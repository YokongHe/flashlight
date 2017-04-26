package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;

public final class f implements Creator {
   static void a(StreetViewPanoramaOrientation var0, Parcel var1) {
      int var2 = com.google.android.gms.common.internal.safeparcel.c.a(var1);
      com.google.android.gms.common.internal.safeparcel.c.a(var1, 1, (int)var0.a());
      com.google.android.gms.common.internal.safeparcel.c.a(var1, 2, var0.a);
      com.google.android.gms.common.internal.safeparcel.c.a(var1, 3, var0.b);
      com.google.android.gms.common.internal.safeparcel.c.a(var1, var2);
   }

   // $FF: synthetic method
   public final Object createFromParcel(Parcel var1) {
      float var3 = 0.0F;
      int var5 = com.google.android.gms.common.internal.safeparcel.a.a(var1);
      int var4 = 0;
      float var2 = 0.0F;

      while(var1.dataPosition() < var5) {
         int var6 = var1.readInt();
         switch(65535 & var6) {
         case 1:
            var4 = com.google.android.gms.common.internal.safeparcel.a.e(var1, var6);
            break;
         case 2:
            var2 = com.google.android.gms.common.internal.safeparcel.a.h(var1, var6);
            break;
         case 3:
            var3 = com.google.android.gms.common.internal.safeparcel.a.h(var1, var6);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var6);
         }
      }

      if(var1.dataPosition() != var5) {
         throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + var5, var1);
      } else {
         return new StreetViewPanoramaOrientation(var4, var2, var3);
      }
   }
}
