package com.tapjoy.internal;

import java.io.IOException;

public final class dj$a extends IOException {
   dj$a() {
      super("CodedOutputStream was writing to a flat byte array and ran out of space.");
   }
}
