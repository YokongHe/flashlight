package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

final class aH implements com.google.android.gms.internal.aF {
   private IBinder a;

   aH(IBinder var1) {
      this.a = var1;
   }

   public final void a(Bundle param1) {
      // $FF: Couldn't be decompiled
   }

   public final IBinder asBinder() {
      return this.a;
   }

   public final void b(Bundle param1) {
      // $FF: Couldn't be decompiled
   }

   public final void d() {
      Parcel var1 = Parcel.obtain();
      Parcel var2 = Parcel.obtain();

      try {
         var1.writeInterfaceToken("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
         this.a.transact(2, var1, var2, 0);
         var2.readException();
      } finally {
         var2.recycle();
         var1.recycle();
      }

   }

   public final void e() {
      Parcel var1 = Parcel.obtain();
      Parcel var2 = Parcel.obtain();

      try {
         var1.writeInterfaceToken("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
         this.a.transact(3, var1, var2, 0);
         var2.readException();
      } finally {
         var2.recycle();
         var1.recycle();
      }

   }

   public final void f() {
      Parcel var1 = Parcel.obtain();
      Parcel var2 = Parcel.obtain();

      try {
         var1.writeInterfaceToken("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
         this.a.transact(4, var1, var2, 0);
         var2.readException();
      } finally {
         var2.recycle();
         var1.recycle();
      }

   }

   public final void g() {
      Parcel var1 = Parcel.obtain();
      Parcel var2 = Parcel.obtain();

      try {
         var1.writeInterfaceToken("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
         this.a.transact(5, var1, var2, 0);
         var2.readException();
      } finally {
         var2.recycle();
         var1.recycle();
      }

   }

   public final void h() {
      Parcel var1 = Parcel.obtain();
      Parcel var2 = Parcel.obtain();

      try {
         var1.writeInterfaceToken("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
         this.a.transact(7, var1, var2, 0);
         var2.readException();
      } finally {
         var2.recycle();
         var1.recycle();
      }

   }

   public final void i() {
      Parcel var1 = Parcel.obtain();
      Parcel var2 = Parcel.obtain();

      try {
         var1.writeInterfaceToken("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
         this.a.transact(8, var1, var2, 0);
         var2.readException();
      } finally {
         var2.recycle();
         var1.recycle();
      }

   }

   public final void j() {
      Parcel var1 = Parcel.obtain();
      Parcel var2 = Parcel.obtain();

      try {
         var1.writeInterfaceToken("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
         this.a.transact(9, var1, var2, 0);
         var2.readException();
      } finally {
         var2.recycle();
         var1.recycle();
      }

   }
}
