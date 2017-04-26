package com.google.android.gms.plus;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

public final class PlusOneButton extends FrameLayout {
   private View a;
   private int b;
   private int c;
   private String d;
   private int e;
   private com.google.android.gms.plus.b f;

   public PlusOneButton(Context var1, AttributeSet var2) {
      byte var4 = 2;
      super(var1, var2);
      String var5 = com.google.android.gms.internal.cO.a("http://schemas.android.com/apk/lib/com.google.android.gms.plus", "size", var1, var2, true, false, "PlusOneButton");
      byte var3;
      if("SMALL".equalsIgnoreCase(var5)) {
         var3 = 0;
      } else if("MEDIUM".equalsIgnoreCase(var5)) {
         var3 = 1;
      } else if("TALL".equalsIgnoreCase(var5)) {
         var3 = 2;
      } else {
         var3 = 3;
      }

      this.b = var3;
      String var6 = com.google.android.gms.internal.cO.a("http://schemas.android.com/apk/lib/com.google.android.gms.plus", "annotation", var1, var2, true, false, "PlusOneButton");
      if("INLINE".equalsIgnoreCase(var6)) {
         var3 = var4;
      } else if("NONE".equalsIgnoreCase(var6)) {
         var3 = 0;
      } else {
         var3 = 1;
      }

      this.c = var3;
      this.e = -1;
      var1 = this.getContext();
      if(this.a != null) {
         this.removeView(this.a);
      }

      this.a = com.google.android.gms.plus.a.d.a(var1, this.b, this.c, this.d, this.e);
      com.google.android.gms.plus.b var7 = this.f;
      this.f = var7;
      this.a.setOnClickListener(new com.google.android.gms.plus.a(this, var7));
      this.addView(this.a);
      if(this.isInEditMode()) {
         ;
      }

   }

   // $FF: synthetic method
   static View a(PlusOneButton var0) {
      return var0.a;
   }

   // $FF: synthetic method
   static int b(PlusOneButton var0) {
      return var0.e;
   }

   protected final void onLayout(boolean var1, int var2, int var3, int var4, int var5) {
      this.a.layout(0, 0, var4 - var2, var5 - var3);
   }

   protected final void onMeasure(int var1, int var2) {
      View var3 = this.a;
      this.measureChild(var3, var1, var2);
      this.setMeasuredDimension(var3.getMeasuredWidth(), var3.getMeasuredHeight());
   }
}
