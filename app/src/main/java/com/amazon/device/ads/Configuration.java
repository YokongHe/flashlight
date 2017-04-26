package com.amazon.device.ads;

import com.amazon.device.ads.AdvertisingIdentifier;
import com.amazon.device.ads.AdvertisingIdentifier$Info;
import com.amazon.device.ads.Configuration$ConfigOption;
import com.amazon.device.ads.Configuration$ConfigurationListener;
import com.amazon.device.ads.DebugProperties;
import com.amazon.device.ads.DeviceInfo;
import com.amazon.device.ads.InternalAdRegistration;
import com.amazon.device.ads.Log;
import com.amazon.device.ads.Metrics;
import com.amazon.device.ads.Metrics$MetricType;
import com.amazon.device.ads.NumberUtils;
import com.amazon.device.ads.PreferredMarketplaceRetriever;
import com.amazon.device.ads.PreferredMarketplaceRetriever$NullPreferredMarketplaceRetriever;
import com.amazon.device.ads.RegistrationInfo;
import com.amazon.device.ads.Settings;
import com.amazon.device.ads.StringUtils;
import com.amazon.device.ads.ThreadUtils;
import com.amazon.device.ads.Version;
import com.amazon.device.ads.WebRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

class Configuration {
   private static final String AAX_MSDK_CONFIG_ENDPOINT = "/e/msdk/cfg";
   private static final String AAX_PROD_US_HOSTNAME = "aax-us-east.amazon-adsystem.com";
   protected static final String CONFIG_APP_DEFINED_MARKETPLACE = "config-appDefinedMarketplace";
   protected static final String CONFIG_LASTFETCHTIME = "config-lastFetchTime";
   protected static final String CONFIG_TTL = "config-ttl";
   protected static final String CONFIG_VERSION_NAME = "configVersion";
   protected static final int CURRENT_CONFIG_VERSION = 1;
   private static final String LOG_TAG = Configuration.class.getSimpleName();
   protected static final int MAX_CONFIG_TTL = 172800;
   protected static final int MAX_NO_RETRY_TTL = 300000;
   private static Configuration instance = new Configuration();
   private String appDefinedMarketplace = null;
   private boolean isAppDefinedMarketplaceSet = false;
   private AtomicBoolean isFetching = null;
   private boolean isFirstParty = false;
   private Boolean lastTestModeValue = null;
   private List listeners = null;
   private PreferredMarketplaceRetriever pfmRetriever = new PreferredMarketplaceRetriever$NullPreferredMarketplaceRetriever();

   protected Configuration() {
      this.listeners = new ArrayList(5);
      this.isFetching = new AtomicBoolean(false);
   }

   public static final Configuration getInstance() {
      return instance;
   }

   public static int getMaxNoRetryTtl() {
      return DebugProperties.getDebugPropertyAsInteger("debug.noRetryTTLMax", 300000);
   }

   private String getPreferredMarketplace() {
      return this.pfmRetriever.retrievePreferredMarketplace();
   }

   private boolean hasAppDefinedMarketplaceChanged() {
      Settings var1 = Settings.getInstance();
      String var2 = var1.getString("config-appDefinedMarketplace", (String)null);
      if(this.isAppDefinedMarketplaceSet) {
         this.isAppDefinedMarketplaceSet = false;
         if(this.appDefinedMarketplace != null && !this.appDefinedMarketplace.equals(var2)) {
            var1.putLongWithNoFlush("config-lastFetchTime", 0L);
            var1.putStringWithNoFlush("config-appDefinedMarketplace", this.appDefinedMarketplace);
            var1.flush();
            InternalAdRegistration.getInstance().getRegistrationInfo().requestNewSISDeviceIdentifier();
            Log.d(LOG_TAG, "New application-defined marketplace set. A new configuration will be retrieved.");
            return true;
         }

         if(var2 != null && this.appDefinedMarketplace == null) {
            var1.remove("config-appDefinedMarketplace");
            InternalAdRegistration.getInstance().getRegistrationInfo().requestNewSISDeviceIdentifier();
            Log.d(LOG_TAG, "Application-defined marketplace removed. A new configuration will be retrieved.");
            return true;
         }
      }

      return false;
   }

