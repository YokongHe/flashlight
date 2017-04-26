package com.inmobi.monetization.internal;

import com.inmobi.commons.internal.EncryptionUtils;
import com.inmobi.commons.internal.InternalSDKUtil;
import com.inmobi.commons.internal.Log;
import com.inmobi.commons.network.Request;
import com.inmobi.commons.network.Request$Format;
import com.inmobi.commons.network.Request$Method;
import com.inmobi.commons.network.RequestBuilderUtils;
import com.inmobi.monetization.internal.configs.Initializer;
import com.inmobi.monetization.internal.configs.PkInitilaizer;
import java.util.HashMap;
import java.util.Map;

class c extends Request {
   protected static String a = "http://i.w.inmobi.com/showad.asm";
   private static byte[] e;
   String b = "";
   String c = "";
   String d = "";
   private byte[] f;
   private byte[] g;

   public c() {
      super(a, Request$Format.KEY_VAL, Request$Method.POST);
      RequestBuilderUtils.fillIdentityMap(this.mReqParams, Initializer.getConfigParams().getDeviceIdMaskMap(), false);
      RequestBuilderUtils.fillAppInfoMap(this.mReqParams);
      RequestBuilderUtils.fillDemogMap(this.mReqParams);
      RequestBuilderUtils.fillDeviceMap(this.mReqParams);
      RequestBuilderUtils.fillLocationMap(this.mReqParams);
      this.setTimeout(Initializer.getConfigParams().getFetchTimeOut());
   }

   String a(String var1) {
      HashMap var2 = new HashMap();
      this.g = EncryptionUtils.generateKey(8);
      this.f = EncryptionUtils.generateKey(16);
      e = EncryptionUtils.keag();
      this.b = PkInitilaizer.getConfigParams().getExponent();
      this.c = PkInitilaizer.getConfigParams().getModulus();
      this.d = PkInitilaizer.getConfigParams().getVersion();
      if(!this.b.equals("") && !this.c.equals("") && !this.d.equals("")) {
         var2.put("sm", EncryptionUtils.SeMeGe(var1, e, this.f, this.g, this.c, this.b));
         var2.put("sn", this.d);
         return InternalSDKUtil.encodeMapAndconvertToDelimitedString(var2, "&");
      } else {
         Log.debug("[InMobi]-[Monetization]", "Exception retreiving Ad due to key problem");
         return null;
      }
   }

   void a(Map var1) {
      if(this.mReqParams != null && var1 != null && !var1.isEmpty()) {
         this.mReqParams.putAll(var1);
      }

   }

   byte[] a() {
      return this.f;
   }

   void b(Map var1) {
      if(this.mReqParams != null && var1 != null) {
         this.mReqParams.putAll(var1);
      }

   }

   byte[] b() {
      return e;
   }

   protected String getPostBody() {
      String var1 = super.getPostBody();
      Log.internal("[InMobi]-[Monetization]", "Raw Postbody: " + var1);
      return this.a(var1);
   }

   protected void setUrl(String var1) {
      super.setUrl(var1);
   }
}
