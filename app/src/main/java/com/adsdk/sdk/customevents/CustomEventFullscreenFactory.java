package com.adsdk.sdk.customevents;

import com.adsdk.sdk.customevents.CustomEventFullscreen;
import java.lang.reflect.Constructor;

public class CustomEventFullscreenFactory {
   private static CustomEventFullscreenFactory instance = new CustomEventFullscreenFactory();

   public static CustomEventFullscreen create(String var0) {
      return instance.internalCreate(var0);
   }

   protected CustomEventFullscreen internalCreate(String var1) {
      Constructor var2 = Class.forName("com.adsdk.sdk.customevents." + var1 + "Fullscreen").asSubclass(CustomEventFullscreen.class).getDeclaredConstructor((Class[])null);
      var2.setAccessible(true);
      return (CustomEventFullscreen)var2.newInstance(new Object[0]);
   }
}
