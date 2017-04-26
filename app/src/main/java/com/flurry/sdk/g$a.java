package com.flurry.sdk;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.flurry.sdk.eo;

final class g$a extends WebChromeClient {
   // $FF: synthetic field
   final com.flurry.sdk.g a;

   private g$a(com.flurry.sdk.g var1) {
      this.a = var1;
   }

   // $FF: synthetic method
   g$a(com.flurry.sdk.g var1, Object var2) {
      this(var1);
   }

   public final void onHideCustomView() {
      eo.a(3, com.flurry.sdk.g.a(this.a), "onHideCustomView()");
      if(!(this.a.getContext() instanceof Activity)) {
         eo.a(3, com.flurry.sdk.g.a(this.a), "no activity present");
      } else {
         Activity var1 = (Activity)this.a.getContext();
         if(com.flurry.sdk.g.u(this.a) != null) {
            if(com.flurry.sdk.g.y(this.a) != null) {
               com.flurry.sdk.g.y(this.a).show();
            }

            ((ViewGroup)var1.getWindow().getDecorView()).removeView(com.flurry.sdk.g.w(this.a));
            com.flurry.sdk.g.w(this.a).removeView(com.flurry.sdk.g.u(this.a));
            if(com.flurry.sdk.g.x(this.a) != null && com.flurry.sdk.g.x(this.a).isShowing()) {
               com.flurry.sdk.g.x(this.a).hide();
               com.flurry.sdk.g.x(this.a).setOnDismissListener((OnDismissListener)null);
               com.flurry.sdk.g.x(this.a).dismiss();
            }

            com.flurry.sdk.g.a((com.flurry.sdk.g)this.a, (Dialog)null);
            com.flurry.sdk.cb.a(var1, com.flurry.sdk.g.z(this.a));
            com.flurry.sdk.g.A(this.a).onCustomViewHidden();
            com.flurry.sdk.g.a((com.flurry.sdk.g)this.a, (CustomViewCallback)null);
            com.flurry.sdk.g.a((com.flurry.sdk.g)this.a, (FrameLayout)null);
            com.flurry.sdk.g.a((com.flurry.sdk.g)this.a, (View)null);
            this.a.getPlatformModule().b((Context)var1, (String)this.a.getAdUnit().b().toString());
            return;
         }
      }

   }

   public final void onShowCustomView(View var1, int var2, CustomViewCallback var3) {
      eo.a(3, com.flurry.sdk.g.a(this.a), "onShowCustomView(14)");
      if(!(this.a.getContext() instanceof Activity)) {
         eo.a(3, com.flurry.sdk.g.a(this.a), "no activity present");
      } else {
         final Activity var4 = (Activity)this.a.getContext();
         if(com.flurry.sdk.g.u(this.a) != null && com.flurry.sdk.g.v(this.a) != null) {
            com.flurry.sdk.g.v(this.a).onHideCustomView();
         } else {
            com.flurry.sdk.g.a(this.a, var1);
            com.flurry.sdk.g.a(this.a, var4.getRequestedOrientation());
            com.flurry.sdk.g.a(this.a, var3);
            com.flurry.sdk.g.a(this.a, new FrameLayout(var4));
            com.flurry.sdk.g.w(this.a).setBackgroundColor(-16777216);
            com.flurry.sdk.g.w(this.a).addView(com.flurry.sdk.g.u(this.a), new LayoutParams(-1, -1, 17));
            ((ViewGroup)var4.getWindow().getDecorView()).addView(com.flurry.sdk.g.w(this.a), -1, -1);
            if(com.flurry.sdk.g.x(this.a) == null) {
               com.flurry.sdk.g.a(this.a, new Dialog(var4, 16973841) {
                  public boolean dispatchTouchEvent(MotionEvent var1) {
                     return var4.dispatchTouchEvent(var1);
                  }

                  public boolean dispatchTrackballEvent(MotionEvent var1) {
                     return var4.dispatchTrackballEvent(var1);
                  }
               });
               com.flurry.sdk.g.x(this.a).getWindow().setType(1000);
               com.flurry.sdk.g.x(this.a).setOnShowListener(new OnShowListener() {
                  public void onShow(DialogInterface var1) {
                     if(com.flurry.sdk.g.y(g$a.this.a) != null) {
                        com.flurry.sdk.g.y(g$a.this.a).hide();
                     }

                  }
               });
               com.flurry.sdk.g.x(this.a).setOnDismissListener(new OnDismissListener() {
                  public void onDismiss(DialogInterface var1) {
                     eo.a(3, com.flurry.sdk.g.a(g$a.this.a), "customViewFullScreenDialog.onDismiss()");
                     if(com.flurry.sdk.g.u(g$a.this.a) != null && com.flurry.sdk.g.v(g$a.this.a) != null) {
                        com.flurry.sdk.g.v(g$a.this.a).onHideCustomView();
                     }

                  }
               });
               com.flurry.sdk.g.x(this.a).setCancelable(true);
               com.flurry.sdk.g.x(this.a).show();
            }

            com.flurry.sdk.cb.a(var4, var2, true);
            this.a.getPlatformModule().a((Context)var4, (String)this.a.getAdUnit().b().toString());
         }
      }
   }

   public final void onShowCustomView(View var1, CustomViewCallback var2) {
      eo.a(3, com.flurry.sdk.g.a(this.a), "onShowCustomView(7)");
      if(!(this.a.getContext() instanceof Activity)) {
         eo.a(3, com.flurry.sdk.g.a(this.a), "no activity present");
      } else {
         this.onShowCustomView(var1, ((Activity)this.a.getContext()).getRequestedOrientation(), var2);
      }
   }
}
