package com.mopub.common;

import android.content.Context;
import com.mopub.common.ClientMetadata;
import com.mopub.common.GpsHelper$AdvertisingInfo;
import com.mopub.common.GpsHelper$FetchAdvertisingInfoTask;
import com.mopub.common.GpsHelper$GpsHelperListener;
import com.mopub.common.SharedPreferencesHelper;
import com.mopub.common.factories.MethodBuilderFactory;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.AsyncTasks;
import com.mopub.common.util.Reflection;

public class GpsHelper {
   public static final String ADVERTISING_ID_KEY = "advertisingId";
   public static final int GOOGLE_PLAY_SUCCESS_CODE = 0;
   public static final String IS_LIMIT_AD_TRACKING_ENABLED_KEY = "isLimitAdTrackingEnabled";
   private static String sAdvertisingIdClientClassName = "com.google.android.gms.ads.identifier.AdvertisingIdClient";
   private static String sPlayServicesUtilClassName = "com.google.android.gms.common.GooglePlayServicesUtil";

   // $FF: synthetic method
   static String access$0() {
      return sAdvertisingIdClientClassName;
   }

   public static void fetchAdvertisingInfoAsync(Context var0, GpsHelper$GpsHelperListener var1) {
      boolean var2 = isPlayServicesAvailable(var0);
      if(var2 && !isClientMetadataPopulated(var0)) {
         internalFetchAdvertisingInfoAsync(var0, var1);
      } else {
         if(var1 != null) {
            var1.onFetchAdInfoCompleted();
         }

         if(var2) {
            internalFetchAdvertisingInfoAsync(var0, (GpsHelper$GpsHelperListener)null);
            return;
         }
      }

   }

   public static GpsHelper$AdvertisingInfo fetchAdvertisingInfoSync(Context var0) {
      if(var0 == null) {
         return null;
      } else {
         Object var2;
         try {
            var2 = MethodBuilderFactory.create((Object)null, "getAdvertisingIdInfo").setStatic(Class.forName(sAdvertisingIdClientClassName)).addParam(Context.class, var0).execute();
         } catch (Exception var1) {
            MoPubLog.d("Unable to obtain Google AdvertisingIdClient.Info via reflection.");
            return null;
         }

         return new GpsHelper$AdvertisingInfo(reflectedGetAdvertisingId(var2, (String)null), reflectedIsLimitAdTrackingEnabled(var2, false));
      }
   }

   private static void internalFetchAdvertisingInfoAsync(Context var0, GpsHelper$GpsHelperListener var1) {
      if(!Reflection.classFound(sAdvertisingIdClientClassName)) {
         if(var1 != null) {
            var1.onFetchAdInfoCompleted();
         }
      } else {
         try {
            AsyncTasks.safeExecuteOnExecutor(new GpsHelper$FetchAdvertisingInfoTask(var0, var1), new Void[0]);
            return;
         } catch (Exception var2) {
            MoPubLog.d("Error executing FetchAdvertisingInfoTask", var2);
            if(var1 != null) {
               var1.onFetchAdInfoCompleted();
               return;
            }
         }
      }

   }

   static boolean isClientMetadataPopulated(Context var0) {
      return ClientMetadata.getInstance(var0).isAdvertisingInfoSet();
   }

   public static boolean isLimitAdTrackingEnabled(Context var0) {
      boolean var1 = false;
      if(isPlayServicesAvailable(var0)) {
         var1 = SharedPreferencesHelper.getSharedPreferences(var0).getBoolean("isLimitAdTrackingEnabled", false);
      }

      return var1;
   }

   public static boolean isPlayServicesAvailable(Context param0) {
      // $FF: Couldn't be decompiled
   }

   static String reflectedGetAdvertisingId(Object var0, String var1) {
      try {
         String var3 = (String)MethodBuilderFactory.create(var0, "getId").execute();
         return var3;
      } catch (Exception var2) {
         return var1;
      }
   }

   static boolean reflectedIsLimitAdTrackingEnabled(Object param0, boolean param1) {
      // $FF: Couldn't be decompiled
   }

   @Deprecated
   public static void setClassNamesForTesting() {
      sPlayServicesUtilClassName = "java.lang.Class";
      sAdvertisingIdClientClassName = "java.lang.Class";
   }

   static void updateClientMetadata(Context var0, Object var1) {
      String var3 = reflectedGetAdvertisingId(var1, (String)null);
      boolean var2 = reflectedIsLimitAdTrackingEnabled(var1, false);
      ClientMetadata.getInstance(var0).setAdvertisingInfo(var3, var2);
   }
}
