package com.nexage.android;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.LinearLayout.LayoutParams;
import java.util.Timer;
import java.util.TimerTask;

public class NexageAdView extends RelativeLayout {
   private static int c = 0;
   private static int d = 0;
   private static int w = 0;
   private boolean A;
   private TimerTask B;
   private boolean C;
   private boolean D;
   private long E;
   String a;
   volatile int b;
   private com.nexage.android.a.j e;
   private final com.nexage.android.a.m f;
   private com.nexage.android.j g;
   private OnClickListener h;
   private int i;
   private View j;
   private String k;
   private Integer l;
   private Integer m;
   private boolean n;
   private Context o;
   private Integer p;
   private String q;
   private int r;
   private int s;
   private volatile boolean t;
   private int u;
   private final BroadcastReceiver v;
   private volatile com.nexage.android.a.a x;
   private volatile com.nexage.android.a.a y;
   private volatile com.nexage.android.i z;

   public NexageAdView(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public NexageAdView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.f = new com.nexage.android.f(this, (byte)0);
      this.i = 30000;
      this.j = null;
      this.k = "fade_in_out";
      this.l = null;
      this.m = null;
      this.n = true;
      this.b = 0;
      this.p = null;
      this.q = "center";
      this.t = true;
      this.u = 2;
      this.v = new com.nexage.android.h(this, (byte)0);
      this.x = null;
      this.y = null;
      this.z = null;
      if((var2 == null || var2.getAttributeCount() == 0) && !this.isInEditMode()) {
         throw new IllegalArgumentException("NexageAdView: AttributeSet cannot be empty");
      } else {
         this.a(var1, var2);
      }
   }

   public NexageAdView(String var1, Context var2) {
      super(var2, (AttributeSet)null, 0);
      this.f = new com.nexage.android.f(this, (byte)0);
      this.i = 30000;
      this.j = null;
      this.k = "fade_in_out";
      this.l = null;
      this.m = null;
      this.n = true;
      this.b = 0;
      this.p = null;
      this.q = "center";
      this.t = true;
      this.u = 2;
      this.v = new com.nexage.android.h(this, (byte)0);
      this.x = null;
      this.y = null;
      this.z = null;
      if(var1 != null && var1.length() != 0) {
         this.a = var1;
         this.a((Context)var2, (AttributeSet)null);
      } else {
         throw new IllegalArgumentException("NexageAdView: position cannot be empty");
      }
   }

   // $FF: synthetic method
   static int a(NexageAdView var0, int var1) {
      var0.u = 0;
      return 0;
   }

   // $FF: synthetic method
   static com.nexage.android.a.a a(NexageAdView var0, com.nexage.android.a.a var1) {
      var0.x = null;
      return null;
   }

   // $FF: synthetic method
   static com.nexage.android.i a(NexageAdView var0, com.nexage.android.i var1) {
      var0.z = null;
      return null;
   }

   // $FF: synthetic method
   static TimerTask a(NexageAdView var0, TimerTask var1) {
      var0.B = null;
      return null;
   }

