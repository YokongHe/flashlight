package com.smaato.soma.interstitial;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.FrameLayout.LayoutParams;
import com.smaato.soma.BaseView;
import com.smaato.soma.CrashReportTemplate;
import com.smaato.soma.bannerutilities.BannerAnimator;
import com.smaato.soma.interstitial.InterstitialBannerView;
import com.smaato.soma.measurements.BannerMeasurements;
import java.lang.ref.WeakReference;

class InterstitialBannerView$BannerHandler extends Handler {
   private WeakReference mParentRef;
   private BaseView parent;
   // $FF: synthetic field
   final InterstitialBannerView this$0;

   private InterstitialBannerView$BannerHandler(InterstitialBannerView var1, BaseView var2) {
      this.this$0 = var1;
      this.mParentRef = null;
      this.parent = var2;
   }

   // $FF: synthetic method
   InterstitialBannerView$BannerHandler(InterstitialBannerView var1, BaseView var2, InterstitialBannerView$BannerHandler var3) {
      this(var1, var2);
   }

   protected WeakReference getParentRef() {
      if(this.mParentRef == null) {
         this.mParentRef = new WeakReference(this.parent);
      }

      return this.mParentRef;
   }

   public void handleMessage(final Message var1) {
      super.handleMessage(var1);
      (new CrashReportTemplate() {
         public Void process() {
            BaseView var1x = (BaseView)InterstitialBannerView$BannerHandler.this.getParentRef().get();
            if(var1x == null) {
               return null;
            } else if(var1.what == 101) {
               var1x.getBannerState().transitionExpandBanner();
               BannerAnimator.getInstance().expandView(var1.arg1, var1.arg2, InterstitialBannerView.access$0(InterstitialBannerView$BannerHandler.this.this$0), var1x, InterstitialBannerView.access$1(InterstitialBannerView$BannerHandler.this.this$0));
               BannerMeasurements.getInstance().didClick();
               InterstitialBannerView.access$2(InterstitialBannerView$BannerHandler.this.this$0);
               return null;
            } else if(var1.what == 103) {
               Log.e(this.getClass().getCanonicalName(), "resize");
               InterstitialBannerView.access$0(InterstitialBannerView$BannerHandler.this.this$0).getView().setLayoutParams(new LayoutParams(var1.arg1, var1.arg2));
               InterstitialBannerView.access$0(InterstitialBannerView$BannerHandler.this.this$0).getView().requestLayout();
               return null;
            } else {
               var1x.getBannerState().transitionCloseOrmma();
               return null;
            }
         }
      }).execute();
   }
}
