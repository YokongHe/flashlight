package com.amazon.device.ads;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import com.amazon.device.ads.AndroidTargetUtils;
import com.amazon.device.ads.ThreadUtils$MainThreadRunnableExecutor;
import com.amazon.device.ads.ThreadUtils$RunnableExecutor;
import com.amazon.device.ads.ThreadUtils$ThreadPoolRunnableExecutor;
import com.amazon.device.ads.ThreadUtils$ThreadVerify;

class ThreadUtils {
   private static ThreadUtils$RunnableExecutor mainThreadExecutor = new ThreadUtils$MainThreadRunnableExecutor();
   private static ThreadUtils$RunnableExecutor runnableExecutor = new ThreadUtils$ThreadPoolRunnableExecutor();

   public static final void executeAsyncTask(final AsyncTask var0, final Object... var1) {
      if(Looper.myLooper() == Looper.getMainLooper()) {
         AndroidTargetUtils.executeAsyncTask(var0, var1);
      } else {
         (new Handler(Looper.getMainLooper())).post(new Runnable() {
            public final void run() {
               AndroidTargetUtils.executeAsyncTask(var0, var1);
            }
         });
      }
   }

   public static void executeOnMainThread(Runnable var0) {
      if(isOnMainThread()) {
         var0.run();
      } else {
         scheduleOnMainThread(var0);
      }
   }

   public static void executeRunnable(Runnable var0) {
      runnableExecutor.execute(var0);
   }

   public static void executeRunnableWithThreadCheck(Runnable var0) {
      if(isOnMainThread()) {
         executeRunnable(var0);
      } else {
         var0.run();
      }
   }

   public static boolean isOnMainThread() {
      return ThreadUtils$ThreadVerify.getInstance().isOnMainThread();
   }

   public static void scheduleOnMainThread(Runnable var0) {
      mainThreadExecutor.execute(var0);
   }
}
