package com.inneractive.api.ads.sdk;

import android.content.Context;
import android.os.AsyncTask;
import com.inneractive.api.ads.sdk.IAdefines;
import com.inneractive.api.ads.sdk.InneractiveAdView$Log;
import com.inneractive.api.ads.sdk.aa$a;

final class IAnetworkFetcher {
   static int a;
   static int b;
   private com.inneractive.api.ads.sdk.aa c;
   private com.inneractive.api.ads.sdk.a d;
   private final com.inneractive.api.ads.sdk.ac e;
   private aa$a f;

   static {
      a = IAdefines.g;
      b = IAdefines.f;
   }

   IAnetworkFetcher(com.inneractive.api.ads.sdk.a var1, aa$a var2) {
      this.d = var1;
      this.e = new com.inneractive.api.ads.sdk.ac();
      this.f = var2;
   }

   final void a() {
      if(this.c != null) {
         InneractiveAdView$Log.d("Canceling network fetch ad for task #" + this.e.a());
         this.c.cancel(true);
      }

   }

   final void a(String var1, Context var2) {
      this.e.b();
      InneractiveAdView$Log.d("Network fetching ad for task #" + this.e.a());
      if(this.c != null) {
         this.c.cancel(true);
      }

      this.c = com.inneractive.api.ads.sdk.ab.a(var2, this.e, this.d);
      this.c.a(this.f);

      try {
         com.inneractive.api.ads.sdk.a.a((AsyncTask)this.c, (Object[])(new String[]{var1}));
      } catch (Exception var3) {
         InneractiveAdView$Log.a("Error executing AdFetchTask");
      }
   }
}
