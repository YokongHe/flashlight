package com.amazon.device.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.media.MediaScannerConnection;
import android.media.MediaScannerConnection.OnScanCompletedListener;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnTouchListener;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.amazon.device.ads.AdActivity;
import com.amazon.device.ads.AdControlAccessor;
import com.amazon.device.ads.AdControlAccessor$Coordinates;
import com.amazon.device.ads.AdControlAccessor$SizeDimensions;
import com.amazon.device.ads.AdEvent;
import com.amazon.device.ads.AdEvent$AdEventType;
import com.amazon.device.ads.AdSDKBridge;
import com.amazon.device.ads.AdState;
import com.amazon.device.ads.AdUtils;
import com.amazon.device.ads.AndroidTargetUtils;
import com.amazon.device.ads.CalendarEventParameters;
import com.amazon.device.ads.CurrentPosition;
import com.amazon.device.ads.DisplayUtils;
import com.amazon.device.ads.ExpandProperties;
import com.amazon.device.ads.ForceOrientation;
import com.amazon.device.ads.ImageUtils;
import com.amazon.device.ads.InAppBrowser$InAppBrowserBuilder;
import com.amazon.device.ads.JavascriptInteractor;
import com.amazon.device.ads.JavascriptInteractor$Executor;
import com.amazon.device.ads.Log;
import com.amazon.device.ads.MRAIDAdSDKBridge$CloseJSIF;
import com.amazon.device.ads.MRAIDAdSDKBridge$CreateCalendarEventJSIF;
import com.amazon.device.ads.MRAIDAdSDKBridge$ExpandJSIF;
import com.amazon.device.ads.MRAIDAdSDKBridge$GetCurrentPositionJSIF;
import com.amazon.device.ads.MRAIDAdSDKBridge$GetDefaultPositionJSIF;
import com.amazon.device.ads.MRAIDAdSDKBridge$GetExpandPropertiesJSIF;
import com.amazon.device.ads.MRAIDAdSDKBridge$GetMaxSizeJSIF;
import com.amazon.device.ads.MRAIDAdSDKBridge$GetPlacementTypeJSIF;
import com.amazon.device.ads.MRAIDAdSDKBridge$GetResizePropertiesJSIF;
import com.amazon.device.ads.MRAIDAdSDKBridge$GetScreenSizeJSIF;
import com.amazon.device.ads.MRAIDAdSDKBridge$OpenJSIF;
import com.amazon.device.ads.MRAIDAdSDKBridge$PlayVideoJSIF;
import com.amazon.device.ads.MRAIDAdSDKBridge$ResizeJSIF;
import com.amazon.device.ads.MRAIDAdSDKBridge$SetExpandPropertiesJSIF;
import com.amazon.device.ads.MRAIDAdSDKBridge$SetOrientationPropertiesJSIF;
import com.amazon.device.ads.MRAIDAdSDKBridge$SetResizePropertiesJSIF;
import com.amazon.device.ads.MRAIDAdSDKBridge$StorePictureJSIF;
import com.amazon.device.ads.MRAIDAdSDKBridge$SupportsJSIF;
import com.amazon.device.ads.MRAIDAdSDKBridge$UseCustomCloseJSIF;
import com.amazon.device.ads.MRAIDAdSDKEventListener;
import com.amazon.device.ads.OrientationProperties;
import com.amazon.device.ads.PermissionChecker;
import com.amazon.device.ads.PreloadCallback;
import com.amazon.device.ads.RelativePosition;
import com.amazon.device.ads.ResizeProperties;
import com.amazon.device.ads.SDKEventListener;
import com.amazon.device.ads.SizeProperty;
import com.amazon.device.ads.StringUtils;
import com.amazon.device.ads.ThreadUtils;
import com.amazon.device.ads.VideoActionHandler;
import com.amazon.device.ads.WebRequest;
import com.amazon.device.ads.WebRequest$WebRequestException;
import com.amazon.device.ads.WebRequest$WebResponse;
import com.amazon.device.ads.WebUtils;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

