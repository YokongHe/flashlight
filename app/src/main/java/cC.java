import java.io.IOException;

public class cC implements cw {
   private static final ae a = bh.a(cC.class);
   private byte[] b;

   public cC(byte[] var1) {
      this.b = var1;
   }

   public final cn a() {
      a.b((Object)"Unpacking XML dictation results.");

      try {
         cF var1 = new cF(this.b);
         var1.a();
         if(var1.b()) {
            return var1.c();
         } else {
            if(a.b()) {
               a.b((Object)("Could not parse XML dictation results: " + var1.d() + ". Trying to parse NLSML results."));
            }

            cD var2 = new cD(this.b);
            var2.a();
            if(var2.b()) {
               return var2.c();
            } else {
               String var4 = "Could not parse XML neither NLSML dictation results. Error from XML Parser: " + var1.d() + ". Error from NLSML Parser: " + var2.d();
               if(a.e()) {
                  a.e(var4);
               }

               throw new IllegalArgumentException(var4);
            }
         }
      } catch (IOException var3) {
         if(a.e()) {
            a.a("Received IOException while parsing XML/NLSML.", var3);
         }

         throw new IllegalArgumentException("Received IOException while parsing XML/NLSML.", var3);
      }
   }
}
