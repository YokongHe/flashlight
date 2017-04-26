package com.inmobi.commons.analytics.net;

import android.os.Handler;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsInitializer;
import com.inmobi.commons.analytics.db.AnalyticsDatabaseManager;
import com.inmobi.commons.analytics.net.AnalyticsCommon;
import com.inmobi.commons.analytics.net.AnalyticsConnectivityReceiver;
import com.inmobi.commons.analytics.net.AnalyticsConnectivityReceiver$a;
import com.inmobi.commons.analytics.net.AnalyticsNetworkManager$a;
import com.inmobi.commons.analytics.net.AnalyticsPayload;
import com.inmobi.commons.analytics.net.AnalyticsPayloadBuilder;
import com.inmobi.commons.analytics.util.AnalyticsUtils;
import com.inmobi.commons.analytics.util.SessionInfo;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.uid.UID;
import java.util.Map;

public final class AnalyticsNetworkManager {
   public static final int MESSAGE_PING = 1001;
   private static Handler a;
   private static AnalyticsNetworkManager b;
   private static AnalyticsConnectivityReceiver$a f = new AnalyticsConnectivityReceiver$a() {
      public final void a() {
         Log.internal("[InMobi]-[Analytics]-4.5.2", "Connectivity came");
         if(AnalyticsNetworkManager.a != null && !AnalyticsUtils.getStartHandle()) {
            AnalyticsUtils.setStartHandle(true);
            AnalyticsNetworkManager.a.sendEmptyMessageDelayed(1001, AnalyticsUtils.getTimeinterval());
         }

      }

      public final void b() {
         Log.internal("[InMobi]-[Analytics]-4.5.2", "Connectivity gone");
      }
   };
   private AnalyticsPayloadBuilder c;
   private AnalyticsConnectivityReceiver d;
   private int e = 0;

   private AnalyticsNetworkManager() {
      (new AnalyticsNetworkManager$a(this)).start();
      Log.debug("[InMobi]-[Analytics]-4.5.2", "NetworkManager-> Constructor ");
   }

   // $FF: synthetic method
   static Handler a(Handler var0) {
      a = var0;
      return var0;
   }

   private String a(String var1, String var2, boolean var3) {
      StringBuilder var4 = new StringBuilder();
      if(var1 != null) {
         var4.append("payload=");
         var4.append(AnalyticsCommon.getURLEncoded(var1));
      }

      if(var2 != null) {
         var4.append("&mk-siteid=");
         var4.append(var2);
      }

      var4.append("&c=");
      if(var3) {
         var4.append(1);
      } else {
         var4.append(0);
      }

      Map var5 = AnalyticsInitializer.getConfigParams().getDeviceIdMaskMap();
      var1 = InternalSDKUtil.encodeMapAndconvertToDelimitedString(UID.getInstance().getMapForEncryption(var5), "&");
      var4.append("&");
      var4.append(var1);
      var1 = "pr-SAND-" + InternalSDKUtil.getInMobiInternalVersion("4.5.2") + "-20141120";
      var4.append("&mk-version=");
      var4.append(var1);
      var4.append("&u-id-adt=");
      if(UID.getInstance().isLimitAdTrackingEnabled()) {
         var4.append(1);
      } else {
         var4.append(0);
      }

      return var4.toString();
   }

   // $FF: synthetic method
   static void a(AnalyticsNetworkManager var0) {
      var0.b();
   }

   private void a(AnalyticsPayload param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   private void b() {
      boolean var2 = true;
      boolean var1 = var2;
      if(this.d != null) {
         var1 = var2;
         if(this.d.isConnected()) {
            var1 = var2;
            if(this.c != null) {
               AnalyticsPayload var3 = this.c.getPayloadList(AnalyticsDatabaseManager.getInstance().getEvents(), InternalSDKUtil.getContext());
               var1 = var2;
               if(var3.getCompletePayload() != null) {
                  this.a(var3, SessionInfo.getAppId(InternalSDKUtil.getContext()));
                  var1 = false;
               }
            }
         }
      }

      if(!var1) {
         a.sendEmptyMessageDelayed(1001, AnalyticsUtils.getTimeinterval());
      } else {
         AnalyticsUtils.setStartHandle(false);
      }
   }

   public static Handler getHandler() {
      return a;
   }

   public static AnalyticsNetworkManager startInstance() {
      synchronized(AnalyticsNetworkManager.class){}

      AnalyticsNetworkManager var0;
      try {
         if(b == null) {
            b = new AnalyticsNetworkManager();
         }

         if(b.c == null) {
            b.c = new AnalyticsPayloadBuilder();
         }

         if(b.d == null) {
            b.d = new AnalyticsConnectivityReceiver(InternalSDKUtil.getContext(), f);
         }

         var0 = b;
      } finally {
         ;
      }

      return var0;
   }
}
