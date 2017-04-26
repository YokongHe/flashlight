package com.tapjoy.internal;

import android.content.SharedPreferences;

public final class j extends com.tapjoy.internal.o {
   private final boolean c = false;

   public j(SharedPreferences var1, String var2) {
      super(var1, var2);
   }

   public final Boolean a() {
      return Boolean.valueOf(this.a.getBoolean(this.b, this.c));
   }

   public final void a(boolean var1) {
      this.a.edit().putBoolean(this.b, var1).commit();
   }
}
