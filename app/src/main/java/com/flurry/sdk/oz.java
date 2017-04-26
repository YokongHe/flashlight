package com.flurry.sdk;

import com.flurry.sdk.hf;
import com.flurry.sdk.is;
import com.flurry.sdk.jk;
import com.flurry.sdk.jw;
import com.flurry.sdk.oi;
import com.flurry.sdk.ov;
import com.flurry.sdk.sh;

public class oz extends oi {
   public oz(oi var1) {
      super(var1);
   }

   public oz(oi var1, jk var2) {
      super(var1, var2);
   }

   protected jk a(ov var1, Class var2, jw var3) {
      jk var4;
      if(this.o != null) {
         var4 = var3.a((sh)var3.a(this.o, var2), (is)this);
      } else {
         var4 = var3.a((Class)var2, (is)this);
      }

      jk var5 = var4;
      if(!var4.b()) {
         var5 = var4.a();
      }

      this.j = this.j.a(var2, var5);
      return var5;
   }

   public oi a(jk var1) {
      if(this.getClass() != oz.class) {
         throw new IllegalStateException("UnwrappingBeanPropertyWriter sub-class does not override \'withSerializer()\'; needs to!");
      } else {
         jk var2 = var1;
         if(!var1.b()) {
            var2 = var1.a();
         }

         return new oz(this, var2);
      }
   }

   public void a(Object var1, hf var2, jw var3) {
      Object var5 = this.a(var1);
      if(var5 != null) {
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

            if(!var8.b()) {
               var2.a(this.g);
            }

            if(this.n == null) {
               var8.a(var5, var2, var3);
               return;
            }

            var8.a(var5, var2, var3, this.n);
            return;
         }
      }

   }
}
