package com.tapjoy.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tapjoy.internal.cr$a;
import java.io.IOException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

final class cq$a implements ServiceConnection {
   boolean a = false;
   private final BlockingQueue b = new LinkedBlockingQueue();

   public static cq$a a(Context var0) {
      if(com.tapjoy.internal.af.b(var0.getPackageManager(), "com.google.android.gms") < 4000000) {
         throw new IOException("Google Play services not available.");
      } else {
         cq$a var1 = new cq$a();
         Intent var2 = new Intent("com.google.android.gms.ads.identifier.service.START");
         var2.setPackage("com.google.android.gms");
         if(var0.bindService(var2, var1, 1)) {
            return var1;
         } else {
            throw new IOException("Connection failure");
         }
      }
   }

   public final com.tapjoy.internal.cr a() {
      if(this.a) {
         throw new IllegalStateException();
      } else {
         this.a = true;
         return cr$a.a((IBinder)this.b.take());
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
