package com.inneractive.api.ads.sdk;

import com.inneractive.api.ads.sdk.s$b;
import java.io.OutputStream;

final class s$a {
   private final s$b a;
   private final boolean[] b;
   private boolean c;
   // $FF: synthetic field
   private com.inneractive.api.ads.sdk.s d;

   private s$a(com.inneractive.api.ads.sdk.s var1, s$b var2) {
      this.d = var1;
      super();
      this.a = var2;
      boolean[] var3;
      if(s$b.d(var2)) {
         var3 = null;
      } else {
         var3 = new boolean[com.inneractive.api.ads.sdk.s.e(var1)];
      }

      this.b = var3;
   }

   // $FF: synthetic method
   s$a(com.inneractive.api.ads.sdk.s var1, s$b var2, byte var3) {
      this(var1, var2);
   }

   // $FF: synthetic method
   static s$b a(s$a var0) {
      return var0.a;
   }

   // $FF: synthetic method
   static boolean a(s$a var0, boolean var1) {
      var0.c = true;
      return true;
   }

   // $FF: synthetic method
   static boolean[] b(s$a var0) {
      return var0.b;
   }

   final OutputStream a(int param1) {
      // $FF: Couldn't be decompiled
   }

   final void a() {
      if(this.c) {
         com.inneractive.api.ads.sdk.s.a(this.d, this, false);
         this.d.c(s$b.c(this.a));
      } else {
         com.inneractive.api.ads.sdk.s.a(this.d, this, true);
      }
   }

   final void b() {
      com.inneractive.api.ads.sdk.s.a(this.d, this, false);
   }
}
