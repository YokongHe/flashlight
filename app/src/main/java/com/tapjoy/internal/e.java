package com.tapjoy.internal;

import android.app.Dialog;
import android.content.Context;

public final class e extends Dialog {
   private boolean a = false;

   public e(Context var1) {
      super(var1, 16973835);
      this.requestWindowFeature(1);
      this.getWindow().setBackgroundDrawableResource(17170445);
   }

   public final void a() {
      this.getWindow().setLayout(-1, -1);
   }

   public final void cancel() {
      this.a = true;
      super.cancel();
   }

   public final void show() {
      this.a = false;
      super.show();
   }
}
