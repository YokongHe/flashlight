package com.inmobi.monetization.internal.carb;

import android.content.Context;
import com.inmobi.commons.InMobi;
import com.inmobi.commons.cache.CacheController;
import com.inmobi.commons.cache.CacheController$Validator;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.uid.UID;
import com.inmobi.monetization.internal.carb.CarbConfigParams;
import java.util.HashMap;
import java.util.Map;

public class CarbInitializer {
   public static final String PRODUCT_CARB = "carb";
   private static Context a = null;
   private static Map b = new HashMap();
   private static CarbConfigParams c = new CarbConfigParams();
   private static CacheController$Validator d = new CacheController$Validator() {
      public final boolean validate(Map var1) {
         return CarbInitializer.a(var1);
      }
   };

   private static void a(Context var0) {
      b(var0);

      try {
         CacheController.getConfig("carb", var0, b, d);
      } catch (Exception var1) {
         ;
      }
   }

   static boolean a(Map var0) {
      Log.internal("CARB", "Saving config to map");
      b = getUidMap(a);

      try {
         var0 = InternalSDKUtil.populateToNewMap((Map)var0.get("AND"), (Map)var0.get("common"), true);
         CarbConfigParams var1 = new CarbConfigParams();
         var1.setFromMap(var0);
         c = var1;
         return true;
      } catch (Exception var2) {
         Log.internal("[InMobi]-[RE]-4.5.2", "Config couldn\'t be parsed", var2);
         return false;
      }
   }

   private static void b(Context var0) {
      if(var0 != null && a == null) {
         if(a == null) {
            a = var0.getApplicationContext();
            b = getUidMap(var0);

            try {
               if(CacheController.getConfig("carb", var0, b, d).getData() != null) {
                  a(CacheController.getConfig("carb", var0, b, d).getData());
                  return;
               }
            } catch (Exception var1) {
               return;
            }
         }
      } else if(a == null && var0 == null) {
         throw new NullPointerException();
      }

   }

   public static CarbConfigParams getConfigParams() {
      if(InternalSDKUtil.getContext() != null && InMobi.getAppId() != null) {
         a(InternalSDKUtil.getContext());
      }

      return c;
   }

   public static Map getUidMap(Context var0) {
      return UID.getInstance().getMapForEncryption((Map)null);
   }

   public static void initialize() {
      getConfigParams();
   }
}
