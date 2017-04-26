package com.mopub.common.util;

import java.lang.reflect.Method;

public class Reflection {
   public static boolean classFound(String var0) {
      try {
         Class.forName(var0);
         return true;
      } catch (ClassNotFoundException var1) {
         return false;
      }
   }

   public static Method getDeclaredMethodWithTraversal(Class var0, String var1, Class... var2) {
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
