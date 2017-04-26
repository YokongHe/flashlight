package com.millennialmedia.a.a.b;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;

public final class b {
   static final Type[] a = new Type[0];

   // $FF: synthetic method
   static int a(Object var0) {
      return var0 != null?var0.hashCode():0;
   }

   public static Type a(Type var0) {
      if(var0 instanceof Class) {
         Object var3 = (Class)var0;
         if(((Class)var3).isArray()) {
            var3 = new com.millennialmedia.a.a.b.c(a((Type)((Class)var3).getComponentType()));
         }

         return (Type)var3;
      } else if(var0 instanceof ParameterizedType) {
         ParameterizedType var2 = (ParameterizedType)var0;
         return new com.millennialmedia.a.a.b.d(var2.getOwnerType(), var2.getRawType(), var2.getActualTypeArguments());
      } else if(var0 instanceof GenericArrayType) {
         return new com.millennialmedia.a.a.b.c(((GenericArrayType)var0).getGenericComponentType());
      } else if(var0 instanceof WildcardType) {
         WildcardType var1 = (WildcardType)var0;
         return new com.millennialmedia.a.a.b.e(var1.getUpperBounds(), var1.getLowerBounds());
      } else {
         return var0;
      }
   }

   public static Type a(Type var0, Class var1) {
      Type var2 = b(var0, var1, Collection.class);
      var0 = var2;
      if(var2 instanceof WildcardType) {
         var0 = ((WildcardType)var2).getUpperBounds()[0];
      }

      return (Type)(var0 instanceof ParameterizedType?((ParameterizedType)var0).getActualTypeArguments()[0]:Object.class);
   }

   private static Type a(Type var0, Class var1, Class var2) {
      Object var7 = var0;
      Class var6 = var1;

      label45:
      while(var2 != var6) {
         if(var2.isInterface()) {
            Class[] var8 = var6.getInterfaces();
            int var3 = 0;

            for(int var4 = var8.length; var3 < var4; ++var3) {
               if(var8[var3] == var2) {
                  return var6.getGenericInterfaces()[var3];
               }

               if(var2.isAssignableFrom(var8[var3])) {
                  var7 = var6.getGenericInterfaces()[var3];
                  var6 = var8[var3];
                  continue label45;
               }
            }
         }

         var7 = var2;
         if(var6.isInterface()) {
            break;
         }

         while(true) {
            var7 = var2;
            if(var6 == Object.class) {
               return (Type)var7;
            }

            var1 = var6.getSuperclass();
            if(var1 == var2) {
               return var6.getGenericSuperclass();
            }

            if(var2.isAssignableFrom(var1)) {
               Type var9 = var6.getGenericSuperclass();
               var6 = var1;
               var7 = var9;
               break;
            }

            var6 = var1;
         }
      }

      return (Type)var7;
   }

   public static Type a(Type var0, Class var1, Type var2) {
      int var5 = 0;
      Object var7 = var2;

      TypeVariable var8;
      Object var14;
      do {
         Type var18;
         if(!(var7 instanceof TypeVariable)) {
            if(var7 instanceof Class && ((Class)var7).isArray()) {
               var14 = (Class)var7;
               Class var23 = ((Class)var14).getComponentType();
               var0 = a(var0, var1, (Type)var23);
               if(var23 != var0) {
                  return f(var0);
               }
               break;
            }

            if(var7 instanceof GenericArrayType) {
               var14 = (GenericArrayType)var7;
               var18 = ((GenericArrayType)var14).getGenericComponentType();
               var0 = a(var0, var1, var18);
               if(var18 != var0) {
                  return f(var0);
               }
            } else if(var7 instanceof ParameterizedType) {
               ParameterizedType var19 = (ParameterizedType)var7;
               var2 = var19.getOwnerType();
               Type var9 = a(var0, var1, var2);
               boolean var15;
               if(var9 != var2) {
                  var15 = true;
               } else {
                  var15 = false;
               }

               Type[] var20 = var19.getActualTypeArguments();

               Type[] var17;
               for(int var6 = var20.length; var5 < var6; var20 = var17) {
                  Type var10 = a(var0, var1, var20[var5]);
                  boolean var4 = var15;
                  var17 = var20;
                  if(var10 != var20[var5]) {
                     var4 = var15;
                     var17 = var20;
                     if(!var15) {
                        var17 = (Type[])var20.clone();
                        var4 = true;
                     }

                     var17[var5] = var10;
                  }

                  ++var5;
                  var15 = var4;
               }

               var14 = var19;
               if(var15) {
                  return new com.millennialmedia.a.a.b.d(var9, var19.getRawType(), var20);
               }
            } else {
               var14 = var7;
               if(var7 instanceof WildcardType) {
                  WildcardType var22 = (WildcardType)var7;
                  Type[] var21 = var22.getLowerBounds();
                  Type[] var24 = var22.getUpperBounds();
                  if(var21.length == 1) {
                     var0 = a(var0, var1, var21[0]);
                     var14 = var22;
                     if(var0 != var21[0]) {
                        return new com.millennialmedia.a.a.b.e(new Type[]{Object.class}, new Type[]{var0});
                     }
                  } else {
                     var14 = var22;
                     if(var24.length == 1) {
                        var0 = a(var0, var1, var24[0]);
                        var14 = var22;
                        if(var0 != var24[0]) {
                           Type[] var11 = a;
                           return new com.millennialmedia.a.a.b.e(new Type[]{var0}, var11);
                        }
                     }
                  }
               }
            }
            break;
         }

         var8 = (TypeVariable)var7;
         GenericDeclaration var12 = var8.getGenericDeclaration();
         Class var13;
         if(var12 instanceof Class) {
            var13 = (Class)var12;
         } else {
            var13 = null;
         }

         label87: {
            if(var13 != null) {
               var18 = a(var0, var1, var13);
               if(var18 instanceof ParameterizedType) {
                  TypeVariable[] var16 = var13.getTypeParameters();

                  for(int var3 = 0; var3 < var16.length; ++var3) {
                     if(var8.equals(var16[var3])) {
                        var14 = ((ParameterizedType)var18).getActualTypeArguments()[var3];
                        break label87;
                     }
                  }

                  throw new NoSuchElementException();
               }
            }

            var14 = var8;
         }

         var7 = var14;
      } while(var14 != var8);

      return (Type)var14;
   }

