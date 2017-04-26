package com.flurry.sdk;

import com.flurry.sdk.qi;
import com.flurry.sdk.ql;
import com.flurry.sdk.qm;
import com.flurry.sdk.qo;
import com.flurry.sdk.qp;
import com.flurry.sdk.qr;
import com.flurry.sdk.qt;
import com.flurry.sdk.qu;
import com.flurry.sdk.sh;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class qs {
   @Deprecated
   public static final qs a = new qs();
   private static final sh[] f = new sh[0];
   protected final qt[] b = null;
   protected final qu c = new qu(this);
   protected qm d;
   protected qm e;

   public static qs a() {
      return a;
   }

   public static sh a(String var0) {
      return a.b(var0);
   }

   public static sh b() {
      return a().c();
   }

   private sh b(Class var1) {
      sh[] var2 = this.a(var1, Map.class);
      if(var2 == null) {
         return qo.a(var1, this.c(), this.c());
      } else if(var2.length != 2) {
         throw new IllegalArgumentException("Strange Map type " + var1.getName() + ": can not determine type parameters");
      } else {
         return qo.a(var1, var2[0], var2[1]);
      }
   }

   private sh c(Class var1) {
      sh[] var2 = this.a(var1, Collection.class);
      if(var2 == null) {
         return ql.a(var1, this.c());
      } else if(var2.length != 1) {
         throw new IllegalArgumentException("Strange Collection type " + var1.getName() + ": can not determine type parameters");
      } else {
         return ql.a(var1, var2[0]);
      }
   }

   protected final qm a(qm var1) {
      synchronized(this){}

      try {
         qm var2;
         if(this.d == null) {
            var2 = var1.a();
            this.a(var2, Map.class);
            this.d = var2.b();
         }

         var2 = this.d.a();
         var1.a(var2);
         var2.b(var1);
      } finally {
         ;
      }

      return var1;
   }

   protected final qm a(qm var1, Class var2) {
      Class var5 = var1.e();
      Type[] var6 = var5.getGenericInterfaces();
      if(var6 != null) {
         int var4 = var6.length;

         for(int var3 = 0; var3 < var4; ++var3) {
            qm var7 = this.b(var6[var3], var2);
            if(var7 != null) {
               var7.b(var1);
               var1.a(var7);
               return var1;
            }
         }
      }

      Type var9 = var5.getGenericSuperclass();
      if(var9 != null) {
         qm var8 = this.b(var9, var2);
         if(var8 != null) {
            var8.b(var1);
            var1.a(var8);
            return var1;
         }
      }

      return null;
   }

   protected final qm a(Type var1, Class var2) {
      qm var4 = new qm(var1);
      Class var3 = var4.e();
      if(var3 == var2) {
         return var4;
      } else {
         Type var6 = var3.getGenericSuperclass();
         if(var6 != null) {
            qm var5 = this.a(var6, var2);
            if(var5 != null) {
               var5.b(var4);
               var4.a(var5);
               return var4;
            }
         }

         return null;
      }
   }

   public final qo a(Class var1, Class var2, Class var3) {
      return qo.a(var1, this.a((Type)var2), this.a((Type)var3));
   }

   public final sh a(sh var1, Class var2) {
      if(!(var1 instanceof qp) || !var2.isArray() && !Map.class.isAssignableFrom(var2) && !Collection.class.isAssignableFrom(var2)) {
         return var1.f(var2);
      } else if(!var1.p().isAssignableFrom(var2)) {
         throw new IllegalArgumentException("Class " + var2.getClass().getName() + " not subtype of " + var1);
      } else {
         sh var3 = this.a(var2, new qr(this, var1.p()));
         Object var4 = var1.n();
         sh var5 = var3;
         if(var4 != null) {
            var5 = var3.d(var4);
         }

         Object var6 = var1.o();
         var1 = var5;
         if(var6 != null) {
            var1 = var5.f(var6);
         }

         return var1;
      }
   }

   public final sh a(Class var1) {
      return new qp(var1);
   }

   protected final sh a(Class var1, qr var2) {
      return (sh)(var1.isArray()?qi.a(this.b((Type)var1.getComponentType(), (qr)null), (Object)null, (Object)null):(var1.isEnum()?new qp(var1):(Map.class.isAssignableFrom(var1)?this.b(var1):(Collection.class.isAssignableFrom(var1)?this.c(var1):new qp(var1)))));
   }

   protected final sh a(Class var1, List var2) {
      if(var1.isArray()) {
         return qi.a(this.b((Type)var1.getComponentType(), (qr)null), (Object)null, (Object)null);
      } else if(var1.isEnum()) {
         return new qp(var1);
      } else if(Map.class.isAssignableFrom(var1)) {
         if(var2.size() > 0) {
            sh var3 = (sh)var2.get(0);
            sh var4;
            if(var2.size() >= 2) {
               var4 = (sh)var2.get(1);
            } else {
               var4 = this.c();
            }

            return qo.a(var1, var3, var4);
         } else {
            return this.b(var1);
         }
      } else {
         return (sh)(Collection.class.isAssignableFrom(var1)?(var2.size() > 0?ql.a(var1, (sh)var2.get(0)):this.c(var1)):(var2.size() == 0?new qp(var1):this.a(var1, (sh[])var2.toArray(new sh[var2.size()]))));
      }
   }

   public final sh a(Class var1, sh[] var2) {
      TypeVariable[] var5 = var1.getTypeParameters();
      if(var5.length != var2.length) {
         throw new IllegalArgumentException("Parameter type mismatch for " + var1.getName() + ": expected " + var5.length + " parameters, was given " + var2.length);
      } else {
         String[] var6 = new String[var5.length];
         int var3 = 0;

         for(int var4 = var5.length; var3 < var4; ++var3) {
            var6[var3] = var5[var3].getName();
         }

         return new qp(var1, var6, var2, (Object)null, (Object)null);
      }
   }

   protected final sh a(GenericArrayType var1, qr var2) {
      return qi.a(this.b(var1.getGenericComponentType(), var2), (Object)null, (Object)null);
   }

   protected final sh a(ParameterizedType var1, qr var2) {
      Class var6 = (Class)var1.getRawType();
      Type[] var7 = var1.getActualTypeArguments();
      int var3;
      if(var7 == null) {
         var3 = 0;
      } else {
         var3 = var7.length;
      }

      sh[] var8;
      if(var3 == 0) {
         var8 = f;
      } else {
         sh[] var5 = new sh[var3];
         int var4 = 0;

         while(true) {
            var8 = var5;
            if(var4 >= var3) {
               break;
            }

            var5[var4] = this.b(var7[var4], var2);
            ++var4;
         }
      }

      if(Map.class.isAssignableFrom(var6)) {
         var8 = this.b(this.a(var6, var8), Map.class);
         if(var8.length != 2) {
            throw new IllegalArgumentException("Could not find 2 type parameters for Map class " + var6.getName() + " (found " + var8.length + ")");
         } else {
            return qo.a(var6, var8[0], var8[1]);
         }
      } else if(Collection.class.isAssignableFrom(var6)) {
         var8 = this.b(this.a(var6, var8), Collection.class);
         if(var8.length != 1) {
            throw new IllegalArgumentException("Could not find 1 type parameter for Collection class " + var6.getName() + " (found " + var8.length + ")");
         } else {
            return ql.a(var6, var8[0]);
         }
      } else {
         return (sh)(var3 == 0?new qp(var6):this.a(var6, var8));
      }
   }

   public final sh a(Type var1) {
      return this.b((Type)var1, (qr)null);
   }

   public final sh a(Type var1, qr var2) {
      return this.b(var1, var2);
   }

   protected final sh a(TypeVariable var1, qr var2) {
      sh var3;
      if(var2 == null) {
         var3 = this.c();
      } else {
         String var5 = var1.getName();
         sh var4 = var2.a(var5);
         var3 = var4;
         if(var4 == null) {
            Type[] var6 = var1.getBounds();
            var2.b(var5);
            return this.b(var6[0], var2);
         }
      }

      return var3;
   }

   protected final sh a(WildcardType var1, qr var2) {
      return this.b(var1.getUpperBounds()[0], var2);
   }

   public final sh[] a(Class var1, Class var2) {
      return this.a(var1, var2, new qr(this, var1));
   }

   public final sh[] a(Class var1, Class var2, qr var3) {
      qm var7 = this.c(var1, var2);
      qm var6 = var7;
      if(var7 == null) {
         throw new IllegalArgumentException("Class " + var1.getName() + " is not a subtype of " + var2.getName());
      } else {
         qr var8;
         for(; var6.b() != null; var3 = var8) {
            var6 = var6.b();
            Class var10 = var6.e();
            var8 = new qr(this, var10);
            if(var6.c()) {
               Type[] var9 = var6.d().getActualTypeArguments();
               TypeVariable[] var11 = var10.getTypeParameters();
               int var5 = var9.length;

               for(int var4 = 0; var4 < var5; ++var4) {
                  var8.a(var11[var4].getName(), a.b(var9[var4], var3));
               }
            }
         }

         if(!var6.c()) {
            return null;
         } else {
            return var3.b();
         }
      }
   }

   public final ql b(Class var1, Class var2) {
      return ql.a(var1, this.a((Type)var2));
   }

   protected final qm b(qm var1) {
      synchronized(this){}

      try {
         qm var2;
         if(this.e == null) {
            var2 = var1.a();
            this.a(var2, List.class);
            this.e = var2.b();
         }

         var2 = this.e.a();
         var1.a(var2);
         var2.b(var1);
      } finally {
         ;
      }

      return var1;
   }

   protected final qm b(Type var1, Class var2) {
      qm var3 = new qm(var1);
      Class var4 = var3.e();
      return var4 == var2?new qm(var1):(var4 == HashMap.class && var2 == Map.class?this.a(var3):(var4 == ArrayList.class && var2 == List.class?this.b(var3):this.a(var3, var2)));
   }

   public final sh b(String var1) {
      return this.c.a(var1);
   }

   public final sh b(Type var1, qr var2) {
      sh var8;
      sh var9;
      if(var1 instanceof Class) {
         Class var6 = (Class)var1;
         qr var5 = var2;
         if(var2 == null) {
            var5 = new qr(this, var6);
         }

         var9 = this.a(var6, var5);
         var2 = var5;
         var8 = var9;
      } else if(var1 instanceof ParameterizedType) {
         var8 = this.a((ParameterizedType)var1, var2);
      } else if(var1 instanceof GenericArrayType) {
         var8 = this.a((GenericArrayType)var1, var2);
      } else if(var1 instanceof TypeVariable) {
         var8 = this.a((TypeVariable)var1, var2);
      } else {
         if(!(var1 instanceof WildcardType)) {
            throw new IllegalArgumentException("Unrecognized Type: " + var1.toString());
         }

         var8 = this.a((WildcardType)var1, var2);
      }

      var9 = var8;
      if(this.b != null) {
         var9 = var8;
         if(!var8.f()) {
            qt[] var7 = this.b;
            int var4 = var7.length;
            int var3 = 0;

            while(true) {
               var9 = var8;
               if(var3 >= var4) {
                  break;
               }

               var8 = var7[var3].a(var8, var1, var2, this);
               ++var3;
            }
         }
      }

      return var9;
   }

   public final sh[] b(sh var1, Class var2) {
      Class var5 = var1.p();
      if(var5 != var2) {
         return this.a(var5, var2, new qr(this, var1));
      } else {
         int var4 = var1.h();
         sh[] var7;
         if(var4 == 0) {
            var7 = null;
         } else {
            sh[] var6 = new sh[var4];
            int var3 = 0;

            while(true) {
               var7 = var6;
               if(var3 >= var4) {
                  break;
               }

               var6[var3] = var1.b(var3);
               ++var3;
            }
         }

         return var7;
      }
   }

   protected final qm c(Class var1, Class var2) {
      return var2.isInterface()?this.b((Type)var1, (Class)var2):this.a((Type)var1, (Class)var2);
   }

   protected final sh c() {
      return new qp(Object.class);
   }
}
