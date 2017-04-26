package com.inneractive.api.ads.sdk;

import java.lang.reflect.Method;

class IAreflectionHandler {
   static Method a(Class var0, String var1, Class... var2) {
      while(var0 != null) {
         try {
            Method var3 = var0.getDeclaredMethod(var1, var2);
            return var3;
         } catch (NoSuchMethodException var4) {
            var0 = var0.getSuperclass();
         }
      }

      throw new NoSuchMethodException();
   }
}
