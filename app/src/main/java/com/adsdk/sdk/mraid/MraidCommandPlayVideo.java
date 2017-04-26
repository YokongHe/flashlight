package com.adsdk.sdk.mraid;

import com.adsdk.sdk.mraid.MraidCommand;
import com.adsdk.sdk.mraid.MraidCommandFactory$MraidJavascriptCommand;
import com.adsdk.sdk.mraid.MraidView;
import com.adsdk.sdk.mraid.MraidView$PlacementType;
import java.util.Map;

class MraidCommandPlayVideo extends MraidCommand {
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

   public MraidCommandPlayVideo(Map var1, MraidView var2) {
      super(var1, var2);
   }

   void execute() {
      String var1 = this.getStringFromParamsForKey("uri");
      if(var1 != null && !var1.equals("")) {
         this.mView.getDisplayController().showVideo(var1);
      } else {
         this.mView.fireErrorEvent(MraidCommandFactory$MraidJavascriptCommand.PLAY_VIDEO, "Video can\'t be played with null or empty URL");
      }
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
