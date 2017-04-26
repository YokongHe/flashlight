package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;

public final class fs extends Button {
   public fs(Context var1) {
      this(var1, (AttributeSet)null);
   }

   public fs(Context var1, AttributeSet var2) {
      super(var1, var2, 16842824);
   }

   private static int a(int var0, int var1, int var2) {
      switch(var0) {
      case 1:
         var1 = var2;
      case 0:
         return var1;
      default:
         throw new IllegalStateException("Unknown color scheme: " + var0);
      }
   }

   public final void a(Resources var1, int var2, int var3) {
      boolean var7 = true;
      boolean var6;
      if(var2 >= 0 && var2 < 3) {
         var6 = true;
      } else {
         var6 = false;
      }

      com.google.android.gms.internal.cM.a(var6, "Unknown button size " + var2);
      if(var3 >= 0 && var3 < 2) {
         var6 = var7;
      } else {
         var6 = false;
      }

      com.google.android.gms.internal.cM.a(var6, "Unknown color scheme " + var3);
      this.setTypeface(Typeface.DEFAULT_BOLD);
      this.setTextSize(14.0F);
      float var4 = var1.getDisplayMetrics().density;
      this.setMinHeight((int)(var4 * 48.0F + 0.5F));
      this.setMinWidth((int)(var4 * 48.0F + 0.5F));
      int var5;
      switch(var2) {
      case 0:
      case 1:
         var5 = a(var3, com.google.android.gms.c.c, com.google.android.gms.c.d);
         break;
      case 2:
         var5 = a(var3, com.google.android.gms.c.a, com.google.android.gms.c.b);
         break;
      default:
         throw new IllegalStateException("Unknown button size: " + var2);
      }

      if(var5 == -1) {
         throw new IllegalStateException("Could not find background resource!");
      } else {
         this.setBackgroundDrawable(var1.getDrawable(var5));
         this.setTextColor(var1.getColorStateList(a(var3, com.google.android.gms.b.a, com.google.android.gms.b.b)));
         switch(var2) {
         case 0:
            this.setText(var1.getString(com.google.android.gms.d.b));
            return;
         case 1:
            this.setText(var1.getString(com.google.android.gms.d.c));
            return;
         case 2:
            this.setText((CharSequence)null);
            return;
         default:
            throw new IllegalStateException("Unknown button size: " + var2);
         }
      }
   }
}
