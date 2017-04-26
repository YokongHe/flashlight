package com.mopub.nativeads;

import com.mopub.nativeads.NativeErrorCode;

public interface CustomEventNative$ImageListener {
   void onImagesCached();

   void onImagesFailedToCache(NativeErrorCode var1);
}
