package com.amazon.device.ads;

import com.amazon.device.ads.AppEvent;
import com.amazon.device.ads.ThreadUtils;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;

class AppEventRegistrationHandler {
   protected static final String APP_EVENTS_FILE = "AppEventsJsonFile";
   protected static final long APP_EVENTS_FILE_MAX_SIZE = 1048576L;
   protected static final String APP_EVENT_NAME_KEY = "evtName";
   protected static final String APP_EVENT_TIMESTAMP_KEY = "ts";
   private static final String LOG_TAG = AppEventRegistrationHandler.class.getSimpleName();
   protected static AppEventRegistrationHandler instance = new AppEventRegistrationHandler();
   protected final Object appEventsFileLock = new Object();
   protected final Set eventsSent = Collections.synchronizedSet(new HashSet());
   protected final Set newEventsToSave = Collections.synchronizedSet(new HashSet());

   public static AppEventRegistrationHandler getInstance() {
      return instance;
   }

   public void addEventToAppEventsCacheFile(final AppEvent var1) {
      ThreadUtils.executeRunnable(new Runnable() {
         public void run() {
            AppEventRegistrationHandler.this.appendAppEventToFile(var1);
         }
      });
   }

   protected void appendAppEventToFile(AppEvent param1) {
      // $FF: Couldn't be decompiled
   }

   public JSONArray getAppEventsJSONArray() {
      // $FF: Couldn't be decompiled
   }

   public void onAppEventsRegistered() {
      // $FF: Couldn't be decompiled
   }
}
