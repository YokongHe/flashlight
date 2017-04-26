package com.inmobi.commons.analytics.net;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.inmobi.commons.analytics.db.AnalyticsEvent;
import com.inmobi.commons.analytics.net.AnalyticsPayload;
import com.inmobi.commons.analytics.util.AnalyticsUtils;
import com.inmobi.commons.analytics.util.SessionInfo;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AnalyticsPayloadBuilder {
   private JSONArray a(List param1) {
      // $FF: Couldn't be decompiled
   }

   private JSONObject a(String var1, long var2, Context var4) {
      JSONObject var5 = new JSONObject();

      try {
         var5.put("ft", SessionInfo.getFirstTime());
         var5.put("a", var4.getPackageName());
         var5.put("an", AnalyticsUtils.getApplicationName(var4));
         var5.put("av", AnalyticsUtils.getAppVersion(var4));
         var5.put("p", "android");
         var5.put("pv", VERSION.RELEASE);
         var5.put("ca", InternalSDKUtil.getConnectivityType(var4));
         var5.put("ma", Build.MANUFACTURER);
         var5.put("mo", Build.MODEL);
         var5.put("ss", var1);
         var5.put("sts", var2);
         var5.put("sv", "4.5.2");
         if(AnalyticsUtils.getCountryISO(var4) != null) {
            var5.put("co", AnalyticsUtils.getCountryISO(var4));
         }

         return var5;
      } catch (JSONException var6) {
         Log.internal("[InMobi]-[Analytics]-4.5.2", "Creation of session object failed", var6);
         return var5;
      } catch (NullPointerException var7) {
         Log.internal("[InMobi]-[Analytics]-4.5.2", "null passed as context", var7);
         return var5;
      }
   }

   private JSONObject a(JSONObject var1, JSONArray var2) {
      JSONObject var3 = new JSONObject();

      try {
         var3.put("session", var1);
      } catch (JSONException var5) {
         Log.internal("[InMobi]-[Analytics]-4.5.2", "Session addition to payload failed");
      }

      try {
         var3.put("events", var2);
         return var3;
      } catch (JSONException var4) {
         Log.internal("[InMobi]-[Analytics]-4.5.2", "Events addition to payload failed");
         return var3;
      }
   }

   public AnalyticsPayload getPayloadList(List var1, Context var2) {
      Log.debug("[InMobi]-[Analytics]-4.5.2", "PayloadBuilder->getPayloadList:");
      JSONArray var4 = new JSONArray();
      ArrayList var5 = new ArrayList();
      ArrayList var6 = new ArrayList();
      int var3 = 0;

      while(var3 < var1.size()) {
         var5.clear();
         AnalyticsEvent var7 = (AnalyticsEvent)var1.get(var3);

         String var8;
         for(var8 = var7.getEventSessionId(); var3 < var1.size() && var8.equals(((AnalyticsEvent)var1.get(var3)).getEventSessionId()); ++var3) {
            var6.add(Long.valueOf(((AnalyticsEvent)var1.get(var3)).getEventTableId()));
            var5.add(var1.get(var3));
         }

         JSONArray var9 = this.a(var5);
         var4.put(this.a(this.a(var8, var7.getEventSessionTimeStamp(), var2), var9));
      }

      AnalyticsPayload var10 = new AnalyticsPayload((String)null, (ArrayList)var6);
      if(var4.length() != 0) {
         var10.setCompletePayload(var4.toString());
         var10.setPayloadSize(var1.size());
      }

      return var10;
   }
}
