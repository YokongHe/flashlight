package com.tapjoy.internal;

import android.content.Context;
import com.tapjoy.internal.fv;
import com.tapjoy.internal.ga;
import com.tapjoy.internal.gb;
import com.tapjoy.internal.gj;
import com.tapjoy.internal.gk$a;
import com.tapjoy.internal.gk$l;
import com.tapjoy.internal.gk$x;
import com.tapjoy.internal.gn;
import com.tapjoy.internal.gr;
import com.tapjoy.internal.gs$a;
import java.util.List;
import java.util.Map;

public final class gs extends gr {
   public final String c;
   public boolean d;
   private final fv e;
   private final gk$l f;
   private final gk$a g;
   private final gk$x h;
   private Context i;

   public gs(fv var1, gk$l var2, gk$a var3, gk$x var4, String var5, Context var6) {
      this.e = var1;
      this.f = var2;
      this.g = var3;
      this.h = var4;
      this.c = var5;
      this.d = false;
      this.i = var6;
   }

   // $FF: synthetic method
   protected final Object a(com.tapjoy.internal.bt var1) {
      var1.i();
      List var3 = null;
      gn var2 = null;

      while(var1.k()) {
         String var4 = var1.m();
         if("interstitial".equals(var4)) {
            var2 = (gn)var1.b(gn.m);
         } else if("enabled_placements".equals(var4)) {
            var3 = var1.d();
         } else {
            var1.t();
         }
      }

      var1.j();
      return var2 == null || !var2.a() && !var2.b()?new gs$a(new gb(), var3):new gs$a(new ga(this.e, this.c, var2, this.i), var3);
   }

   public final String c() {
      return "placement";
   }

   public final Map e() {
      Map var1 = super.e();
      var1.put("info", new com.tapjoy.internal.bs(gj.a(this.f)));
      var1.put("app", new com.tapjoy.internal.bs(gj.a(this.g)));
      var1.put("user", new com.tapjoy.internal.bs(gj.a(this.h)));
      var1.put("placement", this.c);
      return var1;
   }

   // $FF: synthetic method
   protected final Object f() {
      gs$a var1 = (gs$a)super.f();
      if(!(var1.a instanceof gb)) {
         var1.a.a();
         if(!var1.a.b()) {
            String var2 = this.c;
            var1.a = new gb();
         }
      }

      return var1;
   }
}
