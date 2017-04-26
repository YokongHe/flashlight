package com.flurry.sdk;

import com.flurry.sdk.iq;
import com.flurry.sdk.jn;
import com.flurry.sdk.jr;
import com.flurry.sdk.mn;
import com.flurry.sdk.mo;
import com.flurry.sdk.mp;
import com.flurry.sdk.mq;
import com.flurry.sdk.mr;
import com.flurry.sdk.mt;
import com.flurry.sdk.nd;
import com.flurry.sdk.ne;
import com.flurry.sdk.qx;
import com.flurry.sdk.sh;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

public class nc {
   protected final jn a;
   protected final boolean b;
   protected final sh c;
   protected final mn d;
   protected final ne e;
   protected final iq f;
   protected final LinkedHashMap g;
   protected LinkedList h;
   protected LinkedList i;
   protected LinkedList j;
   protected LinkedList k;
   protected Set l;
   protected Set m;
   protected LinkedHashMap n;

   protected nc(jn var1, boolean var2, sh var3, mn var4) {
      Object var5 = null;
      super();
      this.g = new LinkedHashMap();
      this.h = null;
      this.i = null;
      this.j = null;
      this.k = null;
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      iq var6 = (iq)var5;
      if(var1.b()) {
         var6 = this.a.a();
      }

      this.f = var6;
      if(this.f == null) {
         this.e = this.a.e();
      } else {
         this.e = this.f.a(var4, this.a.e());
      }
   }

   private Set a(Set var1, String var2) {
      Object var3 = var1;
      if(var1 == null) {
         var3 = new HashSet();
      }

      ((Set)var3).add(var2);
      return (Set)var3;
   }

   private void a(nd var1) {
      if(!this.b) {
         String var2 = var1.a();
         this.l = this.a(this.l, var2);
         if(var1.t()) {
            this.m = this.a(this.m, var2);
            return;
         }
      }

   }

   public jn a() {
      return this.a;
   }

   protected void a(jr var1) {
      nd[] var7 = (nd[])this.g.values().toArray(new nd[this.g.size()]);
      this.g.clear();
      int var3 = var7.length;

      for(int var2 = 0; var2 < var3; ++var2) {
         nd var6 = var7[var2];
         String var4 = var6.a();
         if(this.b) {
            if(var6.b()) {
               var4 = var1.a(this.a, var6.g(), var4);
            } else if(var6.d()) {
               var4 = var1.a(this.a, var6.i(), var4);
            }
         } else if(var6.c()) {
            var4 = var1.b(this.a, var6.h(), var4);
         } else if(var6.e()) {
            var4 = var1.a(this.a, var6.m(), var4);
         } else if(var6.d()) {
            var4 = var1.a(this.a, var6.i(), var4);
         } else if(var6.b()) {
            var4 = var1.a(this.a, var6.g(), var4);
         }

         nd var5 = var6;
         if(!var4.equals(var6.a())) {
            var5 = var6.a(var4);
         }

         var6 = (nd)this.g.get(var4);
         if(var6 == null) {
            this.g.put(var4, var5);
         } else {
            var6.b(var5);
         }
      }

   }

   protected void a(Object var1, mq var2) {
      if(var1 != null) {
         if(this.n == null) {
            this.n = new LinkedHashMap();
         }

         if((mq)this.n.put(var1, var2) != null) {
            String var3;
            if(var1 == null) {
               var3 = "[null]";
            } else {
               var3 = var1.getClass().getName();
            }

            throw new IllegalArgumentException("Duplicate injectable value with id \'" + String.valueOf(var1) + "\' (of type " + var3 + ")");
         }
      }

   }

   protected void a(String var1) {
      throw new IllegalArgumentException("Problem with definition of " + this.d + ": " + var1);
   }

   protected nd b(String var1) {
      nd var3 = (nd)this.g.get(var1);
      nd var2 = var3;
      if(var3 == null) {
         var2 = new nd(var1);
         this.g.put(var1, var2);
      }

      return var2;
   }

   public sh b() {
      return this.c;
   }

   public mn c() {
      return this.d;
   }

   public List d() {
      return new ArrayList(this.g.values());
   }

   public Map e() {
      return this.n;
   }

   public mr f() {
      if(this.k != null) {
         if(this.k.size() > 1) {
            this.a("Multiple value properties defined (" + this.k.get(0) + " vs " + this.k.get(1) + ")");
         }

         return (mr)this.k.get(0);
      } else {
         return null;
      }
   }

   public mr g() {
      if(this.i != null) {
         if(this.i.size() > 1) {
            this.a("Multiple \'any-getters\' defined (" + this.i.get(0) + " vs " + this.i.get(1) + ")");
         }

         return (mr)this.i.getFirst();
      } else {
         return null;
      }
   }

