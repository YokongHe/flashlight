package com.mopub.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.view.Display;
import android.view.WindowManager;
import com.mopub.common.ClientMetadata$MoPubNetworkType;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Utils;
import java.util.Locale;

public class ClientMetadata {
   private static final String DEVICE_ORIENTATION_LANDSCAPE = "l";
   private static final String DEVICE_ORIENTATION_PORTRAIT = "p";
   private static final String DEVICE_ORIENTATION_SQUARE = "s";
   private static final String DEVICE_ORIENTATION_UNKNOWN = "u";
   private static final String IFA_PREFIX = "ifa:";
   private static final String SHA_PREFIX = "sha:";
   private static final int TYPE_ETHERNET = 9;
   private static final int UNKNOWN_NETWORK = -1;
   private static ClientMetadata sInstance;
   private boolean mAdvertisingInfoSet = false;
   private String mAppName;
   private final String mAppPackageName;
   private final String mAppVersion;
   private final ConnectivityManager mConnectivityManager;
   private final Context mContext;
   private final String mDeviceManufacturer;
   private final String mDeviceModel;
   private final String mDeviceOsVersion;
   private final String mDeviceProduct;
   private final int mDeviceScreenHeightPx;
   private final int mDeviceScreenWidthPx;
   private boolean mDoNotTrack = false;
   private final String mIsoCountryCode;
   private final String mNetworkOperator;
   private String mNetworkOperatorForUrl;
   private String mNetworkOperatorName;
   private final String mSdkVersion;
   private final String mSimIsoCountryCode;
   private String mSimOperator;
   private String mSimOperatorName;
   private String mUdid;

   public ClientMetadata(Context var1) {
      this.mContext = var1.getApplicationContext();
      this.mConnectivityManager = (ConnectivityManager)this.mContext.getSystemService("connectivity");
      this.mDeviceManufacturer = Build.MANUFACTURER;
      this.mDeviceModel = Build.MODEL;
      this.mDeviceProduct = Build.PRODUCT;
      this.mDeviceOsVersion = VERSION.RELEASE;
      Display var2 = ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay();
      this.mDeviceScreenWidthPx = var2.getWidth();
      this.mDeviceScreenHeightPx = var2.getHeight();
      this.mSdkVersion = "3.4.0";
      this.mAppVersion = getAppVersionFromContext(this.mContext);
      PackageManager var6 = this.mContext.getPackageManager();
      this.mAppPackageName = var1.getPackageName();

      ApplicationInfo var5;
      try {
         var5 = var6.getApplicationInfo(this.mAppPackageName, 0);
      } catch (NameNotFoundException var4) {
         var5 = null;
      }

      if(var5 != null) {
         this.mAppName = (String)var6.getApplicationLabel(var5);
      }

      TelephonyManager var7 = (TelephonyManager)this.mContext.getSystemService("phone");
      this.mNetworkOperatorForUrl = var7.getNetworkOperator();
      this.mNetworkOperator = var7.getNetworkOperator();
      if(var7.getPhoneType() == 2 && var7.getSimState() == 5) {
         this.mNetworkOperatorForUrl = var7.getSimOperator();
         this.mSimOperator = var7.getSimOperator();
      }

      this.mIsoCountryCode = var7.getNetworkCountryIso();
      this.mSimIsoCountryCode = var7.getSimCountryIso();

      try {
         this.mNetworkOperatorName = var7.getNetworkOperatorName();
         if(var7.getSimState() == 5) {
            this.mSimOperatorName = var7.getSimOperatorName();
         }
      } catch (SecurityException var3) {
         this.mNetworkOperatorName = null;
         this.mSimOperatorName = null;
      }

      this.mUdid = getDeviceIdFromContext(this.mContext);
   }

   @VisibleForTesting
   public static void clearForTesting() {
      sInstance = null;
   }

   private static String getAppVersionFromContext(Context var0) {
      try {
         String var1 = var0.getPackageName();
         String var3 = var0.getPackageManager().getPackageInfo(var1, 0).versionName;
         return var3;
      } catch (Exception var2) {
         MoPubLog.d("Failed to retrieve PackageInfo#versionName.");
         return null;
      }
   }

