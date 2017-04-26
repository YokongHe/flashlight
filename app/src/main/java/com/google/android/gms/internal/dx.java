package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class dx implements SafeParcelable {
   public static final com.google.android.gms.internal.bK CREATOR = new com.google.android.gms.internal.bK();
   public final int a;
   public String b;
   public int c;
   public int d;
   public boolean e;

   public dx(int var1, int var2, boolean var3) {
      this(1, "afma-sdk-a-v" + 4452000 + ".4452000" + ".0", 4452000, 4452000, true);
   }

   dx(int var1, String var2, int var3, int var4, boolean var5) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.e = var5;
   }

   public final int describeContents() {
      return 0;
   }

   public final void writeToParcel(Parcel var1, int var2) {
      com.google.android.gms.internal.bK.a(this, var1);
   }
}
