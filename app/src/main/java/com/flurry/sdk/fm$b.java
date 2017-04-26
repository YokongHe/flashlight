package com.flurry.sdk;

import com.flurry.sdk.fm;
import com.flurry.sdk.fm$a;
import com.flurry.sdk.fn;
import com.flurry.sdk.hf;
import java.util.List;
import java.util.Map;

class fm$b extends fm$a {
   // $FF: synthetic field
   final fm b;
   private fn c;
   private fn d;

   private fm$b(fm var1, String var2, String var3, Map var4, fn var5, fn var6, fn var7) {
      super(var1, var2, var3, var4, var5, null);
      this.b = var1;
      this.c = var6;
      this.d = var7;
   }

   // $FF: synthetic method
   fm$b(fm var1, String var2, String var3, Map var4, fn var5, fn var6, fn var7, Object var8) {
      this(var1, var2, var3, var4, var5, var6, var7);
   }

   void b(hf var1) {
      var1.a("response");
      this.c.a(fm.a(this.b), var1);
      List var2 = this.d.k();
      if(var2.size() > 1) {
         fn var3 = fn.b(var2.subList(1, var2.size()));
         var1.a("errors");
         var3.a(fm.a(this.b), var1);
      }

   }

   public boolean equals(Object var1) {
      if(super.equals(var1) && var1 instanceof fm$b) {
         fm$b var2 = (fm$b)var1;
         if(this.c.equals(var2.c) && this.d.equals(var2.d)) {
            return true;
         }
      }

      return false;
   }

   public int hashCode() {
      return super.hashCode() + this.c.hashCode() + this.d.hashCode();
   }
}
