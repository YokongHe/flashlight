package com.millennialmedia.android;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;

class AdViewOverlayView$SavedState extends BaseSavedState {
   public static final Creator CREATOR = new Creator() {
      public final AdViewOverlayView$SavedState createFromParcel(Parcel var1) {
         return new AdViewOverlayView$SavedState(var1, null);
      }

      public final AdViewOverlayView$SavedState[] newArray(int var1) {
         return new AdViewOverlayView$SavedState[var1];
      }
   };
   public Object customInlineLayoutParams;
   String gson;

   private AdViewOverlayView$SavedState(Parcel var1) {
      super(var1);
      this.gson = var1.readString();
   }

   // $FF: synthetic method
   AdViewOverlayView$SavedState(Parcel var1, Object var2) {
      this(var1);
   }

   AdViewOverlayView$SavedState(Parcelable var1) {
      super(var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      super.writeToParcel(var1, var2);
      var1.writeString(this.gson);
   }
}
