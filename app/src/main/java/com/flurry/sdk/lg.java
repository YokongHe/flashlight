package com.flurry.sdk;

import com.flurry.sdk.hj;
import com.flurry.sdk.iz;
import com.flurry.sdk.kt;
import com.flurry.sdk.sq;
import java.util.ArrayList;

public class lg {
   protected final ArrayList a = new ArrayList();

   public Object a(hj var1, iz var2, Object var3, sq var4) {
      int var6 = this.a.size();

      for(int var5 = 0; var5 < var6; ++var5) {
         kt var8 = (kt)this.a.get(var5);
         hj var7 = var4.h();
         var7.b();
         var8.a(var7, var2, var3);
      }

      return var3;
   }

   public void a(kt var1) {
      this.a.add(var1);
   }
}
