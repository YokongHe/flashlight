package com.ihs.app.alerts.impl;

import java.util.Random;

final class j extends com.ihs.app.alerts.impl.c {
   j() {
      super("UpdateAlert");
   }

   public final boolean a() {
      if(com.ihs.app.b.c.c()) {
         int var1 = com.ihs.a.e.g.a(this.e(), 0, new String[]{"Probability"});
         return (new Random()).nextInt(100) < var1;
      } else {
         return false;
      }
   }

   public final void b() {
      com.ihs.app.a.b.a("HSUpdateAlert_Showed");
      super.b();
   }
}
