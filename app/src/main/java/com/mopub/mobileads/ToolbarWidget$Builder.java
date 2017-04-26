package com.mopub.mobileads;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View.OnTouchListener;
import com.mopub.mobileads.ToolbarWidget;

class ToolbarWidget$Builder {
   private final Context context;
   private String defaultText;
   private Drawable drawable;
   private int drawableAlign;
   private boolean hasDrawable;
   private boolean hasText;
   private OnTouchListener onTouchListener;
   private int textAlign;
   private int visibility;
   private float weight;
   private int widgetGravity;

   ToolbarWidget$Builder(Context var1) {
      this.context = var1;
      this.weight = 1.0F;
      this.widgetGravity = 17;
      this.visibility = 0;
      this.textAlign = 9;
      this.drawableAlign = 11;
   }

   // $FF: synthetic method
   static Context access$0(ToolbarWidget$Builder var0) {
      return var0.context;
   }

   // $FF: synthetic method
   static float access$1(ToolbarWidget$Builder var0) {
      return var0.weight;
   }

   // $FF: synthetic method
   static OnTouchListener access$10(ToolbarWidget$Builder var0) {
      return var0.onTouchListener;
   }

   // $FF: synthetic method
   static int access$2(ToolbarWidget$Builder var0) {
      return var0.widgetGravity;
   }

   // $FF: synthetic method
   static int access$3(ToolbarWidget$Builder var0) {
      return var0.visibility;
   }

   // $FF: synthetic method
   static boolean access$4(ToolbarWidget$Builder var0) {
      return var0.hasDrawable;
   }

   // $FF: synthetic method
   static Drawable access$5(ToolbarWidget$Builder var0) {
      return var0.drawable;
   }

   // $FF: synthetic method
   static int access$6(ToolbarWidget$Builder var0) {
      return var0.drawableAlign;
   }

   // $FF: synthetic method
   static boolean access$7(ToolbarWidget$Builder var0) {
      return var0.hasText;
   }

   // $FF: synthetic method
   static String access$8(ToolbarWidget$Builder var0) {
      return var0.defaultText;
   }

   // $FF: synthetic method
   static int access$9(ToolbarWidget$Builder var0) {
      return var0.textAlign;
   }

   ToolbarWidget build() {
      return new ToolbarWidget(this, (ToolbarWidget)null);
   }

   ToolbarWidget$Builder defaultText(String var1) {
      this.hasText = true;
      this.defaultText = var1;
      return this;
   }

   ToolbarWidget$Builder drawable(Drawable var1) {
      this.hasDrawable = true;
      this.drawable = var1;
      return this;
   }

   ToolbarWidget$Builder drawableAlign(int var1) {
      this.drawableAlign = var1;
      return this;
   }

   ToolbarWidget$Builder hasDrawable() {
      this.hasDrawable = true;
      return this;
   }

   ToolbarWidget$Builder hasText() {
      this.hasText = true;
      return this;
   }

   ToolbarWidget$Builder onTouchListener(OnTouchListener var1) {
      this.onTouchListener = var1;
      return this;
   }

   ToolbarWidget$Builder textAlign(int var1) {
      this.textAlign = var1;
      return this;
   }

   ToolbarWidget$Builder visibility(int var1) {
      this.visibility = var1;
      return this;
   }

   ToolbarWidget$Builder weight(float var1) {
      this.weight = var1;
      return this;
   }

   ToolbarWidget$Builder widgetGravity(int var1) {
      this.widgetGravity = var1;
      return this;
   }
}
