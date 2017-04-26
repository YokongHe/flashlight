public final class bP {
   private int a;
   private String b;
   private String c;
   private bO d;
   private boolean e;

   protected bP(int var1, bO var2) {
      this.a = var1;
      if(bO.e(var2).f() != null) {
         this.b = bu.a(bO.e(var2).f());
      } else {
         this.b = "";
      }

      this.c = "INTERNAL_ERROR";
      this.d = var2;
      this.e = false;
   }

   // $FF: synthetic method
   static void a(bP var0, String var1) {
      if(var0.c.equals("INTERNAL_ERROR")) {
         var0.c = var1;
      } else {
         var0.c = var0.c + ":" + var1;
      }

      bO.a(var0.d, var0);
   }

   protected final int a() {
      return this.a;
   }

   protected final void a(bR var1) {
      if(this.c.equals("INTERNAL_ERROR")) {
         this.c = var1.toString();
      } else {
         this.c = this.c + ":" + var1.toString();
      }

      bO.a(this.d, this);
   }

   protected final void a(String var1) {
      this.b = var1;
   }

   protected final String b() {
      return this.b;
   }

   protected final String c() {
      return this.c;
   }

   protected final void d() {
      this.e = true;
   }

   protected final boolean e() {
      return this.e;
   }
}
