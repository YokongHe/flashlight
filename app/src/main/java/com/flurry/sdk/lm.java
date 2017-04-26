package com.flurry.sdk;

import com.flurry.sdk.hj;
import com.flurry.sdk.hm;
import com.flurry.sdk.iz;
import com.flurry.sdk.kb;
import com.flurry.sdk.mc;

@kb
public class lm extends mc {
   public lm() {
      super(Class.class);
   }

   // $FF: synthetic method
   public Object a(hj var1, iz var2) {
      return this.b(var1, var2);
   }

   public Class b(hj var1, iz var2) {
      hm var3 = var1.e();
      if(var3 == hm.h) {
         String var6 = var1.k();
         if(var6.indexOf(46) < 0) {
            if("int".equals(var6)) {
               return Integer.TYPE;
            }

            if("long".equals(var6)) {
               return Long.TYPE;
            }

            if("float".equals(var6)) {
               return Float.TYPE;
            }

            if("double".equals(var6)) {
               return Double.TYPE;
            }

            if("boolean".equals(var6)) {
               return Boolean.TYPE;
            }

            if("byte".equals(var6)) {
               return Byte.TYPE;
            }

            if("char".equals(var6)) {
               return Character.TYPE;
            }

            if("short".equals(var6)) {
               return Short.TYPE;
            }

            if("void".equals(var6)) {
               return Void.TYPE;
            }
         }

         try {
            Class var5 = Class.forName(var1.k());
            return var5;
         } catch (ClassNotFoundException var4) {
            throw var2.a((Class)this.q, (Throwable)var4);
         }
      } else {
         throw var2.a(this.q, var3);
      }
   }
}
