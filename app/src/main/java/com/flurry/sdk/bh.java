package com.flurry.sdk;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.flurry.sdk.dx;
import com.flurry.sdk.eo;
import java.util.Iterator;
import java.util.List;

public final class bh implements com.flurry.sdk.bf {
   private static final String a = com.flurry.sdk.bh.class.getSimpleName();

   private boolean a(String var1, String var2, Bundle var3, String var4) {
      if(!TextUtils.isEmpty(var1) && !TextUtils.isEmpty(var2) && var3 != null && !TextUtils.isEmpty(var4)) {
         String var5 = var3.getString(var4);
         if(TextUtils.isEmpty(var5)) {
            eo.b(a, var1 + ": package=\"" + var2 + "\": AndroidManifest.xml should include meta-data node with android:name=\"" + var4 + "\" and not empty value for android:value");
            return false;
         } else {
            eo.a(3, a, var1 + ": package=\"" + var2 + "\": AndroidManifest.xml has meta-data node with android:name=\"" + var4 + "\" and android:value=\"" + var5 + "\"");
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
            List var5 = var2.c();
            if(var5 != null) {
               Bundle var7 = dx.d(var1);
               String var6 = var1.getPackageName();
               Iterator var8 = var5.iterator();
               boolean var3 = true;

               while(var8.hasNext()) {
                  if(!this.a(var4, var6, var7, (String)var8.next())) {
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
