package com.tapjoy.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public final class n extends com.tapjoy.internal.o {
   private final long c = 0L;

   public n(SharedPreferences var1, String var2) {
      super(var1, var2);
   }

   public final long a() {
      return this.a.getLong(this.b, this.c);
   }

   public final Editor a(Editor var1) {
      return var1.remove(this.b);
   }

   public final Editor a(Editor var1, long var2) {
      return var1.putLong(this.b, var2);
   }

   public final void a(long var1) {
      this.a.edit().putLong(this.b, var1).commit();
   }
}
