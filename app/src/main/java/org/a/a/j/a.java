package org.a.a.j;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class a {
   protected final Map a = new HashMap();
   protected org.a.a.j.b b;
   protected final Map c = new LinkedHashMap();
   protected Character d;
   protected org.a.a.b e;
   protected final Map f;
   private org.a.a.f.e g;
   private boolean h;

   public a() {
      this.e = org.a.a.b.c;
      this.f = new IdentityHashMap() {
         // $FF: synthetic method
         public final Object put(Object var1, Object var2) {
            return (org.a.a.g.d)super.put(var1, new org.a.a.g.a((org.a.a.g.d)var2));
         }
      };
      this.h = false;
   }

   public final org.a.a.f.e a() {
      if(this.g == null) {
         this.g = new org.a.a.f.e();
      }

      return this.g;
   }

   public final void a(org.a.a.b var1) {
      this.e = var1;
   }

   public final void a(org.a.a.d var1) {
      this.d = var1.a();
   }

   public final void a(org.a.a.f.e var1) {
      this.g = var1;
      this.h = true;
   }

   public final boolean b() {
      return this.h;
   }
}
