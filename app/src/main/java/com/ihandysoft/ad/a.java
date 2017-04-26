package com.ihandysoft.ad;

import android.content.Context;

public enum a {
   a,
   b,
   c;

   public static com.ihandysoft.ad.a a(Context var0) {
      if(var0 == null) {
         return a;
      } else {
         int var1 = var0.getResources().getConfiguration().screenLayout & 15;
         int var2 = var0.getResources().getConfiguration().orientation;
         return var1 >= 4?c:(var1 == 3?(var2 == 2?c:b):a);
      }
   }
}
