package com.smaato.soma.interstitial;

import android.os.Bundle;
import android.widget.RelativeLayout.LayoutParams;
import com.smaato.soma.BannerStateListener;
import com.smaato.soma.BaseView;
import com.smaato.soma.CrashReportTemplate;
import com.smaato.soma.interstitial.BaseActivity;
import com.smaato.soma.interstitial.Interstitial;

public class InterstitialActivity extends BaseActivity implements BannerStateListener {
   private boolean shouldCallOnClose = true;

   public void onBackPressed() {
      (new CrashReportTemplate() {
         public Void process() {
            if(Interstitial.interstitialAdListener != null && InterstitialActivity.this.shouldCallOnClose) {
               Interstitial.interstitialAdListener.onWillClose();
               InterstitialActivity.this.shouldCallOnClose = false;
            }

            return null;
         }
      }).execute();
      super.onBackPressed();
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      (new CrashReportTemplate() {
         public Void process() {
            Interstitial.getBanner().setContext(InterstitialActivity.this);
            if(InterstitialActivity.this.getIntent().getBooleanExtra("isPortrait", true)) {
               InterstitialActivity.this.setRequestedOrientation(1);
            } else {
               InterstitialActivity.this.setRequestedOrientation(0);
            }

            Interstitial.getBanner().setBannerStateListener(InterstitialActivity.this);
            Interstitial.getBanner().setContext(InterstitialActivity.this);

            try {
               InterstitialActivity.this.getLayout().addView(Interstitial.getBanner(), new LayoutParams(-1, -1));
            } catch (Throwable var2) {
               InterstitialActivity.this.getLayout().addView(Interstitial.getBanner(), new LayoutParams(-1, -1));
            }

            InterstitialActivity.this.addCloseButton();
            return null;
         }
      }).execute();
   }

   protected void onDestroy() {
      (new CrashReportTemplate() {
         public Void process() {
            if(Interstitial.interstitialAdListener != null && InterstitialActivity.this.shouldCallOnClose) {
               Interstitial.interstitialAdListener.onWillClose();
               InterstitialActivity.this.shouldCallOnClose = false;
            }

            return null;
         }
      }).execute();
      super.onDestroy();
   }

   public void onWillCloseLandingPage(BaseView var1) {
      (new CrashReportTemplate() {
         public Void process() {
            if(Interstitial.interstitialAdListener != null && InterstitialActivity.this.shouldCallOnClose) {
               Interstitial.interstitialAdListener.onWillClose();
               InterstitialActivity.this.shouldCallOnClose = false;
            }

            InterstitialActivity.this.finish();
            return null;
         }
      }).execute();
   }

   public void onWillOpenLandingPage(BaseView var1) {
      (new CrashReportTemplate() {
         public Void process() {
            if(Interstitial.interstitialAdListener != null) {
               Interstitial.interstitialAdListener.onWillOpenLandingPage();
            }

            return null;
         }
      }).execute();
   }
}
