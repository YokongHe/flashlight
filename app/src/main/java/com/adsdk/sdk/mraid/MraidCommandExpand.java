package com.adsdk.sdk.mraid;

import com.adsdk.sdk.mraid.MraidCommand;
import com.adsdk.sdk.mraid.MraidView;
import com.adsdk.sdk.mraid.MraidView$PlacementType;
import java.util.Map;

class MraidCommandExpand extends MraidCommand {
   // $FF: synthetic field
   private static int[] $SWITCH_TABLE$com$adsdk$sdk$mraid$MraidView$PlacementType;

   // $FF: synthetic method
   static int[] $SWITCH_TABLE$com$adsdk$sdk$mraid$MraidView$PlacementType() {
      int[] var0 = $SWITCH_TABLE$com$adsdk$sdk$mraid$MraidView$PlacementType;
      if(var0 != null) {
         return var0;
      } else {
         var0 = new int[MraidView$PlacementType.values().length];

         try {
            var0[MraidView$PlacementType.INLINE.ordinal()] = 1;
         } catch (NoSuchFieldError var3) {
            ;
         }

         try {
            var0[MraidView$PlacementType.INTERSTITIAL.ordinal()] = 2;
         } catch (NoSuchFieldError var2) {
            ;
         }

         $SWITCH_TABLE$com$adsdk$sdk$mraid$MraidView$PlacementType = var0;
         return var0;
      }
   }

   MraidCommandExpand(Map var1, MraidView var2) {
      super(var1, var2);
   }

   void execute() {
      int var2 = this.getIntFromParamsForKey("w");
      int var3 = this.getIntFromParamsForKey("h");
      String var6 = this.getStringFromParamsForKey("url");
      boolean var4 = this.getBooleanFromParamsForKey("shouldUseCustomClose");
      boolean var5 = this.getBooleanFromParamsForKey("lockOrientation");
      int var1 = var2;
      if(var2 <= 0) {
         var1 = this.mView.getDisplayController().mScreenWidth;
      }

      var2 = var3;
      if(var3 <= 0) {
         var2 = this.mView.getDisplayController().mScreenHeight;
      }

      this.mView.getDisplayController().expand(var6, var1, var2, var4, var5);
   }

   protected boolean isCommandDependentOnUserClick(MraidView$PlacementType var1) {
      switch($SWITCH_TABLE$com$adsdk$sdk$mraid$MraidView$PlacementType()[var1.ordinal()]) {
      case 1:
         return true;
      case 2:
         return false;
      default:
         return super.isCommandDependentOnUserClick(var1);
      }
   }
}
