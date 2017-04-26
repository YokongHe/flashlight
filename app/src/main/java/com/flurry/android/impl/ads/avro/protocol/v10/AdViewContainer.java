package com.flurry.android.impl.ads.avro.protocol.v10;

import com.flurry.android.impl.ads.avro.protocol.v10.AdViewContainer$Builder;
import com.flurry.android.impl.ads.avro.protocol.v10.ScreenOrientationType;
import com.flurry.sdk.fk;
import com.flurry.sdk.fn;
import com.flurry.sdk.fn$q;
import com.flurry.sdk.gv;
import com.flurry.sdk.gw;

public class AdViewContainer extends gw implements gv {
   public static final fn SCHEMA$ = (new fn$q()).a("{\"type\":\"record\",\"name\":\"AdViewContainer\",\"namespace\":\"com.flurry.android.impl.ads.avro.protocol.v10\",\"fields\":[{\"name\":\"viewWidth\",\"type\":\"int\",\"default\":0},{\"name\":\"viewHeight\",\"type\":\"int\",\"default\":0},{\"name\":\"screenWidth\",\"type\":\"int\",\"default\":0},{\"name\":\"screenHeight\",\"type\":\"int\",\"default\":0},{\"name\":\"density\",\"type\":\"float\",\"default\":1.0},{\"name\":\"screenOrientation\",\"type\":{\"type\":\"enum\",\"name\":\"ScreenOrientationType\",\"symbols\":[\"PORTRAIT\",\"LANDSCAPE\",\"UNKNOWN\"]},\"default\":\"UNKNOWN\"}]}");
   @Deprecated
   public int a;
   @Deprecated
   public int b;
   @Deprecated
   public int c;
   @Deprecated
   public int d;
   @Deprecated
   public float e;
   @Deprecated
   public ScreenOrientationType f;

   public static AdViewContainer$Builder b() {
      return new AdViewContainer$Builder(null);
   }

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
         return Integer.valueOf(this.c);
      case 3:
         return Integer.valueOf(this.d);
      case 4:
         return Float.valueOf(this.e);
      case 5:
         return this.f;
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
         this.c = ((Integer)var2).intValue();
         return;
      case 3:
         this.d = ((Integer)var2).intValue();
         return;
      case 4:
         this.e = ((Float)var2).floatValue();
         return;
      case 5:
         this.f = (ScreenOrientationType)var2;
         return;
      default:
         throw new fk("Bad index");
      }
   }
}
