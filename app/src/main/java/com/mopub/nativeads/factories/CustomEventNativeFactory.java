package com.mopub.nativeads.factories;

import com.mopub.common.Preconditions;
import com.mopub.nativeads.CustomEventNative;
import com.mopub.nativeads.MoPubCustomEventNative;
import java.lang.reflect.Constructor;

public class CustomEventNativeFactory {
   protected static CustomEventNativeFactory instance = new CustomEventNativeFactory();

   public static CustomEventNative create(String var0) {
      if(var0 != null) {
         Class var1 = Class.forName(var0).asSubclass(CustomEventNative.class);
         return instance.internalCreate(var1);
      } else {
         return new MoPubCustomEventNative();
      }
   }

   @Deprecated
   public static void setInstance(CustomEventNativeFactory var0) {
      Preconditions.checkNotNull(var0);
      instance = var0;
   }

   protected CustomEventNative internalCreate(Class var1) {
      Preconditions.checkNotNull(var1);
      Constructor var2 = var1.getDeclaredConstructor((Class[])null);
      var2.setAccessible(true);
      return (CustomEventNative)var2.newInstance(new Object[0]);
   }
}
