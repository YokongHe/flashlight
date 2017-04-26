package com.inneractive.api.ads.sdk;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.JavascriptInterface;
import com.inneractive.api.ads.sdk.IAbaseInterstitialAdActivity;
import com.inneractive.api.ads.sdk.IAbaseInterstitialAdActivity$JavaScriptWebViewCallbacks;
import com.inneractive.api.ads.sdk.IAbaseVideoViewListener;
import com.inneractive.api.ads.sdk.IAbaseVideoViewListener$IAvideoListener;
import com.inneractive.api.ads.sdk.IAbaseWebView;
import com.inneractive.api.ads.sdk.IAbaseWebView$IAviewState;
import com.inneractive.api.ads.sdk.IAdefines$ApiLevel;
import com.inneractive.api.ads.sdk.IAmraidWebView;
import com.inneractive.api.ads.sdk.IAmraidWebView$ExpandMode;
import com.inneractive.api.ads.sdk.IAmraidWebView$MraidPlacementType;
import com.inneractive.api.ads.sdk.IAmraidWebView$NativeCloseButtonMode;
import com.inneractive.api.ads.sdk.IAmraidWebView$d;
import com.inneractive.api.ads.sdk.IAplayerController;
import com.inneractive.api.ads.sdk.InneractiveAdView$InneractiveErrorCode;
import com.inneractive.api.ads.sdk.InneractiveAdView$Log;
import com.inneractive.api.ads.sdk.b$a;

public class InneractiveInterstitialAdActivity extends IAbaseInterstitialAdActivity {
   static com.inneractive.api.ads.sdk.a adConfiguration;
   static Context context;
   static String htmlData;
   private static InneractiveInterstitialAdActivity instance;
   static boolean isTrackingPixelSent;
   static boolean isVastCompleted;
   static b$a mAdInterfaceListener;
   static ag parsedData;
   static IAmraidWebView temporaryMraidView;
   private static com.inneractive.api.ads.sdk.w videoView;
   private IAmraidWebView mMraidView;

   private static Intent createIntent(Context var0, String var1, com.inneractive.api.ads.sdk.a var2) {
      Intent var3 = new Intent(var0, InneractiveInterstitialAdActivity.class);
      var3.addFlags(268435456);
      return var3;
   }

   private void destroyInternalData() {
      if(this.mMraidView != null) {
         this.mMraidView.destroy();
         this.mMraidView = null;
      }

   }

   private static void destroyStaticData() {
      if(temporaryMraidView != null) {
         temporaryMraidView.destroy();
         temporaryMraidView = null;
      }

      if(videoView != null) {
         videoView.n();
         videoView = null;
      }

   }

   static void displayAhead(Context var0, b$a var1, com.inneractive.api.ads.sdk.a var2) {
      context = var0;
      mAdInterfaceListener = var1;
      adConfiguration = var2;
      if(var2 != null && adConfiguration.v() != null) {
         parsedData = adConfiguration.v();
         if(isDisplayingVast()) {
            prepareVideoView();
         } else {
            prepareMraidWebView();
         }
      } else {
         mAdInterfaceListener.a(InneractiveAdView$InneractiveErrorCode.SDK_INTERNAL_ERROR);
      }
   }

   protected static String extractData(ag var0) {
      return var0.b();
   }

