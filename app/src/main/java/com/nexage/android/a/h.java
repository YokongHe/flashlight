package com.nexage.android.a;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.nexage.android.NexageActivity;
import java.util.ArrayList;
import java.util.Arrays;
import org.nexage.sourcekit.mraid.MRAIDNativeFeatureListener;
import org.nexage.sourcekit.mraid.MRAIDView;
import org.nexage.sourcekit.mraid.MRAIDViewListener;
import org.nexage.sourcekit.mraid.internal.MRAIDLog;
import org.nexage.sourcekit.mraid.internal.MRAIDNativeFeatureManager;
import org.nexage.sourcekit.mraid.nativefeature.MRAIDNativeFeatureProvider;

public final class h extends RelativeLayout {
   private static volatile int o = 0;
   private static ArrayList p = new ArrayList();
   private static boolean q;
   private MRAIDView a;
   private String[] b;
   private MRAIDViewListener c;
   private MRAIDNativeFeatureListener d;
   private MRAIDNativeFeatureProvider e;
   private com.nexage.android.a.g f;
   private boolean g;
   private boolean h;
   private short i = -1;
   private short j = -1;
   private short k = -1;
   private short l = -1;
   private volatile RelativeLayout m = null;
   private final com.nexage.android.a.b n = new com.nexage.android.a.i(this, (byte)0);

   public h(com.nexage.android.a.g var1, Context var2, boolean var3) {
      super(var2);
      this.f = var1;
      this.h = var3;
      if(!var1.k()) {
         this.a(var1, var2, var3);
      }

   }

   // $FF: synthetic method
   static MRAIDView a(com.nexage.android.a.h var0, MRAIDView var1) {
      var0.a = null;
      return null;
   }

