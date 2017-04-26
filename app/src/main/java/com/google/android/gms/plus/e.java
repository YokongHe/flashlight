package com.google.android.gms.plus;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.drawable.Drawable;

final class e implements com.google.android.gms.plus.g {
   private Context a;

   private e(Context var1) {
      this.a = var1;
   }

   // $FF: synthetic method
   e(Context var1, byte var2) {
      this(var1);
   }

   public final Drawable a(int param1) {
      // $FF: Couldn't be decompiled
   }

   public final boolean a() {
      try {
         this.a.createPackageContext("com.google.android.gms", 4).getResources();
         return true;
      } catch (NameNotFoundException var2) {
         return false;
      }
   }
}
