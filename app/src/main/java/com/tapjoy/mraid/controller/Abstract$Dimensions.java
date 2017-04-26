package com.tapjoy.mraid.controller;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tapjoy.mraid.controller.Abstract$ReflectedParcelable;

public class Abstract$Dimensions extends Abstract$ReflectedParcelable {
   public static final Creator CREATOR = new Creator() {
      // $FF: synthetic method
      public final Object createFromParcel(Parcel var1) {
         return new Abstract$Dimensions(var1);
      }
   };
   public int height;
   public int width;
   public int x;
   public int y;

   public Abstract$Dimensions() {
      this.x = -1;
      this.y = -1;
      this.width = -1;
      this.height = -1;
   }

   protected Abstract$Dimensions(Parcel var1) {
      super(var1);
   }
}
