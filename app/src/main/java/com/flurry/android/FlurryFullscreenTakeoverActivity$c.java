package com.flurry.android;

import android.content.Context;
import com.flurry.android.FlurryFullscreenTakeoverActivity;
import com.flurry.android.impl.ads.FlurryAdModule;
import com.flurry.sdk.n$f;

final class FlurryFullscreenTakeoverActivity$c implements n$f {
   // $FF: synthetic field
   final FlurryFullscreenTakeoverActivity a;
   private int b;

   public FlurryFullscreenTakeoverActivity$c(FlurryFullscreenTakeoverActivity var1, int var2) {
      this.a = var1;
      this.b = 0;
      this.b = var2;
   }

   public final boolean a(final com.flurry.sdk.n var1, String var2, boolean var3) {
      boolean var4 = true;
      if(FlurryFullscreenTakeoverActivity.a(this.a, var2)) {
         FlurryFullscreenTakeoverActivity.a(this.a, var3);
         FlurryFullscreenTakeoverActivity.b(this.a, false);
         FlurryFullscreenTakeoverActivity.a(this.a, var2, this.b);
      } else {
         boolean var5;
         if(com.flurry.sdk.cf.d(var2)) {
            var5 = var3;
            if(!var3) {
               var5 = FlurryFullscreenTakeoverActivity.a(this.a, var2, var1.getUrl());
            }

            FlurryAdModule.getInstance().a().a((Context)this.a, (String)var2, (String)FlurryFullscreenTakeoverActivity.a(this.a));
            if(var5) {
               var1.post(new Runnable() {
                  public void run() {
                     if(var1.a()) {
                        var1.c();
                     } else {
                        FlurryFullscreenTakeoverActivity$c.this.a.finish();
                     }
                  }
               });
               return true;
            }
         } else {
            boolean var6;
            if(com.flurry.sdk.cf.e(var2)) {
               var6 = FlurryAdModule.getInstance().a().b(this.a, var2, FlurryFullscreenTakeoverActivity.a(this.a));
               var4 = var6;
               if(var6) {
                  var5 = var3;
                  if(!var3) {
                     var5 = FlurryFullscreenTakeoverActivity.a(this.a, var2, var1.getUrl());
                  }

                  var4 = var6;
                  if(var5) {
                     var1.post(new Runnable() {
                        public void run() {
                           if(var1.a()) {
                              var1.c();
                           } else {
                              FlurryFullscreenTakeoverActivity$c.this.a.finish();
                           }
                        }
                     });
                     return var6;
                  }
               }
            } else {
               var6 = FlurryAdModule.getInstance().a().c(this.a, var2, FlurryFullscreenTakeoverActivity.a(this.a));
               var4 = var6;
               if(var6) {
                  var5 = var3;
                  if(!var3) {
                     var5 = FlurryFullscreenTakeoverActivity.a(this.a, var2, var1.getUrl());
                  }

                  var4 = var6;
                  if(var5) {
                     var1.post(new Runnable() {
                        public void run() {
                           if(var1.a()) {
                              var1.c();
                           } else {
                              FlurryFullscreenTakeoverActivity$c.this.a.finish();
                           }
                        }
                     });
                     return var6;
                  }
               }
            }
         }
      }

      return var4;
   }
}
