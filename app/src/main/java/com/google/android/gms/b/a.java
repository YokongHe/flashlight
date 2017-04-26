package com.google.android.gms.b;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public final class a {
   static com.google.android.gms.b.a a;
   final BlockingQueue b = new LinkedBlockingQueue();
   private Context c;
   private PendingIntent d;
   private Handler e = new Handler(Looper.getMainLooper()) {
      public final void handleMessage(Message var1) {
         Intent var2 = (Intent)var1.obj;
         a.this.b.add(var2);
      }
   };
   private Messenger f;

   public a() {
      this.f = new Messenger(this.e);
   }

   public static com.google.android.gms.b.a a(Context var0) {
      synchronized(com.google.android.gms.b.a.class){}

      com.google.android.gms.b.a var4;
      try {
         if(a == null) {
            com.google.android.gms.b.a var1 = new com.google.android.gms.b.a();
            a = var1;
            var1.c = var0;
         }

         var4 = a;
      } finally {
         ;
      }

      return var4;
   }

   private void a(Intent var1) {
      synchronized(this){}

      try {
         if(this.d == null) {
            Intent var2 = new Intent();
            var2.setPackage("com.google.example.invalidpackage");
            this.d = PendingIntent.getBroadcast(this.c, 0, var2, 0);
         }

         var1.putExtra("app", this.d);
      } finally {
         ;
      }

   }

   private void b(String... var1) {
      if(var1 != null && var1.length != 0) {
         StringBuilder var3 = new StringBuilder(var1[0]);

         for(int var2 = 1; var2 < var1.length; ++var2) {
            var3.append(',').append(var1[var2]);
         }

         String var4 = var3.toString();
         Intent var5 = new Intent("com.google.android.c2dm.intent.REGISTER");
         var5.setPackage("com.google.android.gms");
         var5.putExtra("google.messenger", this.f);
         this.a(var5);
         var5.putExtra("sender", var4);
         this.c.startService(var5);
      } else {
         throw new IllegalArgumentException("No senderIds");
      }
   }

   public final String a(String... param1) {
      // $FF: Couldn't be decompiled
   }
}
