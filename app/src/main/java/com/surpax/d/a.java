package com.surpax.d;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;

import com.surpax.ledflashlight.FlashlightActivity;

public final class a extends View implements OnDoubleTapListener, OnGestureListener, OnClickListener {
   private GestureDetector mGestureDetector = null;
   private PaintFlagsDrawFilter mPaintFlagsDrawFilter;
   private Paint mPaint;
   private Matrix mMatrix;
   private float mFloat1;
   private float mFloat2;
   private int mInt1;
   private float mFloat3;
   private boolean mBoolean1;
   private boolean mBoolean2 = false;
   private boolean mBoolean3 = false;
   private boolean mBoolean4;
   private boolean mBoolean5;
   private boolean mBoolean6;
   private boolean mBoolean7;
   private boolean mBoolean8;
   private boolean mBoolean9;
   private boolean mBoolean10;
   private int lightNum;
   private Handler mHandler;
   private boolean u;

   public a(Context var1) {
      super(var1);
      this.setFocusable(true);
      this.setFocusableInTouchMode(true);
      this.mGestureDetector = new GestureDetector(this);
      this.mGestureDetector.setOnDoubleTapListener(this);
      this.mPaintFlagsDrawFilter = new PaintFlagsDrawFilter(0, 3);
      this.mPaint = new Paint();
      this.mMatrix = new Matrix();
      this.mBoolean2 = false;
      this.mBoolean5 = true;
      this.mBoolean4 = false;
      this.mBoolean3 = false;
      this.mBoolean9 = false;
      this.mBoolean8 = false;
      this.mBoolean10 = false;
      this.lightNum = 0;
      this.mFloat2 = (float)(com.surpax.a.a.o * com.surpax.a.a.lightNum * 2);
      this.mInt1 = com.surpax.a.a.lightNum * 2;
      this.mFloat3 = (float)(com.surpax.a.a.o / 2);
      this.mHandler = new com.surpax.d.b() {
         public final void handleMessage(Message var1) {
            super.handleMessage(var1);
            switch(var1.what) {
            case 0:
               FlashlightActivity.getFlashlightActivityInstance().a(false);
               FlashlightActivity.getFlashlightActivityInstance().d();
               a.this.mBoolean9 = true;
               a.this.mBoolean8 = true;
               a.this.postInvalidate();
               return;
            case 1:
               FlashlightActivity.getFlashlightActivityInstance().e();
               return;
            case 2:
               FlashlightActivity.getFlashlightActivityInstance().a(true);
               FlashlightActivity.getFlashlightActivityInstance().f();
               a.this.mBoolean8 = false;
               com.surpax.d.a.a(a.this, 0.0F);
               a.this.mBoolean9 = false;
               com.surpax.d.a.d(a.this, true);
               com.surpax.d.a.e(a.this, false);
               com.surpax.d.a.f(a.this, false);
               a.this.postInvalidate();
               return;
            case 3:
               FlashlightActivity.getFlashlightActivityInstance().i();
               com.surpax.d.a.a(a.this, true);
               return;
            case 4:
               FlashlightActivity.getFlashlightActivityInstance().a(true);
               FlashlightActivity.getFlashlightActivityInstance().f();
               a.this.mBoolean8 = false;
               com.surpax.d.a.a(a.this, 0.0F);
               a.this.mBoolean9 = false;
               com.surpax.d.a.d(a.this, true);
               com.surpax.d.a.e(a.this, false);
               com.surpax.d.a.f(a.this, false);
               com.surpax.d.a.a(a.this, false);
               return;
            default:
            }
         }
      };
      if(com.surpax.a.a.i == 1) {
         this.mFloat1 = (float)com.surpax.a.a.m;
         this.mBoolean8 = true;
         this.mBoolean9 = true;
         this.mBoolean5 = false;
         this.mBoolean4 = true;
         this.mBoolean2 = true;
      }

      (new Thread() {
         public final void run() {
            super.run();

            while(!FlashlightActivity.getFlashlightActivityInstance().lightSwitch) {
               if(a.this.lightNum > 0) {
                  int var1;
                  com.surpax.d.a var2;
                  if(a.this.mBoolean10) {
                     var2 = a.this;
                     var1 = var2.lightNum - 1;
                     var2.lightNum = var1;
                     com.surpax.a.a.lightNum = 9 - var1;
                  } else {
                     var2 = a.this;
                     var1 = var2.lightNum - 1;
                     var2.lightNum = var1;
                     com.surpax.a.a.lightNum = var1;
                  }

                  a.this.postInvalidate();
               }

               try {
                  Thread.sleep(50L);
               } catch (InterruptedException var3) {
                  var3.printStackTrace();
               }
            }

         }
      }).start();
   }