   public mr h() {
      if(this.j != null) {
         if(this.j.size() > 1) {
            this.a("Multiple \'any-setters\' defined (" + this.j.get(0) + " vs " + this.j.get(1) + ")");
         }

         return (mr)this.j.getFirst();
      } else {
         return null;
      }
   }

   public Set i() {
      return this.l;
   }

   public Set j() {
      return this.m;
   }

   public nc k() {
      this.g.clear();
      this.m();
      this.o();
      this.n();
      this.p();
      this.q();
      this.r();
      jr var1 = this.a.j();
      if(var1 != null) {
         this.a(var1);
      }

      Iterator var2 = this.g.values().iterator();

      while(var2.hasNext()) {
         ((nd)var2.next()).p();
      }

      var2 = this.g.values().iterator();

      while(var2.hasNext()) {
         ((nd)var2.next()).a(this.b);
      }

      this.l();
      return this;
   }

   protected void l() {
      iq var4 = this.a.a();
      Boolean var5 = var4.i(this.d);
      boolean var3;
      if(var5 == null) {
         var3 = this.a.d();
      } else {
         var3 = var5.booleanValue();
      }

      String[] var8 = var4.h(this.d);
      if(var3 || this.h != null || var8 != null) {
         int var1 = this.g.size();
         Object var11;
         if(var3) {
            var11 = new TreeMap();
         } else {
            var11 = new LinkedHashMap(var1 + var1);
         }

         Iterator var12 = this.g.values().iterator();

         nd var6;
         while(var12.hasNext()) {
            var6 = (nd)var12.next();
            ((Map)var11).put(var6.a(), var6);
         }

         LinkedHashMap var9 = new LinkedHashMap(var1 + var1);
         if(var8 != null) {
            int var2 = var8.length;

            for(var1 = 0; var1 < var2; ++var1) {
               nd var13;
               String var14;
               label61: {
                  String var7 = var8[var1];
                  var13 = (nd)((Map)var11).get(var7);
                  if(var13 == null) {
                     Iterator var10 = this.g.values().iterator();

                     while(var10.hasNext()) {
                        var6 = (nd)var10.next();
                        if(var7.equals(var6.l())) {
                           var7 = var6.a();
                           var13 = var6;
                           var14 = var7;
                           break label61;
                        }
                     }
                  }

                  var14 = var7;
               }

               if(var13 != null) {
                  var9.put(var14, var13);
               }
            }
         }

         if(this.h != null) {
            var12 = this.h.iterator();

            while(var12.hasNext()) {
               var6 = (nd)var12.next();
               var9.put(var6.a(), var6);
            }
         }

         var9.putAll((Map)var11);
         this.g.clear();
         this.g.putAll(var9);
      }
   }

   protected void m() {
      iq var5 = this.f;

      boolean var1;
      boolean var2;
      String var3;
      String var4;
      mp var7;
      for(Iterator var6 = this.d.l().iterator(); var6.hasNext(); this.b(var4).a(var7, var3, var1, var2)) {
         var7 = (mp)var6.next();
         var4 = var7.b();
         if(var5 == null) {
            var3 = null;
         } else if(this.b) {
            var3 = var5.b(var7);
         } else {
            var3 = var5.c(var7);
         }

         if("".equals(var3)) {
            var3 = var4;
         }

         if(var3 != null) {
            var1 = true;
         } else {
            var1 = false;
         }

         if(!var1) {
            var1 = this.e.a(var7);
         }

         if(var5 != null && var5.c((mq)var7)) {
            var2 = true;
         } else {
            var2 = false;
         }
      }

   }

   protected void n() {
      iq var3 = this.f;
      if(var3 != null) {
         Iterator var4 = this.d.i().iterator();

         int var1;
         int var2;
         mt var6;
         String var7;
         nd var8;
         while(var4.hasNext()) {
            mo var5 = (mo)var4.next();
            if(this.h == null) {
               this.h = new LinkedList();
            }

            var2 = var5.f();

            for(var1 = 0; var1 < var2; ++var1) {
               var6 = var5.c(var1);
               var7 = var3.a(var6);
               if(var7 != null) {
                  var8 = this.b(var7);
                  var8.a(var6, var7, true, false);
                  this.h.add(var8);
               }
            }
         }

         var4 = this.d.j().iterator();

         while(var4.hasNext()) {
            mr var9 = (mr)var4.next();
            if(this.h == null) {
               this.h = new LinkedList();
            }

            var2 = var9.f();

            for(var1 = 0; var1 < var2; ++var1) {
               var6 = var9.c(var1);
               var7 = var3.a(var6);
               if(var7 != null) {
                  var8 = this.b(var7);
                  var8.a(var6, var7, true, false);
                  this.h.add(var8);
               }
            }
         }
      }

   }

