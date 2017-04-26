package com.facebook.ads.a;

import org.json.JSONArray;

enum m {
   a,
   b,
   c,
   d,
   e,
   f,
   g,
   h,
   i,
   j,
   k,
   l;

   private static final com.facebook.ads.a.m[] n;
   private static final String o;
   private final int m;

   static {
      int var0 = 0;
      a = new com.facebook.ads.a.m("APP_AD", 0, 0);
      b = new com.facebook.ads.a.m("LINK_AD", 1, 1);
      c = new com.facebook.ads.a.m("APP_AD_V2", 2, 2);
      d = new com.facebook.ads.a.m("LINK_AD_V2", 3, 3);
      e = new com.facebook.ads.a.m("APP_ENGAGEMENT_AD", 4, 4);
      f = new com.facebook.ads.a.m("AD_CHOICES", 5, 5);
      g = new com.facebook.ads.a.m("JS_TRIGGER", 6, 6);
      h = new com.facebook.ads.a.m("JS_TRIGGER_NO_AUTO_IMP_LOGGING", 7, 7);
      i = new com.facebook.ads.a.m("VIDEO_AD", 8, 8);
      j = new com.facebook.ads.a.m("INLINE_VIDEO_AD", 9, 9);
      k = new com.facebook.ads.a.m("BANNER_TO_INTERSTITIAL", 10, 10);
      l = new com.facebook.ads.a.m("NATIVE_CLOSE_BUTTON", 11, 11);
      n = new com.facebook.ads.a.m[]{d, e, f, h, l};
      JSONArray var2 = new JSONArray();
      com.facebook.ads.a.m[] var3 = n;

      for(int var1 = var3.length; var0 < var1; ++var0) {
         var2.put(var3[var0].a());
      }

      o = var2.toString();
   }

   private m(int var3) {
      this.m = var3;
   }

   public static String b() {
      return o;
   }

   final int a() {
      return this.m;
   }
}
