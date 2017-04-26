public class bH extends bB {
   private static final ae a = bh.a(bH.class);

   public bH(bD var1) {
      super((short)515);
      if(a.b()) {
         a.b((Object)"PDXQueryParameter()");
      }

      this.a("name", var1.b(), (short)193);
      if(var1.c() == 127) {
         this.a("type", 5);
      } else {
         this.a("type", var1.c());
      }

      switch(var1.c()) {
      case 1:
         this.a("buffer_id", ((by)var1).a());
         return;
      case 2:
         this.a("text", ((bN)var1).a(), (short)193);
         return;
      case 3:
         this.a("text", (String)null, (short)193);
         return;
      case 4:
         this.a("data", (byte[])null, (short)193);
         return;
      case 5:
         this.a("dict", ((bz)var1).a(), (short)224);
         return;
      case 6:
      case 7:
      case 8:
         this.a("dict", ((bL)var1).a(), (short)224);
         return;
      case 127:
         this.a("dict", ((bM)var1).d(), (short)224);
         return;
      default:
         a.e("PDXQueryParameter() Unknown parameter type: " + var1.c() + ". ");
      }
   }
}
