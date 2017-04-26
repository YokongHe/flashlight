package com.tapjoy.internal;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources.NotFoundException;
import android.os.Bundle;
import android.os.Build.VERSION;
import android.text.Html;
import com.tapjoy.TapjoyReceiver;
import com.tapjoy.internal.a$c;
import com.tapjoy.internal.a$d;
import com.tapjoy.internal.fs;
import com.tapjoy.internal.fv;
import com.tapjoy.internal.ge;

public final class fx extends com.tapjoy.internal.r {
   private static fx c;

   private fx(Context var1) {
      super(var1, new com.tapjoy.internal.t() {
         public final String a(Context var1) {
            return ge.a(var1).b.getString("gcm.senderIds", "");
         }

         public final void a(Context var1, int var2) {
            com.tapjoy.internal.p.a(ge.a(var1).b, "gcm.appVersion", var2);
         }

         public final void a(Context var1, long var2) {
            Editor var4 = ge.a(var1).b.edit();
            var4.putLong("gcm.onServerExpirationTime", var2);
            var4.commit();
         }

         public final void a(Context var1, String var2) {
            com.tapjoy.internal.p.a(ge.a(var1).b, "gcm.senderIds", var2);
         }

         public final void a(Context var1, boolean var2) {
            com.tapjoy.internal.p.a(ge.a(var1).b, "gcm.stale", var2);
         }

         public final String b(Context var1) {
            return ge.a(var1).b.getString("gcm.regId", "");
         }

         public final void b(Context var1, int var2) {
            com.tapjoy.internal.p.a(ge.a(var1).b, "gcm.backoff", var2);
         }

         public final void b(Context var1, String var2) {
            com.tapjoy.internal.p.a(ge.a(var1).b, "gcm.regId", var2);
         }

         public final void b(Context var1, boolean var2) {
            com.tapjoy.internal.p.a(ge.a(var1).b, "gcm.onServer", var2);
         }

         public final boolean c(Context var1) {
            return ge.a(var1).b.getBoolean("gcm.stale", true);
         }

         public final int d(Context var1) {
            return ge.a(var1).b.getInt("gcm.appVersion", Integer.MIN_VALUE);
         }

         public final boolean e(Context var1) {
            return ge.a(var1).b.getBoolean("gcm.onServer", false);
         }

         public final long f(Context var1) {
            return ge.a(var1).b.getLong("gcm.onServerExpirationTime", 0L);
         }

         public final int g(Context var1) {
            return ge.a(var1).b.getInt("gcm.backoff", 0);
         }
      });
   }

   private static int a(Bundle var0, String var1, Context var2) {
      if(var0 != null) {
         Object var6 = var0.get(var1);
         if(var6 instanceof Integer) {
            label30: {
               int var3 = ((Integer)var6).intValue();

               boolean var4;
               try {
                  var4 = "drawable".equals(var2.getResources().getResourceTypeName(var3));
               } catch (NotFoundException var5) {
                  break label30;
               }

               if(var4) {
                  return var3;
               }
            }
         }

         if(var6 != null && fs.a) {
            com.tapjoy.internal.ad.a(4, "Tapjoy", "meta-data of {} invalid", (Object[])(new Object[]{var1}));
         }
      }

      return 0;
   }

   private static Notification a(Context var0, String var1, String var2, String var3, boolean var4, boolean var5, String var6) {
      Intent var9 = new Intent(var0.getApplicationContext(), TapjoyReceiver.class);
      var9.setAction("com.tapjoy.PUSH_CLICK");
      var9.putExtra("com.tapjoy.PUSH_ID", var1);
      if(var6 != null) {
         var9.putExtra("com.tapjoy.PUSH_PAYLOAD", var6);
      }

      int var7 = 134217728;
      if(VERSION.SDK_INT == 19) {
         var7 = 268435456;
      }

      PendingIntent var17 = PendingIntent.getBroadcast(var0.getApplicationContext(), 0, var9, var7);
      if(var17 == null) {
         return null;
      } else {
         PackageManager var12 = var0.getPackageManager();
         String var18 = var0.getPackageName();

         ApplicationInfo var19;
         try {
            var19 = var12.getApplicationInfo(var18, 128);
         } catch (NameNotFoundException var10) {
            return null;
         }

         int var8 = a(var19.metaData, "com.tapjoy.notification.icon", var0);
         var7 = var8;
         if(var8 == 0) {
            if(var19.icon != 0) {
               var7 = var19.icon;
            } else {
               var7 = 17301651;
            }
         }

         Object var13;
         if(var2.length() == 0) {
            var13 = var12.getApplicationLabel(var19);
         } else {
            var13 = var2;
            if(var4) {
               var13 = Html.fromHtml(var2);
            }
         }

         Object var14 = var3;
         if(var4) {
            var14 = Html.fromHtml(var3);
         }

         a$d var11 = new a$d(var0);
         var11.r.icon = var7;
         var11.r.tickerText = (CharSequence)var13;
         var11.b = (CharSequence)var13;
         var11.c = (CharSequence)var14;
         var11.d = var17;
         Notification var15 = var11.r;
         var15.flags |= 16;
         a$c var16 = new a$c();
         var16.e = (CharSequence)var13;
         var16.a = (CharSequence)var14;
         var11 = var11.a(var16);
         if(var5) {
            var11.r.defaults = 1;
         }

         return com.tapjoy.internal.a.a().a(var11);
      }
   }

   public static fx a(Context var0) {
      synchronized(fx.class){}

      fx var3;
      try {
         if(c == null) {
            c = new fx(var0);
         }

         var3 = c;
      } finally {
         ;
      }

      return var3;
   }

   private static boolean a(Object var0) {
      return Boolean.TRUE.equals(var0) || "true".equals(var0);
   }

   protected final void a(int var1) {
   }

   protected final void a(Context var1, String var2) {
      fv.a(var1).c(var2);
   }

   protected final void a(String var1) {
      this.a();
   }

   protected final boolean a(Context var1, Intent var2) {
      var2.getExtras();
      String var7 = var2.getStringExtra("fiverocks");
      if(var7 == null) {
         return false;
      } else {
         String var9 = var2.getStringExtra("title");
         String var8 = var2.getStringExtra("message");
         if(var8 != null) {
            Bundle var13 = var2.getExtras();
            Object var15 = var13.get("rich");
            Object var10 = var13.get("sound");
            Object var11 = var13.get("important");
            String var12 = var13.getString("payload");
            Object var14 = var13.get("always");
            boolean var3;
            if(!"true".equals(var14) && !Boolean.TRUE.equals(var14)) {
               var3 = false;
            } else {
               var3 = true;
            }

            Object var17 = var13.get("repeatable");
            boolean var4;
            if(!"true".equals(var17) && !Boolean.TRUE.equals(var17)) {
               var4 = false;
            } else {
               var4 = true;
            }

            if(var3 || !fv.a(var1).e()) {
               var9 = com.tapjoy.internal.cv.a(var9);
               boolean var5 = a(var15);
               boolean var6 = a(var10);
               a(var11);
               Notification var16 = a(var1, var7, var9, var8, var5, var6, var12);
               if(fv.a(var1).a(var1, var7, var4)) {
                  ((NotificationManager)var1.getSystemService("notification")).notify(0, var16);
               }
            }
         }

         return true;
      }
   }

   protected final boolean b(String var1) {
      return true;
   }

   protected final boolean c(String var1) {
      return false;
   }

   final void d(String var1) {
      if(var1 != null && var1.length() > 0) {
         super.a(new String[]{var1});
      }

   }
}
