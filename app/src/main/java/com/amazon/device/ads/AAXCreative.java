package com.amazon.device.ads;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

enum AAXCreative {
   CAN_EXPAND1(1003),
   CAN_EXPAND2(1004),
   CAN_PLAY_AUDIO1(1001),
   CAN_PLAY_AUDIO2(1002),
   CAN_PLAY_VIDEO(1014),
   HTML(1007),
   INTERSTITIAL(1008),
   MRAID1(1016),
   MRAID2(1017),
   REQUIRES_TRANSPARENCY(1031),
   VIDEO_INTERSTITIAL(1030);

   private static final HashSet primaryCreativeTypes;
   private final int id;

   static {
      HashSet var0 = new HashSet();
      primaryCreativeTypes = var0;
      var0.add(HTML);
      primaryCreativeTypes.add(MRAID1);
      primaryCreativeTypes.add(MRAID2);
      primaryCreativeTypes.add(INTERSTITIAL);
      primaryCreativeTypes.add(VIDEO_INTERSTITIAL);
   }

   private AAXCreative(int var3) {
      this.id = var3;
   }

   public static boolean containsPrimaryCreativeType(Set var0) {
      Iterator var1 = primaryCreativeTypes.iterator();

      do {
         if(!var1.hasNext()) {
            return false;
         }
      } while(!var0.contains((AAXCreative)var1.next()));

      return true;
   }

   public static AAXCreative getCreativeType(int var0) {
      switch(var0) {
      case 1001:
         return CAN_PLAY_AUDIO1;
      case 1002:
         return CAN_PLAY_AUDIO2;
      case 1003:
         return CAN_EXPAND1;
      case 1004:
         return CAN_EXPAND2;
      case 1007:
         return HTML;
      case 1008:
         return INTERSTITIAL;
      case 1014:
         return CAN_PLAY_VIDEO;
      case 1016:
         return MRAID1;
      case 1017:
         return MRAID2;
      case 1030:
         return VIDEO_INTERSTITIAL;
      case 1031:
         return REQUIRES_TRANSPARENCY;
      default:
         return null;
      }
   }

   static AAXCreative getTopCreative(Set var0) {
      return var0.contains(MRAID2)?MRAID2:(var0.contains(MRAID1)?MRAID1:(var0.contains(HTML)?HTML:null));
   }

   public final int getId() {
      return this.id;
   }
}
