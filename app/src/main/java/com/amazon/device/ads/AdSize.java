package com.amazon.device.ads;

import com.amazon.device.ads.AdSize$SizeType;
import com.amazon.device.ads.Log;
import com.amazon.device.ads.NumberUtils;
import java.util.Locale;

public class AdSize {
   private static final String LOG_TAG = "AdSize";
   public static final AdSize SIZE_1024x50 = new AdSize(1024, 50);
   public static final AdSize SIZE_300x250 = new AdSize(300, 250);
   public static final AdSize SIZE_300x50 = new AdSize(300, 50);
   public static final AdSize SIZE_320x50 = new AdSize(320, 50);
   public static final AdSize SIZE_600x90 = new AdSize(600, 90);
   public static final AdSize SIZE_728x90 = new AdSize(728, 90);
   public static final AdSize SIZE_AUTO;
   static final AdSize SIZE_INTERSTITIAL;
   private int height;
   private AdSize$SizeType type;
   private int width;

   static {
      SIZE_AUTO = new AdSize(AdSize$SizeType.AUTO);
      SIZE_INTERSTITIAL = new AdSize(AdSize$SizeType.INTERSTITIAL);
   }

   public AdSize(int var1, int var2) {
      this.initialize(var1, var2);
   }

   AdSize(AdSize$SizeType var1) {
      this.type = var1;
   }

   AdSize(String var1, String var2) {
      this.initialize(NumberUtils.parseInt(var1, 0), NumberUtils.parseInt(var2, 0));
   }

   protected static String getAsSizeString(int var0, int var1) {
      return Integer.toString(var0) + "x" + Integer.toString(var1);
   }

   private void initialize(int var1, int var2) {
      if(var1 > 0 && var2 > 0) {
         this.width = var1;
         this.height = var2;
         this.type = AdSize$SizeType.EXPLICIT;
      } else {
         Log.e("AdSize", "The width and height must be positive integers.");
         throw new IllegalArgumentException("The width and height must be positive integers.");
      }
   }

   public boolean equals(Object var1) {
      return var1 instanceof AdSize?this.toString().equals(var1.toString()):false;
   }

   public int getHeight() {
      return this.height;
   }

   public int getWidth() {
      return this.width;
   }

   public boolean isAuto() {
      return this.type == AdSize$SizeType.AUTO;
   }

   public String toString() {
      switch(null.$SwitchMap$com$amazon$device$ads$AdSize$SizeType[this.type.ordinal()]) {
      case 1:
         return String.format(Locale.US, "%dx%d", new Object[]{Integer.valueOf(this.width), Integer.valueOf(this.height)});
      case 2:
         return "auto";
      case 3:
         return "interstitial";
      default:
         return null;
      }
   }
}
