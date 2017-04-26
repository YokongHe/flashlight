package com.millennialmedia.android;

import android.media.SoundPool;
import com.millennialmedia.android.BridgeMMMedia$Audio;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

abstract class BridgeMMMedia$Audio$OnLoadCompleteListener {
   private static final int TEST_PERIOD_MS = 100;
   private ArrayList sampleIds;
   private SoundPool soundPool;
   // $FF: synthetic field
   final BridgeMMMedia$Audio this$0;
   private Timer timer;

   public BridgeMMMedia$Audio$OnLoadCompleteListener(BridgeMMMedia$Audio var1, SoundPool var2) {
      this.this$0 = var1;
      this.sampleIds = new ArrayList();
      this.soundPool = var2;
   }

   abstract void onLoadComplete(SoundPool var1, int var2, int var3);

   void release() {
      synchronized(this){}

      try {
         if(this.timer != null) {
            this.timer.cancel();
            this.timer.purge();
         }
      } finally {
         ;
      }

   }

   void testSample(int var1) {
      synchronized(this){}

      try {
         this.sampleIds.add(Integer.valueOf(var1));
         if(this.sampleIds.size() == 1) {
            this.timer = new Timer();
            this.timer.scheduleAtFixedRate(new TimerTask() {
               public void run() {
                  ArrayList var2 = new ArrayList();
                  Iterator var3 = BridgeMMMedia$Audio$OnLoadCompleteListener.this.sampleIds.iterator();

                  while(var3.hasNext()) {
                     Integer var4 = (Integer)var3.next();
                     int var1 = BridgeMMMedia$Audio$OnLoadCompleteListener.this.soundPool.play(var4.intValue(), 0.0F, 0.0F, 0, 0, 1.0F);
                     if(var1 != 0) {
                        BridgeMMMedia$Audio$OnLoadCompleteListener.this.soundPool.stop(var1);
                        BridgeMMMedia$Audio$OnLoadCompleteListener.this.onLoadComplete(BridgeMMMedia$Audio$OnLoadCompleteListener.this.soundPool, var4.intValue(), 0);
                        var2.add(var4);
                     }
                  }

                  BridgeMMMedia$Audio$OnLoadCompleteListener.this.sampleIds.removeAll(var2);
                  if(BridgeMMMedia$Audio$OnLoadCompleteListener.this.sampleIds.size() == 0) {
                     BridgeMMMedia$Audio$OnLoadCompleteListener.this.timer.cancel();
                     BridgeMMMedia$Audio$OnLoadCompleteListener.this.timer.purge();
                  }

               }
            }, 0L, 100L);
         }
      } finally {
         ;
      }

   }
}
