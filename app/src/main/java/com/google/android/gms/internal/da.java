package com.google.android.gms.internal;

import java.io.IOException;

public final class da extends IOException {
   da(int var1, int var2) {
      super("CodedOutputStream was writing to a flat byte array and ran out of space (pos " + var1 + " limit " + var2 + ").");
   }
}
