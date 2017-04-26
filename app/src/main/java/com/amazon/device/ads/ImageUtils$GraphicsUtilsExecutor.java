package com.amazon.device.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore.Images.Media;
import com.amazon.device.ads.ImageUtils;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ImageUtils$GraphicsUtilsExecutor {
   public Bitmap createBitmapImage(InputStream var1) {
      if(var1 != null) {
         BufferedInputStream var2 = new BufferedInputStream(var1, '耀');
         var2.mark('耀');
         Bitmap var4 = BitmapFactory.decodeStream(var2);

         try {
            var2.close();
            return var4;
         } catch (IOException var3) {
            android.util.Log.e(ImageUtils.access$000(), "IOException while trying to close the input stream.");
            return var4;
         }
      } else {
         return null;
      }
   }

   public String insertImageInMediaStore(Context var1, Bitmap var2, String var3, String var4) {
      return Media.insertImage(var1.getContentResolver(), var2, var3, var4);
   }
}
