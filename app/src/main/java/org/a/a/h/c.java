package org.a.a.h;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class c implements org.a.a.h.a {
   private static final Map a;
   private final org.a.a.l.b b;
   private org.a.a.d.f c;
   private List d;
   private Map e;
   private final org.a.a.n.a f;
   private final org.a.a.n.a g;
   private org.a.a.h.y h;

   static {
      HashMap var0 = new HashMap();
      a = var0;
      var0.put("!", "!");
      a.put("!!", "tag:yaml.org,2002:");
   }

   public c(org.a.a.i.b var1) {
      this.b = new org.a.a.l.d(var1);
      this.c = null;
      this.d = null;
      this.e = new HashMap();
      this.f = new org.a.a.n.a(100);
      this.g = new org.a.a.n.a(10);
      this.h = new org.a.a.h.x(this, (byte)0);
   }

   // $FF: synthetic method
   static Map a(org.a.a.h.c var0, Map var1) {
      var0.e = var1;
      return var1;
   }

   // $FF: synthetic method
   static org.a.a.d.f a(org.a.a.h.c var0, org.a.a.c.a var1) {
      return new org.a.a.d.l((String)null, (String)null, new org.a.a.d.h(true, false), "", var1, var1, Character.valueOf('\u0000'));
   }

   // $FF: synthetic method
   static org.a.a.d.f a(org.a.a.h.c var0, boolean var1, boolean var2) {
      return var0.a(true, false);
   }

   private org.a.a.d.f a(boolean var1, boolean var2) {
      org.a.a.c.a var4 = null;
      org.a.a.c.a var5 = null;
      if(this.b.a(new org.a.a.m.v[]{org.a.a.m.v.a})) {
         org.a.a.m.a var26 = (org.a.a.m.a)this.b.b();
         org.a.a.d.a var27 = new org.a.a.d.a(var26.a(), var26.f(), var26.g());
         this.h = (org.a.a.h.y)this.f.a();
         return var27;
      } else {
         String var6;
         org.a.a.c.a var8;
         org.a.a.c.a var9;
         org.a.a.m.t var15;
         if(this.b.a(new org.a.a.m.v[]{org.a.a.m.v.b})) {
            org.a.a.m.b var11 = (org.a.a.m.b)this.b.b();
            var9 = var11.f();
            var4 = var11.g();
            var6 = var11.a();
            if(this.b.a(new org.a.a.m.v[]{org.a.a.m.v.s})) {
               org.a.a.m.s var7 = (org.a.a.m.s)this.b.b();
               var5 = var7.f();
               var4 = var7.g();
               var15 = var7.a();
            } else {
               var15 = null;
               var5 = null;
            }

            var8 = var5;
            var5 = var4;
            var4 = var9;
         } else if(this.b.a(new org.a.a.m.v[]{org.a.a.m.v.s})) {
            org.a.a.m.s var14 = (org.a.a.m.s)this.b.b();
            var4 = var14.f();
            var9 = var14.g();
            org.a.a.m.t var16 = var14.a();
            if(this.b.a(new org.a.a.m.v[]{org.a.a.m.v.b})) {
               org.a.a.m.b var12 = (org.a.a.m.b)this.b.b();
               var9 = var12.g();
               var6 = var12.a();
               var8 = var4;
               var15 = var16;
               var5 = var9;
            } else {
               var15 = var16;
               var6 = null;
               var8 = var4;
               var4 = var4;
               var5 = var9;
            }
         } else {
            var15 = null;
            var6 = null;
            var8 = null;
         }

         String var24 = null;
         if(var15 != null) {
            String var10 = var15.a();
            String var20 = var15.b();
            var24 = var20;
            if(var10 != null) {
               if(!this.e.containsKey(var10)) {
                  throw new b("while parsing a node", var4, "found undefined tag handle " + var10, var8);
               }

               var24 = (String)this.e.get(var10) + var20;
            }
         }

         org.a.a.c.a var22 = var4;
         if(var4 == null) {
            var5 = this.b.a().f();
            var22 = var5;
         }

         boolean var3;
         if(var24 != null && !var24.equals("!")) {
            var3 = false;
         } else {
            var3 = true;
         }

         org.a.a.d.n var25;
         if(var2 && this.b.a(new org.a.a.m.v[]{org.a.a.m.v.d})) {
            var25 = new org.a.a.d.n(var6, var24, var3, var22, this.b.a().g(), Boolean.FALSE);
            this.h = new org.a.a.h.w(this, (byte)0);
            return var25;
         } else {
            org.a.a.d.l var17;
            if(!this.b.a(new org.a.a.m.v[]{org.a.a.m.v.p})) {
               if(this.b.a(new org.a.a.m.v[]{org.a.a.m.v.n})) {
                  var25 = new org.a.a.d.n(var6, var24, var3, var22, this.b.a().g(), Boolean.TRUE);
                  this.h = new org.a.a.h.u(this, (byte)0);
                  return var25;
               } else {
                  org.a.a.d.j var23;
                  if(this.b.a(new org.a.a.m.v[]{org.a.a.m.v.l})) {
                     var23 = new org.a.a.d.j(var6, var24, var3, var22, this.b.a().g(), Boolean.TRUE);
                     this.h = new org.a.a.h.n(this, (byte)0);
                     return var23;
                  } else if(var1 && this.b.a(new org.a.a.m.v[]{org.a.a.m.v.f})) {
                     var25 = new org.a.a.d.n(var6, var24, var3, var22, this.b.a().f(), Boolean.FALSE);
                     this.h = new org.a.a.h.i(this, (byte)0);
                     return var25;
                  } else if(var1 && this.b.a(new org.a.a.m.v[]{org.a.a.m.v.e})) {
                     var23 = new org.a.a.d.j(var6, var24, var3, var22, this.b.a().f(), Boolean.FALSE);
                     this.h = new org.a.a.h.d(this, (byte)0);
                     return var23;
                  } else if(var6 == null && var24 == null) {
                     String var19;
                     if(var1) {
                        var19 = "block";
                     } else {
                        var19 = "flow";
                     }

                     org.a.a.m.u var21 = this.b.a();
                     throw new b("while parsing a " + var19 + " node", var22, "expected the node content, but found " + var21.c(), var21.f());
                  } else {
                     var17 = new org.a.a.d.l(var6, var24, new org.a.a.d.h(var3, false), "", var22, var5, Character.valueOf('\u0000'));
                     this.h = (org.a.a.h.y)this.f.a();
                     return var17;
                  }
               }
            } else {
               org.a.a.m.p var18 = (org.a.a.m.p)this.b.b();
               var8 = var18.g();
               org.a.a.d.h var13;
               if((!var18.a() || var24 != null) && !"!".equals(var24)) {
                  if(var24 == null) {
                     var13 = new org.a.a.d.h(false, true);
                  } else {
                     var13 = new org.a.a.d.h(false, false);
                  }
               } else {
                  var13 = new org.a.a.d.h(true, false);
               }

               var17 = new org.a.a.d.l(var6, var24, var13, var18.d(), var22, var8, Character.valueOf(var18.e()));
               this.h = (org.a.a.h.y)this.f.a();
               return var17;
            }
         }
      }
   }

   // $FF: synthetic method
   static org.a.a.h.y a(org.a.a.h.c var0, org.a.a.h.y var1) {
      var0.h = var1;
      return var1;
   }

   // $FF: synthetic method
   static org.a.a.l.b a(org.a.a.h.c var0) {
      return var0.b;
   }

   // $FF: synthetic method
   static org.a.a.n.a b(org.a.a.h.c var0) {
      return var0.f;
   }

   // $FF: synthetic method
   static List c(org.a.a.h.c var0) {
      var0.d = null;
      var0.e = new HashMap();

      String var6;
      while(var0.b.a(new org.a.a.m.v[]{org.a.a.m.v.g})) {
         org.a.a.m.g var1 = (org.a.a.m.g)var0.b.b();
         if(var1.a().equals("YAML")) {
            if(var0.d != null) {
               throw new b((String)null, (org.a.a.c.a)null, "found duplicate YAML directive", var1.f());
            }

            if(((Integer)var1.d().get(0)).intValue() != 1) {
               throw new b((String)null, (org.a.a.c.a)null, "found incompatible YAML document (version 1.* is required)", var1.f());
            }

            var0.d = var1.d();
         } else if(var1.a().equals("TAG")) {
            List var3 = var1.d();
            String var2 = (String)var3.get(0);
            var6 = (String)var3.get(1);
            if(var0.e.containsKey(var2)) {
               throw new b((String)null, (org.a.a.c.a)null, "duplicate tag handle " + var2, var1.f());
            }

            var0.e.put(var2, var6);
         }
      }

      ArrayList var4 = new ArrayList(2);
      var4.add(var0.d);
      if(!var0.e.isEmpty()) {
         var4.add(new HashMap(var0.e));
      } else {
         var4.add(new HashMap());
      }

      Iterator var5 = a.keySet().iterator();

      while(var5.hasNext()) {
         var6 = (String)var5.next();
         if(!var0.e.containsKey(var6)) {
            var0.e.put(var6, a.get(var6));
         }
      }

      return var4;
   }

   // $FF: synthetic method
   static Map c() {
      return a;
   }

   // $FF: synthetic method
   static org.a.a.n.a d(org.a.a.h.c var0) {
      return var0.g;
   }

   // $FF: synthetic method
   static org.a.a.d.f e(org.a.a.h.c var0) {
      return var0.a(true, true);
   }

   // $FF: synthetic method
   static org.a.a.d.f f(org.a.a.h.c var0) {
      return var0.a(false, false);
   }

   public final org.a.a.d.f a() {
      if(this.c == null && this.h != null) {
         this.c = this.h.a();
      }

      return this.c;
   }

   public final boolean a(org.a.a.d.g var1) {
      this.a();
      return this.c != null && this.c.a(var1);
   }

   public final org.a.a.d.f b() {
      this.a();
      org.a.a.d.f var1 = this.c;
      this.c = null;
      return var1;
   }
}
