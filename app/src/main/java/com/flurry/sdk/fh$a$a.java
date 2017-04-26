package com.flurry.sdk;

import com.flurry.sdk.fh$a;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

class fh$a$a extends FilterOutputStream {
   // $FF: synthetic field
   final fh$a a;

   private fh$a$a(fh$a var1, OutputStream var2) {
      super(var2);
      this.a = var1;
   }

   // $FF: synthetic method
   fh$a$a(fh$a var1, OutputStream var2, Object var3) {
      this(var1, var2);
   }

   public void close() {
      try {
         this.out.close();
      } catch (IOException var2) {
         fh$a.a(this.a, true);
      }
   }

   public void flush() {
      try {
         this.out.flush();
      } catch (IOException var2) {
         fh$a.a(this.a, true);
      }
   }

   public void write(int var1) {
      try {
         this.out.write(var1);
      } catch (IOException var3) {
         fh$a.a(this.a, true);
      }
   }

   public void write(byte[] var1, int var2, int var3) {
      try {
         this.out.write(var1, var2, var3);
      } catch (IOException var4) {
         fh$a.a(this.a, true);
      }
   }
}
