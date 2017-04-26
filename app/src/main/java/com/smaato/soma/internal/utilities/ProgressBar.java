package com.smaato.soma.internal.utilities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.smaato.soma.exception.DissmissingProgressBarFailed;
import com.smaato.soma.exception.SettingProgressFailed;
import com.smaato.soma.exception.ShowProgressBarFailed;

public class ProgressBar {
   static ProgressBar instance;
   ProgressDialog mProgressDialog;
   boolean shouldShowProgressBar = true;

   public static ProgressBar getInstance() {
      if(instance == null) {
         instance = new ProgressBar();
      }

      return instance;
   }

   public void dissmissProgressBar() {
      try {
         if(this.mProgressDialog != null) {
            this.mProgressDialog.dismiss();
            this.mProgressDialog = null;
            this.shouldShowProgressBar = false;
         }
      } catch (RuntimeException var2) {
         throw var2;
      } catch (Exception var3) {
         throw new DissmissingProgressBarFailed(var3);
      }
   }

   public final boolean isShouldShowProgressBar() {
      return this.shouldShowProgressBar;
   }

   public void setProgress(int var1) {
      try {
         if(this.mProgressDialog != null && this.mProgressDialog.isShowing()) {
            this.mProgressDialog.setProgress(var1);
         }

      } catch (RuntimeException var3) {
         throw var3;
      } catch (Exception var4) {
         throw new SettingProgressFailed(var4);
      }
   }

   public final void setShouldShowProgressBar(boolean var1) {
      this.shouldShowProgressBar = var1;
   }

   public void showProgressBar(Context var1) {
      try {
         if((this.mProgressDialog == null || !this.mProgressDialog.isShowing()) && this.shouldShowProgressBar) {
            this.mProgressDialog = new ProgressDialog(var1);
            this.mProgressDialog.setProgressStyle(1);
            this.mProgressDialog.setProgressNumberFormat((String)null);
            this.mProgressDialog.setTitle("Loading ...");
            this.mProgressDialog.setCancelable(true);
            this.mProgressDialog.setOnCancelListener(new OnCancelListener() {
               public void onCancel(DialogInterface var1) {
                  ProgressBar.this.setShouldShowProgressBar(false);
               }
            });
            this.mProgressDialog.show();
         }

      } catch (RuntimeException var2) {
         throw var2;
      } catch (Exception var3) {
         throw new ShowProgressBarFailed(var3);
      }
   }
}
