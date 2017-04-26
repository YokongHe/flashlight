package com.ihs.a.e;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class g {
   public static int a(Map var0, int var1, String... var2) {
      try {
         int var3 = a(var0, var2);
         return var3;
      } catch (RuntimeException var4) {
         return var1;
      }
   }

   public static int a(Map var0, String... var1) {
      Object var4 = f(var0, var1);
      if(var4 != null) {
         if(var4 instanceof Integer) {
            return ((Integer)var4).intValue();
         }

         if(var4 instanceof Double) {
            return ((Double)var4).intValue();
         }

         if(var4 instanceof Float) {
            return ((Float)var4).intValue();
         }

         if(var4 instanceof String) {
            try {
               int var2 = Integer.parseInt(((String)var4).trim());
               return var2;
            } catch (NumberFormatException var3) {
               ;
            }
         }
      }

      (new StringBuilder("Error, Invalid Integer : ")).append(var1[var1.length - 1]).toString();
      throw new RuntimeException("Invalid Integer config");
   }

   public static String a(Map var0, String var1, String... var2) {
      String var3 = c(var0, var2);
      return var3 == null?var1:var3;
   }

   public static Date a(Map var0, Date var1, String... var2) {
      Object var3 = f(var0, var2);
      Date var4;
      if(var3 != null && var3 instanceof Date) {
         var4 = (Date)var3;
      } else {
         var4 = null;
      }

      return var4 == null?var1:var4;
   }

   public static void a(Map var0, Map var1) {
      boolean var3 = true;
      boolean var2;
      if(var1 != null && var0 != null) {
         if(var1 != var0) {
            Iterator var6 = var1.entrySet().iterator();

            while(true) {
               while(var6.hasNext()) {
                  Entry var7 = (Entry)var6.next();
                  if(!var0.containsKey(var7.getKey())) {
                     var0.put(var7.getKey(), var7.getValue());
                  } else {
                     var2 = var7.getValue() instanceof Map;
                     var3 = var0.get(var7.getKey()) instanceof Map;
                     if(var2 && var3) {
                        a((Map)var0.get(var7.getKey()), (Map)var7.getValue());
                     } else {
                        var0.put(var7.getKey(), var7.getValue());
                        if(var2 != var3) {
                           (new StringBuilder("Entry type does not match:")).append((String)var7.getKey()).toString();
                        }
                     }
                  }
               }

               return;
            }
         }
      } else {
         StringBuilder var4 = new StringBuilder("srcMap null = ");
         if(var1 == null) {
            var2 = true;
         } else {
            var2 = false;
         }

         StringBuilder var5 = var4.append(var2).append(", destMap null = ");
         if(var0 == null) {
            var2 = var3;
         } else {
            var2 = false;
         }

         var5.append(var2).toString();
      }

   }

   public static boolean a(Map var0, boolean var1, String... var2) {
      try {
         var1 = b(var0, var2);
         return var1;
      } catch (RuntimeException var3) {
         return false;
      }
   }

   public static boolean b(Map var0, String... var1) {
      Object var2 = f(var0, var1);
      if(var2 != null && var2 instanceof Boolean) {
         return ((Boolean)var2).booleanValue();
      } else {
         (new StringBuilder("Error, Invalid Boolean : ")).append(var1[var1.length - 1]).toString();
         throw new RuntimeException("Invalid Boolean config.");
      }
   }

   public static String c(Map var0, String... var1) {
      Object var2 = f(var0, var1);
      if(var2 != null) {
         if(var2 instanceof String) {
            return (String)var2;
         }

         if(var2 instanceof Integer || var2 instanceof Double || var2 instanceof Float) {
            return String.valueOf(var2);
         }
      }

      return null;
   }

   public static List d(Map var0, String... var1) {
      Object var2 = f(var0, var1);
      return var2 != null && var2 instanceof List?(List)var2:null;
   }

   public static Map e(Map var0, String... var1) {
      Object var2 = f(var0, var1);
      return var2 != null && var2 instanceof Map?(Map)var2:null;
   }

   private static Object f(Map var0, String... var1) {
      Object var6;
      if(var0 != null && !var0.isEmpty()) {
         int var4 = var1.length;
         int var2 = 0;
         int var3 = 0;
         Object var5 = var0;

         while(true) {
            var6 = var5;
            if(var2 >= var4) {
               break;
            }

            String var7 = var1[var2];
            var5 = ((Map)var5).get(var7);
            ++var3;
            var6 = var5;
            if(var3 == var1.length) {
               break;
            }

            if(var5 == null || !(var5 instanceof Map)) {
               return null;
            }

            ++var2;
         }
      } else {
         var6 = null;
      }

      return var6;
   }
}
