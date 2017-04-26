package com.google.android.gms.internal;

import android.os.Handler;

public final class dw {
   private final Handler a;

   public dw(Handler var1) {
      this.a = var1;
   }

   public final void a(Runnable var1) {
      this.a.removeCallbacks(var1);
   }

   public final boolean a(Runnable var1, long var2) {
      return this.a.postDelayed(var1, var2);
   }
}
