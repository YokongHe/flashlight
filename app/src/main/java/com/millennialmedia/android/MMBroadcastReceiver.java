package com.millennialmedia.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.millennialmedia.android.MMAd;
import com.millennialmedia.android.MMAdImpl;
import com.millennialmedia.android.MMAdImplController;
import com.millennialmedia.android.MMLog;

@Deprecated
public class MMBroadcastReceiver extends BroadcastReceiver {
   public static final String ACTION_AD_SINGLE_TAP = "millennialmedia.action.ACTION_AD_SINGLE_TAP";
   public static final String ACTION_DISPLAY_STARTED = "millennialmedia.action.ACTION_DISPLAY_STARTED";
   public static final String ACTION_FETCH_FAILED = "millennialmedia.action.ACTION_FETCH_FAILED";
   public static final String ACTION_FETCH_STARTED_CACHING = "millennialmedia.action.ACTION_FETCH_STARTED_CACHING";
   public static final String ACTION_FETCH_SUCCEEDED = "millennialmedia.action.ACTION_FETCH_SUCCEEDED";
   public static final String ACTION_GETAD_FAILED = "millennialmedia.action.ACTION_GETAD_FAILED";
   public static final String ACTION_GETAD_SUCCEEDED = "millennialmedia.action.ACTION_GETAD_SUCCEEDED";
   public static final String ACTION_INTENT_STARTED = "millennialmedia.action.ACTION_INTENT_STARTED";
   public static final String ACTION_OVERLAY_CLOSED = "millennialmedia.action.ACTION_OVERLAY_CLOSED";
   public static final String ACTION_OVERLAY_OPENED = "millennialmedia.action.ACTION_OVERLAY_OPENED";
   @Deprecated
   public static final String ACTION_OVERLAY_TAP = "millennialmedia.action.ACTION_OVERLAY_TAP";
   public static final String CATEGORY_SDK = "millennialmedia.category.CATEGORY_SDK";
   private static final String TAG = "MMBroadcastReceiver";

   public static IntentFilter createIntentFilter() {
      IntentFilter var0 = new IntentFilter();
      var0.addCategory("millennialmedia.category.CATEGORY_SDK");
      var0.addAction("millennialmedia.action.ACTION_DISPLAY_STARTED");
      var0.addAction("millennialmedia.action.ACTION_FETCH_FAILED");
      var0.addAction("millennialmedia.action.ACTION_FETCH_SUCCEEDED");
      var0.addAction("millennialmedia.action.ACTION_FETCH_STARTED_CACHING");
      var0.addAction("millennialmedia.action.ACTION_GETAD_FAILED");
      var0.addAction("millennialmedia.action.ACTION_GETAD_SUCCEEDED");
      var0.addAction("millennialmedia.action.ACTION_INTENT_STARTED");
      var0.addAction("millennialmedia.action.ACTION_OVERLAY_CLOSED");
      var0.addAction("millennialmedia.action.ACTION_OVERLAY_OPENED");
      var0.addAction("millennialmedia.action.ACTION_OVERLAY_TAP");
      var0.addAction("millennialmedia.action.ACTION_AD_SINGLE_TAP");
      return var0;
   }

   public void displayStarted(MMAd var1) {
      MMLog.i("MMBroadcastReceiver", "Millennial Media display started.");
   }

   public void fetchFailure(MMAd var1) {
      MMLog.i("MMBroadcastReceiver", "Millennial Media fetch failed.");
   }

   public void fetchFinishedCaching(MMAd var1) {
      MMLog.i("MMBroadcastReceiver", "Millennial Media fetch finished caching.");
   }

   public void fetchStartedCaching(MMAd var1) {
      MMLog.i("MMBroadcastReceiver", "Millennial Media fetch started caching.");
   }

   public void getAdFailure(MMAd var1) {
      MMLog.i("MMBroadcastReceiver", "Millennial Media ad Failure.");
   }

   public void getAdSuccess(MMAd var1) {
      MMLog.i("MMBroadcastReceiver", "Millennial Media ad Success.");
   }

   public void intentStarted(MMAd var1, String var2) {
      if(var2 != null) {
         MMLog.i("MMBroadcastReceiver", "Millennial Media started intent: " + var2);
      }

   }

   public void onReceive(Context var1, Intent var2) {
      String var6 = var2.getAction();
      String var7 = var2.getStringExtra("packageName");
      long var3 = var2.getLongExtra("internalId", -4L);
      String var5 = null;
      if(var1.getPackageName().equals(var7)) {
         MMAd var8 = var5;
         if(var3 != -4L) {
            MMAdImpl var9 = MMAdImplController.getAdImplWithId(var3);
            var8 = var5;
            if(var9 != null) {
               var8 = var9.getCallingAd();
            }
         }

         StringBuilder var10 = new StringBuilder(" @@ Intent - Ad in receiver = ");
         if(var8 == null) {
            var5 = " null";
         } else {
            var5 = var8.toString();
         }

         MMLog.v("MMBroadcastReceiver", var10.append(var5).toString());
         if(var6.equals("millennialmedia.action.ACTION_OVERLAY_OPENED")) {
            this.overlayOpened(var8);
            return;
         }

         if(var6.equals("millennialmedia.action.ACTION_OVERLAY_CLOSED")) {
            this.overlayClosed(var8);
            return;
         }

         if(var6.equals("millennialmedia.action.ACTION_OVERLAY_TAP")) {
            this.overlayTap(var8);
            return;
         }

         if(var6.equals("millennialmedia.action.ACTION_AD_SINGLE_TAP")) {
            this.onSingleTap(var8);
            return;
         }

         if(var6.equals("millennialmedia.action.ACTION_DISPLAY_STARTED")) {
            this.displayStarted(var8);
            return;
         }

         if(var6.equals("millennialmedia.action.ACTION_FETCH_FAILED")) {
            this.fetchFailure(var8);
            return;
         }

         if(var6.equals("millennialmedia.action.ACTION_FETCH_SUCCEEDED")) {
            this.fetchFinishedCaching(var8);
            return;
         }

         if(var6.equals("millennialmedia.action.ACTION_FETCH_STARTED_CACHING")) {
            this.fetchStartedCaching(var8);
            return;
         }

         if(var6.equals("millennialmedia.action.ACTION_GETAD_FAILED")) {
            this.getAdFailure(var8);
            return;
         }

         if(var6.equals("millennialmedia.action.ACTION_GETAD_SUCCEEDED")) {
            this.getAdSuccess(var8);
            return;
         }

         if(var6.equals("millennialmedia.action.ACTION_INTENT_STARTED")) {
            this.intentStarted(var8, var2.getStringExtra("intentType"));
            return;
         }
      }

   }

   public void onSingleTap(MMAd var1) {
      MMLog.i("MMBroadcastReceiver", "Millennial Media ad Tap.");
   }

   public void overlayClosed(MMAd var1) {
      MMLog.i("MMBroadcastReceiver", "Millennial Media overlay closed.");
   }

   public void overlayOpened(MMAd var1) {
      MMLog.i("MMBroadcastReceiver", "Millennial Media overlay opened.");
   }

   @Deprecated
   public void overlayTap(MMAd var1) {
      MMLog.i("MMBroadcastReceiver", "Millennial Media overlay Tap.");
   }
}
