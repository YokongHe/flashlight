package com.inmobi.monetization.internal.imai;

import android.content.Context;
import android.os.Handler;
import com.inmobi.commons.analytics.net.AnalyticsCommon$HttpRequestCallback;
import com.inmobi.commons.internal.Log;
import com.inmobi.monetization.internal.imai.IMAIClickEventList;
import com.inmobi.monetization.internal.imai.WebviewLoader;
import java.util.concurrent.atomic.AtomicBoolean;

public final class RequestResponseManager {
   static Thread a;
   static Handler b = new Handler();
   static AtomicBoolean c = null;
   private static AtomicBoolean g = null;
   private static AtomicBoolean i = null;
   public static AtomicBoolean isSynced;
   public static IMAIClickEventList mDBWriterQueue = new IMAIClickEventList();
   public static IMAIClickEventList mNetworkQueue = null;
   String d = "";
   String e = "";
   String f = "";
   private WebviewLoader h = null;

   // $FF: synthetic method
   static AtomicBoolean a() {
      return i;
   }

   public final void deinit() {
      try {
         if(g != null) {
            g.set(false);
         }

         if(mDBWriterQueue != null) {
            mDBWriterQueue.saveClickEvents();
            mDBWriterQueue.clear();
         }

         isSynced.set(false);
         if(mNetworkQueue != null) {
            mNetworkQueue.clear();
         }

         mNetworkQueue = null;
      } catch (Exception var2) {
         Log.internal("[InMobi]-[Monetization]", "Request Response Manager deinit failed", var2);
      }
   }

   public final void init() {
      try {
         if(mNetworkQueue == null) {
            mNetworkQueue = IMAIClickEventList.getLoggedClickEvents();
         }

         if(g == null) {
            g = new AtomicBoolean(false);
         }

         i = new AtomicBoolean(true);
         isSynced = new AtomicBoolean(false);
         c = new AtomicBoolean(false);
      } catch (Exception var2) {
         Log.internal("[InMobi]-[Monetization]", "Request Response Manager init failed", var2);
      }
   }

   public final void processClick(final Context var1, final AnalyticsCommon$HttpRequestCallback var2) {
      try {
         if(g.compareAndSet(false, true)) {
            Thread var4 = new Thread(new Runnable() {
               public void run() {
                  // $FF: Couldn't be decompiled
               }
            });
            a = var4;
            var4.setPriority(1);
            a.start();
         }

      } catch (Exception var3) {
         Log.internal("[InMobi]-[Monetization]", "Exception ping ", var3);
      }
   }

   public final boolean processClickHttpClient(String param1, boolean param2) {
      // $FF: Couldn't be decompiled
   }

   public final boolean processClickUrlInWebview(String param1) {
      // $FF: Couldn't be decompiled
   }
}