   private View getMraidWebView() {
      this.mMraidView = Y.createInstance(this, adConfiguration, IAmraidWebView$ExpandMode.DISABLED, IAmraidWebView$NativeCloseButtonMode.AD_CONTROLLED, IAmraidWebView$MraidPlacementType.INTERSTITIAL);
      this.mMraidView.setListener(new at() {
         public final void onAdWillOpenExternalApp() {
            if(InneractiveInterstitialAdActivity.mAdInterfaceListener != null) {
               InneractiveInterstitialAdActivity.mAdInterfaceListener.c();
            }

         }

         public final void onClicked() {
            if(InneractiveInterstitialAdActivity.mAdInterfaceListener != null) {
               InneractiveInterstitialAdActivity.mAdInterfaceListener.b();
            }

            InneractiveInterstitialAdActivity.this.mMraidView.loadUrl("javascript:if(typeof iaVideoPlayer !== \'undefined\' && typeof iaVideoPlayer.getState === \'function\') {alert(\'playerState\'+iaVideoPlayer.getState())}");
            if(InneractiveInterstitialAdActivity.parsedData.e != 9) {
               InneractiveInterstitialAdActivity.this.finish();
            } else {
               InneractiveInterstitialAdActivity.this.mMraidView.loadUrl("javascript: (function () {\tconsole.log(\'calling closeVastAdActivity via JS\');\tif (typeof InneractiveCloseVastAdActivityInterface !== \'undefined\' && typeof iaVideoPlayer !== \'undefined\' && typeof iaVideoPlayer.getState === \'function\') {  \t\tInneractiveCloseVastAdActivityInterface.closeVastAdActivity(iaVideoPlayer.getState());\t\tconsole.log(\'calling close vast ad with player state: \' + iaVideoPlayer.getState());\t} })()");
            }
         }

         public final void onClose(IAbaseWebView var1, IAbaseWebView$IAviewState var2) {
            this.onDismissed();
         }

         public final void onDismissed() {
            InneractiveInterstitialAdActivity.this.finish();
            if(InneractiveInterstitialAdActivity.mAdInterfaceListener != null) {
               InneractiveInterstitialAdActivity.mAdInterfaceListener.e();
            }

         }

         public final void onFailure(IAbaseWebView var1, InneractiveAdView$InneractiveErrorCode var2) {
            if(InneractiveInterstitialAdActivity.mAdInterfaceListener != null) {
               InneractiveInterstitialAdActivity.mAdInterfaceListener.a(var2);
            }

            this.onDismissed();
         }

         public final void onInternalBrowserDismissed() {
            if(InneractiveInterstitialAdActivity.mAdInterfaceListener != null) {
               InneractiveInterstitialAdActivity.mAdInterfaceListener.d();
            }

            if((InneractiveInterstitialAdActivity.parsedData.e != 9 || InneractiveInterstitialAdActivity.isVastCompleted) && InneractiveInterstitialAdActivity.mAdInterfaceListener != null) {
               InneractiveInterstitialAdActivity.mAdInterfaceListener.e();
            }

         }

         public final void onReady(IAbaseWebView var1) {
            if(!InneractiveInterstitialAdActivity.isTrackingPixelSent) {
               InneractiveAdView$Log.d("This is the first time so isTrackingPixelSent is false and will be set to true");
               InneractiveInterstitialAdActivity.this.mMraidView.loadUrl(IAbaseInterstitialAdActivity$JavaScriptWebViewCallbacks.a.a());
               if(InneractiveInterstitialAdActivity.mAdInterfaceListener != null) {
                  InneractiveInterstitialAdActivity.mAdInterfaceListener.a();
               }

               InneractiveInterstitialAdActivity.isTrackingPixelSent = true;
            } else {
               InneractiveAdView$Log.d("This is NOT the first time so isTrackingPixelSent is TRUE!");
            }

            if(InneractiveInterstitialAdActivity.parsedData.e == 9) {
               if(IAdefines$ApiLevel.a().b(IAdefines$ApiLevel.i)) {
                  InneractiveInterstitialAdActivity.this.mMraidView.loadUrl(IAbaseInterstitialAdActivity$JavaScriptWebViewCallbacks.b.a());
               } else {
                  InneractiveInterstitialAdActivity.this.mMraidView.performVastAutoclick();
               }

               InneractiveInterstitialAdActivity.this.mMraidView.loadUrl("javascript:(function(){ \n\tvar iaVastDoneListener = function(done) { \n       window.console.log(\'video is DONE. need to setStop.\'); \n\t\tif (typeof InneractiveCloseVastAdActivityInterface !== \'undefined\' && typeof iaVideoPlayer !== \'undefined\') {InneractiveCloseVastAdActivityInterface.videoCompleted();console.log(\'calling video completed function\');}\t\tif (typeof iaVideoPlayer !== \'undefined\') {iaVideoPlayer.removeListener(\'done\', iaVastDoneListener); window.console.log(\'iaVastDoneListener IS REMOVED\');} \n\t};\tif (typeof iaVideoPlayer !== \'undefined\') {iaVideoPlayer.addListener(\'done\', iaVastDoneListener);} \n})();");
               InneractiveInterstitialAdActivity.this.concealInterstitialCloseBtn();
               InneractiveInterstitialAdActivity.this.mMraidView.loadUrl("javascript:document.getElementById(\"iaClose\").style.display =\"inline\";");
            } else {
               InneractiveInterstitialAdActivity.this.displayInterstitialCloseBtn();
            }

            if(IAdefines$ApiLevel.a().b(IAdefines$ApiLevel.i)) {
               InneractiveInterstitialAdActivity.this.mMraidView.loadUrl("javascript:var forceReflow = function(elem){ elem = elem || document.documentElement; elem.style.zIndex = 2147483646; var width = elem.style.width, px = elem.offsetWidth+1; elem.style.width = px+\'px\'; setTimeout(function(){ elem.style.zIndex = 2147483646; elem.style.width = width; elem = null; }, 0); }; forceReflow(document.documentElement);");
            }

         }
      });
      this.mMraidView.setOnCloseButtonStateChange(new IAmraidWebView$d() {
         public final void onCloseButtonStateChange(IAmraidWebView var1, boolean var2) {
            if(var2) {
               InneractiveInterstitialAdActivity.this.displayInterstitialCloseBtn();
            } else {
               InneractiveInterstitialAdActivity.this.concealInterstitialCloseBtn();
            }
         }
      });
      if(parsedData != null) {
         String var2 = extractData(parsedData);
         this.addCloseActivityJavascriptInterface();
         IAmraidWebView var3 = this.mMraidView;
         String var1;
         if(adConfiguration != null) {
            var1 = adConfiguration.m();
         } else {
            var1 = null;
         }

         var3.loadHtmlData(var1, var2);
      } else if(mAdInterfaceListener != null) {
         mAdInterfaceListener.a(InneractiveAdView$InneractiveErrorCode.SDK_INTERNAL_ERROR);
      }

      return this.mMraidView;
   }

