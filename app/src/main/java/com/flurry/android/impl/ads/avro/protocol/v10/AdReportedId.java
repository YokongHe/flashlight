package com.flurry.android.impl.ads.avro.protocol.v10;

import com.flurry.android.impl.ads.avro.protocol.v10.AdReportedId$Builder;
import com.flurry.sdk.fk;
import com.flurry.sdk.fn;
import com.flurry.sdk.fn$q;
import com.flurry.sdk.gv;
import com.flurry.sdk.gw;
import java.nio.ByteBuffer;

public class AdReportedId extends gw implements gv {
   public static final fn SCHEMA$ = (new fn$q()).a("{\"type\":\"record\",\"name\":\"AdReportedId\",\"namespace\":\"com.flurry.android.impl.ads.avro.protocol.v10\",\"fields\":[{\"name\":\"type\",\"type\":\"int\"},{\"name\":\"id\",\"type\":\"bytes\"}]}");
   @Deprecated
   public int a;
   @Deprecated
   public ByteBuffer b;

   public static AdReportedId$Builder b() {
      return new AdReportedId$Builder(null);
   }

   public fn a() {
      return SCHEMA$;
   }

   public Object a(int var1) {
      switch(var1) {
      case 0:
         return Integer.valueOf(this.a);
      case 1:
         return this.b;
      default:
         throw new fk("Bad index");
      }
   }

   public void a(int var1, Object var2) {
      switch(var1) {
      case 0:
         this.a = ((Integer)var2).intValue();
         return;
      case 1:
         this.b = (ByteBuffer)var2;
         return;
      default:
         throw new fk("Bad index");
      }
   }
}
