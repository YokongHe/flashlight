package com.google.android.gms.location;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class ActivityRecognitionResult implements SafeParcelable {
   public static final com.google.android.gms.location.b CREATOR = new com.google.android.gms.location.b();
   List a;
   long b;
   long c;
   private final int d = 1;

   public ActivityRecognitionResult(List var1, long var2, long var4) {
      this.a = var1;
      this.b = var2;
      this.c = var4;
   }

   public final int a() {
      return this.d;
   }

   public int describeContents() {
      return 0;
   }

   public String toString() {
      return "ActivityRecognitionResult [probableActivities=" + this.a + ", timeMillis=" + this.b + ", elapsedRealtimeMillis=" + this.c + "]";
   }

   public void writeToParcel(Parcel var1, int var2) {
      com.google.android.gms.location.b.a(this, var1);
   }
}
