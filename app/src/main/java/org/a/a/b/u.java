package org.a.a.b;

import java.util.Collection;
import java.util.List;

public final class u implements d {
   // $FF: synthetic field
   final k a;

   public u(k var1) {
      this.a = var1;
   }

   public final Object a(org.a.a.g.d var1) {
      org.a.a.g.h var2 = (org.a.a.g.h)var1;
      if(var1.h()) {
         k var3 = this.a;
         return k.a(var2.b().size());
      } else {
         return this.a.a(var2);
      }
   }

   public final void a(org.a.a.g.d var1, Object var2) {
      if(var1.h()) {
         this.a.a((org.a.a.g.h)((org.a.a.g.h)var1), (Collection)((List)var2));
      } else {
         throw new org.a.a.c.c("Unexpected recursive sequence structure. Node: " + var1);
      }
   }
}
