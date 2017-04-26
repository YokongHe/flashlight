package com.inmobi.commons.ads.cache;

public class AdData {
   private long a;
   private String b;
   private long c;
   private String d;
   private String e;

   public long getAdId() {
      return this.a;
   }

   public String getAdType() {
      return this.e;
   }

   public String getAppId() {
      return this.b;
   }

   public String getContent() {
      return this.d;
   }

   public long getTimestamp() {
      return this.c;
   }

   public void setAdId(long var1) {
      this.a = var1;
   }

   public void setAdType(String var1) {
      this.e = var1;
   }

   public void setAppId(String var1) {
      this.b = var1;
   }

   public void setContent(String var1) {
      this.d = var1;
   }

   public void setTimestamp(long var1) {
      this.c = var1;
   }
}
