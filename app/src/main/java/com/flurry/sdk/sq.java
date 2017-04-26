package com.flurry.sdk;

import com.flurry.sdk.ha;
import com.flurry.sdk.he;
import com.flurry.sdk.hf;
import com.flurry.sdk.hh;
import com.flurry.sdk.hj;
import com.flurry.sdk.hj$a;
import com.flurry.sdk.hm;
import com.flurry.sdk.hn;
import com.flurry.sdk.hp;
import com.flurry.sdk.hx;
import com.flurry.sdk.im;
import com.flurry.sdk.sq$a;
import com.flurry.sdk.sq$b;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;

public class sq extends hf {
   protected static final int b = hj$a.a();
   protected hn c;
   protected int d;
   protected boolean e;
   protected sq$b f;
   protected sq$b g;
   protected int h;
   protected hx i;

   public sq(hn var1) {
      this.c = var1;
      this.d = b;
      this.i = hx.g();
      sq$b var2 = new sq$b();
      this.g = var2;
      this.f = var2;
      this.h = 0;
   }

   public hf a() {
      return this;
   }

   public hj a(hj var1) {
      sq$a var2 = new sq$a(this.f, var1.a());
      var2.a(var1.h());
      return var2;
   }

   public hj a(hn var1) {
      return new sq$a(this.f, var1);
   }

   public void a(char var1) {
      this.i();
   }

   public void a(double var1) {
      this.a(hm.j, Double.valueOf(var1));
   }

   public void a(float var1) {
      this.a(hm.j, Float.valueOf(var1));
   }

   public void a(long var1) {
      this.a(hm.i, Long.valueOf(var1));
   }

   public void a(ha var1, byte[] var2, int var3, int var4) {
      byte[] var5 = new byte[var4];
      System.arraycopy(var2, var3, var5, 0, var4);
      this.a((Object)var5);
   }

   public void a(hf var1) {
      sq$b var3 = this.f;
      int var2 = -1;

      while(true) {
         ++var2;
         if(var2 >= 16) {
            var3 = var3.a();
            if(var3 == null) {
               break;
            }

            var2 = 0;
         }

         hm var4 = var3.a(var2);
         if(var4 == null) {
            break;
         }

         Object var5;
         switch(null.a[var4.ordinal()]) {
         case 1:
            var1.d();
            break;
         case 2:
            var1.e();
            break;
         case 3:
            var1.b();
            break;
         case 4:
            var1.c();
            break;
         case 5:
            var5 = var3.b(var2);
            if(var5 instanceof hp) {
               var1.a((hp)var5);
            } else {
               var1.a((String)var5);
            }
            break;
         case 6:
            var5 = var3.b(var2);
            if(var5 instanceof hp) {
               var1.b((hp)var5);
            } else {
               var1.b((String)var5);
            }
            break;
         case 7:
            Number var6 = (Number)var3.b(var2);
            if(var6 instanceof BigInteger) {
               var1.a((BigInteger)var6);
            } else if(var6 instanceof Long) {
               var1.a(var6.longValue());
            } else {
               var1.b(var6.intValue());
            }
            break;
         case 8:
            var5 = var3.b(var2);
            if(var5 instanceof BigDecimal) {
               var1.a((BigDecimal)var5);
            } else if(var5 instanceof Float) {
               var1.a(((Float)var5).floatValue());
            } else if(var5 instanceof Double) {
               var1.a(((Double)var5).doubleValue());
            } else if(var5 == null) {
               var1.f();
            } else {
               if(!(var5 instanceof String)) {
                  throw new he("Unrecognized value type for VALUE_NUMBER_FLOAT: " + var5.getClass().getName() + ", can not serialize");
               }

               var1.e((String)var5);
            }
            break;
         case 9:
            var1.a(true);
            break;
         case 10:
            var1.a(false);
            break;
         case 11:
            var1.f();
            break;
         case 12:
            var1.a(var3.b(var2));
            break;
         default:
            throw new RuntimeException("Internal error: should never end up through this code path");
         }
      }

   }

   public void a(hh var1) {
      this.a(hm.g, var1);
   }

   protected final void a(hm var1) {
      sq$b var2 = this.g.a(this.h, var1);
      if(var2 == null) {
         ++this.h;
      } else {
         this.g = var2;
         this.h = 1;
      }
   }

   protected final void a(hm var1, Object var2) {
      sq$b var3 = this.g.a(this.h, var1, var2);
      if(var3 == null) {
         ++this.h;
      } else {
         this.g = var3;
         this.h = 1;
      }
   }

   public void a(hp var1) {
      this.a(hm.f, var1);
      this.i.a(var1.a());
   }

