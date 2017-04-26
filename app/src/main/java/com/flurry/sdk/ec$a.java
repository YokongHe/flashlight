package com.flurry.sdk;

import com.flurry.sdk.ec;
import java.lang.Thread.UncaughtExceptionHandler;

final class ec$a implements UncaughtExceptionHandler {
   // $FF: synthetic field
   final ec a;

   private ec$a(ec var1) {
      this.a = var1;
   }

   // $FF: synthetic method
   ec$a(ec var1, Object var2) {
      this(var1);
   }

   public final void uncaughtException(Thread var1, Throwable var2) {
      ec.a(this.a, var1, var2);
      ec.b(this.a, var1, var2);
   }
}
