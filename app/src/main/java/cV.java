final class cV extends cK {
   private final cR a;

   public cV(cR var1) {
      super(var1);
      this.a = var1;
   }

   protected final void a(int var1, String var2, String var3) {
      this.a.a(new cP(this.a, var1, var2, var3));
   }

   public final void a(bb var1) {
      J var2 = this.a.d();
      if(var2 != null && var2.a(var1) && !var2.a()) {
         this.a.a(new cQ(this.a));
      } else {
         this.a(0);
      }
   }

   public final void a(String var1) {
      this.a(0, var1);
   }

   public final void b(String var1) {
      this.a(2, (String)null, var1);
   }

   public final void d() {
      this.a(0);
   }

   public final void e() {
      this.a(1);
   }

   public final void h() {
      try {
         this.a.r();
         this.a.a(this.a.c());
         this.a.b();
         this.a.t();
      } catch (Throwable var2) {
         com.nuance.nmdp.speechkit.recognitionresult.b.a(this, "Error starting PendingState", var2);
         this.a(0);
      }
   }

   public final void i() {
      this.a(5);
   }
}
