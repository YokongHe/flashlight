package com.tapjoy.mraid.controller;

import android.content.Context;
import com.tapjoy.TapjoyLog;
import com.tapjoy.mraid.controller.Abstract;
import com.tapjoy.mraid.listener.Accel;
import com.tapjoy.mraid.view.MraidView;

public class MraidSensor extends Abstract {
   final int c = 1000;
   private Accel d;
   private float e = 0.0F;
   private float f = 0.0F;
   private float g = 0.0F;

   public MraidSensor(MraidView var1, Context var2) {
      super(var1, var2);
      this.d = new Accel(var2, this);
   }

   public float getHeading() {
      TapjoyLog.d("MRAID Sensor", "getHeading: " + this.d.getHeading());
      return this.d.getHeading();
   }

   public String getTilt() {
      String var1 = "{ x : \"" + this.e + "\", y : \"" + this.f + "\", z : \"" + this.g + "\"}";
      TapjoyLog.d("MRAID Sensor", "getTilt: " + var1);
      return var1;
   }

   public void onHeadingChange(float var1) {
      String var2 = "window.mraidview.fireChangeEvent({ heading: " + (int)((double)var1 * 57.29577951308232D) + "});";
      TapjoyLog.d("MRAID Sensor", var2);
      this.a.injectMraidJavaScript(var2);
   }

   public void onShake() {
      this.a.injectMraidJavaScript("mraid.gotShake()");
   }

   public void onTilt(float var1, float var2, float var3) {
      this.e = var1;
      this.f = var2;
      this.g = var3;
      String var4 = "window.mraidview.fireChangeEvent({ tilt: " + this.getTilt() + "})";
      TapjoyLog.d("MRAID Sensor", var4);
      this.a.injectMraidJavaScript(var4);
   }

   public void startHeadingListener() {
      this.d.startTrackingHeading();
   }

   public void startShakeListener() {
      this.d.startTrackingShake();
   }

   public void startTiltListener() {
      this.d.startTrackingTilt();
   }

   public void stopAllListeners() {
      this.d.stopAllListeners();
   }

   public void stopHeadingListener() {
      this.d.stopTrackingHeading();
   }

   public void stopShakeListener() {
      this.d.stopTrackingShake();
   }

   public void stopTiltListener() {
      this.d.stopTrackingTilt();
   }
}
