package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;

final class bM extends MutableContextWrapper {
   private Activity a;
   private Context b;

   public bM(Context var1) {
      super(var1);
      this.setBaseContext(var1);
   }

   public final void setBaseContext(Context var1) {
      this.b = var1.getApplicationContext();
      Activity var2;
      if(var1 instanceof Activity) {
         var2 = (Activity)var1;
      } else {
         var2 = null;
      }

      this.a = var2;
      super.setBaseContext(this.b);
   }

   public final void startActivity(Intent var1) {
      if(this.a != null) {
         this.a.startActivity(var1);
      } else {
         var1.setFlags(268435456);
         this.b.startActivity(var1);
      }
   }
}
