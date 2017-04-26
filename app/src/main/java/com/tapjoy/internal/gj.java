package com.tapjoy.internal;

import com.tapjoy.internal.fy;
import com.tapjoy.internal.gh;
import com.tapjoy.internal.gk$a;
import com.tapjoy.internal.gk$c;
import com.tapjoy.internal.gk$d;
import com.tapjoy.internal.gk$f;
import com.tapjoy.internal.gk$i;
import com.tapjoy.internal.gk$j;
import com.tapjoy.internal.gk$l;
import com.tapjoy.internal.gk$p;
import com.tapjoy.internal.gk$r;
import com.tapjoy.internal.gk$t;
import com.tapjoy.internal.gk$x;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public final class gj {
   public static String a(gk$a var0) {
      com.tapjoy.internal.bn var1 = (new com.tapjoy.internal.bn()).c();
      if(var0.e()) {
         var1.a("pkg_ver").b(var0.f());
      }

      if(var0.g()) {
         var1.a("pkg_rev").a((long)var0.h());
      }

      if(var0.i()) {
         var1.a("data_ver").b(var0.j());
      }

      if(var0.k()) {
         var1.a("installer").b(var0.l());
      }

      if(var0.m()) {
         var1.a("store").b(var0.n());
      }

      return var1.d().toString();
   }

   private static String a(gk$c var0, boolean var1, boolean var2, boolean var3) {
      com.tapjoy.internal.bn var4 = (new com.tapjoy.internal.bn()).c().a("type").b(a(var0.f())).a("name").b(var0.h());
      var4.a("time");
      if(var0.k()) {
         var4.a(var0.j());
         var4.a("systime").a(var0.l());
      } else if(com.tapjoy.internal.z.c() && var0.m() && var0.o() && fy.a.equals(var0.n())) {
         var4.a(com.tapjoy.internal.z.a(var0.p()));
         var4.a("systime").a(var0.j());
      } else {
         var4.a(var0.j());
      }

      if(var0.q()) {
         var4.a("duration").a(var0.r());
      }

      if(!var1 && var0.s()) {
         var4.a("info").a((com.tapjoy.internal.br)(new com.tapjoy.internal.bs(a(var0.t()))));
      }

      if(!var2 && var0.u()) {
         var4.a("app").a((com.tapjoy.internal.br)(new com.tapjoy.internal.bs(a(var0.v()))));
      }

      if(!var3 && var0.w()) {
         var4.a("user").a((com.tapjoy.internal.br)(new com.tapjoy.internal.bs(a(var0.x(), var0))));
      }

      if(var0.A()) {
         var4.a("event_seq").a((long)var0.B());
      }

      com.tapjoy.internal.bn var5;
      com.tapjoy.internal.bn var7;
      if(var0.C()) {
         var5 = var4.a("event_prev");
         gk$f var6 = var0.D();
         var7 = (new com.tapjoy.internal.bn()).c().a("type").b(a(var6.f())).a("name").b(var6.h());
         if(var6.i()) {
            var7.a("category").b(var6.j());
         }

         var5.a((com.tapjoy.internal.br)(new com.tapjoy.internal.bs(var7.d().toString())));
      }

      if(var0.E()) {
         var5 = var4.a("purchase");
         gk$r var12 = var0.F();
         var7 = (new com.tapjoy.internal.bn()).c().a("product_id").b(var12.f());
         if(var12.g()) {
            var7.a("product_quantity").a((long)var12.h());
         }

         if(var12.i()) {
            var7.a("product_price").a(var12.j());
         }

         if(var12.k()) {
            var7.a("product_price_currency").b(var12.l());
         }

         if(var12.A()) {
            var7.a("currency_price").b(var12.B());
         }

         if(var12.m()) {
            var7.a("product_type").b(var12.n());
         }

         if(var12.o()) {
            var7.a("product_title").b(var12.p());
         }

         if(var12.q()) {
            var7.a("product_description").b(var12.r());
         }

         if(var12.s()) {
            var7.a("transaction_id").b(var12.t());
         }

         if(var12.u()) {
            var7.a("transaction_state").a((long)var12.v());
         }

         if(var12.w()) {
            var7.a("transaction_date").a(var12.x());
         }

         if(var12.y()) {
            var7.a("campaign_id").b(var12.z());
         }

         var5.a((com.tapjoy.internal.br)(new com.tapjoy.internal.bs(var7.d().toString())));
      }

      if(var0.G()) {
         var4.a("exception").b(var0.H());
      }

      try {
         if(var0.K()) {
            LinkedHashMap var10 = new LinkedHashMap();
            if(var0.I()) {
               com.tapjoy.internal.bt.b(var0.J()).a((Map)var10);
            }

            gk$p var13 = var0.L();
            if(var13.e()) {
               var10.put("fq7_change", var13.f());
            }

            if(var13.g()) {
               var10.put("fq30_change", var13.h());
            }

            if(var13.i()) {
               var10.put("push_id", var13.j());
            }

            var4.a("meta").a((Map)var10);
         } else if(var0.I()) {
            var4.a("meta").a((com.tapjoy.internal.br)(new com.tapjoy.internal.bs(var0.J())));
         }
      } catch (IOException var8) {
         ;
      }

      if(var0.M()) {
         var4.a("category").b(var0.N());
      }

      if(var0.O()) {
         var4.a("p1").b(var0.P());
      }

      if(var0.Q()) {
         var4.a("p2").b(var0.R());
      }

      if(var0.T() > 0) {
         var4.a("values").c();
         Iterator var9 = var0.S().iterator();

         while(var9.hasNext()) {
            gk$j var11 = (gk$j)var9.next();
            var4.a(var11.f()).a(var11.h());
         }

         var4.d();
      }

      return var4.d().toString();
   }

   public static String a(gk$d var0) {
      gk$c var6 = null;
      com.tapjoy.internal.bn var7 = (new com.tapjoy.internal.bn()).a();
      Iterator var8 = var0.e().iterator();
      gk$a var5 = null;
      gk$l var4 = null;

      boolean var1;
      boolean var2;
      boolean var3;
      for(gk$x var9 = var6; var8.hasNext(); var7.a((com.tapjoy.internal.br)(new com.tapjoy.internal.bs(a(var6, var1, var2, var3))))) {
         var6 = (gk$c)var8.next();
         if(var4 == null || var6.s() && !var4.equals(var6.t())) {
            var4 = var6.t();
            var1 = false;
         } else {
            var1 = true;
         }

         if(var5 == null || var6.u() && !var5.equals(var6.v())) {
            var5 = var6.v();
            var2 = false;
         } else {
            var2 = true;
         }

         if(var9 == null || var6.w() && !var9.equals(var6.x())) {
            var9 = var6.x();
            var3 = false;
         } else {
            var3 = true;
         }
      }

      return var7.b().toString();
   }

   private static String a(gk$i var0) {
      switch(null.a[var0.ordinal()]) {
      case 1:
         return "app";
      case 2:
         return "campaign";
      case 3:
         return "custom";
      default:
         throw new RuntimeException();
      }
   }

   public static String a(gk$l var0) {
      com.tapjoy.internal.bn var1 = (new com.tapjoy.internal.bn()).c().a("sdk").b(var0.F()).a("os_name").b(var0.n()).a("os_ver").b(var0.p()).a("device_id").b(var0.h()).a("device_maker").b(var0.j()).a("device_model").b(var0.l()).a("pkg_id").b(var0.B()).a("pkg_sign").b(var0.D()).a("display_d").a((long)var0.r()).a("display_w").a((long)var0.t()).a("display_h").a((long)var0.v()).a("locale").b(var0.x()).a("timezone").b(var0.z());
      if(var0.e()) {
         var1.a("mac").b(var0.f());
      }

      if(var0.G()) {
         var1.a("country_sim").b(var0.H());
      }

      if(var0.I()) {
         var1.a("country_net").b(var0.J());
      }

      if(var0.K()) {
         var1.a("imei").b(var0.L());
      }

      return var1.d().toString();
   }

   public static String a(gk$x var0) {
      return a(var0, (gk$c)null);
   }

   private static String a(gk$x var0, gk$c var1) {
      com.tapjoy.internal.bn var2 = (new com.tapjoy.internal.bn()).c();
      if(var0.e()) {
         var2.a("installed").a(var0.f());
      }

      if(var0.g()) {
         var2.a("referrer").b(var0.h());
      }

      if(var0.G()) {
         var2.a("idfa").b(var0.H());
         if(var0.I() && var0.J()) {
            var2.a("idfa_optout").a(1L);
         }
      } else if(var1 != null && var1.m() && fy.a.equals(var1.n())) {
         String var5 = gh.b();
         if(var5 != null) {
            var2.a("idfa").b(var5);
            if(gh.c()) {
               var2.a("idfa_optout").a(1L);
            }
         }
      }

      if(var0.i()) {
         var2.a("fq7").a((long)Math.max(var0.j(), 1));
      }

      if(var0.k()) {
         var2.a("fq30").a((long)Math.max(var0.l(), 1));
      }

      if(var0.n() > 0) {
         ArrayList var6 = new ArrayList(var0.n());
         Iterator var3 = var0.m().iterator();

         while(var3.hasNext()) {
            gk$t var4 = (gk$t)var3.next();
            if(var4.i()) {
               var6.add(var4.f());
            }
         }

         if(!var6.isEmpty()) {
            var2.a("push").a();
            Iterator var7 = var6.iterator();

            while(var7.hasNext()) {
               var2.b((String)var7.next());
            }

            var2.b();
         }
      }

      var2.a("session").c();
      if(var0.o()) {
         var2.a("total_count").a((long)var0.p());
      }

      if(var0.q()) {
         var2.a("total_length").a(var0.r());
      }

      if(var0.s()) {
         var2.a("last_at").a(var0.t());
      }

      if(var0.u()) {
         var2.a("last_length").a(var0.v());
      }

      var2.d();
      var2.a("purchase").c();
      if(var0.w()) {
         var2.a("currency").b(var0.x());
      }

      if(var0.y()) {
         var2.a("total_count").a((long)var0.z());
      }

      if(var0.A()) {
         var2.a("total_price").a(var0.B());
      }

      if(var0.C()) {
         var2.a("last_at").a(var0.D());
      }

      if(var0.E()) {
         var2.a("last_price").a(var0.F());
      }

      var2.d();
      if(var0.K()) {
         var2.a("user_id").b(var0.L());
      }

      if(var0.M()) {
         var2.a("user_level").a((long)var0.N());
      }

      if(var0.O()) {
         var2.a("friend_count").a((long)var0.P());
      }

      if(var0.Q()) {
         var2.a("uv1").b(var0.R());
      }

      if(var0.S()) {
         var2.a("uv2").b(var0.T());
      }

      if(var0.U()) {
         var2.a("uv3").b(var0.V());
      }

      if(var0.W()) {
         var2.a("uv4").b(var0.X());
      }

      if(var0.Y()) {
         var2.a("uv5").b(var0.Z());
      }

      return var2.d().toString();
   }
}
