package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;

public abstract class aN extends Binder implements com.google.android.gms.internal.aM {
   public aN() {
      this.attachInterface(this, "com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
   }

   public IBinder asBinder() {
      return this;
   }

   public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) {
      switch(var1) {
      case 1:
         var2.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
         String var5 = this.a();
         var3.writeNoException();
         var3.writeString(var5);
         return true;
      case 2:
         var2.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
         this.a(var2.readInt());
         var3.writeNoException();
         return true;
      case 3:
         var2.enforceInterface("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
         this.b(var2.readInt());
         var3.writeNoException();
         return true;
      case 1598968902:
         var3.writeString("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
         return true;
      default:
         return super.onTransact(var1, var2, var3, var4);
      }
   }
}
