package com.tapjoy.internal;

import java.io.Closeable;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class dd {
   static final Logger a = Logger.getLogger(dd.class.getName());

   public static void a(Closeable var0) {
      if(var0 != null) {
         try {
            var0.close();
         } catch (IOException var2) {
            IOException var3 = var2;

            try {
               a.log(Level.WARNING, "IOException thrown while closing Closeable.", var3);
               return;
            } catch (IOException var1) {
               a.log(Level.SEVERE, "IOException should not have been thrown.", var1);
               return;
            }
         }
      }

   }
}
