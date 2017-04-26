package com.flurry.sdk;

import com.flurry.sdk.dm$a;
import com.flurry.sdk.dm$b;
import java.util.Timer;

class dm {
   private Timer a;
   private dm$a b;
   private dm$b c;

   dm(dm$b var1) {
      this.c = var1;
   }

   public void a() {
      synchronized(this){}

      try {
         if(this.a != null) {
            this.a.cancel();
            this.a = null;
         }

         this.b = null;
      } finally {
         ;
      }

   }

   public void a(long var1) {
      synchronized(this){}

      try {
         if(this.b()) {
            this.a();
         }

         this.a = new Timer("FlurrySessionTimer");
         this.b = new dm$a(this, this.c);
         this.a.schedule(this.b, var1);
      } finally {
         ;
      }

   }

   public boolean b() {
      return this.a != null;
   }
}
