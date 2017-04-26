package com.flurry.sdk;

import com.flurry.org.codehaus.jackson.annotate.JsonTypeInfo$As;
import com.flurry.sdk.hj;
import com.flurry.sdk.hm;
import com.flurry.sdk.ir;
import com.flurry.sdk.is;
import com.flurry.sdk.is$a;
import com.flurry.sdk.iy;
import com.flurry.sdk.iy$a;
import com.flurry.sdk.iz;
import com.flurry.sdk.jc;
import com.flurry.sdk.jg;
import com.flurry.sdk.jh;
import com.flurry.sdk.js;
import com.flurry.sdk.jy;
import com.flurry.sdk.kc;
import com.flurry.sdk.km;
import com.flurry.sdk.ks;
import com.flurry.sdk.kt;
import com.flurry.sdk.kt$b;
import com.flurry.sdk.kt$c;
import com.flurry.sdk.kx;
import com.flurry.sdk.kz;
import com.flurry.sdk.lc;
import com.flurry.sdk.lc$a;
import com.flurry.sdk.ld;
import com.flurry.sdk.lf;
import com.flurry.sdk.lg;
import com.flurry.sdk.lh;
import com.flurry.sdk.lo;
import com.flurry.sdk.lz;
import com.flurry.sdk.mn;
import com.flurry.sdk.mq;
import com.flurry.sdk.mu;
import com.flurry.sdk.qy;
import com.flurry.sdk.sh;
import com.flurry.sdk.sq;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@kc
public class ko extends lz implements js {
   protected final mn a;
   protected final sh b;
   protected final is c;
   protected final kx d;
   protected jg e;
   protected final ld f;
   protected boolean g;
   protected final kz h;
   protected final lh[] i;
   protected ks j;
   protected final HashSet k;
   protected final boolean l;
   protected final Map m;
   protected HashMap n;
   protected lg o;
   protected lc p;

   public ko(ir var1, is var2, kx var3, kz var4, Map var5, HashSet var6, boolean var7, ks var8, List var9) {
      this(var1.c(), var1.a(), var2, var3, var4, var5, var6, var7, var8, var9);
   }

   protected ko(ko var1) {
      this(var1, var1.l);
   }

   protected ko(ko var1, boolean var2) {
      super(var1.b);
      this.a = var1.a;
      this.b = var1.b;
      this.c = var1.c;
      this.d = var1.d;
      this.e = var1.e;
      this.f = var1.f;
      this.h = var1.h;
      this.m = var1.m;
      this.k = var1.k;
      this.l = var2;
      this.j = var1.j;
      this.i = var1.i;
      this.g = var1.g;
      this.o = var1.o;
   }

   protected ko(mn var1, sh var2, is var3, kx var4, kz var5, Map var6, HashSet var7, boolean var8, ks var9, List var10) {
      Object var11 = null;
      super(var2);
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      if(var4.j()) {
         this.f = new ld(var4);
      } else {
         this.f = null;
      }

      this.h = var5;
      this.m = var6;
      this.k = var7;
      this.l = var8;
      this.j = var9;
      lh[] var12 = (lh[])var11;
      if(var10 != null) {
         if(var10.isEmpty()) {
            var12 = (lh[])var11;
         } else {
            var12 = (lh[])var10.toArray(new lh[var10.size()]);
         }
      }

      this.i = var12;
      if(!var4.i() && this.f == null && var4.h() && this.o == null) {
         var8 = false;
      } else {
         var8 = true;
      }

      this.g = var8;
   }

   private final void b(hj var1, iz var2, Object var3, String var4) {
      if(this.k != null && this.k.contains(var4)) {
         var1.d();
      } else if(this.j != null) {
         try {
            this.j.a(var1, var2, var3, var4);
         } catch (Exception var5) {
            this.a((Throwable)var5, (Object)var3, (String)var4, (iz)var2);
         }
      } else {
         this.a(var1, var2, var3, var4);
      }
   }

