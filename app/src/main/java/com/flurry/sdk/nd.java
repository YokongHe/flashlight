package com.flurry.sdk;

import com.flurry.sdk.it;
import com.flurry.sdk.mo;
import com.flurry.sdk.mp;
import com.flurry.sdk.mq;
import com.flurry.sdk.mr;
import com.flurry.sdk.mt;
import com.flurry.sdk.mv;
import com.flurry.sdk.nd$a;

public class nd extends it implements Comparable {
   protected final String a;
   protected final String b;
   protected nd$a c;
   protected nd$a d;
   protected nd$a e;
   protected nd$a f;

   public nd(nd var1, String var2) {
      this.b = var1.b;
      this.a = var2;
      this.c = var1.c;
      this.d = var1.d;
      this.e = var1.e;
      this.f = var1.f;
   }

   public nd(String var1) {
      this.b = var1;
      this.a = var1;
   }

   private mv a(int var1, nd$a... var2) {
      mv var3 = ((mq)var2[var1].a).j();
      ++var1;

      while(var1 < var2.length) {
         if(var2[var1] != null) {
            return mv.a(var3, this.a(var1, var2));
         }

         ++var1;
      }

      return var3;
   }

   private nd$a a(nd$a var1) {
      return var1 == null?var1:var1.a();
   }

   private static nd$a a(nd$a var0, nd$a var1) {
      return var0 == null?var1:(var1 == null?var0:nd$a.a(var0, var1));
   }

   private nd$a b(nd$a var1) {
      return var1 == null?var1:var1.b();
   }

   private nd$a b(nd$a var1, nd$a var2) {
      while(var1 != null) {
         String var4 = var1.c;
         nd$a var3 = var2;
         if(var4 != null) {
            var3 = var2;
            if(!var4.equals(this.a)) {
               if(var2 == null) {
                  var3 = var1;
               } else {
                  var3 = var2;
                  if(!var4.equals(var2.c)) {
                     throw new IllegalStateException("Conflicting property name definitions: \'" + var2.c + "\' (for " + var2.a + ") vs \'" + var1.c + "\' (for " + var1.a + ")");
                  }
               }
            }
         }

         var1 = var1.b;
         var2 = var3;
      }

      return var2;
   }

   private nd$a c(nd$a var1) {
      return var1 == null?var1:var1.c();
   }

   private boolean d(nd$a var1) {
      while(var1 != null) {
         if(var1.c != null && var1.c.length() > 0) {
            return true;
         }

         var1 = var1.b;
      }

      return false;
   }

   private boolean e(nd$a var1) {
      while(var1 != null) {
         if(var1.d) {
            return true;
         }

         var1 = var1.b;
      }

      return false;
   }

   private boolean f(nd$a var1) {
      while(var1 != null) {
         if(var1.e) {
            return true;
         }

         var1 = var1.b;
      }

      return false;
   }

   public int a(nd var1) {
      if(this.d != null) {
         if(var1.d == null) {
            return -1;
         }
      } else if(var1.d != null) {
         return 1;
      }

      return this.a().compareTo(var1.a());
   }

   public nd a(String var1) {
      return new nd(this, var1);
   }

   public String a() {
      return this.a;
   }

   public void a(mp var1, String var2, boolean var3, boolean var4) {
      this.c = new nd$a(var1, this.c, var2, var3, var4);
   }

   public void a(mr var1, String var2, boolean var3, boolean var4) {
      this.e = new nd$a(var1, this.e, var2, var3, var4);
   }

   public void a(mt var1, String var2, boolean var3, boolean var4) {
      this.d = new nd$a(var1, this.d, var2, var3, var4);
   }

   public void a(boolean var1) {
      mv var2;
      if(var1) {
         if(this.e != null) {
            var2 = this.a(0, new nd$a[]{this.e, this.c, this.d, this.f});
            this.e = this.e.a((Object)((mr)this.e.a).a(var2));
         } else if(this.c != null) {
            var2 = this.a(0, new nd$a[]{this.c, this.d, this.f});
            this.c = this.c.a((Object)((mp)this.c.a).a(var2));
            return;
         }
      } else {
         if(this.d != null) {
            var2 = this.a(0, new nd$a[]{this.d, this.f, this.c, this.e});
            this.d = this.d.a((Object)((mt)this.d.a).a(var2));
            return;
         }

         if(this.f != null) {
            var2 = this.a(0, new nd$a[]{this.f, this.c, this.e});
            this.f = this.f.a((Object)((mr)this.f.a).a(var2));
            return;
         }

         if(this.c != null) {
            var2 = this.a(0, new nd$a[]{this.c, this.e});
            this.c = this.c.a((Object)((mp)this.c.a).a(var2));
            return;
         }
      }

   }

   public void b(mr var1, String var2, boolean var3, boolean var4) {
      this.f = new nd$a(var1, this.f, var2, var3, var4);
   }

   public void b(nd var1) {
      this.c = a(this.c, var1.c);
      this.d = a(this.d, var1.d);
      this.e = a(this.e, var1.e);
      this.f = a(this.f, var1.f);
   }

