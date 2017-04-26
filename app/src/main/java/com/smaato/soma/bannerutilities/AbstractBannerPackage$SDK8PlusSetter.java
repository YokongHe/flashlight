package com.smaato.soma.bannerutilities;

import android.webkit.WebSettings;
import android.webkit.WebSettings.PluginState;
import com.smaato.soma.bannerutilities.AbstractBannerPackage;
import com.smaato.soma.bannerutilities.AbstractBannerPackage$SDK7PlusSetter;
import com.smaato.soma.bannerutilities.AbstractBannerPackage$WebSettingsSetter;
import com.smaato.soma.exception.UnableToApplySDKSettings;

class AbstractBannerPackage$SDK8PlusSetter extends AbstractBannerPackage$SDK7PlusSetter implements AbstractBannerPackage$WebSettingsSetter {
   // $FF: synthetic field
   final AbstractBannerPackage this$0;

   private AbstractBannerPackage$SDK8PlusSetter(AbstractBannerPackage var1) {
      super(var1, (AbstractBannerPackage$SDK7PlusSetter)null);
      this.this$0 = var1;
   }

   // $FF: synthetic method
   AbstractBannerPackage$SDK8PlusSetter(AbstractBannerPackage var1, AbstractBannerPackage$SDK8PlusSetter var2) {
      this(var1);
   }

   public void applyWebSettings(WebSettings var1) {
      try {
         super.applyWebSettings(var1);
         var1.setPluginState(PluginState.ON);
      } catch (RuntimeException var2) {
         throw var2;
      } catch (Exception var3) {
         throw new UnableToApplySDKSettings(var3);
      }
   }
}
