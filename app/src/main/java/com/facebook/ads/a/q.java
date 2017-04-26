package com.facebook.ads.a;

import android.content.Context;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.ImpressionListener;
import com.facebook.ads.a.b$a;
import com.facebook.ads.a.f$a;
import com.facebook.ads.a.j$b;
import com.facebook.ads.a.q$a;

public class q extends RelativeLayout implements com.facebook.ads.a.d {
   private static final String a = com.facebook.ads.a.q.class.getSimpleName();
   private final AdView b;
   private final String c;
   private final AdSize d;
   private AdListener e = null;
   private ImpressionListener f = null;
   private WebView g;
   private com.facebook.ads.a.k h;
   private com.facebook.ads.a.z i;
   private final DisplayMetrics j;
   private int k;
   private long l;
   private b$a m;

   public q(AdView var1, String var2, AdSize var3) {
      super(var1.getContext());
      if(var3 != null && var3 != AdSize.INTERSTITIAL) {
         this.b = var1;
         this.c = var2;
         this.d = var3;
         this.j = this.getContext().getResources().getDisplayMetrics();
         this.a(this.getContext());
         this.i = new com.facebook.ads.a.z(this.g, new f$a() {
            public boolean a() {
               return q.this.g();
            }

            public void b() {
               if(q.this.h != null) {
                  q.this.h.a("on imp sent");
               }

            }

            public void c() {
               if(q.this.f != null) {
                  q.this.f.onLoggingImpression(q.this.b);
               }

            }

            public boolean d() {
               return false;
            }
         }, 1000L, this.getContext());
      } else {
         throw new IllegalArgumentException("adSize");
      }
   }

   // $FF: synthetic method
   static long a(com.facebook.ads.a.q var0, long var1) {
      var0.l = var1;
      return var1;
   }

   // $FF: synthetic method
   static b$a a(com.facebook.ads.a.q var0, b$a var1) {
      var0.m = var1;
      return var1;
   }

   private void a(Context var1) {
      this.g = new WebView(var1);
      this.g.setVisibility(8);
      com.facebook.ads.a.s.a((WebView)this.g, (WebViewClient)(new q$a(this, null)), (com.facebook.ads.a.r)(new com.facebook.ads.a.r()));
      this.addView(this.g);
      this.h();
      com.facebook.ads.a.n var2;
      if(this.d == AdSize.BANNER_HEIGHT_90) {
         var2 = com.facebook.ads.a.n.d;
      } else if(this.d == AdSize.BANNER_HEIGHT_50) {
         var2 = com.facebook.ads.a.n.c;
      } else {
         var2 = com.facebook.ads.a.n.b;
      }

      this.h = new com.facebook.ads.a.k(this.getContext(), this.c, this.d, var2, true, com.facebook.ads.a.o.a, 1, this.e());
   }

   private void a(com.facebook.ads.a.y var1) {
      if(this.g != null) {
         this.g.loadUrl("about:blank");
         this.g.clearCache(true);
         this.g.setVisibility(8);
         this.l = 0L;
         this.m = null;
         this.g.loadDataWithBaseURL(com.facebook.ads.a.s.a(), var1.c(), "text/html", "utf-8", (String)null);
         this.g.setVisibility(0);
      }

   }

   // $FF: synthetic method
   static String d() {
      return a;
   }

   private j$b e() {
      return new j$b() {
         public void a(AdError var1) {
            q.this.i.c();
            if(q.this.e != null) {
               q.this.e.onError(q.this.b, var1);
            }

         }

         public void a(com.facebook.ads.a.l var1) {
            q.this.i.c();
            com.facebook.ads.a.e var2 = var1.d();
            if(var2 != null && var2 instanceof com.facebook.ads.a.y) {
               q.this.i.a((com.facebook.ads.a.y)var2);
               q.this.a((com.facebook.ads.a.y)var2);
               if(q.this.e != null) {
                  q.this.e.onAdLoaded(q.this.b);
               }

               q.this.k = var1.c();
            } else if(var2 == null) {
               if(q.this.e != null) {
                  AdListener var5 = q.this.e;
                  AdView var3 = q.this.b;
                  AdError var4;
                  if(var1.e() != null) {
                     var4 = var1.e();
                  } else {
                     var4 = AdError.INTERNAL_ERROR;
                  }

                  var5.onError(var3, var4);
               }

               if(q.this.h != null) {
                  q.this.h.a("on no fill");
                  return;
               }
            } else {
               if(q.this.e != null) {
                  q.this.e.onError(q.this.b, AdError.INTERNAL_ERROR);
               }

               if(q.this.h != null) {
                  q.this.h.a("on internal error");
                  return;
               }
            }

         }
      };
   }

   private void f() {
      if(this.h == null) {
         throw new RuntimeException("No request controller available, has the AdView been destroyed?");
      }
   }

   private boolean g() {
      int var1 = (int)Math.ceil((double)((float)this.d.getWidth() * this.j.density));
      int var2 = (int)Math.ceil((double)((float)this.d.getHeight() * this.j.density));
      return com.facebook.ads.a.p.a(this.getContext(), this, var1, var2, this.k);
   }

   private void h() {
      if(this.g != null) {
         int var1;
         if((int)((float)this.j.widthPixels / this.j.density) >= this.d.getWidth()) {
            var1 = this.j.widthPixels;
         } else {
            var1 = (int)Math.ceil((double)((float)this.d.getWidth() * this.j.density));
         }

         LayoutParams var2 = new LayoutParams(var1, (int)Math.ceil((double)((float)this.d.getHeight() * this.j.density)));
         var2.addRule(14);
         this.g.setLayoutParams(var2);
      }

   }

   public void a() {
      this.h.a();
   }

   public void b() {
      this.f();
      this.h.b();
   }

   public void c() {
      if(this.h != null) {
         this.h.c();
         this.h = null;
      }

      this.i.c();
      this.i.g();
      if(this.g != null) {
         com.facebook.ads.a.s.a(this.g);
         this.removeView(this.g);
         this.g.destroy();
         this.g = null;
      }

   }

   protected void onConfigurationChanged(Configuration var1) {
      super.onConfigurationChanged(var1);
      this.h();
   }

   protected void onWindowVisibilityChanged(int var1) {
      super.onWindowVisibilityChanged(var1);
      if(this.h != null) {
         this.h.a(var1);
      }

      if(var1 == 0) {
         this.i.b();
         if(this.l > 0L && this.m != null) {
            com.facebook.ads.a.c.a(com.facebook.ads.a.b.a(this.l, this.m));
         }

      } else {
         this.i.c();
      }
   }

   public void setAdListener(AdListener var1) {
      this.e = var1;
   }

   public void setImpressionListener(ImpressionListener var1) {
      this.f = var1;
   }
}
