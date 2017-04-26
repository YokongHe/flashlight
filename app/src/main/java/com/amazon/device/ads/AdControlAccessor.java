package com.amazon.device.ads;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.amazon.device.ads.AdControlAccessor$Coordinates;
import com.amazon.device.ads.AdControlAccessor$SizeDimensions;
import com.amazon.device.ads.AdController;
import com.amazon.device.ads.AdController$AdPosition;
import com.amazon.device.ads.AdEvent;
import com.amazon.device.ads.AdState;
import com.amazon.device.ads.PreloadCallback;
import com.amazon.device.ads.RelativePosition;
import com.amazon.device.ads.SDKEventListener;
import com.amazon.device.ads.Size;

class AdControlAccessor {
   private final AdController adController;

   public AdControlAccessor(AdController var1) {
      this.adController = var1;
   }

   public void addJavascriptInterface(Object var1, boolean var2, String var3) {
      this.adController.addJavascriptInterface(var1, var2, var3);
   }

   public void addSDKEventListener(SDKEventListener var1) {
      this.adController.addSDKEventListener(var1);
   }

   public boolean closeAd() {
      return this.adController.closeAd();
   }

   public void enableCloseButton(boolean var1) {
      this.enableCloseButton(var1, (RelativePosition)null);
   }

   public void enableCloseButton(boolean var1, RelativePosition var2) {
      this.adController.enableNativeCloseButton(var1, var2);
   }

   public void fireAdEvent(AdEvent var1) {
      this.adController.fireAdEvent(var1);
   }

   public AdState getAdState() {
      return this.adController.getAdState();
   }

   public Context getContext() {
      return this.adController.getContext();
   }

   public AdControlAccessor$Coordinates getCurrentPosition() {
      AdController$AdPosition var1 = this.adController.getAdPosition();
      AdControlAccessor$Coordinates var2 = new AdControlAccessor$Coordinates(this);
      var2.width = var1.getSize().getWidth();
      var2.height = var1.getSize().getHeight();
      var2.x = var1.getX();
      var2.y = var1.getY();
      return var2;
   }

   public AdControlAccessor$SizeDimensions getMaxSize(boolean var1) {
      Size var2 = this.adController.getMaxExpandableSize(var1);
      AdControlAccessor$SizeDimensions var3 = new AdControlAccessor$SizeDimensions(this);
      var3.width = var2.getWidth();
      var3.height = var2.getHeight();
      return var3;
   }

   public int getOriginalOrientation() {
      return this.adController.getOriginalOrientation();
   }

   public int getViewHeight() {
      return this.adController.getViewHeight();
   }

   public ViewGroup getViewParentIfExpanded() {
      return this.adController.getViewParentIfExpanded();
   }

   public int getViewWidth() {
      return this.adController.getViewWidth();
   }

   public void injectJavascript(String var1) {
      this.adController.injectJavascript(var1, false);
   }

   public void injectJavascriptPreload(String var1) {
      this.adController.injectJavascript(var1, true);
   }

   public boolean isInterstitial() {
      return this.adController.isInterstitial();
   }

   public void loadHtml(String var1, String var2) {
      this.adController.loadHtml(var1, var2);
   }

   public void loadUrl(String var1) {
      this.adController.loadUrl(var1);
   }

   public void moveViewBackToParent(LayoutParams var1) {
      this.adController.moveViewBackToParent(var1);
   }

   public void moveViewToViewGroup(ViewGroup var1, LayoutParams var2, boolean var3) {
      this.adController.moveViewToViewGroup(var1, var2, var3);
   }

   public void overrideBackButton(boolean var1) {
      this.adController.overrideBackButton(var1);
   }

   public boolean popView() {
      return this.adController.popView();
   }

   public void preloadHtml(String var1, String var2, PreloadCallback var3) {
      this.adController.preloadHtml(var1, var2, var3);
   }

   public void preloadUrl(String var1, PreloadCallback var2) {
      this.adController.preloadUrl(var1, var2);
   }

   public void reload() {
      this.adController.reload();
   }

   public void removeCloseButton() {
      this.adController.removeNativeCloseButton();
   }

   public void setExpanded(boolean var1) {
      this.adController.setExpanded(var1);
   }

   public void setOriginalOrientation(Activity var1) {
      this.adController.setOriginalOrientation(var1);
   }

   public void showNativeCloseButtonImage(boolean var1) {
      this.adController.showNativeCloseButtonImage(var1);
   }

   public void stashView() {
      this.adController.stashView();
   }
}
