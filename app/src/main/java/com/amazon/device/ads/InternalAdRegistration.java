package com.amazon.device.ads;

import android.content.Context;
import com.amazon.device.ads.AppInfo;
import com.amazon.device.ads.Configuration;
import com.amazon.device.ads.DebugProperties;
import com.amazon.device.ads.DeviceInfo;
import com.amazon.device.ads.IInternalAdRegistration;
import com.amazon.device.ads.RegistrationInfo;
import com.amazon.device.ads.SISRegistration;
import com.amazon.device.ads.Settings;
import com.amazon.device.ads.Version;
import java.io.File;

class InternalAdRegistration implements IInternalAdRegistration {
   public static final String LOG_TAG = InternalAdRegistration.class.getSimpleName();
   private static IInternalAdRegistration instance = new InternalAdRegistration();
   private AppInfo appInfo;
   protected Context applicationContext;
   private boolean contextReceived;
   private DeviceInfo deviceInfo;
   private File filesDirectory;
   private boolean isAppDisabled = false;
   private boolean isRegistered;
   private long noRetryTtlExpiresMillis;
   private int noRetryTtlMillis;
   private RegistrationInfo registrationInfo;
   private SISRegistration sisRegistration;

   protected InternalAdRegistration() {
      DebugProperties.readDebugProperties();
      Version.getSDKVersion();
      this.registrationInfo = new RegistrationInfo();
   }

   public static IInternalAdRegistration getInstance() {
      return instance;
   }

   public void contextReceived(Context var1) {
      synchronized(this){}

      try {
         if(!this.contextReceived) {
            this.contextReceived = true;
            this.setApplicationContextFromContext(var1);
            this.setFilesDirectory(var1);
            Settings.getInstance().contextReceived(var1);
            this.createAppInfo(var1);
            this.createDeviceInfo(var1);
            this.createSISRegistration();
         }
      } finally {
         ;
      }

   }

   protected void createAppInfo(Context var1) {
      this.appInfo = new AppInfo(var1);
   }

   protected void createDeviceInfo(Context var1) {
      this.deviceInfo = new DeviceInfo(var1);
   }

   protected void createSISRegistration() {
      this.sisRegistration = new SISRegistration();
   }

   public AppInfo getAppInfo() {
      return this.appInfo;
   }

   public Context getApplicationContext() {
      return this.applicationContext;
   }

   public DeviceInfo getDeviceInfo() {
      return this.deviceInfo;
   }

   public File getFilesDir() {
      return this.filesDirectory;
   }

   public boolean getIsAppDisabled() {
      return this.isAppDisabled;
   }

   public int getNoRetryTtlRemainingMillis() {
      if(this.noRetryTtlMillis != 0 && this.noRetryTtlExpiresMillis != 0L) {
         long var1 = System.currentTimeMillis();
         if(var1 >= this.noRetryTtlExpiresMillis) {
            this.noRetryTtlMillis = 0;
            this.noRetryTtlExpiresMillis = 0L;
            return 0;
         } else {
            return (int)(this.noRetryTtlExpiresMillis - var1);
         }
      } else {
         return 0;
      }
   }

   public RegistrationInfo getRegistrationInfo() {
      return this.registrationInfo;
   }

   protected SISRegistration getSISRegistration() {
      return this.sisRegistration;
   }

   public boolean isContextReceived() {
      return this.contextReceived;
   }

   public boolean isRegistered() {
      return this.isRegistered;
   }

   public void register() {
      this.getSISRegistration().registerApp();
      this.isRegistered = true;
   }

   protected void setApplicationContextFromContext(Context var1) {
      this.applicationContext = var1.getApplicationContext();
   }

   protected void setFilesDirectory(Context var1) {
      this.filesDirectory = var1.getFilesDir();
   }

   public void setIsAppDisabled(boolean var1) {
      this.isAppDisabled = var1;
   }

   public void setNoRetryTtl(int var1) {
      int var3 = Configuration.getMaxNoRetryTtl();
      int var2 = var1;
      if(var3 < var1) {
         var2 = var3;
      }

      if(var2 == 0) {
         this.noRetryTtlMillis = 0;
         this.noRetryTtlExpiresMillis = 0L;
      } else {
         this.noRetryTtlMillis = var2 * 1000;
         this.noRetryTtlExpiresMillis = System.currentTimeMillis() + (long)this.noRetryTtlMillis;
      }
   }
}
