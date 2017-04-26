package com.tapjoy.internal;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

public final class bn implements com.tapjoy.internal.br {
   private final StringWriter a = new StringWriter();
   private final com.tapjoy.internal.bz b;

   public bn() {
      this.b = new com.tapjoy.internal.bz(this.a);
   }

   public static String a(Object var0) {
      return (new com.tapjoy.internal.bn()).b(var0).toString();
   }

   private com.tapjoy.internal.bn b(Object var1) {
      try {
         this.b.a(var1);
         return this;
      } catch (IOException var2) {
         throw com.tapjoy.internal.cw.a(var2);
      }
   }

   public final com.tapjoy.internal.bn a() {
      try {
         this.b.a();
         return this;
      } catch (IOException var2) {
         throw com.tapjoy.internal.cw.a(var2);
      }
   }

   public final com.tapjoy.internal.bn a(double var1) {
      try {
         this.b.a(var1);
         return this;
      } catch (IOException var4) {
         throw com.tapjoy.internal.cw.a(var4);
      }
   }

   public final com.tapjoy.internal.bn a(long var1) {
      try {
         this.b.a(var1);
         return this;
      } catch (IOException var4) {
         throw com.tapjoy.internal.cw.a(var4);
      }
   }

   public final com.tapjoy.internal.bn a(com.tapjoy.internal.br var1) {
      try {
         this.b.a(var1);
         return this;
      } catch (IOException var2) {
         throw com.tapjoy.internal.cw.a(var2);
      }
   }

   public final com.tapjoy.internal.bn a(String var1) {
      try {
         this.b.a(var1);
         return this;
      } catch (IOException var2) {
         throw com.tapjoy.internal.cw.a(var2);
      }
   }

   public final com.tapjoy.internal.bn a(Map var1) {
      try {
         this.b.a(var1);
         return this;
      } catch (IOException var2) {
         throw com.tapjoy.internal.cw.a(var2);
      }
   }

   public final void a(Writer var1) {
      try {
         this.b.e();
         var1.write(this.a.toString());
      } catch (IOException var2) {
         throw com.tapjoy.internal.cw.a(var2);
      }
   }

   public final com.tapjoy.internal.bn b() {
      try {
         this.b.b();
         return this;
      } catch (IOException var2) {
         throw com.tapjoy.internal.cw.a(var2);
      }
   }

   public final com.tapjoy.internal.bn b(String var1) {
      try {
         this.b.b(var1);
         return this;
      } catch (IOException var2) {
         throw com.tapjoy.internal.cw.a(var2);
      }
   }

   public final com.tapjoy.internal.bn c() {
      try {
         this.b.c();
         return this;
      } catch (IOException var2) {
         throw com.tapjoy.internal.cw.a(var2);
      }
   }

   public final com.tapjoy.internal.bn d() {
      try {
         this.b.d();
         return this;
      } catch (IOException var2) {
         throw com.tapjoy.internal.cw.a(var2);
      }
   }

   public final String toString() {
      try {
         this.b.e();
         String var1 = this.a.toString();
         return var1;
      } catch (IOException var2) {
         throw com.tapjoy.internal.cw.a(var2);
      }
   }
}
