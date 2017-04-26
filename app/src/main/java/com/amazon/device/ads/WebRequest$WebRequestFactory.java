package com.amazon.device.ads;

import com.amazon.device.ads.AndroidTargetUtils;
import com.amazon.device.ads.HttpClientWebRequest;
import com.amazon.device.ads.HttpURLConnectionWebRequest;
import com.amazon.device.ads.WebRequest;

public class WebRequest$WebRequestFactory {
   public WebRequest createWebRequest() {
      return (WebRequest)(AndroidTargetUtils.isAtOrBelowAndroidAPI(7)?new HttpClientWebRequest():new HttpURLConnectionWebRequest());
   }
}
