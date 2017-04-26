package com.inneractive.api.ads.sdk;

import android.content.Context;
import com.inneractive.api.ads.sdk.IAreflectionHandler$a;
import com.inneractive.api.ads.sdk.InneractiveAdView$InneractiveErrorCode;
import com.inneractive.api.ads.sdk.InneractiveAdView$Log;
import com.inneractive.api.ads.sdk.b$a;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

class IAmillennialInterstitial extends com.inneractive.api.ads.sdk.b implements InvocationHandler {
   private Object a;
   private Class b;
   private Object c;
   private b$a d;
   private String e;
   private com.inneractive.api.ads.sdk.a f;
   private boolean g = false;

   protected final void a() {
      // $FF: Couldn't be decompiled
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
         InneractiveAdView$Log.d(an.a(var2));
         InneractiveAdView$Log.a("Could not invalidate Millennial Media ad using reflection!");
         this.d.a(InneractiveAdView$InneractiveErrorCode.SDK_INTERNAL_ERROR);
      }
   }

   public Object invoke(Object param1, Method param2, Object[] param3) {
      // $FF: Couldn't be decompiled
   }
}
