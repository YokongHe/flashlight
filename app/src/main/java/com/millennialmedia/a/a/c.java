package com.millennialmedia.a.a;

import java.lang.reflect.Field;

public enum c implements com.millennialmedia.a.a.d {
   a {
      public final String a(Field var1) {
         return var1.getName();
      }
   },
   b {
      public final String a(Field var1) {
         return com.millennialmedia.a.a.c.a(var1.getName());
      }
   },
   c {
      public final String a(Field var1) {
         return com.millennialmedia.a.a.c.a(com.millennialmedia.a.a.c.a(var1.getName(), " "));
      }
   },
   d {
      public final String a(Field var1) {
         return com.millennialmedia.a.a.c.a(var1.getName(), "_").toLowerCase();
      }
   },
   e {
      public final String a(Field var1) {
         return com.millennialmedia.a.a.c.a(var1.getName(), "-").toLowerCase();
      }
   };

   private c() {
   }

   // $FF: synthetic method
   c(byte var3) {
      this();
   }

   // $FF: synthetic method
   static String a(String var0) {
      int var2 = 0;
      StringBuilder var4 = new StringBuilder();

      char var1;
      for(var1 = var0.charAt(0); var2 < var0.length() - 1 && !Character.isLetter(var1); var1 = var0.charAt(var2)) {
         var4.append(var1);
         ++var2;
      }

      String var3;
      if(var2 == var0.length()) {
         var3 = var4.toString();
      } else {
         var3 = var0;
         if(!Character.isUpperCase(var1)) {
            var1 = Character.toUpperCase(var1);
            ++var2;
            if(var2 < var0.length()) {
               var0 = var1 + var0.substring(var2);
            } else {
               var0 = String.valueOf(var1);
            }

            return var4.append(var0).toString();
         }
      }

      return var3;
   }

   // $FF: synthetic method
   static String a(String var0, String var1) {
      StringBuilder var4 = new StringBuilder();

      for(int var3 = 0; var3 < var0.length(); ++var3) {
         char var2 = var0.charAt(var3);
         if(Character.isUpperCase(var2) && var4.length() != 0) {
            var4.append(var1);
         }

         var4.append(var2);
      }

      return var4.toString();
   }
}
