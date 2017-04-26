package com.flurry.android.impl.ads.avro.protocol.v10;

import com.flurry.android.impl.ads.avro.protocol.v10.FrequencyCapInfo;
import com.flurry.sdk.gx;

public class FrequencyCapInfo$Builder extends gx {
   private CharSequence a;
   private long b;
   private long c;
   private int d;
   private int e;
   private int f;
   private int g;

   private FrequencyCapInfo$Builder() {
      super(FrequencyCapInfo.SCHEMA$);
   }

   // $FF: synthetic method
   FrequencyCapInfo$Builder(Object var1) {
      this();
   }

   public FrequencyCapInfo$Builder a(int var1) {
      this.a(this.b()[3], Integer.valueOf(var1));
      this.d = var1;
      this.c()[3] = true;
      return this;
   }

   public FrequencyCapInfo$Builder a(long var1) {
      this.a(this.b()[1], Long.valueOf(var1));
      this.b = var1;
      this.c()[1] = true;
      return this;
   }

   public FrequencyCapInfo$Builder a(CharSequence var1) {
      this.a(this.b()[0], var1);
      this.a = var1;
      this.c()[0] = true;
      return this;
   }

   public FrequencyCapInfo a() {
      // $FF: Couldn't be decompiled
   }

   public FrequencyCapInfo$Builder b(int var1) {
      this.a(this.b()[4], Integer.valueOf(var1));
      this.e = var1;
      this.c()[4] = true;
      return this;
   }

   public FrequencyCapInfo$Builder b(long var1) {
      this.a(this.b()[2], Long.valueOf(var1));
      this.c = var1;
      this.c()[2] = true;
      return this;
   }

   public FrequencyCapInfo$Builder c(int var1) {
      this.a(this.b()[5], Integer.valueOf(var1));
      this.f = var1;
      this.c()[5] = true;
      return this;
   }

   public FrequencyCapInfo$Builder d(int var1) {
      this.a(this.b()[6], Integer.valueOf(var1));
      this.g = var1;
      this.c()[6] = true;
      return this;
   }
}
