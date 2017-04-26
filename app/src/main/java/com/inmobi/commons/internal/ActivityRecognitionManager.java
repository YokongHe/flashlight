package com.inmobi.commons.internal;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;

public class ActivityRecognitionManager extends IntentService {
   static Object a = null;
   static Object b = null;
   static int c = -1;
   private static Object d = null;
   private static Object e = null;

   public ActivityRecognitionManager() {
      super("InMobi activity service");
   }

   private static void a(Context param0) {
      // $FF: Couldn't be decompiled
   }

   private void a(Intent var1) {
      try {
         Class var2 = Class.forName("com.google.android.gms.location.ActivityRecognitionResult");
         if(((Boolean)var2.getMethod("hasResult", new Class[]{Intent.class}).invoke((Object)null, new Object[]{var1})).booleanValue()) {
            Object var5 = var2.getMethod("extractResult", new Class[]{Intent.class}).invoke((Object)null, new Object[]{var1});
            a = var2.getMethod("getMostProbableActivity", (Class[])null).invoke(var5, (Object[])null);
         }

      } catch (ClassNotFoundException var3) {
         Log.internal("[InMobi]-4.5.2", "HandleIntent: Google play services not included. Cannot get current activity.");
      } catch (Exception var4) {
         Log.internal("[InMobi]-4.5.2", "HandleIntent: Google play services not included. Cannot get current activity.");
      }
   }

   private static boolean a() {
      if(VERSION.SDK_INT >= 8) {
         if(c == -1) {
            try {
               a = Class.forName("com.google.android.gms.location.DetectedActivity").getConstructor(new Class[]{Integer.TYPE, Integer.TYPE}).newInstance(new Object[]{Integer.valueOf(-1), Integer.valueOf(100)});
               c = 1;
               if(com.google.android.gms.common.g.a(InternalSDKUtil.getContext()) != 0) {
                  c = 0;
                  return false;
               }
            } catch (ClassNotFoundException var1) {
               Log.debug("[InMobi]-4.5.2", "Google play services not included.");
               c = 0;
            } catch (Exception var2) {
               Log.debug("[InMobi]-4.5.2", "Google play services not included.");
               c = 0;
            }
         }

         if(c == 1) {
            return true;
         }
      }

      return false;
   }

   public static int getDetectedActivity() {
      try {
         if(a == null) {
            return -1;
         } else {
            int var0 = ((Integer)Class.forName("com.google.android.gms.location.DetectedActivity").getMethod("getType", (Class[])null).invoke(a, (Object[])null)).intValue();
            return var0;
         }
      } catch (ClassNotFoundException var2) {
         Log.internal("[InMobi]-4.5.2", "getDetectedActivity: Google play services not included. Returning null.");
         return -1;
      } catch (Exception var3) {
         Log.internal("[InMobi]-4.5.2", "getDetectedActivity: Google play services not included. Returning null.");
         return -1;
      }
   }

   public static void init(Context var0) {
      if(a()) {
         a(var0);
      }

   }

   protected void onHandleIntent(Intent var1) {
      if(a()) {
         this.a(var1);
      }

   }
}
