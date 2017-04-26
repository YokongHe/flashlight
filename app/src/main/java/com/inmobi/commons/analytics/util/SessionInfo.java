package com.inmobi.commons.analytics.util;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import com.inmobi.commons.internal.Log;
import java.util.UUID;

public class SessionInfo {
   private static String a;
   private static long b;
   private static String c;
   private static int d;

   public static String getAppId(Context var0) {
      try {
         if(c != null) {
            return c;
         } else {
            String var2 = var0.getSharedPreferences("inmobiAppAnalyticsAppId", 0).getString("APP_ID", (String)null);
            c = var2;
            return var2;
         }
      } catch (Exception var1) {
         Log.internal("[InMobi]-4.5.2", "Exception getting app id", var1);
         return null;
      }
   }

   public static int getFirstTime() {
      synchronized(SessionInfo.class){}

      int var0;
      try {
         var0 = d;
      } finally {
         ;
      }

      return var0;
   }

   public static String getSessionId(Context var0) {
      synchronized(SessionInfo.class){}
      boolean var3 = false;

      String var6;
      label48: {
         try {
            var3 = true;
            if(a != null) {
               var6 = a;
               var3 = false;
            } else {
               var6 = var0.getSharedPreferences("inmobiAppAnalyticsSession", 0).getString("SESSION_ID", (String)null);
               a = var6;
               var3 = false;
            }
            break label48;
         } catch (Exception var4) {
            Log.internal("[InMobi]-4.5.2", "Exception getting session id", var4);
            var3 = false;
         } finally {
            if(var3) {
               ;
            }
         }

         var6 = null;
      }

      return var6;
   }

   public static long getSessionTime(Context var0) {
      synchronized(SessionInfo.class){}
      boolean var5 = false;

      long var1;
      label48: {
         try {
            var5 = true;
            if(b != 0L) {
               var1 = b;
               var5 = false;
            } else {
               var1 = var0.getSharedPreferences("inmobiAppAnalyticsSession", 0).getLong("SESSION_TIME", 0L);
               b = var1;
               var5 = false;
            }
            break label48;
         } catch (Exception var6) {
            Log.internal("[InMobi]-4.5.2", "Exception getting session time", var6);
            var5 = false;
         } finally {
            if(var5) {
               ;
            }
         }

         var1 = 0L;
      }

      return var1;
   }

   public static boolean isUpdatedFromOldSDK(Context var0) {
      synchronized(SessionInfo.class){}

      boolean var1;
      try {
         var1 = var0.getSharedPreferences("inmobiAppAnalyticsSession", 0).getBoolean("UPDATED_FROM_OLD_SDK", false);
      } finally {
         ;
      }

      return var1;
   }

   public static void removeSessionId(Context var0) {
      synchronized(SessionInfo.class){}

      try {
         a = null;
         b = 0L;
         Editor var5 = var0.getSharedPreferences("inmobiAppAnalyticsSession", 0).edit();
         var5.putString("SESSION_ID", (String)null);
         var5.putString("SESSION_TIME", (String)null);
         var5.commit();
      } catch (Exception var3) {
         Log.internal("[InMobi]-4.5.2", "Exception removing session id", var3);
      } finally {
         ;
      }

   }

   public static void resetFirstTime() {
      synchronized(SessionInfo.class){}

      try {
         d = 0;
      } finally {
         ;
      }

   }

   public static void storeAppId(Context var0, String var1) {
      try {
         c = var1;
         Editor var3 = var0.getSharedPreferences("inmobiAppAnalyticsAppId", 0).edit();
         var3.putString("APP_ID", var1);
         var3.commit();
      } catch (Exception var2) {
         Log.internal("[InMobi]-4.5.2", "Exception storing app id", var2);
      }
   }

   public static void storeFirstTime(Context param0) {
      // $FF: Couldn't be decompiled
   }

   public static void storeSessionId(Context var0) {
      synchronized(SessionInfo.class){}

      try {
         a = UUID.randomUUID().toString();
         b = System.currentTimeMillis() / 1000L;
         Editor var5 = var0.getSharedPreferences("inmobiAppAnalyticsSession", 0).edit();
         var5.putString("SESSION_ID", a);
         var5.putString("APP_SESSION_ID", a);
         var5.putLong("SESSION_TIME", b);
         var5.commit();
      } catch (Exception var3) {
         Log.internal("[InMobi]-4.5.2", "Exception putting session id", var3);
      } finally {
         ;
      }

   }

   public static void updatedFromOldSDK(Context var0) {
      synchronized(SessionInfo.class){}

      try {
         Editor var3 = var0.getSharedPreferences("inmobiAppAnalyticsSession", 0).edit();
         var3.putBoolean("UPDATED_FROM_OLD_SDK", true);
         var3.commit();
      } finally {
         ;
      }

   }
}
