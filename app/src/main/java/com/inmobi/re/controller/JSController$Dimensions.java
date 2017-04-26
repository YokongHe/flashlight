package com.inmobi.re.controller;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.inmobi.re.controller.JSController$ReflectedParcelable;

public class JSController$Dimensions extends JSController$ReflectedParcelable {
   public static final Creator CREATOR = new Creator() {
      public final JSController$Dimensions a(Parcel var1) {
         return new JSController$Dimensions(var1);
      }

      public final JSController$Dimensions[] a(int var1) {
         return new JSController$Dimensions[var1];
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
   public int height;
   public int width;
   public int x;
   public int y;

   public JSController$Dimensions() {
      this.x = -1;
      this.y = -1;
      this.width = -1;
      this.height = -1;
   }

   protected JSController$Dimensions(Parcel var1) {
      super(var1);
   }

   public String toString() {
      return "x: " + this.x + ", y: " + this.y + ", width: " + this.width + ", height: " + this.height;
   }
}
