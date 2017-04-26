package com.smaato.soma.internal.connector;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.smaato.soma.CrashReportTemplate;
import com.smaato.soma.bannerutilities.AbstractBannerPackage;
import com.smaato.soma.debug.DebugCategory;
import com.smaato.soma.debug.Debugger;
import com.smaato.soma.debug.LogMessage;
import com.smaato.soma.internal.utilities.CalendarEventCreator;
import com.smaato.soma.internal.utilities.ImageDownloadProperties;
import com.smaato.soma.internal.utilities.ImageDownloader;
import com.smaato.soma.internal.utilities.SomaCalendar;
import com.smaato.soma.internal.views.CustomWebView;
import org.json.JSONObject;

public class OrmmaBridge {
   private static final String EXTERNAL_BROWSER_TAG = " in external browser.";
   public static final int MRAID_VERSION = 2;
   public final String TAG = "SOMA_Bridge";
   private Context context = null;
   private Handler handler = null;
   private AbstractBannerPackage mPackage = null;
   private WebView mWebView;
   JSONObject resizeProperties = null;

   public OrmmaBridge(Handler var1, Context var2, AbstractBannerPackage var3) {
      this.handler = var1;
      this.context = var2;
      this.mPackage = var3;
   }

   @JavascriptInterface
   public void activate(String var1) {
   }

   @JavascriptInterface
   public void close() {
      (new CrashReportTemplate() {
         public Void process() {
            Debugger.showLog(new LogMessage("SOMA_Bridge", "closing ...", 1, DebugCategory.INFO));
            Message var1 = OrmmaBridge.this.handler.obtainMessage(102);
            OrmmaBridge.this.handler.sendMessage(var1);
            return null;
         }
      }).execute();
   }

   @JavascriptInterface
   public void createCalendarEvent(final String var1) {
      if(this.isUserClicked("create calendar event")) {
         (new CrashReportTemplate() {
            public Void process() {
               new CalendarEventCreator(new SomaCalendar(new JSONObject(var1)), OrmmaBridge.this.context);
               return null;
            }
         }).execute();
      }
   }

   @JavascriptInterface
   public void deactivate(String var1) {
   }

   @JavascriptInterface
   public void expand(int var1, int var2, final int var3, final int var4, String var5, String var6) {
      (new CrashReportTemplate() {
         public Void process() {
            Debugger.showLog(new LogMessage("SOMA_Bridge", "expanding to : " + var3 + "x" + var4, 1, DebugCategory.INFO));
            return null;
         }
      }).execute();
   }

   @JavascriptInterface
   public void foundORMMAAd() {
      (new CrashReportTemplate() {
         public Void process() {
            Debugger.showLog(new LogMessage("SOMA_Bridge", "Found ORMMA/MRAID banner", 1, DebugCategory.DEBUG));
            OrmmaBridge.this.mPackage.setOrmma(true);
            return null;
         }
      }).execute();
   }

   public WebView getWebView() {
      return this.mWebView;
   }

   @JavascriptInterface
   public void hide() {
   }

   public boolean isUserClicked(final String var1) {
      return ((Boolean)(new CrashReportTemplate() {
         public Boolean process() {
            boolean var1x = ((CustomWebView)OrmmaBridge.this.mPackage.getView()).isUserClicked();
            if(!var1x) {
               Debugger.showLog(new LogMessage("SOMA_Bridge", "User Click not detected, escaping " + var1 + " ...", 1, DebugCategory.WARNING));
            }

            return Boolean.valueOf(var1x);
         }
      }).execute()).booleanValue();
   }

   @JavascriptInterface
   public void legacyExpand() {
      (new CrashReportTemplate() {
         public Void process() {
            if(!OrmmaBridge.this.mPackage.isOrmma()) {
               Debugger.showLog(new LogMessage("SOMA_Bridge", "legacyExpand ", 1, DebugCategory.INFO));
            }

            return null;
         }
      }).execute();
   }

   @JavascriptInterface
   public void legacyExpand(int var1, int var2, int var3, int var4, String var5, String var6) {
      (new CrashReportTemplate() {
         public Void process() {
            if(!OrmmaBridge.this.mPackage.isOrmma()) {
               Debugger.showLog(new LogMessage("SOMA_Bridge", "legacyExpand", 1, DebugCategory.INFO));
            }

            return null;
         }
      }).execute();
   }

   @JavascriptInterface
   public void open(final String var1) {
      (new CrashReportTemplate() {
         public Void process() {
            OrmmaBridge.this.redirectPage(var1);
            return null;
         }
      }).execute();
   }

   @JavascriptInterface
   public void open(final String var1, boolean var2, boolean var3, boolean var4) {
      (new CrashReportTemplate() {
         public Void process() {
            OrmmaBridge.this.redirectPage(var1);
            return null;
         }
      }).execute();
   }

   @JavascriptInterface
   public void openMap(String var1, boolean var2) {
   }

   @JavascriptInterface
   public void playAudio(String var1, boolean var2, boolean var3, boolean var4, int var5, String var6, String var7) {
   }

