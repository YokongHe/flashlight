package com.millennialmedia.a.a.b;

final class u implements CharSequence {
   char[] a;

   public final char charAt(int var1) {
      return this.a[var1];
   }

   public final int length() {
      return this.a.length;
   }

   public final CharSequence subSequence(int var1, int var2) {
      return new String(this.a, var1, var2 - var1);
   }
}
