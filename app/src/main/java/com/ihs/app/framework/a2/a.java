package com.ihs.app.framework.a2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

public final class a {
   private final BroadcastReceiver a = new BroadcastReceiver() {
      public final void onReceive(Context var1, Intent var2) {
         if(var2.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS")) {
            String var3 = var2.getStringExtra("reason");
            if(var3 != null && var3.equals("homekey")) {
               com.ihs.app.framework.a.a.a(a.this, true);
            }
         }

      }
   };
   private boolean b;
   private Context c;
   private IntentFilter d;

   public a(Context var1) {
      this.c = var1;
      this.d = new IntentFilter("android.intent.action.CLOSE_SYSTEM_DIALOGS");
   }

   // $FF: synthetic method
   static boolean a(com.ihs.app.framework.a2.a var0, boolean var1) {
      var0.b = true;
      return true;
   }

   public final void a() {
      this.b = false;
      this.c.getApplicationContext().registerReceiver(this.a, this.d);
   }

   public final void b() {
      this.c.getApplicationContext().unregisterReceiver(this.a);
   }

   public final boolean c() {
      return this.b;
   }
}
