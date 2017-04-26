package com.smaato.soma;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.FrameLayout.LayoutParams;
import com.smaato.soma.BannerView;
import com.smaato.soma.BaseView;
import com.smaato.soma.CrashReportTemplate;
import com.smaato.soma.bannerutilities.BannerAnimator;
import com.smaato.soma.measurements.BannerMeasurements;
import java.lang.ref.WeakReference;

class BannerView$BannerHandler extends Handler {
   private WeakReference mParentRef;
   private BaseView parent;
   // $FF: synthetic field
   final BannerView this$0;

   private BannerView$BannerHandler(BannerView var1, BaseView var2) {
      this.this$0 = var1;
      this.mParentRef = null;
      this.parent = var2;
   }

   // $FF: synthetic method
   BannerView$BannerHandler(BannerView var1, BaseView var2, BannerView$BannerHandler var3) {
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
            BaseView var1x = (BaseView)BannerView$BannerHandler.this.getParentRef().get();
            if(var1x != null) {
               if(var1.what == 101) {
                  var1x.getBannerState().transitionExpandBanner();
                  BannerAnimator.getInstance().expandView(var1.arg1, var1.arg2, BannerView$BannerHandler.this.this$0.getCurrentPackage(), var1x, BannerView$BannerHandler.this.this$0.mDensity);
                  BannerView$BannerHandler.this.this$0.pauseAutoReload();
                  BannerMeasurements.getInstance().didClick();
                  BannerView$BannerHandler.this.this$0.pauseAutoReload();
                  return null;
               }

               if(var1.what == 102) {
                  if(var1x.getCurrentPackage().isOrmma()) {
                     var1x.getBannerState().transitionCloseOrmma();
                  } else {
                     var1x.getBannerState().transitionCloseNoOrmma();
                  }

                  BannerView.access$3(BannerView$BannerHandler.this.this$0);
                  return null;
               }

               if(var1.what == 103) {
                  Log.e(this.getClass().getCanonicalName(), "resize");
                  BannerView$BannerHandler.this.this$0.getCurrentPackage().getView().setLayoutParams(new LayoutParams(var1.arg1, var1.arg2));
                  BannerView$BannerHandler.this.this$0.getCurrentPackage().getView().requestLayout();
                  return null;
               }

               if(var1.what == 107) {
                  BannerAnimator.getInstance().setGooglePlayBanner(true);
                  var1x.getBannerState().transitionCloseOrmma();
                  return null;
               }
            }

            return null;
         }
      }).execute();
   }
}
