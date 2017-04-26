final class u extends w {
   private boolean c = false;
   private boolean d = false;

   public u(v var1) {
      super(var1);
   }

   public final void a() {
      this.a(4, "audioError");
   }

   public final void a(bb var1) {
      this.c = true;
      if(this.d) {
         this.a.a((cK)(new q(this.a)));
      }

   }

   public final void a(String var1) {
      this.a(4, var1);
   }

   public final void b() {
      this.f().b(this.a);
   }

   public final void b(String var1) {
      this.a(2, (String)null, var1);
   }

   public final void c() {
      this.d = true;
      if(this.c) {
         this.a.a((cK)(new q(this.a)));
      }

   }

   public final void d() {
      this.a(4, "createCommandFailed");
   }

   public final void e() {
      this.a(1);
   }

   public final void h() {
      try {
         this.a.r();
         this.a.a((String)this.a.e_());
         this.a.a(this.a.c(), this.a.b(), this.a.f());
         this.a.t();
         this.a.d();
      } catch (Throwable var2) {
         com.nuance.nmdp.speechkit.recognitionresult.b.a(this, "Error starting PlayingState", var2);
         this.a(4);
      }
   }

   public final void i() {
      this.a(5);
   }

   public final void k() {
      this.a.e();
   }
}
