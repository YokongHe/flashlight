package com.flurry.sdk;

import com.flurry.sdk.nw;
import com.flurry.sdk.qs;
import com.flurry.sdk.qy;
import com.flurry.sdk.sh;
import java.util.EnumMap;
import java.util.EnumSet;

public class nr extends nw {
   public nr(sh var1, qs var2) {
      super(var1, var2);
   }

   public sh a(String var1) {
      if(var1.indexOf(60) > 0) {
         return qs.a(var1);
      } else {
         try {
            Class var2 = Class.forName(var1, true, Thread.currentThread().getContextClassLoader());
            sh var5 = this.c.a(this.d, var2);
            return var5;
         } catch (ClassNotFoundException var3) {
            throw new IllegalArgumentException("Invalid type id \'" + var1 + "\' (for id type \'Id.class\'): no such class found");
         } catch (Exception var4) {
            throw new IllegalArgumentException("Invalid type id \'" + var1 + "\' (for id type \'Id.class\'): " + var4.getMessage(), var4);
         }
      }
   }

   public String a(Object var1) {
      return this.b(var1, var1.getClass());
   }

   public String a(Object var1, Class var2) {
      return this.b(var1, var2);
   }

   protected final String b(Object var1, Class var2) {
      Class var3 = var2;
      if(Enum.class.isAssignableFrom(var2)) {
         var3 = var2;
         if(!var2.isEnum()) {
            var3 = var2.getSuperclass();
         }
      }

      String var6 = var3.getName();
      String var5;
      if(var6.startsWith("java.util")) {
         Class var4;
         if(var1 instanceof EnumSet) {
            var4 = qy.a((EnumSet)var1);
            var5 = qs.a().b(EnumSet.class, var4).m();
         } else {
            if(var1 instanceof EnumMap) {
               var4 = qy.a((EnumMap)var1);
               return qs.a().a(EnumMap.class, var4, Object.class).m();
            }

            String var7 = var6.substring(9);
            if(!var7.startsWith(".Arrays$")) {
               var5 = var6;
               if(!var7.startsWith(".Collections$")) {
                  return var5;
               }
            }

            var5 = var6;
            if(var6.indexOf("List") >= 0) {
               return "java.util.ArrayList";
            }
         }
      } else {
         var5 = var6;
         if(var6.indexOf(36) >= 0) {
            var5 = var6;
            if(qy.b(var3) != null) {
               var5 = var6;
               if(qy.b(this.d.p()) == null) {
                  return this.d.p().getName();
               }
            }
         }
      }

      return var5;
   }
}
