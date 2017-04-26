package com.inmobi.monetization.internal.configs;

import android.content.Context;
import com.inmobi.commons.InMobi;
import com.inmobi.commons.cache.CacheController;
import com.inmobi.commons.cache.CacheController$Validator;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.uid.UID;
import com.inmobi.monetization.internal.configs.PkParams;
import java.util.HashMap;
import java.util.Map;

public class PkInitilaizer {
   public static final String PRODUCT_PK = "pk";
   private static Context a = null;
   private static Map b = new HashMap();
   private static PkParams c = new PkParams();
   private static CacheController$Validator d = new CacheController$Validator() {
      public final boolean validate(Map var1) {
         return PkInitilaizer.a(var1);
      }
   };

   private static void a(Context var0) {
      b(var0);

      try {
         CacheController.getConfig("pk", var0, b, d);
      } catch (Exception var1) {
         ;
      }
   }

   static boolean a(Map var0) {
      Log.internal("SK", "Saving config to map");
      b = getUidMap(a);

      try {
         PkParams var1 = new PkParams();
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
               if(CacheController.getConfig("pk", var0, b, d).getData() != null) {
                  a(CacheController.getConfig("pk", var0, b, d).getData());
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

   public static PkParams getConfigParams() {
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
