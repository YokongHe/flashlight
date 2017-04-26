package com.inmobi.monetization.internal.configs;

import com.inmobi.commons.internal.InternalSDKUtil;
import java.util.Map;

public class NativeConfigParams {
   int a = 100;
   int b = 1;
   int c = 2;
   long d = 3300L;

   public long getTimeToLive() {
      return this.d;
   }

   public int getmFetchLimit() {
      return this.c;
   }

   public int getmMaxCacheSize() {
      return this.a;
   }

   public int getmMinLimit() {
      return this.b;
   }

   public void setFromMap(Map var1) {
      this.a = InternalSDKUtil.getIntFromMap(var1, "mcl", 1, 2147483647L);
      this.b = InternalSDKUtil.getIntFromMap(var1, "mt", 1, 2147483647L);
      this.c = InternalSDKUtil.getIntFromMap(var1, "fl", 1, 2147483647L);
      this.d = InternalSDKUtil.getLongFromMap(var1, "ttl", 1L, Long.MAX_VALUE);
   }
}
