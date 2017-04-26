package com.tapjoy.internal;

import com.tapjoy.internal.de$a;
import com.tapjoy.internal.dh;
import com.tapjoy.internal.dl$a;
import com.tapjoy.internal.dv;
import com.tapjoy.internal.gk$a;
import com.tapjoy.internal.gk$c;
import com.tapjoy.internal.gk$f;
import com.tapjoy.internal.gk$f$a;
import com.tapjoy.internal.gk$h;
import com.tapjoy.internal.gk$i;
import com.tapjoy.internal.gk$j;
import com.tapjoy.internal.gk$j$a;
import com.tapjoy.internal.gk$l;
import com.tapjoy.internal.gk$p;
import com.tapjoy.internal.gk$p$a;
import com.tapjoy.internal.gk$r;
import com.tapjoy.internal.gk$r$a;
import com.tapjoy.internal.gk$x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class gk$c$a extends dl$a implements gk$h {
   private int b;
   private gk$i c;
   private Object d;
   private long e;
   private long f;
   private Object g;
   private long h;
   private long i;
   private gk$l j;
   private gk$a k;
   private gk$x l;
   private int m;
   private int n;
   private gk$f o;
   private gk$r p;
   private Object q;
   private Object r;
   private gk$p s;
   private Object t;
   private Object u;
   private Object v;
   private List w;

   private gk$c$a() {
      this.c = gk$i.a;
      this.d = "";
      this.g = "";
      this.j = gk$l.c();
      this.k = gk$a.c();
      this.l = gk$x.c();
      this.o = gk$f.c();
      this.p = gk$r.c();
      this.q = "";
      this.r = "";
      this.s = gk$p.c();
      this.t = "";
      this.u = "";
      this.v = "";
      this.w = Collections.emptyList();
   }

   // $FF: synthetic method
   static gk$c$a k() {
      return new gk$c$a();
   }

   private gk$c$a l() {
      gk$c$a var2 = new gk$c$a();
      gk$c var3 = this.m();
      if(var3 == gk$c.c()) {
         return var2;
      } else {
         if(var3.e()) {
            var2.a(var3.f());
         }

         if(var3.g()) {
            var2.b |= 2;
            var2.d = gk$c.a(var3);
         }

         if(var3.i()) {
            var2.a(var3.j());
         }

         if(var3.k()) {
            var2.b(var3.l());
         }

         if(var3.m()) {
            var2.b |= 16;
            var2.g = gk$c.b(var3);
         }

         if(var3.o()) {
            var2.c(var3.p());
         }

         if(var3.q()) {
            var2.d(var3.r());
         }

         if(var3.s()) {
            gk$l var4 = var3.t();
            if((var2.b & 128) == 128 && var2.j != gk$l.c()) {
               var2.j = gk$l.a(var2.j).a(var4).e();
            } else {
               var2.j = var4;
            }

            var2.b |= 128;
         }

         if(var3.u()) {
            gk$a var5 = var3.v();
            if((var2.b & 256) == 256 && var2.k != gk$a.c()) {
               var2.k = gk$a.a(var2.k).a(var5).e();
            } else {
               var2.k = var5;
            }

            var2.b |= 256;
         }

         if(var3.w()) {
            gk$x var6 = var3.x();
            if((var2.b & 512) == 512 && var2.l != gk$x.c()) {
               var2.l = gk$x.a(var2.l).a(var6).e();
            } else {
               var2.l = var6;
            }

            var2.b |= 512;
         }

         if(var3.y()) {
            int var1 = var3.z();
            var2.b |= 1024;
            var2.m = var1;
         }

         if(var3.A()) {
            var2.a(var3.B());
         }

         if(var3.C()) {
            gk$f var7 = var3.D();
            if((var2.b & 4096) == 4096 && var2.o != gk$f.c()) {
               var2.o = gk$f.a(var2.o).a(var7).e();
            } else {
               var2.o = var7;
            }

            var2.b |= 4096;
         }

         if(var3.E()) {
            gk$r var8 = var3.F();
            if((var2.b & 8192) == 8192 && var2.p != gk$r.c()) {
               var2.p = gk$r.a(var2.p).a(var8).e();
            } else {
               var2.p = var8;
            }

            var2.b |= 8192;
         }

         if(var3.G()) {
            var2.b |= 16384;
            var2.q = gk$c.c(var3);
         }

         if(var3.I()) {
            var2.b |= '耀';
            var2.r = gk$c.d(var3);
         }

         if(var3.K()) {
            gk$p var9 = var3.L();
            if((var2.b & 65536) == 65536 && var2.s != gk$p.c()) {
               var2.s = gk$p.a(var2.s).a(var9).f();
            } else {
               var2.s = var9;
            }

            var2.b |= 65536;
         }

         if(var3.M()) {
            var2.b |= 131072;
            var2.t = gk$c.e(var3);
         }

         if(var3.O()) {
            var2.b |= 262144;
            var2.u = gk$c.f(var3);
         }

         if(var3.Q()) {
            var2.b |= 524288;
            var2.v = gk$c.g(var3);
         }

         if(!gk$c.h(var3).isEmpty()) {
            if(var2.w.isEmpty()) {
               var2.w = gk$c.h(var3);
               var2.b &= -1048577;
            } else {
               var2.n();
               var2.w.addAll(gk$c.h(var3));
            }
         }

         var2.a = var2.a.a(gk$c.i(var3));
         return var2;
      }
   }

   private gk$c m() {
      gk$c var4 = new gk$c(this, (byte)0);
      int var3 = this.b;
      byte var2 = 0;
      if((var3 & 1) == 1) {
         var2 = 1;
      }

      gk$c.a(var4, this.c);
      int var1 = var2;
      if((var3 & 2) == 2) {
         var1 = var2 | 2;
      }

      gk$c.a(var4, this.d);
      int var5 = var1;
      if((var3 & 4) == 4) {
         var5 = var1 | 4;
      }

      gk$c.a(var4, this.e);
      var1 = var5;
      if((var3 & 8) == 8) {
         var1 = var5 | 8;
      }

      gk$c.b(var4, this.f);
      var5 = var1;
      if((var3 & 16) == 16) {
         var5 = var1 | 16;
      }

      gk$c.b(var4, this.g);
      var1 = var5;
      if((var3 & 32) == 32) {
         var1 = var5 | 32;
      }

      gk$c.c(var4, this.h);
      var5 = var1;
      if((var3 & 64) == 64) {
         var5 = var1 | 64;
      }

      gk$c.d(var4, this.i);
      var1 = var5;
      if((var3 & 128) == 128) {
         var1 = var5 | 128;
      }

      gk$c.a(var4, this.j);
      var5 = var1;
      if((var3 & 256) == 256) {
         var5 = var1 | 256;
      }

      gk$c.a(var4, this.k);
      var1 = var5;
      if((var3 & 512) == 512) {
         var1 = var5 | 512;
      }

      gk$c.a(var4, this.l);
      var5 = var1;
      if((var3 & 1024) == 1024) {
         var5 = var1 | 1024;
      }

      gk$c.a(var4, this.m);
      var1 = var5;
      if((var3 & 2048) == 2048) {
         var1 = var5 | 2048;
      }

      gk$c.b(var4, this.n);
      var5 = var1;
      if((var3 & 4096) == 4096) {
         var5 = var1 | 4096;
      }

      gk$c.a(var4, this.o);
      var1 = var5;
      if((var3 & 8192) == 8192) {
         var1 = var5 | 8192;
      }

      gk$c.a(var4, this.p);
      var5 = var1;
      if((var3 & 16384) == 16384) {
         var5 = var1 | 16384;
      }

      gk$c.c(var4, this.q);
      var1 = var5;
      if((var3 & '耀') == '耀') {
         var1 = var5 | '耀';
      }

      gk$c.d(var4, this.r);
      var5 = var1;
      if((var3 & 65536) == 65536) {
         var5 = var1 | 65536;
      }

      gk$c.a(var4, this.s);
      var1 = var5;
      if((var3 & 131072) == 131072) {
         var1 = var5 | 131072;
      }

      gk$c.e(var4, this.t);
      var5 = var1;
      if((var3 & 262144) == 262144) {
         var5 = var1 | 262144;
      }

      gk$c.f(var4, this.u);
      var1 = var5;
      if((var3 & 524288) == 524288) {
         var1 = var5 | 524288;
      }

      gk$c.g(var4, this.v);
      if((this.b & 1048576) == 1048576) {
         this.w = Collections.unmodifiableList(this.w);
         this.b &= -1048577;
      }

      gk$c.a(var4, this.w);
      gk$c.c(var4, var1);
      return var4;
   }

   private void n() {
      if((this.b & 1048576) != 1048576) {
         this.w = new ArrayList(this.w);
         this.b |= 1048576;
      }

   }

   // $FF: synthetic method
   public final de$a a() {
      return this.l();
   }

   public final gk$c$a a(int var1) {
      this.b |= 2048;
      this.n = var1;
      return this;
   }

   public final gk$c$a a(long var1) {
      this.b |= 4;
      this.e = var1;
      return this;
   }

   public final gk$c$a a(gk$a var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.k = var1;
         this.b |= 256;
         return this;
      }
   }

   public final gk$c$a a(gk$f$a var1) {
      gk$f var2 = var1.e();
      if(!var2.d()) {
         throw new dv();
      } else {
         this.o = var2;
         this.b |= 4096;
         return this;
      }
   }

   public final gk$c$a a(gk$i var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.b |= 1;
         this.c = var1;
         return this;
      }
   }

   public final gk$c$a a(gk$j$a var1) {
      this.n();
      List var2 = this.w;
      gk$j var3 = var1.e();
      if(!var3.d()) {
         throw new dv();
      } else {
         var2.add(var3);
         return this;
      }
   }

   public final gk$c$a a(gk$l var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.j = var1;
         this.b |= 128;
         return this;
      }
   }

   public final gk$c$a a(gk$p$a var1) {
      this.s = var1.e();
      this.b |= 65536;
      return this;
   }

   public final gk$c$a a(gk$p var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.s = var1;
         this.b |= 65536;
         return this;
      }
   }

   public final gk$c$a a(gk$r$a var1) {
      gk$r var2 = var1.e();
      if(!var2.d()) {
         throw new dv();
      } else {
         this.p = var2;
         this.b |= 8192;
         return this;
      }
   }

   public final gk$c$a a(gk$x var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.l = var1;
         this.b |= 512;
         return this;
      }
   }

   public final gk$c$a a(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.b |= 2;
         this.d = var1;
         return this;
      }
   }

   // $FF: synthetic method
   public final dl$a b() {
      return this.l();
   }

   public final gk$c$a b(long var1) {
      this.b |= 8;
      this.f = var1;
      return this;
   }

   public final gk$c$a b(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.b |= 16;
         this.g = var1;
         return this;
      }
   }

   public final gk$c$a c(long var1) {
      this.b |= 32;
      this.h = var1;
      return this;
   }

   public final gk$c$a c(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.b |= '耀';
         this.r = var1;
         return this;
      }
   }

   // $FF: synthetic method
   public final Object clone() {
      return this.l();
   }

   public final gk$c$a d(long var1) {
      this.b |= 64;
      this.i = var1;
      return this;
   }

   public final gk$c$a d(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.b |= 131072;
         this.t = var1;
         return this;
      }
   }

   public final boolean d() {
      boolean var1;
      if((this.b & 1) == 1) {
         var1 = true;
      } else {
         var1 = false;
      }

      if(var1) {
         if((this.b & 2) == 2) {
            var1 = true;
         } else {
            var1 = false;
         }

         if(var1) {
            if((this.b & 4) == 4) {
               var1 = true;
            } else {
               var1 = false;
            }

            if(var1) {
               if((this.b & 512) == 512) {
                  var1 = true;
               } else {
                  var1 = false;
               }

               if(!var1 || this.l.d()) {
                  if((this.b & 4096) == 4096) {
                     var1 = true;
                  } else {
                     var1 = false;
                  }

                  if(!var1 || this.o.d()) {
                     if((this.b & 8192) == 8192) {
                        var1 = true;
                     } else {
                        var1 = false;
                     }

                     if(!var1 || this.p.d()) {
                        int var2 = 0;

                        while(true) {
                           if(var2 >= this.w.size()) {
                              return true;
                           }

                           if(!((gk$j)this.w.get(var2)).d()) {
                              break;
                           }

                           ++var2;
                        }
                     }
                  }
               }
            }
         }
      }

      return false;
   }

   public final gk$c$a e(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.b |= 262144;
         this.u = var1;
         return this;
      }
   }

   public final gk$c e() {
      gk$c var1 = this.m();
      if(!var1.d()) {
         throw new dv();
      } else {
         return var1;
      }
   }

   public final gk$c$a f(String var1) {
      if(var1 == null) {
         throw new NullPointerException();
      } else {
         this.b |= 524288;
         this.v = var1;
         return this;
      }
   }

   public final gk$i f() {
      return this.c;
   }

   public final String g() {
      Object var1 = this.d;
      if(!(var1 instanceof String)) {
         dh var3 = (dh)var1;
         String var2 = var3.f();
         if(var3.g()) {
            this.d = var2;
         }

         return var2;
      } else {
         return (String)var1;
      }
   }

   public final long h() {
      return this.e;
   }

   public final boolean i() {
      return (this.b & 131072) == 131072;
   }

   public final String j() {
      Object var1 = this.t;
      if(!(var1 instanceof String)) {
         dh var3 = (dh)var1;
         String var2 = var3.f();
         if(var3.g()) {
            this.t = var2;
         }

         return var2;
      } else {
         return (String)var1;
      }
   }
}
