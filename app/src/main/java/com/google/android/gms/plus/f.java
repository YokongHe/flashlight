package com.google.android.gms.plus;

import android.content.Context;
import android.graphics.drawable.Drawable;

final class f implements com.google.android.gms.plus.g {
   private Context a;

   private f(Context var1) {
      this.a = var1;
   }

   // $FF: synthetic method
   f(Context var1, byte var2) {
      this(var1);
   }

   public final Drawable a(int var1) {
      String var2;
      switch(var1) {
      case 0:
         var2 = "ic_plusone_small_off_client";
         break;
      case 1:
         var2 = "ic_plusone_medium_off_client";
         break;
      case 2:
         var2 = "ic_plusone_tall_off_client";
         break;
      default:
         var2 = "ic_plusone_standard_off_client";
      }

      var1 = this.a.getResources().getIdentifier(var2, "drawable", this.a.getPackageName());
      return this.a.getResources().getDrawable(var1);
   }

   public final boolean a() {
      int var1 = this.a.getResources().getIdentifier("ic_plusone_small_off_client", "drawable", this.a.getPackageName());
      int var2 = this.a.getResources().getIdentifier("ic_plusone_medium_off_client", "drawable", this.a.getPackageName());
      int var3 = this.a.getResources().getIdentifier("ic_plusone_tall_off_client", "drawable", this.a.getPackageName());
      int var4 = this.a.getResources().getIdentifier("ic_plusone_standard_off_client", "drawable", this.a.getPackageName());
      return var1 != 0 && var2 != 0 && var3 != 0 && var4 != 0;
   }
}
