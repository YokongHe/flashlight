package com.flurry.sdk;

import java.lang.reflect.Field;
import java.util.EnumMap;
import java.util.EnumSet;

class qy$a {
   static final qy$a a = new qy$a();
   private final Field b = a(EnumSet.class, "elementType", Class.class);
   private final Field c = a(EnumMap.class, "elementType", Class.class);

   private Object a(Object var1, Field var2) {
      try {
         var1 = var2.get(var1);
         return var1;
      } catch (Exception var3) {
         throw new IllegalArgumentException(var3);
      }
   }

   private static Field a(Class var0, String var1, Class var2) {
      Field[] var5 = var0.getDeclaredFields();
      int var4 = var5.length;
      int var3 = 0;

      Field var7;
      while(true) {
         if(var3 >= var4) {
            var7 = null;
            break;
         }

         var7 = var5[var3];
         if(var1.equals(var7.getName()) && var7.getType() == var2) {
            break;
         }

         ++var3;
      }

      Field var8 = var7;
      if(var7 == null) {
         var4 = var5.length;

         for(var3 = 0; var3 < var4; var7 = var8) {
            var8 = var5[var3];
            if(var8.getType() == var2) {
               if(var7 != null) {
                  var7 = null;
                  return var7;
               }
            } else {
               var8 = var7;
            }

            ++var3;
         }

         var8 = var7;
      }

      var7 = var8;
      if(var8 != null) {
         try {
            var8.setAccessible(true);
            return var8;
         } catch (Throwable var6) {
            return var8;
         }
      } else {
         return var7;
      }
   }

   public Class a(EnumMap var1) {
      if(this.c != null) {
         return (Class)this.a(var1, this.c);
      } else {
         throw new IllegalStateException("Can not figure out type for EnumMap (odd JDK platform?)");
      }
   }

   public Class a(EnumSet var1) {
      if(this.b != null) {
         return (Class)this.a(var1, this.b);
      } else {
         throw new IllegalStateException("Can not figure out type for EnumSet (odd JDK platform?)");
      }
   }
}
