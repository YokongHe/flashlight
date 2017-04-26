package com.tapjoy.internal;

import android.os.Build.VERSION;
import com.tapjoy.internal.a$f;
import com.tapjoy.internal.a$g;
import com.tapjoy.internal.a$h;
import com.tapjoy.internal.a$i;
import com.tapjoy.internal.a$j;
import com.tapjoy.internal.a$k;

public final class a {
   private static final a$f a;

   static {
      if(VERSION.SDK_INT >= 16) {
         a = new a$k();
      } else if(VERSION.SDK_INT >= 14) {
         a = new a$j();
      } else if(VERSION.SDK_INT >= 11) {
         a = new a$i();
      } else if(VERSION.SDK_INT >= 9) {
         a = new a$h();
      } else {
         a = new a$g();
      }
   }

   // $FF: synthetic method
   public static a$f a() {
      return a;
   }
}