   // $FF: synthetic method
   static void a(com.surpax.d.a var0, float var1) {
      var0.mFloat1 = var1;
   }

   // $FF: synthetic method
   static void a(final com.surpax.d.a var0, final boolean var1) {
      AnimationSet var3 = new AnimationSet(true);
      AlphaAnimation var2;
      if(var1) {
         var2 = new AlphaAnimation(0.0F, 1.0F);
      } else {
         var2 = new AlphaAnimation(1.0F, 0.0F);
      }

      var2.setDuration(700L);
      var2.setFillAfter(true);
      var2.setInterpolator(new AccelerateInterpolator());
      var3.addAnimation(var2);
      var3.setAnimationListener(new AnimationListener() {
         public final void onAnimationEnd(Animation var1x) {
            FlashlightActivity.getFlashlightActivityInstance().h().setVisibility(View.INVISIBLE);
            Message var2 = new Message();
            if(var1) {
               var2.what = 0;
            } else {
               var2.what = 2;
            }

            var0.mHandler.sendMessage(var2);
            var0.postInvalidate();
         }

         public final void onAnimationRepeat(Animation var1x) {
         }

         public final void onAnimationStart(Animation var1x) {
            FlashlightActivity.getFlashlightActivityInstance().h().setBackgroundColor(-1);
            var0.postInvalidate();
         }
      });
      FlashlightActivity.getFlashlightActivityInstance().h().setVisibility(View.VISIBLE);
      FlashlightActivity.getFlashlightActivityInstance().h().startAnimation(var3);
   }

   // $FF: synthetic method
   static void d(com.surpax.d.a var0, boolean var1) {
      var0.mBoolean5 = var1;
   }

   // $FF: synthetic method
   static void e(com.surpax.d.a var0, boolean var1) {
      var0.mBoolean4 = var1;
   }

   // $FF: synthetic method
   static void f(com.surpax.d.a var0, boolean var1) {
      var0.mBoolean2 = var1;
   }

   // $FF: synthetic method
   static void g(com.surpax.d.a var0, boolean var1) {
      var0.mBoolean3 = var1;
   }

