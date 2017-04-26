package com.tapjoy.internal;

import com.tapjoy.internal.fs;
import com.tapjoy.internal.fv;
import java.util.Map;

public abstract class gr extends com.tapjoy.internal.cf {
   protected Object a(com.tapjoy.internal.bt var1) {
      var1.t();
      return null;
   }

   public final String d() {
      return "application/json";
   }

   public Map e() {
      Map var1 = super.e();
      fv var2 = fv.a();
      var1.put("sdk_ver", var2.d() + "/Android");
      var1.put("api_key", var2.c());
      if(fs.a) {
         var1.put("debug", Boolean.valueOf(true));
      }

      return var1;
   }

   protected Object f() {
      try {
         Object var1 = super.f();
         return var1;
      } catch (Exception var2) {
         throw var2;
      }
   }
}
