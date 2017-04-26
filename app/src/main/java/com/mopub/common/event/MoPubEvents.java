package com.mopub.common.event;

import com.mopub.common.VisibleForTesting;
import com.mopub.common.event.BaseEvent;
import com.mopub.common.event.EventDispatcher;

public class MoPubEvents {
   private static volatile EventDispatcher sEventDispatcher;

   private static EventDispatcher getDispatcher() {
      // $FF: Couldn't be decompiled
   }

   public static void log(BaseEvent var0) {
      getDispatcher().dispatch(var0);
   }

   @VisibleForTesting
   public static void setEventDispatcher(EventDispatcher var0) {
      sEventDispatcher = var0;
   }
}
