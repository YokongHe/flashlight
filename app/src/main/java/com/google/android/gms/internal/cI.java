package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class cI extends Binder implements com.google.android.gms.internal.cH {
   public static com.google.android.gms.internal.cH a(IBinder var0) {
      if(var0 == null) {
         return null;
      } else {
         IInterface var1 = var0.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
         return (com.google.android.gms.internal.cH)(var1 != null && var1 instanceof com.google.android.gms.internal.cH?(com.google.android.gms.internal.cH)var1:new com.google.android.gms.internal.cJ(var0));
      }
   }

   public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) {
      switch(var1) {
      case 1:
         var2.enforceInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
         com.google.android.gms.a.b var5 = this.a(com.google.android.gms.a.c.a(var2.readStrongBinder()), var2.readInt(), var2.readInt());
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
         var3.writeString("com.google.android.gms.common.internal.ISignInButtonCreator");
         return true;
      default:
         return super.onTransact(var1, var2, var3, var4);
      }
   }
}
