package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.StreetViewPanoramaOrientation;
import java.util.Arrays;

public class StreetViewPanoramaCamera implements SafeParcelable {
   public static final com.google.android.gms.maps.model.d CREATOR = new com.google.android.gms.maps.model.d();
   public final float a;
   public final float b;
   public final float c;
   private final int d;
   private StreetViewPanoramaOrientation e;

   StreetViewPanoramaCamera(int var1, float var2, float var3, float var4) {
      boolean var5;
      if(-90.0F <= var3 && var3 <= 90.0F) {
         var5 = true;
      } else {
         var5 = false;
      }

      com.google.android.gms.internal.cM.b(var5, "Tilt needs to be between -90 and 90 inclusive");
      this.d = var1;
      this.a = var2;
      this.b = 0.0F + var3;
      if((double)var4 <= 0.0D) {
         var2 = var4 % 360.0F + 360.0F;
      } else {
         var2 = var4;
      }

      this.c = var2 % 360.0F;
      com.google.android.gms.maps.model.e var6 = new com.google.android.gms.maps.model.e();
      var6.b = var3;
      var6.a = var4;
      this.e = new StreetViewPanoramaOrientation(var6.b, var6.a);
   }

   final int a() {
      return this.d;
   }

   public int describeContents() {
      return 0;
   }

   public boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof StreetViewPanoramaCamera)) {
            return false;
         }

         StreetViewPanoramaCamera var2 = (StreetViewPanoramaCamera)var1;
         if(Float.floatToIntBits(this.a) != Float.floatToIntBits(var2.a) || Float.floatToIntBits(this.b) != Float.floatToIntBits(var2.b) || Float.floatToIntBits(this.c) != Float.floatToIntBits(var2.c)) {
            return false;
         }
      }

      return true;
   }

   public int hashCode() {
      return Arrays.hashCode(new Object[]{Float.valueOf(this.a), Float.valueOf(this.b), Float.valueOf(this.c)});
   }

   public String toString() {
      return com.google.android.gms.internal.cK.a(this).a("zoom", Float.valueOf(this.a)).a("tilt", Float.valueOf(this.b)).a("bearing", Float.valueOf(this.c)).toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      com.google.android.gms.maps.model.d.a(this, var1);
   }
}
