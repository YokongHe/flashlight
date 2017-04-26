package com.flurry.android.impl.ads.avro.protocol.v10;

import com.flurry.android.impl.ads.avro.protocol.v10.SdkAdLogResponse;
import com.flurry.sdk.fm;

public interface SdkAdLogResponse$Callback extends SdkAdLogResponse {
   fm b;

   static default {
      b = SdkAdLogResponse.a;
   }
}
