package com.mopub.common;

import android.net.Uri;
import android.text.TextUtils;

public abstract class BaseUrlGenerator {
   private boolean mFirstParam;
   private StringBuilder mStringBuilder;

   private String getParamDelimiter() {
      if(this.mFirstParam) {
         this.mFirstParam = false;
         return "?";
      } else {
         return "&";
      }
   }

   protected void addParam(String var1, String var2) {
      if(!TextUtils.isEmpty(var2)) {
         this.mStringBuilder.append(this.getParamDelimiter());
         this.mStringBuilder.append(var1);
         this.mStringBuilder.append("=");
         this.mStringBuilder.append(Uri.encode(var2));
      }
   }

   protected void appendAdvertisingInfoTemplates() {
      this.addParam("udid", "mp_tmpl_advertising_id");
      this.addParam("dnt", "mp_tmpl_do_not_track");
   }

   public abstract String generateUrlString(String var1);

   protected String getFinalUrlString() {
      return this.mStringBuilder.toString();
   }

   protected void initUrlString(String var1, String var2) {
      this.mStringBuilder = new StringBuilder("http://" + var1 + var2);
      this.mFirstParam = true;
   }

   protected void setApiVersion(String var1) {
      this.addParam("v", var1);
   }

   protected void setAppVersion(String var1) {
      this.addParam("av", var1);
   }

   protected void setDeviceInfo(String... var1) {
      StringBuilder var3 = new StringBuilder();
      if(var1 != null && var1.length > 0) {
         for(int var2 = 0; var2 < var1.length - 1; ++var2) {
            var3.append(var1[var2]).append(",");
         }

         var3.append(var1[var1.length - 1]);
         this.addParam("dn", var3.toString());
      }
   }

   protected void setDoNotTrack(boolean var1) {
      if(var1) {
         this.addParam("dnt", "1");
      }

   }

   protected void setExternalStoragePermission(boolean var1) {
      String var2;
      if(var1) {
         var2 = "1";
      } else {
         var2 = "0";
      }

      this.addParam("android_perms_ext_storage", var2);
   }

   protected void setUdid(String var1) {
      this.addParam("udid", var1);
   }
}
