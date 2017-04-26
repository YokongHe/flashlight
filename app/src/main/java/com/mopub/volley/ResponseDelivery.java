package com.mopub.volley;

import com.mopub.volley.Request;
import com.mopub.volley.Response;
import com.mopub.volley.VolleyError;

public interface ResponseDelivery {
   void postError(Request var1, VolleyError var2);

   void postResponse(Request var1, Response var2);

   void postResponse(Request var1, Response var2, Runnable var3);
}
