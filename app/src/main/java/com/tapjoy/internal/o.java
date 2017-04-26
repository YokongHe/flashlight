package com.tapjoy.internal;

import android.content.SharedPreferences;

public abstract class o {
   protected SharedPreferences a;
   protected String b;

   public o(SharedPreferences var1, String var2) {
      this.a = var1;
      this.b = var2;
   }

   public final void c() {
      this.a.edit().remove(this.b).commit();
   }
}
