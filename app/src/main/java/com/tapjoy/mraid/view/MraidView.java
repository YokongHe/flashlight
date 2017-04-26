package com.tapjoy.mraid.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.VideoView;
import com.tapjoy.TapjoyCache;
import com.tapjoy.TapjoyCacheMap;
import com.tapjoy.TapjoyCachedAssetData;
import com.tapjoy.TapjoyHttpURLResponse;
import com.tapjoy.TapjoyLog;
import com.tapjoy.TapjoyURLConnection;
import com.tapjoy.TapjoyUtil;
import com.tapjoy.mraid.controller.Abstract$Dimensions;
import com.tapjoy.mraid.controller.Abstract$PlayerProperties;
import com.tapjoy.mraid.controller.Abstract$Properties;
import com.tapjoy.mraid.controller.Utility;
import com.tapjoy.mraid.listener.MraidViewListener;
import com.tapjoy.mraid.listener.Player;
import com.tapjoy.mraid.util.MraidPlayer;
import com.tapjoy.mraid.util.Utils;
import com.tapjoy.mraid.view.ActionHandler;
import com.tapjoy.mraid.view.Browser;
import com.tapjoy.mraid.view.MraidView$Action;
import com.tapjoy.mraid.view.MraidView$PLACEMENT_TYPE;
import com.tapjoy.mraid.view.MraidView$VIEW_STATE;
import com.tapjoy.mraid.view.MraidView$a;
import com.tapjoy.mraid.view.MraidView$b;
import com.tapjoy.mraid.view.MraidView$c;
import com.tapjoy.mraid.view.MraidView$customCloseState;
import com.tapjoy.mraid.view.MraidView$d;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MraidView extends WebView implements OnGlobalLayoutListener {
   public static final String ACTION_KEY = "action";
   public static final String DIMENSIONS = "expand_dimensions";
   public static final String EXPAND_URL = "expand_url";
   public static final int MRAID_ID = 102;
   public static final String PLAYER_PROPERTIES = "player_properties";
   private static int[] c = new int[]{16843039, 16843040};
   private static final String[] d = new String[]{".mp4", ".3gp", ".mpg"};
   private static String f;
   private static MraidPlayer x;
   private int A;
   private Thread B;
   private boolean C;
   private int D;
   private Context E;
   private RelativeLayout F;
   private VideoView G;
   private CustomViewCallback H;
   private ProgressBar I;
   private Handler J;
   private boolean K;
   WebViewClient a;
   WebChromeClient b;
   private MraidView$customCloseState e;
   private String g;
   private boolean h;
   private boolean i;
   private boolean j;
   private Utility k;
   private float l;
   private int m;
   private boolean n;
   private int o;
   private int p;
   private int q;
   private int r;
   private int s;
   private MraidView$PLACEMENT_TYPE t;
   private GestureDetector u;
   private MraidView$VIEW_STATE v;
   private MraidViewListener w;
   private final HashSet y;
   private int z;

   public MraidView(Context var1) {
      super(var1);
      this.e = MraidView$customCloseState.UNKNOWN;
      this.g = null;
      this.h = true;
      this.i = false;
      this.v = MraidView$VIEW_STATE.DEFAULT;
      this.y = new HashSet();
      this.z = 0;
      this.A = 0;
      this.B = null;
      this.C = false;
      this.J = new Handler() {
         public final void handleMessage(Message var1) {
            Bundle var2 = var1.getData();
            MarginLayoutParams var3;
            String var5;
            label44:
            switch(var1.what) {
            case 1000:
               var3 = (MarginLayoutParams)MraidView.this.getLayoutParams();
               if(var3 != null) {
                  MraidView.this.removeCloseImageButton();
                  MraidView.this.v = MraidView$VIEW_STATE.RESIZED;
                  var3.height = var2.getInt("resize_height", var3.height);
                  var3.width = var2.getInt("resize_width", var3.width);
                  var3.leftMargin = var2.getInt("resize_x", var3.leftMargin);
                  var3.topMargin = var2.getInt("resize_y", var3.topMargin);
                  var5 = "window.mraidview.fireChangeEvent({ state: \'resized\', size: { width: " + var3.width + ", height: " + var3.height + ", x: " + var3.leftMargin + ", y: " + var3.topMargin + "}});";
                  MraidView.this.injectMraidJavaScript(var5);
                  MraidView.this.requestLayout();
                  MraidView.this.b(var2.getString("resize_customClosePostition"));
                  MraidView.this.showCloseImageButton();
               }

               if(MraidView.this.w != null) {
                  MraidView.this.w.onResize();
               }
               break;
            case 1001:
               switch(null.a[MraidView.this.v.ordinal()]) {
               case 1:
                  MraidView.this.b();
                  break label44;
               case 2:
                  MraidView.this.a();
                  break label44;
               case 3:
                  if(MraidView.this.t != MraidView$PLACEMENT_TYPE.INLINE) {
                     MraidView.g(MraidView.this);
                  }
               default:
                  break label44;
               }
            case 1002:
               MraidView.this.setVisibility(4);
               MraidView.this.injectMraidJavaScript("window.mraidview.fireChangeEvent({ state: \'hidden\' });");
               break;
            case 1003:
               MraidView.this.injectMraidJavaScript("window.mraidview.fireChangeEvent({ state: \'default\' });");
               MraidView.this.setVisibility(0);
               break;
            case 1004:
               MraidView.a(MraidView.this, var2);
               break;
            case 1005:
               if(MraidView.this.w != null) {
                  MraidView.this.w.onExpandClose();
               }
               break;
            case 1006:
               MraidView.this.v = MraidView$VIEW_STATE.LEFT_BEHIND;
               break;
            case 1007:
               MraidView.this.playVideoImpl(var2);
               break;
            case 1008:
               MraidView.this.playAudioImpl(var2);
               break;
            case 1009:
               var5 = var2.getString("message");
               String var4 = var2.getString("action");
               var4 = "window.mraidview.fireErrorEvent(\"" + var5 + "\", \"" + var4 + "\")";
               MraidView.this.injectMraidJavaScript(var4);
               break;
            case 1010:
               var3 = (MarginLayoutParams)MraidView.this.getLayoutParams();
               if(var3 != null) {
                  MraidView.this.removeCloseImageButton();
                  var3.height = var2.getInt("resize_height", var3.height);
                  var3.width = var2.getInt("resize_width", var3.width);
                  var5 = "window.mraidview.fireChangeEvent({ state: \'" + MraidView.this.getState() + "\', size: { width: " + (int)((float)var3.width / MraidView.this.l) + ", height: " + (int)((float)var3.height / MraidView.this.l) + "}});";
                  TapjoyLog.i("MRAIDView", "resize: injection: " + var5);
                  MraidView.this.injectMraidJavaScript(var5);
                  MraidView.this.requestLayout();
                  MraidView.this.b(var2.getString("resize_customClosePostition"));
                  if(MraidView.this.t != MraidView$PLACEMENT_TYPE.INLINE && MraidView.this.e == MraidView$customCloseState.OPEN) {
                     MraidView.this.showCloseImageButton();
                  }
               }

               if(MraidView.this.w != null) {
                  MraidView.this.w.onResize();
               }
            }

            super.handleMessage(var1);
         }
      };
      this.a = new WebViewClient() {
         public final void onLoadResource(WebView var1, String var2) {
         }

         public final void onPageFinished(WebView var1, String var2) {
            if(MraidView.this.w != null) {
               MraidView.this.w.onPageFinished(var1, var2);
            }

            MraidView.this.o = (int)((float)MraidView.this.getHeight() / MraidView.this.l);
            MraidView.this.p = (int)((float)MraidView.this.getWidth() / MraidView.this.l);
            MraidView.this.k.init(MraidView.this.l);
            MraidView.this.createCloseImageButton();
            if(MraidView.this.t == MraidView$PLACEMENT_TYPE.INLINE) {
               MraidView.this.removeCloseImageButton();
            }

         }

         public final void onPageStarted(WebView var1, String var2, Bitmap var3) {
            if(MraidView.this.w != null) {
               MraidView.this.w.onPageStarted(var1, var2, var3);
            }

         }

         public final void onReceivedError(WebView var1, int var2, String var3, String var4) {
            if(MraidView.this.w != null) {
               MraidView.this.w.onReceivedError(var1, var2, var3, var4);
            }

            TapjoyLog.d("MRAIDView", "error:" + var3);
            super.onReceivedError(var1, var2, var3, var4);
         }

         public final WebResourceResponse shouldInterceptRequest(WebView var1, String var2) {
            if(TapjoyCache.getInstance() != null) {
               TapjoyCacheMap var3 = TapjoyCache.getInstance().getCachedData();
               if(var3.containsKey(var2)) {
                  if((new File(((TapjoyCachedAssetData)var3.get(var2)).getLocalFilePath())).exists()) {
                     MraidView var4 = MraidView.this;
                     WebResourceResponse var5 = MraidView.c(var2);
                     if(var5 != null) {
                        return var5;
                     }
                  } else {
                     TapjoyCache.getInstance().removeAssetFromCache(var2);
                  }
               }
            }

            return super.shouldInterceptRequest(var1, var2);
         }

         public final boolean shouldOverrideUrlLoading(WebView var1, String var2) {
            TapjoyLog.i("MRAIDView", "shouldOverrideUrlLoading: " + var2);
            if(MraidView.this.w != null && MraidView.this.w.shouldOverrideUrlLoading(var1, var2)) {
               return true;
            } else {
               Uri var3 = Uri.parse(var2);

               Intent var6;
               try {
                  if(var2.startsWith("mraid")) {
                     return super.shouldOverrideUrlLoading(var1, var2);
                  } else if(var2.startsWith("tel:")) {
                     var6 = new Intent("android.intent.action.DIAL", Uri.parse(var2));
                     var6.addFlags(268435456);
                     MraidView.this.getContext().startActivity(var6);
                     return true;
                  } else if(var2.startsWith("mailto:")) {
                     var6 = new Intent("android.intent.action.VIEW", Uri.parse(var2));
                     var6.addFlags(268435456);
                     MraidView.this.getContext().startActivity(var6);
                     return true;
                  } else {
                     var6 = new Intent();
                     var6.setAction("android.intent.action.VIEW");
                     var6.setData(var3);
                     var6.addFlags(268435456);
                     MraidView.this.getContext().startActivity(var6);
                     return true;
                  }
               } catch (Exception var5) {
                  try {
                     var6 = new Intent();
                     var6.setAction("android.intent.action.VIEW");
                     var6.setData(var3);
                     var6.addFlags(268435456);
                     MraidView.this.getContext().startActivity(var6);
                     return true;
                  } catch (Exception var4) {
                     return false;
                  }
               }
            }
         }
      };
      this.b = new WebChromeClient() {
         public final void onCloseWindow(WebView var1) {
            super.onCloseWindow(var1);
            MraidView.g(MraidView.this);
         }

         public final boolean onConsoleMessage(ConsoleMessage var1) {
            return MraidView.this.w != null?MraidView.this.w.onConsoleMessage(var1):super.onConsoleMessage(var1);
         }

         public final void onHideCustomView() {
            super.onHideCustomView();
         }

         public final boolean onJsAlert(WebView var1, String var2, String var3, JsResult var4) {
            TapjoyLog.d("MRAIDView", var3);
            return false;
         }

         public final void onShowCustomView(View var1, CustomViewCallback var2) {
            TapjoyLog.i("MRAIDView", "-- onShowCustomView --");
            super.onShowCustomView(var1, var2);
            MraidView.this.H = var2;
            if(var1 instanceof FrameLayout) {
               FrameLayout var4 = (FrameLayout)var1;
               if(var4.getFocusedChild() instanceof VideoView && MraidView.this.E instanceof Activity) {
                  Activity var3 = (Activity)MraidView.this.E;
                  MraidView.this.G = (VideoView)var4.getFocusedChild();
                  var4.removeView(MraidView.this.G);
                  if(MraidView.this.F == null) {
                     MraidView.this.F = new RelativeLayout(MraidView.this.E);
                     MraidView.this.F.setLayoutParams(new LayoutParams(-1, -1));
                     MraidView.this.F.setBackgroundColor(-16777216);
                  }

                  android.widget.RelativeLayout.LayoutParams var5 = new android.widget.RelativeLayout.LayoutParams(-1, -1);
                  var5.addRule(13);
                  MraidView.this.G.setLayoutParams(var5);
                  MraidView.this.I = new ProgressBar(MraidView.this.E, (AttributeSet)null, 16842874);
                  MraidView.this.I.setVisibility(0);
                  var5 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
                  var5.addRule(13);
                  MraidView.this.I.setLayoutParams(var5);
                  MraidView.this.F.addView(MraidView.this.G);
                  MraidView.this.F.addView(MraidView.this.I);
                  var3.getWindow().addContentView(MraidView.this.F, new LayoutParams(-1, -1));
                  (new Thread(new MraidView$d(MraidView.this))).start();
                  MraidView.this.setVisibility(8);
                  MraidView.this.G.setOnPreparedListener(new OnPreparedListener() {
                     public final void onPrepared(MediaPlayer var1) {
                        TapjoyLog.i("MRAIDView", "** ON PREPARED **");
                        TapjoyLog.i("MRAIDView", "isPlaying: " + var1.isPlaying());
                        if(!var1.isPlaying()) {
                           var1.start();
                        }

                     }
                  });
                  MraidView.this.G.setOnCompletionListener(new OnCompletionListener() {
                     public final void onCompletion(MediaPlayer var1) {
                        TapjoyLog.i("MRAIDView", "** ON COMPLETION **");
                        MraidView.this.videoViewCleanup();
                     }
                  });
                  MraidView.this.G.setOnErrorListener(new OnErrorListener() {
                     public final boolean onError(MediaPlayer var1, int var2, int var3) {
                        TapjoyLog.i("MRAIDView", "** ON ERROR **");
                        MraidView.this.videoViewCleanup();
                        return false;
                     }
                  });
                  MraidView.this.G.start();
                  return;
               }
            }

         }
      };
      this.E = var1;
      this.initialize();
   }

   public MraidView(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.e = MraidView$customCloseState.UNKNOWN;
      this.g = null;
      this.h = true;
      this.i = false;
      this.v = MraidView$VIEW_STATE.DEFAULT;
      this.y = new HashSet();
      this.z = 0;
      this.A = 0;
      this.B = null;
      this.C = false;
      this.J = new Handler() {
         public final void handleMessage(Message var1) {
            Bundle var2 = var1.getData();
            MarginLayoutParams var3;
            String var5;
            label44:
            switch(var1.what) {
            case 1000:
               var3 = (MarginLayoutParams)MraidView.this.getLayoutParams();
               if(var3 != null) {
                  MraidView.this.removeCloseImageButton();
                  MraidView.this.v = MraidView$VIEW_STATE.RESIZED;
                  var3.height = var2.getInt("resize_height", var3.height);
                  var3.width = var2.getInt("resize_width", var3.width);
                  var3.leftMargin = var2.getInt("resize_x", var3.leftMargin);
                  var3.topMargin = var2.getInt("resize_y", var3.topMargin);
                  var5 = "window.mraidview.fireChangeEvent({ state: \'resized\', size: { width: " + var3.width + ", height: " + var3.height + ", x: " + var3.leftMargin + ", y: " + var3.topMargin + "}});";
                  MraidView.this.injectMraidJavaScript(var5);
                  MraidView.this.requestLayout();
                  MraidView.this.b(var2.getString("resize_customClosePostition"));
                  MraidView.this.showCloseImageButton();
               }

               if(MraidView.this.w != null) {
                  MraidView.this.w.onResize();
               }
               break;
            case 1001:
               switch(null.a[MraidView.this.v.ordinal()]) {
               case 1:
                  MraidView.this.b();
                  break label44;
               case 2:
                  MraidView.this.a();
                  break label44;
               case 3:
                  if(MraidView.this.t != MraidView$PLACEMENT_TYPE.INLINE) {
                     MraidView.g(MraidView.this);
                  }
               default:
                  break label44;
               }
            case 1002:
               MraidView.this.setVisibility(4);
               MraidView.this.injectMraidJavaScript("window.mraidview.fireChangeEvent({ state: \'hidden\' });");
               break;
            case 1003:
               MraidView.this.injectMraidJavaScript("window.mraidview.fireChangeEvent({ state: \'default\' });");
               MraidView.this.setVisibility(0);
               break;
            case 1004:
               MraidView.a(MraidView.this, var2);
               break;
            case 1005:
               if(MraidView.this.w != null) {
                  MraidView.this.w.onExpandClose();
               }
               break;
            case 1006:
               MraidView.this.v = MraidView$VIEW_STATE.LEFT_BEHIND;
               break;
            case 1007:
               MraidView.this.playVideoImpl(var2);
               break;
            case 1008:
               MraidView.this.playAudioImpl(var2);
               break;
            case 1009:
               var5 = var2.getString("message");
               String var4 = var2.getString("action");
               var4 = "window.mraidview.fireErrorEvent(\"" + var5 + "\", \"" + var4 + "\")";
               MraidView.this.injectMraidJavaScript(var4);
               break;
            case 1010:
               var3 = (MarginLayoutParams)MraidView.this.getLayoutParams();
               if(var3 != null) {
                  MraidView.this.removeCloseImageButton();
                  var3.height = var2.getInt("resize_height", var3.height);
                  var3.width = var2.getInt("resize_width", var3.width);
                  var5 = "window.mraidview.fireChangeEvent({ state: \'" + MraidView.this.getState() + "\', size: { width: " + (int)((float)var3.width / MraidView.this.l) + ", height: " + (int)((float)var3.height / MraidView.this.l) + "}});";
                  TapjoyLog.i("MRAIDView", "resize: injection: " + var5);
                  MraidView.this.injectMraidJavaScript(var5);
                  MraidView.this.requestLayout();
                  MraidView.this.b(var2.getString("resize_customClosePostition"));
                  if(MraidView.this.t != MraidView$PLACEMENT_TYPE.INLINE && MraidView.this.e == MraidView$customCloseState.OPEN) {
                     MraidView.this.showCloseImageButton();
                  }
               }

               if(MraidView.this.w != null) {
                  MraidView.this.w.onResize();
               }
            }

            super.handleMessage(var1);
         }
      };
      this.a = new WebViewClient() {
         public final void onLoadResource(WebView var1, String var2) {
         }

         public final void onPageFinished(WebView var1, String var2) {
            if(MraidView.this.w != null) {
               MraidView.this.w.onPageFinished(var1, var2);
            }

            MraidView.this.o = (int)((float)MraidView.this.getHeight() / MraidView.this.l);
            MraidView.this.p = (int)((float)MraidView.this.getWidth() / MraidView.this.l);
            MraidView.this.k.init(MraidView.this.l);
            MraidView.this.createCloseImageButton();
            if(MraidView.this.t == MraidView$PLACEMENT_TYPE.INLINE) {
               MraidView.this.removeCloseImageButton();
            }

         }

         public final void onPageStarted(WebView var1, String var2, Bitmap var3) {
            if(MraidView.this.w != null) {
               MraidView.this.w.onPageStarted(var1, var2, var3);
            }

         }

         public final void onReceivedError(WebView var1, int var2, String var3, String var4) {
            if(MraidView.this.w != null) {
               MraidView.this.w.onReceivedError(var1, var2, var3, var4);
            }

            TapjoyLog.d("MRAIDView", "error:" + var3);
            super.onReceivedError(var1, var2, var3, var4);
         }

         public final WebResourceResponse shouldInterceptRequest(WebView var1, String var2) {
            if(TapjoyCache.getInstance() != null) {
               TapjoyCacheMap var3 = TapjoyCache.getInstance().getCachedData();
               if(var3.containsKey(var2)) {
                  if((new File(((TapjoyCachedAssetData)var3.get(var2)).getLocalFilePath())).exists()) {
                     MraidView var4 = MraidView.this;
                     WebResourceResponse var5 = MraidView.c(var2);
                     if(var5 != null) {
                        return var5;
                     }
                  } else {
                     TapjoyCache.getInstance().removeAssetFromCache(var2);
                  }
               }
            }

            return super.shouldInterceptRequest(var1, var2);
         }

         public final boolean shouldOverrideUrlLoading(WebView var1, String var2) {
            TapjoyLog.i("MRAIDView", "shouldOverrideUrlLoading: " + var2);
            if(MraidView.this.w != null && MraidView.this.w.shouldOverrideUrlLoading(var1, var2)) {
               return true;
            } else {
               Uri var3 = Uri.parse(var2);

               Intent var6;
               try {
                  if(var2.startsWith("mraid")) {
                     return super.shouldOverrideUrlLoading(var1, var2);
                  } else if(var2.startsWith("tel:")) {
                     var6 = new Intent("android.intent.action.DIAL", Uri.parse(var2));
                     var6.addFlags(268435456);
                     MraidView.this.getContext().startActivity(var6);
                     return true;
                  } else if(var2.startsWith("mailto:")) {
                     var6 = new Intent("android.intent.action.VIEW", Uri.parse(var2));
                     var6.addFlags(268435456);
                     MraidView.this.getContext().startActivity(var6);
                     return true;
                  } else {
                     var6 = new Intent();
                     var6.setAction("android.intent.action.VIEW");
                     var6.setData(var3);
                     var6.addFlags(268435456);
                     MraidView.this.getContext().startActivity(var6);
                     return true;
                  }
               } catch (Exception var5) {
                  try {
                     var6 = new Intent();
                     var6.setAction("android.intent.action.VIEW");
                     var6.setData(var3);
                     var6.addFlags(268435456);
                     MraidView.this.getContext().startActivity(var6);
                     return true;
                  } catch (Exception var4) {
                     return false;
                  }
               }
            }
         }
      };
      this.b = new WebChromeClient() {
         public final void onCloseWindow(WebView var1) {
            super.onCloseWindow(var1);
            MraidView.g(MraidView.this);
         }

         public final boolean onConsoleMessage(ConsoleMessage var1) {
            return MraidView.this.w != null?MraidView.this.w.onConsoleMessage(var1):super.onConsoleMessage(var1);
         }

         public final void onHideCustomView() {
            super.onHideCustomView();
         }

         public final boolean onJsAlert(WebView var1, String var2, String var3, JsResult var4) {
            TapjoyLog.d("MRAIDView", var3);
            return false;
         }

         public final void onShowCustomView(View var1, CustomViewCallback var2) {
            TapjoyLog.i("MRAIDView", "-- onShowCustomView --");
            super.onShowCustomView(var1, var2);
            MraidView.this.H = var2;
            if(var1 instanceof FrameLayout) {
               FrameLayout var4 = (FrameLayout)var1;
               if(var4.getFocusedChild() instanceof VideoView && MraidView.this.E instanceof Activity) {
                  Activity var3 = (Activity)MraidView.this.E;
                  MraidView.this.G = (VideoView)var4.getFocusedChild();
                  var4.removeView(MraidView.this.G);
                  if(MraidView.this.F == null) {
                     MraidView.this.F = new RelativeLayout(MraidView.this.E);
                     MraidView.this.F.setLayoutParams(new LayoutParams(-1, -1));
                     MraidView.this.F.setBackgroundColor(-16777216);
                  }

                  android.widget.RelativeLayout.LayoutParams var5 = new android.widget.RelativeLayout.LayoutParams(-1, -1);
                  var5.addRule(13);
                  MraidView.this.G.setLayoutParams(var5);
                  MraidView.this.I = new ProgressBar(MraidView.this.E, (AttributeSet)null, 16842874);
                  MraidView.this.I.setVisibility(0);
                  var5 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
                  var5.addRule(13);
                  MraidView.this.I.setLayoutParams(var5);
                  MraidView.this.F.addView(MraidView.this.G);
                  MraidView.this.F.addView(MraidView.this.I);
                  var3.getWindow().addContentView(MraidView.this.F, new LayoutParams(-1, -1));
                  (new Thread(new MraidView$d(MraidView.this))).start();
                  MraidView.this.setVisibility(8);
                  MraidView.this.G.setOnPreparedListener(new OnPreparedListener() {
                     public final void onPrepared(MediaPlayer var1) {
                        TapjoyLog.i("MRAIDView", "** ON PREPARED **");
                        TapjoyLog.i("MRAIDView", "isPlaying: " + var1.isPlaying());
                        if(!var1.isPlaying()) {
                           var1.start();
                        }

                     }
                  });
                  MraidView.this.G.setOnCompletionListener(new OnCompletionListener() {
                     public final void onCompletion(MediaPlayer var1) {
                        TapjoyLog.i("MRAIDView", "** ON COMPLETION **");
                        MraidView.this.videoViewCleanup();
                     }
                  });
                  MraidView.this.G.setOnErrorListener(new OnErrorListener() {
                     public final boolean onError(MediaPlayer var1, int var2, int var3) {
                        TapjoyLog.i("MRAIDView", "** ON ERROR **");
                        MraidView.this.videoViewCleanup();
                        return false;
                     }
                  });
                  MraidView.this.G.start();
                  return;
               }
            }

         }
      };
      this.initialize();
      TypedArray var5 = this.getContext().obtainStyledAttributes(var2, c);
      int var3 = var5.getDimensionPixelSize(0, -1);
      int var4 = var5.getDimensionPixelSize(1, -1);
      if(var3 > 0 && var4 > 0) {
         this.k.setMaxSize(var3, var4);
      }

      var5.recycle();
   }

   public MraidView(Context var1, MraidViewListener var2) {
      super(var1);
      this.e = MraidView$customCloseState.UNKNOWN;
      this.g = null;
      this.h = true;
      this.i = false;
      this.v = MraidView$VIEW_STATE.DEFAULT;
      this.y = new HashSet();
      this.z = 0;
      this.A = 0;
      this.B = null;
      this.C = false;
      this.J = new Handler() {
         public final void handleMessage(Message var1) {
            Bundle var2 = var1.getData();
            MarginLayoutParams var3;
            String var5;
            label44:
            switch(var1.what) {
            case 1000:
               var3 = (MarginLayoutParams)MraidView.this.getLayoutParams();
               if(var3 != null) {
                  MraidView.this.removeCloseImageButton();
                  MraidView.this.v = MraidView$VIEW_STATE.RESIZED;
                  var3.height = var2.getInt("resize_height", var3.height);
                  var3.width = var2.getInt("resize_width", var3.width);
                  var3.leftMargin = var2.getInt("resize_x", var3.leftMargin);
                  var3.topMargin = var2.getInt("resize_y", var3.topMargin);
                  var5 = "window.mraidview.fireChangeEvent({ state: \'resized\', size: { width: " + var3.width + ", height: " + var3.height + ", x: " + var3.leftMargin + ", y: " + var3.topMargin + "}});";
                  MraidView.this.injectMraidJavaScript(var5);
                  MraidView.this.requestLayout();
                  MraidView.this.b(var2.getString("resize_customClosePostition"));
                  MraidView.this.showCloseImageButton();
               }

               if(MraidView.this.w != null) {
                  MraidView.this.w.onResize();
               }
               break;
            case 1001:
               switch(null.a[MraidView.this.v.ordinal()]) {
               case 1:
                  MraidView.this.b();
                  break label44;
               case 2:
                  MraidView.this.a();
                  break label44;
               case 3:
                  if(MraidView.this.t != MraidView$PLACEMENT_TYPE.INLINE) {
                     MraidView.g(MraidView.this);
                  }
               default:
                  break label44;
               }
            case 1002:
               MraidView.this.setVisibility(4);
               MraidView.this.injectMraidJavaScript("window.mraidview.fireChangeEvent({ state: \'hidden\' });");
               break;
            case 1003:
               MraidView.this.injectMraidJavaScript("window.mraidview.fireChangeEvent({ state: \'default\' });");
               MraidView.this.setVisibility(0);
               break;
            case 1004:
               MraidView.a(MraidView.this, var2);
               break;
            case 1005:
               if(MraidView.this.w != null) {
                  MraidView.this.w.onExpandClose();
               }
               break;
            case 1006:
               MraidView.this.v = MraidView$VIEW_STATE.LEFT_BEHIND;
               break;
            case 1007:
               MraidView.this.playVideoImpl(var2);
               break;
            case 1008:
               MraidView.this.playAudioImpl(var2);
               break;
            case 1009:
               var5 = var2.getString("message");
               String var4 = var2.getString("action");
               var4 = "window.mraidview.fireErrorEvent(\"" + var5 + "\", \"" + var4 + "\")";
               MraidView.this.injectMraidJavaScript(var4);
               break;
            case 1010:
               var3 = (MarginLayoutParams)MraidView.this.getLayoutParams();
               if(var3 != null) {
                  MraidView.this.removeCloseImageButton();
                  var3.height = var2.getInt("resize_height", var3.height);
                  var3.width = var2.getInt("resize_width", var3.width);
                  var5 = "window.mraidview.fireChangeEvent({ state: \'" + MraidView.this.getState() + "\', size: { width: " + (int)((float)var3.width / MraidView.this.l) + ", height: " + (int)((float)var3.height / MraidView.this.l) + "}});";
                  TapjoyLog.i("MRAIDView", "resize: injection: " + var5);
                  MraidView.this.injectMraidJavaScript(var5);
                  MraidView.this.requestLayout();
                  MraidView.this.b(var2.getString("resize_customClosePostition"));
                  if(MraidView.this.t != MraidView$PLACEMENT_TYPE.INLINE && MraidView.this.e == MraidView$customCloseState.OPEN) {
                     MraidView.this.showCloseImageButton();
                  }
               }

               if(MraidView.this.w != null) {
                  MraidView.this.w.onResize();
               }
            }

            super.handleMessage(var1);
         }
      };
      this.a = new WebViewClient() {
         public final void onLoadResource(WebView var1, String var2) {
         }

         public final void onPageFinished(WebView var1, String var2) {
            if(MraidView.this.w != null) {
               MraidView.this.w.onPageFinished(var1, var2);
            }

            MraidView.this.o = (int)((float)MraidView.this.getHeight() / MraidView.this.l);
            MraidView.this.p = (int)((float)MraidView.this.getWidth() / MraidView.this.l);
            MraidView.this.k.init(MraidView.this.l);
            MraidView.this.createCloseImageButton();
            if(MraidView.this.t == MraidView$PLACEMENT_TYPE.INLINE) {
               MraidView.this.removeCloseImageButton();
            }

         }

         public final void onPageStarted(WebView var1, String var2, Bitmap var3) {
            if(MraidView.this.w != null) {
               MraidView.this.w.onPageStarted(var1, var2, var3);
            }

         }

         public final void onReceivedError(WebView var1, int var2, String var3, String var4) {
            if(MraidView.this.w != null) {
               MraidView.this.w.onReceivedError(var1, var2, var3, var4);
            }

            TapjoyLog.d("MRAIDView", "error:" + var3);
            super.onReceivedError(var1, var2, var3, var4);
         }

         public final WebResourceResponse shouldInterceptRequest(WebView var1, String var2) {
            if(TapjoyCache.getInstance() != null) {
               TapjoyCacheMap var3 = TapjoyCache.getInstance().getCachedData();
               if(var3.containsKey(var2)) {
                  if((new File(((TapjoyCachedAssetData)var3.get(var2)).getLocalFilePath())).exists()) {
                     MraidView var4 = MraidView.this;
                     WebResourceResponse var5 = MraidView.c(var2);
                     if(var5 != null) {
                        return var5;
                     }
                  } else {
                     TapjoyCache.getInstance().removeAssetFromCache(var2);
                  }
               }
            }

            return super.shouldInterceptRequest(var1, var2);
         }

         public final boolean shouldOverrideUrlLoading(WebView var1, String var2) {
            TapjoyLog.i("MRAIDView", "shouldOverrideUrlLoading: " + var2);
            if(MraidView.this.w != null && MraidView.this.w.shouldOverrideUrlLoading(var1, var2)) {
               return true;
            } else {
               Uri var3 = Uri.parse(var2);

               Intent var6;
               try {
                  if(var2.startsWith("mraid")) {
                     return super.shouldOverrideUrlLoading(var1, var2);
                  } else if(var2.startsWith("tel:")) {
                     var6 = new Intent("android.intent.action.DIAL", Uri.parse(var2));
                     var6.addFlags(268435456);
                     MraidView.this.getContext().startActivity(var6);
                     return true;
                  } else if(var2.startsWith("mailto:")) {
                     var6 = new Intent("android.intent.action.VIEW", Uri.parse(var2));
                     var6.addFlags(268435456);
                     MraidView.this.getContext().startActivity(var6);
                     return true;
                  } else {
                     var6 = new Intent();
                     var6.setAction("android.intent.action.VIEW");
                     var6.setData(var3);
                     var6.addFlags(268435456);
                     MraidView.this.getContext().startActivity(var6);
                     return true;
                  }
               } catch (Exception var5) {
                  try {
                     var6 = new Intent();
                     var6.setAction("android.intent.action.VIEW");
                     var6.setData(var3);
                     var6.addFlags(268435456);
                     MraidView.this.getContext().startActivity(var6);
                     return true;
                  } catch (Exception var4) {
                     return false;
                  }
               }
            }
         }
      };
      this.b = new WebChromeClient() {
         public final void onCloseWindow(WebView var1) {
            super.onCloseWindow(var1);
            MraidView.g(MraidView.this);
         }

         public final boolean onConsoleMessage(ConsoleMessage var1) {
            return MraidView.this.w != null?MraidView.this.w.onConsoleMessage(var1):super.onConsoleMessage(var1);
         }

         public final void onHideCustomView() {
            super.onHideCustomView();
         }

         public final boolean onJsAlert(WebView var1, String var2, String var3, JsResult var4) {
            TapjoyLog.d("MRAIDView", var3);
            return false;
         }

         public final void onShowCustomView(View var1, CustomViewCallback var2) {
            TapjoyLog.i("MRAIDView", "-- onShowCustomView --");
            super.onShowCustomView(var1, var2);
            MraidView.this.H = var2;
            if(var1 instanceof FrameLayout) {
               FrameLayout var4 = (FrameLayout)var1;
               if(var4.getFocusedChild() instanceof VideoView && MraidView.this.E instanceof Activity) {
                  Activity var3 = (Activity)MraidView.this.E;
                  MraidView.this.G = (VideoView)var4.getFocusedChild();
                  var4.removeView(MraidView.this.G);
                  if(MraidView.this.F == null) {
                     MraidView.this.F = new RelativeLayout(MraidView.this.E);
                     MraidView.this.F.setLayoutParams(new LayoutParams(-1, -1));
                     MraidView.this.F.setBackgroundColor(-16777216);
                  }

                  android.widget.RelativeLayout.LayoutParams var5 = new android.widget.RelativeLayout.LayoutParams(-1, -1);
                  var5.addRule(13);
                  MraidView.this.G.setLayoutParams(var5);
                  MraidView.this.I = new ProgressBar(MraidView.this.E, (AttributeSet)null, 16842874);
                  MraidView.this.I.setVisibility(0);
                  var5 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
                  var5.addRule(13);
                  MraidView.this.I.setLayoutParams(var5);
                  MraidView.this.F.addView(MraidView.this.G);
                  MraidView.this.F.addView(MraidView.this.I);
                  var3.getWindow().addContentView(MraidView.this.F, new LayoutParams(-1, -1));
                  (new Thread(new MraidView$d(MraidView.this))).start();
                  MraidView.this.setVisibility(8);
                  MraidView.this.G.setOnPreparedListener(new OnPreparedListener() {
                     public final void onPrepared(MediaPlayer var1) {
                        TapjoyLog.i("MRAIDView", "** ON PREPARED **");
                        TapjoyLog.i("MRAIDView", "isPlaying: " + var1.isPlaying());
                        if(!var1.isPlaying()) {
                           var1.start();
                        }

                     }
                  });
                  MraidView.this.G.setOnCompletionListener(new OnCompletionListener() {
                     public final void onCompletion(MediaPlayer var1) {
                        TapjoyLog.i("MRAIDView", "** ON COMPLETION **");
                        MraidView.this.videoViewCleanup();
                     }
                  });
                  MraidView.this.G.setOnErrorListener(new OnErrorListener() {
                     public final boolean onError(MediaPlayer var1, int var2, int var3) {
                        TapjoyLog.i("MRAIDView", "** ON ERROR **");
                        MraidView.this.videoViewCleanup();
                        return false;
                     }
                  });
                  MraidView.this.G.start();
                  return;
               }
            }

         }
      };
      this.setListener(var2);
      this.E = var1;
      this.initialize();
   }

   // $FF: synthetic method
   static void a(final MraidView var0, Bundle var1) {
      if(var0.v != MraidView$VIEW_STATE.EXPANDED) {
         Abstract$Dimensions var4 = (Abstract$Dimensions)var1.getParcelable("expand_dimensions");
         String var5 = var1.getString("expand_url");
         Abstract$Properties var9 = (Abstract$Properties)var1.getParcelable("expand_properties");
         if(URLUtil.isValidUrl(var5)) {
            var0.loadUrl(var5);
         }

         FrameLayout var11 = (FrameLayout)var0.getRootView().findViewById(16908290);
         ViewGroup var7 = (ViewGroup)var0.getParent();
         android.widget.FrameLayout.LayoutParams var6 = new android.widget.FrameLayout.LayoutParams(var4.width, var4.height);
         var6.topMargin = var4.x;
         var6.leftMargin = var4.y;
         int var3 = var7.getChildCount();

         int var2;
         for(var2 = 0; var2 < var3 && var7.getChildAt(var2) != var0; ++var2) {
            ;
         }

         var0.s = var2;
         FrameLayout var8 = new FrameLayout(var0.getContext());
         var8.setId(100);
         var7.addView(var8, var2, new LayoutParams(var0.getWidth(), var0.getHeight()));
         var7.removeView(var0);
         FrameLayout var12 = new FrameLayout(var0.getContext());
         var12.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View var1, MotionEvent var2) {
               TapjoyLog.i("MRAIDView", "background touch called");
               return true;
            }
         });
         android.widget.FrameLayout.LayoutParams var13 = new android.widget.FrameLayout.LayoutParams(-1, -1);
         var12.setId(101);
         var12.setPadding(var4.x, var4.y, 0, 0);
         var12.addView(var0, var6);
         var11.addView(var12, var13);
         if(var9.useBackground) {
            var12.setBackgroundColor(var9.backgroundColor | (int)(var9.backgroundOpacity * 255.0F) * 268435456);
         }

         if(!var9.useCustomClose) {
            var0.showCloseImageButton();
         }

         String var10 = "window.mraidview.fireChangeEvent({ state: \'expanded\', size: { width: " + (int)((float)var4.width / var0.l) + ", height: " + (int)((float)var4.height / var0.l) + ",x:0,y:0} });";
         TapjoyLog.d("MRAIDView", "doExpand: injection: " + var10);
         var0.injectMraidJavaScript(var10);
         var0.v = MraidView$VIEW_STATE.EXPANDED;
         var0.c();
         if(var0.w != null) {
            var0.w.onExpand();
         }
      }

   }

   // $FF: synthetic method
   static void a(MraidView var0, String var1) {
      var0.evaluateJavascript(var1, (ValueCallback)null);
   }

   private void b() {
      this.v = MraidView$VIEW_STATE.DEFAULT;
      if(this.w != null) {
         this.w.onResizeClose();
      }

      String var1 = "window.mraidview.fireChangeEvent({ state: \'default\', size: { width: " + this.p + ", height: " + this.o + ", x:0,y:0}});";
      TapjoyLog.d("MRAIDView", "closeResized: injection: " + var1);
      this.injectMraidJavaScript(var1);
      this.b("top-right");
      this.e();
   }

   private void b(String var1) {
      if(var1 != null) {
         String var2 = null;
         if(var1.equals("top-right")) {
            var2 = "document.getElementById(\"closeButton\").style.right = 1;document.getElementById(\"closeButton\").style.top = 1;document.getElementById(\"closeButton\").style.bottom = mraid.getSize().height -36;document.getElementById(\"closeButton\").style.left = mraid.getSize().width -36";
         } else if(var1.equals("top-center")) {
            var2 = "document.getElementById(\"closeButton\").style.right = mraid.getSize().width/2 - 18;document.getElementById(\"closeButton\").style.top = 1;document.getElementById(\"closeButton\").style.bottom = mraid.getSize().height -36;document.getElementById(\"closeButton\").style.left = mraid.getSize().width/2 -18";
         } else if(var1.equals("top-left")) {
            var2 = "document.getElementById(\"closeButton\").style.right = mraid.getSize().width -36;document.getElementById(\"closeButton\").style.top = 1;document.getElementById(\"closeButton\").style.bottom = mraid.getSize().height -36;document.getElementById(\"closeButton\").style.left = 1";
         } else if(var1.equals("center")) {
            var2 = "document.getElementById(\"closeButton\").style.right = mraid.getSize().width/2 - 18;document.getElementById(\"closeButton\").style.top = mraid.getSize().height/2 -18;document.getElementById(\"closeButton\").style.bottom = mraid.getSize().height/2 -18;document.getElementById(\"closeButton\").style.left = mraid.getSize().width/2 -18";
         } else if(var1.equals("bottom-right")) {
            var2 = "document.getElementById(\"closeButton\").style.right = 1;document.getElementById(\"closeButton\").style.top = mraid.getSize().height -36;document.getElementById(\"closeButton\").style.bottom = 1;document.getElementById(\"closeButton\").style.left = mraid.getSize().width -36";
         } else if(var1.equals("bottom-left")) {
            var2 = "document.getElementById(\"closeButton\").style.left = 1;document.getElementById(\"closeButton\").style.bottom = 1;document.getElementById(\"closeButton\").style.right = mraid.getSize().width -36;document.getElementById(\"closeButton\").style.top = mraid.getSize().height-36;";
         } else if(var1.equals("bottom-center")) {
            var2 = "document.getElementById(\"closeButton\").style.bottom = 1;document.getElementById(\"closeButton\").style.right = mraid.getSize().width -36document.getElementById(\"closeButton\").style.right = mraid.getSize().width/2 -18;document.getElementById(\"closeButton\").style.top = mraid.getSize().height-36;";
         }

         if(var2 != null) {
            this.injectMraidJavaScript(var2);
         } else {
            TapjoyLog.d("MRAIDView", "Reposition of close button failed.");
         }
      }
   }

   private static WebResourceResponse c(String var0) {
      TapjoyCachedAssetData var3 = TapjoyCache.getInstance().getCachedDataForURL(var0);
      if(var3 == null) {
         return null;
      } else {
         try {
            FileInputStream var1 = new FileInputStream(var3.getLocalFilePath());
            WebResourceResponse var4 = new WebResourceResponse(var3.getMimeType(), "UTF-8", var1);
            return var4;
         } catch (FileNotFoundException var2) {
            return null;
         }
      }
   }

   private void c() {
      WindowManager var3 = (WindowManager)this.getContext().getSystemService("window");
      int var1 = var3.getDefaultDisplay().getWidth();
      int var2 = var3.getDefaultDisplay().getHeight();
      if((var1 != this.z || var2 != this.A) && (this.getPlacementType() == MraidView$PLACEMENT_TYPE.INLINE && this.getViewState() == MraidView$VIEW_STATE.EXPANDED || this.getPlacementType() == MraidView$PLACEMENT_TYPE.INTERSTITIAL)) {
         this.resizeOrientation(var1, var2, "top-right", true);
      }

   }

   private void d() {
      synchronized(this){}

      try {
         TapjoyLog.d("MRAIDView", " paths" + f);
         if(f == null && TapjoyUtil.getResource("mraid.js") == null) {
            f = this.k.copyTextFromJarIntoAssetDir("/js/mraid.js", "js/mraid.js");
         }
      } finally {
         ;
      }

   }

   private static boolean d(String var0) {
      boolean var4 = false;
      String[] var5 = d;
      int var2 = var5.length;
      int var1 = 0;

      boolean var3;
      while(true) {
         var3 = var4;
         if(var1 >= var2) {
            break;
         }

         if(var0.endsWith(var5[var1])) {
            var3 = true;
            break;
         }

         ++var1;
      }

      return var3;
   }

   private void e() {
      LayoutParams var1 = this.getLayoutParams();
      if(this.K) {
         var1.height = this.q;
         var1.width = this.r;
      }

      this.setVisibility(0);
      this.requestLayout();
   }

   // $FF: synthetic method
   static void g(MraidView var0) {
      if(var0.w != null) {
         var0.w.onClose();
      }

      ((ViewGroup)var0.getParent()).removeView(var0);
   }

   private int getContentViewHeight() {
      View var1 = this.getRootView().findViewById(16908290);
      return var1 != null?var1.getHeight():-1;
   }

   // $FF: synthetic method
   static boolean m(MraidView var0) {
      return var0.C;
   }

   // $FF: synthetic method
   static void n(MraidView var0) {
      var0.c();
   }

   protected final void a() {
      synchronized(this){}

      try {
         this.resetContents();
         String var1 = "window.mraidview.fireChangeEvent({ state: \'default\', size: { width: " + this.p + ", height: " + this.o + "}});";
         TapjoyLog.d("MRAIDView", "closeExpanded: injection: " + var1);
         this.injectMraidJavaScript(var1);
         this.v = MraidView$VIEW_STATE.DEFAULT;
         this.J.sendEmptyMessage(1005);
         this.setVisibility(0);
         this.removeCloseImageButton();
         ((Activity)this.getContext()).setRequestedOrientation(this.D);
      } finally {
         ;
      }

   }

   public void addJavascriptObject(Object var1, String var2) {
      this.addJavascriptInterface(var1, var2);
   }

   public void clearView() {
      this.reset();
      super.clearView();
   }

   public void close() {
      this.J.sendEmptyMessage(1001);
   }

   public void createCloseImageButton() {
      this.injectMraidJavaScript("window.mraidview.createCss();");
      TapjoyLog.d("MRAIDView", "Creating close button.");
   }

   public void deregisterProtocol(String var1) {
      if(var1 != null) {
         this.y.remove(var1.toLowerCase());
      }

   }

   public void expand(Abstract$Dimensions var1, String var2, Abstract$Properties var3) {
      Message var4 = this.J.obtainMessage(1004);
      Bundle var5 = new Bundle();
      var5.putParcelable("expand_dimensions", var1);
      var5.putString("expand_url", var2);
      var5.putParcelable("expand_properties", var3);
      var4.setData(var5);
      this.J.sendMessage(var4);
   }

   public MraidView$customCloseState getCloseButtonState() {
      return this.e;
   }

   public ConnectivityManager getConnectivityManager() {
      return (ConnectivityManager)this.getContext().getSystemService("connectivity");
   }

   public MraidView$PLACEMENT_TYPE getPlacementType() {
      return this.t;
   }

   MraidPlayer getPlayer() {
      if(x != null) {
         x.releasePlayer();
      }

      MraidPlayer var1 = new MraidPlayer(this.getContext());
      x = var1;
      return var1;
   }

   public String getSize() {
      return "{ width: " + (int)Math.ceil((double)((float)this.getWidth() / this.l)) + ", height: " + (int)Math.ceil((double)((float)this.getHeight() / this.l)) + "}";
   }

   public String getState() {
      return this.v.toString().toLowerCase();
   }

   public MraidView$VIEW_STATE getViewState() {
      return this.v;
   }

   public boolean hasMraidTag(String var1) {
      Pattern var3 = Pattern.compile("<\\s*script[^>]+ormma\\.js");
      Matcher var2 = Pattern.compile("<\\s*script[^>]+mraid\\.js").matcher(var1);
      Matcher var4 = var3.matcher(var1);
      return var2.find() || var4.find();
   }

   public void hide() {
      this.J.sendEmptyMessage(1002);
   }

   @SuppressLint({"SetJavaScriptEnabled"})
   public void initialize() {
      this.setPlacementType(MraidView$PLACEMENT_TYPE.INTERSTITIAL);
      this.setScrollContainer(false);
      this.setVerticalScrollBarEnabled(false);
      this.setHorizontalScrollBarEnabled(false);
      this.u = new GestureDetector(new MraidView$c(this));
      this.setBackgroundColor(0);
      DisplayMetrics var1 = new DisplayMetrics();
      ((WindowManager)this.getContext().getSystemService("window")).getDefaultDisplay().getMetrics(var1);
      this.l = var1.density;
      this.j = false;
      if(this.getSettings() != null) {
         this.getSettings().setJavaScriptEnabled(true);
      }

      this.k = new Utility(this, this.getContext());
      this.addJavascriptInterface(this.k, "MRAIDUtilityControllerBridge");
      this.setWebViewClient(this.a);
      this.setWebChromeClient(this.b);
      this.d();
      this.m = this.getContentViewHeight();
      if(this.getViewTreeObserver() != null) {
         this.getViewTreeObserver().addOnGlobalLayoutListener(this);
      }

      WindowManager var2 = (WindowManager)this.getContext().getSystemService("window");
      this.z = var2.getDefaultDisplay().getWidth();
      this.A = var2.getDefaultDisplay().getHeight();
      this.D = ((Activity)this.getContext()).getRequestedOrientation();
   }

   public void injectMraidJavaScript(String var1) {
      if(var1 != null && this.i) {
         this.loadUrl("javascript:" + var1);
      }

   }

   public boolean isExpanded() {
      return this.v == MraidView$VIEW_STATE.EXPANDED;
   }

   public boolean isMraid() {
      return this.i;
   }

   public boolean isPageFinished() {
      return this.j;
   }

   public void loadDataWithBaseURL(String var1, String var2, String var3, String var4, String var5) {
      if(var2 != null) {
         StringBuffer var13 = new StringBuffer();
         int var10 = var2.indexOf("<html>");
         this.i = false;
         int var7 = var2.indexOf("mraid.js");
         int var6 = var7;
         if(var7 < 0) {
            var6 = var2.indexOf("ormma.js");
         }

         if(var6 > 0 && this.hasMraidTag(var2)) {
            this.i = true;
            var7 = var6;

            int var8;
            while(true) {
               if(var7 < 0) {
                  var8 = var6;
                  break;
               }

               if(var2.substring(var7, var7 + 7).equals("<script")) {
                  var8 = var7;
                  break;
               }

               --var7;
            }

            int var9 = 0;

            while(true) {
               var7 = var6;
               if(var9 >= var2.length()) {
                  break;
               }

               if(var2.substring(var6 + var9, var6 + var9 + 2).equalsIgnoreCase("/>")) {
                  var7 = var6 + var9 + 2;
                  break;
               }

               if(var2.substring(var6 + var9, var6 + var9 + 9).equalsIgnoreCase("</script>")) {
                  var7 = var6 + var9 + 9;
                  break;
               }

               ++var9;
            }

            String var11;
            String var12;
            if(var10 < 0) {
               TapjoyLog.d("MRAIDView", "wrapping fragment");
               var13.append("<html>");
               var13.append("<head>");
               var13.append("<meta name=\'viewport\' content=\'user-scalable=no initial-scale=1.0\' />");
               var13.append("<title>Advertisement</title>");
               var13.append("</head>");
               var13.append("<body style=\"margin:0; padding:0; overflow:hidden; background-color:transparent;\">");
               var13.append("<div align=\"center\"> ");
               var13.append(var2.substring(0, var8));
               var13.append("<script type=text/javascript>");
               var12 = (String)TapjoyUtil.getResource("mraid.js");
               var11 = var12;
               if(var12 == null) {
                  var11 = TapjoyUtil.copyTextFromJarIntoString("js/mraid.js", this.getContext());
               }

               var13.append(var11);
               var13.append("</script>");
               var13.append(var2.substring(var7));
            } else {
               var6 = var2.indexOf("<head>");
               if(var6 != -1) {
                  var12 = (String)TapjoyUtil.getResource("mraid.js");
                  var11 = var12;
                  if(var12 == null) {
                     var11 = TapjoyUtil.copyTextFromJarIntoString("js/mraid.js", this.getContext());
                  }

                  var13.append(var2.substring(0, var6 + 6));
                  var13.append("<script type=\'text/javascript\'>");
                  var13.append(var11);
                  var13.append("</script>");
                  var13.append(var2.substring(var6 + 6));
               }
            }

            TapjoyLog.d("MRAIDView", "injected js/mraid.js");
         } else {
            var13.append(var2);
         }

         super.loadDataWithBaseURL(var1, var13.toString(), var3, var4, var5);
      }
   }

   public void loadUrl(final String var1) {
      ((Activity)this.E).runOnUiThread(new Runnable() {
         public final void run() {
            if(URLUtil.isValidUrl(var1)) {
               if(var1.startsWith("javascript:")) {
                  if(VERSION.SDK_INT >= 19) {
                     try {
                        String var1x = var1.replaceFirst("javascript:", "");
                        MraidView.a(MraidView.this, var1x);
                     } catch (Exception var2) {
                        TapjoyLog.e("MRAIDView", "Exception in evaluateJavascript. Device not supported. " + var2.toString());
                     }
                  } else {
                     MraidView.super.loadUrl(var1);
                  }
               } else {
                  (new MraidView$a(MraidView.this, (byte)0)).execute(new String[]{var1});
               }
            } else {
               MraidView.this.loadDataWithBaseURL((String)null, "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\"><html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\"><title>Connection not Established</title></head><h2>Connection Not Properly Established</h2><body></body></html>", "text/html", "utf-8", (String)null);
            }
         }
      });
   }

   public void loadUrlStandard(String var1) {
      super.loadUrl(var1);
   }

   protected void onAttachedToWindow() {
      if(!this.K) {
         LayoutParams var1 = this.getLayoutParams();
         this.q = var1.height;
         this.r = var1.width;
         this.K = true;
      }

      this.C = false;
      if(this.B == null || !this.B.isAlive()) {
         this.B = new Thread(new MraidView$b(this));
         this.B.start();
      }

      super.onAttachedToWindow();
   }

   protected void onDetachedFromWindow() {
      this.C = true;
      this.k.stopAllListeners();

      try {
         if(this.G != null) {
            this.G.stopPlayback();
         }

         if(this.H != null) {
            this.H.onCustomViewHidden();
         }
      } catch (Exception var2) {
         var2.printStackTrace();
      }

      super.onDetachedFromWindow();
   }

   public void onGlobalLayout() {
      boolean var2 = this.n;
      boolean var1 = var2;
      if(!this.n) {
         var1 = var2;
         if(this.m >= 0) {
            var1 = var2;
            if(this.getContentViewHeight() >= 0) {
               var1 = var2;
               if(this.m != this.getContentViewHeight()) {
                  var1 = true;
                  this.injectMraidJavaScript("window.mraidview.fireChangeEvent({ keyboardState: true});");
               }
            }
         }
      }

      var2 = var1;
      if(this.n) {
         var2 = var1;
         if(this.m >= 0) {
            var2 = var1;
            if(this.getContentViewHeight() >= 0) {
               var2 = var1;
               if(this.m == this.getContentViewHeight()) {
                  var2 = false;
                  this.injectMraidJavaScript("window.mraidview.fireChangeEvent({ keyboardState: false});");
               }
            }
         }
      }

      if(this.m < 0) {
         this.m = this.getContentViewHeight();
      }

      this.n = var2;
   }

   public void open(String var1, boolean var2, boolean var3, boolean var4) {
      String var6 = null;
      boolean var5;
      if(d(var1)) {
         var6 = var1;
         var5 = true;
      } else {
         TapjoyHttpURLResponse var7 = (new TapjoyURLConnection()).getRedirectFromURL(var1);
         TapjoyLog.i("MRAIDView", "redirect: " + var7.redirectURL + ", " + var7.statusCode);
         if(var7 != null && var7.redirectURL != null && var7.redirectURL.length() > 0 && d(var7.redirectURL)) {
            var6 = var7.redirectURL;
            var5 = true;
         } else {
            var5 = false;
         }
      }

      if(var5) {
         Abstract$Dimensions var8 = new Abstract$Dimensions();
         var8.x = 0;
         var8.y = 0;
         var8.width = this.getWidth();
         var8.height = this.getHeight();
         this.playVideo(var6, false, true, true, false, var8, "fullscreen", "exit");
      } else {
         TapjoyLog.d("MRAIDView", "Mraid Browser open:" + var1);
         Intent var9 = new Intent(this.getContext(), Browser.class);
         var9.putExtra("extra_url", var1);
         var9.putExtra("open_show_back", var2);
         var9.putExtra("open_show_forward", var3);
         var9.putExtra("open_show_refresh", var4);
         var9.addFlags(268435456);
         this.getContext().startActivity(var9);
      }
   }

   public void openMap(String var1, boolean var2) {
      TapjoyLog.d("MRAIDView", "Opening Map Url " + var1);
      var1 = Utils.convert(var1.trim());
      if(var2) {
         try {
            Intent var4 = new Intent("android.intent.action.VIEW", Uri.parse(var1));
            var4.setFlags(268435456);
            this.getContext().startActivity(var4);
         } catch (ActivityNotFoundException var3) {
            var3.printStackTrace();
            return;
         }
      }

   }

   public void playAudio(String var1, boolean var2, boolean var3, boolean var4, boolean var5, String var6, String var7) {
      Abstract$PlayerProperties var8 = new Abstract$PlayerProperties();
      var8.setProperties(false, var2, var3, var5, var4, var6, var7);
      Bundle var12 = new Bundle();
      var12.putString("action", MraidView$Action.PLAY_AUDIO.toString());
      var12.putString("expand_url", var1);
      var12.putParcelable("player_properties", var8);
      if(var8.isFullScreen()) {
         try {
            Intent var11 = new Intent(this.getContext(), ActionHandler.class);
            var11.putExtras(var12);
            this.getContext().startActivity(var11);
         } catch (ActivityNotFoundException var9) {
            var9.printStackTrace();
         }
      } else {
         Message var10 = this.J.obtainMessage(1008);
         var10.setData(var12);
         this.J.sendMessage(var10);
      }
   }

   public void playAudioImpl(Bundle var1) {
      Abstract$PlayerProperties var2 = (Abstract$PlayerProperties)var1.getParcelable("player_properties");
      String var4 = var1.getString("expand_url");
      MraidPlayer var3 = this.getPlayer();
      var3.setPlayData(var2, var4);
      var3.setLayoutParams(new LayoutParams(1, 1));
      ((ViewGroup)this.getParent()).addView(var3);
      var3.playAudio();
   }

   public void playVideo(String var1, boolean var2, boolean var3, boolean var4, boolean var5, Abstract$Dimensions var6, String var7, String var8) {
      Message var9 = this.J.obtainMessage(1007);
      Abstract$PlayerProperties var10 = new Abstract$PlayerProperties();
      var10.setProperties(var2, var3, var4, false, var5, var7, var8);
      Bundle var13 = new Bundle();
      var13.putString("expand_url", var1);
      var13.putString("action", MraidView$Action.PLAY_VIDEO.toString());
      var13.putParcelable("player_properties", var10);
      if(var6 != null) {
         var13.putParcelable("expand_dimensions", var6);
      }

      if(var10.isFullScreen()) {
         try {
            Intent var12 = new Intent(this.getContext(), ActionHandler.class);
            var12.putExtras(var13);
            var12.setFlags(268435456);
            this.getContext().startActivity(var12);
         } catch (ActivityNotFoundException var11) {
            var11.printStackTrace();
            return;
         }
      } else if(var6 != null) {
         var9.setData(var13);
         this.J.sendMessage(var9);
         return;
      }

   }

   public void playVideoImpl(Bundle var1) {
      Abstract$PlayerProperties var3 = (Abstract$PlayerProperties)var1.getParcelable("player_properties");
      Abstract$Dimensions var2 = (Abstract$Dimensions)var1.getParcelable("expand_dimensions");
      String var4 = var1.getString("expand_url");
      MraidPlayer var5 = this.getPlayer();
      var5.setPlayData(var3, var4);
      android.widget.FrameLayout.LayoutParams var6 = new android.widget.FrameLayout.LayoutParams(var2.width, var2.height);
      var6.topMargin = var2.x;
      var6.leftMargin = var2.y;
      var5.setLayoutParams(var6);
      FrameLayout var7 = new FrameLayout(this.getContext());
      var7.setId(101);
      var7.setPadding(var2.x, var2.y, 0, 0);
      ((FrameLayout)this.getRootView().findViewById(16908290)).addView(var7, new android.widget.FrameLayout.LayoutParams(-1, -1));
      var7.addView(var5);
      this.setVisibility(4);
      var5.setListener(new Player() {
         public final void onComplete() {
            FrameLayout var1 = (FrameLayout)MraidView.this.getRootView().findViewById(101);
            ((ViewGroup)var1.getParent()).removeView(var1);
            MraidView.this.setVisibility(0);
         }

         public final void onError() {
            this.onComplete();
         }

         public final void onPrepared() {
         }
      });
      var5.playVideo();
   }

   public void raiseError(String var1, String var2) {
      Message var3 = this.J.obtainMessage(1009);
      Bundle var4 = new Bundle();
      var4.putString("message", var1);
      var4.putString("action", var2);
      var3.setData(var4);
      this.J.sendMessage(var3);
   }

   public void registerProtocol(String var1) {
      if(var1 != null) {
         this.y.add(var1.toLowerCase());
      }

   }

   public void removeCloseImageButton() {
      this.injectMraidJavaScript("document.getElementById(\"closeButton\").style.visibility=\"hidden\";");
      TapjoyLog.d("MRAIDView", "Removing close button.");
      this.e = MraidView$customCloseState.HIDDEN;
   }

   public void removeListener() {
      this.w = null;
   }

   public void reset() {
      if(this.v == MraidView$VIEW_STATE.EXPANDED) {
         this.a();
      } else if(this.v == MraidView$VIEW_STATE.RESIZED) {
         this.b();
      }

      this.invalidate();
      this.k.deleteOldAds();
      this.k.stopAllListeners();
      this.e();
   }

   public void resetContents() {
      FrameLayout var2 = (FrameLayout)this.getRootView().findViewById(16908290);
      FrameLayout var1 = (FrameLayout)this.getRootView().findViewById(100);
      FrameLayout var3 = (FrameLayout)this.getRootView().findViewById(101);
      var3.removeView(this);
      var2.removeView(var3);
      this.e();
      if(var1 != null) {
         ViewGroup var4 = (ViewGroup)var1.getParent();
         if(var4 != null) {
            var4.addView(this, this.s);
            var4.removeView(var1);
            var4.invalidate();
         }
      }

   }

   public void resize(int var1, int var2, int var3, int var4, String var5, boolean var6) {
      Message var7 = this.J.obtainMessage(1000);
      Bundle var8 = new Bundle();
      var8.putInt("resize_width", var1);
      var8.putInt("resize_height", var2);
      var8.putInt("resize_x", var3);
      var8.putInt("resize_y", var4);
      var8.putBoolean("resize_allowOffScreen", var6);
      var8.putString("resize_customClosePostition", var5);
      var7.setData(var8);
      this.J.sendMessage(var7);
   }

   public void resizeOrientation(int var1, int var2, String var3, boolean var4) {
      this.z = var1;
      this.A = var2;
      TapjoyLog.i("MRAIDView", "resizeOrientation to dimensions: " + var1 + "x" + var2);
      Message var5 = this.J.obtainMessage(1010);
      Bundle var6 = new Bundle();
      var6.putInt("resize_width", var1);
      var6.putInt("resize_height", var2);
      var6.putBoolean("resize_allowOffScreen", var4);
      var6.putString("resize_customClosePostition", var3);
      var5.setData(var6);
      this.J.sendMessage(var5);
   }

   public WebBackForwardList restoreState(Bundle var1) {
      return super.restoreState(var1);
   }

   public WebBackForwardList saveState(Bundle var1) {
      return super.saveState(var1);
   }

   public void setListener(MraidViewListener var1) {
      this.w = var1;
   }

   public void setMaxSize(int var1, int var2) {
      this.k.setMaxSize(var1, var2);
   }

   public void setOrientationProperties(boolean var1, String var2) {
      byte var3;
      if(!var1) {
         if(var2.equals("landscape")) {
            var3 = 0;
         } else {
            var3 = 1;
         }
      } else {
         var3 = -1;
      }

      ((Activity)this.getContext()).setRequestedOrientation(var3);
   }

   public void setPlacementType(MraidView$PLACEMENT_TYPE var1) {
      if(!var1.equals(MraidView$PLACEMENT_TYPE.INLINE) && !var1.equals(MraidView$PLACEMENT_TYPE.INTERSTITIAL)) {
         TapjoyLog.d("MRAIDView", "Incorrect placement type.");
      } else {
         this.t = var1;
      }

      if(var1.equals(MraidView$PLACEMENT_TYPE.INLINE) && (this.B == null || !this.B.isAlive())) {
         this.B = new Thread(new MraidView$b(this));
         this.B.start();
      }

   }

   public void show() {
      this.J.sendEmptyMessage(1003);
   }

   public void showCloseImageButton() {
      this.injectMraidJavaScript("document.getElementById(\"closeButton\").style.visibility=\"visible\";");
      TapjoyLog.d("MRAIDView", "Showing close button.");
      this.e = MraidView$customCloseState.OPEN;
   }

   public boolean videoPlaying() {
      return this.G != null;
   }

   public void videoViewCleanup() {
      if(this.F != null) {
         ((ViewGroup)this.F.getParent()).removeView(this.F);
         this.F.setVisibility(8);
         this.F = null;
      }

      try {
         if(this.G != null) {
            this.G.stopPlayback();
         }

         if(this.H != null) {
            this.H.onCustomViewHidden();
         }
      } catch (Exception var2) {
         var2.printStackTrace();
      }

      this.G = null;
      this.H = null;
      if(this != null) {
         this.setVisibility(0);
      }

      this.loadUrl("javascript:try{Tapjoy.AdUnit.dispatchEvent(\'videoend\')}catch(e){}");
   }
}