class MRAIDAdSDKBridge implements AdSDKBridge {
   private static final int CLOSE_BUTTON_SIZE = 50;
   private static final String CONTENT_DESCRIPTION_AD_CONTAINER_VIEW = "adContainerView";
   private static final String CONTENT_DESCRIPTION_DIMMING_VIEW = "dimmingView";
   private static final String CONTENT_DESCRIPTION_EXPANSION_VIEW = "expansionView";
   private static final String CONTENT_DESCRIPTION_RESIZED_VIEW = "resizedView";
   private static final String ERROR_EVENT_FORMAT = "mraidBridge.error(\'%s\', \'%s\');";
   private static final String JAVASCRIPT = "(function (window, console) {\n    var is_array = function (obj) {\n        return Object.prototype.toString.call(obj) === \'[object Array]\';\n    },\n    forEach = function (array, fn) {\n        var i;\n        for (i = 0; i < array.length; i++) {\n            if (i in array) {\n                fn.call(null, array[i], i);\n            }\n        }\n    },\n    events = {\n            error: \'error\',\n            ready: \'ready\',\n            sizeChange: \'sizeChange\',\n            stateChange: \'stateChange\',\n            viewableChange: \'viewableChange\'\n    },\n    states = [\"loading\",\"default\",\"expanded\",\"resized\",\"hidden\"],\n    placementTypes = [\"inline\", \"interstitial\"],\n    listeners = [],\n    version = \'2.0\',\n    currentState = \"loading\",\n    supportedFeatures = null,\n    orientationProperties = {\"allowOrientationChange\":true,\"forceOrientation\":\"none\"},\n    // Error Event fires listeners\n    invokeListeners = function(event, args) {\n        var eventListeners = listeners[event] || [];\n        // fire all the listeners\n        forEach(eventListeners, function(listener){\n            try {\n                listener.apply(null, args);\n            }catch(e){\n                debug(\"Error executing \" + event + \" listener\");\n                debug(e);\n            }\n        });\n    },\n    debug = function(msg) {\n        console.log(\"MRAID log: \" + msg);\n    },\n    readyEvent = function() {\n        debug(\"MRAID ready\");\n        invokeListeners(\"ready\");\n    },\n    errorEvent = function(message, action) {\n        debug(\"error: \" + message + \" action: \" + action);\n        var args = [message, action];\n        invokeListeners(\"error\", args);\n    },\n    stateChangeEvent = function(state) {\n        debug(\"stateChange: \" + state);\n        var args = [state];\n        currentState = state;\n        invokeListeners(\"stateChange\", args);\n    },\n    viewableChangeEvent = function(viewable) {\n        debug(\"viewableChange: \" + viewable);\n        var args = [viewable];\n        invokeListeners(\"viewableChange\", args);\n    }, \n    sizeChangeEvent = function(width, height) {\n        debug(\"sizeChange: \" + width + \"x\" + height);\n        var args = [width, height];\n        invokeListeners(\"sizeChange\", args);\n    };\n    window.mraidBridge = {\n            error : errorEvent,\n            ready : readyEvent,\n            stateChange : stateChangeEvent,\n            sizeChange : sizeChangeEvent,\n            viewableChange : viewableChangeEvent\n    };\n    // Define the mraid object\n    window.mraid = {\n            // Command Flow\n            addEventListener : function(event, listener){\n                var eventListeners = listeners[event] || [],\n                alreadyRegistered = false;\n                \n                //verify the event is one that will actually occur\n                if (!events.hasOwnProperty(event)){\n                    return;\n                }\n                \n                //register first set of listeners for this event\n                if (!is_array(listeners[event])) {\n                    listeners[event] = eventListeners;\n                }\n                \n                forEach(eventListeners, function(l){ \n                    // Listener already registered, so no need to add it.\n                        if (listener === l){\n                            alreadyRegistered = true;\n                        }\n                    }\n                );\n                if (!alreadyRegistered){\n                    listeners[event].push(listener);\n                }\n            },\n            removeEventListener : function(event, listener){\n                if (listeners.hasOwnProperty(event)) {\n                    var eventListeners = listeners[event];\n                    if (eventListeners) {\n                        var idx = eventListeners.indexOf(listener);\n                        if (idx !== -1) {\n                            eventListeners.splice(idx, 1);\n                        }\n                    }\n                }\n            },\n            useCustomClose: function(bool){\n                mraidObject." + JavascriptInteractor.getExecutorMethodName() + "(\"UseCustomClose\", JSON.stringify({useCustomClose: bool}));\n            },\n" + "            // Support\n            supports: function(feature){\n" + "                if (!supportedFeatures)\n                {\n" + "                    supportedFeatures = JSON.parse(mraidObject." + JavascriptInteractor.getExecutorMethodName() + "(\"Supports\", null));\n                }\n" + "                return supportedFeatures[feature];\n            },\n" + "            // Properties\n            getVersion: function(){\n" + "                return version;\n            },\n" + "            getState: function(){\n                return currentState;\n" + "            },\n            getPlacementType: function(){\n" + "                var json = JSON.parse(mraidObject." + JavascriptInteractor.getExecutorMethodName() + "(\"GetPlacementType\", null));\n                return json.placementType;\n" + "            },\n            isViewable: function(){\n" + "                // TODO - should we ask the OS if the widget is visible.\n                return currentState !== \"hidden\" && currentState !== \"loading\";\n" + "            },\n            getExpandProperties: function(){\n" + "                return JSON.parse(mraidObject." + JavascriptInteractor.getExecutorMethodName() + "(\"GetExpandProperties\", null));\n            },\n" + "            setExpandProperties: function(properties){\n                var currentProperties = mraid.getExpandProperties(),\n" + "                //properties aren\'t all required, map to existing value if not set.\n                width = properties.hasOwnProperty(\'width\') ? properties.width : currentProperties.width,\n" + "                height = properties.hasOwnProperty(\'height\') ? properties.height : currentProperties.height,\n                useClose = properties.hasOwnProperty(\'useCustomClose\') ? properties.useCustomClose : currentProperties.useCustomClose;\n" + "                //Backwards compatibility with MRAID 1.0 creatives\n                if (!!properties.lockOrientation){\n" + "                    mraid.setOrientationProperties({\"allowOrientationChange\":false});\n                }\n" + "                mraidObject." + JavascriptInteractor.getExecutorMethodName() + "(\"SetExpandProperties\", JSON.stringify({\n                        width: width, \n" + "                        height: height, \n                        useClose: useClose}));\n" + "            },\n            getOrientationProperties: function(){\n" + "                return orientationProperties;\n            },\n" + "            setOrientationProperties: function(properties){\n                if (properties.hasOwnProperty(\"allowOrientationChange\")) {\n" + "                    orientationProperties.allowOrientationChange = properties.allowOrientationChange;\n                }\n" + "                if (properties.hasOwnProperty(\"forceOrientation\")) {\n                    orientationProperties.forceOrientation = properties.forceOrientation;\n" + "                }\n                mraidObject." + JavascriptInteractor.getExecutorMethodName() + "(\"SetOrientationProperties\", JSON.stringify({\n                        allowOrientationChange: orientationProperties.allowOrientationChange, \n" + "                        forceOrientation: orientationProperties.forceOrientation}));\n            },\n" + "            getResizeProperties: function(){\n                return JSON.parse(mraidObject." + JavascriptInteractor.getExecutorMethodName() + "(\"GetResizeProperties\", null));\n            },\n" + "            setResizeProperties: function(properties){\n                if (!properties.customClosePosition){\n" + "                   properties.customClosePosition = null;\n                }\n" + "                if (!properties.hasOwnProperty(\'allowOffscreen\')){\n                   properties.allowOffscreen = true;\n" + "                }\n                mraidObject." + JavascriptInteractor.getExecutorMethodName() + "(\"SetResizeProperties\", JSON.stringify({\n                        width: properties.width, \n" + "                        height: properties.height, \n                        offsetX: properties.offsetX, \n" + "                        offsetY: properties.offsetY, \n                        customClosePosition: properties.customClosePosition, \n" + "                        allowOffscreen: properties.allowOffscreen}));\n            },\n" + "            getCurrentPosition: function(){\n                return JSON.parse(mraidObject." + JavascriptInteractor.getExecutorMethodName() + "(\"GetCurrentPosition\", null));\n            },\n" + "            getMaxSize: function(){\n                return JSON.parse(mraidObject." + JavascriptInteractor.getExecutorMethodName() + "(\"GetMaxSize\", null));\n            },\n" + "            getDefaultPosition: function(){\n                return JSON.parse(mraidObject." + JavascriptInteractor.getExecutorMethodName() + "(\"GetDefaultPosition\", null));\n            },\n" + "            getScreenSize: function(){\n                return JSON.parse(mraidObject." + JavascriptInteractor.getExecutorMethodName() + "(\"GetScreenSize\", null));\n            },\n" + "            // Operations\n            open: function(url) {\n" + "                mraidObject." + JavascriptInteractor.getExecutorMethodName() + "(\"Open\", JSON.stringify({url: url}));\n            },\n" + "            close: function() {\n                mraidObject." + JavascriptInteractor.getExecutorMethodName() + "(\"Close\", null);\n            },\n" + "            expand: function(url) {\n                if (url !== undefined) {\n" + "                    mraidObject." + JavascriptInteractor.getExecutorMethodName() + "(\"Expand\", JSON.stringify({url: url}));\n                } else {\n" + "                    mraidObject." + JavascriptInteractor.getExecutorMethodName() + "(\"Expand\", JSON.stringify({url: \"\"}));\n                }\n" + "            },\n            resize: function() {\n" + "                mraidObject." + JavascriptInteractor.getExecutorMethodName() + "(\"Resize\", null);\n            },\n" + "            createCalendarEvent: function(eventObject) {\n                mraidObject." + JavascriptInteractor.getExecutorMethodName() + "(\"CreateCalendarEvent\", JSON.stringify({\n                        description: eventObject.description || null, \n" + "                        location: eventObject.customClosePosition || null, \n                        summary: eventObject.summary || null, \n" + "                        start: eventObject.start || null, \n                        end: eventObject.end || null}));\n" + "            },\n            playVideo: function(url){\n" + "                mraidObject." + JavascriptInteractor.getExecutorMethodName() + "(\"PlayVideo\", JSON.stringify({url: url}));\n            },\n" + "            storePicture: function(url){\n                mraidObject." + JavascriptInteractor.getExecutorMethodName() + "(\"StorePicture\", JSON.stringify({url: url}));\n            }\n" + "    };\n})(window, console);\n";
   private static final String LOGTAG = MRAIDAdSDKBridge.class.getSimpleName();
   private static final String MRAID_BRIDGE_NAME = "mraidObject";
   private static final String PLACEMENT_TYPE_INLINE = "inline";
   private static final String PLACEMENT_TYPE_INTERSTITIAL = "interstitial";
   private ViewGroup adContainerView;
   private final AdControlAccessor adControlAccessor;
   private final CurrentPosition defaultPosition = new CurrentPosition();
   private final ExpandProperties expandProperties = new ExpandProperties();
   private boolean expandedWithUrl = true;
   private ViewGroup expansionView;
   private boolean isResized = false;
   private final JavascriptInteractor javascriptInteractor;
   private final OrientationProperties orientationProperties = new OrientationProperties();
   private ResizeProperties resizeProperties;
   private ViewGroup resizedView;
   private FrameLayout rootView;
   private SDKEventListener sdkEventListener;

