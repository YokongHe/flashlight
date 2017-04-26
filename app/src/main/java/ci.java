import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public final class ci implements X509TrustManager {
   private static X509TrustManager b;
   private cj a;

   public ci(cj var1) {
      this.a = var1;
      TrustManagerFactory var2 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
      var2.init((KeyStore)null);
      b = (X509TrustManager)var2.getTrustManagers()[0];
   }

   public final void checkClientTrusted(X509Certificate[] var1, String var2) {
   }

   public final void checkServerTrusted(X509Certificate[] var1, String var2) {
      boolean var5 = false;

      try {
         b.checkServerTrusted(var1, var2);
      } catch (CertificateException var7) {
         if(!this.a.a) {
            throw var7;
         }
      }

      int var3;
      if(this.a.b != null) {
         var3 = 0;

         boolean var8;
         while(true) {
            if(var3 >= var1.length) {
               var8 = false;
               break;
            }

            var2 = var1[var3].getSubjectDN().getName();
            int var4 = var2.indexOf("CN=");
            if(var4 != -1) {
               var4 += 3;
               int var6 = var2.indexOf(44, var4);
               if(var6 == -1) {
                  var2 = var2.substring(var4);
               } else {
                  var2 = var2.substring(var4, var6);
               }

               if(this.a.b.equals(var2)) {
                  var8 = true;
                  break;
               }
            }

            ++var3;
         }

         if(!var8) {
            throw new CertificateException("certificate summary is not identical");
         }
      }

      if(this.a.c != null) {
         var3 = 0;

         boolean var9;
         while(true) {
            var9 = var5;
            if(var3 >= var1.length) {
               break;
            }

            var2 = at.a(var1[var3].getEncoded());
            if(this.a.c.equals(var2)) {
               var9 = true;
               break;
            }

            ++var3;
         }

         if(!var9) {
            throw new CertificateException("certificate data is not identical");
         }
      }

   }

   public final X509Certificate[] getAcceptedIssuers() {
      return b.getAcceptedIssuers();
   }
}
