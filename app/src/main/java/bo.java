import java.util.Vector;

public class bo {
   private static final ae a = bh.a(bo.class);

   public static bn a(String var0, short var1, String var2, byte[] var3, String var4, M var5, M var6, String var7, Vector var8, bp var9) {
      if(a.b()) {
         a.b((Object)"createManager");
      }

      if(var0 != null && var0.length() != 0) {
         if(var1 <= 0) {
            a.e("IllegalArgumentException gatewayPort is invalid. ");
            throw new IllegalArgumentException("gatewayPort invalid value!");
         } else if(var2 == null) {
            a.e("NullPointerException applicationId is NULL. ");
            throw new NullPointerException("Application id can not be null!");
         } else if(var3 == null) {
            a.e("NullPointerException appKey is NULL. ");
            throw new NullPointerException("Application key can not be null!");
         } else if(var4 == null) {
            a.e("NullPointerException uid is NULL. ");
            throw new NullPointerException("uid can not be null!");
         } else if(var5 == null) {
            a.e("NullPointerException inputCodec is NULL. ");
            throw new NullPointerException("inputCodec can not be null!");
         } else if(var6 == null) {
            a.e("NullPointerException outputCodec is NULL. ");
            throw new NullPointerException("outputCodec can not be null!");
         } else if(var9 == null) {
            a.e("NullPointerException managerListener is NULL. ");
            throw new NullPointerException("managerListener can not be null!");
         } else {
            if(var8 != null) {
               for(int var10 = 0; var10 < var8.size(); ++var10) {
                  bf var11 = (bf)var8.elementAt(var10);
                  if(var11.d() == bg.e || var11.d() == bg.f || var11.d() == bg.g || var11.d() == bg.h || var11.d() == bg.d || var11.d() == bg.i || var11.d() == bg.j) {
                     a.e("IllegalArgumentException Parameter type: " + var11.d() + " not allowed. ");
                     throw new IllegalArgumentException("Parameter type: " + var11.d() + " not allowed. ");
                  }
               }
            }

            return new bt(var0, var1, var2, var3, var4, var5, var6, var7, var8, var9);
         }
      } else {
         a.e("NullPointerException gatewayIP is NULL. ");
         throw new NullPointerException("gatewayIP must be provided!");
      }
   }
}
