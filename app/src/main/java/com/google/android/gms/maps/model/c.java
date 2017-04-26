package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.maps.model.LatLng;

public final class c implements Creator {
   static void a(LatLng var0, Parcel var1) {
      int var2 = com.google.android.gms.common.internal.safeparcel.c.a(var1);
      com.google.android.gms.common.internal.safeparcel.c.a(var1, 1, (int)var0.a());
      com.google.android.gms.common.internal.safeparcel.c.a(var1, 2, var0.a);
      com.google.android.gms.common.internal.safeparcel.c.a(var1, 3, var0.b);
      com.google.android.gms.common.internal.safeparcel.c.a(var1, var2);
   }

   // $FF: synthetic method
   public final Object createFromParcel(Parcel var1) {
      double var2 = 0.0D;
      int var7 = com.google.android.gms.common.internal.safeparcel.a.a(var1);
      int var6 = 0;
      double var4 = 0.0D;

      while(var1.dataPosition() < var7) {
         int var8 = var1.readInt();
         switch(65535 & var8) {
         case 1:
            var6 = com.google.android.gms.common.internal.safeparcel.a.e(var1, var8);
            break;
         case 2:
            var4 = com.google.android.gms.common.internal.safeparcel.a.i(var1, var8);
            break;
         case 3:
            var2 = com.google.android.gms.common.internal.safeparcel.a.i(var1, var8);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var8);
         }
      }

      if(var1.dataPosition() != var7) {
         throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + var7, var1);
      } else {
         return new LatLng(var6, var4, var2);
      }
   }
}