   public boolean b() {
      return this.e != null;
   }

   public boolean c() {
      return this.f != null;
   }

   // $FF: synthetic method
   public int compareTo(Object var1) {
      return this.a((nd)var1);
   }

   public boolean d() {
      return this.c != null;
   }

   public boolean e() {
      return this.d != null;
   }

   public mr g() {
      mr var3;
      if(this.e == null) {
         var3 = null;
         return var3;
      } else {
         mr var1 = (mr)this.e.a;
         nd$a var2 = this.e.b;

         while(true) {
            var3 = var1;
            if(var2 == null) {
               return var3;
            }

            var3 = (mr)var2.a;
            Class var4 = var1.h();
            Class var5 = var3.h();
            if(var4 == var5) {
               break;
            }

            if(var4.isAssignableFrom(var5)) {
               var1 = var3;
            } else if(!var5.isAssignableFrom(var4)) {
               break;
            }

            var2 = var2.b;
         }

         throw new IllegalArgumentException("Conflicting getter definitions for property \"" + this.a() + "\": " + var1.n() + " vs " + var3.n());
      }
   }

   public mr h() {
      mr var3;
      if(this.f == null) {
         var3 = null;
         return var3;
      } else {
         mr var1 = (mr)this.f.a;
         nd$a var2 = this.f.b;

         while(true) {
            var3 = var1;
            if(var2 == null) {
               return var3;
            }

            var3 = (mr)var2.a;
            Class var4 = var1.h();
            Class var5 = var3.h();
            if(var4 == var5) {
               break;
            }

            if(var4.isAssignableFrom(var5)) {
               var1 = var3;
            } else if(!var5.isAssignableFrom(var4)) {
               break;
            }

            var2 = var2.b;
         }

         throw new IllegalArgumentException("Conflicting setter definitions for property \"" + this.a() + "\": " + var1.n() + " vs " + var3.n());
      }
   }

   public mp i() {
      mp var3;
      if(this.c == null) {
         var3 = null;
         return var3;
      } else {
         mp var1 = (mp)this.c.a;
         nd$a var2 = this.c.b;

         while(true) {
            var3 = var1;
            if(var2 == null) {
               return var3;
            }

            var3 = (mp)var2.a;
            Class var4 = var1.h();
            Class var5 = var3.h();
            if(var4 == var5) {
               break;
            }

            if(var4.isAssignableFrom(var5)) {
               var1 = var3;
            } else if(!var5.isAssignableFrom(var4)) {
               break;
            }

            var2 = var2.b;
         }

         throw new IllegalArgumentException("Multiple fields representing property \"" + this.a() + "\": " + var1.f() + " vs " + var3.f());
      }
   }

   public mq j() {
      mr var2 = this.g();
      Object var1 = var2;
      if(var2 == null) {
         var1 = this.i();
      }

      return (mq)var1;
   }

   public mq k() {
      mt var2 = this.m();
      Object var1 = var2;
      if(var2 == null) {
         mr var3 = this.h();
         var1 = var3;
         if(var3 == null) {
            var1 = this.i();
         }
      }

      return (mq)var1;
   }

   public String l() {
      return this.b;
   }

   public mt m() {
      if(this.d == null) {
         return null;
      } else {
         nd$a var1 = this.d;

         while(!(((mt)var1.a).f() instanceof mo)) {
            var1 = var1.b;
            if(var1 == null) {
               return (mt)this.d.a;
            }
         }

         return (mt)var1.a;
      }
   }

   public void n() {
      this.c = this.a(this.c);
      this.e = this.a(this.e);
      this.f = this.a(this.f);
      this.d = this.a(this.d);
   }

   public void o() {
      this.e = this.b(this.e);
      this.d = this.b(this.d);
      if(this.e == null) {
         this.c = this.b(this.c);
         this.f = this.b(this.f);
      }

   }

   public void p() {
      this.c = this.c(this.c);
      this.e = this.c(this.e);
      this.f = this.c(this.f);
      this.d = this.c(this.d);
   }

   public boolean q() {
      return this.d(this.c) || this.d(this.e) || this.d(this.f) || this.d(this.d);
   }

   public boolean r() {
      return this.e(this.c) || this.e(this.e) || this.e(this.f) || this.e(this.d);
   }

   public boolean s() {
      return this.f(this.c) || this.f(this.e) || this.f(this.f) || this.f(this.d);
   }

   public boolean t() {
      return this.f(this.c) || this.f(this.f) || this.f(this.d);
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("[Property \'").append(this.a).append("\'; ctors: ").append(this.d).append(", field(s): ").append(this.c).append(", getter(s): ").append(this.e).append(", setter(s): ").append(this.f);
      var1.append("]");
      return var1.toString();
   }

   public String u() {
      nd$a var1 = this.b(this.c, (nd$a)null);
      var1 = this.b(this.e, var1);
      var1 = this.b(this.f, var1);
      var1 = this.b(this.d, var1);
      return var1 == null?null:var1.c;
   }
}
