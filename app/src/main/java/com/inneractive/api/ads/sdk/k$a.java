package com.inneractive.api.ads.sdk;

import java.util.HashMap;
import java.util.Map;

class k$a {
   private Map a = new HashMap();
   private com.inneractive.api.ads.sdk.l b = new com.inneractive.api.ads.sdk.l();

   public int a(String var1) {
      Object var2 = this.a.get(var1);
      return var2 == null?-1:((Integer)var2).intValue();
   }

   public void a(String var1, int var2) {
      this.a.put(var1, new Integer(var2));
      this.b.a(var2, var1);
   }
}
