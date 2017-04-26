package com.ihs.b.a;

import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.Parameters;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.SurfaceHolder.Callback;
import java.io.IOException;

public final class j extends com.ihs.b.a.c implements AutoFocusCallback {
   private AutoFocusCallback c = new AutoFocusCallback() {
      public final void onAutoFocus(boolean var1, Camera var2) {
         try {
            j.this.g.autoFocus(j.this.c);
         } catch (Exception var3) {
            ;
         }
      }
   };
   private Handler d = new Handler(Looper.getMainLooper()) {
      public final void handleMessage(Message var1) {
         try {
            j.this.g.autoFocus((AutoFocusCallback)null);
         } catch (Exception var2) {
            ;
         }
      }
   };
   private SurfaceView e;
   private SurfaceHolder f;
   private Camera g;
   private Callback h = new Callback() {
      public final void surfaceChanged(SurfaceHolder var1, int var2, int var3, int var4) {
         if(j.this.g != null) {
            try {
               j.this.g.startPreview();
            } catch (Exception var5) {
               var5.printStackTrace();
               return;
            }
         }

      }

      public final void surfaceCreated(SurfaceHolder var1) {
         if(j.this.g != null) {
            try {
               j.this.g.setPreviewDisplay(j.this.f);
            } catch (IOException var2) {
               var2.printStackTrace();
               return;
            }
         }

      }

      public final void surfaceDestroyed(SurfaceHolder var1) {
      }
   };

   private void f() {
      if(this.g != null) {
         Parameters var1 = this.g.getParameters();
         var1.setFlashMode("off");
         this.g.setParameters(var1);
         this.g.cancelAutoFocus();
         this.g.release();
         this.g = null;
      }
   }

   private boolean g() {
      if(this.g == null) {
         try {
            this.g = Camera.open();
         } catch (Exception var3) {
            var3.printStackTrace();
            return false;
         }
      }

      try {
         this.f = this.e.getHolder();
         this.f.addCallback(this.h);
         this.f.setType(3);
      } catch (Exception var2) {
         var2.printStackTrace();
      }

      return true;
   }

   public final void a(SurfaceView var1) {
      this.e = var1;
   }

   public final boolean a() {
      try {
         this.g = Camera.open();
      } catch (RuntimeException var2) {
         this.a = com.ihs.b.a.b.c;
         return false;
      }

      Parameters var1 = this.g.getParameters();
      var1.setFlashMode("off");
      this.g.setParameters(var1);
      this.g.release();
      this.g = null;
      this.a = com.ihs.b.a.b.a;
      return true;
   }

   public final void b() {
      this.f();
   }

   public final boolean c() {
      if(this.g()) {
         Parameters var1 = this.g.getParameters();

         try {
            var1.setFlashMode("torch");
            this.g.setParameters(var1);
            this.g.startPreview();
            this.g.autoFocus(this.c);
            this.d.sendEmptyMessageDelayed(0, 100L);
            var1.setFlashMode("off");
         } catch (Exception var2) {
            ;
         }
      }

      return true;
   }

   public final boolean d() {
      this.f();
      return true;
   }

   public final com.ihs.b.a.b e() {
      return this.a;
   }

   public final void onAutoFocus(boolean var1, Camera var2) {
   }
}
