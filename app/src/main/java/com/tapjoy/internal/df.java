package com.tapjoy.internal;

import com.tapjoy.internal.de;
import com.tapjoy.internal.di;
import com.tapjoy.internal.dk;
import com.tapjoy.internal.dn;
import com.tapjoy.internal.dq;
import com.tapjoy.internal.ds;
import com.tapjoy.internal.dv;
import java.io.InputStream;

public abstract class df implements ds {
   private static final dk a = dk.a();

   private static dq a(dq var0) {
      if(var0 != null && !var0.d()) {
         dv var1;
         if(var0 instanceof de) {
            var1 = new dv();
         } else {
            var1 = new dv();
         }

         throw var1.a().a(var0);
      } else {
         return var0;
      }
   }

   private dq a(InputStream var1, dk var2) {
      di var4 = new di(var1);
      dq var5 = (dq)this.a(var4, var2);

      try {
         var4.a(0);
         return var5;
      } catch (dn var3) {
         throw var3.a(var5);
      }
   }

   private dq a(byte[] param1, int param2, dk param3) {
      // $FF: Couldn't be decompiled
   }
}