   MRAIDAdSDKBridge(AdControlAccessor var1, JavascriptInteractor var2) {
      this.adControlAccessor = var1;
      this.javascriptInteractor = var2;
      this.populateJavascriptExecutorsInInteractor();
   }

   private SizeProperty computeExpandedSizeInPixels(ExpandProperties var1, String var2) {
      AdControlAccessor$SizeDimensions var5 = this.adControlAccessor.getMaxSize(false);
      int var3;
      if(var2 != null) {
         var3 = var5.getWidth();
      } else {
         var3 = var1.getWidth();
      }

      int var4;
      if(var2 != null) {
         var4 = var5.getHeight();
      } else {
         var4 = var1.getHeight();
      }

      Log.d(LOGTAG, "Expanding Ad to " + var3 + "x" + var4);
      var3 = AdUtils.deviceIndependentPixelToPixel(var3);
      var4 = AdUtils.deviceIndependentPixelToPixel(var4);
      SizeProperty var6 = new SizeProperty();
      var6.setHeight(var4);
      var6.setWidth(var3);
      return var6;
   }

   private SizeProperty computeResizeSizeInPixels(ResizeProperties var1) {
      int var3 = var1.getWidth();
      int var2 = var1.getHeight();
      var3 = AdUtils.deviceIndependentPixelToPixel(var3);
      var2 = AdUtils.deviceIndependentPixelToPixel(var2);
      SizeProperty var4 = new SizeProperty();
      var4.setHeight(var2);
      var4.setWidth(var3);
      return var4;
   }

   @TargetApi(14)
   private void createCalendarIntent(CalendarEventParameters var1) {
      Intent var2 = (new Intent("android.intent.action.INSERT")).setType("vnd.android.cursor.item/event");
      var2.putExtra("title", var1.getDescription());
      if(!StringUtils.isNullOrEmpty(var1.getLocation())) {
         var2.putExtra("eventLocation", var1.getLocation());
      }

      if(!StringUtils.isNullOrEmpty(var1.getSummary())) {
         var2.putExtra("description", var1.getSummary());
      }

      var2.putExtra("beginTime", var1.getStart().getTime());
      if(var1.getEnd() != null) {
         var2.putExtra("endTime", var1.getEnd().getTime());
      }

      this.getContext().startActivity(var2);
   }

