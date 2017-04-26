package com.mopub.nativeads;

import com.mopub.common.Preconditions$NoThrow;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MoPubNativeAdPositioning$MoPubClientPositioning {
   public static final int NO_REPEAT = Integer.MAX_VALUE;
   private final ArrayList mFixedPositions = new ArrayList();
   private int mRepeatInterval = Integer.MAX_VALUE;

   // $FF: synthetic method
   static ArrayList access$0(MoPubNativeAdPositioning$MoPubClientPositioning var0) {
      return var0.mFixedPositions;
   }

   // $FF: synthetic method
   static int access$1(MoPubNativeAdPositioning$MoPubClientPositioning var0) {
      return var0.mRepeatInterval;
   }

   // $FF: synthetic method
   static void access$2(MoPubNativeAdPositioning$MoPubClientPositioning var0, int var1) {
      var0.mRepeatInterval = var1;
   }

   public MoPubNativeAdPositioning$MoPubClientPositioning addFixedPosition(int var1) {
      boolean var3;
      if(var1 >= 0) {
         var3 = true;
      } else {
         var3 = false;
      }

      if(Preconditions$NoThrow.checkArgument(var3)) {
         int var2 = Collections.binarySearch(this.mFixedPositions, Integer.valueOf(var1));
         if(var2 < 0) {
            this.mFixedPositions.add(~var2, Integer.valueOf(var1));
            return this;
         }
      }

      return this;
   }

   public MoPubNativeAdPositioning$MoPubClientPositioning enableRepeatingPositions(int var1) {
      boolean var2 = true;
      if(var1 <= 1) {
         var2 = false;
      }

      if(!Preconditions$NoThrow.checkArgument(var2, "Repeating interval must be greater than 1")) {
         this.mRepeatInterval = Integer.MAX_VALUE;
         return this;
      } else {
         this.mRepeatInterval = var1;
         return this;
      }
   }

   List getFixedPositions() {
      return this.mFixedPositions;
   }

   int getRepeatingInterval() {
      return this.mRepeatInterval;
   }
}
