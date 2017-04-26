package com.mopub.volley.toolbox;

import com.mopub.volley.NetworkResponse;
import com.mopub.volley.ParseError;
import com.mopub.volley.Response;
import com.mopub.volley.Response$ErrorListener;
import com.mopub.volley.Response$Listener;
import com.mopub.volley.toolbox.HttpHeaderParser;
import com.mopub.volley.toolbox.JsonRequest;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonObjectRequest extends JsonRequest {
   public JsonObjectRequest(int var1, String var2, JSONObject var3, Response$Listener var4, Response$ErrorListener var5) {
      String var6;
      if(var3 == null) {
         var6 = null;
      } else {
         var6 = var3.toString();
      }

      super(var1, var2, var6, var4, var5);
   }

   public JsonObjectRequest(String var1, JSONObject var2, Response$Listener var3, Response$ErrorListener var4) {
      byte var5;
      if(var2 == null) {
         var5 = 0;
      } else {
         var5 = 1;
      }

      this(var5, var1, var2, var3, var4);
   }

   protected Response parseNetworkResponse(NetworkResponse var1) {
      try {
         Response var4 = Response.success(new JSONObject(new String(var1.data, HttpHeaderParser.parseCharset(var1.headers))), HttpHeaderParser.parseCacheHeaders(var1));
         return var4;
      } catch (UnsupportedEncodingException var2) {
         return Response.error(new ParseError(var2));
      } catch (JSONException var3) {
         return Response.error(new ParseError(var3));
      }
   }
}
