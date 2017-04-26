package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.model.CameraPosition;

public final class a implements Creator {
   static void a(GoogleMapOptions var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.c.a(var1);
      com.google.android.gms.common.internal.safeparcel.c.a(var1, 1, (int)var0.a());
      com.google.android.gms.common.internal.safeparcel.c.a(var1, 2, (byte)var0.b());
      com.google.android.gms.common.internal.safeparcel.c.a(var1, 3, (byte)var0.c());
      com.google.android.gms.common.internal.safeparcel.c.a(var1, 4, (int)var0.j());
      com.google.android.gms.common.internal.safeparcel.c.a(var1, 5, (Parcelable)var0.k(), var2, false);
      com.google.android.gms.common.internal.safeparcel.c.a(var1, 6, (byte)var0.d());
      com.google.android.gms.common.internal.safeparcel.c.a(var1, 7, (byte)var0.e());
      com.google.android.gms.common.internal.safeparcel.c.a(var1, 8, (byte)var0.f());
      com.google.android.gms.common.internal.safeparcel.c.a(var1, 9, (byte)var0.g());
      com.google.android.gms.common.internal.safeparcel.c.a(var1, 10, (byte)var0.h());
      com.google.android.gms.common.internal.safeparcel.c.a(var1, 11, (byte)var0.i());
      com.google.android.gms.common.internal.safeparcel.c.a(var1, var3);
   }

   // $FF: synthetic method
   public final Object createFromParcel(Parcel var1) {
      byte var2 = 0;
      int var12 = com.google.android.gms.common.internal.safeparcel.a.a(var1);
      CameraPosition var14 = null;
      byte var3 = 0;
      byte var4 = 0;
      byte var5 = 0;
      byte var6 = 0;
      byte var7 = 0;
      int var10 = 0;
      byte var8 = 0;
      byte var9 = 0;
      int var11 = 0;

      while(var1.dataPosition() < var12) {
         int var13 = var1.readInt();
         switch(65535 & var13) {
         case 1:
            var11 = com.google.android.gms.common.internal.safeparcel.a.e(var1, var13);
            break;
         case 2:
            var9 = com.google.android.gms.common.internal.safeparcel.a.d(var1, var13);
            break;
         case 3:
            var8 = com.google.android.gms.common.internal.safeparcel.a.d(var1, var13);
            break;
         case 4:
            var10 = com.google.android.gms.common.internal.safeparcel.a.e(var1, var13);
            break;
         case 5:
            var14 = (CameraPosition)com.google.android.gms.common.internal.safeparcel.a.a(var1, var13, CameraPosition.CREATOR);
            break;
         case 6:
            var7 = com.google.android.gms.common.internal.safeparcel.a.d(var1, var13);
            break;
         case 7:
            var6 = com.google.android.gms.common.internal.safeparcel.a.d(var1, var13);
            break;
         case 8:
            var5 = com.google.android.gms.common.internal.safeparcel.a.d(var1, var13);
            break;
         case 9:
            var4 = com.google.android.gms.common.internal.safeparcel.a.d(var1, var13);
            break;
         case 10:
            var3 = com.google.android.gms.common.internal.safeparcel.a.d(var1, var13);
            break;
         case 11:
            var2 = com.google.android.gms.common.internal.safeparcel.a.d(var1, var13);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var13);
         }
      }

      if(var1.dataPosition() != var12) {
         throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + var12, var1);
      } else {
         return new GoogleMapOptions(var11, var9, var8, var10, var14, var7, var6, var5, var4, var3, var2);
      }
   }
}
