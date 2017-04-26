package com.nuance.a.a.a.a;

import android.os.Handler;
import android.os.Message;
import java.util.ArrayList;

public final class i extends Handler {
   private Handler a;
   private final ArrayList b = new ArrayList();

   public final void a() {
      // $FF: Couldn't be decompiled
   }

   public final boolean sendMessageAtTime(Message var1, long var2) {
      boolean var4 = true;
      synchronized(this){}

      try {
         if(this.a == null) {
            this.b.add(new com.nuance.a.a.a.a.j(var1, var2));
         } else if(this.a.getLooper().getThread().isAlive()) {
            var4 = this.a.sendMessageAtTime(var1, var2);
         }
      } finally {
         ;
      }

      return var4;
   }
}
