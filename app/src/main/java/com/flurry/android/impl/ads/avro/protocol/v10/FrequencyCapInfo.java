package com.flurry.android.impl.ads.avro.protocol.v10;

import com.flurry.android.impl.ads.avro.protocol.v10.FrequencyCapInfo$Builder;
import com.flurry.sdk.fk;
import com.flurry.sdk.fn;
import com.flurry.sdk.fn$q;
import com.flurry.sdk.gv;
import com.flurry.sdk.gw;

public class FrequencyCapInfo extends gw implements gv {
   public static final fn SCHEMA$ = (new fn$q()).a("{\"type\":\"record\",\"name\":\"FrequencyCapInfo\",\"namespace\":\"com.flurry.android.impl.ads.avro.protocol.v10\",\"fields\":[{\"name\":\"idHash\",\"type\":\"string\",\"default\":\"null\"},{\"name\":\"serveTime\",\"type\":\"long\"},{\"name\":\"expirationTime\",\"type\":\"long\"},{\"name\":\"views\",\"type\":\"int\"},{\"name\":\"newCap\",\"type\":\"int\"},{\"name\":\"previousCap\",\"type\":\"int\"},{\"name\":\"previousCapType\",\"type\":\"int\"}]}");
   @Deprecated
   public CharSequence a;
   @Deprecated
   public long b;
   @Deprecated
   public long c;
   @Deprecated
   public int d;
   @Deprecated
   public int e;
   @Deprecated
   public int f;
   @Deprecated
   public int g;

   public static FrequencyCapInfo$Builder b() {
      return new FrequencyCapInfo$Builder(null);
   }

   public fn a() {
      return SCHEMA$;
   }

   public Object a(int var1) {
      switch(var1) {
      case 0:
         return this.a;
      case 1:
         return Long.valueOf(this.b);
      case 2:
         return Long.valueOf(this.c);
      case 3:
         return Integer.valueOf(this.d);
      case 4:
         return Integer.valueOf(this.e);
      case 5:
         return Integer.valueOf(this.f);
      case 6:
         return Integer.valueOf(this.g);
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
         this.b = ((Long)var2).longValue();
         return;
      case 2:
         this.c = ((Long)var2).longValue();
         return;
      case 3:
         this.d = ((Integer)var2).intValue();
         return;
      case 4:
         this.e = ((Integer)var2).intValue();
         return;
      case 5:
         this.f = ((Integer)var2).intValue();
         return;
      case 6:
         this.g = ((Integer)var2).intValue();
         return;
      default:
         throw new fk("Bad index");
      }
   }
}
