package com.google.android.gms.common;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.google.android.gms.internal.fs;

public final class SignInButton extends FrameLayout implements OnClickListener {
   private int a;
   private int b;
   private View c;
   private OnClickListener d;

   public SignInButton(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public SignInButton(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.d = null;
      com.google.android.gms.internal.cM.a(true, "Unknown button size " + 0);
      com.google.android.gms.internal.cM.a(true, "Unknown color scheme " + 0);
      this.a = 0;
      this.b = 0;
      this.a(this.getContext());
   }

   private void a(Context var1) {
      if(this.c != null) {
         this.removeView(this.c);
      }

      try {
         this.c = com.google.android.gms.internal.cN.a(var1, this.a, this.b);
      } catch (com.google.android.gms.a.h var5) {
         Log.w("SignInButton", "Sign in button not found, using placeholder instead");
         int var2 = this.a;
         int var3 = this.b;
         fs var4 = new fs(var1);
         var4.a(var1.getResources(), var2, var3);
         this.c = var4;
      }

      this.addView(this.c);
      this.c.setEnabled(this.isEnabled());
      this.c.setOnClickListener(this);
   }

   public final void onClick(View var1) {
      if(this.d != null && var1 == this.c) {
         this.d.onClick(this);
      }

   }

   public final void setEnabled(boolean var1) {
      super.setEnabled(var1);
      this.c.setEnabled(var1);
   }

   public final void setOnClickListener(OnClickListener var1) {
      this.d = var1;
      if(this.c != null) {
         this.c.setOnClickListener(this);
      }

   }
}
