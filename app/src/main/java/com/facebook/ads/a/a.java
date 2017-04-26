package com.facebook.ads.a;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Environment;
import android.os.StatFs;
import com.facebook.ads.a.a$a;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class a {
   private static SensorManager a = null;
   private static Sensor b = null;
   private static Sensor c = null;
   private static volatile float[] d;
   private static volatile float[] e;
   private static Map f = new ConcurrentHashMap();
   private static String[] g = new String[]{"x", "y", "z"};

   public static Map a() {
      HashMap var0 = new HashMap();
      var0.putAll(f);
      a((Map)var0);
      return var0;
   }

   public static void a(Context param0) {
      // $FF: Couldn't be decompiled
   }

   public static void a(a$a param0) {
      // $FF: Couldn't be decompiled
   }

   private static void a(Map var0) {
      byte var2 = 0;
      float[] var4 = d;
      float[] var5 = e;
      int var1;
      int var3;
      if(var4 != null) {
         var3 = Math.min(g.length, var4.length);

         for(var1 = 0; var1 < var3; ++var1) {
            var0.put("accelerometer_" + g[var1], Float.valueOf(var4[var1]));
         }
      }

      if(var5 != null) {
         var3 = Math.min(g.length, var5.length);

         for(var1 = var2; var1 < var3; ++var1) {
            var0.put("rotation_" + g[var1], Float.valueOf(var5[var1]));
         }
      }

   }

   // $FF: synthetic method
   static float[] a(float[] var0) {
      d = var0;
      return var0;
   }

   // $FF: synthetic method
   static Sensor b() {
      return b;
   }

   private static void b(Context var0) {
      MemoryInfo var1 = new MemoryInfo();
      ((ActivityManager)var0.getSystemService("activity")).getMemoryInfo(var1);
      f.put("available_memory", String.valueOf(var1.availMem));
   }

   // $FF: synthetic method
   static float[] b(float[] var0) {
      e = var0;
      return var0;
   }

   // $FF: synthetic method
   static Sensor c() {
      return c;
   }

   private static void c(Context var0) {
      StatFs var5 = new StatFs(Environment.getDataDirectory().getPath());
      long var1 = (long)var5.getBlockSize();
      long var3 = (long)var5.getAvailableBlocks();
      f.put("free_space", Long.valueOf(var3 * var1));
   }

   private static void d(Context var0) {
      Intent var5 = var0.registerReceiver((BroadcastReceiver)null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
      if(var5 != null) {
         int var3 = var5.getIntExtra("level", -1);
         int var4 = var5.getIntExtra("scale", -1);
         int var2 = var5.getIntExtra("status", -1);
         boolean var7;
         if(var2 != 2 && var2 != 5) {
            var7 = false;
         } else {
            var7 = true;
         }

         float var1 = 0.0F;
         if(var4 > 0) {
            var1 = (float)var3 / (float)var4 * 100.0F;
         }

         f.put("battery", Float.valueOf(var1));
         Map var6 = f;
         byte var8;
         if(var7) {
            var8 = 1;
         } else {
            var8 = 0;
         }

         var6.put("charging", Integer.valueOf(var8));
      }
   }
}
