package com.facebook.ads.a;

import android.content.Context;
import android.content.Intent;
import android.graphics.Camera;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Handler;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.ImpressionListener;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAd$Image;
import com.facebook.ads.NativeAd$Rating;
import java.util.Arrays;

public class i extends com.facebook.ads.a.af implements AdListener, com.facebook.ads.a.d, com.facebook.ads.a.x {
   private final AdView a;
   private ProgressBar b;
   private DisplayMetrics c;
   private com.facebook.ads.a.ac d;
   private AdListener e;
   private boolean f = false;
   private RelativeLayout g;
   private TextView h;
   private boolean i = false;
   private ViewGroup j;
   private View k;
   private View l;
   private com.facebook.ads.a.ah m;

   public i(AdView var1, String var2, AdSize var3) {
      super(var1.getContext());
      this.a = var1;
      if(var3 != null && var3 == AdSize.RECTANGLE_HEIGHT_250) {
         Context var4 = var1.getContext();
         this.c = var4.getResources().getDisplayMetrics();
         this.setMinWidth(Math.round(300.0F * this.c.density));
         this.setMaxWidth(Math.round(360.0F * this.c.density));
         this.setLayoutParams(new LayoutParams(-1, Math.round(250.0F * this.c.density)));
         this.setGravity(17);
         this.b = new ProgressBar(var4, (AttributeSet)null, 16842873);
         this.b.setLayoutParams(new LayoutParams(-2, -2));
         this.addView(this.b);
         this.d = new com.facebook.ads.a.ac(var4, var2, AdSize.RECTANGLE_HEIGHT_250, com.facebook.ads.a.n.j, true);
         this.d.setAdListener(this);
      } else {
         throw new IllegalArgumentException("adSize");
      }
   }

   private View a(View var1) {
      TextView var2 = new TextView(this.getContext());
      LayoutParams var3 = new LayoutParams(-1, -1);
      var3.addRule(3, var1.getId());
      var3.setMargins(Math.round(5.0F * this.c.density), Math.round(this.c.density * 10.0F), Math.round(0.0F), Math.round(this.c.density * 10.0F));
      var2.setTextColor(-11643291);
      var2.setLayoutParams(var3);
      var2.setText(this.d.getAdBody());
      var2.setTextSize(10.0F);
      var2.setEllipsize(TruncateAt.END);
      var2.setMaxLines(3);
      var2.setGravity(16);
      return var2;
   }

   private View a(ViewGroup var1, View var2) {
      RelativeLayout var3 = new RelativeLayout(this.getContext());
      android.widget.LinearLayout.LayoutParams var4 = new android.widget.LinearLayout.LayoutParams(0, -1);
      var4.weight = 1.0F;
      var3.setLayoutParams(var4);
      View var5 = this.b(var1, var2);
      var3.addView(var5);
      var2 = this.a(var5);
      var3.addView(var2);
      this.m = (new com.facebook.ads.a.ah(var5, var2)).a(Math.round(60.0F * this.c.density)).a();
      return var3;
   }

   private View b(ViewGroup var1, View var2) {
      LinearLayout var3 = new LinearLayout(this.getContext());
      LayoutParams var4 = new LayoutParams(-1, -1);
      var4.addRule(10);
      var4.setMargins(Math.round(5.0F * this.c.density), Math.round(this.c.density * 10.0F), Math.round(0.0F), Math.round(this.c.density * 10.0F));
      var3.setLayoutParams(var4);
      var3.setOrientation(1);
      var3.addView(this.c(var1, var2));
      var3.addView(this.i());
      return var3;
   }

