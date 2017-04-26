package com.inmobi.monetization.internal;

import java.util.HashMap;

public class LtvpRulesObject {
   private String a;
   private long b;
   private HashMap c;
   private long d;
   private long e;

   public long getHardExpiry() {
      return this.e;
   }

   public String getRuleId() {
      return this.a;
   }

   public HashMap getRules() {
      return this.c;
   }

   public long getSoftExpiry() {
      return this.d;
   }

   public long getTimeStamp() {
      return this.b;
   }

   public void setHardExpiry(long var1) {
      this.e = var1;
   }

   public void setRuleId(String var1) {
      this.a = var1;
   }

   public void setRules(HashMap var1) {
      this.c = var1;
   }

   public void setSoftExpiry(long var1) {
      this.d = var1;
   }

   public void setTimeStamp(long var1) {
      this.b = var1;
   }
}
