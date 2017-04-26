package com.adsdk.sdk.customevents;

import com.adsdk.sdk.customevents.CustomEventNative;
import java.lang.reflect.Constructor;

public class CustomEventNativeFactory {
   private static CustomEventNativeFactory instance = new CustomEventNativeFactory();

   public static CustomEventNative create(String var0) {
      return instance.internalCreate(var0);
   }

   protected CustomEventNative internalCreate(String var1) {
      Constructor var2 = Class.forName("com.adsdk.sdk.customevents." + var1 + "Native").asSubclass(CustomEventNative.class).getDeclaredConstructor((Class[])null);
      var2.setAccessible(true);
      return (CustomEventNative)var2.newInstance(new Object[0]);
   }
}
