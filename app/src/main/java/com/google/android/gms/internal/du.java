package com.google.android.gms.internal;

import com.google.android.gms.internal.dy;
import java.util.HashMap;
import java.util.Map;

final class du implements dy {
   private com.google.android.gms.internal.bL a;

   public du(com.google.android.gms.internal.bL var1) {
      this.a = var1;
   }

   public final void a(boolean var1) {
      HashMap var3 = new HashMap();
      String var2;
      if(var1) {
         var2 = "1";
      } else {
         var2 = "0";
      }

      var3.put("isVisible", var2);
      this.a.a((String)"onAdVisibilityChanged", (Map)var3);
   }
}