   private void a(Context var1, AttributeSet var2) {
      com.nexage.android.a.p.b("NAV", "init");
      this.o = var1;
      com.nexage.android.b.a(var1);
      this.j = new com.nexage.android.a.q(this.o);
      if(c == 0) {
         c = (int)(320.0F * com.nexage.android.a.m.d);
         d = (int)(50.0F * com.nexage.android.a.m.d);
      }

      this.r = c;
      this.s = d;
      this.addView(this.j);
      this.setClickable(true);
      this.setLongClickable(true);
      this.setFocusable(true);
      this.setPadding(0, 0, 0, 0);
      this.setDescendantFocusability(262144);
      String var7;
      if(var2 != null) {
         var7 = "http://schemas.android.com/apk/res/" + this.o.getPackageName();
         this.a(var2.getAttributeIntValue(var7, "refreshInterval", 30000));
         String var3 = var2.getAttributeValue(var7, "cn");
         if(var3 != null && var3.length() > 0) {
            com.nexage.android.b.d(var3);
            com.nexage.android.a.p.d("cn attribute in NexageAdView is deprecated.");
            com.nexage.android.a.p.d("Please use setCn() method of NexageAdManager.");
         }

         var3 = var2.getAttributeValue(var7, "position");
         String var4 = var2.getAttributeValue(var7, "animation");
         if(!TextUtils.isEmpty(var4)) {
            if(this.isInEditMode()) {
               this.k = var4;
            } else {
               label138: {
                  if(var4 != null && var4.length() >= 2) {
                     var7 = var4;
                     if(!var4.equalsIgnoreCase("fade_in_out")) {
                        var7 = var4;
                        if(!var4.equalsIgnoreCase("slide_in_out")) {
                           var7 = var4;
                           if(!var4.equalsIgnoreCase("left_in_right_out")) {
                              var7 = var4;
                              if(!var4.equalsIgnoreCase("right_in_left_out")) {
                                 var7 = "fade_in_out";
                              }
                           }
                        }
                     }

                     this.k = var7;
                     if(((com.nexage.android.a.l)this.j).b()) {
                        ((com.nexage.android.a.l)this.j).a(this.k);
                        break label138;
                     }
                  } else {
                     this.k = null;
                     if(!((com.nexage.android.a.l)this.j).b()) {
                        break label138;
                     }
                  }

                  this.removeView(this.j);
                  View var8 = ((com.nexage.android.a.l)this.j).a();
                  if(this.k != null && !this.isInEditMode()) {
                     com.nexage.android.a.p.b("NAV", "Animation is not in edit mode and type = " + this.k);
                     this.j = new com.nexage.android.a.c(this.o);
                     ((com.nexage.android.a.l)this.j).a(this.k);
                  } else {
                     com.nexage.android.a.p.b("NAV", "Animation is in edit mode");
                     this.j = new com.nexage.android.a.q(this.o);
                  }

                  if(var8 != null) {
                     ((com.nexage.android.a.l)this.j).a(var8);
                  }

                  this.addView(this.j);
                  this.j.layout(0, 0, this.r, this.s);
                  if(this.l != null) {
                     this.j.setBackgroundColor(this.l.intValue());
                  }

                  if(this.p != null && this.p.intValue() != 0) {
                     this.j.setBackgroundResource(this.p.intValue());
                  }

                  this.j.setVisibility(super.getVisibility());
               }
            }
         }

         var7 = var2.getAttributeValue("http://schemas.android.com/apk/res/android", "textColor");
         if(var7 != null) {
            this.m = Integer.valueOf(16777215);

            try {
               if(var7.charAt(0) == 35) {
                  this.m = Integer.valueOf(com.nexage.android.a.a.b(var7.toUpperCase()));
               } else {
                  this.m = Integer.valueOf(Integer.parseInt(var7.substring(1)));
               }
            } catch (Exception var6) {
               ;
            }
         }

         var7 = var2.getAttributeValue("http://schemas.android.com/apk/res/android", "background");
         if(var7 != null) {
            try {
               if(var7.charAt(0) == 35) {
                  this.l = Integer.valueOf(-16777216);
                  this.l = Integer.valueOf(com.nexage.android.a.a.b(var7.toUpperCase()));
                  this.j.setBackgroundColor(this.l.intValue());
               } else {
                  this.p = Integer.valueOf(0);
                  this.p = Integer.valueOf(Integer.parseInt(var7.substring(1)));
                  if(this.p.intValue() != 0) {
                     this.j.setBackgroundResource(this.p.intValue());
                  }
               }
            } catch (Exception var5) {
               ;
            }
         }

         if(var3 == null) {
            var7 = "default";
            com.nexage.android.a.p.e("NAV", "position not found. Setting to \'default\'. Check that: \n1. page has nexage:position defined. \n2. position is specified as an actual value and not a @string reference\n3. page has xmlns:nexage defiled with the app package name spelled correctly");
         } else {
            var7 = var3;
         }

         this.a = var7;
         LayoutParams var9 = new LayoutParams(this.o, var2);
         if(var9.width > 1) {
            this.r = var9.width;
         }

         if(var9.height > 1) {
            this.s = var9.height;
         }

         super.setLayoutParams(var9);
         this.j.layout(0, 0, this.r, this.s);
         this.setGravity(var9.gravity);
      }

      this.j.layout(0, 0, this.r, this.s);
      var7 = this.a;
      com.nexage.android.a.p.b("NAV", "SetPosition to " + var7);
      if(this.e == null || !var7.equals(this.a)) {
         if(this.e != null) {
            this.e.b(this.f);
         }

         this.e = com.nexage.android.a.j.a(var7);
         this.a = var7;
      }

   }

