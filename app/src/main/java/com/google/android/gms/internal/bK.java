package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.internal.dx;

public final class bK implements Creator {
   static void a(dx var0, Parcel var1) {
      int var2 = com.google.android.gms.common.internal.safeparcel.c.a(var1);
      com.google.android.gms.common.internal.safeparcel.c.a(var1, 1, (int)var0.a);
      com.google.android.gms.common.internal.safeparcel.c.a(var1, 2, (String)var0.b, false);
      com.google.android.gms.common.internal.safeparcel.c.a(var1, 3, (int)var0.c);
      com.google.android.gms.common.internal.safeparcel.c.a(var1, 4, (int)var0.d);
      com.google.android.gms.common.internal.safeparcel.c.a(var1, 5, var0.e);
      com.google.android.gms.common.internal.safeparcel.c.a(var1, var2);
   }

   // $FF: synthetic method
   public final Object createFromParcel(Parcel var1) {
      boolean var7 = false;
      int var5 = com.google.android.gms.common.internal.safeparcel.a.a(var1);
      String var8 = null;
      int var2 = 0;
      int var3 = 0;
      int var4 = 0;

      while(var1.dataPosition() < var5) {
         int var6 = var1.readInt();
         switch(65535 & var6) {
         case 1:
            var4 = com.google.android.gms.common.internal.safeparcel.a.e(var1, var6);
            break;
         case 2:
            var8 = com.google.android.gms.common.internal.safeparcel.a.j(var1, var6);
            break;
         case 3:
            var3 = com.google.android.gms.common.internal.safeparcel.a.e(var1, var6);
            break;
         case 4:
            var2 = com.google.android.gms.common.internal.safeparcel.a.e(var1, var6);
            break;
         case 5:
            var7 = com.google.android.gms.common.internal.safeparcel.a.c(var1, var6);
            break;
         default:
            com.google.android.gms.common.internal.safeparcel.a.b(var1, var6);
         }
      }

      if(var1.dataPosition() != var5) {
         throw new com.google.android.gms.common.internal.safeparcel.b("Overread allowed size end=" + var5, var1);
      } else {
         return new dx(var4, var8, var3, var2, var7);
      }
   }

   // $FF: synthetic method
   public final Object[] newArray(int var1) {
      return new dx[var1];
   }
}
