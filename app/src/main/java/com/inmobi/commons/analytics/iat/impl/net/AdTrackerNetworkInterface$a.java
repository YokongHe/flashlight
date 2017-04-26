package com.inmobi.commons.analytics.iat.impl.net;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.inmobi.commons.analytics.iat.impl.AdTrackerUtils;
import com.inmobi.commons.analytics.iat.impl.Goal;
import com.inmobi.commons.analytics.iat.impl.Goal$State;
import com.inmobi.commons.analytics.iat.impl.GoalList;
import com.inmobi.commons.analytics.iat.impl.config.AdTrackerEventType;
import com.inmobi.commons.analytics.iat.impl.config.AdTrackerInitializer;
import com.inmobi.commons.analytics.iat.impl.net.AdTrackerNetworkInterface;
import com.inmobi.commons.analytics.iat.impl.net.AdTrackerRequestResponseBuilder;
import com.inmobi.commons.analytics.iat.impl.net.AdTrackerWebViewLoader;
import com.inmobi.commons.internal.FileOperations;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import java.util.Iterator;

final class AdTrackerNetworkInterface$a extends Handler {
   static final int a = AdTrackerInitializer.getConfigParams().getReferrerWaitTimeRetryInterval();
   static final int b = AdTrackerInitializer.getConfigParams().getReferrerWaitTime();
   static final int c = AdTrackerInitializer.getConfigParams().getWebviewTimeout();

   public AdTrackerNetworkInterface$a(Looper var1) {
      super(var1);
   }

   public final void handleMessage(Message var1) {
      int var2;
      long var5;
      Goal var9;
      Iterator var10;
      String var12;
      Message var14;
      Message var15;
      Goal var16;
      String var17;
      switch(var1.what) {
      case 2:
         Log.internal("[InMobi]-[AdTracker]-4.5.2", "Trying to fetch referrer ...");
         ((Goal)AdTrackerNetworkInterface.f().get(var1.arg1)).state = Goal$State.REFERRER_REQUESTED;
         if(AdTrackerNetworkInterface.g()) {
            var14 = Message.obtain();
            var14.what = 4;
            var14.arg1 = var1.arg1;
            var14.obj = (String)var1.obj;
            this.sendMessage(var14);
            return;
         }

         if(!AdTrackerNetworkInterface.h()) {
            var2 = AdTrackerInitializer.getConfigParams().getReferrerWaitTimeRetryCount();
            int var3 = var1.arg2 - 1;
            var1.arg2 = var3;
            if(var3 != 0) {
               var14 = Message.obtain();
               var14.what = 2;
               var14.arg1 = var1.arg1;
               var14.arg2 = var3;
               var14.obj = (String)var1.obj;
               this.sendMessageDelayed(var14, (long)((var2 + 1 - var3) * a));
               return;
            }

            boolean var13;
            if(!AdTrackerNetworkInterface.i() && !AdTrackerNetworkInterface.g()) {
               var13 = false;
            } else {
               var13 = true;
            }

            if(var13) {
               var14 = Message.obtain();
               var14.what = 4;
               var14.arg1 = var1.arg1;
               var14.obj = (String)var1.obj;
               this.sendMessage(var14);
               return;
            }

            var14 = Message.obtain();
            var14.what = 3;
            var14.arg1 = var1.arg1;
            var14.arg2 = b;
            var14.obj = (String)var1.obj;
            this.sendMessageDelayed(var14, (long)b);
            return;
         }

         if(!AdTrackerNetworkInterface.i()) {
            long var7 = FileOperations.getLongPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "referrerWaitTime");
            var14 = Message.obtain();
            var14.what = 3;
            var14.arg1 = var1.arg1;
            if(var7 < 0L) {
               var5 = (long)b;
            } else {
               var5 = var7;
            }

            var14.arg2 = (int)var5;
            var14.obj = (String)var1.obj;
            this.sendMessageDelayed(var14, var7);
            return;
         }

         var14 = Message.obtain();
         var14.what = 4;
         var14.arg1 = var1.arg1;
         var14.obj = (String)var1.obj;
         this.sendMessage(var14);
         return;
      case 3:
         Log.internal("[InMobi]-[AdTracker]-4.5.2", "Referrer wait timed out. MESSAGE_GET_REFERRER received ...");
         if(!AdTrackerNetworkInterface.i()) {
            var14 = Message.obtain();
            var14.what = 5;
            var14.arg1 = var1.arg1;
            var14.obj = (String)var1.obj;
            this.sendMessage(var14);
            return;
         }

         var14 = Message.obtain();
         var14.what = 4;
         var14.arg1 = var1.arg1;
         var14.obj = (String)var1.obj;
         this.sendMessage(var14);
         return;
      case 4:
         Log.internal("[InMobi]-[AdTracker]-4.5.2", "GET_REFFERRER_SUCCEEDED message received");
         FileOperations.setPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "waitForReferrer", true);
         ((Goal)AdTrackerNetworkInterface.f().get(var1.arg1)).state = Goal$State.REFERRER_ACQUIRED;
         var14 = Message.obtain();
         var14.arg1 = var1.arg1;
         var14.obj = (String)var1.obj;
         if(AdTrackerNetworkInterface.k()) {
            var14.what = 6;
         } else {
            var14.what = 7;
         }

