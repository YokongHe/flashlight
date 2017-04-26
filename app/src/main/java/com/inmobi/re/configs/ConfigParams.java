package com.inmobi.re.configs;

import android.graphics.Color;
import com.inmobi.commons.internal.Log;
import java.util.HashMap;
import java.util.Map;

public class ConfigParams {
   static int g = 5;
   static String h = "[\"video/mp4\"]";
   String a = "#00000000";
   int b = 320;
   int c = 480;
   int d = 100;
   int e = 20;
   int f = 5;
   HashMap i = new HashMap();

   public String getAllowedContentType() {
      return h;
   }

   public int getMaxSaveContentSize() {
      return g;
   }

   public int getMaxVibDuration() {
      return this.f * 1000;
   }

   public int getMaxVibPatternLength() {
      return this.e;
   }

   public int getPicHeight() {
      return this.c;
   }

   public int getPicQuality() {
      return this.d;
   }

   public int getPicWidth() {
      return this.b;
   }

   public int getWebviewBgColor() {
      try {
         int var1 = Color.parseColor(this.a);
         return var1;
      } catch (Exception var3) {
         Log.internal("[InMobi]-[RE]-4.5.2", "Invalid bg color. Reverting to default", var3);
         return Color.parseColor("#00000000");
      }
   }

   public void setFromMap(Map param1) {
      // $FF: Couldn't be decompiled
   }
}
