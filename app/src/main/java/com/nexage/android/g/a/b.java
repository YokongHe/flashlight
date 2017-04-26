package com.nexage.android.g.a;

import android.location.Location;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class b {
   static Pattern a;

   public static String a(String var0, HashMap var1) {
      com.nexage.android.a var4 = com.nexage.android.b.x();
      Location var9;
      if(var4 != null) {
         var9 = var4.a();
      } else {
         var9 = null;
      }

      com.nexage.android.g.a.c var10;
      if(var9 != null) {
         var10 = new com.nexage.android.g.a.c(var9.getLatitude(), var9.getLongitude());
      } else {
         var10 = null;
      }

      int var2 = com.nexage.android.a.r.a();
      if(a == null) {
         a = Pattern.compile("\\^\\{([A-Z]+?),(.*?)\\}");
      }

      StringBuffer var7 = new StringBuffer(var0);

      for(Matcher var5 = a.matcher(var7); var5.find(0); var5 = a.matcher(var7)) {
         String var6 = var5.group(1);
         var0 = var5.group(2);
         if("LAT".equals(var6)) {
            if(var10 != null) {
               var0 = "" + var10.a;
            }
         } else if("LNG".equals(var6)) {
            if(var10 != null) {
               var0 = "" + var10.b;
            }
         } else if("NET".equals(var6)) {
            var0 = "" + com.nexage.android.a.m.j();
         } else if("SD".equals(var6)) {
            int var3 = var2;
            if(var2 > com.nexage.android.d.e.c()) {
               var3 = 0;
            }

            var0 = "" + var3;
            var2 = var3;
         } else if(var1 != null) {
            String var8 = (String)var1.get("RID");
            if("RID".equals(var6) && var8 != null) {
               var0 = var8;
            }
         }

         var6 = var0;
         if(var0 == null) {
            var6 = "";
         }

         var7.replace(var5.start(), var5.end(), var6);
      }

      com.nexage.android.a.p.c("string after macro sub: " + var7);
      return var7.toString();
   }
}
