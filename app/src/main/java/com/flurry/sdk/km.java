package com.flurry.sdk;

import com.flurry.sdk.hj;
import com.flurry.sdk.iz;
import com.flurry.sdk.jg;
import com.flurry.sdk.jy;
import com.flurry.sdk.sh;

public class km extends jg {
   protected final sh a;
   protected final boolean b;
   protected final boolean c;
   protected final boolean d;
   protected final boolean e;

   public km(sh var1) {
      boolean var3 = false;
      super();
      this.a = var1;
      Class var4 = var1.p();
      this.b = var4.isAssignableFrom(String.class);
      boolean var2;
      if(var4 != Boolean.TYPE && !var4.isAssignableFrom(Boolean.class)) {
         var2 = false;
      } else {
         var2 = true;
      }

      this.c = var2;
      if(var4 != Integer.TYPE && !var4.isAssignableFrom(Integer.class)) {
         var2 = false;
      } else {
         var2 = true;
      }

      label19: {
         this.d = var2;
         if(var4 != Double.TYPE) {
            var2 = var3;
            if(!var4.isAssignableFrom(Double.class)) {
               break label19;
            }
         }

         var2 = true;
      }

      this.e = var2;
   }

   public Object a(hj var1, iz var2) {
      throw var2.a(this.a.p(), "abstract types can only be instantiated with additional type information");
   }

   public Object a(hj var1, iz var2, jy var3) {
      Object var4 = this.b(var1, var2);
      return var4 != null?var4:var3.a(var1, var2);
   }

   protected Object b(hj var1, iz var2) {
      switch(null.a[var1.e().ordinal()]) {
      case 1:
         if(this.b) {
            return var1.k();
         }
         break;
      case 2:
         if(this.d) {
            return Integer.valueOf(var1.t());
         }
         break;
      case 3:
         if(this.e) {
            return Double.valueOf(var1.x());
         }
         break;
      case 4:
         if(this.c) {
            return Boolean.TRUE;
         }
         break;
      case 5:
         if(this.c) {
            return Boolean.FALSE;
         }
      }

      return null;
   }
}
