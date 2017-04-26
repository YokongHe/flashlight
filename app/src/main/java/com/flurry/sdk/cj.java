package com.flurry.sdk;

import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class cj {
   public static int a(String var0) {
      if(var0 != null) {
         Matcher var3 = Pattern.compile("<VAST version=\"(.+?)\">").matcher(var0);
         if(var3.find() && var3.groupCount() == 1) {
            int var1;
            try {
               var1 = Math.round(Float.parseFloat(var3.group(1)));
            } catch (NumberFormatException var2) {
               return 0;
            }

            return var1 > 0 && var1 <= 3?var1:0;
         } else {
            return 0;
         }
      } else {
         return 0;
      }
   }

   static com.flurry.sdk.cv a(List var0) {
      com.flurry.sdk.cv var1;
      if(var0 != null) {
         Iterator var2 = var0.iterator();
         com.flurry.sdk.cv var3 = null;

         while(true) {
            do {
               do {
                  do {
                     var1 = var3;
                     if(!var2.hasNext()) {
                        return var1;
                     }

                     var1 = (com.flurry.sdk.cv)var2.next();
                  } while(var1.b() > 500);
               } while(var1.a() == null);
            } while((var1.c() == null || !var1.c().equalsIgnoreCase("video/mp4")) && !var1.a().endsWith("mp4"));

            if(var3 == null) {
               var3 = var1;
            } else if(var3.b() < var1.b()) {
               var3 = var1;
            }
         }
      } else {
         var1 = null;
         return var1;
      }
   }

   static int b(String var0) {
      byte var2 = 0;
      int var1 = var2;
      if(var0 != null) {
         Matcher var5 = Pattern.compile("(\\d{2}):(\\d{2}):(\\d{2})").matcher(var0);
         var1 = var2;
         if(var5.find()) {
            var1 = var2;
            if(var5.groupCount() == 3) {
               int var3;
               int var6;
               try {
                  var1 = Integer.parseInt(var5.group(1));
                  var6 = Integer.parseInt(var5.group(2));
                  var3 = Integer.parseInt(var5.group(3));
               } catch (NumberFormatException var4) {
                  return 0;
               }

               var1 = var3 + var1 * 60 * 60 + var6 * 60;
            }
         }
      }

      return var1;
   }
}
