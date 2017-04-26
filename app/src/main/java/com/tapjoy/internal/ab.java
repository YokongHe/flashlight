package com.tapjoy.internal;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public final class ab {
   public static String a(File var0, File var1) {
      Object var4 = null;
      String var3;
      if(var0.exists()) {
         var3 = com.tapjoy.internal.cv.b(com.tapjoy.internal.bm.a(var0));
      } else {
         var3 = null;
      }

      String var2 = (String)var4;
      if(var1 != null) {
         var2 = (String)var4;
         if(var1.exists()) {
            var2 = com.tapjoy.internal.cv.b(com.tapjoy.internal.bm.a(var1));
         }
      }

      if(var3 == null) {
         var3 = var2;
         if(var2 == null) {
            var2 = UUID.randomUUID().toString();
            var3 = var2;
            if(var1 != null) {
               label40: {
                  try {
                     com.tapjoy.internal.bm.a(var1, var2);
                  } catch (IOException var6) {
                     var3 = var2;
                     break label40;
                  }

                  var3 = var2;
               }
            }
         }

         try {
            com.tapjoy.internal.bm.a(var0, var3);
         } catch (IOException var5) {
            ;
         }

         if(!var3.equals(com.tapjoy.internal.bm.a(var0))) {
            ;
         }

         return var3;
      } else {
         if(var2 == null && var1 != null) {
            try {
               com.tapjoy.internal.bm.a(var1, var3);
               return var3;
            } catch (IOException var7) {
               ;
            }
         }

         return var3;
      }
   }
}
