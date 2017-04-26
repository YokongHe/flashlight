package org.a.a.b;

import java.util.HashMap;
import java.util.Map;

public final class e extends org.a.a.b.k {
   private final Map f;
   private final Map g;

   public e() {
      this(Object.class);
   }

   private e(Class var1) {
      if(var1 == null) {
         throw new NullPointerException("Root class must be provided.");
      } else {
         this(new org.a.a.f(var1));
      }
   }

   private e(org.a.a.f var1) {
      super();
      if(var1 == null) {
         throw new NullPointerException("Root type must be provided.");
      } else {
         this.b.put((Object)null, new org.a.a.b.i(this));
         if(!Object.class.equals(var1.b())) {
            this.d = new org.a.a.g.i(var1.b());
         }

         this.f = new HashMap();
         this.g = new HashMap();
         this.a.put(org.a.a.g.e.a, new org.a.a.b.g(this));
         this.a.put(org.a.a.g.e.c, new org.a.a.b.f(this));
         this.a.put(org.a.a.g.e.b, new org.a.a.b.h(this));
         if(var1 == null) {
            throw new NullPointerException("TypeDescription is required.");
         } else {
            org.a.a.g.i var2 = var1.a();
            this.f.put(var2, var1.b());
            org.a.a.f var10000 = (org.a.a.f)this.g.put(var1.b(), var1);
         }
      }
   }

   // $FF: synthetic method
   static Map a(e var0) {
      return var0.g;
   }

   protected final Class b(org.a.a.g.d var1) {
      Class var3 = (Class)this.f.get(var1.d());
      Class var2 = var3;
      if(var3 == null) {
         String var5 = var1.d().a();

         try {
            var2 = Class.forName(var5);
         } catch (ClassNotFoundException var4) {
            throw new org.a.a.c.c("Class not found: " + var5);
         }

         this.f.put(var1.d(), var2);
      }

      return var2;
   }
}
