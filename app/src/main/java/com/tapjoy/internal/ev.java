package com.tapjoy.internal;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.webkit.WebView;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ev {
   private static volatile WebView a = null;
   private static final Lock b = new ReentrantLock();
   private static Context c = null;
   private static final String d = ev.class.getName();

   public static WebView a(Context var0) {
      if(c != null && c != var0) {
         Log.e(d, "Mismatched context: Only application context should be used, and it should always be consistent between calls");
         return null;
      } else {
         if(a == null) {
            try {
               b.lock();
               if(a == null) {
                  a = new WebView(var0);
                  c = var0;
               }
            } finally {
               b.unlock();
            }
         } else {
            String var3 = d;
         }

         return a;
      }
   }

   public static boolean a() {
      boolean var3 = false;

      WebView var1;
      try {
         var3 = true;
         b.lock();
         var1 = a;
         var3 = false;
      } finally {
         if(var3) {
            b.unlock();
         }
      }

      boolean var0;
      if(var1 != null) {
         var0 = true;
      } else {
         var0 = false;
      }

      b.unlock();
      return var0;
   }

   public static void b() {
      try {
         b.lock();
         if(a != null) {
            WebView var0 = a;
            (new AsyncTask() {
               private WebView a;

               // $FF: synthetic method
               protected final void onPostExecute(Object var1) {
                  this.a.removeAllViews();
                  this.a.destroy();
               }
            }).execute(new WebView[]{var0});
         }

         a = null;
      } finally {
         b.unlock();
      }

   }
}
