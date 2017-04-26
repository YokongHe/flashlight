package com.inmobi.re.controller.util;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import com.inmobi.commons.internal.Base64;
import com.inmobi.re.configs.Initializer;
import java.io.ByteArrayOutputStream;

public class ImageProcessing {
   public static String convertMediaUriToPath(Uri var0, Context var1) {
      Cursor var3 = var1.getContentResolver().query(var0, new String[]{"_data"}, (String)null, (String[])null, (String)null);
      int var2 = var3.getColumnIndexOrThrow("_data");
      var3.moveToFirst();
      String var4 = var3.getString(var2);
      var3.close();
      return var4;
   }

   public static String getBase64EncodedImage(Bitmap var0, Context var1) {
      ByteArrayOutputStream var3 = new ByteArrayOutputStream();
      int var2 = getDefaultImgQuality(var1);
      var0.compress(CompressFormat.JPEG, var2, var3);
      return Base64.encodeToString(var3.toByteArray(), 2);
   }

   public static Bitmap getCompressedBitmap(String param0, Context param1) {
      // $FF: Couldn't be decompiled
   }

   public static int getDefaultImgHeight(Context var0) {
      return Initializer.getConfigParams().getPicHeight();
   }

   public static int getDefaultImgQuality(Context var0) {
      return Initializer.getConfigParams().getPicQuality();
   }

   public static int getDefaultImgWidth(Context var0) {
      return Initializer.getConfigParams().getPicWidth();
   }
}
