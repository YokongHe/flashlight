package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;

public final class aY implements Runnable {
   protected final com.google.android.gms.internal.bL a;
   protected boolean b;
   protected boolean c;
   private final Handler d;
   private final long e;
   private long f;
   private com.google.android.gms.internal.bP g;
   private final int h;
   private final int i;

   public aY(com.google.android.gms.internal.bP var1, com.google.android.gms.internal.bL var2, int var3, int var4) {
      this(var1, var2, var3, var4, 200L, 50L);
   }

   private aY(com.google.android.gms.internal.bP var1, com.google.android.gms.internal.bL var2, int var3, int var4, long var5, long var7) {
      this.e = 200L;
      this.f = 50L;
      this.d = new Handler(Looper.getMainLooper());
      this.a = var2;
      this.g = var1;
      this.b = false;
      this.c = false;
      this.h = var4;
      this.i = var3;
   }

   // $FF: synthetic method
   static int a(com.google.android.gms.internal.aY var0) {
      return var0.i;
   }

   // $FF: synthetic method
   static int b(com.google.android.gms.internal.aY var0) {
      return var0.h;
   }

   // $FF: synthetic method
   static long c(com.google.android.gms.internal.aY var0) {
      long var1 = var0.f - 1L;
      var0.f = var1;
      return var1;
   }

   // $FF: synthetic method
   static long d(com.google.android.gms.internal.aY var0) {
      return var0.f;
   }

   // $FF: synthetic method
   static com.google.android.gms.internal.bP e(com.google.android.gms.internal.aY var0) {
      return var0.g;
   }

   // $FF: synthetic method
   static long f(com.google.android.gms.internal.aY var0) {
      return var0.e;
   }

   // $FF: synthetic method
   static Handler g(com.google.android.gms.internal.aY var0) {
      return var0.d;
   }

   public final void a() {
      this.d.postDelayed(this, this.e);
   }

   public final void a(com.google.android.gms.internal.cz var1) {
      com.google.android.gms.internal.bT var2 = new com.google.android.gms.internal.bT(this, this.a, var1.q);
      this.a.setWebViewClient(var2);
      com.google.android.gms.internal.bL var3 = this.a;
      String var4;
      if(TextUtils.isEmpty(var1.b)) {
         var4 = null;
      } else {
         var4 = com.google.android.gms.internal.bD.a(var1.b);
      }

      var3.loadDataWithBaseURL(var4, var1.c, "text/html", "UTF-8", (String)null);
   }

   public final void b() {
      synchronized(this){}

      try {
         this.b = true;
      } finally {
         ;
      }

   }

   public final boolean c() {
      synchronized(this){}

      boolean var1;
      try {
         var1 = this.b;
      } finally {
         ;
      }

      return var1;
   }

   public final boolean d() {
      return this.c;
   }

   public final void run() {
      if(this.a != null && !this.c()) {
         (new com.google.android.gms.internal.aZ(this, this.a)).execute(new Void[0]);
      } else {
         this.g.a(this.a);
      }
   }
}
