package com.tapjoy;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tapjoy.TJCOffersWebView;
import com.tapjoy.TJOffersListener;
import com.tapjoy.TJPlacementData;
import com.tapjoy.TapjoyConnectCore;
import com.tapjoy.TapjoyLog;
import com.tapjoy.TapjoyUtil;
import java.util.HashMap;

public class TJCOffers {
   private static TJOffersListener b;
   Context a;

   public TJCOffers(Context var1) {
      this.a = var1;
   }

   public static void onOffersResponse() {
      if(b != null) {
         b.onOffersResponse();
      }

   }

   public static void onOffersResponseFailed(String var0) {
      if(b != null) {
         b.onOffersResponseFailure(var0);
      }

   }

   public void showOffers(TJOffersListener var1) {
      this.showOffersWithCurrencyID((String)null, false, var1);
   }

   public void showOffersWithCurrencyID(String var1, boolean var2, TJOffersListener var3) {
      this.showOffersWithCurrencyID(var1, var2, (TJPlacementData)null, (String)null, var3);
   }

   public void showOffersWithCurrencyID(String var1, boolean var2, TJPlacementData var3, String var4, TJOffersListener var5) {
      if(!TapjoyConnectCore.isViewOpen()) {
         TapjoyConnectCore.viewWillOpen(1);
         b = var5;
         String var8;
         if(var2) {
            var8 = "1";
         } else {
            var8 = "0";
         }

         HashMap var6 = new HashMap(TapjoyConnectCore.getURLParams());
         TapjoyUtil.safePut(var6, "currency_id", var1, true);
         TapjoyUtil.safePut(var6, "currency_selector", var8, true);
         Intent var7 = new Intent(this.a, TJCOffersWebView.class);
         if(var3 != null) {
            TapjoyLog.i("TapjoyOffers", "showOffers for placement: " + var3.name);
         }

         if(var4 != null && var4.length() > 0) {
            var7.putExtra("callback_id", var4);
         }

         var7.putExtra("view_type", 2);
         var7.putExtra("tjplacement", var3);
         var7.putExtra("legacy_view", true);
         var7.putExtra("URL_PARAMS", var6);
         if(!(this.a instanceof Activity)) {
            var7.setFlags(268435456);
            this.a.startActivity(var7);
            return;
         }

         ((Activity)this.a).startActivityForResult(var7, 0);
      }

   }
}
