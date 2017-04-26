package com.mopub.mobileads;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mopub.common.AdReport;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.BaseInterstitialActivity;
import com.mopub.mobileads.BaseInterstitialActivity$JavaScriptWebViewCallbacks;
import com.mopub.mobileads.BaseWebView;
import com.mopub.mobileads.CustomEventInterstitial$CustomEventInterstitialListener;
import com.mopub.mobileads.EventForwardingBroadcastReceiver;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mraid.MraidController;
import com.mopub.mraid.MraidController$MraidListener;
import com.mopub.mraid.MraidController$UseCustomCloseListener;
import com.mopub.mraid.MraidWebViewDebugListener;
import com.mopub.mraid.PlacementType;

public class MraidActivity extends BaseInterstitialActivity {
   private MraidWebViewDebugListener mDebugListener;
   private MraidController mMraidController;

   @VisibleForTesting
   protected static Intent createIntent(Context var0, AdReport var1, String var2, long var3) {
      Intent var5 = new Intent(var0, MraidActivity.class);
      var5.putExtra("Html-Response-Body", var2);
      var5.putExtra("broadcastIdentifier", var3);
      var5.putExtra("mopub-intent-ad-report", var1);
      var5.addFlags(268435456);
      return var5;
   }

   public static void preRenderHtml(Context var0, final CustomEventInterstitial$CustomEventInterstitialListener var1, String var2) {
      BaseWebView var3 = new BaseWebView(var0);
      var3.enablePlugins(false);
      var3.setWebViewClient(new WebViewClient() {
         public void onPageFinished(WebView var1x, String var2) {
            var1.onInterstitialLoaded();
         }

         public void onReceivedError(WebView var1x, int var2, String var3, String var4) {
            super.onReceivedError(var1x, var2, var3, var4);
            var1.onInterstitialFailed(MoPubErrorCode.MRAID_LOAD_ERROR);
         }

         public boolean shouldOverrideUrlLoading(WebView var1x, String var2) {
            return true;
         }
      });
      var3.loadDataWithBaseURL((String)null, var2, "text/html", "UTF-8", (String)null);
   }

   public static void start(Context var0, AdReport var1, String var2, long var3) {
      Intent var6 = createIntent(var0, var1, var2, var3);

      try {
         var0.startActivity(var6);
      } catch (ActivityNotFoundException var5) {
         Log.d("MraidInterstitial", "MraidActivity.class not found. Did you declare MraidActivity in your manifest?");
      }
   }

   public View getAdView() {
      String var1 = this.getIntent().getStringExtra("Html-Response-Body");
      if(var1 == null) {
         MoPubLog.w("MraidActivity received a null HTML body. Finishing the activity.");
         this.finish();
         return new View(this);
      } else {
         this.mMraidController = new MraidController(this, this.mAdReport, PlacementType.INTERSTITIAL);
         this.mMraidController.setDebugListener(this.mDebugListener);
         this.mMraidController.setMraidListener(new MraidController$MraidListener() {
            public void onClose() {
               MraidActivity.this.mMraidController.loadJavascript(BaseInterstitialActivity$JavaScriptWebViewCallbacks.WEB_VIEW_DID_CLOSE.getJavascript());
               MraidActivity.this.finish();
            }

            public void onExpand() {
            }

            public void onFailedToLoad() {
               MoPubLog.d("MraidActivity failed to load. Finishing the activity");
               EventForwardingBroadcastReceiver.broadcastAction(MraidActivity.this, MraidActivity.this.getBroadcastIdentifier().longValue(), "com.mopub.action.interstitial.fail");
               MraidActivity.this.finish();
            }

            public void onLoaded(View var1) {
               MraidActivity.this.mMraidController.loadJavascript(BaseInterstitialActivity$JavaScriptWebViewCallbacks.WEB_VIEW_DID_APPEAR.getJavascript());
            }

            public void onOpen() {
               EventForwardingBroadcastReceiver.broadcastAction(MraidActivity.this, MraidActivity.this.getBroadcastIdentifier().longValue(), "com.mopub.action.interstitial.click");
            }
         });
         this.mMraidController.setUseCustomCloseListener(new MraidController$UseCustomCloseListener() {
            public void useCustomCloseChanged(boolean var1) {
               if(var1) {
                  MraidActivity.this.hideInterstitialCloseButton();
               } else {
                  MraidActivity.this.showInterstitialCloseButton();
               }
            }
         });
         this.mMraidController.loadContent(var1);
         return this.mMraidController.getAdContainer();
      }
   }

   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      EventForwardingBroadcastReceiver.broadcastAction(this, this.getBroadcastIdentifier().longValue(), "com.mopub.action.interstitial.show");
      if(VERSION.SDK_INT >= 14) {
         this.getWindow().setFlags(16777216, 16777216);
      }

   }

   protected void onDestroy() {
      if(this.mMraidController != null) {
         this.mMraidController.destroy();
      }

      EventForwardingBroadcastReceiver.broadcastAction(this, this.getBroadcastIdentifier().longValue(), "com.mopub.action.interstitial.dismiss");
      super.onDestroy();
   }

   protected void onPause() {
      if(this.mMraidController != null) {
         this.mMraidController.pause();
      }

      super.onPause();
   }

   protected void onResume() {
      super.onResume();
      if(this.mMraidController != null) {
         this.mMraidController.resume();
      }

   }

   @VisibleForTesting
   public void setDebugListener(MraidWebViewDebugListener var1) {
      this.mDebugListener = var1;
      if(this.mMraidController != null) {
         this.mMraidController.setDebugListener(var1);
      }

   }
}
