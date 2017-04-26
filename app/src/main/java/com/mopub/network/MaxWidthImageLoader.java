package com.mopub.network;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.WindowManager;
import com.mopub.volley.RequestQueue;
import com.mopub.volley.toolbox.ImageLoader;
import com.mopub.volley.toolbox.ImageLoader$ImageCache;
import com.mopub.volley.toolbox.ImageLoader$ImageContainer;
import com.mopub.volley.toolbox.ImageLoader$ImageListener;

public class MaxWidthImageLoader extends ImageLoader {
   private final int mMaxImageWidth;

   @TargetApi(13)
   public MaxWidthImageLoader(RequestQueue var1, Context var2, ImageLoader$ImageCache var3) {
      super(var1, var3);
      Display var4 = ((WindowManager)var2.getSystemService("window")).getDefaultDisplay();
      Point var5 = new Point();
      if(VERSION.SDK_INT < 13) {
         var5.set(var4.getWidth(), var4.getHeight());
      } else {
         var4.getSize(var5);
      }

      this.mMaxImageWidth = Math.min(var5.x, var5.y);
   }

   public ImageLoader$ImageContainer get(String var1, ImageLoader$ImageListener var2) {
      return super.get(var1, var2, this.mMaxImageWidth, 0);
   }
}
