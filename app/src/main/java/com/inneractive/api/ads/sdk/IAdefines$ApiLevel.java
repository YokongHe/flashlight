package com.inneractive.api.ads.sdk;

import android.os.Build.VERSION;

enum IAdefines$ApiLevel {
   a(8),
   b(9),
   c(10),
   d(11),
   e(13),
   f(14),
   g(16),
   h(18),
   i(19),
   j(1),
   k(2),
   l(3),
   m(4),
   n(5),
   o(6),
   p(7),
   q(12),
   r(15),
   s(17),
   t(10000);

   private int u;

   private IAdefines$ApiLevel(int var3) {
      this.u = var3;
   }

   static IAdefines$ApiLevel a() {
      int var1 = VERSION.SDK_INT;
      IAdefines$ApiLevel[] var3 = values();
      int var2 = var3.length;

      for(int var0 = 0; var0 < var2; ++var0) {
         IAdefines$ApiLevel var4 = var3[var0];
         if(var4.u == var1) {
            return var4;
         }
      }

      return t;
   }

   final boolean a(IAdefines$ApiLevel var1) {
      return this.u <= var1.u;
   }

   final boolean b(IAdefines$ApiLevel var1) {
      return this.u >= var1.u;
   }

   final boolean c(IAdefines$ApiLevel var1) {
      return this.u < var1.u;
   }
}