   public final void a() {
      (new Thread() {
         boolean a = false;

         public final void run() {
            while(!FlashlightActivity.getFlashlightActivityInstance().lightSwitch) {
               Log.e("yokong", "run: com.surpax.d.a.a()");
               Message var3;
               if(a.this.mBoolean9) {
                  if(!this.a) {
                     this.a = true;
                     if(com.surpax.a.a.s) {
                        a.this.mBoolean8 = true;
                        a.this.postInvalidate();
                        com.surpax.a.a.t = false;
                        FlashlightActivity.getFlashlightActivityInstance().runOnUiThread(new Runnable() {
                           public final void run() {
                              FlashlightActivity.getFlashlightActivityInstance().a(false);
                           }
                        });

                        try {
                           FlashlightActivity.getFlashlightActivityInstance().d();
                        } catch (Exception var8) {
                           var8.printStackTrace();
                        }
                     } else {
                        com.surpax.a.a.t = true;
                        var3 = new Message();
                        var3.what = 0;
                        if(a.this.mHandler != null) {
                           a.this.mHandler.sendMessage(var3);
                        }
                     }
                  }

                  if(com.surpax.a.a.lightNum == 0) {
                     a.this.mBoolean8 = true;
                     a.this.postInvalidate();

                     try {
                        Thread.sleep(100L);
                     } catch (InterruptedException var4) {
                        var4.printStackTrace();
                     }
                  } else {
                     this.a = false;
                     long var1 = com.surpax.a.a.a(com.surpax.a.a.lightNum);

                     try {
                        Thread.sleep(var1);
                     } catch (InterruptedException var7) {
                        var7.printStackTrace();
                     }

                     if(com.surpax.a.a.s) {
                        com.surpax.a.a.t = false;

                        try {
                           FlashlightActivity.getFlashlightActivityInstance().e();
                        } catch (Exception var6) {
                           var6.printStackTrace();
                        }
                     } else {
                        com.surpax.a.a.t = true;
                        var3 = new Message();
                        var3.what = 1;
                        if(a.this.mHandler != null) {
                           a.this.mHandler.sendMessage(var3);
                        }
                     }

                     a.this.mBoolean8 = false;
                     a.this.postInvalidate();

                     try {
                        Thread.sleep(var1);
                     } catch (InterruptedException var5) {
                        var5.printStackTrace();
                     }
                  }
               } else if(a.this.mBoolean3) {
                  com.surpax.d.a.g(a.this, false);
                  a.this.mBoolean9 = false;
                  this.a = false;
                  if(com.surpax.a.a.s) {
                     FlashlightActivity.getFlashlightActivityInstance().runOnUiThread(new Runnable() {
                        public final void run() {
                           FlashlightActivity.getFlashlightActivityInstance().a(true);
                        }
                     });

                     try {
                        FlashlightActivity.getFlashlightActivityInstance().f();
                     } catch (Exception var9) {
                        var9.printStackTrace();
                     }

                     com.surpax.d.a.a(a.this, 0.0F);
                     com.surpax.d.a.d(a.this, true);
                     com.surpax.d.a.e(a.this, false);
                     com.surpax.d.a.f(a.this, false);
                  } else {
                     var3 = new Message();
                     var3.what = 2;
                     if(a.this.mHandler != null) {
                        a.this.mHandler.sendMessage(var3);
                     }
                  }

                  a.this.mBoolean8 = false;
                  a.this.postInvalidate();
               } else {
                  this.a = false;

                  try {
                     Thread.sleep(100L);
                  } catch (InterruptedException var10) {
                     var10.printStackTrace();
                  }
               }
            }

         }
      }).start();
   }

   public final void b() {
      this.mHandler.removeCallbacksAndMessages((Object)null);
      this.mBoolean9 = false;
   }

   public final boolean c() {
      return this.mBoolean9;
   }

   public final void d() {
      this.mBoolean8 = false;
      this.mFloat1 = 0.0F;
      this.mBoolean9 = false;
      this.mBoolean6 = false;
      this.mBoolean1 = false;
      this.mBoolean5 = true;
      this.mBoolean4 = false;
      this.mBoolean2 = true;
      com.surpax.a.a.i = 0;
      Message var1 = new Message();
      var1.what = 4;
      this.mHandler.sendMessage(var1);
      if(1 == com.surpax.a.a.h) {
         FlashlightActivity.getFlashlightActivityInstance().a(1);
      }

   }

