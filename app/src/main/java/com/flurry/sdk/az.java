package com.flurry.sdk;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class az extends FilterInputStream {
   private final long a;
   private long b;

   public az(InputStream var1, long var2) {
      super(var1);
      this.a = var2;
   }

   private int a(int var1) {
      this.b += (long)var1;
      if(this.b > this.a) {
         throw new IOException("Size limit exceeded: " + this.a + " bytes, read " + this.b + " bytes!");
      } else {
         return var1;
      }
   }

   public void close() {
      this.in = null;
   }

   public int read() {
      return this.a(super.read());
   }

   public int read(byte[] var1) {
      return this.a(super.read(var1));
   }

   public int read(byte[] var1, int var2, int var3) {
      return this.a(super.read(var1, var2, var3));
   }
}
