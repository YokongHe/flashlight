package com.millennialmedia.a.a.b.a;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public final class f extends com.millennialmedia.a.a.d.c {
   private static final Writer a = new Writer() {
      public final void close() {
         throw new AssertionError();
      }

      public final void flush() {
         throw new AssertionError();
      }

      public final void write(char[] var1, int var2, int var3) {
         throw new AssertionError();
      }
   };
   private static final com.millennialmedia.a.a.o b = new com.millennialmedia.a.a.o("closed");
   private final List c = new ArrayList();
   private String d;
   private com.millennialmedia.a.a.j e;

   public f() {
      super(a);
      this.e = com.millennialmedia.a.a.l.a;
   }

   private void a(com.millennialmedia.a.a.j var1) {
      if(this.d == null) {
         if(this.c.isEmpty()) {
            this.e = var1;
         } else {
            com.millennialmedia.a.a.j var2 = this.j();
            if(var2 instanceof com.millennialmedia.a.a.h) {
               ((com.millennialmedia.a.a.h)var2).a(var1);
            } else {
               throw new IllegalStateException();
            }
         }
      } else {
         if(!var1.j() || this.i()) {
            ((com.millennialmedia.a.a.m)this.j()).a(this.d, var1);
         }

         this.d = null;
      }
   }

   private com.millennialmedia.a.a.j j() {
      return (com.millennialmedia.a.a.j)this.c.get(this.c.size() - 1);
   }

   public final com.millennialmedia.a.a.d.c a(long var1) {
      this.a((com.millennialmedia.a.a.j)(new com.millennialmedia.a.a.o(Long.valueOf(var1))));
      return this;
   }

   public final com.millennialmedia.a.a.d.c a(Number var1) {
      if(var1 == null) {
         return this.f();
      } else {
         if(!this.g()) {
            double var2 = var1.doubleValue();
            if(Double.isNaN(var2) || Double.isInfinite(var2)) {
               throw new IllegalArgumentException("JSON forbids NaN and infinities: " + var1);
            }
         }

         this.a((com.millennialmedia.a.a.j)(new com.millennialmedia.a.a.o(var1)));
         return this;
      }
   }

   public final com.millennialmedia.a.a.d.c a(String var1) {
      if(!this.c.isEmpty() && this.d == null) {
         if(this.j() instanceof com.millennialmedia.a.a.m) {
            this.d = var1;
            return this;
         } else {
            throw new IllegalStateException();
         }
      } else {
         throw new IllegalStateException();
      }
   }

   public final com.millennialmedia.a.a.d.c a(boolean var1) {
      this.a((com.millennialmedia.a.a.j)(new com.millennialmedia.a.a.o(Boolean.valueOf(var1))));
      return this;
   }

   public final com.millennialmedia.a.a.j a() {
      if(!this.c.isEmpty()) {
         throw new IllegalStateException("Expected one JSON element but was " + this.c);
      } else {
         return this.e;
      }
   }

   public final com.millennialmedia.a.a.d.c b() {
      com.millennialmedia.a.a.h var1 = new com.millennialmedia.a.a.h();
      this.a((com.millennialmedia.a.a.j)var1);
      this.c.add(var1);
      return this;
   }

   public final com.millennialmedia.a.a.d.c b(String var1) {
      if(var1 == null) {
         return this.f();
      } else {
         this.a((com.millennialmedia.a.a.j)(new com.millennialmedia.a.a.o(var1)));
         return this;
      }
   }

   public final com.millennialmedia.a.a.d.c c() {
      if(!this.c.isEmpty() && this.d == null) {
         if(this.j() instanceof com.millennialmedia.a.a.h) {
            this.c.remove(this.c.size() - 1);
            return this;
         } else {
            throw new IllegalStateException();
         }
      } else {
         throw new IllegalStateException();
      }
   }

   public final void close() {
      if(!this.c.isEmpty()) {
         throw new IOException("Incomplete document");
      } else {
         this.c.add(b);
      }
   }

   public final com.millennialmedia.a.a.d.c d() {
      com.millennialmedia.a.a.m var1 = new com.millennialmedia.a.a.m();
      this.a((com.millennialmedia.a.a.j)var1);
      this.c.add(var1);
      return this;
   }

   public final com.millennialmedia.a.a.d.c e() {
      if(!this.c.isEmpty() && this.d == null) {
         if(this.j() instanceof com.millennialmedia.a.a.m) {
            this.c.remove(this.c.size() - 1);
            return this;
         } else {
            throw new IllegalStateException();
         }
      } else {
         throw new IllegalStateException();
      }
   }

   public final com.millennialmedia.a.a.d.c f() {
      this.a((com.millennialmedia.a.a.j)com.millennialmedia.a.a.l.a);
      return this;
   }

   public final void flush() {
   }
}
