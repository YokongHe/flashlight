package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.FrameLayout.LayoutParams;

public final class aB extends FrameLayout implements OnClickListener {
   private final Activity a;
   private final ImageButton b;

   public aB(Activity var1, int var2) {
      super(var1);
      this.a = var1;
      this.setOnClickListener(this);
      this.b = new ImageButton(var1);
      this.b.setImageResource(17301527);
      this.b.setBackgroundColor(0);
      this.b.setOnClickListener(this);
      this.b.setPadding(0, 0, 0, 0);
      var2 = com.google.android.gms.internal.bI.a((Context)var1, var2);
      this.addView(this.b, new LayoutParams(var2, var2, 17));
   }

   public final void a(boolean var1) {
      ImageButton var3 = this.b;
      byte var2;
      if(var1) {
         var2 = 4;
      } else {
         var2 = 0;
      }

      var3.setVisibility(var2);
   }

   public final void onClick(View var1) {
      this.a.finish();
   }
}
