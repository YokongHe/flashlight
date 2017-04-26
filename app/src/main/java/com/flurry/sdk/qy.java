package com.flurry.sdk;

import com.flurry.sdk.qy$a;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;

public final class qy {
   public static Class a(Enum var0) {
      Class var1 = var0.getClass();
      Class var2 = var1;
      if(var1.getSuperclass() != Enum.class) {
         var2 = var1.getSuperclass();
      }

      return var2;
   }

   public static Class a(EnumMap var0) {
      return !var0.isEmpty()?a((Enum)var0.keySet().iterator().next()):qy$a.a.a(var0);
   }

   public static Class a(EnumSet var0) {
      return !var0.isEmpty()?a((Enum)var0.iterator().next()):qy$a.a.a(var0);
   }

   public static String a(Class var0) {
      return var0.isAnnotation()?"annotation":(var0.isArray()?"array":(var0.isEnum()?"enum":(var0.isPrimitive()?"primitive":null)));
   }

   public static String a(Class param0, boolean param1) {
      // $FF: Couldn't be decompiled
   }

   public static Throwable a(Throwable var0) {
      while(var0.getCause() != null) {
         var0 = var0.getCause();
      }

      return var0;
   }

   public static List a(Class var0, Class var1) {
      return a(var0, var1, new ArrayList(8));
   }

   public static List a(Class var0, Class var1, List var2) {
      a(var0, var1, var2, false);
      return var2;
   }

   private static void a(Class var0, Class var1, Collection var2, boolean var3) {
      while(var0 != var1 && var0 != null && var0 != Object.class) {
         if(var3) {
            if(var2.contains(var0)) {
               break;
            }

            var2.add(var0);
         }

         Class[] var6 = var0.getInterfaces();
         int var5 = var6.length;

         for(int var4 = 0; var4 < var5; ++var4) {
            a(var6[var4], var1, var2, true);
         }

         var0 = var0.getSuperclass();
         var3 = true;
      }

   }

   public static void a(Throwable var0, String var1) {
      if(var0 instanceof RuntimeException) {
         throw (RuntimeException)var0;
      } else if(var0 instanceof Error) {
         throw (Error)var0;
      } else {
         throw new IllegalArgumentException(var1, var0);
      }
   }

   public static void a(Member var0) {
      AccessibleObject var2 = (AccessibleObject)var0;

      try {
         var2.setAccessible(true);
      } catch (SecurityException var3) {
         if(!var2.isAccessible()) {
            Class var4 = var0.getDeclaringClass();
            throw new IllegalArgumentException("Can not access " + var0 + " (from class " + var4.getName() + "; failed to set access: " + var3.getMessage());
         }
      }

   }

   public static boolean a(Method var0) {
      if(!Modifier.isStatic(var0.getModifiers())) {
         Class[] var1 = var0.getParameterTypes();
         if((var1 == null || var1.length == 0) && Void.TYPE != var0.getReturnType()) {
            return true;
         }
      }

      return false;
   }

   public static Class b(Class var0) {
      try {
         if(var0.getEnclosingMethod() != null) {
            return null;
         }

         if(!Modifier.isStatic(var0.getModifiers())) {
            var0 = var0.getEnclosingClass();
            return var0;
         }
      } catch (SecurityException var1) {
         ;
      } catch (NullPointerException var2) {
         return null;
      }

      return null;
   }

   public static Object b(Class var0, boolean var1) {
      Constructor var2 = c(var0, var1);
      if(var2 == null) {
         throw new IllegalArgumentException("Class " + var0.getName() + " has no default (no arg) constructor");
      } else {
         try {
            Object var4 = var2.newInstance(new Object[0]);
            return var4;
         } catch (Exception var3) {
            b(var3, "Failed to instantiate class " + var0.getName() + ", problem: " + var3.getMessage());
            return null;
         }
      }
   }

   public static void b(Throwable var0) {
      a(var0, var0.getMessage());
   }

   public static void b(Throwable var0, String var1) {
      a(a(var0), var1);
   }

   public static Constructor c(Class param0, boolean param1) {
      // $FF: Couldn't be decompiled
   }

   public static void c(Throwable var0) {
      b(a(var0));
   }

   public static boolean c(Class var0) {
      if(!Proxy.isProxyClass(var0)) {
         String var1 = var0.getName();
         if(!var1.startsWith("net.sf.cglib.proxy.") && !var1.startsWith("org.hibernate.proxy.")) {
            return false;
         }
      }

      return true;
   }

   public static boolean d(Class var0) {
      return (var0.getModifiers() & 1536) == 0;
   }

   public static boolean e(Class var0) {
      return var0.isArray() || Collection.class.isAssignableFrom(var0) || Map.class.isAssignableFrom(var0);
   }

   public static Object f(Class var0) {
      if(var0 == Integer.TYPE) {
         return Integer.valueOf(0);
      } else if(var0 == Long.TYPE) {
         return Long.valueOf(0L);
      } else if(var0 == Boolean.TYPE) {
         return Boolean.FALSE;
      } else if(var0 == Double.TYPE) {
         return Double.valueOf(0.0D);
      } else if(var0 == Float.TYPE) {
         return Float.valueOf(0.0F);
      } else if(var0 == Byte.TYPE) {
         return Byte.valueOf((byte)0);
      } else if(var0 == Short.TYPE) {
         return Short.valueOf((short)0);
      } else if(var0 == Character.TYPE) {
         return Character.valueOf('\u0000');
      } else {
         throw new IllegalArgumentException("Class " + var0.getName() + " is not a primitive type");
      }
   }

   public static Class g(Class var0) {
      Class var1 = var0;
      if(var0.getSuperclass() != Enum.class) {
         var1 = var0.getSuperclass();
      }

      return var1;
   }
}
