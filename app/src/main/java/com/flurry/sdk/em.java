package com.flurry.sdk;

import com.flurry.sdk.ee;
import com.flurry.sdk.eg;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

public final class em extends eg {
   private static em a = null;

   protected em() {
      super(em.class.getName(), 0, 5, 5000L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(11, new ee()));
   }

   public static em a() {
      synchronized(em.class){}

      em var0;
      try {
         if(a == null) {
            a = new em();
         }

         var0 = a;
      } finally {
         ;
      }

      return var0;
   }
}
