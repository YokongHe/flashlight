package com.inmobi.commons.analytics.events;

import android.content.Intent;
import android.os.Bundle;
import com.inmobi.commons.InMobi;
import com.inmobi.commons.analytics.db.AnalyticsEventsQueue;
import com.inmobi.commons.analytics.db.FunctionSetUserAttribute;
import com.inmobi.commons.analytics.net.AnalyticsNetworkManager;
import com.inmobi.commons.analytics.util.AnalyticsUtils;
import com.inmobi.commons.analytics.util.SessionInfo;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import java.util.Map;

public final class AnalyticsEventsWrapper {
   private static AnalyticsEventsWrapper a;
   private static boolean c = false;
   private AnalyticsEventsQueue b;

   private void a(String var1) {
      Log.debug("[InMobi]-[Analytics]-4.5.2", "IllegalArgumentError: " + var1);
   }

   private boolean a() {
      if(InternalSDKUtil.getContext() != null && SessionInfo.getSessionId(InternalSDKUtil.getContext()) == null) {
         this.startSession(InMobi.getAppId(), (Map)null);
      } else if(SessionInfo.getSessionId(InternalSDKUtil.getContext()) == null) {
         Log.internal("[InMobi]-[Analytics]-4.5.2", "Please call InMobi.initialize or startSession before calling any events API");
         return false;
      }

      return true;
   }

   public static AnalyticsEventsWrapper getInstance() {
      synchronized(AnalyticsEventsWrapper.class){}

      AnalyticsEventsWrapper var0;
      try {
         if(AnalyticsUtils.getWebviewUserAgent() == null) {
            AnalyticsUtils.setWebviewUserAgent(InternalSDKUtil.getUserAgent());
         }

         if(a == null) {
            a = new AnalyticsEventsWrapper();
            AnalyticsUtils.setStartHandle(false);
            AnalyticsNetworkManager.startInstance();
         }

         a.b = AnalyticsEventsQueue.getInstance();
         var0 = a;
      } finally {
         ;
      }

      return var0;
   }

   public static boolean isEventsUser() {
      return c;
   }

   public static void setIsEventsUser() {
      c = true;
   }

   public final void beginSection(int param1, String param2, Map param3) {
      // $FF: Couldn't be decompiled
   }

   public final void endSection(int param1, String param2, Map param3) {
      // $FF: Couldn't be decompiled
   }

   public final void endSession(Map param1) {
      // $FF: Couldn't be decompiled
   }

   public final void setUserAttribute(String var1, String var2) {
      if(var1 != null && !var1.trim().equals("") && var2 != null && !var2.trim().equals("")) {
         if(var1.length() > 15 || var2.length() > 20) {
            this.a("attribute name cannot exceed 15 chars and attribute val cannot exceed 20 chars. Please pass a valid attribute");
            return;
         }

         try {
            if(this.a()) {
               FunctionSetUserAttribute var4 = new FunctionSetUserAttribute(InternalSDKUtil.getContext(), var1, var2);
               this.b.addElement(var4);
               this.b.processFunctions();
               return;
            }
         } catch (Exception var3) {
            Log.internal("[InMobi]-[Analytics]-4.5.2", "Set User Attribute Exception", var3);
            return;
         }
      } else {
         this.a("arguments cannot be null or empty");
      }

   }

   public final void startSession(String param1, Map param2) {
      // $FF: Couldn't be decompiled
   }

   public final void tagEvent(String param1, Map param2) {
      // $FF: Couldn't be decompiled
   }

   public final void tagTransactionManually(Intent param1, Bundle param2) {
      // $FF: Couldn't be decompiled
   }
}
