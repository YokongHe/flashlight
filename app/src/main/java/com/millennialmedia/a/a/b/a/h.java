package com.millennialmedia.a.a.b.a;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

final class h extends com.millennialmedia.a.a.s {
   // $FF: synthetic field
   final g a;
   private final com.millennialmedia.a.a.s b;
   private final com.millennialmedia.a.a.s c;
   private final com.millennialmedia.a.a.b.q d;

   public h(g var1, com.millennialmedia.a.a.e var2, Type var3, com.millennialmedia.a.a.s var4, Type var5, com.millennialmedia.a.a.s var6, com.millennialmedia.a.a.b.q var7) {
      this.a = var1;
      this.b = new com.millennialmedia.a.a.b.a.o(var2, var4, var3);
      this.c = new com.millennialmedia.a.a.b.a.o(var2, var6, var5);
      this.d = var7;
   }

   // $FF: synthetic method
   public final Object a(com.millennialmedia.a.a.d.a var1) {
      com.millennialmedia.a.a.d.b var3 = var1.f();
      if(var3 == com.millennialmedia.a.a.d.b.i) {
         var1.j();
         return null;
      } else {
         Map var2 = (Map)this.d.a();
         Object var4;
         if(var3 == com.millennialmedia.a.a.d.b.a) {
            var1.a();

            while(var1.e()) {
               var1.a();
               var4 = this.b.a(var1);
               if(var2.put(var4, this.c.a(var1)) != null) {
                  throw new com.millennialmedia.a.a.q("duplicate key: " + var4);
               }

               var1.b();
            }

            var1.b();
            return var2;
         } else {
            var1.c();

            do {
               if(!var1.e()) {
                  var1.d();
                  return var2;
               }

               com.millennialmedia.a.a.b.h.a.a(var1);
               var4 = this.b.a(var1);
            } while(var2.put(var4, this.c.a(var1)) == null);

            throw new com.millennialmedia.a.a.q("duplicate key: " + var4);
         }
      }
   }

   // $FF: synthetic method
   public final void a(com.millennialmedia.a.a.d.c var1, Object var2) {
      byte var6 = 0;
      byte var5 = 0;
      Map var11 = (Map)var2;
      if(var11 == null) {
         var1.f();
      } else {
         Iterator var12;
         if(!g.a(this.a)) {
            var1.d();
            var12 = var11.entrySet().iterator();

            while(var12.hasNext()) {
               Entry var17 = (Entry)var12.next();
               var1.a(String.valueOf(var17.getKey()));
               this.c.a(var1, var17.getValue());
            }

            var1.e();
         } else {
            ArrayList var7 = new ArrayList(var11.size());
            ArrayList var8 = new ArrayList(var11.size());
            var12 = var11.entrySet().iterator();

            boolean var3;
            boolean var4;
            for(var3 = false; var12.hasNext(); var3 |= var4) {
               Entry var9 = (Entry)var12.next();
               com.millennialmedia.a.a.j var10 = this.b.a(var9.getKey());
               var7.add(var10);
               var8.add(var9.getValue());
               if(!var10.g() && !var10.h()) {
                  var4 = false;
               } else {
                  var4 = true;
               }
            }

            int var15;
            if(!var3) {
               var1.d();

               for(var15 = var6; var15 < var7.size(); ++var15) {
                  com.millennialmedia.a.a.j var13 = (com.millennialmedia.a.a.j)var7.get(var15);
                  String var16;
                  if(var13.i()) {
                     com.millennialmedia.a.a.o var14 = var13.m();
                     if(var14.o()) {
                        var16 = String.valueOf(var14.a());
                     } else if(var14.n()) {
                        var16 = Boolean.toString(var14.f());
                     } else {
                        if(!var14.p()) {
                           throw new AssertionError();
                        }

                        var16 = var14.b();
                     }
                  } else {
                     if(!var13.j()) {
                        throw new AssertionError();
                     }

                     var16 = "null";
                  }

                  var1.a(var16);
                  this.c.a(var1, var8.get(var15));
               }

               var1.e();
            } else {
               var1.b();

               for(var15 = var5; var15 < var7.size(); ++var15) {
                  var1.b();
                  com.millennialmedia.a.a.b.s.a((com.millennialmedia.a.a.j)var7.get(var15), var1);
                  this.c.a(var1, var8.get(var15));
                  var1.c();
               }

               var1.c();
            }
         }
      }
   }
}
