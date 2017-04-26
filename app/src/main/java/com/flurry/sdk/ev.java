package com.flurry.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.flurry.sdk.do;
import com.flurry.sdk.dt;
import com.flurry.sdk.eu;
import com.flurry.sdk.ev$a;
import java.util.Iterator;
import java.util.List;

public class ev extends BroadcastReceiver {
   private static ev e;
   boolean a;
   Boolean b;
   private final dt c = new dt();
   private boolean d = false;

   public static ev a() {
      synchronized(ev.class){}

      ev var0;
      try {
         if(e == null) {
            e = new ev();
         }

         var0 = e;
      } finally {
         ;
      }

      return var0;
   }

   private boolean a(Context var1) {
      if(this.d && var1 != null) {
         NetworkInfo var2 = ((ConnectivityManager)var1.getSystemService("connectivity")).getActiveNetworkInfo();
         return var2 != null && var2.isConnected();
      } else {
         return true;
      }
   }

   private List f() {
      synchronized(this){}

      List var1;
      try {
         var1 = this.c.a();
      } finally {
         ;
      }

      return var1;
   }

   public void a(eu var1) {
      synchronized(this){}

      try {
         this.c.a(var1);
      } finally {
         ;
      }

   }

   public void b() {
      // $FF: Couldn't be decompiled
   }

   public boolean c() {
      return this.b != null?this.b.booleanValue():this.a;
   }

   void d() {
      Context var1 = do.a().b();
      this.a = this.a(var1);
      var1.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
   }

   public ev$a e() {
      if(!this.d) {
         return ev$a.a;
      } else {
         NetworkInfo var1 = ((ConnectivityManager)do.a().b().getSystemService("connectivity")).getActiveNetworkInfo();
         if(var1 != null && var1.isConnected()) {
            switch(var1.getType()) {
            case 0:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
               return ev$a.c;
            case 1:
            case 9:
               return ev$a.b;
            case 8:
               return ev$a.a;
            default:
               return ev$a.c;
            }
         } else {
            return ev$a.a;
         }
      }
   }

   public void onReceive(Context var1, Intent var2) {
      boolean var3 = this.a(var1);
      if(this.a != var3) {
         this.a = var3;
         Iterator var4 = this.f().iterator();

         while(var4.hasNext()) {
            ((eu)var4.next()).a(this.a);
         }
      }

   }
}
