package com.mopub.common.event;

import com.mopub.common.event.BaseEvent;
import com.mopub.common.event.EventRecorder;
import com.mopub.common.logging.MoPubLog;

class LogCatEventRecorder implements EventRecorder {
   public void record(BaseEvent var1) {
      MoPubLog.d(var1.toString());
   }
}
