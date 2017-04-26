package com.flurry.sdk;

import com.flurry.sdk.mx$d;
import com.flurry.sdk.qy;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;

@Deprecated
public final class mx$c extends mx$d {
   public final boolean a(Method var1) {
      if(!super.a(var1)) {
         if(!qy.a(var1)) {
            return false;
         }

         Class var2 = var1.getReturnType();
         if(!Collection.class.isAssignableFrom(var2) && !Map.class.isAssignableFrom(var2)) {
            return false;
         }
      }

      return true;
   }
}
