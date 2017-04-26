package com.amazon.device.ads;

import android.util.SparseArray;
import com.amazon.device.ads.Configuration;
import com.amazon.device.ads.Configuration$ConfigurationListener;
import com.amazon.device.ads.Settings;
import com.amazon.device.ads.Settings$SettingsListener;
import com.amazon.device.ads.ThreadUtils$MainThreadRunnableExecutor;
import com.amazon.device.ads.ThreadUtils$RunnableExecutor;
import com.amazon.device.ads.ThreadUtils$ThreadPoolRunnableExecutor;

abstract class StartUpWaiter implements Configuration$ConfigurationListener, Settings$SettingsListener {
   static final int CALLBACK_ON_MAIN_THREAD = 0;
   static final int DEFAULT = 1;
   private static final SparseArray executors = new SparseArray();
   private int callbackType = 1;

   static {
      putRunnableExecutor(0, new ThreadUtils$MainThreadRunnableExecutor());
      putRunnableExecutor(1, new ThreadUtils$ThreadPoolRunnableExecutor());
   }

   static ThreadUtils$RunnableExecutor getExecutor(int var0) {
      return (ThreadUtils$RunnableExecutor)executors.get(var0, executors.get(1));
   }

   private void onFinished(Runnable var1) {
      getExecutor(this.callbackType).execute(var1);
   }

   static void putRunnableExecutor(int var0, ThreadUtils$RunnableExecutor var1) {
      if(var1 == null) {
         executors.remove(var0);
      } else {
         executors.put(var0, var1);
      }
   }

   public void onConfigurationFailure() {
      this.onFinished(new Runnable() {
         public void run() {
            StartUpWaiter.this.startUpFailed();
         }
      });
   }

   public void onConfigurationReady() {
      this.onFinished(new Runnable() {
         public void run() {
            StartUpWaiter.this.startUpReady();
         }
      });
   }

   public void settingsLoaded() {
      Configuration.getInstance().queueConfigurationListener(this);
   }

   public void start() {
      Settings.getInstance().listenForSettings(this);
   }

   public void startAndCallbackOnMainThread() {
      this.callbackType = 0;
      this.start();
   }

   protected abstract void startUpFailed();

   protected abstract void startUpReady();
}
