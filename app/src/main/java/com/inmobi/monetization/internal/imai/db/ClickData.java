package com.inmobi.monetization.internal.imai.db;

import com.inmobi.monetization.internal.imai.IMAICore;

public class ClickData {
   private long a;
   private String b;
   private boolean c;
   private int d;
   private boolean e;
   private long f;

   public ClickData() {
   }

   public ClickData(String var1, boolean var2, boolean var3, int var4) {
      this.setClickId((long)IMAICore.getRandomNumber());
      this.setClickUrl(var1);
      this.setFollowRedirect(var2);
      this.setPingWv(var3);
      this.setRetryCount(var4);
      this.setTimestamp(System.currentTimeMillis());
   }

   public long getClickId() {
      return this.a;
   }

   public String getClickUrl() {
      return this.b;
   }

   public int getRetryCount() {
      return this.d;
   }

   public long getTimestamp() {
      return this.f;
   }

   public boolean isFollowRedirects() {
      return this.e;
   }

   public boolean isPingWv() {
      return this.c;
   }

   public void setClickId(long var1) {
      this.a = var1;
   }

   public void setClickUrl(String var1) {
      this.b = var1;
   }

   public void setFollowRedirect(boolean var1) {
      this.e = var1;
   }

   public void setPingWv(boolean var1) {
      this.c = var1;
   }

   public void setRetryCount(int var1) {
      this.d = var1;
   }

   public void setTimestamp(long var1) {
      this.f = var1;
   }
}
