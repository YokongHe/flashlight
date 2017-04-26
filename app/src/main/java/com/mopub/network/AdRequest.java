package com.mopub.network;

import android.text.TextUtils;
import com.mopub.common.AdFormat;
import com.mopub.common.util.Json;
import com.mopub.common.util.ResponseHeader;
import com.mopub.mobileads.AdTypeTranslator;
import com.mopub.network.AdRequest$Listener;
import com.mopub.network.AdResponse;
import com.mopub.network.AdResponse$Builder;
import com.mopub.network.HeaderUtils;
import com.mopub.network.MoPubNetworkError;
import com.mopub.network.MoPubNetworkError$Reason;
import com.mopub.volley.DefaultRetryPolicy;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.Request;
import com.mopub.volley.Response;
import com.mopub.volley.toolbox.HttpHeaderParser;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;

public class AdRequest extends Request {
   private final AdFormat mAdFormat;
   private final AdRequest$Listener mListener;

   public AdRequest(String var1, AdFormat var2, AdRequest$Listener var3) {
      super(0, var1, var3);
      this.mListener = var3;
      this.mAdFormat = var2;
      this.setRetryPolicy(new DefaultRetryPolicy(2500, 1, 1.0F));
      this.setShouldCache(false);
   }

   private boolean eventDataIsInResponseBody(String var1, String var2) {
      return "mraid".equals(var1) || "html".equals(var1) || "interstitial".equals(var1) && "vast".equals(var2);
   }

   protected void deliverResponse(AdResponse var1) {
      this.mListener.onSuccess(var1);
   }

   protected Response parseNetworkResponse(NetworkResponse var1) {
      String var4 = null;
      Map var10 = var1.headers;
      if(HeaderUtils.extractBooleanHeader(var10, ResponseHeader.WARMUP, false)) {
         return Response.error(new MoPubNetworkError("Ad Unit is warming up.", MoPubNetworkError$Reason.WARMING_UP));
      } else {
         AdResponse$Builder var5 = new AdResponse$Builder();
         String var8 = HeaderUtils.extractHeader(var10, ResponseHeader.AD_TYPE);
         String var9 = HeaderUtils.extractHeader(var10, ResponseHeader.FULL_AD_TYPE);
         var5.setAdType(var8);
         var5.setFullAdType(var9);
         if("clear".equals(var8)) {
            return Response.error(new MoPubNetworkError("No ads found for ad unit.", MoPubNetworkError$Reason.NO_FILL));
         } else {
            var5.setNetworkType(HeaderUtils.extractHeader(var10, ResponseHeader.NETWORK_TYPE));
            String var6 = HeaderUtils.extractHeader(var10, ResponseHeader.REDIRECT_URL);
            var5.setRedirectUrl(var6);
            String var7 = HeaderUtils.extractHeader(var10, ResponseHeader.CLICK_TRACKING_URL);
            var5.setClickTrackingUrl(var7);
            var5.setImpressionTrackingUrl(HeaderUtils.extractHeader(var10, ResponseHeader.IMPRESSION_URL));
            var5.setFailoverUrl(HeaderUtils.extractHeader(var10, ResponseHeader.FAIL_URL));
            boolean var2 = HeaderUtils.extractBooleanHeader(var10, ResponseHeader.SCROLLABLE, false);
            var5.setScrollable(Boolean.valueOf(var2));
            var5.setDimensions(HeaderUtils.extractIntegerHeader(var10, ResponseHeader.WIDTH), HeaderUtils.extractIntegerHeader(var10, ResponseHeader.HEIGHT));
            Integer var3 = HeaderUtils.extractIntegerHeader(var10, ResponseHeader.AD_TIMEOUT);
            if(var3 == null) {
               var3 = null;
            } else {
               var3 = Integer.valueOf(var3.intValue() * 1000);
            }

            var5.setAdTimeoutDelayMilliseconds(var3);
            var3 = HeaderUtils.extractIntegerHeader(var10, ResponseHeader.REFRESH_TIME);
            if(var3 == null) {
               var3 = var4;
            } else {
               var3 = Integer.valueOf(var3.intValue() * 1000);
            }

            var5.setRefreshTimeMilliseconds(var3);
            String var11 = this.parseStringBody(var1);
            var5.setResponseBody(var11);
            if("json".equals(var8)) {
               try {
                  var5.setJsonBody(new JSONObject(var11));
               } catch (JSONException var13) {
                  return Response.error(new MoPubNetworkError("Failed to decode body JSON for native ad format", var13, MoPubNetworkError$Reason.BAD_BODY));
               }
            }

            var5.setCustomEventClassName(AdTypeTranslator.getCustomEventName(this.mAdFormat, var8, var9, var10));
            var4 = HeaderUtils.extractHeader(var10, ResponseHeader.CUSTOM_EVENT_DATA);
            String var14 = var4;
            if(TextUtils.isEmpty(var4)) {
               var14 = HeaderUtils.extractHeader(var10, ResponseHeader.NATIVE_PARAMS);
            }

            try {
               var5.setServerExtras(Json.jsonStringToMap(var14));
            } catch (JSONException var12) {
               return Response.error(new MoPubNetworkError("Failed to decode server extras for custom event data.", var12, MoPubNetworkError$Reason.BAD_HEADER_DATA));
            }

            if(this.eventDataIsInResponseBody(var8, var9)) {
               TreeMap var15 = new TreeMap();
               var15.put("Html-Response-Body", var11);
               var15.put("Scrollable", Boolean.toString(var2));
               if(var6 != null) {
                  var15.put("Redirect-Url", var6);
               }

               if(var7 != null) {
                  var15.put("Clickthrough-Url", var7);
               }

               var5.setServerExtras(var15);
            }

            return Response.success(var5.build(), HttpHeaderParser.parseCacheHeaders(var1));
         }
      }
   }

   protected String parseStringBody(NetworkResponse var1) {
      try {
         String var2 = new String(var1.data, HttpHeaderParser.parseCharset(var1.headers));
         return var2;
      } catch (UnsupportedEncodingException var3) {
         return new String(var1.data);
      }
   }
}
