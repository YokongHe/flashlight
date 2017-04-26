package com.inmobi.re.controller;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.inmobi.re.controller.JSController$ReflectedParcelable;

public class JSController$OrientationProperties extends JSController$ReflectedParcelable {
   public static final Creator CREATOR = new Creator() {
      public final JSController$OrientationProperties a(Parcel var1) {
         return new JSController$OrientationProperties(var1);
      }

      public final JSController$OrientationProperties[] a(int var1) {
         return new JSController$OrientationProperties[var1];
      }

      // $FF: synthetic method
      public final Object createFromParcel(Parcel var1) {
         return this.a(var1);
      }

      // $FF: synthetic method
      public final Object[] newArray(int var1) {
         return this.a(var1);
      }
   };
   public boolean allowOrientationChange;
   public String forceOrientation;

   public JSController$OrientationProperties() {
      this.initializeOrientationProperties();
   }

   protected JSController$OrientationProperties(Parcel var1) {
      super(var1);
   }

   public void initializeOrientationProperties() {
      this.allowOrientationChange = true;
      this.forceOrientation = "";
   }
}
