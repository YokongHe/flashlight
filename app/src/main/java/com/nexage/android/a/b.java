package com.nexage.android.a;

import android.view.View;
import android.view.View.OnClickListener;
import com.nexage.android.NexageAdView;

public abstract class b {
   private NexageAdView a;
   private OnClickListener b;

   public final void a() {
      if(this.b != null) {
         this.b.onClick(this.a);
      }

   }

   public final void a(OnClickListener var1, NexageAdView var2) {
      this.b = var1;
      this.a = var2;
   }

   public abstract View b();

   public void c() {
   }
}
