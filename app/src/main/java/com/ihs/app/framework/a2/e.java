package com.ihs.app.framework.a2;

import java.util.Observable;

public final class e extends Observable {
   private static com.ihs.app.framework.a2.e a = new com.ihs.app.framework.a2.e();

   public static com.ihs.app.framework.a2.e a() {
      return a;
   }

   public final void a(com.ihs.app.framework.a2.f var1) {
      this.setChanged();
      this.notifyObservers(var1);
   }
}