   public final void draw(Canvas var1) {
      super.draw(var1);
      var1.setDrawFilter(this.mPaintFlagsDrawFilter);
      this.mMatrix.reset();
      this.mMatrix.postTranslate(0.0F, 0.0F);
      this.mMatrix.postScale(FlashlightActivity.getFlashlightActivityInstance().g, FlashlightActivity.getFlashlightActivityInstance().h);
      var1.drawBitmap(FlashlightActivity.getFlashlightActivityInstance().b().led_bg, this.mMatrix, this.mPaint);
      this.mMatrix.reset();
      this.mMatrix.postTranslate(FlashlightActivity.getFlashlightActivityInstance().b().c, FlashlightActivity.getFlashlightActivityInstance().b().d + this.mFloat1);
      this.mMatrix.postScale(FlashlightActivity.getFlashlightActivityInstance().g, FlashlightActivity.getFlashlightActivityInstance().h);
      var1.drawBitmap(FlashlightActivity.getFlashlightActivityInstance().b().led_switch, this.mMatrix, this.mPaint);
      this.mMatrix.reset();
      this.mMatrix.postTranslate(FlashlightActivity.getFlashlightActivityInstance().b().J + this.mFloat2, FlashlightActivity.getFlashlightActivityInstance().b().K);
      this.mMatrix.postScale(FlashlightActivity.getFlashlightActivityInstance().g, FlashlightActivity.getFlashlightActivityInstance().h);
      var1.drawBitmap(FlashlightActivity.getFlashlightActivityInstance().b().led_knob, this.mMatrix, this.mPaint);
      this.mMatrix.reset();
      this.mMatrix.postTranslate(FlashlightActivity.getFlashlightActivityInstance().b().E, FlashlightActivity.getFlashlightActivityInstance().b().F);
      this.mMatrix.postScale(FlashlightActivity.getFlashlightActivityInstance().g, FlashlightActivity.getFlashlightActivityInstance().h);
      var1.drawBitmap(FlashlightActivity.getFlashlightActivityInstance().b().know_shadow, this.mMatrix, this.mPaint);
      this.mMatrix.reset();
      this.mMatrix.postTranslate(FlashlightActivity.getFlashlightActivityInstance().b().q, FlashlightActivity.getFlashlightActivityInstance().b().r);
      this.mMatrix.postScale(FlashlightActivity.getFlashlightActivityInstance().g, FlashlightActivity.getFlashlightActivityInstance().h);
      com.surpax.a.b var2 = FlashlightActivity.getFlashlightActivityInstance().b();
      Bitmap var3;
      switch(com.surpax.a.a.lightNum) {
      case 0:
         var3 = var2.num0;
         break;
      case 1:
         var3 = var2.num1;
         break;
      case 2:
         var3 = var2.num2;
         break;
      case 3:
         var3 = var2.num3;
         break;
      case 4:
         var3 = var2.num4;
         break;
      case 5:
         var3 = var2.num5;
         break;
      case 6:
         var3 = var2.num6;
         break;
      case 7:
         var3 = var2.num7;
         break;
      case 8:
         var3 = var2.num8;
         break;
      case 9:
         var3 = var2.num9;
         break;
      default:
         var3 = var2.num0;
      }

      var1.drawBitmap(var3, this.mMatrix, this.mPaint);
      if(this.mBoolean8) {
         this.mMatrix.reset();
         this.mMatrix.postTranslate(FlashlightActivity.getFlashlightActivityInstance().b().z, FlashlightActivity.getFlashlightActivityInstance().b().A + this.mFloat1);
         this.mMatrix.postScale(FlashlightActivity.getFlashlightActivityInstance().g, FlashlightActivity.getFlashlightActivityInstance().h);
         var1.drawBitmap(FlashlightActivity.getFlashlightActivityInstance().b().led_indicator, this.mMatrix, this.mPaint);
      }

   }

   public final void e() {
      FlashlightActivity.getFlashlightActivityInstance().a(true);
      FlashlightActivity.getFlashlightActivityInstance().f();
      this.mBoolean8 = false;
      this.mBoolean9 = false;
      this.mBoolean8 = false;
      this.mFloat1 = 0.0F;
      this.mBoolean5 = true;
      this.mBoolean4 = false;
      this.mBoolean2 = false;
   }

   public final void f() {
      this.mBoolean8 = false;
      this.mBoolean9 = false;
      this.mBoolean8 = false;
      this.mFloat1 = 0.0F;
      this.mBoolean5 = true;
      this.mBoolean4 = false;
      this.mBoolean2 = false;
      this.u = false;
   }

   public final void g() {
      if(com.surpax.a.a.i == 1 && !this.mBoolean9) {
         this.mFloat1 = (float)com.surpax.a.a.m;
         this.mBoolean8 = true;
         this.mBoolean9 = true;
         this.mBoolean5 = false;
         this.mBoolean4 = true;
         this.mBoolean2 = true;
      }

   }

   public final void onClick(View var1) {
   }

   public final boolean onDoubleTap(MotionEvent var1) {
      return false;
   }

