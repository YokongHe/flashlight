package com.flurry.sdk;

import com.flurry.sdk.gd$a;
import java.io.OutputStream;

class gd$b extends gd$a {
   private final OutputStream a;

   private gd$b(OutputStream var1) {
      this.a = var1;
   }

   // $FF: synthetic method
   gd$b(OutputStream var1, Object var2) {
      this(var1);
   }

   protected void a() {
      this.a.flush();
   }

   protected void a(byte[] var1, int var2, int var3) {
      this.a.write(var1, var2, var3);
   }
}
