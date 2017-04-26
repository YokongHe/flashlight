package com.inmobi.re.controller;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.webkit.JavascriptInterface;
import com.inmobi.commons.data.DeviceInfo;
import com.inmobi.commons.internal.ApiStatCollector;
import com.inmobi.commons.internal.ApiStatCollector$ApiEventType;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.metric.EventLog;
import com.inmobi.re.container.IMWebView;
import com.inmobi.re.container.IMWebView$ViewState;
import com.inmobi.re.controller.JSController;
import com.inmobi.re.controller.JSController$ExpandProperties;
import com.inmobi.re.controller.JSController$OrientationProperties;
import com.inmobi.re.controller.JSController$ResizeProperties;
import org.json.JSONObject;

public class JSDisplayController extends JSController {
   private WindowManager a;
   private float b;
   private JSController$OrientationProperties c = null;
   private JSController$ResizeProperties d = null;

   public JSDisplayController(IMWebView var1, Context var2) {
      super(var1, var2);
      DisplayMetrics var3 = new DisplayMetrics();
      this.a = (WindowManager)var2.getSystemService("window");
      this.a.getDefaultDisplay().getMetrics(var3);
      this.b = ((Activity)this.mContext).getResources().getDisplayMetrics().density;
   }

   private JSController$ExpandProperties a(JSController$ExpandProperties var1) {
      Display var6 = this.a.getDefaultDisplay();
      int var4 = ((Activity)this.mContext).getResources().getDisplayMetrics().widthPixels;
      int var5 = ((Activity)this.mContext).getResources().getDisplayMetrics().heightPixels;
      View var7 = ((Activity)this.mContext).getWindow().findViewById(16908290);
      var1.topStuff = var7.getTop();
      var1.bottomStuff = var5 - var7.getBottom();
      int var2 = DeviceInfo.getDisplayRotation(var6);
      int var3 = var2;
      if(DeviceInfo.isDefOrientationLandscape(var2, var4, var5)) {
         var3 = var2 + 1;
         var2 = var3;
         if(var3 > 3) {
            var2 = 0;
         }

         var3 = var2;
         if(DeviceInfo.isTablet(this.mContext)) {
            this.imWebView.isTablet = true;
            var3 = var2;
         }
      }

      Log.debug("[InMobi]-[RE]-4.5.2", "Device current rotation: " + var3);
      Log.debug("[InMobi]-[RE]-4.5.2", "Density of device: " + this.b);
      var1.width = (int)((float)var1.width * this.b);
      var1.height = (int)((float)var1.height * this.b);
      var1.x = (int)((float)var1.x * this.b);
      var1.y = (int)((float)var1.y * this.b);
      var1.currentX = 0;
      var1.currentY = 0;
      this.imWebView.publisherOrientation = ((Activity)this.imWebView.getContext()).getRequestedOrientation();
      if(var3 != 0 && var3 != 2) {
         var1.rotationAtExpand = "landscape";
      } else {
         var1.rotationAtExpand = "portrait";
      }

      if(var1.height <= 0 || var1.width <= 0) {
         var1.height = var5;
         var1.width = var4;
         var1.zeroWidthHeight = true;
      }

      if(var3 != 0 && var3 != 2) {
         var1.portraitWidthRequested = var1.height;
         var1.portraitHeightRequested = var1.width;
      } else {
         var1.portraitWidthRequested = var1.width;
         var1.portraitHeightRequested = var1.height;
      }

      Log.debug("[InMobi]-[RE]-4.5.2", "Device Width: " + var4 + " Device height: " + var5);
      var2 = var5 - var1.topStuff;
      if(var1.width > var4) {
         var1.width = var4;
      }

      if(var1.height > var2) {
         var1.height = var2;
      }

      int[] var8 = new int[2];
      this.imWebView.getLocationOnScreen(var8);
      if(var1.x < 0) {
         var1.x = var8[0];
      }

      if(var1.y < 0) {
         var1.y = var8[1] - var1.topStuff;
         Log.debug("[InMobi]-[RE]-4.5.2", "topStuff: " + var1.topStuff + " ,bottomStuff: " + var1.bottomStuff);
      }

      Log.debug("[InMobi]-[RE]-4.5.2", "loc 0: " + var8[0] + " loc 1: " + var8[1]);
      var3 = var4 - (var1.x + var1.width);
      if(var3 < 0) {
         var1.x += var3;
         if(var1.x < 0) {
            var1.width += var1.x;
            var1.x = 0;
         }
      }

      var2 -= var1.y + var1.height;
      if(var2 < 0) {
         var1.y += var2;
         if(var1.y < 0) {
            var1.height += var1.y;
            var1.y = 0;
         }
      }

      var1.currentX = var1.x;
      var1.currentY = var1.y;
      Log.debug("[InMobi]-[RE]-4.5.2", "final expanded width after density : " + var1.width + "final expanded height after density " + var1.height + "portrait width requested :" + var1.portraitWidthRequested + "portrait height requested :" + var1.portraitHeightRequested);
      return var1;
   }

