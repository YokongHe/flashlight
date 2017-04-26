package com.adsdk.sdk.customevents;

import com.adsdk.sdk.customevents.CustomEventBanner;
import java.lang.reflect.Constructor;

public class CustomEventBannerFactory {
   private static CustomEventBannerFactory instance = new CustomEventBannerFactory();

   public static CustomEventBanner create(String var0) {
      return instance.internalCreate(var0);
   }

   protected CustomEventBanner internalCreate(String var1) {
      Constructor var2 = Class.forName("com.adsdk.sdk.customevents." + var1 + "Banner").asSubclass(CustomEventBanner.class).getDeclaredConstructor((Class[])null);
      var2.setAccessible(true);
      return (CustomEventBanner)var2.newInstance(new Object[0]);
   }
}
