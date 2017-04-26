package com.google.android.gms.internal;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.google.android.gms.internal.dg;
import com.google.android.gms.internal.dx;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class bL extends WebView implements DownloadListener {
   private final com.google.android.gms.internal.bO a;
   private final com.google.android.gms.internal.bM b;
   private final Object c = new Object();
   private final dg d;
   private final dx e;
   private com.google.android.gms.internal.as f;
   private com.google.android.gms.internal.ak g;
   private boolean h;
   private boolean i;
   private final WindowManager j;

   private bL(com.google.android.gms.internal.bM var1, com.google.android.gms.internal.ak var2, boolean var3, boolean var4, dg var5, dx var6) {
      super(var1);
      this.b = var1;
      this.g = var2;
      this.h = var3;
      this.d = var5;
      this.e = var6;
      this.j = (WindowManager)this.getContext().getSystemService("window");
      this.setBackgroundColor(0);
      WebSettings var7 = this.getSettings();
      var7.setJavaScriptEnabled(true);
      var7.setSavePassword(false);
      var7.setSupportMultipleWindows(true);
      var7.setJavaScriptCanOpenWindowsAutomatically(true);
      com.google.android.gms.internal.bD.a((Context)var1, (String)var6.b, (WebSettings)var7);
      if(VERSION.SDK_INT >= 17) {
         com.google.android.gms.internal.bG.a(this.getContext(), var7);
         var7.setMediaPlaybackRequiresUserGesture(false);
      } else if(VERSION.SDK_INT >= 11) {
         com.google.android.gms.internal.bG.a(this.getContext(), var7);
      }

      this.setDownloadListener(this);
      if(VERSION.SDK_INT >= 11) {
         this.a = new com.google.android.gms.internal.bR(this, var4);
      } else {
         this.a = new com.google.android.gms.internal.bO(this, var4);
      }

      this.setWebViewClient(this.a);
      if(VERSION.SDK_INT >= 14) {
         this.setWebChromeClient(new com.google.android.gms.internal.bS(this));
      } else if(VERSION.SDK_INT >= 11) {
         this.setWebChromeClient(new com.google.android.gms.internal.bQ(this));
      }

      this.j();
   }

   public static com.google.android.gms.internal.bL a(Context var0, com.google.android.gms.internal.ak var1, boolean var2, boolean var3, dg var4, dx var5) {
      return new com.google.android.gms.internal.bL(new com.google.android.gms.internal.bM(var0), var1, var2, var3, var4, var5);
   }

   private void b(String var1, JSONObject var2) {
      JSONObject var3 = var2;
      if(var2 == null) {
         var3 = new JSONObject();
      }

      String var4 = var3.toString();
      StringBuilder var5 = new StringBuilder();
      var5.append("javascript:AFMA_ReceiveMessage(\'");
      var5.append(var1);
      var5.append("\'");
      var5.append(",");
      var5.append(var4);
      var5.append(");");
      com.google.android.gms.internal.bJ.d("Dispatching AFMA event: " + var5);
      this.loadUrl(var5.toString());
   }

   private void j() {
      // $FF: Couldn't be decompiled
   }

   private void k() {
      Object var1 = this.c;
      synchronized(var1) {
         if(!this.i && VERSION.SDK_INT >= 11) {
            this.setLayerType(1, (Paint)null);
         }

         this.i = true;
      }
   }

   private void l() {
      Object var1 = this.c;
      synchronized(var1) {
         if(this.i && VERSION.SDK_INT >= 11) {
            this.setLayerType(0, (Paint)null);
         }

         this.i = false;
      }
   }

   public final void a() {
      if(this.a.a()) {
         DisplayMetrics var1 = new DisplayMetrics();
         Display var2 = this.j.getDefaultDisplay();
         var2.getMetrics(var1);

         try {
            this.b("onScreenInfoChanged", (new JSONObject()).put("width", var1.widthPixels).put("height", var1.heightPixels).put("density", (double)var1.density).put("rotation", var2.getRotation()));
         } catch (JSONException var3) {
            com.google.android.gms.internal.bJ.a("Error occured while obtaining screen information.", var3);
         }
      }
   }

   public final void a(Context var1) {
      this.b.setBaseContext(var1);
   }

   public final void a(Context var1, com.google.android.gms.internal.ak var2) {
      Object var3 = this.c;
      synchronized(var3) {
         this.b.setBaseContext(var1);
         this.f = null;
         this.g = var2;
         this.h = false;
         com.google.android.gms.internal.bD.b((WebView)this);
         this.loadUrl("about:blank");
         this.a.b();
      }
   }

   public final void a(com.google.android.gms.internal.ak var1) {
      Object var2 = this.c;
      synchronized(var2) {
         this.g = var1;
         this.requestLayout();
      }
   }

   public final void a(com.google.android.gms.internal.as var1) {
      Object var2 = this.c;
      synchronized(var2) {
         this.f = var1;
      }
   }

   public final void a(String var1, Map var2) {
      JSONObject var4;
      try {
         var4 = com.google.android.gms.internal.bD.a(var2);
      } catch (JSONException var3) {
         com.google.android.gms.internal.bJ.e("Could not convert parameters to JSON.");
         return;
      }

      this.b(var1, var4);
   }

   public final void a(String var1, JSONObject var2) {
      JSONObject var3 = var2;
      if(var2 == null) {
         var3 = new JSONObject();
      }

      String var4 = var3.toString();
      StringBuilder var5 = new StringBuilder();
      var5.append("javascript:" + var1 + "(");
      var5.append(var4);
      var5.append(");");
      this.loadUrl(var5.toString());
   }

   public final void a(boolean var1) {
      Object var2 = this.c;
      synchronized(var2) {
         this.h = var1;
         this.j();
      }
   }

   public final void b() {
      HashMap var1 = new HashMap(1);
      var1.put("version", this.e.b);
      this.a((String)"onhide", (Map)var1);
   }

   public final void c() {
      HashMap var1 = new HashMap(1);
      var1.put("version", this.e.b);
      this.a((String)"onshow", (Map)var1);
   }

   public final com.google.android.gms.internal.as d() {
      Object var1 = this.c;
      synchronized(var1) {
         com.google.android.gms.internal.as var2 = this.f;
         return var2;
      }
   }

   public final com.google.android.gms.internal.ak e() {
      Object var1 = this.c;
      synchronized(var1) {
         com.google.android.gms.internal.ak var2 = this.g;
         return var2;
      }
   }

   public final com.google.android.gms.internal.bO f() {
      return this.a;
   }

   public final dg g() {
      return this.d;
   }

   public final dx h() {
      return this.e;
   }

   public final boolean i() {
      Object var2 = this.c;
      synchronized(var2) {
         boolean var1 = this.h;
         return var1;
      }
   }

   public final void onDownloadStart(String var1, String var2, String var3, String var4, long var5) {
      try {
         Intent var8 = new Intent("android.intent.action.VIEW");
         var8.setDataAndType(Uri.parse(var1), var4);
         this.getContext().startActivity(var8);
      } catch (ActivityNotFoundException var7) {
         com.google.android.gms.internal.bJ.a("Couldn\'t find an Activity to view url/mimetype: " + var1 + " / " + var4);
      }
   }

   protected final void onMeasure(int param1, int param2) {
      // $FF: Couldn't be decompiled
   }

   public final boolean onTouchEvent(MotionEvent var1) {
      if(this.d != null) {
         this.d.a(var1);
      }

      return super.onTouchEvent(var1);
   }
}
