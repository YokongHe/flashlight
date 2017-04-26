package com.ihandysoft.ad.a;

import com.google.android.gms.ads.AdView;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

public class c extends com.ihandysoft.ad.a.a {
   private com.google.android.gms.ads.a n = new com.google.android.gms.ads.a() {
      public final void onAdClosed() {
         c.this.x();
      }

      public final void onAdFailedToLoad(int var1) {
         c.this.a(new Exception("ErrorCode:" + var1));
      }

      public final void onAdLeftApplication() {
         c.this.v();
         c.this.y();
      }

      public final void onAdLoaded() {
         c.this.u();
      }

      public final void onAdOpened() {
         c.this.v();
         c.this.w();
      }
   };

   public final boolean a(Map var1) {
      if(super.a(var1)) {
         String var2 = (String)this.d.get("adUnitID");
         if(var2 == null) {
            var2 = (String)this.d.get("publisherID");
         }

         String var4 = (String)var1.get("adUnitID");
         String var3 = var4;
         if(var4 == null) {
            var3 = (String)var1.get("publisherID");
         }

         return var2.equals(var3);
      } else {
         return false;
      }
   }

   public final void p() {
      com.google.android.gms.ads.d var3 = com.google.android.gms.ads.d.g;
      String var2 = (String)this.d.get("adUnitID");
      String var1 = var2;
      if(var2 == null) {
         var1 = (String)this.d.get("publisherID");
      }

      AdView var5 = new AdView(this.a());
      var5.a(var1);
      var5.a(var3);
      var5.a(this.n);
      this.b = var5;
      com.google.android.gms.ads.c var4 = (new com.google.android.gms.ads.c()).a((com.google.android.gms.ads.a.g)(new com.google.a.a.e.a())).a((com.google.android.gms.ads.a.g)(new com.google.a.a.d.a())).a((com.google.android.gms.ads.a.g)(new com.google.a.a.c.a()));
      if(this.e != null) {
         Iterator var6 = (new HashSet(Arrays.asList(this.e.split(",")))).iterator();

         while(var6.hasNext()) {
            var4.a((String)var6.next());
         }
      }

      if(this.f != null) {
         var4.a(this.D());
      }

      var5.a(var4.a());
   }

   public final void t() {
      if(this.b != null) {
         ((AdView)this.b).a((com.google.android.gms.ads.a)null);
         ((AdView)this.b).a();
      }

      super.t();
   }
}
