package com.flurry.android;

import android.content.Context;
import android.location.Criteria;
import android.os.Build.VERSION;
import com.flurry.sdk.dl;
import com.flurry.sdk.dn;
import com.flurry.sdk.dp;
import com.flurry.sdk.dz;
import com.flurry.sdk.eo;
import com.flurry.sdk.fe;
import java.util.Date;
import java.util.Map;

public final class FlurryAgent {
   private static final String a = FlurryAgent.class.getSimpleName();

   public static void addOrigin(String var0, String var1) {
      addOrigin(var0, var1, (Map)null);
   }

   public static void addOrigin(String var0, String var1, Map var2) {
      if(VERSION.SDK_INT < 10) {
         eo.b(a, "Device SDK Version older than 10");
      } else if(var0 != null && var0.length() != 0) {
         if(var1 != null && var1.length() != 0) {
            try {
               com.flurry.sdk.cx.a().a(var0, var1, var2);
            } catch (Throwable var3) {
               eo.a(a, "", var3);
            }
         } else {
            throw new IllegalArgumentException("originVersion not specified");
         }
      } else {
         throw new IllegalArgumentException("originName not specified");
      }
   }

   public static void clearLocation() {
      if(VERSION.SDK_INT < 10) {
         eo.b(a, "Device SDK Version older than 10");
      } else {
         dz.a().e();
      }
   }

   public static void endTimedEvent(String var0) {
      if(VERSION.SDK_INT < 10) {
         eo.b(a, "Device SDK Version older than 10");
      } else if(var0 == null) {
         eo.b(a, "String eventId passed to endTimedEvent was null.");
      } else {
         try {
            com.flurry.sdk.cx.a().b(var0);
         } catch (Throwable var2) {
            eo.a(a, "Failed to signify the end of event: " + var0, var2);
         }
      }
   }

   public static void endTimedEvent(String var0, Map var1) {
      if(VERSION.SDK_INT < 10) {
         eo.b(a, "Device SDK Version older than 10");
      } else if(var0 == null) {
         eo.b(a, "String eventId passed to endTimedEvent was null.");
      } else if(var1 == null) {
         eo.b(a, "String eventId passed to endTimedEvent was null.");
      } else {
         try {
            com.flurry.sdk.cx.a().b(var0, var1);
         } catch (Throwable var2) {
            eo.a(a, "Failed to signify the end of event: " + var0, var2);
         }
      }
   }

   public static int getAgentVersion() {
      return dn.a().b();
   }

   public static String getReleaseVersion() {
      return dn.a().g();
   }

   public static boolean getUseHttps() {
      if(VERSION.SDK_INT < 10) {
         eo.b(a, "Device SDK Version older than 10");
         return false;
      } else {
         return ((Boolean)dp.a().a("UseHttps")).booleanValue();
      }
   }

   public static void logEvent(String var0) {
      if(VERSION.SDK_INT < 10) {
         eo.b(a, "Device SDK Version older than 10");
      } else if(var0 == null) {
         eo.b(a, "String eventId passed to logEvent was null.");
      } else {
         try {
            com.flurry.sdk.cx.a().a(var0);
         } catch (Throwable var2) {
            eo.a(a, "Failed to log event: " + var0, var2);
         }
      }
   }

   public static void logEvent(String var0, Map var1) {
      if(VERSION.SDK_INT < 10) {
         eo.b(a, "Device SDK Version older than 10");
      } else if(var0 == null) {
         eo.b(a, "String eventId passed to logEvent was null.");
      } else if(var1 == null) {
         eo.b(a, "String parameters passed to logEvent was null.");
      } else {
         try {
            com.flurry.sdk.cx.a().a(var0, var1);
         } catch (Throwable var2) {
            eo.a(a, "Failed to log event: " + var0, var2);
         }
      }
   }

   public static void logEvent(String var0, Map var1, boolean var2) {
      if(VERSION.SDK_INT < 10) {
         eo.b(a, "Device SDK Version older than 10");
      } else if(var0 == null) {
         eo.b(a, "String eventId passed to logEvent was null.");
      } else if(var1 == null) {
         eo.b(a, "String parameters passed to logEvent was null.");
      } else {
         try {
            com.flurry.sdk.cx.a().a(var0, var1, var2);
         } catch (Throwable var3) {
            eo.a(a, "Failed to log event: " + var0, var3);
         }
      }
   }

