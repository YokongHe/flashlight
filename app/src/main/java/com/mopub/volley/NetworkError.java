package com.mopub.volley;

import com.mopub.volley.NetworkResponse;
import com.mopub.volley.VolleyError;

public class NetworkError extends VolleyError {
   public NetworkError() {
   }

   public NetworkError(NetworkResponse var1) {
      super(var1);
   }

   public NetworkError(Throwable var1) {
      super(var1);
   }
}
