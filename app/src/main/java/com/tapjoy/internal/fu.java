package com.tapjoy.internal;

import android.os.SystemClock;
import com.tapjoy.internal.ft;
import com.tapjoy.internal.fy;
import com.tapjoy.internal.gk$c;
import com.tapjoy.internal.gk$c$a;
import com.tapjoy.internal.gk$f;
import com.tapjoy.internal.gk$f$a;
import com.tapjoy.internal.gk$i;
import com.tapjoy.internal.gk$j;
import com.tapjoy.internal.gk$n;
import com.tapjoy.internal.gk$r;
import com.tapjoy.internal.gk$r$a;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public final class fu {
   final fy a;
   final ft b;
   long c;
   private int d = 1;
   private final gk$f$a e = gk$f.k();

   fu(fy var1, ft var2) {
      this.a = var1;
      this.b = var2;
   }

   final gk$c$a a(gk$i var1, String var2) {
      gk$n var3 = this.a.b();
      gk$c$a var4 = gk$c.U().b(fy.a).a(var1).a(var2);
      if(com.tapjoy.internal.z.c()) {
         var4.a(com.tapjoy.internal.z.b()).b(System.currentTimeMillis());
      } else {
         var4.a(System.currentTimeMillis()).c(SystemClock.elapsedRealtime());
      }

      var4.a(var3.f()).a(var3.h()).a(var3.j());
      return var4;
   }

   final void a(gk$c$a param1) {
      // $FF: Couldn't be decompiled
   }

   public final void a(String var1, String var2, double var3, String var5) {
      this.a.a(var2, var3);
      gk$c$a var6 = this.a(gk$i.a, "purchase");
      gk$r$a var7 = gk$r.C().a(var1);
      if(var2 != null) {
         var7.b(var2);
      }

      var7.a(var3);
      if(var5 != null) {
         var7.c(var5);
      }

      var6.a(var7);
      this.a(var6);
      this.a.a(var6.h(), var3);
   }

   final void a(String var1, String var2, String var3, String var4, Map var5) {
      gk$c$a var7 = this.a(gk$i.c, var2);
      if(var1 != null) {
         var7.d(var1);
      }

      if(var3 != null) {
         var7.e(var3);
      }

      if(var4 != null) {
         var7.f(var4);
      }

      if(var5 != null) {
         Iterator var6 = var5.entrySet().iterator();

         while(var6.hasNext()) {
            Entry var8 = (Entry)var6.next();
            var7.a(gk$j.i().a((String)var8.getKey()).a(((Long)var8.getValue()).longValue()));
         }
      }

      this.a(var7);
   }
}