   public static void logEvent(String var0, boolean var1) {
      if(VERSION.SDK_INT < 10) {
         eo.b(a, "Device SDK Version older than 10");
      } else if(var0 == null) {
         eo.b(a, "String eventId passed to logEvent was null.");
      } else {
         try {
            com.flurry.sdk.cx.a().a(var0, var1);
         } catch (Throwable var3) {
            eo.a(a, "Failed to log event: " + var0, var3);
         }
      }
   }

   public static void onEndSession(Context var0) {
      if(VERSION.SDK_INT < 10) {
         eo.b(a, "Device SDK Version older than 10");
      } else if(var0 == null) {
         throw new NullPointerException("Null context");
      } else {
         try {
            dl.a().a(var0);
         } catch (Throwable var1) {
            eo.a(a, "", var1);
         }
      }
   }

   @Deprecated
   public static void onError(String var0, String var1, String var2) {
      if(VERSION.SDK_INT < 10) {
         eo.b(a, "Device SDK Version older than 10");
      } else if(var0 == null) {
         eo.b(a, "String errorId passed to onError was null.");
      } else if(var1 == null) {
         eo.b(a, "String message passed to onError was null.");
      } else if(var2 == null) {
         eo.b(a, "String errorClass passed to onError was null.");
      } else {
         try {
            com.flurry.sdk.cx.a().a(var0, var1, var2);
         } catch (Throwable var3) {
            eo.a(a, "", var3);
         }
      }
   }

   public static void onError(String var0, String var1, Throwable var2) {
      if(VERSION.SDK_INT < 10) {
         eo.b(a, "Device SDK Version older than 10");
      } else if(var0 == null) {
         eo.b(a, "String errorId passed to onError was null.");
      } else if(var1 == null) {
         eo.b(a, "String message passed to onError was null.");
      } else if(var2 == null) {
         eo.b(a, "Throwable passed to onError was null.");
      } else {
         try {
            com.flurry.sdk.cx.a().a(var0, var1, var2);
         } catch (Throwable var3) {
            eo.a(a, "", var3);
         }
      }
   }

   @Deprecated
   public static void onEvent(String var0) {
      if(VERSION.SDK_INT < 10) {
         eo.b(a, "Device SDK Version older than 10");
      } else if(var0 == null) {
         eo.b(a, "String eventId passed to onEvent was null.");
      } else {
         try {
            com.flurry.sdk.cx.a().c(var0);
         } catch (Throwable var1) {
            eo.a(a, "", var1);
         }
      }
   }

   @Deprecated
   public static void onEvent(String var0, Map var1) {
      if(VERSION.SDK_INT < 10) {
         eo.b(a, "Device SDK Version older than 10");
      } else if(var0 == null) {
         eo.b(a, "String eventId passed to onEvent was null.");
      } else if(var1 == null) {
         eo.b(a, "Parameters Map passed to onEvent was null.");
      } else {
         try {
            com.flurry.sdk.cx.a().c(var0, var1);
         } catch (Throwable var2) {
            eo.a(a, "", var2);
         }
      }
   }

   public static void onPageView() {
      if(VERSION.SDK_INT < 10) {
         eo.b(a, "Device SDK Version older than 10");
      } else {
         try {
            com.flurry.sdk.cx.a().c();
         } catch (Throwable var1) {
            eo.a(a, "", var1);
         }
      }
   }

   public static void onStartSession(Context var0, String var1) {
      if(VERSION.SDK_INT < 10) {
         eo.b(a, "Device SDK Version older than 10");
      } else if(var0 == null) {
         throw new NullPointerException("Null context");
      } else if(var1 != null && var1.length() != 0) {
         try {
            dl.a().a(var0, var1);
         } catch (Throwable var2) {
            eo.a(a, "", var2);
         }
      } else {
         throw new IllegalArgumentException("Api key not specified");
      }
   }

