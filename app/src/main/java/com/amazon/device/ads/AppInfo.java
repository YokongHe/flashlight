package com.amazon.device.ads;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.amazon.device.ads.JSONUtils;
import org.json.JSONObject;

class AppInfo {
   private String applicationLabel;
   private JSONObject packageInfoUrlJSON;
   private String packageName;
   private String versionCode;
   private String versionName;

   protected AppInfo() {
   }

   public AppInfo(Context var1) {
      this.packageName = var1.getPackageName();
      PackageManager var2 = var1.getPackageManager();
      this.applicationLabel = (String)var2.getApplicationLabel(var1.getApplicationInfo());

      PackageInfo var4;
      try {
         var4 = var2.getPackageInfo(this.packageName, 0);
      } catch (NameNotFoundException var3) {
         var4 = null;
      }

      String var5;
      if(var4 != null) {
         var5 = var4.versionName;
      } else {
         var5 = "";
      }

      this.versionName = var5;
      String var6;
      if(var4 != null) {
         var6 = Integer.toString(var4.versionCode);
      } else {
         var6 = "";
      }

      this.versionCode = var6;
      this.packageInfoUrlJSON = new JSONObject();
      JSONUtils.put(this.packageInfoUrlJSON, "lbl", this.applicationLabel);
      JSONUtils.put(this.packageInfoUrlJSON, "pn", this.packageName);
      JSONUtils.put(this.packageInfoUrlJSON, "v", this.versionCode);
      JSONUtils.put(this.packageInfoUrlJSON, "vn", this.versionName);
   }

   public JSONObject getPackageInfoJSON() {
      return this.packageInfoUrlJSON;
   }

   public String getPackageInfoJSONString() {
      return this.packageInfoUrlJSON != null?this.packageInfoUrlJSON.toString():null;
   }
}
