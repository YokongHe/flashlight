package com.inmobi.commons.cache;

import com.inmobi.commons.cache.CacheController$Committer;
import com.inmobi.commons.cache.CacheController$Validator;
import com.inmobi.commons.cache.ProductCacheConfig$a;
import com.inmobi.commons.cache.ProductConfig;
import com.inmobi.commons.cache.RetryMechanism;
import com.inmobi.commons.cache.RetryMechanism$RetryRunnable;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.network.RequestBuilderUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class ProductCacheConfig extends ProductConfig {
   public static final int DEFAULT_EXPIRY = 432000;
   public static final int DEFAULT_INTERVAL = 60;
   public static final int DEFAULT_MAX_RETRY = 3;
   private static Timer a = new Timer();
   private AtomicBoolean b;
   private Map c;
   private CacheController$Validator d;
   private RetryMechanism e;
   private CacheController$Committer f;
   private long g;

   public ProductCacheConfig(JSONObject var1) {
      this.b = new AtomicBoolean(false);
      this.c = new HashMap();
      this.d = null;
      this.e = new RetryMechanism(3, '\uea60', a);

      try {
         this.loadFromJSON(var1);
      } catch (Exception var2) {
         Log.internal("[InMobi]-4.5.2", "JSON retrieved is invalid.");
      }
   }

   public ProductCacheConfig(JSONObject var1, CacheController$Committer var2) {
      this(var1);
      this.f = var2;
   }

   private void a() {
      // $FF: Couldn't be decompiled
   }

   private void b() {
      if(this.b.compareAndSet(false, true)) {
         this.e.rescheduleTimer(new RetryMechanism$RetryRunnable() {
            public void completed() {
               ProductCacheConfig.this.b.set(false);
            }

            public void run() {
               try {
                  if(InternalSDKUtil.checkNetworkAvailibility(InternalSDKUtil.getContext())) {
                     ProductCacheConfig.this.a();
                  } else {
                     throw new IOException("Network unavailable");
                  }
               } catch (Exception var2) {
                  throw var2;
               }
            }
         });
      }
   }

   private ProductCacheConfig$a c() {
      String var3 = "";
      HashMap var2 = new HashMap();
      RequestBuilderUtils.fillIdentityMap(var2, (Map)null, true);
      RequestBuilderUtils.fillAppInfoMap(var2);
      String var6 = InternalSDKUtil.encodeMapAndconvertToDelimitedString(var2, "&");
      if(var6 != null && !"".equals(var6)) {
         if(this.getUrl().endsWith("?")) {
            var6 = this.getUrl() + var6;
         } else if(this.getUrl().contains("?")) {
            var6 = this.getUrl() + "&" + var6;
         } else {
            var6 = this.getUrl() + "?" + var6;
         }
      } else {
         var6 = this.getUrl();
      }

      URL var4 = new URL(var6);
      Log.internal("[InMobi]-4.5.2", "Sending request to " + var6 + " to retreive cache..");
      HttpURLConnection var8 = (HttpURLConnection)var4.openConnection();
      var8.setRequestProperty("User-Agent", InternalSDKUtil.getUserAgent());
      var8.setIfModifiedSince(this.g);
      var8.setRequestMethod("GET");
      int var1 = var8.getResponseCode();
      if(var1 == 304) {
         ProductCacheConfig$a var9 = new ProductCacheConfig$a(this, null);
         ProductCacheConfig$a.a(var9, (String)null);
         ProductCacheConfig$a.a(var9, var8.getLastModified());
         return var9;
      } else if(var1 != 200) {
         throw new IOException("Server did not return 200. ");
      } else {
         BufferedReader var5 = new BufferedReader(new InputStreamReader(var8.getInputStream()));
         var6 = var3;

         while(true) {
            var3 = var5.readLine();
            if(var3 == null) {
               var5.close();
               ProductCacheConfig$a var7 = new ProductCacheConfig$a(this, null);
               ProductCacheConfig$a.a(var7, var6);
               ProductCacheConfig$a.a(var7, var8.getLastModified());
               return var7;
            }

            var6 = var6 + var3;
         }
      }
   }

   public ProductConfig getConfig() {
      return this;
   }

   public String getData(CacheController$Validator var1) {
      if(var1 != null) {
         this.d = var1;
      }

      this.setRetryNumber(0);
      int var2 = (int)(System.currentTimeMillis() / 1000L);
      if(this.getTimestamp() + this.getExpiry() - var2 <= 0) {
         this.b();
      }

      return this.getRawData();
   }

   public String getData(Map var1, CacheController$Validator var2) {
      if(var1 != null) {
         this.c = var1;
      }

      return this.getData(var2);
   }

   public Map getMap() {
      return this.c;
   }

   public CacheController$Validator getValidator() {
      return this.d;
   }

   public final void loadFromJSON(JSONObject var1) {
      this.setExpiry(InternalSDKUtil.getIntFromJSON(var1, "expiry", 432000));
      this.setMaxRetry(InternalSDKUtil.getIntFromJSON(var1, "maxRetry", 3));
      this.setRetryInterval(InternalSDKUtil.getIntFromJSON(var1, "retryInterval", 60));
      this.g = InternalSDKUtil.getLongFromJSON(var1, "lastModified", 0L);
      this.setUrl(InternalSDKUtil.getStringFromJSON(var1, "url", ""));
      this.setProtocol(InternalSDKUtil.getStringFromJSON(var1, "protocol", "json"));
      this.e = new RetryMechanism(this.getMaxRetry(), this.getRetryInterval() * 1000, a);
      this.setTimestamp(InternalSDKUtil.getIntFromJSON(var1, "timestamp", 0));
      this.setData(InternalSDKUtil.getStringFromJSON(var1, "data", (String)null));
   }

   protected void reset() {
      this.setExpiry(0);
      this.setRetryInterval(0);
      this.setMaxRetry(0);
      this.setTimestamp(0);
      this.setUrl((String)null);
      this.setProtocol((String)null);
      this.setData((String)null);
   }

   public void setMap(Map var1) {
      this.c = var1;
   }

   public void setValidator(CacheController$Validator var1) {
      this.d = var1;
   }

   public JSONObject toJSON() {
      JSONObject var1 = new JSONObject();

      JSONException var2;
      label19: {
         JSONObject var6;
         try {
            var6 = new JSONObject("{expiry:" + this.getExpiry() + ",maxRetry:" + this.getMaxRetry() + ",retryInterval:" + this.getRetryInterval() + ",protocol:" + this.getProtocol() + ",timestamp:" + this.getTimestamp() + "}");
         } catch (JSONException var5) {
            var2 = var5;
            break label19;
         }

         try {
            var6.put("url", this.getUrl());
            var6.put("data", this.getRawData());
            var6.put("lastModified", this.g);
            return var6;
         } catch (JSONException var4) {
            var1 = var6;
            var2 = var4;
         }
      }

      Log.internal("[InMobi]-4.5.2", "Ill formed JSON product(" + this.getUrl() + ") toString", var2);
      return var1;
   }

   public String toString() {
      return this.toJSON().toString();
   }
}
