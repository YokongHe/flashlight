package com.nuance.a.a.a.a;

public final class q implements Runnable {
   private .aq a;
   // $FF: synthetic field
   private com.nuance.a.a.a.a.o b;

   public q(com.nuance.a.a.a.a.o var1, .aq var2) {
      this.b = var1;
      super();
      this.a = var2;
      com.nuance.a.a.a.a.o.a(var1).put(var2, this);
   }

   public final void run() {
      com.nuance.a.a.a.a.q var1 = (com.nuance.a.a.a.a.q)com.nuance.a.a.a.a.o.a(this.b).remove(this.a);
      if(com.nuance.a.a.a.a.o.d().b()) {
         com.nuance.a.a.a.a.o.d().b((Object)("TIMER run() _pendingTimerTasks.size():" + com.nuance.a.a.a.a.o.a(this.b).size() + ", this:" + this + ", r:" + var1));
      }

      if(var1 != null) {
         var1.a.run();
      }

   }
}
