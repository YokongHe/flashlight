package com.ihs.app.alerts.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

final class g extends com.ihs.app.alerts.impl.c {
   private int e;

   g() {
      super("PromoteAlert");
   }

   private Map a(List var1) {
      ArrayList var5 = new ArrayList();
      int var2 = 0;

      int var3;
      int var4;
      for(var3 = 0; var2 < var1.size(); var3 = var4) {
         Map var6 = (Map)var1.get(var2);
         var4 = var3;
         if(b(var6)) {
            var5.add(var6);
            var4 = var3 + com.ihs.a.e.g.a(var6, 0, new String[]{"Weight"});
         }

         ++var2;
      }

      if(var5.size() != 0 && var3 != 0) {
         var4 = (new Random()).nextInt(var3);
         (new StringBuilder("Weight random: ")).append(var4).toString();
         var3 = com.ihs.a.e.g.a((Map)var5.get(0), new String[]{"Weight"});

         for(var2 = 0; var2 < var5.size() - 1 && var4 >= var3; ++var2) {
            var3 += com.ihs.a.e.g.a((Map)var5.get(var2 + 1), 0, new String[]{"Weight"});
         }

         return (Map)var5.get(var2);
      } else {
         return null;
      }
   }

   private static boolean b(Map param0) {
      // $FF: Couldn't be decompiled
   }

   final void a(Map var1) {
      super.a(var1);
      this.b = false;
      List var4 = com.ihs.a.e.g.d(var1, new String[]{"Alerts"});
      Object var5;
      if(var4 == null) {
         var5 = new ArrayList();
         this.e = 0;
      } else {
         this.e = com.ihs.a.e.g.a(var1, 0, new String[]{"MinimumShowInterval"});
         var5 = var4;
      }

      this.d = this.a((List)var5);
      if(this.d != null) {
         boolean var2 = com.ihs.a.e.g.a(this.d, false, new String[]{"AppStart"});
         boolean var3 = com.ihs.a.e.g.a(this.d, false, new String[]{"AppEnd"});
         if(!var2) {
            if(!var3) {
               this.d = null;
               return;
            }

            this.b = true;
            return;
         }
      }

   }

   public final boolean a() {
      if(this.d != null) {
         long var1 = com.ihs.app.alerts.impl.b.d().getLong("HSAlert_PromoteAlertLastShownDate", 0L);
         long var3 = System.currentTimeMillis();
         (new StringBuilder("currentTime - lastShownTime : ")).append(var3 - var1).toString();
         if(var3 - var1 >= (long)(this.e * 60 * 1000)) {
            return true;
         }
      }

      return false;
   }

   public final void b() {
      if(this.d != null) {
         com.ihs.app.a.b.a("HSPromoteAlert_Showed");
         com.ihs.app.alerts.impl.b.d().edit().putLong("HSAlert_PromoteAlertLastShownDate", System.currentTimeMillis()).commit();
         super.b();
      }
   }
}
