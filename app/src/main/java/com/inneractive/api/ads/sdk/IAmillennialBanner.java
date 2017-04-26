package com.inneractive.api.ads.sdk;

import android.content.Context;
import android.view.View;
import com.inneractive.api.ads.sdk.IAreflectionHandler$a;
import com.inneractive.api.ads.sdk.InneractiveAdView$InneractiveErrorCode;
import com.inneractive.api.ads.sdk.InneractiveAdView$Log;
import com.inneractive.api.ads.sdk.b$a;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

class IAmillennialBanner extends com.inneractive.api.ads.sdk.b implements InvocationHandler {
   private Object a;
   private Class b;
   private Object c;
   private b$a d;
   private String e;
   private com.inneractive.api.ads.sdk.a f;
   private boolean g = false;

   protected final void a() {
      InneractiveAdView$Log.a("** Millennial banner ad shown **");
   }

   protected final void a(Context param1, b$a param2, com.inneractive.api.ads.sdk.a param3) {
      // $FF: Couldn't be decompiled
   }

   protected final void b() {
      try {
         this.b = Class.forName("com.millennialmedia.android.RequestListener");
         (new IAreflectionHandler$a(this.a, "setListener")).a(this.b, (Object)null).a();
      } catch (Exception var2) {
         InneractiveAdView$Log.d("Handled Exception:");
         InneractiveAdView$Log.d(com.inneractive.api.ads.sdk.an.a(var2));
         InneractiveAdView$Log.a("Could not invalidate Millennial Media ad using reflection!");
         this.d.a(InneractiveAdView$InneractiveErrorCode.SDK_INTERNAL_ERROR);
      }
   }

   public Object invoke(Object var1, Method var2, Object[] var3) {
      if(var2.getName().equals("MMAdOverlayClosed")) {
         InneractiveAdView$Log.a("** Millennial banner ad overlay closed **");
      } else if(var2.getName().equals("MMAdOverlayLaunched")) {
         InneractiveAdView$Log.a("** Millennial banner ad overlay Launched **");
         this.d.c();
      } else if(var2.getName().equals("MMAdRequestIsCaching")) {
         InneractiveAdView$Log.a("** Millennial banner ad is caching **");
      } else if(var2.getName().equals("onSingleTap")) {
         if(!this.g) {
            this.g = true;
            InneractiveAdView$Log.a("** Millennial banner ad clicked **");
            if(this.f != null) {
               this.f.i("MM");
            }

            this.d.b();
         }
      } else if(var2.getName().equals("requestCompleted")) {
         InneractiveAdView$Log.a("** Millennial banner ad loaded successfully **");
         if(this.f != null) {
            this.f.h("MM");
         }

         this.d.a((View)var3[0]);
      } else if(var2.getName().equals("requestFailed")) {
         InneractiveAdView$Log.a("** Millennial banner ad failed to load **");
         if(this.f != null) {
            this.f.h("IA");
            this.f.g("MM");
         }

         this.d.a(InneractiveAdView$InneractiveErrorCode.NO_FILL);
      }

      return null;
   }
}
