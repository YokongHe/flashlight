package com.flurry.sdk;

import com.flurry.sdk.jr$b;

public class jr$a extends jr$b {
   public String a(String var1) {
      if(var1 != null) {
         int var7 = var1.length();
         StringBuilder var8 = new StringBuilder(var7 * 2);
         int var6 = 0;
         boolean var4 = false;

         int var3;
         boolean var9;
         for(var3 = 0; var6 < var7; var4 = var9) {
            char var2 = var1.charAt(var6);
            int var10;
            if(var6 <= 0 && var2 == 95) {
               var10 = var3;
               var9 = var4;
            } else {
               if(Character.isUpperCase(var2)) {
                  int var5 = var3;
                  if(!var4) {
                     var5 = var3;
                     if(var3 > 0) {
                        var5 = var3;
                        if(var8.charAt(var3 - 1) != 95) {
                           var8.append('_');
                           var5 = var3 + 1;
                        }
                     }
                  }

                  var2 = Character.toLowerCase(var2);
                  var9 = true;
                  var10 = var5;
               } else {
                  var10 = var3;
                  var9 = false;
               }

               var8.append(var2);
               ++var10;
            }

            ++var6;
            var3 = var10;
         }

         if(var3 > 0) {
            return var8.toString();
         }
      }

      return var1;
   }
}
