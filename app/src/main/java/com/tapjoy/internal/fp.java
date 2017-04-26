package com.tapjoy.internal;

import android.app.Activity;
import android.opengl.GLSurfaceView;

public final class fp {
   public static final com.tapjoy.internal.bf a = new com.tapjoy.internal.bf() {
      public final boolean a(Runnable var1) {
         GLSurfaceView var2 = (GLSurfaceView)fp.c.a();
         if(var2 != null) {
            var2.queueEvent(var1);
            return true;
         } else {
            return false;
         }
      }
   };
   private static Activity b;
   private static final com.tapjoy.internal.ce c = new com.tapjoy.internal.ce();
   private static final com.tapjoy.internal.ce d = new com.tapjoy.internal.ce();

   public static Activity a() {
      Activity var1 = b;
      Activity var0 = var1;
      if(var1 == null) {
         var0 = com.tapjoy.internal.d.a();
      }

      return var0;
   }

   static void a(GLSurfaceView var0) {
      c.a(var0);
      var0.queueEvent(new Runnable() {
         public final void run() {
            Thread var1 = Thread.currentThread();
            fp.d.a(var1);
         }
      });
   }

   public static Thread b() {
      return (Thread)d.a();
   }
}