         this.sendMessage(var14);
         return;
      case 5:
         Log.internal("[InMobi]-[AdTracker]-4.5.2", "Getting referrer timed out...");
         var17 = AdTrackerUtils.getReferrerFromLogs();
         if(var17 != null) {
            Log.internal("[InMobi]-[AdTracker]-4.5.2", "Saving referrer from logs: " + var17);
            AdTrackerUtils.setReferrerFromLogs(InternalSDKUtil.getContext(), var17);
         }

         var14 = Message.obtain();
         var14.what = 4;
         var14.arg1 = var1.arg1;
         var14.obj = (String)var1.obj;
         this.sendMessage(var14);
         return;
      case 6:
         Log.internal("[InMobi]-[AdTracker]-4.5.2", "Reporting Goal via network ...");
         var9 = (Goal)AdTrackerNetworkInterface.f().get(var1.arg1);
         var12 = (String)var1.obj;
         var9.state = Goal$State.REPORTING_REQUESTED;
         AdTrackerRequestResponseBuilder.reportGoalOverHttp(var12, var9, FileOperations.getPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "iat_ids"));
         return;
      case 7:
         Log.internal("[InMobi]-[AdTracker]-4.5.2", "Reporting Goal via webview");
         var16 = (Goal)AdTrackerNetworkInterface.f().get(var1.arg1);
         var16.state = Goal$State.REPORTING_REQUESTED;
         var17 = (String)var1.obj;
         AdTrackerNetworkInterface.a(new AdTrackerWebViewLoader());
         AdTrackerRequestResponseBuilder.saveWebviewRequestParam(var17, var16);
         AdTrackerNetworkInterface.j().loadWebview(var17, var16);
         var15 = Message.obtain();
         var15.what = 9;
         var15.arg1 = var1.arg1;
         var15.obj = var17;
         this.sendMessageDelayed(var15, (long)c);
         return;
      case 8:
         Log.internal("[InMobi]-[AdTracker]-4.5.2", "Reporting Goal succeeded...");
         var9 = (Goal)var1.obj;
         if(Goal$State.REPORTING_REQUESTED == var9.state) {
            var9.state = Goal$State.REPORTING_COMPLETED;
            AdTrackerUtils.reportMetric(AdTrackerEventType.GOAL_SUCCESS, var9, 1, (long)var1.arg2, 0, (String)null);
            FileOperations.setPreferences(InternalSDKUtil.getContext(), "IMAdTrackerStatusUpload", "goalPingSuccess", true);
            if("download".equals(var9.name)) {
               AdTrackerUtils.updateStatus();
            }

            var12 = var1.getData().getString("appId");
            var10 = AdTrackerNetworkInterface.f().iterator();

            for(var2 = 0; var10.hasNext() && !((Goal)var10.next()).equals(var9); ++var2) {
               ;
            }

            var14 = Message.obtain();
            if(var2 == AdTrackerNetworkInterface.f().size() - 1) {
               var14.what = 11;
               var14.arg1 = var2;
               var14.obj = var12;
            } else {
               var14.what = 1;
               var14.arg1 = var2 + 1;
               var14.obj = var12;
               ((Goal)AdTrackerNetworkInterface.f().get(var14.arg1)).state = Goal$State.ENQUEUE_REQUESTED;
            }

            AdTrackerNetworkInterface.a(0);
            this.sendMessage(var14);
            return;
         }
         break;
      case 9:
         Log.internal("[InMobi]-[AdTracker]-4.5.2", "Reporting message goal timed out...");
         var9 = (Goal)AdTrackerNetworkInterface.f().get(var1.arg1);
         var9.state = Goal$State.REPORTING_TIMED_OUT;
         AdTrackerUtils.reportMetric(AdTrackerEventType.GOAL_FAILURE, var9, 0, 0L, 408, (String)null);
         AdTrackerNetworkInterface.j().deinit(c);
         AdTrackerNetworkInterface.f().increaseRetryTime(var9.name, var9.count, var9.isDuplicate);
         var14 = Message.obtain();
         var14.what = 1;
         var14.arg1 = var1.arg1;
         var14.obj = (String)var1.obj;
         this.sendMessage(var14);
         return;
      case 10:
         Log.internal("[InMobi]-[AdTracker]-4.5.2", "Message report goal failed...");
         var9 = (Goal)var1.obj;
         if(Goal$State.REPORTING_REQUESTED == var9.state) {
            var9.state = Goal$State.REPORTING_FAILED;
            var10 = AdTrackerNetworkInterface.f().iterator();

            for(var2 = 0; var10.hasNext() && !((Goal)var10.next()).equals(var9); ++var2) {
               ;
            }

            var15 = Message.obtain();
            var15.arg1 = var2;
            var15.obj = var1.getData().getString("appId");
            if(6001 == var1.arg2) {
               var15.what = 7;
            } else {
               AdTrackerUtils.reportMetric(AdTrackerEventType.GOAL_FAILURE, var9, 1, 0L, var1.arg2, (String)null);
               AdTrackerNetworkInterface.f().increaseRetryTime(var9.name, var9.count, var9.isDuplicate);
               if(var9.retryTime > 0L) {
                  Log.debug("[InMobi]-[AdTracker]-4.5.2", "Retrying goalname: " + var9 + " after " + var9.retryTime / 1000L + " second");
               }

               var15.what = 1;
            }

            this.sendMessage(var15);
            return;
         }
         break;
      case 11:
         Log.internal("[InMobi]-[AdTracker]-4.5.2", "No more goals to report ...");
         AdTrackerNetworkInterface.f().clear();
         AdTrackerNetworkInterface.f().saveGoals();
         AdTrackerNetworkInterface.l().sendEmptyMessage(1);
         return;
      case 12:
         Log.internal("[InMobi]-[AdTracker]-4.5.2", "Message report goal aborted...");
         AdTrackerNetworkInterface.a(1);
         if(AdTrackerNetworkInterface.f() != null && !AdTrackerNetworkInterface.f().isEmpty()) {
            Iterator var11 = AdTrackerNetworkInterface.f().iterator();

            while(var11.hasNext()) {
               var9 = (Goal)var11.next();
               if(Goal$State.REPORTING_COMPLETED == var9.state) {
                  var11.remove();
               }
            }

            AdTrackerNetworkInterface.f().saveGoals();
         }

         AdTrackerNetworkInterface.a((GoalList)null);
         AdTrackerNetworkInterface.l().sendEmptyMessage(1);
         return;
      default:
         Log.internal("[InMobi]-[AdTracker]-4.5.2", "Enqueuing message goal ...");
         var9 = (Goal)AdTrackerNetworkInterface.f().get(var1.arg1);
         if(InternalSDKUtil.checkNetworkAvailibility(InternalSDKUtil.getContext())) {
            boolean var4;
            label141: {
               AdTrackerNetworkInterface.f().saveGoals();
               AdTrackerNetworkInterface.a(AdTrackerInitializer.getLogger().startNewSample());
               if(Goal$State.ENQUEUE_REQUESTED == var9.state) {
                  if(var1.arg1 == 0) {
                     var4 = true;
                     break label141;
                  }

                  var16 = (Goal)AdTrackerNetworkInterface.f().get(var1.arg1 - 1);
                  if(Goal$State.REPORTING_COMPLETED == var16.state) {
                     var4 = true;
                     break label141;
                  }
               }

               var4 = false;
            }

            var9.state = Goal$State.ENQUEUE_SUCCEEDED;
            Log.debug("[InMobi]-[AdTracker]-4.5.2", "Goal " + var9.name + " enqueued successfully for reporting");
            var5 = AdTrackerNetworkInterface.a(var9, var4);
            var2 = AdTrackerInitializer.getConfigParams().getReferrerWaitTimeRetryCount();
            var14 = Message.obtain();
            var14.what = 2;
            var14.arg1 = var1.arg1;
            var14.arg2 = var2 + 1;
            var14.obj = (String)var1.obj;
            this.sendMessageDelayed(var14, var5);
            return;
         }

         var9.state = Goal$State.ENQUEUE_PENDING;
         Log.debug("[InMobi]-[AdTracker]-4.5.2", "Network Unavailable. Aborting attempt to report goal ...");
         this.sendEmptyMessage(12);
      }

   }
}
