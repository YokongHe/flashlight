package com.millennialmedia.android;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.GeolocationPermissions.Callback;
import android.widget.Toast;
import com.millennialmedia.android.MMWebView;
import java.lang.ref.WeakReference;

class MMWebView$MyWebChromeClient extends WebChromeClient {
   private static final String KEY_USE_GEO = "mm_use_geo_location";
   WeakReference webRef;

   MMWebView$MyWebChromeClient(MMWebView var1) {
      this.webRef = new WeakReference(var1);
   }

   private String getApplicationName(Context var1) {
      PackageManager var2 = var1.getApplicationContext().getPackageManager();

      ApplicationInfo var4;
      try {
         var4 = var2.getApplicationInfo(var1.getPackageName(), 0);
      } catch (NameNotFoundException var3) {
         var4 = null;
      }

      Object var5;
      if(var4 != null) {
         var5 = var2.getApplicationLabel(var4);
      } else {
         var5 = "This app";
      }

      return (String)var5;
   }

   private boolean isFirstGeoRequest() {
      MMWebView var1 = (MMWebView)this.webRef.get();
      return var1 != null?!var1.getContext().getSharedPreferences("MillennialMediaSettings", 0).contains("mm_use_geo_location"):false;
   }

   private boolean retrieveUseGeo() {
      MMWebView var1 = (MMWebView)this.webRef.get();
      return var1 != null?var1.getContext().getSharedPreferences("MillennialMediaSettings", 0).getBoolean("mm_use_geo_location", false):false;
   }

   private void saveUseGeo(boolean var1) {
      MMWebView var2 = (MMWebView)this.webRef.get();
      if(var2 != null) {
         Editor var3 = var2.getContext().getSharedPreferences("MillennialMediaSettings", 0).edit();
         var3.putBoolean("mm_use_geo_location", var1);
         var3.commit();
      }

   }

   public void onConsoleMessage(String var1, int var2, String var3) {
      super.onConsoleMessage(var1, var2, var3);
   }

   public void onGeolocationPermissionsShowPrompt(final String var1, final Callback var2) {
      if(this.isFirstGeoRequest()) {
         if(this.retrieveUseGeo()) {
            var2.invoke(var1, true, true);
         } else {
            MMWebView var3 = (MMWebView)this.webRef.get();
            if(var3 != null) {
               Activity var5 = var3.getActivity();
               if(var5 != null) {
                  Builder var4 = new Builder(var5);
                  var4.setTitle(this.getApplicationName(var5));
                  var4.setMessage("Would like to use your Current Location.").setPositiveButton("Allow", new OnClickListener() {
                     public void onClick(DialogInterface var1x, int var2x) {
                        MMWebView$MyWebChromeClient.this.saveUseGeo(true);
                        var2.invoke(var1, true, true);
                     }
                  }).setNegativeButton("Don\'t Allow", new OnClickListener() {
                     public void onClick(DialogInterface var1x, int var2x) {
                        MMWebView$MyWebChromeClient.this.saveUseGeo(false);
                        var2.invoke(var1, false, false);
                     }
                  });
                  var4.create().show();
                  return;
               }
            }
         }

      } else {
         var2.invoke(var1, false, false);
      }
   }

   public boolean onJsAlert(WebView var1, String var2, String var3, JsResult var4) {
      MMWebView var5 = (MMWebView)this.webRef.get();
      if(var5 != null) {
         if(var5.getContext() != var5.getContext().getApplicationContext()) {
            return super.onJsAlert(var1, var2, var3, var4);
         }

         Toast.makeText(var5.getContext(), var3, 0).show();
      }

      return true;
   }

   public boolean onJsBeforeUnload(WebView var1, String var2, String var3, JsResult var4) {
      MMWebView var5 = (MMWebView)this.webRef.get();
      if(var5 != null) {
         if(var5.getContext() != var5.getContext().getApplicationContext()) {
            return super.onJsBeforeUnload(var1, var2, var3, var4);
         }

         Toast.makeText(var5.getContext(), var3, 0).show();
      }

      return true;
   }

   public boolean onJsConfirm(WebView var1, String var2, String var3, JsResult var4) {
      MMWebView var5 = (MMWebView)this.webRef.get();
      if(var5 != null) {
         if(var5.getContext() != var5.getContext().getApplicationContext()) {
            return super.onJsConfirm(var1, var2, var3, var4);
         }

         Toast.makeText(var5.getContext(), var3, 0).show();
      }

      return true;
   }

   public boolean onJsPrompt(WebView var1, String var2, String var3, String var4, JsPromptResult var5) {
      MMWebView var6 = (MMWebView)this.webRef.get();
      if(var6 != null) {
         if(var6.getContext() != var6.getContext().getApplicationContext()) {
            return super.onJsPrompt(var1, var2, var3, var4, var5);
         }

         Toast.makeText(var6.getContext(), var3, 0).show();
      }

      return true;
   }
}