   protected void o() {
      iq var7 = this.f;
      Iterator var8 = this.d.k().iterator();

      while(true) {
         while(true) {
            while(var8.hasNext()) {
               mr var9 = (mr)var8.next();
               int var1 = var9.f();
               boolean var2;
               boolean var3;
               String var4;
               String var5;
               String var6;
               if(var1 == 0) {
                  if(var7 != null) {
                     if(var7.f(var9)) {
                        if(this.i == null) {
                           this.i = new LinkedList();
                        }

                        this.i.add(var9);
                        continue;
                     }

                     if(var7.c(var9)) {
                        if(this.k == null) {
                           this.k = new LinkedList();
                        }

                        this.k.add(var9);
                        continue;
                     }
                  }

                  if(var7 == null) {
                     var4 = null;
                  } else {
                     var4 = var7.b(var9);
                  }

                  if(var4 == null) {
                     var6 = qx.a(var9, var9.b());
                     if(var6 == null) {
                        var6 = qx.b(var9, var9.b());
                        if(var6 == null) {
                           continue;
                        }

                        var2 = this.e.b(var9);
                        var5 = var4;
                        var4 = var6;
                     } else {
                        var2 = this.e.a(var9);
                        var5 = var4;
                        var4 = var6;
                     }
                  } else {
                     var6 = qx.a(var9);
                     var5 = var6;
                     if(var6 == null) {
                        var5 = var9.b();
                     }

                     var6 = var4;
                     if(var4.length() == 0) {
                        var6 = var5;
                     }

                     var4 = var5;
                     var5 = var6;
                     var2 = true;
                  }

                  if(var7 == null) {
                     var3 = false;
                  } else {
                     var3 = var7.c((mq)var9);
                  }

                  this.b(var4).a(var9, var5, var2, var3);
               } else if(var1 == 1) {
                  if(var7 == null) {
                     var4 = null;
                  } else {
                     var4 = var7.d(var9);
                  }

                  if(var4 == null) {
                     var6 = qx.b(var9);
                     if(var6 == null) {
                        continue;
                     }

                     var2 = this.e.c(var9);
                     var5 = var4;
                     var4 = var6;
                  } else {
                     var6 = qx.b(var9);
                     var5 = var6;
                     if(var6 == null) {
                        var5 = var9.b();
                     }

                     var6 = var4;
                     if(var4.length() == 0) {
                        var6 = var5;
                     }

                     var4 = var5;
                     var5 = var6;
                     var2 = true;
                  }

                  if(var7 == null) {
                     var3 = false;
                  } else {
                     var3 = var7.c((mq)var9);
                  }

                  this.b(var4).b(var9, var5, var2, var3);
               } else if(var1 == 2 && var7 != null && var7.e(var9)) {
                  if(this.j == null) {
                     this.j = new LinkedList();
                  }

                  this.j.add(var9);
               }
            }

            return;
         }
      }
   }

   protected void p() {
      iq var1 = this.f;
      if(var1 != null) {
         Iterator var2 = this.d.l().iterator();

         while(var2.hasNext()) {
            mp var3 = (mp)var2.next();
            this.a((Object)var1.d((mq)var3), (mq)var3);
         }

         var2 = this.d.k().iterator();

         while(var2.hasNext()) {
            mr var4 = (mr)var2.next();
            if(var4.f() == 1) {
               this.a((Object)var1.d((mq)var4), (mq)var4);
            }
         }
      }

   }

   protected void q() {
      Iterator var1 = this.g.entrySet().iterator();

      while(true) {
         while(var1.hasNext()) {
            nd var2 = (nd)((Entry)var1.next()).getValue();
            if(!var2.r()) {
               var1.remove();
            } else {
               if(var2.s()) {
                  this.a(var2);
                  if(!var2.q()) {
                     var1.remove();
                     continue;
                  }

                  var2.n();
               }

               var2.o();
            }
         }

         return;
      }
   }

   protected void r() {
      Iterator var3 = this.g.entrySet().iterator();
      LinkedList var1 = null;

      nd var4;
      while(var3.hasNext()) {
         var4 = (nd)((Entry)var3.next()).getValue();
         String var5 = var4.u();
         if(var5 != null) {
            LinkedList var2 = var1;
            if(var1 == null) {
               var2 = new LinkedList();
            }

            var2.add(var4.a(var5));
            var3.remove();
            var1 = var2;
         }
      }

      if(var1 != null) {
         Iterator var6 = var1.iterator();

         while(var6.hasNext()) {
            nd var7 = (nd)var6.next();
            String var8 = var7.a();
            var4 = (nd)this.g.get(var8);
            if(var4 == null) {
               this.g.put(var8, var7);
            } else {
               var4.b(var7);
            }
         }
      }

   }
}
