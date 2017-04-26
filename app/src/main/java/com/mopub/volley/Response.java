package com.mopub.volley;

import com.mopub.volley.Cache$Entry;
import com.mopub.volley.VolleyError;

public class Response {
   public final Cache$Entry cacheEntry;
   public final VolleyError error;
   public boolean intermediate = false;
   public final Object result;

   private Response(VolleyError var1) {
      this.result = null;
      this.cacheEntry = null;
      this.error = var1;
   }

   private Response(Object var1, Cache$Entry var2) {
      this.result = var1;
      this.cacheEntry = var2;
      this.error = null;
   }

   public static Response error(VolleyError var0) {
      return new Response(var0);
   }

   public static Response success(Object var0, Cache$Entry var1) {
      return new Response(var0, var1);
   }

   public boolean isSuccess() {
      return this.error == null;
   }
}
