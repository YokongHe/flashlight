package com.millennialmedia.android;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.millennialmedia.android.HttpGetRequest;
import com.millennialmedia.android.MMAdImpl;
import com.millennialmedia.android.MMException;
import com.millennialmedia.android.MMLog;
import com.millennialmedia.android.MMSDK;
import com.millennialmedia.android.Utils$ThreadUtils;

class MMSDK$Event {
   public static final String INTENT_CALENDAR_EVENT = "calendar";
   public static final String INTENT_EMAIL = "email";
   public static final String INTENT_EXTERNAL_BROWSER = "browser";
   public static final String INTENT_MAPS = "geo";
   public static final String INTENT_MARKET = "market";
   public static final String INTENT_PHONE_CALL = "tel";
   public static final String INTENT_STREAMING_VIDEO = "streamingVideo";
   public static final String INTENT_TXT_MESSAGE = "sms";
   private static final String KEY_ERROR = "error";
   static final String KEY_INTENT_TYPE = "intentType";
   static final String KEY_INTERNAL_ID = "internalId";
   static final String KEY_PACKAGE_NAME = "packageName";
   protected static final String TAG = MMSDK$Event.class.getName();

   static void adSingleTap(final MMAdImpl var0) {
      if(var0 != null) {
         MMSDK.runOnUiThread(new Runnable() {
            public final void run() {
               if(var0 != null && var0.requestListener != null) {
                  try {
                     var0.requestListener.onSingleTap(var0.getCallingAd());
                  } catch (Exception var2) {
                     MMLog.e("MMSDK", "Exception raised in your RequestListener: ", var2);
                     return;
                  }
               }

            }
         });
         if(MMSDK.access$000()) {
            sendIntent(var0.getContext(), new Intent("millennialmedia.action.ACTION_OVERLAY_TAP"), var0.internalId);
            sendIntent(var0.getContext(), new Intent("millennialmedia.action.ACTION_AD_SINGLE_TAP"), var0.internalId);
            return;
         }
      }

   }

   static void displayStarted(MMAdImpl var0) {
      if(var0 == null) {
         MMLog.w("MMSDK", "No Context in the listener: ");
      } else {
         if(MMSDK.access$000()) {
            sendIntent(var0.getContext(), new Intent("millennialmedia.action.ACTION_DISPLAY_STARTED"), var0.internalId);
         }

         overlayOpened(var0);
      }
   }

   static void fetchStartedCaching(final MMAdImpl var0) {
      if(var0 == null) {
         MMLog.w("MMSDK", "No Context in the listener: ");
      } else {
         MMSDK.runOnUiThread(new Runnable() {
            public final void run() {
               if(var0 != null && var0.requestListener != null) {
                  try {
                     var0.requestListener.MMAdRequestIsCaching(var0.getCallingAd());
                  } catch (Exception var2) {
                     MMLog.e("MMSDK", "Exception raised in your RequestListener: ", var2);
                     return;
                  }
               }

            }
         });
         if(MMSDK.access$000()) {
            sendIntent(var0.getContext(), new Intent("millennialmedia.action.ACTION_FETCH_STARTED_CACHING"), var0.internalId);
            return;
         }
      }

   }

   static void intentStarted(Context var0, String var1, long var2) {
      if(MMSDK.access$000() && var1 != null) {
         sendIntent(var0, (new Intent("millennialmedia.action.ACTION_INTENT_STARTED")).putExtra("intentType", var1), var2);
      }

   }

   protected static void logEvent(final String var0) {
      MMLog.d("Logging event to: %s", var0);
      Utils$ThreadUtils.execute(new Runnable() {
         public final void run() {
            HttpGetRequest var1 = new HttpGetRequest();

            try {
               var1.get(var0);
            } catch (Exception var2) {
               MMLog.e(MMSDK$Event.TAG, "Error logging event: ", var2);
            }
         }
      });
   }

