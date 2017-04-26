package com.facebook.ads.a;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.PowerManager;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import com.facebook.ads.AdSettings;
import com.facebook.ads.a.p$a;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.security.KeyStore;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class p {
   private static final Uri a = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");

   public static p$a a(ContentResolver param0) {
      // $FF: Couldn't be decompiled
   }

   public static Object a(Object var0, Method var1, Object... var2) {
      try {
         var0 = var1.invoke(var0, var2);
         return var0;
      } catch (Exception var3) {
         return null;
      }
   }

   public static Object a(JSONObject var0, String var1) {
      Object var2 = var0.opt(var1);
      Object var3 = var2;
      if(var2 != null) {
         var3 = var2;
         if(var2 instanceof String) {
            var3 = (new JSONTokener((String)var2)).nextValue();
         }
      }

      if(var3 != null && !(var3 instanceof JSONObject) && !(var3 instanceof JSONArray)) {
         throw new IllegalArgumentException(var1);
      } else {
         return var3;
      }
   }

   public static String a(InputStream param0) {
      // $FF: Couldn't be decompiled
   }

   public static String a(Map var0) {
      JSONObject var1 = new JSONObject();
      Iterator var4 = var0.entrySet().iterator();

      while(var4.hasNext()) {
         Entry var2 = (Entry)var4.next();

         try {
            var1.put((String)var2.getKey(), var2.getValue());
         } catch (JSONException var3) {
            var3.printStackTrace();
         }
      }

      return var1.toString();
   }

   public static Method a(Class var0, String var1, Class... var2) {
      try {
         Method var4 = var0.getMethod(var1, var2);
         return var4;
      } catch (NoSuchMethodException var3) {
         return null;
      }
   }

   public static Method a(String var0, String var1, Class... var2) {
      try {
         Method var4 = a(Class.forName(var0), var1, var2);
         return var4;
      } catch (ClassNotFoundException var3) {
         return null;
      }
   }

   public static void a(Context var0, String var1) {
      if(AdSettings.isTestMode(var0)) {
         Log.d("FBAudienceNetworkLog", var1 + " (displayed for test ads only)");
      }

   }

   public static void a(Closeable var0) {
      if(var0 != null) {
         try {
            var0.close();
         } catch (IOException var1) {
            ;
         }
      }
   }

   public static boolean a() {
      String var0 = AdSettings.getUrlPrefix();
      return !com.facebook.ads.a.ag.a(var0) && var0.endsWith(".sb");
   }

   public static boolean a(Context var0, View var1, int var2, int var3, int var4) {
      if(!((PowerManager)var0.getSystemService("power")).isScreenOn()) {
         return false;
      } else if(var1 != null && var1.getParent() != null && var1.getVisibility() == 0) {
         if(VERSION.SDK_INT >= 11 && var1.getAlpha() < 0.9F) {
            return false;
         } else {
            int[] var5 = new int[2];
            var1.getLocationOnScreen(var5);
            DisplayMetrics var6 = var0.getResources().getDisplayMetrics();
            if(var5[0] >= 0 && var6.widthPixels - var5[0] >= var2) {
               var2 = (int)((double)var3 * (100.0D - (double)var4) / 100.0D);
               return var5[1] < 0 && Math.abs(var5[1]) > var2?false:var5[1] + var3 - var6.heightPixels <= var2;
            } else {
               return false;
            }
         }
      } else {
         return false;
      }
   }

   public static HttpClient b() {
      if(a()) {
         try {
            KeyStore var0 = KeyStore.getInstance(KeyStore.getDefaultType());
            var0.load((InputStream)null, (char[])null);
            com.facebook.ads.a.ae var4 = new com.facebook.ads.a.ae(var0);
            var4.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
            BasicHttpParams var1 = new BasicHttpParams();
            HttpProtocolParams.setVersion(var1, HttpVersion.HTTP_1_1);
            HttpProtocolParams.setContentCharset(var1, "UTF-8");
            SchemeRegistry var2 = new SchemeRegistry();
            var2.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
            var2.register(new Scheme("https", var4, 443));
            DefaultHttpClient var5 = new DefaultHttpClient(new ThreadSafeClientConnManager(var1, var2), var1);
            return var5;
         } catch (Exception var3) {
            ;
         }
      }

      return new DefaultHttpClient();
   }
}
