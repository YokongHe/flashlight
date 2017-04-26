package com.flurry.sdk;

import com.flurry.sdk.fk;
import com.flurry.sdk.fn;
import com.flurry.sdk.fn$v;
import com.flurry.sdk.ft;
import com.flurry.sdk.ge;
import com.flurry.sdk.gt;
import java.lang.reflect.Type;
import java.nio.ByteBuffer;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

public class gs extends ft {
   private static final gs a = new gs();
   private static final Class[] c = new Class[0];
   private static final Class[] d = new Class[]{fn.class};
   private static final Map e = new ConcurrentHashMap();
   private static final Class g = (new Object() {
   }).getClass();
   private static final fn h;
   private final ClassLoader b;
   private Map f;
   private final WeakHashMap i;

   static {
      h = fn.a(fn$v.n);
   }

   protected gs() {
      this(gs.class.getClassLoader());
   }

   public gs(ClassLoader var1) {
      this.f = new ConcurrentHashMap();
      this.i = new WeakHashMap();
      this.b = var1;
   }

   public static Object a(Class param0, fn param1) {
      // $FF: Couldn't be decompiled
   }

   public static gs b() {
      return a;
   }

   public static String c(fn var0) {
      String var1 = var0.f();
      String var2 = var0.d();
      if(var1 != null && !"".equals(var1)) {
         String var3;
         if(var1.endsWith("$")) {
            var3 = "";
         } else {
            var3 = ".";
         }

         return var1 + var3 + var2;
      } else {
         return var2;
      }
   }

   protected int a(Object var1, Object var2, fn var3, boolean var4) {
      switch(null.a[var3.a().ordinal()]) {
      case 3:
         if(var1 instanceof Enum) {
            return ((Enum)var1).ordinal() - ((Enum)var2).ordinal();
         }
      default:
         return super.a(var1, var2, var3, var4);
      }
   }

   public fn a(Type var1) {
      fn var3 = (fn)this.i.get(var1);
      fn var2 = var3;
      if(var3 == null) {
         var2 = this.a((Type)var1, (Map)(new LinkedHashMap()));
         this.i.put(var1, var2);
      }

      return var2;
   }

   protected fn a(Type param1, Map param2) {
      // $FF: Couldn't be decompiled
   }

   public ge a(fn var1) {
      return new gt(var1, var1, this);
   }

   public Class b(fn var1) {
      switch(null.a[var1.a().ordinal()]) {
      case 1:
      case 2:
      case 3:
         String var5 = var1.g();
         Class var8;
         if(var5 == null) {
            var8 = null;
         } else {
            Class var4 = (Class)this.f.get(var5);
            Class var3 = var4;
            if(var4 == null) {
               try {
                  var3 = this.b.loadClass(c(var1));
               } catch (ClassNotFoundException var6) {
                  var3 = g;
               }

               this.f.put(var5, var3);
            }

            var8 = var3;
            if(var3 == g) {
               return null;
            }
         }

         return var8;
      case 4:
         return List.class;
      case 5:
         return Map.class;
      case 6:
         List var7 = var1.k();
         if(var7.size() == 2 && var7.contains(h)) {
            byte var2;
            if(((fn)var7.get(0)).equals(h)) {
               var2 = 1;
            } else {
               var2 = 0;
            }

            return this.b((fn)var7.get(var2));
         }

         return Object.class;
      case 7:
         if("String".equals(var1.a("avro.java.string"))) {
            return String.class;
         }

         return CharSequence.class;
      case 8:
         return ByteBuffer.class;
      case 9:
         return Integer.TYPE;
      case 10:
         return Long.TYPE;
      case 11:
         return Float.TYPE;
      case 12:
         return Double.TYPE;
      case 13:
         return Boolean.TYPE;
      case 14:
         return Void.TYPE;
      default:
         throw new fk("Unknown type: " + var1);
      }
   }

   public Object c(Object var1, fn var2) {
      Class var4 = b().b(var2);
      Object var3;
      if(var4 == null) {
         var3 = super.c(var1, var2);
      } else {
         var3 = var1;
         if(!var4.isInstance(var1)) {
            return a(var4, var2);
         }
      }

      return var3;
   }

   public Object d(Object var1, fn var2) {
      Class var4 = b().b(var2);
      Object var3;
      if(var4 == null) {
         var3 = super.d(var1, var2);
      } else {
         var3 = var1;
         if(!var4.isInstance(var1)) {
            return a(var4, var2);
         }
      }

      return var3;
   }

   protected boolean f(Object var1) {
      return var1 instanceof Enum || super.f(var1);
   }

   protected fn g(Object var1) {
      return var1 instanceof Enum?this.a((Type)var1.getClass()):super.g(var1);
   }
}
