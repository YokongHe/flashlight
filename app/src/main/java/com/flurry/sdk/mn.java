package com.flurry.sdk;

import com.flurry.sdk.iq;
import com.flurry.sdk.iu$a;
import com.flurry.sdk.mm;
import com.flurry.sdk.mo;
import com.flurry.sdk.mp;
import com.flurry.sdk.mr;
import com.flurry.sdk.ms;
import com.flurry.sdk.mv;
import com.flurry.sdk.mz;
import com.flurry.sdk.na;
import com.flurry.sdk.qv;
import com.flurry.sdk.qy;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class mn extends mm {
   private static final mv[] l = new mv[0];
   protected final Class a;
   protected final List b;
   protected final iq c;
   protected final iu$a d;
   protected final Class e;
   protected mv f;
   protected mo g;
   protected List h;
   protected List i;
   protected ms j;
   protected List k;

   private mn(Class var1, List var2, iq var3, iu$a var4, mv var5) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      if(this.d == null) {
         var1 = null;
      } else {
         var1 = this.d.a(this.a);
      }

      this.e = var1;
      this.f = var5;
   }

   public static mn a(Class var0, iq var1, iu$a var2) {
      mn var3 = new mn(var0, qy.a((Class)var0, (Class)null), var1, var2, (mv)null);
      var3.m();
      return var3;
   }

   private mv[] a(int var1) {
      mv[] var3;
      if(var1 == 0) {
         var3 = l;
      } else {
         mv[] var4 = new mv[var1];
         int var2 = 0;

         while(true) {
            var3 = var4;
            if(var2 >= var1) {
               break;
            }

            var4[var2] = this.o();
            ++var2;
         }
      }

      return var3;
   }

   public static mn b(Class var0, iq var1, iu$a var2) {
      mn var3 = new mn(var0, Collections.emptyList(), var1, var2, (mv)null);
      var3.m();
      return var3;
   }

   private boolean b(Field var1) {
      if(!var1.isSynthetic()) {
         int var2 = var1.getModifiers();
         if(!Modifier.isStatic(var2) && !Modifier.isTransient(var2)) {
            return true;
         }
      }

      return false;
   }

   private mv o() {
      return new mv();
   }

   protected final mo a(Constructor var1, boolean var2) {
      if(this.c == null) {
         return new mo(var1, this.o(), this.a(var1.getParameterTypes().length));
      } else if(var2) {
         return new mo(var1, this.a(var1.getDeclaredAnnotations()), (mv[])null);
      } else {
         Annotation[][] var5 = var1.getParameterAnnotations();
         int var3 = var1.getParameterTypes().length;
         mv[] var9;
         if(var3 != var5.length) {
            Class var4 = var1.getDeclaringClass();
            mv[] var7;
            if(var4.isEnum() && var3 == var5.length + 2) {
               Annotation[][] var8 = new Annotation[var5.length + 2][];
               System.arraycopy(var5, 0, var8, 2, var5.length);
               var9 = this.a(var8);
               var5 = var8;
               var7 = var9;
            } else if(var4.isMemberClass() && var3 == var5.length + 1) {
               Annotation[][] var6 = new Annotation[var5.length + 1][];
               System.arraycopy(var5, 0, var6, 1, var5.length);
               var7 = this.a(var6);
               var5 = var6;
            } else {
               var7 = null;
            }

            var9 = var7;
            if(var7 == null) {
               throw new IllegalStateException("Internal error: constructor for " + var1.getDeclaringClass().getName() + " has mismatch: " + var3 + " parameters; " + var5.length + " sets of annotations");
            }
         } else {
            var9 = this.a(var5);
         }

         return new mo(var1, this.a(var1.getDeclaredAnnotations()), var9);
      }
   }

   protected final mp a(Field var1) {
      return this.c == null?new mp(var1, this.o()):new mp(var1, this.a(var1.getDeclaredAnnotations()));
   }

   public final mr a(String var1, Class[] var2) {
      return this.j.a(var1, var2);
   }

   protected final mr a(Method var1) {
      return this.c == null?new mr(var1, this.o(), (mv[])null):new mr(var1, this.a(var1.getDeclaredAnnotations()), (mv[])null);
   }

   protected final mv a(Annotation[] var1) {
      mv var4 = new mv();
      if(var1 != null) {
         int var3 = var1.length;

         for(int var2 = 0; var2 < var3; ++var2) {
            Annotation var5 = var1[var2];
            if(this.c.a(var5)) {
               var4.b(var5);
            }
         }
      }

      return var4;
   }

   public final Annotation a(Class var1) {
      return this.f == null?null:this.f.a(var1);
   }

   // $FF: synthetic method
   public final AnnotatedElement a() {
      return this.e();
   }

   protected final void a(mv var1, Class var2) {
      if(this.d != null) {
         this.a(var1, var2, this.d.a(var2));
      }

   }

   protected final void a(mv var1, Class var2, Class var3) {
      if(var3 != null) {
         Annotation[] var6 = var3.getDeclaredAnnotations();
         int var5 = var6.length;

         int var4;
         for(var4 = 0; var4 < var5; ++var4) {
            Annotation var7 = var6[var4];
            if(this.c.a(var7)) {
               var1.a(var7);
            }
         }

         Iterator var8 = qy.a(var3, var2).iterator();

         while(var8.hasNext()) {
            Annotation[] var9 = ((Class)var8.next()).getDeclaredAnnotations();
            var5 = var9.length;

            for(var4 = 0; var4 < var5; ++var4) {
               Annotation var10 = var9[var4];
               if(this.c.a(var10)) {
                  var1.a(var10);
               }
            }
         }
      }

   }

   public final void a(na param1) {
      // $FF: Couldn't be decompiled
   }

   protected final void a(na var1, ms var2, Class var3, ms var4) {
      Method[] var9 = var3.getDeclaredMethods();
      int var6 = var9.length;

      for(int var5 = 0; var5 < var6; ++var5) {
         Method var7 = var9[var5];
         if(this.a(var7, var1)) {
            mr var8 = var2.b(var7);
            if(var8 != null) {
               this.a(var7, var8);
            } else {
               var4.a(this.a(var7));
            }
         }
      }

   }

   protected final void a(Class var1, na var2, ms var3, Class var4, ms var5) {
      if(var4 != null) {
         this.a(var2, var3, var4, var5);
      }

      if(var1 != null) {
         Method[] var9 = var1.getDeclaredMethods();
         int var7 = var9.length;

         for(int var6 = 0; var6 < var7; ++var6) {
            Method var10 = var9[var6];
            if(this.a(var10, var2)) {
               mr var8 = var3.b(var10);
               if(var8 == null) {
                  var8 = this.a(var10);
                  var3.a(var8);
                  mr var11 = var5.a(var10);
                  if(var11 != null) {
                     this.a(var11.e(), var8, false);
                  }
               } else {
                  this.a(var10, var8);
                  if(var8.h().isInterface() && !var10.getDeclaringClass().isInterface()) {
                     var3.a(var8.a(var10));
                  }
               }
            }
         }
      }

   }

   protected final void a(Class var1, Map var2) {
      Field[] var10 = var1.getDeclaredFields();
      int var5 = var10.length;

      for(int var3 = 0; var3 < var5; ++var3) {
         Field var8 = var10[var3];
         if(this.b(var8)) {
            mp var7 = (mp)var2.get(var8.getName());
            if(var7 != null) {
               Annotation[] var11 = var8.getDeclaredAnnotations();
               int var6 = var11.length;

               for(int var4 = 0; var4 < var6; ++var4) {
                  Annotation var9 = var11[var4];
                  if(this.c.a(var9)) {
                     var7.a(var9);
                  }
               }
            }
         }
      }

   }

   protected final void a(Constructor var1, mo var2, boolean var3) {
      Annotation[] var8 = var1.getDeclaredAnnotations();
      int var5 = var8.length;

      int var4;
      for(var4 = 0; var4 < var5; ++var4) {
         Annotation var9 = var8[var4];
         if(this.c.a(var9)) {
            var2.a((Annotation)var9);
         }
      }

      if(var3) {
         Annotation[][] var10 = var1.getParameterAnnotations();
         int var6 = var10.length;

         for(var4 = 0; var4 < var6; ++var4) {
            var8 = var10[var4];
            int var7 = var8.length;

            for(var5 = 0; var5 < var7; ++var5) {
               var2.a(var4, var8[var5]);
            }
         }
      }

   }

   protected final void a(Method var1, mr var2) {
      Annotation[] var6 = var1.getDeclaredAnnotations();
      int var4 = var6.length;

      for(int var3 = 0; var3 < var4; ++var3) {
         Annotation var5 = var6[var3];
         if(this.c.a(var5)) {
            var2.b(var5);
         }
      }

   }

   protected final void a(Method var1, mr var2, boolean var3) {
      Annotation[] var8 = var1.getDeclaredAnnotations();
      int var5 = var8.length;

      int var4;
      for(var4 = 0; var4 < var5; ++var4) {
         Annotation var9 = var8[var4];
         if(this.c.a(var9)) {
            var2.a((Annotation)var9);
         }
      }

      if(var3) {
         Annotation[][] var10 = var1.getParameterAnnotations();
         int var6 = var10.length;

         for(var4 = 0; var4 < var6; ++var4) {
            var8 = var10[var4];
            int var7 = var8.length;

            for(var5 = 0; var5 < var7; ++var5) {
               var2.a(var4, var8[var5]);
            }
         }
      }

   }

   protected final void a(Map var1, Class var2) {
      Class var5 = var2.getSuperclass();
      if(var5 != null) {
         this.a(var1, var5);
         Field[] var7 = var2.getDeclaredFields();
         int var4 = var7.length;

         for(int var3 = 0; var3 < var4; ++var3) {
            Field var6 = var7[var3];
            if(this.b(var6)) {
               var1.put(var6.getName(), this.a(var6));
            }
         }

         if(this.d != null) {
            var2 = this.d.a(var2);
            if(var2 != null) {
               this.a(var2, var1);
            }
         }
      }

   }

   public final void a(boolean var1) {
      this.h = null;
      Constructor[] var4 = this.a.getDeclaredConstructors();
      int var3 = var4.length;

      int var2;
      for(var2 = 0; var2 < var3; ++var2) {
         Constructor var5 = var4[var2];
         if(var5.getParameterTypes().length == 0) {
            this.g = this.a(var5, true);
         } else if(var1) {
            if(this.h == null) {
               this.h = new ArrayList(Math.max(10, var4.length));
            }

            this.h.add(this.a(var5, false));
         }
      }

      if(this.e != null && (this.g != null || this.h != null)) {
         this.c(this.e);
      }

      if(this.c != null) {
         if(this.g != null && this.c.a(this.g)) {
            this.g = null;
         }

         if(this.h != null) {
            var2 = this.h.size();

            while(true) {
               --var2;
               if(var2 < 0) {
                  break;
               }

               if(this.c.a((mo)this.h.get(var2))) {
                  this.h.remove(var2);
               }
            }
         }
      }

      this.i = null;
      if(var1) {
         Method[] var6 = this.a.getDeclaredMethods();
         var3 = var6.length;

         for(var2 = 0; var2 < var3; ++var2) {
            Method var7 = var6[var2];
            if(Modifier.isStatic(var7.getModifiers()) && var7.getParameterTypes().length > 0) {
               if(this.i == null) {
                  this.i = new ArrayList(8);
               }

               this.i.add(this.b(var7));
            }
         }

         if(this.e != null && this.i != null) {
            this.d(this.e);
         }

         if(this.c != null && this.i != null) {
            var2 = this.i.size();

            while(true) {
               --var2;
               if(var2 < 0) {
                  break;
               }

               if(this.c.a((mr)this.i.get(var2))) {
                  this.i.remove(var2);
               }
            }
         }
      }

   }

   protected final boolean a(Method var1, na var2) {
      return (var2 == null || var2.a(var1)) && !var1.isSynthetic() && !var1.isBridge();
   }

   protected final mv[] a(Annotation[][] var1) {
      int var3 = var1.length;
      mv[] var4 = new mv[var3];

      for(int var2 = 0; var2 < var3; ++var2) {
         var4[var2] = this.a(var1[var2]);
      }

      return var4;
   }

   protected final mr b(Method var1) {
      return this.c == null?new mr(var1, this.o(), this.a(var1.getParameterTypes().length)):new mr(var1, this.a(var1.getDeclaredAnnotations()), this.a(var1.getParameterAnnotations()));
   }

   public final String b() {
      return this.a.getName();
   }

   public final Type c() {
      return this.a;
   }

   protected final void c(Class var1) {
      int var2;
      if(this.h == null) {
         var2 = 0;
      } else {
         var2 = this.h.size();
      }

      Constructor[] var7 = var1.getDeclaredConstructors();
      int var5 = var7.length;
      int var3 = 0;

      mz[] var6;
      for(mz[] var9 = null; var3 < var5; var9 = var6) {
         Constructor var8 = var7[var3];
         if(var8.getParameterTypes().length == 0) {
            var6 = var9;
            if(this.g != null) {
               this.a(var8, this.g, false);
               var6 = var9;
            }
         } else {
            int var4;
            if(var9 == null) {
               var6 = new mz[var2];
               var4 = 0;

               while(true) {
                  var9 = var6;
                  if(var4 >= var2) {
                     break;
                  }

                  var6[var4] = new mz(((mo)this.h.get(var4)).e());
                  ++var4;
               }
            }

            mz var10 = new mz(var8);
            var4 = 0;

            while(true) {
               if(var4 >= var2) {
                  var6 = var9;
                  break;
               }

               if(var10.equals(var9[var4])) {
                  this.a(var8, (mo)this.h.get(var4), true);
                  var6 = var9;
                  break;
               }

               ++var4;
            }
         }

         ++var3;
      }

   }

   public final Class d() {
      return this.a;
   }

   protected final void d(Class var1) {
      mz[] var6 = null;
      int var4 = this.i.size();
      Method[] var7 = var1.getDeclaredMethods();
      int var5 = var7.length;
      int var2 = 0;

      for(mz[] var10 = var6; var2 < var5; var10 = var6) {
         Method var8 = var7[var2];
         if(Modifier.isStatic(var8.getModifiers()) && var8.getParameterTypes().length != 0) {
            int var3;
            if(var10 == null) {
               var6 = new mz[var4];
               var3 = 0;

               while(true) {
                  var10 = var6;
                  if(var3 >= var4) {
                     break;
                  }

                  var6[var3] = new mz(((mr)this.i.get(var3)).e());
                  ++var3;
               }
            }

            mz var9 = new mz(var8);
            var3 = 0;

            while(true) {
               var6 = var10;
               if(var3 >= var4) {
                  break;
               }

               if(var9.equals(var10[var3])) {
                  this.a(var8, (mr)this.i.get(var3), true);
                  var6 = var10;
                  break;
               }

               ++var3;
            }
         } else {
            var6 = var10;
         }

         ++var2;
      }

   }

   public final Class e() {
      return this.a;
   }

   public final qv f() {
      return this.f;
   }

   public final boolean g() {
      return this.f.a() > 0;
   }

   public final mo h() {
      return this.g;
   }

   public final List i() {
      return this.h == null?Collections.emptyList():this.h;
   }

   public final List j() {
      return this.i == null?Collections.emptyList():this.i;
   }

   public final Iterable k() {
      return this.j;
   }

   public final Iterable l() {
      return this.k == null?Collections.emptyList():this.k;
   }

   public final void m() {
      this.f = new mv();
      if(this.c != null) {
         if(this.e != null) {
            this.a(this.f, this.a, this.e);
         }

         Annotation[] var3 = this.a.getDeclaredAnnotations();
         int var2 = var3.length;

         int var1;
         for(var1 = 0; var1 < var2; ++var1) {
            Annotation var4 = var3[var1];
            if(this.c.a(var4)) {
               this.f.a(var4);
            }
         }

         Iterator var6 = this.b.iterator();

         while(var6.hasNext()) {
            Class var7 = (Class)var6.next();
            this.a(this.f, var7);
            Annotation[] var8 = var7.getDeclaredAnnotations();
            var2 = var8.length;

            for(var1 = 0; var1 < var2; ++var1) {
               Annotation var5 = var8[var1];
               if(this.c.a(var5)) {
                  this.f.a(var5);
               }
            }
         }

         this.a(this.f, Object.class);
      }
   }

   public final void n() {
      LinkedHashMap var1 = new LinkedHashMap();
      this.a((Map)var1, (Class)this.a);
      if(var1.isEmpty()) {
         this.k = Collections.emptyList();
      } else {
         this.k = new ArrayList(var1.size());
         this.k.addAll(var1.values());
      }
   }

   public final String toString() {
      return "[AnnotedClass " + this.a.getName() + "]";
   }
}
