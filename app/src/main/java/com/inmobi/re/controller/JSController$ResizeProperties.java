package com.inmobi.re.controller;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.inmobi.re.controller.JSController$ReflectedParcelable;

public class JSController$ResizeProperties extends JSController$ReflectedParcelable {
   public static final Creator CREATOR = new Creator() {
      public final JSController$ResizeProperties a(Parcel var1) {
         return new JSController$ResizeProperties(var1);
      }

      public final JSController$ResizeProperties[] a(int var1) {
         return new JSController$ResizeProperties[var1];
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
   public boolean allowOffscreen;
   public String customClosePosition;
   public int height;
   public int offsetX;
   public int offsetY;
   public int width;

   public JSController$ResizeProperties() {
      this.initializeResizeProperties();
   }

   protected JSController$ResizeProperties(Parcel var1) {
      super(var1);
   }

   public void initializeResizeProperties() {
      this.offsetY = 0;
      this.offsetX = 0;
      this.height = 0;
      this.width = 0;
      this.allowOffscreen = false;
      this.customClosePosition = "top-right";
   }
}
