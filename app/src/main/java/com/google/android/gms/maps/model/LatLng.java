package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class LatLng implements SafeParcelable {
   public static final com.google.android.gms.maps.model.c CREATOR = new com.google.android.gms.maps.model.c();
   public final double a;
   public final double b;
   private final int c;

   public LatLng(double var1, double var3) {
      this(1, var1, var3);
   }

   LatLng(int var1, double var2, double var4) {
      this.c = var1;
      if(-180.0D <= var4 && var4 < 180.0D) {
         this.b = var4;
      } else {
         this.b = ((var4 - 180.0D) % 360.0D + 360.0D) % 360.0D - 180.0D;
      }

      this.a = Math.max(-90.0D, Math.min(90.0D, var2));
   }

   final int a() {
      return this.c;
   }

   public final int describeContents() {
      return 0;
   }

   public final boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof LatLng)) {
            return false;
         }

         LatLng var2 = (LatLng)var1;
         if(Double.doubleToLongBits(this.a) != Double.doubleToLongBits(var2.a) || Double.doubleToLongBits(this.b) != Double.doubleToLongBits(var2.b)) {
            return false;
         }
      }

      return true;
   }

   public final int hashCode() {
      long var2 = Double.doubleToLongBits(this.a);
      int var1 = (int)(var2 ^ var2 >>> 32);
      var2 = Double.doubleToLongBits(this.b);
      return (var1 + 31) * 31 + (int)(var2 ^ var2 >>> 32);
   }

   public final String toString() {
      return "lat/lng: (" + this.a + "," + this.b + ")";
   }

   public final void writeToParcel(Parcel var1, int var2) {
      if(com.google.android.gms.maps.a.b.a()) {
         var2 = com.google.android.gms.common.internal.safeparcel.c.a(var1);
         com.google.android.gms.common.internal.safeparcel.c.a(var1, 1, (int)this.c);
         com.google.android.gms.common.internal.safeparcel.c.a(var1, 2, this.a);
         com.google.android.gms.common.internal.safeparcel.c.a(var1, 3, this.b);
         com.google.android.gms.common.internal.safeparcel.c.a(var1, var2);
      } else {
         com.google.android.gms.maps.model.c.a(this, var1);
      }
   }
}
