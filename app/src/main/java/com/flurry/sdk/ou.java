package com.flurry.sdk;

import com.flurry.sdk.jk;
import com.flurry.sdk.ou$a;
import com.flurry.sdk.ox$a;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class ou {
   private final ou$a[] a;
   private final int b;

   public ou(Map var1) {
      int var2 = a(var1.size());
      this.b = var2;
      ou$a[] var4 = new ou$a[var2];

      int var3;
      Entry var5;
      ox$a var6;
      for(Iterator var7 = var1.entrySet().iterator(); var7.hasNext(); var4[var3] = new ou$a(var4[var3], var6, (jk)var5.getValue())) {
         var5 = (Entry)var7.next();
         var6 = (ox$a)var5.getKey();
         var3 = var6.hashCode() & var2 - 1;
      }

      this.a = var4;
   }

   private static final int a(int var0) {
      if(var0 <= 64) {
         var0 += var0;
      } else {
         var0 += var0 >> 2;
      }

      int var1;
      for(var1 = 8; var1 < var0; var1 += var1) {
         ;
      }

      return var1;
   }

   public jk a(ox$a var1) {
      int var2 = var1.hashCode();
      int var3 = this.a.length;
      ou$a var5 = this.a[var2 & var3 - 1];
      if(var5 == null) {
         return null;
      } else {
         ou$a var4 = var5;
         if(var1.equals(var5.a)) {
            return var5.b;
         } else {
            do {
               var5 = var4.c;
               if(var5 == null) {
                  return null;
               }

               var4 = var5;
            } while(!var1.equals(var5.a));

            return var5.b;
         }
      }
   }
}
