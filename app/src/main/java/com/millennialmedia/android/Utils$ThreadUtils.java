package com.millennialmedia.android;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Utils$ThreadUtils {
   private static final ExecutorService cachedThreadExecutor = Executors.newCachedThreadPool();

   static void execute(Runnable var0) {
      cachedThreadExecutor.execute(var0);
   }
}
