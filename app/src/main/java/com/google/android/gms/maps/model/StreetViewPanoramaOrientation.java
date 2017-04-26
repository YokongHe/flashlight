package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

public class StreetViewPanoramaOrientation implements SafeParcelable {
   public static final com.google.android.gms.maps.model.f CREATOR = new com.google.android.gms.maps.model.f();
   public final float a;
   public final float b;
   private final int c;

   public StreetViewPanoramaOrientation(float var1, float var2) {
      this(1, var1, var2);
   }

   StreetViewPanoramaOrientation(int var1, float var2, float var3) {
      boolean var4;
      if(-90.0F <= var2 && var2 <= 90.0F) {
         var4 = true;
      } else {
         var4 = false;
      }

      com.google.android.gms.internal.cM.b(var4, "Tilt needs to be between -90 and 90 inclusive");
      this.c = var1;
      this.a = 0.0F + var2;
      var2 = var3;
      if((double)var3 <= 0.0D) {
         var2 = var3 % 360.0F + 360.0F;
      }

      this.b = var2 % 360.0F;
   }

   final int a() {
      return this.c;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof StreetViewPanoramaOrientation)) {
            return false;
         }

         StreetViewPanoramaOrientation var2 = (StreetViewPanoramaOrientation)var1;
         if(Float.floatToIntBits(this.a) != Float.floatToIntBits(var2.a) || Float.floatToIntBits(this.b) != Float.floatToIntBits(var2.b)) {
            return false;
         }
      }

      return true;
   }

   public int hashCode() {
      return Arrays.hashCode(new Object[]{Float.valueOf(this.a), Float.valueOf(this.b)});
   }

   public String toString() {
      return com.google.android.gms.internal.cK.a(this).a("tilt", Float.valueOf(this.a)).a("bearing", Float.valueOf(this.b)).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      com.google.android.gms.maps.model.f.a(this, var1);
   }
}
