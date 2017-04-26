package com.ihandysoft.ad;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.Location;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.view.animation.Animation.AnimationListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class HSAdBannerView extends RelativeLayout implements com.ihandysoft.ad.a.b {
   private Location A;
   private boolean B;
   private boolean C;
   private com.ihandysoft.ad.h D;
   private HandlerThread E;
   private Handler F;
   private Handler G;
   private com.ihandysoft.ad.e H;
   private com.ihs.a.d.d I;
   private com.ihs.a.d.d J;
   private boolean K;
   private Random a;
   private Map b;
   private List c;
   private List d;
   private int e;
   private int f;
   private Map g;
   private float h;
   private float i;
   private float j;
   private long k;
   private float l;
   private com.ihandysoft.ad.a.a m;
   private List n;
   private com.ihandysoft.ad.b o;
   private Date p;
   private Date q;
   private Date r;
   private List s;
   private List t;
   private Timer u;
   private RelativeLayout v;
   private Timer w;
   private com.ihandysoft.ad.h x;
   private int y;
   private String z;

   public HSAdBannerView(Context var1) {
      this(var1, (AttributeSet)null, 0);
   }

   public HSAdBannerView(Context var1, AttributeSet var2) {
      this(var1, var2, 0);
   }

   public HSAdBannerView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.a = new Random();
      this.b = null;
      this.c = null;
      this.d = null;
      this.e = -1;
      this.f = -1;
      this.g = null;
      this.h = 0.0F;
      this.i = 0.0F;
      this.j = 0.0F;
      this.k = 0L;
      this.l = 1.0F;
      this.m = null;
      this.n = null;
      this.p = null;
      this.q = null;
      this.r = null;
      this.s = null;
      this.t = null;
      this.I = new com.ihs.a.d.d() {
         public final void a(String var1, com.ihs.a.e.e var2) {
            HSAdBannerView.this.F.post(new Runnable() {
               public final void run() {
                  HSAdBannerView.a("Remote Config Data Changed!");
                  Map var1 = com.ihs.a.b.b.d();
                  if(var1 != null && HSAdBannerView.this.b.equals(var1.get("iHandyAds"))) {
                     HSAdBannerView.a("AdInfo in Remote Config didn\'t change.");
                  } else {
                     HSAdBannerView.a("AdInfo in Remote Config changed, reload ads.");
                     HSAdBannerView.this.g();
                  }
               }
            });
         }
      };
      this.J = new com.ihs.a.d.d() {
         public final void a(String var1, com.ihs.a.e.e var2) {
            if("hs.app.session.SESSION_START".equals(var1)) {
               HSAdBannerView.this.F.post(new Runnable() {
                  public final void run() {
                     HSAdBannerView.a("Session Start");
                     if(HSAdBannerView.this.c != null) {
                        HSAdBannerView.e(HSAdBannerView.this);
                     }

                     HSAdBannerView.this.q = null;
                     HSAdBannerView.this.r = null;
                     if(HSAdBannerView.this.p != null) {
                        HSAdBannerView.this.p = new Date();
                     }

                     if(HSAdBannerView.this.x == com.ihandysoft.ad.h.b) {
                        HSAdBannerView.this.a(true);
                     }

                  }
               });
            }

            if("hs.app.session.SESSION_END".equals(var1)) {
               HSAdBannerView.this.F.post(new Runnable() {
                  public final void run() {
                     HSAdBannerView.a("Session End");
                     HSAdBannerView.h(HSAdBannerView.this);
                     HSAdBannerView.this.b();
                  }
               });
            }

         }
      };
      this.K = true;
      this.E = new HandlerThread(this.getClass().getName());
      this.E.start();
      this.F = new Handler(this.E.getLooper());
      this.G = new Handler(Looper.getMainLooper());
      byte var6 = 50;
      if(com.ihandysoft.ad.b.a.a(var1)) {
         var6 = 90;
      }

      float var4 = var1.getResources().getDisplayMetrics().density;
      var3 = (int)((float)var6 * var4 + 0.5F);
      this.v = new RelativeLayout(var1);
      LayoutParams var5 = new LayoutParams(-1, var3);
      this.v.setLayoutParams(var5);
      this.addView(this.v);
      this.h = 15.0F;
      this.o = com.ihandysoft.ad.b.a;
      this.x = com.ihandysoft.ad.h.a;
      this.s = new ArrayList();
      this.t = new ArrayList();
      com.ihs.a.d.a.a("hs.app.session.SESSION_START", this.J);
      com.ihs.a.d.a.a("hs.app.session.SESSION_END", this.J);
   }

   // $FF: synthetic method
   static String a(HSAdBannerView var0, long var1) {
      String[] var4 = new String[]{"0-1", "1-2", "2-3", "3-4", "4-5", "5-6", "6-12", "12-18", "18-24", "24-30", "30+"};
      Integer var5;
      if(var1 >= 6000L) {
         if(var1 % 6000L > 0L) {
            var5 = Integer.valueOf((int)(var1 / 6000L) + 5);
         } else {
            var5 = Integer.valueOf((int)(var1 / 6000L) + 4);
         }
      } else if(var1 % 1000L > 0L) {
         var5 = Integer.valueOf((int)(var1 / 1000L));
      } else {
         var5 = Integer.valueOf((int)(var1 / 1000L) - 1);
      }

      Integer var3 = var5;
      if(var5.intValue() >= var4.length) {
         var3 = Integer.valueOf(var4.length - 1);
      }

      var5 = var3;
      if(var3.intValue() < 0) {
         var5 = Integer.valueOf(0);
      }

      return var4[var5.intValue()];
   }

   private static List a(Object var0) {
      if(var0 instanceof String) {
         ArrayList var1 = new ArrayList();
         var1.add((String)var0);
         return var1;
      } else {
         return var0 instanceof List?(List)var0:null;
      }
   }

   // $FF: synthetic method
   static void a(HSAdBannerView var0, int var1) {
      var0.e = 0;
   }

   // $FF: synthetic method
   static void a(HSAdBannerView var0, com.ihandysoft.ad.a.a var1) {
      var0.m = null;
   }

   // $FF: synthetic method
   static void a(HSAdBannerView var0, com.ihandysoft.ad.a.a var1, Exception var2) {
      var0.d(var1);
   }

   // $FF: synthetic method
   static void a(HSAdBannerView var0, Map var1) {
      var0.a(var1, false, 0);
   }

   // $FF: synthetic method
   static void a(HSAdBannerView var0, Timer var1) {
      var0.u = null;
   }

   // $FF: synthetic method
   static void a(String var0) {
   }

   private void a(String var1, Map var2) {
      if(var2 != null && !var2.isEmpty()) {
         HashMap var4 = new HashMap();
         com.ihandysoft.ad.i var3 = com.ihandysoft.ad.i.a(var2.get("adType"));
         var4.put(var3.name() + "_AdGroup", "AdGroup_" + this.f);
         String var5 = "iHandyAds_Banner_" + var1 + "_" + var3.name();
         if(var3 == com.ihandysoft.ad.i.b) {
            String var8 = (String)var2.get("image");
            String var6 = (String)var2.get("video");
            String[] var7;
            if(TextUtils.isEmpty(var8)) {
               if(var8.startsWith("http")) {
                  var7 = var8.split("/");
                  var6 = var7[var7.length - 1];
                  var4.put("InternalAdImageType", "UrlImage");
               } else {
                  var4.put("InternalAdImageType", "BundleImage");
                  var6 = var8;
               }

               var4.put("InternalAdImageName", var6);
            } else if(TextUtils.isEmpty(var6)) {
               if(var6.startsWith("http")) {
                  var7 = var6.split("/");
                  var6 = var7[var7.length - 1];
                  var4.put("InternalAdVideoType", "UrlVideo");
               } else {
                  var4.put("InternalAdVideoType", "BundleVideo");
               }

               var4.put("InternalAdVideoName", var6);
            }
         }

         if(var1.equals("Shown") || var1.equals("Clicked")) {
            if(this.y < 50) {
               var1 = String.valueOf(this.y);
            } else {
               var1 = "50+";
            }

            var4.put("RoundIndex", var1);
         }

         com.ihs.app.a.b.a(var5, (Map)var4);
      }
   }

   private void a(List var1) {
      if(this.p == null) {
         this.p = new Date();
      }

      this.n = this.d(this.n);
      (new StringBuilder(">> preloadList<?> = ")).append(this.n).toString();
      var1 = this.d(var1);
      if(this.c == null || !this.c.equals(var1)) {
         this.c = var1;
         if(this.c != null && !this.c.isEmpty() || this.n != null && !this.n.isEmpty()) {
            ArrayList var6 = new ArrayList(this.c.size());

            for(int var2 = 0; var2 < this.c.size(); ++var2) {
               Map var3 = (Map)this.c.get(var2);
               HashMap var4 = new HashMap(var3);
               var4.put("adName", com.ihandysoft.ad.i.a(var3.get("adType")).name());
               var4.put("maxCPM", var4.get("cpm"));
               var4.put("preload", Boolean.FALSE);
               var4.put("originalIndex", Integer.valueOf(var2));
               var6.add(var4);
            }

            this.d = var6;
            this.b(this.d);
            this.e = 0;
            (new StringBuilder(">> adItemList<?> = ")).append(this.c).toString();
            this.a(true);
            return;
         }

         Iterator var5 = this.t.iterator();

         while(var5.hasNext()) {
            ((com.ihandysoft.ad.a.a)var5.next()).r();
         }

         this.t.clear();
         if(this.u != null) {
            this.u.cancel();
            this.u = null;
            return;
         }
      }

   }

   private void a(Map var1) {
      if(var1 != null && !var1.isEmpty()) {
         (new StringBuilder("Load ads with info = ")).append(this.b).toString();
         if(var1.containsKey("adTimeInterval") && com.ihandysoft.ad.b.b.b(var1.get("adTimeInterval")) > 0.0F) {
            this.h = com.ihandysoft.ad.b.b.b(var1.get("adTimeInterval"));
         }

         if(var1.containsKey("loadDelay")) {
            Object var5 = var1.get("loadDelay");
            long var3;
            if(var5 == null) {
               var3 = 0L;
            } else if(var5 instanceof String) {
               var3 = Long.parseLong((String)var5);
            } else if(var5 instanceof Number) {
               var3 = ((Number)var5).longValue();
            } else {
               if(!(var5 instanceof Boolean)) {
                  throw new IllegalArgumentException();
               }

               byte var2;
               if(((Boolean)var5).booleanValue()) {
                  var2 = 1;
               } else {
                  var2 = 0;
               }

               var3 = (long)var2;
            }

            this.k = var3 * 1000L;
         }

         if(var1.containsKey("cpmIncreaseRate")) {
            this.i = com.ihandysoft.ad.b.b.b(var1.get("cpmIncreaseRate"));
         }

         if(var1.containsKey("cpmDecreaseRate")) {
            this.j = com.ihandysoft.ad.b.b.b(var1.get("cpmDecreaseRate"));
         }

         if(!var1.containsKey("queueJumpingRatio")) {
            this.l = 2.0F;
         } else {
            this.l = com.ihandysoft.ad.b.b.b(var1.get("queueJumpingRatio"));
         }

         if(this.m != null) {
            this.m.A();
         }

         List var6 = (List)var1.get("preloadList");
         ArrayList var8 = new ArrayList(var6.size());
         Iterator var9 = var6.iterator();

         while(var9.hasNext()) {
            HashMap var7 = new HashMap((Map)var9.next());
            var7.put("maxCPM", var7.get("cpm"));
            var7.put("preload", Boolean.TRUE);
            var8.add(var7);
         }

         this.n = var8;
         if(var1.containsKey("adTransitionStyle")) {
            this.o = com.ihandysoft.ad.b.a(com.ihandysoft.ad.b.b.a(var1.get("adTransitionStyle")));
         }

         this.a((List)var1.get("adItemList"));
      }
   }

   private void a(Map var1, boolean var2, int var3) {
      SharedPreferences var12 = this.getContext().getSharedPreferences("HSAd", 0);
      com.ihandysoft.ad.a.a var11 = com.ihandysoft.ad.a.a.a(var1, this.getContext());
      if(var11 == null) {
         b("<HSAd> Load %s Ad failed", new Object[]{var1.get("adType")});
         this.d(var11);
      } else {
         b("<HSAd> Load %s Ad", new Object[]{var11.b()});
         var11.a((com.ihandysoft.ad.a.b)this);
         var11.a(var2);
         if(var11.f()) {
            var11.a(var3);
         }

         if(this.z != null) {
            var11.a(this.z);
         } else if(var1.containsKey("keywords")) {
            var11.a((String)var1.get("keywords"));
         }

         if(!var11.l()) {
            String var13 = var12.getString("AdUserDefaultsLocationLatitudeKey", (String)null);
            String var14 = var12.getString("AdUserDefaultsLocationLongitudeKey", (String)null);
            if(var13 != null && var14 != null) {
               double var4 = Double.parseDouble(var13);
               double var6 = Double.parseDouble(var14);
               b("Location is %lf,%lf", new Object[]{Double.valueOf(var4), Double.valueOf(var6)});
               this.A = new Location("");
               this.A.setLatitude(var4);
               this.A.setLongitude(var6);
               this.A.setTime(System.currentTimeMillis());
            }

            var11.a(this.A);
         }

         NetworkInfo var17 = ((ConnectivityManager)this.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
         boolean var15;
         if(var17 != null && var17.isConnected()) {
            var15 = true;
         } else {
            var15 = false;
         }

         if(!var15 && var11.c() != com.ihandysoft.ad.i.b) {
            b("<HSAd> Load %s Ad failed", new Object[]{var11.b()});
            this.d(var11);
            return;
         }

         if(var11.d() == com.ihandysoft.ad.g.b && var17.getType() != 1) {
            b("<HSAd> Load %s Ad failed", new Object[]{var11.b()});
            this.d(var11);
            return;
         }

         if(var11.d() == com.ihandysoft.ad.g.c && var17.getType() != 0) {
            b("<HSAd> Load %s Ad failed", new Object[]{var11.b()});
            this.d(var11);
            return;
         }

         float var8;
         label79: {
            var3 = var11.c().ordinal();
            if(this.g != null && this.g.containsKey(Integer.valueOf(var3))) {
               Map var18 = (Map)this.g.get(Integer.valueOf(var3));
               if(var18.containsKey("periodByHour")) {
                  var8 = com.ihandysoft.ad.b.b.b(var18.get("periodByHour"));
                  break label79;
               }
            }

            var8 = 0.0F;
         }

         if(var8 > 0.0F) {
            long var9 = var12.getLong(com.ihandysoft.ad.f.a(var3), 0L);
            if((float)(System.currentTimeMillis() - var9) < var8 * 3600.0F * 1000.0F) {
               b("<HSAd> Load %s Ad failed", new Object[]{var11.b()});
               this.d(var11);
               return;
            }
         }

         Iterator var16 = this.t.iterator();

         label72: {
            while(var16.hasNext()) {
               if(((com.ihandysoft.ad.a.a)var16.next()).a(var1)) {
                  b("!!! %s Ad is already loading. Cancel.", new Object[]{var11.b()});
                  var15 = true;
                  break label72;
               }
            }

            var15 = false;
         }

         if(!var15) {
            this.t.add(var11);
         }

         if(!var15) {
            this.a("Requested", var1);
            var11.q();
            return;
         }
      }

   }

   private static boolean a(String var0, List var1, List var2) {
      boolean var3;
      label36: {
         if(var2 != null) {
            Iterator var6 = var2.iterator();

            while(var6.hasNext()) {
               if(var0.startsWith((String)var6.next())) {
                  var3 = true;
                  break label36;
               }
            }
         }

         var3 = false;
      }

      boolean var4 = var3;
      if(!var3) {
         var4 = var3;
         if(var1 != null) {
            Iterator var5 = var1.iterator();

            while(var5.hasNext()) {
               if(var0.startsWith((String)var5.next())) {
                  return false;
               }
            }

            var4 = true;
         }
      }

      return var4;
   }

   // $FF: synthetic method
   static void b(HSAdBannerView var0, com.ihandysoft.ad.a.a var1) {
      if(var0.w != null) {
         var0.w.cancel();
      }

      var0.w = null;
      if(var0.m != null && !var0.m.C()) {
         var0.s.add(var0.m);
         var0.m = var1;
         var0.s.remove(var1);
         var0.c(var0.s);
      } else {
         if(var0.m != null) {
            var0.m.r();
         }

         var0.m = var1;
         var0.s.remove(var1);
      }
   }

   // $FF: synthetic method
   static void b(HSAdBannerView var0, Timer var1) {
      var0.w = null;
   }

   private static void b(String var0, Object... var1) {
      String.format(Locale.US, var0, var1);
   }

   private void b(List var1) {
      Collections.sort(var1, new com.ihandysoft.ad.d(this, (byte)0));
   }

   private static boolean b(View var0, View var1) {
      for(ViewParent var2 = (ViewParent)var0; var2 != null && var2.getParent() != null; var2 = var2.getParent()) {
         if(var2.getParent() == var1) {
            return true;
         }
      }

      return false;
   }

   private float c(com.ihandysoft.ad.a.a var1) {
      float var2 = this.h;
      if(var1 != null) {
         float var3 = var1.i();
         var2 = var3;
         if(var3 <= 0.0F) {
            var2 = this.h;
         }
      }

      return var2;
   }

   // $FF: synthetic method
   static void c(HSAdBannerView var0, com.ihandysoft.ad.a.a var1) {
      var0.a(var1.o(), true, var1.k() + 1);
   }

   private void c(List var1) {
      Collections.sort(var1, new com.ihandysoft.ad.c(this, (byte)0));
   }

   private List d(List var1) {
      if(var1 == null) {
         return new ArrayList();
      } else {
         String var3 = this.getContext().getResources().getConfiguration().locale.toString();
         (new StringBuilder("locale = ")).append(var3).toString();
         String var4 = VERSION.RELEASE;
         int var2 = VERSION.SDK_INT;
         (new StringBuilder("currentSystemVersion = ")).append(var4).append("  ").append(var2).toString();
         String var5 = Build.MODEL;
         (new StringBuilder("currentDeviceModel = ")).append(var5).toString();
         ArrayList var6 = new ArrayList(var1.size());
         Iterator var16 = var1.iterator();

         while(true) {
            while(true) {
               Map var7;
               com.ihandysoft.ad.i var8;
               List var10;
               List var11;
               List var12;
               List var13;
               List var14;
               List var15;
               do {
                  do {
                     do {
                        do {
                           do {
                              do {
                                 do {
                                    if(!var16.hasNext()) {
                                       return var6;
                                    }

                                    var7 = (Map)var16.next();
                                    var8 = com.ihandysoft.ad.i.a(var7.get("adType"));
                                    String var9 = (String)var7.get("urlSchemeException");
                                    var10 = a(var7.get("regionFilter"));
                                    var11 = a(var7.get("regionException"));
                                    var12 = a(var7.get("osVersionFilter"));
                                    var13 = a(var7.get("osVersionException"));
                                    var14 = a(var7.get("deviceFilter"));
                                    var15 = a(var7.get("deviceException"));
                                    (new StringBuilder("urlSchemeException = ")).append(var9).toString();
                                    (new StringBuilder("regionFilter = ")).append(var10).toString();
                                    (new StringBuilder("regionException = ")).append(var11).toString();
                                    (new StringBuilder("osVersionFilter = ")).append(var12).toString();
                                    (new StringBuilder("osVersionException = ")).append(var13).toString();
                                    (new StringBuilder("deviceFilter = ")).append(var14).toString();
                                    (new StringBuilder("deviceException = ")).append(var15).toString();
                                 } while(var8 == com.ihandysoft.ad.i.a);
                              } while(!var7.containsKey("cpm"));
                           } while(com.ihandysoft.ad.b.b.b(var7.get("cpm")) < 0.0F);
                        } while(var8.a() == null);
                     } while(var8 == com.ihandysoft.ad.i.c);
                  } while(var2 < var8.b());
               } while(a(var5, var14, var15));

               if(var10 != null && !var10.contains(var3)) {
                  b("DELETE AD: current region(%s) doesn\'t match filter(%s)", new Object[]{var3, var10.toString()});
               } else if(var11 != null && var11.contains(var3)) {
                  b("DELETE AD: current region(%s) does match exception(%s)", new Object[]{var3, var11.toString()});
               } else if(a(var4, var12, var13)) {
                  b("DELETE AD: system version(%s) is excluded by filter/exception", new Object[]{var4});
               } else {
                  var6.add(var7);
               }
            }
         }
      }
   }

   private void d(com.ihandysoft.ad.a.a var1) {
      if(!b((View)var1.n(), (View)this)) {
         var1.r();
         boolean var2;
         if(!var1.e() && !var1.f()) {
            var2 = true;
         } else {
            var2 = false;
         }

         this.t.remove(var1);
         if(var2) {
            ++this.e;
            if(this.e < this.d.size()) {
               final Map var3 = (Map)this.d.get(this.e);
               if(this.m == null || this.m.C() || com.ihandysoft.ad.b.b.b(var3.get("cpm")) >= this.m.g()) {
                  this.F.post(new Runnable() {
                     public final void run() {
                        HSAdBannerView.a(HSAdBannerView.this, var3);
                     }
                  });
                  return;
               }
            }

            this.e = 0;
         }

         if(this.t.isEmpty() && this.s.isEmpty() && this.u == null) {
            this.u = new Timer();
            this.u.schedule(new TimerTask() {
               public final void run() {
                  HSAdBannerView.this.F.post(new Runnable() {
                     public final void run() {
                        HSAdBannerView.this.h();
                     }
                  });
               }
            }, (long)(this.f() * 1000.0F));
            return;
         }
      }

   }

   // $FF: synthetic method
   static void e(HSAdBannerView var0) {
      Iterator var2 = var0.t.iterator();

      while(var2.hasNext()) {
         ((com.ihandysoft.ad.a.a)var2.next()).r();
      }

      var0.t.clear();
      var2 = var0.s.iterator();

      while(var2.hasNext()) {
         ((com.ihandysoft.ad.a.a)var2.next()).r();
      }

      var0.s.clear();
      if(var0.u != null) {
         var0.u.cancel();
         var0.u.purge();
         var0.u = null;
      }

      ArrayList var5 = new ArrayList(var0.c.size());

      for(int var1 = 0; var1 < var0.c.size(); ++var1) {
         Map var3 = (Map)var0.c.get(var1);
         HashMap var4 = new HashMap(var3);
         var4.put("adName", com.ihandysoft.ad.i.a(var3.get("adType")).name());
         var4.put("maxCPM", var4.get("cpm"));
         var4.put("preload", Boolean.FALSE);
         var4.put("originalIndex", Integer.valueOf(var1));
         var5.add(var4);
      }

      var0.d = var5;
      var0.b(var0.d);
      var0.e = 0;
      var0.y = 0;
      if(var0.C) {
         var0.g();
      } else {
         var0.a(var0.c);
      }
   }

   private float f() {
      return this.c(this.m);
   }

   private void g() {
      int var2 = 0;
      this.b = (Map)com.ihs.a.b.b.d().get("iHandyAds");
      if(this.b != null) {
         this.g = (Map)this.b.get("frequencyCaps");
         List var4 = (List)this.b.get("adGroups");
         if(var4 != null && var4.size() > 0) {
            if(var4.size() == 1) {
               this.f = 0;
               this.a((Map)var4.get(0));
            } else {
               Iterator var5 = var4.iterator();

               int var1;
               for(var1 = 0; var5.hasNext(); var1 += com.ihandysoft.ad.b.b.a(((Map)var5.next()).get("weight"))) {
                  ;
               }

               int var3;
               for(var1 = this.a.nextInt(var1); var2 < var4.size(); var1 -= var3) {
                  Map var6 = (Map)var4.get(var2);
                  var3 = com.ihandysoft.ad.b.b.a(var6.get("weight"));
                  if(var1 < var3) {
                     (new StringBuilder("There are multiple groups. Choose Ad Group ")).append(var2).toString();
                     this.f = var2;
                     this.a(var6);
                     break;
                  }

                  ++var2;
               }
            }
         }
      }

      this.G.post(new Runnable() {
         public final void run() {
            com.ihs.a.d.a.a("hs.commons.config.CONFIG_CHANGED", HSAdBannerView.this.I);
         }
      });
   }

   private void h() {
      if(this.u != null) {
         this.u.cancel();
         this.u = null;
      }

      float var1 = this.f();
      if(this.s.isEmpty()) {
         if(this.w == null && this.m != null) {
            this.w = new Timer();
            this.w.schedule(new TimerTask() {
               public final void run() {
                  HSAdBannerView.this.F.post(new Runnable() {
                     public final void run() {
                        if(HSAdBannerView.this.m != null) {
                           HSAdBannerView.v(HSAdBannerView.this);
                        } else if(HSAdBannerView.this.w != null) {
                           HSAdBannerView.this.w.cancel();
                           HSAdBannerView.b((HSAdBannerView)HSAdBannerView.this, (Timer)null);
                           return;
                        }

                     }
                  });
               }
            }, (long)(var1 * 1000.0F), (long)(var1 * 1000.0F));
         }

         this.k();
      } else {
         if(this.w != null) {
            this.w.cancel();
            this.w = null;
         }

         final com.ihandysoft.ad.a.a var2 = (com.ihandysoft.ad.a.a)this.s.get(0);
         b("<HSAd> Ad (%s) with cpm %f Available.", new Object[]{var2.b(), Float.valueOf(var2.g())});
         if(this.m != null) {
            b("<HSAd> Current Ad (%s) with cpm %f", new Object[]{this.m.b(), Float.valueOf(this.m.g())});
         }

         if(this.m == null || var2.g() >= this.m.g() || this.m.j() > this.m.k() || this.m.z()) {
            final View var3 = var2.n();
            if(var3 == null) {
               this.s.remove(var2);
            } else {
               final com.ihandysoft.ad.b var4 = this.o;
               final Runnable var5 = new Runnable() {
                  public final void run() {
                     com.ihandysoft.ad.i var4 = var2.c();
                     HSAdBannerView var3 = HSAdBannerView.this;
                     var3.y = var3.y + 1;
                     HSAdBannerView.this.a("Shown", var2.o());
                     long var1;
                     String var5;
                     if(HSAdBannerView.this.q == null) {
                        HSAdBannerView.this.q = new Date();
                        var1 = (HSAdBannerView.this.q.getTime() - HSAdBannerView.this.p.getTime()) / 1000L;
                        if(var1 < 20L) {
                           var5 = String.valueOf(var1);
                        } else {
                           var5 = "20+";
                        }

                        com.ihs.app.a.b.a("iHandyAds_LaunchToFirstAdDisplay_Interval", new String[]{"Interval", var5});
                     }

                     if(HSAdBannerView.this.m != null && HSAdBannerView.this.r != null) {
                        var1 = (System.currentTimeMillis() - HSAdBannerView.this.r.getTime()) / 1000L;
                        if(var1 < 200L) {
                           var5 = String.valueOf(var1);
                        } else {
                           var5 = "200+";
                        }

                        com.ihs.app.a.b.a(String.format(Locale.US, "iHandyAds_Banner_DisplayTime_%s", new Object[]{HSAdBannerView.this.m.b()}), new String[]{"DisplayTime", var5});
                     }

                     HSAdBannerView.this.r = new Date();
                     Editor var6 = HSAdBannerView.this.getContext().getSharedPreferences("HSAd", 0).edit();
                     var6.putLong(com.ihandysoft.ad.f.a(var4.ordinal()), HSAdBannerView.this.r.getTime());
                     var6.commit();
                     HSAdBannerView.b(HSAdBannerView.this, var2);
                  }
               };
               this.G.post(new Runnable() {
                  public final void run() {
                     if(HSAdBannerView.b((View)var3, (View)HSAdBannerView.this.v)) {
                        HSAdBannerView.this.v.removeView(var3);
                        HSAdBannerView.this.v.addView(var3);
                        HSAdBannerView.t(HSAdBannerView.this);
                        HSAdBannerView.this.F.post(var5);
                     } else {
                        LayoutParams var1;
                        if(var4 == com.ihandysoft.ad.b.e) {
                           var1 = new LayoutParams(-2, -2);
                           var1.addRule(12);
                           var1.addRule(14);
                           var3.setLayoutParams(var1);
                           HSAdBannerView.this.v.removeAllViews();
                           HSAdBannerView.this.v.addView(var3);
                           HSAdBannerView.this.F.post(var5);
                           return;
                        }

                        var1 = new LayoutParams(-2, -2);
                        var1.addRule(12);
                        var1.addRule(14);
                        var3.setLayoutParams(var1);
                        HSAdBannerView.this.v.addView(var3);
                        if(HSAdBannerView.this.v.getChildCount() > 1) {
                           View var2 = HSAdBannerView.this.v.getChildAt(HSAdBannerView.this.v.getChildCount() - 2);
                           TranslateAnimation var3x = new TranslateAnimation(0.0F, (float)(-HSAdBannerView.this.v.getWidth()), 0.0F, 0.0F);
                           var3x.setDuration(500L);
                           var2.startAnimation(var3x);
                           TranslateAnimation var4x = new TranslateAnimation((float)HSAdBannerView.this.v.getWidth(), 0.0F, 0.0F, 0.0F);
                           var4x.setDuration(500L);
                           var3.startAnimation(var4x);
                           var3x.setAnimationListener(new AnimationListener() {
                              // $FF: synthetic method
                              static <undefinedtype> a(Object var0) {
                                 return <VAR_NAMELESS_ENCLOSURE>;
                              }

                              public final void onAnimationEnd(Animation var1) {
                                 HSAdBannerView.this.G.post(new Runnable() {
                                    public final void run() {
                                       HSAdBannerView.a("Transition Completed");
                                       HSAdBannerView.t(HSAdBannerView.this);
                                       HSAdBannerView.this.F.post(var5);
                                    }
                                 });
                              }

                              public final void onAnimationRepeat(Animation var1) {
                              }

                              public final void onAnimationStart(Animation var1) {
                              }
                           });
                           return;
                        }

                        HSAdBannerView.this.F.post(var5);
                        if(HSAdBannerView.this.H != null) {
                           HSAdBannerView.this.H;
                           return;
                        }
                     }

                  }
               });
            }

            var1 = this.c(var2);
         }

         this.u = new Timer();
         this.u.schedule(new TimerTask() {
            public final void run() {
               HSAdBannerView.this.F.post(new Runnable() {
                  public final void run() {
                     HSAdBannerView.this.i();
                  }
               });
            }
         }, (long)(var1 * 1000.0F));
      }
   }

   // $FF: synthetic method
   static void h(HSAdBannerView var0) {
      if(var0.s.size() > 0) {
         int var1 = var0.s.size();
         HashMap var3 = new HashMap();
         Iterator var4 = var0.s.iterator();

         while(var4.hasNext()) {
            com.ihandysoft.ad.a.a var5 = (com.ihandysoft.ad.a.a)var4.next();
            if(var3.containsKey(var5.b())) {
               int var2 = com.ihandysoft.ad.b.b.a(var3.get(var5.b()));
               var3.put(var5.b(), String.valueOf(var2 + 1));
            } else {
               var3.put(var5.b(), String.valueOf(1));
            }
         }

         var3.put("Total", String.valueOf(var1));
         var3.put("totalRound", String.valueOf(var0.y));
         com.ihs.app.a.b.a("iHandyAd_AdWasted", (Map)var3);
      }

   }

   private void i() {
      if(this.m != null) {
         this.j();
         this.m.B();
         if(!this.s.isEmpty() && this.m.j() > this.m.k()) {
            this.F.post(new Runnable() {
               public final void run() {
                  HSAdBannerView.c(HSAdBannerView.this, HSAdBannerView.this.m);
               }
            });
         }
      }

      this.h();
   }

   private void j() {
      float var1;
      float var2;
      float var3;
      for(int var4 = 0; var4 < this.d.size(); ++var4) {
         Map var5;
         label61: {
            var5 = (Map)this.d.get(var4);
            var2 = com.ihandysoft.ad.b.b.b(var5.get("cpm"));
            if(this.m != null) {
               var1 = var2;
               if(var5 == this.m.o()) {
                  break label61;
               }
            }

            if(var5.containsKey("cpmIncreaseRate")) {
               var1 = com.ihandysoft.ad.b.b.b(var5.get("cpmIncreaseRate"));
            } else {
               var1 = this.i;
            }

            var2 *= var1 + 1.0F;
            var3 = com.ihandysoft.ad.b.b.b(var5.get("maxCPM"));
            var1 = var2;
            if(var2 > var3) {
               var1 = var3;
            }
         }

         var5.put("cpm", Float.valueOf(var1));
      }

      Map var6;
      for(Iterator var7 = this.n.iterator(); var7.hasNext(); var6.put("cpm", Float.valueOf(var1))) {
         var6 = (Map)var7.next();
         var2 = com.ihandysoft.ad.b.b.b(var6.get("cpm"));
         if(this.m != null) {
            var1 = var2;
            if(var6 == this.m.o()) {
               continue;
            }
         }

         if(var6.containsKey("cpmIncreaseRate")) {
            var1 = com.ihandysoft.ad.b.b.b(var6.get("cpmIncreaseRate"));
         } else {
            var1 = this.i;
         }

         var2 *= var1 + 1.0F;
         var3 = com.ihandysoft.ad.b.b.b(var6.get("maxCPM"));
         var1 = var2;
         if(var2 > var3) {
            var1 = var3;
         }
      }

      if(this.m != null) {
         var2 = this.m.g();
         if(this.m.o().containsKey("cpmDecreaseRate")) {
            var1 = this.m.h();
         } else {
            var1 = this.j;
         }

         this.m.o().put("cpm", Float.valueOf((1.0F - var1) * var2));
      }

      this.c(this.s);
   }

   private void k() {
      ArrayList var6 = new ArrayList(this.n);
      if(this.d.size() > 0 && this.e == 0) {
         this.b(this.d);
         var6.add((Map)this.d.get(this.e));
      }

      Iterator var8 = var6.iterator();
      boolean var1 = false;
      long var2 = 0L;

      while(true) {
         final Map var7;
         do {
            if(!var8.hasNext()) {
               if(!var1 && this.u == null) {
                  this.u = new Timer();
                  this.u.schedule(new TimerTask() {
                     public final void run() {
                        HSAdBannerView.this.F.post(new Runnable() {
                           public final void run() {
                              HSAdBannerView.this.h();
                           }
                        });
                     }
                  }, (long)(this.f() * 1000.0F));
               }

               return;
            }

            var7 = (Map)var8.next();
         } while(this.m != null && !this.m.z() && com.ihandysoft.ad.b.b.b(var7.get("cpm")) < this.m.g());

         long var4 = this.k;
         this.F.postDelayed(new Runnable() {
            public final void run() {
               HSAdBannerView.a(HSAdBannerView.this, var7);
            }
         }, var2);
         var2 += var4;
         var1 = true;
      }
   }

   // $FF: synthetic method
   static void t(HSAdBannerView var0) {
      while(var0.v.getChildCount() > 1) {
         View var1 = var0.v.getChildAt(0);
         var0.v.removeView(var1);
      }

   }

   // $FF: synthetic method
   static void v(HSAdBannerView var0) {
      var0.j();
      var0.m.B();
   }

   public final void a() {
      if(this.K) {
         this.K = false;
         this.F.post(new Runnable() {
            public final void run() {
               HSAdBannerView.this.g();
            }
         });
      }

   }

   public final void a(final com.ihandysoft.ad.a.a var1) {
      this.F.post(new Runnable() {
         public final void run() {
            if(var1 != null && !var1.s() && HSAdBannerView.this.m != var1 && !HSAdBannerView.this.s.contains(var1)) {
               HSAdBannerView.this.a("Loaded", var1.o());
               long var2 = System.currentTimeMillis();
               long var4 = var1.m().getTime();
               com.ihs.app.a.b.a(String.format(Locale.US, "iHandyAds_%s_ReturnSuccess_Seconds", new Object[]{var1.b()}), new String[]{"BySeconds", HSAdBannerView.a(HSAdBannerView.this, var2 - var4), null});
               HSAdBannerView.b("<HSAd> Load %s Ad Successfully!", new Object[]{var1.b()});
               if(!var1.e() && !var1.f()) {
                  HSAdBannerView.a(HSAdBannerView.this, 0);
               }

               HSAdBannerView.this.s.add(var1);
               HSAdBannerView.this.c(HSAdBannerView.this.s);
               HSAdBannerView.this.t.remove(var1);
               if(HSAdBannerView.this.x == com.ihandysoft.ad.h.c) {
                  if(HSAdBannerView.this.m == null || HSAdBannerView.this.m.C()) {
                     HSAdBannerView.this.h();
                     return;
                  }

                  float var1x = var1.g();
                  if(HSAdBannerView.this.l <= 1.0F) {
                     if(var1x > HSAdBannerView.this.m.g()) {
                        HSAdBannerView.a("<HSAd> New loaded Ad is much better. Jump the queue!");
                        HSAdBannerView.this.h();
                        return;
                     }
                  } else if(var1x >= HSAdBannerView.this.m.g() * HSAdBannerView.this.l) {
                     HSAdBannerView.a("<HSAd> New loaded Ad is much better. Jump the queue!");
                     HSAdBannerView.this.h();
                     return;
                  }
               }
            }

         }
      });
   }

   public final void a(final com.ihandysoft.ad.a.a var1, final Exception var2) {
      this.F.post(new Runnable() {
         public final void run() {
            if(var1 != null && !var1.s() && HSAdBannerView.this.m != var1 && !HSAdBannerView.this.s.contains(var1)) {
               HSAdBannerView.b("<HSAd> Load %s Ad Failed with Error: %s", new Object[]{var1.b(), var2});
               long var1x = System.currentTimeMillis();
               long var3 = var1.m().getTime();
               com.ihs.app.a.b.a(String.format(Locale.US, "iHandyAds_%s_ReturnFailure_Seconds", new Object[]{var1.b()}), new String[]{"BySeconds", HSAdBannerView.a(HSAdBannerView.this, var1x - var3), null});
               HSAdBannerView.a(HSAdBannerView.this, var1, var2);
            }
         }
      });
   }

   public final void a(boolean var1) {
      if(this.x == com.ihandysoft.ad.h.c) {
         if(!var1) {
            return;
         }
      } else {
         StringBuilder var3 = new StringBuilder("<HSAd> Play Ads");
         String var2;
         if(var1) {
            var2 = " Immediately";
         } else {
            var2 = "";
         }

         var3.append(var2).toString();
         this.x = com.ihandysoft.ad.h.c;
      }

      if(this.u != null) {
         this.u.cancel();
         this.u = null;
      }

      if(this.m != null) {
         if(var1) {
            this.i();
         } else {
            this.u = new Timer();
            this.u.schedule(new TimerTask() {
               public final void run() {
                  HSAdBannerView.this.F.post(new Runnable() {
                     public final void run() {
                        HSAdBannerView.this.i();
                     }
                  });
               }
            }, (long)(this.f() * 1000.0F));
         }
      } else {
         this.h();
      }
   }

   public final void b() {
      if(this.x == com.ihandysoft.ad.h.c) {
         this.x = com.ihandysoft.ad.h.b;
         if(this.u != null) {
            this.u.cancel();
            this.u = null;
         }

         if(this.w != null) {
            this.w.cancel();
            this.w = null;
            return;
         }
      }

   }

   public final void b(final com.ihandysoft.ad.a.a var1) {
      this.F.post(new Runnable() {
         public final void run() {
            HSAdBannerView.this.b();
            if(HSAdBannerView.this.q != null && HSAdBannerView.this.r != null) {
               long var3 = System.currentTimeMillis();
               long var1x = (var3 - HSAdBannerView.this.q.getTime()) / 1000L;
               var3 = (var3 - HSAdBannerView.this.r.getTime()) / 1000L;
               com.ihs.app.a.b.a("iHandyAds_FirstAdLoadedToClick_Interval", new String[]{"Interval", String.valueOf(var1x)});
               com.ihs.app.a.b.a("iHandyAds_CurrentAdLoadedToClick_Interval", new String[]{"Interval", String.valueOf(var3)});
            }

            HSAdBannerView.this.a("Clicked", var1.o());
            HSAdBannerView.this.r = null;
         }
      });
   }

   public final void c() {
      this.F.post(new Runnable() {
         public final void run() {
            HSAdBannerView.this.a(false);
         }
      });
   }

   public final void d() {
      this.F.post(new Runnable() {
         public final void run() {
            if(!HSAdBannerView.this.B) {
               HSAdBannerView.this.a(true);
            } else {
               HSAdBannerView.this.x = com.ihandysoft.ad.h.c;
            }
         }
      });
   }

   public final void e() {
      com.ihs.a.d.a.a(this.J);
      com.ihs.a.d.a.b("hs.commons.config.CONFIG_CHANGED", this.I);
      this.F.post(new Runnable() {
         public final void run() {
            HSAdBannerView.h(HSAdBannerView.this);
            if(HSAdBannerView.this.u != null) {
               HSAdBannerView.this.u.cancel();
               HSAdBannerView.a((HSAdBannerView)HSAdBannerView.this, (Timer)null);
            }

            if(HSAdBannerView.this.w != null) {
               HSAdBannerView.this.w.cancel();
               HSAdBannerView.b((HSAdBannerView)HSAdBannerView.this, (Timer)null);
            }

            Iterator var1 = HSAdBannerView.this.t.iterator();

            while(var1.hasNext()) {
               ((com.ihandysoft.ad.a.a)var1.next()).r();
            }

            var1 = HSAdBannerView.this.s.iterator();

            while(var1.hasNext()) {
               ((com.ihandysoft.ad.a.a)var1.next()).r();
            }

            HSAdBannerView.this.t.clear();
            HSAdBannerView.this.s.clear();
            if(HSAdBannerView.this.m != null) {
               HSAdBannerView.this.m.r();
               HSAdBannerView.a((HSAdBannerView)HSAdBannerView.this, (com.ihandysoft.ad.a.a)null);
            }

            HSAdBannerView.this.F.removeCallbacksAndMessages((Object)null);
            HSAdBannerView.this.F.getLooper().quit();
         }
      });
   }

   protected void onVisibilityChanged(View var1, final int var2) {
      this.F.post(new Runnable() {
         public final void run() {
            if(var2 != 0 && !HSAdBannerView.this.B) {
               HSAdBannerView.a("HSAdBannerView:banner become invisible");
               HSAdBannerView.this.B = true;
               HSAdBannerView.this.D = HSAdBannerView.this.x;
               HSAdBannerView.this.b();
            } else if(var2 == 0 && HSAdBannerView.this.B) {
               HSAdBannerView.a("HSAdBannerView:banner become visible");
               HSAdBannerView.this.B = false;
               if(HSAdBannerView.this.D == com.ihandysoft.ad.h.c) {
                  HSAdBannerView.this.a(true);
                  return;
               }

               if(HSAdBannerView.this.x == com.ihandysoft.ad.h.b && HSAdBannerView.this.m != null) {
                  HSAdBannerView.this.a(true);
                  return;
               }
            }

         }
      });
      super.onVisibilityChanged(var1, var2);
   }

   protected void onWindowVisibilityChanged(final int var1) {
      this.F.post(new Runnable() {
         public final void run() {
            if(var1 != 0 && !HSAdBannerView.this.B) {
               HSAdBannerView.a("HSAdBannerView:banner become invisible");
               HSAdBannerView.this.B = true;
               HSAdBannerView.this.D = HSAdBannerView.this.x;
               HSAdBannerView.this.b();
            }

         }
      });
      super.onWindowVisibilityChanged(var1);
   }
}
