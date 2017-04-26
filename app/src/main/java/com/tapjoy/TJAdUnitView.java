package com.tapjoy;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.tapjoy.TJAdUnitJSBridge;
import com.tapjoy.TJAdUnitView$a;
import com.tapjoy.TJPlacement;
import com.tapjoy.TJPlacementData;
import com.tapjoy.TJPlacementManager;
import com.tapjoy.TapjoyConnectCore;
import com.tapjoy.TapjoyLog;
import com.tapjoy.TapjoyUtil;
import com.tapjoy.TapjoyVideo;
import com.tapjoy.internal.fv;
import com.tapjoy.mraid.view.MraidView;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

@SuppressLint({"SetJavaScriptEnabled"})
public class TJAdUnitView extends Activity {
   protected RelativeLayout a = null;
   protected MraidView b = null;
   protected String c = null;
   protected String d = null;
   protected boolean e = false;
   protected boolean f = false;
   protected TJAdUnitJSBridge g;
   protected int h = 0;
   protected boolean i;
   private int j = 0;
   private TJPlacementData k;
   private TJPlacement l;
   private String m;
   private boolean n = false;
   private ProgressBar o;
   private ImageButton p;
   private boolean q = true;
   private String r = "A connection error occurred loading this content.";
   private boolean s = false;

   // $FF: synthetic method
   static void a(TJAdUnitView var0, String var1) {
      var0.a(var1);
   }

   private void a(String var1) {
      Intent var2 = new Intent();
      var2.putExtra("result", var1);
      this.setResult(-1, var2);
      this.finish();
   }

