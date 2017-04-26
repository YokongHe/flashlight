package com.inmobi.monetization.internal.imai;

import android.content.Intent;
import android.net.Uri;
import com.inmobi.androidsdk.IMBrowserActivity;
import com.inmobi.commons.analytics.net.AnalyticsCommon$HttpRequestCallback;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.monetization.internal.configs.Initializer;
import com.inmobi.monetization.internal.imai.RequestResponseManager;
import com.inmobi.monetization.internal.imai.db.ClickData;
import com.inmobi.monetization.internal.imai.db.ClickDatabaseManager;
import com.inmobi.re.container.IMWebView;
import com.inmobi.re.container.IMWebView$ViewState;
import java.lang.ref.WeakReference;
import java.util.Random;

public class IMAICore {
   static Random a = new Random();

   public static void fireErrorEvent(WeakReference var0, String var1, String var2, String var3) {
      if(var0 != null) {
         try {
            if(var0.get() != null) {
               Log.debug("[InMobi]-[Monetization]", "Fire error event IMAI for action: " + var2 + " " + var1);
               injectJavaScript((IMWebView)var0.get(), "window._im_imai.broadcastEvent(\'error\',\'" + var1 + "\',\'" + var2 + "\',\'" + var3 + "\')");
            }
         } catch (Exception var4) {
            Log.internal("[InMobi]-[Monetization]", "Exception", var4);
            return;
         }
      }

   }

   public static void fireOpenEmbeddedSuccessful(WeakReference var0, String var1) {
      if(var0 != null) {
         try {
            if(var0.get() != null) {
               Log.debug("[InMobi]-[Monetization]", "fireOpenEmbeddedSuccessful");
               if(!((IMWebView)var0.get()).mWebViewIsBrowserActivity && !((IMWebView)var0.get()).mIsInterstitialAd) {
                  IMBrowserActivity.requestOnAdDismiss(((IMWebView)var0.get()).getWebviewHandler().obtainMessage(((IMWebView)var0.get()).getDismissMessage()));
                  ((IMWebView)var0.get()).fireOnShowAdScreen();
               }

               injectJavaScript((IMWebView)var0.get(), "window._im_imai.broadcastEvent(\'openEmbeddedSuccessful\',\'" + var1 + "\')");
            }
         } catch (Exception var2) {
            Log.internal("[InMobi]-[Monetization]", "Exception", var2);
            return;
         }
      }

   }

   public static void fireOpenExternalSuccessful(WeakReference var0, String var1) {
      if(var0 != null) {
         try {
            if(var0.get() != null) {
               Log.debug("[InMobi]-[Monetization]", "fireOpenExternalSuccessful");
               ((IMWebView)var0.get()).fireOnLeaveApplication();
               injectJavaScript((IMWebView)var0.get(), "window._im_imai.broadcastEvent(\'openExternalSuccessful\',\'" + var1 + "\')");
            }
         } catch (Exception var2) {
            Log.internal("[InMobi]-[Monetization]", "Exception", var2);
            return;
         }
      }

   }

   public static void firePingInWebViewSuccessful(WeakReference var0, String var1) {
      if(var0 != null) {
         try {
            if(var0.get() != null) {
               Log.debug("[InMobi]-[Monetization]", "firePingInWebViewSuccessful");
               injectJavaScript((IMWebView)var0.get(), "window._im_imai.broadcastEvent(\'pingInWebViewSuccessful\',\'" + var1 + "\')");
            }
         } catch (Exception var2) {
            Log.internal("[InMobi]-[Monetization]", "Exception", var2);
            return;
         }
      }

   }

   public static void firePingSuccessful(WeakReference var0, String var1) {
      if(var0 != null) {
         try {
            if(var0.get() != null) {
               Log.debug("[InMobi]-[Monetization]", "firePingSuccessful");
               injectJavaScript((IMWebView)var0.get(), "window._im_imai.broadcastEvent(\'pingSuccessful\',\'" + var1 + "\')");
            }
         } catch (Exception var2) {
            Log.internal("[InMobi]-[Monetization]", "Exception", var2);
            return;
         }
      }

   }