   private View getVideoView() {
      if(videoView == null) {
         return null;
      } else {
         videoView.a((IAbaseVideoViewListener)(new IAbaseVideoViewListener$IAvideoListener() {
            public final void onAdWillOpenExternalApp() {
               if(InneractiveInterstitialAdActivity.mAdInterfaceListener != null) {
                  InneractiveInterstitialAdActivity.mAdInterfaceListener.c();
               }

            }

            public final void onClicked() {
               if(InneractiveInterstitialAdActivity.mAdInterfaceListener != null) {
                  InneractiveInterstitialAdActivity.mAdInterfaceListener.b();
               }

            }

            public final void onDismissed() {
               if(InneractiveInterstitialAdActivity.mAdInterfaceListener != null) {
                  InneractiveInterstitialAdActivity.mAdInterfaceListener.e();
               }

               InneractiveInterstitialAdActivity.videoView.s();
               InneractiveInterstitialAdActivity.this.finish();
            }

            public final void onFailure(com.inneractive.api.ads.sdk.q var1, InneractiveAdView$InneractiveErrorCode var2) {
               InneractiveInterstitialAdActivity.mAdInterfaceListener.a(var2);
            }

            public final void onInternalBrowserDismissed() {
               if(InneractiveInterstitialAdActivity.mAdInterfaceListener != null) {
                  InneractiveInterstitialAdActivity.mAdInterfaceListener.d();
               }

               if(InneractiveInterstitialAdActivity.videoView.m()) {
                  if(InneractiveInterstitialAdActivity.mAdInterfaceListener != null) {
                     InneractiveInterstitialAdActivity.mAdInterfaceListener.e();
                  }

                  InneractiveInterstitialAdActivity.this.finish();
               }

            }
         }));
         if(!isTrackingPixelSent) {
            InneractiveAdView$Log.d("This is the first time so isTrackingPixelSent is false and will be set to true");
            if(mAdInterfaceListener != null) {
               mAdInterfaceListener.a();
            }

            isTrackingPixelSent = true;
         }

         return videoView;
      }
   }

