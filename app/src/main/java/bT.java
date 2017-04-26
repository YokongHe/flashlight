import java.util.Vector;

public class bT {
   private static final ae a = bh.a(bT.class);

   public static bS a(bn var0, bs var1, Vector var2) {
      if(a.b()) {
         a.b((Object)"createNMASResource");
      }

      if(var0 == null) {
         a.e("manager is null");
         throw new NullPointerException("manager can not be null!");
      } else if(var1 == null) {
         a.e("nmasListener is null");
         throw new NullPointerException("nmasListener can not be null!");
      } else {
         if(var2 != null) {
            for(int var3 = 0; var3 < var2.size(); ++var3) {
               bf var4 = (bf)var2.elementAt(var3);
               if(var4.d() == bg.c || var4.d() == bg.d || var4.d() == bg.e || var4.d() == bg.f || var4.d() == bg.g || var4.d() == bg.h || var4.d() == bg.i || var4.d() == bg.j) {
                  a.e("IllegalArgumentException Parameter type: " + var4.d() + " not allowed. ");
                  throw new IllegalArgumentException("Parameter type: " + var4.d() + " not allowed. ");
               }
            }
         }

         return new bx((bt)var0, var1, var2);
      }
   }
}
