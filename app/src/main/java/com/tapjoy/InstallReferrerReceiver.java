package com.tapjoy;

import android.content.Context;
import android.content.Intent;
import com.tapjoy.internal.fv;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class InstallReferrerReceiver extends com.tapjoy.internal.l {
   public void onReceive(Context var1, Intent var2) {
      String var4 = fv.a(var1, var2);
      int var3 = this.a(var1, var2);
      if(var2.getBooleanExtra("fiverocks:verify", false) && this.isOrderedBroadcast()) {
         this.setResultCode(var3 + 1);
         if(var4 != null) {
            try {
               this.setResultData("http://play.google.com/store/apps/details?id=" + var1.getPackageName() + "&referrer=" + URLEncoder.encode(var4, "UTF-8"));
            } catch (UnsupportedEncodingException var5) {
               return;
            }
         }
      }

   }
}
