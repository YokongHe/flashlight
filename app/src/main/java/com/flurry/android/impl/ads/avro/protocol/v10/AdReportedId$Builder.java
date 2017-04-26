package com.flurry.android.impl.ads.avro.protocol.v10;

import com.flurry.android.impl.ads.avro.protocol.v10.AdReportedId;
import com.flurry.sdk.gx;
import java.nio.ByteBuffer;

public class AdReportedId$Builder extends gx {
   private int a;
   private ByteBuffer b;

   private AdReportedId$Builder() {
      super(AdReportedId.SCHEMA$);
   }

   // $FF: synthetic method
   AdReportedId$Builder(Object var1) {
      this();
   }

   public AdReportedId$Builder a(int var1) {
      this.a(this.b()[0], Integer.valueOf(var1));
      this.a = var1;
      this.c()[0] = true;
      return this;
   }

   public AdReportedId$Builder a(ByteBuffer var1) {
      this.a(this.b()[1], var1);
      this.b = var1;
      this.c()[1] = true;
      return this;
   }

   public AdReportedId a() {
      // $FF: Couldn't be decompiled
   }
}
