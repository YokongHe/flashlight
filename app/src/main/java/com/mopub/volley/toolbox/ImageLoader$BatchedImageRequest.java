package com.mopub.volley.toolbox;

import android.graphics.Bitmap;
import com.mopub.volley.Request;
import com.mopub.volley.VolleyError;
import com.mopub.volley.toolbox.ImageLoader;
import com.mopub.volley.toolbox.ImageLoader$ImageContainer;
import java.util.LinkedList;

class ImageLoader$BatchedImageRequest {
   private final LinkedList mContainers;
   private VolleyError mError;
   private final Request mRequest;
   private Bitmap mResponseBitmap;
   // $FF: synthetic field
   final ImageLoader this$0;

   public ImageLoader$BatchedImageRequest(ImageLoader var1, Request var2, ImageLoader$ImageContainer var3) {
      this.this$0 = var1;
      this.mContainers = new LinkedList();
      this.mRequest = var2;
      this.mContainers.add(var3);
   }

   // $FF: synthetic method
   static Bitmap access$000(ImageLoader$BatchedImageRequest var0) {
      return var0.mResponseBitmap;
   }

   // $FF: synthetic method
   static Bitmap access$002(ImageLoader$BatchedImageRequest var0, Bitmap var1) {
      var0.mResponseBitmap = var1;
      return var1;
   }

   // $FF: synthetic method
   static LinkedList access$300(ImageLoader$BatchedImageRequest var0) {
      return var0.mContainers;
   }

   public void addContainer(ImageLoader$ImageContainer var1) {
      this.mContainers.add(var1);
   }

   public VolleyError getError() {
      return this.mError;
   }

   public boolean removeContainerAndCancelIfNecessary(ImageLoader$ImageContainer var1) {
      this.mContainers.remove(var1);
      if(this.mContainers.size() == 0) {
         this.mRequest.cancel();
         return true;
      } else {
         return false;
      }
   }

   public void setError(VolleyError var1) {
      this.mError = var1;
   }
}
