package com.flurry.sdk;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.os.Build.VERSION;
import com.flurry.sdk.do;
import com.flurry.sdk.dt;
import com.flurry.sdk.du;
import com.flurry.sdk.du$a;
import java.util.Iterator;
import java.util.List;

public class dv {
   private static dv b;
   private final dt a = new dt();

   @TargetApi(14)
   private dv() {
      if(VERSION.SDK_INT >= 14) {
         ((Application)do.a().b()).registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            protected void a(Activity var1, du$a var2) {
               Iterator var3 = dv.this.c().iterator();

               while(var3.hasNext()) {
                  ((du)var3.next()).a(var1, var2);
               }

            }

            public void onActivityCreated(Activity var1, Bundle var2) {
               this.a(var1, du$a.a);
            }

            public void onActivityDestroyed(Activity var1) {
               this.a(var1, du$a.b);
            }

            public void onActivityPaused(Activity var1) {
               this.a(var1, du$a.c);
            }

            public void onActivityResumed(Activity var1) {
               this.a(var1, du$a.d);
            }

            public void onActivitySaveInstanceState(Activity var1, Bundle var2) {
               this.a(var1, du$a.g);
            }

            public void onActivityStarted(Activity var1) {
               this.a(var1, du$a.e);
            }

            public void onActivityStopped(Activity var1) {
               this.a(var1, du$a.f);
            }
         });
      }

   }

   public static dv a() {
      synchronized(dv.class){}

      dv var0;
      try {
         if(b == null) {
            b = new dv();
         }

         var0 = b;
      } finally {
         ;
      }

      return var0;
   }

   private List c() {
      synchronized(this){}

      List var1;
      try {
         var1 = this.a.a();
      } finally {
         ;
      }

      return var1;
   }

   public void a(du var1) {
      synchronized(this){}

      try {
         this.a.a(var1);
      } finally {
         ;
      }

   }

   public boolean b() {
      return VERSION.SDK_INT >= 14;
   }
}
