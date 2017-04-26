package com.smaato.soma.internal.requests;

import com.smaato.soma.AdDimension;
import com.smaato.soma.AdSettings;
import com.smaato.soma.AdType;
import com.smaato.soma.debug.Debugger;
import com.smaato.soma.exception.GeneratingAdSettingsRequestFailed;
import java.util.Locale;

public class InternalAdSettings {
   private AdSettings adSettings;

   public InternalAdSettings(AdSettings var1) {
      this.adSettings = var1;
   }

   public StringBuffer getRequestString() {
      try {
         Debugger.methodStart(new Object() {
         });
         StringBuffer var1 = new StringBuffer();
         if(this.adSettings.getPublisherId() >= 0) {
            var1.append(String.format(Locale.US, "pub=%d", new Object[]{Integer.valueOf(this.adSettings.getPublisherId())}));
         }

         if(this.adSettings.getAdspaceId() >= 0) {
            var1.append(String.format(Locale.US, "&adspace=%d", new Object[]{Integer.valueOf(this.adSettings.getAdspaceId())}));
         }

         if(AdType.getStringForValue(this.adSettings.getAdType()).length() > 0) {
            var1.append(String.format(Locale.US, "&format=%s", new Object[]{AdType.getStringForValue(this.adSettings.getAdType())}));
            var1.append(String.format(Locale.US, "&formatstrict=%s", new Object[]{Boolean.valueOf(this.adSettings.isFormatStrict())}));
         }

         if(AdDimension.getStringForValue(this.adSettings.getAdDimension()).length() > 0) {
            var1.append(String.format(Locale.US, "&dimension=%s", new Object[]{AdDimension.getStringForValue(this.adSettings.getAdDimension())}));
            var1.append("&dimensionstrict=" + this.adSettings.isDimensionStrict());
         }

         if(this.adSettings.getBannerWidth() > 0) {
            var1.append(String.format(Locale.US, "&width=%d", new Object[]{Integer.valueOf(this.adSettings.getBannerWidth())}));
         }

         if(this.adSettings.getBannerHeight() > 0) {
            var1.append(String.format(Locale.US, "&height=%d", new Object[]{Integer.valueOf(this.adSettings.getBannerHeight())}));
         }

         return var1;
      } catch (RuntimeException var2) {
         throw var2;
      } catch (Exception var3) {
         throw new GeneratingAdSettingsRequestFailed(var3);
      }
   }
}
