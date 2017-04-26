package com.smaato.soma;

import android.os.Handler;
import android.os.Message;
import com.smaato.soma.BaseView;
import com.smaato.soma.CrashReportTemplate;
import com.smaato.soma.FullScreenBanner$FullScreenView;
import com.smaato.soma.bannerutilities.BannerAnimator;
import java.lang.ref.WeakReference;

class FullScreenBanner$FullScreenView$BannerHandler extends Handler {
   private WeakReference mParentRef;
   private BaseView parent;
   // $FF: synthetic field
   final FullScreenBanner$FullScreenView this$1;

   private FullScreenBanner$FullScreenView$BannerHandler(FullScreenBanner$FullScreenView var1, BaseView var2) {
      this.this$1 = var1;
      this.mParentRef = null;
      this.parent = var2;
   }

   // $FF: synthetic method
   FullScreenBanner$FullScreenView$BannerHandler(FullScreenBanner$FullScreenView var1, BaseView var2, FullScreenBanner$FullScreenView$BannerHandler var3) {
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
            BaseView var1x = (BaseView)FullScreenBanner$FullScreenView$BannerHandler.this.getParentRef().get();
            if(var1x != null) {
               if(var1.what == 101) {
                  var1x.getBannerState().transitionExpandBanner();
                  BannerAnimator.getInstance().expandView(var1.arg1, var1.arg2, FullScreenBanner$FullScreenView$BannerHandler.this.this$1.getCurrentPackage(), var1x, FullScreenBanner$FullScreenView$BannerHandler.this.this$1.mDensity);
                  return null;
               }

               if(var1.what == 102) {
                  var1x.getBannerState().transitionCloseNoOrmma();
                  return null;
               }

               if(var1.what == 107) {
                  var1x.getBannerState().transitionCloseNoOrmma();
                  return null;
               }
            }

            return null;
         }
      }).execute();
   }
}
