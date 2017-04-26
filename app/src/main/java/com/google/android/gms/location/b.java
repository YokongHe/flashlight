package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.location.ActivityRecognitionResult;
import com.google.android.gms.location.DetectedActivity;
import java.util.ArrayList;

public final class b implements Creator {
   static void a(ActivityRecognitionResult var0, Parcel var1) {
      int var2 = com.google.android.gms.common.internal.safeparcel.c.a(var1);
      com.google.android.gms.common.internal.safeparcel.c.b(var1, 1, var0.a, false);
      com.google.android.gms.common.internal.safeparcel.c.a(var1, 1000, (int)var0.a());
      com.google.android.gms.common.internal.safeparcel.c.a(var1, 2, var0.b);
      com.google.android.gms.common.internal.safeparcel.c.a(var1, 3, var0.c);
      com.google.android.gms.common.internal.safeparcel.c.a(var1, var2);
   }

   // $FF: synthetic method
   public final Object createFromParcel(Parcel var1) {
      long var5 = 0L;
      int var2 = com.google.android.gms.common.internal.safeparcel.a.a(var1);
      long var7 = 0L;
      ArrayList var9 = null;

      while(var1.dataPosition() < var2) {
         int var3 = var1.readInt();
         switch(65535 & var3) {
         case 1:
            com.google.android.gms.location.c var10 = DetectedActivity.CREATOR;
            var3 = com.google.android.gms.common.internal.safeparcel.a.a(var1, var3);
            int var4 = var1.dataPosition();
            if(var3 == 0) {
               var9 = null;
            } else {
               var9 = var1.createTypedArrayList(var10);
               var1.setDataPosition(var4 + var3);
            }
            break;
         case 2:
            var7 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var3);
            break;
         case 3:
            var5 = com.google.android.gms.common.internal.safeparcel.a.g(var1, var3);
            break;
         case 1000:
            com.google.android.gms.common.internal.safeparcel.a.e(var1, var3);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var3);
         }
      }

      if(var1.dataPosition() != var2) {
         throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + var2, var1);
      } else {
         return new ActivityRecognitionResult(var9, var7, var5);
      }
   }
}
