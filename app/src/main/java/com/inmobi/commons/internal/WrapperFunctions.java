package com.inmobi.commons.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.net.http.SslError;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.WebView;
import com.inmobi.commons.internal.Log;
import java.lang.reflect.InvocationTargetException;

public class WrapperFunctions {
   private static int a;

   private static void a(WebView var0, int var1) {
      try {
         var0.getClass().getMethod("setLayerType", new Class[]{Integer.TYPE, Paint.class}).invoke(var0, new Object[]{Integer.valueOf(var1), null});
      } catch (NoSuchMethodException var2) {
         Log.internal("[InMobi]-4.5.2", "Cannot set hardware accl", var2);
      } catch (IllegalArgumentException var3) {
         Log.internal("[InMobi]-4.5.2", "Cannot set hardware accl", var3);
      } catch (IllegalAccessException var4) {
         Log.internal("[InMobi]-4.5.2", "Cannot set hardware accl", var4);
      } catch (InvocationTargetException var5) {
         Log.internal("[InMobi]-4.5.2", "Cannot set hardware accl", var5);
      }
   }

   public static void disableHardwareAccl(WebView var0) {
      a(var0, 1);
   }

   public static int getCurrentOrientationInFixedValues(Context var0) {
      int var1;
      switch(var0.getResources().getConfiguration().orientation) {
      case 1:
         if(VERSION.SDK_INT < 8) {
            return 1;
         } else {
            var1 = ((WindowManager)var0.getSystemService("window")).getDefaultDisplay().getRotation();
            if(var1 != 1 && var1 != 2) {
               return 1;
            }

            return 9;
         }
      case 2:
         if(VERSION.SDK_INT < 8) {
            return 0;
         } else {
            var1 = ((WindowManager)var0.getSystemService("window")).getDefaultDisplay().getRotation();
            if(var1 != 0 && var1 != 1) {
               return 8;
            }

            return 0;
         }
      default:
         return 1;
      }
   }

   public static int getDisplayHeight(Display param0) {
      // $FF: Couldn't be decompiled
   }

   public static int getDisplayWidth(Display param0) {
      // $FF: Couldn't be decompiled
   }

   public static int getParamConfigScreenSize() {
      // $FF: Couldn't be decompiled
   }

   public static int getParamConfigSmallestScreenSize() {
      // $FF: Couldn't be decompiled
   }

   public static int getParamFillParent() {
      // $FF: Couldn't be decompiled
   }

   public static int getParamLandscapeOrientation(int param0) {
      // $FF: Couldn't be decompiled
   }

   public static int getParamPortraitOrientation(int param0) {
      // $FF: Couldn't be decompiled
   }

   public static String getSSLErrorUrl(SslError var0) {
      try {
         String var2 = Class.forName("android.net.http.SslError").getDeclaredMethod("getUrl", new Class[0]).invoke(var0, new Object[0]).toString();
         return var2;
      } catch (Exception var1) {
         Log.internal("[InMobi]-4.5.2", "Cannot get SSL Url", var1);
         return null;
      }
   }

   public static Bitmap getVideoBitmap(String var0) {
      try {
         Bitmap var2 = (Bitmap)Class.forName("android.media.ThumbnailUtils").getDeclaredMethod("createVideoThumbnail", new Class[]{String.class, Integer.TYPE}).invoke((Object)null, new Object[]{var0, Integer.valueOf(1)});
         return var2;
      } catch (Exception var1) {
         Log.internal("[InMobi]-4.5.2", "Cannot get video bitmap", var1);
         throw var1;
      }
   }
}
