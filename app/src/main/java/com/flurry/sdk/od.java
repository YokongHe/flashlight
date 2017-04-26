package com.flurry.sdk;

import com.flurry.sdk.ir;
import com.flurry.sdk.is;
import com.flurry.sdk.jk;
import com.flurry.sdk.ju;
import com.flurry.sdk.jx$a;
import com.flurry.sdk.jz;
import com.flurry.sdk.qj;
import com.flurry.sdk.qk;
import com.flurry.sdk.ql;
import com.flurry.sdk.qn;
import com.flurry.sdk.qo;
import com.flurry.sdk.sh;
import java.util.HashMap;

public class od extends jx$a {
   protected HashMap a;
   protected HashMap b;

   public jk a(ju var1, qk var2, ir var3, is var4, jz var5, jk var6) {
      return this.a(var1, var2, var3, var4);
   }

   public jk a(ju var1, ql var2, ir var3, is var4, jz var5, jk var6) {
      return this.a(var1, var2, var3, var4);
   }

   public jk a(ju var1, qn var2, ir var3, is var4, jk var5, jz var6, jk var7) {
      return this.a(var1, var2, var3, var4);
   }

   public jk a(ju var1, qo var2, ir var3, is var4, jk var5, jz var6, jk var7) {
      return this.a(var1, var2, var3, var4);
   }

   public jk a(ju var1, sh var2, ir var3, is var4) {
      Class var7 = var2.p();
      qj var5 = new qj(var7);
      jk var6;
      jk var10;
      if(var7.isInterface()) {
         if(this.b != null) {
            var6 = (jk)this.b.get(var5);
            if(var6 != null) {
               return var6;
            }
         }
      } else if(this.a != null) {
         var10 = (jk)this.a.get(var5);
         var6 = var10;
         if(var10 != null) {
            return var6;
         }

         for(Class var11 = var7; var11 != null; var11 = var11.getSuperclass()) {
            var5.a(var11);
            jk var12 = (jk)this.a.get(var5);
            var6 = var12;
            if(var12 != null) {
               return var6;
            }
         }
      }

      if(this.b == null) {
         return null;
      } else {
         var10 = this.a(var7, var5);
         var6 = var10;
         if(var10 == null) {
            if(!var7.isInterface()) {
               Class var8 = var7;

               jk var9;
               do {
                  var8 = var8.getSuperclass();
                  if(var8 == null) {
                     return null;
                  }

                  var9 = this.a(var8, var5);
               } while(var9 == null);

               return var9;
            } else {
               return null;
            }
         } else {
            return var6;
         }
      }
   }

   protected jk a(Class var1, qj var2) {
      Class[] var6 = var1.getInterfaces();
      int var4 = var6.length;
      int var3 = 0;

      jk var8;
      while(true) {
         if(var3 >= var4) {
            return null;
         }

         Class var5 = var6[var3];
         var2.a(var5);
         var8 = (jk)this.b.get(var2);
         if(var8 != null) {
            break;
         }

         jk var7 = this.a(var5, var2);
         var8 = var7;
         if(var7 != null) {
            break;
         }

         ++var3;
      }

      return var8;
   }
}
