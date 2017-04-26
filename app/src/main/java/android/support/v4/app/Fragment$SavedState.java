package android.support.v4.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Fragment$SavedState implements Parcelable {
   public static final Creator CREATOR = new Creator() {
      public final Fragment$SavedState createFromParcel(Parcel var1) {
         return new Fragment$SavedState(var1, (ClassLoader)null);
      }

      public final Fragment$SavedState[] newArray(int var1) {
         return new Fragment$SavedState[var1];
      }
   };
   final Bundle mState;

   Fragment$SavedState(Bundle var1) {
      this.mState = var1;
   }

   Fragment$SavedState(Parcel var1, ClassLoader var2) {
      this.mState = var1.readBundle();
      if(var2 != null && this.mState != null) {
         this.mState.setClassLoader(var2);
      }

   }

   public int describeContents() {
      return 0;
   }

   public void writeToParcel(Parcel var1, int var2) {
      var1.writeBundle(this.mState);
   }
}
