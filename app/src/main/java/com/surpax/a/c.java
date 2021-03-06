package com.surpax.a;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.Log;

import com.surpax.ledflashlight.FlashlightActivity;
import com.tcl.hawk.myflashlight.R;

import java.util.HashMap;

public final class c {
   private SoundPool soundPool;
   private HashMap hashMap;

   public c(Context var1) {
      Log.d("Surpax App", "soundManager constructor");
      this.soundPool = new SoundPool(2, 3, 0);
      if(this.soundPool != null) {
         Log.d("flashlightactivity", "load sound resource now.....");
         this.hashMap = new HashMap();
         this.hashMap.put(Integer.valueOf(1), Integer.valueOf(this.soundPool.load(var1, R.raw.sound_toggle, 1)));
         this.hashMap.put(Integer.valueOf(2), Integer.valueOf(this.soundPool.load(var1, R.raw.adjustment_move, 1)));
         this.hashMap.put(Integer.valueOf(3), Integer.valueOf(this.soundPool.load(var1, R.raw.adjustment_end, 1)));
      }

   }

   public final void a() {
      if(this.hashMap != null) {
         this.hashMap.clear();
      }

      this.hashMap = null;
      if(this.soundPool != null) {
         this.soundPool.release();
      }

      this.soundPool = null;
   }

   public final void a(int var1) {
      Log.d("flashlightactivity", "play now.....");
      if(this.soundPool != null) {
         AudioManager var3 = (AudioManager)FlashlightActivity.getFlashlightActivityInstance().getSystemService(Context.AUDIO_SERVICE);
         int var2;
         if(var3 != null) {
            var2 = var3.getStreamVolume(3);
            Log.d("flashlightactivity", "current volume is:" + var2);
         } else {
            var2 = 0;
         }

         this.soundPool.play(((Integer)this.hashMap.get(Integer.valueOf(var1))).intValue(), (float)var2, (float)var2, 1, 0, 1.0F);
      }

   }
}
