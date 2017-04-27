package com.surpax.ledflashlight;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

import com.tcl.hawk.myflashlight.R;

import static com.surpax.a.a.A;

public class FlashlightActivity extends Activity {
   private static FlashlightActivity p;
   public boolean a = false;
   public int b = 0;
   public boolean c = false;
   public boolean d;
   public int e;
   public SurfaceView f;
   public float g;
   public float h;
   private TextView i;
   private ImageButton j;
   private ImageButton k;
   private boolean l = false;
   private boolean m = false;
   private AlertDialog n = null;
   private com.surpax.a.c q;
   private com.surpax.a.b r;
   private com.surpax.c.a.c s;
   private boolean t;
   private View u;
   private com.surpax.d.a v;
   private WakeLock w;

   private int a(String var1) {
      int var2 = -1;
      SharedPreferences var3 = this.getSharedPreferences(var1, 0);
      if(var3 != null) {
         var2 = var3.getInt(var1, -1);
      }

      return var2;
   }

   public static FlashlightActivity a() {
      return p;
   }

   // $FF: synthetic method
   static void a(FlashlightActivity var0, AlertDialog var1) {
      var0.n = null;
   }

   private void a(String var1, int var2) {
      Editor var3 = this.getSharedPreferences(var1, 0).edit();
      var3.putInt(var1, var2);
      var3.commit();
   }

   public final void a(int var1) {
      if(this.q != null) {
         this.q.a(var1);
      }

   }

   public final void a(boolean var1) {
      if(this.t && this.v != null) {
         if(!var1) {
            this.v.setVisibility(View.INVISIBLE);
            return;
         }

         this.v.setVisibility(View.VISIBLE);
         if(this.j != null && this.l) {
            this.j.setVisibility(View.VISIBLE);
            this.l = false;
         }

         this.k.setVisibility(View.VISIBLE);
      }

   }

   public final com.surpax.a.b b() {
      return this.r;
   }

   public final void c() {
      if(com.surpax.b.a.a().g() && !com.surpax.b.a.c) {
         this.a = true;
         this.i.setText(com.surpax.b.a.a().f());
         switch(com.surpax.b.a.a().b()) {
         case 0:
            this.j.setImageResource(R.drawable.honey_icon_selector);
            break;
         case 1:
            this.j.setImageResource(R.drawable.honey_icon_selector_1);
            break;
         case 2:
            this.j.setImageResource(R.drawable.honey_icon_animation);
         }

         Drawable var4 = this.j.getDrawable();
         LayoutParams var6 = new LayoutParams(var4.getIntrinsicWidth(), var4.getIntrinsicHeight());
         var6.leftMargin = (int)this.r.N;
         var6.topMargin = (int)this.r.O - 5;
         this.j.setLayoutParams(var6);
         this.j.setVisibility(View.VISIBLE);
         this.j.bringToFront();
         this.j.postInvalidate();
      } else {
         this.a = false;
         this.j.setVisibility(View.INVISIBLE);
         this.i.setVisibility(View.INVISIBLE);
      }
   }

   public final void d() {
      if(this.s != null) {
         this.s.d();
      }

   }

   public final void e() {
      if(this.s != null) {
         this.s.e();
      }

   }

   public final void f() {
      if(this.s != null) {
         this.s.f();
      }

   }

   public final boolean g() {
      return this.t;
   }

   public final View h() {
      return this.u;
   }

   public final void i() {
      if(this.j != null && this.j.getVisibility() == View.VISIBLE) {
         this.j.setVisibility(View.INVISIBLE);
         this.l = true;
      }

   }

   public final View j() {
      return this.findViewById(R.id.root_view);
   }

