package com.ihs.b.a;

import android.os.Build;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.SurfaceView;

public final class d {
   private boolean a;
   private final String b;
   private SurfaceView c;
   private com.ihs.b.a.c d;
   private boolean e;

   private d() {
      this.a = false;
      this.b = "flashlight manager";
      this.c = null;
      this.d = null;
      this.e = false;
   }

   // $FF: synthetic method
   d(byte var1) {
      this();
   }

   public static com.ihs.b.a.d a() {
      return com.ihs.b.a.e.a();
   }

   private boolean a(int param1) {
      // $FF: Couldn't be decompiled
   }

   private boolean h() {
      // $FF: Couldn't be decompiled
   }

   public final void a(SurfaceView var1) {
      this.c = var1;
   }

   public final boolean b() {
      this.a = false;
      int var1 = VERSION.SDK_INT;
      String var2 = Build.MANUFACTURER;
      String var3 = Build.BRAND;
      String var4 = Build.MODEL;
      this.e = false;
      Log.d("flashlight manager", "system sdk version is:" + var1);
      Log.d("flashlight manager", "mobile manufacture is:" + var2);
      Log.d("flashlight manager", "mobile brand is:" + var3);
      Log.d("flashlight manager", "mobile model is:" + var4);
      byte var5;
      if("samsung".equalsIgnoreCase(var2)) {
         if(!"GT-S5830".equalsIgnoreCase(var4) && !"GT-P1000".equalsIgnoreCase(var4)) {
            if("SCH-I500".equalsIgnoreCase(var4)) {
               var5 = 5;
            } else {
               var5 = 0;
            }
         } else {
            var5 = 4;
         }
      } else if("motorola".equalsIgnoreCase(var2)) {
         if("droid".equalsIgnoreCase(var4)) {
            var5 = 3;
         } else {
            var5 = 0;
         }
      } else {
         var5 = 0;
      }

      if(!this.a(var5)) {
         return false;
      } else {
         Log.d("flashlight manager", "open flashlight now");
         return this.d.a();
      }
   }

   public final com.ihs.b.a.b c() {
      return this.d.e();
   }

   protected final Object clone() {
      return new CloneNotSupportedException();
   }

   public final boolean d() {
      try {
         this.e = true;
         if(this.d != null) {
            this.d.c();
         }

         return true;
      } catch (Exception var2) {
         var2.printStackTrace();
         return true;
      }
   }

   public final boolean e() {
      try {
         this.e = false;
         if(this.d != null) {
            this.d.d();
         }
      } catch (Exception var2) {
         var2.printStackTrace();
      }

      return true;
   }

   public final void f() {
      try {
         this.e = false;
         if(this.d != null) {
            this.d.b();
         }

         this.d = null;
      } catch (Exception var2) {
         var2.printStackTrace();
      }
   }

   public final boolean g() {
      return this.e;
   }
}
