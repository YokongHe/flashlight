package com.flurry.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.os.Message;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.RelativeLayout.LayoutParams;
import com.flurry.sdk.do;
import com.flurry.sdk.eo;
import com.flurry.sdk.fa;
import com.flurry.sdk.fb;
import com.flurry.sdk.fb$a;
import com.flurry.sdk.fc;
import com.flurry.sdk.ff;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;

public class z extends FrameLayout implements fb$a {
   public static int a;
   private static int e;
   private static int f;
   private boolean A;
   private boolean B;
   private final String C = com.flurry.sdk.z.class.getSimpleName();
   private Bitmap D;
   private Bitmap E;
   private Bitmap F;
   private Bitmap G;
   private ImageButton H;
   private ImageButton I;
   private ImageButton J;
   private com.flurry.sdk.g K;
   private com.flurry.sdk.al L;
   private AtomicBoolean M = new AtomicBoolean(false);
   @SuppressLint({"HandlerLeak"})
   private Handler N = new Handler() {
      public void handleMessage(Message var1) {
         switch(var1.what) {
         case 1:
            eo.a(3, z.this.C, "HERE IN FADE_OUT");
            z.this.h();
            return;
         case 2:
            int var2 = z.this.t();
            eo.a(3, z.this.C, "HERE IN setProgress " + var2);
            return;
         default:
         }
      }
   };
   fa b;
   do c;
   RelativeLayout d;
   private WeakReference g = new WeakReference((Object)null);
   private Context h;
   private PopupWindow i;
   private ProgressBar j;
   private boolean k;
   private boolean l;
   private boolean m;
   private boolean n;
   private boolean o;
   private boolean p;
   private boolean q;
   private boolean r = false;
   private boolean s;
   private boolean t = false;
   private boolean u = false;
   private int v = 0;
   private long w = 0L;
   private boolean x;
   private boolean y;
   private boolean z;

   public z(Context var1, long var2, boolean var4, boolean var5, boolean var6) {
      super(var1);
      e = fc.b(16);
      f = fc.b(5);
      a = fc.b(35);
      this.a(var1, new com.flurry.sdk.aa(), var2, var4, var5, var6);
   }

   private void a(Context var1, com.flurry.sdk.aa var2, long var3, boolean var5, boolean var6, boolean var7) {
      this.h = var1;
      this.K = null;
      this.n = true;
      this.o = true;
      this.p = true;
      this.q = true;
      this.w = var3;
      this.x = var5;
      this.y = var6;
      this.z = var7;
      var2.f();
      this.D = var2.b();
      this.E = var2.c();
      this.F = var2.d();
      this.G = var2.e();
   }

   private com.flurry.sdk.af getMediaPlayer() {
      return (com.flurry.sdk.af)this.g.get();
   }

   private void l() {
      LayoutParams var1 = new LayoutParams(-2, -2);
      var1.setMargins(f, f, f, f);
      var1.addRule(10);
      var1.addRule(11);
      View var2 = this.q();
      this.d.addView(var2, var1);
   }

   private void m() {
      LayoutParams var1 = new LayoutParams(-2, -2);
      var1.addRule(12);
      var1.addRule(11);
      var1.setMargins(e, e, e, e);
      View var2 = this.r();
      this.d.addView(var2, var1);
   }

   private void n() {
      LayoutParams var1 = new LayoutParams(-2, -2);
      var1.addRule(13);
      var1.setMargins(e, e, e, e);
      View var2 = this.p();
      this.d.addView(var2, var1);
   }

   private void o() {
      if(this.L == null) {
         this.L = new com.flurry.sdk.al(this.h, a, a);
      }

      LayoutParams var1 = new LayoutParams(-2, -2);
      var1.addRule(12);
      var1.addRule(9);
      var1.setMargins(e, e, e, e);
      this.d.addView(this.L.a(), var1);
      if(this.B) {
         this.L.a().setVisibility(0);
      } else {
         this.L.a().setVisibility(8);
      }
   }

