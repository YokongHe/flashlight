final class f extends cY {
   public f(g var1) {
      super(var1);
   }

   private void l() {
      y.a(new Runnable() {
         // $FF: synthetic field
         private f a = f.this;

         public final void run() {
            this.a.a.a(new j(this.a.a));
         }
      }, 200);
   }

   public final void a() {
      this.a(3);
   }

   public final void b_() {
      this.l();
   }

   public final void c() {
      this.a(3);
   }

   public final void c_() {
      this.l();
   }

   public final void h() {
      if(!this.a.g()) {
         this.l();
      }

   }

   public final void i() {
      this.a(5);
   }
}
