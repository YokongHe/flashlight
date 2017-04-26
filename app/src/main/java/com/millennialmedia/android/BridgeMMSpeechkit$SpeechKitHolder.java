package com.millennialmedia.android;

import com.millennialmedia.android.NVASpeechKit;
import com.millennialmedia.android.Utils$ThreadUtils;

class BridgeMMSpeechkit$SpeechKitHolder {
   private NVASpeechKit _speechKit;

   private BridgeMMSpeechkit$SpeechKitHolder() {
   }

   // $FF: synthetic method
   BridgeMMSpeechkit$SpeechKitHolder(Object var1) {
      this();
   }

   public NVASpeechKit getSpeechKit() {
      return this._speechKit;
   }

   public boolean release() {
      if(this._speechKit == null) {
         return false;
      } else {
         Utils$ThreadUtils.execute(new Runnable() {
            public void run() {
               BridgeMMSpeechkit$SpeechKitHolder var1 = BridgeMMSpeechkit$SpeechKitHolder.this;
               synchronized(var1) {
                  if(BridgeMMSpeechkit$SpeechKitHolder.this._speechKit != null) {
                     BridgeMMSpeechkit$SpeechKitHolder.this._speechKit.cancelRecording();
                     BridgeMMSpeechkit$SpeechKitHolder.this._speechKit.release();
                     BridgeMMSpeechkit$SpeechKitHolder.this._speechKit = null;
                  }

               }
            }
         });
         return true;
      }
   }

   public void setSpeechKit(NVASpeechKit var1) {
      this._speechKit = var1;
   }
}
