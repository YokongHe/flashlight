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
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.OnGestureListener;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Animation.AnimationListener;
import com.surpax.ledflashlight.FlashlightActivity;

public final class a extends View implements OnDoubleTapListener, OnGestureListener, OnClickListener {
   private GestureDetector a = null;
   private PaintFlagsDrawFilter b;
   private Paint c;
   private Matrix d;
   private float e;
   private float f;
   private int g;
   private float h;
   private boolean i;
   private boolean j = false;
   private boolean k = false;
   private boolean l;
   private boolean m;
   private boolean n;
   private boolean o;
   private boolean p;
   private boolean q;
   private boolean r;
   private int s;
   private Handler t;
   private boolean u;

   public a(Context var1) {
      super(var1);
      this.setFocusable(true);
      this.setFocusableInTouchMode(true);
      this.a = new GestureDetector(this);
      this.a.setOnDoubleTapListener(this);
      this.b = new PaintFlagsDrawFilter(0, 3);
      this.c = new Paint();
      this.d = new Matrix();
      this.j = false;
      this.m = true;
      this.l = false;
      this.k = false;
      this.q = false;
      this.p = false;
      this.r = false;
      this.s = 0;
      this.f = (float)(com.surpax.a.a.o * com.surpax.a.a.g * 2);
      this.g = com.surpax.a.a.g * 2;
      this.h = (float)(com.surpax.a.a.o / 2);
      this.t = new com.surpax.d.b() {
         public final void handleMessage(Message var1) {
            super.handleMessage(var1);
            switch(var1.what) {
            case 0:
               FlashlightActivity.a().a(false);
               FlashlightActivity.a().d();
               a.this.q = true;
               a.this.p = true;
               a.this.postInvalidate();
               return;
            case 1:
               FlashlightActivity.a().e();
               return;
            case 2:
               FlashlightActivity.a().a(true);
               FlashlightActivity.a().f();
               a.this.p = false;
               com.surpax.d.a.a(a.this, 0.0F);
               a.this.q = false;
               com.surpax.d.a.d(a.this, true);
               com.surpax.d.a.e(a.this, false);
               com.surpax.d.a.f(a.this, false);
               a.this.postInvalidate();
               return;
            case 3:
               FlashlightActivity.a().i();
               com.surpax.d.a.a(a.this, true);
               return;
            case 4:
               FlashlightActivity.a().a(true);
               FlashlightActivity.a().f();
               a.this.p = false;
               com.surpax.d.a.a(a.this, 0.0F);
               a.this.q = false;
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
         this.e = (float)com.surpax.a.a.m;
         this.p = true;
         this.q = true;
         this.m = false;
         this.l = true;
         this.j = true;
      }

      (new Thread() {
         public final void run() {
            super.run();

            while(!FlashlightActivity.a().d) {
               if(a.this.s > 0) {
                  int var1;
                  com.surpax.d.a var2;
                  if(a.this.r) {
                     var2 = a.this;
                     var1 = var2.s - 1;
                     var2.s = var1;
                     com.surpax.a.a.g = 9 - var1;
                  } else {
                     var2 = a.this;
                     var1 = var2.s - 1;
                     var2.s = var1;
                     com.surpax.a.a.g = var1;
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
      var0.e = 0.0F;
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
            FlashlightActivity.a().h().setVisibility(View.INVISIBLE);
            Message var2 = new Message();
            if(var1) {
               var2.what = 0;
            } else {
               var2.what = 2;
            }

            var0.t.sendMessage(var2);
            var0.postInvalidate();
         }

         public final void onAnimationRepeat(Animation var1x) {
         }

         public final void onAnimationStart(Animation var1x) {
            FlashlightActivity.a().h().setBackgroundColor(-1);
            var0.postInvalidate();
         }
      });
      FlashlightActivity.a().h().setVisibility(View.VISIBLE);
      FlashlightActivity.a().h().startAnimation(var3);
   }

   // $FF: synthetic method
   static void d(com.surpax.d.a var0, boolean var1) {
      var0.m = true;
   }

   // $FF: synthetic method
   static void e(com.surpax.d.a var0, boolean var1) {
      var0.l = false;
   }

   // $FF: synthetic method
   static void f(com.surpax.d.a var0, boolean var1) {
      var0.j = false;
   }

   // $FF: synthetic method
   static void g(com.surpax.d.a var0, boolean var1) {
      var0.k = false;
   }

   public final void a() {
      (new Thread() {
         boolean a = false;

         public final void run() {
            while(!FlashlightActivity.a().d) {
               Message var3;
               if(a.this.q) {
                  if(!this.a) {
                     this.a = true;
                     if(com.surpax.a.a.s) {
                        a.this.p = true;
                        a.this.postInvalidate();
                        com.surpax.a.a.t = false;
                        FlashlightActivity.a().runOnUiThread(new Runnable() {
                           public final void run() {
                              FlashlightActivity.a().a(false);
                           }
                        });

                        try {
                           FlashlightActivity.a().d();
                        } catch (Exception var8) {
                           var8.printStackTrace();
                        }
                     } else {
                        com.surpax.a.a.t = true;
                        var3 = new Message();
                        var3.what = 0;
                        if(a.this.t != null) {
                           a.this.t.sendMessage(var3);
                        }
                     }
                  }

                  if(com.surpax.a.a.g == 0) {
                     a.this.p = true;
                     a.this.postInvalidate();

                     try {
                        Thread.sleep(100L);
                     } catch (InterruptedException var4) {
                        var4.printStackTrace();
                     }
                  } else {
                     this.a = false;
                     long var1 = com.surpax.a.a.a(com.surpax.a.a.g);

                     try {
                        Thread.sleep(var1);
                     } catch (InterruptedException var7) {
                        var7.printStackTrace();
                     }

                     if(com.surpax.a.a.s) {
                        com.surpax.a.a.t = false;

                        try {
                           FlashlightActivity.a().e();
                        } catch (Exception var6) {
                           var6.printStackTrace();
                        }
                     } else {
                        com.surpax.a.a.t = true;
                        var3 = new Message();
                        var3.what = 1;
                        if(a.this.t != null) {
                           a.this.t.sendMessage(var3);
                        }
                     }

                     a.this.p = false;
                     a.this.postInvalidate();

                     try {
                        Thread.sleep(var1);
                     } catch (InterruptedException var5) {
                        var5.printStackTrace();
                     }
                  }
               } else if(a.this.k) {
                  com.surpax.d.a.g(a.this, false);
                  a.this.q = false;
                  this.a = false;
                  if(com.surpax.a.a.s) {
                     FlashlightActivity.a().runOnUiThread(new Runnable() {
                        public final void run() {
                           FlashlightActivity.a().a(true);
                        }
                     });

                     try {
                        FlashlightActivity.a().f();
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
                     if(a.this.t != null) {
                        a.this.t.sendMessage(var3);
                     }
                  }

                  a.this.p = false;
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
      this.t.removeCallbacksAndMessages((Object)null);
      this.q = false;
   }

   public final boolean c() {
      return this.q;
   }

   public final void d() {
      this.p = false;
      this.e = 0.0F;
      this.q = false;
      this.n = false;
      this.i = false;
      this.m = true;
      this.l = false;
      this.j = true;
      com.surpax.a.a.i = 0;
      Message var1 = new Message();
      var1.what = 4;
      this.t.sendMessage(var1);
      if(1 == com.surpax.a.a.h) {
         FlashlightActivity.a().a(1);
      }

   }

   public final void draw(Canvas var1) {
      super.draw(var1);
      var1.setDrawFilter(this.b);
      this.d.reset();
      this.d.postTranslate(0.0F, 0.0F);
      this.d.postScale(FlashlightActivity.a().g, FlashlightActivity.a().h);
      var1.drawBitmap(FlashlightActivity.a().b().a, this.d, this.c);
      this.d.reset();
      this.d.postTranslate(FlashlightActivity.a().b().c, FlashlightActivity.a().b().d + this.e);
      this.d.postScale(FlashlightActivity.a().g, FlashlightActivity.a().h);
      var1.drawBitmap(FlashlightActivity.a().b().b, this.d, this.c);
      this.d.reset();
      this.d.postTranslate(FlashlightActivity.a().b().J + this.f, FlashlightActivity.a().b().K);
      this.d.postScale(FlashlightActivity.a().g, FlashlightActivity.a().h);
      var1.drawBitmap(FlashlightActivity.a().b().I, this.d, this.c);
      this.d.reset();
      this.d.postTranslate(FlashlightActivity.a().b().E, FlashlightActivity.a().b().F);
      this.d.postScale(FlashlightActivity.a().g, FlashlightActivity.a().h);
      var1.drawBitmap(FlashlightActivity.a().b().D, this.d, this.c);
      this.d.reset();
      this.d.postTranslate(FlashlightActivity.a().b().q, FlashlightActivity.a().b().r);
      this.d.postScale(FlashlightActivity.a().g, FlashlightActivity.a().h);
      com.surpax.a.b var2 = FlashlightActivity.a().b();
      Bitmap var3;
      switch(com.surpax.a.a.g) {
      case 0:
         var3 = var2.g;
         break;
      case 1:
         var3 = var2.h;
         break;
      case 2:
         var3 = var2.i;
         break;
      case 3:
         var3 = var2.j;
         break;
      case 4:
         var3 = var2.k;
         break;
      case 5:
         var3 = var2.l;
         break;
      case 6:
         var3 = var2.m;
         break;
      case 7:
         var3 = var2.n;
         break;
      case 8:
         var3 = var2.o;
         break;
      case 9:
         var3 = var2.p;
         break;
      default:
         var3 = var2.g;
      }

      var1.drawBitmap(var3, this.d, this.c);
      if(this.p) {
         this.d.reset();
         this.d.postTranslate(FlashlightActivity.a().b().z, FlashlightActivity.a().b().A + this.e);
         this.d.postScale(FlashlightActivity.a().g, FlashlightActivity.a().h);
         var1.drawBitmap(FlashlightActivity.a().b().y, this.d, this.c);
      }

   }

   public final void e() {
      FlashlightActivity.a().a(true);
      FlashlightActivity.a().f();
      this.p = false;
      this.q = false;
      this.p = false;
      this.e = 0.0F;
      this.m = true;
      this.l = false;
      this.j = false;
   }

   public final void f() {
      this.p = false;
      this.q = false;
      this.p = false;
      this.e = 0.0F;
      this.m = true;
      this.l = false;
      this.j = false;
      this.u = false;
   }

   public final void g() {
      if(com.surpax.a.a.i == 1 && !this.q) {
         this.e = (float)com.surpax.a.a.m;
         this.p = true;
         this.q = true;
         this.m = false;
         this.l = true;
         this.j = true;
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
      this.n = false;
      this.i = false;
      boolean var2;
      if(var1.getX() >= FlashlightActivity.a().b().J * FlashlightActivity.a().g && var1.getX() <= (float)FlashlightActivity.a().e && var1.getY() >= FlashlightActivity.a().b().K * FlashlightActivity.a().h && var1.getY() <= FlashlightActivity.a().b().K * FlashlightActivity.a().h + FlashlightActivity.a().b().M * FlashlightActivity.a().h) {
         this.n = true;
         var2 = true;
      } else {
         var2 = false;
      }

      if(!var2) {
         if(var1.getX() >= FlashlightActivity.a().b().c * FlashlightActivity.a().g && var1.getX() <= FlashlightActivity.a().b().c * FlashlightActivity.a().g + (float)FlashlightActivity.a().b().e * FlashlightActivity.a().g && var1.getY() >= FlashlightActivity.a().b().d * FlashlightActivity.a().h + this.e && var1.getY() <= FlashlightActivity.a().b().d * FlashlightActivity.a().h + this.e + (float)FlashlightActivity.a().b().f * FlashlightActivity.a().h) {
            this.i = true;
            var2 = var3;
         } else {
            var2 = false;
         }

         if(!var2) {
            this.n = false;
            this.i = false;
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
      if(this.n) {
         this.f -= var3;
         if(this.f <= 0.0F) {
            if(this.f < (float)(-com.surpax.a.a.o / 4)) {
               this.f = (float)(-com.surpax.a.a.o / 4);
            }

            this.g = 0;
            this.r = false;
            this.s = com.surpax.a.a.g;
            com.surpax.a.a.g = 0;
            if(!this.o && 1 == com.surpax.a.a.h) {
               FlashlightActivity.a().a(3);
               this.o = true;
            }
         } else if(this.f >= (float)com.surpax.a.a.n) {
            if(this.f > (float)(com.surpax.a.a.n + com.surpax.a.a.o / 4)) {
               this.f = (float)(com.surpax.a.a.n + com.surpax.a.a.o / 4);
            }

            this.g = 9;
            this.r = true;
            this.s = 9 - com.surpax.a.a.g;
            com.surpax.a.a.g = 9;
            if(!this.o && 1 == com.surpax.a.a.h) {
               FlashlightActivity.a().a(3);
               this.o = true;
            }
         } else {
            int var5 = (int)Math.ceil((double)(this.f / (float)com.surpax.a.a.o));
            int var6 = (int)Math.floor((double)(this.f / (float)com.surpax.a.a.o));
            if(var6 >= this.g && var5 > this.g) {
               if(1 == var6 - this.g) {
                  this.g = var6;
                  com.surpax.a.a.g = this.g;
                  if(1 == com.surpax.a.a.h) {
                     FlashlightActivity.a().a(2);
                  }
               }
            } else if(var5 <= this.g && var6 < this.g && 1 == this.g - var5) {
               this.g = var5;
               com.surpax.a.a.g = this.g;
               if(1 == com.surpax.a.a.h) {
                  FlashlightActivity.a().a(2);
               }
            }
         }

         this.invalidate();
      } else if(this.i) {
         this.e -= var4;
         Message var7;
         if(this.e >= 0.0F) {
            this.e = 0.0F;
            if(this.j && this.q) {
               if(FlashlightActivity.a().g()) {
                  var7 = new Message();
                  var7.what = 4;
                  this.t.sendMessage(var7);
               } else {
                  this.k = true;
               }

               if(1 == com.surpax.a.a.h) {
                  FlashlightActivity.a().a(1);
               }
            }

            if(!FlashlightActivity.a().g() && !this.k) {
               this.k = true;
               if(!this.m && 1 == com.surpax.a.a.h) {
                  FlashlightActivity.a().a(1);
               }
            }

            this.j = false;
            this.q = false;
            this.p = false;
            this.l = false;
            this.m = true;
            com.surpax.a.a.i = 0;
         } else if(this.e < (float)com.surpax.a.a.m) {
            this.p = true;
            if(!this.j && !this.q) {
               com.surpax.a.a.i = 1;
               if(FlashlightActivity.a().g()) {
                  var7 = new Message();
                  var7.what = 3;
                  this.t.sendMessage(var7);
               } else {
                  this.q = true;
               }

               if(1 == com.surpax.a.a.h) {
                  FlashlightActivity.a().a(1);
               }

               this.j = true;
            }

            if(!FlashlightActivity.a().g() && !this.q) {
               this.q = true;
               if(!this.l && 1 == com.surpax.a.a.h) {
                  FlashlightActivity.a().a(1);
               }
            }

            this.e = (float)com.surpax.a.a.m;
            this.m = false;
            this.l = true;
         } else if(!this.l && this.e < (float)(com.surpax.a.a.m / 2)) {
            this.p = true;
            this.l = true;
            this.m = false;
            com.surpax.a.a.i = 1;
            if(FlashlightActivity.a().g()) {
               var7 = new Message();
               var7.what = 3;
               this.t.sendMessage(var7);
               this.j = true;
            } else {
               this.q = true;
            }

            if(1 == com.surpax.a.a.h) {
               FlashlightActivity.a().a(1);
            }
         } else if(!this.m && this.e > (float)(com.surpax.a.a.m / 2)) {
            this.m = true;
            this.l = false;
            this.q = false;
            this.p = false;
            com.surpax.a.a.i = 0;
            this.k = true;
            if(1 == com.surpax.a.a.h) {
               FlashlightActivity.a().a(1);
            }

            this.j = false;
            this.u = true;
            if(1 == FlashlightActivity.a().b) {
               FlashlightActivity.a().c = true;
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
      if(this.a != null) {
         this.a.onTouchEvent(var1);
      }

      switch(var1.getAction()) {
      case 0:
         com.surpax.b.a.b = true;
         return true;
      case 1:
         if(this.i) {
            if(this.e > (float)(com.surpax.a.a.m / 2)) {
               this.e = 0.0F;
               this.m = true;
               this.l = false;
               this.p = false;
               this.q = false;
               this.k = true;
            } else {
               this.e = (float)com.surpax.a.a.m;
               this.m = false;
               this.l = true;
               this.p = true;
               this.q = true;
               this.k = false;
            }

            (new StringBuilder("lighting state is ")).append(this.q).toString();
         } else if(this.n) {
            if(this.f < 0.0F) {
               this.f = 0.0F;
            }

            if(this.f > (float)(com.surpax.a.a.o * 9)) {
               this.f = (float)(com.surpax.a.a.o * 9);
            }

            float var2 = (float)(this.g * com.surpax.a.a.o);
            if(this.f > var2) {
               if(this.f - var2 >= this.h) {
                  ++this.g;
                  if(1 == com.surpax.a.a.h) {
                     FlashlightActivity.a().a(2);
                  }

                  com.surpax.a.a.g = this.g;
               }
            } else if(var2 - this.f >= this.h) {
               --this.g;
               if(1 == com.surpax.a.a.h) {
                  FlashlightActivity.a().a(2);
               }

               com.surpax.a.a.g = this.g;
            }

            switch(this.g) {
            case 0:
               this.f = 0.0F;
               break;
            case 1:
               this.f = (float)(com.surpax.a.a.o * 1);
               break;
            case 2:
               this.f = (float)(com.surpax.a.a.o * 2);
               break;
            case 3:
               this.f = (float)(com.surpax.a.a.o * 3);
               break;
            case 4:
               this.f = (float)(com.surpax.a.a.o * 4);
               break;
            case 5:
               this.f = (float)(com.surpax.a.a.o * 5);
               break;
            case 6:
               this.f = (float)(com.surpax.a.a.o * 6);
               break;
            case 7:
               this.f = (float)(com.surpax.a.a.o * 7);
               break;
            case 8:
               this.f = (float)(com.surpax.a.a.o * 8);
               break;
            case 9:
               this.f = (float)(com.surpax.a.a.o * 9);
               break;
            default:
               this.f = (float)(com.surpax.a.a.o * 9);
            }

            this.o = false;
            this.invalidate();
         }

         this.invalidate();
         this.n = false;
         this.i = false;
         this.o = false;
         this.postInvalidate();
         return true;
      default:
         return true;
      }
   }
}
