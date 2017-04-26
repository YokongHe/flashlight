package com.flurry.sdk;

import com.flurry.sdk.hf;
import com.flurry.sdk.im;
import com.flurry.sdk.is;
import com.flurry.sdk.jh;
import com.flurry.sdk.jk;
import com.flurry.sdk.jw;
import com.flurry.sdk.jz;
import com.flurry.sdk.mq;
import com.flurry.sdk.ov;
import com.flurry.sdk.ov$d;
import com.flurry.sdk.oz;
import com.flurry.sdk.qv;
import com.flurry.sdk.sh;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashMap;

public class oi implements is {
   protected final mq a;
   protected final qv b;
   protected final sh c;
   protected final Method d;
   protected final Field e;
   protected HashMap f;
   protected final im g;
   protected final sh h;
   protected final jk i;
   protected ov j;
   protected final boolean k;
   protected final Object l;
   protected Class[] m;
   protected jz n;
   protected sh o;

   public oi(mq var1, qv var2, im var3, sh var4, jk var5, jz var6, sh var7, Method var8, Field var9, boolean var10, Object var11) {
      this.a = var1;
      this.b = var2;
      this.g = var3;
      this.c = var4;
      this.i = var5;
      ov var12;
      if(var5 == null) {
         var12 = ov.a();
      } else {
         var12 = null;
      }

      this.j = var12;
      this.n = var6;
      this.h = var7;
      this.d = var8;
      this.e = var9;
      this.k = var10;
      this.l = var11;
   }

   public oi(mq var1, qv var2, String var3, sh var4, jk var5, jz var6, sh var7, Method var8, Field var9, boolean var10, Object var11) {
      this(var1, var2, new im(var3), var4, var5, var6, var7, var8, var9, var10, var11);
   }

   protected oi(oi var1) {
      this(var1, var1.i);
   }

   protected oi(oi var1, jk var2) {
      this.i = var2;
      this.a = var1.a;
      this.b = var1.b;
      this.c = var1.c;
      this.d = var1.d;
      this.e = var1.e;
      if(var1.f != null) {
         this.f = new HashMap(var1.f);
      }

      this.g = var1.g;
      this.h = var1.h;
      this.j = var1.j;
      this.k = var1.k;
      this.l = var1.l;
      this.m = var1.m;
      this.n = var1.n;
      this.o = var1.o;
   }

   protected jk a(ov var1, Class var2, jw var3) {
      ov$d var4;
      if(this.o != null) {
         var4 = var1.a((sh)var3.a(this.o, var2), var3, this);
      } else {
         var4 = var1.a((Class)var2, var3, this);
      }

      if(var1 != var4.b) {
         this.j = var4.b;
      }

      return var4.a;
   }

   public oi a(jk var1) {
      if(this.getClass() != oi.class) {
         throw new IllegalStateException("BeanPropertyWriter sub-class does not override \'withSerializer()\'; needs to!");
      } else {
         return new oi(this, var1);
      }
   }

   public sh a() {
      return this.c;
   }

   public final Object a(Object var1) {
      return this.d != null?this.d.invoke(var1, new Object[0]):this.e.get(var1);
   }

   public void a(sh var1) {
      this.o = var1;
   }

   public void a(Object var1, hf var2, jw var3) {
      Object var5 = this.a(var1);
      if(var5 == null) {
         if(!this.k) {
            var2.a(this.g);
            var3.a(var2);
         }
      } else {
         if(var5 == var1) {
            this.b(var1);
         }

         if(this.l == null || !this.l.equals(var5)) {
            jk var4 = this.i;
            jk var8 = var4;
            if(var4 == null) {
               Class var6 = var5.getClass();
               ov var7 = this.j;
               var4 = var7.a(var6);
               var8 = var4;
               if(var4 == null) {
                  var8 = this.a(var7, var6, var3);
               }
            }

            var2.a(this.g);
            if(this.n == null) {
               var8.a(var5, var2, var3);
               return;
            }

            var8.a(var5, var2, var3, this.n);
            return;
         }
      }

   }

   public void a(Class[] var1) {
      this.m = var1;
   }

   public mq b() {
      return this.a;
   }

   protected void b(Object var1) {
      throw new jh("Direct self-reference leading to cycle");
   }

   public oi c() {
      return new oz(this);
   }

   public String d() {
      return this.g.a();
   }

   public boolean e() {
      return this.i != null;
   }

   public sh f() {
      return this.h;
   }

   public Type g() {
      return this.d != null?this.d.getGenericReturnType():this.e.getGenericType();
   }

   public Class[] h() {
      return this.m;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder(40);
      var1.append("property \'").append(this.d()).append("\' (");
      if(this.d != null) {
         var1.append("via method ").append(this.d.getDeclaringClass().getName()).append("#").append(this.d.getName());
      } else {
         var1.append("field \"").append(this.e.getDeclaringClass().getName()).append("#").append(this.e.getName());
      }

      if(this.i == null) {
         var1.append(", no static serializer");
      } else {
         var1.append(", static serializer of type " + this.i.getClass().getName());
      }

      var1.append(')');
      return var1.toString();
   }
}
