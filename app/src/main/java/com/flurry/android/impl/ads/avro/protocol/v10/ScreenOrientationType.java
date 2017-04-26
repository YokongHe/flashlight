package com.flurry.android.impl.ads.avro.protocol.v10;

import com.flurry.sdk.fn;
import com.flurry.sdk.fn$q;

public enum ScreenOrientationType {
   public static final fn SCHEMA$;
   a,
   b,
   c;

   static {
      SCHEMA$ = (new fn$q()).a("{\"type\":\"enum\",\"name\":\"ScreenOrientationType\",\"namespace\":\"com.flurry.android.impl.ads.avro.protocol.v10\",\"symbols\":[\"PORTRAIT\",\"LANDSCAPE\",\"UNKNOWN\"]}");
   }
}
