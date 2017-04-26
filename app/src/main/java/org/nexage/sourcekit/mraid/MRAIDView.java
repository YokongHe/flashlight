package org.nexage.sourcekit.mraid;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import org.nexage.sourcekit.mraid.Assets;
import org.nexage.sourcekit.mraid.MRAIDNativeFeatureListener;
import org.nexage.sourcekit.mraid.MRAIDView$MRAIDWebChromeClient;
import org.nexage.sourcekit.mraid.MRAIDView$MRAIDWebViewClient;
import org.nexage.sourcekit.mraid.MRAIDView$Size;
import org.nexage.sourcekit.mraid.MRAIDViewListener;
import org.nexage.sourcekit.mraid.internal.MRAIDHtmlProcessor;
import org.nexage.sourcekit.mraid.internal.MRAIDLog;
import org.nexage.sourcekit.mraid.internal.MRAIDLog$LOG_LEVEL;
import org.nexage.sourcekit.mraid.internal.MRAIDNativeFeatureManager;
import org.nexage.sourcekit.mraid.properties.MRAIDOrientationProperties;
import org.nexage.sourcekit.mraid.properties.MRAIDResizeProperties;

@SuppressLint({"ViewConstructor"})
public class MRAIDView extends RelativeLayout {
   private static final int CLOSE_REGION_SIZE = 50;
   public static final int STATE_DEFAULT = 1;
   public static final int STATE_EXPANDED = 2;
   public static final int STATE_HIDDEN = 4;
   public static final int STATE_LOADING = 0;
   public static final int STATE_RESIZED = 3;
   private static final String TAG = "MRAIDView";
   public static final String VERSION = "1.1.2";
   private static boolean mIsJavascriptPromptsAndAlertsAllowed = true;
   private String baseUrl;
   private ImageButton closeRegion;
   private int contentViewTop;
   private Context context;
   private Rect currentPosition;
   private WebView currentWebView;
   private Rect defaultPosition;
   private DisplayMetrics displayMetrics;
   private RelativeLayout expandedView;
   private GestureDetector gestureDetector;
   private Handler handler;
   private boolean hasBeenTouched;
   private boolean isActionBarShowing;
   private boolean isClosing;
   private boolean isExpandingFromDefault;
   private boolean isExpandingPart2;
   private boolean isForceNotFullScreen;
   private boolean isForcingFullScreen;
   private boolean isFullScreen;
   private final boolean isInterstitial;
   private boolean isLaidOut;
   private boolean isPageFinished;
   private boolean isViewable;
   private MRAIDViewListener listener;
   private MRAIDView$Size maxSize;
   private String mraidJs;
   private MRAIDView$MRAIDWebChromeClient mraidWebChromeClient;
   private MRAIDView$MRAIDWebViewClient mraidWebViewClient;
   private MRAIDNativeFeatureListener nativeFeatureListener;
   private MRAIDNativeFeatureManager nativeFeatureManager;
   private MRAIDOrientationProperties orientationProperties;
   private int origTitleBarVisibility;
   private final int originalRequestedOrientation;
   private MRAIDResizeProperties resizeProperties;
   private RelativeLayout resizedView;
   private MRAIDView$Size screenSize;
   private int state;
   private View titleBar;
   private boolean useCustomClose;
   private WebView webView;
   private WebView webViewPart2;

   public MRAIDView(Context var1, String var2, String var3, String[] var4, MRAIDViewListener var5, MRAIDNativeFeatureListener var6) {
      this(var1, var2, var3, var4, var5, var6, false);
   }

   public MRAIDView(Context var1, String var2, String var3, String[] var4, MRAIDViewListener var5, MRAIDNativeFeatureListener var6, boolean var7) {
      super(var1);
      this.context = var1;
      this.baseUrl = var2;
      this.isInterstitial = var7;
      this.state = 0;
      this.isViewable = false;
      this.useCustomClose = false;
      this.orientationProperties = new MRAIDOrientationProperties();
      this.resizeProperties = new MRAIDResizeProperties();
      this.nativeFeatureManager = new MRAIDNativeFeatureManager(var1, new ArrayList(Arrays.asList(var4)));
      this.listener = var5;
      this.nativeFeatureListener = var6;
      this.displayMetrics = new DisplayMetrics();
      ((Activity)var1).getWindowManager().getDefaultDisplay().getMetrics(this.displayMetrics);
      this.currentPosition = new Rect();
      this.defaultPosition = new Rect();
      this.maxSize = new MRAIDView$Size(this, (MRAIDView$Size)null);
      this.screenSize = new MRAIDView$Size(this, (MRAIDView$Size)null);
      this.hasBeenTouched = false;
      if(var1 instanceof Activity) {
         this.originalRequestedOrientation = ((Activity)var1).getRequestedOrientation();
      } else {
         this.originalRequestedOrientation = -1;
      }

      MRAIDLog.d("MRAIDView", "originalRequestedOrientation " + getOrientationString(this.originalRequestedOrientation));
      this.gestureDetector = new GestureDetector(this.getContext(), new SimpleOnGestureListener() {
         public boolean onScroll(MotionEvent var1, MotionEvent var2, float var3, float var4) {
            return true;
         }
      });
      this.handler = new Handler(Looper.getMainLooper());
      this.mraidWebChromeClient = new MRAIDView$MRAIDWebChromeClient(this, (MRAIDView$MRAIDWebChromeClient)null);
      this.mraidWebViewClient = new MRAIDView$MRAIDWebViewClient(this, (MRAIDView$MRAIDWebViewClient)null);
      this.webView = this.createWebView();
      this.currentWebView = this.webView;
      this.addView(this.webView);
      this.injectMraidJs(this.webView);
      String var8 = MRAIDHtmlProcessor.processRawHtml(var3);
      this.webView.loadDataWithBaseURL(var2, var8, "text/html", "UTF-8", (String)null);
      MRAIDLog.d("log level = " + MRAIDLog.getLoggingLevel());
      if(MRAIDLog.getLoggingLevel() == MRAIDLog$LOG_LEVEL.verbose) {
         this.injectJavaScript(this.webView, "mraid.logLevel = mraid.LogLevelEnum.DEBUG;");
      } else {
         if(MRAIDLog.getLoggingLevel() == MRAIDLog$LOG_LEVEL.debug) {
            this.injectJavaScript(this.webView, "mraid.logLevel = mraid.LogLevelEnum.DEBUG;");
            return;
         }

         if(MRAIDLog.getLoggingLevel() == MRAIDLog$LOG_LEVEL.info) {
            this.injectJavaScript(this.webView, "mraid.logLevel = mraid.LogLevelEnum.INFO;");
            return;
         }

         if(MRAIDLog.getLoggingLevel() == MRAIDLog$LOG_LEVEL.warning) {
            this.injectJavaScript(this.webView, "mraid.logLevel = mraid.LogLevelEnum.WARNING;");
            return;
         }

         if(MRAIDLog.getLoggingLevel() == MRAIDLog$LOG_LEVEL.error) {
            this.injectJavaScript(this.webView, "mraid.logLevel = mraid.LogLevelEnum.ERROR;");
            return;
         }

         if(MRAIDLog.getLoggingLevel() == MRAIDLog$LOG_LEVEL.none) {
            this.injectJavaScript(this.webView, "mraid.logLevel = mraid.LogLevelEnum.NONE;");
            return;
         }
      }

   }

   // $FF: synthetic method
   static void access$1(MRAIDView var0, boolean var1) {
      var0.isPageFinished = var1;
   }

   // $FF: synthetic method
   static void access$10(MRAIDView var0, int var1) {
      var0.state = var1;
   }

   // $FF: synthetic method
   static void access$12(MRAIDView var0) {
      var0.fireReadyEvent();
   }

   // $FF: synthetic method
   static boolean access$13(MRAIDView var0) {
      return var0.isViewable;
   }

   // $FF: synthetic method
   static void access$14(MRAIDView var0) {
      var0.fireViewableChangeEvent();
   }

   // $FF: synthetic method
   static boolean access$16(MRAIDView var0) {
      return var0.isExpandingPart2;
   }

   // $FF: synthetic method
   static Handler access$18(MRAIDView var0) {
      return var0.handler;
   }

   // $FF: synthetic method
   static boolean access$19(MRAIDView var0) {
      return var0.hasBeenTouched;
   }

   // $FF: synthetic method
   static void access$20(MRAIDView var0, String var1) {
      var0.parseCommandUrl(var1);
   }

   // $FF: synthetic method
   static void access$21(MRAIDView var0, String var1) {
      var0.open(var1);
   }

   // $FF: synthetic method
   static void access$3(MRAIDView var0, String var1) {
      var0.injectJavaScript(var1);
   }

   // $FF: synthetic method
   static void access$4(MRAIDView var0) {
      var0.setSupportedServices();
   }

   // $FF: synthetic method
   static boolean access$5(MRAIDView var0) {
      return var0.isLaidOut;
   }

   // $FF: synthetic method
   static void access$6(MRAIDView var0) {
      var0.setScreenSize();
   }

   // $FF: synthetic method
   static void access$7(MRAIDView var0) {
      var0.setMaxSize();
   }

   // $FF: synthetic method
   static void access$8(MRAIDView var0) {
      var0.setCurrentPosition();
   }

   // $FF: synthetic method
   static void access$9(MRAIDView var0) {
      var0.setDefaultPosition();
   }

