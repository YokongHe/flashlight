package com.flurry.sdk;

import com.flurry.sdk.mq;
import com.flurry.sdk.mt;
import com.flurry.sdk.mv;
import com.flurry.sdk.qr;
import com.flurry.sdk.qs;
import com.flurry.sdk.sh;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public abstract class mu extends mq {
   protected final mv[] d;

   protected mu(mv var1, mv[] var2) {
      super(var1);
      this.d = var2;
   }

   protected mt a(int var1, mv var2) {
      this.d[var1] = var2;
      return this.c(var1);
   }

   protected sh a(qr var1, TypeVariable[] var2) {
      qr var5 = var1;
      if(var2 != null) {
         var5 = var1;
         if(var2.length > 0) {
            qr var6 = var1.a();
            int var4 = var2.length;
            int var3 = 0;

            while(true) {
               var5 = var6;
               if(var3 >= var4) {
                  break;
               }

               TypeVariable var9 = var2[var3];
               var6.b(var9.getName());
               Type var7 = var9.getBounds()[0];
               sh var8;
               if(var7 == null) {
                  var8 = qs.b();
               } else {
                  var8 = var6.a(var7);
               }

               var6.a(var9.getName(), var8);
               ++var3;
            }
         }
      }

      return var5.a(this.c());
   }

   public abstract Object a(Object var1);

   public abstract Object a(Object[] var1);

   public final Annotation a(Class var1) {
      return this.b.a(var1);
   }

   public final void a(int var1, Annotation var2) {
      mv var4 = this.d[var1];
      mv var3 = var4;
      if(var4 == null) {
         var3 = new mv();
         this.d[var1] = var3;
      }

      var3.b(var2);
   }

   public final void a(Annotation var1) {
      this.b.b(var1);
   }

   public abstract Type b(int var1);

   public final void b(Annotation var1) {
      this.b.a(var1);
   }

   public final mt c(int var1) {
      return new mt(this, this.b(var1), this.d[var1], var1);
   }

   public abstract Object g();
}
