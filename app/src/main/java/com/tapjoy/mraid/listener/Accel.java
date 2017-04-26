package com.tapjoy.mraid.listener;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tapjoy.mraid.controller.MraidSensor;
import java.util.List;

public class Accel implements SensorEventListener {
   MraidSensor a;
   int b = 0;
   int c = 0;
   int d = 0;
   private SensorManager e;
   private int f = 3;
   private long g;
   private int h;
   private long i;
   private long j;
   private float[] k;
   private float[] l = new float[]{0.0F, 0.0F, 0.0F};
   private boolean m;
   private boolean n;
   private float[] o = new float[]{0.0F, 0.0F, 0.0F};
   private float[] p = new float[]{-1.0F, -1.0F, -1.0F};

   public Accel(Context var1, MraidSensor var2) {
      this.a = var2;
      this.e = (SensorManager)var1.getSystemService("sensor");
   }

   private void a() {
      List var1 = this.e.getSensorList(1);
      if(var1.size() > 0) {
         this.e.registerListener(this, (Sensor)var1.get(0), this.f);
      }

   }

   public float getHeading() {
      return this.p[0];
   }

   public void onAccuracyChanged(Sensor var1, int var2) {
   }

   public void onSensorChanged(SensorEvent var1) {
      switch(var1.sensor.getType()) {
      case 1:
         this.o = this.l;
         this.l = (float[])var1.values.clone();
         this.n = true;
         break;
      case 2:
         this.k = (float[])var1.values.clone();
         this.m = true;
      }

      if(this.k != null && this.l != null && this.n && this.m) {
         this.n = false;
         this.m = false;
         float[] var7 = new float[9];
         SensorManager.getRotationMatrix(var7, new float[9], this.l, this.k);
         this.p = new float[3];
         SensorManager.getOrientation(var7, this.p);
         this.a.onHeadingChange(this.p[0]);
      }

      if(var1.sensor.getType() == 1) {
         long var3 = System.currentTimeMillis();
         if(var3 - this.g > 500L) {
            this.h = 0;
         }

         if(var3 - this.i > 100L) {
            long var5 = this.i;
            if(Math.abs(this.l[0] + this.l[1] + this.l[2] - this.o[0] - this.o[1] - this.o[2]) / (float)(var3 - var5) * 10000.0F > 1000.0F) {
               int var2 = this.h + 1;
               this.h = var2;
               if(var2 >= 2 && var3 - this.j > 2000L) {
                  this.j = var3;
                  this.h = 0;
                  this.a.onShake();
               }

               this.g = var3;
            }

            this.i = var3;
            this.a.onTilt(this.l[0], this.l[1], this.l[2]);
         }
      }

   }

   public void setSensorDelay(int var1) {
      this.f = var1;
      if(this.b > 0 || this.c > 0) {
         this.stop();
         this.a();
      }

   }

   public void startTrackingHeading() {
      if(this.d == 0) {
         List var1 = this.e.getSensorList(2);
         if(var1.size() > 0) {
            this.e.registerListener(this, (Sensor)var1.get(0), this.f);
            this.a();
         }
      }

      ++this.d;
   }

   public void startTrackingShake() {
      if(this.c == 0) {
         this.setSensorDelay(1);
         this.a();
      }

      ++this.c;
   }

   public void startTrackingTilt() {
      if(this.b == 0) {
         this.a();
      }

      ++this.b;
   }

   public void stop() {
      if(this.d == 0 && this.c == 0 && this.b == 0) {
         this.e.unregisterListener(this);
      }

   }

   public void stopAllListeners() {
      this.b = 0;
      this.c = 0;
      this.d = 0;

      try {
         this.stop();
      } catch (Exception var2) {
         ;
      }
   }

   public void stopTrackingHeading() {
      if(this.d > 0) {
         int var1 = this.d - 1;
         this.d = var1;
         if(var1 == 0) {
            this.stop();
         }
      }

   }

   public void stopTrackingShake() {
      if(this.c > 0) {
         int var1 = this.c - 1;
         this.c = var1;
         if(var1 == 0) {
            this.setSensorDelay(3);
            this.stop();
         }
      }

   }

   public void stopTrackingTilt() {
      if(this.b > 0) {
         int var1 = this.b - 1;
         this.b = var1;
         if(var1 == 0) {
            this.stop();
         }
      }

   }
}
