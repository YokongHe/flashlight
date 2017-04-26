package com.flurry.android;

import android.content.Context;
import android.os.Looper;
import android.os.Build.VERSION;
import android.view.ViewGroup;
import com.flurry.android.FlurryAdListener;
import com.flurry.android.FlurryAdSize;
import com.flurry.android.ICustomAdNetworkHandler;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.sdk.dz;
import com.flurry.sdk.eo;
import java.util.Map;

public class FlurryAds {
   private static final String a = FlurryAds.class.getSimpleName();

   public static void clearLocation() {
      if(VERSION.SDK_INT < 10) {
         eo.b(a, "Device SDK Version older than 10");
      } else {
         dz.a().e();
      }
   }

   public static void clearTargetingKeywords() {
      if(VERSION.SDK_INT < 10) {
         eo.b(a, "Device SDK Version older than 10");
      } else {
         FlurryAdModule.getInstance().A();
      }
   }

   public static void clearUserCookies() {
      if(VERSION.SDK_INT < 10) {
         eo.b(a, "Device SDK Version older than 10");
      } else {
         FlurryAdModule.getInstance().y();
      }
   }

   public static void displayAd(Context var0, String var1, ViewGroup var2) {
      if(VERSION.SDK_INT < 10) {
         eo.b(a, "Device SDK Version older than 10");
      } else if(var0 == null) {
         eo.b(a, "Context passed to displayAd was null.");
      } else if(var1 == null) {
         eo.b(a, "Ad space name passed to displayAd was null.");
      } else if(var1.length() == 0) {
         eo.b(a, "Ad space name passed to displayAd was empty.");
      } else if(var2 == null) {
         eo.b(a, "ViewGroup passed to displayAd was null.");
      } else {
         try {
            FlurryAdModule.getInstance().d().a(var0, var1, var2);
         } catch (Throwable var3) {
            eo.a(a, "Exception while displaying Ad: ", var3);
         }
      }
   }

   public static void enableTestAds(boolean var0) {
      if(VERSION.SDK_INT < 10) {
         eo.b(a, "Device SDK Version older than 10");
      } else {
         FlurryAdModule.getInstance().a(var0);
      }
   }

   public static void fetchAd(Context var0, String var1, ViewGroup var2, FlurryAdSize var3) {
      if(VERSION.SDK_INT < 10) {
         eo.b(a, "Device SDK Version older than 10");
      } else if(var0 == null) {
         eo.b(a, "Context passed to fetchAd was null.");
      } else if(var1 == null) {
         eo.b(a, "Ad space name passed to fetchAd was null.");
      } else if(var1.length() == 0) {
         eo.b(a, "Ad space name passed to fetchAd was empty.");
      } else if(var2 == null) {
         eo.b(a, "ViewGroup passed to fetchAd was null.");
      } else if(var3 == null) {
         eo.b(a, "FlurryAdSize passed to fetchAd was null.");
      } else {
         try {
            FlurryAdModule.getInstance().d().a(var0, var1, var2, var3, false);
         } catch (Throwable var4) {
            eo.a(a, "Exception while fetching Ad: ", var4);
         }
      }
   }

   @Deprecated
   public static boolean getAd(Context var0, String var1, ViewGroup var2, FlurryAdSize var3, long var4) {
      if(VERSION.SDK_INT < 10) {
         eo.b(a, "Device SDK Version older than 10");
         return false;
      } else if(var0 == null) {
         eo.b(a, "Context passed to getAd was null.");
         return false;
      } else if(var1 == null) {
         eo.b(a, "Ad space name passed to getAd was null.");
         return false;
      } else if(var1.length() == 0) {
         eo.b(a, "Ad space name passed to getAd was empty.");
         return false;
      } else if(var2 == null) {
         eo.b(a, "ViewGroup passed to getAd was null.");
         return false;
      } else if(var3 == null) {
         eo.b(a, "FlurryAdSize passed to getAd was null.");
         return false;
      } else if(Looper.getMainLooper().getThread() != Thread.currentThread()) {
         eo.b(a, "getAd must be called from UI thread.");
         return false;
      } else {
         try {
            boolean var6 = FlurryAdModule.getInstance().d().a(var0, var1, var2, var3);
            return var6;
         } catch (Throwable var7) {
            eo.a(a, "Exception while getting Ad : ", var7);
            return false;
         }
      }
   }

   @Deprecated
   public static void initializeAds(Context var0) {
   }

