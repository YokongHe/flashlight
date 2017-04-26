package com.inmobi.monetization.internal.objects;

import android.content.Context;
import android.util.Base64;
import com.inmobi.commons.ads.cache.AdData;
import com.inmobi.commons.ads.cache.AdDatabaseManager;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.monetization.internal.NativeAdObject;
import com.inmobi.monetization.internal.configs.Initializer;
import java.util.List;
import org.json.JSONObject;

public class NativeAdsCache {
   static NativeAdsCache a;

   private NativeAdsCache(Context var1) {
   }

   public static NativeAdsCache getInstance() {
      if(a == null) {
         synchronized(NativeAdsCache.class) {
            a = new NativeAdsCache(InternalSDKUtil.getContext());
         }
      }

      AdDatabaseManager.getInstance().setDBLimit(Initializer.getConfigParams().getNativeSdkConfigParams().getmMaxCacheSize());
      return a;
   }

   public NativeAdObject getCachedAd(String var1) {
      try {
         JSONObject var3 = new JSONObject(AdDatabaseManager.getInstance().getAd(var1).getContent());
         NativeAdObject var4 = new NativeAdObject((new String(Base64.decode(var3.getString("pubContent"), 0))).trim(), var3.getString("contextCode"), var3.getString("namespace"));
         return var4;
      } catch (Exception var2) {
         Log.internal("[InMobi]-[Monetization]", "Exception getting cached ad", var2);
         return null;
      }
   }

   public int getNumCachedAds(String var1) {
      try {
         int var2 = AdDatabaseManager.getInstance().getNoOfAds(var1);
         return var2;
      } catch (Exception var3) {
         return 0;
      }
   }

   public void removeExpiredAds() {
      long var1 = Initializer.getConfigParams().getNativeSdkConfigParams().getTimeToLive();
      AdDatabaseManager.getInstance().removeExpiredAds(var1, "native");
   }

   public void saveNativeAds(String var1, List var2) {
      if(var2 != null && var2.size() > 0) {
         for(int var3 = 0; var3 < var2.size(); ++var3) {
            AdData var4 = new AdData();
            var4.setContent((String)var2.get(var3));
            var4.setTimestamp(System.currentTimeMillis());
            var4.setAppId(var1);
            var4.setAdType("native");
            AdDatabaseManager.getInstance().insertAd(var4);
         }
      }

   }
}