   private static String getDeviceIdFromContext(Context var0) {
      String var1 = Secure.getString(var0.getContentResolver(), "android_id");
      if(var1 == null) {
         var1 = "";
      } else {
         var1 = Utils.sha1(var1);
      }

      return "sha:" + var1;
   }

   public static ClientMetadata getInstance() {
      ClientMetadata var1 = sInstance;
      ClientMetadata var0 = var1;
      if(var1 == null) {
         synchronized(ClientMetadata.class) {
            var0 = sInstance;
         }
      }

      return var0;
   }

   public static ClientMetadata getInstance(Context param0) {
      // $FF: Couldn't be decompiled
   }

   public ClientMetadata$MoPubNetworkType getActiveNetworkType() {
      byte var2 = -1;
      int var1 = var2;
      if(this.mContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {
         NetworkInfo var3 = this.mConnectivityManager.getActiveNetworkInfo();
         var1 = var2;
         if(var3 != null) {
            var1 = var3.getType();
         }
      }

      return ClientMetadata$MoPubNetworkType.access$2(var1);
   }

   public String getAppName() {
      return this.mAppName;
   }

   public String getAppPackageName() {
      return this.mAppPackageName;
   }

   public String getAppVersion() {
      return this.mAppVersion;
   }

   public float getDensity() {
      return this.mContext.getResources().getDisplayMetrics().density;
   }

   public String getDeviceId() {
      synchronized(this){}

      String var1;
      try {
         var1 = this.mUdid;
      } finally {
         ;
      }

      return var1;
   }

   public Locale getDeviceLocale() {
      return this.mContext.getResources().getConfiguration().locale;
   }

   public String getDeviceManufacturer() {
      return this.mDeviceManufacturer;
   }

   public String getDeviceModel() {
      return this.mDeviceModel;
   }

   public String getDeviceOsVersion() {
      return this.mDeviceOsVersion;
   }

   public String getDeviceProduct() {
      return this.mDeviceProduct;
   }

   public int getDeviceScreenHeightPx() {
      return this.mDeviceScreenHeightPx;
   }

   public int getDeviceScreenWidthPx() {
      return this.mDeviceScreenWidthPx;
   }

   public String getIsoCountryCode() {
      return this.mIsoCountryCode;
   }

   public String getNetworkOperator() {
      return this.mNetworkOperator;
   }

   public String getNetworkOperatorForUrl() {
      return this.mNetworkOperatorForUrl;
   }

   public String getNetworkOperatorName() {
      return this.mNetworkOperatorName;
   }

   public String getOrientationString() {
      int var1 = this.mContext.getResources().getConfiguration().orientation;
      String var2 = "u";
      if(var1 == 1) {
         var2 = "p";
      } else {
         if(var1 == 2) {
            return "l";
         }

         if(var1 == 3) {
            return "s";
         }
      }

      return var2;
   }

   public String getSdkVersion() {
      return this.mSdkVersion;
   }

   public String getSimIsoCountryCode() {
      return this.mSimIsoCountryCode;
   }

   public String getSimOperator() {
      return this.mSimOperator;
   }

   public String getSimOperatorName() {
      return this.mSimOperatorName;
   }

   public boolean isAdvertisingInfoSet() {
      synchronized(this){}

      boolean var1;
      try {
         var1 = this.mAdvertisingInfoSet;
      } finally {
         ;
      }

      return var1;
   }

   public boolean isDoNotTrackSet() {
      synchronized(this){}

      boolean var1;
      try {
         var1 = this.mDoNotTrack;
      } finally {
         ;
      }

      return var1;
   }

   public void setAdvertisingInfo(String var1, boolean var2) {
      synchronized(this){}

      try {
         this.mUdid = "ifa:" + var1;
         this.mDoNotTrack = var2;
         this.mAdvertisingInfoSet = true;
      } finally {
         ;
      }

   }
}