   private void a(JSController$ExpandProperties var1, JSController$ExpandProperties var2) {
      var1.width = var2.width;
      var1.height = var2.height;
      var1.x = var2.x;
      var1.y = var2.y;
      var1.actualWidthRequested = var2.actualWidthRequested;
      var1.actualHeightRequested = var2.actualHeightRequested;
      var1.lockOrientation = var2.lockOrientation;
      var1.isModal = var2.isModal;
      var1.useCustomClose = var2.useCustomClose;
      var1.orientation = var2.orientation;
      var1.topStuff = var2.topStuff;
      var1.bottomStuff = var2.bottomStuff;
      var1.portraitWidthRequested = var2.portraitWidthRequested;
      var1.portraitHeightRequested = var2.portraitHeightRequested;
      var1.zeroWidthHeight = var2.zeroWidthHeight;
      var1.rotationAtExpand = var2.rotationAtExpand;
      var1.currentX = var2.currentX;
      var1.currentY = var2.currentY;
   }

   private void a(JSController$ResizeProperties var1, JSController$ResizeProperties var2) {
      var1.width = var2.width;
      var1.height = var2.height;
      var1.allowOffscreen = var2.allowOffscreen;
      var1.customClosePosition = var2.customClosePosition;
      var1.offsetX = var2.offsetX;
      var1.offsetY = var2.offsetY;
   }

   @JavascriptInterface
   public void close() {
      // $FF: Couldn't be decompiled
   }

   @JavascriptInterface
   public void disableCloseRegion(boolean var1) {
      this.imWebView.setDisableCloseRegion(var1);
   }

   @JavascriptInterface
   public void expand(String param1) {
      // $FF: Couldn't be decompiled
   }

