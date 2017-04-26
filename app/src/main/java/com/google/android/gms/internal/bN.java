package com.google.android.gms.internal;

import android.util.Base64;
import com.google.android.gms.internal.di;

final class bN implements di {
   public final String a(byte[] var1, boolean var2) {
      return Base64.encodeToString(var1, 11);
   }

   public final byte[] a(String var1, boolean var2) {
      return Base64.decode(var1, 2);
   }
}
