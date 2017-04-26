package com.flurry.sdk;

import com.flurry.sdk.hf;
import com.flurry.sdk.hs;
import java.util.Arrays;

public class sl$b implements hs {
   static final String a;
   static final char[] b;

   static {
      String var0 = null;

      String var1;
      label17: {
         try {
            var1 = System.getProperty("line.separator");
         } catch (Throwable var2) {
            break label17;
         }

         var0 = var1;
      }

      var1 = var0;
      if(var0 == null) {
         var1 = "\n";
      }

      a = var1;
      char[] var3 = new char[64];
      b = var3;
      Arrays.fill(var3, ' ');
   }

   public void a(hf var1, int var2) {
      var1.c(a);

      for(var2 += var2; var2 > 64; var2 -= b.length) {
         var1.b(b, 0, 64);
      }

      var1.b(b, 0, var2);
   }

   public boolean a() {
      return false;
   }
}
