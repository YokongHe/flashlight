package com.tapjoy.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import java.sql.Timestamp;

public abstract class r extends com.tapjoy.internal.s {
   public final Context a;
   public final com.tapjoy.internal.t b;
   private boolean c = false;

   public r(Context var1, com.tapjoy.internal.t var2) {
      this.a = var1.getApplicationContext();
      this.b = var2;
   }

   private void a(Context var1) {
      this.b.b(var1, 3000);
   }

   private static void b(Context var0, Intent var1) {
      var1.putExtra("app", PendingIntent.getBroadcast(var0, 0, new Intent(), 0));
   }

   private boolean b() {
      boolean var1 = this.b.e(this.a);
      if(var1) {
         long var2 = this.b.f(this.a);
         if(var2 != 0L && System.currentTimeMillis() > var2) {
            new Timestamp(var2);
            return false;
         }
      }

      return var1;
   }

   private static boolean b(Context param0, String param1) {
      // $FF: Couldn't be decompiled
   }

   private static boolean c(Context var0, String var1) {
      ComponentName var4;
      try {
         com.tapjoy.internal.af.b(var0.getPackageManager(), "com.google.android.gsf");
         Intent var2 = new Intent("com.google.android.c2dm.intent.REGISTER");
         var2.setPackage("com.google.android.gsf");
         b(var0, var2);
         var2.putExtra("sender", var1);
         var4 = var0.startService(var2);
      } catch (RuntimeException var3) {
         return false;
      }

      return var4 != null;
   }

   private void d(String var1) {
      String var4 = this.b.b(this.a);
      if(var4.length() == 0) {
         this.e(var1);
      } else if(!var1.equals(this.b.a(this.a))) {
         this.e(var1);
      } else {
         int var2 = this.b.d(this.a);
         int var3 = com.tapjoy.internal.af.a(this.a);
         if(var2 != Integer.MIN_VALUE && var2 != var3) {
            this.e(var1);
         } else if(this.b.c(this.a)) {
            this.e(var1);
         } else if(!this.b()) {
            this.a(this.a, var4);
         }
      }
   }

   private void e(String var1) {
      this.b.a(this.a, var1);
      this.b.a(this.a, true);
      if(!this.c && b(this.a, var1) || !c(this.a, var1)) {
         ;
      }
   }

   private void f(String var1) {
      synchronized(this){}

      try {
         this.a(this.a);
         this.b.a(this.a, false);
         int var2 = com.tapjoy.internal.af.a(this.a);
         this.b.a(this.a, var2);
         if(!var1.equals(this.b.b(this.a))) {
            this.b.b(this.a, false);
            this.b.b(this.a, var1);
            this.a(this.a, var1);
         } else if(!this.b()) {
            this.a(this.a, var1);
         }
      } finally {
         ;
      }

   }

   public final void a(String... var1) {
      int var2 = 1;
      this.a(this.a);
      if(var1 != null && var1.length != 0) {
         String var4;
         if(var1.length == 1) {
            var4 = var1[0];
         } else {
            StringBuilder var3;
            for(var3 = new StringBuilder(var1[0]); var2 < var1.length; ++var2) {
               var3.append(',').append(var1[var2]);
            }

            var4 = var3.toString();
         }

         this.d(var4);
      } else {
         throw new IllegalArgumentException("No senderIds");
      }
   }

   public final boolean a() {
      String var1 = this.b.a(this.a);
      if(!com.tapjoy.internal.cv.c(var1)) {
         this.d(var1);
         return true;
      } else {
         return false;
      }
   }

   public final boolean a(Intent var1) {
      String var4 = var1.getAction();
      int var2;
      String var7;
      if("com.google.android.c2dm.intent.REGISTRATION".equals(var4)) {
         var4 = var1.getStringExtra("registration_id");
         String var5 = var1.getStringExtra("unregistered");
         var7 = var1.getStringExtra("error");
         if(var4 != null) {
            if(var4.length() > 0) {
               this.f(var4);
               return false;
            }

            if(var5 == null && var7 == null && !this.c) {
               this.c = true;
               this.a();
               return true;
            }
         }

         Context var10;
         if(var5 != null) {
            var7 = this.b.b(this.a);
            this.a(this.a);
            this.b.b(this.a, false);
            this.b.b(this.a, "");
            this.b.a(this.a, true);
            var10 = this.a;
            this.a((String)var7);
            return false;
         }

         if(var7 != null) {
            boolean var3;
            if("SERVICE_NOT_AVAILABLE".equals(var7)) {
               var10 = this.a;
               var3 = this.b(var7);
            } else {
               if(!this.c) {
                  var10 = this.a;
                  this.b(var7);
                  this.c = true;
                  this.a();
                  return true;
               }

               var10 = this.a;
               var3 = this.c(var7);
            }

            if(var3) {
               var2 = this.b.g(this.a);
               var1 = new Intent("com.google.android.gcm.intent.RETRY");
               var1.setPackage(this.a.getPackageName());
               PendingIntent var8 = PendingIntent.getBroadcast(this.a, 0, var1, 0);
               ((AlarmManager)this.a.getSystemService("alarm")).set(3, SystemClock.elapsedRealtime() + (long)var2, var8);
               if(var2 < 3600000) {
                  this.b.b(this.a, var2 * 2);
               }
            }

            return true;
         }
      } else {
         if(!"com.google.android.c2dm.intent.RECEIVE".equals(var4)) {
            if("com.google.android.gcm.intent.RETRY".equals(var4)) {
               var7 = var1.getPackage();
               if(var7 != null && var7.equals(this.a.getPackageName())) {
                  this.a();
                  return true;
               }

               return false;
            }

            return false;
         }

         var4 = var1.getStringExtra("message_type");
         if(var4 == null) {
            return this.a(this.a, var1);
         }

         if(!"deleted_messages".equals(var4)) {
            return false;
         }

         var7 = var1.getStringExtra("total_deleted");
         if(var7 != null) {
            try {
               var2 = Integer.parseInt(var7);
               Context var9 = this.a;
               this.a(var2);
               return false;
            } catch (NumberFormatException var6) {
               return false;
            }
         }
      }

      return false;
   }
}
