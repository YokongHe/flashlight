package com.flurry.sdk;

import java.lang.ref.WeakReference;
import java.util.concurrent.FutureTask;

public class ef extends FutureTask {
   private final WeakReference a = null;
   private final WeakReference b;

   public ef(Runnable var1, Object var2) {
      super(var1, var2);
      this.b = new WeakReference(var1);
   }

   public Runnable a() {
      return (Runnable)this.b.get();
   }
}
