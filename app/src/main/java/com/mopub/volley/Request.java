package com.mopub.volley;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.mopub.volley.Cache$Entry;
import com.mopub.volley.DefaultRetryPolicy;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.Request$Priority;
import com.mopub.volley.RequestQueue;
import com.mopub.volley.Response;
import com.mopub.volley.Response$ErrorListener;
import com.mopub.volley.RetryPolicy;
import com.mopub.volley.VolleyError;
import com.mopub.volley.VolleyLog;
import com.mopub.volley.VolleyLog$MarkerLog;
import java.util.Collections;
import java.util.Map;

public abstract class Request implements Comparable {
   private static final String DEFAULT_PARAMS_ENCODING = "UTF-8";
   private static final long SLOW_REQUEST_THRESHOLD_MS = 3000L;
   private Cache$Entry mCacheEntry;
   private boolean mCanceled;
   private final int mDefaultTrafficStatsTag;
   private final Response$ErrorListener mErrorListener;
   private final VolleyLog$MarkerLog mEventLog;
   private final int mMethod;
   private long mRequestBirthTime;
   private RequestQueue mRequestQueue;
   private boolean mResponseDelivered;
   private RetryPolicy mRetryPolicy;
   private Integer mSequence;
   private boolean mShouldCache;
   private Object mTag;
   private final String mUrl;

   public Request(int var1, String var2, Response$ErrorListener var3) {
      VolleyLog$MarkerLog var4;
      if(VolleyLog$MarkerLog.ENABLED) {
         var4 = new VolleyLog$MarkerLog();
      } else {
         var4 = null;
      }

      this.mEventLog = var4;
      this.mShouldCache = true;
      this.mCanceled = false;
      this.mResponseDelivered = false;
      this.mRequestBirthTime = 0L;
      this.mCacheEntry = null;
      this.mMethod = var1;
      this.mUrl = var2;
      this.mErrorListener = var3;
      this.setRetryPolicy(new DefaultRetryPolicy());
      this.mDefaultTrafficStatsTag = findDefaultTrafficStatsTag(var2);
   }

   @Deprecated
   public Request(String var1, Response$ErrorListener var2) {
      this(-1, var1, var2);
   }

