import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

public final class ch {
   private static SSLSocketFactory a;
   private static SSLContext b;
   private static ci[] c = new ci[1];

   public static Socket a(String var0, int var1, cj var2) {
      try {
         c[0] = new ci(var2);
         SSLContext var6 = SSLContext.getInstance("TLS");
         b = var6;
         var6.init((KeyManager[])null, (TrustManager[])c, (SecureRandom)null);
         a = b.getSocketFactory();
      } catch (NoSuchAlgorithmException var3) {
         throw new SecurityException("No such algorithm exception " + var3);
      } catch (KeyManagementException var4) {
         throw new SecurityException("Failed to initialize the client-side SSLContext " + var4);
      } catch (GeneralSecurityException var5) {
         throw new SecurityException("General security exception " + var5);
      }

      return a.createSocket(var0, var1);
   }
}