   @Deprecated
   public static boolean isAdAvailable(Context var0, String var1, FlurryAdSize var2, long var3) {
      if(VERSION.SDK_INT < 10) {
         eo.b(a, "Device SDK Version older than 10");
         return false;
      } else if(var0 == null) {
         eo.b(a, "Context passed to isAdAvailable was null.");
         return false;
      } else if(var1 == null) {
         eo.b(a, "Ad space name passed to isAdAvailable was null.");
         return false;
      } else if(var1.length() == 0) {
         eo.b(a, "Ad space name passed to isAdAvailable was empty.");
         return false;
      } else if(var2 == null) {
         eo.b(a, "FlurryAdSize passed to isAdAvailable was null.");
         return false;
      } else {
         try {
            boolean var5 = FlurryAdModule.getInstance().d().a(var0, var1, var2);
            return var5;
         } catch (Throwable var6) {
            eo.a(a, "Exception while checking Ads if available: ", var6);
            return false;
         }
      }
   }

   public static boolean isAdReady(String var0) {
      if(VERSION.SDK_INT < 10) {
         eo.b(a, "Device SDK Version older than 10");
         return false;
      } else if(var0 == null) {
         eo.b(a, "Ad space name passed to isAdReady was null.");
         return false;
      } else if(var0.length() == 0) {
         eo.b(a, "Ad space name passed to isAdReady was empty.");
         return false;
      } else {
         return FlurryAdModule.getInstance().d().a(var0);
      }
   }

   public static void removeAd(Context var0, String var1, ViewGroup var2) {
      if(VERSION.SDK_INT < 10) {
         eo.b(a, "Device SDK Version older than 10");
      } else if(var0 == null) {
         eo.b(a, "Context passed to removeAd was null.");
      } else if(var1 == null) {
         eo.b(a, "Ad space name passed to removeAd was null.");
      } else if(var1.length() == 0) {
         eo.b(a, "Ad space name passed to removeAd was empty.");
      } else if(var2 == null) {
         eo.b(a, "ViewGroup passed to removeAd was null.");
      } else {
         try {
            FlurryAdModule.getInstance().d().a(var0, var1);
         } catch (Throwable var3) {
            eo.a(a, "Exception while removing Ad: ", var3);
         }
      }
   }

   public static void setAdListener(FlurryAdListener var0) {
      if(VERSION.SDK_INT < 10) {
         eo.b(a, "Device SDK Version older than 10");
      } else {
         FlurryAdModule.getInstance().a(var0);
      }
   }

   public static void setAdLogUrl(String var0) {
      if(VERSION.SDK_INT < 10) {
         eo.b(a, "Device SDK Version older than 10");
      } else {
         FlurryAdModule.getInstance().f(var0);
      }
   }

   public static void setAdServerUrl(String var0) {
      if(VERSION.SDK_INT < 10) {
         eo.b(a, "Device SDK Version older than 10");
      } else {
         FlurryAdModule.getInstance().e(var0);
      }
   }

   public static void setCustomAdNetworkHandler(ICustomAdNetworkHandler var0) {
      if(VERSION.SDK_INT < 10) {
         eo.b(a, "Device SDK Version older than 10");
      } else if(var0 == null) {
         eo.b(a, "ICustomAdNetworkHandler passed to setCustomAdNetworkHandler was null.");
      } else {
         FlurryAdModule.getInstance().a(var0);
      }
   }

   public static void setLocation(float var0, float var1) {
      if(VERSION.SDK_INT < 10) {
         eo.b(a, "Device SDK Version older than 10");
      } else {
         dz.a().a(var0, var1);
      }
   }

   public static void setTargetingKeywords(Map var0) {
      if(VERSION.SDK_INT < 10) {
         eo.b(a, "Device SDK Version older than 10");
      } else {
         if(var0 == null) {
            eo.b(a, "targetingKeywords Map passed to setTargetingKeywords was null.");
            return;
         }

         if(var0 != null) {
            FlurryAdModule.getInstance().b(var0);
            return;
         }
      }

   }

   public static void setUserCookies(Map var0) {
      if(VERSION.SDK_INT < 10) {
         eo.b(a, "Device SDK Version older than 10");
      } else if(var0 == null) {
         eo.b(a, "userCookies Map passed to setUserCookies was null.");
      } else {
         FlurryAdModule.getInstance().a(var0);
      }
   }
}
