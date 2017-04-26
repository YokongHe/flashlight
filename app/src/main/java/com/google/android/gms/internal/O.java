package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import java.util.Iterator;

public final class O {
   private final com.google.android.gms.internal.cx a;
   private final com.google.android.gms.internal.Y b;
   private final Context c;
   private final Object d = new Object();
   private final com.google.android.gms.internal.Q e;
   private boolean f = false;
   private com.google.android.gms.internal.T g;

   public O(Context var1, com.google.android.gms.internal.cx var2, com.google.android.gms.internal.Y var3, com.google.android.gms.internal.Q var4) {
      this.c = var1;
      this.a = var2;
      this.b = var3;
      this.e = var4;
   }

   public final com.google.android.gms.internal.U a(long var1, long var3) {
      com.google.android.gms.internal.bJ.a("Starting mediation.");
      Iterator var6 = this.e.a.iterator();

      while(var6.hasNext()) {
         com.google.android.gms.internal.P var7 = (com.google.android.gms.internal.P)var6.next();
         com.google.android.gms.internal.bJ.c("Trying mediation network: " + var7.b);
         Iterator var8 = var7.c.iterator();

         while(var8.hasNext()) {
            String var9 = (String)var8.next();
            Object var5 = this.d;
            synchronized(var5) {
               if(this.f) {
                  com.google.android.gms.internal.U var12 = new com.google.android.gms.internal.U(-1);
                  return var12;
               }

               this.g = new com.google.android.gms.internal.T(this.c, var9, this.b, this.e, var7, this.a.c, this.a.d, this.a.k);
            }

            final com.google.android.gms.internal.U var11 = this.g.a(var1, 60000L);
            if(var11.a == 0) {
               com.google.android.gms.internal.bJ.a("Adapter succeeded.");
               return var11;
            }

            if(var11.c != null) {
               com.google.android.gms.internal.bI.a.post(new Runnable() {
                  public final void run() {
                     try {
                        var11.c.c();
                     } catch (RemoteException var2) {
                        com.google.android.gms.internal.bJ.b("Could not destroy mediation adapter.", var2);
                     }
                  }
               });
            }
         }
      }

      return new com.google.android.gms.internal.U(1);
   }

   public final void a() {
      Object var1 = this.d;
      synchronized(var1) {
         this.f = true;
         if(this.g != null) {
            this.g.a();
         }

      }
   }
}