   @TargetApi(12)
   private void b() {
      TapjoyLog.i("TJAdUnitView", "initUI");
      Bundle var2 = this.getIntent().getExtras();
      if(var2 != null) {
         if(var2.getString("DISPLAY_AD_URL") != null) {
            this.f = true;
            this.c = var2.getString("DISPLAY_AD_URL");
         } else if(var2.getSerializable("URL_PARAMS") != null) {
            this.f = false;
            HashMap var3 = (HashMap)var2.getSerializable("URL_PARAMS");
            TapjoyLog.i("TJAdUnitView", "urlParams: " + var3);
            this.c = TapjoyConnectCore.getHostURL() + "get_offers/webpage?" + TapjoyUtil.convertURLParams((Map)var3, false);
         }

         this.k = (TJPlacementData)var2.getSerializable("tjplacement");
         if(this.k != null) {
            this.l = TJPlacementManager.get(this.k.guid);
         }

         this.j = var2.getInt("view_type");
         String var9 = var2.getString("html");
         String var4 = var2.getString("base_url");
         this.d = var2.getString("url");
         this.m = var2.getString("callback_id");
         this.n = var2.getBoolean("legacy_view");
         if(this.b == null) {
            boolean var1;
            label78: {
               label77: {
                  this.b = new MraidView(this);
                  this.b.getSettings().setJavaScriptEnabled(true);
                  this.b.setListener(new TJAdUnitView$a(this, (byte)0));
                  this.g = new TJAdUnitJSBridge(this, this.b, this.k);
                  if(this.j == 1) {
                     TapjoyLog.i("TJAdUnitView", "Loading event data");
                     if(this.l == null) {
                        break label77;
                     }

                     if(!this.k.redirectedFromOtherContent) {
                        this.b.loadDataWithBaseURL(this.k.baseURL, this.k.httpResponse, "text/html", "utf-8", (String)null);
                        this.b.setVisibility(4);
                        TapjoyConnectCore.viewDidOpen(0);
                        if(this.l.a() != null) {
                           this.l.a().onContentShow(this.l);
                           var1 = false;
                           break label78;
                        }
                        break label77;
                     }

                     TapjoyLog.i("TJAdUnitView", "Load URL: " + this.d);
                     this.b.loadUrl(this.d);
                  } else if(var9 != null && var9.length() > 0) {
                     TapjoyLog.i("TJAdUnitView", "Loading HTML data");
                     if(this.n) {
                        this.b.loadDataWithBaseURL(var4, var9, "text/html", "utf-8", (String)null);
                     } else {
                        this.b.loadDataWithBaseURL((String)null, var9, "text/html", "utf-8", (String)null);
                     }
                  } else if(this.d != null) {
                     TapjoyLog.i("TJAdUnitView", "Load URL: " + this.d);
                     this.b.loadUrl(this.d);
                  } else if(this.c != null) {
                     TapjoyLog.i("TJAdUnitView", "Load Offer Wall URL");
                     this.b.loadUrl(this.c);
                  }

                  var1 = true;
                  break label78;
               }

               var1 = false;
            }

            if(VERSION.SDK_INT >= 11) {
               this.getWindow().setFlags(16777216, 16777216);
            }

            this.getWindow().setBackgroundDrawable(new ColorDrawable(1610612736));
            LayoutParams var5 = new LayoutParams(-1, -1);
            this.a = new RelativeLayout(this);
            this.a.setLayoutParams(var5);
            if(this.j == 1) {
               this.a.setBackgroundColor(0);
               this.a.getBackground().setAlpha(0);
            } else {
               this.a.setBackgroundColor(-1);
               this.a.getBackground().setAlpha(255);
            }

            this.b.setLayoutParams(var5);
            if(this.b.getParent() != null) {
               ((ViewGroup)this.b.getParent()).removeView(this.b);
            }

            this.a.addView(this.b, -1, -1);
            this.setContentView(this.a);
            android.widget.RelativeLayout.LayoutParams var7;
            if(this.n && var1) {
               this.o = new ProgressBar(this, (AttributeSet)null, 16842874);
               this.o.setVisibility(0);
               var7 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
               var7.addRule(13);
               this.o.setLayoutParams(var7);
               this.a.addView(this.o);
            }

            if(!this.b.isMraid()) {
               this.p = new ImageButton(this);
               Bitmap var8 = this.d();
               if(var8 == null) {
                  Log.e("TJAdUnitView", "Error loading bitmap data for close button!");
                  return;
               }

               this.p.setImageBitmap(var8);
               this.p.setBackgroundColor(16777215);
               this.p.setOnClickListener(new OnClickListener() {
                  public final void onClick(View var1) {
                     TJAdUnitView.this.handleClose();
                  }
               });
               var7 = new android.widget.RelativeLayout.LayoutParams(-2, -2);
               var7.addRule(10);
               var7.addRule(11);
               int var6 = (int)(-10.0F * TapjoyConnectCore.getDeviceScreenDensityScale());
               var7.setMargins(0, var6, var6, 0);
               this.a.addView(this.p, var7);
               if(VERSION.SDK_INT >= 12) {
                  this.p.setAlpha(0.0F);
                  this.p.setVisibility(0);
                  this.p.setClickable(false);
                  (new Handler()).postDelayed(new Runnable() {
                     public final void run() {
                        TJAdUnitView.this.p.animate().alpha(1.0F).setDuration(500L).setListener(new AnimatorListener() {
                           public final void onAnimationCancel(Animator var1) {
                           }

                           public final void onAnimationEnd(Animator var1) {
                              TJAdUnitView.this.p.setClickable(true);
                           }

                           public final void onAnimationRepeat(Animator var1) {
                           }

                           public final void onAnimationStart(Animator var1) {
                           }
                        });
                     }
                  }, 2000L);
               }
            }
         }
      }

   }

