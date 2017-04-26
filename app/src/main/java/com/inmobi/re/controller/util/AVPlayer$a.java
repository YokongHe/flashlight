package com.inmobi.re.controller.util;

import android.os.Handler;
import android.os.Message;
import com.inmobi.re.controller.util.AVPlayer;
import java.lang.ref.WeakReference;

class AVPlayer$a extends Handler {
   private final WeakReference a;

   public AVPlayer$a(AVPlayer var1) {
      this.a = new WeakReference(var1);
   }

   public void handleMessage(Message var1) {
      AVPlayer var4 = (AVPlayer)this.a.get();
      if(var4 != null) {
         switch(var1.what) {
         case 1001:
            if(!AVPlayer.a(var4)) {
               return;
            }

            int var2 = Math.round((float)(var4.getCurrentPosition() / 1000));
            int var3 = Math.round((float)(var4.getDuration() / 1000));
            if(AVPlayer.b(var4) != var2) {
               AVPlayer.a(var4, var2, var3);
               AVPlayer.a(var4, var2);
               AVPlayer.b(var4, var2);
            }

            this.sendEmptyMessageDelayed(1001, 1000L);
         }
      }

      super.handleMessage(var1);
   }
}
