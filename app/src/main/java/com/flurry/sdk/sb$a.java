package com.flurry.sdk;

final class sb$a {
   private final String a;
   private final sb$a b;

   public sb$a(String var1, sb$a var2) {
      this.a = var1;
      this.b = var2;
   }

   public final String a() {
      return this.a;
   }

   public final String a(char[] var1, int var2, int var3) {
      String var7 = this.a;
      sb$a var6 = this.b;

      while(true) {
         if(var7.length() == var3) {
            int var4 = 0;

            int var5;
            do {
               var5 = var4;
               if(var7.charAt(var4) != var1[var2 + var4]) {
                  break;
               }

               var5 = var4 + 1;
               var4 = var5;
            } while(var5 < var3);

            if(var5 == var3) {
               return var7;
            }
         }

         if(var6 == null) {
            return null;
         }

         var7 = var6.a();
         var6 = var6.b();
      }
   }

   public final sb$a b() {
      return this.b;
   }
}
