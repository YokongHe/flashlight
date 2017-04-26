package com.flurry.sdk;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class qm {
   protected final Type a;
   protected final Class b;
   protected final ParameterizedType c;
   protected qm d;
   protected qm e;

   public qm(Type var1) {
      this.a = var1;
      if(var1 instanceof Class) {
         this.b = (Class)var1;
         this.c = null;
      } else if(var1 instanceof ParameterizedType) {
         this.c = (ParameterizedType)var1;
         this.b = (Class)this.c.getRawType();
      } else {
         throw new IllegalArgumentException("Type " + var1.getClass().getName() + " can not be used to construct HierarchicType");
      }
   }

   private qm(Type var1, Class var2, ParameterizedType var3, qm var4, qm var5) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.e = var5;
   }

   public qm a() {
      qm var1;
      if(this.d == null) {
         var1 = null;
      } else {
         var1 = this.d.a();
      }

      qm var2 = new qm(this.a, this.b, this.c, var1, (qm)null);
      if(var1 != null) {
         var1.b(var2);
      }

      return var2;
   }

   public void a(qm var1) {
      this.d = var1;
   }

   public final qm b() {
      return this.d;
   }

   public void b(qm var1) {
      this.e = var1;
   }

   public final boolean c() {
      return this.c != null;
   }

   public final ParameterizedType d() {
      return this.c;
   }

   public final Class e() {
      return this.b;
   }

   public String toString() {
      return this.c != null?this.c.toString():this.b.getName();
   }
}
