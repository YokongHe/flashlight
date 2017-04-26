package com.inmobi.monetization.internal;

public class NativeAdObject {
   String a = null;
   String b = null;
   String c = null;
   com.inmobi.monetization.internal.e d = null;

   public NativeAdObject(String var1, String var2, String var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public String getContextCode() {
      return this.b;
   }

   public String getNameSpace() {
      return this.c;
   }

   public String getPubContent() {
      return this.a;
   }
}
