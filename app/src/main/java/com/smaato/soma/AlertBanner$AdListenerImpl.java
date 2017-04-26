package com.smaato.soma;

import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import com.smaato.soma.AdDownloaderInterface;
import com.smaato.soma.AdListenerInterface;
import com.smaato.soma.AlertBanner;
import com.smaato.soma.CrashReportTemplate;
import com.smaato.soma.ReceivedBannerInterface;
import com.smaato.soma.bannerutilities.constant.BannerStatus;
import com.smaato.soma.debug.DebugCategory;
import com.smaato.soma.debug.Debugger;
import com.smaato.soma.debug.LogMessage;
import com.smaato.soma.exception.AlertBannerFailedToRecieveAd;

class AlertBanner$AdListenerImpl implements AdListenerInterface {
   // $FF: synthetic field
   final AlertBanner this$0;

   private AlertBanner$AdListenerImpl(AlertBanner var1) {
      this.this$0 = var1;
   }

   // $FF: synthetic method
   AlertBanner$AdListenerImpl(AlertBanner var1, AlertBanner$AdListenerImpl var2) {
      this(var1);
   }

   public final void onReceiveAd(AdDownloaderInterface var1, final ReceivedBannerInterface var2) {
      try {
         Debugger.methodStart(new Object() {
         });
         if(var2.getStatus() == BannerStatus.ERROR) {
            Debugger.showLog(new LogMessage("" + var2.getStatus(), "transitionErrorLoading", 1, DebugCategory.ERROR));
         } else {
            Builder var5 = new Builder(this.this$0.getContext());
            var5.setMessage(var2.getAdText()).setCancelable(false);
            var5.setPositiveButton("Open", new OnClickListener() {
               public void onClick(final DialogInterface var1, int var2x) {
                  (new CrashReportTemplate() {
                     public Void process() {
                        Intent var1x = new Intent("android.intent.action.VIEW", Uri.parse(var2.getClickUrl()));
                        if(AlertBanner$AdListenerImpl.this.this$0.mAlertBannerStateListener != null) {
                           AlertBanner$AdListenerImpl.this.this$0.mAlertBannerStateListener.onWillLeaveActivity();
                        }

                        AlertBanner$AdListenerImpl.this.this$0.getContext().startActivity(var1x);
                        var1.dismiss();
                        return null;
                     }
                  }).execute();
               }
            });
            var5.setNegativeButton("Close", new OnClickListener() {
               public void onClick(DialogInterface var1, int var2) {
                  (new CrashReportTemplate() {
                     public Void process() {
                        if(AlertBanner$AdListenerImpl.this.this$0.mAlertBannerStateListener != null) {
                           AlertBanner$AdListenerImpl.this.this$0.mAlertBannerStateListener.onWillCancelAlert();
                        }

                        return null;
                     }
                  }).execute();
               }
            });
            var5.setTitle(this.this$0.getTitle());
            if(this.this$0.mAlertBannerStateListener != null) {
               this.this$0.mAlertBannerStateListener.onWillShowBanner();
            }

            this.this$0.setAlertDialog(var5.show());
            ((AdDownloaderInterface)this.this$0.mAlertContent).asyncLoadBeacons();
         }
      } catch (RuntimeException var3) {
         throw var3;
      } catch (Exception var4) {
         throw new AlertBannerFailedToRecieveAd(var4);
      }
   }
}
