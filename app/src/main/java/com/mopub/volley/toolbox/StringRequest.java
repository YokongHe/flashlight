package com.mopub.volley.toolbox;

import com.mopub.volley.NetworkResponse;
import com.mopub.volley.Request;
import com.mopub.volley.Response;
import com.mopub.volley.Response$ErrorListener;
import com.mopub.volley.Response$Listener;
import com.mopub.volley.toolbox.HttpHeaderParser;
import java.io.UnsupportedEncodingException;

public class StringRequest extends Request {
   private final Response$Listener mListener;

   public StringRequest(int var1, String var2, Response$Listener var3, Response$ErrorListener var4) {
      super(var1, var2, var4);
      this.mListener = var3;
   }

   public StringRequest(String var1, Response$Listener var2, Response$ErrorListener var3) {
      this(0, var1, var2, var3);
   }

   protected void deliverResponse(String var1) {
      this.mListener.onResponse(var1);
   }

   protected Response parseNetworkResponse(NetworkResponse var1) {
      String var2;
      try {
         var2 = new String(var1.data, HttpHeaderParser.parseCharset(var1.headers));
      } catch (UnsupportedEncodingException var3) {
         var2 = new String(var1.data);
      }

      return Response.success(var2, HttpHeaderParser.parseCacheHeaders(var1));
   }
}
