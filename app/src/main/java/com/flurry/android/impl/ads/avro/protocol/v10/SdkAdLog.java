package com.flurry.android.impl.ads.avro.protocol.v10;

import com.flurry.sdk.fk;
import com.flurry.sdk.fn;
import com.flurry.sdk.fn$q;
import com.flurry.sdk.gv;
import com.flurry.sdk.gw;
import java.util.List;

public class SdkAdLog extends gw implements gv {
   public static final fn SCHEMA$ = (new fn$q()).a("{\"type\":\"record\",\"name\":\"SdkAdLog\",\"namespace\":\"com.flurry.android.impl.ads.avro.protocol.v10\",\"fields\":[{\"name\":\"sessionId\",\"type\":\"long\"},{\"name\":\"adLogGUID\",\"type\":\"string\"},{\"name\":\"sdkAdEvents\",\"type\":{\"type\":\"array\",\"items\":{\"type\":\"record\",\"name\":\"SdkAdEvent\",\"fields\":[{\"name\":\"type\",\"type\":\"string\"},{\"name\":\"params\",\"type\":{\"type\":\"map\",\"values\":\"string\"}},{\"name\":\"timeOffset\",\"type\":\"long\"}]}}}]}");
   @Deprecated
   public long a;
   @Deprecated
   public CharSequence b;
   @Deprecated
   public List c;

   public fn a() {
      return SCHEMA$;
   }

   public Object a(int var1) {
      switch(var1) {
      case 0:
         return Long.valueOf(this.a);
      case 1:
         return this.b;
      case 2:
         return this.c;
      default:
         throw new fk("Bad index");
      }
   }

   public void a(int var1, Object var2) {
      switch(var1) {
      case 0:
         this.a = ((Long)var2).longValue();
         return;
      case 1:
         this.b = (CharSequence)var2;
         return;
      case 2:
         this.c = (List)var2;
         return;
      default:
         throw new fk("Bad index");
      }
   }

   public void a(CharSequence var1) {
      this.b = var1;
   }

   public void a(Long var1) {
      this.a = var1.longValue();
   }

   public void a(List var1) {
      this.c = var1;
   }
}
