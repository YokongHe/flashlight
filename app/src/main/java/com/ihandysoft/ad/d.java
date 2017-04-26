package com.ihandysoft.ad;

import com.ihandysoft.ad.HSAdBannerView;
import java.util.Comparator;
import java.util.Map;

final class d implements Comparator {
   // $FF: synthetic field
   final HSAdBannerView a;

   private d(HSAdBannerView var1) {
      this.a = var1;
   }

   // $FF: synthetic method
   d(HSAdBannerView var1, byte var2) {
      this(var1);
   }

   // $FF: synthetic method
   public final int compare(Object var1, Object var2) {
      Map var5 = (Map)var1;
      Map var6 = (Map)var2;
      float var3 = com.ihandysoft.ad.b.b.b(var5.get("cpm"));
      float var4 = com.ihandysoft.ad.b.b.b(var6.get("cpm"));
      return var3 > var4?-1:(var3 < var4?1:0);
   }
}
