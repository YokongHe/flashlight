package com.tapjoy.internal;

import android.net.Proxy;
import com.tapjoy.internal.fh;
import java.lang.reflect.Method;

class et extends fh {
   private static final Method a = a(Proxy.class, "getDefaultHost", new Class[0]);
   private static final Method b = a(Proxy.class, "getDefaultPort", new Class[0]);
   private static final String c = et.class.getName();
   private String d = null;
   private int e = 0;

   public et() {
      String var1 = System.getProperty("http.proxyHost");
      if(var1 != null && !var1.isEmpty()) {
         this.d = var1;
      }

      var1 = System.getProperty("http.proxyPort");
      if(var1 != null && !var1.isEmpty()) {
         try {
            this.e = Integer.parseInt(var1);
         } catch (NumberFormatException var2) {
            ;
         }
      }

      if(this.d == null || this.e == 0) {
         Integer var3 = (Integer)a((Object)null, b, new Object[0]);
         if(var3 != null) {
            this.e = var3.intValue();
         }

         var1 = (String)a((Object)null, a, new Object[0]);
         if(var1 != null) {
            this.d = var1;
         }
      }

   }

   public final String a() {
      return this.d;
   }

   public final int b() {
      return this.e;
   }
}
