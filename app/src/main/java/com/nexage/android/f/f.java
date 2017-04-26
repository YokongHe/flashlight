package com.nexage.android.f;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.millennialmedia.android.MMAd;
import com.millennialmedia.android.MMAdView;
import com.millennialmedia.android.MMException;
import com.millennialmedia.android.MMRequest;
import com.millennialmedia.android.RequestListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

public final class f extends com.nexage.android.e.b implements RequestListener {
   Activity d;
   FrameLayout e;
   private MMAdView f;

   public f(Activity var1, Handler var2) {
      super(var1, var2);
      com.nexage.android.a.p.b("MillennialMediaProvider", "entering constructor");
      this.d = var1;
      this.c = true;
   }

   public final void MMAdOverlayClosed(MMAd var1) {
      com.nexage.android.a.p.b("MillennialMediaProvider", ">>>> MMAdOverlayClosed <<<<");
      this.d(this);
   }

   public final void MMAdOverlayLaunched(MMAd var1) {
      com.nexage.android.a.p.b("MillennialMediaProvider", ">>>> MMAdOverlayLaunched <<<<");
      this.c(this);
   }

   public final void MMAdRequestIsCaching(MMAd var1) {
      com.nexage.android.a.p.b("MillennialMediaProvider", ">>>> MMAdRequestIsCaching <<<<");
   }

   protected final View a(int var1, int var2, String var3) {
      this.f = new MMAdView(this.d);
      this.f.setApid(var3);
      this.f.setWidth(var1);
      this.f.setHeight(var2);
      HashMap var5 = new HashMap();
      if(com.nexage.android.b.f() == -1) {
         GregorianCalendar var4 = com.nexage.android.b.h();
         if(var4 != null) {
            var5.put("age", Integer.toString(Calendar.getInstance().get(1) - var4.get(1)));
         }
      } else {
         var5.put("age", Integer.toString(com.nexage.android.b.f()));
      }

      if(com.nexage.android.b.o() == com.nexage.android.d.a) {
         var5.put("gender", "male");
      } else if(com.nexage.android.b.o() == com.nexage.android.d.b) {
         var5.put("gender", "female");
      } else if(com.nexage.android.b.o() == com.nexage.android.d.c) {
         var5.put("gender", "other");
      }

      var5.put("zip", com.nexage.android.b.l());
      if(com.nexage.android.b.p() == com.nexage.android.e.b) {
         var5.put("marital", "married");
      } else if(com.nexage.android.b.p() == com.nexage.android.e.a) {
         var5.put("marital", "single");
      } else if(com.nexage.android.b.p() == com.nexage.android.e.d) {
         var5.put("marital", "other");
      } else if(com.nexage.android.b.p() == com.nexage.android.e.c) {
         var5.put("marital", "divorced");
      }

      if(com.nexage.android.b.n() == com.nexage.android.c.a) {
         var5.put("ethnicity", "black");
      } else if(com.nexage.android.b.n() == com.nexage.android.c.b) {
         var5.put("ethnicity", "asian");
      } else if(com.nexage.android.b.n() == com.nexage.android.c.c) {
         var5.put("ethnicity", "hispanic");
      } else if(com.nexage.android.b.n() == com.nexage.android.c.e) {
         var5.put("ethnicity", "other");
      } else if(com.nexage.android.b.n() == com.nexage.android.c.d) {
         var5.put("ethnicity", "white");
      }

      var5.put("income", Integer.toString(com.nexage.android.b.q()));
      var5.put("children", Boolean.toString(com.nexage.android.b.g()));
      var5.put("keywords", com.nexage.android.b.r());
      var5.put("vendor", "nexage");
      MMRequest var6 = new MMRequest();
      var6.setMetaValues(var5);
      this.f.setMMRequest(var6);
      this.f.setListener(this);
      this.e = new FrameLayout(this.d);
      this.e.setLayoutParams(new LayoutParams((int)((float)var1 * this.d.getResources().getDisplayMetrics().density), (int)((float)var2 * this.d.getResources().getDisplayMetrics().density)));
      this.e.addView(this.f);
      return this.e;
   }

   protected final void b() {
      try {
         this.f.getAd();
      } catch (Exception var2) {
         com.nexage.android.a.p.a("MillennialMediaProvider", "loadAdView:", var2);
      }
   }

   protected final void c() {
   }

   public final void onSingleTap(MMAd var1) {
      com.nexage.android.a.p.b("MillennialMediaProvider", ">>>> onSingleTap <<<<");
      this.e(this);
   }

   public final void requestCompleted(MMAd var1) {
      com.nexage.android.a.p.b("MillennialMediaProvider", ">>>> requestCompleted <<<<");
      this.a(this);
   }

   public final void requestFailed(MMAd var1, MMException var2) {
      com.nexage.android.a.p.b("MillennialMediaProvider", ">>>> requestFailed <<<<");
      this.b(this);
   }
}
