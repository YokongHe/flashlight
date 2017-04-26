package com.google.android.gms.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.google.android.gms.internal.di;
import com.google.android.gms.internal.dj;

public abstract class cT implements com.google.android.gms.internal.cS {
   protected MotionEvent a;
   protected DisplayMetrics b;
   protected di c;
   private dj d;

   protected cT(Context var1, di var2, dj var3) {
      this.c = var2;
      this.d = var3;

      try {
         this.b = var1.getResources().getDisplayMetrics();
      } catch (UnsupportedOperationException var4) {
         this.b = new DisplayMetrics();
         this.b.density = 1.0F;
      }
   }

   private String a(Context param1, String param2, boolean param3) {
      // $FF: Couldn't be decompiled
   }

   private void a() {
      this.d.a();
   }

   private byte[] b() {
      return this.d.b();
   }

   public final String a(Context var1) {
      return this.a(var1, (String)null, false);
   }

   public final String a(Context var1, String var2) {
      return this.a(var1, var2, true);
   }

   public final void a(int var1, int var2, int var3) {
      if(this.a != null) {
         this.a.recycle();
      }

      this.a = MotionEvent.obtain(0L, (long)var3, 1, (float)var1 * this.b.density, (float)var2 * this.b.density, 0.0F, 0.0F, 0, 0.0F, 0.0F, 0, 0);
   }

   protected final void a(int var1, long var2) {
      this.d.a(var1, var2);
   }

   protected final void a(int var1, String var2) {
      this.d.a(var1, var2);
   }

   public final void a(MotionEvent var1) {
      if(var1.getAction() == 1) {
         if(this.a != null) {
            this.a.recycle();
         }

         this.a = MotionEvent.obtain(var1);
      }

   }

   protected abstract void b(Context var1);

   protected abstract void c(Context var1);
}
