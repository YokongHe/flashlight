package com.tapjoy.internal;

import java.util.Map;

public final class hl {
   public static void a(StringBuffer var0, Object var1, Map var2) {
      if(var1 == null) {
         var0.append("null");
      } else if(!var1.getClass().isArray()) {
         try {
            var0.append(var1.toString());
         } catch (Throwable var3) {
            System.err.println("SLF4J: Failed toString() invocation on an object of type [" + var1.getClass().getName() + "]");
            var3.printStackTrace();
            var0.append("[FAILED toString()]");
         }
      } else if(var1 instanceof boolean[]) {
         a(var0, (boolean[])var1);
      } else if(var1 instanceof byte[]) {
         a(var0, (byte[])var1);
      } else if(var1 instanceof char[]) {
         a(var0, (char[])var1);
      } else if(var1 instanceof short[]) {
         a(var0, (short[])var1);
      } else if(var1 instanceof int[]) {
         a(var0, (int[])var1);
      } else if(var1 instanceof long[]) {
         a(var0, (long[])var1);
      } else if(var1 instanceof float[]) {
         a(var0, (float[])var1);
      } else if(var1 instanceof double[]) {
         a(var0, (double[])var1);
      } else {
         a(var0, (Object[])var1, var2);
      }
   }

   private static void a(StringBuffer var0, byte[] var1) {
      var0.append('[');
      int var3 = var1.length;

      for(int var2 = 0; var2 < var3; ++var2) {
         var0.append(var1[var2]);
         if(var2 != var3 - 1) {
            var0.append(", ");
         }
      }

      var0.append(']');
   }

   private static void a(StringBuffer var0, char[] var1) {
      var0.append('[');
      int var3 = var1.length;

      for(int var2 = 0; var2 < var3; ++var2) {
         var0.append(var1[var2]);
         if(var2 != var3 - 1) {
            var0.append(", ");
         }
      }

      var0.append(']');
   }

   private static void a(StringBuffer var0, double[] var1) {
      var0.append('[');
      int var3 = var1.length;

      for(int var2 = 0; var2 < var3; ++var2) {
         var0.append(var1[var2]);
         if(var2 != var3 - 1) {
            var0.append(", ");
         }
      }

      var0.append(']');
   }

   private static void a(StringBuffer var0, float[] var1) {
      var0.append('[');
      int var3 = var1.length;

      for(int var2 = 0; var2 < var3; ++var2) {
         var0.append(var1[var2]);
         if(var2 != var3 - 1) {
            var0.append(", ");
         }
      }

      var0.append(']');
   }

   private static void a(StringBuffer var0, int[] var1) {
      var0.append('[');
      int var3 = var1.length;

      for(int var2 = 0; var2 < var3; ++var2) {
         var0.append(var1[var2]);
         if(var2 != var3 - 1) {
            var0.append(", ");
         }
      }

      var0.append(']');
   }

   private static void a(StringBuffer var0, long[] var1) {
      var0.append('[');
      int var3 = var1.length;

      for(int var2 = 0; var2 < var3; ++var2) {
         var0.append(var1[var2]);
         if(var2 != var3 - 1) {
            var0.append(", ");
         }
      }

      var0.append(']');
   }

   private static void a(StringBuffer var0, Object[] var1, Map var2) {
      var0.append('[');
      if(!var2.containsKey(var1)) {
         var2.put(var1, (Object)null);
         int var4 = var1.length;

         for(int var3 = 0; var3 < var4; ++var3) {
            a(var0, var1[var3], var2);
            if(var3 != var4 - 1) {
               var0.append(", ");
            }
         }

         var2.remove(var1);
      } else {
         var0.append("...");
      }

      var0.append(']');
   }

   private static void a(StringBuffer var0, short[] var1) {
      var0.append('[');
      int var3 = var1.length;

      for(int var2 = 0; var2 < var3; ++var2) {
         var0.append(var1[var2]);
         if(var2 != var3 - 1) {
            var0.append(", ");
         }
      }

      var0.append(']');
   }

   private static void a(StringBuffer var0, boolean[] var1) {
      var0.append('[');
      int var3 = var1.length;

      for(int var2 = 0; var2 < var3; ++var2) {
         var0.append(var1[var2]);
         if(var2 != var3 - 1) {
            var0.append(", ");
         }
      }

      var0.append(']');
   }
}