   public static int getRandomNumber() {
      return a.nextInt();
   }

   public static void initialize() {
      (new RequestResponseManager()).init();
      ClickDatabaseManager.getInstance().setDBLimit(Initializer.getConfigParams().getImai().getmMaxDb());
   }

   public static void injectJavaScript(final IMWebView var0, final String var1) {
      try {
         var0.getActivity().runOnUiThread(new Runnable() {
            public final void run() {
               var0.injectJavaScript(var1);
            }
         });
      } catch (Exception var2) {
         Log.internal("[InMobi]-[Monetization]", "Error injecting javascript ", var2);
      }
   }

   public static void launchEmbeddedBrowser(WeakReference var0, String var1) {
      Intent var2 = new Intent(((IMWebView)var0.get()).getActivity(), IMBrowserActivity.class);
      var2.putExtra("extra_url", var1);
      var2.putExtra("extra_browser_type", 100);
      var2.setFlags(268435456);
      IMBrowserActivity.setWebViewListener(((IMWebView)var0.get()).mListener);
      if(!((IMWebView)var0.get()).mWebViewIsBrowserActivity && !((IMWebView)var0.get()).mIsInterstitialAd && ((IMWebView)var0.get()).getStateVariable() == IMWebView$ViewState.DEFAULT) {
         var2.putExtra("FIRST_INSTANCE", true);
      }

      ((IMWebView)var0.get()).getActivity().getApplicationContext().startActivity(var2);
   }

   public static void launchExternalApp(String var0) {
      Intent var1 = new Intent("android.intent.action.VIEW");
      var1.setData(Uri.parse(var0));
      var1.setFlags(268435456);
      InternalSDKUtil.getContext().startActivity(var1);
   }

   public static void ping(final WeakReference var0, final String var1, final boolean var2) {
      try {
         ((IMWebView)var0.get()).getActivity().runOnUiThread(new Runnable() {
            public final void run() {
               try {
                  int var1x = Initializer.getConfigParams().getImai().getMaxRetry();
                  ClickData var2x = new ClickData(var1, var2, false, var1x);
                  RequestResponseManager var3 = new RequestResponseManager();
                  var3.init();
                  RequestResponseManager.mNetworkQueue.add(0, var2x);
                  var3.processClick(InternalSDKUtil.getContext(), new AnalyticsCommon$HttpRequestCallback() {
                     public void notifyResult(int param1, Object param2) {
                        // $FF: Couldn't be decompiled
                     }
                  });
               } catch (Exception var4) {
                  Log.internal("[InMobi]-[Monetization]", "Exception ping in background", var4);
               }
            }
         });
      } catch (Exception var3) {
         Log.internal("[InMobi]-[Monetization]", "Failed to ping", var3);
      }
   }

   public static void pingInWebview(final WeakReference var0, final String var1, final boolean var2) {
      try {
         ((IMWebView)var0.get()).getActivity().runOnUiThread(new Runnable() {
            public final void run() {
               try {
                  int var1x = Initializer.getConfigParams().getImai().getMaxRetry();
                  ClickData var2x = new ClickData(var1, var2, true, var1x);
                  RequestResponseManager var3 = new RequestResponseManager();
                  var3.init();
                  RequestResponseManager.mNetworkQueue.add(0, var2x);
                  var3.processClick(InternalSDKUtil.getContext(), new AnalyticsCommon$HttpRequestCallback() {
                     public void notifyResult(int param1, Object param2) {
                        // $FF: Couldn't be decompiled
                     }
                  });
               } catch (Exception var4) {
                  Log.internal("[InMobi]-[Monetization]", "Exception ping in background", var4);
               }
            }
         });
      } catch (Exception var3) {
         Log.internal("[InMobi]-[Monetization]", "Failed to ping in webview", var3);
      }
   }

   public static boolean validateURL(String var0) {
      if(var0 != null && !"".equals(var0.trim())) {
         return true;
      } else {
         Log.internal("[InMobi]-[Monetization]", "Null url passed");
         return false;
      }
   }
}
