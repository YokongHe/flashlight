package com.ihandysoft.ad.a;

import com.millennialmedia.android.MMAd;
import com.millennialmedia.android.MMAdView;
import com.millennialmedia.android.MMException;
import com.millennialmedia.android.MMRequest;
import com.millennialmedia.android.MMSDK;
import com.millennialmedia.android.RequestListener;
import java.util.Map;

public class j extends com.ihandysoft.ad.a.a implements RequestListener {
   private static boolean n = true;
   // $FF: synthetic field
   private static int[] o;

   // $FF: synthetic method
   private static int[] E() {
      int[] var0 = o;
      if(var0 != null) {
         return var0;
      } else {
         var0 = new int[com.ihandysoft.ad.a.values().length];

         try {
            var0[com.ihandysoft.ad.a.c.ordinal()] = 3;
         } catch (NoSuchFieldError var4) {
            ;
         }

         try {
            var0[com.ihandysoft.ad.a.b.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            var0[com.ihandysoft.ad.a.a.ordinal()] = 1;
         } catch (NoSuchFieldError var2) {
            ;
         }

         o = var0;
         return var0;
      }
   }

   public void MMAdOverlayClosed(MMAd var1) {
      this.x();
   }

   public void MMAdOverlayLaunched(MMAd var1) {
      this.w();
   }

   public void MMAdRequestIsCaching(MMAd var1) {
   }

   public final boolean a(Map var1) {
      return super.a(var1)?this.d.get("placementID").equals(var1.get("placementID")):false;
   }

   public void onSingleTap(MMAd var1) {
      this.v();
   }

   public final void p() {
      if(n) {
         n = false;
         MMSDK.initialize(this.a());
      }

      MMAdView var1 = new MMAdView(this.a());
      this.b = var1;
      var1.setListener(this);
      switch(E()[this.c.ordinal()]) {
      case 1:
         var1.setWidth(320);
         var1.setHeight(50);
         break;
      case 2:
         var1.setWidth(480);
         var1.setHeight(60);
         break;
      case 3:
         var1.setWidth(728);
         var1.setHeight(90);
      }

      var1.setApid((String)this.d.get("placementID"));
      MMRequest var2 = new MMRequest();
      if(this.e != null) {
         var2.setKeywords(this.e);
      }

      if(this.f != null) {
         MMRequest.setUserLocation(this.f);
      }

      var1.setMMRequest(var2);
      var1.getAd();
   }

   public void requestCompleted(MMAd var1) {
      this.u();
   }

   public void requestFailed(MMAd var1, MMException var2) {
      this.a(var2);
   }

   public final void t() {
      if(this.b != null) {
         ((MMAd)this.b).setListener((RequestListener)null);
      }

      super.t();
   }
}
