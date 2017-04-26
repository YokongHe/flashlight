package com.tapjoy.internal;

import com.tapjoy.internal.dn;
import java.util.List;

public final class dv extends RuntimeException {
   private final List a = null;

   public dv() {
      super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
   }

   public final dn a() {
      return new dn(this.getMessage());
   }
}
