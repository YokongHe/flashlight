package com.flurry.org.codehaus.jackson.annotate;

import java.lang.reflect.Member;
import java.lang.reflect.Modifier;

public enum JsonAutoDetect$Visibility {
   ANY,
   DEFAULT,
   NONE,
   NON_PRIVATE,
   PROTECTED_AND_PUBLIC,
   PUBLIC_ONLY;

   public final boolean isVisible(Member var1) {
      boolean var3 = true;
      boolean var2 = var3;
      switch(null.$SwitchMap$org$codehaus$jackson$annotate$JsonAutoDetect$Visibility[this.ordinal()]) {
      case 1:
         break;
      case 2:
         return false;
      case 3:
         var2 = var3;
         if(Modifier.isPrivate(var1.getModifiers())) {
            return false;
         }
         break;
      case 4:
         var2 = var3;
         if(Modifier.isProtected(var1.getModifiers())) {
            break;
         }
      case 5:
         return Modifier.isPublic(var1.getModifiers());
      default:
         var2 = false;
      }

      return var2;
   }
}
