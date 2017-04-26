package com.flurry.sdk;

import com.flurry.sdk.hj;
import com.flurry.sdk.hm;
import com.flurry.sdk.iz;
import com.flurry.sdk.jh;
import com.flurry.sdk.mc;

public class lz$n extends mc {
   public lz$n() {
      super(StackTraceElement.class);
   }

   // $FF: synthetic method
   public Object a(hj var1, iz var2) {
      return this.b(var1, var2);
   }

   public StackTraceElement b(hj var1, iz var2) {
      hm var4 = var1.e();
      if(var4 == hm.b) {
         String var9 = "";
         String var5 = "";
         String var6 = "";
         int var3 = -1;

         while(true) {
            hm var7 = var1.c();
            if(var7 == hm.c) {
               return new StackTraceElement(var9, var5, var6, var3);
            }

            String var8 = var1.g();
            if("className".equals(var8)) {
               var9 = var1.k();
            } else if("fileName".equals(var8)) {
               var6 = var1.k();
            } else if("lineNumber".equals(var8)) {
               if(!var7.c()) {
                  throw jh.a(var1, "Non-numeric token (" + var7 + ") for property \'lineNumber\'");
               }

               var3 = var1.t();
            } else if("methodName".equals(var8)) {
               var5 = var1.k();
            } else if(!"nativeMethod".equals(var8)) {
               this.a(var1, var2, this.q, var8);
            }
         }
      } else {
         throw var2.a(this.q, var4);
      }
   }
}
