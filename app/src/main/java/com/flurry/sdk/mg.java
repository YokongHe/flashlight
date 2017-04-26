package com.flurry.sdk;

import com.flurry.sdk.hj;
import com.flurry.sdk.hm;
import com.flurry.sdk.iz;
import com.flurry.sdk.jg;
import com.flurry.sdk.jh;
import com.flurry.sdk.ko;
import com.flurry.sdk.kt;

public class mg extends ko {
   public mg(ko var1) {
      super(var1);
   }

   protected mg(ko var1, boolean var2) {
      super(var1, var2);
   }

   public jg a() {
      return this.getClass() != mg.class?this:new mg(this, true);
   }

   public Object b(hj var1, iz var2) {
      byte var5 = 0;
      Object var12;
      if(this.f != null) {
         var12 = this.i(var1, var2);
      } else {
         if(this.e != null) {
            return this.d.a(this.e.a(var1, var2));
         }

         if(this.b.c()) {
            throw jh.a(var1, "Can not instantiate abstract type " + this.b + " (need to add/enable type information?)");
         }

         boolean var6 = this.d.c();
         boolean var7 = this.d.h();
         if(!var6 && !var7) {
            throw new jh("Can not deserialize Throwable of type " + this.b + " without having a default contructor, a single-String-arg constructor; or explicit @JsonCreator");
         }

         int var3 = 0;
         Object[] var9 = null;

         int var4;
         Object var8;
         Object var16;
         for(var8 = null; var1.e() != hm.c; var8 = var16) {
            String var10 = var1.g();
            kt var11 = this.h.a(var10);
            var1.b();
            Object[] var14;
            Object var15;
            if(var11 != null) {
               Object[] var17;
               if(var8 != null) {
                  var11.a(var1, var2, var8);
                  var17 = var9;
                  var15 = var8;
                  var14 = var17;
               } else {
                  var17 = var9;
                  if(var9 == null) {
                     var4 = this.h.b();
                     var17 = new Object[var4 + var4];
                  }

                  var4 = var3 + 1;
                  var17[var3] = var11;
                  var3 = var4 + 1;
                  var17[var4] = var11.a(var1, var2);
                  var15 = var8;
                  var14 = var17;
               }
            } else {
               label100: {
                  if("message".equals(var10) && var6) {
                     var16 = this.d.a(var1.k());
                     var8 = var16;
                     if(var9 != null) {
                        for(var4 = 0; var4 < var3; var4 += 2) {
                           ((kt)var9[var4]).a(var16, var9[var4 + 1]);
                        }

                        var15 = var16;
                        var14 = null;
                        break label100;
                     }
                  } else {
                     if(this.k != null && this.k.contains(var10)) {
                        var1.d();
                        var16 = var8;
                        var14 = var9;
                        var15 = var16;
                        break label100;
                     }

                     if(this.j != null) {
                        this.j.a(var1, var2, var8, var10);
                        var16 = var8;
                        var14 = var9;
                        var15 = var16;
                        break label100;
                     }

                     this.a(var1, var2, var8, var10);
                  }

                  var16 = var8;
                  var14 = var9;
                  var15 = var16;
               }
            }

            var1.b();
            var16 = var15;
            var9 = var14;
         }

         var12 = var8;
         if(var8 == null) {
            Object var13;
            if(var6) {
               var13 = this.d.a((String)null);
            } else {
               var13 = this.d.m();
            }

            var12 = var13;
            if(var9 != null) {
               var4 = var5;

               while(true) {
                  var12 = var13;
                  if(var4 >= var3) {
                     break;
                  }

                  ((kt)var9[var4]).a(var13, var9[var4 + 1]);
                  var4 += 2;
               }
            }
         }
      }

      return var12;
   }
}