   private void writeSettingFromConfigOption(Configuration$ConfigOption var1, JSONObject var2) {
      if(var1.getDataType().equals(String.class)) {
         String var4 = var2.getString(var1.getResponseKey());
         if(!var1.getAllowEmpty() && StringUtils.isNullOrWhiteSpace(var4)) {
            throw new IllegalArgumentException("The configuration value must not be empty or contain only white spaces.");
         } else {
            Settings.getInstance().putStringWithNoFlush(var1.getSettingsName(), var4);
         }
      } else if(var1.getDataType().equals(Boolean.class)) {
         boolean var3 = var2.getBoolean(var1.getResponseKey());
         Settings.getInstance().putBooleanWithNoFlush(var1.getSettingsName(), var3);
      } else {
         throw new IllegalArgumentException("Undefined configuration option type.");
      }
   }

   protected void beginFetch() {
      ThreadUtils.executeRunnable(new Runnable() {
         public void run() {
            Configuration.this.fetchConfigurationOnBackgroundThread();
         }
      });
   }

   AdvertisingIdentifier$Info createAdvertisingIdentifierInfo() {
      boolean var1 = false;
      AdvertisingIdentifier var2 = new AdvertisingIdentifier();
      if(Settings.getInstance().getInt("configVersion", 0) != 0) {
         var1 = true;
      }

      return var2.setShouldSetCurrentAdvertisingIdentifier(var1).getAdvertisingIdentifierInfo();
   }

   protected WebRequest createWebRequest(AdvertisingIdentifier$Info var1) {
      WebRequest var3 = WebRequest.createJSONGetWebRequest();
      var3.setExternalLogTag(LOG_TAG);
      var3.enableLog(true);
      var3.setHost(DebugProperties.getDebugPropertyAsString("debug.aaxConfigHostname", "aax-us-east.amazon-adsystem.com"));
      var3.setPath("/e/msdk/cfg");
      var3.setMetricsCollector(Metrics.getInstance().getMetricsCollector());
      var3.setServiceCallLatencyMetric(Metrics$MetricType.AAX_CONFIG_DOWNLOAD_LATENCY);
      var3.setUseSecure(DebugProperties.getDebugPropertyAsBoolean("debug.aaxConfigUseSecure", true));
      RegistrationInfo var4 = InternalAdRegistration.getInstance().getRegistrationInfo();
      DeviceInfo var5 = InternalAdRegistration.getInstance().getDeviceInfo();
      var3.putUnencodedQueryParameter("appId", var4.getAppKey());
      var3.putUnencodedQueryParameter("dinfo", var5.getDInfoProperty().toString());
      var3.putUnencodedQueryParameter("adId", var1.getSISDeviceIdentifier());
      var3.putUnencodedQueryParameter("sdkVer", Version.getSDKVersion());
      var3.putUnencodedQueryParameter("fp", Boolean.toString(this.isFirstParty));
      var3.putUnencodedQueryParameter("mkt", Settings.getInstance().getString("config-appDefinedMarketplace", (String)null));
      var3.putUnencodedQueryParameter("pfm", this.getPreferredMarketplace());
      boolean var2 = Settings.getInstance().getBoolean("testingEnabled", false);
      this.setLastTestModeValue(var2);
      if(var2) {
         var3.putUnencodedQueryParameter("testMode", "true");
      }

      var3.setAdditionalQueryParamsString(DebugProperties.getDebugPropertyAsString("debug.aaxConfigParams", (String)null));
      return var3;
   }

   protected void fetchConfigurationOnBackgroundThread() {
      // $FF: Couldn't be decompiled
   }