   private void createExpandedView() {
      this.rootView = (FrameLayout)((Activity)this.getContext()).findViewById(16908290);
      this.expansionView = new RelativeLayout(this.getContext());
      this.expansionView.setContentDescription("expansionView");
      View var1 = new View(this.getContext());
      var1.setBackgroundColor(0);
      var1.setContentDescription("dimmingView");
      var1.setOnTouchListener(new OnTouchListener() {
         public boolean onTouch(View var1, MotionEvent var2) {
            return true;
         }
      });
      this.expansionView.addView(var1, new LayoutParams(-1, -1));
      this.adContainerView = new FrameLayout(this.getContext());
      this.adContainerView.setContentDescription("adContainerView");
   }

   private void createResizedView() {
      if(this.resizedView == null) {
         if(this.rootView == null) {
            this.rootView = (FrameLayout)((Activity)this.getContext()).findViewById(16908290);
         }

         this.resizedView = new RelativeLayout(this.getContext());
         this.resizedView.setContentDescription("resizedView");
      }

   }

   private void fetchPicture(String var1) {
      WebRequest var2 = WebRequest.createNewWebRequest();
      var2.enableLog(true);
      var2.setUrlString(var1);

      WebRequest$WebResponse var4;
      try {
         var4 = var2.makeCall();
      } catch (WebRequest$WebRequestException var3) {
         this.fireErrorEvent("Server could not be contacted to download picture.", "storePicture");
         return;
      }

      if(var4 == null) {
         this.fireErrorEvent("Server could not be contacted to download picture.", "storePicture");
      } else {
         final Bitmap var5 = var4.getResponseReader().readAsBitmap();
         if(var5 == null) {
            this.fireErrorEvent("Picture could not be retrieved from server.", "storePicture");
         } else {
            ThreadUtils.scheduleOnMainThread(new Runnable() {
               public void run() {
                  MRAIDAdSDKBridge.this.savePicture(var5);
               }
            });
         }
      }
   }

   private void fireErrorEvent(String var1, String var2) {
      this.adControlAccessor.injectJavascript(String.format(Locale.US, "mraidBridge.error(\'%s\', \'%s\');", new Object[]{var1, var2}));
   }

   private Context getContext() {
      return this.adControlAccessor.getContext();
   }

   private JSONObject getMaxSize(boolean var1) {
      AdControlAccessor$SizeDimensions var2 = this.adControlAccessor.getMaxSize(var1);
      SizeProperty var3 = new SizeProperty();
      var3.setWidth(var2.getWidth());
      var3.setHeight(var2.getHeight());
      return var3.toJSONObject();
   }

   private boolean isValidClosePosition(RelativePosition var1, int var2, int var3, SizeProperty var4, int var5, int var6) {
      int var9 = AdUtils.deviceIndependentPixelToPixel(50);
      int var7;
      int var8;
      switch(null.$SwitchMap$com$amazon$device$ads$RelativePosition[var1.ordinal()]) {
      case 1:
         var8 = var2 + var9;
         var7 = var3 + var9;
         break;
      case 2:
         var7 = var4.getWidth() + var3;
         var8 = var2 + var9;
         var3 = var7 - var9;
         break;
      case 3:
         var3 = var4.getWidth() / 2 + var3 - var9 / 2;
         var8 = var2 + var9;
         var7 = var3 + var9;
         break;
      case 4:
         var8 = var2 + var4.getHeight();
         var2 = var8 - var9;
         var7 = var3 + var9;
         break;
      case 5:
         var8 = var2 + var4.getHeight();
         var7 = var4.getWidth() + var3;
         var2 = var8 - var9;
         var3 = var7 - var9;
         break;
      case 6:
         var8 = var2 + var4.getHeight();
         var3 = var4.getWidth() / 2 + var3 - var9 / 2;
         var2 = var8 - var9;
         var7 = var3 + var9;
         break;
      case 7:
         var2 = var4.getHeight() / 2 + var2 - var9 / 2;
         var3 = var4.getWidth() / 2 + var3 - var9 / 2;
         var8 = var2 + var9;
         var7 = var3 + var9;
         break;
      default:
         var7 = 0;
         var3 = 0;
         var8 = 0;
         var2 = 0;
      }

      return var2 >= 0 && var3 >= 0 && var8 <= var6 && var7 <= var5;
   }

   private boolean isVisible() {
      return this.adControlAccessor.getAdState().equals(AdState.SHOWING) || this.adControlAccessor.getAdState().equals(AdState.EXPANDED);
   }

   private void lookupExpansionView() {
      if(this.expansionView == null) {
         ViewGroup var1 = this.adControlAccessor.getViewParentIfExpanded();
         if(var1 != null && "adContainerView".equals(var1.getContentDescription())) {
            var1 = (ViewGroup)var1.getParent();
            if(var1 != null && "expansionView".equals(var1.getContentDescription())) {
               this.expansionView = var1;
            }
         }
      }

   }

