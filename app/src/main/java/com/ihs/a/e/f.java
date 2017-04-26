package com.ihs.a.e;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import java.io.ByteArrayInputStream;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

public final class f {
   private static boolean a = false;
   private static boolean b = false;
   private static Context c;

   public static void a(Context var0) {
      c = var0;
   }

   public static boolean a() {
      if(a) {
         return b;
      } else {
         try {
            byte[] var0 = c.getPackageManager().getPackageInfo(c.getPackageName(), 64).signatures[0].toByteArray();
            b = ((X509Certificate)CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(var0))).getIssuerDN().toString().contains("Android Debug");
         } catch (RuntimeException var5) {
            var5.printStackTrace();
         } catch (NameNotFoundException var6) {
            var6.printStackTrace();
         } catch (CertificateException var7) {
            var7.printStackTrace();
         } finally {
            a = true;
         }

         return b;
      }
   }
}
