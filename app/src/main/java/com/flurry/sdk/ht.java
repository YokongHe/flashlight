package com.flurry.sdk;

import com.flurry.sdk.he;
import com.flurry.sdk.hf;
import com.flurry.sdk.hf$a;
import com.flurry.sdk.hh;
import com.flurry.sdk.hn;
import com.flurry.sdk.ho;
import com.flurry.sdk.hx;
import com.flurry.sdk.sl;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public abstract class ht extends hf {
   protected hn b;
   protected int c;
   protected boolean d;
   protected hx e;
   protected boolean f;

   protected ht(int var1, hn var2) {
      this.c = var1;
      this.e = hx.g();
      this.b = var2;
      this.d = this.a(hf$a.e);
   }

   public hf a() {
      return this.a((ho)(new sl()));
   }

   public void a(hh var1) {
      if(var1 == null) {
         this.f();
      } else if(this.b == null) {
         throw new IllegalStateException("No ObjectCodec defined for the generator, can not serialize JsonNode-based trees");
      } else {
         this.b.a(this, (hh)var1);
      }
   }

   public void a(Object var1) {
      if(var1 == null) {
         this.f();
      } else if(this.b != null) {
         this.b.a(this, (Object)var1);
      } else {
         this.b(var1);
      }
   }

   public final boolean a(hf$a var1) {
      return (this.c & var1.c()) != 0;
   }

   public void b() {
      this.h("start an array");
      this.e = this.e.h();
      if(this.a != null) {
         this.a.e(this);
      } else {
         this.i();
      }
   }

   protected void b(Object var1) {
      if(var1 == null) {
         this.f();
      } else if(var1 instanceof String) {
         this.b((String)var1);
      } else {
         if(var1 instanceof Number) {
            Number var2 = (Number)var1;
            if(var2 instanceof Integer) {
               this.b(var2.intValue());
               return;
            }

            if(var2 instanceof Long) {
               this.a(var2.longValue());
               return;
            }

            if(var2 instanceof Double) {
               this.a(var2.doubleValue());
               return;
            }

            if(var2 instanceof Float) {
               this.a(var2.floatValue());
               return;
            }

            if(var2 instanceof Short) {
               this.b(var2.shortValue());
               return;
            }

            if(var2 instanceof Byte) {
               this.b(var2.byteValue());
               return;
            }

            if(var2 instanceof BigInteger) {
               this.a((BigInteger)((BigInteger)var2));
               return;
            }

            if(var2 instanceof BigDecimal) {
               this.a((BigDecimal)((BigDecimal)var2));
               return;
            }

            if(var2 instanceof AtomicInteger) {
               this.b(((AtomicInteger)var2).get());
               return;
            }

            if(var2 instanceof AtomicLong) {
               this.a(((AtomicLong)var2).get());
               return;
            }
         } else {
            if(var1 instanceof byte[]) {
               this.a((byte[])((byte[])var1));
               return;
            }

            if(var1 instanceof Boolean) {
               this.a(((Boolean)var1).booleanValue());
               return;
            }

            if(var1 instanceof AtomicBoolean) {
               this.a(((AtomicBoolean)var1).get());
               return;
            }
         }

         throw new IllegalStateException("No ObjectCodec defined for the generator, can only serialize simple wrapper types (type passed " + var1.getClass().getName() + ")");
      }
   }

   public void c() {
      if(!this.e.a()) {
         this.i("Current context not an ARRAY but " + this.e.d());
      }

      if(this.a != null) {
         this.a.b(this, this.e.e());
      } else {
         this.j();
      }

      this.e = this.e.j();
   }

   public void close() {
      this.f = true;
   }

   public void d() {
      this.h("start an object");
      this.e = this.e.i();
      if(this.a != null) {
         this.a.b(this);
      } else {
         this.k();
      }
   }

   public void d(String var1) {
      this.h("write raw value");
      this.c(var1);
   }

   public void e() {
      if(!this.e.c()) {
         this.i("Current context not an object but " + this.e.d());
      }

      this.e = this.e.j();
      if(this.a != null) {
         this.a.a(this, this.e.e());
      } else {
         this.l();
      }
   }

   public final hx h() {
      return this.e;
   }

   protected abstract void h(String var1);

   @Deprecated
   protected void i() {
   }

   protected void i(String var1) {
      throw new he(var1);
   }

   @Deprecated
   protected void j() {
   }

   @Deprecated
   protected void k() {
   }

   @Deprecated
   protected void l() {
   }

   protected void m() {
      throw new RuntimeException("Internal error: should never end up through this code path");
   }
}
