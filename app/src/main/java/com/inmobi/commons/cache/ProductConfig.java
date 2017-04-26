package com.inmobi.commons.cache;

import com.inmobi.commons.cache.JSONMapBuilder;
import java.util.HashMap;
import java.util.Map;

public abstract class ProductConfig {
   private String a = null;
   private String b = null;
   private String c = null;
   private int d = 0;
   private int e = 3;
   private int f = 60;
   private int g = 0;
   private int h = -1;
   private boolean i = true;

   Map a(String var1) {
      if(this.getProtocol().equals("json")) {
         return (new JSONMapBuilder()).buildMap(var1);
      } else {
         HashMap var2 = new HashMap();
         var2.put("data", var1);
         return var2;
      }
   }

   public Map getData() {
      return this.a(this.c);
   }

   public int getExpiry() {
      return this.d;
   }

   public int getMaxRetry() {
      return this.e;
   }

   public String getProtocol() {
      return this.b;
   }

   public String getRawData() {
      return this.c;
   }

   public int getRetryInterval() {
      return this.f;
   }

   public int getRetryNumber() {
      return this.g;
   }

   public int getTimestamp() {
      return this.h;
   }

   public String getUrl() {
      return this.a;
   }

   public boolean isSendUidMap() {
      return this.i;
   }

   public void setData(String var1) {
      this.c = var1;
   }

   public void setExpiry(int var1) {
      this.d = var1;
   }

   public void setMaxRetry(int var1) {
      this.e = var1;
   }

   public void setProtocol(String var1) {
      this.b = var1;
   }

   public void setRetryInterval(int var1) {
      this.f = var1;
   }

   public void setRetryNumber(int var1) {
      this.g = var1;
   }

   public void setSendUidMap(boolean var1) {
      this.i = var1;
   }

   public void setTimestamp(int var1) {
      this.h = var1;
   }

   public void setUrl(String var1) {
      this.a = var1;
   }
}
