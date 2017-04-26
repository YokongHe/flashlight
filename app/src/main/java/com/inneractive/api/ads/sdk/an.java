package com.inneractive.api.ads.sdk;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.net.Uri;
import android.os.StatFs;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.inneractive.api.ads.sdk.IAdefines;
import com.inneractive.api.ads.sdk.IAdefines$ApiLevel;
import com.inneractive.api.ads.sdk.IAreflectionHandler$a;
import com.inneractive.api.ads.sdk.InneractiveAdView$Log;
import com.inneractive.api.ads.sdk.InneractiveInternalBrowserActivity;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.regex.Pattern;

final class an {
   private static final int a;
   private static final int b;

   static {
      a = IAdefines.o * 30;
      b = IAdefines.o * 100;
   }

   static int a(float var0, Context var1) {
      return (int)(TypedValue.applyDimension(1, var0, var1.getResources().getDisplayMetrics()) + 0.5F);
   }

   static int a(int var0) {
      return var0 * 1000;
   }

   static int a(Context var0) {
      Display var1 = ((WindowManager)var0.getSystemService("window")).getDefaultDisplay();
      if(IAdefines$ApiLevel.a().b(IAdefines$ApiLevel.e)) {
         Point var3 = new Point();

         try {
            (new IAreflectionHandler$a(var1, "getSize")).a(Point.class, var3).a();
         } catch (Exception var2) {
            InneractiveAdView$Log.a("Failed to get display size");
         }

         return var3.y;
      } else {
         return var1.getHeight();
      }
   }

   static int a(Context var0, int var1) {
      DisplayMetrics var2 = new DisplayMetrics();
      ((WindowManager)var0.getSystemService("window")).getDefaultDisplay().getMetrics(var2);
      return (int)((float)var1 / var2.density + 0.5F);
   }

   static long a(File var0) {
      long var1 = (long)a;

      long var3;
      try {
         StatFs var6 = new StatFs(var0.getAbsolutePath());
         var3 = (long)var6.getBlockCount();
         var3 = (long)var6.getBlockSize() * var3 / 50L;
      } catch (IllegalArgumentException var5) {
         InneractiveAdView$Log.e("Unable to calculate 2% of available disk space, defaulting to minimum");
         return Math.max(Math.min(var1, (long)b), (long)a);
      }

      var1 = var3;
      return Math.max(Math.min(var1, (long)b), (long)a);
   }

   static String a(InputStream var0) {
      StringBuffer var2 = new StringBuffer();
      byte[] var3 = new byte[4096];

      for(int var1 = 0; var1 != -1; var1 = var0.read(var3)) {
         var2.append(new String(var3, 0, var1));
      }

      var0.close();
      return var2.toString();
   }

   static String a(Exception var0) {
      try {
         StringWriter var1 = new StringWriter();
         var0.printStackTrace(new PrintWriter(var1));
         String var3 = "------\r\n" + var1.toString() + "------\r\n";
         return var3;
      } catch (Exception var2) {
         return "bad stackToString";
      }
   }

   static void a(View var0) {
      if(var0 != null && var0.getParent() != null && var0.getParent() instanceof ViewGroup) {
         ((ViewGroup)var0.getParent()).removeView(var0);
      }
   }

   static void a(Closeable var0) {
      if(var0 != null) {
         try {
            var0.close();
         } catch (IOException var1) {
            ;
         }
      }
   }

   static void a(InputStream var0, OutputStream var1) {
      if(var0 != null && var1 != null) {
         byte[] var3 = new byte[65536];

         while(true) {
            int var2 = var0.read(var3);
            if(var2 == -1) {
               return;
            }

            var1.write(var3, 0, var2);
         }
      } else {
         throw new IOException("Unable to copy from or to a null stream.");
      }
   }

   static boolean a(Context var0, String var1) {
      return var0.checkCallingOrSelfPermission(var1) == 0;
   }

   static boolean a(Context param0, String param1, boolean param2) {
      // $FF: Couldn't be decompiled
   }

   static boolean a(String var0) {
      return var0 == null || "null".equals(var0) || var0.length() == 0;
   }

   static int b(Context var0) {
      Display var1 = ((WindowManager)var0.getSystemService("window")).getDefaultDisplay();
      if(IAdefines$ApiLevel.a().b(IAdefines$ApiLevel.e)) {
         Point var3 = new Point();

         try {
            (new IAreflectionHandler$a(var1, "getSize")).a(Point.class, var3).a();
         } catch (Exception var2) {
            InneractiveAdView$Log.a("Failed to get display size");
         }

         return var3.x;
      } else {
         return var1.getWidth();
      }
   }

   static int b(Context var0, int var1) {
      DisplayMetrics var2 = new DisplayMetrics();
      ((WindowManager)var0.getSystemService("window")).getDefaultDisplay().getMetrics(var2);
      return (int)((float)var1 * var2.density + 0.5F);
   }

   static Intent b(Context var0, String var1) {
      Intent var2 = new Intent(var0, InneractiveInternalBrowserActivity.class);
      var2.putExtra("extra_url", var1);
      var2.addFlags(268435456);
      return var2;
   }

   static String b(String var0) {
      return var0 != null?var0.replace(" ", ""):null;
   }

   static int c(Context var0) {
      return ((WindowManager)var0.getSystemService("window")).getDefaultDisplay().getOrientation();
   }

   public static String c(String var0) {
      return var0 == null?null:com.inneractive.api.ads.sdk.k.b.a(var0);
   }

   static boolean c(Context var0, int var1) {
      var1 = (int)TypedValue.applyDimension(1, (float)var1, var0.getResources().getDisplayMetrics());
      return var0.getResources().getDisplayMetrics().widthPixels >= var1;
   }

   public static String d(String var0) {
      return var0 == null?null:com.inneractive.api.ads.sdk.k.a.a(var0);
   }

   static String e(String param0) {
      // $FF: Couldn't be decompiled
   }

   static String f(String param0) {
      // $FF: Couldn't be decompiled
   }

   static boolean g(String var0) {
      return Pattern.compile("(^\\d{5}$)|(^\\d{5}-\\d{4}$)").matcher(var0).matches();
   }

   static boolean h(String var0) {
      return Pattern.compile("^[\\w\\-\\_]+(,[\\w\\-\\_]+)*$").matcher(var0).matches();
   }

   static boolean i(String var0) {
      return Pattern.compile("^([\\w\\-\\_]*)$").matcher(var0).matches();
   }

   static boolean j(String var0) {
      return Pattern.compile("^([\\d]*)$").matcher(var0).matches();
   }

   static Intent k(String var0) {
      Intent var1 = new Intent("android.intent.action.VIEW", Uri.parse(var0));
      var1.setFlags(268435456);
      return var1;
   }
}
