public abstract class g extends cL implements db {
   private final d e;
   private final F f;
   private I g;
   private final H h;
   private final H i;
   private final H j;
   private final H k;
   private final boolean l;
   private final boolean m;
   private final J n;
   private final B o;

   public g(bn var1, cM var2, boolean var3, boolean var4, String var5, E var6, E var7, E var8, E var9, J var10, d var11, b var12) {
      super(var1, var2, var5, var12);
      this.n = var10;
      this.e = var11;
      this.f = new F() {
         public final void a() {
            y.a(new Runnable() {
               // $FF: synthetic field
               private <undefinedtype> a = <VAR_NAMELESS_ENCLOSURE>;

               public final void run() {
                  g.b(g.this).b();
               }
            });
         }

         public final void a(float var1) {
            g.this.e.a(var1);
         }

         public final void a(final int var1) {
            y.a(new Runnable() {
               // $FF: synthetic field
               private int a = var1;
               // $FF: synthetic field
               private <undefinedtype> b = <VAR_NAMELESS_ENCLOSURE>;

               public final void run() {
                  if(this.a == 4) {
                     com.nuance.nmdp.speechkit.recognitionresult.b.c(g.this, "Recorder error");
                     g.b(g.this).a();
                  } else {
                     g.b(g.this).c();
                  }
               }
            });
         }
      };
      this.o = new B() {
         public final void a(Object var1) {
            com.nuance.nmdp.speechkit.recognitionresult.b.c(g.this, "Prompt error");
            y.a(new Runnable() {
               // $FF: synthetic field
               private <undefinedtype> a = <VAR_NAMELESS_ENCLOSURE>;

               public final void run() {
                  g.b(g.this).b_();
               }
            });
         }

         public final void b(Object var1) {
         }

         public final void c(Object var1) {
            y.a(new Runnable() {
               // $FF: synthetic field
               private <undefinedtype> a = <VAR_NAMELESS_ENCLOSURE>;

               public final void run() {
                  g.b(g.this).c_();
               }
            });
         }
      };
      this.g = null;
      this.l = var3;
      this.m = var4;
      H var13;
      if(var6 == null) {
         var13 = null;
      } else {
         var13 = new H(var6, var2.a(), this, this.o);
      }

      this.h = var13;
      if(var7 == null) {
         var13 = null;
      } else {
         var13 = new H(var7, var2.a(), this, this.o);
      }

      this.i = var13;
      if(var8 == null) {
         var13 = null;
      } else {
         var13 = new H(var8, var2.a(), this, this.o);
      }

      this.j = var13;
      if(var9 == null) {
         var13 = null;
      } else {
         var13 = new H(var9, var2.a(), this, this.o);
      }

      this.k = var13;
      this.a = new e(this);
   }

   // $FF: synthetic method
   static c b(g var0) {
      return (c)var0.a;
   }

   protected abstract void b();

   protected abstract String c();

   protected abstract String d();

   final J d_() {
      return this.n;
   }

   protected abstract boolean e();

   public final void f() {
      ((c)this.a).f();
   }

   final boolean g() {
      if(this.h == null) {
         return false;
      } else {
         this.h.a();
         return true;
      }
   }

   final void h() {
      if(this.h != null) {
         this.h.b();
      }

   }

   final void i() {
      if(this.i != null) {
         this.i.a();
      }

   }

   final void j() {
      if(this.j != null) {
         this.j.a();
      }

   }

   final void k() {
      if(this.k != null) {
         this.k.a();
      }

   }

   public final void l() {
      this.g = new I(this.c, this.l, this.m, this, this.d.a(), this.f);
   }

   public final void m() {
      this.g.a();
   }

   public final void n() {
      bd var1 = this.b(this.d());
      this.g.a(var1);
   }

   public final void o() {
      if(this.g != null) {
         this.g.b();
         this.g = null;
      }

   }
}
