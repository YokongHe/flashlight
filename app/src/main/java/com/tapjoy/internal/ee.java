package com.tapjoy.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.tapjoy.internal.ed;
import com.tapjoy.internal.ee$a;
import com.tapjoy.internal.en;
import com.tapjoy.internal.eo;
import com.tapjoy.internal.ex;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

class ee extends ed {
   private static final String i = ee.class.getSimpleName();
   private Context j = null;
   private boolean k = false;
   private boolean l = false;
   private eo m = null;
   private en n = null;
   private CountDownLatch o = null;
   private int p = 0;

   private static String a(String var0, String var1, ArrayList var2) {
      Iterator var3 = var2.iterator();

      HashMap var5;
      while(true) {
         if(var3.hasNext()) {
            HashMap var6 = (HashMap)var3.next();
            String var4 = (String)var6.get("name");
            if(var4 == null || !var4.toLowerCase(Locale.US).contains(var0.toLowerCase(Locale.US))) {
               continue;
            }

            var5 = var6;
            break;
         }

         var5 = null;
         break;
      }

      if(var5 != null) {
         String var7 = ((String)var5.get("name")).replace("[abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXY -]", "");
         var0 = var7;
         if(!var7.isEmpty()) {
            var0 = "true";
         }
      } else {
         var0 = "false";
      }

      return var1 + "^" + var0 + "!";
   }

   private void a(String var1) {
      this.c = var1.replaceAll("(<FIELD_SEP>|<REC_SEP>)", "");
      this.d = ex.b(this.c);
      ArrayList var4 = new ArrayList();
      String[] var7 = var1.split("<REC_SEP>");
      int var3 = var7.length;

      for(int var2 = 0; var2 < var3; ++var2) {
         String var6 = var7[var2];
         if(Thread.currentThread().isInterrupted()) {
            return;
         }

         HashMap var5 = new HashMap();
         String[] var10 = var6.split("<FIELD_SEP>");
         if(var10.length == 4) {
            var5.put("name", var10[0]);
            var5.put("description", var10[1]);
            var5.put("filename", var10[2]);
            var5.put("length", var10[3]);
            var4.add(var5);
         }
      }

      this.b = Integer.toString(var4.size());
      StringBuilder var8 = new StringBuilder();
      var8.append(a("QuickTime Plug-in", "plugin_quicktime", var4));
      var8.append(a("Adobe Acrobat", "plugin_adobe_acrobat", var4));
      var8.append(a("Java", "plugin_java", var4));
      var8.append(a("SVG Viewer", "plugin_svg_viewer", var4));
      var8.append(a("Flash", "plugin_flash", var4));
      var8.append(a("Windows Media Player", "plugin_windows_media_player", var4));
      var8.append(a("Silverlight", "plugin_silverlight", var4));
      var8.append(a("Real Player", "plugin_realplayer", var4));
      var8.append(a("ShockWave Director", "plugin_shockwave", var4));
      var8.append(a("VLC", "plugin_vlc_player", var4));
      var8.append(a("DevalVR", "plugin_devalvr", var4));
      this.a = var8.toString();
      var1 = i;
      StringBuilder var9 = (new StringBuilder("Got")).append(this.b).append(":");
      if(this.a != null) {
         var1 = this.a;
      } else {
         var1 = "";
      }

      var9.append(var1);
   }

   // $FF: synthetic method
   static void e(ee var0) {
      if(!Thread.currentThread().isInterrupted()) {
         String var1;
         if((var0.p & 32) != 0) {
            var1 = var0.n.a("(function () { var plugins_string=\'\', i=0; for (p=navigator.plugins[0]; i< navigator.plugins.length;p=navigator.plugins[i++]) {  plugins_string += p.name + \'<FIELD_SEP>\' + p.description + \'<FIELD_SEP>\' + p.filename + \'<FIELD_SEP>\' + p.length.toString() + \'<REC_SEP>\'; } return plugins_string;})();");
            if(var1 != null) {
               var0.a(var1);
            }
         }

         if(!Thread.currentThread().isInterrupted() && (var0.p & 4) != 0) {
            var1 = var0.n.a("navigator.mimeTypes.length");
            if(var1 != null) {
               try {
                  var0.f = Integer.parseInt(var1);
               } catch (NumberFormatException var2) {
                  Log.e(i, "failed to convert", var2);
               }
            }

            var0.g = var0.n.a("(function () { var mime_string=\'\', i=0; for (var m=navigator.mimeTypes[0]; i< navigator.mimeTypes.length;m=navigator.mimeTypes[i++]) {  mime_string += m.type; } return mime_string;})();");
            if(var0.g == null) {
               var0.h = "";
               return;
            }

            var0.h = ex.b(var0.g);
            var1 = i;
            (new StringBuilder("Got:")).append(var0.g);
         }
      }

   }

