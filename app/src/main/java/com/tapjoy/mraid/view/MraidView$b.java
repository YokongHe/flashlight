package com.tapjoy.mraid.view;

import com.tapjoy.mraid.view.MraidView;

final class MraidView$b implements Runnable {
   // $FF: synthetic field
   final MraidView a;

   public MraidView$b(MraidView var1) {
      this.a = var1;
   }

   public final void run() {
      while(!MraidView.m(this.a)) {
         try {
            Thread.sleep(250L);
            MraidView.n(this.a);
         } catch (Exception var2) {
            ;
         }
      }

   }
}
