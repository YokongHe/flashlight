package com.smaato.soma.bannerutilities;

import android.webkit.WebSettings;
import com.smaato.soma.bannerutilities.AbstractBannerPackage;
import com.smaato.soma.bannerutilities.AbstractBannerPackage$WebSettingsSetter;

class AbstractBannerPackage$SDK7PlusSetter implements AbstractBannerPackage$WebSettingsSetter {
   // $FF: synthetic field
   final AbstractBannerPackage this$0;

   private AbstractBannerPackage$SDK7PlusSetter(AbstractBannerPackage var1) {
      this.this$0 = var1;
   }

   // $FF: synthetic method
   AbstractBannerPackage$SDK7PlusSetter(AbstractBannerPackage var1, AbstractBannerPackage$SDK7PlusSetter var2) {
      this(var1);
   }

   // $FF: synthetic method
   AbstractBannerPackage$SDK7PlusSetter(AbstractBannerPackage var1, AbstractBannerPackage$SDK7PlusSetter var2, AbstractBannerPackage$SDK7PlusSetter var3) {
      this(var1);
   }

   public void applyWebSettings(WebSettings var1) {
      var1.setLoadWithOverviewMode(true);
   }
}
