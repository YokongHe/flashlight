package org.a.a.b;

public final class p extends org.a.a.b.a {
   // $FF: synthetic field
   final k a;

   public p(k var1) {
      this.a = var1;
   }

   public final Object a(org.a.a.g.d var1) {
      int var5 = 0;
      int var4 = 1;
      k var7 = this.a;
      String var8 = ((org.a.a.g.g)var1).b().toString().replaceAll("_", "");
      char var2 = var8.charAt(0);
      byte var9;
      if(var2 == 45) {
         var8 = var8.substring(1);
         var9 = -1;
      } else if(var2 == 43) {
         var8 = var8.substring(1);
         var9 = 1;
      } else {
         var9 = 1;
      }

      if("0".equals(var8)) {
         return Integer.valueOf(0);
      } else {
         byte var3;
         if(var8.startsWith("0b")) {
            var8 = var8.substring(2);
            var3 = 2;
         } else if(var8.startsWith("0x")) {
            var8 = var8.substring(2);
            var3 = 16;
         } else {
            if(!var8.startsWith("0")) {
               if(var8.indexOf(58) == -1) {
                  return k.a(this.a, var9, var8, 10);
               }

               String[] var10 = var8.split(":");
               int var6 = var10.length;

               for(int var11 = 0; var11 < var6; ++var11) {
                  var5 = (int)((long)var5 + Long.parseLong(var10[var6 - var11 - 1]) * (long)var4);
                  var4 *= 60;
               }

               return k.a(this.a, var9, String.valueOf(var5), 10);
            }

            var8 = var8.substring(1);
            var3 = 8;
         }

         return k.a(this.a, var9, var8, var3);
      }
   }
}
