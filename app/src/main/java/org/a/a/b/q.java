package org.a.a.b;

import java.util.LinkedHashMap;
import java.util.Map;

public final class q implements d {
   // $FF: synthetic field
   final k a;

   public q(k var1) {
      this.a = var1;
   }

   public final Object a(org.a.a.g.d var1) {
      if(var1.h()) {
         k var2 = this.a;
         return new LinkedHashMap();
      } else {
         return this.a.b((org.a.a.g.c)var1);
      }
   }

   public final void a(org.a.a.g.d var1, Object var2) {
      if(var1.h()) {
         this.a.a((org.a.a.g.c)var1, (Map)var2);
      } else {
         throw new org.a.a.c.c("Unexpected recursive mapping structure. Node: " + var1);
      }
   }
}
