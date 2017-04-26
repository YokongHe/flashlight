package com.google.android.gms.ads.identifier;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.ads.identifier.AdvertisingIdClient$Info;
import com.google.android.gms.internal.dn;
import com.google.android.gms.internal.do;
import java.io.IOException;

public final class AdvertisingIdClient {
   static AdvertisingIdClient$Info a(Context var0, com.google.android.gms.common.i var1) {
      AdvertisingIdClient$Info var12;
      try {
         dn var2 = do.a(var1.a());
         var12 = new AdvertisingIdClient$Info(var2.a(), var2.a(true));
      } catch (RemoteException var9) {
         Log.i("AdvertisingIdClient", "GMS remote exception ", var9);
         throw new IOException("Remote exception");
      } catch (InterruptedException var10) {
         throw new IOException("Interrupted exception");
      } finally {
         try {
            var0.unbindService(var1);
         } catch (IllegalArgumentException var8) {
            Log.i("AdvertisingIdClient", "getAdvertisingIdInfo unbindService failed.", var8);
         }

      }

      return var12;
   }

   static com.google.android.gms.common.i g(Context var0) {
      try {
         var0.getPackageManager().getPackageInfo("com.android.vending", 0);
      } catch (NameNotFoundException var4) {
         throw new com.google.android.gms.common.e(9);
      }

      try {
         com.google.android.gms.common.g.b(var0);
      } catch (com.google.android.gms.common.e var3) {
         throw new IOException(var3);
      }

      com.google.android.gms.common.i var1 = new com.google.android.gms.common.i();
      Intent var2 = new Intent("com.google.android.gms.ads.identifier.service.START");
      var2.setPackage("com.google.android.gms");
      if(var0.bindService(var2, var1, 1)) {
         return var1;
      } else {
         throw new IOException("Connection failure");
      }
   }

   public static AdvertisingIdClient$Info getAdvertisingIdInfo(Context var0) {
      if(Looper.myLooper() == Looper.getMainLooper()) {
         throw new IllegalStateException("Calling this from your main thread can lead to deadlock");
      } else {
         return a(var0, g(var0));
      }
   }
}
