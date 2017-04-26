package com.amazon.device.ads;

import com.amazon.device.ads.AdvertisingIdentifier;
import com.amazon.device.ads.AdvertisingIdentifier$Info;
import com.amazon.device.ads.AppEventRegistrationHandler;
import com.amazon.device.ads.Configuration;
import com.amazon.device.ads.Configuration$ConfigurationListener;
import com.amazon.device.ads.DebugProperties;
import com.amazon.device.ads.InternalAdRegistration;
import com.amazon.device.ads.Log;
import com.amazon.device.ads.RegistrationInfo;
import com.amazon.device.ads.SISDeviceRequest;
import com.amazon.device.ads.SISGenerateDIDRequest;
import com.amazon.device.ads.SISRegisterEventRequest;
import com.amazon.device.ads.SISRegistration$RegisterEventsSISRequestorCallback;
import com.amazon.device.ads.SISRequest;
import com.amazon.device.ads.SISRequestor;
import com.amazon.device.ads.SISUpdateDeviceInfoRequest;
import com.amazon.device.ads.Settings;
import com.amazon.device.ads.ThreadUtils;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;

class SISRegistration {
   private static final String LOG_TAG = SISRegistration.class.getSimpleName();
   protected static final long SIS_CHECKIN_INTERVAL = 86400000L;
   private static final String SIS_LAST_CHECKIN_PREF_NAME = "amzn-ad-sis-last-checkin";
   private static final ExecutorService executorService = Executors.newSingleThreadExecutor();

   private void putLastSISCheckin(long var1) {
      Settings.getInstance().putLong("amzn-ad-sis-last-checkin", var1);
   }

   protected boolean canRegister(long var1) {
      boolean var3 = false;
      RegistrationInfo var4 = InternalAdRegistration.getInstance().getRegistrationInfo();
      if(this.exceededCheckinInterval(var1) || var4.shouldGetNewSISDeviceIdentifer() || var4.shouldGetNewSISRegistration() || DebugProperties.getDebugPropertyAsBoolean("debug.shouldRegisterSIS", false)) {
         var3 = true;
      }

      return var3;
   }

   protected AdvertisingIdentifier$Info createAdvertisingIdentifierInfo() {
      return (new AdvertisingIdentifier()).getAdvertisingIdentifierInfo();
   }

   protected boolean exceededCheckinInterval(long var1) {
      return var1 - this.getLastSISCheckin() > 86400000L;
   }

   protected long getLastSISCheckin() {
      return Settings.getInstance().getLong("amzn-ad-sis-last-checkin", 0L);
   }

   protected void register(AdvertisingIdentifier$Info var1) {
      SISDeviceRequest var2 = (new SISGenerateDIDRequest()).setAdvertisingIdentifierInfo(var1);
      (new SISRequestor(new SISRegistration$RegisterEventsSISRequestorCallback(this), new SISRequest[]{var2})).startCallSIS();
   }

   public void registerApp() {
      Runnable var1 = new Runnable() {
         public void run() {
            SISRegistration.this.waitForConfigurationThenBeginRegistration();
         }
      };
      executorService.submit(var1);
   }

   void registerAppWorker() {
      long var1 = System.currentTimeMillis();
      AdvertisingIdentifier$Info var3 = this.createAdvertisingIdentifierInfo();
      if(var3.canDo() && this.canRegister(var1)) {
         this.putLastSISCheckin(var1);
         if(!this.shouldUpdateDeviceInfo()) {
            this.register(var3);
            return;
         }

         this.updateDeviceInfo(var3);
      }

   }

   protected void registerEvents() {
      if(ThreadUtils.isOnMainThread()) {
         Log.e(LOG_TAG, "Registering events must be done on a background thread.");
      } else {
         AdvertisingIdentifier$Info var1 = (new AdvertisingIdentifier()).getAdvertisingIdentifierInfo();
         if(var1.hasSISDeviceIdentifier()) {
            JSONArray var2 = AppEventRegistrationHandler.getInstance().getAppEventsJSONArray();
            if(var2 != null) {
               (new SISRequestor(new SISRequest[]{new SISRegisterEventRequest(var1, var2)})).startCallSIS();
               return;
            }
         }
      }

   }

   protected boolean shouldUpdateDeviceInfo() {
      return InternalAdRegistration.getInstance().getRegistrationInfo().isRegisteredWithSIS();
   }

   protected void updateDeviceInfo(AdvertisingIdentifier$Info var1) {
      SISDeviceRequest var2 = (new SISUpdateDeviceInfoRequest()).setAdvertisingIdentifierInfo(var1);
      (new SISRequestor(new SISRegistration$RegisterEventsSISRequestorCallback(this), new SISRequest[]{var2})).startCallSIS();
   }

   void waitForConfigurationThenBeginRegistration() {
      final CountDownLatch var2 = new CountDownLatch(1);
      final AtomicBoolean var1 = new AtomicBoolean(false);
      Configuration.getInstance().queueConfigurationListener(new Configuration$ConfigurationListener() {
         public void onConfigurationFailure() {
            Log.w(SISRegistration.LOG_TAG, "Configuration fetching failed so device registration will not proceed.");
            var2.countDown();
         }

         public void onConfigurationReady() {
            var1.set(true);
            var2.countDown();
         }
      });

      try {
         var2.await();
      } catch (InterruptedException var3) {
         ;
      }

      if(var1.get()) {
         this.registerAppWorker();
      }

   }
}
