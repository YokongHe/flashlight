package com.inmobi.re.controller;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.inmobi.re.controller.JSController$ReflectedParcelable;

public class JSController$ExpandProperties extends JSController$ReflectedParcelable {
   public static final Creator CREATOR = new Creator() {
      public final JSController$ExpandProperties a(Parcel var1) {
         return new JSController$ExpandProperties(var1);
      }

      public final JSController$ExpandProperties[] a(int var1) {
         return new JSController$ExpandProperties[var1];
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
   public int actualHeightRequested;
   public int actualWidthRequested;
   public int bottomStuff;
   public int currentX;
   public int currentY;
   public int height;
   public boolean isModal;
   public boolean lockOrientation;
   public String orientation;
   public int portraitHeightRequested;
   public int portraitWidthRequested;
   public String rotationAtExpand;
   public int topStuff;
   public boolean useCustomClose;
   public int width;
   public int x;
   public int y;
   public boolean zeroWidthHeight;

   public JSController$ExpandProperties() {
      this.reinitializeExpandProperties();
   }

   protected JSController$ExpandProperties(Parcel var1) {
      super(var1);
   }

   public void reinitializeExpandProperties() {
      this.width = 0;
      this.height = 0;
      this.x = -1;
      this.y = -1;
      this.useCustomClose = false;
      this.isModal = true;
      this.lockOrientation = false;
      this.orientation = "";
      this.actualWidthRequested = 0;
      this.actualHeightRequested = 0;
      this.topStuff = 0;
      this.bottomStuff = 0;
      this.portraitWidthRequested = 0;
      this.portraitHeightRequested = 0;
      this.zeroWidthHeight = false;
      this.rotationAtExpand = "";
      this.currentX = 0;
      this.currentY = 0;
   }
}
