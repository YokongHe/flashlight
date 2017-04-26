package com.flurry.sdk;

import com.flurry.org.codehaus.jackson.annotate.JsonTypeInfo$As;
import com.flurry.sdk.hj;
import com.flurry.sdk.hm;
import com.flurry.sdk.is;
import com.flurry.sdk.iz;
import com.flurry.sdk.nh;
import com.flurry.sdk.nv;
import com.flurry.sdk.nw;
import com.flurry.sdk.sh;

public class nj extends nv {
   public nj(sh var1, nh var2, is var3, Class var4) {
      super(var1, var2, var3, var4);
   }

   private final Object f(hj var1, iz var2) {
      boolean var3 = var1.j();
      Object var4 = this.a(var2, this.e(var1, var2)).a(var1, var2);
      if(var3 && var1.b() != hm.e) {
         throw var2.a(var1, hm.e, "expected closing END_ARRAY after type information and deserialized value");
      } else {
         return var4;
      }
   }

   public JsonTypeInfo$As a() {
      return JsonTypeInfo$As.WRAPPER_ARRAY;
   }

   public Object a(hj var1, iz var2) {
      return this.f(var1, var2);
   }

   public Object b(hj var1, iz var2) {
      return this.f(var1, var2);
   }

   public Object c(hj var1, iz var2) {
      return this.f(var1, var2);
   }

   public Object d(hj var1, iz var2) {
      return this.f(var1, var2);
   }

   protected final String e(hj var1, iz var2) {
      if(!var1.j()) {
         if(this.b instanceof nw && this.e != null) {
            return ((nw)this.b).a();
         } else {
            throw var2.a(var1, hm.d, "need JSON Array to contain As.WRAPPER_ARRAY type information for class " + this.c());
         }
      } else if(var1.b() != hm.h) {
         if(this.b instanceof nw && this.e != null) {
            return ((nw)this.b).a();
         } else {
            throw var2.a(var1, hm.h, "need JSON String that contains type id (for subtype of " + this.c() + ")");
         }
      } else {
         String var3 = var1.k();
         var1.b();
         return var3;
      }
   }
}
