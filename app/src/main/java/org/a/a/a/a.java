package org.a.a.a;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class a {
   private final org.a.a.h.a a;
   private final org.a.a.k.a b;
   private final Map c;
   private final Set d;

   public a(org.a.a.h.a var1, org.a.a.k.a var2) {
      this.a = var1;
      this.b = var2;
      this.c = new HashMap();
      this.d = new HashSet();
   }

   private org.a.a.g.d a(String var1) {
      org.a.a.d.n var4 = (org.a.a.d.n)this.a.b();
      String var3 = var4.a();
      boolean var2 = false;
      org.a.a.g.i var6;
      if(var3 != null && !var3.equals("!")) {
         var6 = new org.a.a.g.i(var3);
      } else {
         var6 = this.b.a(org.a.a.g.e.b, (String)null, var4.b());
         var2 = true;
      }

      ArrayList var5 = new ArrayList();
      org.a.a.g.h var7 = new org.a.a.g.h(var6, var2, var5, var4.e(), (org.a.a.c.a)null, var4.c());
      if(var1 != null) {
         this.c.put(var1, var7);
      }

      while(!this.a.a(org.a.a.d.g.g)) {
         var5.add(this.a((org.a.a.g.d)var7));
      }

      var7.a(this.a.b().f());
      return var7;
   }

   private org.a.a.g.d a(org.a.a.g.d var1) {
      this.d.add(var1);
      String var7;
      if(this.a.a(org.a.a.d.g.a)) {
         org.a.a.d.a var6 = (org.a.a.d.a)this.a.b();
         var7 = var6.g();
         if(!this.c.containsKey(var7)) {
            throw new org.a.a.a.b((String)null, (org.a.a.c.a)null, "found undefined alias " + var7, var6.e());
         } else {
            var1 = (org.a.a.g.d)this.c.get(var7);
            if(this.d.remove(var1)) {
               var1.b(true);
            }

            return var1;
         }
      } else {
         org.a.a.d.k var3 = (org.a.a.d.k)this.a.a();
         String var5 = var3.g();
         if(var5 != null && this.c.containsKey(var5)) {
            throw new org.a.a.a.b("found duplicate anchor " + var5 + "; first occurence", ((org.a.a.g.d)this.c.get(var5)).f(), "second occurence", var3.e());
         } else {
            Object var10;
            if(this.a.a(org.a.a.d.g.f)) {
               org.a.a.d.l var4 = (org.a.a.d.l)this.a.b();
               var7 = var4.a();
               boolean var2 = false;
               org.a.a.g.i var8;
               if(var7 != null && !var7.equals("!")) {
                  var8 = new org.a.a.g.i(var7);
               } else {
                  var8 = this.b.a(org.a.a.g.e.a, var4.c(), var4.h().a());
                  var2 = true;
               }

               org.a.a.g.g var9 = new org.a.a.g.g(var8, var2, var4.c(), var4.e(), var4.f(), var4.b());
               var10 = var9;
               if(var5 != null) {
                  this.c.put(var5, var9);
                  var10 = var9;
               }
            } else if(this.a.a(org.a.a.d.g.h)) {
               var10 = this.a(var5);
            } else {
               var10 = this.b(var5);
            }

            this.d.remove(var1);
            return (org.a.a.g.d)var10;
         }
      }
   }

   private org.a.a.g.d b(String var1) {
      org.a.a.d.j var4 = (org.a.a.d.j)this.a.b();
      String var3 = var4.a();
      boolean var2 = false;
      org.a.a.g.i var7;
      if(var3 != null && !var3.equals("!")) {
         var7 = new org.a.a.g.i(var3);
      } else {
         var7 = this.b.a(org.a.a.g.e.c, (String)null, var4.b());
         var2 = true;
      }

      ArrayList var5 = new ArrayList();
      org.a.a.g.c var8 = new org.a.a.g.c(var7, var2, var5, var4.e(), (org.a.a.c.a)null, var4.c());
      if(var1 != null) {
         this.c.put(var1, var8);
      }

      org.a.a.g.d var6;
      for(; !this.a.a(org.a.a.d.g.d); var5.add(new org.a.a.g.f(var6, this.a((org.a.a.g.d)var8)))) {
         var6 = this.a((org.a.a.g.d)var8);
         if(var6.d().equals(org.a.a.g.i.c)) {
            var8.a(true);
         } else if(var6.d().equals(org.a.a.g.i.b)) {
            var6.a(org.a.a.g.i.m);
         }
      }

      var8.a((org.a.a.c.a)this.a.b().f());
      return var8;
   }

   public final org.a.a.g.d a() {
      org.a.a.g.d var1 = null;
      this.a.b();
      if(!this.a.a(org.a.a.d.g.i)) {
         this.a.b();
         var1 = this.a((org.a.a.g.d)null);
         this.a.b();
         this.c.clear();
         this.d.clear();
      }

      if(!this.a.a(org.a.a.d.g.i)) {
         org.a.a.d.f var2 = this.a.b();
         throw new org.a.a.a.b("expected a single document in the stream", var1.f(), "but found another document", var2.e());
      } else {
         this.a.b();
         return var1;
      }
   }
}
