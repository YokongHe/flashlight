package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.ViewGroup;

public final class A {
   private final com.google.android.gms.internal.X a;
   private final com.google.android.gms.internal.j b;
   private com.google.android.gms.ads.a c;
   private com.google.android.gms.internal.p d;
   private com.google.android.gms.ads.d[] e;
   private String f;
   private ViewGroup g;
   private com.google.android.gms.ads.doubleclick.a h;
   private com.google.android.gms.ads.b.a i;

   public A(ViewGroup var1) {
      this(var1, (AttributeSet)null, false, com.google.android.gms.internal.j.a());
   }

   public A(ViewGroup var1, AttributeSet var2, boolean var3) {
      this(var1, var2, var3, com.google.android.gms.internal.j.a());
   }

   private A(ViewGroup var1, AttributeSet var2, boolean var3, com.google.android.gms.internal.j var4) {
      this.a = new com.google.android.gms.internal.X();
      this.g = var1;
      this.b = var4;
      if(var2 != null) {
         Context var7 = var1.getContext();

         try {
            com.google.android.gms.internal.an var6 = new com.google.android.gms.internal.an(var7, var2);
            this.e = var6.a(var3);
            this.f = var6.a();
         } catch (IllegalArgumentException var5) {
            com.google.android.gms.internal.bI.a(var1, new com.google.android.gms.internal.ak(var7, com.google.android.gms.ads.d.a), var5.getMessage(), var5.getMessage());
            return;
         }

         if(var1.isInEditMode()) {
            com.google.android.gms.internal.bI.a(var1, new com.google.android.gms.internal.ak(var7, this.e[0]), "Ads by Google");
         }
      }

   }

   private void e() {
      // $FF: Couldn't be decompiled
   }

   public final void a() {
      try {
         if(this.d != null) {
            this.d.b();
         }

      } catch (RemoteException var2) {
         com.google.android.gms.internal.bJ.b("Failed to destroy AdView.", var2);
      }
   }

   public final void a(com.google.android.gms.ads.a param1) {
      // $FF: Couldn't be decompiled
   }

   public final void a(com.google.android.gms.internal.y var1) {
      try {
         if(this.d == null) {
            if((this.e == null || this.f == null) && this.d == null) {
               throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
            }

            Context var2 = this.g.getContext();
            this.d = com.google.android.gms.internal.h.a(var2, new com.google.android.gms.internal.ak(var2, this.e), this.f, this.a);
            if(this.c != null) {
               this.d.a((com.google.android.gms.internal.m)(new com.google.android.gms.internal.g(this.c)));
            }

            if(this.h != null) {
               this.d.a((com.google.android.gms.internal.v)(new com.google.android.gms.internal.l(this.h)));
            }

            if(this.i != null) {
               this.d.a((com.google.android.gms.internal.aP)(new com.google.android.gms.internal.aS(this.i)));
            }

            this.e();
         }

         com.google.android.gms.internal.p var5 = this.d;
         com.google.android.gms.internal.j var3 = this.b;
         if(var5.a(com.google.android.gms.internal.j.a(this.g.getContext(), var1))) {
            this.a.a(var1.i());
            this.a.b(var1.j());
            return;
         }
      } catch (RemoteException var4) {
         com.google.android.gms.internal.bJ.b("Failed to load ad.", var4);
      }

   }

   public final void a(String var1) {
      if(this.f != null) {
         throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
      } else {
         this.f = var1;
      }
   }

   public final void a(com.google.android.gms.ads.d... var1) {
      if(this.e != null) {
         throw new IllegalStateException("The ad size can only be set once on AdView.");
      } else {
         this.b(var1);
      }
   }

   public final com.google.android.gms.ads.d b() {
      try {
         if(this.d != null) {
            com.google.android.gms.ads.d var1 = this.d.i().a();
            return var1;
         }
      } catch (RemoteException var2) {
         com.google.android.gms.internal.bJ.b("Failed to get the current AdSize.", var2);
      }

      return this.e != null?this.e[0]:null;
   }

   public final void b(com.google.android.gms.ads.d... var1) {
      this.e = var1;

      try {
         if(this.d != null) {
            this.d.a(new com.google.android.gms.internal.ak(this.g.getContext(), this.e));
         }
      } catch (RemoteException var2) {
         com.google.android.gms.internal.bJ.b("Failed to set the ad size.", var2);
      }

      this.g.requestLayout();
   }

   public final void c() {
      try {
         if(this.d != null) {
            this.d.d();
         }

      } catch (RemoteException var2) {
         com.google.android.gms.internal.bJ.b("Failed to call pause.", var2);
      }
   }

   public final void d() {
      try {
         if(this.d != null) {
            this.d.e();
         }

      } catch (RemoteException var2) {
         com.google.android.gms.internal.bJ.b("Failed to call resume.", var2);
      }
   }
}
