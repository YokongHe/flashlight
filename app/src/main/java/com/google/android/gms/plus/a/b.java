package com.google.android.gms.plus.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class b extends Binder implements com.google.android.gms.plus.a.a {
   public static com.google.android.gms.plus.a.a a(IBinder var0) {
      if(var0 == null) {
         return null;
      } else {
         IInterface var1 = var0.queryLocalInterface("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
         return (com.google.android.gms.plus.a.a)(var1 != null && var1 instanceof com.google.android.gms.plus.a.a?(com.google.android.gms.plus.a.a)var1:new com.google.android.gms.plus.a.c(var0));
      }
   }

   public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) {
      Object var5 = null;
      IBinder var7;
      switch(var1) {
      case 1:
         var2.enforceInterface("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
         com.google.android.gms.a.b var8 = this.a(com.google.android.gms.a.c.a(var2.readStrongBinder()), var2.readInt(), var2.readInt(), var2.readString(), var2.readInt());
         var3.writeNoException();
         if(var8 != null) {
            var7 = var8.asBinder();
         } else {
            var7 = null;
         }

         var3.writeStrongBinder(var7);
         return true;
      case 2:
         var2.enforceInterface("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
         com.google.android.gms.a.b var6 = this.a(com.google.android.gms.a.c.a(var2.readStrongBinder()), var2.readInt(), var2.readInt(), var2.readString(), var2.readString());
         var3.writeNoException();
         var7 = (IBinder)var5;
         if(var6 != null) {
            var7 = var6.asBinder();
         }

         var3.writeStrongBinder(var7);
         return true;
      case 1598968902:
         var3.writeString("com.google.android.gms.plus.internal.IPlusOneButtonCreator");
         return true;
      default:
         return super.onTransact(var1, var2, var3, var4);
      }
   }
}
