package com.flurry.android.impl.ads.avro.protocol.v10;

import com.flurry.android.impl.ads.avro.protocol.v10.Location;
import com.flurry.sdk.gx;

public class Location$Builder extends gx {
   private float a;
   private float b;

   private Location$Builder() {
      super(Location.SCHEMA$);
   }

   // $FF: synthetic method
   Location$Builder(Object var1) {
      this();
   }

   public Location$Builder a(float var1) {
      this.a(this.b()[0], Float.valueOf(var1));
      this.a = var1;
      this.c()[0] = true;
      return this;
   }

   public Location a() {
      // $FF: Couldn't be decompiled
   }

   public Location$Builder b(float var1) {
      this.a(this.b()[1], Float.valueOf(var1));
      this.b = var1;
      this.c()[1] = true;
      return this;
   }
}
