package com.mopub.volley.toolbox;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.http.AndroidHttpClient;
import android.os.Build.VERSION;
import com.mopub.volley.RequestQueue;
import com.mopub.volley.toolbox.BasicNetwork;
import com.mopub.volley.toolbox.DiskBasedCache;
import com.mopub.volley.toolbox.HttpClientStack;
import com.mopub.volley.toolbox.HttpStack;
import com.mopub.volley.toolbox.HurlStack;
import java.io.File;

public class Volley {
   private static final String DEFAULT_CACHE_DIR = "volley";

   public static RequestQueue newRequestQueue(Context var0) {
      return newRequestQueue(var0, (HttpStack)null);
   }

   public static RequestQueue newRequestQueue(Context var0, HttpStack var1) {
      File var3 = new File(var0.getCacheDir(), "volley");
      String var2 = "volley/0";

      label20: {
         String var7;
         try {
            String var4 = var0.getPackageName();
            PackageInfo var6 = var0.getPackageManager().getPackageInfo(var4, 0);
            var7 = var4 + "/" + var6.versionCode;
         } catch (NameNotFoundException var5) {
            break label20;
         }

         var2 = var7;
      }

      Object var8 = var1;
      if(var1 == null) {
         if(VERSION.SDK_INT >= 9) {
            var8 = new HurlStack();
         } else {
            var8 = new HttpClientStack(AndroidHttpClient.newInstance(var2));
         }
      }

      BasicNetwork var9 = new BasicNetwork((HttpStack)var8);
      RequestQueue var10 = new RequestQueue(new DiskBasedCache(var3), var9);
      var10.start();
      return var10;
   }
}
