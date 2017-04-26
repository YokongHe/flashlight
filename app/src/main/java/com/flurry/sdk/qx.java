package com.flurry.sdk;

import com.flurry.sdk.mr;

public class qx {
   public static String a(mr var0) {
      String var3 = var0.b();
      String var2 = b(var0, var3);
      String var1 = var2;
      if(var2 == null) {
         var1 = a(var0, var3);
      }

      return var1;
   }

   public static String a(mr var0, String var1) {
      if(var1.startsWith("get")) {
         if("getCallbacks".equals(var1)) {
            if(c(var0)) {
               return null;
            }
         } else if("getMetaClass".equals(var1) && e(var0)) {
            return null;
         }

         return a(var1.substring(3));
      } else {
         return null;
      }
   }

   protected static String a(String var0) {
      StringBuilder var5 = null;
      int var4 = var0.length();
      if(var4 == 0) {
         var0 = null;
      } else {
         StringBuilder var6;
         for(int var3 = 0; var3 < var4; var5 = var6) {
            char var1 = var0.charAt(var3);
            char var2 = Character.toLowerCase(var1);
            if(var1 == var2) {
               break;
            }

            var6 = var5;
            if(var5 == null) {
               var6 = new StringBuilder(var0);
            }

            var6.setCharAt(var3, var2);
            ++var3;
         }

         if(var5 != null) {
            return var5.toString();
         }
      }

      return var0;
   }

   public static String b(mr var0) {
      String var1 = var0.b();
      if(var1.startsWith("set")) {
         var1 = a(var1.substring(3));
         if(var1 != null && (!"metaClass".equals(var1) || !d(var0))) {
            return var1;
         }
      }

      return null;
   }

   public static String b(mr var0, String var1) {
      if(var1.startsWith("is")) {
         Class var2 = var0.d();
         if(var2 == Boolean.class || var2 == Boolean.TYPE) {
            return a(var1.substring(2));
         }
      }

      return null;
   }

   protected static boolean c(mr var0) {
      Class var1 = var0.d();
      if(var1 != null && var1.isArray()) {
         Package var2 = var1.getComponentType().getPackage();
         if(var2 != null) {
            String var3 = var2.getName();
            if(var3.startsWith("net.sf.cglib") || var3.startsWith("org.hibernate.repackage.cglib")) {
               return true;
            }
         }
      }

      return false;
   }

   protected static boolean d(mr var0) {
      boolean var2 = false;
      Package var3 = var0.a(0).getPackage();
      boolean var1 = var2;
      if(var3 != null) {
         var1 = var2;
         if(var3.getName().startsWith("groovy.lang")) {
            var1 = true;
         }
      }

      return var1;
   }

   protected static boolean e(mr var0) {
      Class var1 = var0.d();
      if(var1 != null && !var1.isArray()) {
         Package var2 = var1.getPackage();
         if(var2 != null && var2.getName().startsWith("groovy.lang")) {
            return true;
         }
      }

      return false;
   }
}
