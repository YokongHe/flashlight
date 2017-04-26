package com.tapjoy.internal;

import com.tapjoy.internal.dh;
import com.tapjoy.internal.dp;
import java.io.OutputStream;
import java.util.ArrayList;

public final class dh$b extends OutputStream {
   private static final byte[] a = new byte[0];
   private final int b = 128;
   private final ArrayList c = new ArrayList();
   private int d;
   private byte[] e = new byte[128];
   private int f;

   private void a(int var1) {
      this.c.add(new dp(this.e));
      this.d += this.e.length;
      this.e = new byte[Math.max(this.b, Math.max(var1, this.d >>> 1))];
      this.f = 0;
   }

   private int b() {
      synchronized(this){}

      int var1;
      int var2;
      try {
         var1 = this.d;
         var2 = this.f;
      } finally {
         ;
      }

      return var1 + var2;
   }

   public final dh a() {
      // $FF: Couldn't be decompiled
   }

   public final String toString() {
      return String.format("<ByteString.Output@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(this.b())});
   }

   public final void write(int var1) {
      synchronized(this){}
      boolean var5 = false;

      int var2;
      byte[] var3;
      try {
         var5 = true;
         if(this.f == this.e.length) {
            this.a(1);
         }

         var3 = this.e;
         var2 = this.f;
         this.f = var2 + 1;
         var5 = false;
      } finally {
         if(var5) {
            ;
         }
      }

      var3[var2] = (byte)var1;
   }

   public final void write(byte[] param1, int param2, int param3) {
      // $FF: Couldn't be decompiled
   }
}
