package com.tapjoy.internal;

public final class cp {
   private final String[] a = new String[512];

   public final String a(char[] var1, int var2, int var3) {
      boolean var6 = false;
      int var4 = var2;

      int var5;
      for(var5 = 0; var4 < var2 + var3; ++var4) {
         var5 = var5 * 31 + var1[var4];
      }

      var4 = var5 >>> 20 ^ var5 >>> 12 ^ var5;
      int var7 = (var4 ^ var4 >>> 7 ^ var4 >>> 4) & this.a.length - 1;
      String var8 = this.a[var7];
      if(var8 != null) {
         boolean var10;
         if(var8.length() != var3) {
            var10 = var6;
         } else {
            var5 = 0;

            while(true) {
               if(var5 >= var3) {
                  var10 = true;
                  break;
               }

               var10 = var6;
               if(var1[var2 + var5] != var8.charAt(var5)) {
                  break;
               }

               ++var5;
            }
         }

         if(var10) {
            return var8;
         }
      }

      String var9 = new String(var1, var2, var3);
      this.a[var7] = var9;
      return var9;
   }
}
