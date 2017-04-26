package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.dn;

final class dp implements dn {
   private IBinder a;

   dp(IBinder var1) {
      this.a = var1;
   }

   public final String a() {
      Parcel var1 = Parcel.obtain();
      Parcel var2 = Parcel.obtain();

      String var3;
      try {
         var1.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
         this.a.transact(1, var1, var2, 0);
         var2.readException();
         var3 = var2.readString();
      } finally {
         var2.recycle();
         var1.recycle();
      }

      return var3;
   }

   public final String a(String var1) {
      Parcel var2 = Parcel.obtain();
      Parcel var3 = Parcel.obtain();

      try {
         var2.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
         var2.writeString(var1);
         this.a.transact(3, var2, var3, 0);
         var3.readException();
         var1 = var3.readString();
      } finally {
         var3.recycle();
         var2.recycle();
      }

      return var1;
   }

   public final void a(String param1, boolean param2) {
      // $FF: Couldn't be decompiled
   }

   public final boolean a(boolean param1) {
      // $FF: Couldn't be decompiled
   }

   public final IBinder asBinder() {
      return this.a;
   }
}
