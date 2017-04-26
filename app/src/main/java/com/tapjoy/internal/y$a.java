package com.tapjoy.internal;

import android.os.AsyncTask;

public final class y$a extends AsyncTask {
   private final Runnable a;

   public y$a(Runnable var1) {
      this.a = var1;
   }

   // $FF: synthetic method
   protected final Object doInBackground(Object[] var1) {
      this.a.run();
      return null;
   }
}
