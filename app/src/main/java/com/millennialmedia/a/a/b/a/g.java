package com.millennialmedia.a.a.b.a;

import java.lang.reflect.Type;
import java.util.Map;

public final class g implements com.millennialmedia.a.a.t {
   private final com.millennialmedia.a.a.b.f a;
   private final boolean b;

   public g(com.millennialmedia.a.a.b.f var1, boolean var2) {
      this.a = var1;
      this.b = var2;
   }

   // $FF: synthetic method
   static boolean a(g var0) {
      return var0.b;
   }

   public final com.millennialmedia.a.a.s a(com.millennialmedia.a.a.e var1, com.millennialmedia.a.a.c.a var2) {
      Type var3 = var2.b();
      if(!Map.class.isAssignableFrom(var2.a())) {
         return null;
      } else {
         Type[] var4 = com.millennialmedia.a.a.b.b.b(var3, com.millennialmedia.a.a.b.b.b(var3));
         var3 = var4[0];
         com.millennialmedia.a.a.s var7;
         if(var3 != Boolean.TYPE && var3 != Boolean.class) {
            var7 = var1.a(com.millennialmedia.a.a.c.a.a(var3));
         } else {
            var7 = com.millennialmedia.a.a.b.a.p.f;
         }

         com.millennialmedia.a.a.s var5 = var1.a(com.millennialmedia.a.a.c.a.a(var4[1]));
         com.millennialmedia.a.a.b.q var6 = this.a.a(var2);
         return new com.millennialmedia.a.a.b.a.h(this, var1, var4[0], var7, var4[1], var5, var6);
      }
   }
}
