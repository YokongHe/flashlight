package com.google.android.gms.maps;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.model.CameraPosition;

public final class GoogleMapOptions implements SafeParcelable {
   public static final com.google.android.gms.maps.a CREATOR = new com.google.android.gms.maps.a();
   private final int a;
   private Boolean b;
   private Boolean c;
   private int d = -1;
   private CameraPosition e;
   private Boolean f;
   private Boolean g;
   private Boolean h;
   private Boolean i;
   private Boolean j;
   private Boolean k;

   public GoogleMapOptions() {
      this.a = 1;
   }

   GoogleMapOptions(int var1, byte var2, byte var3, int var4, CameraPosition var5, byte var6, byte var7, byte var8, byte var9, byte var10, byte var11) {
      this.a = var1;
      this.b = com.google.android.gms.maps.a.a.a(var2);
      this.c = com.google.android.gms.maps.a.a.a(var3);
      this.d = var4;
      this.e = var5;
      this.f = com.google.android.gms.maps.a.a.a(var6);
      this.g = com.google.android.gms.maps.a.a.a(var7);
      this.h = com.google.android.gms.maps.a.a.a(var8);
      this.i = com.google.android.gms.maps.a.a.a(var9);
      this.j = com.google.android.gms.maps.a.a.a(var10);
      this.k = com.google.android.gms.maps.a.a.a(var11);
   }

   public static GoogleMapOptions a(Context var0, AttributeSet var1) {
      if(var1 == null) {
         return null;
      } else {
         TypedArray var2 = var0.getResources().obtainAttributes(var1, com.google.android.gms.e.b);
         GoogleMapOptions var3 = new GoogleMapOptions();
         if(var2.hasValue(0)) {
            var3.d = var2.getInt(0, -1);
         }

         if(var2.hasValue(13)) {
            var3.b = Boolean.valueOf(var2.getBoolean(13, false));
         }

         if(var2.hasValue(12)) {
            var3.c = Boolean.valueOf(var2.getBoolean(12, false));
         }

         if(var2.hasValue(6)) {
            var3.g = Boolean.valueOf(var2.getBoolean(6, true));
         }

         if(var2.hasValue(7)) {
            var3.k = Boolean.valueOf(var2.getBoolean(7, true));
         }

         if(var2.hasValue(8)) {
            var3.h = Boolean.valueOf(var2.getBoolean(8, true));
         }

         if(var2.hasValue(9)) {
            var3.j = Boolean.valueOf(var2.getBoolean(9, true));
         }

         if(var2.hasValue(11)) {
            var3.i = Boolean.valueOf(var2.getBoolean(11, true));
         }

         if(var2.hasValue(10)) {
            var3.f = Boolean.valueOf(var2.getBoolean(10, true));
         }

         var3.e = CameraPosition.a(var0, var1);
         var2.recycle();
         return var3;
      }
   }

   final int a() {
      return this.a;
   }

   final byte b() {
      return com.google.android.gms.maps.a.a.a(this.b);
   }

   final byte c() {
      return com.google.android.gms.maps.a.a.a(this.c);
   }

   final byte d() {
      return com.google.android.gms.maps.a.a.a(this.f);
   }

   public final int describeContents() {
      return 0;
   }

   final byte e() {
      return com.google.android.gms.maps.a.a.a(this.g);
   }

   final byte f() {
      return com.google.android.gms.maps.a.a.a(this.h);
   }

   final byte g() {
      return com.google.android.gms.maps.a.a.a(this.i);
   }

   final byte h() {
      return com.google.android.gms.maps.a.a.a(this.j);
   }

   final byte i() {
      return com.google.android.gms.maps.a.a.a(this.k);
   }

   public final int j() {
      return this.d;
   }

   public final CameraPosition k() {
      return this.e;
   }

   public final void writeToParcel(Parcel var1, int var2) {
      if(com.google.android.gms.maps.a.b.a()) {
         int var3 = com.google.android.gms.common.internal.safeparcel.c.a(var1);
         com.google.android.gms.common.internal.safeparcel.c.a(var1, 1, (int)this.a);
         com.google.android.gms.common.internal.safeparcel.c.a(var1, 2, (byte)com.google.android.gms.maps.a.a.a(this.b));
         com.google.android.gms.common.internal.safeparcel.c.a(var1, 3, (byte)com.google.android.gms.maps.a.a.a(this.c));
         com.google.android.gms.common.internal.safeparcel.c.a(var1, 4, (int)this.d);
         com.google.android.gms.common.internal.safeparcel.c.a(var1, 5, (Parcelable)this.e, var2, false);
         com.google.android.gms.common.internal.safeparcel.c.a(var1, 6, (byte)com.google.android.gms.maps.a.a.a(this.f));
         com.google.android.gms.common.internal.safeparcel.c.a(var1, 7, (byte)com.google.android.gms.maps.a.a.a(this.g));
         com.google.android.gms.common.internal.safeparcel.c.a(var1, 8, (byte)com.google.android.gms.maps.a.a.a(this.h));
         com.google.android.gms.common.internal.safeparcel.c.a(var1, 9, (byte)com.google.android.gms.maps.a.a.a(this.i));
         com.google.android.gms.common.internal.safeparcel.c.a(var1, 10, (byte)com.google.android.gms.maps.a.a.a(this.j));
         com.google.android.gms.common.internal.safeparcel.c.a(var1, 11, (byte)com.google.android.gms.maps.a.a.a(this.k));
         com.google.android.gms.common.internal.safeparcel.c.a(var1, var3);
      } else {
         com.google.android.gms.maps.a.a(this, var1, var2);
      }
   }
}
