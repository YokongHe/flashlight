package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.dg;
import com.google.android.gms.internal.ds;
import com.google.android.gms.internal.dx;
import java.util.HashSet;

final class dt {
   public final ds a;
   public final String b;
   public final Context c;
   public final dg d;
   public final dx e;
   public com.google.android.gms.internal.m f;
   public com.google.android.gms.internal.bB g;
   public com.google.android.gms.internal.ak h;
   public com.google.android.gms.internal.bt i;
   public com.google.android.gms.internal.bu j;
   public com.google.android.gms.internal.v k;
   public com.google.android.gms.internal.aP l;
   public com.google.android.gms.internal.bz m = null;
   private HashSet n = null;

   public dt(Context var1, com.google.android.gms.internal.ak var2, String var3, dx var4) {
      if(var2.e) {
         this.a = null;
      } else {
         this.a = new ds(var1);
         this.a.setMinimumWidth(var2.g);
         this.a.setMinimumHeight(var2.d);
         this.a.setVisibility(4);
      }

      this.h = var2;
      this.b = var3;
      this.c = var1;
      this.d = new dg(com.google.android.gms.internal.cW.a(var4.b, var1));
      this.e = var4;
   }

   public final HashSet a() {
      return this.n;
   }

   public final void a(HashSet var1) {
      this.n = var1;
   }
}
