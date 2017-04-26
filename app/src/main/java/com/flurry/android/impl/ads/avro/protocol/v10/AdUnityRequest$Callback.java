package com.flurry.android.impl.ads.avro.protocol.v10;

import com.flurry.android.impl.ads.avro.protocol.v10.AdUnityRequest;
import com.flurry.sdk.fm;

public interface AdUnityRequest$Callback extends AdUnityRequest {
   fm b;

   static default {
      b = AdUnityRequest.a;
   }
}
