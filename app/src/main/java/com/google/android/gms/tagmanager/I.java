package com.google.android.gms.tagmanager;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

final class I {
   private static final com.google.android.gms.tagmanager.x a = new com.google.android.gms.tagmanager.x(com.google.android.gms.tagmanager.P.a(), true);
   private final com.google.android.gms.tagmanager.j b;
   private final Map c;
   private final Map d;
   private final Map e;
   private final com.google.android.gms.tagmanager.S f;
   private final com.google.android.gms.tagmanager.S g;
   private final Set h;
   private final com.google.android.gms.tagmanager.b i;
   private final Map j;
   private volatile String k;
   private int l;

   private com.google.android.gms.tagmanager.x a(com.google.android.gms.internal.bj var1, Set var2, com.google.android.gms.tagmanager.Q var3) {
      if(!var1.l) {
         return new com.google.android.gms.tagmanager.x(var1, true);
      } else {
         int var4;
         com.google.android.gms.internal.bj var5;
         com.google.android.gms.tagmanager.x var6;
         switch(var1.a) {
         case 2:
            var5 = com.google.android.gms.tagmanager.E.a(var1);
            var5.c = new com.google.android.gms.internal.bj[var1.c.length];

            for(var4 = 0; var4 < var1.c.length; ++var4) {
               var6 = this.a(var1.c[var4], var2, var3.a());
               if(var6 == a) {
                  return a;
               }

               var5.c[var4] = (com.google.android.gms.internal.bj)var6.a();
            }

            return new com.google.android.gms.tagmanager.x(var5, false);
         case 3:
            var5 = com.google.android.gms.tagmanager.E.a(var1);
            if(var1.d.length != var1.e.length) {
               com.google.android.gms.tagmanager.n.a("Invalid serving value: " + var1.toString());
               return a;
            } else {
               var5.d = new com.google.android.gms.internal.bj[var1.d.length];
               var5.e = new com.google.android.gms.internal.bj[var1.d.length];

               for(var4 = 0; var4 < var1.d.length; ++var4) {
                  var6 = this.a(var1.d[var4], var2, var3.b());
                  com.google.android.gms.tagmanager.x var7 = this.a(var1.e[var4], var2, var3.c());
                  if(var6 == a || var7 == a) {
                     return a;
                  }

                  var5.d[var4] = (com.google.android.gms.internal.bj)var6.a();
                  var5.e[var4] = (com.google.android.gms.internal.bj)var7.a();
               }

               return new com.google.android.gms.tagmanager.x(var5, false);
            }
         case 4:
            if(var2.contains(var1.f)) {
               com.google.android.gms.tagmanager.n.a("Macro cycle detected.  Current macro reference: " + var1.f + ".  Previous macro references: " + var2.toString() + ".");
               return a;
            }

            var2.add(var1.f);
            com.google.android.gms.tagmanager.x var8 = com.google.android.gms.tagmanager.R.a(this.a(var1.f, var2, var3.e()), var1.k);
            var2.remove(var1.f);
            return var8;
         case 5:
         case 6:
         default:
            com.google.android.gms.tagmanager.n.a("Unknown type: " + var1.a);
            return a;
         case 7:
            var5 = com.google.android.gms.tagmanager.E.a(var1);
            var5.j = new com.google.android.gms.internal.bj[var1.j.length];

            for(var4 = 0; var4 < var1.j.length; ++var4) {
               var6 = this.a(var1.j[var4], var2, var3.d());
               if(var6 == a) {
                  return a;
               }

               var5.j[var4] = (com.google.android.gms.internal.bj)var6.a();
            }

            return new com.google.android.gms.tagmanager.x(var5, false);
         }
      }
   }

   private com.google.android.gms.tagmanager.x a(com.google.android.gms.tagmanager.F var1, Set var2, com.google.android.gms.tagmanager.A var3) {
      com.google.android.gms.tagmanager.x var4 = this.a(this.d, var1, var2, var3);
      Boolean var5 = com.google.android.gms.tagmanager.P.b((com.google.android.gms.internal.bj)var4.a());
      com.google.android.gms.tagmanager.P.a((Object)var5);
      return new com.google.android.gms.tagmanager.x(var5, var4.b());
   }

