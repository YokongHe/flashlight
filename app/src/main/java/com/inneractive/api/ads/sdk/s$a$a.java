package com.inneractive.api.ads.sdk;

import com.inneractive.api.ads.sdk.s$a;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

final class s$a$a extends FilterOutputStream {
   // $FF: synthetic field
   private s$a a;

   private s$a$a(s$a var1, OutputStream var2) {
      this.a = var1;
      super(var2);
   }

   // $FF: synthetic method
   s$a$a(s$a var1, OutputStream var2, byte var3) {
      this(var1, var2);
   }

   public final void close() {
      try {
         this.out.close();
      } catch (IOException var2) {
         s$a.a(this.a, true);
      }
   }

   public final void flush() {
      try {
         this.out.flush();
      } catch (IOException var2) {
         s$a.a(this.a, true);
      }
   }

   public final void write(int var1) {
      try {
         this.out.write(var1);
      } catch (IOException var3) {
         s$a.a(this.a, true);
      }
   }

   public final void write(byte[] var1, int var2, int var3) {
      try {
         this.out.write(var1, var2, var3);
      } catch (IOException var4) {
         s$a.a(this.a, true);
      }
   }
}
