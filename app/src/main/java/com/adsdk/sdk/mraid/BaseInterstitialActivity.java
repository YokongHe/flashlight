package com.adsdk.sdk.mraid;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.adsdk.sdk.mraid.Dips;
import com.adsdk.sdk.mraid.Drawables;

abstract class BaseInterstitialActivity extends Activity {
   public static final String ACTION_INTERSTITIAL_CLICK = "com.mopub.action.interstitial.click";
   public static final String ACTION_INTERSTITIAL_DISMISS = "com.mopub.action.interstitial.dismiss";
   public static final String ACTION_INTERSTITIAL_FAIL = "com.mopub.action.interstitial.fail";
   public static final String ACTION_INTERSTITIAL_SHOW = "com.mopub.action.interstitial.show";
   private static final float CLOSE_BUTTON_PADDING = 8.0F;
   private static final float CLOSE_BUTTON_SIZE = 50.0F;
   public static final IntentFilter HTML_INTERSTITIAL_INTENT_FILTER = createHtmlInterstitialIntentFilter();
   private int mButtonPadding;
   private int mButtonSize;
   private ImageView mCloseButton;
   private RelativeLayout mLayout;

   private static IntentFilter createHtmlInterstitialIntentFilter() {
      IntentFilter var0 = new IntentFilter();
      var0.addAction("com.mopub.action.interstitial.fail");
      var0.addAction("com.mopub.action.interstitial.show");
      var0.addAction("com.mopub.action.interstitial.dismiss");
      var0.addAction("com.mopub.action.interstitial.click");
      return var0;
   }

   private void createInterstitialCloseButton() {
      this.mCloseButton = new ImageButton(this);
      StateListDrawable var1 = new StateListDrawable();
      BitmapDrawable var2 = Drawables.INTERSTITIAL_CLOSE_BUTTON_NORMAL.decodeImage(this);
      var1.addState(new int[]{-16842919}, var2);
      var2 = Drawables.INTERSTITIAL_CLOSE_BUTTON_PRESSED.decodeImage(this);
      var1.addState(new int[]{16842919}, var2);
      this.mCloseButton.setImageDrawable(var1);
      this.mCloseButton.setBackgroundDrawable((Drawable)null);
      this.mCloseButton.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            BaseInterstitialActivity.this.finish();
         }
      });
      LayoutParams var3 = new LayoutParams(this.mButtonSize, this.mButtonSize);
      var3.addRule(11);
      var3.setMargins(this.mButtonPadding, 0, this.mButtonPadding, 0);
      this.mLayout.addView(this.mCloseButton, var3);
   }

   protected void broadcastInterstitialAction(String var1) {
      Intent var2 = new Intent(var1);
      LocalBroadcastManager.getInstance(this).sendBroadcast(var2);
   }

   public abstract View getAdView();

   protected void hideInterstitialCloseButton() {
      this.mCloseButton.setVisibility(4);
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.requestWindowFeature(1);
      this.getWindow().addFlags(1024);
      this.mButtonSize = Dips.asIntPixels(50.0F, this);
      this.mButtonPadding = Dips.asIntPixels(8.0F, this);
      this.mLayout = new RelativeLayout(this);
      LayoutParams var2 = new LayoutParams(-1, -2);
      var2.addRule(13);
      this.mLayout.addView(this.getAdView(), var2);
      this.setContentView(this.mLayout);
      this.createInterstitialCloseButton();
   }

   protected void onDestroy() {
      this.mLayout.removeAllViews();
      super.onDestroy();
   }

   protected void showInterstitialCloseButton() {
      this.mCloseButton.setVisibility(0);
   }
}
