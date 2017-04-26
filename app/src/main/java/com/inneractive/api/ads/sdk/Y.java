package com.inneractive.api.ads.sdk;

import android.content.Context;
import com.inneractive.api.ads.sdk.IAmraidWebView;
import com.inneractive.api.ads.sdk.IAmraidWebView$ExpandMode;
import com.inneractive.api.ads.sdk.IAmraidWebView$MraidPlacementType;
import com.inneractive.api.ads.sdk.IAmraidWebView$NativeCloseButtonMode;

final class Y {
   protected static com.inneractive.api.ads.sdk.Y instance = new com.inneractive.api.ads.sdk.Y();

   static IAmraidWebView createInstance(Context var0, com.inneractive.api.ads.sdk.a var1) {
      return instance.createInstanceInternally(var0, var1, IAmraidWebView$ExpandMode.ENABLED, IAmraidWebView$NativeCloseButtonMode.AD_CONTROLLED, IAmraidWebView$MraidPlacementType.INLINE);
   }

   static IAmraidWebView createInstance(Context var0, com.inneractive.api.ads.sdk.a var1, IAmraidWebView$ExpandMode var2, IAmraidWebView$NativeCloseButtonMode var3, IAmraidWebView$MraidPlacementType var4) {
      return instance.createInstanceInternally(var0, var1, var2, var3, var4);
   }

   @Deprecated
   public static void setInstance(com.inneractive.api.ads.sdk.Y var0) {
      instance = var0;
   }

   protected final IAmraidWebView createInstanceInternally(Context var1, com.inneractive.api.ads.sdk.a var2, IAmraidWebView$ExpandMode var3, IAmraidWebView$NativeCloseButtonMode var4, IAmraidWebView$MraidPlacementType var5) {
      IAmraidWebView var6 = new IAmraidWebView(var1, var2, var5);
      var6.initialize(var3, var4);
      return var6;
   }
}
