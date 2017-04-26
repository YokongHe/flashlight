package com.tapjoy.internal;

import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class fh {
   private static final String a = fh.class.getName();

   static Object a(Object var0, Field var1) {
      if(var0 != null && var1 != null) {
         try {
            var0 = var1.get(var0);
            return var0;
         } catch (IllegalAccessException var2) {
            return null;
         } catch (IllegalArgumentException var3) {
            return null;
         } catch (Exception var4) {
            return null;
         }
      } else {
         return null;
      }
   }

   static Object a(Object var0, Method var1, Object... var2) {
      boolean var3 = true;
      if(var1 != null) {
         label24: {
            try {
               var0 = var1.invoke(var0, var2);
            } catch (ClassCastException var4) {
               Log.e(a, var1.getName() + " invoke failed: ", var4);
               var0 = null;
               break label24;
            } catch (IllegalAccessException var5) {
               Log.e(a, var1.getName() + " invoke failed: ", var5);
               var0 = null;
               break label24;
            } catch (IllegalArgumentException var6) {
               Log.e(a, var1.getName() + " invoke failed: ", var6);
               var0 = null;
               break label24;
            } catch (InvocationTargetException var7) {
               Log.e(a, var1.getName() + " invoke failed: ", var7);
               var0 = null;
               break label24;
            } catch (Exception var8) {
               Log.e(a, var1.getName() + " invoke failed: ", var8);
               var0 = null;
               break label24;
            }

            var3 = false;
         }

         if(!var3) {
            return var0;
         }
      }

      return null;
   }

   static Field a(Class var0, String var1) {
      if(var0 == null) {
         return null;
      } else {
         try {
            Field var4 = var0.getDeclaredField(var1);
            return var4;
         } catch (NoSuchFieldException var2) {
            return null;
         } catch (Exception var3) {
            return null;
         }
      }
   }

   static Method a(Class var0, String var1, Class... var2) {
      if(var0 == null) {
         return null;
      } else {
         try {
            Method var5 = var0.getMethod(var1, var2);
            return var5;
         } catch (NoSuchMethodException var3) {
            return null;
         } catch (Exception var4) {
            return null;
         }
      }
   }

   static Class b(String var0) {
      try {
         Class var1 = Class.forName(var0);
         return var1;
      } catch (ClassNotFoundException var2) {
         var0 = a;
         return null;
      } catch (Exception var3) {
         Log.e(a, var0 + " getClass failed: ", var3);
         return null;
      }
   }
}
