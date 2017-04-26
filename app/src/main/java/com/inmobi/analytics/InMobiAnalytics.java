package com.inmobi.analytics;

import android.content.Intent;
import android.os.Bundle;
import com.inmobi.commons.InMobi;
import com.inmobi.commons.analytics.androidsdk.IMAdTracker;
import com.inmobi.commons.analytics.events.AnalyticsEventsWrapper;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import java.util.Map;

public class InMobiAnalytics {
   public static void beginSection(String var0) {
      beginSection(var0, (Map)null);
   }

   public static void beginSection(String var0, Map var1) {
      if(InternalSDKUtil.isInitializedSuccessfully()) {
         try {
            int var2 = var0.hashCode();
            AnalyticsEventsWrapper.getInstance().beginSection(var2, var0, var1);
            AnalyticsEventsWrapper.setIsEventsUser();
         } catch (Exception var3) {
            Log.debug("[InMobi]-[Analytics]-4.5.2", "Please pass a valid Section Name");
         }
      }
   }

   public static void endSection(String var0) {
      endSection(var0, (Map)null);
   }

   public static void endSection(String var0, Map var1) {
      if(InternalSDKUtil.isInitializedSuccessfully()) {
         try {
            int var2 = var0.hashCode();
            AnalyticsEventsWrapper.getInstance().endSection(var2, var0, var1);
            AnalyticsEventsWrapper.setIsEventsUser();
         } catch (Exception var3) {
            Log.debug("[InMobi]-[Analytics]-4.5.2", "Please pass a valid Section Name");
         }
      }
   }

   public static void endSessionManually() {
      endSessionManually((Map)null);
   }

   public static void endSessionManually(Map var0) {
      if(InternalSDKUtil.isInitializedSuccessfully()) {
         AnalyticsEventsWrapper.getInstance().endSession(var0);
         AnalyticsEventsWrapper.setIsEventsUser();
      }
   }

   public static void reportCustomGoal(String var0) {
      if(InternalSDKUtil.isInitializedSuccessfully()) {
         try {
            IMAdTracker.getInstance().reportCustomGoal(var0);
         } catch (Exception var1) {
            Log.internal("[InMobi]-[Analytics]-4.5.2", "Unable to report custom goal due to unexpected exception.", var1);
         }
      }
   }

   public static void setUserAttribute(String var0, String var1) {
      try {
         if(InternalSDKUtil.isInitializedSuccessfully()) {
            AnalyticsEventsWrapper.getInstance().setUserAttribute(var0, var1);
            AnalyticsEventsWrapper.setIsEventsUser();
         }
      } catch (Exception var2) {
         Log.internal("[InMobi]-[Analytics]-4.5.2", "Unable to set user attribute unexpected exception.", var2);
      }
   }

   public static void startSessionManually() {
      startSessionManually((Map)null);
   }

   public static void startSessionManually(Map var0) {
      if(InternalSDKUtil.isInitializedSuccessfully()) {
         AnalyticsEventsWrapper.getInstance().startSession(InMobi.getAppId(), var0);
         AnalyticsEventsWrapper.setIsEventsUser();
      }
   }

   public static void tagEvent(String var0) {
      tagEvent(var0, (Map)null);
   }

   public static void tagEvent(String var0, Map var1) {
      if(InternalSDKUtil.isInitializedSuccessfully()) {
         try {
            AnalyticsEventsWrapper.getInstance().tagEvent(var0, var1);
            AnalyticsEventsWrapper.setIsEventsUser();
         } catch (Exception var2) {
            Log.internal("[InMobi]-[Analytics]-4.5.2", "Unable to tag event due to unexpected exception.", var2);
         }
      }
   }

   public static void tagTransactionManually(Intent var0, Bundle var1) {
      if(InternalSDKUtil.isInitializedSuccessfully()) {
         try {
            AnalyticsEventsWrapper.getInstance().tagTransactionManually(var0, var1);
            AnalyticsEventsWrapper.setIsEventsUser();
         } catch (Exception var2) {
            Log.internal("[InMobi]-[Analytics]-4.5.2", "Unable to tag transaction due to unexpected exception.", var2);
         }
      }
   }
}
