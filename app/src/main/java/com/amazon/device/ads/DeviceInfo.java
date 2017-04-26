package com.amazon.device.ads;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.amazon.device.ads.ConnectionInfo;
import com.amazon.device.ads.DisplayUtils;
import com.amazon.device.ads.InternalAdRegistration;
import com.amazon.device.ads.JSONUtils;
import com.amazon.device.ads.Log;
import com.amazon.device.ads.Size;
import com.amazon.device.ads.StringUtils;
import com.amazon.device.ads.UserAgentManager;
import com.amazon.device.ads.WebUtils;
import java.util.Locale;
import java.util.regex.Pattern;
import org.json.JSONObject;

class DeviceInfo {
   private static final String LOG_TAG = DeviceInfo.class.getSimpleName();
   public static final String ORIENTATION_LANDSCAPE = "landscape";
   public static final String ORIENTATION_PORTRAIT = "portrait";
   public static final String ORIENTATION_UNKNOWN = "unknown";
   private static final String dt = "android";
   private static final String os = "Android";
   private boolean bad_mac;
   private boolean bad_serial;
   private boolean bad_udid;
   private String carrier;
   private String country;
   private Size landscapeScreenSize;
   private String language;
   private boolean macFetched;
   private String make;
   private String md5_mac;
   private String md5_serial;
   private String md5_udid;
   private String model;
   private String osVersion;
   private Size portraitScreenSize;
   private float scalingFactor;
   private String scalingFactorAsString;
   private boolean serialFetched;
   private String sha1_mac;
   private String sha1_serial;
   private String sha1_udid;
   private String udid;
   private boolean udidFetched;
   private UserAgentManager userAgentManager;

   protected DeviceInfo() {
      this.make = Build.MANUFACTURER;
      this.model = Build.MODEL;
      this.osVersion = VERSION.RELEASE;
   }

   public DeviceInfo(Context var1) {
      this.make = Build.MANUFACTURER;
      this.model = Build.MODEL;
      this.osVersion = VERSION.RELEASE;
      this.setCountry();
      this.setCarrier(var1);
      this.setLanguage();
      this.setScalingFactor(var1);
      this.userAgentManager = new UserAgentManager();
   }

   public static String getDeviceType() {
      return "android";
   }

   public static String getOS() {
      return "Android";
   }

   private void setCarrier(Context var1) {
      TelephonyManager var2 = (TelephonyManager)var1.getSystemService("phone");
      if(var2 != null) {
         String var3 = var2.getNetworkOperatorName();
         if(var3 == null || var3.length() <= 0) {
            var3 = null;
         }

         this.carrier = var3;
      }

   }

   private void setCountry() {
      String var1 = Locale.getDefault().getCountry();
      if(var1 == null || var1.length() <= 0) {
         var1 = null;
      }

      this.country = var1;
   }

   private void setLanguage() {
      String var1 = Locale.getDefault().getLanguage();
      if(var1 == null || var1.length() <= 0) {
         var1 = null;
      }

      this.language = var1;
   }

   private void setMacAddressIfNotFetched() {
      if(!this.macFetched) {
         this.setMacAddress();
      }

   }

   private void setScalingFactor(Context var1) {
      if(this.make.equals("motorola") && this.model.equals("MB502")) {
         this.scalingFactor = 1.0F;
      } else {
         WindowManager var3 = (WindowManager)var1.getSystemService("window");
         DisplayMetrics var2 = new DisplayMetrics();
         var3.getDefaultDisplay().getMetrics(var2);
         this.scalingFactor = var2.scaledDensity;
      }

      this.scalingFactorAsString = Float.toString(this.scalingFactor);
   }

   private void setSerial() {
      String var1;
      try {
         var1 = (String)Build.class.getDeclaredField("SERIAL").get(Build.class);
      } catch (Exception var2) {
         var1 = null;
      }

      if(var1 != null && var1.length() != 0 && !var1.equalsIgnoreCase("unknown")) {
         this.sha1_serial = WebUtils.getURLEncodedString(StringUtils.sha1(var1));
      } else {
         this.bad_serial = true;
      }

      this.serialFetched = true;
   }

   private void setSerialIfNotFetched() {
      if(!this.serialFetched) {
         this.setSerial();
      }

   }

   private void setUdid() {
      String var1 = Secure.getString(InternalAdRegistration.getInstance().getApplicationContext().getContentResolver(), "android_id");
      if(!StringUtils.isNullOrEmpty(var1) && !var1.equalsIgnoreCase("9774d56d682e549c")) {
         this.udid = WebUtils.getURLEncodedString(var1);
         this.sha1_udid = WebUtils.getURLEncodedString(StringUtils.sha1(var1));
      } else {
         this.udid = null;
         this.sha1_udid = null;
         this.bad_udid = true;
      }

      this.udidFetched = true;
   }

   private void setUdidIfNotFetched() {
      if(!this.udidFetched) {
         this.setUdid();
      }

   }

   public String getCarrier() {
      return this.carrier;
   }

   public String getCountry() {
      return this.country;
   }

