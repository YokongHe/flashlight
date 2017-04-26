package com.smaato.soma;

import android.app.AlertDialog;
import android.content.Context;
import android.webkit.WebView;
import com.smaato.soma.AdListenerInterface;
import com.smaato.soma.AlertBannerStateListener;
import com.smaato.soma.CrashReportTemplate;
import com.smaato.soma.StandardPublisherMethods;
import com.smaato.soma.debug.Debugger;
import com.smaato.soma.exception.AlertViewInstantiationException;
import com.smaato.soma.internal.requests.RequestsBuilder;
import com.smaato.soma.internal.requests.settings.UserSettings;
import com.smaato.soma.internal.utilities.Controller;
import com.smaato.soma.measurements.BannerMeasurements;

public abstract class AbstractAlertView {
   protected AlertBannerStateListener mAlertBannerStateListener;
   StandardPublisherMethods mAlertContent;
   private AlertDialog mAlertDialog;
   private Context mContext;
   private String mTitle = "Advertisement";

   public AbstractAlertView(final Context var1) {
      (new CrashReportTemplate() {
         public Void process() {
            AbstractAlertView.this.setContext(var1);
            AbstractAlertView.this.init();
            return null;
         }
      }).execute();
   }

   public void addAdListener(final AdListenerInterface var1) {
      (new CrashReportTemplate() {
         public Void process() {
            AbstractAlertView.this.mAlertContent.addAdListener(var1);
            return null;
         }
      }).execute();
   }

   public void asyncLoadNewBanner() {
      (new CrashReportTemplate() {
         public Void process() {
            if(!BannerMeasurements.getInstance().canRequest()) {
               return null;
            } else {
               if(Controller.getInstance().isShouldInit()) {
                  AbstractAlertView.this.init();
                  Controller.getInstance().sdkInitSuccess();
               }

               (new Thread(new Runnable() {
                  public void run() {
                     AbstractAlertView.this.mAlertContent.asyncLoadNewBanner();
                  }
               })).start();
               return null;
            }
         }
      }).execute();
   }

   protected abstract AdListenerInterface createAdListener();

   public void dismiss() {
      Debugger.methodStart(new Object() {
      });
      (new CrashReportTemplate() {
         public Void process() {
            AlertDialog var1 = AbstractAlertView.this.getAlertDialog();
            if(var1 == null) {
               return null;
            } else {
               var1.dismiss();
               AbstractAlertView.this.setAlertDialog((AlertDialog)null);
               return null;
            }
         }
      }).execute();
   }

   public AlertBannerStateListener getAlertBannerStateListener() {
      return this.mAlertBannerStateListener;
   }

   protected AlertDialog getAlertDialog() {
      return this.mAlertDialog;
   }

   protected Context getContext() {
      return this.mContext;
   }

   public String getTitle() {
      return this.mTitle;
   }

   public UserSettings getUserSettings() {
      return (UserSettings)(new CrashReportTemplate() {
         public UserSettings process() {
            return AbstractAlertView.this.mAlertContent.getUserSettings();
         }
      }).execute();
   }

   protected void init() {
      try {
         Debugger.methodStart(new Object() {
         });
         String var1 = (new WebView(this.getContext())).getSettings().getUserAgentString();
         RequestsBuilder.getInstance().setUserAgent(var1);
      } catch (RuntimeException var2) {
         throw var2;
      } catch (Exception var3) {
         throw new AlertViewInstantiationException(var3);
      }
   }

   public boolean isLocationUpdateEnabled() {
      return ((Boolean)(new CrashReportTemplate() {
         public Boolean process() {
            return Boolean.valueOf(AbstractAlertView.this.mAlertContent.isLocationUpdateEnabled());
         }
      }).execute()).booleanValue();
   }

   public boolean removeAdListener(final AdListenerInterface var1) {
      return ((Boolean)(new CrashReportTemplate() {
         public Boolean process() {
            AbstractAlertView.this.mAlertContent.removeAdListener(var1);
            return Boolean.valueOf(false);
         }
      }).execute()).booleanValue();
   }

   public void setAdSpaceId(final int var1) {
      (new CrashReportTemplate() {
         public Void process() {
            AbstractAlertView.this.mAlertContent.getAdSettings().setAdspaceId(var1);
            return null;
         }
      }).execute();
   }

   public void setAlertBannerStateListener(AlertBannerStateListener var1) {
      this.mAlertBannerStateListener = var1;
   }

   protected void setAlertDialog(AlertDialog var1) {
      this.mAlertDialog = var1;
   }

   protected void setContext(Context var1) {
      this.mContext = var1;
   }

   public void setLocationUpdateEnabled(final boolean var1) {
      (new CrashReportTemplate() {
         public Void process() {
            AbstractAlertView.this.mAlertContent.setLocationUpdateEnabled(var1);
            return null;
         }
      }).execute();
   }

   public void setPublisherId(final int var1) {
      (new CrashReportTemplate() {
         public Void process() {
            AbstractAlertView.this.mAlertContent.getAdSettings().setPublisherId(var1);
            return null;
         }
      }).execute();
   }

   public void setTitle(String var1) {
      this.mTitle = var1;
   }
}
