package com.mopub.mobileads.factories;

import com.mopub.mobileads.CustomEventBanner;
import java.lang.reflect.Constructor;

public class CustomEventBannerFactory {
   private static CustomEventBannerFactory instance = new CustomEventBannerFactory();

   public static CustomEventBanner create(String var0) {
      return instance.internalCreate(var0);
   }

   @Deprecated
   public static void setInstance(CustomEventBannerFactory var0) {
      instance = var0;
   }

   protected CustomEventBanner internalCreate(String var1) {
      Constructor var2 = Class.forName(var1).asSubclass(CustomEventBanner.class).getDeclaredConstructor((Class[])null);
      var2.setAccessible(true);
      return (CustomEventBanner)var2.newInstance(new Object[0]);
   }
}
