package com.inmobi.commons.analytics.iat.impl.config;

import android.content.Context;
import com.inmobi.commons.InMobi;
import com.inmobi.commons.analytics.iat.impl.config.AdTrackerConfigParams;
import com.inmobi.commons.cache.CacheController;
import com.inmobi.commons.cache.CacheController$Validator;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.metric.Logger;
import com.inmobi.commons.uid.UID;
import java.util.Map;

public class AdTrackerInitializer {
   public static final String PRODUCT_IAT = "iat";
   private static Context a = null;
   private static Map b;
   private static AdTrackerConfigParams c = new AdTrackerConfigParams();
   private static Logger d = new Logger(2, "iat");
   private static CacheController$Validator e = new CacheController$Validator() {
      public final boolean validate(Map var1) {
         return AdTrackerInitializer.b(var1);
      }
   };

   private static void a(Context var0) {
      if(var0 != null && a == null) {
         if(a == null) {
            a = var0.getApplicationContext();
            b = UID.getInstance().getMapForEncryption(getConfigParams().getDeviceIdMaskMap());

            try {
               b(CacheController.getConfig("iat", var0, b, e).getData());
               return;
            } catch (Exception var1) {
               Log.internal("[InMobi]-[AdTracker]-4.5.2", "Exception while retreiving configs.");
               return;
            }
         }
      } else if(a == null && var0 == null) {
         a.getApplicationContext();
         return;
      }

   }

   private static void b(Context var0) {
      a(var0);

      try {
         CacheController.getConfig("iat", var0, b, e);
      } catch (Exception var1) {
         ;
      }
   }

   private static boolean b(Map var0) {
      b = getUidMap(a);
      var0 = InternalSDKUtil.populateToNewMap((Map)var0.get("AND"), (Map)var0.get("common"), true);

      try {
         AdTrackerConfigParams var1 = new AdTrackerConfigParams();
         var1.setFromMap(var0);
         c = var1;
         return true;
      } catch (Exception var2) {
         return false;
      }
   }

   public static AdTrackerConfigParams getConfigParams() {
      if(InternalSDKUtil.getContext() != null && InMobi.getAppId() != null) {
         b(InternalSDKUtil.getContext());
      }

      d.setMetricConfigParams(c.getMetric());
      return c;
   }

   public static Logger getLogger() {
      return d;
   }

   public static Map getUidMap(Context var0) {
      return UID.getInstance().getMapForEncryption(getConfigParams().getDeviceIdMaskMap());
   }
}
