package com.flurry.sdk;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.flurry.sdk.eo;
import java.util.Iterator;
import java.util.List;

public final class bi implements com.flurry.sdk.bf {
   private static final String a = com.flurry.sdk.bi.class.getSimpleName();

   private boolean a(String var1, PackageManager var2, String var3, String var4) {
      if(!TextUtils.isEmpty(var1) && var2 != null && !TextUtils.isEmpty(var3) && !TextUtils.isEmpty(var4)) {
         if(-1 == var2.checkPermission(var4, var3)) {
            eo.b(a, var1 + ": package=\"" + var3 + "\": AndroidManifest.xml should include uses-permission node with android:name=\"" + var4 + "\"");
            return false;
         } else {
            eo.a(3, a, var1 + ": package=\"" + var3 + "\": AndroidManifest.xml has uses-permission node with android:name=\"" + var4 + "\"");
            return true;
         }
      } else {
         return false;
      }
   }

   public final boolean a(Context var1, com.flurry.sdk.bj var2) {
      if(var2 != null) {
         String var4 = var2.a();
         if(!TextUtils.isEmpty(var4)) {
            List var5 = var2.d();
            if(var5 != null) {
               PackageManager var7 = var1.getPackageManager();
               String var6 = var1.getPackageName();
               Iterator var8 = var5.iterator();
               boolean var3 = true;

               while(var8.hasNext()) {
                  if(!this.a(var4, var7, var6, (String)var8.next())) {
                     var3 = false;
                  }
               }

               return var3;
            }
         }
      }

      return false;
   }
}