   @JavascriptInterface
   public String getExpandProperties() {
      ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector$ApiEventType(4), (JSONObject)null));
      JSONObject var1 = new JSONObject();

      try {
         var1.put("width", this.expProps.width);
         var1.put("height", this.expProps.height);
         var1.put("isModal", this.expProps.isModal);
         var1.put("useCustomClose", this.expProps.useCustomClose);
         var1.put("lockOrientation", this.expProps.lockOrientation);
         var1.put("orientation", this.expProps.orientation);
      } catch (Exception var3) {
         Log.debug("[InMobi]-[RE]-4.5.2", "Failed to get expand props");
      }

      return var1.toString();
   }

   @JavascriptInterface
   public String getOrientation() {
      ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector$ApiEventType(16), (JSONObject)null));

      try {
         String var1 = this.imWebView.getCurrentRotation(this.imWebView.getIntegerCurrentRotation());
         Log.debug("[InMobi]-[RE]-4.5.2", "JSDisplayController-> getOrientation: " + var1);
         return var1;
      } catch (Exception var2) {
         Log.debug("[InMobi]-[RE]-4.5.2", "Error getOrientation: " + "-1", var2);
         return "-1";
      }
   }

   @JavascriptInterface
   public String getOrientationProperties() {
      ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector$ApiEventType(5), (JSONObject)null));
      JSONObject var1 = new JSONObject();

      try {
         var1.put("allowOrientationChange", this.c.allowOrientationChange);
         var1.put("orientation", this.c.forceOrientation);
      } catch (Exception var3) {
         Log.debug("[InMobi]-[RE]-4.5.2", "Failed to get orientation props");
      }

      return var1.toString();
   }

   @JavascriptInterface
   public String getPlacementType() {
      ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector$ApiEventType(15), (JSONObject)null));
      Log.debug("[InMobi]-[RE]-4.5.2", "JSDisplayController-> getPlacementType");
      return this.imWebView.getPlacementType();
   }

   @JavascriptInterface
   public String getResizeProperties() {
      ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector$ApiEventType(6), (JSONObject)null));
      JSONObject var1 = new JSONObject();

      try {
         var1.put("width", this.d.width);
         var1.put("height", this.d.height);
         var1.put("offsetX", this.d.offsetX);
         var1.put("offsetY", this.d.offsetY);
         var1.put("customClosePosition", this.d.customClosePosition);
         var1.put("allowOffscreen", this.d.allowOffscreen);
      } catch (Exception var3) {
         Log.debug("[InMobi]-[RE]-4.5.2", "Failed to get resize properties");
      }

      return var1.toString();
   }

   @JavascriptInterface
   public String getState() {
      ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector$ApiEventType(3), (JSONObject)null));
      Log.debug("[InMobi]-[RE]-4.5.2", "JSDisplayController-> getState");
      return this.imWebView.getState();
   }

   @JavascriptInterface
   public boolean isViewable() {
      ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector$ApiEventType(14), (JSONObject)null));
      Log.debug("[InMobi]-[RE]-4.5.2", "JSDisplayController-> isViewable" + this.imWebView.isViewable());
      return this.imWebView.isViewable();
   }

   @JavascriptInterface
   public void onOrientationChange() {
      this.imWebView.onOrientationEventChange();
   }

   @JavascriptInterface
   public void open(String var1) {
      ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector$ApiEventType(1), (JSONObject)null));
      Log.debug("[InMobi]-[RE]-4.5.2", "JSDisplayController-> open: url: " + var1);
      this.imWebView.openURL(var1);
   }

   public void reset() {
      if(this.expProps != null) {
         this.expProps.reinitializeExpandProperties();
      }

      if(this.d != null) {
         this.d.initializeResizeProperties();
      }

   }

   @JavascriptInterface
   public void resize() {
      ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector$ApiEventType(12), (JSONObject)null));
      Log.debug("[InMobi]-[RE]-4.5.2", "JSDisplayController-> resize");

      try {
         if(this.imWebView.getStateVariable() == IMWebView$ViewState.RESIZING) {
            Log.debug("[InMobi]-[RE]-4.5.2", "JSDisplayController-> Already resize state");
         } else if(this.imWebView.getStateVariable() == IMWebView$ViewState.HIDDEN) {
            Log.debug("[InMobi]-[RE]-4.5.2", "JSDisplayController-> Resize cannot be called in hidden state. Doing nothing.");
         } else if(this.imWebView.getStateVariable() != IMWebView$ViewState.DEFAULT && this.imWebView.getStateVariable() != IMWebView$ViewState.RESIZED) {
            this.imWebView.raiseError("Current state is neither default nor resized", "resize");
         } else if(this.imWebView.mIsInterstitialAd) {
            this.imWebView.raiseError("Resize cannot be called on interstitial ad", "resize");
         } else {
            JSController$ResizeProperties var1 = new JSController$ResizeProperties();
            this.a(var1, this.d);
            var1.width = (int)((float)var1.width * this.imWebView.getDensity());
            var1.height = (int)((float)var1.height * this.imWebView.getDensity());
            var1.offsetX = (int)((float)var1.offsetX * this.imWebView.getDensity());
            var1.offsetY = (int)((float)var1.offsetY * this.imWebView.getDensity());
            Log.debug("[InMobi]-[RE]-4.5.2", "JSDisplayController-> At the time of resize the properties are: Resize width: " + var1.width + " Resize height: " + var1.height + " Resize offsetX: " + var1.offsetX + " Resize offsetY: " + var1.offsetY + " customClosePosition: " + var1.customClosePosition + " allowOffscreen: " + var1.allowOffscreen);
            this.imWebView.resize(var1);
         }
      } catch (Exception var2) {
         Log.debug("[InMobi]-[RE]-4.5.2", "Exception while expanding the ad. ", var2);
      }
   }

   @JavascriptInterface
   public void setExpandProperties(String param1) {
      // $FF: Couldn't be decompiled
   }

   @JavascriptInterface
   public void setOrientationProperties(String var1) {
      ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector$ApiEventType(8), (JSONObject)null));

      try {
         this.c = (JSController$OrientationProperties)getFromJSON(new JSONObject(var1), JSController$OrientationProperties.class);
         Log.debug("[InMobi]-[RE]-4.5.2", "JSDisplayController-> OrientationProperties is set: Expandable orientation: " + this.expProps.orientation + " Expandable lock orientation: " + this.expProps.lockOrientation);
         this.imWebView.setOrientationPropertiesForInterstitial(this.c.allowOrientationChange, this.c.forceOrientation);
      } catch (Exception var2) {
         Log.debug("[InMobi]-[RE]-4.5.2", "Exception while setting the expand properties " + var2);
      }
   }

   @JavascriptInterface
   public void setResizeProperties(String var1) {
      ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector$ApiEventType(9), (JSONObject)null));

      try {
         this.d = (JSController$ResizeProperties)getFromJSON(new JSONObject(var1), JSController$ResizeProperties.class);
         Log.debug("[InMobi]-[RE]-4.5.2", "JSDisplayController-> ResizeProperties is set: Resize Width: " + this.d.width + " Resize height: " + this.d.height + " Resize offsetX: " + this.d.offsetX + " Resize offsetY: " + this.d.offsetY + " customClosePosition: " + this.d.customClosePosition + " allowOffscreen: " + this.d.allowOffscreen);
      } catch (Exception var2) {
         Log.debug("[InMobi]-[RE]-4.5.2", "Exception while setting the expand properties " + var2);
      }
   }

   public void stopAllListeners() {
   }

   @JavascriptInterface
   public void useCustomClose(boolean var1) {
      ApiStatCollector.getLogger().logEvent(new EventLog(new ApiStatCollector$ApiEventType(10), (JSONObject)null));
      Log.debug("[InMobi]-[RE]-4.5.2", "JSDisplayController-> useCustomClose" + var1);
      this.imWebView.setCustomClose(var1);
   }
}
