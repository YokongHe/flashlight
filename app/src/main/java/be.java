public abstract class be {
   private static final ae b = bh.a(be.class);
   protected String a;
   private String c;
   private short d;
   private af e;
   private M f;
   private M g;

   protected be(String var1, short var2, String var3, M var4, M var5) {
      if(b.b()) {
         b.b((Object)("in NMSPManager() gateway IP [" + var1 + "] Port [" + var2 + "]"));
      }

      String var6 = null;
      if(var1 == null) {
         var6 = " gatewayIP is null";
      } else if(var1.length() == 0) {
         var6 = " gatewayIP is empty";
      }

      if(var2 <= 0) {
         var6 = " gatewayPort should be greater than 0";
      }

      if(var6 != null) {
         b.e("NMSPManager " + IllegalArgumentException.class.getName() + var6);
         throw new IllegalArgumentException(var6);
      } else {
         this.c = var1;
         this.d = var2;
         this.a = var3;
         this.f = var4;
         this.g = var5;
         this.e = new com.nuance.a.a.a.a.o();
      }
   }

   public static String g() {
      throw new RuntimeException("Unsupported");
   }

   public final void a(M var1) {
      this.f = var1;
   }

   public final String b() {
      return this.c;
   }

   public final void b(M var1) {
      this.g = var1;
   }

   public final short c() {
      return this.d;
   }

   public final String d() {
      return this.a;
   }

   public final M e() {
      return this.f;
   }

   public final M f() {
      return this.g;
   }

   public final af i_() {
      return this.e;
   }
}
