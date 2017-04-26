package com.tapjoy.internal;

import com.tapjoy.internal.dj;
import com.tapjoy.internal.dq;
import java.io.IOException;
import java.io.OutputStream;

public abstract class de implements dq {
   protected int a = 0;

   public final void a(OutputStream var1) {
      int var2 = 4096;
      int var3 = this.b();
      if(var3 <= 4096) {
         var2 = var3;
      }

      dj var4 = dj.a(var1, var2);
      this.a(var4);
      var4.a();
   }

   public final byte[] a() {
      try {
         byte[] var1 = new byte[this.b()];
         dj var2 = new dj(var1, var1.length);
         this.a(var2);
         if(var2.c == null) {
            if(var2.a - var2.b != 0) {
               throw new IllegalStateException("Did not write as much data as expected.");
            } else {
               return var1;
            }
         } else {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array.");
         }
      } catch (IOException var3) {
         throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", var3);
      }
   }
}
