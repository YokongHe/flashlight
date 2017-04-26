package com.inmobi.commons.analytics.net;

public interface AnalyticsCommon$HttpRequestCallback {
   int HTTP_FAILURE = 1;
   int HTTP_SUCCESS = 0;

   void notifyResult(int var1, Object var2);
}
