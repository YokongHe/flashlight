package com.mopub.nativeads;

import com.mopub.nativeads.NativeAdInterface;
import com.mopub.nativeads.NativeErrorCode;

public interface CustomEventNative$CustomEventNativeListener {
   void onNativeAdFailed(NativeErrorCode var1);

   void onNativeAdLoaded(NativeAdInterface var1);
}