   private void populateJavascriptExecutorsInInteractor() {
      this.javascriptInteractor.addMethodExecutor(new MRAIDAdSDKBridge$CloseJSIF(this));
      this.javascriptInteractor.addMethodExecutor(new MRAIDAdSDKBridge$CreateCalendarEventJSIF(this));
      this.javascriptInteractor.addMethodExecutor(new MRAIDAdSDKBridge$ExpandJSIF(this));
      this.javascriptInteractor.addMethodExecutor(new MRAIDAdSDKBridge$GetCurrentPositionJSIF(this));
      this.javascriptInteractor.addMethodExecutor(new MRAIDAdSDKBridge$GetDefaultPositionJSIF(this));
      this.javascriptInteractor.addMethodExecutor(new MRAIDAdSDKBridge$GetExpandPropertiesJSIF(this));
      this.javascriptInteractor.addMethodExecutor(new MRAIDAdSDKBridge$GetMaxSizeJSIF(this));
      this.javascriptInteractor.addMethodExecutor(new MRAIDAdSDKBridge$GetPlacementTypeJSIF(this));
      this.javascriptInteractor.addMethodExecutor(new MRAIDAdSDKBridge$GetResizePropertiesJSIF(this));
      this.javascriptInteractor.addMethodExecutor(new MRAIDAdSDKBridge$GetScreenSizeJSIF(this));
      this.javascriptInteractor.addMethodExecutor(new MRAIDAdSDKBridge$OpenJSIF(this));
      this.javascriptInteractor.addMethodExecutor(new MRAIDAdSDKBridge$PlayVideoJSIF(this));
      this.javascriptInteractor.addMethodExecutor(new MRAIDAdSDKBridge$ResizeJSIF(this));
      this.javascriptInteractor.addMethodExecutor(new MRAIDAdSDKBridge$SetExpandPropertiesJSIF(this));
      this.javascriptInteractor.addMethodExecutor(new MRAIDAdSDKBridge$SetOrientationPropertiesJSIF(this));
      this.javascriptInteractor.addMethodExecutor(new MRAIDAdSDKBridge$SetResizePropertiesJSIF(this));
      this.javascriptInteractor.addMethodExecutor(new MRAIDAdSDKBridge$StorePictureJSIF(this));
      this.javascriptInteractor.addMethodExecutor(new MRAIDAdSDKBridge$SupportsJSIF(this));
      this.javascriptInteractor.addMethodExecutor(new MRAIDAdSDKBridge$UseCustomCloseJSIF(this));
   }

   private void savePicture(final Bitmap var1) {
      Builder var2 = this.createAlertDialogBuilder(this.getContext());
      var2.setTitle("Would you like to save the image to your gallery?");
      var2.setPositiveButton("Yes", new OnClickListener() {
         public void onClick(DialogInterface var1x, int var2) {
            String var3 = ImageUtils.insertImageInMediaStore(MRAIDAdSDKBridge.this.getContext(), var1, "AdImage", "Image created by rich media ad.");
            if(StringUtils.isNullOrEmpty(var3)) {
               MRAIDAdSDKBridge.this.fireErrorEvent("Picture could not be stored to device.", "storePicture");
            } else {
               MediaScannerConnection.scanFile(MRAIDAdSDKBridge.this.getContext(), new String[]{var3}, (String[])null, (OnScanCompletedListener)null);
            }
         }
      });
      var2.setNegativeButton("No", new OnClickListener() {
         public void onClick(DialogInterface var1, int var2) {
         }
      });
      var2.show();
   }

   private boolean validUrl(String var1) {
      try {
         new URI(var1);
         return true;
      } catch (URISyntaxException var2) {
         return false;
      } catch (NullPointerException var3) {
         return false;
      }
   }

   public void close() {
      if(!this.adControlAccessor.closeAd()) {
         this.fireErrorEvent("Unable to close ad in its current state.", "close");
      }

   }

