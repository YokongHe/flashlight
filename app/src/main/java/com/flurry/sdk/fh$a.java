package com.flurry.sdk;

import com.flurry.sdk.fh;
import com.flurry.sdk.fh$b;
import java.io.OutputStream;

public final class fh$a {
   // $FF: synthetic field
   final fh a;
   private final fh$b b;
   private final boolean[] c;
   private boolean d;
   private boolean e;

   private fh$a(fh var1, fh$b var2) {
      this.a = var1;
      this.b = var2;
      boolean[] var3;
      if(fh$b.d(var2)) {
         var3 = null;
      } else {
         var3 = new boolean[fh.e(var1)];
      }

      this.c = var3;
   }

   // $FF: synthetic method
   fh$a(fh var1, fh$b var2, Object var3) {
      this(var1, var2);
   }

   // $FF: synthetic method
   static fh$b a(fh$a var0) {
      return var0.b;
   }

   // $FF: synthetic method
   static boolean a(fh$a var0, boolean var1) {
      var0.d = var1;
      return var1;
   }

   // $FF: synthetic method
   static boolean[] b(fh$a var0) {
      return var0.c;
   }

   public final OutputStream a(int param1) {
      // $FF: Couldn't be decompiled
   }

   public final void a() {
      if(this.d) {
         fh.a(this.a, this, false);
         this.a.c(fh$b.c(this.b));
      } else {
         fh.a(this.a, this, true);
      }

      this.e = true;
   }

   public final void b() {
      fh.a(this.a, this, false);
   }
}
