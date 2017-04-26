package com.inneractive.api.ads.sdk;

final class aq {
   private static final String[] c = new String[]{"finalReturn", "impression", "start", "firstQuartile", "midpoint", "thirdQuartile", "complete", "mute", "unmute", "pause", "resume", "fullscreen", "exitFullscreen", "creativeView", "click", "error", "rewind", "close"};
   private int a;
   private String b;

   aq(String var1, String var2) {
      this.a = a(var1);
      this.b = var2;
   }

   private static int a(String var0) {
      int var1 = 0;

      while(true) {
         String[] var2 = c;
         if(var1 >= 18) {
            return -1;
         }

         if(c[var1].equals(var0)) {
            return var1;
         }

         ++var1;
      }
   }

   static String a(int var0) {
      if(var0 >= 0) {
         String[] var1 = c;
         if(var0 < 18) {
            return c[var0];
         }
      }

      return "Invalid index " + var0;
   }

   final int a() {
      return this.a;
   }

   final String b() {
      return this.b;
   }
}
