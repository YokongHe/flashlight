package com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public final class StreetViewPanoramaOptions implements SafeParcelable {
   public static final com.google.android.gms.maps.c CREATOR = new com.google.android.gms.maps.c();
   private final int a;
   private StreetViewPanoramaCamera b;
   private String c;
   private LatLng d;
   private Integer e;
   private Boolean f = Boolean.valueOf(true);
   private Boolean g = Boolean.valueOf(true);
   private Boolean h = Boolean.valueOf(true);
   private Boolean i = Boolean.valueOf(true);
   private Boolean j;

   public StreetViewPanoramaOptions() {
      this.a = 1;
   }

   StreetViewPanoramaOptions(int var1, StreetViewPanoramaCamera var2, String var3, LatLng var4, Integer var5, byte var6, byte var7, byte var8, byte var9, byte var10) {
      this.a = var1;
      this.b = var2;
      this.d = var4;
      this.e = var5;
      this.c = var3;
      this.f = com.google.android.gms.maps.a.a.a(var6);
      this.g = com.google.android.gms.maps.a.a.a(var7);
      this.h = com.google.android.gms.maps.a.a.a(var8);
      this.i = com.google.android.gms.maps.a.a.a(var9);
      this.j = com.google.android.gms.maps.a.a.a(var10);
   }

   final int a() {
      return this.a;
   }

   final byte b() {
      return com.google.android.gms.maps.a.a.a(this.f);
   }

   final byte c() {
      return com.google.android.gms.maps.a.a.a(this.g);
   }

   final byte d() {
      return com.google.android.gms.maps.a.a.a(this.h);
   }

   public final int describeContents() {
      return 0;
   }

   final byte e() {
      return com.google.android.gms.maps.a.a.a(this.i);
   }

   final byte f() {
      return com.google.android.gms.maps.a.a.a(this.j);
   }

   public final StreetViewPanoramaCamera g() {
      return this.b;
   }

   public final LatLng h() {
      return this.d;
   }

   public final Integer i() {
      return this.e;
   }

   public final String j() {
      return this.c;
   }

   public final void writeToParcel(Parcel var1, int var2) {
      com.google.android.gms.maps.c.a(this, var1, var2);
   }
}
