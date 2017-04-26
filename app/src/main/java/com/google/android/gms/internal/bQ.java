package com.google.android.gms.internal;

import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebStorage.QuotaUpdater;
import android.webkit.WebView.WebViewTransport;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class bQ extends WebChromeClient {
   private final com.google.android.gms.internal.bL a;

   public bQ(com.google.android.gms.internal.bL var1) {
      this.a = var1;
   }

   private static boolean a(Context var0, String var1, String var2, String var3, final JsResult var4, final JsPromptResult var5, boolean var6) {
      Builder var7 = new Builder(var0);
      var7.setTitle(var1);
      if(var6) {
         LinearLayout var9 = new LinearLayout(var0);
         var9.setOrientation(1);
         TextView var10 = new TextView(var0);
         var10.setText(var2);
         final EditText var8 = new EditText(var0);
         var8.setText(var3);
         var9.addView(var10);
         var9.addView(var8);
         var7.setView(var9).setPositiveButton(17039370, new OnClickListener() {
            public final void onClick(DialogInterface var1, int var2) {
               var5.confirm(var8.getText().toString());
            }
         }).setNegativeButton(17039360, new OnClickListener() {
            public final void onClick(DialogInterface var1, int var2) {
               var5.cancel();
            }
         }).setOnCancelListener(new OnCancelListener() {
            public final void onCancel(DialogInterface var1) {
               var5.cancel();
            }
         }).create().show();
         return true;
      } else {
         var7.setMessage(var2).setPositiveButton(17039370, new OnClickListener() {
            public final void onClick(DialogInterface var1, int var2) {
               var4.confirm();
            }
         }).setNegativeButton(17039360, new OnClickListener() {
            public final void onClick(DialogInterface var1, int var2) {
               var4.cancel();
            }
         }).setOnCancelListener(new OnCancelListener() {
            public final void onCancel(DialogInterface var1) {
               var4.cancel();
            }
         }).create().show();
         return true;
      }
   }

   protected final void a(View var1, int var2, CustomViewCallback var3) {
      com.google.android.gms.internal.as var4 = this.a.d();
      if(var4 == null) {
         com.google.android.gms.internal.bJ.e("Could not get ad overlay when showing custom view.");
         var3.onCustomViewHidden();
      } else {
         var4.a(var1, var3);
         var4.a(var2);
      }
   }

   public final void onCloseWindow(WebView var1) {
      if(!(var1 instanceof com.google.android.gms.internal.bL)) {
         com.google.android.gms.internal.bJ.e("Tried to close a WebView that wasn\'t an AdWebView.");
      } else {
         com.google.android.gms.internal.as var2 = ((com.google.android.gms.internal.bL)var1).d();
         if(var2 == null) {
            com.google.android.gms.internal.bJ.e("Tried to close an AdWebView not associated with an overlay.");
         } else {
            var2.a();
         }
      }
   }

   public final boolean onConsoleMessage(ConsoleMessage var1) {
      String var2 = "JS: " + var1.message() + " (" + var1.sourceId() + ":" + var1.lineNumber() + ")";
      switch(null.a[var1.messageLevel().ordinal()]) {
      case 1:
         com.google.android.gms.internal.bJ.b(var2);
         break;
      case 2:
         com.google.android.gms.internal.bJ.e(var2);
         break;
      case 3:
      case 4:
         com.google.android.gms.internal.bJ.c(var2);
         break;
      case 5:
         com.google.android.gms.internal.bJ.a(var2);
         break;
      default:
         com.google.android.gms.internal.bJ.c(var2);
      }

      return super.onConsoleMessage(var1);
   }

   public final boolean onCreateWindow(WebView var1, boolean var2, boolean var3, Message var4) {
      WebViewTransport var5 = (WebViewTransport)var4.obj;
      var1 = new WebView(var1.getContext());
      var1.setWebViewClient(this.a.f());
      var5.setWebView(var1);
      var4.sendToTarget();
      return true;
   }

   public final void onExceededDatabaseQuota(String var1, String var2, long var3, long var5, long var7, QuotaUpdater var9) {
      long var10 = 5242880L - var7;
      if(var10 <= 0L) {
         var9.updateQuota(var3);
      } else {
         if(var3 == 0L) {
            if(var5 > var10 || var5 > 1048576L) {
               var5 = 0L;
            }
         } else {
            if(var5 == 0L) {
               var7 = Math.min(Math.min(131072L, var10) + var3, 1048576L);
            } else {
               var7 = var3;
               if(var5 <= Math.min(1048576L - var3, var10)) {
                  var7 = var3 + var5;
               }
            }

            var5 = var7;
         }

         var9.updateQuota(var5);
      }
   }

   public final void onHideCustomView() {
      com.google.android.gms.internal.as var1 = this.a.d();
      if(var1 == null) {
         com.google.android.gms.internal.bJ.e("Could not get ad overlay when hiding custom view.");
      } else {
         var1.c();
      }
   }

   public final boolean onJsAlert(WebView var1, String var2, String var3, JsResult var4) {
      return a(var1.getContext(), var2, var3, (String)null, var4, (JsPromptResult)null, false);
   }

   public final boolean onJsBeforeUnload(WebView var1, String var2, String var3, JsResult var4) {
      return a(var1.getContext(), var2, var3, (String)null, var4, (JsPromptResult)null, false);
   }

   public final boolean onJsConfirm(WebView var1, String var2, String var3, JsResult var4) {
      return a(var1.getContext(), var2, var3, (String)null, var4, (JsPromptResult)null, false);
   }

   public final boolean onJsPrompt(WebView var1, String var2, String var3, String var4, JsPromptResult var5) {
      return a(var1.getContext(), var2, var3, var4, (JsResult)null, var5, true);
   }

   public final void onReachedMaxAppCacheSize(long var1, long var3, QuotaUpdater var5) {
      var1 += 131072L;
      if(5242880L - var3 < var1) {
         var5.updateQuota(0L);
      } else {
         var5.updateQuota(var1);
      }
   }

   public final void onShowCustomView(View var1, CustomViewCallback var2) {
      this.a(var1, -1, var2);
   }
}
