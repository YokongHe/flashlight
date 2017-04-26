package com.inmobi.commons.cache;

import org.json.JSONException;
import org.json.JSONObject;

public final class LocalCache {
   public static final String FILENAME = "inmobi.cache";
   private static String a = "{url:\'https://inmobisdk-a.akamaihd.net/sdk/configs/400/rootConfig.json\'}";
   private static JSONObject b = new JSONObject();

   public static JSONObject addToCache(String var0, JSONObject var1) {
      JSONObject var2 = b;
      synchronized(var2) {
         if(b.toString().equals("{}")) {
            initRoot();
         }

         b.put(var0, var1);
      }

      b();
      return null;
   }

   private static void b() {
      (new Thread(new Runnable() {
         public final void run() {
            LocalCache.c();
         }
      })).start();
   }

   private static void c() {
      // $FF: Couldn't be decompiled
   }

   public static JSONObject getCacheForProduct(String var0) {
      if(b.toString().equals("{}")) {
         initRoot();
      }

      try {
         JSONObject var2 = b.getJSONObject(var0);
         return var2;
      } catch (JSONException var1) {
         return null;
      }
   }

   public static JSONObject getRoot() {
      return b;
   }

   public static void initRoot() {
      // $FF: Couldn't be decompiled
   }

   public static void reset() {
      b = new JSONObject();
      c();
      initRoot();
   }

   public static void saveRoot(JSONObject var0) {
      b = var0;
      b();
   }
}
