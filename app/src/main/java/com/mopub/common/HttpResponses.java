package com.mopub.common;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.mopub.common.DownloadResponse;
import org.json.JSONObject;
import org.json.JSONTokener;

public final class HttpResponses {
   public static Bitmap asBitmap(DownloadResponse var0) {
      if(var0 == null) {
         return null;
      } else {
         byte[] var1 = var0.getByteArray();
         return BitmapFactory.decodeByteArray(var1, 0, var1.length);
      }
   }

   public static JSONObject asJsonObject(DownloadResponse var0) {
      if(var0 == null) {
         return null;
      } else {
         try {
            JSONObject var2 = new JSONObject(new JSONTokener(asResponseString(var0)));
            return var2;
         } catch (Exception var1) {
            return null;
         }
      }
   }

   public static String asResponseString(DownloadResponse var0) {
      if(var0 == null) {
         return null;
      } else {
         try {
            String var2 = new String(var0.getByteArray(), "UTF-8");
            return var2;
         } catch (Exception var1) {
            return null;
         }
      }
   }
}
