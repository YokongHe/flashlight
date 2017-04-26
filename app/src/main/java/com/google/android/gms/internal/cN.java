package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;

public final class cN extends com.google.android.gms.a.g {
   private static final com.google.android.gms.internal.cN a = new com.google.android.gms.internal.cN();

   private cN() {
      super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
   }

   public static View a(Context var0, int var1, int var2) {
      return a.b(var0, var1, var2);
   }

   private View b(Context var1, int var2, int var3) {
      try {
         com.google.android.gms.a.b var4 = com.google.android.gms.a.e.a((Object)var1);
         View var6 = (View)com.google.android.gms.a.e.a(((com.google.android.gms.internal.cH)this.a(var1)).a(var4, var2, var3));
         return var6;
      } catch (Exception var5) {
         throw new com.google.android.gms.a.h("Could not get button with size " + var2 + " and color " + var3, var5);
      }
   }

   // $FF: synthetic method
   public final Object a(IBinder var1) {
      return com.google.android.gms.internal.cI.a(var1);
   }
}
