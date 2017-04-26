package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public final class b implements Creator {
   static void a(CameraPosition var0, Parcel var1, int var2) {
      int var3 = com.google.android.gms.common.internal.safeparcel.c.a(var1);
      com.google.android.gms.common.internal.safeparcel.c.a(var1, 1, (int)var0.a());
      com.google.android.gms.common.internal.safeparcel.c.a(var1, 2, (Parcelable)var0.a, var2, false);
      com.google.android.gms.common.internal.safeparcel.c.a(var1, 3, var0.b);
      com.google.android.gms.common.internal.safeparcel.c.a(var1, 4, var0.c);
      com.google.android.gms.common.internal.safeparcel.c.a(var1, 5, var0.d);
      com.google.android.gms.common.internal.safeparcel.c.a(var1, var3);
   }

   // $FF: synthetic method
   public final Object createFromParcel(Parcel var1) {
      float var2 = 0.0F;
      int var6 = com.google.android.gms.common.internal.safeparcel.a.a(var1);
      int var5 = 0;
      LatLng var8 = null;
      float var3 = 0.0F;
      float var4 = 0.0F;

      while(var1.dataPosition() < var6) {
         int var7 = var1.readInt();
         switch(65535 & var7) {
         case 1:
            var5 = com.google.android.gms.common.internal.safeparcel.a.e(var1, var7);
            break;
         case 2:
            var8 = (LatLng)com.google.android.gms.common.internal.safeparcel.a.a(var1, var7, LatLng.CREATOR);
            break;
         case 3:
            var4 = com.google.android.gms.common.internal.safeparcel.a.h(var1, var7);
            break;
         case 4:
            var3 = com.google.android.gms.common.internal.safeparcel.a.h(var1, var7);
            break;
         case 5:
            var2 = com.google.android.gms.common.internal.safeparcel.a.h(var1, var7);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var7);
         }
      }

      if(var1.dataPosition() != var6) {
         throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + var6, var1);
      } else {
         return new CameraPosition(var5, var8, var4, var3, var2);
      }
   }
}
