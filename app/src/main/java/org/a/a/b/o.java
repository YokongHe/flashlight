package org.a.a.b;

public final class o extends org.a.a.b.a {
   // $FF: synthetic field
   final k a;

   public o(k var1) {
      this.a = var1;
   }

   public final Object a(org.a.a.g.d var1) {
      k var8 = this.a;
      String var13 = ((org.a.a.g.g)var1).b().toString().replaceAll("_", "");
      byte var5 = 1;
      char var6 = var13.charAt(0);
      byte var4;
      String var9;
      if(var6 == 45) {
         var4 = -1;
         var9 = var13.substring(1);
      } else {
         var4 = var5;
         var9 = var13;
         if(var6 == 43) {
            var9 = var13.substring(1);
            var4 = var5;
         }
      }

      var13 = var9.toLowerCase();
      double var2;
      if(".inf".equals(var13)) {
         if(var4 == -1) {
            var2 = Double.NEGATIVE_INFINITY;
         } else {
            var2 = Double.POSITIVE_INFINITY;
         }

         return new Double(var2);
      } else if(".nan".equals(var13)) {
         return new Double(Double.NaN);
      } else if(var9.indexOf(58) == -1) {
         return new Double(Double.valueOf(var9).doubleValue() * (double)var4);
      } else {
         String[] var10 = var9.split(":");
         int var12 = 1;
         var2 = 0.0D;
         int var11 = 0;

         for(int var7 = var10.length; var11 < var7; ++var11) {
            var2 += Double.parseDouble(var10[var7 - var11 - 1]) * (double)var12;
            var12 *= 60;
         }

         return new Double(var2 * (double)var4);
      }
   }
}
