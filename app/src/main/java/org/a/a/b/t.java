package org.a.a.b;

import java.util.ArrayList;
import java.util.Iterator;

public final class t extends org.a.a.b.a {
   // $FF: synthetic field
   final k a;

   public t(k var1) {
      this.a = var1;
   }

   public final Object a(org.a.a.g.d var1) {
      if(!(var1 instanceof org.a.a.g.h)) {
         throw new j("while constructing pairs", var1.f(), "expected a sequence, but found " + var1.a(), var1.f());
      } else {
         org.a.a.g.h var3 = (org.a.a.g.h)var1;
         ArrayList var2 = new ArrayList(var3.b().size());
         Iterator var6 = var3.b().iterator();

         while(var6.hasNext()) {
            org.a.a.g.d var4 = (org.a.a.g.d)var6.next();
            if(!(var4 instanceof org.a.a.g.c)) {
               throw new j("while constructingpairs", var1.f(), "expected a mapping of length 1, but found " + var4.a(), var4.f());
            }

            org.a.a.g.c var5 = (org.a.a.g.c)var4;
            if(var5.b().size() != 1) {
               throw new j("while constructing pairs", var1.f(), "expected a single mapping item, but found " + var5.b().size() + " items", var5.f());
            }

            var4 = ((org.a.a.g.f)var5.b().get(0)).a();
            org.a.a.g.d var7 = ((org.a.a.g.f)var5.b().get(0)).b();
            var2.add(new Object[]{this.a.a(var4), this.a.a(var7)});
         }

         return var2;
      }
   }
}
