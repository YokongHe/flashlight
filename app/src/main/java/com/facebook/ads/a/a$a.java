package com.facebook.ads.a;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

class a$a implements SensorEventListener {
   private a$a() {
   }

   // $FF: synthetic method
   a$a(Object var1) {
      this();
   }

   public void onAccuracyChanged(Sensor var1, int var2) {
   }

   public void onSensorChanged(SensorEvent var1) {
      if(var1.sensor == com.facebook.ads.a.a.b()) {
         com.facebook.ads.a.a.a(var1.values);
      } else if(var1.sensor == com.facebook.ads.a.a.c()) {
         com.facebook.ads.a.a.b(var1.values);
      }

      com.facebook.ads.a.a.a(this);
   }
}
