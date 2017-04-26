package com.amazon.device.ads;

import com.amazon.device.ads.ThreadUtils$RunnableExecutor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadUtils$ThreadPoolRunnableExecutor implements ThreadUtils$RunnableExecutor {
   private static final int keepAliveTimeSeconds = 30;
   private static final int maxNumberThreads = 3;
   private static final int numberThreads = 1;
   private ExecutorService executorService;

   public ThreadUtils$ThreadPoolRunnableExecutor() {
      this.executorService = new ThreadPoolExecutor(1, 3, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue());
   }

   public void execute(Runnable var1) {
      this.executorService.submit(var1);
   }
}
