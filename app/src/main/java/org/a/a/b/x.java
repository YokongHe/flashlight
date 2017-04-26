package org.a.a.b;

import java.util.Calendar;
import java.util.TimeZone;
import java.util.regex.Matcher;

public final class x extends org.a.a.b.a {
   private Calendar a;

   public final Object a(org.a.a.g.d var1) {
      String var6 = ((org.a.a.g.g)var1).b();
      Matcher var14 = k.d().matcher(var6);
      String var7;
      String var15;
      if(var14.matches()) {
         var6 = var14.group(1);
         var7 = var14.group(2);
         var15 = var14.group(3);
         this.a = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
         this.a.clear();
         this.a.set(1, Integer.parseInt(var6));
         this.a.set(2, Integer.parseInt(var7) - 1);
         this.a.set(5, Integer.parseInt(var15));
         return this.a.getTime();
      } else {
         Matcher var12 = k.e().matcher(var6);
         if(!var12.matches()) {
            throw new org.a.a.c.c("Unexpected timestamp: " + var6);
         } else {
            var7 = var12.group(1);
            String var8 = var12.group(2);
            String var9 = var12.group(3);
            String var10 = var12.group(4);
            String var11 = var12.group(5);
            var6 = var12.group(6);
            String var13 = var12.group(7);
            var15 = var6;
            if(var13 != null) {
               var15 = var6 + "." + var13;
            }

            double var2 = Double.parseDouble(var15);
            int var4 = (int)Math.round(Math.floor(var2));
            int var5 = (int)Math.round((var2 - (double)var4) * 1000.0D);
            var6 = var12.group(8);
            var15 = var12.group(9);
            TimeZone var16;
            if(var6 != null) {
               if(var15 != null) {
                  var15 = ":" + var15;
               } else {
                  var15 = "00";
               }

               var16 = TimeZone.getTimeZone("GMT" + var6 + var15);
            } else {
               var16 = TimeZone.getTimeZone("UTC");
            }

            this.a = Calendar.getInstance(var16);
            this.a.set(1, Integer.parseInt(var7));
            this.a.set(2, Integer.parseInt(var8) - 1);
            this.a.set(5, Integer.parseInt(var9));
            this.a.set(11, Integer.parseInt(var10));
            this.a.set(12, Integer.parseInt(var11));
            this.a.set(13, var4);
            this.a.set(14, var5);
            return this.a.getTime();
         }
      }
   }

   public final Calendar a() {
      return this.a;
   }
}
