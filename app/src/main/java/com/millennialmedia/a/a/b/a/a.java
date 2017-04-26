package com.millennialmedia.a.a.b.a;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;

public final class a extends com.millennialmedia.a.a.s {
   public static final com.millennialmedia.a.a.t a = new com.millennialmedia.a.a.t() {
      public final com.millennialmedia.a.a.s a(com.millennialmedia.a.a.e var1, com.millennialmedia.a.a.c.a var2) {
         Type var3 = var2.b();
         if(var3 instanceof GenericArrayType || var3 instanceof Class && ((Class)var3).isArray()) {
            var3 = com.millennialmedia.a.a.b.b.d(var3);
            return new a(var1, var1.a(com.millennialmedia.a.a.c.a.a(var3)), com.millennialmedia.a.a.b.b.b(var3));
         } else {
            return null;
         }
      }
   };
   private final Class b;
   private final com.millennialmedia.a.a.s c;

   public a(com.millennialmedia.a.a.e var1, com.millennialmedia.a.a.s var2, Class var3) {
      this.c = new com.millennialmedia.a.a.b.a.o(var1, var2, var3);
      this.b = var3;
   }

   public final Object a(com.millennialmedia.a.a.d.a var1) {
      if(var1.f() == com.millennialmedia.a.a.d.b.i) {
         var1.j();
         return null;
      } else {
         ArrayList var3 = new ArrayList();
         var1.a();

         while(var1.e()) {
            var3.add(this.c.a(var1));
         }

         var1.b();
         Object var4 = Array.newInstance(this.b, var3.size());

         for(int var2 = 0; var2 < var3.size(); ++var2) {
            Array.set(var4, var2, var3.get(var2));
         }

         return var4;
      }
   }

   public final void a(com.millennialmedia.a.a.d.c var1, Object var2) {
      if(var2 == null) {
         var1.f();
      } else {
         var1.b();
         int var3 = 0;

         for(int var4 = Array.getLength(var2); var3 < var4; ++var3) {
            Object var5 = Array.get(var2, var3);
            this.c.a(var1, var5);
         }

         var1.c();
      }
   }
}
