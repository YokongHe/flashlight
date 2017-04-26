package com.flurry.sdk;

import com.flurry.android.FlurryAgent;
import com.flurry.sdk.dj;
import com.flurry.sdk.dl;
import com.flurry.sdk.dp;
import com.flurry.sdk.dq;
import com.flurry.sdk.dq$a;
import com.flurry.sdk.dz;
import com.flurry.sdk.eb;
import com.flurry.sdk.ec;
import com.flurry.sdk.eo;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.HashMap;
import java.util.Map;

public class cx implements dq$a, UncaughtExceptionHandler {
   private static final String a = com.flurry.sdk.cx.class.getSimpleName();
   private static com.flurry.sdk.cx b;
   private final HashMap c = new HashMap();
   private boolean d;

   private cx() {
      ec.a().a(this);
      this.d();
   }

   public static com.flurry.sdk.cx a() {
      synchronized(com.flurry.sdk.cx.class){}

      com.flurry.sdk.cx var0;
      try {
         if(b == null) {
            b = new com.flurry.sdk.cx();
         }

         var0 = b;
      } finally {
         ;
      }

      return var0;
   }

   private void d() {
      dq var1 = dp.a();
      this.d = ((Boolean)var1.a("CaptureUncaughtExceptions")).booleanValue();
      var1.a((String)"CaptureUncaughtExceptions", (dq$a)this);
      eo.a(4, a, "initSettings, CrashReportingEnabled = " + this.d);
      String var2 = (String)var1.a("VersionName");
      var1.a((String)"VersionName", (dq$a)this);
      eb.a(var2);
      eo.a(4, a, "initSettings, VersionName = " + var2);
   }

   public void a(String var1) {
      dj var2 = dl.a().c();
      if(var2 != null) {
         var2.a(var1, (Map)null, false);
      }

   }

   public void a(String var1, Object var2) {
      if(var1.equals("CaptureUncaughtExceptions")) {
         this.d = ((Boolean)var2).booleanValue();
         eo.a(4, a, "onSettingUpdate, CrashReportingEnabled = " + this.d);
      } else if(var1.equals("VersionName")) {
         var1 = (String)var2;
         eb.a(var1);
         eo.a(4, a, "onSettingUpdate, VersionName = " + var1);
      } else {
         eo.a(6, a, "onSettingUpdate internal error!");
      }
   }

   @Deprecated
   public void a(String var1, String var2, String var3) {
      StackTraceElement[] var4 = Thread.currentThread().getStackTrace();
      if(var4 != null && var4.length > 2) {
         StackTraceElement[] var5 = new StackTraceElement[var4.length - 2];
         System.arraycopy(var4, 2, var5, 0, var5.length);
         var4 = var5;
      }

      Throwable var7 = new Throwable(var2);
      var7.setStackTrace(var4);
      dj var6 = dl.a().c();
      if(var6 != null) {
         var6.a(var1, var2, var3, var7);
      }

   }

   public void a(String var1, String var2, Throwable var3) {
      dj var4 = dl.a().c();
      if(var4 != null) {
         var4.a(var1, var2, var3.getClass().getName(), var3);
      }

   }

   public void a(String var1, String var2, Map var3) {
      Object var4 = var3;
      if(var3 == null) {
         var4 = new HashMap();
      }

      if(((Map)var4).size() >= 10) {
         eo.d(a, "MaxOriginParams exceeded: " + ((Map)var4).size());
      } else {
         ((Map)var4).put("flurryOriginVersion", var2);
         HashMap var6 = this.c;
         synchronized(var6) {
            if(this.c.size() >= 10 && !this.c.containsKey(var1)) {
               eo.d(a, "MaxOrigins exceeded: " + this.c.size());
            } else {
               this.c.put(var1, var4);
            }
         }
      }
   }

   public void a(String var1, Map var2) {
      dj var3 = dl.a().c();
      if(var3 != null) {
         var3.a(var1, var2, false);
      }

   }

   public void a(String var1, Map var2, boolean var3) {
      dj var4 = dl.a().c();
      if(var4 != null) {
         var4.a(var1, var2, var3);
      }

   }

   public void a(String var1, boolean var2) {
      dj var3 = dl.a().c();
      if(var3 != null) {
         var3.a(var1, (Map)null, var2);
      }

   }

   public void a(boolean var1) {
      eo.a(var1);
   }

   public HashMap b() {
      HashMap var1 = this.c;
      synchronized(var1) {
         HashMap var2 = new HashMap(this.c);
         return var2;
      }
   }

   public void b(String var1) {
      dj var2 = dl.a().c();
      if(var2 != null) {
         var2.a((String)var1, (Map)null);
      }

   }

   public void b(String var1, Map var2) {
      dj var3 = dl.a().c();
      if(var3 != null) {
         var3.a(var1, var2);
      }

   }

   public void c() {
      dj var1 = dl.a().c();
      if(var1 != null) {
         var1.e();
      }

   }

   public void c(String var1) {
      dj var2 = dl.a().c();
      if(var2 != null) {
         var2.a(var1, (Map)null, false);
      }

   }

   public void c(String var1, Map var2) {
      dj var3 = dl.a().c();
      if(var3 != null) {
         var3.a(var1, var2, false);
      }

   }

   public void uncaughtException(Thread var1, Throwable var2) {
      var2.printStackTrace();
      if(this.d) {
         String var4 = "";
         StackTraceElement[] var3 = var2.getStackTrace();
         if(var3 != null && var3.length > 0) {
            StringBuilder var5 = new StringBuilder();
            if(var2.getMessage() != null) {
               var5.append(" (" + var2.getMessage() + ")\n");
            }

            var4 = var5.toString();
         } else if(var2.getMessage() != null) {
            var4 = var2.getMessage();
         }

         FlurryAgent.onError("uncaught", var4, var2);
      }

      dl.a().d();
      dz.a().g();
   }
}
