package com.tapjoy.internal;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class eg implements Runnable {
   private static final String c = eg.class.getSimpleName();
   private String a;
   private InetAddress b;

   public eg(String var1) {
      this.a = var1;
   }

   private void a(InetAddress var1) {
      synchronized(this){}

      try {
         this.b = var1;
      } finally {
         ;
      }

   }

   public void run() {
      String var1;
      try {
         var1 = c;
         InetAddress var4 = InetAddress.getByName(this.a);
         String var2 = c;
         this.a(var4);
      } catch (UnknownHostException var3) {
         var1 = c;
      }
   }
}
