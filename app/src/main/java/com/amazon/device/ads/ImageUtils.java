package com.amazon.device.ads;

import android.content.Context;
import android.graphics.Bitmap;
import com.amazon.device.ads.ImageUtils$GraphicsUtilsExecutor;
import java.io.InputStream;

class ImageUtils {
   private static final String LOGTAG = ImageUtils.class.getSimpleName();
   private static ImageUtils$GraphicsUtilsExecutor executor = new ImageUtils$GraphicsUtilsExecutor();

   // $FF: synthetic method
   static String access$000() {
      return LOGTAG;
   }

   public static Bitmap createBitmapImage(InputStream var0) {
      return executor.createBitmapImage(var0);
   }

   public static String insertImageInMediaStore(Context var0, Bitmap var1, String var2, String var3) {
      return executor.insertImageInMediaStore(var0, var1, var2, var3);
   }
}