   private void a(com.nexage.android.a.g var1, Context var2, boolean var3) {
      q = false;
      String var4 = this.f.a();
      ArrayList var5 = new ArrayList();
      if(!com.nexage.android.b.a("no-calendar")) {
         var5.add("calendar");
      }

      var5.add("inlineVideo");
      if(!com.nexage.android.b.a("no-sms")) {
         var5.add("sms");
      }

      if(!com.nexage.android.b.a("no-photo")) {
         var5.add("storePicture");
      }

      if(!com.nexage.android.b.a("no-phone")) {
         var5.add("tel");
      }

      this.b = (String[])var5.toArray(new String[0]);
      this.c = new MRAIDViewListener() {
         public final void mraidViewClose(MRAIDView var1) {
            MRAIDLog.d("MraidAdLayout", "MRAIDViewListener mraidViewClose");
            MRAIDView var2 = var1;
            if(var1 == null) {
               var2 = h.this.a;
            }

            if(var2.getState() != 2 && var2.getState() != 3) {
               com.nexage.android.a.h.q = false;
               Handler var3 = com.nexage.android.a.o.b();
               if(var3 != null) {
                  var3.sendEmptyMessage(2);
               }

               if(h.this.h && var2 != null) {
                  ((NexageActivity)var2.getContext()).a();
                  return;
               }

               if(h.this.f != null) {
                  final com.nexage.android.j var4 = h.this.f.e();
                  if(var4 != null) {
                     h.this.post(new Runnable() {
                        public final void run() {
                           com.nexage.android.j var1 = var4;
                           h.this.f.d();
                           var1.E();
                        }
                     });
                     return;
                  }
               }
            }

         }

         public final void mraidViewExpand(MRAIDView var1) {
            MRAIDLog.d("MraidAdLayout", "MRAIDViewListener mraidViewExpand");
            if(!h.this.h) {
               h.this.c();
            }

            com.nexage.android.a.h.q = true;
            Handler var2 = com.nexage.android.a.o.b();
            if(var2 != null) {
               var2.sendEmptyMessage(1);
            }

            if(h.this.f != null) {
               final com.nexage.android.j var3 = h.this.f.e();
               if(var3 != null) {
                  h.this.post(new Runnable() {
                     public final void run() {
                        com.nexage.android.j var1 = var3;
                        h.this.f.d();
                        var1.G();
                     }
                  });
               }
            }

         }

         public final void mraidViewLoaded(MRAIDView var1) {
            MRAIDLog.d("MraidAdLayout", "MRAIDViewListener mraidViewLoaded");
            com.nexage.android.a.l var2 = h.this.f.f();
            if(var2 != null) {
               var2.a((View)h.this);
            }

         }

         public final boolean mraidViewResize(MRAIDView var1, int var2, int var3, int var4, int var5) {
            MRAIDLog.d("MraidAdLayout", "MRAIDViewListener mraidViewResize");
            h.this.c();
            Handler var6 = com.nexage.android.a.o.b();
            if(var6 != null) {
               var6.sendEmptyMessage(1);
            }

            return true;
         }
      };
      this.d = new MRAIDNativeFeatureListener() {
         public final void mraidNativeFeatureCallTel(String var1) {
            MRAIDLog.d("MraidAdLayout", "MRAIDNativeFeatureListener mraidNativeFeatureCallTel " + var1);
            com.nexage.android.a.h.e(h.this);
            h.this.e.callTel(var1);
         }

         public final void mraidNativeFeatureCreateCalendarEvent(String var1) {
            MRAIDLog.d("MraidAdLayout", "MRAIDNativeFeatureListener mraidNativeFeatureCreateCalendarEvent " + var1);
            if(h.this.e.createCalendarEvent(var1)) {
               com.nexage.android.a.h.e(h.this);
            }

         }

         public final void mraidNativeFeatureOpenBrowser(String var1) {
            MRAIDLog.d("MraidAdLayout", "MRAIDNativeFeatureListener mraidNativeFeatureOpenBrowser " + var1);
            com.nexage.android.a.h.e(h.this);
            h.this.e.openBrowser(var1);
         }

         public final void mraidNativeFeaturePlayVideo(String var1) {
            MRAIDLog.d("MraidAdLayout", "MRAIDNativeFeatureListener mraidNativeFeaturePlayVideo " + var1);
            com.nexage.android.a.h.e(h.this);
            h.this.e.playVideo(var1);
         }

         public final void mraidNativeFeatureSendSms(String var1) {
            MRAIDLog.d("MraidAdLayout", "MRAIDNativeFeatureListener mraidNativeFeatureSendSms " + var1);
            com.nexage.android.a.h.e(h.this);
            h.this.e.sendSms(var1);
         }

         public final void mraidNativeFeatureStorePicture(String var1) {
            MRAIDLog.d("MraidAdLayout", "MRAIDNativeFeatureListener mraidNativeFeatureStorePicture " + var1);
            com.nexage.android.a.h.e(h.this);
            h.this.e.storePicture(var1);
         }
      };
      this.e = new MRAIDNativeFeatureProvider(var2, new MRAIDNativeFeatureManager(var2, new ArrayList(Arrays.asList(this.b))));
      this.a = new MRAIDView(var2, (String)null, var4, this.b, this.c, this.d, var3);
      MRAIDView var7 = this.a;
      LayoutParams var6 = new LayoutParams(var1.b(), var1.c());
      var6.setMargins(0, 0, 0, 0);
      var7.setLayoutParams(var6);
      this.addView(this.a);
   }

   private void c() {
      synchronized(this){}

      try {
         if(this.f != null && !this.g) {
            this.g = true;
            (new Thread(new Runnable() {
               public final void run() {
                  h.this.f.h();
               }
            })).start();
         }
      } finally {
         ;
      }

   }

   // $FF: synthetic method
   static void e(com.nexage.android.a.h var0) {
      var0.c();
      Handler var1 = com.nexage.android.a.o.b();
      if(var1 != null) {
         var1.sendEmptyMessage(1);
      }

   }

   public final void a() {
      if(this.a != null) {
         this.a.clearView();
      }

   }

   public final void a(Context var1) {
      this.a(this.f, var1, true);
   }

   final com.nexage.android.a.b b() {
      return this.n;
   }

   protected final void onVisibilityChanged(View var1, int var2) {
      super.onVisibilityChanged(var1, var2);
      if(var2 == 0 && !com.nexage.android.a.o.c() && !this.h && this.a.getState() != 2 && this.a.getState() != 3) {
         Handler var3 = com.nexage.android.a.o.b();
         if(var3 != null) {
            var3.sendEmptyMessage(2);
            return;
         }
      }

   }

   public final void setBackgroundColor(int var1) {
      super.setBackgroundColor(var1);
      this.a.setBackgroundColor(var1);
   }

   public final void setBackgroundResource(int var1) {
      super.setBackgroundResource(var1);
      this.a.setBackgroundResource(var1);
   }

   public final void setVisibility(int var1) {
      super.setVisibility(var1);
      this.a.setVisibility(var1);
   }
}
