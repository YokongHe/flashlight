package com.tapjoy.internal;

import com.tapjoy.internal.do;
import com.tapjoy.internal.dq$a;
import java.util.Collection;
import java.util.Iterator;

public abstract class de$a implements dq$a {
   private static void a(Iterable var0) {
      Iterator var1 = var0.iterator();

      do {
         if(!var1.hasNext()) {
            return;
         }
      } while(var1.next() != null);

      throw new NullPointerException();
   }

   public static void a(Iterable var0, Collection var1) {
      if(var0 instanceof do) {
         a(((do)var0).a());
         var1.addAll((Collection)var0);
      } else {
         if(var0 instanceof Collection) {
            a(var0);
            var1.addAll((Collection)var0);
            return;
         }

         Iterator var3 = var0.iterator();

         while(var3.hasNext()) {
            Object var2 = var3.next();
            if(var2 == null) {
               throw new NullPointerException();
            }

            var1.add(var2);
         }
      }

   }

   public abstract de$a a();

   // $FF: synthetic method
   public Object clone() {
      return this.a();
   }
}