   void collapseExpandedAd(final AdControlAccessor var1) {
      Log.d(LOGTAG, "Collapsing expanded ad " + this);
      ThreadUtils.executeOnMainThread(new Runnable() {
         public void run() {
            MRAIDAdSDKBridge.this.rootView = (FrameLayout)((Activity)MRAIDAdSDKBridge.this.getContext()).findViewById(16908290);
            MRAIDAdSDKBridge.this.isResized = false;
            if(MRAIDAdSDKBridge.this.expandedWithUrl) {
               Log.d(MRAIDAdSDKBridge.LOGTAG, "Expanded With URL");
               var1.popView();
            } else {
               Log.d(MRAIDAdSDKBridge.LOGTAG, "Not Expanded with URL");
            }

            MRAIDAdSDKBridge.this.lookupExpansionView();
            android.widget.FrameLayout.LayoutParams var1x = new android.widget.FrameLayout.LayoutParams(-1, -1, 17);
            var1.moveViewBackToParent(var1x);
            var1.removeCloseButton();
            if(MRAIDAdSDKBridge.this.expansionView != null) {
               MRAIDAdSDKBridge.this.rootView.removeView(MRAIDAdSDKBridge.this.expansionView);
            }

            if(MRAIDAdSDKBridge.this.resizedView != null) {
               MRAIDAdSDKBridge.this.rootView.removeView(MRAIDAdSDKBridge.this.resizedView);
            }

            MRAIDAdSDKBridge.this.rootView.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
               private boolean triggered = false;

               public void onGlobalLayout() {
                  if(!this.triggered) {
                     this.triggered = true;
                     var1.fireAdEvent(new AdEvent(AdEvent$AdEventType.CLOSED));
                     var1.injectJavascript("mraidBridge.stateChange(\'default\');");
                     MRAIDAdSDKBridge.this.reportSizeChangeEvent();
                  }

               }
            });
         }
      });
   }

   Builder createAlertDialogBuilder(Context var1) {
      return new Builder(var1);
   }

   public void createCalendarEvent(String var1, String var2, String var3, String var4, String var5) {
      if(!AndroidTargetUtils.isAtLeastAndroidAPI(14)) {
         Log.d(LOGTAG, "API version does not support calendar operations.");
         this.fireErrorEvent("API version does not support calendar operations.", "createCalendarEvent");
      } else {
         CalendarEventParameters var7;
         try {
            var7 = new CalendarEventParameters(var1, var2, var3, var4, var5);
         } catch (IllegalArgumentException var6) {
            Log.d(LOGTAG, var6.getMessage());
            this.fireErrorEvent(var6.getMessage(), "createCalendarEvent");
            return;
         }

         this.createCalendarIntent(var7);
      }
   }

   public void expand(String var1) {
      if(this.adControlAccessor.isInterstitial()) {
         this.fireErrorEvent("Unable to expand an interstitial ad placement", "expand");
      } else if(this.adControlAccessor.getAdState().equals(AdState.EXPANDED) && !this.isResized) {
         this.fireErrorEvent("Unable to expand while expanded.", "expand");
      } else if(!this.isVisible()) {
         this.fireErrorEvent("Unable to expand ad while it is not visible.", "expand");
      } else if(this.expandProperties.getWidth() >= 50 && this.expandProperties.getHeight() >= 50) {
         final ExpandProperties var2 = this.expandProperties;
         if(!StringUtils.isNullOrWhiteSpace(var1)) {
            if(this.validUrl(var1)) {
               this.adControlAccessor.preloadUrl(var1, new PreloadCallback() {
                  public void onPreloadComplete(String var1) {
                     MRAIDAdSDKBridge.this.adControlAccessor.injectJavascriptPreload("mraidBridge.stateChange(\'expanded\');");
                     MRAIDAdSDKBridge.this.adControlAccessor.injectJavascriptPreload("mraidBridge.ready();");
                     MRAIDAdSDKBridge.this.expandAd(var2, var1);
                  }
               });
            } else {
               this.fireErrorEvent("Unable to expand with invalid URL.", "expand");
            }
         } else {
            this.expandAd(var2, (String)null);
         }
      } else {
         this.fireErrorEvent("Expand size is too small, must leave room for close.", "expand");
      }
   }

   void expandAd(final ExpandProperties var1, final String var2) {
      ThreadUtils.executeOnMainThread(new Runnable() {
         public void run() {
            boolean var1x = true;
            MRAIDAdSDKBridge.this.isResized = false;
            if(var2 != null) {
               MRAIDAdSDKBridge.this.adControlAccessor.stashView();
               MRAIDAdSDKBridge.this.expandedWithUrl = true;
            } else {
               MRAIDAdSDKBridge.this.expandedWithUrl = false;
            }

            SizeProperty var2x = MRAIDAdSDKBridge.this.computeExpandedSizeInPixels(var1, var2);
            MRAIDAdSDKBridge.this.createExpandedView();
            MRAIDAdSDKBridge.this.adControlAccessor.moveViewToViewGroup(MRAIDAdSDKBridge.this.adContainerView, new LayoutParams(-1, -1), true);
            LayoutParams var3 = new LayoutParams(var2x.getWidth(), var2x.getHeight());
            var3.addRule(13);
            MRAIDAdSDKBridge.this.expansionView.addView(MRAIDAdSDKBridge.this.adContainerView, var3);
            MRAIDAdSDKBridge.this.rootView.addView(MRAIDAdSDKBridge.this.expansionView, new LayoutParams(-1, -1));
            AdControlAccessor var4 = MRAIDAdSDKBridge.this.adControlAccessor;
            if(var1.getUseCustomClose().booleanValue()) {
               var1x = false;
            }

            var4.enableCloseButton(var1x);
            MRAIDAdSDKBridge.this.rootView.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
               private boolean triggered = false;

               public void onGlobalLayout() {
                  if(!this.triggered) {
                     this.triggered = true;
                     Log.d(MRAIDAdSDKBridge.LOGTAG, "Expand ViewTreeObserver fired");
                     MRAIDAdSDKBridge.this.adControlAccessor.fireAdEvent(new AdEvent(AdEvent$AdEventType.EXPANDED));
                     MRAIDAdSDKBridge.this.adControlAccessor.injectJavascript("mraidBridge.stateChange(\'expanded\');");
                     MRAIDAdSDKBridge.this.reportSizeChangeEvent();
                     MRAIDAdSDKBridge.this.orientationPropertyChange();
                  }

               }
            });
         }
      });
   }

   public JSONObject getCurrentPosition() {
      AdControlAccessor$Coordinates var1 = this.adControlAccessor.getCurrentPosition();
      CurrentPosition var2 = new CurrentPosition();
      var2.setX(var1.getX());
      var2.setY(var1.getY());
      var2.setWidth(var1.getWidth());
      var2.setHeight(var1.getHeight());
      return var2.toJSONObject();
   }

   public JSONObject getDefaultPosition() {
      return this.defaultPosition.toJSONObject();
   }

   public JSONObject getExpandProperties() {
      return this.expandProperties.toJSONObject();
   }

   public String getJavascript() {
      return JAVASCRIPT;
   }

   public JavascriptInteractor$Executor getJavascriptInteractorExecutor() {
      return this.javascriptInteractor.getExecutor();
   }

   public JSONObject getMaxSize() {
      return this.getMaxSize(false);
   }

   public String getName() {
      return "mraidObject";
   }

   public String getOrientationProperties() {
      return this.orientationProperties.toString();
   }

   public String getPlacementType() {
      return this.adControlAccessor.isInterstitial()?"interstitial":"inline";
   }

   public JSONObject getResizeProperties() {
      return this.resizeProperties.toJSONObject();
   }

   public SDKEventListener getSDKEventListener() {
      if(this.sdkEventListener == null) {
         this.sdkEventListener = new MRAIDAdSDKEventListener(this);
      }

      return this.sdkEventListener;
   }

   public JSONObject getScreenSize() {
      return this.getMaxSize(true);
   }

   public JSONObject getSupportedFeatures() {
      JSONObject var1 = new JSONObject();

      try {
         var1.put("sms", this.getContext().getPackageManager().hasSystemFeature("android.hardware.telephony"));
         var1.put("tel", this.getContext().getPackageManager().hasSystemFeature("android.hardware.telephony"));
         var1.put("calendar", AndroidTargetUtils.isAtLeastAndroidAPI(14));
         var1.put("storePicture", PermissionChecker.hasWriteExternalStoragePermission(this.getContext()));
         var1.put("inlineVideo", AndroidTargetUtils.isAtLeastAndroidAPI(11));
         return var1;
      } catch (JSONException var3) {
         return var1;
      }
   }

   public boolean hasNativeExecution() {
      return true;
   }

   public void open(String var1) {
      if(!this.isVisible()) {
         this.fireErrorEvent("Unable to open a URL while the ad is not visible", "open");
      } else {
         Log.d(LOGTAG, "Opening URL " + var1);
         if(this.validUrl(var1)) {
            String var2 = WebUtils.getScheme(var1);
            if(!"http".equals(var2) && !"https".equals(var2)) {
               this.adControlAccessor.loadUrl(var1);
            } else {
               (new InAppBrowser$InAppBrowserBuilder()).withContext(this.getContext()).withExternalBrowserButton().withUrl(var1).show();
            }
         } else {
            var1 = "URL " + var1 + " is not a valid URL";
            Log.d(LOGTAG, var1);
            this.fireErrorEvent(var1, "open");
         }
      }
   }

   void orientationPropertyChange() {
      if(this.isVisible() && (this.adControlAccessor.isInterstitial() || AdState.EXPANDED.equals(this.adControlAccessor.getAdState()) && !this.isResized)) {
         Activity var3 = (Activity)this.getContext();
         int var1 = var3.getRequestedOrientation();
         AdControlAccessor$Coordinates var2 = this.adControlAccessor.getCurrentPosition();
         Log.d(LOGTAG, "Current Orientation: " + var1);
         if(this.adControlAccessor.isInterstitial()) {
            switch(null.$SwitchMap$com$amazon$device$ads$ForceOrientation[this.orientationProperties.getForceOrientation().ordinal()]) {
            case 1:
               var3.setRequestedOrientation(1);
               break;
            case 2:
               var3.setRequestedOrientation(0);
            }
         }

         if(!this.adControlAccessor.isInterstitial() || ForceOrientation.NONE.equals(this.orientationProperties.getForceOrientation())) {
            if(this.orientationProperties.isAllowOrientationChange().booleanValue()) {
               if(((Activity)this.adControlAccessor.getContext()).getRequestedOrientation() != -1) {
                  ((Activity)this.adControlAccessor.getContext()).setRequestedOrientation(-1);
               }
            } else if(AdState.EXPANDED.equals(this.adControlAccessor.getAdState())) {
               var3.setRequestedOrientation(DisplayUtils.determineCanonicalScreenOrientation(var3));
            }
         }

         Log.d(LOGTAG, "New Orientation: " + var3.getRequestedOrientation());
         if(var3.getRequestedOrientation() != var1) {
            AdControlAccessor$Coordinates var4 = this.adControlAccessor.getCurrentPosition();
            if(var2.getWidth() != var4.getWidth()) {
               this.reportSizeChangeEvent();
               return;
            }
         }
      }

   }

   public void playVideo(String var1) {
      if(!this.isVisible()) {
         this.fireErrorEvent("Unable to play a video while the ad is not visible", "playVideo");
      } else if(StringUtils.isNullOrEmpty(var1)) {
         this.fireErrorEvent("Unable to play a video without a URL", "playVideo");
      } else {
         try {
            Bundle var2 = new Bundle();
            var2.putString("url", var1);
            Intent var4 = new Intent(this.getContext(), AdActivity.class);
            var4.putExtra("adapter", VideoActionHandler.class.getName());
            var4.putExtras(var2);
            this.getContext().startActivity(var4);
         } catch (ActivityNotFoundException var3) {
            Log.d(LOGTAG, "Failed to open VideoAction activity");
            this.fireErrorEvent("Internal SDK Failure. Unable to launch VideoActionHandler", "playVideo");
         }
      }
   }

   void reportSizeChangeEvent() {
      AdControlAccessor$Coordinates var1 = this.adControlAccessor.getCurrentPosition();
      this.adControlAccessor.injectJavascript("mraidBridge.sizeChange(" + var1.getWidth() + "," + var1.getHeight() + ");");
   }

   public void resize() {
      if(this.adControlAccessor.isInterstitial()) {
         this.fireErrorEvent("Unable to resize an interstitial ad placement.", "resize");
      } else if(this.adControlAccessor.getAdState().equals(AdState.EXPANDED) && !this.isResized) {
         this.fireErrorEvent("Unable to resize while expanded.", "resize");
      } else if(!this.isVisible()) {
         this.fireErrorEvent("Unable to resize ad while it is not visible.", "resize");
      } else if(this.resizeProperties == null) {
         this.fireErrorEvent("Resize properties must be set before calling resize.", "resize");
      } else if(this.resizeProperties.getWidth() >= 50 && this.resizeProperties.getHeight() >= 50) {
         this.resizeAd(this.resizeProperties);
      } else {
         this.fireErrorEvent("Resize width and height must be at least 50 dp in order to fit the close button.", "resize");
      }
   }

   void resizeAd(final ResizeProperties var1) {
      ThreadUtils.executeOnMainThread(new Runnable() {
         // $FF: synthetic field
         final SizeProperty val$resizeSize;

         {
            this.val$resizeSize = var3;
         }

         public void run() {
            MRAIDAdSDKBridge.this.createResizedView();
            int var4 = AdUtils.deviceIndependentPixelToPixel(MRAIDAdSDKBridge.this.defaultPosition.getX() + var1.getOffsetX());
            int var5 = AdUtils.deviceIndependentPixelToPixel(MRAIDAdSDKBridge.this.defaultPosition.getY() + var1.getOffsetY());
            RelativePosition var8 = RelativePosition.fromString(var1.getCustomClosePosition());
            AdControlAccessor$SizeDimensions var9 = MRAIDAdSDKBridge.this.adControlAccessor.getMaxSize(false);
            int var7 = AdUtils.deviceIndependentPixelToPixel(var9.getWidth());
            int var6 = AdUtils.deviceIndependentPixelToPixel(var9.getHeight());
            int var2;
            int var3;
            if(!var1.getAllowOffscreen().booleanValue()) {
               if(this.val$resizeSize.getWidth() > var7) {
                  this.val$resizeSize.setWidth(var7);
               }

               if(this.val$resizeSize.getHeight() > var6) {
                  this.val$resizeSize.setHeight(var6);
               }

               int var1x;
               if(var4 < 0) {
                  var1x = 0;
               } else {
                  var1x = var4;
                  if(this.val$resizeSize.getWidth() + var4 > var7) {
                     var1x = var7 - this.val$resizeSize.getWidth();
                  }
               }

               if(var5 < 0) {
                  var2 = 0;
                  var3 = var1x;
               } else {
                  var2 = var5;
                  var3 = var1x;
                  if(this.val$resizeSize.getHeight() + var5 > var6) {
                     var2 = var6 - this.val$resizeSize.getHeight();
                     var3 = var1x;
                  }
               }
            } else {
               var2 = var5;
               var3 = var4;
               if(!MRAIDAdSDKBridge.this.isValidClosePosition(var8, var5, var4, this.val$resizeSize, var7, var6)) {
                  MRAIDAdSDKBridge.this.fireErrorEvent("Resize failed because close event area must be entirely on screen.", "resize");
                  return;
               }
            }

            MRAIDAdSDKBridge.this.isResized = true;
            LayoutParams var10 = new LayoutParams(this.val$resizeSize.getWidth(), this.val$resizeSize.getHeight());
            MRAIDAdSDKBridge.this.adControlAccessor.moveViewToViewGroup(MRAIDAdSDKBridge.this.resizedView, var10, false);
            android.widget.FrameLayout.LayoutParams var11 = new android.widget.FrameLayout.LayoutParams(this.val$resizeSize.getWidth(), this.val$resizeSize.getHeight());
            var11.gravity = 48;
            var11.leftMargin = var3;
            var11.topMargin = var2;
            if(MRAIDAdSDKBridge.this.rootView.equals(MRAIDAdSDKBridge.this.resizedView.getParent())) {
               MRAIDAdSDKBridge.this.resizedView.setLayoutParams(var11);
            } else {
               MRAIDAdSDKBridge.this.rootView.addView(MRAIDAdSDKBridge.this.resizedView, var11);
            }

            MRAIDAdSDKBridge.this.adControlAccessor.enableCloseButton(false, var8);
            MRAIDAdSDKBridge.this.rootView.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
               private boolean triggered = false;

               public void onGlobalLayout() {
                  if(!this.triggered) {
                     this.triggered = true;
                     int[] var1x = new int[2];
                     MRAIDAdSDKBridge.this.resizedView.getLocationOnScreen(var1x);
                     Rect var3 = new Rect(var1x[0], var1x[1], var1x[0] + MRAIDAdSDKBridge.this.resizedView.getWidth(), var1x[1] + MRAIDAdSDKBridge.this.resizedView.getHeight());
                     AdEvent var2 = new AdEvent(AdEvent$AdEventType.RESIZED);
                     var2.setParameter("positionOnScreen", var3);
                     MRAIDAdSDKBridge.this.adControlAccessor.fireAdEvent(var2);
                     MRAIDAdSDKBridge.this.adControlAccessor.injectJavascript("mraidBridge.stateChange(\'resized\');");
                     MRAIDAdSDKBridge.this.reportSizeChangeEvent();
                  }

               }
            });
         }
      });
   }

   public void setExpandProperties(int var1, int var2, boolean var3) {
      this.expandProperties.setWidth(var1);
      this.expandProperties.setHeight(var2);
      this.setUseCustomClose(var3);
   }

   public void setOrientationProperties(boolean var1, String var2) {
      this.orientationProperties.setAllowOrientationChange(Boolean.valueOf(var1));
      if(!StringUtils.isNullOrEmpty(var2)) {
         try {
            ForceOrientation var3 = ForceOrientation.valueOf(var2.toUpperCase(Locale.US));
            this.orientationProperties.setForceOrientation(var3);
         } catch (IllegalArgumentException var4) {
            Log.w(LOGTAG, "Not a valid orientation to force:" + var2);
         }
      }

      this.orientationPropertyChange();
   }

   public void setResizeProperties(int var1, int var2, int var3, int var4, String var5, boolean var6) {
      if(this.resizeProperties == null) {
         this.resizeProperties = new ResizeProperties();
      }

      this.resizeProperties.setAllowOffscreen(Boolean.valueOf(var6));
      this.resizeProperties.setCustomClosePosition(var5);
      this.resizeProperties.setWidth(var1);
      this.resizeProperties.setHeight(var2);
      this.resizeProperties.setOffsetX(var3);
      this.resizeProperties.setOffsetY(var4);
   }

   public void setUseCustomClose(boolean var1) {
      this.expandProperties.setUseCustomClose(Boolean.valueOf(var1));
      AdControlAccessor var2 = this.adControlAccessor;
      if(!var1) {
         var1 = true;
      } else {
         var1 = false;
      }

      var2.showNativeCloseButtonImage(var1);
   }

   public void storePicture(final String var1) {
      if(!PermissionChecker.hasWriteExternalStoragePermission(this.getContext())) {
         this.fireErrorEvent("Picture could not be stored because permission was denied.", "storePicture");
      } else {
         ThreadUtils.executeRunnableWithThreadCheck(new Runnable() {
            public void run() {
               MRAIDAdSDKBridge.this.fetchPicture(var1);
            }
         });
      }
   }

   void updateDefaultPosition(int var1, int var2, int var3, int var4) {
      this.defaultPosition.setWidth(var1);
      this.defaultPosition.setHeight(var2);
      this.defaultPosition.setX(var3);
      this.defaultPosition.setY(var4);
   }

   void updateExpandProperties(int var1, int var2) {
      this.expandProperties.setWidth(var1);
      this.expandProperties.setHeight(var2);
   }
}
