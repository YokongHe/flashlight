package com.tapjoy.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.io.Writer;

public final class bs implements Parcelable, com.tapjoy.internal.br {
   public static final Creator CREATOR = new Creator() {
      // $FF: synthetic method
      public final Object createFromParcel(Parcel var1) {
         return new com.tapjoy.internal.bs(var1.readString());
      }
   };
   public final String a;

   public bs(String var1) {
      this.a = var1;
   }

   public final void a(Writer var1) {
      var1.write(this.a);
   }

   public final int describeContents() {
      return 0;
   }

   public final boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(var1 instanceof com.tapjoy.internal.bs) {
         com.tapjoy.internal.bs var2 = (com.tapjoy.internal.bs)var1;
         return this.a.equals(var2.a);
      } else {
         return false;
      }
   }

   public final int hashCode() {
      return this.a.hashCode();
   }

   public final String toString() {
      return this.a;
   }

   public final void writeToParcel(Parcel var1, int var2) {
      var1.writeString(this.a);
   }
}
