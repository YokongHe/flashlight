package com.google.android.gms.internal;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings.Secure;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.FrameLayout.LayoutParams;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

public final class bI {
   public static final Handler a = new Handler(Looper.getMainLooper());

   public static int a(Context var0, int var1) {
      return a(var0.getResources().getDisplayMetrics(), var1);
   }

   public static int a(DisplayMetrics var0, int var1) {
      return (int)TypedValue.applyDimension(1, (float)var1, var0);
   }

   public static String a(Context var0) {
      String var1 = Secure.getString(var0.getContentResolver(), "android_id");
      if(var1 == null || a()) {
         var1 = "emulator";
      }

      return a(var1);
   }

   public static String a(String var0) {
      int var1 = 0;

      while(var1 < 2) {
         try {
            MessageDigest var2 = MessageDigest.getInstance("MD5");
            var2.update(var0.getBytes());
            String var4 = String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, var2.digest())});
            return var4;
         } catch (NoSuchAlgorithmException var3) {
            ++var1;
         }
      }

      return null;
   }

   public static void a(ViewGroup var0, com.google.android.gms.internal.ak var1, String var2) {
      a(var0, var1, var2, -16777216, -1);
   }

   private static void a(ViewGroup var0, com.google.android.gms.internal.ak var1, String var2, int var3, int var4) {
      if(var0.getChildCount() == 0) {
         Context var5 = var0.getContext();
         TextView var6 = new TextView(var5);
         var6.setGravity(17);
         var6.setText(var2);
         var6.setTextColor(var3);
         var6.setBackgroundColor(var4);
         FrameLayout var7 = new FrameLayout(var5);
         var7.setBackgroundColor(var3);
         var3 = a((Context)var5, 3);
         var7.addView(var6, new LayoutParams(var1.g - var3, var1.d - var3, 17));
         var0.addView(var7, var1.g, var1.d);
      }
   }

   public static void a(ViewGroup var0, com.google.android.gms.internal.ak var1, String var2, String var3) {
      com.google.android.gms.internal.bJ.e(var3);
      a(var0, var1, var2, -65536, -16777216);
   }

   public static boolean a() {
      return Build.DEVICE.startsWith("generic");
   }

   public static boolean b() {
      return Looper.myLooper() == Looper.getMainLooper();
   }
}
