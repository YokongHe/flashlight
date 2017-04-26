package com.ihs.app.framework.a2;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.ihs.app.framework.HSApplication;

public final class b {
   private long a;
   private long b;
   private long c;
   private float d;
   private int e;
   private Activity f;
   private int g;
   private AlarmManager h;
   private PendingIntent i;
   private com.ihs.app.framework.a2.c j;
   private com.ihs.app.framework.a2.a k;
   private boolean l;
   private boolean m;
   private Boolean n;
   private Object o;

   private b() {
      this.l = true;
      this.m = false;
      this.n = Boolean.valueOf(true);
      this.o = null;
      this.k = new com.ihs.app.framework.a2.a(HSApplication.a());
      this.i = PendingIntent.getBroadcast(HSApplication.a(), 0, new Intent("hs.app.session.PENDING_SESSION_START"), 0);
      this.h = (AlarmManager)HSApplication.a().getSystemService(Context.ALARM_SERVICE);
      this.j = new com.ihs.app.framework.a2.c(this, (byte)0);
   }

   // $FF: synthetic method
   b(byte var1) {
      this();
   }

   public static com.ihs.app.framework.a2.b a() {
      return com.ihs.app.framework.a2.d.a();
   }

   // $FF: synthetic method
   static void a(com.ihs.app.framework.a2.b var0) {
      var0.i();
   }

   private void i() {
      if(this.m) {
         long var2 = System.currentTimeMillis();
         float var1 = (float)((var2 - this.c) / 1000L);
         com.ihs.a.e.j.a(HSApplication.a()).b("hs.app.session.total_usage_seconds", this.d + var1);
         com.ihs.a.e.j.a(HSApplication.a()).b("hs.app.session.last_session_end_time", var2);
         (new StringBuilder("totalUsageMillis: ")).append(this.d).append(", sessionDuration:").append(var1).toString();
         com.ihs.app.a.b.b();
         Boolean var4 = this.n;
         synchronized(var4) {
            if(this.n.booleanValue()) {
               com.ihs.a.d.a.a("hs.app.session.SESSION_END");
            }

            this.o = null;
         }

         HSApplication.a().unregisterReceiver(this.j);
         this.l = false;
         this.m = false;
      }
   }

   public final void a(Activity param1) {
      // $FF: Couldn't be decompiled
   }

   public final void a(boolean param1) {
      // $FF: Couldn't be decompiled
   }

   public final void b() {
      synchronized(this){}
   }

   public final void c() {
      synchronized(this){}
   }

   public final Activity d() {
      return this.f;
   }

   public final boolean e() {
      return this.l;
   }

   public final long f() {
      return this.a;
   }

   public final float g() {
      return this.d;
   }

   public final int h() {
      return this.e;
   }
}
