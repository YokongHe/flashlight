package com.flurry.sdk;

import com.flurry.sdk.cu$a;
import com.flurry.sdk.ds;
import java.util.HashMap;
import java.util.Map;

public class cu {
   private int a;
   private int b;
   private ds c;
   private Map d;
   private com.flurry.sdk.cv e;

   private cu() {
   }

   // $FF: synthetic method
   cu(Object var1) {
      this();
   }

   // $FF: synthetic method
   static int a(com.flurry.sdk.cu var0, int var1) {
      var0.a = var1;
      return var1;
   }

   public static com.flurry.sdk.cu a(com.flurry.sdk.cu var0, com.flurry.sdk.cu var1) {
      if(var0 != null && var1 != null) {
         ds var2 = new ds();
         ds var3 = var0.c();
         if(var3 != null) {
            var2.a(var3);
         }

         var3 = var1.c();
         if(var3 != null) {
            var2.a(var3);
         }

         HashMap var6 = new HashMap();
         Map var4 = var0.d();
         if(var4 != null) {
            var6.putAll(var4);
         }

         var4 = var1.d();
         if(var4 != null) {
            var6.putAll(var4);
         }

         cu$a var5 = new cu$a();
         var5.a(var1.a());
         var5.b(var1.b());
         var5.a(var2);
         var5.a((Map)var6);
         var5.a(var1.e());
         return var5.a();
      } else {
         return null;
      }
   }

   // $FF: synthetic method
   static com.flurry.sdk.cv a(com.flurry.sdk.cu var0, com.flurry.sdk.cv var1) {
      var0.e = var1;
      return var1;
   }

   // $FF: synthetic method
   static ds a(com.flurry.sdk.cu var0, ds var1) {
      var0.c = var1;
      return var1;
   }

   // $FF: synthetic method
   static Map a(com.flurry.sdk.cu var0, Map var1) {
      var0.d = var1;
      return var1;
   }

   // $FF: synthetic method
   static int b(com.flurry.sdk.cu var0, int var1) {
      var0.b = var1;
      return var1;
   }

   public int a() {
      return this.a;
   }

   public int b() {
      return this.b;
   }

   public ds c() {
      return this.c;
   }

   public Map d() {
      return this.d;
   }

   public com.flurry.sdk.cv e() {
      return this.e;
   }
}