   public final boolean k() {
      boolean var1;
      if(this.t) {
         var1 = false;
      } else if("samsung".equalsIgnoreCase(Build.MANUFACTURER) && "SPH-M820-BST".equals(Build.MODEL)) {
         var1 = false;
      } else if("samsung".equalsIgnoreCase(Build.MANUFACTURER) && "SGH-T679".equals(Build.MODEL)) {
         var1 = false;
      } else if("samsung".equalsIgnoreCase(Build.MANUFACTURER) && "SPH-D710".equals(Build.MODEL)) {
         var1 = false;
      } else if("ZTE".equalsIgnoreCase(Build.MANUFACTURER) && "N860".equals(Build.MODEL)) {
         var1 = false;
      } else if("ZTE".equalsIgnoreCase(Build.MANUFACTURER) && "ZTE-SKATE".equals(Build.MODEL)) {
         var1 = false;
      } else if("LGE".equalsIgnoreCase(Build.MANUFACTURER) && "LG-LS855".equals(Build.MODEL)) {
         var1 = false;
      } else if("Motorola".equalsIgnoreCase(Build.MANUFACTURER) && "A854".equals(Build.MODEL)) {
         var1 = false;
      } else {
         var1 = true;
      }

      return var1 && this.c;
   }

   public final void l() {
      try {
         if(this.i.getVisibility() == View.VISIBLE) {
            this.i.setVisibility(View.INVISIBLE);
         }

      } catch (Exception var2) {
         var2.printStackTrace();
      }
   }

   public void onConfigurationChanged(Configuration var1) {
      super.onConfigurationChanged(var1);
   }

   @SuppressLint({"CommitPrefEdits", "InlinedApi"})
   public void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.requestWindowFeature(1);
      Window var11 = this.getWindow();
      var11.setFlags(1024, 1024);
      var11.addFlags(2097280);
      this.setContentView(R.layout.main);
      p = this;
      this.l = false;
      this.d = false;
      this.m = false;
      com.surpax.a.a.l = false;
      this.c = false;
      this.g = 1.0F;
      this.h = 1.0F;
      int var6 = this.a("surpax_sound_state");
      com.surpax.a.a.h = var6;
      if(var6 == -1) {
         com.surpax.a.a.h = 1;
      }

