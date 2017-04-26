package com.adsdk.sdk.video;

import com.adsdk.sdk.Log;
import com.adsdk.sdk.video.TrackEvent;
import java.lang.Thread.UncaughtExceptionHandler;
import java.net.URI;
import java.util.LinkedList;
import java.util.Queue;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;

public class TrackerService {
   private static Object sLock = new Object();
   private static Queue sRetryTrackEvents = new LinkedList();
   private static boolean sStopped;
   private static Thread sThread;
   private static boolean sThreadRunning = false;
   private static Queue sTrackEvents = new LinkedList();

   private static TrackEvent getNextUpdate() {
      Object var0 = sLock;
      synchronized(var0) {
         TrackEvent var1 = (TrackEvent)sTrackEvents.poll();
         return var1;
      }
   }

   private static boolean hasMoreUpdates() {
      // $FF: Couldn't be decompiled
   }

   public static void release() {
      Log.v("release");
      if(sThread != null) {
         Log.v("release stopping Tracking events thread");
         sStopped = true;
      }

   }

   public static void requestRetry(TrackEvent var0) {
      Object var1 = sLock;
      synchronized(var1) {
         if(!sRetryTrackEvents.contains(var0)) {
            ++var0.retries;
            if(var0.retries <= 5) {
               sRetryTrackEvents.add(var0);
            }
         }

         Log.d("Added retry track event:" + sRetryTrackEvents.size());
      }
   }

   public static void requestTrack(TrackEvent var0) {
      Object var1 = sLock;
      synchronized(var1) {
         if(!sTrackEvents.contains(var0)) {
            sTrackEvents.add(var0);
         }

         Log.d("Added track event:" + sTrackEvents.size());
      }

      if(!sThreadRunning) {
         startTracking();
      }

   }

   public static void requestTrack(TrackEvent[] param0) {
      // $FF: Couldn't be decompiled
   }

   public static void startTracking() {
      Object var0 = sLock;
      synchronized(var0) {
         if(!sThreadRunning) {
            sThreadRunning = true;
            Thread var1 = new Thread(new Runnable() {
               public void run() {
                  TrackerService.sStopped = false;

                  while(true) {
                     while(!TrackerService.sStopped) {
                        while(TrackerService.hasMoreUpdates() && !TrackerService.sStopped) {
                           TrackEvent var1 = TrackerService.getNextUpdate();
                           if(var1 != null) {
                              Log.d("Sending tracking :" + var1.url + " Time:" + var1.timestamp + " Events left:" + TrackerService.sTrackEvents.size());
                              Log.d("Sending conversion Request");
                              Log.d("Perform tracking HTTP Get Url: " + var1.url);
                              DefaultHttpClient var2 = new DefaultHttpClient();
                              HttpConnectionParams.setSoTimeout(var2.getParams(), 10000);
                              HttpConnectionParams.setConnectionTimeout(var2.getParams(), 10000);
                              HttpGet var3 = new HttpGet();
                              var3.setHeader("User-Agent", System.getProperty("http.agent"));

                              try {
                                 var3.setURI(new URI(var1.url.trim()));
                                 if(var2.execute(var3).getStatusLine().getStatusCode() != 200) {
                                    TrackerService.requestRetry(var1);
                                 } else {
                                    Log.d("Tracking OK");
                                 }
                              } catch (Throwable var4) {
                                 TrackerService.requestRetry(var1);
                              }
                           }
                        }

                        if(!TrackerService.sStopped && !TrackerService.sRetryTrackEvents.isEmpty()) {
                           try {
                              Thread.sleep(30000L);
                           } catch (Exception var6) {
                              ;
                           }

                           Object var7 = TrackerService.sLock;
                           synchronized(var7) {
                              TrackerService.sTrackEvents.addAll(TrackerService.sRetryTrackEvents);
                              TrackerService.sRetryTrackEvents.clear();
                           }
                        } else {
                           TrackerService.sStopped = true;
                        }
                     }

                     TrackerService.sStopped = false;
                     TrackerService.sThreadRunning = false;
                     TrackerService.sThread = null;
                     return;
                  }
               }
            });
            sThread = var1;
            var1.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
               public void uncaughtException(Thread var1, Throwable var2) {
                  TrackerService.sThreadRunning = false;
                  TrackerService.sThread = null;
                  TrackerService.startTracking();
               }
            });
            sThread.start();
         }

      }
   }
}
