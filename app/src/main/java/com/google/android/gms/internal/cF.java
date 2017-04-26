package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class cF extends Binder implements com.google.android.gms.internal.cE {
   public static com.google.android.gms.internal.cE a(IBinder var0) {
      if(var0 == null) {
         return null;
      } else {
         IInterface var1 = var0.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
         return (com.google.android.gms.internal.cE)(var1 != null && var1 instanceof com.google.android.gms.internal.cE?(com.google.android.gms.internal.cE)var1:new com.google.android.gms.internal.cG(var0));
      }
   }

   public boolean onTransact(int var1, Parcel var2, Parcel var3, int var4) {
      com.google.android.gms.internal.cB var6 = null;
      String var7 = null;
      String var8 = null;
      String var9 = null;
      IBinder var10 = null;
      String var11 = null;
      Object var12 = null;
      Object var13 = null;
      Object var14 = null;
      Object var15 = null;
      Object var16 = null;
      Object var17 = null;
      Object var18 = null;
      Object var19 = null;
      Object var20 = null;
      Bundle var5 = null;
      Bundle var21;
      String var22;
      com.google.android.gms.internal.cB var23;
      String[] var25;
      switch(var1) {
      case 1:
         var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
         var23 = com.google.android.gms.internal.cC.a(var2.readStrongBinder());
         var1 = var2.readInt();
         var22 = var2.readString();
         var7 = var2.readString();
         var25 = var2.createStringArray();
         var9 = var2.readString();
         if(var2.readInt() != 0) {
            var21 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
         } else {
            var21 = null;
         }

         this.a(var23, var1, var22, var7, var25, var9, var21);
         var3.writeNoException();
         return true;
      case 2:
         var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
         var6 = com.google.android.gms.internal.cC.a(var2.readStrongBinder());
         var1 = var2.readInt();
         var7 = var2.readString();
         if(var2.readInt() != 0) {
            var5 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
         }

         this.a(var6, var1, var7, var5);
         var3.writeNoException();
         return true;
      case 3:
         var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
         this.a(com.google.android.gms.internal.cC.a(var2.readStrongBinder()), var2.readInt(), var2.readString());
         var3.writeNoException();
         return true;
      case 4:
         var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
         this.a(com.google.android.gms.internal.cC.a(var2.readStrongBinder()), var2.readInt());
         var3.writeNoException();
         return true;
      case 5:
         var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
         com.google.android.gms.internal.cB var27 = com.google.android.gms.internal.cC.a(var2.readStrongBinder());
         var1 = var2.readInt();
         var8 = var2.readString();
         var5 = var6;
         if(var2.readInt() != 0) {
            var5 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
         }

         this.b(var27, var1, var8, var5);
         var3.writeNoException();
         return true;
      case 6:
         var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
         var6 = com.google.android.gms.internal.cC.a(var2.readStrongBinder());
         var1 = var2.readInt();
         var8 = var2.readString();
         var5 = var7;
         if(var2.readInt() != 0) {
            var5 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
         }

         this.c(var6, var1, var8, var5);
         var3.writeNoException();
         return true;
      case 7:
         var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
         var6 = com.google.android.gms.internal.cC.a(var2.readStrongBinder());
         var1 = var2.readInt();
         var7 = var2.readString();
         var5 = var8;
         if(var2.readInt() != 0) {
            var5 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
         }

         this.d(var6, var1, var7, var5);
         var3.writeNoException();
         return true;
      case 8:
         var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
         var6 = com.google.android.gms.internal.cC.a(var2.readStrongBinder());
         var1 = var2.readInt();
         var7 = var2.readString();
         var5 = var9;
         if(var2.readInt() != 0) {
            var5 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
         }

         this.e(var6, var1, var7, var5);
         var3.writeNoException();
         return true;
      case 9:
         var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
         var23 = com.google.android.gms.internal.cC.a(var2.readStrongBinder());
         var1 = var2.readInt();
         var22 = var2.readString();
         var7 = var2.readString();
         var25 = var2.createStringArray();
         var9 = var2.readString();
         var10 = var2.readStrongBinder();
         var11 = var2.readString();
         if(var2.readInt() != 0) {
            var21 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
         } else {
            var21 = null;
         }

         this.a(var23, var1, var22, var7, var25, var9, var10, var11, var21);
         var3.writeNoException();
         return true;
      case 10:
         var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
         this.a(com.google.android.gms.internal.cC.a(var2.readStrongBinder()), var2.readInt(), var2.readString(), var2.readString(), var2.createStringArray());
         var3.writeNoException();
         return true;
      case 11:
         var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
         var6 = com.google.android.gms.internal.cC.a(var2.readStrongBinder());
         var1 = var2.readInt();
         var7 = var2.readString();
         var5 = var10;
         if(var2.readInt() != 0) {
            var5 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
         }

         this.f(var6, var1, var7, var5);
         var3.writeNoException();
         return true;
      case 12:
         var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
         var6 = com.google.android.gms.internal.cC.a(var2.readStrongBinder());
         var1 = var2.readInt();
         var7 = var2.readString();
         var5 = var11;
         if(var2.readInt() != 0) {
            var5 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
         }

         this.g(var6, var1, var7, var5);
         var3.writeNoException();
         return true;
      case 13:
         var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
         var6 = com.google.android.gms.internal.cC.a(var2.readStrongBinder());
         var1 = var2.readInt();
         var7 = var2.readString();
         var5 = (Bundle)var12;
         if(var2.readInt() != 0) {
            var5 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
         }

         this.h(var6, var1, var7, var5);
         var3.writeNoException();
         return true;
      case 14:
         var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
         var6 = com.google.android.gms.internal.cC.a(var2.readStrongBinder());
         var1 = var2.readInt();
         var7 = var2.readString();
         var5 = (Bundle)var13;
         if(var2.readInt() != 0) {
            var5 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
         }

         this.i(var6, var1, var7, var5);
         var3.writeNoException();
         return true;
      case 15:
         var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
         var6 = com.google.android.gms.internal.cC.a(var2.readStrongBinder());
         var1 = var2.readInt();
         var7 = var2.readString();
         var5 = (Bundle)var14;
         if(var2.readInt() != 0) {
            var5 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
         }

         this.j(var6, var1, var7, var5);
         var3.writeNoException();
         return true;
      case 16:
         var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
         var6 = com.google.android.gms.internal.cC.a(var2.readStrongBinder());
         var1 = var2.readInt();
         var7 = var2.readString();
         var5 = (Bundle)var15;
         if(var2.readInt() != 0) {
            var5 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
         }

         this.k(var6, var1, var7, var5);
         var3.writeNoException();
         return true;
      case 17:
         var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
         var6 = com.google.android.gms.internal.cC.a(var2.readStrongBinder());
         var1 = var2.readInt();
         var7 = var2.readString();
         var5 = (Bundle)var16;
         if(var2.readInt() != 0) {
            var5 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
         }

         this.l(var6, var1, var7, var5);
         var3.writeNoException();
         return true;
      case 18:
         var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
         var6 = com.google.android.gms.internal.cC.a(var2.readStrongBinder());
         var1 = var2.readInt();
         var7 = var2.readString();
         var5 = (Bundle)var17;
         if(var2.readInt() != 0) {
            var5 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
         }

         this.m(var6, var1, var7, var5);
         var3.writeNoException();
         return true;
      case 19:
         var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
         var23 = com.google.android.gms.internal.cC.a(var2.readStrongBinder());
         var1 = var2.readInt();
         var22 = var2.readString();
         IBinder var26 = var2.readStrongBinder();
         if(var2.readInt() != 0) {
            var21 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
         } else {
            var21 = null;
         }

         this.a(var23, var1, var22, var26, var21);
         var3.writeNoException();
         return true;
      case 20:
         var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
         var23 = com.google.android.gms.internal.cC.a(var2.readStrongBinder());
         var1 = var2.readInt();
         var22 = var2.readString();
         String[] var24 = var2.createStringArray();
         var8 = var2.readString();
         if(var2.readInt() != 0) {
            var21 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
         } else {
            var21 = null;
         }

         this.a(var23, var1, var22, var24, var8, var21);
         var3.writeNoException();
         return true;
      case 21:
         var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
         this.b(com.google.android.gms.internal.cC.a(var2.readStrongBinder()), var2.readInt(), var2.readString());
         var3.writeNoException();
         return true;
      case 22:
         var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
         this.c(com.google.android.gms.internal.cC.a(var2.readStrongBinder()), var2.readInt(), var2.readString());
         var3.writeNoException();
         return true;
      case 23:
         var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
         var6 = com.google.android.gms.internal.cC.a(var2.readStrongBinder());
         var1 = var2.readInt();
         var7 = var2.readString();
         var5 = (Bundle)var18;
         if(var2.readInt() != 0) {
            var5 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
         }

         this.n(var6, var1, var7, var5);
         var3.writeNoException();
         return true;
      case 24:
         var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
         this.d(com.google.android.gms.internal.cC.a(var2.readStrongBinder()), var2.readInt(), var2.readString());
         var3.writeNoException();
         return true;
      case 25:
         var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
         var6 = com.google.android.gms.internal.cC.a(var2.readStrongBinder());
         var1 = var2.readInt();
         var7 = var2.readString();
         var5 = (Bundle)var19;
         if(var2.readInt() != 0) {
            var5 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
         }

         this.o(var6, var1, var7, var5);
         var3.writeNoException();
         return true;
      case 26:
         var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
         this.e(com.google.android.gms.internal.cC.a(var2.readStrongBinder()), var2.readInt(), var2.readString());
         var3.writeNoException();
         return true;
      case 27:
         var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
         var6 = com.google.android.gms.internal.cC.a(var2.readStrongBinder());
         var1 = var2.readInt();
         var7 = var2.readString();
         var5 = (Bundle)var20;
         if(var2.readInt() != 0) {
            var5 = (Bundle)Bundle.CREATOR.createFromParcel(var2);
         }

         this.p(var6, var1, var7, var5);
         var3.writeNoException();
         return true;
      case 28:
         var2.enforceInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
         this.b(com.google.android.gms.internal.cC.a(var2.readStrongBinder()), var2.readInt(), var2.readString(), var2.readString(), var2.createStringArray());
         var3.writeNoException();
         return true;
      case 1598968902:
         var3.writeString("com.google.android.gms.common.internal.IGmsServiceBroker");
         return true;
      default:
         return super.onTransact(var1, var2, var3, var4);
      }
   }
}
