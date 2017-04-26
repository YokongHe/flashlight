package com.google.android.gms.common.internal.safeparcel;

import android.os.Parcel;

public final class b extends RuntimeException {
   public b(String var1, Parcel var2) {
      super(var1 + " Parcel: pos=" + var2.dataPosition() + " size=" + var2.dataSize());
   }
}
