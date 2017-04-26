package com.nexage.android.c;

import android.content.Context;
import java.util.Timer;
import java.util.TimerTask;

public final class f {
   private static Context a;
   private static boolean b;
   private static boolean c;
   private static boolean d;
   private static long e = 0L;
   private static Timer f;
   private static Timer g;

   public static com.nexage.android.c.e a(String var0) {
      synchronized(com.nexage.android.c.f.class){}

      com.nexage.android.c.e var3;
      try {
         var3 = new com.nexage.android.c.e(var0);
      } finally {
         ;
      }

      return var3;
   }

   static String a() {
      return com.nexage.android.b.d() + "/adEvents";
   }

   public static void a(Context var0) {
      synchronized(com.nexage.android.c.f.class){}

      try {
         com.nexage.android.a.p.b("ReportManager", "starting...");
         a = var0;
         com.nexage.android.c.g.a(var0);
         j();
         b = true;
         e = System.currentTimeMillis();
         com.nexage.android.a.p.b("ReportManager", "initial report flush complete");
      } finally {
         ;
      }

   }

   public static void a(com.nexage.android.c.e param0) {
      // $FF: Couldn't be decompiled
   }

   public static void a(boolean var0) {
      synchronized(com.nexage.android.c.f.class){}

      try {
         d = true;
      } finally {
         ;
      }

   }

   public static boolean a(com.nexage.android.c.e var0, com.nexage.android.c.a var1) {
      synchronized(com.nexage.android.c.f.class){}
      boolean var4 = false;

      boolean var2;
      label53: {
         label52: {
            try {
               var4 = true;
               com.nexage.android.a.p.b("ReportManager", "addClickEvent: " + var1.d);
               if(var0.m != null) {
                  com.nexage.android.a.p.c(var0.a, "AD Clicked again. Stats will only reflect the first click.");
                  var4 = false;
                  break label52;
               }

               var0.m = var1;
               com.nexage.android.c.g.a(var0, var1);
               com.nexage.android.a.p.c(var0.a, "AD Clicked");
               com.nexage.android.a.p.b("ReportManager", "calling isReadyToFlush from addClickEvent");
               if(i()) {
                  j();
                  var4 = false;
               } else {
                  var4 = false;
               }
            } finally {
               if(var4) {
                  ;
               }
            }

            var2 = true;
            break label53;
         }

         var2 = false;
      }

      return var2;
   }

   public static boolean a(com.nexage.android.c.e var0, com.nexage.android.c.b var1) {
      synchronized(com.nexage.android.c.f.class){}
      boolean var4 = false;

      boolean var2;
      label53: {
         label52: {
            try {
               var4 = true;
               com.nexage.android.a.p.b("ReportManager", "addDisplayEvent: " + var1.d);
               if(var0.n != null) {
                  com.nexage.android.a.p.c("ReportManager", "AD displayed again. Stats will only reflect the first display.");
                  var4 = false;
                  break label52;
               }

               com.nexage.android.c.g.a(var0, var1);
               com.nexage.android.a.p.b("ReportManager", "calling isReadyToFlush from addDisplayEvent");
               if(i()) {
                  j();
                  var4 = false;
               } else {
                  var4 = false;
               }
            } finally {
               if(var4) {
                  ;
               }
            }

            var2 = true;
            break label53;
         }

         var2 = false;
      }

      return var2;
   }

   public static boolean a(com.nexage.android.c.e var0, com.nexage.android.g.a var1) {
      synchronized(com.nexage.android.c.f.class){}

      boolean var2;
      try {
         com.nexage.android.c.b var3 = new com.nexage.android.c.b(var1.c, var1.d.b);
         var3.f = var1.f;
         var3.e = var1.e;
         var2 = a(var0, var3);
      } finally {
         ;
      }

      return var2;
   }

   public static long b() {
      return System.currentTimeMillis();
   }

   static void b(boolean param0) {
      // $FF: Couldn't be decompiled
   }

   public static boolean b(com.nexage.android.c.e var0, com.nexage.android.g.a var1) {
      synchronized(com.nexage.android.c.f.class){}

      boolean var2;
      try {
         var2 = a(var0, new com.nexage.android.c.a(var1.c, var1.d.b));
      } finally {
         ;
      }

      return var2;
   }

   private static void e() {
      synchronized(com.nexage.android.c.f.class){}

      try {
         f();
         com.nexage.android.a.p.b("ReportManager", "startCheckAfterReqTimer");
         Timer var0 = new Timer();
         g = var0;
         var0.schedule(new TimerTask() {
            public final void run() {
               com.nexage.android.a.p.b("ReportManager", "calling isReadyToFlush from requestCompleted");
               if(com.nexage.android.c.f.i()) {
                  com.nexage.android.c.f.j();
               }

            }
         }, 3000L);
      } finally {
         ;
      }

   }

   private static void f() {
      synchronized(com.nexage.android.c.f.class){}

      try {
         com.nexage.android.a.p.b("ReportManager", "stopCheckAfterReqTimer");
         if(g != null) {
            g.cancel();
            g = null;
         }
      } finally {
         ;
      }

   }

   private static void g() {
      synchronized(com.nexage.android.c.f.class){}

      try {
         h();
         long var0 = (long)com.nexage.android.d.e.b();
         com.nexage.android.a.p.b("ReportManager", "startFlushTimer, delay=" + var0);
         Timer var2 = new Timer();
         f = var2;
         var2.schedule(new TimerTask() {
            public final void run() {
               com.nexage.android.a.p.b("ReportManager", "tick!");
               com.nexage.android.c.f.j();
            }
         }, var0);
      } finally {
         ;
      }

   }

   private static void h() {
      synchronized(com.nexage.android.c.f.class){}

      try {
         com.nexage.android.a.p.b("ReportManager", "stopFlushTimer");
         if(f != null) {
            f.cancel();
            f = null;
         }
      } finally {
         ;
      }

   }

   private static boolean i() {
      // $FF: Couldn't be decompiled
   }

   private static void j() {
      synchronized(com.nexage.android.c.f.class){}

      try {
         com.nexage.android.a.p.b("ReportManager", "flush");
         if(d) {
            com.nexage.android.a.p.d("ReportManager", "flush already in progress");
         } else {
            h();
            if(com.nexage.android.d.a.a(a)) {
               com.nexage.android.a.p.d("ReportManager", "device is offline");
               g();
            } else {
               com.nexage.android.c.i.a(a);
            }
         }
      } finally {
         ;
      }

   }
}
