package com.inmobi.monetization.internal.carb;

import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.uid.UIDMapConfigParams;
import java.util.Map;

public class CarbConfigParams {
   boolean a = false;
   String b = "http://dock.inmobi.com/carb/v1/i";
   String c = "http://dock.inmobi.com/carb/v1/o";
   long d = 86400L;
   int e = 3;
   long f = 60L;
   long g = 60L;
   private UIDMapConfigParams h = new UIDMapConfigParams();

   public String getCarbEndpoint() {
      return this.b;
   }

   public String getCarbPostpoint() {
      return this.c;
   }

   public Map getDeviceIdMaskMap() {
      return this.h.getMap();
   }

   public long getRetreiveFrequncy() {
      return this.d * 1000L;
   }

   public int getRetryCount() {
      return this.e;
   }

   public long getRetryInterval() {
      return this.f;
   }

   public long getTimeoutInterval() {
      return this.g;
   }

   public boolean isCarbEnabled() {
      return this.a;
   }

   public void setFromMap(Map var1) {
      try {
         this.h.setMap(InternalSDKUtil.getObjectFromMap(var1, "ids"));
         this.a = InternalSDKUtil.getBooleanFromMap(var1, "enabled");
         this.b = InternalSDKUtil.getStringFromMap(var1, "gep");
         if(!this.b.startsWith("http") && !this.b.startsWith("https")) {
            throw new IllegalArgumentException("URL wrong");
         } else {
            this.c = InternalSDKUtil.getStringFromMap(var1, "pep");
            if(!this.c.startsWith("http") && !this.c.startsWith("https")) {
               throw new IllegalArgumentException("URL wrong");
            } else {
               this.d = InternalSDKUtil.getLongFromMap(var1, "fq_s", 1L, Long.MAX_VALUE);
               this.e = InternalSDKUtil.getIntFromMap(var1, "mr", 0, 2147483647L);
               this.f = InternalSDKUtil.getLongFromMap(var1, "ri", 1L, Long.MAX_VALUE);
               this.g = InternalSDKUtil.getLongFromMap(var1, "to", 1L, Long.MAX_VALUE);
            }
         }
      } catch (IllegalArgumentException var2) {
         Log.internal("CarbConfigParams", "Invalid value");
         this.a = false;
         this.b = "http://dock.inmobi.com/carb/v1/i";
         this.c = "http://dock.inmobi.com/carb/v1/o";
         this.d = 86400L;
         this.e = 3;
         this.f = 60L;
         this.g = 60L;
         throw new IllegalArgumentException();
      }
   }
}
