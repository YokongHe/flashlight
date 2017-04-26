package com.ihs.b.a;

import android.view.SurfaceView;
import java.lang.reflect.Method;

public final class h extends com.ihs.b.a.c {
   private Object c = null;
   private Method d = null;

   public final void a(SurfaceView var1) {
   }

   public final boolean a() {
      // $FF: Couldn't be decompiled
   }

   public final void b() {
      this.c = null;
      this.d = null;
   }

   public final boolean c() {
      if(this.d != null) {
         try {
            this.d.invoke(this.c, new Object[]{Boolean.valueOf(true)});
         } catch (Exception var2) {
            return false;
         }
      }

      return true;
   }

   public final boolean d() {
      if(this.d != null) {
         try {
            this.d.invoke(this.c, new Object[]{Boolean.valueOf(false)});
         } catch (Exception var2) {
            return false;
         }
      }

      return true;
   }

   public final com.ihs.b.a.b e() {
      return this.a;
   }
}
