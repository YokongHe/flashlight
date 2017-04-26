package com.mopub.mobileads.factories;

import android.content.Context;
import com.mopub.mobileads.AdViewController;
import com.mopub.mobileads.MoPubView;

public class AdViewControllerFactory {
   protected static AdViewControllerFactory instance = new AdViewControllerFactory();

   public static AdViewController create(Context var0, MoPubView var1) {
      return instance.internalCreate(var0, var1);
   }

   @Deprecated
   public static void setInstance(AdViewControllerFactory var0) {
      instance = var0;
   }

   protected AdViewController internalCreate(Context var1, MoPubView var2) {
      return new AdViewController(var1, var2);
   }
}