   private static boolean isDisplayingVast() {
      return parsedData != null && parsedData.e == 8;
   }

   static void onInvalidate() {
      InneractiveAdView$Log.a("inter activity onInvalidate called");
      destroyStaticData();
      if(instance != null) {
         instance.destroyInternalData();
      }

   }

   private static void prepareMraidWebView() {
      String var0 = null;
      isTrackingPixelSent = false;
      isVastCompleted = false;
      IAmraidWebView var1 = Y.createInstance(context, (com.inneractive.api.ads.sdk.a)null, IAmraidWebView$ExpandMode.DISABLED, IAmraidWebView$NativeCloseButtonMode.ALWAYS_VISIBLE, IAmraidWebView$MraidPlacementType.INTERSTITIAL);
      temporaryMraidView = var1;
      var1.enablePlugins(false);
      temporaryMraidView.clearCache(true);
      temporaryMraidView.clearHistory();
      temporaryMraidView.setVisibility(8);
      temporaryMraidView.setListener(new at() {
         public final void onFailure(IAbaseWebView var1, InneractiveAdView$InneractiveErrorCode var2) {
            InneractiveInterstitialAdActivity.mAdInterfaceListener.a(var2);
         }

         public final void onReady(IAbaseWebView var1) {
            if(InneractiveInterstitialAdActivity.parsedData != null) {
               if(!"House Ad".equals(InneractiveInterstitialAdActivity.parsedData.d)) {
                  InneractiveInterstitialAdActivity.mAdInterfaceListener.a((View)var1);
                  return;
               }

               InneractiveInterstitialAdActivity.mAdInterfaceListener.b(var1);
            }

         }
      });
      htmlData = extractData(parsedData);
      var1 = temporaryMraidView;
      if(adConfiguration != null) {
         var0 = adConfiguration.m();
      }

      var1.loadHtmlData(var0, htmlData);
   }

   private static void prepareVideoView() {
      isTrackingPixelSent = false;
      com.inneractive.api.ads.sdk.w var0 = new com.inneractive.api.ads.sdk.w(context, adConfiguration);
      videoView = var0;
      var0.a((IAbaseVideoViewListener)(new IAbaseVideoViewListener$IAvideoListener() {
         public final void onFailure(com.inneractive.api.ads.sdk.q var1, InneractiveAdView$InneractiveErrorCode var2) {
            InneractiveInterstitialAdActivity.mAdInterfaceListener.a(var2);
         }

         public final void onReady(com.inneractive.api.ads.sdk.q var1) {
            if(InneractiveInterstitialAdActivity.parsedData != null) {
               if(!"House Ad".equals(InneractiveInterstitialAdActivity.parsedData.d)) {
                  InneractiveInterstitialAdActivity.mAdInterfaceListener.a((View)var1);
                  return;
               }

               InneractiveInterstitialAdActivity.mAdInterfaceListener.b(var1);
            }

         }
      }));
      if(videoView.c()) {
         videoView.f();
      }

   }

