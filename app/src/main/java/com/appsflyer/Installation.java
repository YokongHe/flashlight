package com.appsflyer;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.util.UUID;

public class Installation {
   private static final String INSTALLATION = "AF_INSTALLATION";
   private static String sID = null;

   public static String id(Context var0) {
      synchronized(Installation.class){}

      String var6;
      try {
         if(sID == null) {
            File var5 = new File(var0.getFilesDir(), "AF_INSTALLATION");

            try {
               if(!var5.exists()) {
                  writeInstallationFile(var5);
               }

               sID = readInstallationFile(var5);
            } catch (Exception var3) {
               throw new RuntimeException(var3);
            }
         }

         var6 = sID;
      } finally {
         ;
      }

      return var6;
   }

   private static String readInstallationFile(File var0) {
      RandomAccessFile var2 = new RandomAccessFile(var0, "r");
      byte[] var1 = new byte[(int)var2.length()];
      var2.readFully(var1);
      var2.close();
      return new String(var1);
   }

   private static void writeInstallationFile(File var0) {
      FileOutputStream var1 = new FileOutputStream(var0);
      var1.write(UUID.randomUUID().toString().getBytes());
      var1.close();
   }
}
