package android.support.v4.os;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;

class ParcelableCompat$CompatCreator implements Creator {
   final ParcelableCompatCreatorCallbacks mCallbacks;

   public ParcelableCompat$CompatCreator(ParcelableCompatCreatorCallbacks var1) {
      this.mCallbacks = var1;
   }

   public Object createFromParcel(Parcel var1) {
      return this.mCallbacks.createFromParcel(var1, (ClassLoader)null);
   }

   public Object[] newArray(int var1) {
      return this.mCallbacks.newArray(var1);
   }
}