   @JavascriptInterface
   public void playVideo(final String var1) {
      if(this.isUserClicked("play video")) {
         (new CrashReportTemplate() {
            public Void process() {
               if(var1 != null && !var1.equalsIgnoreCase("undefined") && var1.length() > 0) {
                  Intent var1x = new Intent("android.intent.action.VIEW", Uri.parse(var1));
                  OrmmaBridge.this.context.startActivity(var1x);
               } else {
                  Debugger.showLog(new LogMessage("SOMA_Bridge", "Bad URL: " + var1, 1, DebugCategory.WARNING));
               }

               return null;
            }
         }).execute();
      }
   }

   @JavascriptInterface
   public void playVideo(String var1, boolean var2, boolean var3, boolean var4, boolean var5, int var6, String var7, String var8) {
   }

   @JavascriptInterface
   protected void redirectPage(final String var1) {
      (new CrashReportTemplate() {
         public Void process() {
            if(OrmmaBridge.this.isUserClicked("redirection")) {
               Debugger.showLog(new LogMessage("SOMA_Bridge", "Opening URL " + var1 + " in external browser.", 1, DebugCategory.INFO));
               Intent var1x = new Intent("android.intent.action.VIEW", Uri.parse(var1));
               OrmmaBridge.this.context.startActivity(var1x);
            } else {
               Debugger.showLog(new LogMessage("SOMA_Bridge", "Opening URL " + var1 + " in external browser. failed. User click not detected ...", 1, DebugCategory.WARNING));
            }

            return null;
         }
      }).execute();
   }

   @JavascriptInterface
   public void resize() {
      (new CrashReportTemplate() {
         public Void process() {
            String var3 = OrmmaBridge.this.resizeProperties.optString("width");
            String var4 = OrmmaBridge.this.resizeProperties.optString("height");
            if(var3 != null && var4 != null && var3.length() > 0 && var4.length() > 0) {
               int var1 = Integer.parseInt(var3);
               int var2 = Integer.parseInt(var4);
               Debugger.showLog(new LogMessage("SOMA_Bridge", "resize : width=" + var1 + " height=" + var2, 1, DebugCategory.INFO));
               Message var5 = OrmmaBridge.this.handler.obtainMessage(103, var1, var2);
               OrmmaBridge.this.handler.sendMessage(var5);
            }

            return null;
         }
      }).execute();
   }

   @JavascriptInterface
   public void resize(int var1, int var2) {
   }

   public void setContext(Context var1) {
      this.context = var1;
   }

   @JavascriptInterface
   public void setResizeProperties(String var1) {
      try {
         Debugger.showLog(new LogMessage("SOMA_Bridge", "setResizeProperties=" + var1, 1, DebugCategory.INFO));
         this.resizeProperties = new JSONObject(var1);
      } catch (Throwable var2) {
         Debugger.showLog(new LogMessage("SOMA_Bridge", "setResizeProperties " + var2.getMessage(), 1, DebugCategory.INFO));
      }
   }

   public void setWebView(WebView var1) {
      this.mWebView = var1;
   }

   @JavascriptInterface
   public void show() {
   }

   @JavascriptInterface
   public void showAlert(final String var1) {
      (new CrashReportTemplate() {
         public Void process() {
            Debugger.showLog(new LogMessage("SOMA_Bridge", "alert " + var1, 1, DebugCategory.INFO));
            return null;
         }
      }).execute();
   }

   @JavascriptInterface
   public void storePicture(final String var1) {
      if(this.isUserClicked("store picture")) {
         (new CrashReportTemplate() {
            public Void process() {
               ((Activity)OrmmaBridge.this.context).runOnUiThread(new Runnable() {
                  public void run() {
                     try {
                        if(var1 != null && !var1.equalsIgnoreCase("undefined")) {
                           Builder var1x = new Builder(OrmmaBridge.this.context);
                           var1x.setMessage("Do you want to save this picture into your photo album ?").setCancelable(false).setPositiveButton("Yes", new OnClickListener() {
                              public void onClick(DialogInterface var1x, int var2) {
                                 (new CrashReportTemplate() {
                                    public Void process() {
                                       (new ImageDownloader()).execute(new ImageDownloadProperties[]{new ImageDownloadProperties(var1, OrmmaBridge.this.context)});
                                       return null;
                                    }
                                 }).execute();
                              }
                           }).setNegativeButton("No", new OnClickListener() {
                              public void onClick(final DialogInterface var1x, int var2) {
                                 (new CrashReportTemplate() {
                                    public Void process() {
                                       var1x.cancel();
                                       return null;
                                    }
                                 }).execute();
                              }
                           });
                           var1x.create().show();
                        } else {
                           Debugger.showLog(new LogMessage("SOMA_Bridge", "Bad URL: " + var1, 1, DebugCategory.WARNING));
                        }
                     } catch (Throwable var2) {
                        Debugger.showLog(new LogMessage("SOMA_Bridge", "Unable to Store Picture !!", 2, DebugCategory.WARNING));
                     }
                  }
               });
               return null;
            }
         }).execute();
      }
   }
}
