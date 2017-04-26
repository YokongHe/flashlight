package com.flurry.sdk;

import android.view.ViewGroup;
import com.flurry.android.FlurryAdSize;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;
import com.flurry.android.impl.ads.avro.protocol.v10.Configuration;
import com.flurry.sdk.do;
import com.flurry.sdk.eo;
import com.flurry.sdk.t$a;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class t {
   private static final String a = com.flurry.sdk.t.class.getSimpleName();
   private final FlurryAdModule b;
   private final com.flurry.sdk.w c;
   private final Map d;
   private final Map e;
   private Configuration f;
   private int g;
   private boolean h;

   public t(FlurryAdModule var1) {
      this.b = var1;
      this.c = new com.flurry.sdk.w();
      this.d = new HashMap();
      this.e = new HashMap();
   }

   // $FF: synthetic method
   static FlurryAdModule a(com.flurry.sdk.t var0) {
      return var0.b;
   }

   // $FF: synthetic method
   static Configuration a(com.flurry.sdk.t var0, Configuration var1) {
      var0.f = var1;
      return var1;
   }

   private t$a a(String param1) {
      // $FF: Couldn't be decompiled
   }

   // $FF: synthetic method
   static boolean a(com.flurry.sdk.t var0, boolean var1) {
      var0.h = var1;
      return var1;
   }

   // $FF: synthetic method
   static Configuration b(com.flurry.sdk.t var0) {
      return var0.f;
   }

   // $FF: synthetic method
   static void c(com.flurry.sdk.t var0) {
      var0.e();
   }

   // $FF: synthetic method
   static com.flurry.sdk.w d(com.flurry.sdk.t var0) {
      return var0.c;
   }

   // $FF: synthetic method
   static String d() {
      return a;
   }

   // $FF: synthetic method
   static int e(com.flurry.sdk.t var0) {
      int var1 = var0.g;
      var0.g = var1 + 1;
      return var1;
   }

   private void e() {
      // $FF: Couldn't be decompiled
   }

   public void a() {
      if(this.f == null) {
         this.a("", (ViewGroup)null, FlurryAdSize.BANNER_BOTTOM, true, (AdUnit)null);
      } else {
         this.e();
      }
   }

   public void a(String var1, ViewGroup var2, FlurryAdSize var3, boolean var4, AdUnit var5) {
      eo.a(3, a, "requestAd: adSpaceName = " + var1 + ", viewGroup = " + var2 + ", size = " + var3 + ", refresh = " + var4);
      this.a(var1).a(var2, var3, var4, var5);
   }

   public void a(String param1, List param2, int param3) {
      // $FF: Couldn't be decompiled
   }

   public void b() {
      Iterator var1 = this.e.values().iterator();

      while(var1.hasNext()) {
         ((t$a)var1.next()).a();
      }

      this.e.clear();
   }

   public File c() {
      return this.h?do.a().b().getFileStreamPath(".flurryads.mediaassets"):null;
   }
}
