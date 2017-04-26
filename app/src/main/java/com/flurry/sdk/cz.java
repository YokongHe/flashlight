package com.flurry.sdk;

import com.flurry.sdk.eo;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class cz {
   private static final String a = com.flurry.sdk.cz.class.getSimpleName();

   public Map a(String var1) {
      eo.a(3, a, "Parsing referrer map");
      if(var1 == null) {
         return Collections.emptyMap();
      } else {
         HashMap var4 = new HashMap();
         String[] var5 = var1.split("&");
         int var3 = var5.length;

         for(int var2 = 0; var2 < var3; ++var2) {
            String[] var7 = var5[var2].split("=");
            if(var7.length != 2) {
               eo.a(5, a, "Invalid referrer Element: " + var5[var2] + " in referrer tag " + var1);
            } else {
               String var6 = URLDecoder.decode(var7[0]);
               String var11 = URLDecoder.decode(var7[1]);
               if(var4.get(var6) == null) {
                  var4.put(var6, new ArrayList());
               }

               ((List)var4.get(var6)).add(var11);
            }
         }

         Iterator var8 = var4.entrySet().iterator();

         while(var8.hasNext()) {
            Entry var10 = (Entry)var8.next();
            eo.a(3, a, "entry: " + (String)var10.getKey() + "=" + var10.getValue());
         }

         StringBuilder var9 = new StringBuilder();
         if(var4.get("utm_source") == null) {
            var9.append("Campaign Source is missing.\n");
         }

         if(var4.get("utm_medium") == null) {
            var9.append("Campaign Medium is missing.\n");
         }

         if(var4.get("utm_campaign") == null) {
            var9.append("Campaign Name is missing.\n");
         }

         if(var9.length() > 0) {
            eo.a(5, a, "Detected missing referrer keys : " + var9.toString());
         }

         return var4;
      }
   }
}
