package com.inmobi.monetization.internal.configs;

import android.content.Context;
import com.inmobi.commons.InMobi;
import com.inmobi.commons.cache.CacheController;
import com.inmobi.commons.cache.CacheController$Validator;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.metric.Logger;
import com.inmobi.commons.uid.UID;
import com.inmobi.monetization.internal.configs.ConfigParams;
import java.util.HashMap;
import java.util.Map;

public class Initializer {
   public static final String PRODUCT_ADNETWORK = "adNetwork";
   private static Context a = null;
   private static Map b = new HashMap();
   private static Logger c = new Logger(1, "network");
   private static ConfigParams d = new ConfigParams();
   private static CacheController$Validator e = new CacheController$Validator() {
      public final boolean validate(Map var1) {
         return Initializer.b(var1);
      }
   };

   private static void a(Context var0) {
      if(var0 != null && a == null) {
         if(a == null) {
            a = var0.getApplicationContext();
            b = getUidMap(var0);

            try {
               b(CacheController.getConfig("adNetwork", var0, b, e).getData());
               return;
            } catch (Exception var1) {
               return;
            }
         }
      } else if(a == null && var0 == null) {
         throw new NullPointerException();
      }

   }

   private static void b(Context var0) {
      a(var0);

      try {
         CacheController.getConfig("adNetwork", var0, b, e);
      } catch (Exception var1) {
         ;
      }
   }

   private static boolean b(Map var0) {
      b = getUidMap(a);

      try {
         var0 = InternalSDKUtil.populateToNewMap((Map)var0.get("AND"), (Map)var0.get("common"), true);
         ConfigParams var1 = new ConfigParams();
         var1.setFromMap(var0);
         d = var1;
         c.setMetricConfigParams(var1.getMetric());
         return true;
      } catch (Exception var2) {
         Log.internal("[InMobi]-[Monetization]", "Config couldn\'t be parsed", var2);
         return false;
      }
   }

   public static ConfigParams getConfigParams() {
      if(InternalSDKUtil.getContext() != null && InMobi.getAppId() != null) {
         b(InternalSDKUtil.getContext());
      }

      return d;
   }

   public static Logger getLogger() {
      return c;
   }

   public static Map getUidMap(Context var0) {
      return UID.getInstance().getMapForEncryption(d.getDeviceIdMaskMap());
   }
}
