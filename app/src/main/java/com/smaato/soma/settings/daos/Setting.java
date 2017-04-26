package com.smaato.soma.settings.daos;

import com.smaato.soma.settings.enums.BaseUserSettings;

public class Setting {
   private boolean enabled = true;
   private BaseUserSettings settingsType;
   private String value;

   public Setting() {
   }

   public Setting(BaseUserSettings var1, String var2, boolean var3) {
      this.settingsType = var1;
      this.value = var2;
      this.enabled = var3;
   }

   public final BaseUserSettings getSettingsType() {
      return this.settingsType;
   }

   public final String getValue() {
      return this.value;
   }

   public final boolean isEnabled() {
      return this.enabled;
   }

   public final void setEnabled(boolean var1) {
      this.enabled = var1;
   }

   public final void setSettingsType(BaseUserSettings var1) {
      this.settingsType = var1;
   }

   public final void setValue(String var1) {
      this.value = var1;
   }
}
