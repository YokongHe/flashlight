package com.mopub.common.event;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Handler.Callback;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.event.BaseEvent;
import com.mopub.common.event.EventRecorder;
import com.mopub.common.logging.MoPubLog;
import java.util.Iterator;

public class EventDispatcher {
   private final Iterable mEventRecorders;
   @VisibleForTesting
   Callback mHandlerCallback;
   private final HandlerThread mHandlerThread;
   private final Handler mMessageHandler;

   @VisibleForTesting
   EventDispatcher(Iterable var1, HandlerThread var2) {
      this.mEventRecorders = var1;
      this.mHandlerCallback = new Callback() {
         public boolean handleMessage(Message var1) {
            if(var1.obj instanceof BaseEvent) {
               Iterator var2 = EventDispatcher.this.mEventRecorders.iterator();

               while(var2.hasNext()) {
                  ((EventRecorder)var2.next()).record((BaseEvent)var1.obj);
               }
            } else {
               MoPubLog.d("EventDispatcher received non-BaseEvent message type.");
            }

            return true;
         }
      };
      this.mHandlerThread = var2;
      this.mHandlerThread.start();
      this.mMessageHandler = new Handler(this.mHandlerThread.getLooper(), this.mHandlerCallback);
   }

   void dispatch(BaseEvent var1) {
      Message.obtain(this.mMessageHandler, 0, var1).sendToTarget();
   }
}
