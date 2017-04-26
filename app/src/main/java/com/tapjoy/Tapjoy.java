package com.tapjoy;

import android.app.Activity;
import android.content.Context;
import android.opengl.GLSurfaceView;
import com.tapjoy.TJAwardCurrencyListener;
import com.tapjoy.TJConnectListener;
import com.tapjoy.TJEarnedCurrencyListener;
import com.tapjoy.TJGetCurrencyBalanceListener;
import com.tapjoy.TJOffersListener;
import com.tapjoy.TJSpendCurrencyListener;
import com.tapjoy.TJVideoListener;
import com.tapjoy.TJViewListener;
import com.tapjoy.internal.dy;
import java.util.Hashtable;
import java.util.Map;

public final class Tapjoy {
   public static void actionComplete(String var0) {
      dy.a().e(var0);
   }

   public static void awardCurrency(int var0, TJAwardCurrencyListener var1) {
      dy.a().a(var0, var1);
   }

   public static boolean connect(Context var0, String var1) {
      return dy.a().a(var0, var1);
   }

   public static boolean connect(Context var0, String var1, Hashtable var2) {
      return dy.a().a((Context)var0, var1, (Hashtable)var2, (TJConnectListener)null);
   }

   public static boolean connect(Context var0, String var1, Hashtable var2, TJConnectListener var3) {
      synchronized(Tapjoy.class){}

      boolean var4;
      try {
         var4 = dy.a().a(var0, var1, var2, var3);
      } finally {
         ;
      }

      return var4;
   }

   public static void enablePaidAppWithActionID(String var0) {
      dy.a().d(var0);
   }

   public static void endSession() {
      dy.a().f();
   }

   public static void getCurrencyBalance(TJGetCurrencyBalanceListener var0) {
      dy.a().a(var0);
   }

   public static float getCurrencyMultiplier() {
      return dy.a().d();
   }

   public static String getVersion() {
      return dy.a().b();
   }

   public static boolean isConnected() {
      return dy.a().g();
   }

   public static void loadSharedLibrary() {
      try {
         System.loadLibrary("tapjoy");
      } catch (UnsatisfiedLinkError var1) {
         ;
      }
   }

   public static void onActivityStart(Activity var0) {
      dy.a().a(var0);
   }

   public static void onActivityStop(Activity var0) {
      dy.a().b(var0);
   }

   public static void setAppDataVersion(String var0) {
      dy.a().c(var0);
   }

   public static void setCurrencyMultiplier(float var0) {
      dy.a().a(var0);
   }

   public static void setDebugEnabled(boolean var0) {
      dy.a().a(var0);
   }

   public static void setEarnedCurrencyListener(TJEarnedCurrencyListener var0) {
      dy.a().a(var0);
   }

   public static void setGLSurfaceView(GLSurfaceView var0) {
      dy.a().a(var0);
   }

   public static void setGcmSender(String var0) {
      dy.a().f(var0);
   }

   public static void setTapjoyViewListener(TJViewListener var0) {
      dy.a().a(var0);
   }

   public static void setUserCohortVariable(int var0, String var1) {
      dy.a().a(var0, var1);
   }

   public static void setUserFriendCount(int var0) {
      dy.a().b(var0);
   }

   public static void setUserID(String var0) {
      dy.a().b(var0);
   }

   public static void setUserLevel(int var0) {
      dy.a().a(var0);
   }

   public static void setVideoListener(TJVideoListener var0) {
      dy.a().a(var0);
   }

   public static void showOffers() {
      dy.a().c();
   }

   public static void showOffers(TJOffersListener var0) {
      dy.a().a(var0);
   }

   public static void showOffersWithCurrencyID(String var0, boolean var1) {
      dy.a().a(var0, var1);
   }

   public static void showOffersWithCurrencyID(String var0, boolean var1, TJOffersListener var2) {
      dy.a().a(var0, var1, var2);
   }

   public static void spendCurrency(int var0, TJSpendCurrencyListener var1) {
      dy.a().a(var0, var1);
   }

   public static void startSession() {
      dy.a().e();
   }

   public static void trackEvent(String var0) {
      dy.a().a(var0);
   }

   public static void trackEvent(String var0, long var1) {
      dy.a().a(var0, var1);
   }

   public static void trackEvent(String var0, String var1, long var2) {
      dy.a().a(var0, var1, var2);
   }

   public static void trackEvent(String var0, String var1, String var2, String var3) {
      dy.a().a(var0, var1, var2, var3);
   }

   public static void trackEvent(String var0, String var1, String var2, String var3, long var4) {
      dy.a().a(var0, var1, var2, var3, var4);
   }

   public static void trackEvent(String var0, String var1, String var2, String var3, String var4, long var5) {
      dy.a().a(var0, var1, var2, var3, var4, var5);
   }

   public static void trackEvent(String var0, String var1, String var2, String var3, String var4, long var5, String var7, long var8) {
      dy.a().a(var0, var1, var2, var3, var4, var5, var7, var8);
   }

   public static void trackEvent(String var0, String var1, String var2, String var3, String var4, long var5, String var7, long var8, String var10, long var11) {
      dy.a().a(var0, var1, var2, var3, var4, var5, var7, var8, var10, var11);
   }

   public static void trackEvent(String var0, String var1, String var2, String var3, Map var4) {
      dy.a().a(var0, var1, var2, var3, var4);
   }

   public static void trackPurchase(String var0, String var1) {
      dy.a().a(var0, var1);
   }

   public static void trackPurchase(String var0, String var1, double var2, String var4) {
      dy.a().a(var0, var1, var2, var4);
   }
}
