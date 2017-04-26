package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.location.DetectedActivity;

public final class c implements Creator {
   static void a(DetectedActivity var0, Parcel var1) {
      int var2 = com.google.android.gms.common.internal.safeparcel.c.a(var1);
      com.google.android.gms.common.internal.safeparcel.c.a(var1, 1, (int)var0.a);
      com.google.android.gms.common.internal.safeparcel.c.a(var1, 1000, (int)var0.a());
      com.google.android.gms.common.internal.safeparcel.c.a(var1, 2, (int)var0.b);
      com.google.android.gms.common.internal.safeparcel.c.a(var1, var2);
   }

   // $FF: synthetic method
   public final Object createFromParcel(Parcel var1) {
      int var4 = 0;
      int var5 = com.google.android.gms.common.internal.safeparcel.a.a(var1);
      int var3 = 0;
      int var2 = 0;

      while(var1.dataPosition() < var5) {
         int var6 = var1.readInt();
         switch(65535 & var6) {
         case 1:
            var3 = com.google.android.gms.common.internal.safeparcel.a.e(var1, var6);
            break;
         case 2:
            var4 = com.google.android.gms.common.internal.safeparcel.a.e(var1, var6);
            break;
         case 1000:
            var2 = com.google.android.gms.common.internal.safeparcel.a.e(var1, var6);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var6);
         }
      }

      if(var1.dataPosition() != var5) {
         throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + var5, var1);
      } else {
         return new DetectedActivity(var2, var3, var4);
      }
   }
}
