package com.millennialmedia.a.a.b.a;

import java.lang.reflect.Type;
import java.util.Collection;

public final class b implements com.millennialmedia.a.a.t {
   private final com.millennialmedia.a.a.b.f a;

   public b(com.millennialmedia.a.a.b.f var1) {
      this.a = var1;
   }

   public final com.millennialmedia.a.a.s a(com.millennialmedia.a.a.e var1, com.millennialmedia.a.a.c.a var2) {
      Type var3 = var2.b();
      Class var4 = var2.a();
      if(!Collection.class.isAssignableFrom(var4)) {
         return null;
      } else {
         var3 = com.millennialmedia.a.a.b.b.a(var3, var4);
         return new com.millennialmedia.a.a.b.a.c(var1, var3, var1.a(com.millennialmedia.a.a.c.a.a(var3)), this.a.a(var2));
      }
   }
}