   private com.google.android.gms.tagmanager.x a(com.google.android.gms.tagmanager.G var1, Set var2, com.google.android.gms.tagmanager.D var3) {
      Iterator var5 = var1.b().iterator();
      boolean var4 = true;

      while(var5.hasNext()) {
         com.google.android.gms.tagmanager.x var6 = this.a((com.google.android.gms.tagmanager.F)var5.next(), var2, var3.a());
         if(((Boolean)var6.a()).booleanValue()) {
            com.google.android.gms.tagmanager.P.a((Object)Boolean.valueOf(false));
            return new com.google.android.gms.tagmanager.x(Boolean.valueOf(false), var6.b());
         }

         if(var4 && var6.b()) {
            var4 = true;
         } else {
            var4 = false;
         }
      }

      Iterator var7 = var1.a().iterator();

      while(true) {
         while(var7.hasNext()) {
            com.google.android.gms.tagmanager.x var8 = this.a((com.google.android.gms.tagmanager.F)var7.next(), var2, var3.b());
            if(!((Boolean)var8.a()).booleanValue()) {
               com.google.android.gms.tagmanager.P.a((Object)Boolean.valueOf(false));
               return new com.google.android.gms.tagmanager.x(Boolean.valueOf(false), var8.b());
            }

            if(var4 && var8.b()) {
               var4 = true;
            } else {
               var4 = false;
            }
         }

         com.google.android.gms.tagmanager.P.a((Object)Boolean.valueOf(true));
         return new com.google.android.gms.tagmanager.x(Boolean.valueOf(true), var4);
      }
   }

   private com.google.android.gms.tagmanager.x a(String var1, Set var2, com.google.android.gms.tagmanager.p var3) {
      ++this.l;
      com.google.android.gms.tagmanager.K var5 = (com.google.android.gms.tagmanager.K)this.g.a();
      if(var5 != null && !this.b.b()) {
         this.a(var5.b(), var2);
         --this.l;
         return var5.a();
      } else {
         com.google.android.gms.tagmanager.L var6 = (com.google.android.gms.tagmanager.L)this.j.get(var1);
         if(var6 == null) {
            com.google.android.gms.tagmanager.n.a(this.a() + "Invalid macro: " + var1);
            --this.l;
            return a;
         } else {
            com.google.android.gms.tagmanager.x var10 = this.a(var6.a(), var6.b(), var6.c(), var6.e(), var6.d(), var2, var3.b());
            com.google.android.gms.tagmanager.F var7;
            if(((Set)var10.a()).isEmpty()) {
               var7 = var6.f();
            } else {
               if(((Set)var10.a()).size() > 1) {
                  com.google.android.gms.tagmanager.n.b(this.a() + "Multiple macros active for macroName " + var1);
               }

               var7 = (com.google.android.gms.tagmanager.F)((Set)var10.a()).iterator().next();
            }

            if(var7 == null) {
               --this.l;
               return a;
            } else {
               com.google.android.gms.tagmanager.x var9 = this.a(this.e, var7, var2, var3.a());
               boolean var4;
               if(var10.b() && var9.b()) {
                  var4 = true;
               } else {
                  var4 = false;
               }

               if(var9 == a) {
                  var9 = a;
               } else {
                  var9 = new com.google.android.gms.tagmanager.x(var9.a(), var4);
               }

               com.google.android.gms.internal.bj var8 = var7.b();
               if(var9.b()) {
                  com.google.android.gms.tagmanager.S var11 = this.g;
                  new com.google.android.gms.tagmanager.K(var9, var8);
               }

               this.a(var8, var2);
               --this.l;
               return var9;
            }
         }
      }
   }

   private com.google.android.gms.tagmanager.x a(Map var1, com.google.android.gms.tagmanager.F var2, Set var3, com.google.android.gms.tagmanager.A var4) {
      boolean var6 = true;
      com.google.android.gms.internal.bj var7 = (com.google.android.gms.internal.bj)var2.a().get(com.google.android.gms.internal.G.aC.toString());
      com.google.android.gms.tagmanager.x var13;
      if(var7 == null) {
         com.google.android.gms.tagmanager.n.a("No function id in properties");
         var13 = a;
      } else {
         String var16 = var7.g;
         com.google.android.gms.tagmanager.k var8 = (com.google.android.gms.tagmanager.k)var1.get(var16);
         if(var8 == null) {
            com.google.android.gms.tagmanager.n.a(var16 + " has no backing implementation.");
            return a;
         }

         var13 = (com.google.android.gms.tagmanager.x)this.f.a();
         if(var13 == null || this.b.b()) {
            HashMap var14 = new HashMap();
            Iterator var9 = var2.a().entrySet().iterator();

            boolean var5;
            Entry var10;
            com.google.android.gms.tagmanager.x var17;
            for(var5 = true; var9.hasNext(); var14.put(var10.getKey(), var17.a())) {
               var10 = (Entry)var9.next();
               var10.getKey();
               com.google.android.gms.tagmanager.C var11 = var4.a();
               com.google.android.gms.internal.bj var12 = (com.google.android.gms.internal.bj)var10.getValue();
               var10.getValue();
               var17 = this.a(var12, var3, var11.a());
               if(var17 == a) {
                  return a;
               }

               if(var17.b()) {
                  var2.a((String)var10.getKey(), (com.google.android.gms.internal.bj)var17.a());
               } else {
                  var5 = false;
               }
            }

            if(!var8.a(var14.keySet())) {
               com.google.android.gms.tagmanager.n.a("Incorrect keys for function " + var16 + " required " + var8.c() + " had " + var14.keySet());
               return a;
            }

            if(!var5 || !var8.a()) {
               var6 = false;
            }

            var13 = new com.google.android.gms.tagmanager.x(var8.b(), var6);
            if(var6) {
               com.google.android.gms.tagmanager.S var15 = this.f;
            }

            var13.a();
            return var13;
         }
      }

      return var13;
   }

