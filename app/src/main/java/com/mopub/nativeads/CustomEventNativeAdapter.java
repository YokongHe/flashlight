package com.mopub.nativeads;

import android.content.Context;
import com.mopub.common.logging.MoPubLog;
import com.mopub.nativeads.CustomEventNative;
import com.mopub.nativeads.CustomEventNative$CustomEventNativeListener;
import com.mopub.nativeads.NativeErrorCode;
import com.mopub.nativeads.factories.CustomEventNativeFactory;
import com.mopub.network.AdResponse;
import java.util.Map;

final class CustomEventNativeAdapter {
   public static void loadNativeAd(Context var0, Map var1, AdResponse var2, CustomEventNative$CustomEventNativeListener var3) {
      String var4 = var2.getCustomEventClassName();

      CustomEventNative var5;
      try {
         var5 = CustomEventNativeFactory.create(var4);
      } catch (Exception var6) {
         MoPubLog.w("Failed to load Custom Event Native class: " + var4);
         var3.onNativeAdFailed(NativeErrorCode.NATIVE_ADAPTER_NOT_FOUND);
         return;
      }

      if(var2.hasJson()) {
         var1.put("com_mopub_native_json", var2.getJsonBody());
      }

      var5.loadNativeAd(var0, var3, var1, var2.getServerExtras());
   }
}
