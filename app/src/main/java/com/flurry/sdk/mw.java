package com.flurry.sdk;

import com.flurry.sdk.iq;
import com.flurry.sdk.iq$a;
import com.flurry.sdk.ir;
import com.flurry.sdk.it;
import com.flurry.sdk.jn;
import com.flurry.sdk.kg$a;
import com.flurry.sdk.mm;
import com.flurry.sdk.mn;
import com.flurry.sdk.mo;
import com.flurry.sdk.mq;
import com.flurry.sdk.mr;
import com.flurry.sdk.nc;
import com.flurry.sdk.qr;
import com.flurry.sdk.qv;
import com.flurry.sdk.sh;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class mw extends ir {
   protected final jn b;
   protected final iq c;
   protected final mn d;
   protected qr e;
   protected final List f;
   protected mr g;
   protected Map h;
   protected Set i;
   protected Set j;
   protected mr k;
   protected mr l;

   protected mw(jn var1, sh var2, mn var3, List var4) {
      super(var2);
      this.b = var1;
      iq var5;
      if(var1 == null) {
         var5 = null;
      } else {
         var5 = var1.a();
      }

      this.c = var5;
      this.d = var3;
      this.f = var4;
   }

   public static mw a(jn var0, sh var1, mn var2) {
      return new mw(var0, var1, var2, Collections.emptyList());
   }

   public static mw a(nc var0) {
      mw var1 = new mw(var0.a(), var0.b(), var0.c(), var0.d());
      var1.g = var0.h();
      var1.i = var0.i();
      var1.j = var0.j();
      var1.h = var0.e();
      return var1;
   }

   public static mw b(nc var0) {
      mw var1 = new mw(var0.a(), var0.b(), var0.c(), var0.d());
      var1.k = var0.f();
      var1.l = var0.g();
      return var1;
   }

   public kg$a a(kg$a var1) {
      return this.c == null?var1:this.c.a((mm)this.d, (kg$a)var1);
   }

   public mr a(String var1, Class[] var2) {
      return this.d.a(var1, var2);
   }

   public sh a(Type var1) {
      return var1 == null?null:this.j().a(var1);
   }

   public Object a(boolean var1) {
      mo var2 = this.d.h();
      if(var2 == null) {
         return null;
      } else {
         if(var1) {
            var2.k();
         }

         Object var4;
         try {
            var4 = var2.e().newInstance(new Object[0]);
            return var4;
         } catch (Exception var3) {
            for(var4 = var3; ((Throwable)var4).getCause() != null; var4 = ((Throwable)var4).getCause()) {
               ;
            }

            if(var4 instanceof Error) {
               throw (Error)var4;
            } else if(var4 instanceof RuntimeException) {
               throw (RuntimeException)var4;
            } else {
               throw new IllegalArgumentException("Failed to instantiate bean of type " + this.d.e().getName() + ": (" + var4.getClass().getName() + ") " + ((Throwable)var4).getMessage(), (Throwable)var4);
            }
         }
      }
   }

   public Constructor a(Class... var1) {
      Iterator var4 = this.d.i().iterator();

      while(true) {
         mo var5;
         do {
            if(!var4.hasNext()) {
               return null;
            }

            var5 = (mo)var4.next();
         } while(var5.f() != 1);

         Class var6 = var5.a(0);
         int var3 = var1.length;

         for(int var2 = 0; var2 < var3; ++var2) {
            if(var1[var2] == var6) {
               return var5.e();
            }
         }
      }
   }

   protected boolean a(mr var1) {
      Class var2 = var1.d();
      if(this.b().isAssignableFrom(var2)) {
         if(this.c.k(var1)) {
            return true;
         }

         if("valueOf".equals(var1.b())) {
            return true;
         }
      }

      return false;
   }

   public Method b(Class... var1) {
      Iterator var4 = this.d.j().iterator();

      while(true) {
         mr var5;
         do {
            if(!var4.hasNext()) {
               return null;
            }

            var5 = (mr)var4.next();
         } while(!this.a(var5));

         Class var6 = var5.a(0);
         int var3 = var1.length;

         for(int var2 = 0; var2 < var3; ++var2) {
            if(var6.isAssignableFrom(var1[var2])) {
               return var5.e();
            }
         }
      }
   }

   public mn c() {
      return this.d;
   }

   public List d() {
      return this.f;
   }

   public mr e() {
      return this.k;
   }

   public Set f() {
      return this.i == null?Collections.emptySet():this.i;
   }

   public Set g() {
      return this.j;
   }

   public boolean h() {
      return this.d.g();
   }

   public qv i() {
      return this.d.f();
   }

   public qr j() {
      if(this.e == null) {
         this.e = new qr(this.b.m(), this.a);
      }

      return this.e;
   }

   public mo k() {
      return this.d.h();
   }

   public mr l() {
      if(this.g != null) {
         Class var1 = this.g.a(0);
         if(var1 != String.class && var1 != Object.class) {
            throw new IllegalArgumentException("Invalid \'any-setter\' annotation on method " + this.g.b() + "(): first argument not of type String or Object, but " + var1.getName());
         }
      }

      return this.g;
   }

   public Map m() {
      return this.h;
   }

   public List n() {
      return this.d.i();
   }

   public List o() {
      List var2 = this.d.j();
      if(var2.isEmpty()) {
         return var2;
      } else {
         ArrayList var1 = new ArrayList();
         Iterator var4 = var2.iterator();

         while(var4.hasNext()) {
            mr var3 = (mr)var4.next();
            if(this.a(var3)) {
               var1.add(var3);
            }
         }

         return var1;
      }
   }

   public mr p() {
      if(this.l != null && !Map.class.isAssignableFrom(this.l.d())) {
         throw new IllegalArgumentException("Invalid \'any-getter\' annotation on method " + this.l.b() + "(): return type is not instance of java.util.Map");
      } else {
         return this.l;
      }
   }

   public Map q() {
      HashMap var1 = null;
      Iterator var2 = this.f.iterator();

      while(var2.hasNext()) {
         mq var3 = ((it)var2.next()).k();
         if(var3 != null) {
            iq$a var4 = this.c.a(var3);
            if(var4 != null && var4.c()) {
               if(var1 == null) {
                  var1 = new HashMap();
               }

               String var5 = var4.a();
               if(var1.put(var5, var3) != null) {
                  throw new IllegalArgumentException("Multiple back-reference properties with name \'" + var5 + "\'");
               }
            }
         }
      }

      return var1;
   }
}