   protected Configuration$ConfigurationListener[] getAndClearListeners() {
      synchronized(this){}

      Configuration$ConfigurationListener[] var1;
      try {
         var1 = new Configuration$ConfigurationListener[this.listeners.size()];
         var1 = (Configuration$ConfigurationListener[])this.listeners.toArray(var1);
         this.listeners.clear();
      } finally {
         ;
      }

      return var1;
   }

   public String getAppDefinedMarketplace() {
      return this.appDefinedMarketplace;
   }

   public boolean getBoolean(Configuration$ConfigOption var1) {
      return this.getBooleanWithDefault(var1, false);
   }

   public boolean getBooleanWithDefault(Configuration$ConfigOption var1, boolean var2) {
      return DebugProperties.containsDebugProperty(var1.getDebugProperty())?DebugProperties.getDebugPropertyAsBoolean(var1.getDebugProperty(), var2):Settings.getInstance().getBoolean(var1.getSettingsName(), var2);
   }

   protected Configuration$ConfigOption[] getConfigOptions() {
      return Configuration$ConfigOption.configOptions;
   }

   PreferredMarketplaceRetriever getPreferredMarketplaceRetriever() {
      return this.pfmRetriever;
   }

   public String getString(Configuration$ConfigOption var1) {
      String var3 = DebugProperties.getDebugPropertyAsString(var1.getDebugProperty(), (String)null);
      String var2 = var3;
      if(var3 == null) {
         var2 = Settings.getInstance().getString(var1.getSettingsName(), (String)null);
      }

      return var2;
   }

   protected boolean isFetching() {
      return this.isFetching.get();
   }

   boolean isFirstParty() {
      return this.isFirstParty;
   }

   protected long nanoTime() {
      return System.nanoTime();
   }

   protected void onFetchFailure() {
      // $FF: Couldn't be decompiled
   }

   protected void onFetchSuccess() {
      // $FF: Couldn't be decompiled
   }

   public void queueConfigurationListener(Configuration$ConfigurationListener var1) {
      synchronized(this){}

      try {
         this.queueConfigurationListener(var1, true);
      } finally {
         ;
      }

   }

   public void queueConfigurationListener(Configuration$ConfigurationListener param1, boolean param2) {
      // $FF: Couldn't be decompiled
   }

   public void setAppDefinedMarketplace(String var1) {
      this.appDefinedMarketplace = var1;
      this.isAppDefinedMarketplaceSet = true;
   }

   protected void setIsFetching(boolean var1) {
      this.isFetching.set(var1);
   }

   public void setIsFirstParty(boolean var1) {
      this.isFirstParty = var1;
   }

   protected void setLastTestModeValue(boolean var1) {
      this.lastTestModeValue = Boolean.valueOf(var1);
   }

   public void setPreferredMarketplaceRetriever(PreferredMarketplaceRetriever var1) {
      this.pfmRetriever = var1;
   }

   protected boolean shouldFetch() {
      Settings var7 = Settings.getInstance();
      if(!this.hasAppDefinedMarketplaceChanged() && Settings.getInstance().getInt("configVersion", 0) == 1) {
         long var1 = this.nanoTime();
         long var3 = var7.getLong("config-lastFetchTime", 0L);
         long var5 = (long)var7.getInt("config-ttl", 172800);
         if(var3 == 0L) {
            Log.d(LOG_TAG, "No configuration found. A new configuration will be retrieved.");
            return true;
         }

         if(var1 - var3 > NumberUtils.convertToNsFromS(var5)) {
            Log.d(LOG_TAG, "The configuration has expired. A new configuration will be retrieved.");
            return true;
         }

         if(this.lastTestModeValue != null && this.lastTestModeValue.booleanValue() != var7.getBoolean("testingEnabled", false)) {
            Log.d(LOG_TAG, "The testing mode has changed. A new configuration will be retrieved.");
            return true;
         }

         if(!DebugProperties.getDebugPropertyAsBoolean("debug.shouldFetchConfig", false)) {
            return false;
         }
      }

      return true;
   }
}
