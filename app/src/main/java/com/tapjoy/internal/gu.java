package com.tapjoy.internal;

import com.tapjoy.internal.gj;
import com.tapjoy.internal.gk$a;
import com.tapjoy.internal.gk$l;
import com.tapjoy.internal.gk$n;
import com.tapjoy.internal.gk$x;
import com.tapjoy.internal.gr;
import java.util.Map;

public final class gu extends gr {
   private final gk$l c;
   private final gk$a d;
   private final gk$x e;
   private final String f;

   private gu(gk$l var1, gk$a var2, gk$x var3, String var4) {
      this.c = var1;
      this.d = var2;
      this.e = var3;
      this.f = var4;
   }

   public gu(gk$n var1, String var2) {
      this(var1.f(), var1.h(), var1.j(), var2);
   }

   public final String c() {
      return "api/v1/tokens";
   }

   public final Map e() {
      Map var2 = super.e();
      var2.put("info", new com.tapjoy.internal.bs(gj.a(this.c)));
      var2.put("app", new com.tapjoy.internal.bs(gj.a(this.d)));
      var2.put("user", new com.tapjoy.internal.bs(gj.a(this.e)));
      String var3 = this.f;
      boolean var1;
      if(var3 != null && var3.length() != 0) {
         var1 = false;
      } else {
         var1 = true;
      }

      if(!var1) {
         var2.put("push_token", this.f);
      }

      return var2;
   }
}
