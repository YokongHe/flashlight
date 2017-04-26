package com.inmobi.monetization.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.util.Log;
import com.inmobi.androidsdk.IMBrowserActivity;
import com.inmobi.monetization.internal.InvalidManifestConfigException;
import java.util.Iterator;

class b {
   private static boolean a = false;

   public static Activity a(Activity var0) {
      while(var0.getParent() != null) {
         var0 = var0.getParent();
      }

      return var0;
   }

   public static void a(Context var0) {
      if(var0.checkCallingOrSelfPermission("android.permission.INTERNET") != 0) {
         Log.e("[InMobi]-[Monetization]", "App does not have INTERNET permissions. Please provide INTERNET permissions");
         throw new InvalidManifestConfigException(-1);
      } else if(var0.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
         Log.e("[InMobi]-[Monetization]", "App does not have ACCESS_NETWORK_STATE permissions. Please provide ACCESS_NETWORK_STATE permissions");
         throw new InvalidManifestConfigException(-9);
      } else {
         Iterator var2 = var0.getPackageManager().queryIntentActivities(new Intent(var0, IMBrowserActivity.class), 65536).iterator();

         ResolveInfo var3;
         do {
            if(!var2.hasNext()) {
               var3 = null;
               break;
            }

            var3 = (ResolveInfo)var2.next();
         } while(!var3.activityInfo.name.contentEquals("com.inmobi.androidsdk.IMBrowserActivity"));

         if(var3 == null) {
            Log.e("[InMobi]-[Monetization]", "IMBrowserActivity not declared in the manifest. Please declare it in the app manifest");
            throw new InvalidManifestConfigException(-2);
         } else {
            int var1 = var3.activityInfo.configChanges;
            if(var1 == 0) {
               Log.e("[InMobi]-[Monetization]", "IMBrowserActivity in the manifest does not have android:configChanges attributes.Please add android:configChanges=keyboardHidden|orientation|keyboard|screenSize|smallestScreenSize to IMBrowserActivity in the app manifest");
               throw new InvalidManifestConfigException(-3);
            } else if((var1 & 16) == 0) {
               Log.e("[InMobi]-[Monetization]", "Missing Config keyboard from android:configChangesof IMBRowserActivity");
               throw new InvalidManifestConfigException(-4);
            } else if((var1 & 32) == 0) {
               Log.e("[InMobi]-[Monetization]", "Missing Config keyboardHidden from android:configChangesof IMBRowserActivity");
               throw new InvalidManifestConfigException(-5);
            } else if((var1 & 128) == 0) {
               Log.e("[InMobi]-[Monetization]", "Missing Config orientation from android:configChangesof IMBRowserActivity");
               throw new InvalidManifestConfigException(-6);
            } else {
               if(VERSION.SDK_INT >= 13) {
                  if((var1 & 1024) == 0) {
                     Log.e("[InMobi]-[Monetization]", "Missing Config screenSize from android:configChangesof IMBRowserActivity");
                     throw new InvalidManifestConfigException(-7);
                  }

                  if((var1 & 2048) == 0) {
                     Log.e("[InMobi]-[Monetization]", "Missing Config smallestScreenSize from android:configChanges of IMBRowserActivity");
                     throw new InvalidManifestConfigException(-8);
                  }
               }

            }
         }
      }
   }
}
