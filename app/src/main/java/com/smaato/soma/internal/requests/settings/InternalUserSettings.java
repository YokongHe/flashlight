package com.smaato.soma.internal.requests.settings;

import com.smaato.soma.debug.Debugger;
import com.smaato.soma.exception.GenerateUserSettingsFailed;
import com.smaato.soma.internal.requests.settings.UserSettings;
import com.smaato.soma.internal.requests.settings.UserSettings$Gender;
import com.smaato.soma.internal.utilities.StringFormatter;
import java.util.Locale;

public class InternalUserSettings {
   private UserSettings userSettings;

   public InternalUserSettings(UserSettings var1) {
      this.userSettings = var1;
   }

   public final StringBuffer getRequestString() {
      try {
         Debugger.methodStart(new Object() {
         });
         StringBuffer var1 = new StringBuffer();
         var1.append("&coppa=" + this.userSettings.isCOPPA());
         if(UserSettings$Gender.getStringForValue(this.userSettings.mUserGender).length() > 0) {
            var1.append(String.format(Locale.US, "&gender=%s", new Object[]{StringFormatter.stringToUTF8(UserSettings$Gender.getStringForValue(this.userSettings.mUserGender))}));
         }

         if(this.userSettings.getAge() > 0) {
            var1.append(String.format(Locale.US, "&age=%d", new Object[]{Integer.valueOf(this.userSettings.getAge())}));
         }

         if(this.userSettings.mKeywordList != null && this.userSettings.mKeywordList.length() > 0) {
            var1.append(String.format(Locale.US, "&kws=%s", new Object[]{StringFormatter.stringToUTF8(this.userSettings.mKeywordList)}));
         }

         if(this.userSettings.mSearchQuery != null && this.userSettings.mSearchQuery.length() > 0) {
            var1.append(String.format(Locale.US, "&qs=%s", new Object[]{StringFormatter.stringToUTF8(this.userSettings.mSearchQuery)}));
         }

         if(this.userSettings.mRegion != null && this.userSettings.mRegion.length() > 0) {
            var1.append(String.format(Locale.US, "&region=%s", new Object[]{StringFormatter.stringToUTF8(this.userSettings.mRegion)}));
         }

         if(this.userSettings.mCity != null && this.userSettings.mCity.length() > 0) {
            var1.append(String.format(Locale.US, "&city=%s", new Object[]{StringFormatter.stringToUTF8(this.userSettings.mCity)}));
         }

         return var1;
      } catch (RuntimeException var2) {
         throw var2;
      } catch (Exception var3) {
         throw new GenerateUserSettingsFailed(var3);
      }
   }
}
