package com.mopub.nativeads;

import android.content.Context;
import com.mopub.common.event.ErrorEvent$Builder;
import com.mopub.common.event.MoPubEvents;
import com.mopub.nativeads.CustomEventNative;
import com.mopub.nativeads.CustomEventNative$CustomEventNativeListener;
import com.mopub.nativeads.MoPubCustomEventNative$MoPubForwardingNativeAd;
import com.mopub.nativeads.NativeErrorCode;
import java.util.Map;
import org.json.JSONObject;

public class MoPubCustomEventNative extends CustomEventNative {
   protected void loadNativeAd(Context var1, CustomEventNative$CustomEventNativeListener var2, Map var3, Map var4) {
      Object var7 = var3.get("com_mopub_native_json");
      if(!(var7 instanceof JSONObject)) {
         var2.onNativeAdFailed(NativeErrorCode.INVALID_JSON);
      } else {
         MoPubCustomEventNative$MoPubForwardingNativeAd var6 = new MoPubCustomEventNative$MoPubForwardingNativeAd(var1.getApplicationContext(), (JSONObject)var7, var2);

         try {
            var6.loadAd();
         } catch (IllegalArgumentException var5) {
            var2.onNativeAdFailed(NativeErrorCode.UNSPECIFIED);
            MoPubEvents.log((new ErrorEvent$Builder("", "")).withException(var5).build());
         }
      }
   }
}
