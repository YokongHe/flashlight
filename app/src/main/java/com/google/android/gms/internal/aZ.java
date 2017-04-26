package com.google.android.gms.internal;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Bitmap.Config;
import android.os.AsyncTask;
import android.view.View.MeasureSpec;
import android.webkit.WebView;

public final class aZ extends AsyncTask {
   // $FF: synthetic field
   final com.google.android.gms.internal.aY a;
   private final WebView b;
   private Bitmap c;

   public aZ(com.google.android.gms.internal.aY var1, WebView var2) {
      this.a = var1;
      this.b = var2;
   }

   private Boolean a() {
      // $FF: Couldn't be decompiled
   }

   // $FF: synthetic method
   protected final Object doInBackground(Object[] var1) {
      return this.a();
   }

   // $FF: synthetic method
   protected final void onPostExecute(Object var1) {
      Boolean var2 = (Boolean)var1;
      com.google.android.gms.internal.aY.c(this.a);
      if(!var2.booleanValue() && !this.a.c() && com.google.android.gms.internal.aY.d(this.a) > 0L) {
         if(com.google.android.gms.internal.aY.d(this.a) > 0L) {
            if(com.google.android.gms.internal.bJ.a(2)) {
               com.google.android.gms.internal.bJ.a("Ad not detected, scheduling another run.");
            }

            com.google.android.gms.internal.aY.g(this.a).postDelayed(this.a, com.google.android.gms.internal.aY.f(this.a));
            return;
         }
      } else {
         this.a.c = var2.booleanValue();
         com.google.android.gms.internal.aY.e(this.a).a(this.a.a);
      }

   }

   protected final void onPreExecute() {
      synchronized(this){}

      try {
         this.c = Bitmap.createBitmap(com.google.android.gms.internal.aY.a(this.a), com.google.android.gms.internal.aY.b(this.a), Config.ARGB_8888);
         this.b.setVisibility(0);
         this.b.measure(MeasureSpec.makeMeasureSpec(com.google.android.gms.internal.aY.a(this.a), 0), MeasureSpec.makeMeasureSpec(com.google.android.gms.internal.aY.b(this.a), 0));
         this.b.layout(0, 0, com.google.android.gms.internal.aY.a(this.a), com.google.android.gms.internal.aY.b(this.a));
         Canvas var1 = new Canvas(this.c);
         this.b.draw(var1);
         this.b.invalidate();
      } finally {
         ;
      }

   }
}
