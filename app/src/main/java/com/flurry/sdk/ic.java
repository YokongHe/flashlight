package com.flurry.sdk;

import com.flurry.sdk.ie;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

abstract class ic extends Reader {
   protected final ie a;
   protected InputStream b;
   protected byte[] c;
   protected int d;
   protected int e;
   protected char[] f = null;

   protected ic(ie var1, InputStream var2, byte[] var3, int var4, int var5) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.e = var5;
   }

   public final void a() {
      byte[] var1 = this.c;
      if(var1 != null) {
         this.c = null;
         this.a.a(var1);
      }

   }

   protected void a(char[] var1, int var2, int var3) {
      throw new ArrayIndexOutOfBoundsException("read(buf," + var2 + "," + var3 + "), cbuf[" + var1.length + "]");
   }

   protected void b() {
      throw new IOException("Strange I/O stream, returned 0 bytes on read");
   }

   public void close() {
      InputStream var1 = this.b;
      if(var1 != null) {
         this.b = null;
         this.a();
         var1.close();
      }

   }

   public int read() {
      if(this.f == null) {
         this.f = new char[1];
      }

      return this.read(this.f, 0, 1) <= 0?-1:this.f[0];
   }
}
