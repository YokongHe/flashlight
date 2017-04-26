package com.flurry.sdk;

import com.flurry.sdk.hg;
import com.flurry.sdk.hj;
import com.flurry.sdk.hk;
import com.flurry.sdk.jh$a;
import java.util.Iterator;
import java.util.LinkedList;

public class jh extends hk {
   protected LinkedList b;

   public jh(String var1) {
      super(var1);
   }

   public jh(String var1, hg var2) {
      super(var1, var2);
   }

   public jh(String var1, hg var2, Throwable var3) {
      super(var1, var2, var3);
   }

   public jh(String var1, Throwable var2) {
      super(var1, var2);
   }

   public static jh a(hj var0, String var1) {
      return new jh(var1, var0.h());
   }

   public static jh a(hj var0, String var1, Throwable var2) {
      return new jh(var1, var0.h(), var2);
   }

   public static jh a(Throwable var0, jh$a var1) {
      jh var4;
      if(var0 instanceof jh) {
         var4 = (jh)var0;
      } else {
         String var2;
         label14: {
            String var3 = var0.getMessage();
            if(var3 != null) {
               var2 = var3;
               if(var3.length() != 0) {
                  break label14;
               }
            }

            var2 = "(was " + var0.getClass().getName() + ")";
         }

         var4 = new jh(var2, (hg)null, var0);
      }

      var4.a(var1);
      return var4;
   }

   public static jh a(Throwable var0, Object var1, int var2) {
      return a(var0, new jh$a(var1, var2));
   }

   public static jh a(Throwable var0, Object var1, String var2) {
      return a(var0, new jh$a(var1, var2));
   }

   public void a(jh$a var1) {
      if(this.b == null) {
         this.b = new LinkedList();
      }

      if(this.b.size() < 1000) {
         this.b.addFirst(var1);
      }

   }

   public void a(Object var1, String var2) {
      this.a(new jh$a(var1, var2));
   }

   protected void a(StringBuilder var1) {
      Iterator var2 = this.b.iterator();

      while(var2.hasNext()) {
         var1.append(((jh$a)var2.next()).toString());
         if(var2.hasNext()) {
            var1.append("->");
         }
      }

   }

   public String getMessage() {
      String var1 = super.getMessage();
      if(this.b == null) {
         return var1;
      } else {
         StringBuilder var2;
         if(var1 == null) {
            var2 = new StringBuilder();
         } else {
            var2 = new StringBuilder(var1);
         }

         var2.append(" (through reference chain: ");
         this.a(var2);
         var2.append(')');
         return var2.toString();
      }
   }

   public String toString() {
      return this.getClass().getName() + ": " + this.getMessage();
   }
}