   public final boolean onDoubleTapEvent(MotionEvent var1) {
      return false;
   }

   public final boolean onDown(MotionEvent var1) {
      boolean var3 = true;
      this.mBoolean6 = false;
      this.mBoolean1 = false;
      boolean var2;
      if(var1.getX() >= FlashlightActivity.getFlashlightActivityInstance().b().J * FlashlightActivity.getFlashlightActivityInstance().g && var1.getX() <= (float)FlashlightActivity.getFlashlightActivityInstance().e && var1.getY() >= FlashlightActivity.getFlashlightActivityInstance().b().K * FlashlightActivity.getFlashlightActivityInstance().h && var1.getY() <= FlashlightActivity.getFlashlightActivityInstance().b().K * FlashlightActivity.getFlashlightActivityInstance().h + FlashlightActivity.getFlashlightActivityInstance().b().M * FlashlightActivity.getFlashlightActivityInstance().h) {
         this.mBoolean6 = true;
         var2 = true;
      } else {
         var2 = false;
      }

      if(!var2) {
         if(var1.getX() >= FlashlightActivity.getFlashlightActivityInstance().b().c * FlashlightActivity.getFlashlightActivityInstance().g && var1.getX() <= FlashlightActivity.getFlashlightActivityInstance().b().c * FlashlightActivity.getFlashlightActivityInstance().g + (float)FlashlightActivity.getFlashlightActivityInstance().b().e * FlashlightActivity.getFlashlightActivityInstance().g && var1.getY() >= FlashlightActivity.getFlashlightActivityInstance().b().d * FlashlightActivity.getFlashlightActivityInstance().h + this.mFloat1 && var1.getY() <= FlashlightActivity.getFlashlightActivityInstance().b().d * FlashlightActivity.getFlashlightActivityInstance().h + this.mFloat1 + (float)FlashlightActivity.getFlashlightActivityInstance().b().f * FlashlightActivity.getFlashlightActivityInstance().h) {
            this.mBoolean1 = true;
            var2 = var3;
         } else {
            var2 = false;
         }

         if(!var2) {
            this.mBoolean6 = false;
            this.mBoolean1 = false;
            return false;
         }
      }

      return false;
   }

   public final boolean onFling(MotionEvent var1, MotionEvent var2, float var3, float var4) {
      return true;
   }

   public final void onLongPress(MotionEvent var1) {
   }

