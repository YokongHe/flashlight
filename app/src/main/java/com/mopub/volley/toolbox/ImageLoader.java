package com.mopub.volley.toolbox;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import com.mopub.volley.Request;
import com.mopub.volley.RequestQueue;
import com.mopub.volley.Response$ErrorListener;
import com.mopub.volley.Response$Listener;
import com.mopub.volley.VolleyError;
import com.mopub.volley.toolbox.ImageLoader$BatchedImageRequest;
import com.mopub.volley.toolbox.ImageLoader$ImageCache;
import com.mopub.volley.toolbox.ImageLoader$ImageContainer;
import com.mopub.volley.toolbox.ImageLoader$ImageListener;
import com.mopub.volley.toolbox.ImageRequest;
import java.util.HashMap;
import java.util.Iterator;

public class ImageLoader {
   private int mBatchResponseDelayMs = 100;
   private final HashMap mBatchedResponses = new HashMap();
   private final ImageLoader$ImageCache mCache;
   private final Handler mHandler = new Handler(Looper.getMainLooper());
   private final HashMap mInFlightRequests = new HashMap();
   private final RequestQueue mRequestQueue;
   private Runnable mRunnable;

   public ImageLoader(RequestQueue var1, ImageLoader$ImageCache var2) {
      this.mRequestQueue = var1;
      this.mCache = var2;
   }

   // $FF: synthetic method
   static HashMap access$100(ImageLoader var0) {
      return var0.mInFlightRequests;
   }

   private void batchResponse(String var1, ImageLoader$BatchedImageRequest var2) {
      this.mBatchedResponses.put(var1, var2);
      if(this.mRunnable == null) {
         this.mRunnable = new Runnable() {
            public void run() {
               Iterator var1 = ImageLoader.this.mBatchedResponses.values().iterator();

               while(var1.hasNext()) {
                  ImageLoader$BatchedImageRequest var2 = (ImageLoader$BatchedImageRequest)var1.next();
                  Iterator var3 = ImageLoader$BatchedImageRequest.access$300(var2).iterator();

                  while(var3.hasNext()) {
                     ImageLoader$ImageContainer var4 = (ImageLoader$ImageContainer)var3.next();
                     if(ImageLoader$ImageContainer.access$400(var4) != null) {
                        if(var2.getError() == null) {
                           ImageLoader$ImageContainer.access$502(var4, ImageLoader$BatchedImageRequest.access$000(var2));
                           ImageLoader$ImageContainer.access$400(var4).onResponse(var4, false);
                        } else {
                           ImageLoader$ImageContainer.access$400(var4).onErrorResponse(var2.getError());
                        }
                     }
                  }
               }

               ImageLoader.this.mBatchedResponses.clear();
               ImageLoader.this.mRunnable = null;
            }
         };
         this.mHandler.postDelayed(this.mRunnable, (long)this.mBatchResponseDelayMs);
      }

   }

   private static String getCacheKey(String var0, int var1, int var2) {
      return (new StringBuilder(var0.length() + 12)).append("#W").append(var1).append("#H").append(var2).append(var0).toString();
   }

   public static ImageLoader$ImageListener getImageListener(final ImageView var0, final int var1, final int var2) {
      return new ImageLoader$ImageListener() {
         public final void onErrorResponse(VolleyError var1x) {
            if(var2 != 0) {
               var0.setImageResource(var2);
            }

         }

         public final void onResponse(ImageLoader$ImageContainer var1x, boolean var2x) {
            if(var1x.getBitmap() != null) {
               var0.setImageBitmap(var1x.getBitmap());
            } else if(var1 != 0) {
               var0.setImageResource(var1);
               return;
            }

         }
      };
   }

   private void throwIfNotOnMainThread() {
      if(Looper.myLooper() != Looper.getMainLooper()) {
         throw new IllegalStateException("ImageLoader must be invoked from the main thread.");
      }
   }

   public ImageLoader$ImageContainer get(String var1, ImageLoader$ImageListener var2) {
      return this.get(var1, var2, 0, 0);
   }

   public ImageLoader$ImageContainer get(String var1, ImageLoader$ImageListener var2, int var3, int var4) {
      this.throwIfNotOnMainThread();
      String var5 = getCacheKey(var1, var3, var4);
      Bitmap var6 = this.mCache.getBitmap(var5);
      if(var6 != null) {
         ImageLoader$ImageContainer var8 = new ImageLoader$ImageContainer(this, var6, var1, (String)null, (ImageLoader$ImageListener)null);
         var2.onResponse(var8, true);
         return var8;
      } else {
         ImageLoader$ImageContainer var10 = new ImageLoader$ImageContainer(this, (Bitmap)null, var1, var5, var2);
         var2.onResponse(var10, true);
         ImageLoader$BatchedImageRequest var9 = (ImageLoader$BatchedImageRequest)this.mInFlightRequests.get(var5);
         if(var9 != null) {
            var9.addContainer(var10);
            return var10;
         } else {
            Request var7 = this.makeImageRequest(var1, var3, var4, var5);
            this.mRequestQueue.add(var7);
            this.mInFlightRequests.put(var5, new ImageLoader$BatchedImageRequest(this, var7, var10));
            return var10;
         }
      }
   }

   public boolean isCached(String var1, int var2, int var3) {
      this.throwIfNotOnMainThread();
      var1 = getCacheKey(var1, var2, var3);
      return this.mCache.getBitmap(var1) != null;
   }

   protected Request makeImageRequest(String var1, int var2, int var3, final String var4) {
      return new ImageRequest(var1, new Response$Listener() {
         public void onResponse(Bitmap var1) {
            ImageLoader.this.onGetImageSuccess(var4, var1);
         }
      }, var2, var3, Config.RGB_565, new Response$ErrorListener() {
         public void onErrorResponse(VolleyError var1) {
            ImageLoader.this.onGetImageError(var4, var1);
         }
      });
   }

   protected void onGetImageError(String var1, VolleyError var2) {
      ImageLoader$BatchedImageRequest var3 = (ImageLoader$BatchedImageRequest)this.mInFlightRequests.remove(var1);
      if(var3 != null) {
         var3.setError(var2);
         this.batchResponse(var1, var3);
      }

   }

   protected void onGetImageSuccess(String var1, Bitmap var2) {
      this.mCache.putBitmap(var1, var2);
      ImageLoader$BatchedImageRequest var3 = (ImageLoader$BatchedImageRequest)this.mInFlightRequests.remove(var1);
      if(var3 != null) {
         ImageLoader$BatchedImageRequest.access$002(var3, var2);
         this.batchResponse(var1, var3);
      }

   }

   public void setBatchedResponseDelay(int var1) {
      this.mBatchResponseDelayMs = var1;
   }
}
