package com.flurry.sdk;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Looper;
import android.text.TextUtils;
import com.flurry.sdk.do;
import com.flurry.sdk.dp;
import com.flurry.sdk.dq;
import com.flurry.sdk.dq$a;
import com.flurry.sdk.dz$a;
import com.flurry.sdk.eo;
import com.flurry.sdk.fa;
import com.flurry.sdk.fb;
import com.flurry.sdk.fb$a;

public class dz implements dq$a, fb$a {
   private static final String c = dz.class.getSimpleName();
   private static dz q;
   boolean a = false;
   boolean b;
   private final int d = 3;
   private final long e = 10000L;
   private final long f = 90000L;
   private final long g = 0L;
   private long h = 0L;
   private LocationManager i;
   private Criteria j;
   private Location k;
   private dz$a l = new dz$a(this);
   private String m;
   private int n = 0;
   private int o = 0;
   private volatile Location p;

   private dz() {
      dq var1 = dp.a();
      this.j = (Criteria)var1.a("LocationCriteria");
      var1.a((String)"LocationCriteria", (dq$a)this);
      eo.a(4, c, "initSettings, LocationCriteria = " + this.j);
      this.b = ((Boolean)var1.a("ReportLocation")).booleanValue();
      var1.a((String)"ReportLocation", (dq$a)this);
      eo.a(4, c, "initSettings, ReportLocation = " + this.b);
   }

   // $FF: synthetic method
   static int a(dz var0) {
      int var1 = var0.o + 1;
      var0.o = var1;
      return var1;
   }

   // $FF: synthetic method
   static Location a(dz var0, Location var1) {
      var0.k = var1;
      return var1;
   }

   public static dz a() {
      synchronized(dz.class){}

      dz var0;
      try {
         if(q == null) {
            q = new dz();
         }

         var0 = q;
      } finally {
         ;
      }

      return var0;
   }

   private void a(String var1) {
      if(!TextUtils.isEmpty(var1)) {
         this.i.requestLocationUpdates(var1, 10000L, 0.0F, this.l, Looper.getMainLooper());
      }

   }

   private Location b(String var1) {
      Location var2 = null;
      if(!TextUtils.isEmpty(var1)) {
         var2 = this.i.getLastKnownLocation(var1);
      }

      return var2;
   }

   // $FF: synthetic method
   static void b(dz var0) {
      var0.i();
   }

   // $FF: synthetic method
   static String h() {
      return c;
   }

   private void i() {
      this.i.removeUpdates(this.l);
      this.a = false;
      this.o = 0;
      this.h = 0L;
      this.m();
      eo.a(4, c, "LocationProvider stopped");
   }

   private void j() {
      if(this.b && this.p == null) {
         Context var1 = do.a().b();
         if(var1.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0 || var1.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0) {
            this.i();
            String var2 = this.k();
            this.a(var2);
            this.k = this.b(var2);
            this.h = System.currentTimeMillis() + 90000L;
            this.l();
            this.a = true;
            eo.a(4, c, "LocationProvider started");
            return;
         }
      }

   }

   private String k() {
      Criteria var2 = this.j;
      Criteria var1 = var2;
      if(var2 == null) {
         var1 = new Criteria();
      }

      String var3;
      if(TextUtils.isEmpty(this.m)) {
         var3 = this.i.getBestProvider(var1, true);
      } else {
         var3 = this.m;
      }

      eo.a(4, c, "provider = " + var3);
      return var3;
   }

   private void l() {
      eo.a(4, c, "Register location timer");
      fa.a().a(this);
   }

   private void m() {
      eo.a(4, c, "Unregister location timer");
      fa.a().b(this);
   }

   public void a(float var1, float var2) {
      this.p = new Location("Explicit");
      this.p.setLatitude((double)var1);
      this.p.setLongitude((double)var2);
   }

   public void a(fb var1) {
      if(this.h > 0L && this.h < System.currentTimeMillis()) {
         eo.a(4, c, "No location received in 90 seconds , stopping LocationManager");
         this.i();
      }

   }

   public void a(String var1, Object var2) {
      if(var1.equals("LocationCriteria")) {
         this.j = (Criteria)var2;
         eo.a(4, c, "onSettingUpdate, LocationCriteria = " + this.j);
         if(this.a) {
            this.j();
         }
      } else {
         if(!var1.equals("ReportLocation")) {
            eo.a(6, c, "LocationProvider internal error! Had to be LocationCriteria or ReportLocation key.");
            return;
         }

         this.b = ((Boolean)var2).booleanValue();
         eo.a(4, c, "onSettingUpdate, ReportLocation = " + this.b);
         if(!this.b) {
            this.i();
            return;
         }

         if(!this.a && this.n > 0) {
            this.j();
            return;
         }
      }

   }

   public void b() {
      // $FF: Couldn't be decompiled
   }

   public void c() {
      synchronized(this){}

      try {
         eo.a(4, c, "Location provider subscribed");
         ++this.n;
         if(!this.a && this.o < 3) {
            this.j();
         }
      } finally {
         ;
      }

   }

   public void d() {
      synchronized(this){}

      try {
         eo.a(4, c, "Location provider unsubscribed");
         if(this.n <= 0) {
            eo.a(6, c, "Error! Unsubscribed too many times!");
         } else {
            --this.n;
            if(this.n == 0) {
               this.i();
            }
         }
      } finally {
         ;
      }

   }

   public void e() {
      this.p = null;
   }

   public Location f() {
      Location var1 = null;
      if(this.p != null) {
         return this.p;
      } else {
         if(this.b) {
            var1 = this.b(this.k());
            if(var1 != null) {
               this.k = var1;
            }

            var1 = this.k;
         }

         eo.a(4, c, "getLocation() = " + var1);
         return var1;
      }
   }

   public void g() {
      this.n = 0;
      this.i();
   }
}
