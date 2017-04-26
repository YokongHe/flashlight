package com.flurry.sdk;

import java.util.concurrent.ThreadFactory;

public class ez implements ThreadFactory {
   private final ThreadGroup a;
   private final int b;

   public ez(String var1, int var2) {
      this.a = new ThreadGroup(var1);
      this.b = var2;
   }

   public Thread newThread(Runnable var1) {
      Thread var2 = new Thread(this.a, var1);
      var2.setName(this.a.getName() + ":" + var2.getId());
      var2.setPriority(this.b);
      return var2;
   }
}
