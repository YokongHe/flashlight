package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class C implements Creator {
   static void a(com.google.android.gms.internal.av var0, Parcel var1) {
      int var2 = com.google.android.gms.common.internal.safeparcel.c.a(var1);
      com.google.android.gms.common.internal.safeparcel.c.a(var1, 1, (int)var0.a);
      com.google.android.gms.common.internal.safeparcel.c.a(var1, 2, (int)var0.b);
      com.google.android.gms.common.internal.safeparcel.c.a(var1, 3, (int)var0.c);
      com.google.android.gms.common.internal.safeparcel.c.a(var1, 4, (int)var0.d);
      com.google.android.gms.common.internal.safeparcel.c.a(var1, 5, (int)var0.e);
      com.google.android.gms.common.internal.safeparcel.c.a(var1, 6, (int)var0.f);
      com.google.android.gms.common.internal.safeparcel.c.a(var1, 7, (int)var0.g);
      com.google.android.gms.common.internal.safeparcel.c.a(var1, 8, (int)var0.h);
      com.google.android.gms.common.internal.safeparcel.c.a(var1, 9, (int)var0.i);
      com.google.android.gms.common.internal.safeparcel.c.a(var1, 10, (String)var0.j, false);
      com.google.android.gms.common.internal.safeparcel.c.a(var1, 11, (int)var0.k);
      com.google.android.gms.common.internal.safeparcel.c.a(var1, 12, (String)var0.l, false);
      com.google.android.gms.common.internal.safeparcel.c.a(var1, 13, (int)var0.m);
      com.google.android.gms.common.internal.safeparcel.c.a(var1, 14, (int)var0.n);
      com.google.android.gms.common.internal.safeparcel.c.a(var1, 15, (String)var0.o, false);
      com.google.android.gms.common.internal.safeparcel.c.a(var1, var2);
   }

   // $FF: synthetic method
   public final Object createFromParcel(Parcel var1) {
      int var14 = com.google.android.gms.common.internal.safeparcel.a.a(var1);
      int var13 = 0;
      int var12 = 0;
      int var11 = 0;
      int var10 = 0;
      int var9 = 0;
      int var8 = 0;
      int var7 = 0;
      int var6 = 0;
      int var5 = 0;
      String var18 = null;
      int var4 = 0;
      String var17 = null;
      int var3 = 0;
      int var2 = 0;
      String var16 = null;

      while(var1.dataPosition() < var14) {
         int var15 = var1.readInt();
         switch(65535 & var15) {
         case 1:
            var13 = com.google.android.gms.common.internal.safeparcel.a.e(var1, var15);
            break;
         case 2:
            var12 = com.google.android.gms.common.internal.safeparcel.a.e(var1, var15);
            break;
         case 3:
            var11 = com.google.android.gms.common.internal.safeparcel.a.e(var1, var15);
            break;
         case 4:
            var10 = com.google.android.gms.common.internal.safeparcel.a.e(var1, var15);
            break;
         case 5:
            var9 = com.google.android.gms.common.internal.safeparcel.a.e(var1, var15);
            break;
         case 6:
            var8 = com.google.android.gms.common.internal.safeparcel.a.e(var1, var15);
            break;
         case 7:
            var7 = com.google.android.gms.common.internal.safeparcel.a.e(var1, var15);
            break;
         case 8:
            var6 = com.google.android.gms.common.internal.safeparcel.a.e(var1, var15);
            break;
         case 9:
            var5 = com.google.android.gms.common.internal.safeparcel.a.e(var1, var15);
            break;
         case 10:
            var18 = com.google.android.gms.common.internal.safeparcel.a.j(var1, var15);
            break;
         case 11:
            var4 = com.google.android.gms.common.internal.safeparcel.a.e(var1, var15);
            break;
         case 12:
            var17 = com.google.android.gms.common.internal.safeparcel.a.j(var1, var15);
            break;
         case 13:
            var3 = com.google.android.gms.common.internal.safeparcel.a.e(var1, var15);
            break;
         case 14:
            var2 = com.google.android.gms.common.internal.safeparcel.a.e(var1, var15);
            break;
         case 15:
            var16 = com.google.android.gms.common.internal.safeparcel.a.j(var1, var15);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var15);
         }
      }

      if(var1.dataPosition() != var14) {
         throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + var14, var1);
      } else {
         return new com.google.android.gms.internal.av(var13, var12, var11, var10, var9, var8, var7, var6, var5, var18, var4, var17, var3, var2, var16);
      }
   }

   // $FF: synthetic method
   public final Object[] newArray(int var1) {
      return new com.google.android.gms.internal.av[var1];
   }
}