   public final String a() {
      if(this.c == null) {
         if(this.n != null && !this.l) {
            this.e = this.n.a(this.j);
         } else {
            this.e = en.c();
         }
      }

      return this.e;
   }

   final boolean a(Context var1, boolean var2, int var3) {
      this.j = var1;
      this.k = var2;
      this.p = var3;
      if(!this.k) {
         return false;
      } else {
         String var7 = i;
         StringBuilder var4 = (new StringBuilder("initJSExecutor: jsProblem = ")).append(this.l).append(", jsExec = ").append(this.n).append(", hasBadOptions = ");
         Object var8;
         if(this.n != null) {
            var8 = Boolean.valueOf(this.n.a(var2));
         } else {
            var8 = "true";
         }

         var4.append(var8);
         if(!this.l && this.n == null || this.n != null && this.n.a(this.k)) {
            final CountDownLatch var11 = new CountDownLatch(1);
            Handler var5 = new Handler(Looper.getMainLooper());
            boolean var10;
            if(!en.b() && !en.a()) {
               var10 = false;
            } else {
               var10 = true;
            }

            CountDownLatch var9;
            if(var10) {
               var9 = var11;
            } else {
               var9 = null;
            }

            this.m = new eo(var9);
            var7 = i;
            (new StringBuilder("Firing off initJSExecutor on UI thread using latch: ")).append(var11.hashCode()).append(" with count: ").append(var11.getCount());
            var5.post(new ee$a(this, var11) {
               public final void run() {
                  ee.i;
                  this.b.n = new en(ee.this.j, ee.this.m, ee.this.k);

                  try {
                     this.b.n.d();
                  } catch (InterruptedException var2) {
                     Log.e(ee.i, "Interrupted initing js engine");
                  }

                  ee.i;
                  if(this.c != null) {
                     ee.i;
                     (new StringBuilder("js exec init countdown using latch: ")).append(this.c.hashCode()).append(" with count: ").append(this.c.getCount());
                     this.c.countDown();
                  }

               }
            });

            try {
               if(!var11.await(10L, TimeUnit.SECONDS)) {
                  this.l = true;
                  Log.e(i, "initJSExecutor no response from UI thread before timeout using init latch: " + var11.hashCode() + " with count: " + var11.getCount());
                  return false;
               }
            } catch (InterruptedException var6) {
               Log.e(i, "Interrupted initing js engine");
               return false;
            }
         } else {
            var7 = i;
         }

         return true;
      }
   }

   final void b() {
      // $FF: Couldn't be decompiled
   }

   final boolean c() {
      boolean var1;
      if(this.n != null && !this.l) {
         var1 = true;
      } else {
         var1 = false;
      }

      return var1 && this.k;
   }

   final void d() {
      int var1 = 1;
      byte var2 = 1;
      boolean var3;
      if(!en.b() && !en.a()) {
         var3 = false;
      } else {
         var3 = true;
      }

      if(var3) {
         if((this.p & 32) != 0) {
            var2 = 2;
         }

         var1 = var2;
         if((this.p & 4) != 0) {
            var1 = var2 + 2;
         }
      }

      this.o = new CountDownLatch(var1);
      Handler var5 = new Handler(Looper.getMainLooper());
      String var4 = i;
      (new StringBuilder("Firing off getBrowserInfo on UI thread using latch: ")).append(this.o.hashCode()).append(" with count: ").append(var1);
      eo var6 = this.m;
      CountDownLatch var7;
      if(var3) {
         var7 = this.o;
      } else {
         var7 = null;
      }

      var6.a(var7);
      var5.post(new ee$a(this, this.o) {
         public final void run() {
            try {
               ee.i;
               ee.e(this.b);
            } catch (InterruptedException var2) {
               ee.i;
            }

            if(this.c != null) {
               ee.i;
               (new StringBuilder("getBrowserInfo countdown using latch: ")).append(this.c.hashCode()).append(" with count: ").append(this.c.getCount());
               this.c.countDown();
            }

         }
      });
   }
}
