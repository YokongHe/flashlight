package com.ihs.app.alerts.impl;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import com.ihs.app.alerts.impl.AlertActivity;
import com.ihs.app.framework.HSApplication;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

abstract class c implements com.ihs.app.alerts.b {
   String a;
   boolean b = false;
   protected Map c;
   protected Map d;
   private boolean e;

   c(String var1) {
      this.a = var1;
   }

   void a(Map var1) {
      this.c = var1;
      this.d = com.ihs.a.e.g.e(this.c, new String[]{"Alert"});
   }

   final void a(boolean var1) {
      this.e = var1;
   }

   public void b() {
      Activity var1 = com.ihs.app.framework.a.b.a().d();
      if(!this.b && var1 != null) {
         AlertDialog var2 = (new com.ihs.app.alerts.impl.a(var1, false)).a(this.a, 1, (Bundle)null);
         ((com.ihs.app.framework.activity.a)var1).a(var2);
      } else {
         Intent var3 = new Intent(HSApplication.a(), AlertActivity.class);
         var3.setFlags(268435456);
         var3.putExtra("AlertName", this.a);
         HSApplication.a().startActivity(var3);
      }
   }

   public boolean c() {
      return this.e;
   }

   boolean d() {
      return this.c == null || this.c.isEmpty();
   }

   final Map e() {
      String var1 = Locale.getDefault().getCountry();
      Map var2 = com.ihs.a.e.g.e(this.c, new String[]{"Conditions"});
      if(var2 == null) {
         return null;
      } else {
         List var3 = com.ihs.a.e.g.d(var2, new String[]{"Regional"});
         if(var3 != null) {
            Iterator var6 = var3.iterator();

            while(var6.hasNext()) {
               Object var4 = var6.next();
               if(var4 instanceof Map) {
                  Map var7 = (Map)var4;
                  List var5 = com.ihs.a.e.g.d(var7, new String[]{"Regions"});
                  if(var5 != null && var5.contains(var1)) {
                     return var7;
                  }
               }
            }
         }

         return com.ihs.a.e.g.e(var2, new String[]{"Default"});
      }
   }
}
