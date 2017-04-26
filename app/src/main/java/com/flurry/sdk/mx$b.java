package com.flurry.sdk;

import com.flurry.sdk.na;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

class mx$b implements na {
   private mx$b() {
   }

   // $FF: synthetic method
   mx$b(Object var1) {
      this();
   }

   public boolean a(Method var1) {
      return !Modifier.isStatic(var1.getModifiers()) && var1.getParameterTypes().length <= 2;
   }
}
