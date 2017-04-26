package com.nexage.android.a;

import android.os.Handler;
import android.os.Message;

public final class o extends Handler {
   private static boolean a = true;
   private static Handler b;

   public static void a() {
      if(b == null) {
         b = new com.nexage.android.a.o();
      }

   }

   public static void a(boolean var0) {
      synchronized(com.nexage.android.a.o.class){}

      try {
         com.nexage.android.a.p.b("NexageGlobalHandler", "setGlobalAdServingEnabled " + var0);
         a = var0;
      } finally {
         ;
      }

   }

   public static Handler b() {
      return b;
   }

   public static boolean c() {
      return a;
   }

   public final void handleMessage(Message var1) {
      switch(var1.what) {
      case 1:
         com.nexage.android.a.p.b("NexageGlobalHandler", "isGlobalAdServingEnabled false (handleMessage)");
         a = false;
         break;
      case 2:
         com.nexage.android.a.p.b("NexageGlobalHandler", "isGlobalAdServingEnabled true (handleMessage)");
         a = true;
         com.nexage.android.a.j.b();
      }

      super.handleMessage(var1);
   }
}
