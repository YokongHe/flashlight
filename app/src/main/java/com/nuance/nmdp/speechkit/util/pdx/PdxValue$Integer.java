package com.nuance.nmdp.speechkit.util.pdx;

import com.nuance.nmdp.speechkit.util.pdx.PdxValue;

public final class PdxValue$Integer extends PdxValue {
   private final int a;

   public PdxValue$Integer(int var1) {
      super(1);
      this.a = var1;
   }

   public final int get() {
      return this.a;
   }

   public final String toString(String var1) {
      return Integer.toString(this.a);
   }
}
