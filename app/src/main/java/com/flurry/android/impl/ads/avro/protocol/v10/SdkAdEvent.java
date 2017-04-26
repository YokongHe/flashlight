package com.flurry.android.impl.ads.avro.protocol.v10;

import com.flurry.sdk.fk;
import com.flurry.sdk.fn;
import com.flurry.sdk.fn$q;
import com.flurry.sdk.gv;
import com.flurry.sdk.gw;
import java.util.Map;

public class SdkAdEvent extends gw implements gv {
   public static final fn SCHEMA$ = (new fn$q()).a("{\"type\":\"record\",\"name\":\"SdkAdEvent\",\"namespace\":\"com.flurry.android.impl.ads.avro.protocol.v10\",\"fields\":[{\"name\":\"type\",\"type\":\"string\"},{\"name\":\"params\",\"type\":{\"type\":\"map\",\"values\":\"string\"}},{\"name\":\"timeOffset\",\"type\":\"long\"}]}");
   @Deprecated
   public CharSequence a;
   @Deprecated
   public Map b;
   @Deprecated
   public long c;

   public fn a() {
      return SCHEMA$;
   }

   public Object a(int var1) {
      switch(var1) {
      case 0:
         return this.a;
      case 1:
         return this.b;
      case 2:
         return Long.valueOf(this.c);
      default:
         throw new fk("Bad index");
      }
   }

   public void a(int var1, Object var2) {
      switch(var1) {
      case 0:
         this.a = (CharSequence)var2;
         return;
      case 1:
         this.b = (Map)var2;
         return;
      case 2:
         this.c = ((Long)var2).longValue();
         return;
      default:
         throw new fk("Bad index");
      }
   }

   public void a(CharSequence var1) {
      this.a = var1;
   }

   public void a(Long var1) {
      this.c = var1.longValue();
   }

   public void a(Map var1) {
      this.b = var1;
   }
}
