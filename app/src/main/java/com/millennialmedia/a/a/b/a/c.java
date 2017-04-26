package com.millennialmedia.a.a.b.a;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

final class c extends com.millennialmedia.a.a.s {
   private final com.millennialmedia.a.a.s a;
   private final com.millennialmedia.a.a.b.q b;

   public c(com.millennialmedia.a.a.e var1, Type var2, com.millennialmedia.a.a.s var3, com.millennialmedia.a.a.b.q var4) {
      this.a = new com.millennialmedia.a.a.b.a.o(var1, var3, var2);
      this.b = var4;
   }

   // $FF: synthetic method
   public final Object a(com.millennialmedia.a.a.d.a var1) {
      if(var1.f() == com.millennialmedia.a.a.d.b.i) {
         var1.j();
         return null;
      } else {
         Collection var2 = (Collection)this.b.a();
         var1.a();

         while(var1.e()) {
            var2.add(this.a.a(var1));
         }

         var1.b();
         return var2;
      }
   }

   // $FF: synthetic method
   public final void a(com.millennialmedia.a.a.d.c var1, Object var2) {
      Collection var4 = (Collection)var2;
      if(var4 == null) {
         var1.f();
      } else {
         var1.b();
         Iterator var5 = var4.iterator();

         while(var5.hasNext()) {
            Object var3 = var5.next();
            this.a.a(var1, var3);
         }

         var1.c();
      }
   }
}
