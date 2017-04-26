package com.inmobi.commons.thinICE.wifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.net.wifi.WifiManager.WifiLock;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.inmobi.commons.thinICE.wifi.WifiScanListener;

public final class WifiScanner {
   private static Context a = null;
   private static WifiScanListener b = null;
   private static Handler c = null;
   private static boolean d = false;
   private static Runnable e = new Runnable() {
      public final void run() {
         WifiScanListener var1 = WifiScanner.b;
         WifiScanner.d();
         if(var1 != null) {
            var1.onTimeout();
         }

      }
   };
   private static boolean f = false;
   private static final BroadcastReceiver g = new BroadcastReceiver() {
      public final void onReceive(Context param1, Intent param2) {
         // $FF: Couldn't be decompiled
      }
   };
   private static final IntentFilter h = new IntentFilter("android.net.wifi.SCAN_RESULTS");
   private static WakeLock i = null;
   private static WifiLock j = null;

   // $FF: synthetic method
   static Context c() {
      return a;
   }

   private static void d() {
      // $FF: Couldn't be decompiled
   }

   private static void e() {
      if(!f) {
         f = true;
         a.registerReceiver(g, h, (String)null, c);
      }
   }

   private static void f() {
      if(f) {
         f = false;

         try {
            a.unregisterReceiver(g);
         } catch (IllegalArgumentException var1) {
            ;
         }
      }
   }

   private static void g() {
      if(i == null) {
         WakeLock var0 = ((PowerManager)a.getSystemService("power")).newWakeLock(1, "wifiscanrequester.CpuLock");
         i = var0;
         var0.setReferenceCounted(false);
      }

      if(!i.isHeld()) {
         i.acquire();
      }

   }

   private static void h() {
      if(i != null) {
         if(i.isHeld()) {
            i.release();
         }

         i = null;
      }

   }

   private static void i() {
      if(j == null) {
         WifiLock var0 = ((WifiManager)a.getSystemService("wifi")).createWifiLock(2, "wifiscanrequester.WiFiScanLock");
         j = var0;
         var0.setReferenceCounted(false);
      }

      if(!j.isHeld()) {
         j.acquire();
      }

   }

   private static void j() {
      if(j != null) {
         if(j.isHeld()) {
            j.release();
         }

         j = null;
      }

   }

   public static boolean requestScan(Context var0, WifiScanListener var1) {
      return requestScan(Looper.myLooper(), var0, var1, 10000L, false);
   }

   public static boolean requestScan(Looper param0, Context param1, WifiScanListener param2, long param3, boolean param5) {
      // $FF: Couldn't be decompiled
   }
}
