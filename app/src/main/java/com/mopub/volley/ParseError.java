package com.mopub.volley;

import com.mopub.volley.NetworkResponse;
import com.mopub.volley.VolleyError;

public class ParseError extends VolleyError {
   public ParseError() {
   }

   public ParseError(NetworkResponse var1) {
      super(var1);
   }

   public ParseError(Throwable var1) {
      super(var1);
   }
}
