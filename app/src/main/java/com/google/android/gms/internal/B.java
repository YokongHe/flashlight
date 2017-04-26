package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;

public final class B {
   private final com.google.android.gms.internal.X a;
   private final Context b;
   private final com.google.android.gms.internal.j c;
   private com.google.android.gms.ads.a d;
   private com.google.android.gms.internal.p e;
   private String f;
   private com.google.android.gms.ads.doubleclick.a g;
   private com.google.android.gms.ads.b.a h;

   public B(Context var1) {
      this(var1, com.google.android.gms.internal.j.a());
   }

   private B(Context var1, com.google.android.gms.internal.j var2) {
      this.a = new com.google.android.gms.internal.X();
      this.b = var1;
      this.c = var2;
   }

   private void b(String var1) {
      if(this.e == null) {
         throw new IllegalStateException("The ad unit ID must be set on InterstitialAd before " + var1 + " is called.");
      }
   }

   public final void a(com.google.android.gms.ads.a param1) {
      // $FF: Couldn't be decompiled
   }

   public final void a(com.google.android.gms.internal.y var1) {
      try {
         if(this.e == null) {
            if(this.f == null) {
               this.b("loadAd");
            }

            this.e = com.google.android.gms.internal.h.a(this.b, new com.google.android.gms.internal.ak(), this.f, this.a);
            if(this.d != null) {
               this.e.a((com.google.android.gms.internal.m)(new com.google.android.gms.internal.g(this.d)));
            }

            if(this.g != null) {
               this.e.a((com.google.android.gms.internal.v)(new com.google.android.gms.internal.l(this.g)));
            }

            if(this.h != null) {
               this.e.a((com.google.android.gms.internal.aP)(new com.google.android.gms.internal.aS(this.h)));
            }
         }

         com.google.android.gms.internal.p var2 = this.e;
         com.google.android.gms.internal.j var3 = this.c;
         if(var2.a(com.google.android.gms.internal.j.a(this.b, var1))) {
            this.a.a(var1.i());
            this.a.b(var1.j());
         }

      } catch (RemoteException var4) {
         com.google.android.gms.internal.bJ.b("Failed to load ad.", var4);
      }
   }

   public final void a(String var1) {
      if(this.f != null) {
         throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
      } else {
         this.f = var1;
      }
   }

   public final boolean a() {
      try {
         if(this.e == null) {
            return false;
         } else {
            boolean var1 = this.e.c();
            return var1;
         }
      } catch (RemoteException var3) {
         com.google.android.gms.internal.bJ.b("Failed to check if ad is ready.", var3);
         return false;
      }
   }

   public final void b() {
      try {
         this.b("show");
         this.e.f();
      } catch (RemoteException var2) {
         com.google.android.gms.internal.bJ.b("Failed to show interstitial.", var2);
      }
   }
}
