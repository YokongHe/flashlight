package com.tapjoy.internal;

import com.tapjoy.internal.dg$a;
import com.tapjoy.internal.dh$a;
import com.tapjoy.internal.dp;
import java.util.Iterator;

final class dg extends dp {
   private final int d;
   private final int e;

   dg(byte[] var1, int var2, int var3) {
      super(var1);
      if(var2 < 0) {
         throw new IllegalArgumentException((new StringBuilder(29)).append("Offset too small: ").append(var2).toString());
      } else if(var3 < 0) {
         throw new IllegalArgumentException((new StringBuilder(29)).append("Length too small: ").append(var2).toString());
      } else if((long)var2 + (long)var3 > (long)var1.length) {
         throw new IllegalArgumentException((new StringBuilder(48)).append("Offset+Length too large: ").append(var2).append("+").append(var3).toString());
      } else {
         this.d = var2;
         this.e = var3;
      }
   }

   public final int a() {
      return this.e;
   }

   protected final void a(byte[] var1, int var2, int var3, int var4) {
      System.arraycopy(this.c, this.d + var2, var1, var3, var4);
   }

   protected final int b() {
      return this.d;
   }

   public final dh$a c() {
      return new dg$a(this, (byte)0);
   }

   // $FF: synthetic method
   public final Iterator iterator() {
      return this.c();
   }
}
