package com.tapjoy.mraid.controller;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tapjoy.mraid.controller.Abstract$ReflectedParcelable;

public class Abstract$Properties extends Abstract$ReflectedParcelable {
   public static final Creator CREATOR = new Creator() {
      // $FF: synthetic method
      public final Object createFromParcel(Parcel var1) {
         return new Abstract$Properties(var1);
      }
   };
   public int backgroundColor;
   public float backgroundOpacity;
   public boolean isModal;
   public boolean lockOrientation;
   public boolean useBackground;
   public boolean useCustomClose;

   public Abstract$Properties() {
      this.useBackground = false;
      this.backgroundColor = 0;
      this.backgroundOpacity = 0.0F;
      this.isModal = false;
      this.lockOrientation = false;
      this.useCustomClose = false;
   }

   protected Abstract$Properties(Parcel var1) {
      super(var1);
   }
}
