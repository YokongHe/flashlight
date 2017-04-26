package com.inneractive.api.ads.sdk;

import com.inneractive.api.ads.sdk.IAmraidWebView;
import com.inneractive.api.ads.sdk.IAmraidWebView$MraidPlacementType;
import java.util.Map;

abstract class A {
   protected Map a;
   protected IAmraidWebView b;

   A(Map var1, IAmraidWebView var2) {
      this.a = var1;
      this.b = var2;
   }

   protected final int a(String var1) {
      var1 = (String)this.a.get(var1);
      if(var1 == null) {
         return -1;
      } else {
         try {
            int var2 = Integer.parseInt(var1, 10);
            return var2;
         } catch (NumberFormatException var3) {
            return -1;
         }
      }
   }

   abstract void a();

   protected boolean a(IAmraidWebView$MraidPlacementType var1) {
      return false;
   }

   protected final String b(String var1) {
      return (String)this.a.get(var1);
   }

   protected final boolean c(String var1) {
      return "true".equals(this.a.get(var1));
   }
}
