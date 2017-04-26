package com.facebook.ads.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AdSize;
import com.facebook.ads.a.j$a;
import com.facebook.ads.a.j$b;
import com.facebook.ads.a.p$a;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONObject;
import org.json.JSONTokener;

public class j {
   private static final String a = com.facebook.ads.a.j.class.getSimpleName();
   private final Context b;
   private final String c;
   private final AdSize d;
   private final com.facebook.ads.a.n e;
   private final String f;
   private final int g;
   private final j$b h;
   private final com.facebook.ads.a.o i;
   private final boolean j;

   public j(Context var1, String var2, AdSize var3, com.facebook.ads.a.n var4, com.facebook.ads.a.o var5, int var6, boolean var7, j$b var8) {
      if(var2 != null && var2.length() > 0) {
         if(var3 == null) {
            throw new IllegalArgumentException("adSize");
         } else if(var8 == null) {
            throw new IllegalArgumentException("callback");
         } else {
            this.b = var1;
            this.c = var2;
            this.d = var3;
            this.e = var4;
            this.f = com.facebook.ads.a.s.a(var1, var5);
            this.i = var5;
            this.g = var6;
            this.j = var7;
            this.h = var8;
         }
      } else {
         throw new IllegalArgumentException("placementId");
      }
   }

   private j$a a(InputStream var1) {
      j$a var2 = new j$a(null);

      try {
         Object var4 = (new JSONTokener(com.facebook.ads.a.p.a(var1))).nextValue();
         if(var4 instanceof JSONObject) {
            JSONObject var5 = (JSONObject)var4;
            if(var5.has("error")) {
               var2.b = new AdError(2000, ((JSONObject)com.facebook.ads.a.p.a(var5, "error")).optString("message", AdError.SERVER_ERROR.getErrorMessage()));
            } else {
               var2.a = var5;
               var2.b = null;
            }
         }
      } catch (Exception var3) {
         var2.b = new AdError(2000, var3.getMessage());
      }

      return var2.a == null && var2.b == null?null:var2;
   }

   private void a(Map var1) {
      var1.put("os", "Android");
      var1.put("os_version", VERSION.RELEASE);
      DisplayMetrics var4 = this.b.getResources().getDisplayMetrics();
      int var2 = (int)((float)var4.widthPixels / var4.density);
      int var3 = (int)((float)var4.heightPixels / var4.density);
      var1.put("screen_width", Integer.valueOf(var2));
      var1.put("screen_height", Integer.valueOf(var3));

      try {
         PackageInfo var7 = this.b.getPackageManager().getPackageInfo(this.b.getPackageName(), 0);
         var1.put("app_build", Integer.valueOf(var7.versionCode));
         var1.put("app_version", var7.versionName);
      } catch (NameNotFoundException var6) {
         var1.put("app_version", Integer.valueOf(0));
      }

      Locale var5 = this.b.getResources().getConfiguration().locale;
      Locale var8 = var5;
      if(var5 == null) {
         var8 = Locale.getDefault();
      }

      var1.put("locale", var8.toString());
   }

   private void a(Map var1, p$a var2) {
      boolean var3 = true;
      com.facebook.ads.a.t var4 = com.facebook.ads.a.t.a(this.b, var2);
      if(var4 == null) {
         var1.put("tracking_enabled", Boolean.valueOf(true));
      } else {
         if(var4.b()) {
            var3 = false;
         }

         var1.put("tracking_enabled", Boolean.valueOf(var3));
         if(!var4.b()) {
            var1.put("device_id", var4.a());
            return;
         }
      }

   }

   private void b(Map var1) {
      var1.put("package_name", this.b.getPackageName());
   }

   private String c() {
      switch(null.a[this.i.ordinal()]) {
      case 1:
         return "network_ads_native";
      default:
         return "network_ads";
      }
   }

   private String c(Map var1) {
      StringBuilder var3 = new StringBuilder(512);
      Iterator var5 = var1.entrySet().iterator();

      Entry var4;
      for(boolean var2 = true; var5.hasNext(); var3.append(URLEncoder.encode((String)var4.getKey(), "utf-8")).append("=").append(URLEncoder.encode(String.valueOf(var4.getValue()), "utf-8"))) {
         var4 = (Entry)var5.next();
         if(var2) {
            var2 = false;
         } else {
            var3.append("&");
         }
      }

      return var3.toString();
   }

   private Map d() {
      HashMap var1 = new HashMap();
      p$a var2 = com.facebook.ads.a.p.a(this.b.getContentResolver());
      var1.put("ad_type", Integer.valueOf(this.i.a()));
      var1.put("sdk_capabilities", com.facebook.ads.a.m.b());
      var1.put("sdk_version", "3.22.0");
      var1.put("placement_id", this.c);
      var1.put("attribution_id", var2.a);
      var1.put("width", Integer.valueOf(this.d.getWidth()));
      var1.put("height", Integer.valueOf(this.d.getHeight()));
      var1.put("template_id", Integer.valueOf(this.e.a()));
      var1.put("test_mode", Boolean.valueOf(this.j));
      var1.put("child_directed", Boolean.valueOf(AdSettings.isChildDirected()));
      var1.put("events", com.facebook.ads.a.c.a());
      var1.put("num_ads_requested", Integer.valueOf(this.g));
      this.a((Map)var1);
      this.b((Map)var1);
      this.a(var1, var2);
      return var1;
   }

   private URL e() {
      String var1 = AdSettings.getUrlPrefix();
      if(com.facebook.ads.a.ag.a(var1)) {
         var1 = "https://graph.facebook.com";
      } else {
         var1 = String.format("http://graph.%s.facebook.com", new Object[]{var1});
      }

      return new URL(String.format("%s/%s", new Object[]{var1, this.c()}));
   }

   private HttpURLConnection f() {
      HttpURLConnection var1 = (HttpURLConnection)this.e().openConnection();
      var1.setRequestProperty("User-Agent", this.f);
      var1.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
      var1.setRequestMethod("POST");
      var1.setDoOutput(true);
      var1.setConnectTimeout(30000);
      var1.setReadTimeout(30000);
      String var2 = this.c(this.d());
      BufferedOutputStream var3 = new BufferedOutputStream(var1.getOutputStream());
      BufferedWriter var4 = new BufferedWriter(new OutputStreamWriter(var3, "utf-8"));
      var4.write(var2);
      var4.flush();
      var4.close();
      var3.close();
      var1.connect();
      return var1;
   }

   public AsyncTask a() {
      com.facebook.ads.a.a.a(this.b);
      return (new AsyncTask() {
         protected j$a a(Void... var1) {
            return j.this.b();
         }

         protected void a(j$a var1) {
            if(var1 == null) {
               j.this.h.a(AdError.INTERNAL_ERROR);
            } else if(var1.b != null) {
               j.this.h.a(var1.b);
            } else {
               com.facebook.ads.a.l var2 = com.facebook.ads.a.l.a(j.this.b, var1.a);
               j.this.h.a(var2);
            }
         }

         // $FF: synthetic method
         protected Object doInBackground(Object[] var1) {
            return this.a((Void[])var1);
         }

         // $FF: synthetic method
         protected void onPostExecute(Object var1) {
            this.a((j$a)var1);
         }
      }).execute(new Void[0]);
   }

   public j$a b() {
      // $FF: Couldn't be decompiled
   }
}
