package com.mopub.volley.toolbox;

import com.mopub.volley.NetworkResponse;
import com.mopub.volley.Request;
import com.mopub.volley.Response;
import com.mopub.volley.Response$ErrorListener;
import com.mopub.volley.Response$Listener;
import com.mopub.volley.VolleyLog;
import java.io.UnsupportedEncodingException;

public abstract class JsonRequest extends Request {
   private static final String PROTOCOL_CHARSET = "utf-8";
   private static final String PROTOCOL_CONTENT_TYPE = String.format("application/json; charset=%s", new Object[]{"utf-8"});
   private final Response$Listener mListener;
   private final String mRequestBody;

   public JsonRequest(int var1, String var2, String var3, Response$Listener var4, Response$ErrorListener var5) {
      super(var1, var2, var5);
      this.mListener = var4;
      this.mRequestBody = var3;
   }

   public JsonRequest(String var1, String var2, Response$Listener var3, Response$ErrorListener var4) {
      this(-1, var1, var2, var3, var4);
   }

   protected void deliverResponse(Object var1) {
      this.mListener.onResponse(var1);
   }

   public byte[] getBody() {
      try {
         if(this.mRequestBody == null) {
            return null;
         } else {
            byte[] var1 = this.mRequestBody.getBytes("utf-8");
            return var1;
         }
      } catch (UnsupportedEncodingException var2) {
         VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", new Object[]{this.mRequestBody, "utf-8"});
         return null;
      }
   }

   public String getBodyContentType() {
      return PROTOCOL_CONTENT_TYPE;
   }

   public byte[] getPostBody() {
      return this.getBody();
   }

   public String getPostBodyContentType() {
      return this.getBodyContentType();
   }

   protected abstract Response parseNetworkResponse(NetworkResponse var1);
}
