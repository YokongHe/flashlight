package com.flurry.sdk;

import com.flurry.sdk.ha;
import com.flurry.sdk.hg;
import com.flurry.sdk.hj$b;
import com.flurry.sdk.hm;
import com.flurry.sdk.hv;
import com.flurry.sdk.hw;
import com.flurry.sdk.ie;
import com.flurry.sdk.ii;
import com.flurry.sdk.sj;
import com.flurry.sdk.sp;
import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class hu extends hv {
   static final BigDecimal u = new BigDecimal(Long.MIN_VALUE);
   static final BigDecimal v = new BigDecimal(Long.MAX_VALUE);
   static final BigDecimal w = new BigDecimal(Long.MIN_VALUE);
   static final BigDecimal x = new BigDecimal(Long.MAX_VALUE);
   protected long A;
   protected double B;
   protected BigInteger C;
   protected BigDecimal D;
   protected boolean E;
   protected int F;
   protected int G;
   protected int H;
   protected final ie d;
   protected boolean e;
   protected int f = 0;
   protected int g = 0;
   protected long h = 0L;
   protected int i = 1;
   protected int j = 0;
   protected long k = 0L;
   protected int l = 1;
   protected int m = 0;
   protected hw n;
   protected hm o;
   protected final sp p;
   protected char[] q = null;
   protected boolean r = false;
   protected sj s = null;
   protected byte[] t;
   protected int y = 0;
   protected int z;

   protected hu(ie var1, int var2) {
      this.a = var2;
      this.d = var1;
      this.p = var1.d();
      this.n = hw.g();
   }

   private final void a(int var1, char[] var2, int var3, int var4) {
      String var5 = this.p.f();

      try {
         if(ii.a(var2, var3, var4, this.E)) {
            this.A = Long.parseLong(var5);
            this.y = 2;
         } else {
            this.C = new BigInteger(var5);
            this.y = 4;
         }
      } catch (NumberFormatException var6) {
         this.a("Malformed numeric value \'" + var5 + "\'", var6);
      }
   }

   private final void d(int param1) {
      // $FF: Couldn't be decompiled
   }

   public final long A() {
      return this.k;
   }

   public final int B() {
      return this.l;
   }

   public final int C() {
      int var1 = this.m;
      return var1 < 0?var1:var1 + 1;
   }

   protected final void D() {
      if(!this.E()) {
         this.S();
      }

   }

   protected abstract boolean E();

   protected abstract void F();

   protected void G() {
      this.p.a();
      char[] var1 = this.q;
      if(var1 != null) {
         this.q = null;
         this.d.c(var1);
      }

   }

   protected void H() {
      if(!this.n.b()) {
         this.c(": expected close marker for " + this.n.d() + " (from " + this.n.a(this.d.a()) + ")");
      }

   }

   public sj I() {
      if(this.s == null) {
         this.s = new sj();
      } else {
         this.s.a();
      }

      return this.s;
   }

   protected void J() {
      if((this.y & 2) != 0) {
         int var1 = (int)this.A;
         if((long)var1 != this.A) {
            this.d("Numeric value (" + this.k() + ") out of range of int");
         }

         this.z = var1;
      } else if((this.y & 4) != 0) {
         this.z = this.C.intValue();
      } else if((this.y & 8) != 0) {
         if(this.B < -2.147483648E9D || this.B > 2.147483647E9D) {
            this.O();
         }

         this.z = (int)this.B;
      } else if((this.y & 16) != 0) {
         if(w.compareTo(this.D) > 0 || x.compareTo(this.D) < 0) {
            this.O();
         }

         this.z = this.D.intValue();
      } else {
         this.U();
      }

      this.y |= 1;
   }

   protected void K() {
      if((this.y & 1) != 0) {
         this.A = (long)this.z;
      } else if((this.y & 4) != 0) {
         this.A = this.C.longValue();
      } else if((this.y & 8) != 0) {
         if(this.B < -9.223372036854776E18D || this.B > 9.223372036854776E18D) {
            this.P();
         }

         this.A = (long)this.B;
      } else if((this.y & 16) != 0) {
         if(u.compareTo(this.D) > 0 || v.compareTo(this.D) < 0) {
            this.P();
         }

         this.A = this.D.longValue();
      } else {
         this.U();
      }

      this.y |= 2;
   }

   protected void L() {
      if((this.y & 16) != 0) {
         this.C = this.D.toBigInteger();
      } else if((this.y & 2) != 0) {
         this.C = BigInteger.valueOf(this.A);
      } else if((this.y & 1) != 0) {
         this.C = BigInteger.valueOf((long)this.z);
      } else if((this.y & 8) != 0) {
         this.C = BigDecimal.valueOf(this.B).toBigInteger();
      } else {
         this.U();
      }

      this.y |= 4;
   }

   protected void M() {
      if((this.y & 16) != 0) {
         this.B = this.D.doubleValue();
      } else if((this.y & 4) != 0) {
         this.B = this.C.doubleValue();
      } else if((this.y & 2) != 0) {
         this.B = (double)this.A;
      } else if((this.y & 1) != 0) {
         this.B = (double)this.z;
      } else {
         this.U();
      }

      this.y |= 8;
   }

   protected void N() {
      if((this.y & 8) != 0) {
         this.D = new BigDecimal(this.k());
      } else if((this.y & 4) != 0) {
         this.D = new BigDecimal(this.C);
      } else if((this.y & 2) != 0) {
         this.D = BigDecimal.valueOf(this.A);
      } else if((this.y & 1) != 0) {
         this.D = BigDecimal.valueOf((long)this.z);
      } else {
         this.U();
      }

      this.y |= 16;
   }

   protected void O() {
      this.d("Numeric value (" + this.k() + ") out of range of int (-2147483648" + " - 2147483647" + ")");
   }

   protected void P() {
      this.d("Numeric value (" + this.k() + ") out of range of long (-9223372036854775808" + " - 9223372036854775807" + ")");
   }

   protected char Q() {
      throw new UnsupportedOperationException();
   }

   protected final int a(ha var1, char var2, int var3) {
      if(var2 != 92) {
         throw this.b(var1, var2, var3);
      } else {
         char var4 = this.Q();
         int var6;
         if(var4 <= 32 && var3 == 0) {
            var6 = -1;
         } else {
            int var5 = var1.b(var4);
            var6 = var5;
            if(var5 < 0) {
               throw this.b(var1, var4, var3);
            }
         }

         return var6;
      }
   }

   protected final int a(ha var1, int var2, int var3) {
      if(var2 != 92) {
         throw this.b(var1, var2, var3);
      } else {
         char var5 = this.Q();
         if(var5 <= 32 && var3 == 0) {
            var2 = -1;
         } else {
            int var4 = var1.b((int)var5);
            var2 = var4;
            if(var4 < 0) {
               throw this.b(var1, var5, var3);
            }
         }

         return var2;
      }
   }

   protected final hm a(String var1, double var2) {
      this.p.a(var1);
      this.B = var2;
      this.y = 8;
      return hm.j;
   }

   protected final hm a(boolean var1, int var2) {
      this.E = var1;
      this.F = var2;
      this.G = 0;
      this.H = 0;
      this.y = 0;
      return hm.i;
   }

   protected final hm a(boolean var1, int var2, int var3, int var4) {
      return var3 <= 0 && var4 <= 0?this.a(var1, var2):this.b(var1, var2, var3, var4);
   }

   protected IllegalArgumentException a(ha var1, int var2, int var3, String var4) {
      String var6;
      if(var2 <= 32) {
         var6 = "Illegal white space character (code 0x" + Integer.toHexString(var2) + ") as character #" + (var3 + 1) + " of 4-char base64 unit: can only used between units";
      } else if(var1.a(var2)) {
         var6 = "Unexpected padding character (\'" + var1.b() + "\') as character #" + (var3 + 1) + " of 4-char base64 unit: padding only legal as 3rd or 4th character";
      } else if(Character.isDefined(var2) && !Character.isISOControl(var2)) {
         var6 = "Illegal character \'" + (char)var2 + "\' (code 0x" + Integer.toHexString(var2) + ") in base64 content";
      } else {
         var6 = "Illegal character (code 0x" + Integer.toHexString(var2) + ") in base64 content";
      }

      String var5 = var6;
      if(var4 != null) {
         var5 = var6 + ": " + var4;
      }

      return new IllegalArgumentException(var5);
   }

   protected void a(int var1) {
      if(this.b == hm.i) {
         char[] var9 = this.p.e();
         int var3 = this.p.d();
         int var4 = this.F;
         int var2 = var3;
         if(this.E) {
            var2 = var3 + 1;
         }

         if(var4 <= 9) {
            var2 = ii.a(var9, var2, var4);
            var1 = var2;
            if(this.E) {
               var1 = -var2;
            }

            this.z = var1;
            this.y = 1;
         } else if(var4 <= 18) {
            long var7 = ii.b(var9, var2, var4);
            long var5 = var7;
            if(this.E) {
               var5 = -var7;
            }

            if(var4 == 10) {
               if(this.E) {
                  if(var5 >= -2147483648L) {
                     this.z = (int)var5;
                     this.y = 1;
                     return;
                  }
               } else if(var5 <= 2147483647L) {
                  this.z = (int)var5;
                  this.y = 1;
                  return;
               }
            }

            this.A = var5;
            this.y = 2;
         } else {
            this.a(var1, var9, var2, var4);
         }
      } else if(this.b == hm.j) {
         this.d(var1);
      } else {
         this.d("Current token (" + this.b + ") not numeric, can not use numeric value accessors");
      }
   }

   protected void a(int var1, char var2) {
      String var3 = "" + this.n.a(this.d.a());
      this.d("Unexpected close marker \'" + (char)var1 + "\': expected \'" + var2 + "\' (for " + this.n.d() + " starting at " + var3 + ")");
   }

   protected void a(int var1, String var2) {
      String var4 = "Unexpected character (" + c(var1) + ") in numeric value";
      String var3 = var4;
      if(var2 != null) {
         var3 = var4 + ": " + var2;
      }

      this.d(var3);
   }

   protected final hm b(boolean var1, int var2, int var3, int var4) {
      this.E = var1;
      this.F = var2;
      this.G = var3;
      this.H = var4;
      this.y = 0;
      return hm.j;
   }

   protected IllegalArgumentException b(ha var1, int var2, int var3) {
      return this.a(var1, var2, var3, (String)null);
   }

   protected void b(String var1) {
      this.d("Invalid numeric value: " + var1);
   }

   public void close() {
      if(!this.e) {
         this.e = true;

         try {
            this.F();
         } finally {
            this.G();
         }
      }

   }

   public String g() {
      return this.b != hm.b && this.b != hm.d?this.n.h():this.n.i().h();
   }

   public hg h() {
      return new hg(this.d.a(), this.A(), this.B(), this.C());
   }

   public hg i() {
      int var1 = this.f;
      int var2 = this.j;
      return new hg(this.d.a(), this.h + (long)this.f - 1L, this.i, var1 - var2 + 1);
   }

   public boolean o() {
      return this.b == hm.h?true:(this.b == hm.f?this.r:false);
   }

   public Number p() {
      if(this.y == 0) {
         this.a(0);
      }

      if(this.b == hm.i) {
         return (Number)((this.y & 1) != 0?Integer.valueOf(this.z):((this.y & 2) != 0?Long.valueOf(this.A):((this.y & 4) != 0?this.C:this.D)));
      } else if((this.y & 16) != 0) {
         return this.D;
      } else {
         if((this.y & 8) == 0) {
            this.U();
         }

         return Double.valueOf(this.B);
      }
   }

   public hj$b q() {
      if(this.y == 0) {
         this.a(0);
      }

      return this.b == hm.i?((this.y & 1) != 0?hj$b.a:((this.y & 2) != 0?hj$b.b:hj$b.c)):((this.y & 16) != 0?hj$b.f:hj$b.e);
   }

   public int t() {
      if((this.y & 1) == 0) {
         if(this.y == 0) {
            this.a(1);
         }

         if((this.y & 1) == 0) {
            this.J();
         }
      }

      return this.z;
   }

   public long u() {
      if((this.y & 2) == 0) {
         if(this.y == 0) {
            this.a(2);
         }

         if((this.y & 2) == 0) {
            this.K();
         }
      }

      return this.A;
   }

   public BigInteger v() {
      if((this.y & 4) == 0) {
         if(this.y == 0) {
            this.a(4);
         }

         if((this.y & 4) == 0) {
            this.L();
         }
      }

      return this.C;
   }

   public float w() {
      return (float)this.x();
   }

   public double x() {
      if((this.y & 8) == 0) {
         if(this.y == 0) {
            this.a(8);
         }

         if((this.y & 8) == 0) {
            this.M();
         }
      }

      return this.B;
   }

   public BigDecimal y() {
      if((this.y & 16) == 0) {
         if(this.y == 0) {
            this.a(16);
         }

         if((this.y & 16) == 0) {
            this.N();
         }
      }

      return this.D;
   }
}
