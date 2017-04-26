package com.flurry.sdk;

import com.flurry.sdk.qr;
import com.flurry.sdk.qs;
import com.flurry.sdk.qu$a;
import com.flurry.sdk.sh;
import java.util.ArrayList;
import java.util.List;

public class qu {
   final qs a;

   public qu(qs var1) {
      this.a = var1;
   }

   protected sh a(qu$a var1) {
      if(!var1.hasMoreTokens()) {
         throw this.a(var1, "Unexpected end-of-string");
      } else {
         Class var2 = this.a(var1.nextToken(), var1);
         if(var1.hasMoreTokens()) {
            String var3 = var1.nextToken();
            if("<".equals(var3)) {
               return this.a.a(var2, this.b(var1));
            }

            var1.a(var3);
         }

         return this.a.a((Class)var2, (qr)null);
      }
   }

   public sh a(String var1) {
      qu$a var3 = new qu$a(var1.trim());
      sh var2 = this.a(var3);
      if(var3.hasMoreTokens()) {
         throw this.a(var3, "Unexpected tokens after complete type");
      } else {
         return var2;
      }
   }

   protected Class a(String var1, qu$a var2) {
      try {
         Class var3 = Class.forName(var1, true, Thread.currentThread().getContextClassLoader());
         return var3;
      } catch (Exception var4) {
         if(var4 instanceof RuntimeException) {
            throw (RuntimeException)var4;
         } else {
            throw this.a(var2, "Can not locate class \'" + var1 + "\', problem: " + var4.getMessage());
         }
      }
   }

   protected IllegalArgumentException a(qu$a var1, String var2) {
      return new IllegalArgumentException("Failed to parse type \'" + var1.a() + "\' (remaining: \'" + var1.b() + "\'): " + var2);
   }

   protected List b(qu$a var1) {
      ArrayList var2 = new ArrayList();

      while(var1.hasMoreTokens()) {
         var2.add(this.a(var1));
         if(!var1.hasMoreTokens()) {
            break;
         }

         String var3 = var1.nextToken();
         if(">".equals(var3)) {
            return var2;
         }

         if(!",".equals(var3)) {
            throw this.a(var1, "Unexpected token \'" + var3 + "\', expected \',\' or \'>\')");
         }
      }

      throw this.a(var1, "Unexpected end-of-string");
   }
}
