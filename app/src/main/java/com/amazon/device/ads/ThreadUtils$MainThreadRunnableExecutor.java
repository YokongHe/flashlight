package com.amazon.device.ads;

import android.os.Handler;
import android.os.Looper;
import com.amazon.device.ads.ThreadUtils$RunnableExecutor;

public class ThreadUtils$MainThreadRunnableExecutor implements ThreadUtils$RunnableExecutor {
   public void execute(Runnable var1) {
      (new Handler(Looper.getMainLooper())).post(var1);
   }
}
