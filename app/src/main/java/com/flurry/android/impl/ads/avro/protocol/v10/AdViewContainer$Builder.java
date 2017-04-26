package com.flurry.android.impl.ads.avro.protocol.v10;

import com.flurry.android.impl.ads.avro.protocol.v10.AdViewContainer;
import com.flurry.android.impl.ads.avro.protocol.v10.ScreenOrientationType;
import com.flurry.sdk.gx;

public class AdViewContainer$Builder extends gx {
   private int a;
   private int b;
   private int c;
   private int d;
   private float e;
   private ScreenOrientationType f;

   private AdViewContainer$Builder() {
      super(AdViewContainer.SCHEMA$);
   }

   // $FF: synthetic method
   AdViewContainer$Builder(Object var1) {
      this();
   }

   public AdViewContainer$Builder a(float var1) {
      this.a(this.b()[4], Float.valueOf(var1));
      this.e = var1;
      this.c()[4] = true;
      return this;
   }

   public AdViewContainer$Builder a(int var1) {
      this.a(this.b()[0], Integer.valueOf(var1));
      this.a = var1;
      this.c()[0] = true;
      return this;
   }

   public AdViewContainer$Builder a(ScreenOrientationType var1) {
      this.a(this.b()[5], var1);
      this.f = var1;
      this.c()[5] = true;
      return this;
   }

   public AdViewContainer a() {
      // $FF: Couldn't be decompiled
   }

   public AdViewContainer$Builder b(int var1) {
      this.a(this.b()[1], Integer.valueOf(var1));
      this.b = var1;
      this.c()[1] = true;
      return this;
   }

   public AdViewContainer$Builder c(int var1) {
      this.a(this.b()[2], Integer.valueOf(var1));
      this.c = var1;
      this.c()[2] = true;
      return this;
   }

   public AdViewContainer$Builder d(int var1) {
      this.a(this.b()[3], Integer.valueOf(var1));
      this.d = var1;
      this.c()[3] = true;
      return this;
   }
}
