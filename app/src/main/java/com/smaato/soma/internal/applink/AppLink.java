package com.smaato.soma.internal.applink;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

public class AppLink {
   String appClass;
   String appName;
   String appPackage;
   String appUrl;

   public AppLink() {
   }

   public AppLink(String var1, String var2, String var3, String var4) {
      this.appUrl = var1;
      this.appPackage = var2;
      this.appClass = var3;
      this.appName = var4;
   }

   private boolean appInstalledOrNot(String var1, Context var2) {
      PackageManager var4 = var2.getPackageManager();

      try {
         var4.getPackageInfo(var1, 1);
         return true;
      } catch (NameNotFoundException var3) {
         return false;
      }
   }

   public boolean canStart(Context var1) {
      return this.getAppPackage() != null && this.getAppPackage().length() > 0?this.appInstalledOrNot(this.getAppPackage(), var1):false;
   }

   public String getAppClass() {
      return this.appClass;
   }

   public String getAppName() {
      return this.appName;
   }

   public String getAppPackage() {
      return this.appPackage;
   }

   public String getAppUrl() {
      return this.appUrl;
   }

   public void setAppClass(String var1) {
      this.appClass = var1;
   }

   public void setAppName(String var1) {
      this.appName = var1;
   }

   public void setAppPackage(String var1) {
      this.appPackage = var1;
   }

   public void setAppUrl(String var1) {
      this.appUrl = var1;
   }

   public String toString() {
      StringBuffer var1 = new StringBuffer();
      var1.append("App Name : ");
      var1.append(this.appName);
      var1.append("App URL : ");
      var1.append(this.appUrl);
      var1.append("App Package : ");
      var1.append(this.appPackage);
      var1.append("App Class : ");
      var1.append(this.appClass);
      return var1.toString();
   }
}
