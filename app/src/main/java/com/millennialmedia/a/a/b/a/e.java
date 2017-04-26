package com.millennialmedia.a.a.b.a;

import java.io.Reader;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public final class e extends com.millennialmedia.a.a.d.a {
   private static final Reader a = new Reader() {
      public final void close() {
         throw new AssertionError();
      }

      public final int read(char[] var1, int var2, int var3) {
         throw new AssertionError();
      }
   };
   private static final Object b = new Object();
   private final List c;

   private void a(com.millennialmedia.a.a.d.b var1) {
      if(this.f() != var1) {
         throw new IllegalStateException("Expected " + var1 + " but was " + this.f());
      }
   }

   private Object q() {
      return this.c.get(this.c.size() - 1);
   }

   private Object r() {
      return this.c.remove(this.c.size() - 1);
   }

   public final void a() {
      this.a(com.millennialmedia.a.a.d.b.a);
      com.millennialmedia.a.a.h var1 = (com.millennialmedia.a.a.h)this.q();
      this.c.add(var1.iterator());
   }

   public final void b() {
      this.a(com.millennialmedia.a.a.d.b.b);
      this.r();
      this.r();
   }

   public final void c() {
      this.a(com.millennialmedia.a.a.d.b.c);
      com.millennialmedia.a.a.m var1 = (com.millennialmedia.a.a.m)this.q();
      this.c.add(var1.n().iterator());
   }

   public final void close() {
      this.c.clear();
      this.c.add(b);
   }

   public final void d() {
      this.a(com.millennialmedia.a.a.d.b.d);
      this.r();
      this.r();
   }

   public final boolean e() {
      com.millennialmedia.a.a.d.b var1 = this.f();
      return var1 != com.millennialmedia.a.a.d.b.d && var1 != com.millennialmedia.a.a.d.b.b;
   }

   public final com.millennialmedia.a.a.d.b f() {
      while(!this.c.isEmpty()) {
         Object var2 = this.q();
         if(var2 instanceof Iterator) {
            boolean var1 = this.c.get(this.c.size() - 2) instanceof com.millennialmedia.a.a.m;
            Iterator var4 = (Iterator)var2;
            if(var4.hasNext()) {
               if(var1) {
                  return com.millennialmedia.a.a.d.b.e;
               }

               this.c.add(var4.next());
               continue;
            }

            if(var1) {
               return com.millennialmedia.a.a.d.b.d;
            }

            return com.millennialmedia.a.a.d.b.b;
         }

         if(var2 instanceof com.millennialmedia.a.a.m) {
            return com.millennialmedia.a.a.d.b.c;
         }

         if(var2 instanceof com.millennialmedia.a.a.h) {
            return com.millennialmedia.a.a.d.b.a;
         }

         if(var2 instanceof com.millennialmedia.a.a.o) {
            com.millennialmedia.a.a.o var3 = (com.millennialmedia.a.a.o)var2;
            if(var3.p()) {
               return com.millennialmedia.a.a.d.b.f;
            }

            if(var3.n()) {
               return com.millennialmedia.a.a.d.b.h;
            }

            if(var3.o()) {
               return com.millennialmedia.a.a.d.b.g;
            }

            throw new AssertionError();
         }

         if(var2 instanceof com.millennialmedia.a.a.l) {
            return com.millennialmedia.a.a.d.b.i;
         }

         if(var2 == b) {
            throw new IllegalStateException("JsonReader is closed");
         }

         throw new AssertionError();
      }

      return com.millennialmedia.a.a.d.b.j;
   }

   public final String g() {
      this.a(com.millennialmedia.a.a.d.b.e);
      Entry var1 = (Entry)((Iterator)this.q()).next();
      this.c.add(var1.getValue());
      return (String)var1.getKey();
   }

   public final String h() {
      com.millennialmedia.a.a.d.b var1 = this.f();
      if(var1 != com.millennialmedia.a.a.d.b.f && var1 != com.millennialmedia.a.a.d.b.g) {
         throw new IllegalStateException("Expected " + com.millennialmedia.a.a.d.b.f + " but was " + var1);
      } else {
         return ((com.millennialmedia.a.a.o)this.r()).b();
      }
   }

   public final boolean i() {
      this.a(com.millennialmedia.a.a.d.b.h);
      return ((com.millennialmedia.a.a.o)this.r()).f();
   }

   public final void j() {
      this.a(com.millennialmedia.a.a.d.b.i);
      this.r();
   }

   public final double k() {
      com.millennialmedia.a.a.d.b var3 = this.f();
      if(var3 != com.millennialmedia.a.a.d.b.g && var3 != com.millennialmedia.a.a.d.b.f) {
         throw new IllegalStateException("Expected " + com.millennialmedia.a.a.d.b.g + " but was " + var3);
      } else {
         double var1 = ((com.millennialmedia.a.a.o)this.q()).c();
         if(this.p() || !Double.isNaN(var1) && !Double.isInfinite(var1)) {
            this.r();
            return var1;
         } else {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + var1);
         }
      }
   }

   public final long l() {
      com.millennialmedia.a.a.d.b var3 = this.f();
      if(var3 != com.millennialmedia.a.a.d.b.g && var3 != com.millennialmedia.a.a.d.b.f) {
         throw new IllegalStateException("Expected " + com.millennialmedia.a.a.d.b.g + " but was " + var3);
      } else {
         long var1 = ((com.millennialmedia.a.a.o)this.q()).d();
         this.r();
         return var1;
      }
   }

   public final int m() {
      com.millennialmedia.a.a.d.b var2 = this.f();
      if(var2 != com.millennialmedia.a.a.d.b.g && var2 != com.millennialmedia.a.a.d.b.f) {
         throw new IllegalStateException("Expected " + com.millennialmedia.a.a.d.b.g + " but was " + var2);
      } else {
         int var1 = ((com.millennialmedia.a.a.o)this.q()).e();
         this.r();
         return var1;
      }
   }

   public final void n() {
      if(this.f() == com.millennialmedia.a.a.d.b.e) {
         this.g();
      } else {
         this.r();
      }
   }

   public final void o() {
      this.a(com.millennialmedia.a.a.d.b.e);
      Entry var1 = (Entry)((Iterator)this.q()).next();
      this.c.add(var1.getValue());
      this.c.add(new com.millennialmedia.a.a.o((String)var1.getKey()));
   }

   public final String toString() {
      return this.getClass().getSimpleName();
   }
}
