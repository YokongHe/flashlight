package com.smaato.soma.interstitial;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import com.smaato.soma.BaseView;
import com.smaato.soma.CrashReportTemplate;
import com.smaato.soma.bannerutilities.AbstractBannerPackage;
import com.smaato.soma.interstitial.Interstitial;
import com.smaato.soma.interstitial.InterstitialBannerView$BannerHandler;

public class InterstitialBannerView extends BaseView {
   private InterstitialBannerView$BannerHandler mHandler;
   private Interstitial mParent;
   private boolean shouldNotifyIdle = false;

   public InterstitialBannerView(Context var1) {
      super(var1);
   }

   // $FF: synthetic method
   static AbstractBannerPackage access$0(InterstitialBannerView var0) {
      return var0.getCurrentPackage();
   }

   // $FF: synthetic method
   static float access$1(InterstitialBannerView var0) {
      return var0.mDensity;
   }

   // $FF: synthetic method
   static void access$2(InterstitialBannerView var0) {
      var0.pauseAutoReload();
   }

   protected boolean asyncLoadBeacon() {
      return super.asyncLoadBeacon();
   }

   public final Context getActivityContext() {
      return this.mCurrentPackage.getContext();
   }

   public Handler getBannerAnimatorHandler() {
      if(this.mHandler == null) {
         this.mHandler = new InterstitialBannerView$BannerHandler(this, this, (InterstitialBannerView$BannerHandler)null);
      }

      return this.mHandler;
   }

   protected void isBannerIdle() {
      (new CrashReportTemplate() {
         public Void process() {
            if(InterstitialBannerView.this.shouldNotifyIdle) {
               InterstitialBannerView.this.mParent.setStateToReady();
               Interstitial.interstitialAdListener.onReadyToShow();
               InterstitialBannerView.this.shouldNotifyIdle = false;
            }

            return null;
         }
      }).execute();
      super.isBannerIdle();
   }

   protected final boolean isShouldNotifyIdle() {
      return this.shouldNotifyIdle;
   }

   protected void onAttachedToWindow() {
      (new CrashReportTemplate() {
         public Void process() {
            InterstitialBannerView.this.asyncLoadBeacon();
            return null;
         }
      }).execute();
      super.onAttachedToWindow();
   }

   protected void setContext(final Activity var1) {
      (new CrashReportTemplate() {
         public Void process() {
            InterstitialBannerView.this.mCurrentPackage.setContext(var1);
            return null;
         }
      }).execute();
   }

   public void setInterstitialParent(Interstitial var1) {
      this.mParent = var1;
   }

   protected final void setShouldNotifyIdle(boolean var1) {
      this.shouldNotifyIdle = var1;
   }
}
