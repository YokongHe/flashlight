package com.mopub.mobileads.factories;

import com.mopub.mobileads.CustomEventInterstitial;
import java.lang.reflect.Constructor;

public class CustomEventInterstitialFactory {
   private static CustomEventInterstitialFactory instance = new CustomEventInterstitialFactory();

   public static CustomEventInterstitial create(String var0) {
      return instance.internalCreate(var0);
   }

   @Deprecated
   public static void setInstance(CustomEventInterstitialFactory var0) {
      instance = var0;
   }

   protected CustomEventInterstitial internalCreate(String var1) {
      Constructor var2 = Class.forName(var1).asSubclass(CustomEventInterstitial.class).getDeclaredConstructor((Class[])null);
      var2.setAccessible(true);
      return (CustomEventInterstitial)var2.newInstance(new Object[0]);
   }
}
