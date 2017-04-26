package com.millennialmedia.a.a.b;

import java.io.Writer;

final class t extends Writer {
   private final Appendable a;
   private final com.millennialmedia.a.a.b.u b;

   private t(Appendable var1) {
      this.b = new com.millennialmedia.a.a.b.u();
      this.a = var1;
   }

   // $FF: synthetic method
   t(Appendable var1, byte var2) {
      this(var1);
   }

   public final void close() {
   }

   public final void flush() {
   }

   public final void write(int var1) {
      this.a.append((char)var1);
   }

   public final void write(char[] var1, int var2, int var3) {
      this.b.a = var1;
      this.a.append(this.b, var2, var2 + var3);
   }
}
