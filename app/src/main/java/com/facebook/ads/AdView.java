package com.facebook.ads;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.facebook.ads.Ad;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSize;
import com.facebook.ads.ImpressionListener;

public class AdView extends RelativeLayout implements Ad {
   private static final String TAG = AdView.class.getSimpleName();
   private com.facebook.ads.a.d adContentView;

   public AdView(Context var1, String var2, AdSize var3) {
      super(var1);
      if(var3 != null && var3 != AdSize.INTERSTITIAL) {
         switch(null.a[var3.ordinal()]) {
         case 1:
            this.adContentView = new com.facebook.ads.a.i(this, var2, var3);
            break;
         default:
            this.adContentView = new com.facebook.ads.a.q(this, var2, var3);
         }

         this.addView((View)this.adContentView);
      } else {
         throw new IllegalArgumentException("adSize");
      }
   }

   public void destroy() {
      if(this.adContentView != null) {
         this.removeView((View)this.adContentView);
         this.adContentView.c();
         this.adContentView = null;
      }

   }

   public void disableAutoRefresh() {
      this.adContentView.a();
   }

   public void loadAd() {
      this.adContentView.b();
   }

   public void setAdListener(AdListener var1) {
      this.adContentView.setAdListener(var1);
   }

   public void setImpressionListener(ImpressionListener var1) {
      this.adContentView.setImpressionListener(var1);
   }
}
