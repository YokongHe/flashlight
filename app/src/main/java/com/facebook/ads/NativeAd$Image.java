package com.facebook.ads;

import org.json.JSONObject;

public class NativeAd$Image {
   private final int height;
   private final String url;
   private final int width;

   private NativeAd$Image(String var1, int var2, int var3) {
      this.url = var1;
      this.width = var2;
      this.height = var3;
   }

   public static NativeAd$Image fromJSONObject(JSONObject var0) {
      if(var0 != null) {
         String var1 = var0.optString("url");
         if(var1 != null) {
            return new NativeAd$Image(var1, var0.optInt("width", 0), var0.optInt("height", 0));
         }
      }

      return null;
   }

   public int getHeight() {
      return this.height;
   }

   public String getUrl() {
      return this.url;
   }

   public int getWidth() {
      return this.width;
   }
}
