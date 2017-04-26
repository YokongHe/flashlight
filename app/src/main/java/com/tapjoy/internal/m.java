package com.tapjoy.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public final class m extends com.tapjoy.internal.o {
   private final int c;

   public m(SharedPreferences var1, String var2, int var3) {
      super(var1, var2);
      this.c = var3;
   }

   public final Editor a(Editor var1, int var2) {
      return var1.putInt(this.b, var2);
   }

   public final Integer a() {
      return Integer.valueOf(this.b());
   }

   public final void a(int var1) {
      this.a.edit().putInt(this.b, var1).commit();
   }

   public final int b() {
      return this.a.getInt(this.b, this.c);
   }
}
