package com.flurry.sdk;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

public class do {
   private static do a;
   private final Context b;
   private final Handler c;
   private final Handler d;

   private do(Context var1) {
      this.b = var1.getApplicationContext();
      this.c = new Handler(Looper.getMainLooper());
      HandlerThread var2 = new HandlerThread("FlurryAgent");
      var2.start();
      this.d = new Handler(var2.getLooper());
   }

   public static do a() {
      return a;
   }

   public static void a(Context param0) {
      // $FF: Couldn't be decompiled
   }

   public void a(Runnable var1) {
      if(var1 != null) {
         this.c.post(var1);
      }
   }

   public void a(Runnable var1, long var2) {
      if(var1 != null) {
         this.c.postDelayed(var1, var2);
      }
   }

   public Context b() {
      return this.b;
   }

   public void b(Runnable var1) {
      if(var1 != null) {
         this.c.removeCallbacks(var1);
      }
   }

   public void b(Runnable var1, long var2) {
      if(var1 != null) {
         this.d.postDelayed(var1, var2);
      }
   }

   public PackageManager c() {
      return this.b.getPackageManager();
   }

   public void c(Runnable var1) {
      if(var1 != null) {
         this.d.post(var1);
      }
   }

   public void d(Runnable var1) {
      if(var1 != null) {
         this.d.removeCallbacks(var1);
      }
   }
}