      this.q = new com.surpax.a.c(this.getApplicationContext());
      DisplayMetrics var9 = new DisplayMetrics();
      this.getWindowManager().getDefaultDisplay().getMetrics(var9);
      this.e = var9.widthPixels;
      Log.d("Surpax App", "screen height is:" + var9.heightPixels + ", width is:" + var9.widthPixels);
      Options var12 = new Options();
      var12.inTargetDensity = var9.densityDpi;
      var12.inDensity = var9.densityDpi;
      this.h = 1.0F;
      this.g = 1.0F;
      this.r = new com.surpax.a.b();
      int var7;
      if(800 == var9.heightPixels && 480 == var9.widthPixels) {
         this.r.b(this.getResources(), var12);
      } else if(854 == var9.heightPixels && 480 == var9.widthPixels) {
         this.r.a(this.getResources(), var12);
      } else if(480 == var9.heightPixels && 320 == var9.widthPixels) {
         this.r.d(this.getResources(), var12);
      } else if(640 == var9.heightPixels && 480 == var9.widthPixels) {
         this.r.c(this.getResources(), var12);
      } else if(1280 == var9.heightPixels && 720 == var9.widthPixels) {
         this.r.e(this.getResources(), var12);
      } else if(1920 == var9.heightPixels && 1080 == var9.widthPixels) {
         com.surpax.a.b var16 = this.r;
         Resources var17 = this.getResources();
         var16.led_bg = BitmapFactory.decodeResource(var17, 2130837607, var12);
         Log.d("FlashLightActivity_Test", "background bmps\'s width is:" + var16.led_bg.getWidth() + ", height is:" + var16.led_bg.getHeight());
         var16.led_indicator = BitmapFactory.decodeResource(var17, 2130837613, var12);
         var16.z = 481.0F;
         var16.A = 1152.0F;
         var16.B = 124;
         var16.C = 124;
         var16.num0 = BitmapFactory.decodeResource(var17, 2130837628, var12);
         var16.num1 = BitmapFactory.decodeResource(var17, 2130837633, var12);
         var16.num2 = BitmapFactory.decodeResource(var17, 2130837638, var12);
         var16.num3 = BitmapFactory.decodeResource(var17, 2130837643, var12);
         var16.num4 = BitmapFactory.decodeResource(var17, 2130837648, var12);
         var16.num5 = BitmapFactory.decodeResource(var17, 2130837653, var12);
         var16.num6 = BitmapFactory.decodeResource(var17, 2130837658, var12);
         var16.num7 = BitmapFactory.decodeResource(var17, 2130837663, var12);
         var16.num8 = BitmapFactory.decodeResource(var17, 2130837668, var12);
         var16.num9 = BitmapFactory.decodeResource(var17, 2130837673, var12);
         var16.q = 513.0F;
         var16.r = 557.0F;
         var16.s = 51;
         var16.t = 69;
         var16.led_switch = BitmapFactory.decodeResource(var17, 2130837682, var12);
         var16.c = 380.0F;
         var16.d = 1122.0F;
         var16.e = 316;
         var16.f = 495;
         var16.led_knob = BitmapFactory.decodeResource(var17, 2130837618, var12);
         var16.know_shadow = BitmapFactory.decodeResource(var17, 2130837623, var12);
         var16.J = -2130.0F;
         var16.K = 0.0F;
         var16.L = 1080.0F;
         var16.M = 329.0F;
         var16.H = 761.0F;
         var16.G = 1080.0F;
         var16.E = 0.0F;
         var16.F = 0.0F;
         com.surpax.a.a.o = 126;
         com.surpax.a.a.n = 1107;
         com.surpax.a.a.m = -346;
      } else if(1184 == var9.heightPixels && 720 == var9.widthPixels) {
         this.r.f(this.getResources(), var12);
      } else {
         if(1184 == var9.heightPixels && 768 == var9.widthPixels) {
            this.r.f(this.getResources(), var12);
         } else {
            float var5 = (float)var9.heightPixels * 1.0F / (float)var9.widthPixels;
            Log.d("Surpax App", "height / width = " + var5);
            float[] var10 = new float[]{com.surpax.a.a.d, com.surpax.a.a.a, com.surpax.a.a.b, com.surpax.a.a.c, com.surpax.a.a.e, com.surpax.a.a.f};
            Log.d("Surpax App", "array length is: " + var10.length);
            float var2 = 100.0F;
            var7 = 0;

            float var3;
            for(var6 = 0; var6 < var10.length; var2 = var3) {
               float var4 = Math.abs(var10[var6] - var5);
               var3 = var2;
               if(var4 < var2) {
                  var3 = var4;
                  var7 = var6;
               }

               ++var6;
            }

            switch(var7) {
            case 0:
               Log.d("Surpax App", "invoke load320to480");
               this.r.d(this.getResources(), var12);
               break;
            case 1:
               Log.d("Surpax App", "invoke 480to640");
               this.r.c(this.getResources(), var12);
               break;
            case 2:
               Log.d("Surpax App", "invoke load480t0800");
               this.r.b(this.getResources(), var12);
               break;
            case 3:
               Log.d("Surpax App", "invoke load480to854");
               this.r.a(this.getResources(), var12);
               break;
            case 4:
               Log.d("Surpax App", "invoke load720to1280");
               this.r.e(this.getResources(), var12);
               break;
            case 5:
               Log.d("Surpax App", "invoke load720to1184");
               this.r.f(this.getResources(), var12);
               break;
            default:
               Log.d("Surpax App", "default invoke load480t0800");
               this.r.b(this.getResources(), var12);
            }
         }

         this.h = (float)var9.heightPixels * 1.0F / (float)this.r.led_bg.getHeight();
         this.g = (float)var9.widthPixels * 1.0F / (float)this.r.led_bg.getWidth();
      }

      com.surpax.a.b var13 = this.r;
      var9 = new DisplayMetrics();
      p.getWindowManager().getDefaultDisplay().getMetrics(var9);
      var6 = var9.widthPixels;
      var7 = var9.heightPixels;
      int var8 = var9.densityDpi * 78 / 240;
      var13.w = var8;
      var13.x = var9.densityDpi * 82 / 240;
      var13.u = (float)((int)((float)var6 * 0.05F));
      var13.v = (float)(var7 - (int)((float)(var9.densityDpi * 370 / 480) * 1.0F) - 15);
      var13.N = (float)var6 - var13.u - (float)var8;
      var13.O = var13.v;
      this.i = (TextView)this.findViewById(R.id.honeycomb_info);
      this.i.setVisibility(View.INVISIBLE);
      this.j = (ImageButton)this.findViewById(R.id.bt_honeycomb);
      this.j.setVisibility(View.INVISIBLE);
      this.j.setSoundEffectsEnabled(false);
      this.j.setOnClickListener(new View.OnClickListener() {
         @SuppressLint({"NewApi"})
         public final void onClick(View var1) {
            FlashlightActivity.this.i.setVisibility(View.INVISIBLE);
            Drawable var2 = FlashlightActivity.this.j.getDrawable();
            if(var2 instanceof AnimationDrawable) {
               ((AnimationDrawable)var2).stop();
               ((AnimationDrawable)var2).selectDrawable(0);
            }
         }
      });
      this.k = (ImageButton)this.findViewById(R.id.bt_sound);
      if(com.surpax.a.a.h == 1) {
         this.k.setBackgroundResource(R.drawable.sound_icon_enable_selector);
      } else {
         this.k.setBackgroundResource(R.drawable.sound_icon_disable_selector);
      }

