package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class aQ extends Binder implements com.google.android.gms.internal.aP {
   public aQ() {
      this.attachInterface(this, "com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
   }

   public IBinder asBinder() {
      return this;
   }

   public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) {
      switch(var1) {
      case 1:
         var2.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
         IBinder var6 = var2.readStrongBinder();
         Object var7;
         if(var6 == null) {
            var7 = null;
         } else {
            IInterface var5 = var6.queryLocalInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
            if(var5 != null && var5 instanceof com.google.android.gms.internal.aM) {
               var7 = (com.google.android.gms.internal.aM)var5;
            } else {
               var7 = new com.google.android.gms.internal.aO(var6);
            }
         }

         this.a((com.google.android.gms.internal.aM)var7);
         var3.writeNoException();
         return true;
      case 1598968902:
         var3.writeString("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
         return true;
      default:
         return super.onTransact(var1, var2, var3, var4);
      }
   }
}
