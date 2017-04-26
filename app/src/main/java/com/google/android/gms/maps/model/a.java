package com.google.android.gms.maps.model;

import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public final class a {
   private LatLng a;
   private float b;
   private float c;
   private float d;

   public final CameraPosition a() {
      return new CameraPosition(this.a, this.b, this.c, this.d);
   }

   public final com.google.android.gms.maps.model.a a(float var1) {
      this.b = var1;
      return this;
   }

   public final com.google.android.gms.maps.model.a a(LatLng var1) {
      this.a = var1;
      return this;
   }

   public final com.google.android.gms.maps.model.a b(float var1) {
      this.c = var1;
      return this;
   }

   public final com.google.android.gms.maps.model.a c(float var1) {
      this.d = var1;
      return this;
   }
}
