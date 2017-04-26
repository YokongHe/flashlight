package com.millennialmedia.a.a;

import java.io.IOException;
import java.io.StringWriter;

public abstract class j {
   public Number a() {
      throw new UnsupportedOperationException(this.getClass().getSimpleName());
   }

   public String b() {
      throw new UnsupportedOperationException(this.getClass().getSimpleName());
   }

   public double c() {
      throw new UnsupportedOperationException(this.getClass().getSimpleName());
   }

   public long d() {
      throw new UnsupportedOperationException(this.getClass().getSimpleName());
   }

   public int e() {
      throw new UnsupportedOperationException(this.getClass().getSimpleName());
   }

   public boolean f() {
      throw new UnsupportedOperationException(this.getClass().getSimpleName());
   }

   public final boolean g() {
      return this instanceof h;
   }

   public final boolean h() {
      return this instanceof com.millennialmedia.a.a.m;
   }

   public final boolean i() {
      return this instanceof com.millennialmedia.a.a.o;
   }

   public final boolean j() {
      return this instanceof com.millennialmedia.a.a.l;
   }

   public final com.millennialmedia.a.a.m k() {
      if(this instanceof com.millennialmedia.a.a.m) {
         return (com.millennialmedia.a.a.m)this;
      } else {
         throw new IllegalStateException("Not a JSON Object: " + this);
      }
   }

   public final h l() {
      if(this instanceof h) {
         return (h)this;
      } else {
         throw new IllegalStateException("This is not a JSON Array.");
      }
   }

   public final com.millennialmedia.a.a.o m() {
      if(this instanceof com.millennialmedia.a.a.o) {
         return (com.millennialmedia.a.a.o)this;
      } else {
         throw new IllegalStateException("This is not a JSON Primitive.");
      }
   }

   public String toString() {
      try {
         StringWriter var1 = new StringWriter();
         d.c var2 = new d.c(var1);
         var2.b(true);
         b.s.a(this, var2);
         String var4 = var1.toString();
         return var4;
      } catch (IOException var3) {
         throw new AssertionError(var3);
      }
   }
}
