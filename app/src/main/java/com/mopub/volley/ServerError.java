package com.mopub.volley;

import com.mopub.volley.NetworkResponse;
import com.mopub.volley.VolleyError;

public class ServerError extends VolleyError {
   public ServerError() {
   }

   public ServerError(NetworkResponse var1) {
      super(var1);
   }
}
