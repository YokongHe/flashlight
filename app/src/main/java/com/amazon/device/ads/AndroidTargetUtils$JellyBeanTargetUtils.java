package com.amazon.device.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageButton;

@TargetApi(16)
class AndroidTargetUtils$JellyBeanTargetUtils {
   public static void hideStatusBar(Activity var0) {
      var0.getWindow().getDecorView().setSystemUiVisibility(4);
   }

   public static void setBackgroundForLinerLayout(View var0, Drawable var1) {
      var0.setBackground(var1);
   }

   protected static void setImageButtonAlpha(ImageButton var0, int var1) {
      var0.setImageAlpha(var1);
   }
}
