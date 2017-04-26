package com.flurry.sdk;

import com.flurry.org.codehaus.jackson.annotate.JsonTypeInfo$As;
import com.flurry.sdk.hj;
import com.flurry.sdk.hm;
import com.flurry.sdk.is;
import com.flurry.sdk.iz;
import com.flurry.sdk.jg;
import com.flurry.sdk.nh;
import com.flurry.sdk.nv;
import com.flurry.sdk.sh;

public class np extends nv {
   public np(sh var1, nh var2, is var3, Class var4) {
      super(var1, var2, var3, (Class)null);
   }

   private final Object e(hj var1, iz var2) {
      if(var1.e() != hm.b) {
         throw var2.a(var1, hm.b, "need JSON Object to contain As.WRAPPER_OBJECT type information for class " + this.c());
      } else if(var1.b() != hm.f) {
         throw var2.a(var1, hm.f, "need JSON String that contains type id (for subtype of " + this.c() + ")");
      } else {
         jg var3 = this.a(var2, var1.k());
         var1.b();
         Object var4 = var3.a(var1, var2);
         if(var1.b() != hm.c) {
            throw var2.a(var1, hm.c, "expected closing END_OBJECT after type information and deserialized value");
         } else {
            return var4;
         }
      }
   }

   public JsonTypeInfo$As a() {
      return JsonTypeInfo$As.WRAPPER_OBJECT;
   }

   public Object a(hj var1, iz var2) {
      return this.e(var1, var2);
   }

   public Object b(hj var1, iz var2) {
      return this.e(var1, var2);
   }

   public Object c(hj var1, iz var2) {
      return this.e(var1, var2);
   }

   public Object d(hj var1, iz var2) {
      return this.e(var1, var2);
   }
}
