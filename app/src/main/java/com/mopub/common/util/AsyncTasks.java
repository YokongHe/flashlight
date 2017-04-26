package com.mopub.common.util;

import android.annotation.TargetApi;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AsyncTasks {
   private static Executor sExecutor;

   static {
      init();
   }

   @TargetApi(11)
   private static void init() {
      if(VERSION.SDK_INT >= 11) {
         sExecutor = AsyncTask.THREAD_POOL_EXECUTOR;
      } else {
         sExecutor = Executors.newSingleThreadExecutor();
      }
   }

   @TargetApi(11)
   public static void safeExecuteOnExecutor(AsyncTask var0, Object... var1) {
      Preconditions.checkNotNull(var0, "Unable to execute null AsyncTask.");
      Preconditions.checkUiThread("AsyncTask must be executed on the main thread");
      if(VERSION.SDK_INT >= 11) {
         var0.executeOnExecutor(sExecutor, var1);
      } else {
         var0.execute(var1);
      }
   }

   @VisibleForTesting
   public static void setExecutor(Executor var0) {
      sExecutor = var0;
   }
}
