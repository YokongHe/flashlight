package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class DetectedActivity implements SafeParcelable {
   public static final com.google.android.gms.location.c CREATOR = new com.google.android.gms.location.c();
   int a;
   int b;
   private final int c;

   public DetectedActivity(int var1, int var2, int var3) {
      this.c = var1;
      this.a = var2;
      this.b = var3;
   }

   public final int a() {
      return this.c;
   }

   public int describeContents() {
      return 0;
   }

   public String toString() {
      StringBuilder var3 = new StringBuilder("DetectedActivity [type=");
      int var2 = this.a;
      int var1 = var2;
      if(var2 > 8) {
         var1 = 4;
      }

      return var3.append(var1).append(", confidence=").append(this.b).append("]").toString();
   }

   public void writeToParcel(Parcel var1, int var2) {
      com.google.android.gms.location.c.a(this, var1);
   }
}
