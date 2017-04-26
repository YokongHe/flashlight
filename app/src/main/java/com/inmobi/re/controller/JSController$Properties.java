package com.inmobi.re.controller;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.inmobi.re.controller.JSController$ReflectedParcelable;

public class JSController$Properties extends JSController$ReflectedParcelable {
   public static final Creator CREATOR = new Creator() {
      public final JSController$Properties a(Parcel var1) {
         return new JSController$Properties(var1);
      }

      public final JSController$Properties[] a(int var1) {
         return new JSController$Properties[var1];
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
   public int backgroundColor;
   public float backgroundOpacity;
   public boolean useBackground;

   public JSController$Properties() {
      this.useBackground = false;
      this.backgroundColor = 0;
      this.backgroundOpacity = 0.0F;
   }

   protected JSController$Properties(Parcel var1) {
      super(var1);
   }
}
