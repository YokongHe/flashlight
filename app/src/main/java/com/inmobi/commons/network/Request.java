package com.inmobi.commons.network;

import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.network.Request$Format;
import com.inmobi.commons.network.Request$Method;
import com.inmobi.commons.network.RequestBuilderUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class Request {
   protected static HashMap mHeaders;
   private Request$Format a;
   private final String b;
   private String c;
   private Request$Method d;
   private int e;
   protected HashMap mReqParams;

   public Request(String var1, Request$Format var2, Request$Method var3) {
      this.a = Request$Format.KEY_VAL;
      this.b = "User-Agent";
      this.c = null;
      this.d = Request$Method.POST;
      this.e = 0;
      this.mReqParams = new HashMap();
      mHeaders = new HashMap();
      RequestBuilderUtils.fillIdentityMap(this.mReqParams, (Map)null, true);
      mHeaders.put("User-Agent", InternalSDKUtil.getUserAgent());
      this.a = var2;
      this.c = var1;
      this.d = var3;
   }

   private String a() {
      Map var1 = InternalSDKUtil.getEncodedMap(this.mReqParams);
      switch(null.a[this.a.ordinal()]) {
      case 1:
         return InternalSDKUtil.encodeMapAndconvertToDelimitedString(this.mReqParams, "&");
      case 2:
         return (new JSONObject(var1)).toString();
      default:
         return null;
      }
   }

   public void fillAppInfo() {
      RequestBuilderUtils.fillAppInfoMap(this.mReqParams);
   }

   public void fillCustomInfo(Map var1) {
      if(var1 != null) {
         this.mReqParams.putAll(var1);
      }

   }

   public void fillDemogInfo() {
      RequestBuilderUtils.fillDemogMap(this.mReqParams);
   }

   public void fillDeviceInfo() {
      RequestBuilderUtils.fillDeviceMap(this.mReqParams);
   }

   public void fillLocationInfo() {
      RequestBuilderUtils.fillLocationMap(this.mReqParams);
   }

   public Map getHeaders() {
      return InternalSDKUtil.getEncodedMap(mHeaders);
   }

   protected String getPostBody() {
      return this.d != Request$Method.GET?this.a():null;
   }

   protected String getQueryParams() {
      return this.d == Request$Method.GET?this.a():null;
   }

   protected Request$Method getRequestMethod() {
      return this.d;
   }

   public int getTimeout() {
      return this.e;
   }

   protected String getUrl() {
      return this.c;
   }

   public void setTimeout(int var1) {
      this.e = var1;
   }

   protected void setUrl(String var1) {
      boolean var3 = true;
      boolean var2;
      if(var1 != null) {
         var2 = true;
      } else {
         var2 = false;
      }

      if("".equals(var1.trim())) {
         var3 = false;
      }

      if(var2 & var3) {
         this.c = var1;
      }

   }
}
