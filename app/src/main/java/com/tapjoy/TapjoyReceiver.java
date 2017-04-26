package com.tapjoy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import com.tapjoy.internal.fs;
import com.tapjoy.internal.fv;
import com.tapjoy.internal.fx;
import java.util.List;

public class TapjoyReceiver extends BroadcastReceiver {
   public void onReceive(Context var1, Intent var2) {
      fx.a(var1);
      if("com.tapjoy.PUSH_CLICK".equals(var2.getAction())) {
         String var3 = var2.getStringExtra("com.tapjoy.PUSH_ID");
         String var4 = var2.getStringExtra("com.tapjoy.PUSH_PAYLOAD");
         if(var3 != null && var3.length() != 0) {
            PackageManager var5 = var1.getPackageManager();
            String var6 = var1.getPackageName();
            var2 = new Intent("android.intent.action.MAIN");
            var2.setPackage(var6);
            var2.addCategory("android.intent.category.LAUNCHER");
            List var7 = var5.queryIntentActivities(var2, 0);
            if(var7 != null && var7.size() > 0) {
               var2 = new Intent(var2);
               var2.setFlags(268435456);
               var2.setClassName(((ResolveInfo)var7.get(0)).activityInfo.packageName, ((ResolveInfo)var7.get(0)).activityInfo.name);
            } else {
               var2 = null;
            }

            if(var2 != null) {
               if(var4 != null) {
                  var2.putExtra("com.tapjoy.PUSH_PAYLOAD", var4);
               }

               fv.a(var1).d(var3);
               var1.startActivity(var2);
            } else {
               fs.b("No intent that can be used to launch the main activity.");
            }
         }
      }

      if(this.isOrderedBroadcast()) {
         this.setResult(-1, (String)null, (Bundle)null);
      }

   }
}
