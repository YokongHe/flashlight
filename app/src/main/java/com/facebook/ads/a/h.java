package com.facebook.ads.a;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;

public class h {
   public static Collection a(JSONArray var0) {
      if(var0 != null && var0.length() != 0) {
         HashSet var2 = new HashSet();

         for(int var1 = 0; var1 < var0.length(); ++var1) {
            var2.add(var0.optString(var1));
         }

         return var2;
      } else {
         return null;
      }
   }

   public static boolean a(Context var0, com.facebook.ads.a.e var1) {
      com.facebook.ads.a.g var3 = var1.a();
      if(var3 != null && var3 != com.facebook.ads.a.g.a) {
         Collection var4 = var1.b();
         if(var4 != null && !var4.isEmpty()) {
            Iterator var5 = var4.iterator();

            boolean var2;
            while(true) {
               if(!var5.hasNext()) {
                  var2 = false;
                  break;
               }

               if(a(var0, (String)var5.next())) {
                  var2 = true;
                  break;
               }
            }

            if(var3 == com.facebook.ads.a.g.b) {
               return var2;
            }

            if(var3 == com.facebook.ads.a.g.c && !var2) {
               return true;
            }
         }
      }

      return false;
   }

   public static boolean a(Context var0, String var1) {
      if(com.facebook.ads.a.ag.a(var1)) {
         return false;
      } else {
         PackageManager var4 = var0.getPackageManager();

         try {
            var4.getPackageInfo(var1, 0);
            return true;
         } catch (NameNotFoundException var2) {
            return false;
         } catch (RuntimeException var3) {
            return false;
         }
      }
   }
}
