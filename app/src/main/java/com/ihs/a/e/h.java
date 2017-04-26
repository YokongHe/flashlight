package com.ihs.a.e;

import android.text.TextUtils;
import android.util.Log;
import java.net.InetAddress;
import java.net.UnknownHostException;

public final class h {
   private static Boolean a = Boolean.valueOf(false);
   private static Boolean b = Boolean.valueOf(false);

   public static void a() {
      a = Boolean.valueOf(false);
      b = Boolean.valueOf(false);
      a("gwallcheck.api-alliance.com");
      a("fbwallcheck.api-alliance.com");
   }

   private static void a(final String var0) {
      (new Thread(new Runnable() {
         public final void run() {
            String var1;
            label29: {
               UnknownHostException var2;
               label28: {
                  try {
                     var1 = InetAddress.getByName(var0).getHostAddress();
                  } catch (UnknownHostException var4) {
                     var2 = var4;
                     var1 = null;
                     break label28;
                  }

                  try {
                     Log.d("checkblock", "rul is " + var0 + ", host is " + var1);
                     break label29;
                  } catch (UnknownHostException var3) {
                     var2 = var3;
                  }
               }

               var2.printStackTrace();
            }

            if(!TextUtils.isEmpty(var1) && var1.contains("99.2")) {
               if(!var0.equalsIgnoreCase("gwallcheck.api-alliance.com")) {
                  Log.d("checkblock", "is Facebook blocked");
                  com.ihs.a.e.h.b = Boolean.valueOf(true);
                  return;
               }

               Log.d("checkblock", "is google blocked");
               com.ihs.a.e.h.a = Boolean.valueOf(true);
            }

         }
      })).start();
   }
}
