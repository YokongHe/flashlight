package com.mopub.nativeads;

import com.mopub.common.VisibleForTesting;
import com.mopub.nativeads.MoPubNativeAdPositioning$MoPubClientPositioning;
import com.mopub.network.MoPubNetworkError;
import com.mopub.network.MoPubNetworkError$Reason;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.Response;
import com.mopub.volley.Response$ErrorListener;
import com.mopub.volley.Response$Listener;
import com.mopub.volley.VolleyError;
import com.mopub.volley.toolbox.HttpHeaderParser;
import com.mopub.volley.toolbox.JsonRequest;
import java.io.UnsupportedEncodingException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PositioningRequest extends JsonRequest {
   private static final String FIXED_KEY = "fixed";
   private static final String INTERVAL_KEY = "interval";
   private static final int MAX_VALUE = 65536;
   private static final String POSITION_KEY = "position";
   private static final String REPEATING_KEY = "repeating";
   private static final String SECTION_KEY = "section";

   public PositioningRequest(String var1, Response$Listener var2, Response$ErrorListener var3) {
      super(0, var1, (String)null, var2, var3);
   }

   private void parseFixedJson(JSONArray var1, MoPubNativeAdPositioning$MoPubClientPositioning var2) {
      for(int var3 = 0; var3 < var1.length(); ++var3) {
         JSONObject var5 = var1.getJSONObject(var3);
         int var4 = var5.optInt("section", 0);
         if(var4 < 0) {
            throw new JSONException("Invalid section " + var4 + " in JSON response");
         }

         if(var4 <= 0) {
            var4 = var5.getInt("position");
            if(var4 < 0 || var4 > 65536) {
               throw new JSONException("Invalid position " + var4 + " in JSON response");
            }

            var2.addFixedPosition(var4);
         }
      }

   }

   private void parseRepeatingJson(JSONObject var1, MoPubNativeAdPositioning$MoPubClientPositioning var2) {
      int var3 = var1.getInt("interval");
      if(var3 >= 2 && var3 <= 65536) {
         var2.enableRepeatingPositions(var3);
      } else {
         throw new JSONException("Invalid interval " + var3 + " in JSON response");
      }
   }

   protected void deliverResponse(MoPubNativeAdPositioning$MoPubClientPositioning var1) {
      super.deliverResponse(var1);
   }

   @VisibleForTesting
   MoPubNativeAdPositioning$MoPubClientPositioning parseJson(String var1) {
      JSONObject var2 = new JSONObject(var1);
      var1 = var2.optString("error", (String)null);
      if(var1 != null) {
         if(var1.equalsIgnoreCase("WARMING_UP")) {
            throw new MoPubNetworkError(MoPubNetworkError$Reason.WARMING_UP);
         } else {
            throw new JSONException(var1);
         }
      } else {
         JSONArray var4 = var2.optJSONArray("fixed");
         var2 = var2.optJSONObject("repeating");
         if(var4 == null && var2 == null) {
            throw new JSONException("Must contain fixed or repeating positions");
         } else {
            MoPubNativeAdPositioning$MoPubClientPositioning var3 = new MoPubNativeAdPositioning$MoPubClientPositioning();
            if(var4 != null) {
               this.parseFixedJson(var4, var3);
            }

            if(var2 != null) {
               this.parseRepeatingJson(var2, var3);
            }

            return var3;
         }
      }
   }

   protected Response parseNetworkResponse(NetworkResponse var1) {
      if(var1.statusCode != 200) {
         return Response.error(new VolleyError(var1));
      } else if(var1.data.length == 0) {
         return Response.error(new VolleyError("Empty positioning response", new JSONException("Empty response")));
      } else {
         try {
            Response var5 = Response.success(this.parseJson(new String(var1.data, HttpHeaderParser.parseCharset(var1.headers))), HttpHeaderParser.parseCacheHeaders(var1));
            return var5;
         } catch (UnsupportedEncodingException var2) {
            return Response.error(new VolleyError("Couldn\'t parse JSON from Charset", var2));
         } catch (JSONException var3) {
            return Response.error(new VolleyError("JSON Parsing Error", var3));
         } catch (MoPubNetworkError var4) {
            return Response.error(var4);
         }
      }
   }
}
