package com.inneractive.api.ads.sdk;

import android.content.Context;
import android.os.AsyncTask;
import com.inneractive.api.ads.sdk.IAnetworkFetcher;
import com.inneractive.api.ads.sdk.IAnetworkFetcher$NetworkFetcherStatus;
import com.inneractive.api.ads.sdk.InneractiveAdView$InneractiveErrorCode;
import com.inneractive.api.ads.sdk.InneractiveAdView$Log;
import com.inneractive.api.ads.sdk.aa$a;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.DefaultHttpClient;

final class aa extends AsyncTask {
   private com.inneractive.api.ads.sdk.ac a;
   private aa$a b;
   private Exception c;
   private DefaultHttpClient d;
   private long e;
   private String f;
   private com.inneractive.api.ads.sdk.a g;
   private IAnetworkFetcher$NetworkFetcherStatus h;
   private Context i;

   aa(Context var1, com.inneractive.api.ads.sdk.ac var2, com.inneractive.api.ads.sdk.a var3) {
      this.h = IAnetworkFetcher$NetworkFetcherStatus.a;
      this.a = var2;
      this.d = com.inneractive.api.ads.sdk.y.a(IAnetworkFetcher.a, IAnetworkFetcher.b);
      this.e = this.a.a();
      this.f = com.inneractive.api.ads.sdk.a.i();
      this.i = var1;
      this.g = var3;
   }

   private com.inneractive.api.ads.sdk.ag a(String... param1) {
      // $FF: Couldn't be decompiled
   }

   private void a() {
      this.a = null;
      this.c = null;
      this.h = IAnetworkFetcher$NetworkFetcherStatus.a;
   }

   private void b() {
      if(this.d != null) {
         ClientConnectionManager var1 = this.d.getConnectionManager();
         if(var1 != null) {
            var1.shutdown();
         }

         this.d = null;
      }

   }

   private boolean c() {
      return this.a == null?false:this.a.b(this.e);
   }

   final void a(aa$a var1) {
      this.b = var1;
   }

   // $FF: synthetic method
   protected final Object doInBackground(Object[] var1) {
      return this.a((String[])var1);
   }

   protected final void onCancelled() {
      if(!this.c()) {
         InneractiveAdView$Log.d("IANetworkFetcherTask - onCancelled() case old ad");
         this.a();
      } else {
         InneractiveAdView$Log.a("Ad loading was cancelled.");
         if(this.c != null) {
            InneractiveAdView$Log.a("oops...Exception caught while loading ad: " + this.c);
         }

         this.a.a(this.e);
         this.a();
      }
   }

   // $FF: synthetic method
   protected final void onPostExecute(Object var1) {
      com.inneractive.api.ads.sdk.ag var2 = (com.inneractive.api.ads.sdk.ag)var1;
      if(!this.c()) {
         InneractiveAdView$Log.d("IANetworkFetcherTask - onPostExecute case old ad");
         this.a();
      } else {
         if(!this.isCancelled()) {
            if(var2 != null) {
               if(this.b != null) {
                  this.b.a(var2);
               }
            } else {
               if(this.c != null) {
                  InneractiveAdView$Log.a("oops...Exception caught while fetching ad: " + this.c);
               }

               InneractiveAdView$InneractiveErrorCode var3;
               switch(null.a[this.h.ordinal()]) {
               case 1:
                  var3 = InneractiveAdView$InneractiveErrorCode.UNSPECIFIED;
                  InneractiveAdView$Log.d("error - not set");
                  break;
               case 2:
                  var3 = InneractiveAdView$InneractiveErrorCode.CANCELLED;
                  InneractiveAdView$Log.d("error - fetch network cancelled");
                  break;
               case 3:
                  InneractiveAdView$Log.d("error - invalid server reponse (backoff)");
               case 4:
                  var3 = InneractiveAdView$InneractiveErrorCode.SERVER_INTERNAL_ERROR;
                  InneractiveAdView$Log.d("error - invalid server response");
                  break;
               default:
                  var3 = InneractiveAdView$InneractiveErrorCode.UNSPECIFIED;
                  InneractiveAdView$Log.d("error - clear adtype");
               }

               if(this.b != null) {
                  this.b.a(var3);
               }

               if(this.h == IAnetworkFetcher$NetworkFetcherStatus.c) {
                  this.h = IAnetworkFetcher$NetworkFetcherStatus.a;
               }
            }
         }

         this.a.a(this.e);
         this.a();
      }
   }
}
