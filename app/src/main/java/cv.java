public final class cv implements cq {
   private String a;
   private long b;
   private long c;
   private double d;
   private boolean e;
   private boolean f;
   private boolean g;
   private boolean h;

   private cv(String var1, long var2, long var4, double var6, boolean var8) {
      this.e = true;
      this.f = false;
      this.g = false;
      this.h = false;
      this.a = var1;
      this.b = var2;
      this.c = var4;
      this.d = var6;
      this.e = var8;
      int var9;
      if(this.a.indexOf("\\*no-space-before") != -1) {
         this.g = true;
         var9 = this.a.indexOf("\\*no-space-before");
         if(var9 + 17 == this.a.length()) {
            this.a = this.a.substring(0, var9);
         } else {
            this.a = this.a.substring(0, var9) + this.a.substring(var9 + 17);
         }
      }

      if(this.a.indexOf("\\*no-space-after") != -1) {
         this.h = true;
         var9 = this.a.indexOf("\\*no-space-after");
         if(var9 + 16 == this.a.length()) {
            this.a = this.a.substring(0, var9);
         } else {
            this.a = this.a.substring(0, var9) + this.a.substring(var9 + 16);
         }
      }

      if(this.a.length() != 0 && cH.a(this.a).length() == 0) {
         this.f = true;
      }

   }

   public cv(String var1, long var2, long var4, double var6, boolean var8, byte var9) {
      cr var10 = cr.a;
      this(var1, var2, var4, var6, var8);
   }

   public final double a() {
      return this.d;
   }

   public final void a(String var1) {
      this.a = var1;
   }

   public final String b() {
      return this.a;
   }

   public final long c() {
      return this.b;
   }

   public final long d() {
      return this.c;
   }

   public final boolean e() {
      return this.e;
   }

   public final boolean f() {
      return this.f;
   }

   public final boolean g() {
      return this.g;
   }

   public final boolean h() {
      return this.h;
   }

   public final String toString() {
      return this.a;
   }
}