      this.k.setSoundEffectsEnabled(false);
      this.k.setOnClickListener(new View.OnClickListener() {
         public final void onClick(View var1) {
            if(com.surpax.a.a.h == 1) {
               com.surpax.a.a.h = 0;
               FlashlightActivity.this.k.setBackgroundResource(R.drawable.sound_icon_disable_selector);
            } else {
               com.surpax.a.a.h = 1;
               FlashlightActivity.this.k.setBackgroundResource(R.drawable.sound_icon_enable_selector);
               FlashlightActivity.p.a(1);
            }
         }
      });
      LayoutParams var14 = new LayoutParams(this.r.w, this.r.x);
      var14.leftMargin = (int)this.r.u;
      var14.topMargin = (int)this.r.v;
      this.k.setLayoutParams(var14);
      this.setVolumeControlStream(3);
      if(VERSION.SDK_INT >= 8) {
         android.view.WindowManager.LayoutParams var15 = this.getWindow().getAttributes();
         var15.buttonBrightness = 1.0F;
         this.getWindow().setAttributes(var15);
      }

   }

   protected void onDestroy() {
      super.onDestroy();
      this.d = true;
      this.v.setVisibility(View.INVISIBLE);
      this.v.f();
      this.m = false;
      com.surpax.a.a.l = false;
      if(this.s != null) {
         this.s.f();
         this.s.b();
         this.s = null;
      }

      this.a("surpax_lighting_frequency", 0);
      com.surpax.a.b var1 = this.r;
      var1.led_bg.recycle();
      var1.led_bg = null;
      var1.led_indicator.recycle();
      var1.led_indicator = null;
      var1.num0.recycle();
      var1.num1.recycle();
      var1.num2.recycle();
      var1.num3.recycle();
      var1.num4.recycle();
      var1.num5.recycle();
      var1.num6.recycle();
      var1.num7.recycle();
      var1.num8.recycle();
      var1.num9.recycle();
      var1.num0 = null;
      var1.num1 = null;
      var1.num2 = null;
      var1.num3 = null;
      var1.num4 = null;
      var1.num5 = null;
      var1.num6 = null;
      var1.num7 = null;
      var1.num8 = null;
      var1.num9 = null;
      var1.led_knob.recycle();
      var1.led_knob = null;
      var1.know_shadow.recycle();
      var1.know_shadow = null;
      var1.led_switch.recycle();
      var1.led_switch = null;
      this.q.a();
      System.gc();

      try {
         Thread.sleep(350L);
      } catch (InterruptedException var2) {
         var2.printStackTrace();
      }
   }

   protected void onNewIntent(Intent var1) {
      super.onNewIntent(var1);
      this.setIntent(var1);
   }

   protected void onPause() {
      if(com.surpax.a.a.i == 1) {
         com.surpax.a.a.l = true;
      } else {
         com.surpax.a.a.l = false;
      }

      if(this.t && this.v != null && this.v.c()) {
         this.v.e();
      }

      com.surpax.a.a.g = 0;
      this.a("surpax_lighting_frequency", com.surpax.a.a.g);
      this.v.f();
      this.v.b();
      if(this.s != null) {
         this.s.f();
         this.s.b();
      }

      this.s = null;
      Intent var1 = new Intent();
      var1.setAction("com.surpax.action.RESTORE_WIDGET");
      this.sendBroadcast(var1);

      try {
         if(this.n != null) {
            this.n.dismiss();
            this.n = null;
         }
      } catch (Exception var2) {
         var2.printStackTrace();
      }

      com.surpax.a.a.i = 0;
      com.surpax.a.a.H = 0;
      com.surpax.a.a.u = false;
      com.surpax.a.a.B = false;
      this.a("surpax_light_state", com.surpax.a.a.j);
      this.a("surpax_sound_state", com.surpax.a.a.h);
      this.a("surpax_light_state_exit", com.surpax.a.a.k);
      com.surpax.a.a.z = 1;
      this.a(A, com.surpax.a.a.z);
      super.onPause();
   }

   protected void onRestart() {
      super.onRestart();
      this.c = false;
      this.m = true;
   }

   @TargetApi(11)
   protected void onResume() {
      int var1 = this.a("surpax_lighting_frequency");
      com.surpax.a.a.g = var1;
      if(var1 == -1) {
         com.surpax.a.a.g = 0;
      }

      com.surpax.a.a.j = this.a("surpax_light_state");
      if(-1 == com.surpax.a.a.j) {
         com.surpax.a.a.j = 0;
         com.surpax.a.a.u = true;
      }

      com.surpax.a.a.i = com.surpax.a.a.j;
      var1 = this.a("surpax_sound_state");
      com.surpax.a.a.h = var1;
      if(var1 == -1) {
         com.surpax.a.a.h = 1;
      }

      var1 = this.a("surpax_light_state_exit");
      com.surpax.a.a.k = var1;
      if(var1 == -1) {
         com.surpax.a.a.k = 1;
      }

      com.surpax.a.a.z = this.a(com.surpax.a.a.A);
      com.surpax.a.a.r = false;
      Context var3 = this.getApplicationContext();
      if(this.v == null) {
         this.v = new com.surpax.d.a(var3);
         ((RelativeLayout)this.findViewById(R.id.root_view)).addView(this.v);
      }

      this.v.a();
      super.onResume();
      this.v.setVisibility(View.VISIBLE);
      RelativeLayout var6 = (RelativeLayout)this.findViewById(R.id.surfaceHolder);
      LayoutParams var4 = new LayoutParams(1, 1);
      this.f = null;
      this.f = new SurfaceView(this);
      var6.removeAllViews();
      var6.addView(this.f, var4);
      this.s = new com.surpax.c.a.c();
      this.s.a();
      if(com.surpax.a.a.H != 0) {
         com.surpax.a.a.i = 1;
         if(com.surpax.a.a.h == 1) {
            this.a(1);
         }
      }

      if(this.m && com.surpax.a.a.l) {
         com.surpax.a.a.i = 1;
      }

      Intent var7 = this.getIntent();
      if(var7 != null) {
         boolean var2 = var7.getBooleanExtra("intent.extra.led.on", false);
         if(var2) {
            com.surpax.a.a.i = 1;
         }

         (new StringBuilder("open is ")).append(var2).toString();
         var7.putExtra("intent.extra.led.on", false);
      }

      this.t = this.s.c();
      if(this.t) {
         com.surpax.a.a.i = 0;
      }

      if(this.t) {
         this.f.setVisibility(View.INVISIBLE);
         var6 = (RelativeLayout)this.findViewById(R.id.root_view);
         var4 = new LayoutParams(-1, -1);
         var4.addRule(2);
         View var5 = ((LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.halftrans, (ViewGroup)null);
         var6.addView(var5, var4);
         this.u = var5.findViewById(R.id.cover_view);
         this.u.setVisibility(View.INVISIBLE);
      }

      if(this.v != null && !this.s.c()) {
         this.v.g();
      }
   }

   protected void onStart() {
      super.onStart();
      this.w = ((PowerManager)this.getSystemService(Context.POWER_SERVICE)).newWakeLock(268435457, this.getClass().getCanonicalName());
      this.w.acquire();
   }

   protected void onStop() {
      super.onStop();
      (new StringBuilder("flashlightactivity stop entrance, time = ")).append(System.currentTimeMillis()).toString();
      this.v.setVisibility(View.INVISIBLE);
      System.gc();
      this.w.release();
      this.w = null;
   }

   public boolean onTouchEvent(MotionEvent var1) {
      switch(var1.getAction()) {
      case 0:
         try {
            if(this.t && this.v != null && this.v.c()) {
               this.v.d();
            }
         } catch (Exception var3) {
            var3.printStackTrace();
         }
      default:
         return super.onTouchEvent(var1);
      }
   }
}
