package com.nuance.nmdp.speechkit.util.pdx;

import com.nuance.nmdp.speechkit.util.pdx.PdxValue;

public final class PdxValue$String extends PdxValue {
   private final String a;

   public PdxValue$String(String var1) {
      super(0);
      this.a = var1;
   }

   public final String get() {
      return this.a;
   }

   public final String toString(String var1) {
      return this.a.replace("\n", "\n" + var1);
   }
}
