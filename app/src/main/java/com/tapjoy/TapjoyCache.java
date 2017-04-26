package com.tapjoy;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import android.text.TextUtils;
import com.tapjoy.TJCacheListener;
import com.tapjoy.TapjoyCache$CacheAssetThread;
import com.tapjoy.TapjoyCacheMap;
import com.tapjoy.TapjoyCachedAssetData;
import com.tapjoy.TapjoyLog;
import com.tapjoy.TapjoyUtil;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TapjoyCache {
   public static final String CACHE_DIRECTORY_NAME = "Tapjoy/Cache/";
   public static final int CACHE_LIMIT = -1;
   private static TapjoyCache a = null;
   public static boolean unit_test_mode = false;
   private Context b;
   private TapjoyCacheMap c;
   private Vector d;
   private ExecutorService e;
   private File f;
   private boolean g;

   public TapjoyCache(Context var1) {
      if(a == null || unit_test_mode) {
         a = this;
         this.b = var1;
         this.c = new TapjoyCacheMap(var1, -1);
         this.d = new Vector();
         this.e = Executors.newFixedThreadPool(5);
         if(Environment.getExternalStorageDirectory() != null) {
            TapjoyUtil.deleteFileOrDirectory(new File(Environment.getExternalStorageDirectory(), "tapjoy"));
            TapjoyUtil.deleteFileOrDirectory(new File(Environment.getExternalStorageDirectory(), "tjcache/tmp/"));
         }

         this.f = new File(this.b.getFilesDir() + "/Tapjoy/Cache/");
         if(!this.f.exists() && !this.f.mkdirs()) {
            TapjoyLog.e("TapjoyCache", "Error initalizing cache");
            a = null;
         }

         this.a();
      }

   }

   // $FF: synthetic method
   static String a(String var0) {
      return b(var0);
   }

   private void a() {
      SharedPreferences var2 = this.b.getSharedPreferences("tapjoyCacheData", 0);
      Editor var1 = var2.edit();
      Iterator var6 = var2.getAll().entrySet().iterator();

      while(true) {
         while(true) {
            while(true) {
               while(var6.hasNext()) {
                  Entry var3 = (Entry)var6.next();
                  File var4 = new File((String)var3.getKey());
                  if(var4.exists() && var4.isFile()) {
                     TapjoyCachedAssetData var7 = TapjoyCachedAssetData.fromRawJSONString(var3.getValue().toString());
                     if(var7 != null) {
                        String var5 = b(var7.getAssetURL());
                        if(var5 != null && !"".equals(var5) && var5.length() > 0) {
                           if(var7.getTimeOfDeathInSeconds() < System.currentTimeMillis() / 1000L) {
                              if(this.g) {
                                 TapjoyLog.i("TapjoyCache", "Asset expired, removing from cache");
                              }

                              if(var7.getLocalFilePath() != null && var7.getLocalFilePath().length() > 0) {
                                 TapjoyUtil.deleteFileOrDirectory(new File(var7.getLocalFilePath()));
                              }
                           } else {
                              this.c.put(var5, var7);
                           }
                        } else {
                           var1.remove((String)var3.getKey()).commit();
                        }
                     } else {
                        var1.remove((String)var3.getKey()).commit();
                     }
                  } else {
                     var1.remove((String)var3.getKey()).commit();
                  }
               }

               return;
            }
         }
      }
   }

   // $FF: synthetic method
   static boolean a(TapjoyCache var0) {
      return var0.g;
   }

   private static String b(String var0) {
      String var1 = var0;
      if(var0.startsWith("//")) {
         var1 = "http:" + var0;
      }

      try {
         var0 = (new URL(var1)).getFile();
         return var0;
      } catch (MalformedURLException var2) {
         return "";
      }
   }

   // $FF: synthetic method
   static Vector b(TapjoyCache var0) {
      return var0.d;
   }

   // $FF: synthetic method
   static TapjoyCacheMap c(TapjoyCache var0) {
      return var0.c;
   }

   // $FF: synthetic method
   static File d(TapjoyCache var0) {
      return var0.f;
   }

   public static TapjoyCache getInstance() {
      return a;
   }

   public static void setInstance(TapjoyCache var0) {
      a = var0;
   }

   public Future cacheAssetFromJSONObject(JSONObject var1) {
      try {
         Future var3 = this.cacheAssetFromURL(var1.getString("url"), var1.optString("offerId"), Long.valueOf(var1.optLong("timeToLive")).longValue());
         return var3;
      } catch (JSONException var2) {
         return null;
      }
   }

   public Future cacheAssetFromURL(String var1, String var2, long var3) {
      URL var5;
      try {
         var5 = new URL(var1);
      } catch (MalformedURLException var6) {
         return null;
      }

      var1 = b(var1);
      return this.d.contains(var1)?null:this.startCachingThread(var5, var2, var3);
   }

   public void cacheAssetGroup(final JSONArray var1, final TJCacheListener var2) {
      if(var1 != null && var1.length() > 0) {
         (new Thread() {
            public final void run() {
               // $FF: Couldn't be decompiled
            }
         }).start();
      } else if(var2 != null) {
         var2.onCachingComplete(1);
         return;
      }

   }

   public String cachedAssetsToJSON() {
      Iterator var1 = this.c.entrySet().iterator();
      JSONObject var2 = new JSONObject();

      while(var1.hasNext()) {
         Entry var3 = (Entry)var1.next();

         try {
            var2.put(((String)var3.getKey()).toString(), ((TapjoyCachedAssetData)var3.getValue()).toRawJSONString());
         } catch (JSONException var4) {
            var4.printStackTrace();
         }
      }

      return var2.toString();
   }

   public void clearTapjoyCache() {
      TapjoyUtil.deleteFileOrDirectory(this.f);
      this.f.mkdirs();
      this.c = new TapjoyCacheMap(this.b, -1);
   }

   public TapjoyCacheMap getCachedData() {
      return this.c;
   }

   public TapjoyCachedAssetData getCachedDataForURL(String var1) {
      var1 = b(var1);
      return var1 != ""?(TapjoyCachedAssetData)this.c.get(var1):null;
   }

   public String getCachedOfferIDs() {
      String var1 = "";
      ArrayList var2 = new ArrayList();
      if(this.c != null) {
         Iterator var4 = this.c.entrySet().iterator();

         while(var4.hasNext()) {
            String var3 = ((TapjoyCachedAssetData)((Entry)var4.next()).getValue()).getOfferId();
            if(var3 != null && var3.length() != 0 && !var2.contains(var3)) {
               var2.add(var3);
            }
         }

         var1 = TextUtils.join(",", var2);
      }

      return var1;
   }

   public String getPathOfCachedURL(String var1) {
      String var3 = b(var1);
      String var2 = var1;
      if(var3 != "") {
         var2 = var1;
         if(this.c.containsKey(var3)) {
            TapjoyCachedAssetData var4 = (TapjoyCachedAssetData)this.c.get(var3);
            if(!(new File(var4.getLocalFilePath())).exists()) {
               getInstance().removeAssetFromCache(var1);
               return var1;
            }

            var2 = var4.getLocalURL();
         }
      }

      return var2;
   }

   public boolean isURLCached(String var1) {
      return this.c.get(var1) != null;
   }

   public boolean isURLDownloading(String var1) {
      boolean var3 = false;
      boolean var2 = var3;
      if(this.d != null) {
         var1 = b(var1);
         var2 = var3;
         if(var1 != "") {
            var2 = var3;
            if(this.d.contains(var1)) {
               var2 = true;
            }
         }
      }

      return var2;
   }

   public void printCacheInformation() {
      TapjoyLog.i("TapjoyCache", "------------- Cache Data -------------");
      TapjoyLog.i("TapjoyCache", "Number of files in cache: " + this.c.size());
      TapjoyLog.i("TapjoyCache", "Cache Size: " + TapjoyUtil.fileOrDirectorySize(this.f));
      TapjoyLog.i("TapjoyCache", "--------------------------------------");
   }

   public boolean removeAssetFromCache(String var1) {
      var1 = b(var1);
      return var1 != "" && this.c.remove(var1) != null;
   }

   public Future startCachingThread(URL var1, String var2, long var3) {
      return var1 != null?this.e.submit(new TapjoyCache$CacheAssetThread(this, var1, var2, var3)):null;
   }
}
