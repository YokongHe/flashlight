package com.adsdk.sdk.nativeads;

import android.graphics.Bitmap;
import com.adsdk.sdk.Util;

public class NativeAd$ImageAsset {
   Bitmap bitmap;
   int height;
   String url;
   int width;

   public NativeAd$ImageAsset(String var1, int var2, int var3) {
      this.url = var1;
      this.width = var2;
      this.height = var3;
      this.bitmap = Util.loadBitmap(var1);
   }

   public Bitmap getBitmap() {
      return this.bitmap;
   }

   public int getHeight() {
      return this.height;
   }

   public String getUrl() {
      return this.url;
   }

   public int getWidth() {
      return this.width;
   }
}
