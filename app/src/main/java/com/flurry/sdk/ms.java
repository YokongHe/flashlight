package com.flurry.sdk;

import com.flurry.sdk.mr;
import com.flurry.sdk.mz;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;

public final class ms implements Iterable {
   protected LinkedHashMap a;

   public final mr a(String var1, Class[] var2) {
      return this.a == null?null:(mr)this.a.get(new mz(var1, var2));
   }

   public final mr a(Method var1) {
      return this.a != null?(mr)this.a.remove(new mz(var1)):null;
   }

   public final void a(mr var1) {
      if(this.a == null) {
         this.a = new LinkedHashMap();
      }

      this.a.put(new mz(var1.e()), var1);
   }

   public final boolean a() {
      return this.a == null || this.a.size() == 0;
   }

   public final mr b(Method var1) {
      return this.a == null?null:(mr)this.a.get(new mz(var1));
   }

   public final Iterator iterator() {
      return this.a != null?this.a.values().iterator():Collections.emptyList().iterator();
   }
}
