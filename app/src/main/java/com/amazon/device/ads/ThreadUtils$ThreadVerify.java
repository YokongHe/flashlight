package com.amazon.device.ads;

import android.os.Looper;

class ThreadUtils$ThreadVerify {
   private static ThreadUtils$ThreadVerify instance = new ThreadUtils$ThreadVerify();

   static ThreadUtils$ThreadVerify getInstance() {
      return instance;
   }

   boolean isOnMainThread() {
      return Looper.getMainLooper().getThread() == Thread.currentThread();
   }
}