   private byte[] encodeParameters(Map param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   private static int findDefaultTrafficStatsTag(String var0) {
      if(!TextUtils.isEmpty(var0)) {
         Uri var1 = Uri.parse(var0);
         if(var1 != null) {
            var0 = var1.getHost();
            if(var0 != null) {
               return var0.hashCode();
            }
         }
      }

      return 0;
   }

   public void addMarker(String var1) {
      if(VolleyLog$MarkerLog.ENABLED) {
         this.mEventLog.add(var1, Thread.currentThread().getId());
      } else if(this.mRequestBirthTime == 0L) {
         this.mRequestBirthTime = SystemClock.elapsedRealtime();
         return;
      }

   }

   public void cancel() {
      this.mCanceled = true;
   }

   public int compareTo(Request var1) {
      Request$Priority var2 = this.getPriority();
      Request$Priority var3 = var1.getPriority();
      return var2 == var3?this.mSequence.intValue() - var1.mSequence.intValue():var3.ordinal() - var2.ordinal();
   }

   public void deliverError(VolleyError var1) {
      if(this.mErrorListener != null) {
         this.mErrorListener.onErrorResponse(var1);
      }

   }

   protected abstract void deliverResponse(Object var1);

   void finish(final String var1) {
      if(this.mRequestQueue != null) {
         this.mRequestQueue.finish(this);
      }

      final long var2;
      if(VolleyLog$MarkerLog.ENABLED) {
         var2 = Thread.currentThread().getId();
         if(Looper.myLooper() == Looper.getMainLooper()) {
            this.mEventLog.add(var1, var2);
            this.mEventLog.finish(this.toString());
            return;
         }

         (new Handler(Looper.getMainLooper())).post(new Runnable() {
            public void run() {
               Request.this.mEventLog.add(var1, var2);
               Request.this.mEventLog.finish(this.toString());
            }
         });
      } else {
         var2 = SystemClock.elapsedRealtime() - this.mRequestBirthTime;
         if(var2 >= 3000L) {
            VolleyLog.d("%d ms: %s", new Object[]{Long.valueOf(var2), this.toString()});
            return;
         }
      }

   }

   public byte[] getBody() {
      Map var1 = this.getParams();
      return var1 != null && var1.size() > 0?this.encodeParameters(var1, this.getParamsEncoding()):null;
   }

   public String getBodyContentType() {
      return "application/x-www-form-urlencoded; charset=" + this.getParamsEncoding();
   }

   public Cache$Entry getCacheEntry() {
      return this.mCacheEntry;
   }

   public String getCacheKey() {
      return this.getUrl();
   }

   public Response$ErrorListener getErrorListener() {
      return this.mErrorListener;
   }

   public Map getHeaders() {
      return Collections.emptyMap();
   }

   public int getMethod() {
      return this.mMethod;
   }

   protected Map getParams() {
      return null;
   }

   protected String getParamsEncoding() {
      return "UTF-8";
   }

   @Deprecated
   public byte[] getPostBody() {
      Map var1 = this.getPostParams();
      return var1 != null && var1.size() > 0?this.encodeParameters(var1, this.getPostParamsEncoding()):null;
   }

   @Deprecated
   public String getPostBodyContentType() {
      return this.getBodyContentType();
   }

   @Deprecated
   protected Map getPostParams() {
      return this.getParams();
   }

   @Deprecated
   protected String getPostParamsEncoding() {
      return this.getParamsEncoding();
   }

   public Request$Priority getPriority() {
      return Request$Priority.NORMAL;
   }

   public RetryPolicy getRetryPolicy() {
      return this.mRetryPolicy;
   }

   public final int getSequence() {
      if(this.mSequence == null) {
         throw new IllegalStateException("getSequence called before setSequence");
      } else {
         return this.mSequence.intValue();
      }
   }

   public Object getTag() {
      return this.mTag;
   }

   public final int getTimeoutMs() {
      return this.mRetryPolicy.getCurrentTimeout();
   }

   public int getTrafficStatsTag() {
      return this.mDefaultTrafficStatsTag;
   }

   public String getUrl() {
      return this.mUrl;
   }

   public boolean hasHadResponseDelivered() {
      return this.mResponseDelivered;
   }

   public boolean isCanceled() {
      return this.mCanceled;
   }

   public void markDelivered() {
      this.mResponseDelivered = true;
   }

   protected VolleyError parseNetworkError(VolleyError var1) {
      return var1;
   }

   protected abstract Response parseNetworkResponse(NetworkResponse var1);

   public Request setCacheEntry(Cache$Entry var1) {
      this.mCacheEntry = var1;
      return this;
   }

   public Request setRequestQueue(RequestQueue var1) {
      this.mRequestQueue = var1;
      return this;
   }

   public Request setRetryPolicy(RetryPolicy var1) {
      this.mRetryPolicy = var1;
      return this;
   }

   public final Request setSequence(int var1) {
      this.mSequence = Integer.valueOf(var1);
      return this;
   }

   public final Request setShouldCache(boolean var1) {
      this.mShouldCache = var1;
      return this;
   }

   public Request setTag(Object var1) {
      this.mTag = var1;
      return this;
   }

   public final boolean shouldCache() {
      return this.mShouldCache;
   }

   public String toString() {
      String var2 = "0x" + Integer.toHexString(this.getTrafficStatsTag());
      StringBuilder var3 = new StringBuilder();
      String var1;
      if(this.mCanceled) {
         var1 = "[X] ";
      } else {
         var1 = "[ ] ";
      }

      return var3.append(var1).append(this.getUrl()).append(" ").append(var2).append(" ").append(this.getPriority()).append(" ").append(this.mSequence).toString();
   }
}