   public static boolean a(Type var0, Type var1) {
      Type var3 = var0;

      GenericArrayType var5;
      for(var0 = var1; var3 != var0; var0 = var5.getGenericComponentType()) {
         if(var3 instanceof Class) {
            return var3.equals(var0);
         }

         if(var3 instanceof ParameterizedType) {
            if(!(var0 instanceof ParameterizedType)) {
               return false;
            }

            ParameterizedType var12 = (ParameterizedType)var3;
            ParameterizedType var10 = (ParameterizedType)var0;
            var3 = var12.getOwnerType();
            Type var4 = var10.getOwnerType();
            boolean var2;
            if(var3 == var4 || var3 != null && var3.equals(var4)) {
               var2 = true;
            } else {
               var2 = false;
            }

            if(var2 && var12.getRawType().equals(var10.getRawType()) && Arrays.equals(var12.getActualTypeArguments(), var10.getActualTypeArguments())) {
               return true;
            }

            return false;
         }

         if(!(var3 instanceof GenericArrayType)) {
            if(var3 instanceof WildcardType) {
               if(!(var0 instanceof WildcardType)) {
                  return false;
               }

               WildcardType var11 = (WildcardType)var3;
               WildcardType var8 = (WildcardType)var0;
               if(Arrays.equals(var11.getUpperBounds(), var8.getUpperBounds()) && Arrays.equals(var11.getLowerBounds(), var8.getLowerBounds())) {
                  return true;
               }

               return false;
            }

            if(var3 instanceof TypeVariable) {
               if(!(var0 instanceof TypeVariable)) {
                  return false;
               }

               TypeVariable var9 = (TypeVariable)var3;
               TypeVariable var7 = (TypeVariable)var0;
               if(var9.getGenericDeclaration() == var7.getGenericDeclaration() && var9.getName().equals(var7.getName())) {
                  return true;
               }

               return false;
            }

            return false;
         }

         if(!(var0 instanceof GenericArrayType)) {
            return false;
         }

         GenericArrayType var6 = (GenericArrayType)var3;
         var5 = (GenericArrayType)var0;
         var3 = var6.getGenericComponentType();
      }

      return true;
   }

   public static Class b(Type var0) {
      while(!(var0 instanceof Class)) {
         if(var0 instanceof ParameterizedType) {
            var0 = ((ParameterizedType)var0).getRawType();
            com.millennialmedia.a.a.b.a.a(var0 instanceof Class);
            return (Class)var0;
         }

         if(var0 instanceof GenericArrayType) {
            return Array.newInstance(b(((GenericArrayType)var0).getGenericComponentType()), 0).getClass();
         }

         if(var0 instanceof TypeVariable) {
            return Object.class;
         }

         if(!(var0 instanceof WildcardType)) {
            String var1;
            if(var0 == null) {
               var1 = "null";
            } else {
               var1 = var0.getClass().getName();
            }

            throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + var0 + "> is of type " + var1);
         }

         var0 = ((WildcardType)var0).getUpperBounds()[0];
      }

      return (Class)var0;
   }

   private static Type b(Type var0, Class var1, Class var2) {
      com.millennialmedia.a.a.b.a.a(var2.isAssignableFrom(var1));
      return a(var0, var1, a(var0, var1, var2));
   }

   public static Type[] b(Type var0, Class var1) {
      if(var0 == Properties.class) {
         return new Type[]{String.class, String.class};
      } else {
         var0 = b(var0, var1, Map.class);
         return var0 instanceof ParameterizedType?((ParameterizedType)var0).getActualTypeArguments():new Type[]{Object.class, Object.class};
      }
   }

   public static String c(Type var0) {
      return var0 instanceof Class?((Class)var0).getName():var0.toString();
   }

   public static Type d(Type var0) {
      return (Type)(var0 instanceof GenericArrayType?((GenericArrayType)var0).getGenericComponentType():((Class)var0).getComponentType());
   }

   // $FF: synthetic method
   static void e(Type var0) {
      boolean var1;
      if(var0 instanceof Class && ((Class)var0).isPrimitive()) {
         var1 = false;
      } else {
         var1 = true;
      }

      com.millennialmedia.a.a.b.a.a(var1);
   }

   private static GenericArrayType f(Type var0) {
      return new com.millennialmedia.a.a.b.c(var0);
   }
}
