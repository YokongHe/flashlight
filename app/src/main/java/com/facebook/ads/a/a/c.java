package com.facebook.ads.a.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.util.Log;
import com.facebook.ads.a.b$a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class c extends com.facebook.ads.a.a.a {
   private static final String a = com.facebook.ads.a.a.c.class.getSimpleName();
   private final Context b;
   private final Uri c;

   public c(Context var1, Uri var2) {
      this.b = var1;
      this.c = var2;
   }

   private Intent a(com.facebook.ads.a.u var1) {
      Intent var2 = new Intent("android.intent.action.VIEW");
      var2.addFlags(268435456);
      if(!com.facebook.ads.a.ag.a(var1.a()) && !com.facebook.ads.a.ag.a(var1.b())) {
         var2.setComponent(new ComponentName(var1.a(), var1.b()));
      }

      if(!com.facebook.ads.a.ag.a(var1.c())) {
         var2.setData(Uri.parse(var1.c()));
      }

      return var2;
   }

   private Intent b(com.facebook.ads.a.u var1) {
      if(com.facebook.ads.a.ag.a(var1.a())) {
         return null;
      } else if(!com.facebook.ads.a.h.a(this.b, var1.a())) {
         return null;
      } else {
         String var2 = var1.c();
         if(!com.facebook.ads.a.ag.a(var2) && (var2.startsWith("tel:") || var2.startsWith("telprompt:"))) {
            return new Intent("android.intent.action.CALL", Uri.parse(var2));
         } else {
            PackageManager var3 = this.b.getPackageManager();
            if(com.facebook.ads.a.ag.a(var1.b()) && com.facebook.ads.a.ag.a(var2)) {
               return var3.getLaunchIntentForPackage(var1.a());
            } else {
               Intent var6 = this.a(var1);
               List var7 = var3.queryIntentActivities(var6, 65536);
               if(var6.getComponent() == null) {
                  Iterator var4 = var7.iterator();

                  while(var4.hasNext()) {
                     ResolveInfo var5 = (ResolveInfo)var4.next();
                     if(var5.activityInfo.packageName.equals(var1.a())) {
                        var6.setComponent(new ComponentName(var5.activityInfo.packageName, var5.activityInfo.name));
                        break;
                     }
                  }
               }

               return !var7.isEmpty() && var6.getComponent() != null?var6:null;
            }
         }
      }
   }

   private List e() {
      // $FF: Couldn't be decompiled
   }

   public b$a a() {
      return b$a.a;
   }

   public void a(Map var1) {
      this.a(this.b, this.c);
      List var4 = this.c();
      if(var4 != null) {
         Iterator var5 = var4.iterator();

         while(var5.hasNext()) {
            Intent var2 = (Intent)var5.next();

            try {
               this.b.startActivity(var2);
               return;
            } catch (Exception var3) {
               Log.d(a, "Failed to open app intent, falling back", var3);
            }
         }
      }

      this.d();
   }

   protected Uri b() {
      String var1 = this.c.getQueryParameter("store_url");
      return !com.facebook.ads.a.ag.a(var1)?Uri.parse(var1):Uri.parse(String.format("market://details?id=%s", new Object[]{this.c.getQueryParameter("store_id")}));
   }

   protected List c() {
      List var2 = this.e();
      ArrayList var1 = new ArrayList();
      if(var2 != null) {
         Iterator var4 = var2.iterator();

         while(var4.hasNext()) {
            Intent var3 = this.b((com.facebook.ads.a.u)var4.next());
            if(var3 != null) {
               var1.add(var3);
            }
         }
      }

      return var1;
   }

   public void d() {
      Intent var1 = new Intent("android.intent.action.VIEW", this.b());
      var1.addFlags(268435456);

      try {
         this.b.startActivity(var1);
      } catch (Exception var4) {
         Log.d(a, "Failed to open market url: " + this.c.toString(), var4);
         String var5 = this.c.getQueryParameter("store_url_web_fallback");
         if(var5 != null && var5.length() > 0) {
            Intent var2 = new Intent("android.intent.action.VIEW", Uri.parse(var5));
            var2.addFlags(268435456);

            try {
               this.b.startActivity(var2);
               return;
            } catch (Exception var3) {
               Log.d(a, "Failed to open fallback url: " + var5, var3);
               return;
            }
         }
      }

   }
}
