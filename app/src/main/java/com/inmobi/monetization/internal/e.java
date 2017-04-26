package com.inmobi.monetization.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.RelativeLayout.LayoutParams;
import com.inmobi.commons.internal.Log;
import com.inmobi.monetization.internal.imai.IMAIController;
import com.inmobi.re.container.IMWebView;
import com.inmobi.re.container.IMWebView$IMWebViewListener;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONObject;

class e extends View {
   WebViewClient a = new WebViewClient() {
      public void onPageFinished(WebView var1, String var2) {
         Log.internal("[InMobi]-[Monetization]", "Native ad context code loaded");
         e.this.f = true;
         if(e.this.e != null && !e.this.e.isEmpty()) {
            for(int var3 = 0; var3 < e.this.e.size(); ++var3) {
               e.this.b((String)e.this.e.get(var3));
            }

            e.this.e.clear();
            e.this.e = null;
         }

      }
   };
   private IMWebView b;
   private boolean c = false;
   private String d;
   private ArrayList e = null;
   private boolean f = false;

   public e(Context var1, String var2, String var3) {
      super(var1);
      if(var2 != null && var3 != null) {
         this.d = var3;
         LayoutParams var4 = new LayoutParams(-1, -1);
         var4.addRule(10);
         this.setLayoutParams(var4);
         this.setBackgroundColor(0);
         IMWebView.setIMAIController(IMAIController.class);
         this.b = new IMWebView(var1, (IMWebView$IMWebViewListener)null, false, false);
         this.b.getSettings().setJavaScriptEnabled(true);
         this.b.getSettings().setCacheMode(2);
         this.b.setWebViewClient(this.a);
         this.b.loadData(var2, "text/html", "UTF-8");
         this.e = new ArrayList();
         this.setId(999);
      }
   }

   private String b() {
      return this.d + "recordEvent(18)";
   }

   private String b(HashMap var1) {
      StringBuilder var2 = new StringBuilder();
      if(var1 != null && !var1.isEmpty()) {
         var2.append(this.d + "recordEvent(8, ");
         var2.append((new JSONObject(var1)).toString());
         var2.append(")");
         return var2.toString();
      } else {
         var2.append(this.d + "recordEvent(8)");
         return var2.toString();
      }
   }

   private void c(String var1) {
      this.b.loadUrl(var1);
   }

   @TargetApi(19)
   private void d(String var1) {
      this.b.evaluateJavascript(var1, (ValueCallback)null);
   }

   public void a() {
      if(this.b != null) {
         this.b.destroy();
         this.b = null;
      }

      if(this.e != null) {
         this.e.clear();
         this.e = null;
      }

      this.c = false;
      this.f = false;
   }

   public void a(String var1) {
      Log.debug("[InMobi]-[Monetization]", "Handle Impression");
      this.b(var1);
   }

   public void a(HashMap var1) {
      Log.debug("[InMobi]-[Monetization]", "Handle Click");
      String var2 = this.b(var1);
      if(this.f) {
         this.b(var2);
      } else if(this.e != null) {
         this.e.add(var2);
         return;
      }

   }

   public void b(String var1) {
      if(var1 != null) {
         try {
            if(var1.length() < 400) {
               Log.internal("[InMobi]-[Monetization]", var1);
            }

            if(this.b != null) {
               var1 = "javascript:try{" + var1 + "}catch(e){}";
               if(VERSION.SDK_INT < 19) {
                  this.c(var1);
                  return;
               }

               this.d(var1);
               return;
            }
         } catch (Exception var2) {
            var2.printStackTrace();
         }
      }

   }

   protected void onWindowVisibilityChanged(int var1) {
      super.onWindowVisibilityChanged(var1);
      if(var1 == 0 && !this.c) {
         this.c = true;
         if(this.f) {
            this.a(this.b());
         } else if(this.e != null) {
            this.e.add(this.b());
            return;
         }
      }

   }
}
