package com.tapjoy.internal;

import java.io.File;
import java.io.IOException;

public final class fz {
   private final File a;

   public fz(File var1) {
      this.a = var1;
   }

   public final boolean a() {
      // $FF: Couldn't be decompiled
   }

   final String b() {
      if(this.a.exists()) {
         int var1;
         String var2;
         try {
            var2 = com.tapjoy.internal.bm.a(this.a, com.tapjoy.internal.aq.c);
            var1 = var2.length();
         } catch (IOException var3) {
            return null;
         }

         if(var1 > 0) {
            return var2;
         }
      }

      return null;
   }
}
