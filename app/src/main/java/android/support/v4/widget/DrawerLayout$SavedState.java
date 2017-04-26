package android.support.v4.widget;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.view.View.BaseSavedState;

public class DrawerLayout$SavedState extends BaseSavedState {
   public static final Creator CREATOR = new Creator() {
      public final DrawerLayout$SavedState createFromParcel(Parcel var1) {
         return new DrawerLayout$SavedState(var1);
      }

      public final DrawerLayout$SavedState[] newArray(int var1) {
         return new DrawerLayout$SavedState[var1];
      }
   };
   int lockModeLeft = 0;
   int lockModeRight = 0;
   int openDrawerGravity = 0;

   public DrawerLayout$SavedState(Parcel var1) {
      super(var1);
      this.openDrawerGravity = var1.readInt();
   }

   public DrawerLayout$SavedState(Parcelable var1) {
      super(var1);
   }

   public void writeToParcel(Parcel var1, int var2) {
      super.writeToParcel(var1, var2);
      var1.writeInt(this.openDrawerGravity);
   }
}
