package com.mopub.mobileads;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.mopub.common.AdReport;
import com.mopub.common.CloseableLayout;
import com.mopub.common.CloseableLayout$OnCloseListener;

abstract class BaseInterstitialActivity extends Activity {
   protected AdReport mAdReport;
   private Long mBroadcastIdentifier;
   private CloseableLayout mCloseableLayout;

   protected static AdReport getAdReportFromIntent(Intent var0) {
      try {
         AdReport var2 = (AdReport)var0.getSerializableExtra("mopub-intent-ad-report");
         return var2;
      } catch (ClassCastException var1) {
         return null;
      }
   }

   protected static Long getBroadcastIdentifierFromIntent(Intent var0) {
      return var0.hasExtra("broadcastIdentifier")?Long.valueOf(var0.getLongExtra("broadcastIdentifier", -1L)):null;
   }

   public abstract View getAdView();

   Long getBroadcastIdentifier() {
      return this.mBroadcastIdentifier;
   }

   protected void hideInterstitialCloseButton() {
      this.mCloseableLayout.setCloseVisible(false);
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      Intent var2 = this.getIntent();
      this.mBroadcastIdentifier = getBroadcastIdentifierFromIntent(var2);
      this.mAdReport = getAdReportFromIntent(var2);
      this.requestWindowFeature(1);
      this.getWindow().addFlags(1024);
      View var3 = this.getAdView();
      this.mCloseableLayout = new CloseableLayout(this);
      this.mCloseableLayout.setOnCloseListener(new CloseableLayout$OnCloseListener() {
         public void onClose() {
            BaseInterstitialActivity.this.finish();
         }
      });
      this.mCloseableLayout.addView(var3, new LayoutParams(-1, -1));
      this.setContentView(this.mCloseableLayout);
   }

   protected void onDestroy() {
      this.mCloseableLayout.removeAllViews();
      super.onDestroy();
   }

   protected void showInterstitialCloseButton() {
      this.mCloseableLayout.setCloseVisible(true);
   }
}
