package com.flurry.sdk;

import com.flurry.sdk.im;
import com.flurry.sdk.iq;
import com.flurry.sdk.qy;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public final class rb {
   private final EnumMap a;

   private rb(Map var1) {
      this.a = new EnumMap(var1);
   }

   public static rb a(Class var0, iq var1) {
      return b(var0, var1);
   }

   public static rb b(Class var0, iq var1) {
      Enum[] var4 = (Enum[])qy.g(var0).getEnumConstants();
      if(var4 == null) {
         throw new IllegalArgumentException("Can not determine enum constants for Class " + var0.getName());
      } else {
         HashMap var6 = new HashMap();
         int var3 = var4.length;

         for(int var2 = 0; var2 < var3; ++var2) {
            Enum var5 = var4[var2];
            var6.put(var5, new im(var1.a(var5)));
         }

         return new rb(var6);
      }
   }

   public static rb c(Class var0, iq var1) {
      Enum[] var6 = (Enum[])qy.g(var0).getEnumConstants();
      if(var6 == null) {
         throw new IllegalArgumentException("Can not determine enum constants for Class " + var0.getName());
      } else {
         HashMap var5 = new HashMap();
         int var3 = var6.length;

         for(int var2 = 0; var2 < var3; ++var2) {
            Enum var4 = var6[var2];
            var5.put(var4, new im(var4.toString()));
         }

         return new rb(var5);
      }
   }

   public final im a(Enum var1) {
      return (im)this.a.get(var1);
   }
}
