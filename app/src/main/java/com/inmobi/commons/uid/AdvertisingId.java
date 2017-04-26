package com.inmobi.commons.uid;

public class AdvertisingId {
   private String a;
   private boolean b;

   void a(String var1) {
      this.a = var1;
   }

   void a(boolean var1) {
      this.b = var1;
   }

   public String getAdId() {
      return this.a;
   }

   public boolean isLimitAdTracking() {
      return this.b;
   }
}
