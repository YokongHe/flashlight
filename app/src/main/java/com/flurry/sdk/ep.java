package com.flurry.sdk;

import android.content.Context;
import com.flurry.sdk.dj;
import com.flurry.sdk.eq;
import com.flurry.sdk.et;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class ep implements et {
   private static ep a;
   private final List b = b();

   public static ep a() {
      synchronized(ep.class){}

      ep var0;
      try {
         if(a == null) {
            a = new ep();
         }

         var0 = a;
      } finally {
         ;
      }

      return var0;
   }

   private static List b() {
      ArrayList var0 = new ArrayList();
      var0.add(new eq("com.flurry.android.impl.analytics.FlurryAnalyticsModule", 10));
      var0.add(new eq("com.flurry.android.impl.ads.FlurryAdModule", 10));
      return Collections.unmodifiableList(var0);
   }

   public final void a(dj var1) {
      Iterator var2 = this.b.iterator();

      while(var2.hasNext()) {
         ((et)var2.next()).a(var1);
      }

   }

   public final void a(dj var1, Context var2) {
      Iterator var3 = this.b.iterator();

      while(var3.hasNext()) {
         ((et)var3.next()).a(var1, var2);
      }

   }

   public final void b(dj var1, Context var2) {
      Iterator var3 = this.b.iterator();

      while(var3.hasNext()) {
         ((et)var3.next()).b(var1, var2);
      }

   }

   public final void c(dj var1, Context var2) {
      Iterator var3 = this.b.iterator();

      while(var3.hasNext()) {
         ((et)var3.next()).c(var1, var2);
      }

   }
}
