package com.flurry.android.impl.ads.avro.protocol.v10;

import com.flurry.android.impl.ads.avro.protocol.v10.AdRequest;
import com.flurry.android.impl.ads.avro.protocol.v10.AdViewContainer;
import com.flurry.android.impl.ads.avro.protocol.v10.Location;
import com.flurry.android.impl.ads.avro.protocol.v10.TargetingOverride;
import com.flurry.android.impl.ads.avro.protocol.v10.TestAds;
import com.flurry.sdk.gx;
import java.util.List;
import java.util.Map;

public class AdRequest$Builder extends gx {
   private boolean A;
   private Map B;
   private CharSequence a;
   private CharSequence b;
   private CharSequence c;
   private long d;
   private List e;
   private Location f;
   private boolean g;
   private List h;
   private AdViewContainer i;
   private CharSequence j;
   private CharSequence k;
   private CharSequence l;
   private CharSequence m;
   private TestAds n;
   private Map o;
   private boolean p;
   private boolean q;
   private int r;
   private List s;
   private boolean t;
   private CharSequence u;
   private List v;
   private CharSequence w;
   private TargetingOverride x;
   private boolean y;
   private List z;

   private AdRequest$Builder() {
      super(AdRequest.SCHEMA$);
   }

   // $FF: synthetic method
   AdRequest$Builder(Object var1) {
      this();
   }

   public AdRequest$Builder a(int var1) {
      this.a(this.b()[17], Integer.valueOf(var1));
      this.r = var1;
      this.c()[17] = true;
      return this;
   }

   public AdRequest$Builder a(long var1) {
      this.a(this.b()[3], Long.valueOf(var1));
      this.d = var1;
      this.c()[3] = true;
      return this;
   }

   public AdRequest$Builder a(AdViewContainer var1) {
      this.a(this.b()[8], var1);
      this.i = var1;
      this.c()[8] = true;
      return this;
   }

   public AdRequest$Builder a(Location var1) {
      this.a(this.b()[5], var1);
      this.f = var1;
      this.c()[5] = true;
      return this;
   }

   public AdRequest$Builder a(CharSequence var1) {
      this.a(this.b()[0], var1);
      this.a = var1;
      this.c()[0] = true;
      return this;
   }

   public AdRequest$Builder a(List var1) {
      this.a(this.b()[4], var1);
      this.e = var1;
      this.c()[4] = true;
      return this;
   }

   public AdRequest$Builder a(boolean var1) {
      this.a(this.b()[6], Boolean.valueOf(var1));
      this.g = var1;
      this.c()[6] = true;
      return this;
   }

   public AdRequest a() {
      // $FF: Couldn't be decompiled
   }

   public AdRequest$Builder b(CharSequence var1) {
      this.a(this.b()[1], var1);
      this.b = var1;
      this.c()[1] = true;
      return this;
   }

   public AdRequest$Builder b(List var1) {
      this.a(this.b()[7], var1);
      this.h = var1;
      this.c()[7] = true;
      return this;
   }

   public AdRequest$Builder b(boolean var1) {
      this.a(this.b()[16], Boolean.valueOf(var1));
      this.q = var1;
      this.c()[16] = true;
      return this;
   }

   public AdRequest$Builder c(CharSequence var1) {
      this.a(this.b()[2], var1);
      this.c = var1;
      this.c()[2] = true;
      return this;
   }

   public AdRequest$Builder c(List var1) {
      this.a(this.b()[18], var1);
      this.s = var1;
      this.c()[18] = true;
      return this;
   }

   public AdRequest$Builder c(boolean var1) {
      this.a(this.b()[19], Boolean.valueOf(var1));
      this.t = var1;
      this.c()[19] = true;
      return this;
   }

   public AdRequest$Builder d(CharSequence var1) {
      this.a(this.b()[9], var1);
      this.j = var1;
      this.c()[9] = true;
      return this;
   }

   public AdRequest$Builder d(List var1) {
      this.a(this.b()[21], var1);
      this.v = var1;
      this.c()[21] = true;
      return this;
   }

   public AdRequest$Builder d(boolean var1) {
      this.a(this.b()[24], Boolean.valueOf(var1));
      this.y = var1;
      this.c()[24] = true;
      return this;
   }

   public AdRequest$Builder e(CharSequence var1) {
      this.a(this.b()[10], var1);
      this.k = var1;
      this.c()[10] = true;
      return this;
   }

   public AdRequest$Builder e(List var1) {
      this.a(this.b()[25], var1);
      this.z = var1;
      this.c()[25] = true;
      return this;
   }

   public AdRequest$Builder e(boolean var1) {
      this.a(this.b()[26], Boolean.valueOf(var1));
      this.A = var1;
      this.c()[26] = true;
      return this;
   }

   public AdRequest$Builder f(CharSequence var1) {
      this.a(this.b()[11], var1);
      this.l = var1;
      this.c()[11] = true;
      return this;
   }

   public AdRequest$Builder g(CharSequence var1) {
      this.a(this.b()[12], var1);
      this.m = var1;
      this.c()[12] = true;
      return this;
   }

   public AdRequest$Builder h(CharSequence var1) {
      this.a(this.b()[20], var1);
      this.u = var1;
      this.c()[20] = true;
      return this;
   }

   public AdRequest$Builder i(CharSequence var1) {
      this.a(this.b()[22], var1);
      this.w = var1;
      this.c()[22] = true;
      return this;
   }
}