   public JSONObject getDInfoProperty() {
      JSONObject var1 = new JSONObject();
      JSONUtils.put(var1, "make", this.getMake());
      JSONUtils.put(var1, "model", this.getModel());
      JSONUtils.put(var1, "os", getOS());
      JSONUtils.put(var1, "osVersion", this.getOSVersion());
      JSONUtils.put(var1, "scalingFactor", this.getScalingFactorAsString());
      JSONUtils.put(var1, "language", this.getLanguage());
      JSONUtils.put(var1, "country", this.getCountry());
      JSONUtils.put(var1, "carrier", this.getCarrier());
      return var1;
   }

   public String getLanguage() {
      return this.language;
   }

   public String getMacMd5() {
      this.setMacAddressIfNotFetched();
      return this.md5_mac;
   }

   public String getMacSha1() {
      this.setMacAddressIfNotFetched();
      return this.sha1_mac;
   }

   public String getMake() {
      return this.make;
   }

   public String getModel() {
      return this.model;
   }

   public String getOSVersion() {
      return this.osVersion;
   }

   public String getOrientation() {
      switch(DisplayUtils.determineCanonicalScreenOrientation(InternalAdRegistration.getInstance().getApplicationContext())) {
      case 0:
      case 8:
         return "landscape";
      case 1:
      case 9:
         return "portrait";
      default:
         return "unknown";
      }
   }

   public float getScalingFactorAsFloat() {
      return this.scalingFactor;
   }

   public String getScalingFactorAsString() {
      return this.scalingFactorAsString;
   }

   public Size getScreenSize(String var1) {
      if(var1.equals("portrait") && this.portraitScreenSize != null) {
         return this.portraitScreenSize;
      } else if(var1.equals("landscape") && this.landscapeScreenSize != null) {
         return this.landscapeScreenSize;
      } else {
         WindowManager var2 = (WindowManager)InternalAdRegistration.getInstance().getApplicationContext().getSystemService("window");
         DisplayMetrics var3 = new DisplayMetrics();
         var2.getDefaultDisplay().getMetrics(var3);
         String var4 = var3.widthPixels + "x" + var3.heightPixels;
         if(var1.equals("portrait")) {
            this.portraitScreenSize = new Size(var4);
            return this.portraitScreenSize;
         } else if(var1.equals("landscape")) {
            this.landscapeScreenSize = new Size(var4);
            return this.landscapeScreenSize;
         } else {
            return new Size(var4);
         }
      }
   }

   public String getSerialMd5() {
      this.setSerialIfNotFetched();
      return this.md5_serial;
   }

   public String getSerialSha1() {
      this.setSerialIfNotFetched();
      return this.sha1_serial;
   }

   public String getUdid() {
      this.setUdidIfNotFetched();
      return this.udid;
   }

   public String getUdidMd5() {
      this.setUdidIfNotFetched();
      return this.md5_udid;
   }

   public String getUdidSha1() {
      this.setUdidIfNotFetched();
      return this.sha1_udid;
   }

   public String getUserAgentString() {
      return this.userAgentManager.getUserAgentString();
   }

   public boolean isMacBad() {
      this.setMacAddressIfNotFetched();
      return this.bad_mac;
   }

   public boolean isSerialBad() {
      this.setSerialIfNotFetched();
      return this.bad_serial;
   }

   public boolean isUdidBad() {
      this.setUdidIfNotFetched();
      return this.bad_udid;
   }

   public void populateUserAgentString(Context var1) {
      this.userAgentManager.populateUserAgentString(var1);
   }

   protected void setMacAddress() {
      WifiInfo var4;
      label32: {
         WifiManager var1 = (WifiManager)InternalAdRegistration.getInstance().getApplicationContext().getSystemService("wifi");
         if(var1 != null) {
            try {
               var4 = var1.getConnectionInfo();
               break label32;
            } catch (SecurityException var2) {
               Log.d(LOG_TAG, "Unable to get Wifi connection information: %s", new Object[]{var2});
               var4 = null;
               break label32;
            } catch (ExceptionInInitializerError var3) {
               Log.d(LOG_TAG, "Unable to get Wifi connection information: %s", new Object[]{var3});
            }
         }

         var4 = null;
      }

      if(var4 == null) {
         this.sha1_mac = null;
      } else {
         String var5 = var4.getMacAddress();
         if(var5 != null && var5.length() != 0) {
            if(!Pattern.compile("((([0-9a-fA-F]){1,2}[-:]){5}([0-9a-fA-F]){1,2})").matcher(var5).find()) {
               this.sha1_mac = null;
               this.bad_mac = true;
            } else {
               this.sha1_mac = WebUtils.getURLEncodedString(StringUtils.sha1(var5));
            }
         } else {
            this.sha1_mac = null;
            this.bad_mac = true;
         }
      }

      this.macFetched = true;
   }

   public void setUserAgentString(String var1) {
      this.userAgentManager.setUserAgentString(var1);
   }

   JSONObject toJsonObject(String var1) {
      JSONObject var2 = this.getDInfoProperty();
      JSONUtils.put(var2, "orientation", var1);
      JSONUtils.put(var2, "screenSize", this.getScreenSize(var1).toString());
      JSONUtils.put(var2, "connectionType", (new ConnectionInfo()).getConnectionType());
      return var2;
   }

   public String toJsonString() {
      return this.toJsonObject(this.getOrientation()).toString();
   }
}
