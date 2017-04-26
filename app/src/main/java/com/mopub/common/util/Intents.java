package com.mopub.common.util;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.exceptions.IntentNotResolvableException;
import com.mopub.exceptions.UrlParseException;

public class Intents {
   private static final String HTTP = "http";
   private static final String HTTPS = "https";
   private static final String MARKET = "market";
   private static final String MARKET_ANDROID_COM = "market.android.com";
   private static final String PLAY_GOOGLE_COM = "play.google.com";
   private static final String TWITTER_APPLICATION_DEEPLINK_URL = "twitter://timeline";

   public static boolean canHandleApplicationUrl(Context var0, String var1) {
      return canHandleApplicationUrl(var0, var1, true);
   }

   public static boolean canHandleApplicationUrl(Context var0, String var1, boolean var2) {
      if(!deviceCanHandleIntent(var0, new Intent("android.intent.action.VIEW", Uri.parse(var1)))) {
         if(var2) {
            MoPubLog.w("Could not handle application specific action: " + var1 + ". You may be running in the emulator or another device which does not " + "have the required application.");
         }

         return false;
      } else {
         return true;
      }
   }

   public static boolean canHandleTwitterUrl(Context var0) {
      return canHandleApplicationUrl(var0, "twitter://timeline", false);
   }

   public static boolean deviceCanHandleIntent(Context var0, Intent var1) {
      boolean var2;
      try {
         var2 = var0.getPackageManager().queryIntentActivities(var1, 0).isEmpty();
      } catch (NullPointerException var3) {
         return false;
      }

      return !var2;
   }

   public static Intent getStartActivityIntent(Context var0, Class var1, Bundle var2) {
      Intent var3 = new Intent(var0, var1);
      if(!(var0 instanceof Activity)) {
         var3.addFlags(268435456);
      }

      if(var2 != null) {
         var3.putExtras(var2);
      }

      return var3;
   }

   public static Intent intentForNativeBrowserScheme(String var0) {
      Preconditions.checkNotNull(var0);
      if(!isNativeBrowserScheme(var0)) {
         throw new UrlParseException("URL does not have mopubnativebrowser:// scheme.");
      } else {
         Uri var1 = Uri.parse(var0);
         if(!"navigate".equals(var1.getHost())) {
            throw new UrlParseException("URL missing \'navigate\' host parameter.");
         } else {
            String var3;
            try {
               var3 = var1.getQueryParameter("url");
            } catch (UnsupportedOperationException var2) {
               MoPubLog.w("Could not handle url: " + var0);
               throw new UrlParseException("Passed-in URL did not create a hierarchical URI.");
            }

            if(var3 == null) {
               throw new UrlParseException("URL missing \'url\' query parameter.");
            } else {
               return new Intent("android.intent.action.VIEW", Uri.parse(var3));
            }
         }
      }
   }

   private static boolean isAppStoreUrl(String var0) {
      if(var0 != null) {
         Uri var1 = Uri.parse(var0);
         var0 = var1.getScheme();
         String var2 = var1.getHost();
         if("play.google.com".equals(var2) || "market.android.com".equals(var2)) {
            return true;
         }

         if("market".equals(var0)) {
            return true;
         }
      }

      return false;
   }

   public static boolean isDeepLink(String var0) {
      return isAppStoreUrl(var0) || !isHttpUrl(var0);
   }

   public static boolean isHttpUrl(String var0) {
      if(var0 != null) {
         var0 = Uri.parse(var0).getScheme();
         if("http".equals(var0) || "https".equals(var0)) {
            return true;
         }
      }

      return false;
   }

   public static boolean isNativeBrowserScheme(String var0) {
      return var0.startsWith("mopubnativebrowser://");
   }

   public static void startActivity(Context var0, Intent var1) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkNotNull(var1);
      if(!(var0 instanceof Activity)) {
         var1.addFlags(268435456);
      }

      try {
         var0.startActivity(var1);
      } catch (ActivityNotFoundException var2) {
         throw new IntentNotResolvableException(var2);
      }
   }
}