   public final boolean onScroll(MotionEvent var1, MotionEvent var2, float var3, float var4) {
      if(this.mBoolean6) {
         this.mFloat2 -= var3;
         if(this.mFloat2 <= 0.0F) {
            if(this.mFloat2 < (float)(-com.surpax.a.a.o / 4)) {
               this.mFloat2 = (float)(-com.surpax.a.a.o / 4);
            }

            this.mInt1 = 0;
            this.mBoolean10 = false;
            this.lightNum = com.surpax.a.a.lightNum;
            com.surpax.a.a.lightNum = 0;
            if(!this.mBoolean7 && 1 == com.surpax.a.a.h) {
               FlashlightActivity.getFlashlightActivityInstance().a(3);
               this.mBoolean7 = true;
            }
         } else if(this.mFloat2 >= (float)com.surpax.a.a.n) {
            if(this.mFloat2 > (float)(com.surpax.a.a.n + com.surpax.a.a.o / 4)) {
               this.mFloat2 = (float)(com.surpax.a.a.n + com.surpax.a.a.o / 4);
            }

            this.mInt1 = 9;
            this.mBoolean10 = true;
            this.lightNum = 9 - com.surpax.a.a.lightNum;
            com.surpax.a.a.lightNum = 9;
            if(!this.mBoolean7 && 1 == com.surpax.a.a.h) {
               FlashlightActivity.getFlashlightActivityInstance().a(3);
               this.mBoolean7 = true;
            }
         } else {
            int var5 = (int)Math.ceil((double)(this.mFloat2 / (float)com.surpax.a.a.o));
            int var6 = (int)Math.floor((double)(this.mFloat2 / (float)com.surpax.a.a.o));
            if(var6 >= this.mInt1 && var5 > this.mInt1) {
               if(1 == var6 - this.mInt1) {
                  this.mInt1 = var6;
                  com.surpax.a.a.lightNum = this.mInt1;
                  if(1 == com.surpax.a.a.h) {
                     FlashlightActivity.getFlashlightActivityInstance().a(2);
                  }
               }
            } else if(var5 <= this.mInt1 && var6 < this.mInt1 && 1 == this.mInt1 - var5) {
               this.mInt1 = var5;
               com.surpax.a.a.lightNum = this.mInt1;
               if(1 == com.surpax.a.a.h) {
                  FlashlightActivity.getFlashlightActivityInstance().a(2);
               }
            }
         }

         this.invalidate();
      } else if(this.mBoolean1) {
         this.mFloat1 -= var4;
         Message var7;
         if(this.mFloat1 >= 0.0F) {
            this.mFloat1 = 0.0F;
            if(this.mBoolean2 && this.mBoolean9) {
               if(FlashlightActivity.getFlashlightActivityInstance().g()) {
                  var7 = new Message();
                  var7.what = 4;
                  this.mHandler.sendMessage(var7);
               } else {
                  this.mBoolean3 = true;
               }

               if(1 == com.surpax.a.a.h) {
                  FlashlightActivity.getFlashlightActivityInstance().a(1);
               }
            }

            if(!FlashlightActivity.getFlashlightActivityInstance().g() && !this.mBoolean3) {
               this.mBoolean3 = true;
               if(!this.mBoolean5 && 1 == com.surpax.a.a.h) {
                  FlashlightActivity.getFlashlightActivityInstance().a(1);
               }
            }

            this.mBoolean2 = false;
            this.mBoolean9 = false;
            this.mBoolean8 = false;
            this.mBoolean4 = false;
            this.mBoolean5 = true;
            com.surpax.a.a.i = 0;
         } else if(this.mFloat1 < (float)com.surpax.a.a.m) {
            this.mBoolean8 = true;
            if(!this.mBoolean2 && !this.mBoolean9) {
               com.surpax.a.a.i = 1;
               if(FlashlightActivity.getFlashlightActivityInstance().g()) {
                  var7 = new Message();
                  var7.what = 3;
                  this.mHandler.sendMessage(var7);
               } else {
                  this.mBoolean9 = true;
               }

               if(1 == com.surpax.a.a.h) {
                  FlashlightActivity.getFlashlightActivityInstance().a(1);
               }

               this.mBoolean2 = true;
            }

            if(!FlashlightActivity.getFlashlightActivityInstance().g() && !this.mBoolean9) {
               this.mBoolean9 = true;
               if(!this.mBoolean4 && 1 == com.surpax.a.a.h) {
                  FlashlightActivity.getFlashlightActivityInstance().a(1);
               }
            }

            this.mFloat1 = (float)com.surpax.a.a.m;
            this.mBoolean5 = false;
            this.mBoolean4 = true;
         } else if(!this.mBoolean4 && this.mFloat1 < (float)(com.surpax.a.a.m / 2)) {
            this.mBoolean8 = true;
            this.mBoolean4 = true;
            this.mBoolean5 = false;
            com.surpax.a.a.i = 1;
            if(FlashlightActivity.getFlashlightActivityInstance().g()) {
               var7 = new Message();
               var7.what = 3;
               this.mHandler.sendMessage(var7);
               this.mBoolean2 = true;
            } else {
               this.mBoolean9 = true;
            }

            if(1 == com.surpax.a.a.h) {
               FlashlightActivity.getFlashlightActivityInstance().a(1);
            }
         } else if(!this.mBoolean5 && this.mFloat1 > (float)(com.surpax.a.a.m / 2)) {
            this.mBoolean5 = true;
            this.mBoolean4 = false;
            this.mBoolean9 = false;
            this.mBoolean8 = false;
            com.surpax.a.a.i = 0;
            this.mBoolean3 = true;
            if(1 == com.surpax.a.a.h) {
               FlashlightActivity.getFlashlightActivityInstance().a(1);
            }

            this.mBoolean2 = false;
            this.u = true;
            if(1 == FlashlightActivity.getFlashlightActivityInstance().b) {
               FlashlightActivity.getFlashlightActivityInstance().c = true;
            }
         }

         this.invalidate();
      }

      this.invalidate();
      return false;
   }