   public static void start(Context var0, com.inneractive.api.ads.sdk.a var1) {
      Intent var3 = createIntent(var0, htmlData, var1);

      try {
         var0.startActivity(var3);
      } catch (ActivityNotFoundException var2) {
         InneractiveAdView$Log.b("InneractiveInterstitialAdActivity.class not found. Did you declare InneractiveInterstitialAdActivity in your manifest?");
      }
   }

   private void unmuteMediaPlayerInNeeded() {
      boolean var2 = false;
      if(videoView != null) {
         com.inneractive.api.ads.sdk.w var3 = videoView;
         boolean var1 = var2;
         IAplayerController var4;
         if(var3.e != null) {
            var4 = var3.e;
            var1 = var2;
            if(var4.a() != null) {
               var1 = var4.a().a;
            }
         }

         if(var1) {
            var3 = videoView;
            if(var3.e != null) {
               var4 = var3.e;
               if(var4.a() != null) {
                  var4.a().a();
               }
            }
         }
      }

   }

   void addCloseActivityJavascriptInterface() {
      if(this.mMraidView != null) {
         this.mMraidView.addJavascriptInterface(new Object() {
            @JavascriptInterface
            public final void closeVastAdActivity(String var1) {
               if(InneractiveInterstitialAdActivity.isVastCompleted) {
                  InneractiveAdView$Log.d("finish activity!");
                  InneractiveInterstitialAdActivity.this.finish();
               }

            }

            @JavascriptInterface
            public final void videoCompleted() {
               InneractiveInterstitialAdActivity.isVastCompleted = true;
            }
         }, "InneractiveCloseVastAdActivityInterface");
      }

   }

   View getAdView() {
      return parsedData != null && parsedData.e == 8?this.getVideoView():this.getMraidWebView();
   }

   public void onBackPressed() {
      if(videoView != null) {
         videoView.s();
      }

      if(mAdInterfaceListener != null) {
         mAdInterfaceListener.e();
      }

      this.finish();
   }

   protected void onCreate(Bundle var1) {
      instance = this;
      if(parsedData != null && parsedData.e == 8) {
         if(adConfiguration.L() == 2) {
            if(IAdefines$ApiLevel.a().b(IAdefines$ApiLevel.b)) {
               this.setRequestedOrientation(6);
            } else {
               this.setRequestedOrientation(0);
            }
         } else if(adConfiguration.L() == 1) {
            this.setRequestedOrientation(1);
         }
      }

      super.onCreate(var1);
      if(IAdefines$ApiLevel.a().b(IAdefines$ApiLevel.d)) {
         this.getWindow().setFlags(16777216, 16777216);
      }

      this.getCloseButton().setOnClickListener(new OnClickListener() {
         public final void onClick(View var1) {
            InneractiveInterstitialAdActivity.this.finish();
            if(InneractiveInterstitialAdActivity.mAdInterfaceListener != null) {
               InneractiveInterstitialAdActivity.mAdInterfaceListener.e();
            }

         }
      });
   }

   protected void onDestroy() {
      destroyStaticData();
      this.destroyInternalData();
      instance = null;
      super.onDestroy();
   }

   public boolean onKeyDown(int var1, KeyEvent var2) {
      if(var1 != 25 && var1 != 24) {
         if(var1 == 4 && isDisplayingVast() && !videoView.b()) {
            return true;
         }
      } else {
         this.unmuteMediaPlayerInNeeded();
      }

      return super.onKeyDown(var1, var2);
   }

   protected void onPause() {
      super.onPause();
      if(this.mMraidView != null) {
         this.mMraidView.onPause();
      }

      if(videoView != null) {
         videoView.p();
      }

   }

   protected void onResume() {
      super.onResume();
      if(this.mMraidView != null) {
         this.mMraidView.onResume();
      }

      if(videoView != null) {
         videoView.q();
      }

   }

   protected void onStart() {
      super.onStart();
   }

   protected void onStop() {
      super.onStop();
   }
}