   private com.google.android.gms.tagmanager.x a(Set var1, final Map var2, final Map var3, final Map var4, final Map var5, Set var6, com.google.android.gms.tagmanager.H var7) {
      return this.a(var1, var6, new com.google.android.gms.tagmanager.J() {
         public final void a(com.google.android.gms.tagmanager.G var1, Set var2x, Set var3x, com.google.android.gms.tagmanager.D var4x) {
            List var5x = (List)var2.get(var1);
            var3.get(var1);
            if(var5x != null) {
               var2x.addAll(var5x);
               var4x.c();
            }

            List var6 = (List)var4.get(var1);
            var5.get(var1);
            if(var6 != null) {
               var3x.addAll(var6);
               var4x.d();
            }

         }
      }, var7);
   }

   private com.google.android.gms.tagmanager.x a(Set var1, Set var2, com.google.android.gms.tagmanager.J var3, com.google.android.gms.tagmanager.H var4) {
      HashSet var6 = new HashSet();
      HashSet var7 = new HashSet();
      Iterator var11 = var1.iterator();
      boolean var5 = true;

      while(true) {
         while(var11.hasNext()) {
            com.google.android.gms.tagmanager.G var8 = (com.google.android.gms.tagmanager.G)var11.next();
            com.google.android.gms.tagmanager.D var9 = var4.a();
            com.google.android.gms.tagmanager.x var10 = this.a(var8, var2, var9);
            if(((Boolean)var10.a()).booleanValue()) {
               var3.a(var8, var6, var7, var9);
            }

            if(var5 && var10.b()) {
               var5 = true;
            } else {
               var5 = false;
            }
         }

         var6.removeAll(var7);
         return new com.google.android.gms.tagmanager.x(var6, var5);
      }
   }

   private String a() {
      if(this.l <= 1) {
         return "";
      } else {
         StringBuilder var2 = new StringBuilder();
         var2.append(Integer.toString(this.l));

         for(int var1 = 2; var1 < this.l; ++var1) {
            var2.append(' ');
         }

         var2.append(": ");
         return var2.toString();
      }
   }

   private void a(com.google.android.gms.internal.bj var1, Set var2) {
      if(var1 != null) {
         com.google.android.gms.tagmanager.x var3 = this.a((com.google.android.gms.internal.bj)var1, var2, (com.google.android.gms.tagmanager.Q)(new com.google.android.gms.tagmanager.w()));
         if(var3 != a) {
            Object var4 = com.google.android.gms.tagmanager.P.c((com.google.android.gms.internal.bj)var3.a());
            if(var4 instanceof Map) {
               Map var6 = (Map)var4;
               this.i.a(var6);
               return;
            }

            if(!(var4 instanceof List)) {
               com.google.android.gms.tagmanager.n.b("pushAfterEvaluate: value not a Map or List");
               return;
            }

            Iterator var5 = ((List)var4).iterator();

            while(var5.hasNext()) {
               Object var7 = var5.next();
               if(var7 instanceof Map) {
                  Map var8 = (Map)var7;
                  this.i.a(var8);
               } else {
                  com.google.android.gms.tagmanager.n.b("pushAfterEvaluate: value not a Map");
               }
            }
         }
      }

   }

   private void b(String var1) {
      synchronized(this){}

      try {
         this.k = var1;
      } finally {
         ;
      }

   }

   public final void a(String param1) {
      // $FF: Couldn't be decompiled
   }
}
