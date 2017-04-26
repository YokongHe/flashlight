package com.inneractive.api.ads.sdk;

import com.inneractive.api.ads.sdk.IAmraidActionFactory$MraidJavascriptCommand;
import com.inneractive.api.ads.sdk.IAmraidWebView;
import java.util.Map;

final class IAmraidActionFactory {
   private static IAmraidActionFactory a = new IAmraidActionFactory();

   static A a(String var0, Map var1, IAmraidWebView var2) {
      IAmraidActionFactory var3 = a;
      IAmraidActionFactory$MraidJavascriptCommand var4 = IAmraidActionFactory$MraidJavascriptCommand.a(var0);
      switch(null.a[var4.ordinal()]) {
      case 1:
         return new B(var1, var2);
      case 2:
         return new com.inneractive.api.ads.sdk.D(var1, var2);
      case 3:
         return new com.inneractive.api.ads.sdk.P(var1, var2);
      case 4:
         return new J(var1, var2);
      case 5:
         return new com.inneractive.api.ads.sdk.L(var1, var2);
      case 6:
         return new H(var1, var2);
      case 7:
         return new N(var1, var2);
      case 8:
         return new M(var1, var2);
      case 9:
         return new K(var1, var2);
      case 10:
         return new com.inneractive.api.ads.sdk.O(var1, var2);
      case 11:
         return new com.inneractive.api.ads.sdk.E(var1, var2);
      case 12:
         return new com.inneractive.api.ads.sdk.F(var1, var2);
      case 13:
         return new com.inneractive.api.ads.sdk.G(var1, var2);
      case 14:
         return new com.inneractive.api.ads.sdk.I(var1, var2);
      case 15:
         return new com.inneractive.api.ads.sdk.C(var1, var2);
      case 16:
      default:
         return null;
      }
   }
}
