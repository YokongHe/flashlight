package com.google.android.gms.maps.model;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.LatLng;
import java.util.Arrays;

public final class CameraPosition implements SafeParcelable {
   public static final com.google.android.gms.maps.model.b CREATOR = new com.google.android.gms.maps.model.b();
   public final LatLng a;
   public final float b;
   public final float c;
   public final float d;
   private final int e;

   CameraPosition(int var1, LatLng var2, float var3, float var4, float var5) {
      com.google.android.gms.internal.cM.a(var2, "null camera target");
      boolean var6;
      if(0.0F <= var4 && var4 <= 90.0F) {
         var6 = true;
      } else {
         var6 = false;
      }

      com.google.android.gms.internal.cM.b(var6, "Tilt needs to be between 0 and 90 inclusive");
      this.e = var1;
      this.a = var2;
      this.b = var3;
      this.c = var4 + 0.0F;
      var3 = var5;
      if((double)var5 <= 0.0D) {
         var3 = var5 % 360.0F + 360.0F;
      }

      this.d = var3 % 360.0F;
   }

   public CameraPosition(LatLng var1, float var2, float var3, float var4) {
      this(1, var1, var2, var3, var4);
   }

   public static CameraPosition a(Context var0, AttributeSet var1) {
      if(var1 == null) {
         return null;
      } else {
         TypedArray var5 = var0.getResources().obtainAttributes(var1, com.google.android.gms.e.b);
         float var2;
         if(var5.hasValue(2)) {
            var2 = var5.getFloat(2, 0.0F);
         } else {
            var2 = 0.0F;
         }

         float var3;
         if(var5.hasValue(3)) {
            var3 = var5.getFloat(3, 0.0F);
         } else {
            var3 = 0.0F;
         }

         LatLng var6 = new LatLng((double)var2, (double)var3);
         com.google.android.gms.maps.model.a var4 = new com.google.android.gms.maps.model.a();
         var4.a(var6);
         if(var5.hasValue(5)) {
            var4.a(var5.getFloat(5, 0.0F));
         }

         if(var5.hasValue(1)) {
            var4.c(var5.getFloat(1, 0.0F));
         }

         if(var5.hasValue(4)) {
            var4.b(var5.getFloat(4, 0.0F));
         }

         return var4.a();
      }
   }

   final int a() {
      return this.e;
   }

   public final int describeContents() {
      return 0;
   }

   public final boolean equals(Object var1) {
      if(this != var1) {
         if(!(var1 instanceof CameraPosition)) {
            return false;
         }

         CameraPosition var2 = (CameraPosition)var1;
         if(!this.a.equals(var2.a) || Float.floatToIntBits(this.b) != Float.floatToIntBits(var2.b) || Float.floatToIntBits(this.c) != Float.floatToIntBits(var2.c) || Float.floatToIntBits(this.d) != Float.floatToIntBits(var2.d)) {
            return false;
         }
      }

      return true;
   }

   public final int hashCode() {
      return Arrays.hashCode(new Object[]{this.a, Float.valueOf(this.b), Float.valueOf(this.c), Float.valueOf(this.d)});
   }

   public final String toString() {
      return com.google.android.gms.internal.cK.a(this).a("target", this.a).a("zoom", Float.valueOf(this.b)).a("tilt", Float.valueOf(this.c)).a("bearing", Float.valueOf(this.d)).toString();
   }

   public final void writeToParcel(Parcel var1, int var2) {
      if(com.google.android.gms.maps.a.b.a()) {
         int var3 = com.google.android.gms.common.internal.safeparcel.c.a(var1);
         com.google.android.gms.common.internal.safeparcel.c.a(var1, 1, (int)this.e);
         com.google.android.gms.common.internal.safeparcel.c.a(var1, 2, (Parcelable)this.a, var2, false);
         com.google.android.gms.common.internal.safeparcel.c.a(var1, 3, this.b);
         com.google.android.gms.common.internal.safeparcel.c.a(var1, 4, this.c);
         com.google.android.gms.common.internal.safeparcel.c.a(var1, 5, this.d);
         com.google.android.gms.common.internal.safeparcel.c.a(var1, var3);
      } else {
         com.google.android.gms.maps.model.b.a(this, var1, var2);
      }
   }
}
