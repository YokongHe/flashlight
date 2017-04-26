package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

public final class aD extends com.google.android.gms.a.g {
   private static final com.google.android.gms.internal.aD a = new com.google.android.gms.internal.aD();

   private aD() {
      super("com.google.android.gms.ads.AdOverlayCreatorImpl");
   }

   public static com.google.android.gms.internal.aF a(Activity var0) {
      try {
         Intent var1 = var0.getIntent();
         if(!var1.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
            throw new com.google.android.gms.internal.aE("Ad overlay requires the useClientJar flag in intent extras.");
         } else if(var1.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false)) {
            com.google.android.gms.internal.bJ.a("Using AdOverlay from the client jar.");
            return new com.google.android.gms.internal.as(var0);
         } else {
            com.google.android.gms.internal.aF var3 = a.b(var0);
            return var3;
         }
      } catch (com.google.android.gms.internal.aE var2) {
         com.google.android.gms.internal.bJ.e(var2.getMessage());
         return null;
      }
   }

   private com.google.android.gms.internal.aF b(Activity var1) {
      try {
         com.google.android.gms.a.b var2 = com.google.android.gms.a.e.a((Object)var1);
         com.google.android.gms.internal.aF var5 = com.google.android.gms.internal.aG.a(((com.google.android.gms.internal.aI)this.a((Context)var1)).a(var2));
         return var5;
      } catch (RemoteException var3) {
         com.google.android.gms.internal.bJ.b("Could not create remote AdOverlay.", var3);
         return null;
      } catch (com.google.android.gms.a.h var4) {
         com.google.android.gms.internal.bJ.b("Could not create remote AdOverlay.", var4);
         return null;
      }
   }

   // $FF: synthetic method
   protected final Object a(IBinder var1) {
      return com.google.android.gms.internal.aJ.a(var1);
   }
}
