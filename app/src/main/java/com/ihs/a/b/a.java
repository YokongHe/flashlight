package com.ihs.a.b;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import java.io.InputStream;
import java.util.Map;

final class a {
   private Map a;
   private com.ihs.a.b.c b;
   private String c;
   private Context d;

   private static String a(InputStream param0) {
      // $FF: Couldn't be decompiled
   }

   private Map a(Context param1, String param2) {
      // $FF: Couldn't be decompiled
   }

   private void e() {
      // $FF: Couldn't be decompiled
   }

   public final int a(int var1, String... var2) {
      return com.ihs.a.e.g.a(this.a, var1, var2);
   }

   public final String a(String var1, String... var2) {
      return com.ihs.a.e.g.a(this.a, var1, var2);
   }

   public final void a() {
      synchronized(this){}

      try {
         this.b.a(new com.ihs.a.b.d() {
            public final void a(boolean var1) {
               if(var1) {
                  a.this.e();
                  (new Handler(Looper.getMainLooper())).post(new Runnable() {
                     public final void run() {
                        com.ihs.a.d.a.a("hs.commons.config.CONFIG_CHANGED");
                     }
                  });
               }

            }
         });
      } finally {
         ;
      }

   }

   public final void a(Context var1, String var2, boolean var3) {
      synchronized(this){}

      try {
         this.d = var1;
         this.c = var2;
         this.a = this.a(var1, var2);
         var2 = this.a("", new String[]{"libCommons", "RemoteConfig", "PlistFile"});
         this.b = new com.ihs.a.b.c(var1, this.a("", new String[]{"libCommons", "RemoteConfig", "PlistUrl"}), var2, var3);
         this.e();
      } finally {
         ;
      }

   }

   public final boolean a(String... var1) {
      boolean var2;
      Boolean var4;
      try {
         var2 = com.ihs.a.e.g.b(this.a, var1);
      } catch (Exception var3) {
         var3.printStackTrace();
         if(com.ihs.a.e.f.a()) {
            throw new RuntimeException("config value not exist");
         }

         var4 = null;
         return var4 == null?false:var4.booleanValue();
      }

      var4 = Boolean.valueOf(var2);
      return var4 == null?false:var4.booleanValue();
   }

   public final String b(String... var1) {
      String var4;
      try {
         var4 = com.ihs.a.e.g.c(this.a, var1);
      } catch (Exception var3) {
         var3.printStackTrace();
         if(com.ihs.a.e.f.a()) {
            throw new RuntimeException("config value not exist");
         }

         var4 = null;
      }

      String var2 = var4;
      if(var4 == null) {
         var2 = "";
      }

      return var2;
   }

   public final boolean b() {
      return this.b.b();
   }

   public final String c() {
      return this.b.c();
   }

   public final Map d() {
      return this.a;
   }
}
