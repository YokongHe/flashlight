package com.flurry.android.impl.ads.avro.protocol.v10;

import com.flurry.android.impl.ads.avro.protocol.v10.AdUnityResponse;
import com.flurry.sdk.fm;

public interface AdUnityResponse$Callback extends AdUnityResponse {
   fm b;

   static default {
      b = AdUnityResponse.a;
   }
}