   public final void onShowPress(MotionEvent var1) {
   }

   public final boolean onSingleTapConfirmed(MotionEvent var1) {
      return false;
   }

   public final boolean onSingleTapUp(MotionEvent var1) {
      return false;
   }

   @SuppressLint({"ClickableViewAccessibility"})
   public final boolean onTouchEvent(MotionEvent var1) {
      super.onTouchEvent(var1);
      if(this.mGestureDetector != null) {
         this.mGestureDetector.onTouchEvent(var1);
      }
      switch(var1.getAction()) {
      case 0:
         com.surpax.b.a.b = true;
         return true;
      case 1:
         if(this.mBoolean1) {
            if(this.mFloat1 > (float)(com.surpax.a.a.m / 2)) {
               this.mFloat1 = 0.0F;
               this.mBoolean5 = true;
               this.mBoolean4 = false;
               this.mBoolean8 = false;
               this.mBoolean9 = false;
               this.mBoolean3 = true;
            } else {
               this.mFloat1 = (float)com.surpax.a.a.m;
               this.mBoolean5 = false;
               this.mBoolean4 = true;
               this.mBoolean8 = true;
               this.mBoolean9 = true;
               this.mBoolean3 = false;
            }

            (new StringBuilder("lighting state is ")).append(this.mBoolean9).toString();
         } else if(this.mBoolean6) {
            if(this.mFloat2 < 0.0F) {
               this.mFloat2 = 0.0F;
            }

            if(this.mFloat2 > (float)(com.surpax.a.a.o * 9)) {
               this.mFloat2 = (float)(com.surpax.a.a.o * 9);
            }

            float var2 = (float)(this.mInt1 * com.surpax.a.a.o);
            if(this.mFloat2 > var2) {
               if(this.mFloat2 - var2 >= this.mFloat3) {
                  ++this.mInt1;
                  if(1 == com.surpax.a.a.h) {
                     FlashlightActivity.getFlashlightActivityInstance().a(2);
                  }

                  com.surpax.a.a.lightNum = this.mInt1;
               }
            } else if(var2 - this.mFloat2 >= this.mFloat3) {
               --this.mInt1;
               if(1 == com.surpax.a.a.h) {
                  FlashlightActivity.getFlashlightActivityInstance().a(2);
               }

               com.surpax.a.a.lightNum = this.mInt1;
            }

            switch(this.mInt1) {
            case 0:
               this.mFloat2 = 0.0F;
               break;
            case 1:
               this.mFloat2 = (float)(com.surpax.a.a.o * 1);
               break;
            case 2:
               this.mFloat2 = (float)(com.surpax.a.a.o * 2);
               break;
            case 3:
               this.mFloat2 = (float)(com.surpax.a.a.o * 3);
               break;
            case 4:
               this.mFloat2 = (float)(com.surpax.a.a.o * 4);
               break;
            case 5:
               this.mFloat2 = (float)(com.surpax.a.a.o * 5);
               break;
            case 6:
               this.mFloat2 = (float)(com.surpax.a.a.o * 6);
               break;
            case 7:
               this.mFloat2 = (float)(com.surpax.a.a.o * 7);
               break;
            case 8:
               this.mFloat2 = (float)(com.surpax.a.a.o * 8);
               break;
            case 9:
               this.mFloat2 = (float)(com.surpax.a.a.o * 9);
               break;
            default:
               this.mFloat2 = (float)(com.surpax.a.a.o * 9);
            }

            this.mBoolean7 = false;
            this.invalidate();
         }

         this.invalidate();
         this.mBoolean6 = false;
         this.mBoolean1 = false;
         this.mBoolean7 = false;
         this.postInvalidate();
         return true;
      default:
         return true;
      }
   }
}
