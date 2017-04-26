package com.nexage.android.c;

import com.nexage.android.NexageAdView;
import java.util.ArrayList;
import java.util.UUID;
import org.json.JSONObject;

public final class e {
   public final String a;
   String b;
   int c;
   long d;
   int e;
   final int f;
   int g;
   String h;
   String i;
   String j;
   String k;
   final ArrayList l = new ArrayList();
   com.nexage.android.c.a m;
   com.nexage.android.c.b n;
   public boolean o;
   boolean p;
   public boolean q;
   NexageAdView r = null;

   e(String var1) {
      this.a = var1;
      this.b = null;
      this.c = -1;
      this.d = com.nexage.android.c.f.b();
      this.f = 0;
      this.e = -1;
      this.k = UUID.randomUUID().toString().replace("-", "");
   }

   final JSONObject a() {
      // $FF: Couldn't be decompiled
   }

   public final void a(NexageAdView var1) {
      this.r = var1;
   }

   public final void a(com.nexage.android.g.a var1) {
      synchronized(this){}

      try {
         com.nexage.android.a.p.c("AdService2", "addAdNetRequest: " + var1.d.b);
         if(this.c <= 0 && var1.a == 1) {
            this.c = 1;
         }

         this.l.add(new com.nexage.android.c.c(var1));
      } finally {
         ;
      }

   }

   public final void a(String var1) {
      this.k = var1;
   }

   public final void a(String var1, String var2) {
      this.h = var1;
      this.i = var2;
   }

   public final void b() {
      this.p = true;
      this.r = null;
   }

   public final long c() {
      return this.d;
   }

   public final String d() {
      return this.k;
   }
}
