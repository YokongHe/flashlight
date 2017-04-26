package com.inneractive.api.ads.sdk;

import com.inneractive.api.ads.sdk.IAreflectionHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

final class IAreflectionHandler$a {
   private final Object a;
   private final String b;
   private Class c;
   private List d;
   private List e;
   private boolean f;

   IAreflectionHandler$a(Object var1, String var2) {
      this.a = var1;
      this.b = var2;
      this.d = new ArrayList();
      this.e = new ArrayList();
      Class var3;
      if(var1 != null) {
         var3 = var1.getClass();
      } else {
         var3 = null;
      }

      this.c = var3;
   }

   final IAreflectionHandler$a a(Class var1) {
      this.f = true;
      this.c = var1;
      return this;
   }

   final IAreflectionHandler$a a(Class var1, Object var2) {
      this.d.add(var1);
      this.e.add(var2);
      return this;
   }

   final Object a() {
      Class[] var1 = new Class[this.d.size()];
      var1 = (Class[])this.d.toArray(var1);
      Method var3 = IAreflectionHandler.a(this.c, this.b, var1);
      Object[] var2 = this.e.toArray();
      return this.f?var3.invoke((Object)null, var2):var3.invoke(this.a, var2);
   }
}