   static void overlayClosed(final MMAdImpl var0) {
      if(var0 == null) {
         MMLog.w("MMSDK", "No Context in the listener: ");
      } else {
         MMSDK.runOnUiThread(new Runnable() {
            public final void run() {
               if(var0 != null && var0.requestListener != null) {
                  try {
                     var0.requestListener.MMAdOverlayClosed(var0.getCallingAd());
                  } catch (Exception var2) {
                     MMLog.e("MMSDK", "Exception raised in your RequestListener: ", var2);
                     return;
                  }
               }

            }
         });
         if(MMSDK.access$000() && var0.getContext() != null) {
            sendIntent(var0.getContext(), new Intent("millennialmedia.action.ACTION_OVERLAY_CLOSED"), var0.internalId);
            return;
         }
      }

   }

   static void overlayOpened(final MMAdImpl var0) {
      if(var0 == null) {
         MMLog.w("MMSDK", "No Context in the listener: ");
      } else {
         MMSDK.runOnUiThread(new Runnable() {
            public final void run() {
               if(var0 != null && var0.requestListener != null) {
                  try {
                     var0.requestListener.MMAdOverlayLaunched(var0.getCallingAd());
                  } catch (Exception var2) {
                     MMLog.e("MMSDK", "Exception raised in your RequestListener: ", var2);
                     return;
                  }
               }

            }
         });
         overlayOpenedBroadCast(var0.getContext(), var0.internalId);
      }
   }

   static void overlayOpenedBroadCast(Context var0, long var1) {
      if(MMSDK.access$000()) {
         sendIntent(var0, new Intent("millennialmedia.action.ACTION_OVERLAY_OPENED"), var1);
      }

   }

   static void requestCompleted(final MMAdImpl var0) {
      if(var0 == null) {
         MMLog.w("MMSDK", "No Context in the listener: ");
      } else {
         MMSDK.runOnUiThread(new Runnable() {
            public final void run() {
               if(var0 != null && var0.requestListener != null) {
                  try {
                     var0.requestListener.requestCompleted(var0.getCallingAd());
                  } catch (Exception var2) {
                     MMLog.e("MMSDK", "Exception raised in your RequestListener: ", var2);
                     return;
                  }
               }

            }
         });
         if(MMSDK.access$000()) {
            String var1 = var0.getRequestCompletedAction();
            sendIntent(var0.getContext(), new Intent(var1), var0.internalId);
            return;
         }
      }

   }

   static void requestFailed(final MMAdImpl var0, final MMException var1) {
      if(var0 == null) {
         MMLog.w("MMSDK", "No Context in the listener: ");
      } else {
         MMSDK.runOnUiThread(new Runnable() {
            public final void run() {
               if(var0 != null && var0.requestListener != null) {
                  try {
                     var0.requestListener.requestFailed(var0.getCallingAd(), var1);
                  } catch (Exception var2) {
                     MMLog.e("MMSDK", "Exception raised in your RequestListener: ", var2);
                     return;
                  }
               }

            }
         });
         if(MMSDK.access$000()) {
            String var2 = var0.getRequestFailedAction();
            sendIntent(var0.getContext(), (new Intent(var2)).putExtra("error", var1), var0.internalId);
            return;
         }
      }

   }

   private static final void sendIntent(Context var0, Intent var1, long var2) {
      if(var0 != null) {
         var1.addCategory("millennialmedia.category.CATEGORY_SDK");
         if(var2 != -4L) {
            var1.putExtra("internalId", var2);
         }

         var1.putExtra("packageName", var0.getPackageName());
         String var4 = var1.getStringExtra("intentType");
         if(!TextUtils.isEmpty(var4)) {
            var4 = String.format(" Type[%s]", new Object[]{var4});
         } else {
            var4 = "";
         }

         MMLog.v("MMSDK", " @@ Intent: " + var1.getAction() + " " + var4 + " for " + var2);
         var0.sendBroadcast(var1);
      }

   }
}