   public void a(im var1) {
      this.a(hm.f, var1);
      this.i.a(var1.a());
   }

   public void a(Object var1) {
      this.a(hm.g, var1);
   }

   public final void a(String var1) {
      this.a(hm.f, var1);
      this.i.a(var1);
   }

   public void a(BigDecimal var1) {
      if(var1 == null) {
         this.f();
      } else {
         this.a(hm.j, var1);
      }
   }

   public void a(BigInteger var1) {
      if(var1 == null) {
         this.f();
      } else {
         this.a(hm.i, var1);
      }
   }

   public void a(boolean var1) {
      hm var2;
      if(var1) {
         var2 = hm.k;
      } else {
         var2 = hm.l;
      }

      this.a(var2);
   }

   public void a(char[] var1, int var2, int var3) {
      this.b(new String(var1, var2, var3));
   }

   public final void b() {
      this.a(hm.d);
      this.i = this.i.h();
   }

   public void b(int var1) {
      this.a(hm.i, Integer.valueOf(var1));
   }

   public void b(hj var1) {
      switch(null.a[var1.e().ordinal()]) {
      case 1:
         this.d();
         return;
      case 2:
         this.e();
         return;
      case 3:
         this.b();
         return;
      case 4:
         this.c();
         return;
      case 5:
         this.a(var1.g());
         return;
      case 6:
         if(var1.o()) {
            this.a(var1.l(), var1.n(), var1.m());
            return;
         }

         this.b(var1.k());
         return;
      case 7:
         switch(null.b[var1.q().ordinal()]) {
         case 1:
            this.b(var1.t());
            return;
         case 2:
            this.a(var1.v());
            return;
         default:
            this.a(var1.u());
            return;
         }
      case 8:
         switch(null.b[var1.q().ordinal()]) {
         case 3:
            this.a(var1.y());
            return;
         case 4:
            this.a(var1.w());
            return;
         default:
            this.a(var1.x());
            return;
         }
      case 9:
         this.a(true);
         return;
      case 10:
         this.a(false);
         return;
      case 11:
         this.f();
         return;
      case 12:
         this.a(var1.z());
         return;
      default:
         throw new RuntimeException("Internal error: should never end up through this code path");
      }
   }

   public void b(hp var1) {
      if(var1 == null) {
         this.f();
      } else {
         this.a(hm.h, var1);
      }
   }

   public void b(String var1) {
      if(var1 == null) {
         this.f();
      } else {
         this.a(hm.h, var1);
      }
   }

   public void b(char[] var1, int var2, int var3) {
      this.i();
   }

   public final void c() {
      this.a(hm.e);
      hx var1 = this.i.j();
      if(var1 != null) {
         this.i = var1;
      }

   }

   public void c(hj var1) {
      hm var3 = var1.e();
      hm var2 = var3;
      if(var3 == hm.f) {
         this.a(var1.g());
         var2 = var1.b();
      }

      switch(null.a[var2.ordinal()]) {
      case 1:
         this.d();

         while(var1.b() != hm.c) {
            this.c(var1);
         }

         this.e();
         return;
      case 2:
      default:
         this.b(var1);
         return;
      case 3:
         this.b();

         while(var1.b() != hm.e) {
            this.c(var1);
         }

         this.c();
      }
   }

   public void c(String var1) {
      this.i();
   }

   public void close() {
      this.e = true;
   }

   public final void d() {
      this.a(hm.b);
      this.i = this.i.i();
   }

   public void d(String var1) {
      this.i();
   }

   public final void e() {
      this.a(hm.c);
      hx var1 = this.i.j();
      if(var1 != null) {
         this.i = var1;
      }

   }

   public void e(String var1) {
      this.a(hm.j, var1);
   }

   public void f() {
      this.a(hm.m);
   }

   public void g() {
   }

   public hj h() {
      return this.a(this.c);
   }

   protected void i() {
      throw new UnsupportedOperationException("Called operation not supported for TokenBuffer");
   }

   public String toString() {
      StringBuilder var2 = new StringBuilder();
      var2.append("[TokenBuffer: ");
      hj var3 = this.h();
      int var1 = 0;

      while(true) {
         hm var4;
         try {
            var4 = var3.b();
         } catch (IOException var5) {
            throw new IllegalStateException(var5);
         }

         if(var4 == null) {
            if(var1 >= 100) {
               var2.append(" ... (truncated ").append(var1 - 100).append(" entries)");
            }

            var2.append(']');
            return var2.toString();
         }

         if(var1 < 100) {
            if(var1 > 0) {
               var2.append(", ");
            }

            var2.append(var4.toString());
         }

         ++var1;
      }
   }
}