   // $FF: synthetic method
   static void b(final TJAdUnitView var0, String var1) {
      Map var6 = TapjoyUtil.convertURLParams(var1.substring(var1.indexOf("://") + 3), true);
      var1 = (String)var6.get("video_id");
      String var2 = (String)var6.get("amount");
      String var3 = (String)var6.get("currency_name");
      String var4 = (String)var6.get("click_url");
      String var5 = (String)var6.get("video_complete_url");
      String var9 = (String)var6.get("video_url");
      TapjoyLog.i("TJAdUnitView", "video_id: " + var1);
      TapjoyLog.i("TJAdUnitView", "amount: " + var2);
      TapjoyLog.i("TJAdUnitView", "currency_name: " + var3);
      TapjoyLog.i("TJAdUnitView", "click_url: " + var4);
      TapjoyLog.i("TJAdUnitView", "video_complete_url: " + var5);
      TapjoyLog.i("TJAdUnitView", "video_url: " + var9);
      if(TapjoyVideo.getInstance().startVideo(var1, var3, var2, var4, var5, var9)) {
         TapjoyLog.i("TJAdUnitView", "Video started successfully");
      } else {
         TapjoyLog.e("TJAdUnitView", "Unable to play video: " + var1);
         AlertDialog var8 = (new Builder(var0)).setTitle("").setMessage("Unable to play video.").setPositiveButton("OK", new android.content.DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface var1, int var2) {
               var1.dismiss();
            }
         }).create();

