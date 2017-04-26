package com.mopub.volley;

import com.mopub.volley.NetworkResponse;

public class VolleyError extends Exception {
   public final NetworkResponse networkResponse;

   public VolleyError() {
      this.networkResponse = null;
   }

   public VolleyError(NetworkResponse var1) {
      this.networkResponse = var1;
   }

   public VolleyError(String var1) {
      super(var1);
      this.networkResponse = null;
   }

   public VolleyError(String var1, Throwable var2) {
      super(var1, var2);
      this.networkResponse = null;
   }

   public VolleyError(Throwable var1) {
      super(var1);
      this.networkResponse = null;
   }
}
