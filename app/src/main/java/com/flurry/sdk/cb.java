package com.flurry.sdk;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.flurry.android.impl.ads.avro.protocol.v10.ScreenOrientationType;
import com.flurry.sdk.eo;

public final class cb {
   private static final String a = com.flurry.sdk.cb.class.getSimpleName();
   private static final SparseArray b = c();

   public static int a() {
      return 7;
   }

   public static int a(Activity var0, int var1, int var2) {
      if(var0 == null) {
         return -1;
      } else {
         SparseIntArray var3 = (SparseIntArray)b.get(var2);
         if(var3 != null) {
            var1 = var3.get(var1, -1);
         } else {
            var1 = -1;
         }

         return var1;
      }
   }

   public static int a(Activity var0, ScreenOrientationType var1) {
      byte var2 = 0;
      if(ScreenOrientationType.a.equals(var1)) {
         var2 = 1;
      } else if(ScreenOrientationType.b.equals(var1)) {
         var2 = 2;
      }

      return a(var0, -1, var2);
   }

   @TargetApi(13)
   public static int a(ActivityInfo var0) {
      int var1;
      if(var0 == null) {
         var1 = 0;
      } else {
         int var2 = var0.configChanges;
         var1 = var2;
         if(var0.applicationInfo.targetSdkVersion < 13) {
            return var2 | 3072;
         }
      }

      return var1;
   }

   public static ActivityInfo a(Activity var0) {
      return var0 == null?null:a(var0.getPackageManager(), var0.getComponentName());
   }

   public static ActivityInfo a(PackageManager var0, ComponentName var1) {
      if(var0 != null && var1 != null) {
         try {
            ActivityInfo var3 = var0.getActivityInfo(var1, 0);
            return var3;
         } catch (NameNotFoundException var2) {
            eo.a(5, a, "cannot find info for activity: " + var1);
            return null;
         }
      } else {
         return null;
      }
   }

   public static void a(Activity var0, int var1) {
      if(var0 == null) {
         eo.b(a, "Context is null. Cannot set requested orientation.");
      } else if(a((Context)var0)) {
         eo.b(a, "setRequestedOrientation SCREEN_ORIENTATION_SENSOR");
         var0.setRequestedOrientation(4);
      } else {
         eo.b(a, "setRequestedOrientation " + var1);
         var0.setRequestedOrientation(var1);
      }
   }

   public static boolean a(Activity var0, int var1, boolean var2) {
      boolean var4 = true;
      if(var0 == null) {
         var4 = false;
      } else {
         int var3 = var1;
         if(!b(var0)) {
            var3 = b(var0, var1);
            if(-1 == var3) {
               eo.a(5, a, "cannot set requested orientation without restarting activity, requestedOrientation = " + var1);
               eo.b(a, "cannot set requested orientation without restarting activity. It is recommended to add keyboardHidden|orientation|screenSize for android:configChanges attribute for activity: " + var0.getComponentName().getClassName());
               return false;
            }

            var2 = true;
         }

         var0.setRequestedOrientation(var3);
         if(!var2) {
            var0.setRequestedOrientation(-1);
            return true;
         }
      }

      return var4;
   }

   public static boolean a(Context var0) {
      boolean var1;
      if((var0.getResources().getConfiguration().screenLayout & 15) >= 3) {
         var1 = true;
      } else {
         var1 = false;
      }

      eo.b(a, "isTablet " + var1);
      return var1;
   }

   public static int b() {
      return 6;
   }

   public static int b(Activity var0, int var1) {
      return var0 == null?-1:a(var0, var1, var0.getResources().getConfiguration().orientation);
   }

   public static boolean b(Activity var0) {
      int var1 = a(a(var0));
      return (var1 & 128) != 0 && (var1 & 1024) != 0;
   }

   private static SparseArray c() {
      SparseArray var0 = new SparseArray();
      var0.put(1, d());
      var0.put(2, e());
      return var0;
   }

   private static SparseIntArray d() {
      int var0 = a();
      SparseIntArray var1 = new SparseIntArray();
      var1.put(-1, var0);
      var1.put(2, var0);
      var1.put(3, var0);
      var1.put(4, var0);
      var1.put(1, 1);
      var1.put(5, 5);
      var1.put(7, 7);
      var1.put(9, 9);
      var1.put(10, 7);
      return var1;
   }

   private static SparseIntArray e() {
      int var0 = b();
      SparseIntArray var1 = new SparseIntArray();
      var1.put(-1, var0);
      var1.put(2, var0);
      var1.put(3, var0);
      var1.put(4, var0);
      var1.put(0, 0);
      var1.put(5, 5);
      var1.put(6, 6);
      var1.put(8, 8);
      var1.put(10, 6);
      return var1;
   }
}
