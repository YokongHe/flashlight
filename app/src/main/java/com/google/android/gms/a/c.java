package com.google.android.gms.a;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class c extends Binder implements com.google.android.gms.a.b {
   public c() {
      this.attachInterface(this, "com.google.android.gms.dynamic.IObjectWrapper");
   }

   public static com.google.android.gms.a.b a(IBinder var0) {
      if(var0 == null) {
         return null;
      } else {
         IInterface var1 = var0.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
         return (com.google.android.gms.a.b)(var1 != null && var1 instanceof com.google.android.gms.a.b?(com.google.android.gms.a.b)var1:new com.google.android.gms.a.d(var0));
      }
   }

   public IBinder asBinder() {
      return this;
   }

   public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) {
      switch(var1) {
      case 1598968902:
         var3.writeString("com.google.android.gms.dynamic.IObjectWrapper");
         return true;
      default:
         return super.onTransact(var1, var2, var3, var4);
      }
   }
}
