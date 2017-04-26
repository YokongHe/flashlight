package com.flurry.android.impl.ads.avro.protocol.v10;

import com.flurry.android.impl.ads.avro.protocol.v10.TestAds;
import com.flurry.sdk.gx;

public class TestAds$Builder extends gx {
   private int a;

   private TestAds$Builder() {
      super(TestAds.SCHEMA$);
   }

   // $FF: synthetic method
   TestAds$Builder(Object var1) {
      this();
   }

   public TestAds$Builder a(int var1) {
      this.a(this.b()[0], Integer.valueOf(var1));
      this.a = var1;
      this.c()[0] = true;
      return this;
   }

   public TestAds a() {
      // $FF: Couldn't be decompiled
   }
}
