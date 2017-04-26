package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.dn;
import com.google.android.gms.internal.dp;

public abstract class do extends Binder implements dn {
   public static dn a(IBinder var0) {
      if(var0 == null) {
         return null;
      } else {
         IInterface var1 = var0.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
         return (dn)(var1 != null && var1 instanceof dn?(dn)var1:new dp(var0));
      }
   }

   public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) {
      boolean var6 = false;
      byte var5 = 0;
      String var9;
      switch(var1) {
      case 1:
         var2.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
         var9 = this.a();
         var3.writeNoException();
         var3.writeString(var9);
         return true;
      case 2:
         var2.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
         if(var2.readInt() != 0) {
            var6 = true;
         } else {
            var6 = false;
         }

         var6 = this.a(var6);
         var3.writeNoException();
         byte var8 = var5;
         if(var6) {
            var8 = 1;
         }

         var3.writeInt(var8);
         return true;
      case 3:
         var2.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
         var9 = this.a(var2.readString());
         var3.writeNoException();
         var3.writeString(var9);
         return true;
      case 4:
         var2.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
         String var7 = var2.readString();
         if(var2.readInt() != 0) {
            var6 = true;
         }

         this.a(var7, var6);
         var3.writeNoException();
         return true;
      case 1598968902:
         var3.writeString("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
         return true;
      default:
         return super.onTransact(var1, var2, var3, var4);
      }
   }
}
