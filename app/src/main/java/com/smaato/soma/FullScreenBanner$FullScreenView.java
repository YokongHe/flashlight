package com.smaato.soma;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.os.Handler;
import android.util.AttributeSet;
import com.smaato.soma.AdType;
import com.smaato.soma.BaseView;
import com.smaato.soma.CrashReportTemplate;
import com.smaato.soma.FullScreenBanner;
import com.smaato.soma.FullScreenBanner$FullScreenView$BannerHandler;
import com.smaato.soma.bannerutilities.constant.BannerStatus;
import com.smaato.soma.exception.UnableToViewFullScreenBanner;

public class FullScreenBanner$FullScreenView extends BaseView {
   // $FF: synthetic field
   final FullScreenBanner this$0;

   protected FullScreenBanner$FullScreenView(FullScreenBanner var1, Context var2) {
      super(var2);
      this.this$0 = var1;
   }

   protected FullScreenBanner$FullScreenView(FullScreenBanner var1, Context var2, AttributeSet var3) {
      super(var2, var3);
      this.this$0 = var1;
   }

   protected FullScreenBanner$FullScreenView(FullScreenBanner var1, Context var2, AttributeSet var3, int var4) {
      super(var2, var3, var4);
      this.this$0 = var1;
   }

   public Handler getBannerAnimatorHandler() {
      if(this.handler == null) {
         this.setBannerAnimatorHandler(new FullScreenBanner$FullScreenView$BannerHandler(this, this, (FullScreenBanner$FullScreenView$BannerHandler)null));
      }

      return this.handler;
   }

   protected void isBannerIdle() {
      try {
         if(FullScreenBanner.access$2(this.this$0) != BannerStatus.ERROR && FullScreenBanner.access$3(this.this$0) != null) {
            if(this.this$0.getAlertDialog() == null) {
               super.isBannerIdle();
               FullScreenBanner.access$4(this.this$0, new Builder(this.getContext()));
               FullScreenBanner.access$5(this.this$0).setCancelable(false);
               FullScreenBanner.access$5(this.this$0).setView((FullScreenBanner$FullScreenView)this.this$0.mAlertContent);
               FullScreenBanner.access$5(this.this$0).setNegativeButton("Skip", new OnClickListener() {
                  public void onClick(DialogInterface var1, int var2) {
                     (new CrashReportTemplate() {
                        public Void process() {
                           if(FullScreenBanner$FullScreenView.this.this$0.mAlertBannerStateListener != null) {
                              FullScreenBanner$FullScreenView.this.this$0.mAlertBannerStateListener.onWillCancelAlert();
                           }

                           FullScreenBanner$FullScreenView.this.this$0.dismiss();
                           return null;
                        }
                     }).execute();
                  }
               });
               if(FullScreenBanner.access$3(this.this$0).getAdType() != null && (FullScreenBanner.access$3(this.this$0).getAdType() == AdType.TEXT || FullScreenBanner.access$3(this.this$0).getAdType() == AdType.IMAGE)) {
                  FullScreenBanner.access$5(this.this$0).setPositiveButton("More Info", new OnClickListener() {
                     public void onClick(final DialogInterface var1, int var2) {
                        (new CrashReportTemplate() {
                           public Void process() {
                              Intent var1x = new Intent("android.intent.action.VIEW", Uri.parse(FullScreenBanner.access$3(FullScreenBanner$FullScreenView.this.this$0).getClickUrl()));
                              if(FullScreenBanner$FullScreenView.this.this$0.mAlertBannerStateListener != null) {
                                 FullScreenBanner$FullScreenView.this.this$0.mAlertBannerStateListener.onWillLeaveActivity();
                              }

                              FullScreenBanner$FullScreenView.this.getContext().startActivity(var1x);
                              var1.dismiss();
                              return null;
                           }
                        }).execute();
                     }
                  });
               }

               if(this.this$0.mAlertBannerStateListener != null) {
                  this.this$0.mAlertBannerStateListener.onWillShowBanner();
               }

               this.this$0.setAlertDialog(FullScreenBanner.access$5(this.this$0).show());
               this.asyncLoadBeacon();
               FullScreenBanner.access$0(this.this$0, BannerStatus.ERROR);
            }
         }
      } catch (RuntimeException var2) {
         throw var2;
      } catch (Exception var3) {
         throw new UnableToViewFullScreenBanner(var3);
      }
   }
}
