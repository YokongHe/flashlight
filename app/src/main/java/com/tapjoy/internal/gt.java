package com.tapjoy.internal;

import com.tapjoy.internal.gj;
import com.tapjoy.internal.gk$c;
import com.tapjoy.internal.gk$d;
import com.tapjoy.internal.gk$d$a;
import com.tapjoy.internal.gk$i;
import com.tapjoy.internal.gr;
import java.util.Map;

public final class gt extends gr {
   public final gk$d$a c = gk$d.f();
   private gk$i d = null;

   public final boolean a(gk$c var1) {
      if(this.d == null) {
         this.d = var1.f();
      } else if(var1.f() != this.d) {
         return false;
      }

      this.c.a(var1);
      return true;
   }

   public final String c() {
      return "api/v1/cevs";
   }

   public final Map e() {
      Map var1 = super.e();
      var1.put("events", new com.tapjoy.internal.bs(gj.a(this.c.e())));
      return var1;
   }
}
