package com.ihandysoft.ad;

import com.ihandysoft.ad.HSAdBannerView;
import java.util.Comparator;

final class c implements Comparator {
   // $FF: synthetic field
   final HSAdBannerView a;

   private c(HSAdBannerView var1) {
      this.a = var1;
   }

   // $FF: synthetic method
   c(HSAdBannerView var1, byte var2) {
      this(var1);
   }

   // $FF: synthetic method
   public final int compare(Object var1, Object var2) {
      com.ihandysoft.ad.a.a var5 = (com.ihandysoft.ad.a.a)var1;
      com.ihandysoft.ad.a.a var6 = (com.ihandysoft.ad.a.a)var2;
      float var3 = var5.g();
      float var4 = var6.g();
      return var3 > var4?-1:(var3 < var4?1:0);
   }
}
