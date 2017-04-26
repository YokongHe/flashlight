package com.surpax.c.a;

import android.content.ContentResolver;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.view.WindowManager.LayoutParams;
import com.surpax.ledflashlight.FlashlightActivity;

public final class b extends com.surpax.c.a.a {
   private int a = -1;

   final boolean a() {
      ContentResolver var1 = FlashlightActivity.a().getContentResolver();

      try {
         this.a = System.getInt(var1, "screen_brightness");
         return true;
      } catch (SettingNotFoundException var2) {
         var2.printStackTrace();
         return false;
      }
   }

   final void b() {
      try {
         LayoutParams var1 = FlashlightActivity.a().getWindow().getAttributes();
         var1.screenBrightness = Float.valueOf((float)this.a).floatValue() * 0.003921569F;
         FlashlightActivity.a().getWindow().setAttributes(var1);
      } catch (RuntimeException var2) {
         var2.printStackTrace();
      }
   }

   final void c() {
      try {
         FlashlightActivity.a().j().setBackgroundColor(-1);
         LayoutParams var1 = FlashlightActivity.a().getWindow().getAttributes();
         var1.screenBrightness = 1.0F;
         FlashlightActivity.a().getWindow().setAttributes(var1);
      } catch (RuntimeException var2) {
         var2.printStackTrace();
      }
   }

   final void d() {
      try {
         FlashlightActivity.a().j().setBackgroundColor(-16777216);
      } catch (Exception var2) {
         var2.printStackTrace();
      }
   }

   final void e() {
      try {
         LayoutParams var1 = FlashlightActivity.a().getWindow().getAttributes();
         var1.screenBrightness = Float.valueOf((float)this.a).floatValue() * 0.003921569F;
         FlashlightActivity.a().getWindow().setAttributes(var1);
      } catch (RuntimeException var2) {
         var2.printStackTrace();
      }
   }
}
