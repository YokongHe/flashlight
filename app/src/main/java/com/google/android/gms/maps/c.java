package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.maps.StreetViewPanoramaOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public final class c implements Creator {
   static void a(StreetViewPanoramaOptions var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.c.a(var1);
      com.google.android.gms.common.internal.safeparcel.c.a(var1, 1, (int)var0.a());
      com.google.android.gms.common.internal.safeparcel.c.a(var1, 2, (Parcelable)var0.g(), var2, false);
      com.google.android.gms.common.internal.safeparcel.c.a(var1, 3, (String)var0.j(), false);
      com.google.android.gms.common.internal.safeparcel.c.a(var1, 4, (Parcelable)var0.h(), var2, false);
      com.google.android.gms.common.internal.safeparcel.c.a(var1, 5, (Integer)var0.i(), false);
      com.google.android.gms.common.internal.safeparcel.c.a(var1, 6, (byte)var0.b());
      com.google.android.gms.common.internal.safeparcel.c.a(var1, 7, (byte)var0.c());
      com.google.android.gms.common.internal.safeparcel.c.a(var1, 8, (byte)var0.d());
      com.google.android.gms.common.internal.safeparcel.c.a(var1, 9, (byte)var0.e());
      com.google.android.gms.common.internal.safeparcel.c.a(var1, 10, (byte)var0.f());
      com.google.android.gms.common.internal.safeparcel.c.a(var1, var3);
   }

   // $FF: synthetic method
   public final Object createFromParcel(Parcel var1) {
      Integer var10 = null;
      byte var2 = 0;
      int var8 = com.google.android.gms.common.internal.safeparcel.a.a(var1);
      byte var3 = 0;
      byte var4 = 0;
      byte var5 = 0;
      byte var6 = 0;
      LatLng var11 = null;
      String var12 = null;
      StreetViewPanoramaCamera var13 = null;
      int var7 = 0;

      while(var1.dataPosition() < var8) {
         int var9 = var1.readInt();
         switch(65535 & var9) {
         case 1:
            var7 = com.google.android.gms.common.internal.safeparcel.a.e(var1, var9);
            break;
         case 2:
            var13 = (StreetViewPanoramaCamera)com.google.android.gms.common.internal.safeparcel.a.a(var1, var9, StreetViewPanoramaCamera.CREATOR);
            break;
         case 3:
            var12 = com.google.android.gms.common.internal.safeparcel.a.j(var1, var9);
            break;
         case 4:
            var11 = (LatLng)com.google.android.gms.common.internal.safeparcel.a.a(var1, var9, LatLng.CREATOR);
            break;
         case 5:
            var10 = com.google.android.gms.common.internal.safeparcel.a.f(var1, var9);
            break;
         case 6:
            var6 = com.google.android.gms.common.internal.safeparcel.a.d(var1, var9);
            break;
         case 7:
            var5 = com.google.android.gms.common.internal.safeparcel.a.d(var1, var9);
            break;
         case 8:
            var4 = com.google.android.gms.common.internal.safeparcel.a.d(var1, var9);
            break;
         case 9:
            var3 = com.google.android.gms.common.internal.safeparcel.a.d(var1, var9);
            break;
         case 10:
            var2 = com.google.android.gms.common.internal.safeparcel.a.d(var1, var9);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var9);
         }
      }

      if(var1.dataPosition() != var8) {
         throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + var8, var1);
      } else {
         return new StreetViewPanoramaOptions(var7, var13, var12, var11, var10, var6, var5, var4, var3, var2);
      }
   }
}
