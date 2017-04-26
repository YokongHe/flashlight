package com.tapjoy;

import com.tapjoy.TapjoyLog;
import com.tapjoy.TapjoyUtil;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class TapjoyCachedAssetData implements Serializable {
   private long a;
   private long b;
   private String c;
   private String d;
   private String e;
   private long f;
   private String g;
   private String h;

   public TapjoyCachedAssetData(String var1, String var2, long var3) {
      this(var1, var2, var3, System.currentTimeMillis() / 1000L);
   }

   public TapjoyCachedAssetData(String var1, String var2, long var3, long var5) {
      this.setAssetURL(var1);
      this.setLocalFilePath(var2);
      this.b = var3;
      this.a = var5;
      this.f = var5 + var3;
   }

   public static TapjoyCachedAssetData fromJSONObject(JSONObject var0) {
      TapjoyCachedAssetData var7;
      label17: {
         TapjoyCachedAssetData var8;
         try {
            String var3 = var0.getString("assetURL");
            String var4 = var0.getString("localFilePath");
            long var1 = var0.getLong("timestamp");
            var8 = new TapjoyCachedAssetData(var3, var4, var0.getLong("timeToLive"), var1);
         } catch (JSONException var6) {
            var7 = null;
            break label17;
         }

         try {
            var8.setOfferID(var0.optString("offerID"));
            return var8;
         } catch (JSONException var5) {
            var7 = var8;
         }
      }

      TapjoyLog.i("TapjoyCachedAssetData", "Can not build TapjoyVideoObject -- not enough data.");
      return var7;
   }

   public static TapjoyCachedAssetData fromRawJSONString(String var0) {
      try {
         TapjoyCachedAssetData var2 = fromJSONObject(new JSONObject(var0));
         return var2;
      } catch (JSONException var1) {
         TapjoyLog.i("TapjoyCachedAssetData", "Can not build TapjoyVideoObject -- error reading json string");
         return null;
      }
   }

   public String getAssetURL() {
      return this.c;
   }

   public String getLocalFilePath() {
      return this.d;
   }

   public String getLocalURL() {
      return this.e;
   }

   public String getMimeType() {
      return this.g;
   }

   public String getOfferId() {
      return this.h;
   }

   public long getTimeOfDeathInSeconds() {
      return this.f;
   }

   public long getTimeToLiveInSeconds() {
      return this.b;
   }

   public long getTimestampInSeconds() {
      return this.a;
   }

   public void resetTimeToLive(long var1) {
      this.b = var1;
      this.f = System.currentTimeMillis() / 1000L + var1;
   }

   public void setAssetURL(String var1) {
      this.c = var1;
      this.g = TapjoyUtil.determineMimeType(var1);
   }

   public void setLocalFilePath(String var1) {
      this.d = var1;
      this.e = "file://" + var1;
   }

   public void setOfferID(String var1) {
      this.h = var1;
   }

   public JSONObject toJSON() {
      JSONObject var1 = new JSONObject();

      try {
         var1.put("timestamp", this.getTimestampInSeconds());
         var1.put("timeToLive", this.getTimeToLiveInSeconds());
         var1.put("assetURL", this.getAssetURL());
         var1.put("localFilePath", this.getLocalFilePath());
         var1.put("offerID", this.getOfferId());
         return var1;
      } catch (JSONException var3) {
         return var1;
      }
   }

   public String toRawJSONString() {
      return this.toJSON().toString();
   }
}
