package com.flurry.sdk;

import com.flurry.sdk.gz;
import java.lang.ref.WeakReference;

class gz$a extends WeakReference {
   int a;
   // $FF: synthetic field
   final gz b;

   gz$a(gz var1, Object var2) {
      super(var2, gz.a(var1));
      this.b = var1;
      this.a = System.identityHashCode(var2);
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         gz$a var2 = (gz$a)var1;
         if(this.get() != var2.get()) {
            return false;
         }
      }

      return true;
   }

   public int hashCode() {
      return this.a;
   }
}
