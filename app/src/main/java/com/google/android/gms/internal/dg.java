package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import com.google.android.gms.internal.dh;

public final class dg {
   private String a = "googleads.g.doubleclick.net";
   private String b = "/pagead/ads";
   private String[] c = new String[]{".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};
   private com.google.android.gms.internal.cS d;
   private final com.google.android.gms.internal.cP e = new com.google.android.gms.internal.cP();

   public dg(com.google.android.gms.internal.cS var1) {
      this.d = var1;
   }

   private Uri a(Uri param1, Context param2, String param3, boolean param4) {
      // $FF: Couldn't be decompiled
   }

   public final Uri a(Uri var1, Context var2) {
      try {
         var1 = this.a(var1, var2, var1.getQueryParameter("ai"), true);
         return var1;
      } catch (UnsupportedOperationException var3) {
         throw new dh("Provided Uri is not in a valid state");
      }
   }

   public final com.google.android.gms.internal.cS a() {
      return this.d;
   }

   public final void a(MotionEvent var1) {
      this.d.a(var1);
   }

   public final boolean a(Uri param1) {
      // $FF: Couldn't be decompiled
   }
}
