package com.inneractive.api.ads.sdk;

import com.inneractive.api.ads.sdk.IAvastMediaFile;
import java.util.Comparator;

final class g$a implements Comparator {
   // $FF: synthetic field
   private com.inneractive.api.ads.sdk.g a;

   g$a(com.inneractive.api.ads.sdk.g var1) {
      this.a = var1;
      super();
   }

   // $FF: synthetic method
   public final int compare(Object var1, Object var2) {
      IAvastMediaFile var8 = (IAvastMediaFile)var1;
      IAvastMediaFile var9 = (IAvastMediaFile)var2;
      int var3 = var9.g().compareTo(var8.g());
      if(var3 == 0) {
         int var4 = var9.a().compareTo(var8.a());
         var3 = var4;
         if(var4 == 0) {
            int var6 = var8.d();
            int var7 = var8.e();
            var3 = var9.d();
            var4 = var9.e();
            int var5 = com.inneractive.api.ads.sdk.an.b(this.a.a) * com.inneractive.api.ads.sdk.an.a(this.a.a);
            var6 = Math.abs(var6 * var7 - var5);
            var3 = Math.abs(var3 * var4 - var5);
            if(var6 < var3) {
               return -1;
            }

            if(var6 > var3) {
               return 1;
            }

            return 0;
         }
      }

      return var3;
   }
}
