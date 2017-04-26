package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.List;

public final class cL {
   private final List a;
   private final Object b;

   private cL(Object var1) {
      this.b = com.google.android.gms.internal.cM.a(var1);
      this.a = new ArrayList();
   }

   // $FF: synthetic method
   cL(Object var1, byte var2) {
      this(var1);
   }

   public final com.google.android.gms.internal.cL a(String var1, Object var2) {
      this.a.add((String)com.google.android.gms.internal.cM.a((Object)var1) + "=" + var2);
      return this;
   }

   public final String toString() {
      StringBuilder var3 = (new StringBuilder(100)).append(this.b.getClass().getSimpleName()).append('{');
      int var2 = this.a.size();

      for(int var1 = 0; var1 < var2; ++var1) {
         var3.append((String)this.a.get(var1));
         if(var1 < var2 - 1) {
            var3.append(", ");
         }
      }

      return var3.append('}').toString();
   }
}
