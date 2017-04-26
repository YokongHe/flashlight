package com.tapjoy.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public final class p {
   public static boolean a(SharedPreferences var0, String var1, int var2) {
      Editor var3 = var0.edit();
      var3.putInt(var1, var2);
      return var3.commit();
   }

   public static boolean a(SharedPreferences var0, String var1, String var2) {
      Editor var3 = var0.edit();
      var3.putString(var1, var2);
      return var3.commit();
   }

   public static boolean a(SharedPreferences var0, String var1, boolean var2) {
      Editor var3 = var0.edit();
      var3.putBoolean(var1, var2);
      return var3.commit();
   }
}