   public jg a() {
      return this.getClass() != ko.class?this:new ko(this, true);
   }

   protected kt a(iy var1, kt var2) {
      String var4 = var2.e();
      if(var4 == null) {
         return var2;
      } else {
         jg var7 = var2.h();
         boolean var3 = false;
         kt var8;
         if(var7 instanceof ko) {
            var8 = ((ko)var7).a(var4);
         } else {
            if(!(var7 instanceof lo)) {
               if(var7 instanceof km) {
                  throw new IllegalArgumentException("Can not handle managed/back reference for abstract types (property " + this.b.p().getName() + "." + var2.c() + ")");
               }

               throw new IllegalArgumentException("Can not handle managed/back reference \'" + var4 + "\': type for value deserializer is not BeanDeserializer or ContainerDeserializerBase, but " + var7.getClass().getName());
            }

            var7 = ((lo)var7).d();
            if(!(var7 instanceof ko)) {
               throw new IllegalArgumentException("Can not handle managed/back reference \'" + var4 + "\': value deserializer is of type ContainerDeserializerBase, but content type is not handled by a BeanDeserializer  (instead it\'s of type " + var7.getClass().getName() + ")");
            }

            var8 = ((ko)var7).a(var4);
            var3 = true;
         }

         if(var8 == null) {
            throw new IllegalArgumentException("Can not handle managed/back reference \'" + var4 + "\': no back reference property found from type " + var2.a());
         } else {
            sh var5 = this.b;
            sh var6 = var8.a();
            if(!var6.p().isAssignableFrom(var5.p())) {
               throw new IllegalArgumentException("Can not handle managed/back reference \'" + var4 + "\': back reference type (" + var6.p().getName() + ") not compatible with managed type (" + var5.p().getName() + ")");
            } else {
               return new kt$c(var4, var2, var8, this.a.f(), var3);
            }
         }
      }
   }

   public kt a(String var1) {
      return this.m == null?null:(kt)this.m.get(var1);
   }

   public final Object a(hj var1, iz var2) {
      hm var3 = var1.e();
      if(var3 == hm.b) {
         var1.b();
         return this.b(var1, var2);
      } else {
         switch(null.a[var3.ordinal()]) {
         case 1:
            return this.d(var1, var2);
         case 2:
            return this.e(var1, var2);
         case 3:
            return this.f(var1, var2);
         case 4:
            return var1.z();
         case 5:
         case 6:
            return this.g(var1, var2);
         case 7:
            return this.h(var1, var2);
         case 8:
         case 9:
            return this.b(var1, var2);
         default:
            throw var2.b(this.d());
         }
      }
   }

   public Object a(hj var1, iz var2, jy var3) {
      return var3.a(var1, var2);
   }

   public Object a(hj var1, iz var2, Object var3) {
      if(this.i != null) {
         this.a(var2, var3);
      }

      Object var5;
      if(this.o != null) {
         var5 = this.b(var1, var2, var3);
      } else {
         if(this.p != null) {
            return this.c(var1, var2, var3);
         }

         hm var8 = var1.e();
         hm var4 = var8;
         if(var8 == hm.b) {
            var4 = var1.b();
         }

         while(true) {
            var5 = var3;
            if(var4 != hm.f) {
               break;
            }

            String var7 = var1.g();
            var1.b();
            kt var9 = this.h.a(var7);
            if(var9 != null) {
               try {
                  var9.a(var1, var2, var3);
               } catch (Exception var6) {
                  this.a((Throwable)var6, (Object)var3, (String)var7, (iz)var2);
               }
            } else if(this.k != null && this.k.contains(var7)) {
               var1.d();
            } else if(this.j != null) {
               this.j.a(var1, var2, var3, var7);
            } else {
               this.a(var1, var2, var3, var7);
            }

            var4 = var1.b();
         }
      }

      return var5;
   }

