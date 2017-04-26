package com.tapjoy;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import com.tapjoy.TJAwardCurrencyListener;
import com.tapjoy.TJEarnedCurrencyListener;
import com.tapjoy.TJGetCurrencyBalanceListener;
import com.tapjoy.TJSpendCurrencyListener;
import com.tapjoy.TapjoyConnectCore;
import com.tapjoy.TapjoyHttpURLResponse;
import com.tapjoy.TapjoyLog;
import com.tapjoy.TapjoyURLConnection;
import com.tapjoy.TapjoyUtil;
import java.util.Map;
import java.util.UUID;

public class TJCurrency {
   private static TJGetCurrencyBalanceListener d;
   private static TJSpendCurrencyListener e;
   private static TJAwardCurrencyListener f;
   private static TJEarnedCurrencyListener g;
   String a = null;
   int b = 0;
   Context c;

   public TJCurrency(Context var1) {
      this.c = var1;
   }

   private void a(TapjoyHttpURLResponse param1) {
      // $FF: Couldn't be decompiled
   }

   private void b(TapjoyHttpURLResponse param1) {
      // $FF: Couldn't be decompiled
   }

   private void c(TapjoyHttpURLResponse param1) {
      // $FF: Couldn't be decompiled
   }

   public void awardCurrency(int var1, TJAwardCurrencyListener var2) {
      if(var1 < 0) {
         TapjoyLog.e("TJCurrency", "awardCurrency error: amount must be a positive number");
      } else {
         this.b = var1;
         f = var2;
         (new Thread(new Runnable() {
            public final void run() {
               String var3 = UUID.randomUUID().toString();
               long var1 = System.currentTimeMillis() / 1000L;
               Map var4 = TapjoyConnectCore.getGenericURLParams();
               TapjoyUtil.safePut(var4, "tap_points", String.valueOf(TJCurrency.this.b), true);
               TapjoyUtil.safePut(var4, "guid", var3, true);
               TapjoyUtil.safePut(var4, "timestamp", String.valueOf(var1), true);
               TapjoyUtil.safePut(var4, "verifier", TapjoyConnectCore.getAwardCurrencyVerifier(var1, TJCurrency.this.b, var3), true);
               TapjoyHttpURLResponse var5 = (new TapjoyURLConnection()).getResponseFromURL(TapjoyConnectCore.getHostURL() + "points/award?", var4);
               TJCurrency.this.c(var5);
            }
         })).start();
      }
   }

   public void getCurrencyBalance(TJGetCurrencyBalanceListener var1) {
      d = var1;
      (new Thread(new Runnable() {
         public final void run() {
            TapjoyHttpURLResponse var1 = (new TapjoyURLConnection()).getResponseFromURL(TapjoyConnectCore.getHostURL() + "get_vg_store_items/user_account?", TapjoyConnectCore.getURLParams());
            TJCurrency.this.a(var1);
         }
      })).start();
   }

   public int getLocalCurrencyBalance() {
      return this.c.getSharedPreferences("tjcPrefrences", 0).getInt("last_currency_balance", -9999);
   }

   public void saveCurrencyBalance(int var1) {
      Editor var2 = this.c.getSharedPreferences("tjcPrefrences", 0).edit();
      var2.putInt("last_currency_balance", var1);
      var2.commit();
   }

   public void setEarnedCurrencyListener(TJEarnedCurrencyListener var1) {
      g = var1;
   }

   public void spendCurrency(int var1, TJSpendCurrencyListener var2) {
      if(var1 < 0) {
         TapjoyLog.e("TJCurrency", "spendCurrency error: amount must be a positive number");
      } else {
         this.a = "" + var1;
         e = var2;
         (new Thread(new Runnable() {
            public final void run() {
               Map var1 = TapjoyConnectCore.getURLParams();
               TapjoyUtil.safePut(var1, "tap_points", TJCurrency.this.a, true);
               TapjoyHttpURLResponse var2 = (new TapjoyURLConnection()).getResponseFromURL(TapjoyConnectCore.getHostURL() + "points/spend?", var1);
               TJCurrency.this.b(var2);
            }
         })).start();
      }
   }
}
