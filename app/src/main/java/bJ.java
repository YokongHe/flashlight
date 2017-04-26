public class bJ extends bB implements bb {
   private static final ae a = bh.a(bJ.class);

   public bJ(byte[] var1) {
      super((short)29185, var1);
   }

   public final boolean g() {
      try {
         if(this.a("final_response")) {
            if(this.d("final_response") == 0) {
               return false;
            }
         } else if(a.c()) {
            a.c((Object)"final_response does not exist. ");
            return true;
         }
      } catch (Exception var2) {
         ;
      }

      return true;
   }
}
