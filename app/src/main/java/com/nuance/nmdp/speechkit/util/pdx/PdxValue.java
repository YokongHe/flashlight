package com.nuance.nmdp.speechkit.util.pdx;

public abstract class PdxValue {
   public static final int TYPE_BYTES = 4;
   public static final int TYPE_DICT = 2;
   public static final int TYPE_INT = 1;
   public static final int TYPE_SEQ = 3;
   public static final int TYPE_SEQ_CHUNK = 6;
   public static final int TYPE_SEQ_END = 7;
   public static final int TYPE_SEQ_START = 5;
   public static final int TYPE_STRING = 0;
   private final int a;

   PdxValue(int var1) {
      this.a = var1;
   }

   public final int getType() {
      return this.a;
   }

   public abstract String toString(String var1);
}
