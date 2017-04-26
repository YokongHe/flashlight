package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.RemoteException;
import java.util.Map;

public final class X extends com.google.android.gms.internal.Z {
   private Map a;
   private Map b;

   private com.google.android.gms.internal.ab b(String var1) {
      try {
         Class var2 = Class.forName(var1, false, com.google.android.gms.internal.X.class.getClassLoader());
         if(com.google.a.a.b.class.isAssignableFrom(var2)) {
            com.google.a.a.b var4 = (com.google.a.a.b)var2.newInstance();
            return new com.google.android.gms.internal.am(var4, (com.google.a.a.j)this.a.get(var4.getAdditionalParametersType()));
         } else if(com.google.android.gms.ads.a.b.class.isAssignableFrom(var2)) {
            return new com.google.android.gms.internal.aj((com.google.android.gms.ads.a.b)var2.newInstance(), (Bundle)this.b.get(var2));
         } else {
            com.google.android.gms.internal.bJ.e("Could not instantiate mediation adapter: " + var1 + " (not a valid adapter).");
            throw new RemoteException();
         }
      } catch (Throwable var3) {
         com.google.android.gms.internal.bJ.e("Could not instantiate mediation adapter: " + var1 + ". " + var3.getMessage());
         throw new RemoteException();
      }
   }

   public final com.google.android.gms.internal.ab a(String var1) {
      return this.b(var1);
   }

   public final void a(Map var1) {
      this.a = var1;
   }

   public final void b(Map var1) {
      this.b = var1;
   }
}
