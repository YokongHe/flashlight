package com.tapjoy.internal;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.net.Uri;
import android.os.SystemClock;
import android.os.Build.VERSION;
import android.view.Window;
import android.view.WindowManager.BadTokenException;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tapjoy.internal.aj$a;
import com.tapjoy.internal.fp;
import com.tapjoy.internal.fq;
import com.tapjoy.internal.fs;
import com.tapjoy.internal.fv;
import com.tapjoy.internal.fw;
import com.tapjoy.internal.gc;
import com.tapjoy.internal.gm;
import com.tapjoy.internal.gn;
import com.tapjoy.internal.gx;
import com.tapjoy.internal.gy;
import com.tapjoy.internal.gy$a;

public final class ga extends gc {
   final fv a;
   final String b;
   final gn c;
   long d;
   public fq e;
   boolean f;
   private boolean h;
   private Context i;

   public ga(fv var1, String var2, gn var3, Context var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.i = var4;
   }

   private static Boolean a(Context param0) {
      // $FF: Couldn't be decompiled
   }

   static void a(Context var0, String var1) {
      if(!com.tapjoy.internal.cv.c(var1)) {
         try {
            var0.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(var1)));
         } catch (Exception var2) {
            ;
         }
      }
   }

   public final void a() {
      this.c.c();
   }

   public final void a(final fw var1) {
      boolean var2;
      if(!this.h) {
         var2 = true;
      } else {
         var2 = false;
      }

      if(!var2) {
         throw new IllegalStateException();
      } else {
         this.h = true;
         final Activity var3;
         if(this.i != null) {
            var3 = (Activity)this.i;
         } else {
            var3 = com.tapjoy.internal.c.a(fp.a());
         }

         final com.tapjoy.internal.e var4 = new com.tapjoy.internal.e(var3);
         var4.setOnCancelListener(new OnCancelListener() {
            public final void onCancel(DialogInterface var1x) {
               var1.d(ga.this.b);
            }
         });
         var4.setOnDismissListener(new OnDismissListener() {
            public final void onDismiss(DialogInterface var1x) {
               ga.a(var3, ga.this.c.g);
               ga.this.a.a(ga.this.c.k, SystemClock.elapsedRealtime() - ga.this.d);
               if(!ga.this.f) {
                  var1.b(ga.this.b, ga.this.c.h);
               }

            }
         });
         var4.setCanceledOnTouchOutside(false);
         gy var5 = new gy(var3, this.c, new gy$a() {
            public final void a() {
               var4.cancel();
            }

            public final void a(gm var1x) {
               ga.this.a.a(ga.this.c.k, var1x.b);
               ga.a(var3, var1x.d);
               if(var1x.e != null) {
                  ga.this.e.a(var3, var1x.e);
                  ga.this.f = true;
               }

               var1.a(ga.this.b, var1x.f);
               if(var1x.c) {
                  var4.dismiss();
               }

            }
         });
         gx var9 = new gx(var3, this.c, var5);
         FrameLayout var6 = new FrameLayout(var3);
         var6.addView(var9, new LayoutParams(-2, -2, 17));
         var4.setContentView(var6);
         if(Boolean.FALSE.booleanValue()) {
            label49: {
               Window var10 = var4.getWindow();
               if(VERSION.SDK_INT == 16 && "4.1.2".equals(VERSION.RELEASE)) {
                  if(Boolean.FALSE.equals(a(var10.getContext()))) {
                     var2 = false;
                     break label49;
                  }

                  var10.setFlags(16777216, 16777216);
               }

               var2 = true;
            }

            if(var2) {
               aj$a var7 = aj$a.b;
               com.tapjoy.internal.ak var11 = new com.tapjoy.internal.ak();
               com.tapjoy.internal.am var12;
               switch(null.a[var7.ordinal()]) {
               case 1:
                  var12 = new com.tapjoy.internal.am();
                  var12.a = false;
                  var12.b = 60.0F;
                  var11.a(var12.a()).a(new ScaleAnimation(0.4F, 1.0F, 0.4F, 1.0F)).a((new com.tapjoy.internal.an()).a(1.0F).b(0.3F).a());
                  break;
               case 2:
                  var12 = new com.tapjoy.internal.am();
                  var12.a = false;
                  var12.b = -60.0F;
                  var11.a(var12.a()).a(new ScaleAnimation(0.4F, 1.0F, 0.4F, 1.0F)).a((new com.tapjoy.internal.an()).a(-0.4F).b(0.3F).a());
                  break;
               case 3:
                  var12 = new com.tapjoy.internal.am();
                  var12.a = true;
                  var12.b = -60.0F;
                  var11.a(var12.a()).a(new ScaleAnimation(0.4F, 1.0F, 0.4F, 1.0F)).a((new com.tapjoy.internal.an()).a(0.3F).b(1.0F).a());
                  break;
               case 4:
                  var12 = new com.tapjoy.internal.am();
                  var12.a = true;
                  var12.b = 60.0F;
                  var11.a(var12.a()).a(new ScaleAnimation(0.4F, 1.0F, 0.4F, 1.0F)).a((new com.tapjoy.internal.an()).a(0.3F).b(-0.4F).a());
               }

               var9.startAnimation(var11.b().a());
            }
         }

         try {
            var4.show();
         } catch (BadTokenException var8) {
            fs.b("Failed to show the content for \"{}\" caused by invalid activity", new Object[]{this.b});
            return;
         }

         var4.a();
         if((var3.getWindow().getAttributes().flags & 1024) != 0) {
            var4.getWindow().setFlags(1024, 1024);
         }

         this.d = SystemClock.elapsedRealtime();
         this.a.a(this.c.k);
         var1.c(this.b);
      }
   }

   public final boolean b() {
      return this.c.d();
   }
}