   // $FF: synthetic method
   static boolean a(NexageAdView var0) {
      return var0.e();
   }

   // $FF: synthetic method
   static boolean a(NexageAdView var0, boolean var1) {
      var0.t = var1;
      return var1;
   }

   // $FF: synthetic method
   static int b(NexageAdView var0) {
      return var0.u;
   }

   private static String b(int var0) {
      switch(var0) {
      case 0:
         return "VISIBLE";
      case 4:
         return "INVISIBLE";
      case 8:
         return "GONE";
      default:
         return "UNKNOWN";
      }
   }

   // $FF: synthetic method
   static void b(final NexageAdView var0, com.nexage.android.a.a var1) {
      synchronized(var0) {
         var0.y = null;
         if(var0.x != null && var0.x != var1) {
            var0.x.g();
         }

         if(var0.A) {
            var0.x = null;
            return;
         }

         var0.x = var1;
      }

      var0.x.a(var0.r, var0.s);
      var1 = var0.x;
      Integer var3 = var0.l;
      var3 = var0.m;
      String var9 = var0.q;
      var1.j();
      var0.x.b(var0);
      var0.x.a((com.nexage.android.a.l)var0.j);
      if(((com.nexage.android.f)var0.f).b()) {
         if(var0.x == null) {
            com.nexage.android.a.p.d(var0.a, "switchView: currentAd is null");
            return;
         }

         if(!com.nexage.android.a.o.c()) {
            com.nexage.android.a.p.d(var0.a, "global ad serving is disabled, waiting to switch the view");
            return;
         }

         com.nexage.android.a.b var7 = var0.x.a((Activity)var0.o);
         if(var7 != null) {
            if(var0.h != null) {
               var7.a(var0.h, var0);
            }

            View var8 = var7.b();
            var8.setVisibility(var0.getVisibility());
            if(var0.p != null) {
               var8.setBackgroundResource(var0.p.intValue());
            }

            if(var0.l != null) {
               var8.setBackgroundColor(var0.l.intValue());
            }

            try {
               if(var0.x.f() == null) {
                  ((com.nexage.android.a.l)var0.j).a(var8);
               }
            } catch (Exception var5) {
               com.nexage.android.a.p.a("NAV", "error adding ad view", var5);
            }

            boolean var2;
            if(var8 == null) {
               var2 = true;
            } else {
               var2 = false;
            }

            try {
               var0.a(var2);
            } catch (Exception var4) {
               com.nexage.android.a.p.a("NAV", "error checking refresh timer", var4);
            }

            var0.b(false);
            if(var0.g != null) {
               ((Activity)var0.o).runOnUiThread(new Runnable() {
                  public final void run() {
                     if(var0.g != null) {
                        com.nexage.android.j var1 = var0.g;
                        NexageAdView var2 = var0;
                        var1.H();
                     }

                  }
               });
               return;
            }
         }
      }

   }

   private void b(boolean var1) {
      com.nexage.android.a.p.b("NAV", "setting isFetching to " + var1);
      this.D = var1;
   }

   // $FF: synthetic method
   static boolean b(NexageAdView var0, boolean var1) {
      var0.n = var1;
      return var1;
   }

   // $FF: synthetic method
   static int c(NexageAdView var0) {
      return var0.i;
   }

   // $FF: synthetic method
   static com.nexage.android.a.a c(NexageAdView var0, com.nexage.android.a.a var1) {
      var0.y = var1;
      return var1;
   }

   // $FF: synthetic method
   static void c(NexageAdView var0, boolean var1) {
      var0.b(false);
   }

   // $FF: synthetic method
   static TimerTask d(NexageAdView var0) {
      return var0.B;
   }

   // $FF: synthetic method
   static View e(NexageAdView var0) {
      return var0.j;
   }

