package com.mopub.volley;

import java.util.Collections;
import java.util.Map;

public class NetworkResponse {
   public final byte[] data;
   public final Map headers;
   public final boolean notModified;
   public final int statusCode;

   public NetworkResponse(int var1, byte[] var2, Map var3, boolean var4) {
      this.statusCode = var1;
      this.data = var2;
      this.headers = var3;
      this.notModified = var4;
   }

   public NetworkResponse(byte[] var1) {
      this(200, var1, Collections.emptyMap(), false);
   }

   public NetworkResponse(byte[] var1, Map var2) {
      this(200, var1, var2, false);
   }
}
