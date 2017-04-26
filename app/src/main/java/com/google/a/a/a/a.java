package com.google.a.a.a;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.ads.AdView;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

public final class a implements com.google.android.gms.ads.a.c, com.google.android.gms.ads.a.e {
   private AdView a;
   private com.google.android.gms.ads.e b;

   private static com.google.android.gms.ads.b a(Context var0, com.google.android.gms.ads.a.a var1, Bundle var2, Bundle var3) {
      com.google.android.gms.ads.c var6 = new com.google.android.gms.ads.c();
      Date var7 = var1.a();
      if(var7 != null) {
         var6.a(var7);
      }

      int var4 = var1.b();
      if(var4 != 0) {
         var6.a(var4);
      }

      Set var8 = var1.c();
      if(var8 != null) {
         Iterator var9 = var8.iterator();

         while(var9.hasNext()) {
            var6.a((String)var9.next());
         }
      }

      if(var1.d()) {
         var6.b(com.google.android.gms.internal.bI.a(var0));
      }

      if(var3.getInt("tagForChildDirectedTreatment") != -1) {
         boolean var5;
         if(var3.getInt("tagForChildDirectedTreatment") == 1) {
            var5 = true;
         } else {
            var5 = false;
         }

         var6.a(var5);
      }

      if(var2 == null) {
         var2 = new Bundle();
      }

      var2.putInt("gw", 1);
      var2.putString("mad_hac", var3.getString("mad_hac"));
      if(!TextUtils.isEmpty(var3.getString("adJson"))) {
         var2.putString("_ad", var3.getString("adJson"));
      }

      var2.putBoolean("_noRefresh", true);
      var6.a(com.google.a.a.a.a.class, var2);
      return var6.a();
   }

   public final void a() {
      if(this.a != null) {
         this.a.a();
         this.a = null;
      }

      if(this.b != null) {
         this.b = null;
      }

   }

   public final void a(Context var1, com.google.android.gms.ads.a.d var2, Bundle var3, com.google.android.gms.ads.d var4, com.google.android.gms.ads.a.a var5, Bundle var6) {
      this.a = new AdView(var1);
      this.a.a(new com.google.android.gms.ads.d(var4.b(), var4.a()));
      this.a.a(var3.getString("pubid"));
      this.a.a((com.google.android.gms.ads.a)(new com.google.a.a.a.b(this, var2)));
      this.a.a(a(var1, var5, var6, var3));
   }

   public final void a(Context var1, com.google.android.gms.ads.a.f var2, Bundle var3, com.google.android.gms.ads.a.a var4, Bundle var5) {
      this.b = new com.google.android.gms.ads.e(var1);
      this.b.a(var3.getString("pubid"));
      this.b.a((com.google.android.gms.ads.a)(new com.google.a.a.a.c(this, var2)));
      this.b.a(a(var1, var4, var5, var3));
   }

   public final void b() {
      if(this.a != null) {
         this.a.b();
      }

   }

   public final void c() {
      if(this.a != null) {
         this.a.c();
      }

   }

   public final View d() {
      return this.a;
   }

   public final void e() {
      this.b.b();
   }
}
