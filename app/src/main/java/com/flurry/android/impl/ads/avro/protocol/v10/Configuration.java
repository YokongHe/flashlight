package com.flurry.android.impl.ads.avro.protocol.v10;

import com.flurry.sdk.fk;
import com.flurry.sdk.fn;
import com.flurry.sdk.fn$q;
import com.flurry.sdk.gv;
import com.flurry.sdk.gw;

public class Configuration extends gw implements gv {
   public static final fn SCHEMA$ = (new fn$q()).a("{\"type\":\"record\",\"name\":\"Configuration\",\"namespace\":\"com.flurry.android.impl.ads.avro.protocol.v10\",\"fields\":[{\"name\":\"sdkAssetUrl\",\"type\":\"string\"},{\"name\":\"cacheSizeMb\",\"type\":\"int\",\"default\":20},{\"name\":\"maxAssetSizeKb\",\"type\":\"int\",\"default\":2024}]}");
   @Deprecated
   public CharSequence a;
   @Deprecated
   public int b;
   @Deprecated
   public int c;

   public fn a() {
      return SCHEMA$;
   }

   public Object a(int var1) {
      switch(var1) {
      case 0:
         return this.a;
      case 1:
         return Integer.valueOf(this.b);
      case 2:
         return Integer.valueOf(this.c);
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
         this.b = ((Integer)var2).intValue();
         return;
      case 2:
         this.c = ((Integer)var2).intValue();
         return;
      default:
         throw new fk("Bad index");
      }
   }

   public CharSequence b() {
      return this.a;
   }

   public Integer c() {
      return Integer.valueOf(this.b);
   }

   public Integer d() {
      return Integer.valueOf(this.c);
   }
}
