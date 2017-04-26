package com.flurry.sdk;

import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.SparseArray;
import com.flurry.sdk.eo;
import java.util.Iterator;
import java.util.List;

public final class bb implements com.flurry.sdk.bf {
   private static final String a = com.flurry.sdk.bb.class.getSimpleName();
   private static final SparseArray b = a();

   @TargetApi(13)
   private static SparseArray a() {
      SparseArray var0 = new SparseArray();
      var0.append(1, "mcc");
      var0.append(2, "mnc");
      var0.append(4, "locale");
      var0.append(8, "touchscreen");
      var0.append(16, "keyboard");
      var0.append(32, "keyboardHidden");
      var0.append(64, "navigation");
      var0.append(128, "orientation");
      var0.append(256, "screenLayout");
      var0.append(512, "uiMode");
      var0.append(1024, "screenSize");
      var0.append(2048, "smallestScreenSize");
      return var0;
   }

   private boolean a(String var1, PackageManager var2, String var3, ActivityInfo var4) {
      if(!TextUtils.isEmpty(var1) && var2 != null && !TextUtils.isEmpty(var3) && var4 != null && !TextUtils.isEmpty(var4.name)) {
         ActivityInfo var11 = com.flurry.sdk.cb.a(var2, new ComponentName(var3, var4.name));
         if(var11 == null) {
            eo.b(a, var1 + ": package=\"" + var3 + "\": AndroidManifest.xml should include activity node with android:name=\"" + var4.name + "\"");
            return false;
         } else {
            eo.a(3, a, var1 + ": package=\"" + var3 + "\": AndroidManifest.xml has activity node with android:name=\"" + var4.name + "\"");
            int var6 = var4.configChanges;
            boolean var10;
            if(var6 != 0) {
               int var7 = com.flurry.sdk.cb.a(var11);
               SparseArray var12 = b();
               int var5 = 0;
               boolean var9 = true;

               while(true) {
                  var10 = var9;
                  if(var5 >= var12.size()) {
                     break;
                  }

                  int var8 = var12.keyAt(var5);
                  var10 = var9;
                  if((var8 & var6) != 0) {
                     if((var8 & var7) == 0) {
                        eo.b(a, var1 + ": package=\"" + var3 + "\": AndroidManifest.xml activity node with android:name=\"" + var4.name + "\" should include android:configChanges value=\"" + (String)var12.valueAt(var5) + "\"");
                        var10 = false;
                     } else {
                        eo.a(3, a, var1 + ": package=\"" + var3 + "\": AndroidManifest.xml activity node with android:name=\"" + var4.name + "\" has android:configChanges value=\"" + (String)var12.valueAt(var5) + "\"");
                        var10 = var9;
                     }
                  }

                  ++var5;
                  var9 = var10;
               }
            } else {
               var10 = true;
            }

            return var10;
         }
      } else {
         return false;
      }
   }

   private static SparseArray b() {
      return b;
   }

   public final boolean a(Context var1, com.flurry.sdk.bj var2) {
      if(var2 != null) {
         String var4 = var2.a();
         if(!TextUtils.isEmpty(var4)) {
            List var5 = var2.e();
            if(var5 != null) {
               PackageManager var7 = var1.getPackageManager();
               String var6 = var1.getPackageName();
               Iterator var8 = var5.iterator();
               boolean var3 = true;

               while(var8.hasNext()) {
                  if(!this.a(var4, var7, var6, (ActivityInfo)var8.next())) {
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