   public static void setAge(int var0) {
      if(VERSION.SDK_INT < 10) {
         eo.b(a, "Device SDK Version older than 10");
      } else if(var0 > 0 && var0 < 110) {
         long var1 = (new Date((new Date(System.currentTimeMillis() - (long)var0 * 31449600000L)).getYear(), 1, 1)).getTime();
         dp.a().a((String)"Age", (Object)Long.valueOf(var1));
         return;
      }

   }

   public static void setCaptureUncaughtExceptions(boolean var0) {
      if(VERSION.SDK_INT < 10) {
         eo.b(a, "Device SDK Version older than 10");
      } else {
         dp.a().a((String)"CaptureUncaughtExceptions", (Object)Boolean.valueOf(var0));
      }
   }

   public static void setContinueSessionMillis(long var0) {
      if(VERSION.SDK_INT < 10) {
         eo.b(a, "Device SDK Version older than 10");
      } else if(var0 < 5000L) {
         eo.b(a, "Invalid time set for session resumption: " + var0);
      } else {
         dp.a().a((String)"ContinueSessionMillis", (Object)Long.valueOf(var0));
      }
   }

   public static void setGender(byte var0) {
      if(VERSION.SDK_INT < 10) {
         eo.b(a, "Device SDK Version older than 10");
      } else {
         switch(var0) {
         case 0:
         case 1:
            dp.a().a((String)"Gender", (Object)Byte.valueOf(var0));
            return;
         default:
            dp.a().a((String)"Gender", (Object)Byte.valueOf((byte)-1));
         }
      }
   }

   public static void setLocation(float var0, float var1) {
      if(VERSION.SDK_INT < 10) {
         eo.b(a, "Device SDK Version older than 10");
      } else {
         dz.a().a(var0, var1);
      }
   }

   public static void setLocationCriteria(Criteria var0) {
      if(VERSION.SDK_INT < 10) {
         eo.b(a, "Device SDK Version older than 10");
      } else {
         dp.a().a((String)"LocationCriteria", (Object)var0);
      }
   }

   public static void setLogEnabled(boolean var0) {
      if(VERSION.SDK_INT < 10) {
         eo.b(a, "Device SDK Version older than 10");
      } else if(var0) {
         eo.b();
      } else {
         eo.a();
      }
   }

   public static void setLogEvents(boolean var0) {
      if(VERSION.SDK_INT < 10) {
         eo.b(a, "Device SDK Version older than 10");
      } else {
         dp.a().a((String)"LogEvents", (Object)Boolean.valueOf(var0));
      }
   }

   public static void setLogLevel(int var0) {
      if(VERSION.SDK_INT < 10) {
         eo.b(a, "Device SDK Version older than 10");
      } else {
         eo.a(var0);
      }
   }

   public static void setReportLocation(boolean var0) {
      if(VERSION.SDK_INT < 10) {
         eo.b(a, "Device SDK Version older than 10");
      } else {
         dp.a().a((String)"ReportLocation", (Object)Boolean.valueOf(var0));
      }
   }

   public static void setReportUrl(String var0) {
      if(VERSION.SDK_INT < 10) {
         eo.b(a, "Device SDK Version older than 10");
      } else {
         dp.a().a((String)"ReportUrl", (Object)var0);
      }
   }

   public static void setUseHttps(boolean var0) {
      if(VERSION.SDK_INT < 10) {
         eo.b(a, "Device SDK Version older than 10");
      } else {
         dp.a().a((String)"UseHttps", (Object)Boolean.valueOf(var0));
      }
   }

   public static void setUserId(String var0) {
      if(VERSION.SDK_INT < 10) {
         eo.b(a, "Device SDK Version older than 10");
      } else if(var0 == null) {
         eo.b(a, "String userId passed to setUserId was null.");
      } else {
         dp.a().a((String)"UserId", (Object)fe.a(var0));
      }
   }

   public static void setVersionName(String var0) {
      if(VERSION.SDK_INT < 10) {
         eo.b(a, "Device SDK Version older than 10");
      } else if(var0 == null) {
         eo.b(a, "String versionName passed to setVersionName was null.");
      } else {
         dp.a().a((String)"VersionName", (Object)var0);
      }
   }
}
