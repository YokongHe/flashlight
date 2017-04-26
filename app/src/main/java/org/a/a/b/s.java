package org.a.a.b;

import java.util.Iterator;
import java.util.LinkedHashMap;

public final class s extends org.a.a.b.a {
   // $FF: synthetic field
   final k a;

   public s(k var1) {
      this.a = var1;
   }

   public final Object a(org.a.a.g.d var1) {
      LinkedHashMap var2 = new LinkedHashMap();
      if(!(var1 instanceof org.a.a.g.h)) {
         throw new j("while constructing an ordered map", var1.f(), "expected a sequence, but found " + var1.a(), var1.f());
      } else {
         Iterator var3 = ((org.a.a.g.h)var1).b().iterator();

         while(var3.hasNext()) {
            org.a.a.g.d var4 = (org.a.a.g.d)var3.next();
            if(!(var4 instanceof org.a.a.g.c)) {
               throw new j("while constructing an ordered map", var1.f(), "expected a mapping of length 1, but found " + var4.a(), var4.f());
            }

            org.a.a.g.c var5 = (org.a.a.g.c)var4;
            if(var5.b().size() != 1) {
               throw new j("while constructing an ordered map", var1.f(), "expected a single mapping item, but found " + var5.b().size() + " items", var5.f());
            }

            var4 = ((org.a.a.g.f)var5.b().get(0)).a();
            org.a.a.g.d var6 = ((org.a.a.g.f)var5.b().get(0)).b();
            var2.put(this.a.a(var4), this.a.a(var6));
         }

         return var2;
      }
   }
}
