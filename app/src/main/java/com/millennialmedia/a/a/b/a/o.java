package com.millennialmedia.a.a.b.a;

import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

final class o extends com.millennialmedia.a.a.s {
   private final com.millennialmedia.a.a.e a;
   private final com.millennialmedia.a.a.s b;
   private final Type c;

   o(com.millennialmedia.a.a.e var1, com.millennialmedia.a.a.s var2, Type var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public final Object a(com.millennialmedia.a.a.d.a var1) {
      return this.b.a(var1);
   }

   public final void a(com.millennialmedia.a.a.d.c var1, Object var2) {
      com.millennialmedia.a.a.s var4 = this.b;
      Type var5 = this.c;
      Object var3 = var5;
      if(var2 != null) {
         label23: {
            if(var5 != Object.class && !(var5 instanceof TypeVariable)) {
               var3 = var5;
               if(!(var5 instanceof Class)) {
                  break label23;
               }
            }

            var3 = var2.getClass();
         }
      }

      com.millennialmedia.a.a.s var6;
      if(var3 != this.c) {
         var4 = this.a.a(com.millennialmedia.a.a.c.a.a((Type)var3));
         var6 = var4;
         if(var4 instanceof k) {
            var6 = var4;
            if(!(this.b instanceof k)) {
               var6 = this.b;
            }
         }
      } else {
         var6 = var4;
      }

      var6.a(var1, var2);
   }
}
