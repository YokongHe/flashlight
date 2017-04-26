package com.tapjoy.internal;

import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import com.tapjoy.internal.fh;
import java.lang.reflect.Method;

class eh extends fh {
   private static final Method a = a(Display.class, "getWidth", new Class[0]);
   private static final Method b = a(Display.class, "getHeight", new Class[0]);
   private static final Method c = a(Display.class, "getSize", new Class[]{Point.class});
   private static final String d = eh.class.getName();
   private final Display e;

   public eh(Display var1) {
      this.e = var1;
   }

   public final int a() {
      if(c != null) {
         Point var2 = new Point();
         a(this.e, c, new Object[]{var2});
         return var2.x;
      } else {
         if(a != null) {
            Integer var1 = (Integer)a(this.e, a, new Object[0]);
            if(var1 != null) {
               return var1.intValue();
            }
         }

         Log.w(d, "unable to get display width");
         return 0;
      }
   }

   public final int b() {
      if(c != null) {
         Point var2 = new Point();
         a(this.e, c, new Object[]{var2});
         return var2.y;
      } else {
         if(b != null) {
            Integer var1 = (Integer)a(this.e, b, new Object[0]);
            if(var1 != null) {
               return var1.intValue();
            }
         }

         Log.w(d, "unable to get display height");
         return 0;
      }
   }
}
