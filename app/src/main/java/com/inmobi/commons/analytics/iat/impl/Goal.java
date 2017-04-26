package com.inmobi.commons.analytics.iat.impl;

import com.inmobi.commons.analytics.iat.impl.Goal$State;
import java.io.Serializable;

public class Goal implements Serializable {
   public int count;
   public boolean isDuplicate;
   public String name;
   public int retryCount;
   public long retryTime;
   public Goal$State state;

   public Goal() {
      this("", 0, 0L, 0, false);
   }

   public Goal(String var1, int var2, long var3, int var5, boolean var6) {
      this(var1, Goal$State.ENQUEUE_PENDING, var2, var3, var5, var6);
   }

   public Goal(String var1, Goal$State var2, int var3, long var4, int var6, boolean var7) {
      byte var9 = 0;
      super();
      this.name = var1;
      this.state = var2;
      int var8 = var3;
      if(var3 < 0) {
         var8 = 0;
      }

      this.count = var8;
      long var10 = var4;
      if(var4 < 0L) {
         var10 = 0L;
      }

      this.retryTime = var10;
      if(var6 < 0) {
         var3 = var9;
      } else {
         var3 = var6;
      }

      this.retryCount = var3;
      this.isDuplicate = var7;
   }
}
