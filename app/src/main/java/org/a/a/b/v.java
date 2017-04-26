package org.a.a.b;

import java.util.LinkedHashSet;
import java.util.Set;

public final class v implements d {
   // $FF: synthetic field
   final k a;

   public v(k var1) {
      this.a = var1;
   }

   public final Object a(org.a.a.g.d var1) {
      if(var1.h()) {
         k var2 = this.a;
         return new LinkedHashSet();
      } else {
         return this.a.a((org.a.a.g.c)var1);
      }
   }

   public final void a(org.a.a.g.d var1, Object var2) {
      if(var1.h()) {
         this.a.a((org.a.a.g.c)var1, (Set)var2);
      } else {
         throw new org.a.a.c.c("Unexpected recursive set structure. Node: " + var1);
      }
   }
}
