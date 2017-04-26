package com.flurry.sdk;

import com.flurry.sdk.fn;
import com.flurry.sdk.gb;
import com.flurry.sdk.gf;
import com.flurry.sdk.gg$a;
import com.flurry.sdk.gl;
import java.io.InputStream;

public class gg {
   private static final gg b = new gg$a(null);
   int a = 8192;

   public static gg a() {
      return b;
   }

   public gb a(InputStream var1, gb var2) {
      return var2 != null && var2.getClass().equals(gb.class)?var2.a(var1, this.a):new gb(var1, this.a);
   }

   public gb a(byte[] var1, int var2, int var3, gb var4) {
      return var4 != null && var4.getClass().equals(gb.class)?var4.a(var1, var2, var3):new gb(var1, var2, var3);
   }

   public gb a(byte[] var1, gb var2) {
      return this.a(var1, 0, var1.length, var2);
   }

   public gl a(fn var1, fn var2, gf var3) {
      return new gl(var1, var2, var3);
   }
}
