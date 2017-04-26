package com.inneractive.api.ads.sdk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

abstract class IAbaseInterstitialAdActivity extends Activity {
   private View mCloseButton;
   protected RelativeLayout mLayout;

   private void createInterstitialCloseButton() {
      int var1 = an.b(this, 35);
      this.mCloseButton = new r(this, var1, true);
      LayoutParams var2 = new LayoutParams(var1, var1);
      var2.addRule(10);
      var2.addRule(11);
      var2.rightMargin = an.b(this, 10);
      var2.topMargin = an.b(this, 10);
      this.mLayout.addView(this.mCloseButton, var2);
   }

   protected void broadcastInterstitialAction(String var1) {
      Intent var2 = new Intent(var1);
      LocalBroadcastManager.getInstance(this).sendBroadcast(var2);
   }

   protected void concealInterstitialCloseBtn() {
      this.mCloseButton.setVisibility(4);
   }

   protected void displayInterstitialCloseBtn() {
      this.mCloseButton.setVisibility(0);
   }

   abstract View getAdView();

   public View getCloseButton() {
      return this.mCloseButton;
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.requestWindowFeature(1);
      this.getWindow().addFlags(1024);
      this.mLayout = new RelativeLayout(this);
      LayoutParams var2 = new LayoutParams(-1, -1);
      var2.addRule(13);
      this.mLayout.addView(this.getAdView(), var2);
      this.setContentView(this.mLayout);
      this.createInterstitialCloseButton();
      this.concealInterstitialCloseBtn();
   }

   protected void onDestroy() {
      this.mLayout.removeAllViews();
      super.onDestroy();
   }

   public void setCloseButton(View var1) {
      this.mCloseButton = var1;
   }
}
