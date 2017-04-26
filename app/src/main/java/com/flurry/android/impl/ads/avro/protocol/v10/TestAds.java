package com.flurry.android.impl.ads.avro.protocol.v10;

import com.flurry.android.impl.ads.avro.protocol.v10.TestAds$Builder;
import com.flurry.sdk.fk;
import com.flurry.sdk.fn;
import com.flurry.sdk.fn$q;
import com.flurry.sdk.gv;
import com.flurry.sdk.gw;

public class TestAds extends gw implements gv {
   public static final fn SCHEMA$ = (new fn$q()).a("{\"type\":\"record\",\"name\":\"TestAds\",\"namespace\":\"com.flurry.android.impl.ads.avro.protocol.v10\",\"fields\":[{\"name\":\"adspacePlacement\",\"type\":\"int\",\"default\":0}]}");
   @Deprecated
   public int a;

   public static TestAds$Builder b() {
      return new TestAds$Builder(null);
   }

   public fn a() {
      return SCHEMA$;
   }

   public Object a(int var1) {
      switch(var1) {
      case 0:
         return Integer.valueOf(this.a);
      default:
         throw new fk("Bad index");
      }
   }

   public void a(int var1, Object var2) {
      switch(var1) {
      case 0:
         this.a = ((Integer)var2).intValue();
         return;
      default:
         throw new fk("Bad index");
      }
   }
}
