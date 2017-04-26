package org.a.a.b;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public class k extends org.a.a.b.b {
   public static final org.a.a.b.l e = new org.a.a.b.l();
   private static final Map f;
   private static final Pattern g;
   private static final Pattern h;

   static {
      HashMap var0 = new HashMap();
      f = var0;
      var0.put("yes", Boolean.TRUE);
      f.put("no", Boolean.FALSE);
      f.put("true", Boolean.TRUE);
      f.put("false", Boolean.FALSE);
      f.put("on", Boolean.TRUE);
      f.put("off", Boolean.FALSE);
      g = Pattern.compile("^([0-9][0-9][0-9][0-9])-([0-9][0-9]?)-([0-9][0-9]?)(?:(?:[Tt]|[ \t]+)([0-9][0-9]?):([0-9][0-9]):([0-9][0-9])(?:\\.([0-9]*))?(?:[ \t]*(?:Z|([-+][0-9][0-9]?)(?::([0-9][0-9])?)?))?)?$");
      h = Pattern.compile("^([0-9][0-9][0-9][0-9])-([0-9][0-9]?)-([0-9][0-9]?)$");
   }

   public k() {
      this.b.put(org.a.a.g.i.l, new org.a.a.b.r(this));
      this.b.put(org.a.a.g.i.k, new org.a.a.b.n(this));
      this.b.put(org.a.a.g.i.h, new org.a.a.b.p(this));
      this.b.put(org.a.a.g.i.i, new org.a.a.b.o(this));
      this.b.put(org.a.a.g.i.g, new org.a.a.b.m(this));
      this.b.put(org.a.a.g.i.j, new org.a.a.b.x());
      this.b.put(org.a.a.g.i.f, new org.a.a.b.s(this));
      this.b.put(org.a.a.g.i.e, new org.a.a.b.t(this));
      this.b.put(org.a.a.g.i.d, new org.a.a.b.v(this));
      this.b.put(org.a.a.g.i.m, new org.a.a.b.w(this));
      this.b.put(org.a.a.g.i.n, new org.a.a.b.u(this));
      this.b.put(org.a.a.g.i.o, new org.a.a.b.q(this));
      this.b.put((Object)null, e);
      this.a.put(org.a.a.g.e.a, e);
      this.a.put(org.a.a.g.e.b, e);
      this.a.put(org.a.a.g.e.c, e);
   }

   private static Number a(int var0, String var1, int var2) {
      String var3 = var1;
      if(var0 < 0) {
         var3 = "-" + var1;
      }

      try {
         Integer var7 = Integer.valueOf(var3, var2);
         return var7;
      } catch (NumberFormatException var5) {
         try {
            Long var6 = Long.valueOf(var3, var2);
            return var6;
         } catch (NumberFormatException var4) {
            return new BigInteger(var3, var2);
         }
      }
   }

   // $FF: synthetic method
   static Number a(org.a.a.b.k var0, int var1, String var2, int var3) {
      return a(var1, var2, var3);
   }

   private List a(org.a.a.g.c var1, boolean var2, Map var3, List var4) {
      List var5 = var1.b();
      Collections.reverse(var5);
      Iterator var9 = var5.iterator();

      while(true) {
         label29:
         while(var9.hasNext()) {
            org.a.a.g.f var6 = (org.a.a.g.f)var9.next();
            org.a.a.g.d var7 = var6.a();
            org.a.a.g.d var8 = var6.b();
            if(var7.d().equals(org.a.a.g.i.c)) {
               var9.remove();
               switch(null.a[var8.a().ordinal()]) {
               case 1:
                  this.a((org.a.a.g.c)var8, false, var3, var4);
                  break;
               case 2:
                  Iterator var10 = ((org.a.a.g.h)var8).b().iterator();

                  while(true) {
                     if(!var10.hasNext()) {
                        continue label29;
                     }

                     var7 = (org.a.a.g.d)var10.next();
                     if(!(var7 instanceof org.a.a.g.c)) {
                        throw new j("while constructing a mapping", var1.f(), "expected a mapping for merging, but found " + var7.a(), var7.f());
                     }

                     this.a((org.a.a.g.c)var7, false, var3, var4);
                  }
               default:
                  throw new j("while constructing a mapping", var1.f(), "expected a mapping or list of mappings for merging, but found " + var8.a(), var8.f());
               }
            } else {
               Object var11 = this.a(var7);
               if(!var3.containsKey(var11)) {
                  var4.add(var6);
                  var3.put(var11, Integer.valueOf(var4.size() - 1));
               } else if(var2) {
                  var4.set(((Integer)var3.get(var11)).intValue(), var6);
               }
            }
         }

         return var4;
      }
   }

   // $FF: synthetic method
   static Map c() {
      return f;
   }

   // $FF: synthetic method
   static Pattern d() {
      return h;
   }

   // $FF: synthetic method
   static Pattern e() {
      return g;
   }

   protected final void a(org.a.a.g.c var1, Map var2) {
      this.c(var1);
      super.a(var1, var2);
   }

   protected final void a(org.a.a.g.c var1, Set var2) {
      this.c(var1);
      super.a(var1, var2);
   }

   protected final void c(org.a.a.g.c var1) {
      if(var1.c()) {
         var1.a(this.a(var1, true, new HashMap(), new ArrayList()));
      }

   }
}
