package com.tapjoy.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public final class k extends com.tapjoy.internal.o {
   private final double c = 0.0D;

   public k(SharedPreferences var1, String var2) {
      super(var1, var2);
   }

   public final double a() {
      String var3 = this.a.getString(this.b, (String)null);
      if(var3 != null) {
         try {
            double var1 = Double.parseDouble(var3);
            return var1;
         } catch (NumberFormatException var4) {
            ;
         }
      }

      return this.c;
   }

   public final Editor a(Editor var1) {
      return var1.remove(this.b);
   }

   public final Editor a(Editor var1, double var2) {
      return var1.putString(this.b, Double.toString(var2));
   }
}
