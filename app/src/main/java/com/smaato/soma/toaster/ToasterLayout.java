package com.smaato.soma.toaster;

import android.content.Context;
import android.os.Handler;
import com.smaato.soma.BaseView;
import com.smaato.soma.ToasterBanner;
import com.smaato.soma.bannerutilities.AbstractBannerPackage;
import com.smaato.soma.toaster.ToasterLayout$BannerHandler;

public class ToasterLayout extends BaseView {
   ToasterBanner mToasterBanner;

   public ToasterLayout(Context var1, ToasterBanner var2) {
      super(var1);
      this.mToasterBanner = var2;
   }

   // $FF: synthetic method
   static AbstractBannerPackage access$0(ToasterLayout var0) {
      return var0.getCurrentPackage();
   }

   // $FF: synthetic method
   static float access$1(ToasterLayout var0) {
      return var0.mDensity;
   }

   public Handler getBannerAnimatorHandler() {
      if(this.handler == null) {
         this.setBannerAnimatorHandler(new ToasterLayout$BannerHandler(this, this, (ToasterLayout$BannerHandler)null));
      }

      return this.handler;
   }

   public boolean switchViews() {
      boolean var1 = super.switchViews();
      this.mToasterBanner.appear();
      return var1;
   }
}
