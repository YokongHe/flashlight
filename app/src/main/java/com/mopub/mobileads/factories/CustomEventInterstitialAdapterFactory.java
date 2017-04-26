package com.mopub.mobileads.factories;

import com.mopub.common.AdReport;
import com.mopub.mobileads.CustomEventInterstitialAdapter;
import com.mopub.mobileads.MoPubInterstitial;
import java.util.Map;

public class CustomEventInterstitialAdapterFactory {
   protected static CustomEventInterstitialAdapterFactory instance = new CustomEventInterstitialAdapterFactory();

   public static CustomEventInterstitialAdapter create(MoPubInterstitial var0, String var1, Map var2, long var3, AdReport var5) {
      return instance.internalCreate(var0, var1, var2, var3, var5);
   }

   @Deprecated
   public static void setInstance(CustomEventInterstitialAdapterFactory var0) {
      instance = var0;
   }

   protected CustomEventInterstitialAdapter internalCreate(MoPubInterstitial var1, String var2, Map var3, long var4, AdReport var6) {
      return new CustomEventInterstitialAdapter(var1, var2, var3, var4, var6);
   }
}
