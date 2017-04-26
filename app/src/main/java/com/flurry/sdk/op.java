package com.flurry.sdk;

import com.flurry.sdk.iq;
import com.flurry.sdk.jk;
import com.flurry.sdk.ju;
import com.flurry.sdk.ju$a;
import com.flurry.sdk.jz;
import com.flurry.sdk.kg$a;
import com.flurry.sdk.kg$b;
import com.flurry.sdk.mm;
import com.flurry.sdk.mp;
import com.flurry.sdk.mq;
import com.flurry.sdk.mr;
import com.flurry.sdk.mw;
import com.flurry.sdk.oi;
import com.flurry.sdk.ol;
import com.flurry.sdk.op$a;
import com.flurry.sdk.op$b;
import com.flurry.sdk.op$c;
import com.flurry.sdk.op$d;
import com.flurry.sdk.qv;
import com.flurry.sdk.qz;
import com.flurry.sdk.sh;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;

public class op {
   protected final ju a;
   protected final mw b;
   protected final kg$a c;
   protected final iq d;
   protected Object e;

   public op(ju var1, mw var2) {
      this.a = var1;
      this.b = var2;
      this.c = var2.a(var1.g());
      this.d = this.a.a();
   }

   protected oi a(String var1, sh var2, jk var3, jz var4, jz var5, mq var6, boolean var7) {
      Method var10;
      Field var11;
      if(var6 instanceof mp) {
         var10 = null;
         var11 = ((mp)var6).e();
      } else {
         var10 = ((mr)var6).e();
         var11 = null;
      }

      sh var12 = this.a(var6, var7, var2);
      sh var13;
      if(var5 != null) {
         var13 = var12;
         if(var12 == null) {
            var13 = var2;
         }

         if(var13.g() == null) {
            throw new IllegalStateException("Problem trying to create BeanPropertyWriter for property \'" + var1 + "\' (of type " + this.b.a() + "); serialization type " + var13 + " has no content");
         }

         var12 = var13.e(var5);
         var12.g();
      }

      Object var18;
      label46: {
         var13 = null;
         var7 = false;
         boolean var9 = false;
         kg$a var14 = this.d.a((mm)var6, (kg$a)this.c);
         boolean var8 = var9;
         var18 = var13;
         if(var14 != null) {
            switch(null.a[var14.ordinal()]) {
            case 1:
               Object var19 = this.a(var1, var10, var11);
               if(var19 == null) {
                  var7 = true;
                  var18 = var19;
                  break label46;
               }

               var8 = var9;
               var18 = var19;
               if(var19.getClass().isArray()) {
                  var18 = qz.a(var19);
                  var7 = false;
                  break label46;
               }
               break;
            case 2:
               var18 = this.b(var1, var2);
               var7 = true;
               break label46;
            case 3:
               var7 = true;
            case 4:
               var8 = var7;
               var18 = var13;
               if(var2.f()) {
                  var18 = this.a(var1, var2);
                  break label46;
               }
               break;
            default:
               var18 = var13;
               var8 = var9;
            }
         }

         var7 = var8;
      }

      oi var16 = new oi(var6, this.b.i(), var1, var2, var3, var4, var12, var10, var11, var7, var18);
      Boolean var17 = this.d.b(var6);
      oi var15 = var16;
      if(var17 != null) {
         var15 = var16;
         if(var17.booleanValue()) {
            var15 = var16.c();
         }
      }

      return var15;
   }

   public qv a() {
      return this.b.i();
   }

   protected sh a(mm var1, boolean var2, sh var3) {
      boolean var4 = true;
      Class var5 = this.d.e(var1);
      if(var5 != null) {
         Class var6 = var3.p();
         if(var5.isAssignableFrom(var6)) {
            var3 = var3.h(var5);
         } else {
            if(!var6.isAssignableFrom(var5)) {
               throw new IllegalArgumentException("Illegal concrete-type annotation for method \'" + var1.b() + "\': class " + var5.getName() + " not a super-type of (declared) class " + var6.getName());
            }

            var3 = this.a.a(var3, var5);
         }

         var2 = true;
      }

      sh var8 = ol.b(this.a, var1, var3);
      if(var8 != var3) {
         var3 = var8;
         var2 = true;
      }

      if(!var2) {
         kg$b var7 = this.d.f(var1);
         if(var7 != null) {
            if(var7 == kg$b.b) {
               var2 = var4;
            } else {
               var2 = false;
            }
         }
      }

      return var2?var3:null;
   }

   protected Object a(Exception var1, String var2, Object var3) {
      while(((Throwable)var1).getCause() != null) {
         var1 = ((Throwable)var1).getCause();
      }

      if(var1 instanceof Error) {
         throw (Error)var1;
      } else if(var1 instanceof RuntimeException) {
         throw (RuntimeException)var1;
      } else {
         throw new IllegalArgumentException("Failed to get property \'" + var2 + "\' of default " + var3.getClass().getName() + " instance");
      }
   }

   protected Object a(String var1, sh var2) {
      if(!this.a.a(ju$a.w)) {
         if(var2.b()) {
            return new op$a();
         }

         if(Collection.class.isAssignableFrom(var2.p())) {
            return new op$b();
         }
      }

      return null;
   }

   protected Object a(String param1, Method param2, Field param3) {
      // $FF: Couldn't be decompiled
   }

   protected Object b() {
      if(this.e == null) {
         this.e = this.b.a(this.a.a(ju$a.e));
         if(this.e == null) {
            Class var1 = this.b.c().e();
            throw new IllegalArgumentException("Class " + var1.getName() + " has no default constructor; can not instantiate default bean value to support \'properties=JsonSerialize.Inclusion.NON_DEFAULT\' annotation");
         }
      }

      return this.e;
   }

   protected Object b(String var1, sh var2) {
      Class var3 = var2.p();
      return var3 == String.class?new op$d():(var2.b()?new op$a():(Collection.class.isAssignableFrom(var3)?new op$b():(Map.class.isAssignableFrom(var3)?new op$c():null)));
   }
}
