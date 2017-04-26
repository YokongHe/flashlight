package com.flurry.sdk;

import com.flurry.sdk.nr;
import com.flurry.sdk.qs;
import com.flurry.sdk.sh;

public class ns extends nr {
   protected final String a;
   protected final String b;

   protected ns(sh var1, qs var2) {
      super(var1, var2);
      String var4 = var1.p().getName();
      int var3 = var4.lastIndexOf(46);
      if(var3 < 0) {
         this.a = "";
         this.b = ".";
      } else {
         this.b = var4.substring(0, var3 + 1);
         this.a = var4.substring(0, var3);
      }
   }

   public sh a(String var1) {
      String var2 = var1;
      if(var1.startsWith(".")) {
         StringBuilder var3 = new StringBuilder(var1.length() + this.a.length());
         if(this.a.length() == 0) {
            var3.append(var1.substring(1));
         } else {
            var3.append(this.a).append(var1);
         }

         var2 = var3.toString();
      }

      return super.a(var2);
   }

   public String a(Object var1) {
      String var2 = var1.getClass().getName();
      String var3 = var2;
      if(var2.startsWith(this.b)) {
         var3 = var2.substring(this.b.length() - 1);
      }

      return var3;
   }
}
