package com.millennialmedia.android;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.media.MediaPlayer.OnCompletionListener;
import android.net.Uri;
import com.millennialmedia.android.BridgeMMMedia$Audio$OnLoadCompleteListener;
import com.millennialmedia.android.BridgeMMMedia$Audio$PeriodicListener;
import com.millennialmedia.android.MMJSResponse;
import com.millennialmedia.android.MMSDK;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class BridgeMMMedia$Audio implements OnCompletionListener {
   private static final int MAX_SOUNDS = 4;
   private static BridgeMMMedia$Audio sharedInstance;
   private BridgeMMMedia$Audio$OnLoadCompleteListener completionListener;
   CopyOnWriteArrayList completionListeners;
   private WeakReference contextRef;
   private MediaPlayer mediaPlayer;
   CopyOnWriteArrayList periodicListeners;
   Runnable periodicUpdater = new Runnable() {
      public void run() {
         if(BridgeMMMedia$Audio.this.mediaPlayer != null) {
            if(BridgeMMMedia$Audio.this.mediaPlayer.isPlaying()) {
               int var1 = BridgeMMMedia$Audio.this.mediaPlayer.getCurrentPosition();
               if(BridgeMMMedia$Audio.this.periodicListeners != null) {
                  Iterator var2 = BridgeMMMedia$Audio.this.periodicListeners.iterator();

                  while(var2.hasNext()) {
                     ((BridgeMMMedia$Audio$PeriodicListener)var2.next()).onUpdate(var1);
                  }
               }
            }

            MMSDK.runOnUiThreadDelayed(this, 500L);
         }

      }
   };
   private SoundPool soundPool;

   private BridgeMMMedia$Audio() {
   }

   private BridgeMMMedia$Audio(Context var1) {
      this.contextRef = new WeakReference(var1.getApplicationContext());
   }

   // $FF: synthetic method
   static WeakReference access$200(BridgeMMMedia$Audio var0) {
      return var0.contextRef;
   }

   static BridgeMMMedia$Audio sharedAudio(Context var0) {
      synchronized(BridgeMMMedia$Audio.class){}

      BridgeMMMedia$Audio var3;
      try {
         if(sharedInstance == null) {
            sharedInstance = new BridgeMMMedia$Audio(var0);
         }

         var3 = sharedInstance;
      } finally {
         ;
      }

      return var3;
   }

   boolean addCompletionListener(OnCompletionListener var1) {
      if(this.completionListeners == null) {
         this.completionListeners = new CopyOnWriteArrayList();
      }

      return !this.completionListeners.contains(var1)?this.completionListeners.add(var1):false;
   }

   boolean addPeriodicListener(BridgeMMMedia$Audio$PeriodicListener var1) {
      if(this.periodicListeners == null) {
         this.periodicListeners = new CopyOnWriteArrayList();
      }

      return !this.periodicListeners.contains(var1)?this.periodicListeners.add(var1):false;
   }

   boolean isPlaying() {
      synchronized(this){}
      boolean var4 = false;

      boolean var1;
      label45: {
         try {
            var4 = true;
            if(this.mediaPlayer == null) {
               var4 = false;
               break label45;
            }

            var1 = this.mediaPlayer.isPlaying();
            var4 = false;
         } finally {
            if(var4) {
               ;
            }
         }

         if(var1) {
            var1 = true;
            return var1;
         }
      }

      var1 = false;
      return var1;
   }

   public void onCompletion(MediaPlayer param1) {
      // $FF: Couldn't be decompiled
   }

   MMJSResponse playAudio(Uri param1, boolean param2) {
      // $FF: Couldn't be decompiled
   }

   MMJSResponse playSound(File var1) {
      synchronized(this){}

      MMJSResponse var6;
      try {
         try {
            if(this.soundPool == null) {
               this.soundPool = new SoundPool(4, 3, 0);
               this.completionListener = new BridgeMMMedia$Audio$OnLoadCompleteListener(this, this.soundPool) {
                  public void onLoadComplete(SoundPool param1, int param2, int param3) {
                     // $FF: Couldn't be decompiled
                  }
               };
            }

            this.completionListener.testSample(this.soundPool.load(var1.getAbsolutePath(), 1));
         } catch (Exception var4) {
            ;
         }

         var6 = MMJSResponse.responseWithSuccess("Sound playback started");
      } finally {
         ;
      }

      return var6;
   }

   boolean removeCompletionListener(OnCompletionListener var1) {
      return this.completionListeners != null?this.completionListeners.remove(var1):false;
   }

   boolean removePeriodicListener(BridgeMMMedia$Audio$PeriodicListener var1) {
      return this.periodicListeners != null?this.periodicListeners.remove(var1):false;
   }

   MMJSResponse stop() {
      synchronized(this){}

      MMJSResponse var1;
      try {
         if(this.mediaPlayer != null) {
            this.onCompletion(this.mediaPlayer);
         }

         if(this.soundPool != null) {
            this.soundPool.release();
            this.soundPool = null;
         }

         if(this.completionListener != null) {
            this.completionListener.release();
            this.completionListener = null;
         }

         var1 = MMJSResponse.responseWithSuccess("Audio stopped");
      } finally {
         ;
      }

      return var1;
   }
}
