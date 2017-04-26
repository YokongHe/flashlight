package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public final class i implements ServiceConnection {
   boolean a = false;
   private final BlockingQueue b = new LinkedBlockingQueue();

   public final IBinder a() {
      if(this.a) {
         throw new IllegalStateException();
      } else {
         this.a = true;
         return (IBinder)this.b.take();
      }
   }

   public final void onServiceConnected(ComponentName var1, IBinder var2) {
      try {
         this.b.put(var2);
      } catch (InterruptedException var3) {
         ;
      }
   }

   public final void onServiceDisconnected(ComponentName var1) {
   }
}
