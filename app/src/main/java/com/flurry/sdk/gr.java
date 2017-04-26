package com.flurry.sdk;

import com.flurry.sdk.fn;
import com.flurry.sdk.fn$f;
import com.flurry.sdk.gq;
import com.flurry.sdk.gq$h;
import com.flurry.sdk.gr$a;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class gr {
   public gq a(fn var1, Map var2) {
      int var3;
      gq[] var4;
      Iterator var7;
      gq var8;
      switch(null.a[var1.a().ordinal()]) {
      case 1:
         var8 = gq.c;
         break;
      case 2:
         return gq.d;
      case 3:
         return gq.e;
      case 4:
         return gq.f;
      case 5:
         return gq.g;
      case 6:
         return gq.h;
      case 7:
         return gq.i;
      case 8:
         return gq.j;
      case 9:
         return gq.b(new gq[]{new gq$h(var1.l()), gq.k});
      case 10:
         return gq.b(new gq[]{new gq$h(var1.c().size()), gq.l});
      case 11:
         return gq.b(new gq[]{gq.a(gq.o, new gq[]{this.a(var1.i(), var2)}), gq.n});
      case 12:
         return gq.b(new gq[]{gq.a(gq.q, new gq[]{this.a(var1.j(), var2), gq.i}), gq.p});
      case 13:
         gr$a var11 = new gr$a(var1);
         gq var10 = (gq)var2.get(var11);
         var8 = var10;
         if(var10 == null) {
            var4 = new gq[var1.b().size()];
            var10 = gq.b(var4);
            var2.put(var11, var10);
            var3 = var4.length;

            fn$f var12;
            for(var7 = var1.b().iterator(); var7.hasNext(); var4[var3] = this.a(var12.c(), var2)) {
               var12 = (fn$f)var7.next();
               --var3;
            }

            return var10;
         }
         break;
      case 14:
         List var5 = var1.k();
         var4 = new gq[var5.size()];
         String[] var9 = new String[var5.size()];
         var7 = var1.k().iterator();

         for(var3 = 0; var7.hasNext(); ++var3) {
            fn var6 = (fn)var7.next();
            var4[var3] = this.a(var6, var2);
            var9[var3] = var6.g();
         }

         return gq.b(new gq[]{gq.a(var4, var9), gq.m});
      default:
         throw new RuntimeException("Unexpected schema type");
      }

      return var8;
   }
}
