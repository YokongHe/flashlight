package com.google.android.gms.internal;

import com.google.android.gms.internal.dd;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class de {
   public static String a(dd var0) {
      if(var0 == null) {
         return "";
      } else {
         StringBuffer var1 = new StringBuffer();

         try {
            a((String)null, var0, new StringBuffer(), var1);
         } catch (IllegalAccessException var2) {
            return "Error printing proto: " + var2.getMessage();
         } catch (InvocationTargetException var3) {
            return "Error printing proto: " + var3.getMessage();
         }

         return var1.toString();
      }
   }

   private static String a(String var0) {
      StringBuffer var3 = new StringBuffer();

      for(int var2 = 0; var2 < var0.length(); ++var2) {
         char var1 = var0.charAt(var2);
         if(var2 == 0) {
            var3.append(Character.toLowerCase(var1));
         } else if(Character.isUpperCase(var1)) {
            var3.append('_').append(Character.toLowerCase(var1));
         } else {
            var3.append(var1);
         }
      }

      return var3.toString();
   }

   private static void a(String var0, Object var1, StringBuffer var2, StringBuffer var3) {
      if(var1 != null) {
         if(!(var1 instanceof dd)) {
            var0 = a(var0);
            var3.append(var2).append(var0).append(": ");
            if(var1 instanceof String) {
               String var16 = (String)var1;
               var0 = var16;
               if(!var16.startsWith("http")) {
                  var0 = var16;
                  if(var16.length() > 200) {
                     var0 = var16.substring(0, 200) + "[...]";
                  }
               }

               var0 = b(var0);
               var3.append("\"").append(var0).append("\"");
            } else if(var1 instanceof byte[]) {
               a((byte[])var1, var3);
            } else {
               var3.append(var1);
            }

            var3.append("\n");
            return;
         }

         int var7 = var2.length();
         if(var0 != null) {
            var3.append(var2).append(a(var0)).append(" <\n");
            var2.append("  ");
         }

         Class var9 = var1.getClass();
         Field[] var10 = var9.getFields();
         int var8 = var10.length;

         int var4;
         int var5;
         String var11;
         for(var4 = 0; var4 < var8; ++var4) {
            Field var13 = var10[var4];
            var5 = var13.getModifiers();
            var11 = var13.getName();
            if((var5 & 1) == 1 && (var5 & 8) != 8 && !var11.startsWith("_") && !var11.endsWith("_")) {
               Class var12 = var13.getType();
               Object var19 = var13.get(var1);
               if(var12.isArray()) {
                  if(var12.getComponentType() == Byte.TYPE) {
                     a(var11, var19, var2, var3);
                  } else {
                     if(var19 == null) {
                        var5 = 0;
                     } else {
                        var5 = Array.getLength(var19);
                     }

                     for(int var6 = 0; var6 < var5; ++var6) {
                        a(var11, Array.get(var19, var6), var2, var3);
                     }
                  }
               } else {
                  a(var11, var19, var2, var3);
               }
            }
         }

         Method[] var17 = var9.getMethods();
         var5 = var17.length;

         for(var4 = 0; var4 < var5; ++var4) {
            var11 = var17[var4].getName();
            if(var11.startsWith("set")) {
               var11 = var11.substring(3);

               Method var18;
               try {
                  var18 = var9.getMethod("has" + var11, new Class[0]);
               } catch (NoSuchMethodException var15) {
                  continue;
               }

               if(((Boolean)var18.invoke(var1, new Object[0])).booleanValue()) {
                  try {
                     var18 = var9.getMethod("get" + var11, new Class[0]);
                  } catch (NoSuchMethodException var14) {
                     continue;
                  }

                  a(var11, var18.invoke(var1, new Object[0]), var2, var3);
               }
            }
         }

         if(var0 != null) {
            var2.setLength(var7);
            var3.append(var2).append(">\n");
         }
      }

   }

   private static void a(byte[] var0, StringBuffer var1) {
      if(var0 == null) {
         var1.append("\"\"");
      } else {
         var1.append('\"');

         for(int var2 = 0; var2 < var0.length; ++var2) {
            byte var3 = var0[var2];
            if(var3 != 92 && var3 != 34) {
               if(var3 >= 32 && var3 < 127) {
                  var1.append((char)var3);
               } else {
                  var1.append(String.format("\\%03o", new Object[]{Integer.valueOf(var3)}));
               }
            } else {
               var1.append('\\').append((char)var3);
            }
         }

         var1.append('\"');
      }
   }

   private static String b(String var0) {
      int var3 = var0.length();
      StringBuilder var4 = new StringBuilder(var3);

      for(int var2 = 0; var2 < var3; ++var2) {
         char var1 = var0.charAt(var2);
         if(var1 >= 32 && var1 <= 126 && var1 != 34 && var1 != 39) {
            var4.append(var1);
         } else {
            var4.append(String.format("\\u%04x", new Object[]{Integer.valueOf(var1)}));
         }
      }

      return var4.toString();
   }
}