   protected Object a(hj var1, iz var2, Object var3, sq var4) {
      jg var5 = this.b(var2, var3, var4);
      Object var7;
      if(var5 != null) {
         if(var4 != null) {
            var4.e();
            hj var6 = var4.h();
            var6.b();
            var7 = var5.a(var6, var2, var3);
         } else {
            var7 = var3;
         }

         var3 = var7;
         if(var1 != null) {
            var3 = var5.a(var1, var2, var7);
         }
      } else {
         if(var4 != null) {
            var7 = this.a(var2, var3, var4);
         } else {
            var7 = var3;
         }

         var3 = var7;
         if(var1 != null) {
            return this.a(var1, var2, var7);
         }
      }

      return var3;
   }

   protected Object a(iz var1, Object var2, sq var3) {
      var3.e();
      hj var5 = var3.h();

      while(var5.b() != hm.c) {
         String var4 = var5.g();
         var5.b();
         this.a(var5, var1, var2, var4);
      }

      return var2;
   }

   protected void a(hj var1, iz var2, Object var3, String var4) {
      if(!this.l && (this.k == null || !this.k.contains(var4))) {
         super.a(var1, var2, var3, var4);
      } else {
         var1.d();
      }
   }

   public void a(iy var1, jc var2) {
      Iterator var8 = this.h.c();
      lc$a var3 = null;
      lg var4 = null;

      kt var6;
      while(var8.hasNext()) {
         kt var7 = (kt)var8.next();
         kt var5;
         if(!var7.f()) {
            var5 = var7.a(this.a((iy)var1, (jc)var2, (sh)var7.a(), (is)var7));
         } else {
            var5 = var7;
         }

         var5 = this.a(var1, var5);
         var6 = this.b(var1, var5);
         kt var9;
         lg var10;
         if(var6 != null) {
            var10 = var4;
            if(var4 == null) {
               var10 = new lg();
            }

            var10.a(var6);
            var9 = var6;
         } else {
            var6 = var5;
            var10 = var4;
            var9 = var6;
         }

         var6 = this.c(var1, var9);
         if(var6 != var7) {
            this.h.a(var6);
         }

         var4 = var10;
         if(var6.g()) {
            jy var12 = var6.i();
            var4 = var10;
            if(var12.a() == JsonTypeInfo$As.EXTERNAL_PROPERTY) {
               if(var3 == null) {
                  var3 = new lc$a();
               }

               var3.a(var6, var12.b());
               this.h.b(var6);
               var4 = var10;
            }
         }
      }

      if(this.j != null && !this.j.b()) {
         this.j = this.j.a(this.a((iy)var1, (jc)var2, (sh)this.j.c(), (is)this.j.a()));
      }

      if(this.d.i()) {
         sh var13 = this.d.l();
         if(var13 == null) {
            throw new IllegalArgumentException("Invalid delegate-creator definition for " + this.b + ": value instantiator (" + this.d.getClass().getName() + ") returned true for \'canCreateUsingDelegate()\', but null for \'getDelegateType()\'");
         }

         mu var11 = this.d.o();
         this.e = this.a((iy)var1, (jc)var2, (sh)var13, (is)(new is$a((String)null, var13, this.a.f(), var11)));
      }

      if(this.f != null) {
         Iterator var14 = this.f.a().iterator();

         while(var14.hasNext()) {
            var6 = (kt)var14.next();
            if(!var6.f()) {
               this.f.a(var6, this.a((iy)var1, (jc)var2, (sh)var6.a(), (is)var6));
            }
         }
      }

      if(var3 != null) {
         this.p = var3.a();
         this.g = true;
      }

      this.o = var4;
      if(var4 != null) {
         this.g = true;
      }

   }

   protected void a(iz var1, Object var2) {
      lh[] var5 = this.i;
      int var4 = var5.length;

      for(int var3 = 0; var3 < var4; ++var3) {
         var5[var3].b(var1, var2);
      }

   }

