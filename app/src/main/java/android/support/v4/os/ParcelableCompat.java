package android.support.v4.os;

import android.os.Build.VERSION;
import android.os.Parcelable.Creator;
import android.support.v4.os.ParcelableCompat$CompatCreator;
import android.support.v4.os.ParcelableCompatCreatorCallbacks;
import android.support.v4.os.ParcelableCompatCreatorHoneycombMR2Stub;

public class ParcelableCompat {
   public static Creator newCreator(ParcelableCompatCreatorCallbacks var0) {
      if(VERSION.SDK_INT >= 13) {
         ParcelableCompatCreatorHoneycombMR2Stub.instantiate(var0);
      }

      return new ParcelableCompat$CompatCreator(var0);
   }
}
