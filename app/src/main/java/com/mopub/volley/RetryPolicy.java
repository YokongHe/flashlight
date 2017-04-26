package com.mopub.volley;

import com.mopub.volley.VolleyError;

public interface RetryPolicy {
   int getCurrentRetryCount();

   int getCurrentTimeout();

   void retry(VolleyError var1);
}
