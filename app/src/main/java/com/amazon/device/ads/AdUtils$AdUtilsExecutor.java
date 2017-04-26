package com.amazon.device.ads;

import android.content.Context;
import com.amazon.device.ads.AndroidTargetUtils;
import com.amazon.device.ads.ConnectionInfo;
import com.amazon.device.ads.DeviceInfo;
import com.amazon.device.ads.InternalAdRegistration;
import com.amazon.device.ads.Metrics$MetricType;
import com.amazon.device.ads.MetricsCollector;
import java.util.HashSet;

class AdUtils$AdUtilsExecutor {
   private boolean hasRequiredActivities = false;
   private final HashSet requiredActivities = new HashSet();

   AdUtils$AdUtilsExecutor() {
      this.requiredActivities.add("com.amazon.device.ads.AdActivity");
   }

   double calculateScalingMultiplier(int var1, int var2, int var3, int var4) {
      double var5;
      double var7;
      label17: {
         var7 = (double)var3 / (double)var1;
         double var9 = (double)var4 / (double)var2;
         if(var9 >= var7) {
            var5 = var7;
            if(var7 != 0.0D) {
               break label17;
            }
         }

         var5 = var7;
         if(var9 != 0.0D) {
            var5 = var9;
         }
      }

      var7 = var5;
      if(var5 == 0.0D) {
         var7 = 1.0D;
      }

      return var7;
   }

   boolean checkDefinedActivities(Context param1) {
      // $FF: Couldn't be decompiled
   }

   int deviceIndependentPixelToPixel(int var1) {
      return (int)((float)var1 * this.getScalingFactorAsFloat());
   }

   float getScalingFactorAsFloat() {
      return InternalAdRegistration.getInstance().getDeviceInfo().getScalingFactorAsFloat();
   }

   double getViewportInitialScale(double var1) {
      if(AndroidTargetUtils.isAtLeastAndroidAPI(19)) {
         var1 = 1.0D;
      }

      return var1;
   }

   int pixelToDeviceIndependentPixel(int var1) {
      return (int)((float)var1 / this.getScalingFactorAsFloat());
   }

   void setConnectionMetrics(ConnectionInfo var1, MetricsCollector var2) {
      if(var1 != null) {
         if(var1.isWiFi()) {
            var2.incrementMetric(Metrics$MetricType.WIFI_PRESENT);
         } else {
            var2.setMetricString(Metrics$MetricType.CONNECTION_TYPE, var1.getConnectionType());
         }
      }

      DeviceInfo var3 = InternalAdRegistration.getInstance().getDeviceInfo();
      if(var3.getCarrier() != null) {
         var2.setMetricString(Metrics$MetricType.CARRIER_NAME, var3.getCarrier());
      }

   }
}
