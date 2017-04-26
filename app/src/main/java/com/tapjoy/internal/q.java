package com.tapjoy.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public final class q extends com.tapjoy.internal.o {
   private final String c = null;

   public q(SharedPreferences var1, String var2) {
      super(var1, var2);
   }

   public final Editor a(Editor var1, String var2) {
      return var2 != null?var1.putString(this.b, var2):var1.remove(this.b);
   }

   public final String a() {
      return this.a.getString(this.b, this.c);
   }

   public final void a(String var1) {
      this.a.edit().putString(this.b, var1).commit();
   }
}
