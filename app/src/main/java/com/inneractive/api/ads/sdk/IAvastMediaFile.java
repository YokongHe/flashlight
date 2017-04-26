package com.inneractive.api.ads.sdk;

import com.inneractive.api.ads.sdk.IAvastMediaFile$Delivery;
import com.inneractive.api.ads.sdk.IAvastMediaFile$MediaTypes;

final class IAvastMediaFile {
   private String a;
   private IAvastMediaFile$Delivery b;
   private String c;
   private int d;
   private int e;
   private int f;

   IAvastMediaFile(String var1, String var2, IAvastMediaFile$Delivery var3, int var4, int var5) {
      this.a = var1;
      this.b = var3;
      this.d = var4;
      this.e = var5;
      this.c = var2;
   }

   final Integer a() {
      return Integer.valueOf(this.f);
   }

   final void a(int var1) {
      this.f = var1;
   }

   final String b() {
      return this.a;
   }

   final IAvastMediaFile$Delivery c() {
      return this.b;
   }

   final int d() {
      return this.d;
   }

   final int e() {
      return this.e;
   }

   final String f() {
      return this.c;
   }

   final Integer g() {
      return this.c.compareToIgnoreCase(IAvastMediaFile$MediaTypes.a.d) == 0?Integer.valueOf(3):(this.c.compareToIgnoreCase(IAvastMediaFile$MediaTypes.b.d) == 0?Integer.valueOf(2):(this.c.compareToIgnoreCase(IAvastMediaFile$MediaTypes.c.d) == 0?Integer.valueOf(1):Integer.valueOf(-1)));
   }
}
