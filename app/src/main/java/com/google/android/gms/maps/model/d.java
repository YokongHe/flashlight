package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public final class d implements Creator {
   static void a(StreetViewPanoramaCamera var0, Parcel var1) {
      int var2 = com.google.android.gms.common.internal.safeparcel.c.a(var1);
      com.google.android.gms.common.internal.safeparcel.c.a(var1, 1, (int)var0.a());
      com.google.android.gms.common.internal.safeparcel.c.a(var1, 2, var0.a);
      com.google.android.gms.common.internal.safeparcel.c.a(var1, 3, var0.b);
      com.google.android.gms.common.internal.safeparcel.c.a(var1, 4, var0.c);
      com.google.android.gms.common.internal.safeparcel.c.a(var1, var2);
   }

   // $FF: synthetic method
   public final Object createFromParcel(Parcel var1) {
      float var4 = 0.0F;
      int var6 = com.google.android.gms.common.internal.safeparcel.a.a(var1);
      float var2 = 0.0F;
      int var5 = 0;
      float var3 = 0.0F;

      while(var1.dataPosition() < var6) {
         int var7 = var1.readInt();
         switch(65535 & var7) {
         case 1:
            var5 = com.google.android.gms.common.internal.safeparcel.a.e(var1, var7);
            break;
         case 2:
            var2 = com.google.android.gms.common.internal.safeparcel.a.h(var1, var7);
            break;
         case 3:
            var3 = com.google.android.gms.common.internal.safeparcel.a.h(var1, var7);
            break;
         case 4:
            var4 = com.google.android.gms.common.internal.safeparcel.a.h(var1, var7);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var7);
         }
      }

      if(var1.dataPosition() != var6) {
         throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + var6, var1);
      } else {
         return new StreetViewPanoramaCamera(var5, var2, var3, var4);
      }
   }
}
