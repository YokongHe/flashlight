package com.mopub.network;

import android.content.Context;
import android.text.TextUtils;
import com.mopub.common.event.MoPubEvents$Type;
import com.mopub.common.logging.MoPubLog;
import com.mopub.network.MoPubNetworkError;
import com.mopub.network.MoPubNetworkError$Reason;
import com.mopub.network.Networking;
import com.mopub.network.TrackingRequest$Listener;
import com.mopub.volley.DefaultRetryPolicy;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.Request;
import com.mopub.volley.RequestQueue;
import com.mopub.volley.Response;
import com.mopub.volley.VolleyError;
import com.mopub.volley.toolbox.HttpHeaderParser;
import java.util.Arrays;
import java.util.Iterator;

public class TrackingRequest extends Request {
   private final TrackingRequest$Listener mListener;

   private TrackingRequest(String var1, TrackingRequest$Listener var2) {
      super(0, var1, var2);
      this.mListener = var2;
      this.setShouldCache(false);
      this.setRetryPolicy(new DefaultRetryPolicy(2500, 1, 1.0F));
   }

   public static void makeTrackingHttpRequest(Iterable var0, Context var1) {
      makeTrackingHttpRequest((Iterable)var0, var1, (TrackingRequest$Listener)null, (MoPubEvents$Type)null);
   }

   public static void makeTrackingHttpRequest(Iterable var0, Context var1, MoPubEvents$Type var2) {
      makeTrackingHttpRequest((Iterable)var0, var1, (TrackingRequest$Listener)null, var2);
   }

   public static void makeTrackingHttpRequest(Iterable var0, Context var1, final TrackingRequest$Listener var2, MoPubEvents$Type var3) {
      if(var0 != null && var1 != null) {
         RequestQueue var5 = Networking.getRequestQueue(var1);
         Iterator var4 = var0.iterator();

         while(var4.hasNext()) {
            final String var6 = (String)var4.next();
            if(!TextUtils.isEmpty(var6)) {
               var5.add(new TrackingRequest(var6, new TrackingRequest$Listener() {
                  public void onErrorResponse(VolleyError var1) {
                     MoPubLog.d("Failed to hit tracking endpoint: " + var6);
                     if(var2 != null) {
                        var2.onErrorResponse(var1);
                     }

                  }

                  public void onResponse() {
                     MoPubLog.d("Successfully hit tracking endpoint: " + var6);
                     if(var2 != null) {
                        var2.onResponse();
                     }

                  }
               }));
            }
         }
      }

   }

   public static void makeTrackingHttpRequest(String var0, Context var1) {
      makeTrackingHttpRequest((String)var0, var1, (TrackingRequest$Listener)null, (MoPubEvents$Type)null);
   }

   public static void makeTrackingHttpRequest(String var0, Context var1, MoPubEvents$Type var2) {
      makeTrackingHttpRequest((String)var0, var1, (TrackingRequest$Listener)null, var2);
   }

   public static void makeTrackingHttpRequest(String var0, Context var1, TrackingRequest$Listener var2) {
      makeTrackingHttpRequest((String)var0, var1, var2, (MoPubEvents$Type)null);
   }

   public static void makeTrackingHttpRequest(String var0, Context var1, TrackingRequest$Listener var2, MoPubEvents$Type var3) {
      makeTrackingHttpRequest((Iterable)Arrays.asList(new String[]{var0}), var1, var2, var3);
   }

   public void deliverResponse(Void var1) {
      if(this.mListener != null) {
         this.mListener.onResponse();
      }

   }

   protected Response parseNetworkResponse(NetworkResponse var1) {
      return var1.statusCode != 200?Response.error(new MoPubNetworkError("Failed to log tracking request. Response code: " + var1.statusCode + " for url: " + this.getUrl(), MoPubNetworkError$Reason.TRACKING_FAILURE)):Response.success((Object)null, HttpHeaderParser.parseCacheHeaders(var1));
   }
}