   protected void a(Throwable var1, iz var2) {
      while(var1 instanceof InvocationTargetException && var1.getCause() != null) {
         var1 = var1.getCause();
      }

      if(var1 instanceof Error) {
         throw (Error)var1;
      } else {
         boolean var3;
         if(var2 != null && !var2.a(iy$a.n)) {
            var3 = false;
         } else {
            var3 = true;
         }

         if(var1 instanceof IOException) {
            throw (IOException)var1;
         } else if(!var3 && var1 instanceof RuntimeException) {
            throw (RuntimeException)var1;
         } else {
            throw var2.a(this.b.p(), var1);
         }
      }
   }

   public void a(Throwable var1, Object var2, String var3, iz var4) {
      while(var1 instanceof InvocationTargetException && var1.getCause() != null) {
         var1 = var1.getCause();
      }

      if(var1 instanceof Error) {
         throw (Error)var1;
      } else {
         boolean var5;
         if(var4 != null && !var4.a(iy$a.n)) {
            var5 = false;
         } else {
            var5 = true;
         }

         if(var1 instanceof IOException) {
            if(!var5 || !(var1 instanceof jh)) {
               throw (IOException)var1;
            }
         } else if(!var5 && var1 instanceof RuntimeException) {
            throw (RuntimeException)var1;
         }

         throw jh.a(var1, var2, var3);
      }
   }

   protected jg b(iz param1, Object param2, sq param3) {
      // $FF: Couldn't be decompiled
   }

   protected kt b(iy var1, kt var2) {
      mq var3 = var2.b();
      if(var3 != null && var1.a().b(var3) == Boolean.TRUE) {
         jg var4 = var2.h();
         jg var5 = var4.a();
         if(var5 != var4 && var5 != null) {
            return var2.a(var5);
         }
      }

      return null;
   }

   public Object b(hj var1, iz var2) {
      Object var3;
      if(this.g) {
         if(this.o == null) {
            if(this.p != null) {
               return this.l(var1, var2);
            }

            return this.c(var1, var2);
         }

         var3 = this.j(var1, var2);
      } else {
         Object var4 = this.d.m();
         if(this.i != null) {
            this.a(var2, var4);
         }

         while(true) {
            var3 = var4;
            if(var1.e() == hm.c) {
               break;
            }

            String var7 = var1.g();
            var1.b();
            kt var5 = this.h.a(var7);
            if(var5 != null) {
               try {
                  var5.a(var1, var2, var4);
               } catch (Exception var6) {
                  this.a((Throwable)var6, (Object)var4, (String)var7, (iz)var2);
               }
            } else {
               this.b(var1, var2, var4, var7);
            }

            var1.b();
         }
      }

      return var3;
   }

   protected Object b(hj var1, iz var2, Object var3) {
      hm var5 = var1.e();
      hm var4 = var5;
      if(var5 == hm.b) {
         var4 = var1.b();
      }

      sq var9 = new sq(var1.a());
      var9.d();

      for(; var4 == hm.f; var4 = var1.b()) {
         String var8 = var1.g();
         kt var6 = this.h.a(var8);
         var1.b();
         if(var6 != null) {
            try {
               var6.a(var1, var2, var3);
            } catch (Exception var7) {
               this.a((Throwable)var7, (Object)var3, (String)var8, (iz)var2);
            }
         } else if(this.k != null && this.k.contains(var8)) {
            var1.d();
         } else {
            var9.a(var8);
            var9.c(var1);
            if(this.j != null) {
               this.j.a(var1, var2, var3, var8);
            }
         }
      }

      var9.e();
      this.o.a(var1, var2, var3, var9);
      return var3;
   }

