package com.inmobi.commons.analytics.iat.impl.net;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.inmobi.commons.analytics.iat.impl.Goal;
import com.inmobi.commons.analytics.iat.impl.GoalList;
import com.inmobi.commons.analytics.iat.impl.config.AdTrackerInitializer;
import com.inmobi.commons.analytics.iat.impl.net.AdTrackerNetworkInterface$a;
import com.inmobi.commons.analytics.iat.impl.net.AdTrackerNetworkInterface$b;
import com.inmobi.commons.analytics.iat.impl.net.AdTrackerWebViewLoader;
import com.inmobi.commons.internal.FileOperations;
import com.inmobi.commons.internal.InternalSDKUtil;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;

public class AdTrackerNetworkInterface {
   private static GoalList a;
   private static AdTrackerWebViewLoader b;
   private static Handler c;
   private static HandlerThread d;
   private static AtomicBoolean e;
   private static int f = 0;
   private static boolean g = false;
   private static String h = "https://d.appsdt.com/download/tracker/?";
   private static String i = "https://d.appsdt.com/sdkdwnldbeacon.html";
   private static String j = "https://d.appsdt.com/download/tracker/iatsdkconfs?";
   private static Handler k;

   // $FF: synthetic method
   static int a(int var0) {
      f = var0;
      return var0;
   }

   // $FF: synthetic method
   static long a(Goal var0, boolean var1) {
      return b(var0, var1);
   }

   // $FF: synthetic method
   static Handler a(Handler var0) {
      k = var0;
      return var0;
   }

   // $FF: synthetic method
   static HandlerThread a(HandlerThread var0) {
      d = var0;
      return var0;
   }

   // $FF: synthetic method
   static GoalList a(GoalList var0) {
      a = var0;
      return var0;
   }

   // $FF: synthetic method
   static AdTrackerWebViewLoader a(AdTrackerWebViewLoader var0) {
      b = var0;
      return var0;
   }

   static String a() {
      return h;
   }

   // $FF: synthetic method
   static boolean a(boolean var0) {
      g = var0;
      return var0;
   }

   private static long b(Goal var0, boolean var1) {
      String var7 = var0.name;
      long var5 = var0.retryTime;
      int var2 = AdTrackerInitializer.getConfigParams().getRetryParams().getMaxWaitTime();
      long var3;
      if(var1) {
         var3 = 0L;
      } else {
         var3 = var5;
         if(var5 > (long)var2) {
            return (long)var2;
         }
      }

      return var3;
   }

   static String b() {
      return i;
   }

   static final Handler c() {
      return k;
   }

   // $FF: synthetic method
   static HandlerThread d() {
      return d;
   }

   // $FF: synthetic method
   static AtomicBoolean e() {
      return e;
   }

   // $FF: synthetic method
   static GoalList f() {
      return a;
   }

   // $FF: synthetic method
   static boolean g() {
      return p();
   }

   public static GoalList getGoalList() {
      return a;
   }

   public static Handler getUIHandler() {
      return c;
   }

   // $FF: synthetic method
   static boolean h() {
      return o();
   }

   // $FF: synthetic method
   static boolean i() {
      return n();
   }

   public static void init() {
      if(e == null) {
         e = new AtomicBoolean(false);
      }

      if(a == null) {
         a = GoalList.getLoggedGoals();
      }

      if(c == null) {
         c = new AdTrackerNetworkInterface$b();
      }

      if(d == null) {
         HandlerThread var0 = new HandlerThread("AdTrackerNetworkHandler");
         d = var0;
         var0.start();
      }

      if(k == null) {
         k = new AdTrackerNetworkInterface$a(d.getLooper());
      }

   }

   public static boolean isMetricSample() {
      return g;
   }

   public static int isUnstableNetwork() {
      return f;
   }

   // $FF: synthetic method
   static AdTrackerWebViewLoader j() {
      return b;
   }

   // $FF: synthetic method
   static boolean k() {
      return m();
   }

   // $FF: synthetic method
   static Handler l() {
      return c;
   }

   private static boolean m() {
      String var0 = FileOperations.getPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "timetoLive");
      String var2 = FileOperations.getPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "iat_ids");
      Calendar var1 = Calendar.getInstance();
      var1.setTime(new Date());
      var1.getTime().toString();
      if(var0 != null && var2 != null) {
         Date var3 = var1.getTime();
         var1.add(11, Integer.parseInt(var0));
         if(var1.getTime().after(var3)) {
            return true;
         }
      }

      return false;
   }

   private static boolean n() {
      return FileOperations.getPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "referrer") != null;
   }

   private static boolean o() {
      // $FF: Couldn't be decompiled
   }

   public static void onReceiveReferrer(String var0) {
      Message var1 = Message.obtain();
      if(c() != null && c().hasMessages(3)) {
         Message var2 = c().obtainMessage(3);
         var1.what = 4;
         var1.arg1 = var2.arg1;
         var1.obj = var0;
         c().removeMessages(3);
         c().sendMessage(var1);
      }

   }

   private static boolean p() {
      return FileOperations.getBooleanPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "waitForReferrer");
   }

   public static void reportToServer(String param0) {
      // $FF: Couldn't be decompiled
   }
}