   private boolean e() {
      boolean var2 = true;
      com.nexage.android.a.p.b("NAV", "visible");
      boolean var3 = this.isShown();
      boolean var1;
      if(this.getVisibility() == 0) {
         var1 = true;
      } else {
         var1 = false;
      }

      if(!this.n || !this.isShown() || this.getVisibility() != 0 || this.A) {
         var2 = false;
      }

      com.nexage.android.a.p.b("NAV", "mScreenVisible=" + this.n + ", isShown=" + var3 + ", isVisible=" + var1 + ", isDetached=" + this.A + " --> retval=" + var2);
      return var2;
   }

   // $FF: synthetic method
   static com.nexage.android.a.a f(NexageAdView var0) {
      return var0.x;
   }

   private void f() {
      com.nexage.android.a.p.b("NAV", "startFetcher");
      this.C = true;
      this.e.a(this.f);
      synchronized(this) {
         if(this.B != null) {
            this.B.cancel();
            this.B = null;
         }

         if(this.y != null) {
            com.nexage.android.a.p.b("NAV", "posting DisplayAdRunnable from startFetcher");
            this.post(new com.nexage.android.g(this, this.y));
         }

      }
   }

   // $FF: synthetic method
   static Context g(NexageAdView var0) {
      return var0.o;
   }

   // $FF: synthetic method
   static boolean i(NexageAdView var0) {
      return var0.t;
   }

   // $FF: synthetic method
   static int j(NexageAdView var0) {
      int var1 = var0.u;
      var0.u = var1 - 1;
      return var1;
   }

   // $FF: synthetic method
   static boolean k(NexageAdView var0) {
      return var0.A;
   }

   public final com.nexage.android.j a() {
      return this.g;
   }

   public final void a(int var1) {
      int var2 = var1;
      if(var1 != 0) {
         var2 = var1;
         if(var1 < 10000) {
            var2 = 10000;
         }
      }

      this.i = var2;
   }

   public final void a(com.nexage.android.j var1) {
      this.g = var1;
   }

   public final void a(boolean var1) {
      com.nexage.android.a.p.b("NAV", "checkSetRefreshTimer enter");
      if(!com.nexage.android.b.z()) {
         com.nexage.android.a.p.b("NAV", "checkSetRefreshTimer visible=" + this.e() + ", foreground=" + var1);
         if(!this.e() && var1) {
            com.nexage.android.a.p.b("NAV", "checkSetRefreshTimer not visible and in foreground, returning");
         } else if(com.nexage.android.b.y() && this.z != null) {
            com.nexage.android.a.p.b("NAV", "checkSetRefreshTimer popup in the foreground, returning");
            this.z.cancel();
            this.z = null;
         } else {
            if(var1 && com.nexage.android.a.o.c()) {
               this.c();
            }

            if(this.x == null && var1) {
               com.nexage.android.a.p.b("NAV", "checkSetRefreshTimer m_CurrentAd is null and in foreground, returning");
            } else {
               synchronized(this) {
                  com.nexage.android.a.p.b("NAV", "checkSetRefreshTimer refreshInterval=" + this.i + ", m_RefreshTask=" + this.z);
                  if(this.i > 0 && this.z == null) {
                     com.nexage.android.a.p.b("NAV", "checkSetRefreshTimer creating new RefreshTask");
                     this.z = new com.nexage.android.i(this, (byte)0);
                     (new Timer()).schedule(this.z, (long)this.i);
                  }

               }
            }
         }
      }
   }

   public final void b() {
      // $FF: Couldn't be decompiled
   }

   final void c() {
      com.nexage.android.a.p.b("NAV", "nudgeAdFetcher enter");
      long var1 = System.currentTimeMillis();
      com.nexage.android.a.p.b("NAV", "nudgeAdFetcher elapsed=" + (var1 - this.E));
      if(var1 - this.E > 2000L) {
         com.nexage.android.a.p.b("NAV", "nudgeAdFetcher wake");
         this.b(true);
         this.e.a();
         this.E = var1;
      } else {
         com.nexage.android.a.p.b("NAV", "nudgeAdFetcher ignored");
         this.a(false);
      }
   }

