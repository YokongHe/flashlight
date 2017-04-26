package com.inmobi.monetization.internal.configs;

import com.inmobi.commons.internal.InternalSDKUtil;
import java.util.Map;

public class IMAIConfigParams {
   int a = 3;
   int b = 10;
   int c = 120;
   int d = 10;
   int e = 1000;

   public int getMaxRetry() {
      return this.a;
   }

   public int getPingTimeOut() {
      return this.c * 1000;
   }

   public int getRetryInterval() {
      return this.b * 1000;
   }

   public int getmDefaultEventsBatch() {
      return this.d;
   }

   public int getmMaxDb() {
      return this.e;
   }

   public void setFromMap(Map var1) {
      this.a = InternalSDKUtil.getIntFromMap(var1, "mr", 0, 2147483647L);
      this.b = InternalSDKUtil.getIntFromMap(var1, "pint", 1, 2147483647L);
      this.c = InternalSDKUtil.getIntFromMap(var1, "pto", 1, 2147483647L);
      this.d = InternalSDKUtil.getIntFromMap(var1, "eb", 1, 2147483647L);
      this.e = InternalSDKUtil.getIntFromMap(var1, "mdb", 1, 2147483647L);
   }

   public void setmDefaultEventsBatch(int var1) {
      this.d = var1;
   }

   public void setmMaxDb(int var1) {
      this.e = var1;
   }
}