   private View c(ViewGroup var1, View var2) {
      TextView var5 = new TextView(this.getContext());
      var5.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-1, -1, 1.0F));
      var5.setText(this.d.getAdTitle());
      var5.setTypeface(Typeface.DEFAULT_BOLD);
      var5.setTextColor(-16777216);
      var5.setTextSize(16.0F);
      var5.setEllipsize(TruncateAt.END);
      var5.setSingleLine(true);
      TextPaint var6 = var5.getPaint();
      String var7 = this.d.getAdTitle();
      String var4 = var7.substring(0, Math.min(20, var7.length()));
      String var3 = var4;
      if(var7.length() > 20) {
         var3 = var4 + "…";
      }

      if(var6.measureText(var3) >= (float)this.getMeasuredWidth() - 185.0F * this.c.density) {
         var1.removeView(var2);
      }

      return var5;
   }

   private ViewGroup e() {
      RelativeLayout var1 = new RelativeLayout(this.getContext());
      LayoutParams var2 = new LayoutParams(-1, Math.round(190.0F * this.c.density));
      var2.addRule(10);
      var1.setLayoutParams(var2);
      ImageView var3 = new ImageView(this.getContext());
      var1.addView(var3);
      var3.setLayoutParams(new LayoutParams(-1, -1));
      var3.setScaleType(ScaleType.CENTER_CROP);
      (new com.facebook.ads.a.w(var3)).a((com.facebook.ads.a.x)this).execute(new String[]{this.d.getAdCoverImage().getUrl()});
      this.l = this.k();
      var1.addView(this.l);
      return var1;
   }

   private View f() {
      RelativeLayout var1 = new RelativeLayout(this.getContext());
      LayoutParams var2 = new LayoutParams(-1, Math.round(60.0F * this.c.density));
      var2.addRule(12);
      var1.setLayoutParams(var2);
      var1.addView(this.g());
      return var1;
   }

   private View g() {
      LinearLayout var1 = new LinearLayout(this.getContext());
      var1.setLayoutParams(new LayoutParams(-1, -1));
      var1.setBackgroundColor(-1);
      var1.setOrientation(0);
      View var2 = this.h();
      var1.addView(var2);
      var1.addView(this.a(var1, var2));
      View var3 = this.j();
      var1.addView(var3);
      this.d.unregisterView();
      this.d.registerViewForInteraction(this, Arrays.asList(new View[]{var2, var3}));
      return var1;
   }

   private View h() {
      ImageView var1 = new ImageView(this.getContext());
      android.widget.LinearLayout.LayoutParams var2 = new android.widget.LinearLayout.LayoutParams(Math.round(this.c.density * 50.0F), Math.round(this.c.density * 50.0F));
      var2.setMargins(Math.round(this.c.density * 5.0F), Math.round(this.c.density * 5.0F), Math.round(this.c.density * 5.0F), Math.round(this.c.density * 5.0F));
      var1.setLayoutParams(var2);
      NativeAd.downloadAndDisplayImage(this.d.getAdIcon(), var1);
      return var1;
   }

   private View i() {
      NativeAd$Rating var1 = this.d.getAdStarRating();
      if(var1 != null && var1.getValue() >= 3.5D) {
         RatingBar var2 = new RatingBar(this.getContext(), (AttributeSet)null, 16842877);
         var2.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-2, -2));
         var2.setStepSize(0.1F);
         var2.setIsIndicator(true);
         var2.setNumStars((int)var1.getScale());
         var2.setRating((float)var1.getValue());
         return var2;
      } else {
         TextView var3 = new TextView(this.getContext());
         var3.setText(this.d.getAdSocialContext());
         var3.setTextColor(-16777216);
         var3.setTextSize(12.0F);
         var3.setEllipsize(TruncateAt.END);
         var3.setSingleLine(true);
         return var3;
      }
   }

   private View j() {
      Button var1 = new Button(this.getContext(), (AttributeSet)null, 16843563);
      android.widget.LinearLayout.LayoutParams var2 = new android.widget.LinearLayout.LayoutParams(Math.round(100.0F * this.c.density), Math.round(40.0F * this.c.density));
      var2.setMargins(Math.round(this.c.density * 10.0F), Math.round(this.c.density * 10.0F), Math.round(this.c.density * 10.0F), Math.round(this.c.density * 10.0F));
      var1.setLayoutParams(var2);
      var1.setTextColor(-1);
      var1.setText(this.d.getAdCallToAction());
      var1.setTextSize(14.0F);
      var1.setGravity(17);
      GradientDrawable var3 = new GradientDrawable();
      var3.setColor(-7617003);
      var3.setCornerRadius(5.0F * this.c.density);
      var1.setBackgroundDrawable(var3);
      return var1;
   }

   private View k() {
      this.g = new RelativeLayout(this.getContext());
      NativeAd$Image var1 = this.d.getAdChoicesIcon();
      LayoutParams var2 = new LayoutParams(Math.round((float)(var1.getWidth() + 4) * this.c.density), Math.round((float)(var1.getHeight() + 2) * this.c.density));
      var2.addRule(10);
      var2.addRule(11);
      this.g.setLayoutParams(var2);
      GradientDrawable var5 = new GradientDrawable();
      var5.setColor(-1291845632);
      var5.setCornerRadii(new float[]{0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, (float)Math.round(this.c.density * 8.0F), (float)Math.round(this.c.density * 8.0F)});
      this.g.setBackgroundDrawable(var5);
      this.g.setOnTouchListener(new OnTouchListener() {
         public boolean onTouch(View var1, MotionEvent var2) {
            if(var2.getAction() == 0) {
               if(i.this.f) {
                  Intent var3 = new Intent();
                  var3.setAction("android.intent.action.VIEW");
                  var3.addCategory("android.intent.category.BROWSABLE");
                  var3.setData(Uri.parse(i.this.d.getAdChoicesLinkUrl()));
                  i.this.getContext().startActivity(var3);
               } else {
                  i.this.m();
               }

               return true;
            } else {
               return false;
            }
         }
      });
      ImageView var6 = new ImageView(this.getContext());
      this.g.addView(var6);
      LayoutParams var3 = new LayoutParams(Math.round((float)var1.getWidth() * this.c.density), Math.round((float)var1.getHeight() * this.c.density));
      var3.addRule(9);
      var3.addRule(15, -1);
      var3.setMargins(Math.round(4.0F * this.c.density), Math.round(this.c.density * 2.0F), Math.round(this.c.density * 2.0F), Math.round(this.c.density * 2.0F));
      var6.setLayoutParams(var3);
      NativeAd.downloadAndDisplayImage(var1, var6);
      this.h = new TextView(this.getContext());
      this.g.addView(this.h);
      LayoutParams var4 = new LayoutParams(0, -2);
      var4.addRule(11, var6.getId());
      var4.addRule(15, -1);
      this.h.setLayoutParams(var4);
      this.h.setSingleLine();
      this.h.setText("AdChoices");
      this.h.setTextSize(10.0F);
      this.h.setTextColor(-4341303);
      this.f = false;
      return this.g;
   }

   private void l() {
      Animation var1 = new Animation() {
         private boolean b = false;
         private boolean c = false;

         protected void applyTransformation(float var1, Transformation var2) {
            double var3 = 3.141592653589793D * (double)var1;
            float var6 = (float)(180.0D * var3 / 3.141592653589793D);
            float var5 = var6;
            if(var1 >= 0.5F) {
               var1 = var6 - 180.0F;
               var5 = var1;
               if(!this.b) {
                  this.b = true;
                  i.this.j.setVisibility(0);
                  i.this.k.setVisibility(0);
                  var5 = var1;
               }
            }

            var1 = var5;
            if(this.c) {
               var1 = -var5;
            }

            Camera var9 = new Camera();
            Matrix var10 = var2.getMatrix();
            var9.save();
            var9.translate(0.0F, 0.0F, (float)(Math.sin(var3) * 150.0D));
            var9.rotateY(var1);
            var9.getMatrix(var10);
            var9.restore();
            int var7 = i.this.getWidth() / 2;
            int var8 = i.this.getHeight() / 2;
            var10.preTranslate((float)(-var7), (float)(-var8));
            var10.postTranslate((float)var7, (float)var8);
         }
      };
      var1.setDuration(300L);
      var1.setFillAfter(true);
      var1.setAnimationListener(new AnimationListener() {
         public void onAnimationEnd(Animation var1) {
            i.this.removeView(i.this.getChildAt(0));
            i.this.removeView(i.this.getChildAt(0));
         }

         public void onAnimationRepeat(Animation var1) {
         }

         public void onAnimationStart(Animation var1) {
         }
      });
      this.startAnimation(var1);
   }

   private void m() {
      Paint var3 = new Paint();
      var3.setTextSize(this.h.getTextSize());
      final int var2 = Math.round(var3.measureText("AdChoices") + 4.0F * this.c.density);
      final int var1 = this.g.getWidth();
      var2 += var1;
      this.f = true;
      Animation var4 = new Animation() {
         protected void applyTransformation(float var1x, Transformation var2x) {
            int var3 = (int)((float)var1 + (float)(var2 - var1) * var1x);
            i.this.g.getLayoutParams().width = var3;
            i.this.g.requestLayout();
            i.this.h.getLayoutParams().width = var3 - var1;
            i.this.h.requestLayout();
         }

         public boolean willChangeBounds() {
            return true;
         }
      };
      var4.setAnimationListener(new AnimationListener() {
         public void onAnimationEnd(Animation var1x) {
            (new Handler()).postDelayed(new Runnable() {
               public void run() {
                  if(i.this.f) {
                     i.this.f = false;
                     Animation var1x = new Animation() {
                        protected void applyTransformation(float var1x, Transformation var2x) {
                           int var3 = (int)((float)var2 + (float)(var1 - var2) * var1x);
                           i.this.g.getLayoutParams().width = var3;
                           i.this.g.requestLayout();
                           i.this.h.getLayoutParams().width = var3 - var1;
                           i.this.h.requestLayout();
                        }

                        public boolean willChangeBounds() {
                           return true;
                        }
                     };
                     var1x.setDuration(300L);
                     var1x.setFillAfter(true);
                     i.this.g.startAnimation(var1x);
                  }
               }
            }, 3000L);
         }

         public void onAnimationRepeat(Animation var1x) {
         }

         public void onAnimationStart(Animation var1x) {
         }
      });
      var4.setDuration(300L);
      var4.setFillAfter(true);
      this.g.startAnimation(var4);
   }

   public void a() {
      this.d.disableAutoRefresh();
   }

   public void b() {
      this.d.loadAd();
   }

   public void c() {
      this.d.destroy();
   }

   public void d() {
      if(this.i) {
         this.j.setVisibility(4);
         this.k.setVisibility(4);
         this.addView(this.j);
         this.addView(this.k);
         this.l();
      } else {
         this.i = true;
         this.removeView(this.b);
         this.setGravity(0);
         this.addView(this.j);
         this.addView(this.k);
      }

      this.e.onAdLoaded(this.a);
   }

   public void onAdClicked(Ad var1) {
      this.e.onAdClicked(this.a);
   }

   public void onAdLoaded(Ad var1) {
      if(this.d != null && this.d == var1) {
         this.j = this.e();
         this.k = this.f();
      }
   }

   public void onError(Ad var1, AdError var2) {
      this.e.onError(this.a, var2);
      this.removeView(this.b);
   }

   protected void onWindowVisibilityChanged(int var1) {
      super.onWindowVisibilityChanged(var1);
      this.d.onWindowVisibilityChanged(var1);
      if(var1 == 0) {
         if(this.m != null) {
            this.m.a();
         }

         if(this.j != null && this.l != null) {
            this.j.removeView(this.l);
            this.l = this.k();
            this.j.addView(this.l);
         }
      }

   }

   public void setAdListener(AdListener var1) {
      this.e = var1;
   }

   public void setImpressionListener(ImpressionListener var1) {
      this.d.setImpressionListener(var1);
   }
}
