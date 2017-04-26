package com.tapjoy.internal;

import android.content.Context;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.WindowManager;

public enum ag {
   a,
   b,
   c,
   d,
   e,
   f,
   g,
   h,
   i,
   j,
   k,
   l,
   m,
   n,
   o,
   p;

   private final com.tapjoy.internal.ag q;
   private final com.tapjoy.internal.ag r;

   static {
      e = new com.tapjoy.internal.ag("NATURAL_PORTRAIT", 4, b);
      f = new com.tapjoy.internal.ag("RIGHT_LANDSCAPE", 5, c, e);
      g = new com.tapjoy.internal.ag("REVERSE_PORTRAIT", 6, b, e);
      h = new com.tapjoy.internal.ag("LEFT_LANDSCAPE", 7, c, e);
      i = new com.tapjoy.internal.ag("NATURAL_LANDSCAPE", 8, c);
      j = new com.tapjoy.internal.ag("RIGHT_PORTRAIT", 9, b, i);
      k = new com.tapjoy.internal.ag("REVERSE_LANDSCAPE", 10, c, i);
      l = new com.tapjoy.internal.ag("LEFT_PORTRAIT", 11, b, i);
      m = new com.tapjoy.internal.ag("NATURAL_SQUARE", 12, d);
      n = new com.tapjoy.internal.ag("RIGHT_SQUARE", 13, d, m);
      o = new com.tapjoy.internal.ag("REVERSE_SQUARE", 14, d, m);
      p = new com.tapjoy.internal.ag("LEFT_SQUARE", 15, d, m);
   }

   private ag() {
      this.q = this;
      this.r = null;
   }

   private ag(com.tapjoy.internal.ag var3) {
      this.q = var3;
      this.r = this;
   }

   private ag(com.tapjoy.internal.ag var3, com.tapjoy.internal.ag var4) {
      this.q = var3;
      this.r = var4;
   }

   public static com.tapjoy.internal.ag a(Context var0) {
      Display var3 = ((WindowManager)var0.getSystemService("window")).getDefaultDisplay();
      int var1 = var3.getRotation();
      Point var2 = new Point();
      if(VERSION.SDK_INT >= 13) {
         var3.getSize(var2);
      } else {
         var2.x = var3.getWidth();
         var2.y = var3.getHeight();
      }

      if(var2.x < var2.y) {
         switch(var1 & 3) {
         case 1:
            return j;
         case 2:
            return g;
         case 3:
            return l;
         default:
            return e;
         }
      } else if(var2.x > var2.y) {
         switch(var1 & 3) {
         case 1:
            return f;
         case 2:
            return k;
         case 3:
            return h;
         default:
            return i;
         }
      } else {
         switch(var1 & 3) {
         case 1:
            return n;
         case 2:
            return o;
         case 3:
            return p;
         default:
            return m;
         }
      }
   }

   public static com.tapjoy.internal.ag b(Context var0) {
      switch(var0.getResources().getConfiguration().orientation) {
      case 1:
         return b;
      case 2:
         return c;
      default:
         return a;
      }
   }

   public final boolean a() {
      return this == b || this.q == b;
   }

   public final boolean b() {
      return this == c || this.q == c;
   }

   public final int c() {
      return this.r != null?this.ordinal() - this.r.ordinal():0;
   }
}
