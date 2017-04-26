package com.google.android.gms.plus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.android.gms.plus.PlusOneButton;

public final class a implements OnClickListener, com.google.android.gms.plus.b {
   // $FF: synthetic field
   final PlusOneButton a;
   private final com.google.android.gms.plus.b b;

   public a(PlusOneButton var1, com.google.android.gms.plus.b var2) {
      this.a = var1;
      this.b = var2;
   }

   public final void a(Intent var1) {
      Context var2 = this.a.getContext();
      if(var2 instanceof Activity && var1 != null) {
         ((Activity)var2).startActivityForResult(var1, PlusOneButton.b(this.a));
      }

   }

   public final void onClick(View var1) {
      Intent var2 = (Intent)PlusOneButton.a(this.a).getTag();
      if(this.b != null) {
         this.b.a(var2);
      } else {
         this.a(var2);
      }
   }
}
