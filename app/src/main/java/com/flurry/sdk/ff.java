package com.flurry.sdk;

import com.flurry.sdk.eo;
import java.io.PrintStream;
import java.io.PrintWriter;

public abstract class ff implements Runnable {
   private static final String a = ff.class.getSimpleName();
   PrintStream g;
   PrintWriter h;

   public abstract void a();

   public final void run() {
      try {
         this.a();
      } catch (Throwable var2) {
         if(this.g != null) {
            var2.printStackTrace(this.g);
         } else if(this.h != null) {
            var2.printStackTrace(this.h);
         } else {
            var2.printStackTrace();
         }

         eo.a(6, a, "", var2);
      }
   }
}