   public final void d() {
      com.nexage.android.a.p.b("NAV", "onDisplay");
      com.nexage.android.a.r.b();
      this.x.i();
      com.nexage.android.a.p.b("NAV", "AD displayed for pos " + this.a);
      com.nexage.android.a.p.b("NAV", "setting m_AdViewed to true");
      this.x.c = true;
   }

   protected void onAttachedToWindow() {
      com.nexage.android.a.p.b("NAV", "onAttachedToWindow");
      super.onAttachedToWindow();
      this.A = false;
      if(!this.C) {
         this.f();
      }

      IntentFilter var1 = new IntentFilter("android.intent.action.USER_PRESENT");
      var1.addAction("android.intent.action.SCREEN_OFF");
      Context var2 = this.getContext();
      com.nexage.android.a.p.b("NAV", "register mScreenReceiver " + w + " " + this.v);
      var2.registerReceiver(this.v, var1);
      ++w;
   }

   protected void onDetachedFromWindow() {
      com.nexage.android.a.p.b("NAV", "onDetachedFromWindow");
      com.nexage.android.a.o.a(true);
      this.setVisibility(8);

      try {
         super.onDetachedFromWindow();
      } catch (Exception var3) {
         com.nexage.android.a.p.b("onDetachedFromWindow exception caught");
      }

      try {
         com.nexage.android.a.p.b("NAV", "unregister mScreenReceiver " + w + " " + this.v);
         this.getContext().unregisterReceiver(this.v);
         --w;
      } catch (Exception var2) {
         ;
      }

      synchronized(this) {
         this.A = true;
         if(this.x != null && this.x.c) {
            this.x.g();
         }

         this.B = new TimerTask() {
            public final void run() {
               // $FF: Couldn't be decompiled
            }
         };
         (new Timer()).schedule(this.B, 10000L);
      }

      this.e.b(this.f);
      this.C = false;
   }

   protected void onMeasure(int var1, int var2) {
      super.onMeasure(this.r, this.s);
      this.setMeasuredDimension(this.r, this.s);
   }

   public void onWindowFocusChanged(boolean var1) {
      if(var1 && com.nexage.android.b.y()) {
         com.nexage.android.b.a(false);
      }

      super.onWindowFocusChanged(var1);
      if(var1) {
         this.a(true);
      }

   }

   protected void onWindowVisibilityChanged(int var1) {
      com.nexage.android.a.p.b("NAV", "onWindowVisibilityChanged " + b(var1));
      super.onWindowVisibilityChanged(var1);
      if(var1 == 0) {
         this.a(true);
      }

   }

   public void setBackgroundColor(int var1) {
      super.setBackgroundColor(var1);
      this.l = Integer.valueOf(var1);
      this.j.setBackgroundColor(var1);
   }

   public void setBackgroundResource(int var1) {
      super.setBackgroundResource(var1);
      this.p = Integer.valueOf(var1);
      this.j.setBackgroundResource(var1);
   }

   public void setGravity(int var1) {
      super.setGravity(var1);
      if(var1 == 3) {
         this.q = "left";
      } else {
         if(var1 == 5) {
            this.q = "right";
            return;
         }

         if(var1 == 1) {
            this.q = "center";
            return;
         }
      }

   }

   public void setLayoutParams(android.view.ViewGroup.LayoutParams var1) {
      if(var1.width > 1) {
         this.r = var1.width;
      }

      if(var1.height > 1) {
         this.s = var1.height;
      }

      super.setLayoutParams(var1);
      if(this.j != null) {
         this.j.layout(0, 0, this.r, this.s);
      }

      this.setGravity((new LayoutParams(var1)).gravity);
   }

   public void setOnClickListener(OnClickListener var1) {
      this.setClickable(true);
      this.h = var1;
   }

   public void setVisibility(int var1) {
      super.setVisibility(var1);
      int var2 = super.getVisibility();
      com.nexage.android.a.p.b("NAV", "setVisibility from " + b(var2) + " to " + b(var1));
      if(var2 != var1) {
         if(var1 == 0) {
            if(this.x != null) {
               this.a(true);
            } else {
               this.b();
            }
         }

         if(this.j != null) {
            this.j.setVisibility(var1);
         }
      }

   }
}
