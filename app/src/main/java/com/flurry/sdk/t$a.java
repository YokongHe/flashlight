package com.flurry.sdk;

import android.view.ViewGroup;
import com.flurry.android.FlurryAdSize;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;
import com.flurry.sdk.do;
import com.flurry.sdk.em;
import com.flurry.sdk.eo;
import com.flurry.sdk.ev;
import com.flurry.sdk.ff;
import com.flurry.sdk.t$b;
import java.util.List;

class t$a {
   // $FF: synthetic field
   final com.flurry.sdk.t a;
   private final String b;
   private t$b c;
   private List d;

   public t$a(com.flurry.sdk.t var1, String var2) {
      this.a = var1;
      this.b = var2;
      this.c = t$b.a;
      this.a();
   }

   // $FF: synthetic method
   static String a(t$a var0) {
      return var0.b;
   }

   // $FF: synthetic method
   static List a(t$a var0, List var1) {
      var0.d = var1;
      return var1;
   }

   // $FF: synthetic method
   static void a(t$a var0, t$b var1) {
      var0.a(var1);
   }

   // $FF: synthetic method
   static void a(t$a var0, List var1, int var2) {
      var0.a(var1, var2);
   }

   private void a(t$b param1) {
      // $FF: Couldn't be decompiled
   }

   private void a(List param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   private void b() {
      // $FF: Couldn't be decompiled
   }

   private void b(ViewGroup param1, FlurryAdSize param2, boolean param3, AdUnit param4) {
      // $FF: Couldn't be decompiled
   }

   // $FF: synthetic method
   static void b(t$a var0) {
      var0.b();
   }

   public void a() {
      synchronized(this){}

      try {
         em.a().a(this);
         this.a(t$b.a);
         this.d = null;
      } finally {
         ;
      }

   }

   public void a(final ViewGroup var1, final FlurryAdSize var2, final boolean var3, final AdUnit var4) {
      synchronized(this){}

      try {
         if(!t$b.a.equals(this.c)) {
            eo.a(3, com.flurry.sdk.t.d(), "requestAds: request pending");
         } else if(!ev.a().c()) {
            eo.a(5, com.flurry.sdk.t.d(), "There is no network connectivity (requestAds will fail)");
         } else if(com.flurry.sdk.t.a(this.a).j() == null) {
            eo.a(5, com.flurry.sdk.t.d(), "There is no API key (requestAds will fail)");
         } else {
            com.flurry.sdk.t.a(this.a).W().d();
            this.a(t$b.b);
            do.a().c(new ff() {
               public void a() {
                  t$a.this.b(var1, var2, var3, var4);
               }
            });
         }
      } finally {
         ;
      }

   }
}
