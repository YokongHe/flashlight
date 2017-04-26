package com.ihandysoft.ad.a;

import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

public class a {
   protected com.ihandysoft.ad.a.b a;
   protected View b;
   protected com.ihandysoft.ad.a c;
   protected Map d;
   protected String e;
   protected Location f;
   protected Date g;
   protected boolean h;
   protected int i;
   protected int j;
   protected Context k;
   protected Handler l = new Handler(Looper.getMainLooper());
   protected boolean m;

   private int E() {
      return com.ihandysoft.ad.b.b.a(this.d.get("allowedExtraDisplayCycles"));
   }

   public static com.ihandysoft.ad.a.a a(Map var0, Context var1) {
      Class var3 = com.ihandysoft.ad.i.a(var0.get("adType")).a();
      Class var2 = var3;
      if(var3 == null) {
         var2 = com.ihandysoft.ad.a.a.class;
      }

      com.ihandysoft.ad.a.a var5;
      try {
         var5 = (com.ihandysoft.ad.a.a)var2.newInstance();
      } catch (Exception var4) {
         var5 = null;
      }

      if(var5 != null) {
         var5.d = var0;
         var5.k = var1;
      }

      var5.c = com.ihandysoft.ad.a.a(var1);
      return var5;
   }

   public final void A() {
      this.j = this.E() + 1;
   }

   public final void B() {
      ++this.j;
   }

   public final boolean C() {
      return this.j > 0;
   }

   public final Location D() {
      return this.f;
   }

   public final Context a() {
      return this.k;
   }

   public final void a(int var1) {
      this.i = var1;
   }

   public final void a(Location var1) {
      this.f = var1;
   }

   public final void a(com.ihandysoft.ad.a.b var1) {
      this.a = var1;
   }

   protected final void a(final Exception var1) {
      this.l.post(new Runnable() {
         public final void run() {
            if(a.this.a != null) {
               a.this.a.a(a.this, var1);
            }

         }
      });
   }

   public final void a(String var1) {
      this.e = var1;
   }

   public final void a(boolean var1) {
      this.h = var1;
   }

   public boolean a(Map var1) {
      return this.c() == com.ihandysoft.ad.i.a(var1.get("adType")) && this.e() == com.ihandysoft.ad.b.b.c(var1.get("preload"));
   }

   public final String b() {
      return this.c().name();
   }

   public final com.ihandysoft.ad.i c() {
      return com.ihandysoft.ad.i.a(this.d.get("adType"));
   }

   public final com.ihandysoft.ad.g d() {
      return com.ihandysoft.ad.g.a(com.ihandysoft.ad.b.b.a(this.d.get("networkType")));
   }

   public final boolean e() {
      return com.ihandysoft.ad.b.b.c(this.d.get("preload"));
   }

   public final boolean f() {
      return this.h;
   }

   public final float g() {
      return com.ihandysoft.ad.b.b.b(this.d.get("cpm"));
   }

   public final float h() {
      return com.ihandysoft.ad.b.b.b(this.d.get("cpmDecreaseRate"));
   }

   public final float i() {
      return com.ihandysoft.ad.b.b.b(this.d.get("adTimeInterval"));
   }

   public final int j() {
      return com.ihandysoft.ad.b.b.a(this.d.get("forceReloadCount"));
   }

   public final int k() {
      return this.i;
   }

   public final boolean l() {
      return com.ihandysoft.ad.b.b.c(this.d.get("locationDisabled"));
   }

   public final Date m() {
      return this.g;
   }

   public final View n() {
      return this.b;
   }

   public final Map o() {
      return this.d;
   }

   protected void p() {
      this.a((Exception)null);
   }

   public final void q() {
      this.l.post(new Runnable() {
         public final void run() {
            a.this.g = new Date();
            a.this.p();
         }
      });
   }

   public final void r() {
      com.ihandysoft.ad.b.a.a(this.l, new Runnable() {
         public final void run() {
            a.this.m = true;
            a.this.t();
            a.this.g = null;
            a.this.a = null;
            (new StringBuilder(String.valueOf(a.this.b()))).append(" is unloaded.").toString();
         }
      });
   }

   public final boolean s() {
      return this.m;
   }

   protected void t() {
   }

   public String toString() {
      return String.format(Locale.US, "%s:%6.2f", new Object[]{this.c().name(), Float.valueOf(this.g())});
   }

   protected final void u() {
      this.l.post(new Runnable() {
         public final void run() {
            if(a.this.a != null) {
               a.this.a.a(a.this);
            }

         }
      });
   }

   protected final void v() {
      this.l.post(new Runnable() {
         public final void run() {
            if(a.this.a != null) {
               a.this.a.b(a.this);
            }

         }
      });
   }

   protected final void w() {
      this.l.post(new Runnable() {
         public final void run() {
            if(a.this.a != null) {
               com.ihandysoft.ad.a.b var1 = a.this.a;
               com.ihandysoft.ad.a.a var2 = a.this;
            }

         }
      });
   }

   protected final void x() {
      this.l.post(new Runnable() {
         public final void run() {
            if(a.this.a != null) {
               com.ihandysoft.ad.a.b var1 = a.this.a;
               com.ihandysoft.ad.a.a var2 = a.this;
               var1.d();
            }

         }
      });
   }

   protected final void y() {
      this.l.post(new Runnable() {
         public final void run() {
            if(a.this.a != null) {
               com.ihandysoft.ad.a.b var1 = a.this.a;
               com.ihandysoft.ad.a.a var2 = a.this;
               var1.c();
            }

         }
      });
   }

   public final boolean z() {
      return this.j > this.E();
   }
}
