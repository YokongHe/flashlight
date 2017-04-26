package com.amazon.device.ads;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.ViewGroup;
import com.amazon.device.ads.AdActivity$IAdActivityAdapter;
import com.amazon.device.ads.AdController;
import com.amazon.device.ads.AdControllerFactory;
import com.amazon.device.ads.AndroidTargetUtils;
import com.amazon.device.ads.InterstitialAd;
import com.amazon.device.ads.InterstitialAdActivityAdapter$InterstitialAdSDKEventListener;
import com.amazon.device.ads.Log;

@SuppressLint({"NewApi"})
class InterstitialAdActivityAdapter implements AdActivity$IAdActivityAdapter {
   private static final String LOGTAG = InterstitialAdActivityAdapter.class.getSimpleName();
   private Activity activity = null;
   private AdController adController;

   // $FF: synthetic method
   static Activity access$000(InterstitialAdActivityAdapter var0) {
      return var0.activity;
   }

   // $FF: synthetic method
   static AdController access$102(InterstitialAdActivityAdapter var0, AdController var1) {
      var0.adController = var1;
      return var1;
   }

   Activity getActivity() {
      return this.activity;
   }

   AdController getAdController() {
      return AdControllerFactory.getCachedAdController();
   }

   public boolean onBackPressed() {
      return this.adController.onBackButtonPress();
   }

   public void onConfigurationChanged(android.content.res.Configuration var1) {
   }

   public void onCreate() {
      AndroidTargetUtils.enableHardwareAcceleration(this.activity.getWindow());
      this.adController = this.getAdController();
      if(this.adController == null) {
         Log.e(LOGTAG, "Failed to show interstitial ad due to an error in the Activity.");
         InterstitialAd.resetIsAdShowing();
         this.activity.finish();
      } else {
         this.adController.setAdActivity(this.activity);
         this.adController.addSDKEventListener(new InterstitialAdActivityAdapter$InterstitialAdSDKEventListener(this));
         ViewGroup var1 = (ViewGroup)this.adController.getView().getParent();
         if(var1 != null) {
            var1.removeView(this.adController.getView());
         }

         this.activity.setContentView(this.adController.getView());
         this.adController.adShown();
      }
   }

   public void onPause() {
   }

   public void onResume() {
   }

   public void onStop() {
      if(this.activity.isFinishing() && this.adController != null) {
         this.adController.closeAd();
      }

   }

   public void preOnCreate() {
      this.activity.requestWindowFeature(1);
      this.activity.getWindow().setFlags(1024, 1024);
      AndroidTargetUtils.hideActionAndStatusBars(this.activity);
   }

   public void setActivity(Activity var1) {
      this.activity = var1;
   }
}
