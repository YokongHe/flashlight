package com.nexage.android.a;

import android.text.TextUtils;
import com.nexage.android.NexageAdView;
import java.util.HashMap;
import java.util.UUID;
import java.util.Vector;
import java.util.regex.Pattern;
import org.json.JSONObject;

public final class j {
   private static Pattern a = null;
   private static String c;
   private static long d;
   private static HashMap e = new HashMap();
   private final String b;
   private final Vector f = new Vector();
   private com.nexage.android.a.k g = null;
   private boolean h = false;

   private j(String var1) {
      this.b = var1;
   }

   private static int a(String param0, com.nexage.android.d.b param1, int param2, String param3) {
      // $FF: Couldn't be decompiled
   }

   public static com.nexage.android.a.a a(com.nexage.android.a.m var0, com.nexage.android.c.e var1, String var2, com.nexage.android.d.b var3, int var4) {
      Object var7 = null;
      short var13;
      if(com.nexage.android.b.z()) {
         if(com.nexage.android.a.m.j() == 0) {
            var13 = 2000;
         } else if(com.nexage.android.a.m.j() == 1) {
            var13 = 4000;
         } else {
            var13 = 0;
         }
      } else {
         var13 = 7500;
      }

      String var5 = UUID.randomUUID().toString().replace("-", "");
      var1.a(var5);
      var4 = a(var2, var3, var13, var5);
      switch(var4) {
      case -3:
         com.nexage.android.a.p.b("NAF", "(" + var2 + ") Error: no ad -- unknown");
         break;
      case -2:
         com.nexage.android.a.p.b("NAF", "(" + var2 + ") Error: no ad -- timeout");
         break;
      case -1:
         com.nexage.android.a.p.b("NAF", "(" + var2 + ") Error: no ad -- empty");
      }

      if(var3.c.equals("RTB")) {
         label65: {
            String var6;
            label64: {
               Exception var14;
               label63: {
                  JSONObject var15;
                  try {
                     com.nexage.android.a.p.b("NAF", "parsing RTB JSON");
                     var15 = new JSONObject(c);
                     c = var15.getString("ad");
                     var2 = var15.getString("ad_pru");
                  } catch (Exception var9) {
                     var14 = var9;
                     var2 = null;
                     break label63;
                  }

                  try {
                     var6 = var15.getString("ad_buyer");
                     break label64;
                  } catch (Exception var8) {
                     var14 = var8;
                  }
               }

               com.nexage.android.a.p.d("NAF", "failed to parse RTB JSON -- " + var14.getLocalizedMessage());
               c = null;
               var5 = var2;
               var2 = null;
               break label65;
            }

            var5 = var2;
            var2 = var6;
         }
      } else {
         var2 = null;
         var5 = null;
      }

      com.nexage.android.a.g var12 = new com.nexage.android.a.g(var0, var1, false);
      var12.a(d);
      if(!TextUtils.isEmpty(var5) && !TextUtils.isEmpty(var2)) {
         var12.a(var5, var2);
      }

      if(var0 != null && var0.h() != null && var0.h() instanceof NexageAdView) {
         NexageAdView var10 = (NexageAdView)var0.h();
         var12.a(var10);
         var12.a(var10.a());
      }

      var12.a(var3);
      if(var4 == 1) {
         var4 = var12.a(c);
      }

      var12.a(var4, var3);
      com.nexage.android.a.g var11 = (com.nexage.android.a.g)var7;
      if(var4 == 1) {
         var11 = var12;
      }

      return var11;
   }

   public static com.nexage.android.a.j a(String var0) {
      com.nexage.android.a.j var2 = (com.nexage.android.a.j)e.get(var0);
      com.nexage.android.a.j var1 = var2;
      if(var2 == null) {
         var1 = new com.nexage.android.a.j(var0);
         e.put(var0, var1);
      }

      return var1;
   }

   // $FF: synthetic method
   static String a(com.nexage.android.a.j var0) {
      return var0.b;
   }

   // $FF: synthetic method
   static boolean a(com.nexage.android.a.j var0, boolean var1) {
      var0.h = var1;
      return var1;
   }

   public static void b() {
      // $FF: Couldn't be decompiled
   }

   // $FF: synthetic method
   static boolean b(com.nexage.android.a.j var0) {
      return var0.e();
   }

   // $FF: synthetic method
   static HashMap c() {
      return e;
   }

   // $FF: synthetic method
   static Vector c(com.nexage.android.a.j var0) {
      return var0.f;
   }

   private void d() {
      synchronized(this){}

      try {
         com.nexage.android.a.p.b("NAF", "waiting...");
         this.wait();
         com.nexage.android.a.p.b("NAF", "wait over");
      } catch (InterruptedException var4) {
         ;
      } finally {
         ;
      }

   }

   // $FF: synthetic method
   static void d(com.nexage.android.a.j var0) {
      var0.d();
   }

   private boolean e() {
      boolean var1 = true;
      synchronized(this){}
      boolean var4 = false;

      try {
         var4 = true;
         if(!this.f.isEmpty()) {
            var4 = false;
            return var1;
         }

         this.g = null;
         this.h = true;
         var4 = false;
      } finally {
         if(var4) {
            ;
         }
      }

      var1 = false;
      return var1;
   }

   public final void a() {
      synchronized(this){}

      try {
         com.nexage.android.a.p.b("NAF", "waking...");
         this.notifyAll();
      } finally {
         ;
      }

   }

   public final boolean a(com.nexage.android.a.m var1) {
      synchronized(this){}

      try {
         com.nexage.android.a.p.b("NAF", "add enter");
         if(!this.f.isEmpty()) {
            var1.f();
            ((com.nexage.android.a.m)this.f.get(0)).f();
         }

         var1.f();
         this.f.add(var1);
         if(this.g == null) {
            this.g = new com.nexage.android.a.k(this);
            this.g.start();
         } else {
            var1.e();
         }
      } finally {
         ;
      }

      return true;
   }

   public final void b(com.nexage.android.a.m param1) {
      // $FF: Couldn't be decompiled
   }
}