   protected kt c(iy var1, kt var2) {
      jg var6 = var2.h();
      Object var5 = var2;
      if(var6 instanceof ko) {
         var5 = var2;
         if(!((ko)var6).e().h()) {
            Class var7 = var2.a().p();
            Class var9 = qy.b(var7);
            var5 = var2;
            if(var9 != null) {
               var5 = var2;
               if(var9 == this.b.p()) {
                  Constructor[] var11 = var7.getConstructors();
                  int var4 = var11.length;
                  int var3 = 0;

                  while(true) {
                     var5 = var2;
                     if(var3 >= var4) {
                        break;
                     }

                     Constructor var10 = var11[var3];
                     Class[] var8 = var10.getParameterTypes();
                     if(var8.length == 1 && var8[0] == var9) {
                        if(var1.a(iy$a.f)) {
                           qy.a((Member)var10);
                        }

                        var5 = new kt$b(var2, var10);
                        break;
                     }

                     ++var3;
                  }
               }
            }
         }
      }

      return (kt)var5;
   }

   protected Object c(hj var1, iz var2) {
      if(this.e != null) {
         return this.d.a(this.e.a(var1, var2));
      } else if(this.f != null) {
         return this.i(var1, var2);
      } else if(this.b.c()) {
         throw jh.a(var1, "Can not instantiate abstract type " + this.b + " (need to add/enable type information?)");
      } else {
         throw jh.a(var1, "No suitable constructor found for type " + this.b + ": can not instantiate from JSON object (need to add/enable type information?)");
      }
   }

   protected Object c(hj var1, iz var2, Object var3) {
      lc var4;
      for(var4 = this.p.a(); var1.e() != hm.c; var1.b()) {
         String var5 = var1.g();
         var1.b();
         kt var6 = this.h.a(var5);
         if(var6 != null) {
            try {
               var6.a(var1, var2, var3);
            } catch (Exception var7) {
               this.a((Throwable)var7, (Object)var3, (String)var5, (iz)var2);
            }
         } else if(this.k != null && this.k.contains(var5)) {
            var1.d();
         } else if(!var4.a(var1, var2, var5, var3)) {
            if(this.j != null) {
               try {
                  this.j.a(var1, var2, var3, var5);
               } catch (Exception var8) {
                  this.a((Throwable)var8, (Object)var3, (String)var5, (iz)var2);
               }
            } else {
               this.a(var1, var2, var3, var5);
            }
         }
      }

      return var4.a(var1, var2, var3);
   }

   public final Class d() {
      return this.b.p();
   }

   public Object d(hj var1, iz var2) {
      if(this.e != null && !this.d.c()) {
         Object var3 = this.d.a(this.e.a(var1, var2));
         if(this.i != null) {
            this.a(var2, var3);
         }

         return var3;
      } else {
         return this.d.a(var1.k());
      }
   }

   public kx e() {
      return this.d;
   }

   public Object e(hj var1, iz var2) {
      Object var3;
      Object var4;
      switch(null.b[var1.q().ordinal()]) {
      case 1:
         if(this.e != null && !this.d.d()) {
            var3 = this.d.a(this.e.a(var1, var2));
            var4 = var3;
            if(this.i != null) {
               this.a(var2, var3);
               return var3;
            }
            break;
         }

         return this.d.a(var1.t());
      case 2:
         if(this.e != null && !this.d.d()) {
            var3 = this.d.a(this.e.a(var1, var2));
            var4 = var3;
            if(this.i != null) {
               this.a(var2, var3);
               return var3;
            }
            break;
         }

         return this.d.a(var1.u());
      default:
         if(this.e == null) {
            throw var2.a(this.d(), "no suitable creator method found to deserialize from JSON integer number");
         }

         var3 = this.d.a(this.e.a(var1, var2));
         var4 = var3;
         if(this.i != null) {
            this.a(var2, var3);
            var4 = var3;
         }
      }

      return var4;
   }

   public Object f(hj var1, iz var2) {
      Object var4;
      switch(null.b[var1.q().ordinal()]) {
      case 3:
      case 4:
         if(this.e != null && !this.d.f()) {
            Object var3 = this.d.a(this.e.a(var1, var2));
            var4 = var3;
            if(this.i != null) {
               this.a(var2, var3);
               return var3;
            }
            break;
         }

         return this.d.a(var1.x());
      default:
         if(this.e == null) {
            throw var2.a(this.d(), "no suitable creator method found to deserialize from JSON floating-point number");
         }

         var4 = this.d.a(this.e.a(var1, var2));
      }

      return var4;
   }

