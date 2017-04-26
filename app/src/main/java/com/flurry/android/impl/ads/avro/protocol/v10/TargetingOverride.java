package com.flurry.android.impl.ads.avro.protocol.v10;

import com.flurry.sdk.fk;
import com.flurry.sdk.fn;
import com.flurry.sdk.fn$q;
import com.flurry.sdk.gv;
import com.flurry.sdk.gw;
import java.util.List;

public class TargetingOverride extends gw implements gv {
   public static final fn SCHEMA$ = (new fn$q()).a("{\"type\":\"record\",\"name\":\"TargetingOverride\",\"namespace\":\"com.flurry.android.impl.ads.avro.protocol.v10\",\"fields\":[{\"name\":\"ageRange\",\"type\":\"int\",\"default\":-2},{\"name\":\"gender\",\"type\":\"int\",\"default\":-2},{\"name\":\"personas\",\"type\":{\"type\":\"array\",\"items\":\"int\"},\"default\":[]}]}");
   @Deprecated
   public int a;
   @Deprecated
   public int b;
   @Deprecated
   public List c;

   public fn a() {
      return SCHEMA$;
   }

   public Object a(int var1) {
      switch(var1) {
      case 0:
         return Integer.valueOf(this.a);
      case 1:
         return Integer.valueOf(this.b);
      case 2:
         return this.c;
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
         this.b = ((Integer)var2).intValue();
         return;
      case 2:
         this.c = (List)var2;
         return;
      default:
         throw new fk("Bad index");
      }
   }
}
