package com.flurry.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.flurry.sdk.eo;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class h {
   private static final String a = com.flurry.sdk.h.class.getSimpleName();
   private static final List b = Arrays.asList(new String[]{"com.android.chrome", "org.mozilla.firefox", "mobi.mgeek.TunnyBrowser", "com.UCMobile.intl", "com.opera.mini.android", "com.jiubang.browser", "com.opera.browser", "com.uc.browser.en", "acr.browser.barebones", "com.boatbrowser.free", "com.mx.browser", "com.ilegendsoft.mercury", "gpc.myweb.hinet.net.PopupWeb", "mobi.browser.flashfox", "com.baidu.browser.inter", "com.sec.webbrowserminiapp", "com.android.browser", "com.android.vending"});

   public static Intent a(Context var0, String var1) {
      if(var0 != null && !TextUtils.isEmpty(var1)) {
         Intent var3 = new Intent("android.intent.action.VIEW", Uri.parse(var1));
         ActivityInfo var2 = a(var0.getPackageManager(), var3);
         if(var2 != null) {
            return a(var2, var3);
         }
      }

      return null;
   }

   private static Intent a(ActivityInfo var0, Intent var1) {
      eo.a(3, a, "Launching App in package: " + var0.packageName);
      ComponentName var2 = new ComponentName(var0.applicationInfo.packageName, var0.name);
      var1.addCategory("android.intent.category.LAUNCHER");
      var1.setComponent(var2);
      return var1;
   }

   private static ActivityInfo a(PackageManager var0, Intent var1) {
      if(var0 != null && var1 != null) {
         List var3 = var0.queryIntentActivities(var1, 65536);
         if(var3 != null && var3.size() > 0) {
            Iterator var4 = var3.iterator();

            while(var4.hasNext()) {
               String var2 = ((ResolveInfo)var4.next()).activityInfo.packageName;
               if(b(var2)) {
                  var4.remove();
               } else {
                  eo.a(3, a, "Package not blacklisted: " + var2);
               }
            }
         }

         return var3.size() > 0?((ResolveInfo)var3.get(0)).activityInfo:null;
      } else {
         return null;
      }
   }

   private static boolean a(String var0) {
      boolean var2 = false;
      boolean var1 = var2;
      if(!TextUtils.isEmpty(var0)) {
         if(!"com.android.vending".equalsIgnoreCase(var0)) {
            var1 = var2;
            if(!"com.google.market".equalsIgnoreCase(var0)) {
               return var1;
            }
         }

         var1 = true;
      }

      return var1;
   }

   public static Intent b(Context var0, String var1) {
      if(var0 != null && !TextUtils.isEmpty(var1)) {
         PackageManager var2 = var0.getPackageManager();
         Intent var3 = new Intent("android.intent.action.VIEW", Uri.parse(var1));
         List var4 = var2.queryIntentActivities(var3, 65536);
         if(var4 != null && var4.size() > 0) {
            Iterator var5 = var4.iterator();

            while(var5.hasNext()) {
               ActivityInfo var6 = ((ResolveInfo)var5.next()).activityInfo;
               if(a(var6.packageName)) {
                  return a(var6, var3);
               }
            }
         }

         return null;
      } else {
         return null;
      }
   }

   private static boolean b(String var0) {
      return b.contains(var0);
   }
}
