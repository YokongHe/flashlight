package com.tapjoy.internal;

import java.util.Iterator;
import java.util.LinkedHashMap;

public final class aw extends com.tapjoy.internal.av {
   private final LinkedHashMap a = new LinkedHashMap(0, 0.75F, true);
   private int b = 10;

   private void a() {
      int var1 = this.a.size() - this.b;
      if(var1 > 0) {
         Iterator var2 = this.a.entrySet().iterator();

         while(var1 > 0 && var2.hasNext()) {
            --var1;
            var2.next();
            var2.remove();
         }
      }

   }

   protected final com.tapjoy.internal.at a(Object var1, boolean var2) {
      com.tapjoy.internal.ar var4 = (com.tapjoy.internal.ar)this.a.get(var1);
      com.tapjoy.internal.ar var3 = var4;
      if(var4 == null) {
         var3 = var4;
         if(var2) {
            var3 = new com.tapjoy.internal.ar(var1);
            this.a.put(var1, var3);
            this.a();
         }
      }

      return var3;
   }

   public final void a(Object var1, Object var2) {
      super.a(var1, var2);
      this.a();
   }
}