   private void addCloseRegion(View var1) {
      this.closeRegion = new ImageButton(this.context);
      this.closeRegion.setBackgroundColor(0);
      this.closeRegion.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            MRAIDView.this.close();
         }
      });
      if(var1 == this.expandedView && !this.useCustomClose) {
         this.showDefaultCloseButton();
      }

      ((ViewGroup)var1).addView(this.closeRegion);
   }

   private void applyOrientationProperties() {
      byte var1 = 1;
      MRAIDLog.d("MRAIDView", "applyOrientationProperties " + this.orientationProperties.allowOrientationChange + " " + this.orientationProperties.forceOrientationString());
      Activity var5 = (Activity)this.context;
      boolean var2;
      if(this.getResources().getConfiguration().orientation == 1) {
         var2 = true;
      } else {
         var2 = false;
      }

      StringBuilder var6 = new StringBuilder("currentOrientation ");
      String var4;
      if(var2) {
         var4 = "portrait";
      } else {
         var4 = "landscape";
      }

      MRAIDLog.d("MRAIDView", var6.append(var4).toString());
      int var3 = this.originalRequestedOrientation;
      if(this.orientationProperties.forceOrientation != 0) {
         label25: {
            if(this.orientationProperties.forceOrientation != 1) {
               if(this.orientationProperties.allowOrientationChange) {
                  var1 = -1;
                  break label25;
               }

               if(var2) {
                  break label25;
               }
            }

            var1 = 0;
         }
      }

      var5.setRequestedOrientation(var1);
   }

   public static boolean areJavascriptPromptsAndAlertsAllowed() {
      return mIsJavascriptPromptsAndAlertsAllowed;
   }

   private void calculateMaxSize() {
      Rect var3 = new Rect();
      Window var4 = ((Activity)this.context).getWindow();
      var4.getDecorView().getWindowVisibleDisplayFrame(var3);
      MRAIDLog.d("MRAIDView", "calculateMaxSize frame [" + var3.left + "," + var3.top + "][" + var3.right + "," + var3.bottom + "] (" + var3.width() + "x" + var3.height() + ")");
      int var1 = var3.top;
      this.contentViewTop = var4.findViewById(16908290).getTop();
      int var2 = this.contentViewTop;
      MRAIDLog.d("MRAIDView", "calculateMaxSize statusHeight " + var1);
      MRAIDLog.d("MRAIDView", "calculateMaxSize titleHeight " + (var2 - var1));
      MRAIDLog.d("MRAIDView", "calculateMaxSize contentViewTop " + this.contentViewTop);
      var1 = var3.width();
      var2 = this.screenSize.height - this.contentViewTop;
      MRAIDLog.d("MRAIDView", "calculateMaxSize max size " + var1 + "x" + var2);
      if(var1 != this.maxSize.width || var2 != this.maxSize.height) {
         this.maxSize.width = var1;
         this.maxSize.height = var2;
         if(this.isPageFinished) {
            this.setMaxSize();
         }
      }

   }

   private void calculatePosition(boolean var1) {
      int[] var8 = new int[2];
      Object var6;
      if(var1) {
         var6 = this.currentWebView;
      } else {
         var6 = this;
      }

      String var7;
      if(var1) {
         var7 = "current";
      } else {
         var7 = "default";
      }

      ((View)var6).getLocationOnScreen(var8);
      int var2 = var8[0];
      int var3 = var8[1];
      MRAIDLog.d("MRAIDView", "calculatePosition " + var7 + " locationOnScreen [" + var2 + "," + var3 + "]");
      MRAIDLog.d("MRAIDView", "calculatePosition " + var7 + " contentViewTop " + this.contentViewTop);
      var3 -= this.contentViewTop;
      int var4 = ((View)var6).getWidth();
      int var5 = ((View)var6).getHeight();
      MRAIDLog.d("MRAIDView", "calculatePosition " + var7 + " position [" + var2 + "," + var3 + "] (" + var4 + "x" + var5 + ")");
      Rect var9;
      if(var1) {
         var9 = this.currentPosition;
      } else {
         var9 = this.defaultPosition;
      }

      if(var2 != var9.left || var3 != var9.top || var4 != var9.width() || var5 != var9.height()) {
         if(var1) {
            this.currentPosition = new Rect(var2, var3, var4 + var2, var5 + var3);
         } else {
            this.defaultPosition = new Rect(var2, var3, var4 + var2, var5 + var3);
         }

         if(this.isPageFinished) {
            if(!var1) {
               this.setDefaultPosition();
               return;
            }

            this.setCurrentPosition();
         }
      }

   }

   private void calculateScreenSize() {
      boolean var1 = true;
      if(this.getResources().getConfiguration().orientation != 1) {
         var1 = false;
      }

      StringBuilder var4 = new StringBuilder("calculateScreenSize orientation ");
      String var3;
      if(var1) {
         var3 = "portrait";
      } else {
         var3 = "landscape";
      }

      MRAIDLog.d("MRAIDView", var4.append(var3).toString());
      int var5 = this.displayMetrics.widthPixels;
      int var2 = this.displayMetrics.heightPixels;
      MRAIDLog.d("MRAIDView", "calculateScreenSize screen size " + var5 + "x" + var2);
      if(var5 != this.screenSize.width || var2 != this.screenSize.height) {
         this.screenSize.width = var5;
         this.screenSize.height = var2;
         if(this.isPageFinished) {
            this.setScreenSize();
         }
      }

   }

   private void close() {
      MRAIDLog.d("MRAIDView-JS callback", "close");
      this.handler.post(new Runnable() {
         public void run() {
            if(MRAIDView.this.state != 0 && (MRAIDView.this.state != 1 || MRAIDView.this.isInterstitial) && MRAIDView.this.state != 4) {
               if(MRAIDView.this.state == 1 || MRAIDView.this.state == 2) {
                  MRAIDView.this.closeFromExpanded();
                  return;
               }

               if(MRAIDView.this.state == 3) {
                  MRAIDView.this.closeFromResized();
                  return;
               }
            }

         }
      });
   }

   private void closeFromExpanded() {
      if(this.state == 1 && this.isInterstitial) {
         this.state = 4;
         this.clearView();
         this.handler.post(new Runnable() {
            public void run() {
               MRAIDView.this.fireStateChangeEvent();
               if(MRAIDView.this.listener != null) {
                  MRAIDView.this.listener.mraidViewClose(MRAIDView.this);
               }

            }
         });
      } else if(this.state == 2 || this.state == 3) {
         this.state = 1;
      }

      this.isClosing = true;
      this.expandedView.removeAllViews();
      ((FrameLayout)((Activity)this.context).findViewById(16908290)).removeView(this.expandedView);
      this.expandedView = null;
      this.closeRegion = null;
      this.handler.post(new Runnable() {
         public void run() {
            MRAIDView.this.restoreOriginalOrientation();
            MRAIDView.this.restoreOriginalScreenState();
         }
      });
      if(this.webViewPart2 == null) {
         this.addView(this.webView);
      } else {
         this.webViewPart2.setWebChromeClient((WebChromeClient)null);
         this.webViewPart2.setWebViewClient((WebViewClient)null);
         this.webViewPart2.destroy();
         this.webViewPart2 = null;
         this.webView.setWebChromeClient(this.mraidWebChromeClient);
         this.webView.setWebViewClient(this.mraidWebViewClient);
         this.currentWebView = this.webView;
      }

      this.handler.post(new Runnable() {
         public void run() {
            MRAIDView.this.fireStateChangeEvent();
            if(MRAIDView.this.listener != null) {
               MRAIDView.this.listener.mraidViewClose(MRAIDView.this);
            }

         }
      });
   }

   private void closeFromResized() {
      this.state = 1;
      this.isClosing = true;
      this.removeResizeView();
      this.addView(this.webView);
      this.handler.post(new Runnable() {
         public void run() {
            MRAIDView.this.fireStateChangeEvent();
            if(MRAIDView.this.listener != null) {
               MRAIDView.this.listener.mraidViewClose(MRAIDView.this);
            }

         }
      });
   }

   private void createCalendarEvent(String var1) {
      MRAIDLog.d("MRAIDView-JS callback", "createCalendarEvent " + var1);
      if(this.nativeFeatureListener != null) {
         this.nativeFeatureListener.mraidNativeFeatureCreateCalendarEvent(var1);
      }

   }

   @SuppressLint({"SetJavaScriptEnabled"})
   private WebView createWebView() {
      WebView var1 = new WebView(this.context) {
         private static final String TAG = "MRAIDView-WebView";

         public void onConfigurationChanged(Configuration var1) {
            super.onConfigurationChanged(var1);
            StringBuilder var2 = new StringBuilder("onConfigurationChanged ");
            String var3;
            if(var1.orientation == 1) {
               var3 = "portrait";
            } else {
               var3 = "landscape";
            }

            MRAIDLog.d("MRAIDView-WebView", var2.append(var3).toString());
            if(MRAIDView.this.isInterstitial) {
               ((Activity)MRAIDView.this.context).getWindowManager().getDefaultDisplay().getMetrics(MRAIDView.this.displayMetrics);
            }

         }

         protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
            super.onLayout(var1, var2, var3, var4, var5);
            MRAIDView.this.onLayoutWebView(this, var1, var2, var3, var4, var5);
         }

         protected void onVisibilityChanged(View var1, int var2) {
            super.onVisibilityChanged(var1, var2);
            MRAIDLog.d("MRAIDView-WebView", "onVisibilityChanged " + MRAIDView.getVisibilityString(var2));
            if(MRAIDView.this.isInterstitial) {
               MRAIDView.this.setViewable(var2);
            }

         }

         protected void onWindowVisibilityChanged(int var1) {
            super.onWindowVisibilityChanged(var1);
            int var2 = this.getVisibility();
            MRAIDLog.d("MRAIDView-WebView", "onWindowVisibilityChanged " + MRAIDView.getVisibilityString(var1) + " (actual " + MRAIDView.getVisibilityString(var2) + ")");
            if(MRAIDView.this.isInterstitial) {
               MRAIDView.this.setViewable(var2);
            }

            if(var1 != 0) {
               MRAIDView.this.pauseWebView(this);
            }

         }
      };
      var1.setLayoutParams(new LayoutParams(-1, -1));
      var1.setScrollContainer(false);
      var1.setVerticalScrollBarEnabled(false);
      var1.setHorizontalScrollBarEnabled(false);
      var1.setScrollBarStyle(33554432);
      var1.setFocusableInTouchMode(false);
      var1.setOnTouchListener(new OnTouchListener() {
         @SuppressLint({"ClickableViewAccessibility"})
         public boolean onTouch(View var1, MotionEvent var2) {
            MRAIDView.this.hasBeenTouched = true;
            switch(var2.getAction()) {
            case 0:
            case 1:
               if(!var1.hasFocus()) {
                  var1.requestFocus();
               }
            default:
               return false;
            }
         }
      });
      var1.getSettings().setJavaScriptEnabled(true);
      var1.setWebChromeClient(this.mraidWebChromeClient);
      var1.setWebViewClient(this.mraidWebViewClient);
      return var1;
   }

   @TargetApi(11)
   private void expand(String var1) {
      StringBuilder var3 = new StringBuilder("expand ");
      final String var2;
      if(var1 != null) {
         var2 = var1;
      } else {
         var2 = "(1-part)";
      }

      MRAIDLog.d("MRAIDView-JS callback", var3.append(var2).toString());
      if((!this.isInterstitial || this.state == 0) && (this.isInterstitial || this.state == 1 || this.state == 3)) {
         if(!TextUtils.isEmpty(var1)) {
            try {
               var1 = URLDecoder.decode(var1, "UTF-8");
            } catch (UnsupportedEncodingException var4) {
               return;
            }

            var2 = var1;
            if(!var1.startsWith("http://")) {
               var2 = var1;
               if(!var1.startsWith("https://")) {
                  var2 = this.baseUrl + var1;
               }
            }

            (new Thread(new Runnable() {
               public void run() {
                  final String var1 = MRAIDView.this.getStringFromUrl(var2);
                  if(!TextUtils.isEmpty(var1)) {
                     ((Activity)MRAIDView.this.context).runOnUiThread(new Runnable() {
                        public void run() {
                           if(MRAIDView.this.webView != null) {
                              if(MRAIDView.this.state == 3) {
                                 MRAIDView.this.removeResizeView();
                                 MRAIDView.this.addView(MRAIDView.this.webView);
                              }

                              MRAIDView.this.webView.setWebChromeClient((WebChromeClient)null);
                              MRAIDView.this.webView.setWebViewClient((WebViewClient)null);
                              MRAIDView.this.webViewPart2 = MRAIDView.this.createWebView();
                              MRAIDView.this.injectMraidJs(MRAIDView.this.webViewPart2);
                              MRAIDView.this.webViewPart2.loadDataWithBaseURL(MRAIDView.this.baseUrl, var1, "text/html", "UTF-8", (String)null);
                              MRAIDView.this.currentWebView = MRAIDView.this.webViewPart2;
                              MRAIDView.this.isExpandingPart2 = true;
                              MRAIDView.this.expandHelper(MRAIDView.this.currentWebView);
                           }
                        }
                     });
                  } else {
                     MRAIDLog.e("Could not load part 2 expanded content for URL: " + var2);
                  }
               }
            }, "2-part-content")).start();
         } else {
            if(!this.isInterstitial && this.state != 1) {
               if(this.state == 3) {
                  this.removeResizeView();
               }
            } else if(this.webView.getParent() != null) {
               ((ViewGroup)this.webView.getParent()).removeView(this.webView);
            } else {
               this.removeView(this.webView);
            }

            this.expandHelper(this.webView);
         }
      }
   }

   private void expandHelper(WebView var1) {
      if(!this.isInterstitial) {
         this.state = 2;
      }

      this.applyOrientationProperties();
      this.forceFullScreen();
      this.expandedView = new RelativeLayout(this.context);
      this.expandedView.addView(var1);
      this.addCloseRegion(this.expandedView);
      this.setCloseRegionPosition(this.expandedView);
      ((Activity)this.context).addContentView(this.expandedView, new LayoutParams(-1, -1));
      this.isExpandingFromDefault = true;
      if(this.isInterstitial) {
         this.isLaidOut = true;
         this.state = 1;
         this.fireStateChangeEvent();
      }

   }

   private void fireReadyEvent() {
      MRAIDLog.d("MRAIDView", "fireReadyEvent");
      this.injectJavaScript("mraid.fireReadyEvent();");
   }

   @SuppressLint({"DefaultLocale"})
   private void fireStateChangeEvent() {
      MRAIDLog.d("MRAIDView", "fireStateChangeEvent");
      StringBuilder var2 = new StringBuilder("mraid.fireStateChangeEvent(\'");
      int var1 = this.state;
      this.injectJavaScript(var2.append((new String[]{"loading", "default", "expanded", "resized", "hidden"})[var1]).append("\');").toString());
   }

   private void fireViewableChangeEvent() {
      MRAIDLog.d("MRAIDView", "fireViewableChangeEvent");
      this.injectJavaScript("mraid.fireViewableChangeEvent(" + this.isViewable + ");");
   }

   @TargetApi(11)
   private void forceFullScreen() {
      boolean var3 = false;
      MRAIDLog.d("MRAIDView", "forceFullScreen");
      Activity var4 = (Activity)this.context;
      int var1 = var4.getWindow().getAttributes().flags;
      boolean var2;
      if((var1 & 1024) != 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      this.isFullScreen = var2;
      if((var1 & 2048) != 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      boolean var7;
      label40: {
         this.isForceNotFullScreen = var2;
         this.origTitleBarVisibility = -9;
         if(VERSION.SDK_INT >= 11) {
            ActionBar var5 = var4.getActionBar();
            if(var5 != null) {
               this.isActionBarShowing = var5.isShowing();
               var5.hide();
               var7 = true;
               break label40;
            }
         }

         var7 = false;
      }

      if(!var7) {
         this.titleBar = null;

         try {
            this.titleBar = (View)var4.findViewById(16908310).getParent();
         } catch (NullPointerException var6) {
            ;
         }

         if(this.titleBar != null) {
            this.origTitleBarVisibility = this.titleBar.getVisibility();
            this.titleBar.setVisibility(8);
         }
      }

      MRAIDLog.d("MRAIDView", "isFullScreen " + this.isFullScreen);
      MRAIDLog.d("MRAIDView", "isForceNotFullScreen " + this.isForceNotFullScreen);
      MRAIDLog.d("MRAIDView", "isActionBarShowing " + this.isActionBarShowing);
      MRAIDLog.d("MRAIDView", "origTitleBarVisibility " + getVisibilityString(this.origTitleBarVisibility));
      ((Activity)this.context).getWindow().addFlags(1024);
      ((Activity)this.context).getWindow().clearFlags(2048);
      if(this.isFullScreen) {
         var2 = var3;
      } else {
         var2 = true;
      }

      this.isForcingFullScreen = var2;
   }

   private static String getOrientationString(int var0) {
      switch(var0) {
      case -1:
         return "UNSPECIFIED";
      case 0:
         return "LANDSCAPE";
      case 1:
         return "PORTRAIT";
      default:
         return "UNKNOWN";
      }
   }

   private String getStringFromFileUrl(String param1) {
      // $FF: Couldn't be decompiled
   }

   private String getStringFromUrl(String param1) {
      // $FF: Couldn't be decompiled
   }

   private static String getVisibilityString(int var0) {
      switch(var0) {
      case 0:
         return "VISIBLE";
      case 4:
         return "INVISIBLE";
      case 8:
         return "GONE";
      default:
         return "UNKNOWN";
      }
   }

   @SuppressLint({"NewApi"})
   private void injectJavaScript(WebView var1, String var2) {
      if(!TextUtils.isEmpty(var2)) {
         if(VERSION.SDK_INT < 19) {
            MRAIDLog.d("MRAIDView", "loading url: " + var2);
            var1.loadUrl("javascript:" + var2);
            return;
         }

         MRAIDLog.d("MRAIDView", "evaluating js: " + var2);
         var1.evaluateJavascript(var2, new ValueCallback() {
            public void onReceiveValue(String var1) {
            }
         });
      }

   }

   @SuppressLint({"NewApi"})
   private void injectJavaScript(String var1) {
      this.injectJavaScript(this.currentWebView, var1);
   }

   @SuppressLint({"NewApi"})
   private void injectMraidJs(WebView var1) {
      if(TextUtils.isEmpty(this.mraidJs)) {
         this.mraidJs = new String(Base64.decode("Ly8NCi8vICBtcmFpZC5qcw0KLy8NCg0KKGZ1bmN0aW9uKCkgew0KCQ0KCWNvbnNvbGUubG9nKCJN UkFJRCBvYmplY3QgbG9hZGluZy4uLiIpOw0KDQoJLyoqKioqKioqKioqKioqKioqKioqKioqKioq KioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKg0KCSAqIE1S QUlEIGRlY2xhcmF0aW9uDQoJICoqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioq KioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqLw0KDQoJdmFyIG1yYWlkID0gd2lu ZG93Lm1yYWlkID0ge307DQoNCgkvKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioq KioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqDQoJICogY29uc29sZSBsb2dn aW5nIGhlbHBlcg0KCSAqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioq KioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKi8NCg0KCW1yYWlkLkxvZ0xldmVsRW51bSA9 IHsNCgkJIkRFQlVHIiAgIDogMCwNCgkJIklORk8iICAgIDogMSwNCgkJIldBUk5JTkciIDogMiwN CgkJIkVSUk9SIiAgIDogMywNCgkJIk5PTkUiICAgIDogNA0KCX07DQoNCgltcmFpZC5sb2dMZXZl bCA9IG1yYWlkLkxvZ0xldmVsRW51bS5OT05FOw0KCXZhciBsb2cgPSB7fTsNCg0KCWxvZy5kID0g ZnVuY3Rpb24obXNnKSB7DQoJCWlmIChtcmFpZC5sb2dMZXZlbCA8PSBtcmFpZC5Mb2dMZXZlbEVu dW0uREVCVUcpIHsNCgkJCWNvbnNvbGUubG9nKCIoRC1tcmFpZC5qcykgIiArIG1zZyk7DQoJCX0N Cgl9Ow0KDQoJbG9nLmkgPSBmdW5jdGlvbihtc2cpIHsNCgkJaWYgKG1yYWlkLmxvZ0xldmVsIDw9 IG1yYWlkLkxvZ0xldmVsRW51bS5JTkZPKSB7DQoJCQljb25zb2xlLmxvZygiKEktbXJhaWQuanMp ICIgKyBtc2cpOw0KCQl9DQoJfTsNCg0KCWxvZy53ID0gZnVuY3Rpb24obXNnKSB7DQoJCWlmICht cmFpZC5sb2dMZXZlbCA8PSBtcmFpZC5Mb2dMZXZlbEVudW0uV0FSTklORykgew0KCQkJY29uc29s ZS5sb2coIihXLW1yYWlkLmpzKSAiICsgbXNnKTsNCgkJfQ0KCX07DQoNCglsb2cuZSA9IGZ1bmN0 aW9uKG1zZykgew0KCQlpZiAobXJhaWQubG9nTGV2ZWwgPD0gbXJhaWQuTG9nTGV2ZWxFbnVtLkVS Uk9SKSB7DQoJCQljb25zb2xlLmxvZygiKEUtbXJhaWQuanMpICIgKyBtc2cpOw0KCQl9DQoJfTsN Cg0KCS8qKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioq KioqKioqKioqKioqKioqKioqKioqKioNCgkgKiBjb25zdGFudHMNCgkgKioqKioqKioqKioqKioq KioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioq KiovDQoNCgl2YXIgVkVSU0lPTiA9ICIyLjAiOw0KDQoJdmFyIFNUQVRFUyA9IG1yYWlkLlNUQVRF UyA9IHsNCgkJIkxPQURJTkciIDogImxvYWRpbmciLA0KCQkiREVGQVVMVCIgOiAiZGVmYXVsdCIs DQoJCSJFWFBBTkRFRCIgOiAiZXhwYW5kZWQiLA0KCQkiUkVTSVpFRCIgOiAicmVzaXplZCIsDQoJ CSJISURERU4iIDogImhpZGRlbiINCgl9Ow0KDQoJdmFyIFBMQUNFTUVOVF9UWVBFUyA9IG1yYWlk LlBMQUNFTUVOVF9UWVBFUyA9IHsNCgkJIklOTElORSIgOiAiaW5saW5lIiwNCgkJIklOVEVSU1RJ VElBTCIgOiAiaW50ZXJzdGl0aWFsIg0KCX07DQoNCgl2YXIgUkVTSVpFX1BST1BFUlRJRVNfQ1VT VE9NX0NMT1NFX1BPU0lUSU9OID0gbXJhaWQuUkVTSVpFX1BST1BFUlRJRVNfQ1VTVE9NX0NMT1NF X1BPU0lUSU9OID0gew0KCQkiVE9QX0xFRlQiIDogInRvcC1sZWZ0IiwNCgkJIlRPUF9DRU5URVIi IDogInRvcC1jZW50ZXIiLA0KCQkiVE9QX1JJR0hUIiA6ICJ0b3AtcmlnaHQiLA0KCQkiQ0VOVEVS IiA6ICJjZW50ZXIiLA0KCQkiQk9UVE9NX0xFRlQiIDogImJvdHRvbS1sZWZ0IiwNCgkJIkJPVFRP TV9DRU5URVIiIDogImJvdHRvbS1jZW50ZXIiLA0KCQkiQk9UVE9NX1JJR0hUIiA6ICJib3R0b20t cmlnaHQiDQoJfTsNCg0KCXZhciBPUklFTlRBVElPTl9QUk9QRVJUSUVTX0ZPUkNFX09SSUVOVEFU SU9OID0gbXJhaWQuT1JJRU5UQVRJT05fUFJPUEVSVElFU19GT1JDRV9PUklFTlRBVElPTiA9IHsN CgkJIlBPUlRSQUlUIiA6ICJwb3J0cmFpdCIsDQoJCSJMQU5EU0NBUEUiIDogImxhbmRzY2FwZSIs DQoJCSJOT05FIiA6ICJub25lIg0KCX07DQoNCgl2YXIgRVZFTlRTID0gbXJhaWQuRVZFTlRTID0g ew0KCQkiRVJST1IiIDogImVycm9yIiwNCgkJIlJFQURZIiA6ICJyZWFkeSIsDQoJCSJTSVpFQ0hB TkdFIiA6ICJzaXplQ2hhbmdlIiwNCgkJIlNUQVRFQ0hBTkdFIiA6ICJzdGF0ZUNoYW5nZSIsDQoJ CSJWSUVXQUJMRUNIQU5HRSIgOiAidmlld2FibGVDaGFuZ2UiDQoJfTsNCg0KCXZhciBTVVBQT1JU RURfRkVBVFVSRVMgPSBtcmFpZC5TVVBQT1JURURfRkVBVFVSRVMgPSB7DQoJCSJTTVMiIDogInNt cyIsDQoJCSJURUwiIDogInRlbCIsDQoJCSJDQUxFTkRBUiIgOiAiY2FsZW5kYXIiLA0KCQkiU1RP UkVQSUNUVVJFIiA6ICJzdG9yZVBpY3R1cmUiLA0KCQkiSU5MSU5FVklERU8iIDogImlubGluZVZp ZGVvIg0KCX07DQoNCgkvKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioq KioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqDQoJICogc3RhdGUNCgkgKioqKioqKioq KioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioq KioqKioqKiovDQoNCgl2YXIgc3RhdGUgPSBTVEFURVMuTE9BRElORzsNCgl2YXIgcGxhY2VtZW50 VHlwZSA9IFBMQUNFTUVOVF9UWVBFUy5JTkxJTkU7DQoJdmFyIHN1cHBvcnRlZEZlYXR1cmVzID0g e307DQoJdmFyIGlzVmlld2FibGUgPSBmYWxzZTsNCgl2YXIgaXNFeHBhbmRQcm9wZXJ0aWVzU2V0 ID0gZmFsc2U7DQoJdmFyIGlzUmVzaXplUmVhZHkgPSBmYWxzZTsNCg0KCXZhciBleHBhbmRQcm9w ZXJ0aWVzID0gew0KCQkid2lkdGgiIDogMCwNCgkJImhlaWdodCIgOiAwLA0KCQkidXNlQ3VzdG9t Q2xvc2UiIDogZmFsc2UsDQoJCSJpc01vZGFsIiA6IHRydWUNCgl9Ow0KDQoJdmFyIG9yaWVudGF0 aW9uUHJvcGVydGllcyA9IHsNCgkJImFsbG93T3JpZW50YXRpb25DaGFuZ2UiIDogdHJ1ZSwNCgkJ ImZvcmNlT3JpZW50YXRpb24iIDogT1JJRU5UQVRJT05fUFJPUEVSVElFU19GT1JDRV9PUklFTlRB VElPTi5OT05FDQoJfTsNCg0KCXZhciByZXNpemVQcm9wZXJ0aWVzID0gew0KCQkid2lkdGgiIDog MCwNCgkJImhlaWdodCIgOiAwLA0KCQkiY3VzdG9tQ2xvc2VQb3NpdGlvbiIgOiBSRVNJWkVfUFJP UEVSVElFU19DVVNUT01fQ0xPU0VfUE9TSVRJT04uVE9QX1JJR0hULA0KCQkib2Zmc2V0WCIgOiAw LA0KCQkib2Zmc2V0WSIgOiAwLA0KCQkiYWxsb3dPZmZzY3JlZW4iIDogdHJ1ZQ0KCX07DQoNCgl2 YXIgY3VycmVudFBvc2l0aW9uID0gew0KCQkieCIgOiAwLA0KCQkieSIgOiAwLA0KCQkid2lkdGgi IDogMCwNCgkJImhlaWdodCIgOiAwDQoJfTsNCg0KCXZhciBkZWZhdWx0UG9zaXRpb24gPSB7DQoJ CSJ4IiA6IDAsDQoJCSJ5IiA6IDAsDQoJCSJ3aWR0aCIgOiAwLA0KCQkiaGVpZ2h0IiA6IDANCgl9 Ow0KDQoJdmFyIG1heFNpemUgPSB7DQoJCSJ3aWR0aCIgOiAwLA0KCQkiaGVpZ2h0IiA6IDANCgl9 Ow0KDQoJdmFyIHNjcmVlblNpemUgPSB7DQoJCSJ3aWR0aCIgOiAwLA0KCQkiaGVpZ2h0IiA6IDAN Cgl9Ow0KDQoJdmFyIGN1cnJlbnRPcmllbnRhdGlvbiA9IDA7DQoNCgl2YXIgbGlzdGVuZXJzID0g e307DQoNCgkvKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioq KioqKioqKioqKioqKioqKioqKioqKioqKioqDQoJICogIm9mZmljaWFsIiBBUEk6IG1ldGhvZHMg Y2FsbGVkIGJ5IGNyZWF0aXZlDQoJICoqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioq KioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqLw0KDQoJbXJhaWQuYWRkRXZl bnRMaXN0ZW5lciA9IGZ1bmN0aW9uKGV2ZW50LCBsaXN0ZW5lcikgew0KCQlsb2cuaSgibXJhaWQu YWRkRXZlbnRMaXN0ZW5lciAiICsgZXZlbnQgKyAiOiAiICsgU3RyaW5nKGxpc3RlbmVyKSk7DQoJ CWlmICghZXZlbnQgfHwgIWxpc3RlbmVyKSB7DQoJCQltcmFpZC5maXJlRXJyb3JFdmVudCgiQm90 aCBldmVudCBhbmQgbGlzdGVuZXIgYXJlIHJlcXVpcmVkLiIsICJhZGRFdmVudExpc3RlbmVyIik7 DQoJCQlyZXR1cm47DQoJCX0NCgkJaWYgKCFjb250YWlucyhldmVudCwgRVZFTlRTKSkgew0KCQkJ bXJhaWQuZmlyZUVycm9yRXZlbnQoIlVua25vd24gTVJBSUQgZXZlbnQ6ICIgKyBldmVudCwgImFk ZEV2ZW50TGlzdGVuZXIiKTsNCgkJCXJldHVybjsNCgkJfQ0KCQl2YXIgbGlzdGVuZXJzRm9yRXZl bnQgPSBsaXN0ZW5lcnNbZXZlbnRdID0gbGlzdGVuZXJzW2V2ZW50XSB8fCBbXTsNCgkJLy8gY2hl Y2sgdG8gbWFrZSBzdXJlIHRoYXQgdGhlIGxpc3RlbmVyIGlzbid0IGFscmVhZHkgcmVnaXN0ZXJl ZA0KCQlmb3IgKHZhciBpID0gMDsgaSA8IGxpc3RlbmVyc0ZvckV2ZW50Lmxlbmd0aDsgaSsrKSB7 DQoJCQl2YXIgc3RyMSA9IFN0cmluZyhsaXN0ZW5lcik7DQoJCQl2YXIgc3RyMiA9IFN0cmluZyhs aXN0ZW5lcnNGb3JFdmVudFtpXSk7DQoJCQlpZiAobGlzdGVuZXIgPT09IGxpc3RlbmVyc0ZvckV2 ZW50W2ldIHx8IHN0cjEgPT09IHN0cjIpIHsNCgkJCQlsb2cuaSgibGlzdGVuZXIgIiArIHN0cjEg KyAiIGlzIGFscmVhZHkgcmVnaXN0ZXJlZCBmb3IgZXZlbnQgIiArIGV2ZW50KTsNCgkJCQlyZXR1 cm47DQoJCQl9DQoJCX0NCgkJbGlzdGVuZXJzRm9yRXZlbnQucHVzaChsaXN0ZW5lcik7DQoJfTsN Cg0KCW1yYWlkLmNyZWF0ZUNhbGVuZGFyRXZlbnQgPSBmdW5jdGlvbihwYXJhbWV0ZXJzKSB7DQoJ CWxvZy5pKCJtcmFpZC5jcmVhdGVDYWxlbmRhckV2ZW50IHdpdGggIiArIHBhcmFtZXRlcnMpOw0K CQlpZiAoc3VwcG9ydGVkRmVhdHVyZXNbbXJhaWQuU1VQUE9SVEVEX0ZFQVRVUkVTLkNBTEVOREFS XSkgew0KCQkJY2FsbE5hdGl2ZSgiY3JlYXRlQ2FsZW5kYXJFdmVudD9ldmVudEpTT049IgkrIEpT T04uc3RyaW5naWZ5KHBhcmFtZXRlcnMpKTsNCgkJfSBlbHNlIHsNCgkJCWxvZy5lKCJjcmVhdGVD YWxlbmRhckV2ZW50IGlzIG5vdCBzdXBwb3J0ZWQiKTsNCgkJfQ0KCX07DQoNCgltcmFpZC5jbG9z ZSA9IGZ1bmN0aW9uKCkgew0KCQlsb2cuaSgibXJhaWQuY2xvc2UiKTsNCgkJaWYgKHN0YXRlID09 PSBTVEFURVMuTE9BRElORw0KCQkJCXx8IChzdGF0ZSA9PT0gU1RBVEVTLkRFRkFVTFQgJiYgcGxh Y2VtZW50VHlwZSA9PT0gUExBQ0VNRU5UX1RZUEVTLklOTElORSkNCgkJCQl8fCBzdGF0ZSA9PT0g U1RBVEVTLkhJRERFTikgew0KCQkJLy8gZG8gbm90aGluZw0KCQkJcmV0dXJuOw0KCQl9DQoJCWNh bGxOYXRpdmUoImNsb3NlIik7DQoJfTsNCg0KCW1yYWlkLmV4cGFuZCA9IGZ1bmN0aW9uKHVybCkg ew0KCQlpZiAodXJsID09PSB1bmRlZmluZWQpIHsNCgkJCWxvZy5pKCJtcmFpZC5leHBhbmQgKDEt cGFydCkiKTsNCgkJfSBlbHNlIHsNCgkJCWxvZy5pKCJtcmFpZC5leHBhbmQgIiArIHVybCk7DQoJ CX0NCgkJLy8gVGhlIG9ubHkgdGltZSBpdCBpcyB2YWxpZCB0byBjYWxsIGV4cGFuZCBpcyB3aGVu IHRoZSBhZCBpcw0KCQkvLyBhIGJhbm5lciBjdXJyZW50bHkgaW4gZWl0aGVyIGRlZmF1bHQgb3Ig cmVzaXplZCBzdGF0ZS4NCgkJaWYgKHBsYWNlbWVudFR5cGUgIT09IFBMQUNFTUVOVF9UWVBFUy5J TkxJTkUNCgkJCQl8fCAoc3RhdGUgIT09IFNUQVRFUy5ERUZBVUxUICYmIHN0YXRlICE9PSBTVEFU RVMuUkVTSVpFRCkpIHsNCgkJCXJldHVybjsNCgkJfQ0KCQlpZiAodXJsID09PSB1bmRlZmluZWQp IHsNCgkJCWNhbGxOYXRpdmUoImV4cGFuZCIpOw0KCQl9IGVsc2Ugew0KCQkJY2FsbE5hdGl2ZSgi ZXhwYW5kP3VybD0iICsgZW5jb2RlVVJJQ29tcG9uZW50KHVybCkpOw0KCQl9DQoJfTsNCg0KCW1y YWlkLmdldEN1cnJlbnRQb3NpdGlvbiA9IGZ1bmN0aW9uKCkgew0KCQlsb2cuaSgibXJhaWQuZ2V0 Q3VycmVudFBvc2l0aW9uIik7DQoJCXJldHVybiBjdXJyZW50UG9zaXRpb247DQoJfTsNCg0KCW1y YWlkLmdldERlZmF1bHRQb3NpdGlvbiA9IGZ1bmN0aW9uKCkgew0KCQlsb2cuaSgibXJhaWQuZ2V0 RGVmYXVsdFBvc2l0aW9uIik7DQoJCXJldHVybiBkZWZhdWx0UG9zaXRpb247DQoJfTsNCg0KCW1y YWlkLmdldEV4cGFuZFByb3BlcnRpZXMgPSBmdW5jdGlvbigpIHsNCgkJbG9nLmkoIm1yYWlkLmdl dEV4cGFuZFByb3BlcnRpZXMiKTsNCgkJcmV0dXJuIGV4cGFuZFByb3BlcnRpZXM7DQoJfTsNCg0K CW1yYWlkLmdldE1heFNpemUgPSBmdW5jdGlvbigpIHsNCgkJbG9nLmkoIm1yYWlkLmdldE1heFNp emUiKTsNCgkJcmV0dXJuIG1heFNpemU7DQoJfTsNCg0KCW1yYWlkLmdldE9yaWVudGF0aW9uUHJv cGVydGllcyA9IGZ1bmN0aW9uKCkgew0KCQlsb2cuaSgibXJhaWQuZ2V0T3JpZW50YXRpb25Qcm9w ZXJ0aWVzIik7DQoJCXJldHVybiBvcmllbnRhdGlvblByb3BlcnRpZXM7DQoJfTsNCg0KCW1yYWlk LmdldFBsYWNlbWVudFR5cGUgPSBmdW5jdGlvbigpIHsNCgkJbG9nLmkoIm1yYWlkLmdldFBsYWNl bWVudFR5cGUiKTsNCgkJcmV0dXJuIHBsYWNlbWVudFR5cGU7DQoJfTsNCg0KCW1yYWlkLmdldFJl c2l6ZVByb3BlcnRpZXMgPSBmdW5jdGlvbigpIHsNCgkJbG9nLmkoIm1yYWlkLmdldFJlc2l6ZVBy b3BlcnRpZXMiKTsNCgkJcmV0dXJuIHJlc2l6ZVByb3BlcnRpZXM7DQoJfTsNCg0KCW1yYWlkLmdl dFNjcmVlblNpemUgPSBmdW5jdGlvbigpIHsNCgkJbG9nLmkoIm1yYWlkLmdldFNjcmVlblNpemUi KTsNCgkJcmV0dXJuIHNjcmVlblNpemU7DQoJfTsNCg0KCW1yYWlkLmdldFN0YXRlID0gZnVuY3Rp b24oKSB7DQoJCWxvZy5pKCJtcmFpZC5nZXRTdGF0ZSIpOw0KCQlyZXR1cm4gc3RhdGU7DQoJfTsN Cg0KCW1yYWlkLmdldFZlcnNpb24gPSBmdW5jdGlvbigpIHsNCgkJbG9nLmkoIm1yYWlkLmdldFZl cnNpb24iKTsNCgkJcmV0dXJuIFZFUlNJT047DQoJfTsNCg0KCW1yYWlkLmlzVmlld2FibGUgPSBm dW5jdGlvbigpIHsNCgkJbG9nLmkoIm1yYWlkLmlzVmlld2FibGUiKTsNCgkJcmV0dXJuIGlzVmll d2FibGU7DQoJfTsNCg0KCW1yYWlkLm9wZW4gPSBmdW5jdGlvbih1cmwpIHsNCgkJbG9nLmkoIm1y YWlkLm9wZW4gIiArIHVybCk7DQoJCWNhbGxOYXRpdmUoIm9wZW4/dXJsPSIgKyBlbmNvZGVVUklD b21wb25lbnQodXJsKSk7DQoJfTsNCg0KCW1yYWlkLnBsYXlWaWRlbyA9IGZ1bmN0aW9uKHVybCkg ew0KCQlsb2cuaSgibXJhaWQucGxheVZpZGVvICIgKyB1cmwpOw0KCQljYWxsTmF0aXZlKCJwbGF5 VmlkZW8/dXJsPSIgKyBlbmNvZGVVUklDb21wb25lbnQodXJsKSk7DQoJfTsNCg0KCW1yYWlkLnJl bW92ZUV2ZW50TGlzdGVuZXIgPSBmdW5jdGlvbihldmVudCwgbGlzdGVuZXIpIHsNCgkJbG9nLmko Im1yYWlkLnJlbW92ZUV2ZW50TGlzdGVuZXIgIiArIGV2ZW50ICsgIiA6ICIgKyBTdHJpbmcobGlz dGVuZXIpKTsNCgkJaWYgKCFldmVudCkgew0KCQkJbXJhaWQuZmlyZUVycm9yRXZlbnQoIkV2ZW50 IGlzIHJlcXVpcmVkLiIsICJyZW1vdmVFdmVudExpc3RlbmVyIik7DQoJCQlyZXR1cm47DQoJCX0N CgkJaWYgKCFjb250YWlucyhldmVudCwgRVZFTlRTKSkgew0KCQkJbXJhaWQuZmlyZUVycm9yRXZl bnQoIlVua25vd24gTVJBSUQgZXZlbnQ6ICIgKyBldmVudCwgInJlbW92ZUV2ZW50TGlzdGVuZXIi KTsNCgkJCXJldHVybjsNCgkJfQ0KCQlpZiAobGlzdGVuZXJzLmhhc093blByb3BlcnR5KGV2ZW50 KSkgew0KCQkJaWYgKGxpc3RlbmVyKSB7DQoJCQkJdmFyIGxpc3RlbmVyc0ZvckV2ZW50ID0gbGlz dGVuZXJzW2V2ZW50XTsNCgkJCQkvLyB0cnkgdG8gZmluZCB0aGUgZ2l2ZW4gbGlzdGVuZXINCgkJ CQl2YXIgbGVuID0gbGlzdGVuZXJzRm9yRXZlbnQubGVuZ3RoOw0KCQkJCWZvciAodmFyIGkgPSAw OyBpIDwgbGVuOyBpKyspIHsNCgkJCQkJdmFyIHJlZ2lzdGVyZWRMaXN0ZW5lciA9IGxpc3RlbmVy c0ZvckV2ZW50W2ldOw0KCQkJCQl2YXIgc3RyMSA9IFN0cmluZyhsaXN0ZW5lcik7DQoJCQkJCXZh ciBzdHIyID0gU3RyaW5nKHJlZ2lzdGVyZWRMaXN0ZW5lcik7DQoJCQkJCWlmIChsaXN0ZW5lciA9 PT0gcmVnaXN0ZXJlZExpc3RlbmVyIHx8IHN0cjEgPT09IHN0cjIpIHsNCgkJCQkJCWxpc3RlbmVy c0ZvckV2ZW50LnNwbGljZShpLCAxKTsNCgkJCQkJCWJyZWFrOw0KCQkJCQl9DQoJCQkJfQ0KCQkJ CWlmIChpID09PSBsZW4pIHsNCgkJCQkJbG9nLmkoImxpc3RlbmVyICIgKyBzdHIxICsgIiBub3Qg Zm91bmQgZm9yIGV2ZW50ICIgKyBldmVudCk7DQoJCQkJfQ0KCQkJCWlmIChsaXN0ZW5lcnNGb3JF dmVudC5sZW5ndGggPT09IDApIHsNCgkJCQkJZGVsZXRlIGxpc3RlbmVyc1tldmVudF07DQoJCQkJ fQ0KCQkJfSBlbHNlIHsNCgkJCQkvLyBubyBsaXN0ZW5lciB0byByZW1vdmUgd2FzIHByb3ZpZGVk LCBzbyByZW1vdmUgYWxsIGxpc3RlbmVycw0KCQkJCS8vIGZvciBnaXZlbiBldmVudA0KCQkJCWRl bGV0ZSBsaXN0ZW5lcnNbZXZlbnRdOw0KCQkJfQ0KCQl9IGVsc2Ugew0KCQkJbG9nLmkoIm5vIGxp c3RlbmVycyByZWdpc3RlcmVkIGZvciBldmVudCAiICsgZXZlbnQpOw0KCQl9DQoJfTsNCg0KCW1y YWlkLnJlc2l6ZSA9IGZ1bmN0aW9uKCkgew0KCQlsb2cuaSgibXJhaWQucmVzaXplIik7DQoJCS8v IFRoZSBvbmx5IHRpbWUgaXQgaXMgdmFsaWQgdG8gY2FsbCByZXNpemUgaXMgd2hlbiB0aGUgYWQg aXMNCgkJLy8gYSBiYW5uZXIgY3VycmVudGx5IGluIGVpdGhlciBkZWZhdWx0IG9yIHJlc2l6ZWQg c3RhdGUuDQoJCS8vIFRyaWdnZXIgYW4gZXJyb3IgaWYgdGhlIGN1cnJlbnQgc3RhdGUgaXMgZXhw YW5kZWQuDQoJCWlmIChwbGFjZW1lbnRUeXBlID09PSBQTEFDRU1FTlRfVFlQRVMuSU5URVJTVElU SUFMIHx8IHN0YXRlID09PSBTVEFURVMuTE9BRElORyB8fCBzdGF0ZSA9PT0gU1RBVEVTLkhJRERF Tikgew0KCQkJLy8gZG8gbm90aGluZw0KCQkJcmV0dXJuOw0KCQl9DQoJCWlmIChzdGF0ZSA9PT0g U1RBVEVTLkVYUEFOREVEKSB7DQoJCQltcmFpZC5maXJlRXJyb3JFdmVudCgibXJhaWQucmVzaXpl IGNhbGxlZCB3aGVuIGFkIGlzIGluIGV4cGFuZGVkIHN0YXRlIiwgIm1yYWlkLnJlc2l6ZSIpOw0K CQkJcmV0dXJuOw0KCQl9DQoJCWlmICghaXNSZXNpemVSZWFkeSkgew0KCQkJbXJhaWQuZmlyZUVy cm9yRXZlbnQoIm1yYWlkLnJlc2l6ZSBpcyBub3QgcmVhZHkgdG8gYmUgY2FsbGVkIiwgIm1yYWlk LnJlc2l6ZSIpOw0KCQkJcmV0dXJuOw0KCQl9DQoJCWNhbGxOYXRpdmUoInJlc2l6ZSIpOw0KCX07 DQoNCgltcmFpZC5zZXRFeHBhbmRQcm9wZXJ0aWVzID0gZnVuY3Rpb24ocHJvcGVydGllcykgew0K CQlsb2cuaSgibXJhaWQuc2V0RXhwYW5kUHJvcGVydGllcyIpOw0KDQoJCWlmICghdmFsaWRhdGUo cHJvcGVydGllcywgInNldEV4cGFuZFByb3BlcnRpZXMiKSkgew0KCQkJbG9nLmUoImZhaWxlZCB2 YWxpZGF0aW9uIik7DQoJCQlyZXR1cm47DQoJCX0NCg0KCQl2YXIgb2xkVXNlQ3VzdG9tQ2xvc2Ug PSBleHBhbmRQcm9wZXJ0aWVzLnVzZUN1c3RvbUNsb3NlOw0KDQoJCS8vIGV4cGFuZFByb3BlcnRp ZXMgY29udGFpbnMgMyByZWFkLXdyaXRlIHByb3BlcnRpZXM6IHdpZHRoLCBoZWlnaHQsIGFuZCB1 c2VDdXN0b21DbG9zZTsNCgkJLy8gdGhlIGlzTW9kYWwgcHJvcGVydHkgaXMgcmVhZC1vbmx5DQoJ CXZhciByd1Byb3BzID0gWyAid2lkdGgiLCAiaGVpZ2h0IiwgInVzZUN1c3RvbUNsb3NlIiBdOw0K CQlmb3IgKHZhciBpID0gMDsgaSA8IHJ3UHJvcHMubGVuZ3RoOyBpKyspIHsNCgkJCXZhciBwcm9w bmFtZSA9IHJ3UHJvcHNbaV07DQoJCQlpZiAocHJvcGVydGllcy5oYXNPd25Qcm9wZXJ0eShwcm9w bmFtZSkpIHsNCgkJCQlleHBhbmRQcm9wZXJ0aWVzW3Byb3BuYW1lXSA9IHByb3BlcnRpZXNbcHJv cG5hbWVdOw0KCQkJfQ0KCQl9DQoNCgkJLy8gSW4gTVJBSUQgdjIuMCwgYWxsIGV4cGFuZGVkIGFk cyBieSBkZWZpbml0aW9uIGNvdmVyIHRoZSBlbnRpcmUgc2NyZWVuLA0KCQkvLyBzbyB0aGUgb25s eSBwcm9wZXJ0eSB0aGF0IHRoZSBuYXRpdmUgc2lkZSBoYXMgdG8ga25vdyBhYm91dCBpcyB1c2VD dXN0b21DbG9zZS4NCgkJLy8gKFRoYXQgaXMsIHRoZSB3aWR0aCBhbmQgaGVpZ2h0IHByb3BlcnRp ZXMgYXJlIG5vdCBuZWVkZWQgYnkgdGhlIG5hdGl2ZSBjb2RlLikNCgkJaWYgKGV4cGFuZFByb3Bl cnRpZXMudXNlQ3VzdG9tQ2xvc2UgIT09IG9sZFVzZUN1c3RvbUNsb3NlKSB7DQoJCQljYWxsTmF0 aXZlKCJ1c2VDdXN0b21DbG9zZT91c2VDdXN0b21DbG9zZT0iCSsgZXhwYW5kUHJvcGVydGllcy51 c2VDdXN0b21DbG9zZSk7DQoJCX0NCgkJDQoJCWlzRXhwYW5kUHJvcGVydGllc1NldCA9IHRydWU7 DQoJfTsNCg0KCW1yYWlkLnNldE9yaWVudGF0aW9uUHJvcGVydGllcyA9IGZ1bmN0aW9uKHByb3Bl cnRpZXMpIHsNCgkJbG9nLmkoIm1yYWlkLnNldE9yaWVudGF0aW9uUHJvcGVydGllcyIpOw0KDQoJ CWlmICghdmFsaWRhdGUocHJvcGVydGllcywgInNldE9yaWVudGF0aW9uUHJvcGVydGllcyIpKSB7 DQoJCQlsb2cuZSgiZmFpbGVkIHZhbGlkYXRpb24iKTsNCgkJCXJldHVybjsNCgkJfQ0KDQoJCXZh ciBuZXdPcmllbnRhdGlvblByb3BlcnRpZXMgPSB7fTsNCgkJbmV3T3JpZW50YXRpb25Qcm9wZXJ0 aWVzLmFsbG93T3JpZW50YXRpb25DaGFuZ2UgPSBvcmllbnRhdGlvblByb3BlcnRpZXMuYWxsb3dP cmllbnRhdGlvbkNoYW5nZSwNCgkJbmV3T3JpZW50YXRpb25Qcm9wZXJ0aWVzLmZvcmNlT3JpZW50 YXRpb24gPSBvcmllbnRhdGlvblByb3BlcnRpZXMuZm9yY2VPcmllbnRhdGlvbjsNCg0KCQkvLyBv cmllbnRhdGlvblByb3BlcnRpZXMgY29udGFpbnMgMiByZWFkLXdyaXRlIHByb3BlcnRpZXM6DQoJ CS8vIGFsbG93T3JpZW50YXRpb25DaGFuZ2UgYW5kIGZvcmNlT3JpZW50YXRpb24NCgkJdmFyIHJ3 UHJvcHMgPSBbICJhbGxvd09yaWVudGF0aW9uQ2hhbmdlIiwgImZvcmNlT3JpZW50YXRpb24iIF07 DQoJCWZvciAodmFyIGkgPSAwOyBpIDwgcndQcm9wcy5sZW5ndGg7IGkrKykgew0KCQkJdmFyIHBy b3BuYW1lID0gcndQcm9wc1tpXTsNCgkJCWlmIChwcm9wZXJ0aWVzLmhhc093blByb3BlcnR5KHBy b3BuYW1lKSkgew0KCQkJCW5ld09yaWVudGF0aW9uUHJvcGVydGllc1twcm9wbmFtZV0gPSBwcm9w ZXJ0aWVzW3Byb3BuYW1lXTsNCgkJCX0NCgkJfQ0KDQoJCS8vIFNldHRpbmcgYWxsb3dPcmllbnRh dGlvbkNoYW5nZSB0byB0cnVlIHdoaWxlIHNldHRpbmcgZm9yY2VPcmllbnRhdGlvbg0KCQkvLyB0 byBlaXRoZXIgcG9ydHJhaXQgb3IgbGFuZHNjYXBlDQoJCS8vIGlzIGNvbnNpZGVyZWQgYW4gZXJy b3IgY29uZGl0aW9uLg0KCQlpZiAobmV3T3JpZW50YXRpb25Qcm9wZXJ0aWVzLmFsbG93T3JpZW50 YXRpb25DaGFuZ2UNCgkJCQkmJiBuZXdPcmllbnRhdGlvblByb3BlcnRpZXMuZm9yY2VPcmllbnRh dGlvbiAhPT0gbXJhaWQuT1JJRU5UQVRJT05fUFJPUEVSVElFU19GT1JDRV9PUklFTlRBVElPTi5O T05FKSB7DQoJCQltcmFpZC5maXJlRXJyb3JFdmVudCgNCgkJCQkJImFsbG93T3JpZW50YXRpb25D aGFuZ2UgaXMgdHJ1ZSBidXQgZm9yY2VPcmllbnRhdGlvbiBpcyAiDQoJCQkJCSsgbmV3T3JpZW50 YXRpb25Qcm9wZXJ0aWVzLmZvcmNlT3JpZW50YXRpb24sDQoJCQkJCSJzZXRPcmllbnRhdGlvblBy b3BlcnRpZXMiKTsNCgkJCXJldHVybjsNCgkJfQ0KDQoJCW9yaWVudGF0aW9uUHJvcGVydGllcy5h bGxvd09yaWVudGF0aW9uQ2hhbmdlID0gbmV3T3JpZW50YXRpb25Qcm9wZXJ0aWVzLmFsbG93T3Jp ZW50YXRpb25DaGFuZ2U7DQoJCW9yaWVudGF0aW9uUHJvcGVydGllcy5mb3JjZU9yaWVudGF0aW9u ID0gbmV3T3JpZW50YXRpb25Qcm9wZXJ0aWVzLmZvcmNlT3JpZW50YXRpb247DQoNCgkJdmFyIHBh cmFtcyA9ICJhbGxvd09yaWVudGF0aW9uQ2hhbmdlPSINCgkJCQkrIG9yaWVudGF0aW9uUHJvcGVy dGllcy5hbGxvd09yaWVudGF0aW9uQ2hhbmdlDQoJCQkJKyAiJmZvcmNlT3JpZW50YXRpb249IiAr IG9yaWVudGF0aW9uUHJvcGVydGllcy5mb3JjZU9yaWVudGF0aW9uOw0KDQoJCWNhbGxOYXRpdmUo InNldE9yaWVudGF0aW9uUHJvcGVydGllcz8iICsgcGFyYW1zKTsNCgl9Ow0KDQoJbXJhaWQuc2V0 UmVzaXplUHJvcGVydGllcyA9IGZ1bmN0aW9uKHByb3BlcnRpZXMpIHsNCgkJbG9nLmkoIm1yYWlk LnNldFJlc2l6ZVByb3BlcnRpZXMiKTsNCgkJDQoJCWlzUmVzaXplUmVhZHkgPSBmYWxzZTsNCg0K CQkvLyByZXNpemVQcm9wZXJ0aWVzIGNvbnRhaW5zIDYgcmVhZC13cml0ZSBwcm9wZXJ0aWVzOg0K CQkvLyB3aWR0aCwgaGVpZ2h0LCBvZmZzZXRYLCBvZmZzZXRZLCBjdXN0b21DbG9zZVBvc2l0aW9u LCBhbGxvd09mZnNjcmVlbg0KDQoJCS8vIFRoZSBwcm9wZXJ0aWVzIG9iamVjdCBwYXNzZWQgaW50 byB0aGlzIGZ1bmN0aW9uIG11c3QgY29udGFpbiB3aWR0aCwgaGVpZ2h0LCBvZmZzZXRYLCBvZmZz ZXRZLg0KCQkvLyBUaGUgcmVtYWluaW5nIHR3byBwcm9wZXJ0aWVzIGFyZSBvcHRpb25hbC4NCgkJ dmFyIHJlcXVpcmVkUHJvcHMgPSBbICJ3aWR0aCIsICJoZWlnaHQiLCAib2Zmc2V0WCIsICJvZmZz ZXRZIiBdOw0KCQlmb3IgKHZhciBpID0gMDsgaSA8IHJlcXVpcmVkUHJvcHMubGVuZ3RoOyBpKysp IHsNCgkJCXZhciBwcm9wbmFtZSA9IHJlcXVpcmVkUHJvcHNbaV07DQoJCQlpZiAoIXByb3BlcnRp ZXMuaGFzT3duUHJvcGVydHkocHJvcG5hbWUpKSB7DQoJCQkJbXJhaWQuZmlyZUVycm9yRXZlbnQo DQoJCQkJCQkicmVxdWlyZWQgcHJvcGVydHkgIiArIHByb3BuYW1lICsgIiBpcyBtaXNzaW5nIiwN CgkJCQkJCSJtcmFpZC5zZXRSZXNpemVQcm9wZXJ0aWVzIik7DQoJCQkJcmV0dXJuOw0KCQkJfQ0K CQl9DQoJCQ0KCQlpZiAoIXZhbGlkYXRlKHByb3BlcnRpZXMsICJzZXRSZXNpemVQcm9wZXJ0aWVz IikpIHsNCgkJCW1yYWlkLmZpcmVFcnJvckV2ZW50KCJmYWlsZWQgdmFsaWRhdGlvbiIsICJtcmFp ZC5zZXRSZXNpemVQcm9wZXJ0aWVzIik7DQoJCQlyZXR1cm47DQoJCX0NCgkJDQogICAgICAgIHZh ciBhZGp1c3RtZW50cyA9IHsgIngiOiAwLCAieSI6IDAgfTsNCgkJDQoJCXZhciBhbGxvd09mZnNj cmVlbiA9IHByb3BlcnRpZXMuaGFzT3duUHJvcGVydHkoImFsbG93T2Zmc2NyZWVuIikgPyBwcm9w ZXJ0aWVzLmFsbG93T2Zmc2NyZWVuIDogcmVzaXplUHJvcGVydGllcy5hbGxvd09mZnNjcmVlbjsN CiAgICAgICAgaWYgKCFhbGxvd09mZnNjcmVlbikgew0KICAgICAgICAgICAgaWYgKHByb3BlcnRp ZXMud2lkdGggPiBtYXhTaXplLndpZHRoIHx8IHByb3BlcnRpZXMuaGVpZ2h0ID4gbWF4U2l6ZS5o ZWlnaHQpIHsNCiAgICAgICAgICAgICAgICBtcmFpZC5maXJlRXJyb3JFdmVudCgicmVzaXplIHdp ZHRoIG9yIGhlaWdodCBpcyBncmVhdGVyIHRoYW4gdGhlIG1heFNpemUgd2lkdGggb3IgaGVpZ2h0 IiwgIm1yYWlkLnNldFJlc2l6ZVByb3BlcnRpZXMiKTsNCiAgICAgICAgICAgICAgICByZXR1cm47 DQogICAgICAgICAgICB9DQogICAgICAgICAgICBhZGp1c3RtZW50cyA9IGZpdFJlc2l6ZVZpZXdP blNjcmVlbihwcm9wZXJ0aWVzKTsNCiAgICAgICAgfSBlbHNlIGlmICghaXNDbG9zZVJlZ2lvbk9u U2NyZWVuKHByb3BlcnRpZXMpKSB7DQogICAgICAgICAgICBtcmFpZC5maXJlRXJyb3JFdmVudCgi Y2xvc2UgZXZlbnQgcmVnaW9uIHdpbGwgbm90IGFwcGVhciBlbnRpcmVseSBvbnNjcmVlbiIsICJt cmFpZC5zZXRSZXNpemVQcm9wZXJ0aWVzIik7DQogICAgICAgICAgICByZXR1cm47DQogICAgICAg IH0NCgkJDQoJCXZhciByd1Byb3BzID0gWyAid2lkdGgiLCAiaGVpZ2h0IiwgIm9mZnNldFgiLCAi b2Zmc2V0WSIsICJjdXN0b21DbG9zZVBvc2l0aW9uIiwgImFsbG93T2Zmc2NyZWVuIiBdOw0KCQlm b3IgKHZhciBpID0gMDsgaSA8IHJ3UHJvcHMubGVuZ3RoOyBpKyspIHsNCgkJCXZhciBwcm9wbmFt ZSA9IHJ3UHJvcHNbaV07DQoJCQlpZiAocHJvcGVydGllcy5oYXNPd25Qcm9wZXJ0eShwcm9wbmFt ZSkpIHsNCgkJCQlyZXNpemVQcm9wZXJ0aWVzW3Byb3BuYW1lXSA9IHByb3BlcnRpZXNbcHJvcG5h bWVdOw0KCQkJfQ0KCQl9DQoJCQ0KCQl2YXIgcGFyYW1zID0NCgkJCSJ3aWR0aD0iICsgcmVzaXpl UHJvcGVydGllcy53aWR0aCArDQoJCQkiJmhlaWdodD0iICsgcmVzaXplUHJvcGVydGllcy5oZWln aHQgKw0KCSAgICAgICAgIiZvZmZzZXRYPSIgKyAocmVzaXplUHJvcGVydGllcy5vZmZzZXRYICsg YWRqdXN0bWVudHMueCkgKw0KCSAgICAgICAgIiZvZmZzZXRZPSIgKyAocmVzaXplUHJvcGVydGll cy5vZmZzZXRZICsgYWRqdXN0bWVudHMueSkgKw0KCQkJIiZjdXN0b21DbG9zZVBvc2l0aW9uPSIg KyByZXNpemVQcm9wZXJ0aWVzLmN1c3RvbUNsb3NlUG9zaXRpb24gKw0KCQkJIiZhbGxvd09mZnNj cmVlbj0iICsgcmVzaXplUHJvcGVydGllcy5hbGxvd09mZnNjcmVlbjsNCg0KCQljYWxsTmF0aXZl KCJzZXRSZXNpemVQcm9wZXJ0aWVzPyIgKyBwYXJhbXMpOw0KDQoJCWlzUmVzaXplUmVhZHkgPSB0 cnVlOw0KCX07DQoNCgltcmFpZC5zdG9yZVBpY3R1cmUgPSBmdW5jdGlvbih1cmwpIHsNCgkJbG9n LmkoIm1yYWlkLnN0b3JlUGljdHVyZSAiICsgdXJsKTsNCgkJaWYgKHN1cHBvcnRlZEZlYXR1cmVz W21yYWlkLlNVUFBPUlRFRF9GRUFUVVJFUy5TVE9SRVBJQ1RVUkVdKSB7DQoJCQljYWxsTmF0aXZl KCJzdG9yZVBpY3R1cmU/dXJsPSIgKyBlbmNvZGVVUklDb21wb25lbnQodXJsKSk7DQoJCX0gZWxz ZSB7DQoJCQlsb2cuZSgic3RvcmVQaWN0dXJlIGlzIG5vdCBzdXBwb3J0ZWQiKTsNCgkJfQ0KCX07 DQoNCgltcmFpZC5zdXBwb3J0cyA9IGZ1bmN0aW9uKGZlYXR1cmUpIHsNCgkJbG9nLmkoIm1yYWlk LnN1cHBvcnRzICIgKyBmZWF0dXJlICsgIiAiICsgc3VwcG9ydGVkRmVhdHVyZXNbZmVhdHVyZV0p Ow0KCQl2YXIgcmV0dmFsID0gc3VwcG9ydGVkRmVhdHVyZXNbZmVhdHVyZV07DQoJCWlmICh0eXBl b2YgcmV0dmFsID09PSAidW5kZWZpbmVkIikgew0KCQkJcmV0dmFsID0gZmFsc2U7DQoJCX0NCgkJ cmV0dXJuIHJldHZhbDsNCgl9Ow0KDQoJbXJhaWQudXNlQ3VzdG9tQ2xvc2UgPSBmdW5jdGlvbihp c0N1c3RvbUNsb3NlKSB7DQoJCWxvZy5pKCJtcmFpZC51c2VDdXN0b21DbG9zZSAiICsgaXNDdXN0 b21DbG9zZSk7DQoJCWlmIChleHBhbmRQcm9wZXJ0aWVzLnVzZUN1c3RvbUNsb3NlICE9PSBpc0N1 c3RvbUNsb3NlKSB7DQoJCQlleHBhbmRQcm9wZXJ0aWVzLnVzZUN1c3RvbUNsb3NlID0gaXNDdXN0 b21DbG9zZTsNCgkJCWNhbGxOYXRpdmUoInVzZUN1c3RvbUNsb3NlP3VzZUN1c3RvbUNsb3NlPSIN CgkJCQkJKyBleHBhbmRQcm9wZXJ0aWVzLnVzZUN1c3RvbUNsb3NlKTsNCgkJfQ0KCX07DQoNCgkv KioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioq KioqKioqKioqKioqKioqKioqDQoJICogaGVscGVyIG1ldGhvZHMgY2FsbGVkIGJ5IFNESw0KCSAq KioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioq KioqKioqKioqKioqKioqKi8NCg0KCS8vIHNldHRlcnMgdG8gY2hhbmdlIHN0YXRlDQoJbXJhaWQu c2V0Q3VycmVudFBvc2l0aW9uID0gZnVuY3Rpb24oeCwgeSwgd2lkdGgsIGhlaWdodCkgew0KCQls b2cuaSgibXJhaWQuc2V0Q3VycmVudFBvc2l0aW9uICIgKyB4ICsgIiwiICsgeSArICIsIiArIHdp ZHRoICsgIiwiCSsgaGVpZ2h0KTsNCg0KCQl2YXIgcHJldmlvdXNTaXplID0ge307DQoJCXByZXZp b3VzU2l6ZS53aWR0aCA9IGN1cnJlbnRQb3NpdGlvbi53aWR0aDsNCgkJcHJldmlvdXNTaXplLmhl aWdodCA9IGN1cnJlbnRQb3NpdGlvbi5oZWlnaHQ7DQoJCWxvZy5pKCJwcmV2aW91c1NpemUgIiAr IHByZXZpb3VzU2l6ZS53aWR0aCArICIsIiArIHByZXZpb3VzU2l6ZS5oZWlnaHQpOw0KDQoJCWN1 cnJlbnRQb3NpdGlvbi54ID0geDsNCgkJY3VycmVudFBvc2l0aW9uLnkgPSB5Ow0KCQljdXJyZW50 UG9zaXRpb24ud2lkdGggPSB3aWR0aDsNCgkJY3VycmVudFBvc2l0aW9uLmhlaWdodCA9IGhlaWdo dDsNCg0KCQlpZiAod2lkdGggIT09IHByZXZpb3VzU2l6ZS53aWR0aCB8fCBoZWlnaHQgIT09IHBy ZXZpb3VzU2l6ZS5oZWlnaHQpIHsNCgkJCW1yYWlkLmZpcmVTaXplQ2hhbmdlRXZlbnQod2lkdGgs IGhlaWdodCk7DQoJCX0NCgl9Ow0KDQoJbXJhaWQuc2V0RGVmYXVsdFBvc2l0aW9uID0gZnVuY3Rp b24oeCwgeSwgd2lkdGgsIGhlaWdodCkgew0KCQlsb2cuaSgibXJhaWQuc2V0RGVmYXVsdFBvc2l0 aW9uICIgKyB4ICsgIiwiICsgeSArICIsIiArIHdpZHRoICsgIiwiCSsgaGVpZ2h0KTsNCgkJZGVm YXVsdFBvc2l0aW9uLnggPSB4Ow0KCQlkZWZhdWx0UG9zaXRpb24ueSA9IHk7DQoJCWRlZmF1bHRQ b3NpdGlvbi53aWR0aCA9IHdpZHRoOw0KCQlkZWZhdWx0UG9zaXRpb24uaGVpZ2h0ID0gaGVpZ2h0 Ow0KCX07DQoNCgltcmFpZC5zZXRFeHBhbmRTaXplID0gZnVuY3Rpb24od2lkdGgsIGhlaWdodCkg ew0KCQlsb2cuaSgibXJhaWQuc2V0RXhwYW5kU2l6ZSAiICsgd2lkdGggKyAieCIgKyBoZWlnaHQp Ow0KCQlleHBhbmRQcm9wZXJ0aWVzLndpZHRoID0gd2lkdGg7DQoJCWV4cGFuZFByb3BlcnRpZXMu aGVpZ2h0ID0gaGVpZ2h0Ow0KCX07DQoNCgltcmFpZC5zZXRNYXhTaXplID0gZnVuY3Rpb24od2lk dGgsIGhlaWdodCkgew0KCQlsb2cuaSgibXJhaWQuc2V0TWF4U2l6ZSAiICsgd2lkdGggKyAieCIg KyBoZWlnaHQpOw0KCQltYXhTaXplLndpZHRoID0gd2lkdGg7DQoJCW1heFNpemUuaGVpZ2h0ID0g aGVpZ2h0Ow0KCX07DQoNCgltcmFpZC5zZXRQbGFjZW1lbnRUeXBlID0gZnVuY3Rpb24ocHQpIHsN CgkJbG9nLmkoIm1yYWlkLnNldFBsYWNlbWVudFR5cGUgIiArIHB0KTsNCgkJcGxhY2VtZW50VHlw ZSA9IHB0Ow0KCX07DQoNCgltcmFpZC5zZXRTY3JlZW5TaXplID0gZnVuY3Rpb24od2lkdGgsIGhl aWdodCkgew0KCQlsb2cuaSgibXJhaWQuc2V0U2NyZWVuU2l6ZSAiICsgd2lkdGggKyAieCIgKyBo ZWlnaHQpOw0KCQlzY3JlZW5TaXplLndpZHRoID0gd2lkdGg7DQoJCXNjcmVlblNpemUuaGVpZ2h0 ID0gaGVpZ2h0Ow0KCQlpZiAoIWlzRXhwYW5kUHJvcGVydGllc1NldCkgew0KCQkJZXhwYW5kUHJv cGVydGllcy53aWR0aCA9IHdpZHRoOw0KCQkJZXhwYW5kUHJvcGVydGllcy5oZWlnaHQgPSBoZWln aHQ7Ow0KCQl9DQoJfTsNCg0KCW1yYWlkLnNldFN1cHBvcnRzID0gZnVuY3Rpb24oZmVhdHVyZSwg c3VwcG9ydGVkKSB7DQoJCWxvZy5pKCJtcmFpZC5zZXRTdXBwb3J0cyAiICsgZmVhdHVyZSArICIg IiArIHN1cHBvcnRlZCk7DQoJCXN1cHBvcnRlZEZlYXR1cmVzW2ZlYXR1cmVdID0gc3VwcG9ydGVk Ow0KCX07DQoNCgkvLyBtZXRob2RzIHRvIGZpcmUgZXZlbnRzDQoNCgltcmFpZC5maXJlRXJyb3JF dmVudCA9IGZ1bmN0aW9uKG1lc3NhZ2UsIGFjdGlvbikgew0KCQlsb2cuaSgibXJhaWQuZmlyZUVy cm9yRXZlbnQgIiArIG1lc3NhZ2UgKyAiICIgKyBhY3Rpb24pOw0KCQlmaXJlRXZlbnQobXJhaWQu RVZFTlRTLkVSUk9SLCBtZXNzYWdlLCBhY3Rpb24pOw0KCX07DQoNCgltcmFpZC5maXJlUmVhZHlF dmVudCA9IGZ1bmN0aW9uKCkgew0KCQlsb2cuaSgibXJhaWQuZmlyZVJlYWR5RXZlbnQiKTsNCgkJ ZmlyZUV2ZW50KG1yYWlkLkVWRU5UUy5SRUFEWSk7DQoJfTsNCg0KCW1yYWlkLmZpcmVTaXplQ2hh bmdlRXZlbnQgPSBmdW5jdGlvbih3aWR0aCwgaGVpZ2h0KSB7DQoJCWxvZy5pKCJtcmFpZC5maXJl U2l6ZUNoYW5nZUV2ZW50ICIgKyB3aWR0aCArICJ4IiArIGhlaWdodCk7DQoJCWlmIChzdGF0ZSAh PT0gbXJhaWQuU1RBVEVTLkxPQURJTkcpIHsNCgkJCWZpcmVFdmVudChtcmFpZC5FVkVOVFMuU0la RUNIQU5HRSwgd2lkdGgsIGhlaWdodCk7DQoJCX0NCgl9Ow0KDQoJbXJhaWQuZmlyZVN0YXRlQ2hh bmdlRXZlbnQgPSBmdW5jdGlvbihuZXdTdGF0ZSkgew0KCQlsb2cuaSgibXJhaWQuZmlyZVN0YXRl Q2hhbmdlRXZlbnQgIiArIG5ld1N0YXRlKTsNCgkJaWYgKHN0YXRlICE9PSBuZXdTdGF0ZSkgew0K CQkJc3RhdGUgPSBuZXdTdGF0ZTsNCgkJCWZpcmVFdmVudChtcmFpZC5FVkVOVFMuU1RBVEVDSEFO R0UsIHN0YXRlKTsNCgkJfQ0KCX07DQoNCgltcmFpZC5maXJlVmlld2FibGVDaGFuZ2VFdmVudCA9 IGZ1bmN0aW9uKG5ld0lzVmlld2FibGUpIHsNCgkJbG9nLmkoIm1yYWlkLmZpcmVWaWV3YWJsZUNo YW5nZUV2ZW50ICIgKyBuZXdJc1ZpZXdhYmxlKTsNCgkJaWYgKGlzVmlld2FibGUgIT09IG5ld0lz Vmlld2FibGUpIHsNCgkJCWlzVmlld2FibGUgPSBuZXdJc1ZpZXdhYmxlOw0KCQkJZmlyZUV2ZW50 KG1yYWlkLkVWRU5UUy5WSUVXQUJMRUNIQU5HRSwgaXNWaWV3YWJsZSk7DQoJCX0NCgl9Ow0KDQoJ LyoqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioq KioqKioqKioqKioqKioqKioqKg0KCSAqIGludGVybmFsIGhlbHBlciBtZXRob2RzDQoJICoqKioq KioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioqKioq KioqKioqKioqKioqLw0KDQoJZnVuY3Rpb24gY2FsbE5hdGl2ZShjb21tYW5kKSB7DQoJCXZhciBp ZnJhbWUgPSBkb2N1bWVudC5jcmVhdGVFbGVtZW50KCJJRlJBTUUiKTsNCgkJaWZyYW1lLnNldEF0 dHJpYnV0ZSgic3JjIiwgIm1yYWlkOi8vIiArIGNvbW1hbmQpOw0KCQlkb2N1bWVudC5kb2N1bWVu dEVsZW1lbnQuYXBwZW5kQ2hpbGQoaWZyYW1lKTsNCgkJaWZyYW1lLnBhcmVudE5vZGUucmVtb3Zl Q2hpbGQoaWZyYW1lKTsNCgkJaWZyYW1lID0gbnVsbDsNCgl9Ow0KDQoJZnVuY3Rpb24gZmlyZUV2 ZW50KGV2ZW50KSB7DQoJCXZhciBhcmdzID0gQXJyYXkucHJvdG90eXBlLnNsaWNlLmNhbGwoYXJn dW1lbnRzKTsNCgkJYXJncy5zaGlmdCgpOw0KCQlsb2cuaSgiZmlyZUV2ZW50ICIgKyBldmVudCAr ICIgWyIgKyBhcmdzLnRvU3RyaW5nKCkgKyAiXSIpOw0KCQl2YXIgZXZlbnRMaXN0ZW5lcnMgPSBs aXN0ZW5lcnNbZXZlbnRdOw0KCQlpZiAoZXZlbnRMaXN0ZW5lcnMpIHsNCgkJCXZhciBsZW4gPSBl dmVudExpc3RlbmVycy5sZW5ndGg7DQoJCQlsb2cuaShsZW4gKyAiIGxpc3RlbmVyKHMpIGZvdW5k Iik7DQoJCQlmb3IgKHZhciBpID0gMDsgaSA8IGxlbjsgaSsrKSB7DQoJCQkJZXZlbnRMaXN0ZW5l cnNbaV0uYXBwbHkobnVsbCwgYXJncyk7DQoJCQl9DQoJCX0gZWxzZSB7DQoJCQlsb2cuaSgibm8g bGlzdGVuZXJzIGZvdW5kIik7DQoJCX0NCgl9Ow0KDQoJZnVuY3Rpb24gY29udGFpbnModmFsdWUs IGFycmF5KSB7DQoJCWZvciAoIHZhciBpIGluIGFycmF5KSB7DQoJCQlpZiAoYXJyYXlbaV0gPT09 IHZhbHVlKSB7DQoJCQkJcmV0dXJuIHRydWU7DQoJCQl9DQoJCX0NCgkJcmV0dXJuIGZhbHNlOw0K CX07DQoNCgkvLyBUaGUgYWN0aW9uIHBhcmFtZXRlciBpcyBhIHN0cmluZyB3aGljaCBpcyB0aGUg bmFtZSBvZiB0aGUgc2V0dGVyIGZ1bmN0aW9uDQoJLy8gd2hpY2ggY2FsbGVkIHRoaXMgZnVuY3Rp b24NCgkvLyAoaW4gb3RoZXIgd29yZHMsIHNldEV4cGFuZFByb3BldGllcywgc2V0T3JpZW50YXRp b25Qcm9wZXJ0aWVzLCBvcg0KCS8vIHNldFJlc2l6ZVByb3BlcnRpZXMpLg0KCS8vIEl0IHNlcnZl cyBib3RoIGFzIHRoZSBrZXkgdG8gZ2V0IHRoZSB0aGUgYXBwcm9wcmlhdGUgc2V0IG9mIHZhbGlk YXRpbmcNCgkvLyBmdW5jdGlvbnMgZnJvbSB0aGUgYWxsVmFsaWRhdG9ycyBvYmplY3QNCgkvLyBh cyB3ZWxsIGFzIHRoZSBhY3Rpb24gcGFyYW1ldGVyIG9mIGFueSBlcnJvciBldmVudCB0aGF0IG1h eSBiZSB0aHJvd24uDQoJZnVuY3Rpb24gdmFsaWRhdGUocHJvcGVydGllcywgYWN0aW9uKSB7DQoJ CXZhciByZXR2YWwgPSB0cnVlOw0KCQl2YXIgdmFsaWRhdG9ycyA9IGFsbFZhbGlkYXRvcnNbYWN0 aW9uXTsNCgkJZm9yICh2YXIgcHJvcCBpbiBwcm9wZXJ0aWVzKSB7DQoJCQl2YXIgdmFsaWRhdG9y ID0gdmFsaWRhdG9yc1twcm9wXTsNCgkJCXZhciB2YWx1ZSA9IHByb3BlcnRpZXNbcHJvcF07DQoJ CQlpZiAodmFsaWRhdG9yICYmICF2YWxpZGF0b3IodmFsdWUpKSB7DQoJCQkJbXJhaWQuZmlyZUVy cm9yRXZlbnQoIlZhbHVlIG9mIHByb3BlcnR5ICIgKyBwcm9wICsgIiAoIiArIHZhbHVlCSsgIikg aXMgaW52YWxpZCIsICJtcmFpZC4iICsgYWN0aW9uKTsNCgkJCQlyZXR2YWwgPSBmYWxzZTsNCgkJ CX0NCgkJfQ0KCQlyZXR1cm4gcmV0dmFsOw0KCX07DQoNCgl2YXIgYWxsVmFsaWRhdG9ycyA9IHsN CgkJInNldEV4cGFuZFByb3BlcnRpZXMiIDogew0KCQkJLy8gSW4gTVJBSUQgMi4wLCB0aGUgb25s eSBwcm9wZXJ0eSBpbiBleHBhbmRQcm9wZXJ0aWVzIHdlIGFjdHVhbGx5IGNhcmUgYWJvdXQgaXMg dXNlQ3VzdG9tQ2xvc2UuDQoJCQkvLyBTdGlsbCwgd2UnbGwgZG8gYSBiYXNpYyBzYW5pdHkgY2hl Y2sgb24gdGhlIHdpZHRoIGFuZCBoZWlnaHQgcHJvcGVydGllcywgdG9vLg0KCQkJIndpZHRoIiA6 IGZ1bmN0aW9uKHdpZHRoKSB7DQoJCQkJcmV0dXJuICFpc05hTih3aWR0aCk7DQoJCQl9LA0KCQkJ ImhlaWdodCIgOiBmdW5jdGlvbihoZWlnaHQpIHsNCgkJCQlyZXR1cm4gIWlzTmFOKGhlaWdodCk7 DQoJCQl9LA0KCQkJInVzZUN1c3RvbUNsb3NlIiA6IGZ1bmN0aW9uKHVzZUN1c3RvbUNsb3NlKSB7 DQoJCQkJcmV0dXJuICh0eXBlb2YgdXNlQ3VzdG9tQ2xvc2UgPT09ICJib29sZWFuIik7DQoJCQl9 DQoJCX0sDQoJCSJzZXRPcmllbnRhdGlvblByb3BlcnRpZXMiIDogew0KCQkJImFsbG93T3JpZW50 YXRpb25DaGFuZ2UiIDogZnVuY3Rpb24oYWxsb3dPcmllbnRhdGlvbkNoYW5nZSkgew0KCQkJCXJl dHVybiAodHlwZW9mIGFsbG93T3JpZW50YXRpb25DaGFuZ2UgPT09ICJib29sZWFuIik7DQoJCQl9 LA0KCQkJImZvcmNlT3JpZW50YXRpb24iIDogZnVuY3Rpb24oZm9yY2VPcmllbnRhdGlvbikgew0K CQkJCXZhciB2YWxpZFZhbHVlcyA9IFsgInBvcnRyYWl0IiwgImxhbmRzY2FwZSIsICJub25lIiBd Ow0KCQkJCXJldHVybiAodHlwZW9mIGZvcmNlT3JpZW50YXRpb24gPT09ICJzdHJpbmciICYmIHZh bGlkVmFsdWVzLmluZGV4T2YoZm9yY2VPcmllbnRhdGlvbikgIT09IC0xKTsNCgkJCX0NCgkJfSwN CgkJInNldFJlc2l6ZVByb3BlcnRpZXMiIDogew0KCQkJIndpZHRoIiA6IGZ1bmN0aW9uKHdpZHRo KSB7DQoJCQkJcmV0dXJuICFpc05hTih3aWR0aCkgJiYgNTAgPD0gd2lkdGg7DQoJCQl9LA0KCQkJ ImhlaWdodCIgOiBmdW5jdGlvbihoZWlnaHQpIHsNCgkJCQlyZXR1cm4gIWlzTmFOKGhlaWdodCkg JiYgNTAgPD0gaGVpZ2h0Ow0KCQkJfSwNCgkJCSJvZmZzZXRYIiA6IGZ1bmN0aW9uKG9mZnNldFgp IHsNCgkJCQlyZXR1cm4gIWlzTmFOKG9mZnNldFgpOw0KCQkJfSwNCgkJCSJvZmZzZXRZIiA6IGZ1 bmN0aW9uKG9mZnNldFkpIHsNCgkJCQlyZXR1cm4gIWlzTmFOKG9mZnNldFkpOw0KCQkJfSwNCgkJ CSJjdXN0b21DbG9zZVBvc2l0aW9uIiA6IGZ1bmN0aW9uKGN1c3RvbUNsb3NlUG9zaXRpb24pIHsN CgkJCQl2YXIgdmFsaWRQb3NpdGlvbnMgPSBbICJ0b3AtbGVmdCIsICJ0b3AtY2VudGVyIiwgInRv cC1yaWdodCIsDQoJCQkJICAgICAgICAgICAgICAgICAgICAgICAiY2VudGVyIiwNCgkJCQkgICAg ICAgICAgICAgICAgICAgICAgICJib3R0b20tbGVmdCIsICJib3R0b20tY2VudGVyIiwJImJvdHRv bS1yaWdodCIgXTsNCgkJCQlyZXR1cm4gKHR5cGVvZiBjdXN0b21DbG9zZVBvc2l0aW9uID09PSAi c3RyaW5nIiAmJiB2YWxpZFBvc2l0aW9ucy5pbmRleE9mKGN1c3RvbUNsb3NlUG9zaXRpb24pICE9 PSAtMSk7DQoJCQl9LA0KCQkJImFsbG93T2Zmc2NyZWVuIiA6IGZ1bmN0aW9uKGFsbG93T2Zmc2Ny ZWVuKSB7DQoJCQkJcmV0dXJuICh0eXBlb2YgYWxsb3dPZmZzY3JlZW4gPT09ICJib29sZWFuIik7 DQoJCQl9DQoJCX0NCgl9Ow0KCQ0KICAgIGZ1bmN0aW9uIGlzQ2xvc2VSZWdpb25PblNjcmVlbihw cm9wZXJ0aWVzKSB7DQogICAgICAgIGxvZy5kKCJpc0Nsb3NlUmVnaW9uT25TY3JlZW4iKTsNCiAg ICAgICAgbG9nLmQoImRlZmF1bHRQb3NpdGlvbiAiICsgZGVmYXVsdFBvc2l0aW9uLnggKyAiICIg KyBkZWZhdWx0UG9zaXRpb24ueSk7DQogICAgICAgIGxvZy5kKCJvZmZzZXQgIiArIHByb3BlcnRp ZXMub2Zmc2V0WCArICIgIiArIHByb3BlcnRpZXMub2Zmc2V0WSk7DQoNCiAgICAgICAgdmFyIHJl c2l6ZVJlY3QgPSB7fTsNCiAgICAgICAgcmVzaXplUmVjdC54ID0gZGVmYXVsdFBvc2l0aW9uLngg KyBwcm9wZXJ0aWVzLm9mZnNldFg7DQogICAgICAgIHJlc2l6ZVJlY3QueSA9IGRlZmF1bHRQb3Np dGlvbi55ICsgcHJvcGVydGllcy5vZmZzZXRZOw0KICAgICAgICByZXNpemVSZWN0LndpZHRoID0g cHJvcGVydGllcy53aWR0aDsNCiAgICAgICAgcmVzaXplUmVjdC5oZWlnaHQgPSBwcm9wZXJ0aWVz LmhlaWdodDsNCiAgICAgICAgcHJpbnRSZWN0KCJyZXNpemVSZWN0IiwgcmVzaXplUmVjdCk7DQoN CgkJdmFyIGN1c3RvbUNsb3NlUG9zaXRpb24gPSBwcm9wZXJ0aWVzLmhhc093blByb3BlcnR5KCJj dXN0b21DbG9zZVBvc2l0aW9uIikgPw0KCQkJCXByb3BlcnRpZXMuY3VzdG9tQ2xvc2VQb3NpdGlv biA6IHJlc2l6ZVByb3BlcnRpZXMuY3VzdG9tQ2xvc2VQb3NpdGlvbjsNCiAgICAgICAgbG9nLmQo ImN1c3RvbUNsb3NlUG9zaXRpb24gIiArIGN1c3RvbUNsb3NlUG9zaXRpb24pOw0KICAgICAgICAN CiAgICAgICAgdmFyIGNsb3NlUmVjdCA9IHsgIndpZHRoIjogNTAsICJoZWlnaHQiOiA1MCB9Ow0K DQogICAgICAgIGlmIChjdXN0b21DbG9zZVBvc2l0aW9uLnNlYXJjaCgibGVmdCIpICE9PSAtMSkg ew0KICAgICAgICAgICAgY2xvc2VSZWN0LnggPSByZXNpemVSZWN0Lng7DQogICAgICAgIH0gZWxz ZSBpZiAoY3VzdG9tQ2xvc2VQb3NpdGlvbi5zZWFyY2goImNlbnRlciIpICE9PSAtMSkgew0KICAg ICAgICAgICAgY2xvc2VSZWN0LnggPSByZXNpemVSZWN0LnggKyAocmVzaXplUmVjdC53aWR0aCAv IDIpIC0gMjU7DQogICAgICAgIH0gZWxzZSBpZiAoY3VzdG9tQ2xvc2VQb3NpdGlvbi5zZWFyY2go InJpZ2h0IikgIT09IC0xKSB7DQogICAgICAgICAgICBjbG9zZVJlY3QueCA9IHJlc2l6ZVJlY3Qu eCArIHJlc2l6ZVJlY3Qud2lkdGggLSA1MDsNCiAgICAgICAgfQ0KDQogICAgICAgIGlmIChjdXN0 b21DbG9zZVBvc2l0aW9uLnNlYXJjaCgidG9wIikgIT09IC0xKSB7DQogICAgICAgICAgICBjbG9z ZVJlY3QueSA9IHJlc2l6ZVJlY3QueTsNCiAgICAgICAgfSBlbHNlIGlmIChjdXN0b21DbG9zZVBv c2l0aW9uID09PSAiY2VudGVyIikgew0KICAgICAgICAgICAgY2xvc2VSZWN0LnkgPSByZXNpemVS ZWN0LnkgKyAocmVzaXplUmVjdC5oZWlnaHQgLyAyKSAtIDI1Ow0KICAgICAgICB9IGVsc2UgaWYg KGN1c3RvbUNsb3NlUG9zaXRpb24uc2VhcmNoKCJib3R0b20iKSAhPT0gLTEpIHsNCiAgICAgICAg ICAgIGNsb3NlUmVjdC55ID0gcmVzaXplUmVjdC55ICsgcmVzaXplUmVjdC5oZWlnaHQgLSA1MDsN CiAgICAgICAgfQ0KDQogICAgICAgIHZhciBtYXhSZWN0ID0geyAieCI6IDAsICJ5IjogMCB9Ow0K ICAgICAgICBtYXhSZWN0LndpZHRoID0gbWF4U2l6ZS53aWR0aDsNCiAgICAgICAgbWF4UmVjdC5o ZWlnaHQgPSBtYXhTaXplLmhlaWdodDsNCg0KICAgICAgICByZXR1cm4gaXNSZWN0Q29udGFpbmVk KG1heFJlY3QsIGNsb3NlUmVjdCk7DQogICAgfQ0KICAgIA0KICAgIGZ1bmN0aW9uIGZpdFJlc2l6 ZVZpZXdPblNjcmVlbihwcm9wZXJ0aWVzKSB7DQogICAgICAgIGxvZy5kKCJmaXRSZXNpemVWaWV3 T25TY3JlZW4iKTsNCiAgICAgICAgbG9nLmQoImRlZmF1bHRQb3NpdGlvbiAiICsgZGVmYXVsdFBv c2l0aW9uLnggKyAiICIgKyBkZWZhdWx0UG9zaXRpb24ueSk7DQogICAgICAgIGxvZy5kKCJvZmZz ZXQgIiArIHByb3BlcnRpZXMub2Zmc2V0WCArICIgIiArIHByb3BlcnRpZXMub2Zmc2V0WSk7DQoN CiAgICAgICAgdmFyIHJlc2l6ZVJlY3QgPSB7fTsNCiAgICAgICAgcmVzaXplUmVjdC54ID0gZGVm YXVsdFBvc2l0aW9uLnggKyBwcm9wZXJ0aWVzLm9mZnNldFg7DQogICAgICAgIHJlc2l6ZVJlY3Qu eSA9IGRlZmF1bHRQb3NpdGlvbi55ICsgcHJvcGVydGllcy5vZmZzZXRZOw0KICAgICAgICByZXNp emVSZWN0LndpZHRoID0gcHJvcGVydGllcy53aWR0aDsNCiAgICAgICAgcmVzaXplUmVjdC5oZWln aHQgPSBwcm9wZXJ0aWVzLmhlaWdodDsNCiAgICAgICAgcHJpbnRSZWN0KCJyZXNpemVSZWN0Iiwg cmVzaXplUmVjdCk7DQoNCiAgICAgICAgdmFyIG1heFJlY3QgPSB7ICJ4IjogMCwgInkiOiAwIH07 DQogICAgICAgIG1heFJlY3Qud2lkdGggPSBtYXhTaXplLndpZHRoOw0KICAgICAgICBtYXhSZWN0 LmhlaWdodCA9IG1heFNpemUuaGVpZ2h0Ow0KDQogICAgICAgIHZhciBhZGp1c3RtZW50cyA9IHsg IngiOiAwLCAieSI6IDAgfTsNCg0KICAgICAgICBpZiAoaXNSZWN0Q29udGFpbmVkKG1heFJlY3Qs IHJlc2l6ZVJlY3QpKSB7DQogICAgICAgICAgICBsb2cuZCgibm8gYWRqdXN0bWVudCBuZWNlc3Nh cnkiKTsNCiAgICAgICAgICAgIHJldHVybiBhZGp1c3RtZW50czsNCiAgICAgICAgfQ0KDQogICAg ICAgIGlmIChyZXNpemVSZWN0LnggPCBtYXhSZWN0LngpIHsNCiAgICAgICAgICAgIGFkanVzdG1l bnRzLnggPSBtYXhSZWN0LnggLSByZXNpemVSZWN0Lng7DQogICAgICAgIH0gZWxzZSBpZiAoKHJl c2l6ZVJlY3QueCArIHJlc2l6ZVJlY3Qud2lkdGgpID4gKG1heFJlY3QueCArIG1heFJlY3Qud2lk dGgpKSB7DQogICAgICAgICAgICBhZGp1c3RtZW50cy54ID0gKG1heFJlY3QueCArIG1heFJlY3Qu d2lkdGgpIC0gKHJlc2l6ZVJlY3QueCArIHJlc2l6ZVJlY3Qud2lkdGgpOw0KICAgICAgICB9DQog ICAgICAgIGxvZy5kKCJhZGp1c3RtZW50cy54ICIgKyBhZGp1c3RtZW50cy54KTsNCg0KICAgICAg ICBpZiAocmVzaXplUmVjdC55IDwgbWF4UmVjdC55KSB7DQogICAgICAgICAgICBhZGp1c3RtZW50 cy55ID0gbWF4UmVjdC55IC0gcmVzaXplUmVjdC55Ow0KICAgICAgICB9IGVsc2UgaWYgKChyZXNp emVSZWN0LnkgKyByZXNpemVSZWN0LmhlaWdodCkgPiAobWF4UmVjdC55ICsgbWF4UmVjdC5oZWln aHQpKSB7DQogICAgICAgICAgICBhZGp1c3RtZW50cy55ID0gKG1heFJlY3QueSArIG1heFJlY3Qu aGVpZ2h0KSAtIChyZXNpemVSZWN0LnkgKyByZXNpemVSZWN0LmhlaWdodCk7DQogICAgICAgIH0N CiAgICAgICAgbG9nLmQoImFkanVzdG1lbnRzLnkgIiArIGFkanVzdG1lbnRzLnkpOw0KDQogICAg ICAgIHJlc2l6ZVJlY3QueCA9IGRlZmF1bHRQb3NpdGlvbi54ICsgcHJvcGVydGllcy5vZmZzZXRY ICsgYWRqdXN0bWVudHMueDsNCiAgICAgICAgcmVzaXplUmVjdC55ID0gZGVmYXVsdFBvc2l0aW9u LnkgKyBwcm9wZXJ0aWVzLm9mZnNldFkgKyBhZGp1c3RtZW50cy55Ow0KICAgICAgICBwcmludFJl Y3QoImFkanVzdGVkIHJlc2l6ZVJlY3QiLCByZXNpemVSZWN0KTsNCg0KICAgICAgICByZXR1cm4g YWRqdXN0bWVudHM7DQogICAgfQ0KICAgIA0KICAgIGZ1bmN0aW9uIGlzUmVjdENvbnRhaW5lZChj b250YWluaW5nUmVjdCwgY29udGFpbmVkUmVjdCkgew0KICAgICAgICBsb2cuZCgiaXNSZWN0Q29u dGFpbmVkIik7DQogICAgICAgIHByaW50UmVjdCgiY29udGFpbmluZ1JlY3QiLCBjb250YWluaW5n UmVjdCk7DQogICAgICAgIHByaW50UmVjdCgiY29udGFpbmVkUmVjdCIsIGNvbnRhaW5lZFJlY3Qp Ow0KICAgICAgICByZXR1cm4gKGNvbnRhaW5lZFJlY3QueCA+PSBjb250YWluaW5nUmVjdC54ICYm DQogICAgICAgICAgICAoY29udGFpbmVkUmVjdC54ICsgY29udGFpbmVkUmVjdC53aWR0aCkgPD0g KGNvbnRhaW5pbmdSZWN0LnggKyBjb250YWluaW5nUmVjdC53aWR0aCkgJiYNCiAgICAgICAgICAg IGNvbnRhaW5lZFJlY3QueSA+PSBjb250YWluaW5nUmVjdC55ICYmDQogICAgICAgICAgICAoY29u dGFpbmVkUmVjdC55ICsgY29udGFpbmVkUmVjdC5oZWlnaHQpIDw9IChjb250YWluaW5nUmVjdC55 ICsgY29udGFpbmluZ1JlY3QuaGVpZ2h0KSk7DQogICAgfQ0KICAgIA0KICAgIGZ1bmN0aW9uIHBy aW50UmVjdChsYWJlbCwgcmVjdCkgew0KICAgICAgICBsb2cuZChsYWJlbCArDQogICAgICAgICAg ICAiIFsiICsgcmVjdC54ICsgIiwiICsgcmVjdC55ICsgIl0iICsNCiAgICAgICAgICAgICIsWyIg KyAocmVjdC54ICsgcmVjdC53aWR0aCkgKyAiLCIgKyAocmVjdC55ICsgcmVjdC5oZWlnaHQpICsg Il0iICsNCiAgICAgICAgICAgICIgKCIgKyByZWN0LndpZHRoICsgIngiICsgcmVjdC5oZWlnaHQg KyAiKSIpOw0KICAgIH0NCgkNCgltcmFpZC5kdW1wTGlzdGVuZXJzID0gZnVuY3Rpb24oKSB7DQoJ CXZhciBuRXZlbnRzID0gT2JqZWN0LmtleXMobGlzdGVuZXJzKS5sZW5ndGg7DQoJCWxvZy5pKCJk dW1waW5nIGxpc3RlbmVycyAoIiArIG5FdmVudHMgKyAiIGV2ZW50cykiKTsNCgkJZm9yICggdmFy IGV2ZW50IGluIGxpc3RlbmVycykgew0KCQkJdmFyIGV2ZW50TGlzdGVuZXJzID0gbGlzdGVuZXJz W2V2ZW50XTsNCgkJCWxvZy5pKCIgICIgKyBldmVudCArICIgY29udGFpbnMgIiArIGV2ZW50TGlz dGVuZXJzLmxlbmd0aCArICIgbGlzdGVuZXJzIik7DQoJCQlmb3IgKHZhciBpID0gMDsgaSA8IGV2 ZW50TGlzdGVuZXJzLmxlbmd0aDsgaSsrKSB7DQoJCQkJbG9nLmkoIiAgICAiICsgZXZlbnRMaXN0 ZW5lcnNbaV0pOw0KCQkJfQ0KCQl9DQoJfTsNCgkNCgljb25zb2xlLmxvZygiTVJBSUQgb2JqZWN0 IGxvYWRlZCIpOw0KDQp9KSgpOw==", 0));
      }

      MRAIDLog.d("MRAIDView", "injectMraidJs ok " + this.mraidJs.length());
      if(VERSION.SDK_INT >= 19) {
         var1.loadData("<html></html>", "text/html", "UTF-8");
         var1.evaluateJavascript(this.mraidJs, new ValueCallback() {
            public void onReceiveValue(String var1) {
            }
         });
      } else {
         var1.loadUrl("javascript:" + this.mraidJs);
      }
   }

   private void onLayoutWebView(WebView var1, boolean var2, int var3, int var4, int var5, int var6) {
      boolean var7;
      if(var1 == this.currentWebView) {
         var7 = true;
      } else {
         var7 = false;
      }

      StringBuilder var8 = new StringBuilder("onLayoutWebView ");
      String var9;
      if(var1 == this.webView) {
         var9 = "1 ";
      } else {
         var9 = "2 ";
      }

      MRAIDLog.w("MRAIDView", var8.append(var9).append(var7).append(" (").append(this.state).append(") ").append(var2).append(" ").append(var3).append(" ").append(var4).append(" ").append(var5).append(" ").append(var6).toString());
      if(!var7) {
         MRAIDLog.d("MRAIDView", "onLayoutWebView ignored, not current");
      } else {
         if(this.isForcingFullScreen) {
            MRAIDLog.d("MRAIDView", "onLayoutWebView ignored, isForcingFullScreen");
            this.isForcingFullScreen = false;
            return;
         }

         if(this.state == 0 || this.state == 1) {
            this.calculateScreenSize();
            this.calculateMaxSize();
         }

         if(!this.isClosing) {
            this.calculatePosition(true);
            if(this.isInterstitial && !this.defaultPosition.equals(this.currentPosition)) {
               this.defaultPosition = new Rect(this.currentPosition);
               this.setDefaultPosition();
            }
         }

         if(this.isExpandingFromDefault) {
            this.isExpandingFromDefault = false;
            if(this.isInterstitial) {
               this.state = 1;
               this.isLaidOut = true;
            }

            if(!this.isExpandingPart2) {
               MRAIDLog.d("MRAIDView", "calling fireStateChangeEvent 1");
               this.fireStateChangeEvent();
            }

            if(this.isInterstitial) {
               this.fireReadyEvent();
               if(this.isViewable) {
                  this.fireViewableChangeEvent();
               }
            }

            if(this.listener != null) {
               this.listener.mraidViewExpand(this);
               return;
            }
         }
      }

   }

   private void open(String var1) {
      try {
         var1 = URLDecoder.decode(var1, "UTF-8");
         MRAIDLog.d("MRAIDView-JS callback", "open " + var1);
         if(this.nativeFeatureListener != null) {
            if(var1.startsWith("sms")) {
               this.nativeFeatureListener.mraidNativeFeatureSendSms(var1);
               return;
            }

            if(var1.startsWith("tel")) {
               this.nativeFeatureListener.mraidNativeFeatureCallTel(var1);
               return;
            }

            this.nativeFeatureListener.mraidNativeFeatureOpenBrowser(var1);
         }

      } catch (UnsupportedEncodingException var2) {
         var2.printStackTrace();
      }
   }

   private void parseCommandUrl(String param1) {
      // $FF: Couldn't be decompiled
   }

   @TargetApi(11)
   private void pauseWebView(WebView var1) {
      MRAIDLog.d("MRAIDView", "pauseWebView " + var1.toString());
      if(VERSION.SDK_INT >= 11) {
         var1.onPause();
      } else {
         var1.loadUrl("about:blank");
      }
   }

   private void playVideo(String var1) {
      try {
         var1 = URLDecoder.decode(var1, "UTF-8");
         MRAIDLog.d("MRAIDView-JS callback", "playVideo " + var1);
         if(this.nativeFeatureListener != null) {
            this.nativeFeatureListener.mraidNativeFeaturePlayVideo(var1);
         }

      } catch (UnsupportedEncodingException var2) {
         var2.printStackTrace();
      }
   }

   private int px2dip(int var1) {
      return var1 * 160 / this.displayMetrics.densityDpi;
   }

   private void removeDefaultCloseButton() {
      if(this.closeRegion != null) {
         this.closeRegion.setImageResource(17170445);
      }

   }

   private void removeResizeView() {
      this.resizedView.removeAllViews();
      ((FrameLayout)((Activity)this.context).findViewById(16908290)).removeView(this.resizedView);
      this.resizedView = null;
      this.closeRegion = null;
   }

   private void resize() {
      MRAIDLog.d("MRAIDView-JS callback", "resize");
      if(this.listener != null && this.listener.mraidViewResize(this, this.resizeProperties.width, this.resizeProperties.height, this.resizeProperties.offsetX, this.resizeProperties.offsetY)) {
         this.state = 3;
         if(this.resizedView == null) {
            this.resizedView = new RelativeLayout(this.context);
            this.removeAllViews();
            this.resizedView.addView(this.webView);
            this.addCloseRegion(this.resizedView);
            ((FrameLayout)this.getRootView().findViewById(16908290)).addView(this.resizedView);
         }

         this.setCloseRegionPosition(this.resizedView);
         this.setResizedViewSize();
         this.setResizedViewPosition();
         this.handler.post(new Runnable() {
            public void run() {
               MRAIDView.this.fireStateChangeEvent();
            }
         });
      }
   }

   private void restoreOriginalOrientation() {
      MRAIDLog.d("MRAIDView", "restoreOriginalOrientation");
      Activity var1 = (Activity)this.context;
      if(var1.getRequestedOrientation() != this.originalRequestedOrientation) {
         var1.setRequestedOrientation(this.originalRequestedOrientation);
      }

   }

   @TargetApi(11)
   private void restoreOriginalScreenState() {
      Activity var1 = (Activity)this.context;
      if(!this.isFullScreen) {
         var1.getWindow().clearFlags(1024);
      }

      if(this.isForceNotFullScreen) {
         var1.getWindow().addFlags(2048);
      }

      if(VERSION.SDK_INT >= 11 && this.isActionBarShowing) {
         var1.getActionBar().show();
      } else if(this.titleBar != null) {
         this.titleBar.setVisibility(this.origTitleBarVisibility);
         return;
      }

   }

   private void setCloseRegionPosition(View var1) {
      int var2 = (int)TypedValue.applyDimension(1, 50.0F, this.displayMetrics);
      LayoutParams var3 = new LayoutParams(var2, var2);
      if(var1 == this.expandedView) {
         var3.addRule(10);
         var3.addRule(11);
      } else if(var1 == this.resizedView) {
         switch(this.resizeProperties.customClosePosition) {
         case 0:
         case 4:
            var3.addRule(9);
            break;
         case 1:
         case 3:
         case 5:
            var3.addRule(14);
            break;
         case 2:
         case 6:
            var3.addRule(11);
         }

         switch(this.resizeProperties.customClosePosition) {
         case 0:
         case 1:
         case 2:
            var3.addRule(10);
            break;
         case 3:
            var3.addRule(15);
            break;
         case 4:
         case 5:
         case 6:
            var3.addRule(12);
         }
      }

      this.closeRegion.setLayoutParams(var3);
   }

   private void setCurrentPosition() {
      int var1 = this.currentPosition.left;
      int var2 = this.currentPosition.top;
      int var3 = this.currentPosition.width();
      int var4 = this.currentPosition.height();
      MRAIDLog.d("MRAIDView", "setCurrentPosition [" + var1 + "," + var2 + "] (" + var3 + "x" + var4 + ")");
      this.injectJavaScript("mraid.setCurrentPosition(" + this.px2dip(var1) + "," + this.px2dip(var2) + "," + this.px2dip(var3) + "," + this.px2dip(var4) + ");");
   }

   private void setDefaultPosition() {
      int var1 = this.defaultPosition.left;
      int var2 = this.defaultPosition.top;
      int var3 = this.defaultPosition.width();
      int var4 = this.defaultPosition.height();
      MRAIDLog.d("MRAIDView", "setDefaultPosition [" + var1 + "," + var2 + "] (" + var3 + "x" + var4 + ")");
      this.injectJavaScript("mraid.setDefaultPosition(" + this.px2dip(var1) + "," + this.px2dip(var2) + "," + this.px2dip(var3) + "," + this.px2dip(var4) + ");");
   }

   public static void setIsJavascriptPromptsAndAlertsAllowed(boolean var0) {
      mIsJavascriptPromptsAndAlertsAllowed = var0;
   }

   private void setMaxSize() {
      MRAIDLog.d("MRAIDView", "setMaxSize");
      int var1 = this.maxSize.width;
      int var2 = this.maxSize.height;
      MRAIDLog.d("MRAIDView", "setMaxSize " + var1 + "x" + var2);
      this.injectJavaScript("mraid.setMaxSize(" + this.px2dip(var1) + "," + this.px2dip(var2) + ");");
   }

   private void setOrientationProperties(Map var1) {
      boolean var2 = Boolean.parseBoolean((String)var1.get("allowOrientationChange"));
      String var3 = (String)var1.get("forceOrientation");
      MRAIDLog.d("MRAIDView-JS callback", "setOrientationProperties " + var2 + " " + var3);
      if(this.orientationProperties.allowOrientationChange != var2 || this.orientationProperties.forceOrientation != MRAIDOrientationProperties.forceOrientationFromString(var3)) {
         this.orientationProperties.allowOrientationChange = var2;
         this.orientationProperties.forceOrientation = MRAIDOrientationProperties.forceOrientationFromString(var3);
         if(this.isInterstitial || this.state == 2) {
            this.applyOrientationProperties();
         }
      }

   }

   private void setResizeProperties(Map var1) {
      int var2 = Integer.parseInt((String)var1.get("width"));
      int var3 = Integer.parseInt((String)var1.get("height"));
      int var4 = Integer.parseInt((String)var1.get("offsetX"));
      int var5 = Integer.parseInt((String)var1.get("offsetY"));
      String var7 = (String)var1.get("customClosePosition");
      boolean var6 = Boolean.parseBoolean((String)var1.get("allowOffscreen"));
      MRAIDLog.d("MRAIDView-JS callback", "setResizeProperties " + var2 + " " + var3 + " " + var4 + " " + var5 + " " + var7 + " " + var6);
      this.resizeProperties.width = var2;
      this.resizeProperties.height = var3;
      this.resizeProperties.offsetX = var4;
      this.resizeProperties.offsetY = var5;
      this.resizeProperties.customClosePosition = MRAIDResizeProperties.customClosePositionFromString(var7);
      this.resizeProperties.allowOffscreen = var6;
   }

   private void setResizedViewPosition() {
      MRAIDLog.d("MRAIDView", "setResizedViewPosition");
      if(this.resizedView != null) {
         int var1 = this.resizeProperties.width;
         int var2 = this.resizeProperties.height;
         int var4 = this.resizeProperties.offsetX;
         int var3 = this.resizeProperties.offsetY;
         var1 = (int)TypedValue.applyDimension(1, (float)var1, this.displayMetrics);
         var2 = (int)TypedValue.applyDimension(1, (float)var2, this.displayMetrics);
         var4 = (int)TypedValue.applyDimension(1, (float)var4, this.displayMetrics);
         var3 = (int)TypedValue.applyDimension(1, (float)var3, this.displayMetrics);
         var4 += this.defaultPosition.left;
         var3 += this.defaultPosition.top;
         FrameLayout.LayoutParams var5 = (FrameLayout.LayoutParams)this.resizedView.getLayoutParams();
         var5.leftMargin = var4;
         var5.topMargin = var3;
         this.resizedView.setLayoutParams(var5);
         if(var4 != this.currentPosition.left || var3 != this.currentPosition.top || var1 != this.currentPosition.width() || var2 != this.currentPosition.height()) {
            this.currentPosition.left = var4;
            this.currentPosition.top = var3;
            this.currentPosition.right = var4 + var1;
            this.currentPosition.bottom = var2 + var3;
            this.setCurrentPosition();
            return;
         }
      }

   }

   private void setResizedViewSize() {
      MRAIDLog.d("MRAIDView", "setResizedViewSize");
      int var1 = this.resizeProperties.width;
      int var2 = this.resizeProperties.height;
      Log.d("MRAIDView", "setResizedViewSize " + var1 + "x" + var2);
      FrameLayout.LayoutParams var3 = new FrameLayout.LayoutParams((int)TypedValue.applyDimension(1, (float)var1, this.displayMetrics), (int)TypedValue.applyDimension(1, (float)var2, this.displayMetrics));
      this.resizedView.setLayoutParams(var3);
   }

   private void setScreenSize() {
      MRAIDLog.d("MRAIDView", "setScreenSize");
      int var1 = this.screenSize.width;
      int var2 = this.screenSize.height;
      MRAIDLog.d("MRAIDView", "setScreenSize " + var1 + "x" + var2);
      this.injectJavaScript("mraid.setScreenSize(" + this.px2dip(var1) + "," + this.px2dip(var2) + ");");
   }

   private void setSupportedServices() {
      MRAIDLog.d("MRAIDView", "setSupportedServices");
      this.injectJavaScript("mraid.setSupports(mraid.SUPPORTED_FEATURES.CALENDAR, " + this.nativeFeatureManager.isCalendarSupported() + ");");
      this.injectJavaScript("mraid.setSupports(mraid.SUPPORTED_FEATURES.INLINEVIDEO, " + this.nativeFeatureManager.isInlineVideoSupported() + ");");
      this.injectJavaScript("mraid.setSupports(mraid.SUPPORTED_FEATURES.SMS, " + this.nativeFeatureManager.isSmsSupported() + ");");
      this.injectJavaScript("mraid.setSupports(mraid.SUPPORTED_FEATURES.STOREPICTURE, " + this.nativeFeatureManager.isStorePictureSupported() + ");");
      this.injectJavaScript("mraid.setSupports(mraid.SUPPORTED_FEATURES.TEL, " + this.nativeFeatureManager.isTelSupported() + ");");
   }

   private void setViewable(int var1) {
      boolean var2;
      if(var1 == 0) {
         var2 = true;
      } else {
         var2 = false;
      }

      if(var2 != this.isViewable) {
         this.isViewable = var2;
         if(this.isPageFinished && this.isLaidOut) {
            this.fireViewableChangeEvent();
         }
      }

   }

   private void showDefaultCloseButton() {
      if(this.closeRegion != null) {
         Drawable var1 = Assets.getDrawableFromBase64(this.getResources(), "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 AAAASUVORK5CYII=");
         Drawable var2 = Assets.getDrawableFromBase64(this.getResources(), "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 4RT5f02O5nnLDJUQAAAAAElFTkSuQmCC");
         StateListDrawable var3 = new StateListDrawable();
         var3.addState(new int[]{-16842919}, var1);
         var3.addState(new int[]{16842919}, var2);
         this.closeRegion.setImageDrawable(var3);
         this.closeRegion.setScaleType(ScaleType.CENTER_CROP);
      }

   }

   private void storePicture(String var1) {
      try {
         var1 = URLDecoder.decode(var1, "UTF-8");
         MRAIDLog.d("MRAIDView-JS callback", "storePicture " + var1);
         if(this.nativeFeatureListener != null) {
            this.nativeFeatureListener.mraidNativeFeatureStorePicture(var1);
         }

      } catch (UnsupportedEncodingException var2) {
         var2.printStackTrace();
      }
   }

   private void useCustomClose(String var1) {
      MRAIDLog.d("MRAIDView-JS callback", "useCustomClose " + var1);
      boolean var2 = Boolean.parseBoolean(var1);
      if(this.useCustomClose != var2) {
         this.useCustomClose = var2;
         if(!var2) {
            this.showDefaultCloseButton();
            return;
         }

         this.removeDefaultCloseButton();
      }

   }

   public void clearView() {
      if(this.webView != null) {
         this.webView.setWebChromeClient((WebChromeClient)null);
         this.webView.setWebViewClient((WebViewClient)null);
         this.webView.loadUrl("about:blank");
      }

   }

   public void destroy() {
      if(this.webView != null) {
         this.webView.setWebChromeClient((WebChromeClient)null);
         this.webView.setWebViewClient((WebViewClient)null);
         this.webView.destroy();
         this.webView = null;
      }

   }

   public int getState() {
      return this.state;
   }

   protected void onAttachedToWindow() {
      MRAIDLog.d("MRAIDView", "onAttachedToWindow");
      super.onAttachedToWindow();
   }

   public void onConfigurationChanged(Configuration var1) {
      super.onConfigurationChanged(var1);
      StringBuilder var2 = new StringBuilder("onConfigurationChanged ");
      String var3;
      if(var1.orientation == 1) {
         var3 = "portrait";
      } else {
         var3 = "landscape";
      }

      MRAIDLog.d("MRAIDView", var2.append(var3).toString());
      ((Activity)this.context).getWindowManager().getDefaultDisplay().getMetrics(this.displayMetrics);
   }

   protected void onDetachedFromWindow() {
      MRAIDLog.d("MRAIDView", "onDetachedFromWindow");
      super.onDetachedFromWindow();
   }

   @SuppressLint({"DrawAllocation"})
   protected void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      super.onLayout(var1, var2, var3, var4, var5);
      MRAIDLog.w("MRAIDView", "onLayout (" + this.state + ") " + var1 + " " + var2 + " " + var3 + " " + var4 + " " + var5);
      if(this.isForcingFullScreen) {
         MRAIDLog.d("MRAIDView", "onLayout ignored");
      } else {
         if(this.state == 2 || this.state == 3) {
            this.calculateScreenSize();
            this.calculateMaxSize();
         }

         if(this.isClosing) {
            this.isClosing = false;
            this.currentPosition = new Rect(this.defaultPosition);
            this.setCurrentPosition();
         } else {
            this.calculatePosition(false);
         }

         if(this.state == 3 && var1) {
            this.handler.post(new Runnable() {
               public void run() {
                  MRAIDView.this.setResizedViewPosition();
               }
            });
         }

         this.isLaidOut = true;
         if(this.state == 0 && this.isPageFinished && !this.isInterstitial) {
            this.state = 1;
            this.fireStateChangeEvent();
            this.fireReadyEvent();
            if(this.isViewable) {
               this.fireViewableChangeEvent();
               return;
            }
         }
      }

   }

   @SuppressLint({"ClickableViewAccessibility"})
   public boolean onTouchEvent(MotionEvent var1) {
      if(this.gestureDetector.onTouchEvent(var1)) {
         var1.setAction(3);
      }

      return super.onTouchEvent(var1);
   }

   protected void onVisibilityChanged(View var1, int var2) {
      super.onVisibilityChanged(var1, var2);
      MRAIDLog.d("MRAIDView", "onVisibilityChanged " + getVisibilityString(var2));
      this.setViewable(var2);
   }

   protected void onWindowVisibilityChanged(int var1) {
      super.onWindowVisibilityChanged(var1);
      int var2 = this.getVisibility();
      MRAIDLog.d("MRAIDView", "onWindowVisibilityChanged " + getVisibilityString(var1) + " (actual " + getVisibilityString(var2) + ")");
      this.setViewable(var2);
   }

   protected void showAsInterstitial() {
      this.expand((String)null);
   }
}
