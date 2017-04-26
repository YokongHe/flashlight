package com.flurry.sdk;

import android.view.ViewGroup.LayoutParams;
import com.flurry.android.impl.ads.avro.protocol.v10.AdSpaceLayout;
import com.flurry.sdk.j$c;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

final class j$e extends j$c {
   private static final Map a = a();

   j$e() {
      super(null);
   }

   private static Integer a(String var0) {
      return (Integer)a.get(var0);
   }

   private static Map a() {
      HashMap var0 = new HashMap();
      var0.put("b", Integer.valueOf(12));
      var0.put("t", Integer.valueOf(10));
      var0.put("m", Integer.valueOf(15));
      var0.put("c", Integer.valueOf(14));
      var0.put("l", Integer.valueOf(9));
      var0.put("r", Integer.valueOf(11));
      return Collections.unmodifiableMap(var0);
   }

   public final LayoutParams a(AdSpaceLayout var1) {
      android.widget.RelativeLayout.LayoutParams var2 = new android.widget.RelativeLayout.LayoutParams(this.b(var1), this.c(var1));
      String[] var4 = var1.f().toString().split("-");
      if(var4.length == 2) {
         Integer var3 = a(var4[0]);
         if(var3 != null) {
            var2.addRule(var3.intValue());
         }

         Integer var5 = a(var4[1]);
         if(var5 != null) {
            var2.addRule(var5.intValue());
         }
      }

      return var2;
   }

   public final int g(AdSpaceLayout var1) {
      return -1;
   }
}
