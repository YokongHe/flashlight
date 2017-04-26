package com.mopub.volley.toolbox;

import android.graphics.Bitmap;
import com.mopub.volley.toolbox.ImageLoader;
import com.mopub.volley.toolbox.ImageLoader$BatchedImageRequest;
import com.mopub.volley.toolbox.ImageLoader$ImageListener;

public class ImageLoader$ImageContainer {
   private Bitmap mBitmap;
   private final String mCacheKey;
   private final ImageLoader$ImageListener mListener;
   private final String mRequestUrl;
   // $FF: synthetic field
   final ImageLoader this$0;

   public ImageLoader$ImageContainer(ImageLoader var1, Bitmap var2, String var3, String var4, ImageLoader$ImageListener var5) {
      this.this$0 = var1;
      this.mBitmap = var2;
      this.mRequestUrl = var3;
      this.mCacheKey = var4;
      this.mListener = var5;
   }

   // $FF: synthetic method
   static ImageLoader$ImageListener access$400(ImageLoader$ImageContainer var0) {
      return var0.mListener;
   }

   // $FF: synthetic method
   static Bitmap access$502(ImageLoader$ImageContainer var0, Bitmap var1) {
      var0.mBitmap = var1;
      return var1;
   }

   public void cancelRequest() {
      if(this.mListener != null) {
         ImageLoader$BatchedImageRequest var1 = (ImageLoader$BatchedImageRequest)ImageLoader.access$100(this.this$0).get(this.mCacheKey);
         if(var1 != null) {
            if(var1.removeContainerAndCancelIfNecessary(this)) {
               ImageLoader.access$100(this.this$0).remove(this.mCacheKey);
               return;
            }
         } else {
            var1 = (ImageLoader$BatchedImageRequest)ImageLoader.access$200(this.this$0).get(this.mCacheKey);
            if(var1 != null) {
               var1.removeContainerAndCancelIfNecessary(this);
               if(ImageLoader$BatchedImageRequest.access$300(var1).size() == 0) {
                  ImageLoader.access$200(this.this$0).remove(this.mCacheKey);
                  return;
               }
            }
         }
      }

   }

   public Bitmap getBitmap() {
      return this.mBitmap;
   }

   public String getRequestUrl() {
      return this.mRequestUrl;
   }
}