   public Object g(hj var1, iz var2) {
      if(this.e != null && !this.d.g()) {
         Object var4 = this.d.a(this.e.a(var1, var2));
         if(this.i != null) {
            this.a(var2, var4);
         }

         return var4;
      } else {
         boolean var3;
         if(var1.e() == hm.k) {
            var3 = true;
         } else {
            var3 = false;
         }

         return this.d.a(var3);
      }
   }

   public Object h(hj var1, iz var2) {
      if(this.e != null) {
         try {
            Object var4 = this.d.a(this.e.a(var1, var2));
            if(this.i != null) {
               this.a(var2, var4);
            }

            return var4;
         } catch (Exception var3) {
            this.a((Throwable)var3, (iz)var2);
         }
      }

      throw var2.b(this.d());
   }

   protected final Object i(hj var1, iz var2) {
      ld var6 = this.f;
      lf var7 = var6.a(var1, var2);
      hm var4 = var1.e();
      sq var3 = null;

      Object var15;
      while(true) {
         if(var4 != hm.f) {
            Object var12;
            try {
               var12 = var6.a(var7);
            } catch (Exception var10) {
               this.a((Throwable)var10, (iz)var2);
               return null;
            }

            if(var3 != null) {
               if(var12.getClass() != this.b.p()) {
                  return this.a((hj)null, (iz)var2, (Object)var12, (sq)var3);
               }

               return this.a(var2, var12, var3);
            }

            return var12;
         }

         String var5 = var1.g();
         var1.b();
         kt var8 = var6.a(var5);
         sq var14;
         if(var8 != null) {
            Object var9 = var8.a(var1, var2);
            var14 = var3;
            if(var7.a(var8.j(), var9)) {
               var1.b();

               try {
                  var15 = var6.a(var7);
                  break;
               } catch (Exception var11) {
                  this.a((Throwable)var11, (Object)this.b.p(), (String)var5, (iz)var2);
                  var14 = var3;
               }
            }
         } else {
            kt var16 = this.h.a(var5);
            if(var16 != null) {
               var7.a(var16, var16.a(var1, var2));
               var14 = var3;
            } else if(this.k != null && this.k.contains(var5)) {
               var1.d();
               var14 = var3;
            } else if(this.j != null) {
               var7.a(this.j, var5, this.j.a(var1, var2));
               var14 = var3;
            } else {
               var14 = var3;
               if(var3 == null) {
                  var14 = new sq(var1.a());
               }

               var14.a(var5);
               var14.c(var1);
            }
         }

         hm var17 = var1.b();
         var3 = var14;
         var4 = var17;
      }

      if(var15.getClass() != this.b.p()) {
         return this.a(var1, var2, var15, var3);
      } else {
         Object var13;
         if(var3 != null) {
            var13 = this.a(var2, var15, var3);
         } else {
            var13 = var15;
         }

         return this.a(var1, var2, var13);
      }
   }

   protected Object j(hj var1, iz var2) {
      if(this.e != null) {
         return this.d.a(this.e.a(var1, var2));
      } else if(this.f != null) {
         return this.k(var1, var2);
      } else {
         sq var3 = new sq(var1.a());
         var3.d();
         Object var4 = this.d.m();
         if(this.i != null) {
            this.a(var2, var4);
         }

         for(; var1.e() != hm.c; var1.b()) {
            String var5 = var1.g();
            var1.b();
            kt var6 = this.h.a(var5);
            if(var6 != null) {
               try {
                  var6.a(var1, var2, var4);
               } catch (Exception var7) {
                  this.a((Throwable)var7, (Object)var4, (String)var5, (iz)var2);
               }
            } else if(this.k != null && this.k.contains(var5)) {
               var1.d();
            } else {
               var3.a(var5);
               var3.c(var1);
               if(this.j != null) {
                  try {
                     this.j.a(var1, var2, var4, var5);
                  } catch (Exception var8) {
                     this.a((Throwable)var8, (Object)var4, (String)var5, (iz)var2);
                  }
               }
            }
         }

         var3.e();
         this.o.a(var1, var2, var4, var3);
         return var4;
      }
   }

