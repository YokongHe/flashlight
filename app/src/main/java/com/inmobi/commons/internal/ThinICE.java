package com.inmobi.commons.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsInitializer;
import com.inmobi.commons.analytics.bootstrapper.ThinICEConfig;
import com.inmobi.commons.cache.RetryMechanism;
import com.inmobi.commons.cache.RetryMechanism$RetryRunnable;
import com.inmobi.commons.internal.ActivityRecognitionSampler;
import com.inmobi.commons.internal.ApplicationFocusManager;
import com.inmobi.commons.internal.ApplicationFocusManager$FocusChangedListener;
import com.inmobi.commons.internal.CommonsException;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.JSONPayloadCreator;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.thinICE.icedatacollector.IceDataCollector;
import com.inmobi.commons.thinICE.icedatacollector.IceDataCollector$ThinIceDataCollectedListener;
import com.inmobi.commons.thinICE.icedatacollector.ThinICEConfigSettings;
import com.inmobi.commons.thinICE.icedatacollector.ThinICEListener;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Timer;

public final class ThinICE {
   private static boolean a = false;
   private static boolean b = false;
   private static ThinICEListener c = new ThinICEListener() {
      public final void onSamplingTerminated(List var1) {
         ThinICE.b(var1);
         IceDataCollector.stop();
         ActivityRecognitionSampler.stop();
      }
   };
   private static Timer d = new Timer();

   @SuppressLint({"NewApi"})
   private static void a(Context var0) {
      if(!a && var0 == null) {
         throw new CommonsException(1);
      } else {
         if(!a) {
            if(VERSION.SDK_INT >= 14) {
               ApplicationFocusManager.init(var0);
               ApplicationFocusManager.addFocusChangedListener(new ApplicationFocusManager$FocusChangedListener() {
                  public final void onFocusChanged(boolean var1) {
                     if(var1) {
                        Log.internal("[InMobi]-4.5.2", "App comes in foreground");
                        ThinICE.b = true;
                        IceDataCollector.start(InternalSDKUtil.getContext());
                     } else {
                        Log.internal("[InMobi]-4.5.2", "App goes in background");
                        ThinICE.b = false;
                        ThinICE.c();
                     }
                  }
               });
               IceDataCollector.start(var0.getApplicationContext());
            } else {
               IceDataCollector.setListener(c);
            }

            a = true;
         }

         InternalSDKUtil.initialize(var0.getApplicationContext());
         IceDataCollector.setIceDataCollectionListener(new IceDataCollector$ThinIceDataCollectedListener() {
            public final void onDataCollected() {
               if(ThinICE.b) {
                  ThinICE.b = false;
                  ThinICE.c();
                  IceDataCollector.start(InternalSDKUtil.getContext());
               }

            }
         });
      }
   }

   private static void b(String var0) {
      HttpURLConnection var1 = (HttpURLConnection)(new URL(AnalyticsInitializer.getConfigParams().getThinIceConfig().getEndpointUrl())).openConnection();
      var1.setRequestProperty("User-Agent", InternalSDKUtil.getUserAgent());
      var1.setDoOutput(true);
      var1.setDoInput(false);
      OutputStreamWriter var2 = new OutputStreamWriter(var1.getOutputStream());
      var2.write(var0);
      var2.flush();
      var2.close();
      var1.getResponseCode();
   }

   private static void b(List var0) {
      if(var0.size() == 0 && ActivityRecognitionSampler.getCollectedList().size() == 0) {
         Log.internal("[InMobi]-4.5.2", "No ThinICE data is collected. NoOp.");
      } else if(!AnalyticsInitializer.getConfigParams().getThinIceConfig().isEnabled()) {
         Log.internal("[InMobi]-4.5.2", "ThisICE disabled. Not sending data. NoOp.");
      } else {
         RetryMechanism var1 = new RetryMechanism((int)AnalyticsInitializer.getConfigParams().getThinIceConfig().getMaxRetry(), (int)AnalyticsInitializer.getConfigParams().getThinIceConfig().getRetryInterval() * 1000, d);
         final String var2 = (new JSONPayloadCreator()).toPayloadString(var0, ActivityRecognitionSampler.getCollectedList(), InternalSDKUtil.getContext());
         Log.internal("[InMobi]-4.5.2", "Sending " + var0.size() + " ThinICE params to server " + var2);
         var1.rescheduleTimer(new RetryMechanism$RetryRunnable() {
            public final void completed() {
            }

            public final void run() {
               Log.internal("[InMobi]-4.5.2", "Sending ThinICE data to server " + AnalyticsInitializer.getConfigParams().getThinIceConfig().getEndpointUrl());
               if(InternalSDKUtil.checkNetworkAvailibility(InternalSDKUtil.getContext())) {
                  ThinICE.b(var2);
               } else {
                  throw new Exception("Device not connected.");
               }
            }
         });
      }
   }

   private static void c() {
      List var0 = IceDataCollector.getData();
      IceDataCollector.stop();
      b(var0);
      ActivityRecognitionSampler.stop();
   }

   public static void setConfig(ThinICEConfig var0) {
      if(var0 != null) {
         ThinICEConfigSettings var1 = new ThinICEConfigSettings();
         var1.setEnabled(var0.isEnabled());
         var1.setSampleCellEnabled(var0.isCellEnabled());
         var1.setSampleCellOperatorEnabled(var0.isOperatorEnabled());
         var1.setSampleConnectedWifiEnabled(var0.isConnectedWifiEnabled());
         var1.setSampleHistorySize(var0.getSampleHistorySize());
         var1.setSampleInterval(var0.getSampleInterval() * 1000L);
         var1.setSampleLocationEnabled(true);
         var1.setSampleVisibleWifiEnabled(var0.isVisibleWifiEnabled());
         var1.setStopRequestTimeout(var0.getStopRequestTimeout() * 1000L);
         var1.setWifiFlags(var0.getWifiFlags());
         var1.setCellOpFlags(var0.getCellOpsFlag());
         IceDataCollector.setConfig(var1);
      }

   }

   public static void start(Context var0) {
      if(InternalSDKUtil.isInitializedSuccessfully(false)) {
         a(var0);
         if(VERSION.SDK_INT < 14) {
            IceDataCollector.start(var0);
         }

         ActivityRecognitionSampler.start();
      }
   }

   public static void stop(Context var0) {
      a(var0);
      if(VERSION.SDK_INT < 14) {
         c();
      }

   }
}
