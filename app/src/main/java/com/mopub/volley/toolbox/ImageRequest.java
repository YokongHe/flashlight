package com.mopub.volley.toolbox;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import com.mopub.volley.DefaultRetryPolicy;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.ParseError;
import com.mopub.volley.Request;
import com.mopub.volley.Request$Priority;
import com.mopub.volley.Response;
import com.mopub.volley.Response$ErrorListener;
import com.mopub.volley.Response$Listener;
import com.mopub.volley.VolleyLog;
import com.mopub.volley.toolbox.HttpHeaderParser;

public class ImageRequest extends Request {
   private static final float IMAGE_BACKOFF_MULT = 2.0F;
   private static final int IMAGE_MAX_RETRIES = 2;
   private static final int IMAGE_TIMEOUT_MS = 1000;
   private static final Object sDecodeLock = new Object();
   private final Config mDecodeConfig;
   private final Response$Listener mListener;
   private final int mMaxHeight;
   private final int mMaxWidth;

   public ImageRequest(String var1, Response$Listener var2, int var3, int var4, Config var5, Response$ErrorListener var6) {
      super(0, var1, var6);
      this.setRetryPolicy(new DefaultRetryPolicy(1000, 2, 2.0F));
      this.mListener = var2;
      this.mDecodeConfig = var5;
      this.mMaxWidth = var3;
      this.mMaxHeight = var4;
   }

   private Response doParse(NetworkResponse var1) {
      byte[] var6 = var1.data;
      Options var7 = new Options();
      Bitmap var8;
      if(this.mMaxWidth == 0 && this.mMaxHeight == 0) {
         var7.inPreferredConfig = this.mDecodeConfig;
         var8 = BitmapFactory.decodeByteArray(var6, 0, var6.length, var7);
      } else {
         var7.inJustDecodeBounds = true;
         BitmapFactory.decodeByteArray(var6, 0, var6.length, var7);
         int var2 = var7.outWidth;
         int var3 = var7.outHeight;
         int var4 = getResizedDimension(this.mMaxWidth, this.mMaxHeight, var2, var3);
         int var5 = getResizedDimension(this.mMaxHeight, this.mMaxWidth, var3, var2);
         var7.inJustDecodeBounds = false;
         var7.inSampleSize = findBestSampleSize(var2, var3, var4, var5);
         var8 = BitmapFactory.decodeByteArray(var6, 0, var6.length, var7);
         if(var8 != null && (var8.getWidth() > var4 || var8.getHeight() > var5)) {
            Bitmap var9 = Bitmap.createScaledBitmap(var8, var4, var5, true);
            var8.recycle();
            var8 = var9;
         }
      }

      return var8 == null?Response.error(new ParseError(var1)):Response.success(var8, HttpHeaderParser.parseCacheHeaders(var1));
   }

   static int findBestSampleSize(int var0, int var1, int var2, int var3) {
      double var4 = Math.min((double)var0 / (double)var2, (double)var1 / (double)var3);

      float var6;
      for(var6 = 1.0F; (double)(var6 * 2.0F) <= var4; var6 *= 2.0F) {
         ;
      }

      return (int)var6;
   }

   private static int getResizedDimension(int var0, int var1, int var2, int var3) {
      int var6;
      if(var0 == 0 && var1 == 0) {
         var6 = var2;
      } else {
         if(var0 == 0) {
            return (int)((double)var1 / (double)var3 * (double)var2);
         }

         var6 = var0;
         if(var1 != 0) {
            double var4 = (double)var3 / (double)var2;
            var6 = var0;
            if((double)var0 * var4 > (double)var1) {
               return (int)((double)var1 / var4);
            }
         }
      }

      return var6;
   }

   protected void deliverResponse(Bitmap var1) {
      this.mListener.onResponse(var1);
   }

   public Request$Priority getPriority() {
      return Request$Priority.LOW;
   }

   protected Response parseNetworkResponse(NetworkResponse var1) {
      Object var2 = sDecodeLock;
      synchronized(var2) {
         Response var3;
         try {
            var3 = this.doParse(var1);
         } catch (OutOfMemoryError var4) {
            VolleyLog.e("Caught OOM for %d byte image, url=%s", new Object[]{Integer.valueOf(var1.data.length), this.getUrl()});
            Response var6 = Response.error(new ParseError(var4));
            return var6;
         }

         return var3;
      }
   }
}