   protected Object k(hj var1, iz var2) {
      ld var5 = this.f;
      lf var6 = var5.a(var1, var2);
      sq var4 = new sq(var1.a());
      var4.d();
      hm var3 = var1.e();

      Object var8;
      while(true) {
         if(var3 != hm.f) {
            Object var12;
            try {
               var12 = var5.a(var6);
            } catch (Exception var9) {
               this.a((Throwable)var9, (iz)var2);
               return null;
            }

            return this.o.a(var1, var2, var12, var4);
         }

         String var7 = var1.g();
         var1.b();
         kt var11 = var5.a(var7);
         if(var11 != null) {
            var8 = var11.a(var1, var2);
            if(var6.a(var11.j(), var8)) {
               var3 = var1.b();

               try {
                  var8 = var5.a(var6);
                  break;
               } catch (Exception var10) {
                  this.a((Throwable)var10, (Object)this.b.p(), (String)var7, (iz)var2);
               }
            }
         } else {
            var11 = this.h.a(var7);
            if(var11 != null) {
               var6.a(var11, var11.a(var1, var2));
            } else if(this.k != null && this.k.contains(var7)) {
               var1.d();
            } else {
               var4.a(var7);
               var4.c(var1);
               if(this.j != null) {
                  var6.a(this.j, var7, this.j.a(var1, var2));
               }
            }
         }

         var3 = var1.b();
      }

      while(var3 == hm.f) {
         var1.b();
         var4.c(var1);
         var3 = var1.b();
      }

      var4.e();
      if(var8.getClass() != this.b.p()) {
         throw var2.b("Can not create polymorphic instances with unwrapped values");
      } else {
         return this.o.a(var1, var2, var8, var4);
      }
   }

   protected Object l(hj var1, iz var2) {
      return this.f != null?this.m(var1, var2):this.c(var1, var2, this.d.m());
   }

   protected Object m(hj var1, iz var2) {
      lc var4 = this.p.a();
      ld var6 = this.f;
      lf var7 = var6.a(var1, var2);
      sq var5 = new sq(var1.a());
      var5.d();
      hm var3 = var1.e();

      Object var9;
      while(true) {
         if(var3 != hm.f) {
            Object var13;
            try {
               var13 = var6.a(var7);
            } catch (Exception var10) {
               this.a((Throwable)var10, (iz)var2);
               return null;
            }

            return var4.a(var1, var2, var13);
         }

         String var8 = var1.g();
         var1.b();
         kt var12 = var6.a(var8);
         if(var12 != null) {
            var9 = var12.a(var1, var2);
            if(var7.a(var12.j(), var9)) {
               var3 = var1.b();

               try {
                  var9 = var6.a(var7);
                  break;
               } catch (Exception var11) {
                  this.a((Throwable)var11, (Object)this.b.p(), (String)var8, (iz)var2);
               }
            }
         } else {
            var12 = this.h.a(var8);
            if(var12 != null) {
               var7.a(var12, var12.a(var1, var2));
            } else if(!var4.a(var1, var2, var8, (Object)null)) {
               if(this.k != null && this.k.contains(var8)) {
                  var1.d();
               } else if(this.j != null) {
                  var7.a(this.j, var8, this.j.a(var1, var2));
               }
            }
         }

         var3 = var1.b();
      }

      while(var3 == hm.f) {
         var1.b();
         var5.c(var1);
         var3 = var1.b();
      }

      if(var9.getClass() != this.b.p()) {
         throw var2.b("Can not create polymorphic instances with unwrapped values");
      } else {
         return var4.a(var1, var2, var9);
      }
   }
}
