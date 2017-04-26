package com.inmobi.commons.analytics.bootstrapper;

import android.content.Context;
import com.inmobi.commons.InMobi;
import com.inmobi.commons.analytics.bootstrapper.AnalyticsConfigParams;
import com.inmobi.commons.cache.CacheController;
import com.inmobi.commons.cache.CacheController$Validator;
import com.inmobi.commons.cache.ProductConfig;
import com.inmobi.commons.internal.CommonsException;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.internal.ThinICE;
import com.inmobi.commons.uid.UID;
import java.util.HashMap;
import java.util.Map;

public class AnalyticsInitializer {
   public static final String PRODUCT_ANALYTICS = "ltvp";
   private static Context a = null;
   private static Map b = new HashMap();
   private static AnalyticsConfigParams c = new AnalyticsConfigParams();
   private static CacheController$Validator d = new CacheController$Validator() {
      public final boolean validate(Map var1) {
         return AnalyticsInitializer.b(var1);
      }
   };

   private static void a(Context var0) {
      if(var0 != null && a == null) {
         if(a == null) {
            a = var0.getApplicationContext();
            b = getUidMap(var0);

            try {
               ProductConfig var3 = CacheController.getConfig("ltvp", var0, b, d);
               if(var3.getRawData() != null) {
                  b(var3.getData());
                  return;
               }
            } catch (CommonsException var1) {
               Log.internal("[InMobi]-[Analytics]-4.5.2", "Exception while retreiving configs due to commons Exception with code " + var1.getCode());
               return;
            } catch (Exception var2) {
               Log.internal("[InMobi]-[Analytics]-4.5.2", "Exception while retreiving configs.", var2);
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
      b = getUidMap(a);

      try {
         CacheController.getConfig("ltvp", var0, b, d);
      } catch (Exception var1) {
         ;
      }
   }

   private static boolean b(Map var0) {
      AnalyticsConfigParams var1 = new AnalyticsConfigParams();

      try {
         var1.setFromMap((Map)var0.get("common"));
         c = var1;
         ThinICE.setConfig(var1.getThinIceConfig());
         return true;
      } catch (Exception var2) {
         Log.internal("[InMobi]-[Analytics]-4.5.2", "Exception while saving configs.", var2);
         return false;
      }
   }

   public static AnalyticsConfigParams getConfigParams() {
      if(InternalSDKUtil.getContext() != null && InMobi.getAppId() != null) {
         b(InternalSDKUtil.getContext());
      }

      return c;
   }

   public static AnalyticsConfigParams getRawConfigParams() {
      return c;
   }

   public static Map getUidMap(Context var0) {
      return UID.getInstance().getMapForEncryption((Map)null);
   }
}
