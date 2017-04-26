package com.mopub.nativeads;

import android.os.SystemClock;

class TimestampWrapper {
   long mCreatedTimestamp;
   final Object mInstance;

   TimestampWrapper(Object var1) {
      this.mInstance = var1;
      this.mCreatedTimestamp = SystemClock.uptimeMillis();
   }
}
