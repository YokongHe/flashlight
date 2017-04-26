package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;

public abstract class Z extends Binder implements com.google.android.gms.internal.Y {
   public Z() {
      this.attachInterface(this, "com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
   }

   public IBinder asBinder() {
      return this;
   }

   public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) {
      switch(var1) {
      case 1:
         var2.enforceInterface("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
         com.google.android.gms.internal.ab var5 = this.a(var2.readString());
         var3.writeNoException();
         IBinder var6;
         if(var5 != null) {
            var6 = var5.asBinder();
         } else {
            var6 = null;
         }

         var3.writeStrongBinder(var6);
         return true;
      case 1598968902:
         var3.writeString("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
         return true;
      default:
         return super.onTransact(var1, var2, var3, var4);
      }
   }
}