   @SuppressLint({"NewApi"})
   private View p() {
      this.H = new ImageButton(this.getContext());
      this.H.setPadding(0, 0, 0, 0);
      this.H.setBackgroundColor(0);
      this.H.setImageBitmap(this.F);
      this.H.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            z.this.u();
            z.this.h();
         }
      });
      if(this.getMediaPlayer() != null && this.getMediaPlayer().getCurrentPosition() <= this.getOffsetStartTime()) {
         this.H.setVisibility(0);
      } else {
         this.H.setVisibility(8);
      }

      return this.H;
   }

   @SuppressLint({"NewApi"})
   private View q() {
      this.I = new ImageButton(this.getContext());
      this.I.setPadding(0, 0, 0, 0);
      this.I.setImageBitmap(this.D);
      GradientDrawable var1 = new GradientDrawable();
      var1.setColor(-16777216);
      var1.setShape(1);
      var1.setAlpha(178);
      if(VERSION.SDK_INT >= 16) {
         this.I.setBackground(var1);
      } else {
         this.I.setBackgroundDrawable(var1);
      }

      this.I.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            eo.a(3, z.this.C, "Show video close button.");
            if(z.this.K != null) {
               z.this.K.a();
            }

            z.this.d();
         }
      });
      if(this.l) {
         this.I.setVisibility(0);
      } else {
         this.I.setVisibility(8);
      }

      return this.I;
   }

   private View r() {
      this.J = new ImageButton(this.getContext());
      this.J.setPadding(0, 0, 0, 0);
      this.J.setBackgroundColor(0);
      this.J.setImageBitmap(this.G);
      this.J.setOnClickListener(new OnClickListener() {
         public void onClick(View var1) {
            eo.a(3, z.this.C, "Show video more info button.");
            if(z.this.K != null) {
               z.this.K.a("clicked", Collections.emptyMap(), z.this.K.getAdUnit(), z.this.K.getAdLog(), z.this.K.getAdFrameIndex(), 0);
               z.this.J.setVisibility(8);
            }

         }
      });
      if(this.A) {
         this.J.setVisibility(0);
      } else {
         this.J.setVisibility(8);
      }

      return this.J;
   }

   private void s() {
      eo.a(3, this.C, "showPlayerAssets.");
      if(this.H != null && this.getMediaPlayer() != null && !this.getMediaPlayer().isPlaying() && this.getMediaPlayer().getCurrentPosition() <= this.getOffsetStartTime()) {
         this.H.setVisibility(0);
      }

      if(this.L != null && this.B) {
         this.L.a().setVisibility(0);
      }

      if(this.I != null && this.l) {
         this.I.setVisibility(0);
      }

      if(this.J != null && this.A) {
         this.J.setVisibility(0);
      }

   }

   private int t() {
      int var1;
      if(this.getMediaPlayer() != null && !this.m) {
         int var2 = this.getMediaPlayer().getCurrentPosition();
         int var3 = this.getMediaPlayer().getDuration();
         var1 = var2;
         if(this.j != null) {
            if(var3 > 0) {
               long var4 = 1000L * (long)var2 / (long)var3;
               this.j.setProgress((int)var4);
            }

            var1 = this.getMediaPlayer().getBufferPercentage();
            this.j.setSecondaryProgress(var1 * 10);
            return var2;
         }
      } else {
         var1 = 0;
      }

      return var1;
   }

   private void u() {
      eo.a(3, this.C, "***********doPauseResume");
      if(this.getMediaPlayer() != null) {
         if(!this.getMediaPlayer().isPlaying()) {
            this.getMediaPlayer().start();
            return;
         }

         this.getMediaPlayer().pause();
      }

   }

   public void a() {
      if(this.i == null) {
         this.i = new PopupWindow(this.h);
         this.i.setBackgroundDrawable((Drawable)null);
      } else {
         eo.a(3, this.C, "PopupWindow exists so using current one!");
      }

      this.i.setFocusable(true);
      if(this.d == null) {
         this.d = new RelativeLayout(this.h);
         this.d.setBackgroundColor(0);
      } else {
         this.d.removeAllViews();
      }

      this.l();
      if(!this.x && this.getMediaPlayer() != null && this.getMediaPlayer().getCurrentPosition() <= this.getOffsetStartTime()) {
         this.n();
      }

      if(this.y) {
         this.o();
      }

      if(this.z) {
         this.m();
      }

      this.d.setFocusableInTouchMode(true);
      this.d.setOnKeyListener(new OnKeyListener() {
         public boolean onKey(View var1, int var2, KeyEvent var3) {
            if(var2 == 4) {
               if(z.this.l) {
                  eo.a(3, z.this.C, "IN KEYCODE BACK");
                  if(z.this.i != null && z.this.i.isShowing()) {
                     eo.a(3, z.this.C, "dismissing popup");
                     z.this.d();
                  }
               }

               return true;
            } else {
               return false;
            }
         }
      });
      this.i.setContentView(this.d);
      OnDismissListener var1 = new OnDismissListener() {
         public void onDismiss() {
            eo.a(3, z.this.C, "here in onDismiss ");
         }
      };
      this.i.setOnDismissListener(var1);
      if(!this.r) {
         this.j();
      }

      if(this.c == null) {
         this.c = do.a();
      }

      this.c.a(new ff() {
         public void a() {
            if(!z.this.M.get()) {
               eo.a(3, z.this.C, "Initializing popUp");
               z.this.i.showAtLocation(z.this.d, 17, 0, 0);
               z.this.i.update(0, 0, z.this.getWidthDimensions(), z.this.getHeightDimensions());
            } else {
               eo.a(3, z.this.C, "Popup initialization not required.");
            }
         }
      }, 100L);
   }

   public void a(int var1) {
      eo.a(3, this.C, "***********show called");
      if(!this.k && this.i != null) {
         eo.a(3, this.C, "********showing player assets in show()");
         this.s();
         this.k = true;
      }

      this.N.sendEmptyMessage(2);
      Message var2 = this.N.obtainMessage(1);
      if(var1 != 0) {
         this.N.removeMessages(1);
         this.N.sendMessageDelayed(var2, (long)var1);
      }

   }

   public void a(int var1, float var2) {
      if(this.I != null && var2 >= (float)this.w && !this.l) {
         this.I.setVisibility(0);
         this.l = true;
      }

      if(this.L != null && var2 > 0.0F) {
         if(!this.B) {
            this.B = true;
            this.L.a().setVisibility(0);
         }

         this.L.a(var1, this.k);
      }

      if(this.J != null && var2 >= 3000.0F && !this.A && !this.t) {
         this.A = true;
         this.J.setVisibility(0);
      }

      if(this.H != null && var2 > (float)this.getOffsetStartTime() && this.H.isShown()) {
         this.H.setVisibility(8);
      }

   }

   public void a(fb var1) {
      if(this.getMediaPlayer() != null) {
         float var2 = (float)this.getMediaPlayer().getDuration();
         float var3 = (float)this.getMediaPlayer().getCurrentPosition();
         int var4 = (int)Math.abs((var2 - var3) / 1000.0F);
         if(this.L != null) {
            this.L.a((int)var2);
         }

         this.a(var4, var3);
         if(var3 > (float)this.getOffsetStartTime() && this.n && this.K != null) {
            this.n = false;
            this.K.a("videoStart", Collections.emptyMap(), this.K.getAdUnit(), this.K.getAdLog(), this.K.getAdFrameIndex(), 0);
         }

         var2 = var3 / var2;
         if((double)var2 >= 0.25D && this.o && this.K != null) {
            this.o = false;
            this.K.a("videoFirstQuartile", Collections.emptyMap(), this.K.getAdUnit(), this.K.getAdLog(), this.K.getAdFrameIndex(), 0);
         }

         if((double)var2 >= 0.5D && this.p && this.K != null) {
            this.p = false;
            this.K.a("videoMidpoint", Collections.emptyMap(), this.K.getAdUnit(), this.K.getAdLog(), this.K.getAdFrameIndex(), 0);
         }

         if((double)var2 >= 0.75D && this.q && this.K != null) {
            this.q = false;
            this.K.a("videoThirdQuartile", Collections.emptyMap(), this.K.getAdUnit(), this.K.getAdLog(), this.K.getAdFrameIndex(), 0);
            return;
         }
      }

   }

   public void b() {
      if(this.i != null && this.i.isShowing()) {
         this.i.update(0, 0, this.getWidthDimensions(), this.getHeightDimensions());
      }

   }

   public boolean c() {
      return this.u;
   }

   public void d() {
      if(this.i != null && this.i.isShowing()) {
         eo.a(3, this.C, "dismissing popup");
         this.i.dismiss();
      }

      eo.a(3, this.C, "END OF DISMISS POPUP");
   }

   public boolean dispatchKeyEvent(KeyEvent var1) {
      int var2 = var1.getKeyCode();
      eo.a(3, this.C, "HERE IN dispatchKeyEvent");
      if(var1.getRepeatCount() == 0 && var1.getAction() == 0 && (var2 == 79 || var2 == 85 || var2 == 62)) {
         this.u();
         this.e();
         return true;
      } else if(var2 != 4 && var2 != 82) {
         this.e();
         return super.dispatchKeyEvent(var1);
      } else {
         this.h();
         return true;
      }
   }

   public void e() {
      this.a(3000);
   }

   public void f() {
      eo.a(3, this.C, "hidePlayerAssets.");
      if(this.H != null) {
         this.H.setVisibility(8);
      }

   }

   public boolean g() {
      return this.k;
   }

   public boolean getAutoPlay() {
      return this.x;
   }

   public ImageButton getCloseButton() {
      return this.I;
   }

   public int getHeightDimensions() {
      DisplayMetrics var1 = fc.b();
      eo.a(3, this.C, "height is " + var1.heightPixels);
      return var1.heightPixels;
   }

   public ImageButton getMoreInfoButton() {
      return this.J;
   }

   public boolean getMoreInfoClicked() {
      return this.s;
   }

   public int getOffsetStartTime() {
      return this.v;
   }

   public ImageButton getPauseButton() {
      return this.H;
   }

   public com.flurry.sdk.al getTimerView() {
      return this.L;
   }

   public int getWidthDimensions() {
      DisplayMetrics var1 = fc.b();
      eo.a(3, this.C, "width is " + var1.widthPixels);
      return var1.widthPixels;
   }

   public void h() {
      eo.a(3, this.C, "HERE IN HIDE");
      if(this.i != null && this.k) {
         try {
            eo.a(3, this.C, "********hiding player assets in hide()");
            this.f();
         } catch (IllegalArgumentException var2) {
            eo.a(5, this.C, "already removed");
         }

         this.k = false;
      }
   }

   public void i() {
      if(this.s || this.c()) {
         if(this.i != null) {
            this.d();
         }

         this.a();
         this.setmCloseConfirmDialogClicked(false);
      }

      if(!this.k && this.i != null) {
         this.e();
      }

   }

   public void j() {
      eo.a(3, this.C, "***********addTimerListener hit");
      if(this.b == null) {
         this.b = fa.a();
      }

      this.b.a(this);
      this.r = true;
   }

   public void k() {
      eo.a(3, this.C, "***********removeTimerListener hit");
      if(this.b == null) {
         this.b = fa.a();
      }

      this.b.b(this);
      this.r = false;
   }

   public boolean onTrackballEvent(MotionEvent var1) {
      eo.a(3, this.C, "HERE IN onTrackballEvent");
      this.e();
      return false;
   }

   public void setAdUnityView(com.flurry.sdk.g var1) {
      this.K = var1;
   }

   public void setEnabled(boolean var1) {
      if(this.j != null) {
         this.j.setEnabled(var1);
      }

      super.setEnabled(var1);
   }

   public void setFlurryCore(do var1) {
      this.c = var1;
   }

   public void setInitialVideoMidpoint(boolean var1) {
      this.p = var1;
   }

   public void setIntialVideoFirstQuartile(boolean var1) {
      this.o = var1;
   }

   public void setIntialVideoStart(boolean var1) {
      this.n = var1;
   }

   public void setIntialVideoThirdQuartile(boolean var1) {
      this.q = var1;
   }

   public void setIsMediaPlayerReleased(boolean var1) {
      this.M.set(var1);
   }

   public void setMediaPlayer(com.flurry.sdk.f var1) {
      this.g = new WeakReference(var1);
      eo.a(3, this.C, "Here is adUnityViewView: " + var1);
   }

   public void setOffsetStartTime(int var1) {
      this.v = var1;
   }

   public void setTickManager(fa var1) {
      this.b = var1;
   }

   public void setTimerView(com.flurry.sdk.al var1) {
      this.L = var1;
   }

   public void setVideoState(com.flurry.sdk.am var1) {
      boolean var3 = true;
      if(var1 != null) {
         boolean var2;
         if(!var1.b()) {
            var2 = true;
         } else {
            var2 = false;
         }

         this.n = var2;
         if(!var1.c()) {
            var2 = true;
         } else {
            var2 = false;
         }

         this.o = var2;
         if(!var1.d()) {
            var2 = true;
         } else {
            var2 = false;
         }

         this.p = var2;
         if(!var1.e()) {
            var2 = var3;
         } else {
            var2 = false;
         }

         this.q = var2;
         this.s = var1.f();
         this.t = var1.h();
         this.A = false;
      }

   }

   public void setmCloseConfirmDialogClicked(boolean var1) {
      this.u = var1;
   }
}
