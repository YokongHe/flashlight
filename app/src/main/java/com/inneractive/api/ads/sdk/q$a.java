package com.inneractive.api.ads.sdk;

import android.content.Context;
import android.view.SurfaceView;
import android.view.View.MeasureSpec;
import com.inneractive.api.ads.sdk.IAplayer;
import com.inneractive.api.ads.sdk.InneractiveAdView$Log;

final class q$a extends SurfaceView {
   private float a;
   // $FF: synthetic field
   private com.inneractive.api.ads.sdk.q b;

   public q$a(com.inneractive.api.ads.sdk.q var1, Context var2) {
      this.b = var1;
      super(var2);
      this.a = 2.0F;
   }

   protected final void onMeasure(int var1, int var2) {
      InneractiveAdView$Log.a("Base Video View: onMeasure");
      int var4;
      int var5;
      if(this.b.e != null) {
         IAplayer var10 = this.b.e.a();
         var5 = var1;
         var4 = var2;
         if(var10 != null) {
            int var7 = var10.getVideoWidth();
            int var6 = var10.getVideoHeight();
            int var8 = getDefaultSize(var7, var1);
            int var9 = getDefaultSize(var6, var2);
            InneractiveAdView$Log.a("Base Video View: onMeasure called with: " + var8 + "," + var9);
            InneractiveAdView$Log.a("Base Video View: onMeasure video size: " + var7 + ", " + var6);
            var5 = var1;
            var4 = var2;
            if(var7 > 0) {
               var5 = var1;
               var4 = var2;
               if(var6 > 0) {
                  float var3 = (float)var7 / (float)var6;
                  InneractiveAdView$Log.a("Base Video View: onMeasure aspect ratio: " + var3);
                  com.inneractive.api.ads.sdk.q var11 = this.b;
                  var1 = var6;
                  var2 = var7;
                  if(com.inneractive.api.ads.sdk.q.a(var3)) {
                     var3 = Math.min((float)var8 / (float)var7, this.a);
                     if((float)var9 > (float)var6 * var3) {
                        var2 = (int)((float)var7 * var3);
                        var1 = (int)((float)var6 * var3);
                     } else {
                        var3 = Math.min((float)var9 / (float)var6, this.a);
                        var2 = (int)((float)var7 * var3);
                        var1 = (int)((float)var6 * var3);
                     }
                  }

                  var5 = MeasureSpec.makeMeasureSpec(var2, 1073741824);
                  var4 = MeasureSpec.makeMeasureSpec(var1, 1073741824);
               }
            }
         }
      } else {
         InneractiveAdView$Log.a("Base Video View: onMeasure mediaController is null!");
         var5 = var1;
         var4 = var2;
      }

      InneractiveAdView$Log.a("Base Video View: onMeasure final dimensions: " + var5 + ", " + var4);
      super.onMeasure(var5, var4);
   }
}
