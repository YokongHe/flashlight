package com.mopub.mobileads.factories;

import com.mopub.common.AdReport;
import com.mopub.mobileads.CustomEventBannerAdapter;
import com.mopub.mobileads.MoPubView;
import java.util.Map;

public class CustomEventBannerAdapterFactory {
   protected static CustomEventBannerAdapterFactory instance = new CustomEventBannerAdapterFactory();

   public static CustomEventBannerAdapter create(MoPubView var0, String var1, Map var2, long var3, AdReport var5) {
      return instance.internalCreate(var0, var1, var2, var3, var5);
   }

   @Deprecated
   public static void setInstance(CustomEventBannerAdapterFactory var0) {
      instance = var0;
   }

   protected CustomEventBannerAdapter internalCreate(MoPubView var1, String var2, Map var3, long var4, AdReport var6) {
      return new CustomEventBannerAdapter(var1, var2, var3, var4, var6);
   }
}
