package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class aJ extends Binder implements com.google.android.gms.internal.aI {
   public static com.google.android.gms.internal.aI a(IBinder var0) {
      if(var0 == null) {
         return null;
      } else {
         IInterface var1 = var0.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
         return (com.google.android.gms.internal.aI)(var1 != null && var1 instanceof com.google.android.gms.internal.aI?(com.google.android.gms.internal.aI)var1:new com.google.android.gms.internal.aK(var0));
      }
   }

   public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) {
      switch(var1) {
      case 1:
         var2.enforceInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
         IBinder var5 = this.a(com.google.android.gms.a.c.a(var2.readStrongBinder()));
         var3.writeNoException();
         var3.writeStrongBinder(var5);
         return true;
      case 1598968902:
         var3.writeString("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
         return true;
      default:
         return super.onTransact(var1, var2, var3, var4);
      }
   }
}
