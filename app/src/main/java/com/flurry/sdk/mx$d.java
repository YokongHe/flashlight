package com.flurry.sdk;

import com.flurry.sdk.na;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

@Deprecated
public class mx$d implements na {
   public boolean a(Method var1) {
      if(Modifier.isStatic(var1.getModifiers())) {
         return false;
      } else {
         switch(var1.getParameterTypes().length) {
         case 1:
            return true;
         case 2:
            return true;
         default:
            return false;
         }
      }
   }
}
