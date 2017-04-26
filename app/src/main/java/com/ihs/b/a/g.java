package com.ihs.b.a;

import android.hardware.Camera;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.SurfaceHolder.Callback;

public final class g extends com.ihs.b.a.c implements Callback {
   private Camera c = null;
   private boolean d = false;
   private SurfaceView e;
   private boolean f;

   // $FF: synthetic method
   static Camera a(com.ihs.b.a.g var0) {
      return var0.c;
   }

   private boolean f() {
      // $FF: Couldn't be decompiled
   }

   private void g() {
      if(this.e != null) {
         try {
            this.e.getHolder().removeCallback(this);
         } catch (Exception var2) {
            var2.printStackTrace();
         }
      }
   }

   public final void a(SurfaceView var1) {
      this.e = var1;
   }

   public final boolean a() {
      return this.f();
   }

   public final void b() {
      if(this.c != null) {
         this.g();

         try {
            this.c.release();
         } catch (Exception var2) {
            var2.printStackTrace();
         }

         this.c = null;
      }

   }

   public final boolean c() {
      // $FF: Couldn't be decompiled
   }

   public final boolean d() {
      // $FF: Couldn't be decompiled
   }

   public final com.ihs.b.a.b e() {
      return this.a;
   }

   public final void surfaceChanged(SurfaceHolder var1, int var2, int var3, int var4) {
      if(this.b == com.ihs.b.a.a.a && this.f && this.c != null) {
         try {
            this.c.startPreview();
         } catch (Exception var5) {
            var5.printStackTrace();
            return;
         }
      }

   }

   public final void surfaceCreated(SurfaceHolder var1) {
      if(this.b == com.ihs.b.a.a.a && this.f && this.c != null) {
         try {
            this.c.setPreviewDisplay(var1);
         } catch (Exception var2) {
            var2.printStackTrace();
            return;
         }
      }

   }

   public final void surfaceDestroyed(SurfaceHolder var1) {
   }
}
