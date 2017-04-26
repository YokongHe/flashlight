package com.ihs.app.push.impl;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.ihs.app.framework.HSApplication;
import java.util.HashMap;
import java.util.Map;

public final class a {
   private static long b = 0L;
   private static final com.ihs.app.push.impl.a c = new com.ihs.app.push.impl.a();
   public com.ihs.a.d.b a = new com.ihs.a.d.b();

   private a() {
      com.ihs.a.d.a.a("hs.app.session.SESSION_START", new com.ihs.a.d.d() {
         public final void a(String var1, com.ihs.a.e.e var2) {
            var1 = "";
            if(com.ihs.app.b.c.c()) {
               com.ihs.a.e.j.a(HSApplication.a()).b("hs.app.push.device_token_invalid", true);
            } else if(!com.ihs.a.e.j.a(HSApplication.a()).a("hs.app.push.device_token_invalid", false)) {
               var1 = com.ihs.app.push.impl.a.d();
            }

            if(TextUtils.isEmpty(var1)) {
               if(com.ihs.app.push.impl.a.b <= 0L) {
                  var1 = com.ihs.a.b.b.b(new String[]{"libFramework", "Push", "SenderID"});
                  if(!TextUtils.isEmpty(var1)) {
                     com.ihs.app.push.impl.a.b = System.currentTimeMillis();
                     if(com.ihs.app.push.impl.a.c()) {
                        com.ihs.app.push.impl.a.a(a.this, var1);
                        return;
                     }

                     com.ihs.app.push.impl.a.b(a.this, var1);
                     return;
                  }
               }

            } else {
               a.this.f();
            }
         }
      });
   }

   public static com.ihs.app.push.impl.a a() {
      return c;
   }

   static void a(Intent var0) {
      if(var0 != null) {
         Bundle var1 = var0.getExtras();
         if(var1 != null) {
            var1.toString();
            if(TextUtils.isEmpty(var1.getString("GCMType"))) {
               com.ihs.a.e.e var2 = new com.ihs.a.e.e();
               var2.a("MSG_INTENT", (Object)var0);
               com.ihs.a.d.a.a("hs.app.push.MSG_RECEIVED", var2);
               return;
            }

            com.ihs.app.a.b.a("HSPushAlert_Message_Received");
            com.ihs.app.alerts.impl.h.a(var1);
            return;
         }
      }

   }

   // $FF: synthetic method
   static void a(final com.ihs.app.push.impl.a var0, final String var1) {
      (new AsyncTask() {
         private Void a() {
            try {
               String var1x = com.google.android.gms.b.a.a(HSApplication.a()).a(new String[]{var1});
               var0.a(var1x);
               (new StringBuilder("DeviceTokenReceived: ")).append(var1x).toString();
            } catch (Exception var2) {
               var0.b(var2.getMessage());
               (new StringBuilder("DeviceTokenFailed: ")).append(var2.getMessage()).toString();
            }

            return null;
         }

         // $FF: synthetic method
         protected final Object doInBackground(Object[] var1x) {
            return this.a();
         }
      }).execute(new Void[0]);
   }

   public static void b() {
   }

   // $FF: synthetic method
   static void b(com.ihs.app.push.impl.a var0, String var1) {
      String var2 = var1;
      (new StringBuilder("Registering app ")).append(HSApplication.a().getPackageName()).append(" of senders ").append(var2).toString();
      Intent var3 = new Intent("com.google.android.c2dm.intent.REGISTER");
      var3.setPackage("com.google.android.gsf");
      var3.putExtra("app", PendingIntent.getBroadcast(HSApplication.a(), 0, new Intent(), 0));
      var3.putExtra("sender", var2);
      HSApplication.a().startService(var3);
   }

   public static boolean c() {
      return VERSION.SDK_INT >= 10 && com.google.android.gms.common.g.a(HSApplication.a()) == 0;
   }

   public static String d() {
      return com.ihs.a.e.j.a(HSApplication.a()).a("hs.app.push.device_token", "");
   }

   private void f() {
      final com.ihs.a.e.j var2 = com.ihs.a.e.j.a(HSApplication.a());
      final String var3 = var2.a("hs.app.push.device_token", "");
      if(!TextUtils.isEmpty(var3)) {
         final String var4 = var2.a("hs.app.push.device_token_server", "");
         if(!TextUtils.isEmpty(var3)) {
            final String var5 = com.ihs.app.b.c.f();
            final String var1 = var2.a("hs.app.push.device_token_server_version", "");
            if((!TextUtils.equals(var3, var4) || !TextUtils.equals(var5, var1)) && com.ihs.a.b.b.a(new String[]{"libFramework", "Push", "SendTokenToServer"})) {
               final String var6 = HSApplication.a().getPackageName();
               if(com.ihs.a.e.f.a()) {
                  var1 = "http://spark.ihandysoft.com:8080/MobileAppServlet/MobileAppServlet";
               } else if(var6.startsWith("com.ihandysoft.")) {
                  var1 = "http://kitty.ihandysoft.com/MobileAppServlet";
               } else if(var6.startsWith("com.moplus.")) {
                  var1 = "http://token.mopl.us/token";
               } else {
                  var1 = "http://api.asiatone.net/token";
               }

               (new Thread() {
                  public final void run() {
                     // $FF: Couldn't be decompiled
                  }
               }).start();
               return;
            }
         }
      }

   }

   final void a(String var1) {
      long var2 = System.currentTimeMillis();
      long var4 = b;
      b = 0L;
      HashMap var6 = new HashMap();
      var6.put("TimeUsed", (var2 - var4) / 1000L + "s");
      com.ihs.app.a.b.a("GCM_Get_Token_Time", (Map)var6);
      com.ihs.a.e.j var8 = com.ihs.a.e.j.a(HSApplication.a());
      if(!TextUtils.equals(var1, d())) {
         var8.b("hs.app.push.device_token", var1);
         com.ihs.a.e.e var7 = new com.ihs.a.e.e();
         var7.a("TOKEN_STRING", var1);
         this.a.b("hs.app.push.DEVICETOKEN_RECEIVED", var7);
      }

      var8.b("hs.app.push.device_token_invalid", false);
      this.f();
   }

   final void b(String var1) {
      b = 0L;
      HashMap var2 = new HashMap();
      var2.put("Error Msg", var1);
      com.ihs.app.a.b.a("GCM_Get_Token_Failed", (Map)var2);
      com.ihs.a.e.e var3 = new com.ihs.a.e.e();
      var3.a("ERROR_STRING", var1);
      this.a.b("hs.app.push.DEVICETOKEN_REQUEST_FAILED", var3);
   }
}
