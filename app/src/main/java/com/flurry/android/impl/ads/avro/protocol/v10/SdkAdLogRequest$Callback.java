package com.flurry.android.impl.ads.avro.protocol.v10;

import com.flurry.android.impl.ads.avro.protocol.v10.SdkAdLogRequest;
import com.flurry.sdk.fm;

public interface SdkAdLogRequest$Callback extends SdkAdLogRequest {
   fm b;

   static default {
      b = SdkAdLogRequest.a;
   }
}
