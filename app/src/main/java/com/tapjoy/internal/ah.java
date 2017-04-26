package com.tapjoy.internal;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;

public final class ah {
   @SuppressLint({"NewApi"})
   public static void a(View var0, Drawable var1) {
      if(VERSION.SDK_INT >= 16) {
         var0.setBackground(var1);
      } else {
         var0.setBackgroundDrawable(var1);
      }
   }
}
