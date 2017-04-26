package com.mopub.common.factories;

import com.mopub.common.util.Reflection$MethodBuilder;

public class MethodBuilderFactory {
   protected static MethodBuilderFactory instance = new MethodBuilderFactory();

   public static Reflection$MethodBuilder create(Object var0, String var1) {
      return instance.internalCreate(var0, var1);
   }

   @Deprecated
   public static void setInstance(MethodBuilderFactory var0) {
      instance = var0;
   }

   protected Reflection$MethodBuilder internalCreate(Object var1, String var2) {
      return new Reflection$MethodBuilder(var1, var2);
   }
}
