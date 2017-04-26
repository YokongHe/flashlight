package com.mopub.volley.toolbox;

import com.mopub.volley.NetworkResponse;
import com.mopub.volley.ParseError;
import com.mopub.volley.Response;
import com.mopub.volley.Response$ErrorListener;
import com.mopub.volley.Response$Listener;
import com.mopub.volley.toolbox.HttpHeaderParser;
import com.mopub.volley.toolbox.JsonRequest;
import java.io.UnsupportedEncodingException;
import org.json.JSONArray;
import org.json.JSONException;

public class JsonArrayRequest extends JsonRequest {
   public JsonArrayRequest(String var1, Response$Listener var2, Response$ErrorListener var3) {
      super(0, var1, (String)null, var2, var3);
   }

   protected Response parseNetworkResponse(NetworkResponse var1) {
      try {
         Response var4 = Response.success(new JSONArray(new String(var1.data, HttpHeaderParser.parseCharset(var1.headers))), HttpHeaderParser.parseCacheHeaders(var1));
         return var4;
      } catch (UnsupportedEncodingException var2) {
         return Response.error(new ParseError(var2));
      } catch (JSONException var3) {
         return Response.error(new ParseError(var3));
      }
   }
}
