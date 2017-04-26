package com.inmobi.re.container;

import android.os.AsyncTask;
import com.inmobi.re.container.IMWebView;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

class IMWebView$a extends AsyncTask {
   File a;
   String b;
   String c;
   int d;
   String e;
   // $FF: synthetic field
   final IMWebView f;

   IMWebView$a(IMWebView var1, File var2, String var3, String var4) {
      this.f = var1;
      this.d = -1;
      this.e = "";
      this.a = var2;
      this.b = var3;
      this.c = var4;
      if(IMWebView.q(var1) == null) {
         IMWebView.a(var1, new ArrayList());
      }

      IMWebView.q(var1).add(this);
   }

   public String a() {
      return this.c;
   }

   protected String a(Void... param1) {
      // $FF: Couldn't be decompiled
   }

   protected void a(String var1) {
      if(var1.equals("success")) {
         this.f.injectJavaScript("window.mraid.sendSaveContentResult(\"saveContent_" + this.c + "\", \'success\', \"" + this.e + "\");");
         if(this.f.c != null) {
            this.f.c.postSuccess();
         }
      } else {
         JSONObject var2 = new JSONObject();

         try {
            var2.put("url", this.b);
            var2.put("reason", this.d);
            String var4 = var2.toString().replace("\"", "\\\"");
            this.f.injectJavaScript("window.mraid.sendSaveContentResult(\"saveContent_" + this.c + "\", \'failure\', \"" + var4 + "\");");
            if(this.f.c != null) {
               this.f.c.postFailed(this.d);
            }
         } catch (JSONException var3) {
            ;
         }
      }

      super.onPostExecute(var1);
   }

   // $FF: synthetic method
   protected Object doInBackground(Object[] var1) {
      return this.a((Void[])var1);
   }

   protected void onCancelled() {
      super.onCancelled();
   }

   // $FF: synthetic method
   protected void onPostExecute(Object var1) {
      this.a((String)var1);
   }
}
