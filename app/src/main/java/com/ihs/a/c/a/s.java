package com.ihs.a.c.a;

import android.os.Handler;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public final class s {
   private Timer a;
   private Handler b;
   private Runnable c;
   private long d;
   private long e;
   private boolean f;
   private boolean g;

   private static com.ihs.a.c.a.s a(int var0, int var1, boolean var2, Handler var3, Runnable var4) {
      final com.ihs.a.c.a.s var5 = new com.ihs.a.c.a.s();
      var5.d = (long)0;
      var5.e = (long)var0;
      var5.c = var4;
      var5.f = false;
      var5.b = var3;
      var5.g = false;
      var5.a = new Timer();
      TimerTask var6 = new TimerTask() {
         public final void run() {
            var5.b.post(new Runnable() {
               public final void run() {
                  if(!var5.g && var5.c != null) {
                     (new StringBuilder("Timer Fired. ")).append(var5.c.toString()).append(" Interval:").append(var5.d / 1000L).append("s. Repeat:").append(var5.f).toString();
                     var5.c.run();
                     if(!var5.f) {
                        var5.a();
                     }
                  }

               }
            });
         }
      };
      if(var5.f) {
         var5.a.schedule(var6, (long)var0, (long)0);
      } else {
         var5.a.schedule(var6, (long)var0);
      }

      String.format(Locale.US, "Timer Started. Interval:%ds. Repeat:%s", new Object[]{Long.valueOf(var5.d / 1000L), Boolean.valueOf(var5.f)});
      return var5;
   }

   public static com.ihs.a.c.a.s a(Runnable var0) {
      return a(0, 0, false, new Handler(), var0);
   }

   public static com.ihs.a.c.a.s a(Runnable var0, int var1) {
      return a(var1, 0, false, new Handler(), var0);
   }

   public final void a() {
      this.g = true;
      if(this.a != null) {
         this.a.cancel();
         this.a.purge();
         this.a = null;
      }

      this.c = null;
   }
}
