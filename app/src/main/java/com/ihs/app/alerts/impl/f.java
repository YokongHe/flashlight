package com.ihs.app.alerts.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

final class f extends com.ihs.app.alerts.impl.c {
   f() {
      super("MessageAlert");
   }

   final void a(Map var1) {
      super.a(var1);
      this.d = null;
      if(var1 != null) {
         Iterator var10 = var1.entrySet().iterator();

         while(true) {
            int var11;
            Map var12;
            do {
               boolean var2;
               do {
                  Entry var6;
                  do {
                     if(!var10.hasNext()) {
                        return;
                     }

                     var6 = (Entry)var10.next();
                  } while(!(var6.getValue() instanceof Map));

                  var12 = (Map)var6.getValue();
                  if(var12 != null && var12.containsKey("ID")) {
                     String var7 = com.ihs.a.e.g.c(var12, new String[]{"ID"});
                     boolean var4 = com.ihs.app.alerts.impl.b.d().getBoolean("HSAlert_MessageAlertShown_" + var7, false);
                     boolean var5 = com.ihs.a.e.g.a(var12, false, new String[]{"AlwaysShow"});
                     if(var4 && !var5) {
                        var2 = false;
                     } else {
                        Date var13 = com.ihs.a.e.g.a(var12, new Date(0L), new String[]{"DateStart"});
                        Date var8 = com.ihs.a.e.g.a(var12, new Date(0L), new String[]{"DateEnd"});
                        Date var9 = new Date();
                        if(var9.compareTo(var13) >= 0 && var9.compareTo(var8) <= 0) {
                           var7 = Locale.getDefault().getCountry();
                           List var15 = com.ihs.a.e.g.d(var12, new String[]{"RegionFilter"});
                           if(var15 != null && !var15.isEmpty() && !var15.contains(var7)) {
                              var2 = false;
                           } else {
                              var15 = com.ihs.a.e.g.d(var12, new String[]{"RegionException"});
                              if(var15 != null && !var15.isEmpty() && var15.contains(var7)) {
                                 var2 = false;
                              } else {
                                 var2 = true;
                              }
                           }
                        } else {
                           var2 = false;
                        }
                     }
                  } else {
                     var2 = false;
                  }
               } while(!var2);

               if(this.d == null) {
                  break;
               }

               Map var14 = this.d;
               var11 = com.ihs.a.e.g.a(var14, 0, new String[]{"Priority"});
               int var3 = com.ihs.a.e.g.a(var12, 0, new String[]{"Priority"});
               if(var11 == var3) {
                  var11 = com.ihs.a.e.g.a(var14, new Date(0L), new String[]{"DateStart"}).compareTo(com.ihs.a.e.g.a(var12, new Date(0L), new String[]{"DateStart"}));
               } else {
                  var11 -= var3;
               }
            } while(var11 >= 0);

            this.d = var12;
         }
      }
   }

   public final boolean a() {
      return this.d != null;
   }

   public final void b() {
      String var1 = com.ihs.a.e.g.c(this.d, new String[]{"ID"});
      com.ihs.app.alerts.impl.b.d().edit().putBoolean("HSAlert_MessageAlertShown_" + var1, true).commit();
      com.ihs.app.a.b.a("HSMessageAlert_Showed");
      super.b();
   }
}
