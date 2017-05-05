package com.surpax.c.a;

import android.content.ContentResolver;
import android.hardware.Camera;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.util.Log;

import com.surpax.ledflashlight.FlashlightActivity;

public final class b extends com.surpax.c.a.a {
   private int a = -1;
   Camera mCamera;
   private boolean cameraRelease;

   final boolean a() {
      Log.e("yokong", "com.suipax.c.a.b.a(): ");
      ContentResolver var1 = FlashlightActivity.getFlashlightActivityInstance().getContentResolver();

      try {
         this.a = System.getInt(var1, "screen_brightness");
         return true;
      } catch (SettingNotFoundException var2) {
         var2.printStackTrace();
         return false;
      }
   }

   final void b() {
      Log.e("yokong", "com.suipax.c.a.b.b(): ");
//      try {
//         LayoutParams var1 = FlashlightActivity.getFlashlightActivityInstance().getWindow().getAttributes();
//         var1.screenBrightness = Float.valueOf((float)this.a).floatValue() * 0.003921569F;
//         FlashlightActivity.getFlashlightActivityInstance().getWindow().setAttributes(var1);
//      } catch (RuntimeException var2) {
//         var2.printStackTrace();
//      }
   }

   final void c() {
      Log.e("yokong", "com.suipax.c.a.b.c(): ");
      openFlash();
//      try {
//         FlashlightActivity.getFlashlightActivityInstance().j().setBackgroundColor(-1);
//         LayoutParams var1 = FlashlightActivity.getFlashlightActivityInstance().getWindow().getAttributes();
//         var1.screenBrightness = 1.0F;
//         FlashlightActivity.getFlashlightActivityInstance().getWindow().setAttributes(var1);
//      } catch (RuntimeException var2) {
//         var2.printStackTrace();
//      }
   }

   final void d() {
      Log.e("yokong", "com.suipax.c.a.b.d(): ");
      closeFlash();
//      try {
//         FlashlightActivity.getFlashlightActivityInstance().j().setBackgroundColor(-16777216);
//      } catch (Exception var2) {
//         var2.printStackTrace();
//      }
   }

   final void e() {
//      closeFlash();
      releaseFlash();
//      Log.e("yokong", "com.suipax.c.a.b.e(): ");
//      try {
//         LayoutParams var1 = FlashlightActivity.getFlashlightActivityInstance().getWindow().getAttributes();
//         var1.screenBrightness = Float.valueOf((float)this.a).floatValue() * 0.003921569F;
//         FlashlightActivity.getFlashlightActivityInstance().getWindow().setAttributes(var1);
//      } catch (RuntimeException var2) {
//         var2.printStackTrace();
//      }
   }

   private void openFlash() {
      try{
         if (mCamera == null) {
            mCamera = Camera.open();
         }
         if (cameraRelease) {
            mCamera = Camera.open();
            cameraRelease = false;
         }
         mCamera.reconnect();
         Camera.Parameters mParameters;
         mParameters = mCamera.getParameters();
         mParameters.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
         mCamera.setParameters(mParameters);
      } catch(Exception ex){}
   }

   private void closeFlash() {
      try{
         Camera.Parameters mParameters;
         mParameters = mCamera.getParameters();
         mParameters.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
         mCamera.setParameters(mParameters);
      } catch(Exception ex){}
   }

   private void releaseFlash() {
      cameraRelease = true;
      mCamera.release();
   }
}
