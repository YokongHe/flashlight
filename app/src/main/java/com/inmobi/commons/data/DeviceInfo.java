package com.inmobi.commons.data;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.inmobi.commons.data.DeviceInfo$a;
import com.inmobi.commons.internal.FileOperations;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import java.lang.reflect.Method;
import java.util.UUID;

public class DeviceInfo {
   private static String a;
   private static String b;
   private static String c;
   private static String d = null;
   private static String e = null;
   private static String f;
   private static String g;
   private static DeviceInfo$a h;

   static {
      h = DeviceInfo$a.a;
   }

   private static String a() {
      return c;
   }

   private static void a(Context var0) {
      try {
         if(f == null) {
            f = FileOperations.getPreferences(var0, "impref", "AID");
         }

         if(f == null) {
            f = UUID.randomUUID().toString();
            FileOperations.setPreferences(var0, "impref", "AID", f);
         }

      } catch (Exception var1) {
         ;
      }
   }

   private static void a(DeviceInfo$a var0) {
      h = var0;
   }

   private static void a(String var0) {
      a = var0;
   }

   private static void b(String var0) {
      b = var0;
   }

   private static void c(String var0) {
      c = var0;
   }

   public static String getAid() {
      return f;
   }

   public static int getDisplayRotation(Display var0) {
      Method var2 = null;

      label31: {
         Method var3;
         try {
            var3 = Display.class.getMethod("getRotation", (Class[])null);
         } catch (NoSuchMethodException var6) {
            try {
               var3 = Display.class.getMethod("getOrientation", (Class[])null);
            } catch (NoSuchMethodException var5) {
               Log.internal("[InMobi]-4.5.2", "Unable to access getOrientation method via reflection");
               break label31;
            }

            var2 = var3;
            break label31;
         }

         var2 = var3;
      }

      if(var2 != null) {
         try {
            int var1 = ((Integer)var2.invoke(var0, (Object[])null)).intValue();
            return var1;
         } catch (Exception var4) {
            Log.internal("[InMobi]-4.5.2", "Unable to access display rotation");
         }
      }

      return -999;
   }

   public static String getLocalization() {
      return b;
   }

   public static String getNetworkType() {
      return a;
   }

   public static int getOrientation() {
      return DeviceInfo$a.a(h);
   }

   public static String getPhoneDefaultUserAgent() {
      return g == null?"":g;
   }

   public static String getScreenDensity() {
      return e;
   }

   public static String getScreenSize() {
      return d;
   }

   public static boolean isDefOrientationLandscape(int var0, int var1, int var2) {
      return var1 > var2 && (var0 == 0 || var0 == 2) || var1 < var2 && (var0 == 1 || var0 == 3);
   }

   public static boolean isTablet(Context var0) {
      Display var6 = ((WindowManager)var0.getSystemService("window")).getDefaultDisplay();
      DisplayMetrics var5 = new DisplayMetrics();
      var6.getMetrics(var5);
      double var1 = (double)((float)var5.widthPixels / var5.xdpi);
      double var3 = (double)((float)var5.heightPixels / var5.ydpi);
      return Math.sqrt(var3 * var3 + var1 * var1) > 7.0D;
   }

   public static void setPhoneDefaultUserAgent(String var0) {
      g = var0;
   }

   public static void setScreenDensity(String var0) {
      e = var0;
   }

   public static void setScreenSize(String var0) {
      d = var0;
   }

   public static void updateDeviceInfo() {
      // $FF: Couldn't be decompiled
   }

   public static void updateDeviceOrientation() {
      // $FF: Couldn't be decompiled
   }

   public static void updateNetworkConnectedInfo() {
      a = InternalSDKUtil.getConnectivityType(InternalSDKUtil.getContext());
   }
}
