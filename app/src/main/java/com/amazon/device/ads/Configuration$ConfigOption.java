package com.amazon.device.ads;

public class Configuration$ConfigOption {
   public static final Configuration$ConfigOption AAX_HOSTNAME = new Configuration$ConfigOption("config-aaxHostname", String.class, "aaxHostname", "debug.aaxHostname");
   public static final Configuration$ConfigOption AD_PREF_URL = new Configuration$ConfigOption("config-adPrefURL", String.class, "adPrefURL", "debug.adPrefURL");
   public static final Configuration$ConfigOption MADS_HOSTNAME = new Configuration$ConfigOption("config-madsHostname", String.class, "madsHostname", "debug.madsHostname", true);
   public static final Configuration$ConfigOption SEND_GEO = new Configuration$ConfigOption("config-sendGeo", Boolean.class, "sendGeo", "debug.sendGeo");
   public static final Configuration$ConfigOption SIS_DOMAIN = new Configuration$ConfigOption("config-sisDomain", String.class, "sisDomain", "debug.sisDomain");
   public static final Configuration$ConfigOption SIS_URL = new Configuration$ConfigOption("config-sisURL", String.class, "sisURL", "debug.sisURL");
   public static final Configuration$ConfigOption[] configOptions;
   private final boolean allowEmpty;
   private final Class dataType;
   private final String debugProperty;
   private final String responseKey;
   private final String settingsName;

   static {
      configOptions = new Configuration$ConfigOption[]{AAX_HOSTNAME, SIS_URL, AD_PREF_URL, MADS_HOSTNAME, SIS_DOMAIN, SEND_GEO};
   }

   protected Configuration$ConfigOption(String var1, Class var2, String var3, String var4) {
      this(var1, var2, var3, var4, false);
   }

   protected Configuration$ConfigOption(String var1, Class var2, String var3, String var4, boolean var5) {
      this.settingsName = var1;
      this.responseKey = var3;
      this.dataType = var2;
      this.debugProperty = var4;
      this.allowEmpty = var5;
   }

   boolean getAllowEmpty() {
      return this.allowEmpty;
   }

   Class getDataType() {
      return this.dataType;
   }

   String getDebugProperty() {
      return this.debugProperty;
   }

   String getResponseKey() {
      return this.responseKey;
   }

   String getSettingsName() {
      return this.settingsName;
   }
}
