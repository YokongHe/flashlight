package com.flurry.sdk;

import com.flurry.sdk.iq;
import java.util.HashMap;

public class ra {
   protected final Class a;
   protected final Enum[] b;
   protected final HashMap c;

   protected ra(Class var1, Enum[] var2, HashMap var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public static ra a(Class var0) {
      Enum[] var2 = (Enum[])var0.getEnumConstants();
      HashMap var3 = new HashMap();
      int var1 = var2.length;

      while(true) {
         --var1;
         if(var1 < 0) {
            return new ra(var0, var2, var3);
         }

         Enum var4 = var2[var1];
         var3.put(var4.toString(), var4);
      }
   }

   public static ra a(Class var0, iq var1) {
      Enum[] var4 = (Enum[])var0.getEnumConstants();
      if(var4 == null) {
         throw new IllegalArgumentException("No enum constants for class " + var0.getName());
      } else {
         HashMap var5 = new HashMap();
         int var3 = var4.length;

         for(int var2 = 0; var2 < var3; ++var2) {
            Enum var6 = var4[var2];
            var5.put(var1.a(var6), var6);
         }

         return new ra(var0, var4, var5);
      }
   }

   public static ra b(Class var0) {
      return a(var0);
   }

   public static ra b(Class var0, iq var1) {
      return a(var0, var1);
   }

   public Class a() {
      return this.a;
   }

   public Enum a(int var1) {
      return var1 >= 0 && var1 < this.b.length?this.b[var1]:null;
   }

   public Enum a(String var1) {
      return (Enum)this.c.get(var1);
   }

   public int b() {
      return this.b.length - 1;
   }
}
