package com.millennialmedia.a.a.b.a;

import java.util.Map;

final class q extends com.millennialmedia.a.a.s {
   private final Map a;
   private final Map b;

   public q(Class param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: synthetic method
   public final Object a(com.millennialmedia.a.a.d.a var1) {
      if(var1.f() == com.millennialmedia.a.a.d.b.i) {
         var1.j();
         return null;
      } else {
         return (Enum)this.a.get(var1.h());
      }
   }

   // $FF: synthetic method
   public final void a(com.millennialmedia.a.a.d.c var1, Object var2) {
      Enum var3 = (Enum)var2;
      String var4;
      if(var3 == null) {
         var4 = null;
      } else {
         var4 = (String)this.b.get(var3);
      }

      var1.b(var4);
   }
}
