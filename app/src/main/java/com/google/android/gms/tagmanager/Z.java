package com.google.android.gms.tagmanager;

import java.util.Arrays;

final class Z {
   final String a;
   final byte[] b;

   Z(String var1, byte[] var2) {
      this.a = var1;
      this.b = var2;
   }

   public final String toString() {
      return "KeyAndSerialized: key = " + this.a + " serialized hash = " + Arrays.hashCode(this.b);
   }
}