         try {
            var8.show();
         } catch (Exception var7) {
            TapjoyLog.e("TJAdUnitView", "e: " + var7.toString());
         }
      }
   }

   // $FF: synthetic method
   static boolean b(TJAdUnitView var0) {
      return var0.n;
   }

   private static Bitmap c() {
      try {
         float var0 = TapjoyConnectCore.getDeviceScreenDensityScale();
         Bitmap var1 = Bitmap.createBitmap((int)(50.0F * var0), (int)(var0 * 50.0F), Config.ARGB_8888);
         return var1;
      } catch (Exception var2) {
         var2.printStackTrace();
         return null;
      }
   }

   // $FF: synthetic method
   static ProgressBar c(TJAdUnitView var0) {
      return var0.o;
   }

   // $FF: synthetic method
   static int d(TJAdUnitView var0) {
      return var0.j;
   }

   private Bitmap d() {
      return !this.q?c():TapjoyUtil.loadBitmapFromJar("tj_close_button.png", this);
   }

   private void e() {
      this.g.disable();
      if(this.j == 4) {
         this.a("offer_wall");
      } else if(this != null) {
         this.finish();
         return;
      }

   }

   protected final boolean a() {
      ConnectivityManager var1 = (ConnectivityManager)this.getSystemService("connectivity");
      return var1.getActiveNetworkInfo() != null && var1.getActiveNetworkInfo().isAvailable() && var1.getActiveNetworkInfo().isConnected();
   }

   public void finish() {
      if(this.j != 1 && this.j != 4) {
         Intent var1 = new Intent();
         var1.putExtra("result", Boolean.TRUE);
         var1.putExtra("callback_id", this.m);
         this.setResult(-1, var1);
      }

      super.finish();
   }

   public void handleClose() {
      if(this.b.videoPlaying()) {
         this.b.videoViewCleanup();
      } else {
         if(this.g.customClose) {
            TapjoyLog.i("TJAdUnitView", "customClose");
            if(!this.g.shouldClose) {
               TapjoyLog.i("TJAdUnitView", "closeRequested...");
               this.g.closeRequested();
               TimerTask var1 = new TimerTask() {
                  public final void run() {
                     if(TJAdUnitView.this.g.shouldClose) {
                        TapjoyLog.i("TJAdUnitView", "customClose timeout");
                        TJAdUnitView.this.e();
                     }

                  }
               };
               (new Timer()).schedule(var1, 1000L);
               return;
            }
         }

         this.e();
      }
   }

   public void handleWebViewOnPageFinished(WebView var1, String var2) {
      TapjoyLog.i("TJAdUnitView", "handleWebViewOnPageFinished");
   }

   public void handleWebViewOnReceivedError(WebView var1, int var2, String var3, String var4) {
      TapjoyLog.i("TJAdUnitView", "handleWebViewError");
      if(!this.isFinishing()) {
         (new Builder(this)).setMessage(this.r).setPositiveButton("OK", new android.content.DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface var1, int var2) {
               var1.cancel();
            }
         }).create().show();
      }

   }

   protected void onActivityResult(int var1, int var2, Intent var3) {
      super.onActivityResult(var1, var2, var3);
      Log.i("TJAdUnitView", "onActivityResult requestCode:" + var1 + ", resultCode: " + var2);
      Bundle var4 = null;
      if(var3 != null) {
         var4 = var3.getExtras();
      }

      if(var4 != null && var4.getString("callback_id") != null) {
         TapjoyLog.i("TJAdUnitView", "onActivityResult extras: " + var4.keySet());
         this.g.invokeJSCallback(var4.getString("callback_id"), new Object[]{Boolean.valueOf(var4.getBoolean("result")), var4.getString("result_string1"), var4.getString("result_string2")});
      }

   }

   public void onConfigurationChanged(Configuration var1) {
      TapjoyLog.i("TJAdUnitView", "onConfigurationChanged");
      super.onConfigurationChanged(var1);
      this.b();
   }

   protected void onCreate(Bundle var1) {
      if(VERSION.SDK_INT < 11) {
         this.setTheme(16973839);
      } else {
         this.requestWindowFeature(1);
         this.getWindow().setFlags(1024, 1024);
      }

      TapjoyLog.i("TJAdUnitView", "TJAdUnitView onCreate: " + var1);
      super.onCreate(var1);
      this.b();
   }

   protected void onDestroy() {
      super.onDestroy();
      TapjoyLog.i("TJAdUnitView", "onDestroy isFinishing: " + this.isFinishing());
      if(this.isFinishing()) {
         if(this.j == 1) {
            this.g.destroy();
            TapjoyConnectCore.viewWillClose(0);
            TapjoyConnectCore.viewDidClose(0);
            if(this.l != null && this.l.a() != null) {
               this.l.a().onContentDismiss(this.l);
            }

            if(this.l != null && this.l.c()) {
               TJPlacementManager.decrementPlacementCacheCount();
               this.l.d();
            }
         }

         if(this.b != null) {
            try {
               WebView.class.getMethod("onPause", new Class[0]).invoke(this.b, new Object[0]);
            } catch (Exception var3) {
               ;
            }

            try {
               this.b = null;
            } catch (Exception var2) {
               return;
            }
         }
      }

   }

   public boolean onKeyDown(int var1, KeyEvent var2) {
      if(var1 == 4) {
         this.handleClose();
         return true;
      } else {
         return super.onKeyDown(var1, var2);
      }
   }

   protected void onPause() {
      super.onPause();
      this.e = true;

      try {
         WebView.class.getMethod("onPause", new Class[0]).invoke(this.b, new Object[0]);
      } catch (Exception var2) {
         ;
      }
   }

   protected void onRestoreInstanceState(Bundle var1) {
      super.onRestoreInstanceState(var1);
      if(this.b != null) {
         this.b.restoreState(var1);
      }

   }

   protected void onResume() {
      super.onResume();

      try {
         WebView.class.getMethod("onResume", new Class[0]).invoke(this.b, new Object[0]);
      } catch (Exception var2) {
         ;
      }

      if(this.j == 1 && this.g.didLaunchOtherActivity) {
         TapjoyLog.i("TJAdUnitView", "onResume bridge.didLaunchOtherActivity callbackID: " + this.g.otherActivityCallbackID);
         this.g.invokeJSCallback(this.g.otherActivityCallbackID, new Object[]{Boolean.TRUE});
         this.g.didLaunchOtherActivity = false;
      }

   }

   protected void onSaveInstanceState(Bundle var1) {
      super.onSaveInstanceState(var1);
      if(this.b != null) {
         this.b.saveState(var1);
      }

   }

   protected void onStart() {
      super.onStart();
      if(TapjoyConnectCore.isAutoSessionTrackingStarted()) {
         this.s = true;
         fv.a().a((Activity)this);
      }

   }

   protected void onStop() {
      if(this.s) {
         this.s = false;
         fv.a().b((Activity)this);
      }

      super.onStop();
   }

   public void setCloseButtonVisibility(boolean var1) {
      if(this.q != var1) {
         this.q = var1;
         if(this.p != null) {
            Bitmap var2 = this.d();
            if(var2 != null) {
               this.p.setImageBitmap(var2);
            }
         }
      }

   }
}
