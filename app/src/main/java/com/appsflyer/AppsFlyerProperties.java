package com.appsflyer;

import android.content.Context;
import java.util.HashMap;
import java.util.Map;

public class AppsFlyerProperties {
   public static final String AF_KEY = "AppsFlyerKey";
   public static final String APP_ID = "appid";
   public static final String APP_USER_ID = "AppUserId";
   public static final String CHANNEL = "channel";
   public static final String COLLECT_ANDROID_ID = "collectAndroidId";
   public static final String COLLECT_IMEI = "collectIMEI";
   public static final String COLLECT_MAC = "collectMAC";
   public static final String CURRENCY_CODE = "currencyCode";
   public static final String DEVICE_TRACKING_DISABLED = "deviceTrackingDisabled";
   public static final String IS_UPDATE = "IS_UPDATE";
   public static final String USE_HTTP_FALLBACK = "useHttpFallback";
   private static AppsFlyerProperties instance = new AppsFlyerProperties();
   private boolean isLaunchCalled;
   private boolean isOnReceiveCalled;
   private Map properties = new HashMap();
   private String referrer;

   public static AppsFlyerProperties getInstance() {
      return instance;
   }

   public String get(String var1) {
      return (String)this.properties.get(var1);
   }

   public boolean getBoolean(String var1, boolean var2) {
      var1 = this.get(var1);
      return var1 == null?var2:Boolean.valueOf(var1).booleanValue();
   }

   public String getReferrer(Context var1) {
      return this.referrer != null?this.referrer:var1.getSharedPreferences("appsflyer-data", 0).getString("referrer", (String)null);
   }

   protected boolean isLaunchCalled() {
      return this.isLaunchCalled;
   }

   protected boolean isOnReceiveCalled() {
      return this.isOnReceiveCalled;
   }

   public void set(String var1, String var2) {
      this.properties.put(var1, var2);
   }

   public void set(String var1, boolean var2) {
      this.properties.put(var1, Boolean.toString(var2));
   }

   protected void setLaunchCalled() {
      this.isLaunchCalled = true;
   }

   protected void setOnReceiveCalled() {
      this.isOnReceiveCalled = true;
   }

   protected void setReferrer(String var1) {
      this.referrer = var1;
   }
}
