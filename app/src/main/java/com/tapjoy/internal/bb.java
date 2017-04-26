package com.tapjoy.internal;

import java.util.List;

public final class bb {
   public static void a(List var0, int var1) {
      if(var1 < 0) {
         throw new IndexOutOfBoundsException();
      } else {
         if(var1 > 0) {
            int var3 = var0.size();
            if(var1 > var3) {
               throw new IndexOutOfBoundsException();
            }

            int var2 = var1;
            if(var1 == var3) {
               var0.clear();
            } else {
               while(var2 > 0) {
                  var0.remove(0);
                  --var2;
               }
            }
         }

      }
   }
}
