package com.flurry.sdk;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.flurry.android.FlurryAdSize;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;
import com.flurry.sdk.du$a;
import com.flurry.sdk.eo;
import com.flurry.sdk.ff;
import com.flurry.sdk.u$a;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class u {
   private static final String a = com.flurry.sdk.u.class.getSimpleName();
   private final FlurryAdModule b;
   private com.flurry.sdk.an c;
   private final com.flurry.sdk.m d;
   private final Map e;

   public u(FlurryAdModule var1) {
      this.b = var1;
      this.d = new com.flurry.sdk.m();
      this.c = new com.flurry.sdk.an();
      this.e = new HashMap();
   }

   // $FF: synthetic method
   static FlurryAdModule a(com.flurry.sdk.u var0) {
      return var0.b;
   }

   private void a(List var1) {
      if(var1 != null && !var1.isEmpty()) {
         this.c.a(var1);
      }
   }

   // $FF: synthetic method
   static com.flurry.sdk.an b(com.flurry.sdk.u var0) {
      return var0.c;
   }

   // $FF: synthetic method
   static com.flurry.sdk.m c(com.flurry.sdk.u var0) {
      return var0.d;
   }

   // $FF: synthetic method
   static String d() {
      return a;
   }

   private u$a g(String param1) {
      // $FF: Couldn't be decompiled
   }

   public com.flurry.sdk.l a(FlurryAdModule var1, Context var2, ViewGroup var3, String var4) {
      return this.d.a(var1, var2, var3, var4);
   }

   public List a(String var1, int var2, int var3) {
      if(TextUtils.isEmpty(var1)) {
         return Collections.emptyList();
      } else {
         List var4 = this.c.a(var1, var2, var3);
         this.c.a(var1, var4);
         return var4;
      }
   }

   public void a() {
      // $FF: Couldn't be decompiled
   }

   public void a(final Activity var1, du$a var2) {
      Iterator var3;
      if(du$a.c.equals(var2)) {
         var3 = this.d.a((Context)var1).iterator();

         while(var3.hasNext()) {
            ((com.flurry.sdk.l)var3.next()).c();
         }
      } else if(du$a.d.equals(var2)) {
         var3 = this.d.a((Context)var1).iterator();

         while(var3.hasNext()) {
            ((com.flurry.sdk.l)var3.next()).b();
         }
      } else if(du$a.b.equals(var2)) {
         this.b.a(new ff() {
            public void a() {
               u.this.a((Context)var1);
            }
         });
      }

   }

   public void a(Context var1, String var2) {
      eo.a(3, a, "removeAd: context = " + var1 + ", adSpaceName = " + var2);
      this.g(var2).c();
   }

   public void a(Context var1, String var2, ViewGroup var3, FlurryAdSize var4, boolean var5) {
      eo.a(3, a, "fetchAd: context = " + var1 + ", adSpaceName = " + var2 + ", viewGroup = " + var3 + ", size = " + var4 + ", autoDisplay = " + var5);
      this.g(var2).a(var1, var3, var4, var5);
   }

   void a(String var1, int var2) {
      if(!TextUtils.isEmpty(var1)) {
         this.c.a(var1, var2);
      }
   }

   public void a(String var1, AdUnit var2) {
      if(!TextUtils.isEmpty(var1) && var2 != null) {
         this.c.a(var1, var2);
      }
   }

   void a(String var1, String var2) {
      if(!TextUtils.isEmpty(var1)) {
         this.c.a(var1, var2);
      }
   }

   public void a(String var1, List var2) {
      if(var2 != null) {
         eo.a(3, a, "Handling ad response");
         if(TextUtils.isEmpty(var1)) {
            this.a(var2);
            this.f(var1);
            eo.a(3, a, "handleAdResponse: setting cache request limit count");
            return;
         }

         u$a var3 = this.g(var1);
         if(!var3.a(var2)) {
            this.a(var2);
            this.f(var1);
            eo.a(3, a, "handleAdResponse: setting cache request limit count");
            var3.f();
            return;
         }
      }

   }

   public boolean a(Context var1) {
      boolean var3 = false;
      Iterator var4 = this.d.a(var1).iterator();

      int var2;
      for(var2 = 0; var4.hasNext(); ++var2) {
         this.a(var1, ((com.flurry.sdk.l)var4.next()).getAdSpace());
      }

      eo.a(3, a, "removeAllAds: removed " + var2 + " banners");
      if(var2 > 0) {
         var3 = true;
      }

      return var3;
   }

   public boolean a(Context var1, String var2, ViewGroup var3) {
      eo.a(3, a, "displayAd: context = " + var1 + ", adSpaceName = " + var2 + ", viewGroup = " + var3);
      return this.g(var2).a(var1, var3);
   }

   public boolean a(Context var1, String var2, ViewGroup var3, FlurryAdSize var4) {
      eo.a(3, a, "getAd: context = " + var1 + ", adSpaceName = " + var2 + ", viewGroup = " + var3 + ", size = " + var4);
      if(this.a(var2)) {
         return this.a(var1, var2, var3);
      } else {
         this.a(var1, var2, var3, var4, true);
         return false;
      }
   }

   public boolean a(Context var1, String var2, FlurryAdSize var3) {
      eo.a(3, a, "isAdAvailable: adSpaceName = " + var2);
      return this.a(var2);
   }

   public boolean a(String var1) {
      eo.a(3, a, "isAdReady: adSpaceName = " + var1);
      return this.g(var1).d();
   }

   public String b(String var1) {
      return this.g(var1).e();
   }

   public void b() {
      this.c.a();
   }

   public com.flurry.sdk.an c() {
      return this.c;
   }

   public com.flurry.sdk.l c(String var1) {
      return this.d.a(var1);
   }

   public void d(String var1) {
      if(!TextUtils.isEmpty(var1)) {
         this.c.a(var1);
      }
   }

   public List e(String var1) {
      return TextUtils.isEmpty(var1)?Collections.emptyList():this.c.d(var1);
   }

   public void f(String var1) {
      if(!TextUtils.isEmpty(var1)) {
         this.c.b(var1);
         eo.a(3, a, "fetchAdTaskExecute: setting cache request limit count");
      }
   }
}
