package com.flurry.android.impl.ads.avro.protocol.v10;

import com.flurry.android.impl.ads.avro.protocol.v10.SdkLogRequest;
import com.flurry.sdk.gx;
import java.util.List;

public class SdkLogRequest$Builder extends gx {
   private CharSequence a;
   private List b;
   private List c;
   private long d;
   private CharSequence e;
   private boolean f;

   private SdkLogRequest$Builder() {
      super(SdkLogRequest.SCHEMA$);
   }

   // $FF: synthetic method
   SdkLogRequest$Builder(Object var1) {
      this();
   }

   public SdkLogRequest$Builder a(long var1) {
      this.a(this.b()[3], Long.valueOf(var1));
      this.d = var1;
      this.c()[3] = true;
      return this;
   }

   public SdkLogRequest$Builder a(CharSequence var1) {
      this.a(this.b()[0], var1);
      this.a = var1;
      this.c()[0] = true;
      return this;
   }

   public SdkLogRequest$Builder a(List var1) {
      this.a(this.b()[1], var1);
      this.b = var1;
      this.c()[1] = true;
      return this;
   }

   public SdkLogRequest$Builder a(boolean var1) {
      this.a(this.b()[5], Boolean.valueOf(var1));
      this.f = var1;
      this.c()[5] = true;
      return this;
   }

   public SdkLogRequest a() {
      // $FF: Couldn't be decompiled
   }

   public SdkLogRequest$Builder b(CharSequence var1) {
      this.a(this.b()[4], var1);
      this.e = var1;
      this.c()[4] = true;
      return this;
   }

   public SdkLogRequest$Builder b(List var1) {
      this.a(this.b()[2], var1);
      this.c = var1;
      this.c()[2] = true;
      return this;
   }
}
