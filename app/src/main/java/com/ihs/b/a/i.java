package com.ihs.b.a;

import android.hardware.Camera;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.SurfaceView;

public final class i extends com.ihs.b.a.c {
   private Camera c = null;
   private Handler d = new Handler(Looper.getMainLooper()) {
      public final void handleMessage(Message var1) {
         if(i.this.c != null) {
            com.ihs.b.a.i.b(i.this);
         }

      }
   };

   // $FF: synthetic method
   static void b(com.ihs.b.a.i param0) {
      // $FF: Couldn't be decompiled
   }

   private boolean f() {
      if(this.c != null) {
         return true;
      } else {
         this.a = com.ihs.b.a.b.b;

         try {
            this.c = Camera.open();
         } catch (RuntimeException var2) {
            this.a = com.ihs.b.a.b.c;
            var2.printStackTrace();
            return false;
         }

         this.a = com.ihs.b.a.b.a;
         return true;
      }
   }

   private void g() {
      if(this.c != null) {
         try {
            this.c.release();
         } catch (Exception var2) {
            var2.printStackTrace();
         }

         this.c = null;
      }
   }

   public final void a(SurfaceView var1) {
   }

   public final boolean a() {
      return this.f();
   }

   public final void b() {
      this.g();
   }

   public final boolean c() {
      // $FF: Couldn't be decompiled
   }

   public final boolean d() {
      this.g();
      return true;
   }

   public final com.ihs.b.a.b e() {
      return this.a;
   }
}
