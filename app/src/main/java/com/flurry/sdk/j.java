package com.flurry.sdk;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsoluteLayout;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.flurry.android.AdCreative;
import com.flurry.android.ICustomAdNetworkHandler;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.android.impl.ads.avro.protocol.v10.AdFrame;
import com.flurry.android.impl.ads.avro.protocol.v10.AdSpaceLayout;
import com.flurry.android.impl.ads.avro.protocol.v10.AdUnit;
import com.flurry.sdk.eo;
import com.flurry.sdk.j$a;
import com.flurry.sdk.j$b;
import com.flurry.sdk.j$c;
import com.flurry.sdk.j$d;
import com.flurry.sdk.j$e;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class j extends com.flurry.sdk.ah {
   private static final String a = com.flurry.sdk.j.class.getSimpleName();
   private static final Map b = f();
   private com.flurry.sdk.i c;

   public j(FlurryAdModule var1, AdUnit var2, com.flurry.sdk.e var3) {
      super(var1, var2, var3);
   }

   private int a(ViewGroup var1) {
      int var2 = var1.getChildCount();
      if(this.c() != null && this.c().d().size() > 0) {
         AdSpaceLayout var3 = ((AdFrame)this.c().d().get(0)).e();
         if(var3 != null) {
            String[] var4 = var3.f().toString().split("-");
            if(var4.length == 2 && "t".equals(var4[0])) {
               return 0;
            }
         }

         return var2;
      } else {
         return var2;
      }
   }

   private LayoutParams a(ViewGroup var1, com.flurry.sdk.l var2) {
      LayoutParams var4;
      if(this.c() != null && this.c().d().size() > 0) {
         AdSpaceLayout var5 = ((AdFrame)this.c().d().get(0)).e();
         if(var5 == null) {
            return null;
         }

         j$c var3 = b(var1);
         if(var3 == null) {
            eo.a(5, a, "Ad space layout and alignment from the server is being ignored for ViewGroup subclass " + var1.getClass().getSimpleName());
            return null;
         }

         LayoutParams var6 = var3.a(var5);
         var4 = var6;
         if(var6 == null) {
            eo.a(6, a, "Ad space layout and alignment from the server is being ignored for ViewGroup subclass " + var1.getClass().getSimpleName());
            return var6;
         }
      } else {
         var4 = null;
      }

      return var4;
   }

   // $FF: synthetic method
   static String a() {
      return a;
   }

   private void a(Context var1, ViewGroup var2, FlurryAdModule var3) {
      com.flurry.sdk.l var4 = var3.a(var1, var2, this.e());
      if(var4 == null) {
         eo.a(6, a, "failed to render banner ad for holder = " + var4 + " for adSpaceName = " + this.e());
      } else {
         ViewGroup var5 = (ViewGroup)var4.getParent();
         if(var5 != null) {
            var5.removeView(var4);
         }

         var4.d();
         var4.removeAllViews();
         var5 = (ViewGroup)this.c.getParent();
         if(var5 != null) {
            var5.removeView(this.c);
         }

         var4.addView(this.c, new android.widget.RelativeLayout.LayoutParams(-1, -1));
         this.c.initLayout();
         LayoutParams var6 = this.a(var2, var4);
         if(var6 != null) {
            var4.setLayoutParams(var6);
            eo.a(3, a, "banner ad holder layout params = " + var6.getClass().getName() + " {width = " + var6.width + ", height = " + var6.height + "} for banner ad with adSpaceName = " + this.e());
         }

         var2.addView(var4, this.a(var2));
      }
   }

   private static j$c b(ViewGroup var0) {
      return (j$c)b.get(var0.getClass());
   }

   private static Map f() {
      HashMap var0 = new HashMap();
      var0.put(LinearLayout.class, new j$d());
      var0.put(AbsoluteLayout.class, new j$a());
      var0.put(FrameLayout.class, new j$b());
      var0.put(RelativeLayout.class, new j$e());
      return Collections.unmodifiableMap(var0);
   }

   public final void a(Context var1, ViewGroup var2) {
      eo.a(3, a, "render(" + var1 + ", " + var2 + ")");
      if(var1 != null && var2 != null) {
         FlurryAdModule var4 = this.b();
         AdUnit var5 = this.c();
         com.flurry.sdk.e var6 = this.d();
         if(var5 == null) {
            eo.a(6, a, "failed to render banner ad, adUnit is null for adspace: " + this.e() + " context: " + var1 + " viewGroup: " + var2);
         } else {
            List var7 = var5.d();
            if(var7 != null && !var7.isEmpty()) {
               AdFrame var8 = (AdFrame)var7.get(0);
               int var3 = var8.b().intValue();
               String var12 = var8.d().toString();
               AdCreative var13 = com.flurry.sdk.cc.a(var8.e());
               ICustomAdNetworkHandler var9 = var4.q();
               com.flurry.sdk.k var10 = var4.b();
               if(var3 == 4 && var9 != null) {
                  this.c = var9.getAdFromNetwork(var1, var13, var12);
                  if(this.c != null) {
                     this.c.setPlatformModule(var4);
                     this.c.setAdLog(var6);
                     this.c.setAdFrameIndex(0);
                     this.c.setAdUnit(var5);
                  }
               } else {
                  this.c = var10.a(var1, var4, var6, var5);
               }

               if(this.c == null) {
                  eo.d(a, "Failed to create view for ad network: " + var12 + ", network is unsupported on Android, or no ICustomAdNetworkHandler was registered or it failed to return a view.");
                  HashMap var11 = new HashMap();
                  var11.put("errorCode", Integer.toString(com.flurry.sdk.b.p.a()));
                  if(var3 == 4) {
                     var11.put("binding_3rd_party", Integer.toString(4));
                  }

                  var4.a((com.flurry.sdk.q)(new com.flurry.sdk.q("renderFailed", var11, var1, var5, var6, 0)), (com.flurry.sdk.ad)var4.a(), 1);
               } else {
                  this.a(var1, var2, var4);
               }
            } else {
               eo.a(6, a, "failed to render banner ad, no adFrames for adspace: " + this.e() + " context: " + var1 + " viewGroup: " + var2);
            }
         }
      } else {
         eo.a(6, a, "failed to render banner ad for adspace: " + this.e() + " context: " + var1 + " viewGroup: " + var2);
      }
   }
}
