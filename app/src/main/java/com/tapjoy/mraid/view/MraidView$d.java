package com.tapjoy.mraid.view;

import android.app.Activity;
import com.tapjoy.mraid.view.MraidView;
import com.tapjoy.mraid.view.MraidView$d$a;

final class MraidView$d implements Runnable {
   // $FF: synthetic field
   final MraidView a;

   public MraidView$d(MraidView var1) {
      this.a = var1;
   }

   public final void run() {
      int var1 = 0;

      while(MraidView.j(this.a) != null && !MraidView.j(this.a).isPlaying()) {
         try {
            Thread.sleep(50L);
         } catch (Exception var4) {
            continue;
         }

         int var2 = var1 + 50;
         var1 = var2;
         if(var2 >= 10000) {
            break;
         }
      }

      ((Activity)MraidView.i(this.a)).runOnUiThread(new Runnable() {
         public final void run() {
            if(MraidView.l(MraidView$d.this.a) != null) {
               MraidView.l(MraidView$d.this.a).setVisibility(8);
            }

            (new Thread(new MraidView$d$a(MraidView$d.this))).start();
         }
      });
   }
}
