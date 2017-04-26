package com.tapjoy.internal;

import android.content.Context;
import android.net.wifi.WifiManager;

public final class ac {
   public static String a(Context var0) {
      WifiManager var3 = (WifiManager)var0.getSystemService("wifi");
      if(var3 != null) {
         try {
            String var4 = com.tapjoy.internal.cv.b(var3.getConnectionInfo().getMacAddress());
            return var4;
         } catch (SecurityException var1) {
            ;
         } catch (RuntimeException var2) {
            ;
         }
      }

      return null;
   }
}
