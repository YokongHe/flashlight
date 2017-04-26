package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;

final class M {
   static void a(Context var0, String var1, String var2, String var3) {
      final Editor var4 = var0.getSharedPreferences(var1, 0).edit();
      var4.putString(var2, var3);
      if(VERSION.SDK_INT >= 9) {
         var4.apply();
      } else {
         (new Thread(new Runnable() {
            public final void run() {
               var4.commit();
            }
         })).start();
      }
   }
}
