package com.smaato.soma.internal.requests.settings;

import com.smaato.soma.CrashReportTemplate;
import com.smaato.soma.internal.requests.settings.DeviceDataCollector;

class DeviceDataCollector$GoogleAdvertisingIdProvider extends Thread {
   // $FF: synthetic field
   final DeviceDataCollector this$0;

   private DeviceDataCollector$GoogleAdvertisingIdProvider(DeviceDataCollector var1) {
      this.this$0 = var1;
   }

   // $FF: synthetic method
   DeviceDataCollector$GoogleAdvertisingIdProvider(DeviceDataCollector var1, DeviceDataCollector$GoogleAdvertisingIdProvider var2) {
      this(var1);
   }

   // $FF: synthetic method
   static DeviceDataCollector access$1(DeviceDataCollector$GoogleAdvertisingIdProvider var0) {
      return var0.this$0;
   }

   public void run() {
      (new CrashReportTemplate() {
         public Void process() {
            // $FF: Couldn't be decompiled
         }
      }).execute();
      super.run();
   }
}
