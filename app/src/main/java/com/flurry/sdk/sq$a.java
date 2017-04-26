package com.flurry.sdk;

import com.flurry.sdk.ha;
import com.flurry.sdk.hg;
import com.flurry.sdk.hj$b;
import com.flurry.sdk.hm;
import com.flurry.sdk.hn;
import com.flurry.sdk.hv;
import com.flurry.sdk.hw;
import com.flurry.sdk.sj;
import com.flurry.sdk.sq$b;
import java.math.BigDecimal;
import java.math.BigInteger;

public final class sq$a extends hv {
   protected hn d;
   protected sq$b e;
   protected int f;
   protected hw g;
   protected boolean h;
   protected transient sj i;
   protected hg j = null;

   public sq$a(sq$b var1, hn var2) {
      super(0);
      this.e = var1;
      this.f = -1;
      this.d = var2;
      this.g = hw.a(-1, -1);
   }

   protected final Object A() {
      return this.e.b(this.f);
   }

   protected final void B() {
      if(this.b == null || !this.b.c()) {
         throw this.a((String)("Current token (" + this.b + ") not numeric, can not use numeric value accessors"));
      }
   }

   protected final void H() {
      this.U();
   }

   public final hn a() {
      return this.d;
   }

   public final void a(hg var1) {
      this.j = var1;
   }

   public final byte[] a(ha var1) {
      if(this.b == hm.g) {
         Object var2 = this.A();
         if(var2 instanceof byte[]) {
            return (byte[])var2;
         }
      }

      if(this.b != hm.h) {
         throw this.a((String)("Current token (" + this.b + ") not VALUE_STRING (or VALUE_EMBEDDED_OBJECT with byte[]), can not access as binary"));
      } else {
         String var3 = this.k();
         if(var3 == null) {
            return null;
         } else {
            sj var4 = this.i;
            if(var4 == null) {
               var4 = new sj(100);
               this.i = var4;
            } else {
               this.i.a();
            }

            this.a(var3, var4, var1);
            return var4.b();
         }
      }
   }

   public final hm b() {
      label40: {
         if(!this.h && this.e != null) {
            int var1 = this.f + 1;
            this.f = var1;
            if(var1 < 16) {
               break label40;
            }

            this.f = 0;
            this.e = this.e.a();
            if(this.e != null) {
               break label40;
            }
         }

         return null;
      }

      this.b = this.e.a(this.f);
      if(this.b == hm.f) {
         Object var2 = this.A();
         String var3;
         if(var2 instanceof String) {
            var3 = (String)var2;
         } else {
            var3 = var2.toString();
         }

         this.g.a(var3);
      } else if(this.b == hm.b) {
         this.g = this.g.c(-1, -1);
      } else if(this.b == hm.d) {
         this.g = this.g.b(-1, -1);
      } else if(this.b == hm.c || this.b == hm.e) {
         this.g = this.g.i();
         if(this.g == null) {
            this.g = hw.a(-1, -1);
         }
      }

      return this.b;
   }

   public final void close() {
      if(!this.h) {
         this.h = true;
      }

   }

   public final String g() {
      return this.g.h();
   }

   public final hg h() {
      return this.i();
   }

   public final hg i() {
      return this.j == null?hg.a:this.j;
   }

   public final String k() {
      Object var1;
      if(this.b != hm.h && this.b != hm.f) {
         if(this.b == null) {
            return null;
         } else {
            switch(null.a[this.b.ordinal()]) {
            case 7:
            case 8:
               var1 = this.A();
               if(var1 == null) {
                  return null;
               }

               return var1.toString();
            default:
               return this.b.a();
            }
         }
      } else {
         var1 = this.A();
         return var1 instanceof String?(String)var1:(var1 == null?null:var1.toString());
      }
   }

   public final char[] l() {
      String var1 = this.k();
      return var1 == null?null:var1.toCharArray();
   }

   public final int m() {
      String var1 = this.k();
      return var1 == null?0:var1.length();
   }

   public final int n() {
      return 0;
   }

   public final boolean o() {
      return false;
   }

   public final Number p() {
      this.B();
      return (Number)this.A();
   }

   public final hj$b q() {
      Number var1 = this.p();
      return var1 instanceof Integer?hj$b.a:(var1 instanceof Long?hj$b.b:(var1 instanceof Double?hj$b.e:(var1 instanceof BigDecimal?hj$b.f:(var1 instanceof Float?hj$b.d:(var1 instanceof BigInteger?hj$b.c:null)))));
   }

   public final int t() {
      return this.b == hm.i?((Number)this.A()).intValue():this.p().intValue();
   }

   public final long u() {
      return this.p().longValue();
   }

   public final BigInteger v() {
      Number var1 = this.p();
      if(var1 instanceof BigInteger) {
         return (BigInteger)var1;
      } else {
         switch(null.b[this.q().ordinal()]) {
         case 3:
            return ((BigDecimal)var1).toBigInteger();
         default:
            return BigInteger.valueOf(var1.longValue());
         }
      }
   }

   public final float w() {
      return this.p().floatValue();
   }

   public final double x() {
      return this.p().doubleValue();
   }

   public final BigDecimal y() {
      Number var1 = this.p();
      if(var1 instanceof BigDecimal) {
         return (BigDecimal)var1;
      } else {
         switch(null.b[this.q().ordinal()]) {
         case 1:
         case 5:
            return BigDecimal.valueOf(var1.longValue());
         case 2:
            return new BigDecimal((BigInteger)var1);
         case 3:
         case 4:
         default:
            return BigDecimal.valueOf(var1.doubleValue());
         }
      }
   }

   public final Object z() {
      return this.b == hm.g?this.A():null;
   }
}
