package com.surpax.a;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;
import android.util.Log;
import com.surpax.ledflashlight.FlashlightActivity;
import java.util.HashMap;

public final class c {
   private SoundPool a;
   private HashMap b;

   public c(Context var1) {
      Log.d("Surpax App", "soundManager constructor");
      this.a = new SoundPool(2, 3, 0);
      if(this.a != null) {
         Log.d("flashlightactivity", "load sound resource now.....");
         this.b = new HashMap();
         this.b.put(Integer.valueOf(1), Integer.valueOf(this.a.load(var1, 2130837702, 1)));
         this.b.put(Integer.valueOf(2), Integer.valueOf(this.a.load(var1, 2130837505, 1)));
         this.b.put(Integer.valueOf(3), Integer.valueOf(this.a.load(var1, 2130837504, 1)));
      }

   }

   public final void a() {
      if(this.b != null) {
         this.b.clear();
      }

      this.b = null;
      if(this.a != null) {
         this.a.release();
      }

      this.a = null;
   }

   public final void a(int var1) {
      Log.d("flashlightactivity", "play now.....");
      if(this.a != null) {
         AudioManager var3 = (AudioManager)FlashlightActivity.a().getSystemService("audio");
         int var2;
         if(var3 != null) {
            var2 = var3.getStreamVolume(3);
            Log.d("flashlightactivity", "current volume is:" + var2);
         } else {
            var2 = 0;
         }

         this.a.play(((Integer)this.b.get(Integer.valueOf(var1))).intValue(), (float)var2, (float)var2, 1, 0, 1.0F);
      }

   }
}
