package com.flurry.sdk;

import com.flurry.sdk.li;
import com.flurry.sdk.ll;
import com.flurry.sdk.lm;
import com.flurry.sdk.lp;
import com.flurry.sdk.lt;
import com.flurry.sdk.lu;
import com.flurry.sdk.lz;
import com.flurry.sdk.lz$a;
import com.flurry.sdk.lz$b;
import com.flurry.sdk.lz$c;
import com.flurry.sdk.lz$d;
import com.flurry.sdk.lz$e;
import com.flurry.sdk.lz$f;
import com.flurry.sdk.lz$g;
import com.flurry.sdk.lz$h;
import com.flurry.sdk.lz$i;
import com.flurry.sdk.lz$j;
import com.flurry.sdk.lz$l;
import com.flurry.sdk.lz$m;
import com.flurry.sdk.lz$n;
import com.flurry.sdk.mf;
import com.flurry.sdk.mh;
import com.flurry.sdk.mi;
import com.flurry.sdk.mj;
import com.flurry.sdk.qj;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;

class kw {
   final HashMap a = new HashMap();

   private kw() {
      this.a(new mj());
      mf var1 = new mf();
      this.a(var1, String.class);
      this.a(var1, CharSequence.class);
      this.a(new lm());
      this.a(new lz$c(Boolean.class, (Boolean)null));
      this.a(new lz$d(Byte.class, (Byte)null));
      this.a(new lz$l(Short.class, (Short)null));
      this.a(new lz$e(Character.class, (Character)null));
      this.a(new lz$h(Integer.class, (Integer)null));
      this.a(new lz$i(Long.class, (Long)null));
      this.a(new lz$g(Float.class, (Float)null));
      this.a(new lz$f(Double.class, (Double)null));
      this.a(new lz$c(Boolean.TYPE, Boolean.FALSE));
      this.a(new lz$d(Byte.TYPE, Byte.valueOf((byte)0)));
      this.a(new lz$l(Short.TYPE, Short.valueOf((short)0)));
      this.a(new lz$e(Character.TYPE, Character.valueOf('\u0000')));
      this.a(new lz$h(Integer.TYPE, Integer.valueOf(0)));
      this.a(new lz$i(Long.TYPE, Long.valueOf(0L)));
      this.a(new lz$g(Float.TYPE, Float.valueOf(0.0F)));
      this.a(new lz$f(Double.TYPE, Double.valueOf(0.0D)));
      this.a(new lz$j());
      this.a(new lz$a());
      this.a(new lz$b());
      this.a(new ll());
      this.a(new lp());
      this.a(new ll(GregorianCalendar.class), GregorianCalendar.class);
      this.a(new lz$m());
      this.a(new mh());
      Iterator var2 = lt.d().iterator();

      while(var2.hasNext()) {
         this.a((lt)var2.next());
      }

      this.a(new lz$n());
      this.a(new li());
      this.a(new mi());
      this.a(new lu());
   }

   public static HashMap a() {
      return (new kw()).a;
   }

   private void a(lz var1) {
      this.a(var1, var1.f());
   }

   private void a(lz var1, Class var2) {
      this.a.put(new qj(var2), var1);
   }
}
