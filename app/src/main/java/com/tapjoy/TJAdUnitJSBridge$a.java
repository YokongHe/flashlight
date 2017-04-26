package com.tapjoy;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Paint;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.tapjoy.TJAdUnitJSBridge;

@TargetApi(11)
final class TJAdUnitJSBridge$a extends AsyncTask {
   WebView a;
   // $FF: synthetic field
   final TJAdUnitJSBridge b;

   public TJAdUnitJSBridge$a(TJAdUnitJSBridge var1, WebView var2) {
      this.b = var1;
      this.a = var2;
   }

   // $FF: synthetic method
   protected final void onPostExecute(Object var1) {
      Boolean[] var4 = (Boolean[])var1;
      final boolean var2 = var4[0].booleanValue();
      final boolean var3 = var4[1].booleanValue();
      ((Activity)TJAdUnitJSBridge.d(this.b)).runOnUiThread(new Runnable() {
         public final void run() {
            if(var2) {
               TJAdUnitJSBridge$a.this.a.setVisibility(0);
               if(var3) {
                  if(TJAdUnitJSBridge$a.this.a.getParent() instanceof RelativeLayout) {
                     ((RelativeLayout)TJAdUnitJSBridge$a.this.a.getParent()).getBackground().setAlpha(0);
                     ((RelativeLayout)TJAdUnitJSBridge$a.this.a.getParent()).setBackgroundColor(0);
                  }

                  if(VERSION.SDK_INT >= 11) {
                     TJAdUnitJSBridge$a.this.a.setLayerType(1, (Paint)null);
                  }
               } else {
                  if(TJAdUnitJSBridge$a.this.a.getParent() instanceof RelativeLayout) {
                     ((RelativeLayout)TJAdUnitJSBridge$a.this.a.getParent()).getBackground().setAlpha(255);
                     ((RelativeLayout)TJAdUnitJSBridge$a.this.a.getParent()).setBackgroundColor(-1);
                  }

                  if(VERSION.SDK_INT >= 11) {
                     TJAdUnitJSBridge$a.this.a.setLayerType(0, (Paint)null);
                     return;
                  }
               }
            } else {
               TJAdUnitJSBridge$a.this.a.setVisibility(4);
               if(TJAdUnitJSBridge$a.this.a.getParent() instanceof RelativeLayout) {
                  ((RelativeLayout)TJAdUnitJSBridge$a.this.a.getParent()).getBackground().setAlpha(0);
                  ((RelativeLayout)TJAdUnitJSBridge$a.this.a.getParent()).setBackgroundColor(0);
                  return;
               }
            }

         }
      });
   }
}
