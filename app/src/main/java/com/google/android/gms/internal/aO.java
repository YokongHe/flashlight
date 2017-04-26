package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;

final class aO implements com.google.android.gms.internal.aM {
   private IBinder a;

   aO(IBinder var1) {
      this.a = var1;
   }

   public final String a() {
      Parcel var1 = Parcel.obtain();
      Parcel var2 = Parcel.obtain();

      String var3;
      try {
         var1.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
         this.a.transact(1, var1, var2, 0);
         var2.readException();
         var3 = var2.readString();
      } finally {
         var2.recycle();
         var1.recycle();
      }

      return var3;
   }

   public final void a(int var1) {
      Parcel var2 = Parcel.obtain();
      Parcel var3 = Parcel.obtain();

      try {
         var2.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
         var2.writeInt(var1);
         this.a.transact(2, var2, var3, 0);
         var3.readException();
      } finally {
         var3.recycle();
         var2.recycle();
      }

   }

   public final IBinder asBinder() {
      return this.a;
   }

   public final void b(int var1) {
      Parcel var2 = Parcel.obtain();
      Parcel var3 = Parcel.obtain();

      try {
         var2.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchase");
         var2.writeInt(var1);
         this.a.transact(3, var2, var3, 0);
         var3.readException();
      } finally {
         var3.recycle();
         var2.recycle();
      }

   }
}
