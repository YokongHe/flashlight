package com.mopub.nativeads;

import com.mopub.nativeads.NativeErrorCode;
import com.mopub.nativeads.NativeResponse;

public interface MoPubNative$MoPubNativeNetworkListener {
   void onNativeFail(NativeErrorCode var1);

   void onNativeLoad(NativeResponse var1);
}
