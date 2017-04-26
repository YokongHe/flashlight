package com.facebook.ads.a;

import android.content.Context;
import android.os.Looper;
import com.facebook.ads.a.p$a;
import java.lang.reflect.Method;

public class t {
   private final String a;
   private final boolean b;

   private t(String var1, boolean var2) {
      this.a = var1;
      this.b = var2;
   }

   public static com.facebook.ads.a.t a(Context var0, p$a var1) {
      if(Looper.myLooper() == Looper.getMainLooper()) {
         throw new IllegalStateException("Cannot get advertising info on main thread.");
      } else if(var1 != null && !com.facebook.ads.a.ag.a(var1.b)) {
         return new com.facebook.ads.a.t(var1.b, var1.c);
      } else {
         Method var4 = com.facebook.ads.a.p.a("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", new Class[]{Context.class});
         if(var4 == null) {
            return null;
         } else {
            Object var5 = com.facebook.ads.a.p.a((Object)null, (Method)var4, (Object[])(new Object[]{var0}));
            if(var5 != null && ((Integer)var5).intValue() == 0) {
               var4 = com.facebook.ads.a.p.a("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", new Class[]{Context.class});
               if(var4 == null) {
                  return null;
               } else {
                  Object var3 = com.facebook.ads.a.p.a((Object)null, (Method)var4, (Object[])(new Object[]{var0}));
                  if(var3 == null) {
                     return null;
                  } else {
                     var4 = com.facebook.ads.a.p.a(var3.getClass(), "getId", new Class[0]);
                     Method var2 = com.facebook.ads.a.p.a(var3.getClass(), "isLimitAdTrackingEnabled", new Class[0]);
                     return var4 != null && var2 != null?new com.facebook.ads.a.t((String)com.facebook.ads.a.p.a(var3, var4, new Object[0]), ((Boolean)com.facebook.ads.a.p.a(var3, var2, new Object[0])).booleanValue()):null;
                  }
               }
            } else {
               return null;
            }
         }
      }
   }

   public String a() {
      return this.a;
   }

   public boolean b() {
      return this.b;
   }
}
