package com.smaato.soma.toaster;

import android.os.Handler;
import android.os.Message;
import com.smaato.soma.BaseView;
import com.smaato.soma.CrashReportTemplate;
import com.smaato.soma.bannerutilities.BannerAnimator;
import com.smaato.soma.debug.Debugger;
import com.smaato.soma.toaster.ToasterLayout;
import java.lang.ref.WeakReference;

class ToasterLayout$BannerHandler extends Handler {
   private WeakReference mParentRef;
   private BaseView parent;
   // $FF: synthetic field
   final ToasterLayout this$0;

   private ToasterLayout$BannerHandler(ToasterLayout var1, BaseView var2) {
      this.this$0 = var1;
      this.mParentRef = null;
      this.parent = var2;
   }

   // $FF: synthetic method
   ToasterLayout$BannerHandler(ToasterLayout var1, BaseView var2, ToasterLayout$BannerHandler var3) {
      this(var1, var2);
   }

   protected WeakReference getParentRef() {
      if(this.mParentRef == null) {
         this.mParentRef = new WeakReference(this.parent);
      }

      return this.mParentRef;
   }

   public void handleMessage(final Message var1) {
      Debugger.methodStart(new Object() {
      });
      super.handleMessage(var1);
      (new CrashReportTemplate() {
         public Void process() {
            BaseView var1x = (BaseView)ToasterLayout$BannerHandler.this.getParentRef().get();
            if(var1x == null) {
               return null;
            } else if(var1.what == 101) {
               var1x.getBannerState().transitionExpandBanner();
               BannerAnimator.getInstance().expandView(var1.arg1, var1.arg2, ToasterLayout.access$0(ToasterLayout$BannerHandler.this.this$0), var1x, ToasterLayout.access$1(ToasterLayout$BannerHandler.this.this$0));
               ToasterLayout$BannerHandler.this.this$0.mToasterBanner.disappear();
               return null;
            } else {
               var1x.getBannerState().transitionCloseOrmma();
               return null;
            }
         }
      }).execute();
   }
}
